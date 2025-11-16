package ProyectoFinalVista;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.event.ActionListener;
import javax.swing.*;
import javax.swing.JFrame;
import proyectofinal.ProyectoFinalModel;

/**
 *
 * @author anceron
 */
public class Jugador1Vista extends JFrame {
    private JLabel letrasLabel, palabraLabel;
    private JTextField letrasField, palabraField;
    private JButton confirmar;
    private Jugador1Menu menu;

    //Ventana principal de la aplicacion
    public Jugador1Vista (ProyectoFinalModel m){
        super("ProyectoFinal: Jugador 1");
        
        //setLayout(new BoxLayout(getContentPane(),BoxLayout.Y_AXIS));//En vez de getContentPane habia un this
        setLayout(new FlowLayout(FlowLayout.LEFT));
        
        letrasLabel = new JLabel("Introduzca la cantidad de letras de la palabra(3-5): ");
        add(letrasLabel);
        letrasField = new JTextField();
        letrasField.setColumns(1);
        letrasField.setEditable(true);
        add(letrasField);
        
        palabraLabel = new JLabel("Introduzca la palabra a adivinar: ");
        add(palabraLabel);
        palabraField = new JTextField();
        palabraField.setColumns(10);
        palabraField.setEditable(true);
        add(palabraField);
        
        confirmar = new JButton("Confirmar");
        confirmar.setActionCommand("botonConfirmar1");
        confirmar.setEnabled(true);
        add(confirmar);
        
        menu = new Jugador1Menu();
        setJMenuBar(menu);
        
        setVisible(true);
        setSize(400,200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    
    public void setActionListener (ActionListener ae){
        letrasField.addActionListener(ae);
        palabraField.addActionListener(ae);
        confirmar.addActionListener(ae);
        
        menu.setActionListener(ae);
    }
    
    //Funcion que devuelvela palabra introducida por el usuaio
    public String getPalabra(){
        return palabraField.getText();
    }
    
    //Funcion que devuelve el numero de letras introducido por el usuario
    public int getNumeroLetras(){
        return Integer.parseInt(letrasField.getText());
    }
}
