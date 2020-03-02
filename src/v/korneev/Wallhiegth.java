package v.korneev;

public class Wallhiegth {

    private int maxwallheight;

    public Wallhiegth( int max_wall_heigth){
        this.maxwallheight = max_wall_heigth;
    }

    public boolean doJump(Rulls Rulls){
        int heigth = Rulls.heigth();
        return heigth >= maxwallheight;
    }

    public static void main(String[] args) {
        System.out.println("Высота преграды составляет "+ Rulls.max_heigth);
        Rulls Human = new Human("Viktor",2000,2);
        System.out.println(new Wallhiegth( Rulls.max_heigth).doJump(Human));

        Rulls Cat = new Cat("Volt", 2500, 2);
        System.out.println(new Wallhiegth( Rulls.max_heigth).doJump(Cat));

        Rulls Robot = new Robot("Verder", 1400, 1);
        System.out.println(new Wallhiegth( Rulls.max_heigth).doJump(Robot));

    }
}
