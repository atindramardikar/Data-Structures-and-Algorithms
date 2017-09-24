/**
 * Created by atindramardikar on 19/09/17.
 */
public class BST {
    static class Node{
        Node left;
        Node right;
        int data;
        public Node(int item) {
            data = item;
            left = right = null;
        }
    }
    Node root;
    Node prec=null;
    Node succ=null;

    void insert(int key) {
        root = insertRec(root, key);
    }

     Node insertRec(Node root, int key){
        if(root==null){
            Node n =new Node(key);
            return n;
        }
        if(key<=root.data){
            root.left=insertRec(root.left,key);
        }else{
            root.right=insertRec(root.right,key);
        }
        return root;
    }

    void printInorder(Node root){
        if(root!=null){
            printInorder(root.left);
            System.out.println(root.data);
            printInorder(root.right);
        }
    }

    Node search(Node root, int d){
        if(root==null||root.data==d)
            return root;
        if(d<root.data)
            return search(root.left,d);
        return search(root.right,d);
    }

    void delete(int key){
        root=deleteRec(root,key);
    }

    Node deleteRec(Node root, int data){
        if(root==null)
            return root;
        if(data<root.data)
            deleteRec(root.left,data);
        else if(data>root.data)
            deleteRec(root.right,data);
        else{
            if(root.left==null)
                return root.right;
            else if(root.right==null)
                return root.left;
            root.data=minVal(root.right);
            root.right=deleteRec(root.right,root.data);
        }
        return root;
    }

    int minVal(Node root){
        int min=root.data;
        while (root.left != null)
        {
            min = root.left.data;
            root = root.left;
        }
        return min;
    }

    void calPredSuc(Node root,int key){
        if(root==null)
            return;
        if(root.data==key){

            if(root.left!=null) {
                Node tmp = root.left;
                while (tmp != null) {
                    tmp = tmp.right;
                }
                prec = root.right;
            }

            if(root.right!=null) {
                Node tmp = root.right;
                while (tmp != null) {
                    tmp = tmp.left;
                }
                succ = root.left;
            }

        }
        else if(root.data<key){
            this.prec=root;
            calPredSuc(root.right,key);
        }
        else{
            this.succ=root;
            calPredSuc(root.left,key);
        }
    }

    boolean isBST(Node root, int min,int max){
        if(root==null)
            return true;
        if(root.data<min||root.data>max)
            return false;
        return(isBST(root.left,min,root.data-1)&&isBST(root.right,root.data+1,max));
    }

    int kthSmallest(Node root, int k){
        if(root==null)
            return 0;
        int lcount=count(root.left);
        System.out.println(lcount);
        if(k==lcount+1)
            return root.data;
        if(k<=lcount)
            return kthSmallest(root.left,k);

            return kthSmallest(root.right,k-lcount-1);
    }
    int count(Node root){
        int count=0;
        if (root==null)
         return count;

        count= 1+count(root.left)+count(root.right);

        return count;
    }
    int sum=0;
    void greaterSum(Node root){
        if(root==null)
            return;

        greaterSum(root.right);

        sum=sum+root.data;
        root.data = sum-root.data;

        greaterSum(root.left);
    }

    Node sortedArraytoBST(int[] arr, int start, int end){
        if(start>end){
           return null;
        }
        int mid = (start + end) / 2;
        Node node = new Node(arr[mid]);

        node.left= sortedArraytoBST(arr, start,mid-1);
        node.right=sortedArraytoBST(arr,mid+1,end);
        return node;
    }


    public static void main(String[] args) {
        BST si = new BST();
        //si.insert(50);
//        si.root.left=new Node(60);
//        si.root.right=new Node(20);
//        si.insert(30);
//        si.insert(70);
//        si.insert(20);
//        si.insert(40);
//        si.insert(60);
//        si.insert(80);
        int[] arr = new int[]{1,2,3,4,5,6};
        si.root=si.sortedArraytoBST(arr,0,5);
        //si.printInorder(si.root);
        //System.out.println(si.search(si.root,3).data);
        //si.delete(2);
        //si.printInorder(si.root);
        //si.calPredSuc(si.root,65);
        //System.out.println(si.isBST(si.root, Integer.MIN_VALUE, Integer.MAX_VALUE));
        //System.out.println(si.prec.data+" "+si.succ.data);
        //si.greaterSum(si.root);
        //System.out.println(si.kthSmallest(si.root,3));

        si.printInorder(si.root);
    }
}
