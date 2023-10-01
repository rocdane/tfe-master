package startup.loga.client.app.api;

import startup.loga.client.app.factory.Dashboard;
import startup.loga.client.vendor.http.HttpRequestHelper;

import java.io.IOException;

public class MonitoringPortal extends HttpRequestHelper {

    public Dashboard load() throws IOException, InterruptedException {
        return (Dashboard) request("/monitoring-service/load","GET",null, Dashboard.class);
    }
}
