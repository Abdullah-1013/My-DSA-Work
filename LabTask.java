public class LabTask {
    static class Node {
        int data;
        Node next;

        public Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    static class LinkedList {
        Node head;

        public void insertTail(int data) {
            Node newNode = new Node(data);

            if (head == null) {
                head = newNode;
                return;
            }

            Node temp = head;
            while (temp.next != null) {
                temp = temp.next;
            }
            temp.next = newNode;
        }

        public void reverse() {
            Node prev = null;
            Node current = head;
            Node nextNode;

            while (current != null) {
                nextNode = current.next;
                current.next = prev;
                prev = current;
                current = nextNode;
            }

            head = prev;
        }

        public void merge(LinkedList list2) {
            Node temp = this.head;

            while (temp.next != null) {
                temp = temp.next;
            }

            temp.next = list2.head;
        }

        public LinkedList cloneList() {
            LinkedList clonedList = new LinkedList();
            Node temp = this.head;

            while (temp != null) {
                clonedList.insertTail(temp.data);
                temp = temp.next;
            }

            return clonedList;
        }

        public void printList() {
            Node temp = head;

            while (temp != null) {
                System.out.print(temp.data + " ");
                temp = temp.next;
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        LinkedList list1 = new LinkedList();
        LinkedList list2 = new LinkedList();

        list1.insertTail(1);
        list1.insertTail(2);
        list1.insertTail(3);

        list2.insertTail(4);
        list2.insertTail(5);
        list2.insertTail(6);

        System.out.println("Original List 1:");
        list1.printList();

        System.out.println("Original List 2:");
        list2.printList();

        list1.reverse();
        list2.reverse();

        System.out.println("Reversed List 1:");
        list1.printList();

        System.out.println("Reversed List 2:");
        list2.printList();

        list1.merge(list2);

        System.out.println("Merged List:");
        list1.printList();

        LinkedList clonedList = list1.cloneList();

        System.out.println("Cloned List:");
        clonedList.printList();
    }
}

