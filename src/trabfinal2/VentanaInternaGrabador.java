/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package trabfinal2;

import java.io.File;
import javax.sound.sampled.LineEvent;
import javax.sound.sampled.LineListener;
import sm.sound.SMSoundRecorder;

/**
 *
 * @author carla
 */
public class VentanaInternaGrabador extends javax.swing.JInternalFrame {
    SMSoundRecorder recorder;
    File f1;
    /**
     * Creates new form VentanaInternaGrabador
     * @param f
     */
    public VentanaInternaGrabador(File f) {
        initComponents();
        recorder= new SMSoundRecorder(f);
        recorder.setLineListener(new ManejadorAudio());
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jMenuBar2 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenu2 = new javax.swing.JMenu();
        jPanel1 = new javax.swing.JPanel();
        grabar = new javax.swing.JButton();
        stopG = new javax.swing.JButton();
        jMenuBar1 = new javax.swing.JMenuBar();

        jMenu1.setText("File");
        jMenuBar2.add(jMenu1);

        jMenu2.setText("Edit");
        jMenuBar2.add(jMenu2);

        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setResizable(true);

        jPanel1.setLayout(new java.awt.GridLayout(1, 0));

        grabar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/RecordPressed_48x48.png"))); // NOI18N
        grabar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                grabarActionPerformed(evt);
            }
        });
        jPanel1.add(grabar);

        stopG.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/StopDisabled_48x48.png"))); // NOI18N
        stopG.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                stopGActionPerformed(evt);
            }
        });
        jPanel1.add(stopG);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void grabarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_grabarActionPerformed
        if(recorder!=null) recorder.record();
    }//GEN-LAST:event_grabarActionPerformed

    private void stopGActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_stopGActionPerformed
        if(recorder!=null) recorder.stop();
    }//GEN-LAST:event_stopGActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton grabar;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuBar jMenuBar2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JButton stopG;
    // End of variables declaration//GEN-END:variables
 public class ManejadorAudio implements LineListener {
        /**
         * create ManejadorAudio
         */
        public ManejadorAudio() {
            super();
        }
        String appdata = System.getenv("iconos");
        String playDis = appdata + "\\PlayDisabled_48x48.png";
        File icon = new File(playDis);
        String playPres = appdata + "\\PlayPressed_48x48.png";
        String stopPres = appdata + "\\StopPressedBlue_48x48.png";
        String stopDis = appdata + "\\StopDisabled_48x48.png";
        int time=0;
        
        @Override
        public void update(LineEvent event) {
            
            //int length=record.getClip().getFrameLength();
            if (event.getType() == LineEvent.Type.START) {
               
               grabar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/RecordPressed_48x48.png")));
               
               stopG.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/StopDisabled_48x48.png")));
              /* if(time>0 ){
                  grabar.getClip().setFramePosition(time);
               }*/
               //time=player.getClip().getFramePosition();
            }
            if (event.getType() == LineEvent.Type.STOP) {
      
                grabar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/RecordDisabled_48x48.png")));
                
                stopG.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/StopNormalRed_48x48.png")));
                //time=player.getClip().getFramePosition();
            }
            if (event.getType() == LineEvent.Type.CLOSE) {
                //TODO
            }
        }

    }
}