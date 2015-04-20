/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tocadorMidi.engine.actionListeners;

import java.io.File;
import java.io.IOException;
import javafx.concurrent.Task;
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
        ArquivoSingleton instance = ArquivoSingleton.getInstance();
        try {
            if (instance.getArqMidi() != null) {
                instance.setSequencia(MidiSystem.getSequence(instance.getArqMidi()));
            }
            instance.setSequenciador(MidiSystem.getSequencer());
            instance.getSequenciador().setSequence(instance.getSequencia());
            instance.getSequenciador().open();
            
            if(instance.getTick() != null)
                instance.getSequenciador().setLoopStartPoint(instance.getTick());
            if(instance.getMicrossegundo() != null)
                instance.getSequenciador().setMicrosecondPosition(instance.getMicrossegundo());
            
            instance.getSequenciador().start();
            instance.setIsTocando(Boolean.TRUE);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
