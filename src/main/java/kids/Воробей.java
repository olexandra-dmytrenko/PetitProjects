package kids;

public class Воробей {
    int размерЖелудка;
    int съелМошек;
    double осталосьСъесть;
    double коэфициентНасыщения = 0.8;
    double надоМошек;


    Воробей(int количествоСъеденыхМошек) {
        this.размерЖелудка = 10;
        this.съелМошек = количествоСъеденыхМошек;
        double сытость = количествоСъеденыхМошек * коэфициентНасыщения;
        this.осталосьСъесть = (размерЖелудка - сытость) / коэфициентНасыщения;
        //Проверочная формула сколько надо съесть мошек?
        this.надоМошек = размерЖелудка / коэфициентНасыщения;

    }

    public static String летаниеМошек(String weather) {
        String prediction;
        if (weather == "good") {
            System.out.println("1");
            prediction = ("Insects are flying");
            //System.out.println(prediction);
        }

        else if (weather == "bad") {
            prediction = ("Insects aren't flying");
            System.out.println("2");
            //System.out.println(prediction);
        } else  { //иначе
            prediction = ("Search for insects");
            System.out.println("3");
            //System.out.println(prediction);
        }
        return prediction;
    }


    public static void main(String[] args) {
       /* Воробей воробушек1 = new Воробей(12);
        Воробей воробушек2 = new Воробей(14);
        System.out.println(воробушек1);
        System.out.println(воробушек2);
       */
        String todaysWeather = "Хмарно з проясненнями";
        System.out.println(летаниеМошек("good"));
    }

    @Override
    public String toString() {
        return "Воробей{" +
                "размерЖелудка=" + размерЖелудка +
                ", съелМошек=" + съелМошек +
                ", осталосьСъесть=" + осталосьСъесть +
                ", надо мошек=" + надоМошек +
                '}';
    }
}
