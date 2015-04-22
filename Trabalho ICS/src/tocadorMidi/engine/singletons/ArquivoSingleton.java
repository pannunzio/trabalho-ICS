/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tocadorMidi.engine.singletons;

import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Random;
import java.util.concurrent.TimeUnit;
import javafx.concurrent.Task;
import javax.sound.midi.InvalidMidiDataException;
import javax.sound.midi.MetaMessage;
import javax.sound.midi.MidiEvent;
import javax.sound.midi.MidiMessage;
import javax.sound.midi.MidiSystem;
import javax.sound.midi.MidiUnavailableException;
import javax.sound.midi.Receiver;
import javax.sound.midi.Sequence;
import javax.sound.midi.Sequencer;
import javax.sound.midi.ShortMessage;
import javax.sound.midi.Track;
import javax.swing.JTextArea;
import javax.swing.SwingWorker;
import jdk.nashorn.internal.codegen.CompilerConstants;

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
    private Calendar tempoMusica;
    private Boolean isTocando;
    private Integer tamanhoTrilha;
    private String formulaCompasso;

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

    public Calendar getTempoMusica() {
        return tempoMusica;
    }

    public void setTempoMusica(Calendar tempoMusica) {
        this.tempoMusica = tempoMusica;
    }

    
    final int FORMULA_DE_COMPASSO = 0x58;

    public String getFormulaDeCompasso(Track trilha) {
        int p = 1;
        int q = 1;

        Dimension d = new Dimension(p, q);
        
        for (int i = 0; i < trilha.size(); i++) {
            MidiMessage m = trilha.get(i).getMessage();
            if (m instanceof MetaMessage) {
                if (((MetaMessage) m).getType() == FORMULA_DE_COMPASSO) {
                    MetaMessage mm = (MetaMessage) m;
                    byte[] data = mm.getData();
                    p = data[0];
                    q = data[1];
                }
            }
        }
        return p + "/" + q*q;
    }


    public void initMidi() throws InvalidMidiDataException, IOException, MidiUnavailableException {
        Integer tamTrilha = null;
        if (this.getArqMidi() != null) {
            this.setSequencia(MidiSystem.getSequence(this.getArqMidi()));

            this.setSequenciador(MidiSystem.getSequencer());
            this.getSequenciador().setSequence(this.getSequencia());
            this.getSequenciador().open();

            tamTrilha = (int) this.getSequenciador().getMicrosecondLength() / 1000;
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

    public void tempoTotalMusica() {
        Long tempo = this.getSequenciador().getMicrosecondLength();
        Calendar cal = Calendar.getInstance();
        cal.setTimeInMillis(tempo / 1000);

        this.setTempoMusica(cal);
    }

    public Calendar tempoAtualMusica() {
        Long tempo = this.getSequenciador().getMicrosecondPosition();
        Calendar cal = Calendar.getInstance();
        cal.setTimeInMillis(tempo / 1000);

        return cal;
    }

    public String tempoEmString(Calendar tempo) {
        SimpleDateFormat formato = new SimpleDateFormat("mm:ss");
        System.out.println(formato.format(tempo.getTime()));
        return formato.format(tempo.getTime());
    }
}
