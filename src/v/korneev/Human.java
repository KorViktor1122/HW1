package v.korneev;
public class Human implements Rulls {

    public static void main(String[] args) {
        System.out.println(" У человека есть имя, а также он умеет бегать и прыгать. ");
    }
    String name;
    int distancte , upjump ;

    Human(String name, int distancte, int upjump) {
        this.name = name;
        this.distancte = distancte;
        this.upjump = upjump;
    }

    public int getDistancte() {
        return distancte = 2000;
    }

    public String getName() {
        return name = "Viktor";
    }

    public int getUpjump() {
        return upjump = 2;
    }

    public Human() {
        getName();getDistancte();getUpjump();
    }

    @Override
    public int length() {
        System.out.println("Человек может пробежать: " + distancte);
        return distancte;
    }

    @Override
    public int heigth() {
        System.out.println(" Человек может перепрыгнуть:" + upjump);
        return upjump;

    }
}

