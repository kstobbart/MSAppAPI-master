/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

/**
 *
 * @author adickinson
 * An abstract super class for Injury models.
 */
public abstract class Injury {
    public String fortnightDiaryID;
    public int participantID;
    
    public int bruises;
    public int cuts;
    public int sprains;
    public int dislocations;
    public int brokenBones;

    public String getFortnightDiaryID() {
        return fortnightDiaryID;
    }

    public void setFortnightDiaryID(String fortnightDiaryID) {
        this.fortnightDiaryID = fortnightDiaryID;
    }

    public int getParticipantID() {
        return participantID;
    }

    public void setParticipantID(int participantID) {
        this.participantID = participantID;
    }    
    
    //<editor-fold desc="Injury getters and setters.">
    public int getBruises() {
        return bruises;
    }

    public void setBruises(int bruises) {
        this.bruises = bruises;
    }

    public int getCuts() {
        return cuts;
    }

    public void setCuts(int cuts) {
        this.cuts = cuts;
    }

    public int getSprains() {
        return sprains;
    }

    public void setSprains(int sprains) {
        this.sprains = sprains;
    }

    public int getDislocations() {
        return dislocations;
    }

    public void setDislocations(int dislocations) {
        this.dislocations = dislocations;
    }

    public int getBrokenBones() {
        return brokenBones;
    }

    public void setBrokenBones(int brokenBones) {
        this.brokenBones = brokenBones;
    }
    //</editor-fold> 
    
    //<editor-fold desc="Methods to alter a user's total number of sustained injuries.">
    //Bruises
    public int tallyBruises(int increase){
        this.bruises += increase;
        return bruises;
    }
    
    //Cuts
    public int tallyCuts(int increase){
        this.cuts += increase;
        return cuts;
    }
    
    //Sprains
    public int tallySprains(int increase){
        this.sprains += increase;
        return sprains;
    }
    
    //Dislocations
    public int tallyDislocations(int increase){
        this.dislocations += increase;
        return dislocations;
    }
    
    //Broken bones
    public int tallyBrokenBones(int increase){
        this.brokenBones+= increase;
        return brokenBones;
    }
    
    //</editor-fold>
}
