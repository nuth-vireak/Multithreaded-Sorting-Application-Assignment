import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    static Scanner input = new Scanner(System.in);

    public static void main(String[] args) throws InterruptedException {

        System.out.println("----------------------------------");
        System.out.println("------ Multi Thread Sorting ------");
        System.out.println("----------------------------------");

        // Input random array
        System.out.print("Enter array size: ");
        int size = input.nextInt();

        ArrayList<Integer> array = new ArrayList<>();
        for (int i = 0; i < size; i++) {
            array.add((int) (Math.random() * 100));
        }

        System.out.println("Array: " + array.toString());

        // Divide array into two parts
        ArrayList<Integer> array1 = new ArrayList<>();
        ArrayList<Integer> array2 = new ArrayList<>();

        for (int i = 0; i < array.size(); i++) {
            if (i < array.size() / 2) {
                array1.add(array.get(i));
            } else {
                array2.add(array.get(i));
            }
        }

        // Display array1 and array2
        System.out.println("Array 1: " + array1.toString());
        System.out.println("Array 2: " + array2.toString());

        // Create two threads for sorting
        SortingThread1 sortingThread1 = new SortingThread1(array1);
        SortingThread2 sortingThread2 = new SortingThread2(array2);

        // Start two threads
        sortingThread1.start();
        sortingThread2.start();

        // Wait for two threads to finish
        sortingThread1.join();
        sortingThread2.join();

        // Create a thread for merging
        MergeThread mergeThread = new MergeThread(sortingThread1, sortingThread2);

        // Start the thread
        mergeThread.start();

        // Wait for the thread to finish
        mergeThread.join();

        System.out.println("Done!");
    }
}

//    // Using ArrayList random 1000 numbers
//    ArrayList<Integer> array = new ArrayList<Integer>();
//        for (int i = 0; i < 1000; i++) {
//        array.add((int) (Math.random() * 1000));
//        }
//
//        Long startTime = System.currentTimeMillis();
//        SortingThread1 sortingThread1 = new SortingThread1(array, 0, 333);
//        SortingThread2 sortingThread2 = new SortingThread2(array, 333, 666);
//
//        sortingThread1.start();
//        sortingThread2.start();
//
//        try {
//        sortingThread1.join();
//        sortingThread2.join();
//        } catch (InterruptedException e) {
//        e.printStackTrace();
//        }
//
//        MergeThread mergeThread = new MergeThread(array, new int[1000], 0, 666);
//        mergeThread.start();
//
//        try {
//        mergeThread.join();
//        } catch (InterruptedException e) {
//        e.printStackTrace();
//        }
//
//        Long endTime = System.currentTimeMillis();
//        System.out.println("Time: " + (endTime - startTime));
