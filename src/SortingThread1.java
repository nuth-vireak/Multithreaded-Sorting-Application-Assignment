import java.util.ArrayList;

public class SortingThread1 extends Thread {

    // using ArrayList
    private ArrayList<Integer> array;
    private int start;
    private int end;

    public SortingThread1(ArrayList<Integer> array, int start, int end) {
        this.array = array;
        this.start = start;
        this.end = end;
    }

    public void run() {
        bubbleSort(array, start, end);
    }

    private void bubbleSort(ArrayList<Integer> array, int start, int end) {
        for (int i = start; i < end; i++) {
            for (int j = start; j < end - 1; j++) {
                if (array.get(j) > array.get(j + 1)) {
                    int temp = array.get(j);
                    array.set(j, array.get(j + 1));
                    array.set(j + 1, temp);
                }
            }
        }
    }

    public String getArray() {
        return array.toString();
    }
}

