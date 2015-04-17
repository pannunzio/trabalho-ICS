/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tocadorMidi.engine.singletons;

import javax.sound.midi.Sequence;
import javax.sound.midi.Sequencer;

/**
 *
 * @author mqueiroz
 */
public class TocadorSingleton {

    private static TocadorSingleton instance = null;

    private Sequencer sequenciador;
    private Sequence sequencia;

    protected TocadorSingleton() {

    }

    public static TocadorSingleton getInstance() {
        if (instance == null) {
            instance = new TocadorSingleton();
        }
        return instance;
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

}
