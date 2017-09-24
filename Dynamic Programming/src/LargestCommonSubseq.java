/**
 * Created by atindramardikar on 23/09/17.
 */
public class LargestCommonSubseq {
    static int lcs(char[] x, char[] y){
        int m=x.length;
        int n=y.length;
        int[][] L=new int[m+1][n+1];
        for(int i=0;i<=m;i++){
            for(int j=0;j<=n;j++){
                if(i==0 || j==0)
                    L[i][j]=0;
                else if(x[i-1]==y[j-1]){
                    L[i][j]=L[i-1][j-1]+1;
                }
                else
                    L[i][j]=max(L[i-1][j],L[i][j-1]);
            }
        }
        return L[m][n];
    }

    static int max(int a, int b){
        if(a>=b)
            return a;
        return b;
    }
    public static void main(String[] args) {
        String a="abcd";
        String b="abcd";
        System.out.println(LargestCommonSubseq.lcs(a.toCharArray(),b.toCharArray()));

    }
}
