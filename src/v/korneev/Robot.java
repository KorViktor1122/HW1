package v.korneev;

public class Robot implements Rulls{
    public static void main(String[] args) {
        System.out.println("Робот может прыгать, " + "\n" + "\t" + " робот может бегать" );
    }
    String name;
    int distancte, upjump;

    Robot(String name, int distancte, int upjump) {
        this.name = name;
        this.distancte = distancte;
        this.upjump = upjump;
    }
    public int getDistancte() {
        return distancte = 1000;
    }

    public String getName() {
        return name = "Verder";
    }

    public int getUpjump() {
        return upjump = 1;
    }

    public Robot() {
        getName();getDistancte();getUpjump();
    }


    @Override
    public int length() {
        System.out.println("Робот может бегать на дистанцию : " + distancte);
        return distancte;
    }

    @Override
    public int heigth() {
        System.out.println(" Робот может перепрыгнуть препятствие ниже:" + upjump);
        return upjump;
    }
}



