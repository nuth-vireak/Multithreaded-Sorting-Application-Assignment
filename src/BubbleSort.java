import java.util.ArrayList;

public class BubbleSort {

    public static void bubbleSort(ArrayList<Integer> array) {
        int n = array.size();
        int temp = 0;

        for (int i = 0; i < n; i++) {
            for (int j = 1; j < (n - i); j++) {
                if (array.get(j - 1) > array.get(j)) {
                    // Swap elements
                    temp = array.get(j - 1);
                    array.set(j - 1, array.get(j));
                    array.set(j, temp);
                }
            }
        }
    }
}
