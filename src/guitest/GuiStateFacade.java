/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package guitest;

/**
 *
 * @author student
 */
public class GuiStateFacade {
    ViewModel model;

    public GuiStateFacade(ViewModel model) {
        this.model = model;
    }
    
    public void enabled(boolean enabled){
        model.setFormEnabled(enabled);
        //i tutaj inne operacje na modelu które chcemy zrobić na enebled
    }
    
}
