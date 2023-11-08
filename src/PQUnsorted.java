public class PQUnsorted {
    private int[] array;
    private int size;

    public PQUnsorted(int capacity) {
        array = new int[capacity];
        size = 0;
    }

    public void insert(int data) {
        if (size == array.length) {
            System.out.println("Queue is full. Cannot insert.");
            return;
        }

        array[size] = data;
        size++;
    }

    public int extractMax() {
        if (size == 0) {
            System.out.println("Queue is empty. Cannot extract max.");
            return -1;
        }

        int maxIndex = 0;
        for (int i = 1; i < size; i++) {
            if (array[i] > array[maxIndex]) {
                maxIndex = i;
            }
        }

        int maxValue = array[maxIndex];

        // Remove the maximum value by moving the last element to the maxIndex and reducing the size.
        array[maxIndex] = array[size - 1];
        size--;

        return maxValue;
    }

    public int getMax() {
        if (size == 0) {
            System.out.println("Queue is empty. Cannot get max.");
            return -1;
        }

        int maxIndex = 0;
        for (int i = 1; i < size; i++) {
            if (array[i] > array[maxIndex]) {
                maxIndex = i;
            }
        }

        return array[maxIndex];
    }

    public boolean searchData(int data) {
        for (int i = 0; i < size; i++) {
            if (array[i] == data) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
    	PQUnsorted pq = new PQUnsorted(10);

        pq.insert(7);
        pq.insert(3);
        pq.insert(5);

        System.out.println("Max value: " + pq.getMax());

        pq.extractMax();

        System.out.println("Max value after extraction: " + pq.getMax());

        System.out.println("Search for value 3: " + pq.searchData(3));
        System.out.println("Search for value 10: " + pq.searchData(10));
    }
}
