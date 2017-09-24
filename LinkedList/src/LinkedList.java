import java.util.HashSet;

/**
 * Created by atindramardikar on 16/09/17.
 */
public class LinkedList {

    //Node
    class Node{
        int data;
        Node next;

        Node(int data){
            this.data=data;
            this.next=null;
        }
    }

    Node head;
    HashSet<Integer> elements;

    void insertAtEnd(int d){
        Node end = new Node(d);
        if (head == null)
        {
            head = end;
            return;
        }
        Node n = head;
        while(n.next !=null){
            n=n.next;
        }
        n.next=end;
    }

    // Delete probs
    void deleteFirstElement(int d){
        if(head!=null){
            if(head.data== d) {
                head = head.next;
                return;
            }
            Node n = head;
            while(n.next != null){
                if(n.next.data==d){
                    n.next=n.next.next;
                    return;
                }
                n=n.next;
            }
        }
    }

    void deleteAllElement(int d){
        if(head!=null) {
            Node dummy = new Node(0);
            dummy.next = head;
            Node prev = dummy;
            Node current = head;
            while (current != null) {
                if (current.data == d) {
                    prev.next = current.next;
                } else {
                    prev = current;
                }
                current = current.next;
            }
            head = dummy.next;
        }
    }

    void deleteDuplicatesSorted(){
        if(head!=null){
            Node prev = head;
            Node current = head.next;
            while (current != null) {
                if(prev.data==current.data){
                    prev.next=current.next;
                }
                else{
                    prev=current;
                }
                current = current.next;
            }
        }
    }
    void deleteDuplicatesUnsorted(){
        if(head!=null) {
            elements = new HashSet<>();
            Node prev = head;
            Node current = head;
            while (current != null) {
                if (elements.contains(current.data)) {
                    prev.next = current.next;
                } else {
                    elements.add(current.data);
                    prev = current;
                }
                current = current.next;
            }
        }
    }

    //Print probs
    void printMid(){
        Node fastPtr = head;
        Node slowPtr = head;
        if (head!=null) {
            while (fastPtr != null && fastPtr.next != null) {
                fastPtr = fastPtr.next.next;
                slowPtr = slowPtr.next;
            }
        }
        System.out.println(slowPtr.data);
    }

    void printNthFromEnd(int n){
        Node curr = head;
        Node refPtr = head;
        int count=0;
        if(head!=null) {
            while (count < n) {
                if (refPtr == null) {
                    return;
                }
                refPtr = refPtr.next;
                count++;
            }
            while (refPtr != null) {
                curr = curr.next;
                refPtr = refPtr.next;
            }
            System.out.println(curr.data);
        }
    }
    void printLinkedList(){
        Node n = head;
        while(n !=null){
            System.out.print(n.data+" ");
            n=n.next;
        }
        System.out.println();
    }

    void createLoop(){
        Node n = head;
        while(n.next !=null){
            n=n.next;
        }
        n.next=head;
    }

    void detectLoop(){
        Node slowPtr=head;
        Node fastPtr=head;
        if(head!=null){
            while(slowPtr!=null && fastPtr!=null && fastPtr.next!=null){
                slowPtr=slowPtr.next;
                fastPtr=fastPtr.next.next;
                if(slowPtr==fastPtr){
                    System.out.println("Loop");
                    return;
                }
            }
        }
        System.out.println("No Loop");
    }
    Node reverseK(Node head, int k){
        Node curr=head;
        Node next=null;
        Node prev=null;
        int count =0;
        while(count<k && curr!=null){
            next=curr.next;
            curr.next=prev;
            prev=curr;
            curr=next;
            count++;
        }

        if(next!=null){
            head.next=reverseK(next,k);
        }
        return prev;
    }

    Node reverseAltK(Node head, int k){
        Node curr=head;
        Node next=null;
        Node prev=null;
        int count =0;
        while(count<k && curr!=null){
            next=curr.next;
            curr.next=prev;
            prev=curr;
            curr=next;
            count++;
        }

        if(next!=null){
            head.next=next;
        }

        count=0;
        while(count<k-1 && curr!=null){
            curr = curr.next;
            count++;
        }

        if(curr!=null)
            curr.next=reverseAltK(curr.next,k);

        return prev;
    }

    void sortedReverse(Node n1, Node n2){
        Node result=null;
        while(n1!=null && n2!=null){
            if(n1.data <= n2.data){
                Node temp= n1.next;
                n1.next=result;
                result=n1;
                n1=temp;
            }
            else{
                Node temp= n2.next;
                n2.next=result;
                result=n2;
                n2=temp;
            }
        }
        while(n1!=null){
            Node temp= n1.next;
            n1.next=result;
            result=n1;
            n1=temp;
        }
        while(n2!=null){
            Node temp= n2.next;
            n2.next=result;
            result=n2;
            n2=temp;
        }


        Node n = result;
        while(n !=null){
            System.out.print(n.data+" ");
            n=n.next;
        }
    }


    void reverse(){
        Node curr=head;
        Node next=null;
        Node prev=null;
        if(head!=null) {
            while (curr != null) {
                next=curr.next;
                curr.next=prev;
                prev=curr;
                curr=next;
            }
        }
        head=prev;
    }


    void partition(int x){
        Node head=this.head;
        Node tail=this.head;
        Node node=this.head;
        while(node!=null){
            Node next = node.next;
            if(node.data<x){
                node.next=head;
                head=node;
            }
            else{
                tail.next=node;
                tail=node;
            }
            node=next;
        }
        this.head=head;

    }
    Node left;
    public boolean isPalindrome(Node head) {
        left = head;

        boolean result = helper(head);
        return result;
    }

    public boolean helper(Node right){

        //stop recursion
        if (right == null)
            return true;

        //if sub-list is not palindrome,  return false
        boolean x = helper(right.next);
        if (!x)
            return false;

        //current left and right
        boolean y = (left.data == right.data);

        //move left to next
        left = left.next;

        return y;
    }


    public static void main(String[] args) {
//        LinkedList linkedList = new LinkedList();
//        linkedList.insertAtEnd(1);
//        linkedList.insertAtEnd(3);
//        linkedList.insertAtEnd(4);
//        linkedList.insertAtEnd(6);
//        linkedList.insertAtEnd(7);
//        linkedList.insertAtEnd(9);
//        linkedList.insertAtEnd(10);
//        linkedList.insertAtEnd(11);
//        linkedList.printLinkedList();
//        linkedList.printMid();
//        linkedList.printNthFromEnd(4);
//        linkedList.deleteDuplicatesSorted();
        //linkedList.head=linkedList.reverseAltK(linkedList.head,3);
//        linkedList.printLinkedList();
        LinkedList linkedList2 = new LinkedList();
        linkedList2.insertAtEnd(1);
        linkedList2.insertAtEnd(0);
        linkedList2.insertAtEnd(1);
        linkedList2.insertAtEnd(0);
        linkedList2.insertAtEnd(1);
        linkedList2.insertAtEnd(0);
        linkedList2.insertAtEnd(2);
        //linkedList2.partition(5);
        boolean result = linkedList2.isPalindrome(linkedList2.head);
        System.out.println(result);
        linkedList2.printLinkedList();
        //linkedList.sortedReverse(linkedList.head,linkedList2.head);
        //linkedList.createLoop();
        //linkedList.detectLoop();
    }
}
