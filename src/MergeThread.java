
import java.util.ArrayList;

public class MergeThread extends Thread {

    public SortingThread1 sortingThread1;
    public SortingThread2 sortingThread2;

    public MergeThread(SortingThread1 sortingThread1, SortingThread2 sortingThread2) {
        this.sortingThread1 = sortingThread1;
        this.sortingThread2 = sortingThread2;
    }

    @Override
    public void run() {
        super.run();

        mergeSortingThread1And2();
    }

    private void mergeSortingThread1And2() {
        ArrayList<Integer> array1 = sortingThread1.array1;
        ArrayList<Integer> array2 = sortingThread2.array2;

        ArrayList<Integer> mergedArray = new ArrayList<>();

        int i = 0;
        int j = 0;

        while (i < array1.size() && j < array2.size()) {
            if (array1.get(i) < array2.get(j)) {
                mergedArray.add(array1.get(i));
                i++;
            } else {
                mergedArray.add(array2.get(j));
                j++;
            }
        }

        while (i < array1.size()) {
            mergedArray.add(array1.get(i));
            i++;
        }

        while (j < array2.size()) {
            mergedArray.add(array2.get(j));
            j++;
        }

        System.out.println("Merged array: " + mergedArray.toString());
    }
}
