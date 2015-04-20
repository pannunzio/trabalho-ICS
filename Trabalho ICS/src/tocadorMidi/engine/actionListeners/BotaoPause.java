/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package tocadorMidi.engine.actionListeners;

import javax.sound.midi.MidiSystem;
import tocadorMidi.engine.singletons.ArquivoSingleton;

/**
 *
 * @author mariana
 */
public class BotaoPause {
    public BotaoPause(){
        
    }
    
    public void Pause(){
        ArquivoSingleton instance = ArquivoSingleton.getInstance();
        try {
            
            instance.setMicrossegundo(instance.getSequenciador().getMicrosecondPosition());
            instance.getSequenciador().stop();
            instance.setIsTocando(Boolean.FALSE);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
