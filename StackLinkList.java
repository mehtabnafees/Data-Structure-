import java.util.Scanner; // Import Scanner for user input

// Stack using Linked List
public class StackLinkList {
    private static class Node {
        int data; // Data stored in the node
        Node next; // Pointer to the next node

        Node(int data) {
            this.data = data; // Initialize data
            next = null; // Set next as null
        }
    }

    static class Stack {
        public static Node head = null; // Top of the stack

        // Push operation (Insert at the top)
        public static void push(int data) {
            Node newNode = new Node(data); // Create new node
            newNode.next = head; // New node points to current top
            head = newNode; // Update top to new node
            System.out.println(data + " pushed into stack.");
        }

        // Check if stack is empty
        public static boolean isEmpty() {
            return head == null;
        }

        // Pop operation (Remove from the top)
        public static int pop() {
            if (isEmpty()) {
                System.out.println("Stack is empty. Nothing to pop.");
                return -1;
            }
            int poppedData = head.data; // Get top data
            head = head.next; // Move top to the next node
            System.out.println(poppedData + " popped from stack.");
            return poppedData;
        }

        // Peek operation (Check the top element)
        public static int peek() {
            if (isEmpty()) {
                System.out.println("Stack is empty. No top element.");
                return -1;
            }
            return head.data; // Return top element
        }

        // Display stack elements
        public static void display() {
            if (isEmpty()) {
                System.out.println("Stack is empty.");
                return;
            }
            Node temp = head;
            System.out.print("Stack: ");
            while (temp != null) { // Traverse stack
                System.out.print(temp.data + " -> ");
                temp = temp.next;
            }
            System.out.println("null");
        }
    }

    // Main method with menu-driven system
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in); // Scanner for user input
        Stack stack = new Stack(); // Create stack object
        int choice, value;

        // Menu loop
        do {
            System.out.println("\nSTACK MENU:");
            System.out.println("1. Push");
            System.out.println("2. Pop");
            System.out.println("3. Peek");
            System.out.println("4. Display Stack");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");
            choice = sc.nextInt(); // Read user choice

            switch (choice) {
                case 1:
                    System.out.print("Enter value to push: ");
                    value = sc.nextInt();
                    stack.push(value);
                    break;
                case 2:
                    stack.pop();
                    break;
                case 3:
                    System.out.println("Top element is: " + stack.peek());
                    break;
                case 4:
                    stack.display();
                    break;
                case 5:
                    System.out.println("Exiting...");
                    break;
                default:
                    System.out.println("Invalid choice! Please try again.");
            }
        } while (choice != 5); // Loop until exit option is chosen
    }
}
