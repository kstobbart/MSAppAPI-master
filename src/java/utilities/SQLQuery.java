/*
 * TODO: Change me
 */
package utilities;

import controllers.DatabaseController;
import java.sql.ResultSet;
import java.util.ArrayList;

/**
 *
 * Helper class for interaction with databases. 
 */
public class SQLQuery {
    public String parameterlessQuery;
    public String[] queryParams;
    
    public ResultSet response;
    public Object[] rowResult;
    public ArrayList<Object[]> results = new ArrayList<Object[]>();
    
    //Variables related to execution failure
    public Boolean succesful = null;
    public String errorCode = "00000";
    public String errorMessage = "hi";//For use by internal development purposes
    
    public String debug;

    
    public SQLQuery(){
        this.parameterlessQuery = null;
    }
    
    /**
     * 
     * @param query
     * @param queryParams 
     */
    public SQLQuery(String query, String[] queryParams){
        this.parameterlessQuery = query;
        this.queryParams = queryParams;
    }
    
    /**
     * 
     * @param errorCode
     * @param errorMessage 
     */
    public void queryFail(String errorCode, String errorMessage){
        this.succesful = false;
        this.errorCode = errorCode;
        //this.errorMessage = generateErrorMessage();
    }
    
    public String getDebug(){
        return debug;
    }
    
    public void setDebug(String s){
        this.debug = s;
    }
    
    //<editor-fold desc="Getters and Setters">
    public String getParameterlessQuery() {
        return parameterlessQuery;
    }

    public void setParameterlessQuery(String query) {
        this.parameterlessQuery = query;
    }    

    public String[] getQueryParams() {
        return queryParams;
    }

    public void setQueryParams(String[] queryParams) {
        this.queryParams = queryParams;
    }
    
    public ResultSet getResponse() {
        return response;
    }

    public void setResponse(ResultSet response) {
        this.response = response;
    }

    public Object[] getRowResult() {
        return rowResult;
    }

    public void setRowResult(Object[] rowResult) {
        this.rowResult = rowResult;
    }

    public ArrayList<Object[]> getResults() {
        return results;
    }

    public void setResults(ArrayList<Object[]> results) {
        this.results = results;
    }

    
    
    public Boolean getSuccesful() {
        return succesful;
    }

    public void setSuccesful(Boolean succesful) {
        this.succesful = succesful;
    }   
    
    public String getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(String errorCode) {
        this.errorCode = errorCode;
    }

    public String getErrorMessage() {
        return errorCode;
    }

    public void setErrorMessage(String errorMessage) {
        this.errorCode = errorMessage;
    }
    //</editor-fold>

    /**
     * 
     * @return 
     */
    private String generateErrorMessage() {
        String message;
        switch(this.errorCode){
            case("23000"):
                message = "Duplicate Data.";
                break;
            default:
                message = "Unrecognised Error has occurred.";
                break;
        }
        
        return message;
    }
    
    /** 
     * May seem redundant, however this is necessary in order to get back the query 
     * which was passed in so properties of the query can be examined.
     * Initialises a database controller and passes the query to be executed. 
     * @param query
     * @param resultSetColumns
     * @return 
     */
    public SQLQuery queryDatabase(SQLQuery query, int resultSetColumns){
        DatabaseController databaseController = DatabaseController.getInstance();
        return databaseController.submitQuery(query, resultSetColumns);
    }
    
}
