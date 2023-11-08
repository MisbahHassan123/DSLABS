public class PQSorted {
    private int[] array;
    private int size;

    public PQSorted(int capacity) {
        array = new int[capacity];
        size = 0;
    }

    public void insert(int data) {
        if (size == array.length) {
            System.out.println("Queue is full. Cannot insert.");
            return;
        }

        // Find the index where the new element should be inserted.
        int insertIndex = 0;
        while (insertIndex < size && array[insertIndex] < data) {
            insertIndex++;
        }

        // Shift elements to the right to make space for the new element.
        for (int i = size; i > insertIndex; i--) {
            array[i] = array[i - 1];
        }

        // Insert the new element at the correct position and increase the size.
        array[insertIndex] = data;
        size++;
    }

    public int extractMax() {
        if (size == 0) {
            System.out.println("Queue is empty. Cannot extract max.");
            return -1;
        }

        int maxValue = array[size - 1];
        size--;

        return maxValue;
    }

    public int getMax() {
        if (size == 0) {
            System.out.println("Queue is empty. Cannot get max.");
            return -1;
        }

        return array[size - 1];
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
    	PQSorted pq = new PQSorted(10);

        pq.insert(6);
        pq.insert(4);
        pq.insert(8);

        System.out.println("Max value: " + pq.getMax());

        pq.extractMax();

        System.out.println("Max value after extraction: " + pq.getMax());

        System.out.println("Search for value 4: " + pq.searchData(4));
        System.out.println("Search for value 10: " + pq.searchData(10));
    }
}
