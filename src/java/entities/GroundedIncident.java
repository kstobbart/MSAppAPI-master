/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

/**
 *
 * @author adickinson
 * Helper class for incidents where participant had a fall that had them on the ground
 * for a time in excess of 10 minutes.
 * Despite the name, there is very little which each of the incident classes share
 * which makes it hard to justify utilising abstraction and a super class.
 */
public class GroundedIncident {
    public String fortnightDiaryID;
    public int tenThirtyIncidents;//Annoyingly, since identifiers can't begin with numbers, we need to use an awkward name like this.
    public int thirtySixtyIncidents;//30-60 minutes on ground
    public int sixtyPlusIncidents;//60+ minutes on ground
    
    public GroundedIncident(){
        this.fortnightDiaryID = "";
        this.tenThirtyIncidents = 0;
        this.thirtySixtyIncidents = 0;
        this.sixtyPlusIncidents = 0;
    }
    
    public GroundedIncident(String ID){
        this.fortnightDiaryID = ID;
        this.tenThirtyIncidents = 0;
        this.thirtySixtyIncidents = 0;
        this.sixtyPlusIncidents = 0;
    }
    
    public GroundedIncident(String ID, int tenThirtyIncidents, int thirtySixtyIncidents, int sixtyPlusIncidents){
        this.fortnightDiaryID = ID;
        this.tenThirtyIncidents = tenThirtyIncidents;
        this.thirtySixtyIncidents = thirtySixtyIncidents;
        this.sixtyPlusIncidents = sixtyPlusIncidents;
    }
    
    //<editor-fold desc="Getters and setters.">
    public String getFortnightDiaryID() {
        return fortnightDiaryID;
    }

    public void setFortnightDiaryID(String fortnightDiaryID) {
        this.fortnightDiaryID = fortnightDiaryID;
    }

    public int getTenThirtyIncidents() {
        return tenThirtyIncidents;
    }

    public void setTenThirtyIncidents(int tenThirtyIncidents) {
        this.tenThirtyIncidents = tenThirtyIncidents;
    }

    public int getThirtySixtyIncidents() {
        return thirtySixtyIncidents;
    }

    public void setThirtySixtyIncidents(int thirtySixtyIncidents) {
        this.thirtySixtyIncidents = thirtySixtyIncidents;
    }

    public int getSixtyPlusIncidents() {
        return sixtyPlusIncidents;
    }

    public void setSixtyPlusIncidents(int sixtyPlusIncidents) {
        this.sixtyPlusIncidents = sixtyPlusIncidents;
    }
    //</editor-fold>
    
    //<editor-fold desc="Methods to alter a user's total number of incidents.">
    //10-30 Minutes
    public int tallyTenThirty(int increase){
        this.tenThirtyIncidents += increase;
        return tenThirtyIncidents;
    }
    
    //30-60 Minutes
    public int tallyThirtySixty(int increase){
        this.thirtySixtyIncidents += increase;
        return thirtySixtyIncidents;
    }
    
    //60+ Minutes
    public int tallySixtyPlus(int increase){
        this.sixtyPlusIncidents += increase;
        return sixtyPlusIncidents;
    }
    //</editor-fold>
    
    
}
