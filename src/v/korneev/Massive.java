package v.korneev;

public class Massive {
    public static void main(String[] args) {
        Object Cat = 1;
        Object Robot = 1;
        Object runlength = 1;
        Object wallhiegth = 1;
        Object human = 1;



        int [] list = {(int) human, (int) Cat, (int) Robot};
        int [] block = {(int) runlength, (int) wallhiegth};


        System.out.println(" Размер списка массива с участниками:" + list.length);
        System.out.println(" Размер списка массива с препятсвиями:" + block.length);

        for ( int i = 0; i < list.length; i++){
            if(block[0] <= list[i])
                System.out.println(" Участник не смог пройти дистанцию");
            System.out.print(" ");

        }



    }

/*
    private Object human;
    private Object Cat;
    private Object Robot;
    private Object runlength;
    private Object wallhiegth;

   public int[] participant = {(int) human, (int) Cat, (int) Robot};

   public int[] block = {(int) runlength, (int) wallhiegth};


    public Massive(Object human, Object cat, Object robot, Object runlength, Object wallhiegth) {
        this.human = human;
        Cat = cat;
        Robot = robot;
        this.runlength = runlength;
        this.wallhiegth = wallhiegth;
    }

    public static void main(String[] args) {

    }*/

}


