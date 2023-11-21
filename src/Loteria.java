import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Stack;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;

public class Loteria extends Thread {
    Ventana v;
    Stack<ImagenConNumero> pila = new Stack<>();
    String Imagenes[] = {"cartas separadas/1.png", "cartas separadas/2.png","cartas separadas/3.png", "cartas separadas/4.png","cartas separadas/5.png",
    "cartas separadas/6.png","cartas separadas/7.png", 
    "cartas separadas/8.png","cartas separadas/8.png", "cartas separadas/9.png","cartas separadas/10.png", "cartas separadas/11.png",
    "cartas separadas/12.png", "cartas separadas/13.png","cartas separadas/14.png", "cartas separadas/15.png","cartas separadas/16.png", 
    "cartas separadas/17.png","cartas separadas/18.png", "cartas separadas/19.png","cartas separadas/20.png", "cartas separadas/21.png",
    "cartas separadas/22.png", "cartas separadas/23.png","cartas separadas/24.png", "cartas separadas/25.png","cartas separadas/26.png",
    "cartas separadas/27.png","cartas separadas/28.png","cartas separadas/29.png","cartas separadas/30.png", "cartas separadas/31.png",
    "cartas separadas/32.png", "cartas separadas/33.png","cartas separadas/34.png", "cartas separadas/35.png","cartas separadas/36.png", 
    "cartas separadas/37.png","cartas separadas/38.png", "cartas separadas/39.png","cartas separadas/40.png", "cartas separadas/41.png",
    "cartas separadas/42.png", "cartas separadas/43.png", "cartas separadas/44.png", "cartas separadas/45.png", "cartas separadas/45.png",
    "cartas separadas/46.png", "cartas separadas/447.png", "cartas separadas/48.png", "cartas separadas/49.png", "cartas separadas/50.png"
    , "cartas separadas/51.png", "cartas separadas/52.png","cartas separadas/53.png","cartas separadas/54.png"};
    ArrayList<ImagenConNumero> imagenesConNumeros;

    public Loteria(Ventana v) {
        this.v = v;
        imagenesConNumeros = asignarNumeros(Imagenes);
    }

    public void Insertar() {
        for (ImagenConNumero imagenConNumero : imagenesConNumeros) {
            pila.push(imagenConNumero);
        }
    }

    public void MostrarImagen() {
        if (!pila.isEmpty()) {
            ImagenConNumero imagenConNumero = pila.pop();
            v.jLabel1.setIcon(imagenConNumero.getImageIcon());
        } else {
      }
    }

    public void run() {
        Insertar();
        while (true) {
            MostrarImagen();

            try {
                sleep(1000);
            } catch (InterruptedException ex) {
                Logger.getLogger(Loteria.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
   private static ArrayList<ImagenConNumero> asignarNumeros(String[] imagenes) {
        ArrayList<ImagenConNumero> imagenesConNumeros = new ArrayList<>();
        for (int i = 0; i < imagenes.length; i++) {
            imagenesConNumeros.add(new ImagenConNumero(i + 1, imagenes[i]));
        }
      Collections.shuffle(imagenesConNumeros);
        return imagenesConNumeros;
    }
}

