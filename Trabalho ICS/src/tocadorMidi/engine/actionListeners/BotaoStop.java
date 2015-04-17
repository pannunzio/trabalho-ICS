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
        ArquivoSingleton obj = ArquivoSingleton.getInstance();
        try {

            obj.setMicrossegundo(null);
            obj.setTick(null);
            obj.getSequenciador().stop();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
