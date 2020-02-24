package v.korneev;

public class runlength {

    private String name;
    private int maxDistation;

    public runlength(String name, int maxDistation){
        this.name = name;
        this.maxDistation = maxDistation;
    }

    public boolean doRun(rulls rulls){
        int distancte = rulls.length();
        return distancte >= maxDistation;
    }


    public static void main(String[] args) {
        System.out.println("Длина беговой дорожки расчитана на "+ rulls.max_length);
        rulls human = new human("Viktor",2000,2);
        System.out.println(new runlength("Electolux", 1350).doRun(human));

        rulls Cat = new Cat("Volt", 500, 1);
        System.out.println(new runlength("Electolux", 1350).doRun(Cat));

        rulls Robot = new Robot("Verder", 1400, 1);
        System.out.println(new runlength("Electolux", 1350).doRun(Robot));

    }



}
