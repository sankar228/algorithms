package algorithms;

import java.util.Arrays;

public class TwoSum {
    public static void main(String[] args) {
        TwoSum obj = new TwoSum();
        int[] a = {2, 3, 6, 4, 5};
        int[] result = obj.twoSum_On(a, 10);
        System.out.println(result[0]+","+result[1]);
    }

    //This approch takes O(n2) time complexity, there is a better approch for O(n)
    public int[] twoSum_On2(int[] a, int totalSum) {
        int[] result = new int[2];
        for (int i = 0; i < a.length; i++) {
            for (int j = i + 1; j < a.length; j++) {
                int sum = a[i] + a[j];

                if (sum > totalSum) {
                    break;
                }

                if (sum == totalSum) {
                    result[0] = a[i];
                    result[1] = a[j];
                    return result;
                }
            }
        }

        return result;
    }

    public int[] twoSum_On(int[] a, int totalSum){

        int[] result = new int[2];
        //sort the array = O(nlogn)
        Arrays.sort(a);

        int i = 0, j = a.length -1;
        while(i <= j){
            if((a[i] + a[j]) < totalSum){
                i++;
            }else if((a[i] + a[j]) > totalSum){
                j--;
            }else{
                result[0] = a[i];
                result[1] = a[j];

                return result;
            }
        }

        return result;
    }
}
