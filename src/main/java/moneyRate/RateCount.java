package moneyRate;

/**
 * Created by Nykyta and Olexandra on 01.01.17.
 */
public class RateCount {

    public static final int STEP = 1000;

    public static void main(String[] args) {
        double Kurs = 28.2;
        double DengiPomenjani = 20000;
        double Konez = 200000;
        double actualRate = countActualRate(Kurs, DengiPomenjani);
//        countActualRateCycle(Kurs, DengiPomenjani, Konez);
        System.out.println("The rate where 2% is applied is " + actualRate);
    }

    private static void countActualRateCycle(double kurs, double dengiPomenjani, double konez) {
        while (dengiPomenjani <= konez) {
            countActualRate(kurs, dengiPomenjani);
            dengiPomenjani = dengiPomenjani + STEP;
        }
    }

    private static double countActualRate(double kurs, double dengiPomenjani) {
        double DengiZaplacheni = dengiPomenjani * 1.02; //12 240
        double erPolucheni = dengiPomenjani / kurs; //12 000 / 28.2
        double novuiKurs = DengiZaplacheni / erPolucheni; // 12 240 / (12 000 / 28.2)

        System.out.println("-----------------------------");
        System.out.println("DengiPomenjani =  |" + dengiPomenjani);
        System.out.println("DengiZaplacheni = |" + DengiZaplacheni);
        System.out.println("erPolucheni =     |" + erPolucheni);
        System.out.println("novuiKurs =       |" + novuiKurs);
        System.out.println("-----------------------------");
        return novuiKurs;
    }
}

