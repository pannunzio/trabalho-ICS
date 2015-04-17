/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tocadorMidi.engine.singletons;

import java.io.File;
import javax.sound.midi.Sequence;
import javax.sound.midi.Sequencer;

/**
 *
 * @author mqueiroz
 */
public class ArquivoSingleton {
    private static ArquivoSingleton instance = null;
    
    private static File arqMidi;
    private Sequencer sequenciador;
    private Sequence sequencia;
    private Long tick;
    private Long microssegundo;
    
    protected ArquivoSingleton(){
    }
    
    public static ArquivoSingleton getInstance(){
        if(instance == null){
            instance = new ArquivoSingleton();
        }
        return instance;
    }

    public File getArqMidi() {
        return arqMidi;
    }

    public void setArqMidi(File arqMidi) {
        this.arqMidi = arqMidi;
    }

    public Sequencer getSequenciador() {
        return sequenciador;
    }

    public void setSequenciador(Sequencer sequenciador) {
        this.sequenciador = sequenciador;
    }

    public Sequence getSequencia() {
        return sequencia;
    }

    public void setSequencia(Sequence sequencia) {
        this.sequencia = sequencia;
    }

    public Long getTick() {
        return tick;
    }

    public void setTick(Long tick) {
        this.tick = tick;
    }

    public Long getMicrossegundo() {
        return microssegundo;
    }

    public void setMicrossegundo(Long microssegundo) {
        this.microssegundo = microssegundo;
    }
}
