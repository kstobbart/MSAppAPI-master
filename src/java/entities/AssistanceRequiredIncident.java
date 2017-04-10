/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

/**
 *
 * @author adickinson
 * Helper class for incidents where participant required assistance recovering from an incident.
 * Despite the name, there is very little which each of the incident classes share
 * which makes it hard to justify utilising abstraction and a super class.
 */
public class AssistanceRequiredIncident {
    public String fortnightDiaryID;
    public int family;
    public int acquaintance;//Friend/Neighbour
    public int healthcarePro;//Healthcare professional
    
    public AssistanceRequiredIncident(){
        this.fortnightDiaryID = "";
        this.family = 0;
        this.acquaintance = 0;
        this.healthcarePro = 0;
    }
    
    public AssistanceRequiredIncident(String ID){
        this.fortnightDiaryID = ID;
        this.family = 0;
        this.acquaintance = 0;
        this.healthcarePro = 0;
    }
    
    public AssistanceRequiredIncident(String ID, int family, int acquaintance, int healthcarePro){
        this.fortnightDiaryID = ID;
        this.family = family;
        this.acquaintance = acquaintance;
        this.healthcarePro = healthcarePro;
    }
    
    //<editor-fold desc="Getters and setters.">
    public String getFortnightDiaryID() {
        return fortnightDiaryID;
    }

    public void setFortnightDiaryID(String fortnightDiaryID) {
        this.fortnightDiaryID = fortnightDiaryID;
    }

    public int getFamily() {
        return family;
    }

    public void setFamily(int family) {
        this.family = family;
    }

    public int getAcquaintance() {
        return acquaintance;
    }

    public void setAcquaintance(int acquaintance) {
        this.acquaintance = acquaintance;
    }

    public int getHealthcarePro() {
        return healthcarePro;
    }

    public void setHealthcarePro(int healthcarePro) {
        this.healthcarePro = healthcarePro;
    }
    //</editor-fold>
    
    //<editor-fold desc="Methods to alter a user's total number of incidents.">
    //Family
    public int tallyFamily(int increase){
        this.family += increase;
        return family;
    }
    
    //Acquaintance
    public int tallyAcquaintance(int increase){
        this.acquaintance += increase;
        return acquaintance;
    }
    
    //Healthcare Professional
    public int tallyHealthcarePro(int increase){
        this.healthcarePro += increase;
        return healthcarePro;
    }
    //</editor-fold>
    
}
