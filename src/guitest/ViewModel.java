/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package guitest;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;

/**
 *
 * @author marek
 */
public class ViewModel {
    
    private int progres = 0;
    private String info = "Przycisk uruchamia proces";  
    private boolean formEnabled = true;

    private int progresMax = 10;

    public static final String PROP_PROGRESMAX = "progresMax";

    /**
     * Get the value of progresMax
     *
     * @return the value of progresMax
     */
    public int getProgresMax() {
        return progresMax;
    }

    /**
     * Set the value of progresMax
     *
     * @param progresMax new value of progresMax
     */
    public void setProgresMax(int progresMax) {
        int oldProgresMax = this.progresMax;
        this.progresMax = progresMax;
        propertyChangeSupport.firePropertyChange(PROP_PROGRESMAX, oldProgresMax, progresMax);
    }

    public static final String PROP_FORMENABLED = "formEnabled";

    /**
     * Get the value of formEnabled
     *
     * @return the value of formEnabled
     */
    public boolean isFormEnabled() {
        return formEnabled;
    }

    /**
     * Set the value of formEnabled
     *
     * @param formEnabled new value of formEnabled
     */
    public void setFormEnabled(boolean formEnabled) {
        boolean oldFormEnabled = this.formEnabled;
        this.formEnabled = formEnabled;
        propertyChangeSupport.firePropertyChange(PROP_FORMENABLED, oldFormEnabled, formEnabled);
    }


    public static final String PROP_INFO = "info";
    public static final String PROP_PROGRES = "progres";


    /**
     * Get the value of info
     *
     * @return the value of info
     */
    public String getInfo() {
        return info;
    }

    /**
     * Set the value of info
     *
     * @param info new value of info
     */
    public void setInfo(String info) {
        String oldInfo = this.info;
        this.info = info;
        propertyChangeSupport.firePropertyChange(PROP_INFO, oldInfo, info);
    }





    /**
     * Get the value of progres
     *
     * @return the value of progres
     */
    public int getProgres() {
        return progres;
    }

    /**
     * Set the value of progres
     *
     * @param progres new value of progres
     */
    public void setProgres(int progres) {
        int oldProgres = this.progres;
        this.progres = progres;
        propertyChangeSupport.firePropertyChange(PROP_PROGRES, oldProgres, progres);
    }

    private transient final PropertyChangeSupport propertyChangeSupport = new PropertyChangeSupport(this);

    /**
     * Add PropertyChangeListener.
     *
     * @param listener
     */
    public void addPropertyChangeListener(PropertyChangeListener listener) {
        propertyChangeSupport.addPropertyChangeListener(listener);
    }

    /**
     * Remove PropertyChangeListener.
     *
     * @param listener
     */
    public void removePropertyChangeListener(PropertyChangeListener listener) {
        propertyChangeSupport.removePropertyChangeListener(listener);
    }

}
