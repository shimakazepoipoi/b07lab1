//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//
//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//


import java.io.*;
import java.util.Scanner;

public class Polynomial {
    double[] c;
    int[] d;





    public Polynomial() {
        c = new double[0];
        d = new int[0];

    }

    public Polynomial(double[] arr, int[] arr1) {
        this.c = arr;
        this.d = arr1;
    }

    public Polynomial(File file) throws FileNotFoundException {
        Scanner file1 = new Scanner(file);
        String new_file = file1.nextLine();
        file1.close();

        new_file = new_file.replace("-", "+-");
        String[] result = new_file.split("\\+");

        this.c = new double[result.length];
        this.d = new int[result.length];

        for (int i = 0; i < result.length; i++) {
            String[] temp = result[i].split("x");
            this.c[i] = Double.parseDouble(temp[0]);
            this.d[i] = (temp.length == 1) ? 0 : Integer.parseInt(temp[1]);
        }


    }


    public void saveToFile(String filename) throws IOException {
        FileWriter temp = new FileWriter(filename);
        String result = "";

        for (int i = 0; i < this.c.length; i++) {
            if(i ==  this.c.length -1)
            {
                result += this.c[i] + "x" + this.d[i];
                break;
            }
            result += this.c[i] + "x" + this.d[i] + "+";
        }
        result = result.replace("+-", "-");
        result = result.replace("x0", "");
        result = result.replace(".0", "");
        temp.write(result);

        temp.close();
    }









    public Polynomial add(Polynomial arr) {
        int max;
        if (this.d[this.d.length - 1] > arr.d[arr.d.length - 1]) {
            max = this.d[this.d.length - 1];

        } else {
            max = arr.d[arr.d.length - 1];
        }

        int length = this.d.length;
        int a = 0;
        for(int i = 0; i < arr.d.length; i++)
        {
            for(int j = 0; j < this.d.length; j++)
            {
                if(this.d[j] == arr.d[i])
                {
                    a = 1;
                    if(this.c[j] + arr.c[i] == 0)
                    {
                        length = length - 1;
                    }
                }
            }

            if(a == 1)
                a = 0;
            else
            {
                length += 1;
            }


        }



        double[] new_c = new double[max + 1];

        for(int i = 0; i < this.c.length; i++)
        {
            new_c[this.d[i]] += this.c[i];
        }

        for(int i = 0; i < arr.c.length; i++)
        {
            new_c[arr.d[i]] += arr.c[i];
        }

        double[] result_c = new double[length];
        int[] result_d = new int[length];


        int j = 0;
        for (int i = 0; i < new_c.length; i++) {
            if (new_c[i] != 0) {
                result_c[j] = new_c[i];
                result_d[j] = i;
                j += 1;
            }
        }
        return new Polynomial(result_c, result_d);

    }


    public Polynomial multiply(Polynomial arr){
        int a = 0;
        int b = 0;
        int count = 0;
        int length = 0;
        int[] total1 = new int[arr.d.length*this.d.length];
        double[] total2 = new double[arr.d.length*this.d.length];

        for(int i = 0; i < arr.d.length; i++){
            for(int j = 0; j < this.d.length; j++){
                total1[count] = arr.d[i] + this.d[j];
                count ++;
            }

        }
        count = 0;
        for(int i = 0; i < arr.c.length; i++){
            for(int j = 0; j < this.d.length; j++){
                total2[count] = arr.c[i] * this.c[j];
                count ++;
            }

        }



        for(int i = 0; i < total1.length; i++){
            for(int j = 0; j < i; j++){
                if(total1[i] == total1[j]){
                    a = 1;
                }

            }
            if (a == 1){
                a = 0;
            }
            else{
                length ++;
            }

        }
        int[] result1 = new int[length];
        double[] result2 = new double[length];
        System.out.println("length" + length);
        count = 0;




        for(int i = 0; i < total1.length; i++){
            for(int j = 0; j < i; j++){
                if(total1[i] == total1[j]){
                    a = 1;
                }

            }
            if (a == 1){
                a = 0;
            }
            else{
                result1[count] = total1[i];
                count++;

            }

        }

        for(int i = 0; i < total1.length; i++){
            for(int j = 0; j < result1.length; j++){
                if(total1[i] == result1[j]){
                    result2[j] += total2[i];
                }


            }
        }
        return new Polynomial(result2, result1);
    }







    public double evaluate(double x) {
        double y = 0.0;

        for(int i = 0; i < this.c.length; ++i) {
            y += this.c[i] * Math.pow(x, this.d[i]);
        }

        return y;
    }

    public boolean hasRoot(double x) {
        return this.evaluate(x) == 0.0;
    }
}


