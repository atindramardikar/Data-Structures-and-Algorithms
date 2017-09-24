import java.util.LinkedList;

/**
 * Created by atindramardikar on 23/09/17.
 */
public class Graph {
    int V;
    LinkedList<Integer>[] adjacencyList;
    Graph(int V){
        this.V=V;
        adjacencyList=new LinkedList[V];
        for(int i=0;i<V;i++)
            adjacencyList[i]=new LinkedList<>();
    }

    void addEdge(int src,int dest){
        adjacencyList[src].add(dest);
        //adjacencyList[dest].addFirst(src);
    }

    void printAdjacencyList(){
        for(int i=0;i<V;i++){
            System.out.print("Edge"+i);
            for(Integer l: adjacencyList[i]){
                System.out.print(" -> "+l);
            }
            System.out.println();
        }
    }
    public static void main(String[] args) {
        Graph g =new Graph(3);
        g.addEdge(0,1);
        g.addEdge(1,2);
        g.printAdjacencyList();
    }
}
