/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

/**
 *
 * @author adickinson
 * Helper class for incidents where participant experiences any new or worsening symptoms.
 * Despite the name, there is very little which each of the incident classes share
 * which makes it hard to justify utilising abstraction and a super class.
 */
public class DegradationIncident {
    public String fortnightDiaryID;
    public String problem;
    public IncidentSeverityEnum severity;
    
    public String durationRaw;//The formatted String for storing/retrieving in the DB
    // EG -{"Duration":"10", "Units":"Hours"}
    public int duration;//The actual duration
    public String durationUnits;//The units for the duration, eg Days or hours

    public DegradationIncident(){
        this.fortnightDiaryID = "";
        this.problem = "";
        this.severity = null;
        this.durationRaw = "";
        this.duration = 0;
        this.durationUnits = "";
    }
    
    public DegradationIncident(String ID){
        this.fortnightDiaryID = ID;
        this.problem = "";
        this.severity = null;
        this.durationRaw = "";
        this.duration = 0;
        this.durationUnits = "";
    }
    
    public DegradationIncident(String ID, String problem, IncidentSeverityEnum severity,
                                int duration, String durationUnits){
        this.fortnightDiaryID = ID;
        this.problem = problem;
        this.severity = severity;
        
        this.duration = duration;
        this.durationUnits = durationUnits;
        
        updateDurationRaw();
    }
    
    public DegradationIncident(String ID, String problem, IncidentSeverityEnum severity,
                                String durationRaw){
        this.fortnightDiaryID = ID;
        this.problem = problem;
        this.severity = severity;
        
        this.durationRaw = durationRaw;        
        
        updateDurations(durationRaw);
    }
    
    //<editor-fold desc="Getters and setters.">
    public String getFortnightDiaryID() {
        return fortnightDiaryID;
    }

    public void setFortnightDiaryID(String fortnightDiaryID) {
        this.fortnightDiaryID = fortnightDiaryID;
    }

    public String getProblem() {
        return problem;
    }

    public void setProblem(String problem) {
        this.problem = problem;
    }

    public IncidentSeverityEnum getSeverity() {
        return severity;
    }

    public void setSeverity(IncidentSeverityEnum severity) {
        this.severity = severity;
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
