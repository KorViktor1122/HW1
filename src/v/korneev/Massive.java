package v.korneev;

public class Massive {
    public static void main(String[] args) {
            Object Human = 1;
            Object Cat = 2;
            Object Robot = 3;
            Object Runlength = Rulls.max_length;
            Object Wallhiegth = Rulls.max_heigth;

        int [] list = {(int) Human, (int) Cat, (int) Robot};
        int[] block = {(int) Runlength, (int) Wallhiegth};

        for (int i = 0; i < list.length; i++)
            System.out.println(" Список участников :" + list[i]);

        System.out.println(" Размер списка массива с участниками:" + block.length);


        for ( int i = 0; i < block.length; i++){
            for( int j = 0; j < list.length; j++)
                if( list[j] >= block[i] || list[j] >= block[i])
                System.out.println(list[j] + " смог пройти препятствие " + block[i]);
               else
                   System.out.println(list[j] + " не смог пройти соревнование " + block[i]);
            System.out.print(" ");

        }

    }
}


