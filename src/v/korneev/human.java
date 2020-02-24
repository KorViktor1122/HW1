package v.korneev;

public class human implements rulls {
    public static void main(String[] args) {
        System.out.println(" У человека есть имя, а также он умеет бегать и прыгать. ");
    }

    String name;
    int distancte, upjump;

    human(String name, int distancte, int upjump) {
        this.name = name;
        this.distancte = distancte;
        this.upjump = upjump;
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

