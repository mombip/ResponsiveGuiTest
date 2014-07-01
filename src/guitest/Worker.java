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

        ViewModel viewModel;

        public WorkToDo(ViewModel model) {
            this.viewModel = model;
        }
        

        @Override
        public void run() {
            //Tutaj działasz sobie na obiekkcie ViewModel zamiast na komponentach GUI
            //Binding załatwia resztę!!!
            
            viewModel.setFormEnabled(false);
            viewModel.setInfo("START!!!");

            for (int i = 1; i <= viewModel.getProgresMax(); i++) {
                viewModel.setProgres(i);
                viewModel.setInfo("Progres: " + i);
                System.out.println("Progres: " + i);
                try {
                    Thread.sleep(500);
                } catch (InterruptedException ex) {
                    Logger.getLogger(Worker.class.getName()).log(Level.SEVERE, null, ex);
                }
            }

            viewModel.setInfo("FINISHED!!!");
            viewModel.setFormEnabled(true);
        }
    }

}
