package Sort;

public class InsertionSort {

    public void insertionSort(String[] arr){
        for(int i = 0; i < arr.length; i++){ // iterate through to insert
            String temp = arr[i];  // temp store curr element needs to be inserted

            // need to  iterate through all previous existed items
            // compare the previous one with temp, while the previous one is larger than the temp, keep going for exchange.
            int j = i;
            while( j > 0 && arr[j-1].compareTo(temp) > 0){
                arr[j] = arr[j - 1];                        // curr location gets the value of the previous one.
                j--;
            }
            arr[j] = temp;  // else we put the temp to curr place.
        }

        // for our worse case, iterate needs 0(n);
        //inside the iterate loop, each comparasion will needs 0(n);
        // So the time complexity is O(n^2);
    }

    public void print(String[] arr){
        System.out.println("\nInsertion sort: ");
        for(int i = 0; i < arr.length; i++){
            System.out.print(arr[i] + " ");
        }
    }

}
