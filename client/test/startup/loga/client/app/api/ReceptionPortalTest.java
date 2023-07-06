package startup.loga.client.app.api;

import org.junit.jupiter.api.Test;
import startup.loga.client.model.Notice;
import startup.loga.client.model.Reception;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertNotNull;

class ReceptionPortalTest {

    private final ReceptionPortal receptionPortal;

    ReceptionPortalTest() {
        this.receptionPortal = new ReceptionPortal();
    }

    @Test
    void create() throws IOException, InterruptedException {
        Reception reception = new Reception();
        reception.setDescription("Réception");
        reception.setMileage(223222);

        Notice notice = new Notice();
        notice.setCode("code");
        notice.setCheckpoint("checkpoint 1001");
        notice.setStatus("OK");

        reception.addNotice(notice);

        Reception created = receptionPortal.create(reception);

        System.out.println(created.getId()+"\n"+created.getDescription()+"\n"+created.getMileage()+"\n"+created.getCreatedAt());

        assertNotNull(created.getId(),"Echec test reception");
    }
}