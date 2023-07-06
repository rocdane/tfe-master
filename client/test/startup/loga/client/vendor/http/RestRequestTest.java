package startup.loga.client.vendor.http;

import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;
import com.sun.net.httpserver.Request;
import org.junit.jupiter.api.Test;

import java.io.InputStream;

import static org.junit.jupiter.api.Assertions.*;

class RestRequestTest {
    RestRequest request = new RestRequest();

    @Test
    void download() throws UnirestException {
        HttpResponse<InputStream> response = request.download("/loga/report/diagnostic/1");
        InputStream inputStream = response.getBody();
        System.out.println(inputStream);
    }
}