import java.util.ArrayList;

public class SortingThread2 extends Thread {

    public ArrayList<Integer> array2;

    public SortingThread2(ArrayList<Integer> array2) {
        this.array2 = array2;
        BubbleSort.bubbleSort(array2);
        System.out.println("Array 2 after sorting: " + array2.toString());
    }

    @Override
    public void run() {
        super.run();
    }
}
