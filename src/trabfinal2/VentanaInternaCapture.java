/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package trabfinal2;

import java.awt.Component;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.util.List;
import javax.media.Buffer;
import javax.media.CaptureDeviceInfo;
import javax.media.CaptureDeviceManager;
import javax.media.Manager;
import javax.media.MediaLocator;
import javax.media.Player;
import javax.media.control.FrameGrabbingControl;
import javax.media.format.VideoFormat;
import javax.media.format.YUVFormat;
import javax.media.util.BufferToImage;

/**
 *
 * @author carla
 */
public class VentanaInternaCapture extends javax.swing.JInternalFrame {
     public VentanaPrincipal parent=null;
    private Object contenedor;
     private Player player = null;
    /**
     * Creates new form VentanaInternaCapture
     * @param v
     */
    public VentanaInternaCapture(VentanaPrincipal v) {
        this.parent=v;
       
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

        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setResizable(true);

        pack();
    }// </editor-fold>//GEN-END:initComponents
    public void play() {
        try {
            CaptureDeviceInfo deviceInfo;
            List<CaptureDeviceInfo> deviceList
                    = CaptureDeviceManager.getDeviceList(new YUVFormat());
            deviceInfo = deviceList.get(0);
            MediaLocator ml = deviceInfo.getLocator();
            player = Manager.createRealizedPlayer(ml);
            Component areaVisual = player.getVisualComponent();
            if (areaVisual != null) {
              // contenedor.add(areaVisual);
            }
            Component panelControl = player.getControlPanelComponent();
            if (panelControl != null) {
               // contenedor.add(panelControl);
            }
            player.start();
        } catch (Exception e) {
            System.out.println("Error"+e);
        }
    }
    
    /**
     * Gets a BufferedImage from Player
     * @param player
     * @return BufferdImage
     */
    public BufferedImage getFrame(Player player) {
        FrameGrabbingControl fgc;
        String claseCtr = "javax.media.control.FrameGrabbingControl ";
        fgc = (FrameGrabbingControl) player.getControl(claseCtr);
        Buffer bufferFrame = fgc.grabFrame();
        BufferToImage bti;
        bti = new BufferToImage((VideoFormat) bufferFrame.getFormat());
        Image img = bti.createImage(bufferFrame);
        return (BufferedImage) img;
    }
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}
