package startup.loga.client.app.api;

import org.junit.jupiter.api.Test;
import startup.loga.client.model.Diagnosis;
import startup.loga.client.model.Factor;
import startup.loga.client.vendor.http.HttpRequestHelper;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

class DiagnosticPortalTest extends HttpRequestHelper {

    private final DiagnosticPortal diagnosticPortal;

    DiagnosticPortalTest() {
        this.diagnosticPortal = new DiagnosticPortal();
    }

    @Test
    void create() throws IOException, InterruptedException {

        Diagnosis diagnosis = new Diagnosis();
        diagnosis.setDescription("Diagnostic complet du véhicule");
        diagnosis.setMileage(234944);

        diagnosis.addFactor(new Factor("Système de motorisation",
                "courroie alternateur usée",
                "remplacement de la courroie alternateur"));

        diagnosis.addFactor(new Factor("Système de transmission",
                "transmission avant droit défectueux",
                "remplacement de la transmission avant droit"));

        diagnosis.addFactor(new Factor("Système de freinage",
                "vibration du volant au freinage",
                "contrôle et réglage des disques de freins"));

        diagnosis.addFactor(new Factor("Système de freinage",
                "plaquettes freins avant et arrière défectueux",
                "remplacement des plaquettes freins avant et arrière"));

        diagnosis.addFactor(new Factor("Système de suspension",
                "biellette barre stabilisatrice arrière usée",
                "remplacement des biellettes barre stabilisatrice arrière"));

        diagnosis.addFactor(new Factor("Système de direction",
                "rotule de direction défectueux",
                "remplacement du rotule de direction"));

        Diagnosis created = diagnosticPortal.create(diagnosis);

        System.out.println(created.getId()+"\n"+created.getDescription()+"\n"+created.getMileage()+"\n"+created.getCreatedAt());

        assertNotNull(created,"Echec test !!!");
    }
}