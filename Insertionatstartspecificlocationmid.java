import java.util.Scanner;

public class Insertionatstartspecificlocationmid {
    static class Node {
        int data;
        Node next;

        Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    Node head = null;

    public void creation() {
        int data, n, m, p;
        Scanner s1 = new Scanner(System.in);
        do {
            System.out.println("Enter the elements for the Linked List:");
            data = s1.nextInt();
            Node newnode = new Node(data);
            if (head == null) {
                head = newnode;
            } else {
                System.out.println("Enter 1 to start at beginning Enter 2 to insert a specific location Enter 3 to insert at the end");
                m = s1.nextInt();
                switch (m) {
                    case 1:
                        newnode.next = head;
                        head = newnode;
                        break;
                    case 2:
                        System.out.println("Enter the position to be inserted: ");
                        p = s1.nextInt();
                        if (p == 1) {
                            newnode.next = head;
                            head = newnode;
                        } else {
                            Node temp = head;
                            for (int i = 0; i < (p - 2); i++) {
                                temp = temp.next;
                            }
                            newnode.next = temp.next;
                            temp.next = newnode;
                        }
                        break;
                    case 3:
                        Node temp = head;
                        while (temp.next != null) {
                            temp = temp.next;
                        }
                        temp.next = newnode;
                        break;
                }
            }
            System.out.println("Do you want to add another data. Press 1: ");
            n = s1.nextInt();
        } while (n == 1);
    }

    public void printList() {
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.data + " ");
            temp = temp.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Insertionatstartspecificlocationmid I1 = new Insertionatstartspecificlocationmid();
        I1.creation();
        System.out.println("Linked List:");
        I1.printList();
    }
}

