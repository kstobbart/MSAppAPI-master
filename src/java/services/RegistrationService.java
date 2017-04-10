/*
 * TODO: Change me
 */
package services;

import entities.Password;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.security.NoSuchAlgorithmException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.json.Json;
import javax.json.JsonObject;
import javax.json.JsonReader;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import utilities.SQLQuery;
import controllers.DatabaseController;
import javax.ws.rs.GET;
import javax.ws.rs.QueryParam;

/**
 *
 * @author Andrew
 * Note: Currently a mess, imported code from a prior project.
 * 
 */
@Path("/Register")
public class RegistrationService {
    
    
    //Register user service
    /**
     * The default method for the /Register context of web services, meaning it is accessed
     * by a URI of form host/API/Register. 
     * Unlike most of the other methods, this is a post method and requires a sample of JSON 
     * data providing an email and password from the user in a form similar to:
     * {
     *      "Email":"[emailValue]",
     *      "Password":"[passwordValue]"
     * }
     * If the JSON is malformed and/or does not contain valid key pairs, this service will
     * throw a 500 Server Error message.
     * 
     * Everything else is then auto generated as necessary, and used to insert the user in to 
     * the database.
     * 
     * @param data
     * @return 
     */
    @POST
    @Path("/")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response registerUser(InputStream data){
        StringBuilder builder = new StringBuilder();
        
        //Variables for the building of the user to be inserted
        String email = "";
        String ptPassword = "";
        JsonObject user = null;
        Password password = new Password();
        byte[] salt = null;
        
        try{
            //Read in the submitted JSON
            BufferedReader in = new BufferedReader(new InputStreamReader(data));
            String line = null;
            while ((line = in.readLine()) != null) {
                builder.append(line);
            }
 
            //Convert the JSON String submitted by client to a JSON Object
            JsonReader jsonReader = Json.createReader(data);
            user = jsonReader.readObject();
            jsonReader.close();

            //Extract relevant values from the JSON Object
            email = user.get("Email").toString();
            ptPassword = user.get("Password").toString();
            
            //Generate new hashed password           
            password = new Password(ptPassword);
            
            System.out.println(salt[0]+ "  "+salt[1]+ "  "+salt[2]);
            
        } catch (IOException ex) {
            Logger.getLogger(RegistrationService.class.getName()).log(Level.SEVERE, null, ex);        
        } catch (Exception ex) {
            Logger.getLogger(RegistrationService.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
        //Attempt to create a query
        //TODO: Redo based on DB schema and language.
        String parameterlessQuery = "Insert into users (ID, EMAIL, PASSWORD, PASSWORD_SALT) VALUES (SEQ_PERSON_ID.nextval,?,?,?)";
        String[] params = {email, password.getHashedPassword(), password.saltToString(salt)};
        System.out.println("New Hashed:             "+"Hashed: "+ password.getHashedPassword() + "    Salt: "+ password.saltToString(salt));
        SQLQuery query = new SQLQuery(parameterlessQuery, params);
        
        //Check to ensure that the data is not null
        if((email!=null&&ptPassword!=null)&&(email.length()>0&&(ptPassword.length()>0))){
            query = registerUser(query);
        }else
        {
            query.setErrorCode("22000");
        }
        
        //If the error code suggests that the user has been created successfully, return a 200 OK message
        //to client
        if (query.getErrorCode().matches("00000")||query.getErrorCode().matches("24000")){
            return Response.status(200).entity("User Created successfully.").build();
        }
        else{//If not, return an error message with the SQLState code thrown
            return Response.status(400).entity("Failed, Error Code: "+query.getErrorCode()).build();
        }
    }
    

    //Method for submitting a query to a database
    /** 
     * May seem redundant, however this is necessary in order to get back the query 
     * which was passed in so properties of the query can be examined.
     * Initialises a database controller and passes the query to be executed. 
     * @param query
     * @return 
     */
    public SQLQuery registerUser(SQLQuery query){        
        DatabaseController databaseController = DatabaseController.getInstance();
        return databaseController.submitQuery(query, 0);        
    }
    
    @GET
    @Path("/test")
    public String passwordAndSaltGen(@QueryParam("Password")String password){
        Password passwordObj = new Password(password);
        
        return "Hashed pWord = "+passwordObj.getHashedPassword()+ "\nSalt = "+passwordObj.saltToString(passwordObj.getSalt());
    }
    
    
}
