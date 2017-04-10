/*
 * TODO: Change me
 */
package services;

import controllers.AuthenticationController;
import java.io.InputStream;
import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;
import javax.json.Json;
import javax.json.JsonObject;
import javax.json.JsonReader;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.NewCookie;
import javax.ws.rs.core.Response;

/**
 *
 * @author Andrew
 */
@Path("/Authenticate")
public class AuthenticationService {
    AuthenticationController authController = AuthenticationController.getInstance();
    
    /**
     * Method to authenticate a user given an email and password.
     * Expected JSON:
     * {
     *      "Email":"email",
     *      "Password":"password"
     * }
     * 
     * POST, /Authenticate
     * @param data
     * @return 
     */
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public Response authenticateUser(InputStream data){
        JsonReader reader = Json.createReader(data);
        JsonObject userData = reader.readObject();
        reader.close();
        
        String email = "";
        String password = "";
        
        try{
            email = userData.getString("Email");
            password = userData.getString("Password");
            
            Object[] results = authController.authenticateUser(email, password);
            Boolean success = (Boolean) results[0];
            
            if (success){
                //Add JWT as cookie.
                int ID = (int) results[1];
                String authToken = authController.generateJWT(ID);
                NewCookie cookie = new NewCookie("AuthToken", authToken);
                
                return Response.status(200).entity("Authentication successful.").cookie(cookie).build();
            }
            else{
                return Response.status(400).entity("Authentication failure, incorrect email + password combination").build();
            }
        }
        catch(Exception ex){
            return Response.status(400).entity("Fatal error has occurred. Please ensure you have provided the specified data in the correct format. Consult the API documentation if necessary.").build();
        }
        
        
    }

    
    /**
     * Method to logout the user, which does so by generating a bad cookie which overwrites their current.
     * As such, since they no longer have a valid auth token, they cannot submit authentication
     * sensitive requests.
     * 
     * POST, /Authenticate/Logout
     * 
     *
     * @return 
     * @throws java.security.spec.InvalidKeySpecException 
     * @throws java.security.NoSuchAlgorithmException 
     */
    @Path("/Logout")
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public Response logoutUser() throws InvalidKeySpecException, NoSuchAlgorithmException{
        NewCookie authToken = new NewCookie("AuthToken", authController.generateStaleJWT(0));
        
        return Response.status(200).cookie(authToken).entity("Logged out successfully.").build();
    }
    
     
}
