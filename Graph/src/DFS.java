/**
 * Created by atindramardikar on 23/09/17.
 */
public class DFS {
    static boolean visited[];
    static void dfs(Graph g){
        visited=new boolean[g.V];
        for(int i=0;i<g.V;i++) {
            if (!visited[i]) {
                dfsUtil(i,g);
            }
        }
    }

    static void dfsUtil(int x,Graph g){
        visited[x]=true;
        System.out.print(x+" ");
        for(int l: g.adjacencyList[x]){
            if(!visited[l])
                dfsUtil(l,g);
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
        DFS.dfs(g);
    }
}
