package ProyectoFinalVista;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.BoxLayout;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import proyectofinal.ProyectoFinalModel;

/**
 *
 * @author Oscar
 */
public class Jugador2Vista extends JFrame{
    private Jugador1Menu menu;
    private JPanel pNorte, pSur, pCentro;
    private JButton salir, confirmar;
    private JLabel nIntentos;
    private JTextField nIntentos_;
    private JTextField casillas[], m;
    private JLabel casillas2[];
    private int cantidadLetras;//Variable que almacenala cantida de letras
    private String palabra;//Variable para almacenar la palabra introducida por el usuario
    private int intentos = 8;
    private boolean mostrarRanking = false;
    
    private Jugador1Vista j1v;
    private ProyectoFinalModel mo;
    
    public Jugador2Vista (Jugador1Vista j1v, ProyectoFinalModel mo){
        super("ProyectoFinal: Jugador 2");
           
        this.mo = mo;
        this.j1v = j1v;
        setLayout(new BorderLayout());
        
        menu = new Jugador1Menu();
        setJMenuBar(menu);
        
        //Panel que contendra algo de informacion (numero de intentos...)
        pNorte = new JPanel(); 
        nIntentos = new JLabel ("Numero de intentos: ");
        nIntentos_ = new JTextField(2);
        nIntentos_.setEditable(false);
        pNorte.add(nIntentos);
        pNorte.add(nIntentos_);
        
        //Panel que contendra el boton de salir
        pSur = new JPanel();
        confirmar = new JButton("Confirmar");
        confirmar.setActionCommand("botonConfirmar2");
        salir = new JButton("Salir");
        salir.setActionCommand("botonSalir");
        pSur.add(confirmar);
        pSur.add(salir);
        
        pCentro = new JPanel();
        pCentro.setLayout(new GridLayout(8,cantidadLetras));
        
        add(pNorte, BorderLayout.NORTH);
        add(pSur,BorderLayout.SOUTH);
        add(pCentro, BorderLayout.CENTER);
        
        setVisible(false);
        setSize(400,500);
    }
    
    public void setActionListener(ActionListener ae){
        salir.addActionListener(ae); 
        confirmar.addActionListener(ae);
        
        menu.setActionListener(ae);
    }
    
    public void crearCasillas(){
        casillas = new JTextField [mo.getLongitudPalabra()*8];
        for(int i = 0; i < mo.getLongitudPalabra()*8; i++){
            casillas[i] = new JTextField(1);
            pCentro.add(casillas[i]);
        }
    }
    
    public void restaurarCasillas(){
        for(int i = 0; i < mo.getLongitudPalabra()*8; i++){
            pCentro.remove(casillas[i]);
        }
    }
    
    public void actualizarIntentos(){
        nIntentos_.setText(String.valueOf(mo.getIntentos()));
    }
    
    public void setLetrasPalabra(){
        cantidadLetras = mo.getLongitudPalabra();
    }
    
    
    //Funcion que asigna la palabra a la variable palabra
    public void setPalabra(){
        palabra = mo.getPalabraParaAdivinar();
    }
    
    //Funcion para comprobar si las letras introducidas en las casillas se corresponden con las de la palabra
    public void comprobarCasillas(){
        int aciertos = 0;
        int inicio = 0, fin = 0;                            //Variables que almacenan el inicio y fin del indice de correccion de las casillas en cada intento
        
        
        if(mo.getIntentos() == 0){
            if(mo.getLongitudPalabra() == 3){
                //Comparar la posicion i con i+3
                inicio = 0;
                fin = 2;
            }
            else if (mo.getLongitudPalabra() == 4){
                //Comparar la posicion i con i+4
                inicio = 0;
                fin = 3;
            }
            else if(mo.getLongitudPalabra() == 5){
                //Comparar la posicion i con i+5
                inicio = 0;
                fin = 4;
            }
        }
        else if (mo.getIntentos() == 1){
            if(mo.getLongitudPalabra() == 3){
                //Comparar la posicion i con i+3
                inicio = 3;
                fin = 5;
            }
            else if (mo.getLongitudPalabra() == 4){
                //Comparar la posicion i con i+4
                inicio = 4;
                fin = 7;
            }
            else if(mo.getLongitudPalabra() == 5){
                //Comparar la posicion i con i+5
                inicio = 5;
                fin = 9;
            }
        }
        else if (mo.getIntentos() == 2){
            if(mo.getLongitudPalabra() == 3){
                //Comparar la posicion i con i+3
                inicio = 6;
                fin = 8;
            }
            else if (mo.getLongitudPalabra() == 4){
                //Comparar la posicion i con i+4
                inicio = 8;
                fin = 11;
            }
            else if(mo.getLongitudPalabra() == 5){
                //Comparar la posicion i con i+5
                inicio = 10;
                fin = 14;
            }
        }
        else if (mo.getIntentos() == 3){
            if(mo.getLongitudPalabra() == 3){
                //Comparar la posicion i con i+3
                inicio = 9;
                fin = 11;
            }
            else if (mo.getLongitudPalabra() == 4){
                //Comparar la posicion i con i+4
                inicio = 12;
                fin = 15;
            }
            else if(mo.getLongitudPalabra() == 5){
                //Comparar la posicion i con i+5
                inicio = 15;
                fin = 19;
            }
        }
        else if(mo.getIntentos() == 4){
            if(mo.getLongitudPalabra() == 3){
                //Comparar la posicion i con i+3
                inicio = 12;
                fin = 14;
            }
            else if (mo.getLongitudPalabra() == 4){
                //Comparar la posicion i con i+4
                inicio = 16;
                fin = 19;
            }
            else if(mo.getLongitudPalabra() == 5){
                //Comparar la posicion i con i+5
                inicio = 20;
                fin = 24;
            }
        }
        else if (mo.getIntentos() == 5){
            if(mo.getLongitudPalabra() == 3){
                //Comparar la posicion i con i+3
                inicio = 15;
                fin = 17;
            }
            else if (mo.getLongitudPalabra() == 4){
                //Comparar la posicion i con i+4
                inicio = 20;
                fin = 23;
            }
            else if(mo.getLongitudPalabra() == 5){
                //Comparar la posicion i con i+5
                inicio = 25;
                fin = 29;
            }
        }
        else if (mo.getIntentos() == 6){
            if(mo.getLongitudPalabra() == 3){
                //Comparar la posicion i con i+3
                inicio = 18;
                fin = 20;
            }
            else if (mo.getLongitudPalabra() == 4){
                //Comparar la posicion i con i+4
                inicio = 24;
                fin = 27;
            }
            else if(mo.getLongitudPalabra() == 5){
                //Comparar la posicion i con i+5
                inicio = 30;
                fin = 34;
            }
        }
        else if (mo.getIntentos() == 7){
            if(mo.getLongitudPalabra() == 3){
                //Comparar la posicion i con i+3
                inicio = 21;
                fin = 23;
            }
            else if (mo.getLongitudPalabra() == 4){
                //Comparar la posicion i con i+4
                inicio = 28;
                fin = 31;
            }
            else if(mo.getLongitudPalabra() == 5){
                //Comparar la posicion i con i+5
                inicio = 35;
                fin = 39;
            }
        }
        
        //Esta es la que mejor funciona por ahora
        for(int j = inicio; j <= fin; j++){                                     //Recorre todas las celdas(j)
            for (int i = 0; i < mo.getLongitudPalabra(); i++){
                char au = mo.getPalabraParaAdivinar().charAt(i);
                
                char casilla = casillas[j].getText().charAt(0);
                if (casilla == au){                //Si la letra introducida coincide con la que hay en la palabra 
                    if (i == j || (i + mo.getLongitudPalabra()* mo.getIntentos()) == j || i * mo.getIntentos() == j){                                                //Si la letra introducida coincida con la de la palabra y estan en la misma posicion
                        casillas[j].setBackground(Color.green);              //Pone el fondo de la casilla en verde
                        aciertos++;
                    }
                    else{
                        casillas[j].setBackground(Color.yellow);//Pone el fondo de la casilla en amarillo
                    }
                }
                else{
                    //casillas[j].setBackground(Color.gray);//Pone el fondo de la casilla en gris
                }
                casillas[j].setEditable(false);     
            }
        }
        if(aciertos == mo.getLongitudPalabra()){
            mo.Victoria();
            mostrarRanking = true;
        }
        else if (mo.getIntentos() > 6){
            mo.Derrota();
            mostrarRanking = true;
        }
    }
    
    //Funcion que devuelve cuando tenemos que mostrar el ranking (true = si, false = no)
    public boolean getMostrarRanking(){
        return mostrarRanking;
    }
}
