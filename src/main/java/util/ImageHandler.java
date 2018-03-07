/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package util;

import com.sun.org.apache.xerces.internal.impl.dv.util.Base64;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import javafx.embed.swing.SwingFXUtils;
import javafx.scene.image.Image;
import javafx.scene.image.WritableImage;
import javax.imageio.ImageIO;

/**
 * Classe para conversão de stream de bytes em Image do JavaFX ou Image para
 * stream de bytes
 *
 * @author joao
 */
public class ImageHandler {

    public static FileInputStream getFis(String arq) {
        try {
            File file = new File(arq);

            return new FileInputStream(file);
        } catch (IOException ex) {
            System.out.println("Erro-->" + ex);
        }
        return null;
    }

    public static int getLen(String arq) {
        File file = new File(arq);
        return (int) file.length();
    }


    public static void findMinAndMax(short[] pixels, int width, int height) {
        int size = width * height;
        int value,
                min = 65535,
                max = 0;
        for (int i = 0; i < size; i++) {
            value = pixels[i] & 0xffff;
            if (value < min) {
                min = value;
            }
            if (value > max) {
                max = value;
            }
        }
    }

    public static Image convertToJavaFXImage(byte[] raw, final int width, final int height) {
        WritableImage image = new WritableImage(width, height);
        try {
            ByteArrayInputStream bis = new ByteArrayInputStream(raw);
            BufferedImage read = ImageIO.read(bis);
            image = SwingFXUtils.toFXImage(read, null);
        } catch (IOException ex) {
            System.out.println("Erro-->>"+ex);
        }
        return image;
    }
     public static byte[] fileToByteArray(File fileImg) {
        try {
            String base64String;
            try (ByteArrayOutputStream baos = new ByteArrayOutputStream((int)fileImg.length())) {
                BufferedImage img = ImageIO.read(fileImg);
                ImageIO.write(img, "jpg", baos);
                baos.flush();
                base64String = Base64.encode(baos.toByteArray());
            }
            
            byte[] bytearray = Base64.decode(base64String);
            return bytearray;
        } catch (IOException ex) {
            System.out.println("Erro ao converter imagem:"+ex);
        }
        return null;
    }
}
