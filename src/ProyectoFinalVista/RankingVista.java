/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ProyectoFinalVista;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 *
 * @author Oscar
 */
public class RankingVista extends JFrame{
    private Jugador1Menu menu;
    
    private JPanel pSur, pCentro;
    
    private JButton salir;
    private JTextField jugador[];
    private JLabel numeros[];
    private JTextField puntuacion[];
    
    public RankingVista(){
        super("ProyectoFinal: Ranking");
        setLayout(new BorderLayout());
        
        menu = new Jugador1Menu();
        setJMenuBar(menu);
        
        pCentro = new JPanel(); 
        pSur = new JPanel(); 
        
        pCentro.setLayout(new GridLayout(10,3));
        String nombrejugador;
        int puntuacionobtenida;
        
        numeros = new JLabel[11];
        jugador = new JTextField[11];
        puntuacion = new JTextField[11];
        
        for(int i=0 ; i<10 ; i++){
            
            
            String valor = String.valueOf(i+1);
            numeros[i] = new JLabel(valor);
            jugador[i] = new JTextField(10);
            jugador[i].setEditable(false);//Marcamos como no editable para que el jugador no lo pueda editar los nombres
            puntuacion[i] = new JTextField(2);
            puntuacion[i].setEditable(false);//Marcamos como no editable para que el jugador no lo pueda editar la puntuacion
            
            pCentro.add(numeros[i]);
            pCentro.add(jugador[i]);
            pCentro.add(puntuacion[i]);
            
            
        }
        
        pSur = new JPanel();  
        salir = new JButton("Salir");
        salir.setActionCommand("botonSalirRanking");
        pSur.add(salir);
        
        
        add(pSur,BorderLayout.SOUTH);
        add(pCentro, BorderLayout.CENTER);
        
        setVisible(false);
        setSize(700,400);
        
    }
    
    public void setActionListener (ActionListener ae){
        for(int j = 0; j < 10; j++){
            jugador[j].addActionListener(ae);
            puntuacion[j].addActionListener(ae);
        }
        salir.addActionListener(ae);
        
        menu.setActionListener(ae);
    }
    
    public void actualizarRanking(String nombre, int intentos){
        jugador[intentos-1].setText("NOMBRE: " + nombre);
        puntuacion[intentos-1].setText("INTENTOS:" + String.valueOf(intentos));
    }
}
