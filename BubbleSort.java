public class BubbleSort {
    public static void bubbleSort(int[] arr) {
        int n = arr.length;
        for (int i = 0; i < n - 1; i++) { // Number of passes
            for (int j = 0; j < n - i - 1; j++) { // Compare adjacent elements
                if (arr[j] > arr[j + 1]) { // Swap if needed
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }
    }

    public static void main(String[] args) {
        int[] arr = {50, 20, 40, 10, 30};
        bubbleSort(arr);
        System.out.print("Sorted Array: ");
        for (int num : arr) System.out.print(num + " ");
    }
}
