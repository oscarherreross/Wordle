package ProyectoFinalVista;

import java.awt.event.ActionListener;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

/**
 *
 * @author Oscar
 */
public class Jugador1Menu extends JMenuBar{
    private JMenu opciones, acercaDe;
    private JMenuItem jugar, ranking, salir, info; 
    
    public Jugador1Menu (){
        opciones = new JMenu("Opciones");
        jugar = new JMenuItem("Jugar");//Muestra la ventana del jugador 2 (el juego en sí)
        jugar.setActionCommand("itemJugar");
        ranking = new JMenuItem("Ranking");//Muestra la ventana ranking
        ranking.setActionCommand("itemRanking");
        salir = new JMenuItem("Salir");//Cierra la ventana
        salir.setActionCommand("itemSalir");
        
        opciones.add(jugar);
        opciones.add(ranking);
        opciones.add(salir);
        
        add(opciones);
        
        acercaDe = new JMenu("Acerca de");//Muestra informacion sobre los autores
        info = new JMenuItem("Informacion");
        info.setActionCommand("itemInformacion");
        acercaDe.add(info);
        add(acercaDe); 
    }
    
    public void setActionListener(ActionListener ae){
        jugar.addActionListener(ae);
        ranking.addActionListener(ae);
        salir.addActionListener(ae);
        
        info.addActionListener(ae);
    }
}
