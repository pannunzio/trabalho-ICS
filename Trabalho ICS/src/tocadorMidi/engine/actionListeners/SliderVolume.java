/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tocadorMidi.engine.actionListeners;

import javax.sound.midi.InvalidMidiDataException;
import javax.sound.midi.MidiUnavailableException;
import javax.sound.midi.ShortMessage;
import tocadorMidi.engine.singletons.ArquivoSingleton;

/**
 *
 * @author mariana
 */
public class SliderVolume {

    public SliderVolume() {

    }

    public void iniciaVolume(int volume) throws MidiUnavailableException {
        ArquivoSingleton obj = ArquivoSingleton.getInstance();
        ShortMessage mensagemDeVolume = new ShortMessage();
        
        obj.setReceptor(obj.getSequenciador().getTransmitters().iterator().next().getReceiver());
        obj.getSequenciador().getTransmitter().setReceiver(obj.getReceptor());
        
        for (int i = 0; i < 16; i++) {
            try {
                mensagemDeVolume.setMessage(ShortMessage.CONTROL_CHANGE, i, 7, volume);
                if(obj.getReceptor() != null)
                    obj.getReceptor().send(mensagemDeVolume, -1);
                
            } catch (InvalidMidiDataException e1) {
            }
        }
    }
}
