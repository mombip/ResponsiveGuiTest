/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package guitest;

/**
 *
 * @author Marek
 */
public class ProgressFacade {
    ViewModel model;

    public ProgressFacade(ViewModel model) {
        this.model = model;
    }
    
    public void reportProgress(int progress, String comment){
        model.setProgres(progress);
        model.setInfo(comment);
    }
    
    public void init(int maxValue, String comment){
        model.setInfo(comment);
        model.setProgresMax(maxValue);
    }

    void finalize(String comment) {
        model.setProgres(model.getProgresMax());
        model.setInfo(comment);
    }
    
    
}
