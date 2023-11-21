
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Kevin Alberto Perez
 */
public class ImagenConNumero {
    private int numero;
    private String direccion;

    public ImagenConNumero(int numero, String direccion) {
        this.numero = numero;
        this.direccion = direccion;
    }

    public int getNumero() {
        return numero;
    }

    public String getDireccion() {
        return direccion;
    }

    public ImageIcon getImageIcon() {
        try {
            BufferedImage bufferedImage = ImageIO.read(getClass().getResource(direccion));
            return new ImageIcon(bufferedImage);
        } catch (IOException ex) {
            Logger.getLogger(Loteria.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }
}