import java.util.LinkedList;

/**
 * Created by atindramardikar on 23/09/17.
 */
public class BFS {
    static void bfs(Graph g,int s){
        boolean visited[] = new boolean[g.V];
        LinkedList<Integer> queue = new LinkedList<>();
        visited[s]=true;
        queue.add(s);
        while(queue.size()!=0){
            int n=queue.poll();
            System.out.print(n+" ");
            for(int l: g.adjacencyList[n]){
                if(!visited[l]) {
                    visited[l]=true;
                    queue.add(l);
                }
            }
        }
    }
    public static void main(String[] args) {
        Graph g = new Graph(4);

        g.addEdge(0, 1);
        g.addEdge(0, 2);
        g.addEdge(1, 2);
        g.addEdge(2, 0);
        g.addEdge(2, 3);
        g.addEdge(3, 3);

        BFS.bfs(g,0);
    }
}
