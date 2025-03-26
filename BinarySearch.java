import java.util.Scanner;

public class BinarySearch {
    // Binary search function (Iterative) - Binary search function (Iterative)
    public static int binarySearch(int[] arr, int target) {
        int left = 0, right = arr.length - 1; // Left aur right pointers initialize kar rahe hain

        while (left <= right) {
            int mid = left + (right - left) / 2; // Integer overflow se bachne ke liye mid calculate kar rahe hain

            if (arr[mid] == target) {
                return mid; // Target mil gaya
            } else if (arr[mid] < target) {
                left = mid + 1; // Right half mein search kar rahe hain
            } else {
                right = mid - 1; // Left half mein search kar rahe hain
            }
        }
        return -1; // Target nahi mila
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in); // Scanner object bana rahe hain
        int[] arr = {10, 20, 30, 40, 50}; // Sorted array define kar rahe hain

        System.out.print("Enter number to search: "); // User se number input lene ke liye keh rahe hain
        int target = sc.nextInt(); // User ka input read kar rahe hain

        int result = binarySearch(arr, target); // Search perform kar rahe hain

        if (result != -1) {
            System.out.println("Element found at index: " + result); // Element mil gaya to uska index print kar rahe hain
        } else {
            System.out.println("Element not found."); // Element nahi mila
        }

        sc.close(); // Scanner object close kar rahe hain
    }
}
