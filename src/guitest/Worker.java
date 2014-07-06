/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package guitest;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author marek
 */
public class Worker {

    void doJob(ViewModel model) {

        try {
            Thread thr = new Thread(new WorkToDo(model));
            thr.start();//odpali watek i od razu wróci - uwolni GUI
//TEST tego jak by było bez watku - wszystko zostaje tylko dodajemy linię z joinem
//            thr.join(); //symulacja braku wątku - wtedy nic sie nie odswierza
        } catch (Exception ex) {
            Logger.getLogger(Worker.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    class WorkToDo implements Runnable {

//        ViewModel viewModel;
        ProgressFacade progress;
        GuiStateFacade guiState;
        public WorkToDo(ViewModel model) {
//            this.viewModel = model;
            progress = new ProgressFacade(model);
            guiState = new GuiStateFacade(model);
            
        }
        

        @Override
        public void run() {
            //Tutaj działasz sobie na obiekkcie ViewModel zamiast na komponentach GUI
            //Binding załatwia resztę!!!
            int iterationsCountDependOnBuisnesLogic = 10;
            
                    
            guiState.enabled(false);
            progress.init(iterationsCountDependOnBuisnesLogic, "START!!!");

            for (int i = 0; i < iterationsCountDependOnBuisnesLogic; i++) {
                
                progress.reportProgress(i+1, "Progres: " + (i+1));
                System.out.println("Progres: " + i);
                try {
                    Thread.sleep(500);
                } catch (InterruptedException ex) {
                    Logger.getLogger(Worker.class.getName()).log(Level.SEVERE, null, ex);
                }
            }

            progress.finalize("FINISHED!!!");
            guiState.enabled(true);
        }
    }

}
