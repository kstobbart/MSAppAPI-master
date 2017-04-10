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
 * A helper class that represents the model of a user's fortnightly diary.
 */
public class FortnightDiary {
    public String recordID;
    
    public int participantID;
    public int totalFalls;
    public int grievousFalls;
    
    public Date fortnightStart;
    
    public ArrayList<DailyDiary> dailyDiaryList;
    
    public HeadInjury headInjuries;
    public BodyInjury bodyInjuries;
    public ArmInjury armInjuries;
    public LegInjury legInjuries;    
    public MedServiceIncident medServiceIncidents;
    public GroundedIncident groundedIncidents;
    public AssistanceRequiredIncident assistanceRequiredIncident;
    public DegradationIncident degradationIncident;
    public RelapseIncident relapseIncident;
    
    //<editor-fold desc="Don't look in here. Class constructors, but it's an absolute mess and hurts to look at">
    public FortnightDiary(){
        this.recordID = "";
        
        this.participantID = 0;
        this.totalFalls = 0;
        this.grievousFalls = 0;
        
        this.fortnightStart = null;
        
        this.dailyDiaryList = new ArrayList();
        
        this.headInjuries = new HeadInjury();
        this.bodyInjuries = new BodyInjury();
        this.armInjuries = new ArmInjury();
        this.legInjuries = new LegInjury();
        this.medServiceIncidents = new MedServiceIncident();
        this.groundedIncidents = new GroundedIncident();
        this.assistanceRequiredIncident = new AssistanceRequiredIncident();
        this.degradationIncident = new DegradationIncident();
        this.relapseIncident = new RelapseIncident();        
    }

    public FortnightDiary(String ID, int participantID) {
        this.recordID = ID;
        
        this.participantID = participantID;
        this.totalFalls = 0;
        this.grievousFalls = 0;
        
        this.fortnightStart = null;
        
        this.dailyDiaryList = new ArrayList();
        
        this.headInjuries = new HeadInjury();
        this.bodyInjuries = new BodyInjury();
        this.armInjuries = new ArmInjury();
        this.legInjuries = new LegInjury();
        this.medServiceIncidents = new MedServiceIncident();
        this.groundedIncidents = new GroundedIncident();
        this.assistanceRequiredIncident = new AssistanceRequiredIncident();
        this.degradationIncident = new DegradationIncident();
        this.relapseIncident = new RelapseIncident();        
    }

    public FortnightDiary(String ID, int participantID, int totalFalls, int grievousFalls, Date fortnightStart, ArrayList<DailyDiary> dailyDiaryList, HeadInjury headInjuries, BodyInjury bodyInjuries, ArmInjury armInjuries, LegInjury legInjuries, MedServiceIncident medServiceIncidents, GroundedIncident groundedIncidents, AssistanceRequiredIncident assistanceRequiredIncident, DegradationIncident degradationIncident, RelapseIncident relapseIncident) {
        this.recordID = ID;
        
        this.participantID = participantID;
        this.totalFalls = totalFalls;
        this.grievousFalls = grievousFalls;
        
        this.fortnightStart = fortnightStart;
        
        this.dailyDiaryList = dailyDiaryList;
        
        this.headInjuries = headInjuries;
        this.bodyInjuries = bodyInjuries;
        this.armInjuries = armInjuries;
        this.legInjuries = legInjuries;
        this.medServiceIncidents = medServiceIncidents;
        this.groundedIncidents = groundedIncidents;
        this.assistanceRequiredIncident = assistanceRequiredIncident;
        this.degradationIncident = degradationIncident;
        this.relapseIncident = relapseIncident;
    }
    
    //</editor-fold>

    //<editor-fold desc="Getters and setters.">
    public String getRecordID() {
        return recordID;
    }

    public void setRecordID(String recordID) {
        this.recordID = recordID;
    }

    public int getParticipantID() {
        return participantID;
    }

    public void setParticipantID(int participantID) {
        this.participantID = participantID;
    }

    public int getTotalFalls() {
        return totalFalls;
    }

    public void setTotalFalls(int totalFalls) {
        this.totalFalls = totalFalls;
    }

    public int getGrievousFalls() {
        return grievousFalls;
    }

    public void setGrievousFalls(int grievousFalls) {
        this.grievousFalls = grievousFalls;
    }

    public Date getFortnightStart() {
        return fortnightStart;
    }

    public void setFortnightStart(Date fortnightStart) {
        this.fortnightStart = fortnightStart;
    }

    public ArrayList<DailyDiary> getDailyDiaryList() {
        return dailyDiaryList;
    }

    public void setDailyDiaryList(ArrayList<DailyDiary> dailyDiaryList) {
        this.dailyDiaryList = dailyDiaryList;
    }

    public HeadInjury getHeadInjuries() {
        return headInjuries;
    }

    public void setHeadInjuries(HeadInjury headInjuries) {
        this.headInjuries = headInjuries;
    }

    public BodyInjury getBodyInjuries() {
        return bodyInjuries;
    }

    public void setBodyInjuries(BodyInjury bodyInjuries) {
        this.bodyInjuries = bodyInjuries;
    }

    public ArmInjury getArmInjuries() {
        return armInjuries;
    }

    public void setArmInjuries(ArmInjury armInjuries) {
        this.armInjuries = armInjuries;
    }

    public LegInjury getLegInjuries() {
        return legInjuries;
    }

    public void setLegInjuries(LegInjury legInjuries) {
        this.legInjuries = legInjuries;
    }

    public MedServiceIncident getMedServiceIncidents() {
        return medServiceIncidents;
    }

    public void setMedServiceIncidents(MedServiceIncident medServiceIncidents) {
        this.medServiceIncidents = medServiceIncidents;
    }

    public GroundedIncident getGroundedIncidents() {
        return groundedIncidents;
    }

    public void setGroundedIncidents(GroundedIncident groundedIncidents) {
        this.groundedIncidents = groundedIncidents;
    }

    public AssistanceRequiredIncident getAssistanceRequiredIncident() {
        return assistanceRequiredIncident;
    }

    public void setAssistanceRequiredIncident(AssistanceRequiredIncident assistanceRequiredIncident) {
        this.assistanceRequiredIncident = assistanceRequiredIncident;
    }

    public DegradationIncident getDegradationIncident() {
        return degradationIncident;
    }

    public void setDegradationIncident(DegradationIncident degradationIncident) {
        this.degradationIncident = degradationIncident;
    }

    public RelapseIncident getRelapseIncident() {
        return relapseIncident;
    }

    public void setRelapseIncident(RelapseIncident relapseIncident) {
        this.relapseIncident = relapseIncident;
    }
    //</editor-fold>
    
}
