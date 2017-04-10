/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import entities.Password;
import entities.User;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.Jws;
import io.jsonwebtoken.JwtBuilder;
import io.jsonwebtoken.Jwts;
import java.security.Key;
import java.util.Date;
import javax.crypto.spec.SecretKeySpec;
import javax.xml.bind.DatatypeConverter;
import io.jsonwebtoken.SignatureAlgorithm;
import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;
import java.sql.ResultSet;
import java.util.logging.Level;
import java.util.logging.Logger;
import utilities.SQLQuery;

/**
 *
 * @author adickinson
 */
public class AuthenticationController {
    private static AuthenticationController instance = new AuthenticationController();
    private String keySeed = "PRCO308";
    
    private AuthenticationController(){
        
    }
    
    public static AuthenticationController getInstance(){
        return instance;
    }
    
    /** 
     * User submits request with email + pass
     * 
     * Server validates, if valid grants an access token which user can store in cookies
     * 
     * Whenever a user tries to submit an authentication sensitive request, they also submit 
     * the token.
     * Server then validates the token, and if token is good the user gets to proceed.
     * 
     * Token is time sensitive, with a new one being issued whenever they successfully perform an action.
     * 
     * The danger is that this potentially allows malicious agents to spoof the token to gain access.
     * As such the IP of the user, accessed by the request header X-FORWARDED-FOR could be compared to 
     * the the IP address supplied by the client, with the request only being accepted should the 
     * IPs match, however this is potentially tricky and should not be attempted until the end.
     * 
     * @param email
     * @param inputPassword
     * @return 
     */
    
    //Method to validate email + pass
    public Object[] authenticateUser(String email, String inputPassword){
        User user = new User();
        Password passwordToVerify = new Password();
        //Query DB for User's email
        SQLQuery emailRetrievalQuery = new SQLQuery();
        emailRetrievalQuery.setParameterlessQuery("Select Participant_ID, Password, Salt From dbo.Participant Where UPPER(Email) = UPPER(?)");
        String[] params = {email};
        emailRetrievalQuery.setQueryParams(params);

        
        if((email!=null)&&(email.length()>0)){
            emailRetrievalQuery = emailRetrievalQuery.queryDatabase(emailRetrievalQuery, 3);
        }
        else{
            //TODO:Look up MS SQL error codes#
            //return false;
        }
        
        //If Email is found, return hashed password and salt
        //Retrieve variables from results list
        if(!emailRetrievalQuery.getResults().isEmpty()){

            Object[] userToVerify = emailRetrievalQuery.getResults().get(0);                

            user.setID(Integer.parseInt(userToVerify[0].toString()));
            String storedPassword = userToVerify[1].toString();
            String saltString = userToVerify[2].toString();

            passwordToVerify.setSalt(passwordToVerify.saltToBytes(saltString));
            //Use the salt and provided password to create hashed password
            passwordToVerify.setPlainPassword(inputPassword);
            passwordToVerify.hashSelf();
            
            Object[] results = {passwordToVerify.passwordMatch(storedPassword),user.getID()};

                
            return results;
        }else{
            //If the results are empty then there is no user in DB with matching email
            //-> bad input.
            System.out.println("Email not found.");
            Object[] results = {};
            return results;
        }        
    }
    
    //Method to generate auth token
    public String generateJWT(int userID) throws InvalidKeySpecException, NoSuchAlgorithmException{
        EncryptionController key = new EncryptionController(keySeed);        
        SignatureAlgorithm signatureAlgorithm = SignatureAlgorithm.HS256;
        
        long nowMillis = System.currentTimeMillis();
        Date now = new Date(nowMillis);

        //We will sign our JWT with our ApiKey secret
        byte[] apiKeySecretBytes = DatatypeConverter.parseBase64Binary(key.getSecretKey());
        Key signingKey = new SecretKeySpec(apiKeySecretBytes, signatureAlgorithm.getJcaName());

        //Let's set the JWT Claims
        JwtBuilder builder = Jwts.builder().setId(Integer.toString(userID));
        builder.setIssuedAt(now);
        builder.setSubject("users/"+userID);
        builder.setIssuer("MSAppAPI");
        builder.signWith(signatureAlgorithm, signingKey);

        
        //To generate the expiry time we add 20 minutes in unix time to now
        long expMillis = nowMillis + 1200000;
        Date exp = new Date(expMillis);
        builder.setExpiration(exp);

        //Builds the JWT and serializes it to a compact, URL-safe string
        String jwt = builder.compact();        
        return jwt;
    }
    
    //Method to generate a stale auth token (for the purpose of logging out)
    public String generateStaleJWT(int ID) throws InvalidKeySpecException, NoSuchAlgorithmException{
        EncryptionController key = new EncryptionController(keySeed);        
        SignatureAlgorithm signatureAlgorithm = SignatureAlgorithm.HS256;
        
        long nowMillis = System.currentTimeMillis();
        Date now = new Date(nowMillis);

        //We will sign our JWT with our ApiKey secret
        byte[] apiKeySecretBytes = DatatypeConverter.parseBase64Binary(key.getSecretKey());
        Key signingKey = new SecretKeySpec(apiKeySecretBytes, signatureAlgorithm.getJcaName());

        //Let's set the JWT Claims
        JwtBuilder builder = Jwts.builder().setId(Integer.toString(ID));
        builder.setIssuedAt(now);
        builder.setSubject("");
        builder.setIssuer("");
        builder.signWith(signatureAlgorithm, signingKey);

        
        //To generate the expiry time we add one millisecond in unix time to now
        long expMillis = nowMillis+1;
        Date exp = new Date(expMillis);
        builder.setExpiration(exp);

        //Builds the JWT and serializes it to a compact, URL-safe string
        String jwt = builder.compact();        
        return jwt;
    }
    
    //Method to parse a User's ID from the JWT
    public int parseUserID(String jwt) throws InvalidKeySpecException, NoSuchAlgorithmException{
        int ID = 0;
        
        try{
            EncryptionController key = new EncryptionController(keySeed);
            SignatureAlgorithm signatureAlgorithm = SignatureAlgorithm.HS256;

            byte[] apiKeySecretBytes = DatatypeConverter.parseBase64Binary(key.getSecretKey());
            Key signingKey = new SecretKeySpec(apiKeySecretBytes, signatureAlgorithm.getJcaName());

            Jws<Claims> claims = Jwts.parser().setSigningKey(signingKey).parseClaimsJws(jwt);
            ID = Integer.parseInt(claims.getBody().getId());
            
            System.out.println(ID);
        }catch(ExpiredJwtException ex){
            System.out.println("Token has expired.");
        }
        catch(Exception ex){
            System.out.println("Token parsing failed.");
        }
        
        return ID;        
    }
    
    /**
     * Method to check if a token is not expired.
     * Unfortunately this method cannot know for sure whether the issue was due to token expiry,
     * so if it returns false there is the possibility that something else went wrong.
     * @param jwt
     * @return 
     */
    public Boolean freshJWT(String jwt){
        try{
            EncryptionController key = new EncryptionController(keySeed);
            SignatureAlgorithm signatureAlgorithm = SignatureAlgorithm.HS256;

            byte[] apiKeySecretBytes = DatatypeConverter.parseBase64Binary(key.getSecretKey());
            Key signingKey = new SecretKeySpec(apiKeySecretBytes, signatureAlgorithm.getJcaName());

            Jws<Claims> claims = Jwts.parser().setSigningKey(signingKey).parseClaimsJws(jwt);

            return true;
        }catch(ExpiredJwtException ex){
            System.out.println("Token has expired.");
            return false;
        } catch (Exception ex) {
            System.out.println("Token parsing failed.");
            return false;
        }
        
    }
    
    //What do we want this for and how do we do it?
    public Boolean validateIdentity(String jwt){
        return false;
    }
}
