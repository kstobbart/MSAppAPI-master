/*
 * TODO: Change me
 */
package controllers;

import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.security.spec.InvalidKeySpecException;
import java.util.Arrays;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.PBEKeySpec;
import javax.xml.bind.DatatypeConverter;

/**
 *
 * @author Andrew
 */
public class EncryptionController {
    String secretKey;
    byte[] salt;
    
    public EncryptionController(){
        this.secretKey = null;
        this.salt = null;
    }
    
    public EncryptionController(String key) throws InvalidKeySpecException, NoSuchAlgorithmException{
        
        byte[] bytes = {-96, -81, 121, -127, -109, 4, -2, 20, 13, -119, -107, -64, -76, 38, 82, -109, -100, 35, -24, -26, -44, 81, 124, 1, -79, -77, 111, 10, -14, -15, 7, 8};
        this.salt = bytes;
        this.secretKey = generateKey(key);
    }
    
    
    //Used to generate a new salt.
    /**
     * Because of the nature of our distributed server instances, a given encryption key must be the
     * same across servers else things will break. This means we need to unfortunately hard code a salt
     * value, which can be obtained through outputting the results of an instance of the below method and 
     * saving the generated salt. 
     * @return
     * @throws NoSuchAlgorithmException 
     */
    public String outputSalt() throws NoSuchAlgorithmException{
        SecureRandom secureRandomGenerator = SecureRandom.getInstance("SHA1PRNG");
        byte[] randomBytes = new byte[32];
        secureRandomGenerator.nextBytes(randomBytes);
       
        return (Arrays.toString(randomBytes));
    }
    
    //Takes in a plaintext string and a salt to generate a key that can be used to 
    //encrypt and sign JWT cookies. 
    /** 
     * Since the algorithms need to be the same across server instances, in order for the 
     * same secret key to be used in session management to decrypt and encrypt JWTs.
     * Salt is used to add an extra layer of complexity and ensure decryption attacks are harder 
     * to pull off. Actually a very similar method to the hashing function for password hashing.
     * @param ptKeySeed
     * @param salt
     * @return 
     */
    public String generateKey(String ptKeySeed){
        SecretKeyFactory keyFactory;
        SecretKey key;
        String encoded = "";
        //Takes in the salt and uses it to create a base64 encoded string for encryption/decryption
        try{
        keyFactory = SecretKeyFactory.getInstance("PBKDF2WithHmacSHA1");
        key = keyFactory.generateSecret(new PBEKeySpec(ptKeySeed.toCharArray(), salt, 2000, 128));
        encoded = DatatypeConverter.printBase64Binary(key.getEncoded());
        } catch (NoSuchAlgorithmException ex) {
            Logger.getLogger(EncryptionController.class.getName()).log(Level.SEVERE, null, ex);
        } catch (InvalidKeySpecException ex) {
            Logger.getLogger(EncryptionController.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
        
        return encoded;
    }

    public String getSecretKey() {
        return secretKey;
    }

    public byte[] getSalt() {
        return salt;
    }
    
    
    
}
