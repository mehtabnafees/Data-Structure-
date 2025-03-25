// Class representing a Node in a Doubly Linked List
class Node {
    int data;
    Node next;
    Node prev;

    public Node(int data) {
        this.data = data;
        this.next = null;
        this.prev = null;
    }
}

// Doubly Linked List Class
class DoublyLinkedList {
    Node head;

    // Insert at a specific position
    public void insertAtPosition(int data, int position) {
        Node newNode = new Node(data); // Create new node

        if (position <= 1 || head == null) { // Insert at the beginning
            newNode.next = head;
            if (head != null) {
                head.prev = newNode;
            }
            head = newNode;
            System.out.println(data + " inserted at position " + position);
            return;
        }

        Node temp = head;
        int count = 1;

        while (temp.next != null && count < position - 1) { // Traverse to position
            temp = temp.next;
            count++;
        }

        newNode.next = temp.next;
        newNode.prev = temp;
        if (temp.next != null) {
            temp.next.prev = newNode;
        }
        temp.next = newNode;

        System.out.println(data + " inserted at position " + position);
    }

    // Display the list
    public void display() {
        Node temp = head;
        System.out.print("Doubly Linked List: ");
        while (temp != null) {
            System.out.print(temp.data + " <-> ");
            temp = temp.next;
        }
        System.out.println("null");
    }
}

// Main class to test
public class DoublyLinkedListExample {
    public static void main(String[] args) {
        DoublyLinkedList list = new DoublyLinkedList();

        list.insertAtPosition(10, 1); // Insert at head
        list.insertAtPosition(20, 2); // Insert at end
        list.insertAtPosition(30, 3); // Insert at end
        list.insertAtPosition(15, 2); // Insert in the middle
        list.insertAtPosition(5, 1);  // Insert at beginning

        list.display();  // Output: 5 <-> 10 <-> 15 <-> 20 <-> 30 <-> null
    }
}
