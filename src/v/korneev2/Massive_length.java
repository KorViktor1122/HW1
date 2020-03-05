package v.korneev2;

import javafx.event.EventDispatchChain;

public class Massive_length {

        public static void main(String[] args) {
            try {
                String [][] massive = new String[4][4];
                massive[3][3] = " Hello." ;
                System.out.println(String.valueOf(massive[3][3]));

                System.out.println("Преобразовать массив из  String в int. ");
               // преобразовать массиив из string в int
                int massive1 [][] = new int[massive.length][];
                int y = 0;
                for (int i = 0; i < 4; i++)
                    for (int j = 0; j < 4; j++) {
                        massive1[i][j] = y;
                        y++;
                    }

//                for (int i = 0; i < 3; i++) {
//                    for (int j = 0; j < 4; j++)
//                       System.out.println( massive[i][j] + " ") ;
//                }

            } catch (ArrayIndexOutOfBoundsException e) {
                System.out.println(" Указанный индекс массива находиться за пределами исходного массива ");
                System.out.println(e.getMessage());
                e.printStackTrace();
            } finally {
                System.out.println(" Завершение работы пронраммы !");
            }
        }
    }


