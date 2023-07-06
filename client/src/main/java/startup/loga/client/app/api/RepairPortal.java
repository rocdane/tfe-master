package startup.loga.client.app.api;

import com.google.gson.reflect.TypeToken;
import startup.loga.client.model.*;
import startup.loga.client.vendor.http.HttpRequestHelper;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class RepairPortal extends HttpRequestHelper {

    public Repair create(Repair repair) throws IOException, InterruptedException {
        return (Repair) request("/loga/v1/repair/create","POST",repair,Repair.class);
    }

    public List list() throws IOException, InterruptedException {
        return request("/loga/v1/repair/read","GET",null,new TypeToken<ArrayList<Repair>>(){}.getType());
    }

    public Repair read(Long id) throws IOException, InterruptedException {
        return (Repair) request("/loga/v1/repair/read/"+id,"GET",null,Repair.class);
    }

    public void order(Long id) throws IOException, InterruptedException {
        request("/loga/v1/repair/order/"+id,"PUT",null);
    }

    public List read(String ref) throws IOException, InterruptedException {
        return request("/loga/v1/repair/read/"+ref,"GET",null,new TypeToken<ArrayList<Repair>>(){}.getType());
    }

    public void edit(Repair repair, Long id) throws IOException, InterruptedException {
        request("/loga/v1/repair/read/"+id,"PUT",repair);
    }

    public void delete(Long id) throws IOException, InterruptedException {
        request("/loga/v1/repair/delete/"+id,"PUT",null);
    }

    public void editTask(Task task, Long id) throws IOException, InterruptedException {
        request("/loga/v1/repair/edit/task/"+id,"PUT",task);
    }

    public void editSpare(Spare spare, Long id) throws IOException, InterruptedException {
        request("/loga/v1/repair/edit/spare/"+id,"PUT",spare);
    }

    public void deleteTask(Long id) throws IOException, InterruptedException {
        request("/loga/v1/repair/delete/task/"+id,"PUT",null);
    }

    public void deleteSpare(Long id) throws IOException, InterruptedException {
        request("/loga/v1/repair/edit/spare/"+id,"PUT",null);
    }
}
