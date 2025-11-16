package proyectofinal;

import ProyectoFinalVista.InformacionView;
import ProyectoFinalVista.Jugador1Vista;
import ProyectoFinalVista.Jugador2Vista;
import ProyectoFinalVista.RankingVista;

/**
 *
 * @author Oscar
 */

public class ProyectoFinal {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        ProyectoFinalModel m = new ProyectoFinalModel(); 
        InformacionView iv = new InformacionView();
        Jugador1Vista j1v = new Jugador1Vista(m);
        Jugador2Vista j2v = new Jugador2Vista(j1v, m);
        RankingVista rv = new RankingVista();

        ProyectoFinalController controller = new ProyectoFinalController(m,j1v,j2v,rv, iv);
        
        j1v.setVisible(true);
   }
}
