/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package tocadorMidi.engine.classePrincipal;

import java.io.File;
import javax.swing.UIManager;
import tocadorMidi.engine.singletons.ArquivoSingleton;
import tocadorMidi.interfaces.FrameTocador;

/**
 *
 * @author mariana
 */
public class MainClass {
    /**
     * @param args the command line arguments
     */
    
    public static void main(String[] args) {
        ArquivoSingleton.getInstance().initVolume();
        FrameTocador app = new FrameTocador();
        app.runApp();
    }
}
