package Set;

import javafx.beans.binding.When;

import java.io.*;
import java.util.HashSet;
import java.util.TreeSet;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws FileNotFoundException, IOException{

        LinkedListSet listSet = new LinkedListSet();
        BinaryTreeSet treeSet = new BinaryTreeSet();
        HashTableSet hashSet = new HashTableSet();

       //**************************** Test Add ***********************************
        //Sources I learn reading text file: https://www.youtube.com/watch?v=lHFlAYaNfdo
        //open the file
        File file = new File("/Users/cheryl/UCI Exercise/241 P/Exercise 1/Set/src/Set/pride-and-prejudice.txt");
        Scanner scanner = new Scanner(new FileReader(file));  // read the file
        FileWriter writer1 = new FileWriter("LinkedList.csv");
        FileWriter writer2 = new FileWriter("TreeList.csv");
        FileWriter writer3 = new FileWriter("HashTable.csv");

        int count = 0;
        while(scanner.hasNextLine()){
            String str = scanner.nextLine();
            str = str.replaceAll("[^a-zA-Z_0-9]", " "); // replace non letter or non number with white space
            str.trim(); // remove leading and tail white spaces.
            String[] words = str.split(" ");

            //for each line of words,  add words to set
            for(String word: words){
                count++;
                long listStartTime = System.nanoTime();
                listSet.add(word);
                long listEndTime = System.nanoTime();
                long elapsedTime =listEndTime - listStartTime;
                writer1.append(Long.toString(elapsedTime));
                writer1.append("\n");
               // System.out.println((listEndTime - listStartTime));

                long treeStartTime = System.nanoTime();
                treeSet.add(word);
                long treeEndTime = System.nanoTime();
                writer2.append(Long.toString(treeEndTime - treeStartTime));
                writer2.append("\n");
               // System.out.println("It takes " + (treeEndTime - treeStartTime) + " nanoSeconds to add the word in listSet");
//
                long hashStartTime = System.nanoTime();
                hashSet.add(word);
                long hashEndTime = System.nanoTime();
                writer3.append(Long.toString(hashEndTime - hashStartTime));
                writer3.append("\n");
//                System.out.println("It takes " + (hashEndTime - hashStartTime) + " nanoSeconds to add the word in listSet");

            }


        }
        writer1.flush();
        writer1.close();
        writer2.flush();
        writer2.close();
        writer3.flush();
        writer3.close();






        // System.out.println("It takes " + duration + " nanoSeconds to insert to listSet");
        System.out.println();
        System.out.println("total words: " + count);
        System.out.println("LinkedList set size: " + listSet.size());
        System.out.println("Binary Tree set size: " + treeSet.size());
        System.out.println("HashTable set size: " + hashSet.size());

        //***************** Test Search ********************************
        File fileForSearch = new File("/Users/cheryl/UCI Exercise/241 P/Exercise 1/Set/src/Set/words-shuffled.txt");
        Scanner scan = new Scanner(fileForSearch);
        int listSetCounter = 0, treeSetCounter = 0, hashSetCounter = 0, counter = 0;
        while(scan.hasNextLine()){
            String s = scan.nextLine();
            s = s.replaceAll("[^a-zA-Z_0-9]", " ");
            s.trim();
            String[] contents = s.split(" ");

            for(String content : contents){
                counter++;
                long startTime = System.nanoTime();
                if(!listSet.contains(content)){
                    listSetCounter++;
                }
                long endTime = System.nanoTime();
                long duration1 = (endTime - startTime);
                //System.out.println("It takes " + duration1 + " nanoSeconds to add the word in listSet");


                if(!treeSet.contains(content)){
                    treeSetCounter++;
                }

                if(!hashSet.contains(content)){
                    hashSetCounter++;
                }
            }
        }
        System.out.println();
        System.out.println("counter: " + counter);
        System.out.println(listSetCounter + " does not exist in listSet.");
        System.out.println(treeSetCounter + " does not exist in treeSet.");
        System.out.println(hashSetCounter + " does not exist in hashSet.");

    }
}
