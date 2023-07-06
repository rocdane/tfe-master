package startup.loga.client.app.factory;

import java.util.Date;

/**
 * Interface de l'application LoGa représentant les opérations du flux financier.
 * @author rochdane sabi rocdanesabi@gmail.com
 * @version 2.1
 * @since 2.0
 */
public interface ICashflow {
    String getDescription();
    Double getValue();
    Date getDate();
}
