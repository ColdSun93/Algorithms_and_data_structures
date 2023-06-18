package hw_2;

public class pyramid {

    public static void main(String[] args) {
        int[] arrayIn = { 7, 2, 1, 6, 3, 4, 8, 5, 7 };
        printArr(arrayIn);
        heapsort(arrayIn);
        printArr(arrayIn);
    }

    private static void printArr(int[] arr) {
        System.out.println();
        for (int i : arr) {
            System.out.print(i + ", ");
        }
    }

    private static void heapsort(int[] arr) {
        int n = arr.length;
        int i = (n - 2) / 2;

        while (i >= 0) {
            heapify(arr, i--, n);
        }
        while (n > 0) {
            arr[n - 1] = pop(arr, n);
            n--;
        }
    }

    private static void heapify(int[] arr, int i, int size) {
        int left = 2 * i + 1;
        int right = 2 * i + 2;
        int largest = i;

        if (left < size && arr[left] > arr[i]) {
            largest = left;
        }
        if (right < size && arr[right] > arr[largest]) {
            largest = right;
        }

        if (largest != i) {
            swapElemArr(arr, i, largest);
            heapify(arr, largest, size);
        }
    }

    private static int pop(int[] arr, int size) {
        if (size <= 0)
            return -1;

        int top = arr[0];
        arr[0] = arr[size - 1];
        heapify(arr, 0, size - 1);
        return top;
    }

    private static void swapElemArr(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
    
}