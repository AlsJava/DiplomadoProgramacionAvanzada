package edu.aluismarte.diplomado.week5;

import okhttp3.Call;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;

/**
 * Reimplementar esta clase separando la lógica en diversas funciones
 * <p>
 * No se debe obtener la foto y salvarla en un mismo segmento de lógica, también el nombre del archivo debe tener criterios
 *
 * @author aluis on 5/8/2022.
 */
public class Exercise1Week5 {

    private static final String API_URL = "https://http.cat/";

    private final OkHttpClient client = new OkHttpClient();

    public void getAndSave(int code, String filename) {
        Request request = new Request.Builder()
                .url(API_URL + "/" + code)
                .build();
        Call call = client.newCall(request);
        try {
            Response response = call.execute();
            InputStream inputStream = response.body().byteStream();
            BufferedImage image = ImageIO.read(inputStream);
            File file = new File(filename); // TODO Que pasa cuando no tiene extension? y cuando la tiene? ajustar esto
            ImageIO.write(image, "jpg", file);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

//    private BufferedImage getCatUsingStatusCode(int code) {
//    }
}
