/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ProyectoFinalVista;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextArea;

/**
 *
 * @author Oscar
 */
public class InformacionView extends JFrame {
    private JLabel autores;
    
    public InformacionView (){
        super("Informacion");

        this.setSize(600,300);
        
        autores = new JLabel("Los autores son Óscar y Ángel.");
        add(autores);
                
        this.setVisible(false);
    }
}
