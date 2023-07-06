package startup.loga.client.app.api;

import startup.loga.client.model.AuthSession;
import startup.loga.client.model.Client;
import startup.loga.client.model.User;
import startup.loga.client.vendor.http.HttpRequestHelper;

import java.io.IOException;

public class AuthPortal extends HttpRequestHelper {

    public AuthSession authenticate(User user) throws IOException, InterruptedException {
        return (AuthSession) request("/loga/v1/authenticate/signin","POST",user, AuthSession.class);
    }

    public Client register(User user) throws IOException, InterruptedException {
        return (Client) request("/loga/v1/authenticate/registrate","POST",user, User.class);
    }

    public Client update(User user, Long id) throws IOException, InterruptedException {
        return (Client) request("/loga/v1/authenticate/update/"+id,"POST",user, User.class);
    }

    public void logout(String token) throws IOException, InterruptedException {
        request("/loga/v1/authenticate/logout/"+token,"POST",null);
    }
}
