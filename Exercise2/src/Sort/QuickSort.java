package Sort;
import java.util.Collection;


public class QuickSort {

    public void quickSort(String[] arr){
        if(arr == null || arr.length == 0) return;
        quickSort(arr, 0, arr.length -1);
    }

    public void quickSort(String[] arr, int left, int right){
        if(left < right){
            int pivotIdx = partition(arr, left, right);  // choose pivot
            quickSort(arr, left, pivotIdx - 1);   // sort the smaller part
            quickSort(arr, pivotIdx + 1, right);   // sort the larger part
        }
    }

    // partition
    private int partition(String[] arr, int left, int right){
        String pivot = arr[right];  // choose the right element as pivot
        int idx = left;           // smaller element idx starting from left
        for(int j = left; j < right; j++){
            if(arr[j].compareTo(pivot) <= 0){    // check if current element is less than or equal to pivot
                swap(arr, idx, j);              //swap arr[i] and arr[j]
                idx++;
            }
        }
        swap(arr, idx , right);  // restore pivot
        return idx;
    }

    // swap method
    private void swap(String[] arr, int i, int j){
            String temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;
    }

    public void print(String[] arr){
        System.out.println("\nQuickSort:");
        for(String str : arr){
            System.out.print(str + " ");
        }
    }
}
