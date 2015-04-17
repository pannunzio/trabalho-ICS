/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tocadorMidi.engine.actionListeners;

import java.io.File;
import java.io.IOException;
import javax.sound.midi.InvalidMidiDataException;
import javax.sound.midi.MidiSystem;
import javax.sound.midi.MidiUnavailableException;
import tocadorMidi.engine.classePrincipal.MainClass;
import tocadorMidi.engine.singletons.ArquivoSingleton; 

/**
 *
 * @author mariana
 */
public class BotaoPlay {

    public BotaoPlay() {

    }

    public void play() throws InvalidMidiDataException, IOException, MidiUnavailableException {
        ArquivoSingleton obj = ArquivoSingleton.getInstance();
        SliderVolume volume = new SliderVolume();
        try {
            if (obj.getArqMidi() != null) {
                obj.setSequencia(MidiSystem.getSequence(obj.getArqMidi()));
            }
            
            if(obj.getVolumeAtual() == null)
                volume.iniciaVolume(75);
            else
                volume.iniciaVolume(obj.getVolumeAtual());

            obj.setSequenciador(MidiSystem.getSequencer());
            obj.getSequenciador().setSequence(obj.getSequencia());
            obj.getSequenciador().open();
            
            if(obj.getTick() != null)
                obj.getSequenciador().setLoopStartPoint(obj.getTick());
            if(obj.getMicrossegundo() != null)
                obj.getSequenciador().setMicrosecondPosition(obj.getMicrossegundo());
            
            obj.getSequenciador().start();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
