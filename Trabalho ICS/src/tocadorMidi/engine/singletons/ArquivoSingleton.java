/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tocadorMidi.engine.singletons;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;
import javax.sound.midi.InvalidMidiDataException;
import javax.sound.midi.MidiSystem;
import javax.sound.midi.MidiUnavailableException;
import javax.sound.midi.Receiver;
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
    private Integer volumeAtual;
    private Receiver receptor;
    private String tempoFormatado;

    protected ArquivoSingleton() {
    }

    public static ArquivoSingleton getInstance() {
        if (instance == null) {
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

    public Integer getVolumeAtual() {
        return volumeAtual;
    }

    public void setVolumeAtual(Integer volumeAtual) {
        this.volumeAtual = volumeAtual;
    }

    public Receiver getReceptor() {
        return receptor;
    }

    public void setReceptor(Receiver receptor) {
        this.receptor = receptor;
    }

    public String getTempoFormatado() {
        return tempoFormatado;
    }

    public void setTempoFormatado(String tempoFormatado) {
        this.tempoFormatado = tempoFormatado;
    }

    public void initMidi() throws InvalidMidiDataException, IOException, MidiUnavailableException {
        if (this.getArqMidi() != null) {
            Long milissegundos = null;
            Long minutos = null;
            Long segundos = null;
            
            this.setSequencia(MidiSystem.getSequence(this.getArqMidi()));

            this.setSequenciador(MidiSystem.getSequencer());
            this.getSequenciador().setSequence(this.getSequencia());
            this.getSequenciador().open();
            
            segundos = TimeUnit.MILLISECONDS.toSeconds(milissegundos);
            minutos = TimeUnit.MILLISECONDS.toMinutes(milissegundos);
            milissegundos -= TimeUnit.SECONDS.toMillis(segundos);
            
            setTempoFormatado(String.format("%02d:%02d:%d", minutos, segundos, milissegundos));
        }
    }
}
