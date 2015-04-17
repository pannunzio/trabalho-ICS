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
        ArquivoSingleton obj = ArquivoSingleton.getInstance();
        try {
            
            obj.setMicrossegundo(obj.getSequenciador().getMicrosecondPosition());
            obj.getSequenciador().stop();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
