/*
 * TODO: Change me
 */
package controllers;

import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import utilities.SQLQuery;

/**
 *
 * @author Andrew
 * Class controlling access to databases using SQL queries.
 * Singleton pattern is used as it allows for the database credentials to be altered
 * remotely and programmatically.
 */
public class DatabaseController {    
    //<editor-fold desc="Constructors and class variables">    
    String targetDB;//The database it shall use to connect to
    String username;//The username needed to connect to the target database
    String password;//The password needed to connect to the target database

    private static DatabaseController instance = new DatabaseController();
    //The default Database credentials
    DatabaseController(){
       this.targetDB = "jdbc:sqlserver://proc308.database.windows.net:1433;database=MSApp;encrypt=true;trustServerCertificate=false;hostNameInCertificate=*.database.windows.net;loginTimeout=30;";
       this.username = "AppUser";
       this.password = "Multiplesclerosi5";

    }
    
    public static DatabaseController getInstance(){
        return instance;
    }
    
//    //Should we have more than one database to manipulate.
//    public DatabaseController(String targetDB, String username, String password){
//       this.targetDB = targetDB;
//       this.username = username;
//       this.password = password;
//    }
    //</editor-fold>
    
    //Formats and submits the query to the given database.
    public SQLQuery submitQuery(SQLQuery query, int columns){        
        try {
            
            //Using the Oracle DB connection Driver
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            //Open a connection to the target Database
            Connection connection = DriverManager.getConnection(targetDB, username, password); 
            System.out.println("DB Connection established");

            //Build then Execute Query         
            //This may look a bit weird. Unfortunately it's the result of the nuances of the 
            //classes used, (PreparedStatement instead of Statement), however the benefit of 
            //doing so is protection from SQL injections.
            PreparedStatement statement = connection.prepareStatement(query.getParameterlessQuery());  
            
            System.out.println("Inserting parameters");
            if(query.getQueryParams() != null){
                if(query.getQueryParams().length > 0){
                    String[] params = query.getQueryParams();

                    for(int i=0; i< params.length; i++){
                        statement.setString((i+1), params[i]);                   
                    }
                }
            }
            System.out.println("Parameterisation successful.");
            //query.setDebug(statement.toString());
 

            System.out.println(statement.toString());
            query.setResponse(statement.executeQuery());
            
            //If there is a result set expected, then save the results before they are lost on connection close
            if(columns > 0){
                while(query.getResponse().next()){                
                    Object[] temp = new Object[columns];
                    for (int i = 0; i < columns; i++){
                        temp[i] = query.getResponse().getObject(i+1);
                    }

                    query.getResults().add(temp);
                }   
            }
            

            //Close Connection
            connection.close();
       } catch (ClassNotFoundException ex) {
            Logger.getLogger(DatabaseController.class.getName()).log(Level.SEVERE, null, ex);
            query.setDebug("driver missing");
       } catch (SQLException ex) {
            for (Throwable e : ex) {
                if (e instanceof SQLException) {                   
                    query.queryFail(((SQLException)e).getSQLState(), ((SQLException)e).getMessage());
                    
                    System.out.println(query.getErrorCode() + "\n"+ query.getErrorMessage());
                }
            }
       }
        return query;
    }

    public String getTargetDB() {
        return targetDB;
    }

    public void setTargetDB(String targetDB) {
        this.targetDB = targetDB;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    
    
    
}
