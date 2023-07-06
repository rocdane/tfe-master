package startup.loga.client.vendor.http;

import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.JsonNode;
import com.mashape.unirest.http.exceptions.UnirestException;

import java.io.File;
import java.io.InputStream;
import java.util.Map;

public interface IRestRequest {
    HttpResponse<JsonNode> post(String route, Object body) throws UnirestException;
    HttpResponse<JsonNode> put(String route, Object body) throws UnirestException;
    HttpResponse<JsonNode> get(String route, Map<String, Object> params) throws UnirestException;
    HttpResponse<JsonNode> delete(String route, Map<String, Object> params) throws UnirestException;
    HttpResponse<JsonNode> upload(String url, File file) throws UnirestException;
    HttpResponse<InputStream> download(String url) throws UnirestException;
}
