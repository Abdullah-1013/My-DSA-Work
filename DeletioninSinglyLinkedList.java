import java.util.Scanner;

public class DeletioninSinglyLinkedList {
    static class Node {
        int data;
        Node next;

        Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    Node head = null;


    public void deletion() {
        int data, n,m, p;
        Scanner s1 = new Scanner(System.in);
        do {
            System.out.println("Enter the Data: ");
            data = s1.nextInt();
            Node newnode = new Node(data);
            if (head == null) {
                head = newnode;
            } else {
                System.out.println("Press 1 to delete data at beginning Press 2 to delete data at the end Press 3 to delete data at the specific location");
                m= s1.nextInt();
                switch (m) {
                    case 1:
                        Node temp=head;
                        temp=temp.next;
                        head=temp;
                        break;
                    case 2:
                        if (head.next == null) {
                            head = null;
                        } else {
                            Node temp1 = head;
                            Node ptr = temp1.next;
                            while (ptr.next != null) {
                                temp1 = ptr;
                                ptr = ptr.next;
                            }
                            temp1.next = null;
                        }
                        break;
                    case 3:
                        System.out.println("Enter the position of node to be deleted: ");
                        p = s1.nextInt();
                        Node temp2=head;
                        Node ptr1=temp2.next;
                        for (int i=0;i<p-2;i++){
                            temp2=ptr1;
                            Node ptr=temp2.next;
                        }
                        temp2.next=ptr1.next;
                        break;
                }
            }
            System.out.println("Do you want to DELETE another data? Press 1: ");
            n = s1.nextInt();
        }
        while (n == 1);
    }

    public static void main(String[] args) {
        DeletioninSinglyLinkedList d1 = new DeletioninSinglyLinkedList();
        d1.deletion();
    }
}


