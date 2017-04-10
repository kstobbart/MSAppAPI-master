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
 * Helper class for incidents where medical services were required by the participant.
 * Despite the name, there is very little which each of the incident classes share
 * which makes it hard to justify utilising abstraction and a super class.
 */
public class MedServiceIncident {
    public String fortnightDiaryID;
    public int participantID;
    public int nurseVisits;
    public int GPVisits;
    public int specialistVisits;    
    public int emergencyVisits; //A&E visits
    public int otherVisits;
    
    public ArrayList<String> specialistSeenList;
    public ArrayList<String> otherSeenList;
    
    public MedServiceIncident(){
        this.fortnightDiaryID = "";
        this.participantID = 0;
        this.nurseVisits = 0;
        this.GPVisits = 0;
        this.specialistVisits = 0;
        this.emergencyVisits = 0;
        this.otherVisits = 0;
        
        this.specialistSeenList = new ArrayList();
        this.otherSeenList = new ArrayList();
    }
    
    public MedServiceIncident(String fortnightDiaryID, int participantID){
        this.fortnightDiaryID = fortnightDiaryID;
        this.participantID = participantID;
        this.nurseVisits = 0;
        this.GPVisits = 0;
        this.specialistVisits = 0;
        this.emergencyVisits = 0;
        this.otherVisits = 0;
        
        this.specialistSeenList = new ArrayList();
        this.otherSeenList = new ArrayList();
        
        //Add values to lists?
    }
    
    public MedServiceIncident(String fortnightDiaryID, int participantID, 
            int nurseVisits, int GPVisits, int specialistVisits, 
            int emergencyVisits, int otherVisits, ArrayList<String> specialistSeenList,
            ArrayList<String> otherSeenList){
        this.fortnightDiaryID = fortnightDiaryID;
        this.participantID = participantID;
        this.nurseVisits = nurseVisits;
        this.GPVisits = GPVisits;
        this.specialistVisits = specialistVisits;
        this.emergencyVisits = emergencyVisits;
        this.otherVisits = otherVisits;
        
        this.specialistSeenList = new ArrayList();
        this.specialistSeenList = specialistSeenList;
        this.otherSeenList = new ArrayList();
        this.otherSeenList = otherSeenList;
        
        //Add values to lists?
    }

    //<editor-fold desc="Getters and setters.">
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

    public int getNurseVisits() {
        return nurseVisits;
    }

    public void setNurseVisits(int nurseVisits) {
        this.nurseVisits = nurseVisits;
    }

    public int getGPVisits() {
        return GPVisits;
    }

    public void setGPVisits(int GPVisits) {
        this.GPVisits = GPVisits;
    }

    public int getSpecialistVisits() {
        return specialistVisits;
    }

    public void setSpecialistVisits(int specialistVisits) {
        this.specialistVisits = specialistVisits;
    }

    public int getEmergencyVisits() {
        return emergencyVisits;
    }

    public void setEmergencyVisits(int emergencyVisits) {
        this.emergencyVisits = emergencyVisits;
    }

    public int getOtherVisits() {
        return otherVisits;
    }

    public void setOtherVisits(int otherVisits) {
        this.otherVisits = otherVisits;
    }

    public ArrayList<String> getSpecialistSeenList() {
        return specialistSeenList;
    }

    public void setSpecialistSeenList(ArrayList<String> specialistSeenList) {
        this.specialistSeenList = specialistSeenList;
    }

    public ArrayList<String> getOtherSeenList() {
        return otherSeenList;
    }

    public void setOtherSeenList(ArrayList<String> otherSeenList) {
        this.otherSeenList = otherSeenList;
    }
    //</editor-fold>
    
    //<editor-fold desc="Methods to alter a user's total number of Visits.">
    //Nurse
    public int tallyNurse(int increase){
        this.nurseVisits += increase;
        return nurseVisits;
    }
    
    //GP
    public int tallyGP(int increase){
        this.GPVisits += increase;
        return GPVisits;
    }
    
    //Specialist
    public int tally(int increase){
        this.specialistVisits += increase;
        return specialistVisits;
    }
    
    //Emergency
    public int tallyEmergency(int increase){
        this.emergencyVisits +=increase;
        return emergencyVisits;
    }
    
    //Other
    public int tallyOther(int increase){
        this.otherVisits += increase;
        return otherVisits;
    }
    //</editor-fold>
}
