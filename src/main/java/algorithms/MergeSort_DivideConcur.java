package algorithms;

import java.util.Arrays;

public class MergeSort_DivideConcur {

    public static void main(String[] args) {
        MergeSort_DivideConcur obj = new MergeSort_DivideConcur();

        int[] array = {10, 3, 4, 5, 38, 7, 98, 6};
        obj.mergeSort(array);
    }

    public void mergeSort(int[] array) {
        int[] temp = new int[array.length];
        mergeSort(array, temp,0, array.length -1);

        Arrays.stream(array).forEach(a -> {
            System.out.print(a);
            System.out.print(",");
        });
    }

    public void mergeSort(int[] array, int[] temp, int leftStart, int rightEnd) {
        if (leftStart >= rightEnd) {
            return;
        }
        int middle = (leftStart + rightEnd) / 2;
        mergeSort(array, temp, leftStart, middle);
        mergeSort(array, temp, middle + 1, rightEnd);

        merge(array, temp,leftStart, rightEnd);
    }


    public void merge(int[] array, int[] temp, int leftStart, int rightEnd) {
        int leftEnd = (leftStart + rightEnd) / 2;
        int rightStart = leftEnd + 1;
        int index = leftStart;
        int left = leftStart;
        int right = rightStart;

        while (left <= leftEnd && right <= rightEnd) {
            if (array[left] <= array[right]) {
                temp[index] = array[left];
                left++;
            } else {
                temp[index] = array[right];
                right++;
            }
            index++;
        }

        for (int i = left; i <= leftEnd; i++) {
            temp[index] = array[left];
            left++;
            index++;
        }
        for (int i = right; i <= rightEnd; i++) {
            temp[index] = array[right];
            right++;
            index++;
        }
        for (int i = leftStart; i <= rightEnd; i++) {
            array[i] = temp[i];
        }
    }
}
