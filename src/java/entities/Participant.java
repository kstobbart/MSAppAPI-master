/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

import java.util.ArrayList;

/**
 *
 * @author adickinson
 * A class model for Participants.
 */
public class Participant {
    public int ID;
    public int programmeID;
    public String password; //A hashed version of the user's plaintext password
    
    public byte[] salt; //The user's salt for password encryption. 
    /**
     * Please note if you are playing with this, the value for salt MUST be
     * a byte array, eg 
     * [-89, 23, 12...]
     * If you are debugging or receive weird results, make sure you are using the
     * char array properly, and not doing something like converting it to a string directly.
     */
    
    public String email;
    public String privateName;
    
    public ArrayList<String> fortnightDiaryIDList; //List of a user's diary IDs
    
    /**
     * Default Constructor for the Participant model class.
     */
    public Participant(){
        this.ID = 0;
        this.programmeID = 0;
        this.password = "";
        this.salt = null;
        this.email = "";
        this.privateName = "";
        
        this.fortnightDiaryIDList = new ArrayList();
    }
    
    /**
     * Parameterised Constructor for the Participant model class.
     * Note that for security reasons, we do not initialise with the password/salt.
     * If necessary these can be set with the appropriate set methods.
     */
    public Participant(int ID, int programmeID, String email, String privateName){
        this.ID = 0;
        this.programmeID = 0;
        this.password = "";
        this.salt = null;
        this.email = "";
        this.privateName ="";
        this.fortnightDiaryIDList = new ArrayList();
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public int getProgrammeID() {
        return programmeID;
    }

    public void setProgrammeID(int programmeID) {
        this.programmeID = programmeID;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public byte[] getSalt() {
        return salt;
    }

    public void setSalt(byte[] salt) {
        this.salt = salt;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPrivateName() {
        return privateName;
    }

    public void setPrivateName(String privateName) {
        this.privateName = privateName;
    }

    public ArrayList<String> getFortnightDiaryIDList() {
        return fortnightDiaryIDList;
    }

    public void setFortnightDiaryIDList(ArrayList<String> fortnightDiaryIDList) {
        this.fortnightDiaryIDList = fortnightDiaryIDList;
    }
    
    
}
