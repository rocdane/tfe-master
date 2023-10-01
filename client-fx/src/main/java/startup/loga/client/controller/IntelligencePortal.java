package startup.loga.client.controller;

import com.google.gson.reflect.TypeToken;
import startup.loga.client.app.factory.Diagnosis;
import startup.loga.client.vendor.http.HttpRequestHelper;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class IntelligencePortal extends HttpRequestHelper {
    public List processDiagnosis(String words) throws IOException, InterruptedException {
        return request("/intelligent-service/resolve/"+words,"GET",null, new TypeToken<ArrayList<Diagnosis>>(){}.getType());
    }
}
