package tocadorMidi.engine.actionListeners;
 
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.beans.*;
import java.util.Random;
import tocadorMidi.engine.singletons.ArquivoSingleton;
 
public class ProgressoAudio {
 
    private Task tarefa;
    
    public JProgressBar initProgresso(){
        
        ArquivoSingleton instance = ArquivoSingleton.getInstance();
        JProgressBar novoProgresso = null;
        if(instance.getArqMidi() != null && instance.getSequenciador() != null){
        
            int microssegundoParaSegundo = (int) instance.getSequenciador().getMicrosecondLength()/1000;
            novoProgresso = new JProgressBar(0, microssegundoParaSegundo);
            novoProgresso.setValue(0);
            novoProgresso.setStringPainted(Boolean.TRUE);
        
        }
        
        return novoProgresso;
    }
 
    class Task extends SwingWorker<Void, Void> {
        /*
         * Main task. Executed in background thread.
         */
        @Override
        public Void doInBackground() {
            Random random = new Random();
            int progress = 0;
            //Initialize progress property.
            setProgress(0);
            while (progress < 100) {
                //Sleep for up to one second.
                try {
                    Thread.sleep(random.nextInt(1000));
                } catch (InterruptedException ignore) {}
                //Make random progress.
                progress += random.nextInt(10);
                setProgress(Math.min(progress, 100));
            }
            return null;
        }
 
        /*
         * Executed in event dispatching thread
         */
        @Override
        public void done() {
            Toolkit.getDefaultToolkit().beep();
//            startButton.setEnabled(true);
//            setCursor(null); //turn off the wait cursor
//            taskOutput.append("Done!\n");
        }
    }
    
    
    public void MidiTocando() {
        //Instances of javax.swing.SwingWorker are not reusuable, so
        //we create new instances as needed.
        tarefa = new Task();
//        tarefa.addPropertyChangeListener();
        tarefa.execute();
        
    }
}