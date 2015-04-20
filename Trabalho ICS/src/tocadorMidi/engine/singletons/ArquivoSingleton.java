/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tocadorMidi.engine.singletons;

import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.io.File;
import java.io.IOException;
import java.util.Random;
import java.util.concurrent.TimeUnit;
import javafx.concurrent.Task;
import javax.sound.midi.InvalidMidiDataException;
import javax.sound.midi.MidiSystem;
import javax.sound.midi.MidiUnavailableException;
import javax.sound.midi.Receiver;
import javax.sound.midi.Sequence;
import javax.sound.midi.Sequencer;
import javax.sound.midi.ShortMessage;
import javax.swing.JTextArea;
import javax.swing.SwingWorker;

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
    private Boolean isTocando;
    private Integer tamanhoTrilha;

    protected ArquivoSingleton() {
        this.setIsTocando(Boolean.FALSE);
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

    public Boolean getIsTocando() {
        return isTocando;
    }

    public void setIsTocando(Boolean isTocando) {
        this.isTocando = isTocando;
    }

    public Integer getTamanhoTrilha() {
        return tamanhoTrilha;
    }

    public void setTamanhoTrilha(Integer tamanhoTrilha) {
        this.tamanhoTrilha = tamanhoTrilha;
    }

    public void initMidi() throws InvalidMidiDataException, IOException, MidiUnavailableException {
        Integer tamTrilha = null;
        if (this.getArqMidi() != null) {
            this.setSequencia(MidiSystem.getSequence(this.getArqMidi()));

            this.setSequenciador(MidiSystem.getSequencer());
            this.getSequenciador().setSequence(this.getSequencia());
            this.getSequenciador().open();
            
            tamTrilha = (int) this.getSequenciador().getMicrosecondLength()/1000;
            this.setTamanhoTrilha(tamTrilha);
            this.setIsTocando(Boolean.FALSE);
        }
    }

    public void closeMidi() {
        if (this.getArqMidi() != null) {
            this.getSequenciador().close();
        }
    }

    public void initVolume() {
        this.setVolumeAtual(50);
        this.setReceptor(null);
    }

    public void configuraVolume() throws MidiUnavailableException {
        this.setReceptor(this.getSequenciador().getTransmitters().iterator().next().getReceiver());
        this.getSequenciador().getTransmitter().setReceiver(this.getReceptor());
    }

    public void inicializaVolume() {
        if (this.isTocando) {
            ShortMessage msgVolume = new ShortMessage();
            for (int i = 0; i < 16; i++) {
                try {
                    msgVolume.setMessage(ShortMessage.CONTROL_CHANGE, i, 7, this.getVolumeAtual());
                    this.getReceptor().send(msgVolume, -1);
                } catch (InvalidMidiDataException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public void alteraPosicaoMusica(Long milisegundosAlterados) {
        if (this.getIsTocando() && this.getArqMidi() != null) {
            this.setMicrossegundo(instance.getSequenciador().getMicrosecondPosition());
            this.getSequenciador().stop();
            this.getSequenciador().setMicrosecondPosition(instance.getMicrossegundo());
            this.getSequenciador().start();
        }
    }
}
