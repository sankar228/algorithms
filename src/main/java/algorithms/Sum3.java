package algorithms;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Sum3 {

    public static void main(String[] args) {
        Sum3 obj = new Sum3();

        List<List<Integer>> result = obj.threeSum(new int[]{0,0,0});

        result.forEach(l -> {
           l.forEach(v -> System.out.print(v+" , "));
        });
    }

    public List<List<Integer>> threeSum(int[] nums) {

        Arrays.sort(nums);
        List<List<Integer>> result = new ArrayList<>();
        int sum = 0;

        if(nums.length ==0 ) return result;
        if(nums.length < 3) {
            return result;
        }

        //-4,-1,-1,0,1,2
        for(int i=0; i <= nums.length -3; i++){
            int left = i + 1;
            int right = nums.length -1;

            while(left < right){
                if(i > 0 && nums[i] == nums[i -1]) {
                    left ++;
                    continue;
                }else if(right < nums.length -1 && nums[right] == nums[right +1]){
                    right --;
                    continue;
                }
                sum = nums[i] + nums[left] + nums[right];
                if( sum == 0){
                    List<Integer> subList = new ArrayList();
                    subList.add(nums[i]);
                    subList.add(nums[left]);
                    subList.add(nums[right]);

                    result.add(subList);

                    right --;
                }else if(sum > 0){
                    right --;
                }else {
                    left ++;
                }
            }
        }

        return result;

    }
}
