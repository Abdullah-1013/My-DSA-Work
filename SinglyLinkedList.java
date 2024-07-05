import java.util.Scanner;

public class SinglyLinkedList {
    static class Node{
        int data;
        Node next;
        Node(int data){
            this.data=data;
            this.next=null;
        }

    }
    Node head=null;
    public void add(){
        int data,n;
        Scanner s1=new Scanner(System.in);
        do {
            System.out.println("Enter the elements for the Linked List:");
            data = s1.nextInt();
            Node newnode = new Node(data);
            if (head == null) {
                head = newnode;
            } else
            {
                newnode.next = head;
                head = newnode;
            }
            System.out.println("Do you want to add another data. Press 1: ");
            n = s1.nextInt();
        }
        while (n==1);

    }
    public void transverse(){
        Node temp=head;
        if (head==null){
            System.out.println("The Linked List does not exists.");
        }
        else {
            while(temp!=null){
                System.out.println(temp.data);
                temp=temp.next;

            }
        }

    }

    public static void main(String[] args) {
        SinglyLinkedList singlyLinkedList=new SinglyLinkedList();
        singlyLinkedList.add();
        singlyLinkedList.transverse();

    }
}
