/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tocadorMidi.interfaces;

import java.awt.event.WindowEvent;
import java.io.File;
import javax.swing.JFileChooser;
import javax.swing.filechooser.FileFilter;
import javax.swing.filechooser.FileNameExtensionFilter;
import tocadorMidi.engine.actionListeners.BotaoPlay;
import tocadorMidi.engine.classePrincipal.MainClass;
import tocadorMidi.engine.singletons.ArquivoSingleton;
import tocadorMidi.engine.tocaMidi.tocaMidi;

/**
 *
 * @author mqueiroz
 */
public class VisualizaArquivo extends javax.swing.JDialog {   
    public VisualizaArquivo(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        bindingGroup = new org.jdesktop.beansbinding.BindingGroup();

        abrirArq = new javax.swing.JFileChooser();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        abrirArq.setAutoscrolls(true);
        abrirArq.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        org.jdesktop.beansbinding.Binding binding = org.jdesktop.beansbinding.Bindings.createAutoBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ_WRITE, abrirArq, org.jdesktop.beansbinding.ELProperty.create("${acceptAllFileFilterUsed}"), abrirArq, org.jdesktop.beansbinding.BeanProperty.create("acceptAllFileFilterUsed"));
        bindingGroup.addBinding(binding);
        binding = org.jdesktop.beansbinding.Bindings.createAutoBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ_WRITE, abrirArq, org.jdesktop.beansbinding.ELProperty.create("${approveButtonText}"), abrirArq, org.jdesktop.beansbinding.BeanProperty.create("approveButtonText"));
        bindingGroup.addBinding(binding);
        binding = org.jdesktop.beansbinding.Bindings.createAutoBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ_WRITE, abrirArq, org.jdesktop.beansbinding.ELProperty.create("${controlButtonsAreShown}"), abrirArq, org.jdesktop.beansbinding.BeanProperty.create("controlButtonsAreShown"));
        bindingGroup.addBinding(binding);
        binding = org.jdesktop.beansbinding.Bindings.createAutoBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ_WRITE, abrirArq, org.jdesktop.beansbinding.ELProperty.create("${currentDirectory}"), abrirArq, org.jdesktop.beansbinding.BeanProperty.create("currentDirectory"));
        bindingGroup.addBinding(binding);
        binding = org.jdesktop.beansbinding.Bindings.createAutoBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ, abrirArq, org.jdesktop.beansbinding.ELProperty.create("${fileFilter}"), abrirArq, org.jdesktop.beansbinding.BeanProperty.create("fileFilter"));
        bindingGroup.addBinding(binding);
        binding = org.jdesktop.beansbinding.Bindings.createAutoBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ_WRITE, abrirArq, org.jdesktop.beansbinding.ELProperty.create("${fileHidingEnabled}"), abrirArq, org.jdesktop.beansbinding.BeanProperty.create("fileHidingEnabled"));
        bindingGroup.addBinding(binding);
        binding = org.jdesktop.beansbinding.Bindings.createAutoBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ_WRITE, abrirArq, org.jdesktop.beansbinding.ELProperty.create("${fileSelectionMode}"), abrirArq, org.jdesktop.beansbinding.BeanProperty.create("fileSelectionMode"));
        bindingGroup.addBinding(binding);
        binding = org.jdesktop.beansbinding.Bindings.createAutoBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ_WRITE, abrirArq, org.jdesktop.beansbinding.ELProperty.create("${fileView}"), abrirArq, org.jdesktop.beansbinding.BeanProperty.create("fileView"));
        bindingGroup.addBinding(binding);
        binding = org.jdesktop.beansbinding.Bindings.createAutoBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ_WRITE, abrirArq, org.jdesktop.beansbinding.ELProperty.create("${selectedFile}"), abrirArq, org.jdesktop.beansbinding.BeanProperty.create("selectedFile"));
        bindingGroup.addBinding(binding);

        abrirArq.addAncestorListener(new javax.swing.event.AncestorListener() {
            public void ancestorMoved(javax.swing.event.AncestorEvent evt) {
            }
            public void ancestorAdded(javax.swing.event.AncestorEvent evt) {
            }
            public void ancestorRemoved(javax.swing.event.AncestorEvent evt) {
                abrirArqAncestorRemoved(evt);
            }
        });
        abrirArq.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                abrirArqActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(abrirArq, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(abrirArq, javax.swing.GroupLayout.DEFAULT_SIZE, 444, Short.MAX_VALUE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        FileFilter filtro = new FileNameExtensionFilter("Arquivos MIDI", "mid");
        abrirArq.setFileFilter(filtro);

        bindingGroup.bind();

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void abrirArqActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_abrirArqActionPerformed
        if(evt.getActionCommand().startsWith("Approve")){
            ArquivoSingleton obj = ArquivoSingleton.getInstance();
            obj.setArqMidi(abrirArq.getSelectedFile());
        }
        this.dispose();
    }//GEN-LAST:event_abrirArqActionPerformed

    private void abrirArqAncestorRemoved(javax.swing.event.AncestorEvent evt) {//GEN-FIRST:event_abrirArqAncestorRemoved
        
    }//GEN-LAST:event_abrirArqAncestorRemoved
    
    public void run() {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                VisualizaArquivo dialog = new VisualizaArquivo(new javax.swing.JFrame(), true);
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                    @Override
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        this.windowClosed(e);
                    }
                });
                dialog.setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JFileChooser abrirArq;
    private org.jdesktop.beansbinding.BindingGroup bindingGroup;
    // End of variables declaration//GEN-END:variables
}
