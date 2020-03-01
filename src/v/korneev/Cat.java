package v.korneev;

public class Cat implements Rulls{
    public static void main(String[] args) {
        System.out.println("Кот может прыгать, " + "\n" + "\t"  + " кот может бегать");
    }

    String name;
    int distancte, upjump;

    Cat(String name, int distancte, int upjump) {
        this.name = name;
        this.distancte = distancte;
        this.upjump = upjump;
    }
    public int getDistancte() {
        return distancte = 500;
    }

    public String getName() {
        return name = "Volt";
    }

    public int getUpjump() {
        return upjump = 1;
    }

    public Cat() {
        getName();getDistancte();getUpjump();
    }


    @Override
    public int length() {
        System.out.println("Кот может пробежать: " + distancte);
        return distancte;
    }

    @Override
    public int heigth() {
        System.out.println(" Кот может перепрыгнуть преграду ниже:" + upjump);
        return upjump;
    }
}