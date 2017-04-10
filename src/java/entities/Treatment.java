/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

/**
 *
 * @author adickinson
 */
class Treatment {
    public String whoSeen;
    public String treatmentReceived;
    
    public Treatment(){
        this.whoSeen = "";
        this.treatmentReceived = "";
    }
    
    public Treatment(String whoSeen, String treatmentReceived){
        this.whoSeen = whoSeen;
        this.treatmentReceived = treatmentReceived;
    }
    
    //<editor-fold desc="Getters and setters.">
    public String getWhoSeen() {
        return whoSeen;
    }

    public void setWhoSeen(String whoSeen) {
        this.whoSeen = whoSeen;
    }

    public String getTreatmentReceived() {
        return treatmentReceived;
    }

    public void setTreatmentReceived(String treatmentReceived) {
        this.treatmentReceived = treatmentReceived;
    }
    //</editor-fold>
}
