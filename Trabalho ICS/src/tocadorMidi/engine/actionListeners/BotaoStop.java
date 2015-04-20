/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tocadorMidi.engine.actionListeners;

import tocadorMidi.engine.singletons.ArquivoSingleton;

/**
 *
 * @author mariana
 */
public class BotaoStop {

    public BotaoStop() {
    }

    public void Stop() {
        ArquivoSingleton instance = ArquivoSingleton.getInstance();
        try {

            instance.setMicrossegundo(null);
            instance.getSequenciador().stop();
            instance.setIsTocando(Boolean.FALSE);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
