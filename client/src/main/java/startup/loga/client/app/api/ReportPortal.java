package startup.loga.client.app.api;

import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import startup.loga.client.vendor.http.HttpRequestHelper;

public class ReportPortal extends HttpRequestHelper {

    private final SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

    public void report(String src) throws IOException, InterruptedException {
        byte[] doc = request("/loga/report/"+src);
        writeOut(doc,src+sdf.format(new Date()));
    }

    public void reportById(String src, Long id) throws IOException, InterruptedException {
        byte[] doc = request("/loga/report/"+src+"/"+id);
        writeOut(doc,src+sdf.format(new Date()));
    }

    private void writeOut(byte[] doc, String filename) throws IOException {
        FileOutputStream fos = new FileOutputStream(filename+".pdf");
        fos.write(doc);
        fos.close();
    }
}
