package startup.loga.client.vendor.http;

import com.google.gson.Gson;

import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Type;
import java.net.HttpURLConnection;
import java.net.URI;
import java.net.URL;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.nio.charset.StandardCharsets;
import java.time.Duration;
import java.util.List;

public abstract class HttpRequestHelper {

    private final String BASE_URL;

    private final Gson GSON;

    public HttpRequestHelper(){
        this.BASE_URL = "http://localhost:8765/gateway-server";
        this.GSON = new Gson().newBuilder()
                .setPrettyPrinting()
                .create();
    }

    public void request(String path, String method){

        try {
            URL url = new URL(BASE_URL+path);

            HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
            httpURLConnection.setRequestMethod(method);
            httpURLConnection.setRequestProperty("content-type", "application/json");
            httpURLConnection.setRequestProperty("accept", "application/json");
            //httpURLConnection.setRequestProperty("partner-token", "37e1155b3299479a9865959887e9e848");
            //httpURLConnection.setRequestProperty("authorization", "Basic ZGI0YWVhZGQtNGI1NS00NjYwLWI1ZWUtMTk5MzI3NDRlOGNk");
            httpURLConnection.setConnectTimeout(5000);
            httpURLConnection.setReadTimeout(5000);

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void request(String url, String method, Object parameter) throws IOException, InterruptedException {

        HttpRequest httpRequest = HttpRequest.newBuilder()
                .uri(URI.create(BASE_URL+url))
                .setHeader("Content-Type","application/json; charset=UTF-8")
                .setHeader("Accept","application/json")
                .method(method, HttpRequest.BodyPublishers.ofString(GSON.toJson(parameter), StandardCharsets.UTF_8))
                .timeout(Duration.ofMillis(5000))
                .build();

        HttpResponse<?> httpResponse = HttpClient.newHttpClient()
                .send(httpRequest, HttpResponse.BodyHandlers.ofString());
    }

    public Object request(String url, String method, Object parameter, Class<?> entity) throws IOException, InterruptedException {
        HttpRequest httpRequest = HttpRequest.newBuilder()
                .uri(URI.create(BASE_URL+url))
                .setHeader("Content-Type","application/json; charset=UTF-8")
                .setHeader("Accept","application/json")
                .method(method,HttpRequest.BodyPublishers.ofString(GSON.toJson(parameter), StandardCharsets.UTF_8))
                .timeout(Duration.ofMillis(5000))
                .build();

        HttpResponse<?> httpResponse = HttpClient.newHttpClient()
                .send(httpRequest, HttpResponse.BodyHandlers.ofString());

        return GSON.fromJson(httpResponse.body().toString(),entity);
    }

    public List request(String url, String method, Object parameter, Type type) throws IOException, InterruptedException {

        HttpRequest httpRequest = HttpRequest.newBuilder()
                .uri(URI.create(BASE_URL+url))
                .setHeader("Content-Type","application/json; charset=UTF-8")
                .setHeader("Accept","application/json")
                .method(method,HttpRequest.BodyPublishers.ofString(GSON.toJson(parameter), StandardCharsets.UTF_8))
                .timeout(Duration.ofMillis(5000))
                .build();

        HttpResponse<?> httpResponse = HttpClient.newHttpClient()
                .send(httpRequest, HttpResponse.BodyHandlers.ofString());

        return GSON.fromJson(httpResponse.body().toString(), type);
    }

    public byte[] request(String url) throws IOException, InterruptedException {

        HttpRequest httpRequest = HttpRequest.newBuilder()
                .uri(URI.create(BASE_URL+url))
                .GET()
                .setHeader("Accept","application/pdf")
                .build();

        HttpResponse<InputStream> httpResponse = HttpClient.newHttpClient()
                .send(httpRequest, HttpResponse.BodyHandlers.ofInputStream());

        return httpResponse.body().readAllBytes();
    }
}
