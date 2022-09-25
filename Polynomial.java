import java.lang.Math;

public class Polynomial {
    private double[]  c;

    public Polynomial() {
        c = new double[0];
    }

    public Polynomial(double[] arr) {
        c = arr;
    }

    public Polynomial add(Polynomial arr){
        int length;
        boolean thisLonger;
        int length2;
        if (this.c.length > arr.c.length){
            length = arr.c.length;
            length2 = this.c.length;
            thisLonger = true;
        }
        else{
            length = this.c.length;
            length2 = arr.c.length;
            thisLonger = false;
        }
        double[] result = new double[length2];


        for (int i = 0; i < length; i++)
        {
            result[i] = arr.c[i] + this.c[i];
        }


        if (thisLonger){
            for(int j = length; j < length2; j++){
                result[j] = this.c[j];
            }
        }
        else {
            for (int j = length; j < length2; j++) {
                result[j] = arr.c[j];
            }
        }
        Polynomial result2 = new Polynomial(result);
        return result2;
    }

    public double evaluate(double x){
        double y = 0;
        for(int i = 0; i < this.c.length; i++){
            y += Math.pow(x, i) * c[i];
        }
        return y;
    }

    public boolean hasRoot(double x){
        if (this.evaluate(x) == 0){
            return true;
        }
        return false;
    }

}