/**
 * Created by atindramardikar on 23/09/17.
 */
public class CycleDirected {
    static boolean visited[];
    static boolean stack[];

    static boolean isCyclic(Graph g){
        stack= new boolean[g.V];
        visited=new boolean[g.V];
        for(int i=0;i<g.V;i++) {
            if (!visited[i]) {
                return isCyclicUtil(i,g);
            }
        }
        System.out.println("here");
        return false;
    }
    static boolean isCyclicUtil(int x,Graph g){
        visited[x]=true;
        stack[x]=true;
        for(int l: g.adjacencyList[x]){
            if(!visited[l]) {
                if (isCyclicUtil(l, g))
                    return true;
            }
            else if (stack[l])
                return true;
        }
        stack[x]=false;
        return false;
    }

    public static void main(String[] args) {
        Graph g = new Graph(4);
        g.addEdge(0, 1);
        g.addEdge(0, 2);
        g.addEdge(1, 2);
        g.addEdge(2, 0);
        g.addEdge(2, 3);
        g.addEdge(3, 3);
        System.out.println(CycleDirected.isCyclic(g));
    }
}
