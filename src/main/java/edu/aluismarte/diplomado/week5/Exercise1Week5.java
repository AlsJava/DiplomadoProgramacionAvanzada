package edu.aluismarte.diplomado.week5;

import okhttp3.*;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.InputStream;

/**
 * @author aluis on 5/8/2022.
 */
public class Exercise1Week5 {

    private static final String API_URL = "https://http.cat/";

    private final OkHttpClient client = new OkHttpClient();

    public BufferedImage getCatUsingStatusCode(int code) {
        Request request = new Request.Builder()
                .url(API_URL + "/" + code)
                .build();
        Call call = client.newCall(request);
        try {
            Response response = call.execute();
            InputStream inputStream = response.body().byteStream();
            return ImageIO.read(inputStream);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
