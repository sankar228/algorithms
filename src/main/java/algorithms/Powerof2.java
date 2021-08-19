package algorithms;

public class Powerof2 {
    public static void main(String[] args) {
        Powerof2 obj = new Powerof2();

        //obj.powerOf2(50);
        System.out.println(obj.power(5, 1));
    }

    int powerOf2(int n){
        if(n <= 0) return 0;
        else if(n == 1) {
            System.out.println(1);
            return 1;
        }else{
            int prev = powerOf2(n/2);
            int curr = prev * 2;
            System.out.println(curr);
            return curr;
        }
    }

    /*void power(int a, int b){
        int pow = 1;

        for(int i=0; i<b; i++){
            pow *= a;
        }
        System.out.println(pow);
    }*/

    //using recursion
    int power(int a, int b){
        if(b ==1) return a;
        else{
            return a * power(a, b -1);
        }
    }
}
