package startup.loga.client.app.api;

import org.junit.jupiter.api.Test;
import startup.loga.client.model.Profile;
import startup.loga.client.model.User;

import java.io.IOException;
import java.util.Date;

import static org.junit.jupiter.api.Assertions.*;

class ResourcePortalTest {

    private final ResourcePortal resourcePortal;
    public ResourcePortalTest() {
        this.resourcePortal = new ResourcePortal();
    }
    @Test
    void create() throws IOException, InterruptedException {
        Profile profile = new Profile();
        profile.setName("GMC PLUS");
        profile.setSurname("GARAGE");
        profile.setContact("gmcplus@loga.com");
        profile.setAddress("BÉNIN");
        profile.setArchived(false);
        profile.setUser(new User("gmcplus","secret"));
        profile.setSalary(1000000);

        Profile created = resourcePortal.create(profile);

        System.out.println(created.getUser().getId()+"\n"+created.getId());

        assertNotNull(created.getId(),"Echec profile");
    }
}