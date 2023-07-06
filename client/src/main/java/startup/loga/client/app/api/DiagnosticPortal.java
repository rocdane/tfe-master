package startup.loga.client.app.api;

import startup.loga.client.model.Diagnosis;
import startup.loga.client.vendor.http.HttpRequestHelper;

import java.io.IOException;

public class DiagnosticPortal extends HttpRequestHelper {
    public Diagnosis create(Diagnosis diagnosis) throws IOException, InterruptedException {
        return (Diagnosis) request("/gateway-server/maintenance-service/diagnosis","POST", diagnosis, Diagnosis.class);
    }

    public Diagnosis read(Long id) throws IOException, InterruptedException {
        return (Diagnosis) request("/gateway-server/maintenance-service/diagnosis/"+id,"GET", null, Diagnosis.class);
    }

    public void report(Long id) throws IOException, InterruptedException {
        request("/gateway-server/report-service/report/"+id);
    }
}
