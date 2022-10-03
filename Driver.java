




import java.io.*;
import java.util.Scanner;

public class Driver {
    public static void main(String [] args) throws IOException {

        double [] a1 = {6, -2, 5};
        int [] a2 = {0, 1, 3};
        Polynomial a = new Polynomial(a1, a2);


        double[] b1 = {1, 2, 3};
        int[]    b2 = {1, 2, 3};
        Polynomial b = new Polynomial(b1, b2);


        Polynomial together = a.add(b);
        for (int i = 0; i < together.c.length; i++)
            System.out.print(together.c[i] + " ");
        System.out.println();

        for (int i = 0; i < together.d.length; i++)
            System.out.print(together.d[i] + " ");
        System.out.println();



        together = a.multiply(b);
        for (int i = 0; i < together.c.length; i++)
            System.out.print(together.c[i] + " ");
        System.out.println();

        for (int i = 0; i < together.d.length; i++)
            System.out.print(together.d[i] + " ");
        System.out.println();




        File poi = new File("C:\\Users\\Administrator\\Desktop\\Lab\\poi.txt");
        Polynomial c = new Polynomial(poi);

        for (int i = 0; i < c.c.length; i++)
            System.out.print(c.c[i] + " ");
        System.out.println();

        for (int i = 0; i < c.d.length; i++)
            System.out.print(c.d[i] + " ");
        System.out.println();
        c.saveToFile("output.txt");


    }
}
