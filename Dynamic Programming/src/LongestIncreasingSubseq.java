/**
 * Created by atindramardikar on 23/09/17.
 */
public class LongestIncreasingSubseq {
    static int lis(int[] x){
        int m=x.length;
        int[] L=new int[m];
        for(int i=0;i<m;i++)
            L[i]=1;
        for(int i=1;i<m;i++)
            for(int j=0;j<i;j++){
                if(x[i]>x[j] && L[i]<L[j]+1)
                    L[i]=L[j]+1;
            }
        int max=0;
        for(int i=0;i<m;i++){
            if(L[i]>max)
                max=L[i];
        }
        return max;
    }

    public static void main(String[] args) {
        int[] a = {1,2,6,-1,2};
        System.out.println(LongestIncreasingSubseq.lis(a));
    }
}
