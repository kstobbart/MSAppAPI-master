/*
 * TODO: Change me
 */
package entities;

import java.util.ArrayList;

/**
 *
 * @author Andrew
 */
public class User {
    public int ID;
    public int programmeNumber;
    
    public Password password;
    public String email;
    public String greeting;
    
    public ArrayList<String> fortnightlyDiaryIDs;

    public User(){
        this.ID = 0;
        this.programmeNumber = 0;
        
        this.password = null;
        this.email = "";
        this.greeting = "";
        
        this.fortnightlyDiaryIDs = new ArrayList();
    }

    public User(int ID, int programmeNumber, Password password, String email, String greeting, ArrayList<String> fortnightlyDiaryIDs) {
        this.ID = ID;
        this.programmeNumber = programmeNumber;
        this.password = password;
        this.email = email;
        this.greeting = greeting;
        this.fortnightlyDiaryIDs = fortnightlyDiaryIDs;
    }
    
    //<editor-fold desc="Getters and setters">
    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public int getProgrammeNumber() {
        return programmeNumber;
    }

    public void setProgrammeNumber(int programmeNumber) {
        this.programmeNumber = programmeNumber;
    }

    public Password getPassword() {
        return password;
    }

    public void setPassword(Password password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getGreeting() {
        return greeting;
    }

    public void setGreeting(String greeting) {
        this.greeting = greeting;
    }

    public ArrayList<String> getFortnightlyDiaryIDs() {
        return fortnightlyDiaryIDs;
    }

    public void setFortnightlyDiaryIDs(ArrayList<String> fortnightlyDiaryIDs) {
        this.fortnightlyDiaryIDs = fortnightlyDiaryIDs;
    }
    //</editor-fold>
    
    //TODO: Import List manipulation module
}
