/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package tocadorMidi.engine.classePrincipal;

import javax.swing.UIManager;
import tocadorMidi.engine.beans.ArquivoMidi;
import tocadorMidi.interfaces.FrameTocador;

/**
 *
 * @author mariana
 */
public class MainClass {
    private ArquivoMidi arqMidi;

    public ArquivoMidi getArqMidi() {
        return arqMidi;
    }

    public void setArqMidi(ArquivoMidi arqMidi) {
        this.arqMidi = arqMidi;
    }
    /**
     * @param args the command line arguments
     */
    
    public static void main(String[] args) {
        UIManager.put("swing.boldMetal", Boolean.FALSE); 
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FrameTocador().setVisible(true);
            }
        });
    }
    
}
