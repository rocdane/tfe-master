package startup.loga.client.vendor.http;

import java.io.IOException;
import java.lang.reflect.Type;
import java.util.List;

public interface IHttpRequestHelper {

    void request(String url, String method, Object parameter) throws IOException, InterruptedException;

    Object request(String url, String method, Object parameter, Class<?> response) throws IOException, InterruptedException;

    List<?> request(String url, String method, Object parameter, Type entity) throws IOException, InterruptedException;

}
