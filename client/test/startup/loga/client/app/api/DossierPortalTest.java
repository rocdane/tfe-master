package startup.loga.client.app.api;

import org.junit.jupiter.api.Test;
import startup.loga.client.model.Automobile;
import startup.loga.client.model.Client;
import startup.loga.client.model.Dossier;
import startup.loga.client.vendor.http.HttpRequestHelper;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

class DossierPortalTest extends HttpRequestHelper{

    final DossierPortal dossierPortal;

    public DossierPortalTest(){
        this.dossierPortal = new DossierPortal();
    }

    @Test
    void create() throws IOException, InterruptedException {
        Automobile automobile = new Automobile();
        automobile.setNumber("AH2775RB");
        automobile.setVin("FJSDKLFJSDKLFJSKL");
        automobile.setMake("TOYOTA");
        automobile.setModel("CARINA 3");
        automobile.setUnit("Km");
        automobile.setTrim(223222);

        Client client = new Client();
        client.setContact("rocdanesabi@n2a-consulting.com");
        client.setAddress("Afrique");
        client.setName("rochdane sabi");
        client.setType("homme");
        client.setLegalNotice("informaticien");

        Dossier dossier = new Dossier();
        dossier.setReference(client.getName().trim()+automobile.getNumber().trim());
        dossier.setAutomobile(automobile);
        dossier.setClient(client);

        Dossier created = dossierPortal.create(dossier);

        System.out.println(created.getReference()+"\n"+created.getOpenAt()+"\n"+created.getAutomobile().getVin()+"\n"+created.getClient().getName());

        assertNotNull(created,"Echec test !!!");
    }
}