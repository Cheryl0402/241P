package Sort;
import com.sun.org.apache.bcel.internal.generic.Select;

import java.io.FileReader;
import java.io.File;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.io.FileNotFoundException;


public class Main {

    public static void main(String[] args) throws FileNotFoundException{
        //open file
        File file = new File("/Users/cheryl/UCI Exercise/241 P/Exercise2/src/pride-and-prejudice.txt");
        //read file
        Scanner scan = new Scanner(new FileReader(file));

        // create lists to store words from the text file.
        List<String> ssArray = new ArrayList<String>();
        List<String> hsArray = new ArrayList<String>();
        List<String> isArray = new ArrayList<String>();
        List<String> msArray = new ArrayList<String>();
        List<String> qsArray = new ArrayList<String>();

        int idx = 0;
        while(scan.hasNextLine()){
            //tokenize
            String str = scan.nextLine();
            str = str.replaceAll("[^a-zA-Z0-9]", " ");
            str.trim();
            String[] words = str.split(" ");

            // add words to arrays.
            for(String word : words){
                if(word != null && word.matches("[a-zA-Z_0-9]+")){
                    ssArray.add(word);
                    hsArray.add(word);
                    isArray.add(word);
                    msArray.add(word);
                    qsArray.add(word);
                    idx++;
                }
            }
        }
        System.out.println("Total number of words added: " + idx);


    //********************************************* Test Selection Sort ************************************************
        SelectionSort ss = new SelectionSort();
        long ssStartTime = System.nanoTime();
        ss.selectionSort(ssArray.toArray(new String[0]));
        long ssEndTime = System.nanoTime();
        System.out.println("Selection sort time: " + (ssEndTime - ssStartTime) + " nanoseconds");


    //********************************************* Test Insertion Sort ************************************************
        InsertionSort is = new InsertionSort();
        long isStartTime = System.nanoTime();
        is.insertionSort(isArray.toArray(new String[0]));
        long isEndTime = System.nanoTime();
        System.out.println("Insertion sort time: " + (isEndTime - isStartTime) + " nanoseconds");


    //********************************************* Test Heap Sort *****************************************************
        HeapSort hs = new HeapSort();
        long hsstartTime = System.nanoTime();
        hs.heapSort(hsArray.toArray(new String[0]));
        long hsendTime = System.nanoTime();
        System.out.println("Heap sort time: " + (hsendTime - hsstartTime) + " nanoseconds");


    //********************************************* Test Merge Sort ****************************************************
        MergeSort ms = new MergeSort();
        long msStartTime = System.nanoTime();
        ms.mergeSort(msArray.toArray(new String[0]));
        long msEndTime = System.nanoTime();
        System.out.println("Merge sort time: " + (msEndTime - msStartTime) + " nanoseconds");


    // ********************************************* Test Selection Sort ***********************************************
        QuickSort qs = new QuickSort();
        long qsStartTime = System.nanoTime();
        qs.quickSort(qsArray.toArray(new String[0]));
        long qsEndTime = System.nanoTime();
        System.out.println("Quick sort time: " + (qsEndTime - qsStartTime) + " nanoseconds");
    }
}
