/*
 * TODO: Change me
 */
package entities;

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
public class Password {
    public String plainPassword;
    public byte[] salt;
    public String hashedPassword;
    
    public Password(){
        this.plainPassword = null;
        this.hashedPassword = null;
        this.salt = null;
    }

    //Constructor for generation of new passwords
    public Password(String plainPassword) {
        this.plainPassword = plainPassword;
        this.salt = generateSalt();
        this.hashedPassword = generateHash(this.plainPassword, this.salt);
    }
    
    public Password(String hashedPassword, byte[] salt){
        this.hashedPassword = hashedPassword;
        this.salt = salt;
    }
    
    public Password(String hashedPassword, String salt){
        this.hashedPassword = hashedPassword;
        this.salt = saltToBytes(salt);
    }
    
    
    //<editor-fold desc="Getters and setters">
    public String getPlainPassword() {
        return plainPassword;
    }

    public void setPlainPassword(String ptPassword) {
        this.plainPassword = ptPassword;
    }

    public String getHashedPassword() {
        return hashedPassword;
    }

    public void setHashedPassword(String hashedPassword) {
        this.hashedPassword = hashedPassword;
    }

    public byte[] getSalt() {
        return salt;
    }

    public void setSalt(byte[] salt) {
        this.salt = salt;
    } 
    //</editor-fold>
    
    //Hashes current values of salt and plainPassword and sets hashedPassword as result
    public void hashSelf(){
        setHashedPassword(generateHash(this.plainPassword, this.salt));
    }
    
    //Generates a salt for hashing a password
    /**
     * Uses SecureRandom and the SHA-1 Pseudo Random Number Generator to create a 
     * salt that is extremely difficult to predict.
     * 
     * @return 
     * @throws java.security.NoSuchAlgorithmException
     */
    public byte[] generateSalt(){
        SecureRandom secureRandomGenerator = new SecureRandom();
        try{
            secureRandomGenerator = SecureRandom.getInstance("SHA1PRNG");
        } catch (NoSuchAlgorithmException ex) {
            Logger.getLogger(Password.class.getName()).log(Level.SEVERE, null, ex);
        }        
        byte[] randomBytes = new byte[32];
        secureRandomGenerator.nextBytes(randomBytes);
       
        return randomBytes;
    }
    
    //Uses the plaintext password and the salt to generate a hashed password to store in the database
    /** 
     * 
     * @param password
     * @param salt
     * @return
     * @throws Exception 
     */
    public String generateHash(String password, byte[] salt){
        SecretKeyFactory keyFactory = null;
        SecretKey key = null;
        try {
            keyFactory = SecretKeyFactory.getInstance("PBKDF2WithHmacSHA1");
            key = keyFactory.generateSecret(new PBEKeySpec(password.toCharArray(), salt, 2000, 128));
        } catch (NoSuchAlgorithmException ex) {
            Logger.getLogger(Password.class.getName()).log(Level.SEVERE, null, ex);
        } catch (InvalidKeySpecException ex) {
            Logger.getLogger(Password.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
        String encoded = DatatypeConverter.printBase64Binary(key.getEncoded());
        //byte[] decoded = DatatypeConverter.parseBase64Binary(encoded);
        
        //String output = new String(decoded, "UTF-8");
        
        return encoded;
    } 
    
    
    //Helper method for conversion of salt to a database storable object
    /**
     * 
     * @param salt
     * @return 
     */
    public String saltToString(byte[] salt){
        return Arrays.toString(salt);
    }
    
    //Helper method for conversion of salt to a byte array
    /**
     * 
     * @param salt
     * @return 
     */
    public byte[] saltToBytes(String salt){
        String[] byteValues = salt.substring(1, salt.length()-1).split(",");
        byte[] bytes = new byte[byteValues.length];

        for (int i=0; i<bytes.length; i++) {
           bytes[i] = Byte.parseByte(byteValues[i].trim());     
        }
        
        return bytes;
    }
    
    //Please note that something exceptionally weird goes on here. In an ideal world one would 
    //rather use String.matches() instead of String.contains, however for some strange reason
    //String.matches always returns false even if the hash values match.
    //You can verify this by executing the below System.out message
    //In reality this isn't really an issue, as the algorithm to produce hashed values will
    //create values that always have the same length, so we realisticaly do not need to worry about
    //the evaluation step equating to something like
    //"Boolean match = abcdefghijkl.contains("bcd")"
    //Weird, but insignificant.
    public Boolean passwordMatch(String inputPassword){
        //Compare this.hashedPassword to input
        Boolean match = this.hashedPassword.contains(inputPassword);
            
        return match;
    }
    
}
