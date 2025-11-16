package proyectofinal;

import ProyectoFinalVista.InformacionView;
import ProyectoFinalVista.Jugador1Vista;
import ProyectoFinalVista.Jugador2Vista;
import ProyectoFinalVista.RankingVista;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

/**
 *
 * @author Oscar
 */
public class ProyectoFinalController {
    private ProyectoFinalModel modelo;
    private Jugador1Vista j1v;
    private Jugador2Vista j2v;
    private RankingVista rv;
    private InformacionView iv;
    
    public ProyectoFinalController(ProyectoFinalModel modelo, Jugador1Vista j1v, Jugador2Vista j2v, RankingVista rv, InformacionView iv){
        this.modelo = modelo;
        this.j1v = j1v;
        this.j2v = j2v;
        this.rv = rv;
        this.iv = iv;
        
        j1v.setActionListener(new ProyectoFinalControllerActionListener());
        j1v.addWindowListener(new ProyectoFinalControllerWindowListener());
        
        j2v.setActionListener(new ProyectoFinalControllerActionListener());
        j2v.addWindowListener(new ProyectoFinalControllerWindowListener());
        
        rv.setActionListener(new ProyectoFinalControllerActionListener());
        rv.addWindowListener(new ProyectoFinalControllerWindowListener());
        
    }
    
    class ProyectoFinalControllerWindowListener extends WindowAdapter{
        @Override
        public void windowClosing(WindowEvent we){
            System.out.println("ProyectoFinal: cerrando ventana");
            System.exit(0);
        }
    }
    
    class ProyectoFinalControllerActionListener implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent ae) {
            String command = ae.getActionCommand();
            
            switch (command){
                //Casos del menu de la ventana del jugador 1
                case "itemSalir":
                    System.out.println("Saliendo...");
                    System.exit(0);
                    break;
                case "itemJugar":
                    System.out.println("ProyectoFinal: Empecemos a jugar");
                    j2v.setVisible(true);
                    break;
                case"itemRanking":
                    System.out.println("ProyectoFinal: Mostrando ranking");
                    rv.setVisible(true);
                    break;
                case "itemInformacion":
                    System.out.println("ProyectoFinal: Mostrando informacion de los creadores");
                    iv.setVisible(true);
                    break;
                    
                //Caso del boton de la ventana del jugador 1
                case "botonConfirmar1"://Boton confirmar del jugador 1 (una vez pulsado tiene que abrir la ventana del jugador 2)
                    System.out.println("ProyectoFinal: Datos de inicio del juego confirmados");
                    //Pedirle a la vista la palabra y las letras y pasársela al modelo para que la almacene
                    modelo.setPalabraParaAdivinar(j1v.getPalabra());    //Guarda la palabra a adivinar en el modelo
                    modelo.setLongitudPalabra(j1v.getNumeroLetras());  //Guarda la longitud de la palabra a adivinar en el modelo
                    modelo.setIntento();//Inicializa el valor de los intentos
                    modelo.setPuntos(); //Inicializa el valor de los puntos
                    
                    j2v.crearCasillas();     //Crea las casillas de la ventana del jugador 2
                    j2v.actualizarIntentos();//Actualiza los intentos del usuario
                    j2v.setVisible(true);
                    break;
                    
                //Casos del los botones de la ventana del jugador 2
                case "botonSalir":
                    System.out.println("ProyectoFinal: Saliendo con el boton de la ventana 2.");
                    j1v.setVisible(true);
                    j2v.restaurarCasillas();
                    break;
                case "botonConfirmar2":
                    //Boton que se encarga de revisar si las letras introducidas por el usuario están o no en la palabra a adivinar
                    System.out.println("ProyectoFinal: Confirmando palabra");
                    j2v.comprobarCasillas();    //Comprueba si el valor introducido en las casillas coincide con el de las letras a adiivinar
                    modelo.actualizarIntento(); //Aumenta el valor de los intentos
                    j2v.actualizarIntentos();   //Actualiza el valor de los intentos en la ventana del jugador 2
                    //Añadir funcion para que se abra el ranking cuando se acierte la palabra o cuando se acaben el numero de intentos
                    rv.actualizarRanking(modelo.getNombresRanking(), modelo.getIntentos());
                    if (j2v.getMostrarRanking() == true){
                        rv.setVisible(true);
                    }
                    break;
                
                //Casos de los botones de la ventana del ranking
                case "botonSalirRanking":
                    System.out.println("ProyectoFinal: Saliendo del Ranking.");
                    j2v.restaurarCasillas();
                    j1v.setVisible(true);
                    break;
            }
        }
        
    }
}
