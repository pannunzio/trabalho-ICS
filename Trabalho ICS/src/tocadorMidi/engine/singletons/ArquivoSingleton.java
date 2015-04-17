/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tocadorMidi.engine.singletons;

import java.io.File;

/**
 *
 * @author mqueiroz
 */
public class ArquivoSingleton {
    private static ArquivoSingleton instance = null;
    private static File arqMidi;
    
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
}
