package startup.loga.client.app.api;

import org.junit.jupiter.api.Test;
import startup.loga.client.model.Repair;
import startup.loga.client.model.Spare;
import startup.loga.client.model.Task;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertNotNull;

class RepairPortalTest {

    private final RepairPortal repairPortal;

    public RepairPortalTest(){
        this.repairPortal = new RepairPortal();
    }

    @Test
    void create() throws IOException, InterruptedException {

        Repair repair = new Repair();
        repair.setMileage(222222);
        repair.setDescription("nouvelle réparation");
        repair.setReference("0001");

        Spare spare = new Spare();
        spare.setDesignation("fourniture");
        spare.setAmount(10000);
        spare.setPrice(1000);
        spare.setQuantity(10);

        Task task = new Task();
        task.setDuration(20000);
        task.setCost(100000);
        task.setDescription("travaux");

        repair.addSpare(spare);
        repair.addTask(task);

        Repair created = repairPortal.create(repair);

        System.out.println(created);

        assertNotNull(created.getId(),"Error repair");
    }
}