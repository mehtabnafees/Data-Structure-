import java.util.Scanner; // Import Scanner for user input

// Queue using Doubly Linked List
public class QueueDoublyLinkedList {
    private static class Node {
        int data; // Data in the node
        Node next; // Pointer to the next node
        Node prev; // Pointer to the previous node

        public Node(int data) {
            this.data = data;
            this.next = null;
            this.prev = null;
        }
    }

    static class Queue {
        Node front, rear; // Front and rear pointers

        public Queue() {
            front = rear = null; // Initialize empty queue
        }

        // Enqueue (Insert at rear)
        public void enqueue(int data) {
            Node newNode = new Node(data); // Create a new node
            if (rear == null) { // If queue is empty
                front = rear = newNode;
            } else {
                rear.next = newNode; // Link new node at rear
                newNode.prev = rear;
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
            front = front.next; // Move front pointer to next node

            if (front == null) { // If queue becomes empty
                rear = null;
            } else {
                front.prev = null; // Remove previous reference
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
            while (temp != null) { // Traverse queue
                System.out.print(temp.data + " <-> ");
                temp = temp.next;
            }
            System.out.println("null");
        }
    }

    // Main method with a menu-driven system
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in); // Scanner for user input
        Queue queue = new Queue(); // Create Queue object
        int choice, value;

        // Menu loop
        do {
            System.out.println("\nQUEUE MENU:");
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
