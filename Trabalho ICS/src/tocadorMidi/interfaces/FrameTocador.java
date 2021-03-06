/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tocadorMidi.interfaces;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.concurrent.Task;
import javax.sound.midi.InvalidMidiDataException;
import javax.sound.midi.MidiUnavailableException;
import javax.sound.midi.ShortMessage;
import javax.swing.Action;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JProgressBar;
import javax.swing.JSlider;
import javax.swing.SwingWorker;
import javax.swing.UIManager;
import javax.swing.event.ChangeEvent;
import tocadorMidi.engine.actionListeners.BotaoPause;
import tocadorMidi.engine.actionListeners.BotaoPlay;
import tocadorMidi.engine.actionListeners.BotaoStop;
import tocadorMidi.engine.singletons.ArquivoSingleton;

/**
 *
 * @author mariana
 */
public class FrameTocador extends javax.swing.JFrame{

    /**
     * Creates new form FrameTocadoe
     */
    public FrameTocador() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        bindingGroup = new org.jdesktop.beansbinding.BindingGroup();

        jFrame1 = new javax.swing.JFrame();
        labelFaixa = new javax.swing.JLabel();
        labelNomeDaFaixa = new javax.swing.JLabel();
        botaoPlay = new javax.swing.JButton();
        botaoPause = new javax.swing.JButton();
        botaoStop = new javax.swing.JButton();
        sliderVolume = new javax.swing.JSlider();
        labelFormulaCompasso = new javax.swing.JLabel();
        labelMetro = new javax.swing.JLabel();
        labelAndamento = new javax.swing.JLabel();
        labelArmaduraTonalidade = new javax.swing.JLabel();
        labelValorCompasso = new javax.swing.JLabel();
        labelValorMetro = new javax.swing.JLabel();
        labelValorAndamento = new javax.swing.JLabel();
        labelValorTonalidade = new javax.swing.JLabel();
        abrirMidi = new javax.swing.JButton();
        labelTempoMusica = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        labelInstanteMusica = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        panel1 = new javax.swing.JPanel();
        panel = new javax.swing.JPanel();
        progressoAudio = new javax.swing.JProgressBar();

        javax.swing.GroupLayout jFrame1Layout = new javax.swing.GroupLayout(jFrame1.getContentPane());
        jFrame1.getContentPane().setLayout(jFrame1Layout);
        jFrame1Layout.setHorizontalGroup(
            jFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        jFrame1Layout.setVerticalGroup(
            jFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });

        labelFaixa.setText("Faixa: ");

        labelNomeDaFaixa.setText("nome_do_arquivo.mid");

        org.jdesktop.beansbinding.Binding binding = org.jdesktop.beansbinding.Bindings.createAutoBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ_WRITE, labelNomeDaFaixa, org.jdesktop.beansbinding.ELProperty.create("${selected}"), labelNomeDaFaixa, org.jdesktop.beansbinding.BeanProperty.create("labelFor"));
        bindingGroup.addBinding(binding);

        botaoPlay.setText("Play");
        botaoPlay.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                botaoPlayMouseClicked(evt);
            }
        });
        botaoPlay.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botaoPlayActionPerformed(evt);
            }
        });

        botaoPause.setText("Pause");
        botaoPause.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                botaoPauseMouseClicked(evt);
            }
        });

        botaoStop.setText("Stop");
        botaoStop.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                botaoStopMouseClicked(evt);
            }
        });

        binding = org.jdesktop.beansbinding.Bindings.createAutoBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ_WRITE, sliderVolume, org.jdesktop.beansbinding.ELProperty.create("${value}"), sliderVolume, org.jdesktop.beansbinding.BeanProperty.create("value"));
        bindingGroup.addBinding(binding);

        sliderVolume.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                sliderVolumeStateChanged(evt);
            }
        });

        labelFormulaCompasso.setText("Formula de Compasso: ");

        labelMetro.setText("Metro: ");

        labelAndamento.setText("Andamento: ");

        labelArmaduraTonalidade.setText("Armadura de Tonalidade: ");

        labelValorCompasso.setText("compasso");
        labelValorCompasso.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                labelValorCompassoPropertyChange(evt);
            }
        });

        labelValorMetro.setText("metro");
        labelValorMetro.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                labelValorMetroPropertyChange(evt);
            }
        });

        labelValorAndamento.setText("andamento");

        labelValorTonalidade.setText("tonalidade");

        abrirMidi.setText("Abrir MIDI");

        binding = org.jdesktop.beansbinding.Bindings.createAutoBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ_WRITE, abrirMidi, org.jdesktop.beansbinding.ELProperty.create("${selected}"), abrirMidi, org.jdesktop.beansbinding.BeanProperty.create("selected"));
        bindingGroup.addBinding(binding);

        abrirMidi.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                abrirMidiFocusGained(evt);
            }
        });
        abrirMidi.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                abrirMidiMouseClicked(evt);
            }
        });

        labelTempoMusica.setText("00:00:00");

        jLabel2.setText("/");

        labelInstanteMusica.setText("00:00:00");

        jLabel1.setText("Volume: ");

        binding = org.jdesktop.beansbinding.Bindings.createAutoBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ_WRITE, panel1, org.jdesktop.beansbinding.ELProperty.create("${background}"), panel1, org.jdesktop.beansbinding.BeanProperty.create("background"));
        bindingGroup.addBinding(binding);

        javax.swing.GroupLayout panel1Layout = new javax.swing.GroupLayout(panel1);
        panel1.setLayout(panel1Layout);
        panel1Layout.setHorizontalGroup(
            panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        panel1Layout.setVerticalGroup(
            panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 24, Short.MAX_VALUE)
        );

        progressoAudio.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                progressoAudioPropertyChange(evt);
            }
        });

        javax.swing.GroupLayout panelLayout = new javax.swing.GroupLayout(panel);
        panel.setLayout(panelLayout);
        panelLayout.setHorizontalGroup(
            panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(progressoAudio, javax.swing.GroupLayout.PREFERRED_SIZE, 387, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        panelLayout.setVerticalGroup(
            panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(progressoAudio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(panel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(panel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(313, 313, 313)
                        .addComponent(abrirMidi))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(287, 287, 287)
                        .addComponent(labelInstanteMusica, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(labelTempoMusica, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(labelFaixa)
                                .addGap(18, 18, 18)
                                .addComponent(labelNomeDaFaixa, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(botaoPlay)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(botaoPause)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(botaoStop)
                                .addGap(78, 78, 78)
                                .addComponent(jLabel1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(sliderVolume, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(labelAndamento)
                                    .addComponent(labelArmaduraTonalidade)
                                    .addComponent(labelFormulaCompasso)
                                    .addComponent(labelMetro))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(2, 2, 2)
                                        .addComponent(labelValorCompasso, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                    .addComponent(labelValorMetro, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(labelValorAndamento, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(labelValorTonalidade, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(panel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(panel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labelFaixa)
                    .addComponent(labelNomeDaFaixa))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labelTempoMusica)
                    .addComponent(jLabel2)
                    .addComponent(labelInstanteMusica))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.TRAILING)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(botaoPlay)
                                    .addComponent(botaoPause)
                                    .addComponent(botaoStop)))
                            .addComponent(sliderVolume, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(labelFormulaCompasso)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(labelMetro)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(labelAndamento)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(labelArmaduraTonalidade))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(labelValorCompasso)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(labelValorMetro)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(labelValorAndamento)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(labelValorTonalidade)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(abrirMidi)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        bindingGroup.bind();

        pack();
    }// </editor-fold>//GEN-END:initComponents

    public void runApp() {
        UIManager.put("swing.boldMetal", Boolean.FALSE);;
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FrameTocador().setVisible(true);
            }
        });
    }

    private void labelValorCompassoPropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_labelValorCompassoPropertyChange

    }//GEN-LAST:event_labelValorCompassoPropertyChange

    private void labelValorMetroPropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_labelValorMetroPropertyChange
        // TODO add your handling code here:
    }//GEN-LAST:event_labelValorMetroPropertyChange

    private void botaoPlayMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_botaoPlayMouseClicked
        ArquivoSingleton instance = ArquivoSingleton.getInstance();
        if (instance.getArqMidi() != null) {
            botaoPlay.setEnabled(false);
            botaoPause.setEnabled(true);
            botaoStop.setEnabled(true);

            BotaoPlay acao = new BotaoPlay();

            try {
                acao.play();
                instance.configuraVolume();
                instance.inicializaVolume();
            } catch (InvalidMidiDataException ex) {
                Logger.getLogger(FrameTocador.class.getName()).log(Level.SEVERE, null, ex);
            } catch (IOException ex) {
                Logger.getLogger(FrameTocador.class.getName()).log(Level.SEVERE, null, ex);
            } catch (MidiUnavailableException ex) {
                Logger.getLogger(FrameTocador.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_botaoPlayMouseClicked

  
    private void botaoPauseMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_botaoPauseMouseClicked
        if (ArquivoSingleton.getInstance().getArqMidi() != null) {
            botaoPlay.setEnabled(true);
            botaoPause.setEnabled(false);
            botaoStop.setEnabled(false);
        }

        BotaoPause acao = new BotaoPause();
        acao.Pause();

    }//GEN-LAST:event_botaoPauseMouseClicked

    private void botaoStopMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_botaoStopMouseClicked
        if (ArquivoSingleton.getInstance().getArqMidi() != null) {
            botaoPlay.setEnabled(true);
            botaoPause.setEnabled(false);
            botaoStop.setEnabled(false);
        }

        BotaoStop acao = new BotaoStop();
        acao.Stop();
    }//GEN-LAST:event_botaoStopMouseClicked

    private void abrirMidiMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_abrirMidiMouseClicked
        VisualizaArquivo abrir = new VisualizaArquivo(this, rootPaneCheckingEnabled);
        abrir.run();
    }//GEN-LAST:event_abrirMidiMouseClicked

    private void sliderVolumeStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_sliderVolumeStateChanged
        ArquivoSingleton instance = ArquivoSingleton.getInstance();
        JSlider source = (JSlider) evt.getSource();
        if (instance.getIsTocando()) {
            instance.inicializaVolume();
            if (!source.getValueIsAdjusting()) {
                int valor = (int) source.getValue();
                ShortMessage mensagemDeVolume = new ShortMessage();
                for (int i = 0; i < 16; i++) {
                    try {
                        mensagemDeVolume.setMessage(ShortMessage.CONTROL_CHANGE, i, 7, valor);
                        instance.getReceptor().send(mensagemDeVolume, -1);
                    } catch (InvalidMidiDataException e) {
                        e.printStackTrace();
                    }
                }
                ArquivoSingleton.getInstance().setVolumeAtual(valor);
            }
        }
    }//GEN-LAST:event_sliderVolumeStateChanged

    private void abrirMidiFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_abrirMidiFocusGained
        ArquivoSingleton instance = ArquivoSingleton.getInstance();
        if (instance.getArqMidi() != null) {
            try {
                instance.initMidi();
                instance.tempoTotalMusica();
                labelNomeDaFaixa.setText(instance.getArqMidi().getName());
                labelTempoMusica.setText(instance.tempoEmString(instance.getTempoMusica()));
                
                float duracao = instance.getSequencia().getMicrosecondLength()/1000000;
                int  resolucao   = instance.getSequencia().getResolution();
	        long totaltiques = instance.getSequenciador().getTickLength();
                
                float durtique       = (float)duracao/totaltiques;
	        float durseminima    = durtique*resolucao;
	        float bpm            = 60/durseminima;
	        int   totalseminimas = (int)(duracao/durseminima);
                
                labelValorMetro.setText(String.valueOf(bpm));
                labelValorAndamento.setText(String.valueOf(Math.round(bpm)));
                labelValorTonalidade.setText(ArquivoSingleton.getTonalidade(instance.getSequencia().getTracks()[0]));
                
            } catch (InvalidMidiDataException ex) {
                Logger.getLogger(FrameTocador.class.getName()).log(Level.SEVERE, null, ex);
            } catch (IOException ex) {
                Logger.getLogger(FrameTocador.class.getName()).log(Level.SEVERE, null, ex);
            } catch (MidiUnavailableException ex) {
                Logger.getLogger(FrameTocador.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_abrirMidiFocusGained

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        if (ArquivoSingleton.getInstance().getArqMidi() != null) {
            ArquivoSingleton.getInstance().closeMidi();
            System.out.println("close Midi");
        }
    }//GEN-LAST:event_formWindowClosing

    private void botaoPlayActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botaoPlayActionPerformed
        BarraProgresso progresso = new BarraProgresso();
        progresso.actionPerformed(evt);
    }//GEN-LAST:event_botaoPlayActionPerformed

    private void progressoAudioPropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_progressoAudioPropertyChange
        if ("progress" == evt.getPropertyName()) {
            int progress = (Integer) evt.getNewValue();
            progressoAudio.setValue(progress);
        }
    }//GEN-LAST:event_progressoAudioPropertyChange

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton abrirMidi;
    private javax.swing.JButton botaoPause;
    private javax.swing.JButton botaoPlay;
    private javax.swing.JButton botaoStop;
    private javax.swing.JFrame jFrame1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel labelAndamento;
    private javax.swing.JLabel labelArmaduraTonalidade;
    private javax.swing.JLabel labelFaixa;
    private javax.swing.JLabel labelFormulaCompasso;
    private javax.swing.JLabel labelInstanteMusica;
    private javax.swing.JLabel labelMetro;
    private javax.swing.JLabel labelNomeDaFaixa;
    private javax.swing.JLabel labelTempoMusica;
    private javax.swing.JLabel labelValorAndamento;
    private javax.swing.JLabel labelValorCompasso;
    private javax.swing.JLabel labelValorMetro;
    private javax.swing.JLabel labelValorTonalidade;
    private javax.swing.JPanel panel;
    private javax.swing.JPanel panel1;
    private javax.swing.JProgressBar progressoAudio;
    private javax.swing.JSlider sliderVolume;
    private org.jdesktop.beansbinding.BindingGroup bindingGroup;
    // End of variables declaration//GEN-END:variables

    class BarraProgresso extends JPanel
            implements ActionListener,
            PropertyChangeListener {

        private JProgressBar progressoAudio;
        private Task task;

        class Task extends SwingWorker<Void, Void> {

            @Override
            public Void doInBackground() {
                ArquivoSingleton instance = ArquivoSingleton.getInstance();
                int progress = 0;
                int total = (int) (instance.getSequenciador().getMicrosecondLength()) / 1000;
                int parcial = 0;
                
                setProgress(0);
                if (instance.getArqMidi() != null) {
                    while (progress <= 100) {
                        try {
                            Thread.sleep(1000);
                            labelInstanteMusica.setText(instance.tempoEmString(instance.tempoAtualMusica()));
                        } catch (InterruptedException e) {
                            System.out.println("Interrupted Exception");
                        }
                        parcial = (int) (instance.getSequenciador().getMicrosecondPosition()) / 10;
                        progress = parcial / total;
                        setProgress(Math.min(progress, 100));
                        progressoAudio.updateUI();
                    }
                }
                return null;
            }
        }

        public BarraProgresso() {
            super(new BorderLayout());

            progressoAudio = new JProgressBar(0, 100);
            progressoAudio.setValue(0);

            JPanel panel = new JPanel();
            panel.add(progressoAudio);

            add(panel, BorderLayout.PAGE_START);
            setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

            panel.setVisible(true);

        }
        
        public void actionPerformed(ActionEvent evt) {
            taskMaker();
        }
        
        public void propertyChange(PropertyChangeEvent evt) {
            progressoAudioPropertyChange(evt);
        }

        public void taskMaker() {
            task = new Task();
            task.addPropertyChangeListener(this);
            task.execute();
        }

        private JPanel createAndShowGUI() {
     
            JComponent newContentPane = new BarraProgresso();
            newContentPane.setOpaque(true);
            return (JPanel) newContentPane;
        }

        public JPanel start() {
            return createAndShowGUI();
        }
    }
}
