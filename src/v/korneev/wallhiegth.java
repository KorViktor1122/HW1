package v.korneev;

public class wallhiegth {

    private int maxwallheight;

    public wallhiegth( int max_wall_heigth){
        this.maxwallheight = max_wall_heigth;
    }

    public boolean doJump(rulls rulls){
        int heigth = rulls.heigth();
        return heigth >= maxwallheight;
    }

    public static void main(String[] args) {
        System.out.println("Высота преграды составляет "+ rulls.max_heigth);
        rulls human = new human("Viktor",2000,2);
        System.out.println(new wallhiegth( 1).doJump(human));

        rulls Cat = new Cat("Volt", 500, 1);
        System.out.println(new wallhiegth( 1).doJump(Cat));

        rulls Robot = new Robot("Verder", 1400, 1);
        System.out.println(new wallhiegth( 1).doJump(Robot));

    }
}
