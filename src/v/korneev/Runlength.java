package v.korneev;

public class Runlength {
    private String name;
    private int maxDistation;

    public Runlength(String name, int maxDistation){
        this.name = name;
        this.maxDistation = maxDistation;
    }


    public boolean doRun(Rulls Rulls){
        int distancte = Rulls.length();
        return distancte >= maxDistation;
    }
    public static void main(String[] args) {
        System.out.println("Длина беговой дорожки расчитана на " + Rulls.max_length);

        Rulls Human = new Human();
        Rulls Cat = new Cat();
        Rulls Robot = new Robot();

        Rulls Participant [] = {Human, Cat, Robot};

        //for ( int i = 0; i < Participant.length; i++){
         //   if(Participant[i] = true){
           //     System.out.println(Participant[i] + "смог пройти дистанцию. ");
           // }
        }

//        Human = new Human();
//        System.out.println(new Runlength("Electolux", Rulls.max_heigth).doRun(Human));
//
//
//        Rulls Cat = new Cat("Volt", 500, 1);
//        System.out.println(new Runlength("Electolux", Rulls.max_length).doRun(Cat));
//
//        Rulls Robot = new Robot("Verder", 1400, 1);
//        System.out.println(new Runlength("Electolux", Rulls.max_length).doRun(Robot));

    }



//}
