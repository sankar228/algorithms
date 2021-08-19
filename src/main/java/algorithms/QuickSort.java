package algorithms;

import java.util.Arrays;

public class QuickSort {
    public static void main(String[] args){
        QuickSort obj = new QuickSort();

        obj.sort(new int[]{10, 30, 5, 3, 1, 26});
    }

    public void sort(int[] list){
        list = sort(list, 0, list.length - 1);
        Arrays.stream(list).forEach(a -> System.out.println(a+","));
    }

    public int[] sort(int[] list, int low, int high){

        if(low >= high) return list;
        int pivot = (low + high) /2;

        int index = partition(list, low, high, pivot);
        sort(list, low, index -1);
        sort(list, index, high);

        return list;

    }

    public int partition(int[] list, int low, int high, int pivot){

        while(low <= high){
            while(list[low] < list[pivot]) {
                low++;
            }
            while(list[high] > list[pivot]){
                high --;
            }
            if(low < high) {
                swap(list, low, high);
            }
            low++;
            high--;
        }

        return low;
    }

    public void swap(int[] list, int low, int high){

        int temp = list[low];
        list[low] = list[high];
        list[high] = temp;
    }

}
