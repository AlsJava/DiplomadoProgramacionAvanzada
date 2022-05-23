package edu.aluismarte.diplomado.week5;

import com.fasterxml.jackson.databind.ObjectMapper;
import edu.aluismarte.diplomado.model.week5.ChuckNorrisJoke;
import edu.aluismarte.diplomado.model.week5.SearchChuckNorrisJoke;
import okhttp3.*;

import java.io.IOException;
import java.util.List;

/**
 * @author aluis on 5/1/2022.
 */
public class ChuckNorrisJokeService {

    private static final String CHUCK_NORRIS_IO_URL = "https://api.chucknorris.io/jokes";

    private final OkHttpClient client = new OkHttpClient();

    private final ObjectMapper objectMapper = new ObjectMapper();

    public ChuckNorrisJoke getRandomJoke() {
        Request request = new Request.Builder()
                .url(CHUCK_NORRIS_IO_URL + "/random")
                .build();
        try {
            return objectMapper.readValue(sendRequest(request), ChuckNorrisJoke.class);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public ChuckNorrisJoke getRandomJokeFromCategory(String category) {
        HttpUrl httpUrl = HttpUrl.parse(CHUCK_NORRIS_IO_URL + "/random");
        HttpUrl.Builder urlBuilder;
        if (httpUrl != null) {
            urlBuilder = httpUrl.newBuilder().addQueryParameter("category", category);
        } else {
            return null;
        }
        Request request = new Request.Builder()
                .url(urlBuilder.build().toString())
                .build();
        try {
            return objectMapper.readValue(sendRequest(request), ChuckNorrisJoke.class);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public SearchChuckNorrisJoke getJokeByText(String text) {
        HttpUrl httpUrl = HttpUrl.parse(CHUCK_NORRIS_IO_URL + "/search");
        HttpUrl.Builder urlBuilder;
        if (httpUrl != null) {
            urlBuilder = httpUrl.newBuilder().addQueryParameter("query", text);
        } else {
            return null;
        }
        Request request = new Request.Builder()
                .url(urlBuilder.build().toString())
                .build();
        try {
            return objectMapper.readValue(sendRequest(request), SearchChuckNorrisJoke.class);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public List<String> getJokesCategories() {
        Request request = new Request.Builder()
                .url(CHUCK_NORRIS_IO_URL + "/categories")
                .build();
        try {
            String[] values = objectMapper.readValue(sendRequest(request), String[].class);
            return List.of(values);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private String sendRequest(Request request) {
        Call call = client.newCall(request);
        try {
            Response response = call.execute();
            ResponseBody body = response.body();
            if (body == null) {
                return null;
            }
            return body.string();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

}
