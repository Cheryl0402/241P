package Sort;

public class MergeSort {
    //O(nlogn) time
    //O(n) space

    public void mergeSort(String[] arr){
        String[] temp = new String[arr.length];
        mergeSort(arr, temp, 0, arr.length-1);
    }

    public void mergeSort(String[] arr, String[] temp, int left, int right){
        if(left >= right) return;
        //int leftStart = left, rightEnd = right;
        int mid = (left + right) / 2;

        //mergeSort left half
        mergeSort(arr,temp, left, mid);

        //mergeSort right half
        mergeSort(arr, temp,mid + 1, right);

        //merge two halves
        merge(arr, temp, left, right);
    }

    public void merge(String[] arr, String[] temp, int leftStart, int rightEnd){
        int mid = (leftStart + rightEnd) / 2;
        int leftEnd = mid, rightStart = mid + 1;
        int idx = leftStart;
        int l = leftStart, r = rightEnd;

        //walk through each half, copy the smaller one into the curr array container.
        while(leftStart <= leftEnd && rightStart <= rightEnd){
            if(arr[leftStart].compareTo(arr[rightStart]) < 0){
                temp[idx] = arr[leftStart];
                leftStart++;
            }else{
                temp[idx] = arr[rightStart];
                rightStart++;
            }
            idx++;
        }

        //deal with the leftover elements. Copy the left elements into curr array.
        for(int i = leftStart; i <= leftEnd; i++){
            temp[idx] = arr[i];
            idx++;
        }

        for(int i = rightStart; i <= rightEnd; i++){
            temp[idx] = arr[i];
            idx++;
        }

        // copy sorted curr array back to array
        for(int i = l; i <= r; i++){
            arr[i] = temp[i];
        }
    }

    public void print(String[] arr){
        System.out.println("\nMergeSort:");
        for(String str : arr){
            System.out.print(str + " ");
        }
    }

}
