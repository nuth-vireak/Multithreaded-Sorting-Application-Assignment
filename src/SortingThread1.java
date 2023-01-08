import java.util.ArrayList;

public class SortingThread1 extends Thread {

    public ArrayList<Integer> array1;

    public SortingThread1(ArrayList<Integer> array1) {
        this.array1 = array1;
        BubbleSort.bubbleSort(array1);
        System.out.println("Array 1 after sorting: " + array1.toString());
    }

    @Override
    public void run() {
        super.run();
    }
}