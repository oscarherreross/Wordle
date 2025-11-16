package proyectofinal;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

/**
 *
 * @author Oscar
 */
public class ProyectoFinalModel {   
    private int longitudPalabra;       //Variable en la que vamos a almacenar la longitud de la palabra
    private String palabraParaAdivinar;//Variable en la que vamos a almacenar la palabra a adivinar
    private int intentos ;               //Variable en la que vamos a almacenar el intento en el que se encuentra el usuario actual
    private int puntos;                //Variable en la que vamos a almacenar el nº de puntos del usuario actual
    private String nombresRanking[] = new String[8];
    private String nombreRanking;
    
    public ProyectoFinalModel (){   
        String nombresRanking[] = new String[8]; 
    }
    
    //Funcion para asignarle valor a la longitud de la palabra(el valor introducido por el jugador2)
    public void setLongitudPalabra(int longitud){
        longitudPalabra = longitud;//Esta variable tiene el valor que se le introduce en le vantena del jugador 1 (comprobado con el debuger)
    }
    
    //Funcion que devuelve el valor de la longitud de la palabra
    public int getLongitudPalabra(){
        return longitudPalabra;
    }
    
    //Funcion para asignarle valor a la palabra a adivinar por el jugador2(el valor introducido por el jugador1)
    public void setPalabraParaAdivinar(String palabra){
        palabraParaAdivinar = palabra ;//Esta variable tiene el valor que se le introduce en le vantena del jugador 1 (comprobado con el debuger)
    }
    
    //Funcion que devuelve la palabra a adivinar
    public String getPalabraParaAdivinar(){
        return palabraParaAdivinar;
    }
    
    //Funcion para que devuelva el numero de intentos
    public int getIntentos(){
        return intentos;
    }
    
    //Funcion para asignarle valor al intento en el que se encuentra el jugador2(primer intento = 1. segundo intento = 2...)
    public void setIntento(){
        intentos = 0;
    }
    
    //Funcion para actualizar el intento actual
    public void actualizarIntento(){
        intentos++;
    }
    
    //Funcion para asignarle valor a los puntos que va teniendo el jugador2
    //Si adivina la palabra en el primer intento son 8 puntos, si la adivina en el segundo intento son 7 puntos...
    public void setPuntos(){
        puntos = 8;
    }
    
    //Funcion para decrementar puntos(conforme el usuario va consumiendo intentos)
    public void decrementarPuntos(){
        puntos--;
    }
    
    //Funcion que muestra un mensaje al jugador cuando no ha podido adivinar la palabra después de los intentos
    public void Derrota(){        
        Icon imagenDerrota = new ImageIcon(getClass().getResource("/ProyectoFinalVista/ImagenDerrota.jpg"));
        
        JOptionPane.showMessageDialog(null, "Lo sentimos, te has quedado sin intentos", "DERROTA", JOptionPane.INFORMATION_MESSAGE, imagenDerrota); //Le indica al usuario que ha ganado
        String nombre = JOptionPane.showInputDialog(null,"Te has quedado sin intentos, introduce tu nombre para continuar","Derrota",JOptionPane.DEFAULT_OPTION);
    
        nombresRanking[intentos] = nombre;
        nombreRanking = nombre;
    }
    
    //Funcion que muestra un mensaje al jugador cuando ha adivinado la palabra después de los intentos
    public void Victoria(){
        Icon imagenVictoria = new ImageIcon(getClass().getResource("/ProyectoFinalVista/ImagenVictoria.jpg"));
        
        JOptionPane.showMessageDialog(null, "Enhorabuena, has ganado", "VICTORIA", JOptionPane.INFORMATION_MESSAGE, imagenVictoria); //Le indica al usuario que ha ganado
        String nombre = JOptionPane.showInputDialog(null,"Has descubierto la palabra misteriosa, introduce tu nombre para continuar","Victoria",JOptionPane.DEFAULT_OPTION);
    
        nombresRanking[intentos] = nombre;
        nombreRanking = nombre;
    } 
    
    public String getNombresRanking(){
        return nombreRanking;
    }
}
