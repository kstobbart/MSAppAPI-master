/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author adickinson
 * Helper class for incidents where participant experienced a relapse in their symptoms.
 * Despite the name, there is very little which each of the incident classes share
 * which makes it hard to justify utilising abstraction and a super class.
 */
public class RelapseIncident {
    public String fortnightDiaryID;
    public Date onsetDate;
    
    public String durationRaw;//The formatted String for storing/retrieving in the DB
    // EG -{"Duration":"10", "Units":"Hours"}
    public int duration;//The actual duration
    public String durationUnits;//The units for the duration, eg Days or hours
    
    public Boolean healthcareProConsulted;
    public ArrayList<String> symptomList;//TODO: Possibly tweak this depending on front end
    public ArrayList<Treatment> treatmentList;
    
    public RelapseIncident(){
        this.fortnightDiaryID = "";
        this.onsetDate = null;
        
        this.durationRaw = "";
        this.duration = 0;
        this.durationUnits = "";
        
        this.healthcareProConsulted = null;
        this.symptomList = new ArrayList();
        this.treatmentList = new ArrayList();
    }
    
    public RelapseIncident(String ID){
        this.fortnightDiaryID = ID;
        this.onsetDate = null;
        
        this.durationRaw = "";
        this.duration = 0;
        this.durationUnits = "";
        
        this.healthcareProConsulted = null;
        this.symptomList = new ArrayList();
        this.treatmentList = new ArrayList();
    }
    
    public RelapseIncident(String ID, Date onsetDate, int duration, String durationUnits,
                            Boolean healthcareProConsulted, ArrayList<String> symptomList,
                            ArrayList<Treatment> treatmentList){
        this.fortnightDiaryID = ID;
        this.onsetDate = onsetDate;
        
        this.duration = duration;
        this.durationUnits = durationUnits;
        
        this.healthcareProConsulted = null;
        this.symptomList = new ArrayList();
        this.symptomList = symptomList;
        this.treatmentList = new ArrayList();
        this.treatmentList = treatmentList;
        
        updateDurationRaw();
    }
    
    public RelapseIncident(String ID, Date onsetDate, String durationRaw, Boolean 
                            healthcareProConsulted, ArrayList<String> symptomList,
                            ArrayList<Treatment> treatmentList){
        this.fortnightDiaryID = ID;
        this.onsetDate = onsetDate;
        
        this.durationRaw = durationRaw;
       
        this.healthcareProConsulted = null;
        this.symptomList = new ArrayList();
        this.symptomList = symptomList;
        this.treatmentList = new ArrayList();
        this.treatmentList = treatmentList;
        
        updateDurations(durationRaw);
    }

    //<editor-fold desc="Getters and setters.">
    public String getFortnightDiaryID() {
        return fortnightDiaryID;
    }

    public void setFortnightDiaryID(String fortnightDiaryID) {
        this.fortnightDiaryID = fortnightDiaryID;
    }

    public Date getOnsetDate() {
        return onsetDate;
    }

    public void setOnsetDate(Date onsetDate) {
        this.onsetDate = onsetDate;
    }

    public String getDurationRaw() {
        return durationRaw;
    }

    public void setDurationRaw(String durationRaw) {
        this.durationRaw = durationRaw;
        updateDurations(durationRaw);
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
        updateDurationRaw();
    }

    public String getDurationUnits() {
        return durationUnits;
    }

    public void setDurationUnits(String durationUnits) {
        this.durationUnits = durationUnits;
        updateDurationRaw();
    }

    public Boolean getHealthcareProConsulted() {
        return healthcareProConsulted;
    }

    public void setHealthcareProConsulted(Boolean healthcareProConsulted) {
        this.healthcareProConsulted = healthcareProConsulted;
    }

    public ArrayList<String> getSymptomList() {
        return symptomList;
    }

    public void setSymptomList(ArrayList<String> symptomList) {
        this.symptomList = symptomList;
    }

    public ArrayList<Treatment> getTreatmentList() {
        return treatmentList;
    }

    public void setTreatmentList(ArrayList<Treatment> treatmentList) {
        this.treatmentList = treatmentList;
    }
    //</editor-fold>
    
    //Method to auto update raw duration
    public void updateDurationRaw(){
        //TODO:
    }
    
    //Method to auto update duration and duration units
    public void updateDurations(String durationRaw){
        //TODO:
    }  
}
