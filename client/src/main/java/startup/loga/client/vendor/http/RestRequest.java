package startup.loga.client.vendor.http;

import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.JsonNode;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;

import java.io.File;
import java.io.InputStream;
import java.util.Map;

public class RestRequest implements IRestRequest{

    private final String BASE_URL;

    public RestRequest(){
        this.BASE_URL = "http://localhost:12780";
    }

    @Override
    public HttpResponse<JsonNode> post(String route, Object body) throws UnirestException {
        return Unirest.post(BASE_URL+route)
                .header("Content-Type", "application/json")
                .body(body)
                .asJson();
    }

    @Override
    public HttpResponse<JsonNode> put(String route, Object body) throws UnirestException {
        return Unirest.put(BASE_URL+route)
                .header("Content-Type", "application/json")
                .body(body)
                .asJson();
    }

    @Override
    public HttpResponse<JsonNode> get(String route, Map<String, Object> params) throws UnirestException {
        return Unirest.get(BASE_URL+route)
                .header("Content-Type", "application/json")
                .queryString(params)
                .asJson();
    }

    @Override
    public HttpResponse<JsonNode> delete(String route, Map<String, Object> params) throws UnirestException {
        return Unirest.delete(BASE_URL+route)
                .fields(params)
                .asJson();
    }

    @Override
    public HttpResponse<JsonNode> upload(String url, File file) throws UnirestException {
        return Unirest.post(BASE_URL+url)
                .field("file", file)
                .asJson();
    }

    @Override
    public HttpResponse<InputStream> download(String url) throws UnirestException {
        return Unirest.get(BASE_URL+url).asBinary();
    }
}
