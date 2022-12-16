import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {

        // Using ArrayList random 1000 numbers and Display them
        ArrayList<Integer> array = new ArrayList<Integer>();
        for (int i = 0; i < 1000; i++) {
            array.add((int) (Math.random() * 1000));
        }

        Long startTime = System.currentTimeMillis();

        // Using ArrayList
        SortingThread1 sortingThread1 = new SortingThread1(array, 0, 333);
        SortingThread2 sortingThread2 = new SortingThread2(array, 333, 666);

        sortingThread1.start();
        sortingThread2.start();

        // Display the unsorted array of sortingThread1
        System.out.println("Unsorted array of sortingThread1: " + sortingThread1.getArray());

        // Display the unsorted array of sortingThread2
        System.out.println("Unsorted array of sortingThread2: " + sortingThread2.getArray());


        try {
            sortingThread1.join();
            sortingThread2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // Display the sorted array of sortingThread1
        System.out.println("Sorted array of sortingThread1: " + sortingThread1.getArray());

        // Display the sorted array of sortingThread2
        System.out.println("Sorted array of sortingThread2: " + sortingThread2.getArray());

        // Using ArrayList
        MergeThread mergeThread = new MergeThread(array, new int[1000], 0, 666);
        mergeThread.start();

        try {
            mergeThread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // Display the sorted array of mergeThread
        System.out.println("Sorted array of mergeThread: " + mergeThread.getArray());

        Long endTime = System.currentTimeMillis();

        System.out.println("Total Time: " + (endTime - startTime));
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
