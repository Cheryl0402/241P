package Sort;

public class HeapSort {
    private int size = 0;
    private String[] heap;


    // Heap sort
    public void heapSort(String[] arr){
        if(arr == null || arr.length == 0) return;
        buildHeap(arr);
        for(int i = 0; i < arr.length; i++){
            arr[i] = extractMin();
        }
    }

    //1, build a min heap from the input data; index 1 based.
    private void buildHeap(String[] arr){
        this.heap = new String[arr.length + 1];
        for(int i = 0; i < arr.length; i++){
            insert(arr[i]);
        }
    }

    //2, insert
    private void insert(String s){
        int curr = size + 1;  //The next available place index.[Index starting from 1]
         //heap[0] used as a temporary container.
        // In this way, we don't need to assign 3 times for each swap
        heap[0] = s;
        // bubble up if parent is larger than curr element
        while(heap[curr / 2].compareTo(s) > 0){

            heap[curr] = heap[curr / 2];
            curr /= 2;
        }
        //else insert the element to curr location
        heap[curr] = s;
        size++;
    }

    private String extractMin(){
        if(heap == null) return "Error: Empty Heap!!!";
        String minStr = heap[1];
        heap[1] = heap[size];
        size--;
        bubbleDown(1);
        return minStr;

    }

    private void bubbleDown(int hole){
        int child;
        String temp = heap[hole];
        while(hole * 2 <= size){
            child = hole * 2;
            if(child != size && heap[child].compareTo(heap[child + 1]) > 0){ // find the smaller child
                child++;
            }
            if(heap[child].compareTo(temp) < 0){ // compare child to temp string, if child is smaller, put child to the hole
                heap[hole] = heap[child];
            }else{
                break;                          // else break from the loop, assign temp to the hole.
            }
            hole = child;  // hole index advance to child index
        }
        heap[hole] = temp;
    }

    public void printHeap(String[] arr){
      System.out.println("\nHeap Sort: ");
      for(String str : arr){
          System.out.print(str + " ");
      }
    }
}
