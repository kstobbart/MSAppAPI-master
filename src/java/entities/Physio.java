/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

/**
 *
 * @author kstobbart
 */
public class Physio {
    public int PhysioID;
    public String email;
    public String password;
    public byte[] salt;

    public int getPhysioID() {
        return PhysioID;
    }

    public void setPhysioID(int PhysioID) {
        this.PhysioID = PhysioID;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
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
    
    
}
