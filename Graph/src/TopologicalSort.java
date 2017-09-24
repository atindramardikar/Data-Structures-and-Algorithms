import java.util.*;
/**
 * Created by atindramardikar on 23/09/17.
 */
public class TopologicalSort {
    static boolean visited[];
    static Stack stack;
    static void sort(Graph g){
        stack= new Stack();
        visited=new boolean[g.V];
        for(int i=0;i<g.V;i++) {
            if (!visited[i]) {
                sortUtil(i,g);
            }
        }
        while (stack.empty()==false)
            System.out.print(stack.pop() + " ");
    }

    static void sortUtil(int x,Graph g){
        visited[x]=true;
        for(int l: g.adjacencyList[x]){
            if(!visited[l])
                sortUtil(l,g);
        }
        stack.push(x);
    }

    public static void main(String[] args) {
        Graph g = new Graph(6);
        g.addEdge(5, 2);
        g.addEdge(5, 0);
        g.addEdge(4, 0);
        g.addEdge(4, 1);
        g.addEdge(2, 3);
        g.addEdge(3, 1);
        TopologicalSort.sort(g);
    }

}
