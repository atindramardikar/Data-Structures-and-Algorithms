/**
 * Created by atindramardikar on 18/09/17.
 */
public class Stack {
    Node top = null;
    class Node{
        int data;
        Node next=null;
        Node(int d){data=d;}
    }
     void push(int a){
         Node newNode=new Node(a);
         if(top==null){
             top=newNode;
         }
         else{
             newNode.next=top;
             top=newNode;
         }
     }

     int peek(){
         if(top!= null)
            return top.data;
         return -1;
     }

     Node pop(){
         Node n =top;
         if(top!=null)
            top = top.next;
         return n;
     }

     void printStack(){
         Node n=top;
         while(n!=null) {
             System.out.print(n.data + " ");
             n = n.next;
         }
     }

    public static void main(String[] args) {
        Stack st = new Stack();
        //System.out.println(st.peek());
        st.push(2);
        st.push(1);
        //st.printStack();
        System.out.println(st.peek());
        //System.out.println(st.pop().data);
        //st.printStack();

    }
}
