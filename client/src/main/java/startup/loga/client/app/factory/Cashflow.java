package startup.loga.client.app.factory;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

/**
 * Classe de représentation du flux financier
 * @author rochdane sabi rocdanesabi@gmail.com
 * @version 2.1
 */

public class Cashflow implements Serializable {

    private ArrayList<ICashflow> ICashFlow;

    public void addCashFlow(ICashflow ICashFlow){
        this.ICashFlow.add(ICashFlow);
    }

    /**
     * Cette méthode permet de calculer le flux financier
     * @return Double
     */
    public double calculateCashFlow(){
        double cost = 0;
        for (ICashflow ICashFlow :this.ICashFlow) {
            cost+= ICashFlow.getValue();
        }
        return cost;
    }

    /**
     * Cette méthode permet d'afficher le flux financier
     * @return
     */
    public StringBuilder showCashFlow(){
        StringBuilder stringBuilder = new StringBuilder();
        for (ICashflow ICashFlow :this.ICashFlow) {
            stringBuilder.append(ICashFlow.getDescription())
                    .append(" / ")
                    .append(ICashFlow.getValue())
                    .append(" / ")
                    .append(new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").format(ICashFlow.getDate()))
                    .append("\n");
        }
        return stringBuilder;
    }
}
