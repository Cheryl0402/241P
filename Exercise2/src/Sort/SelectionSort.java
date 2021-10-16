package Sort;

public class SelectionSort {

    public void selectionSort(String[] arr){
        if(arr == null || arr.length == 0) return;
        for(int i = 0; i < arr.length - 1; i++){
            int minStrIdx = i;
            for(int j = i + 1; j < arr.length; j++){
                if(arr[j].compareTo(arr[minStrIdx]) <= 0){
                    minStrIdx = j;
                }
            }
            swap(arr, i, minStrIdx);
        }
    }

    public void swap(String arr[], int i, int j) {
        String temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public void print(String[] arr){
        if(arr == null || arr.length == 0){
            System.out.println("Null or Empty");
            return;
        }
        System.out.println("Selection Sort: ");
        for(int i = 0; i < arr.length; i++){
            System.out.print(arr[i] + " ");
        }
    }
}
