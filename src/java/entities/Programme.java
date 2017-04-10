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
public class Programme {
    public int ProgrammeID;
    public String Name;
    public int Weeks;
    public int Capacity;
    public int Manager;
    
    public Programme(){
        this.Name = "";
    }
   

    public int getProgrammeID() {
        return ProgrammeID;
    }

    public void setProgrammeID(int ProgrammeID) {
        this.ProgrammeID = ProgrammeID;
    }
    
    public String getName() {
        return Name;
    }

    public void setName(String Name) {
        this.Name = Name;
    }

    public int getWeeks() {
        return Weeks;
    }

    public void setWeeks(int Weeks) {
        this.Weeks = Weeks;
    }

    public int getCapacity() {
        return Capacity;
    }

    public void setCapacity(int Capactity) {
        this.Capacity = Capactity;
    }

    public int getManager() {
        return Manager;
    }

    public void setManager(int Manager) {
        this.Manager = Manager;
    }
    
    
    
}
