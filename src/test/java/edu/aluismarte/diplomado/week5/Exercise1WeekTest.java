package edu.aluismarte.diplomado.week5;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;

/**
 * Usar el API para
 *
 * @author aluis on 5/8/2022.
 */
public class Exercise1WeekTest {

    private final Exercise1Week5 exercise1Week5 = new Exercise1Week5();

    private File catImageFile;
    private int count = 0;

    @BeforeEach
    void beforeEachTest() {
        catImageFile = new File("cat" + count + ".jpg");
        count++;
    }

    @AfterEach
    void afterEachTest() {
        System.out.println("Eliminando archivos");
        for (int i = 0; i < count; i++) {
            File cat = new File("cat" + i + ".jpg");
            if (cat.exists()) {
                if (cat.delete()) {
                    System.out.println("Foto eliminada " + cat.getName());
                } else {
                    System.out.println("No se pudo eliminar la foto " + cat.getName());
                }
            }
        }
    }

    private void saveImage(BufferedImage bufferedImage) throws IOException {
        ImageIO.write(bufferedImage, "jpg", catImageFile);
    }

    public static byte[] toByteArray(BufferedImage bufferedImage, String format) throws IOException {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        ImageIO.write(bufferedImage, format, byteArrayOutputStream);
        return byteArrayOutputStream.toByteArray();

    }
}
