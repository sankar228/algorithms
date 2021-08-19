package algorithms;

public class SumoFDigits {
    public static void main(String[] args) {
        SumoFDigits obj = new SumoFDigits();

        System.out.println(obj.sumofDigits(1678));
    }

    int sumofDigits(int n){
        if ( n <=9) return n;
        else{
            return n%10 + sumofDigits(n/10);
        }
    }
}
