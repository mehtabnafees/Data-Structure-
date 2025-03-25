import java.util.Scanner; // Import Scanner for user input

// Circular Queue using Doubly Linked List
public class CircularQueueDoubly {
    private static class Node {
        int data; // Data stored in the node
        Node next; // Pointer to the next node
        Node prev; // Pointer to the previous node

        public Node(int data) {
            this.data = data;
            this.next = null;
            this.prev = null;
        }
    }

    static class CircularQueue {
        Node front, rear; // Front and rear pointers

        public CircularQueue() {
            front = rear = null; // Initialize empty queue
        }

        // Enqueue (Insert at rear)
        public void enqueue(int data) {
            Node newNode = new Node(data); // Create a new node
            if (front == null) { // If queue is empty
                front = rear = newNode;
                front.next = front; // Circular connection
                front.prev = front;
            } else {
                rear.next = newNode; // Link new node at rear
                newNode.prev = rear;
                newNode.next = front; // Connect last node to front
                front.prev = newNode;
                rear = newNode; // Update rear pointer
            }
            System.out.println(data + " enqueued into queue.");
        }

        // Dequeue (Remove from front)
        public int dequeue() {
            if (front == null) { // If queue is empty
                System.out.println("Queue is empty! Nothing to dequeue.");
                return -1;
            }
            int removedData = front.data; // Get front data
            if (front == rear) { // If only one element exists
                front = rear = null;
            } else {
                front = front.next; // Move front to the next node
                front.prev = rear;
                rear.next = front;
            }
            System.out.println(removedData + " dequeued from queue.");
            return removedData;
        }

        // Peek (Show front element)
        public int peek() {
            if (front == null) {
                System.out.println("Queue is empty! No front element.");
                return -1;
            }
            return front.data;
        }

        // Display the queue elements
        public void display() {
            if (front == null) {
                System.out.println("Queue is empty.");
                return;
            }
            Node temp = front;
            System.out.print("Queue: ");
            do {
                System.out.print(temp.data + " <-> ");
                temp = temp.next;
            } while (temp != front);
            System.out.println("(back to front)");
        }
    }

    // Main method with a menu-driven system
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in); // Scanner for user input
        CircularQueue queue = new CircularQueue(); // Create CircularQueue object
        int choice, value;

        // Menu loop
        do {
            System.out.println("\nCIRCULAR QUEUE MENU:");
            System.out.println("1. Enqueue");
            System.out.println("2. Dequeue");
            System.out.println("3. Peek");
            System.out.println("4. Display Queue");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");
            choice = sc.nextInt(); // Read user choice

            switch (choice) {
                case 1:
                    System.out.print("Enter value to enqueue: ");
                    value = sc.nextInt();
                    queue.enqueue(value);
                    break;
                case 2:
                    queue.dequeue();
                    break;
                case 3:
                    System.out.println("Front element is: " + queue.peek());
                    break;
                case 4:
                    queue.display();
                    break;
                case 5:
                    System.out.println("Exiting...");
                    break;
                default:
                    System.out.println("Invalid choice! Please try again.");
            }
        } while (choice != 5); // Loop until user chooses to exit

        sc.close(); // Close scanner
    }
}
