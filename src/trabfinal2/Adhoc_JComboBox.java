/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package trabfinal2;

import java.awt.BorderLayout;
import javax.swing.ImageIcon;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import java.awt.Component;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.ListCellRenderer;



/**
* @author mj144431
*
* TODO To change the template for this generated type comment go to
* Window - Preferences - Java - Code Style - Code Templates
*/
public class Adhoc_JComboBox extends JFrame{

private static JComboBox combobox;
private static String a1;
private static String b2;
private static String c3;
private static String d3;

    /**
     *
     * @param args
     */
    public static void main(String[] args) {
    Adhoc_JComboBox adhoc_JComboBox = new Adhoc_JComboBox();
}

private Adhoc_JComboBox(){
a1 = new String( "a");
b2 = new String( "b");
c3 = new String( "c");
d3 = new String( "d");
combobox = new JComboBox(
new String[] {a1, b2, c3}
);
combobox.setSelectedItem(a1);
combobox.setEditable(false);
setLayout(new FlowLayout());
add(combobox);
combobox.setRenderer(new MyComboBoxRenderer());
JButton button = new JButton("Click");
button.addActionListener(new ActionListener(){
public void actionPerformed(ActionEvent ae){
System.out.println("Action called");
combobox.setSelectedItem(d3);
}
});
add(button);
pack();
setVisible(true);
}
}

class MyComboBoxRenderer extends JLabel implements ListCellRenderer {

public MyComboBoxRenderer(){
setOpaque(false);
}

public Component getListCellRendererComponent(JList list, Object value, int index, boolean isSelected, boolean cellHasFocus) {
setText(value.toString());
setIcon(new ImageIcon("iconos/black.png"));

return this;
}

}