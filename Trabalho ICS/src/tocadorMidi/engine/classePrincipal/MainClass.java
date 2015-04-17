/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package tocadorMidi.engine.classePrincipal;

import java.io.File;
import javax.swing.UIManager;
import tocadorMidi.interfaces.FrameTocador;

/**
 *
 * @author mariana
 */
public class MainClass {
    static private File arqMidi;

    public File getArqMidi() {
        return arqMidi;
    }

    public void setArqMidi(File arqMidi) {
        this.arqMidi = arqMidi;
    }
    /**
     * @param args the command line arguments
     */
    
    public static void main(String[] args) {
        FrameTocador app = new FrameTocador();
        
        app.runApp(arqMidi);
    }
    
}
