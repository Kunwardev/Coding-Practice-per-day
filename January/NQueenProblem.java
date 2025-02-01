package January;

import java.util.ArrayList;

public class NQueenProblem {
    
    private void nQueenUtil(int n, int j, ArrayList<Integer> iterResult, 
    boolean[] row, boolean[] majorDiagonal, boolean[]minorDiagonal,
    ArrayList<ArrayList<Integer>> result)
    {
         if(j > n){
            System.out.println(iterResult);
            result.add(new ArrayList<>(iterResult));
            return;
        }
        for(int i=1;i<=n;i++){
            // MAJOR DIAGONAL IS FROM TOP LEFT TO BOTTOM RIGHT, SUM OF I&J GIVES YOU THE MAJOR DIAGONAL AND WE WILL NOT HAVE TO 
            // USE THE FOR LOOP TO MAKE IT CHECK FOR EVERYTHING. THUS O(N^2) GETS CHANGED TO O(1)
            // 
            // FOR MINOR DIAGONAL WHICH IS TOP RIGHT TO BOTTOM LEFT, THE SUM IS I - J + N
            if(!row[i] && !majorDiagonal[i+j] && !minorDiagonal[i-j+n])
            {
                row[i] = majorDiagonal[i+j] = minorDiagonal[i-j+n] = true;
                iterResult.add(i);
                System.out.println(iterResult + " "+ j + " " + n);
                nQueenUtil(n, j+1, iterResult, row, majorDiagonal, minorDiagonal, result);
                iterResult.remove(iterResult.size()-1);
                row[i] = majorDiagonal[i+j] = minorDiagonal[i-j+n] = false;
            }
        } 
    }
    
    public ArrayList<ArrayList<Integer>> nQueen(int n) {
        // code here
        ArrayList<Integer> iterResult = new ArrayList<>();
        boolean[] row = new boolean[n+1];
        boolean[] majorDiagonal = new boolean[2*n+1];
        boolean[] minorDiagonal = new boolean[2*n+1];
        ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
        nQueenUtil(n,1,iterResult, row, majorDiagonal, minorDiagonal, result);
        System.out.println(result);
        return result;
    }

    public static void main(String[] args) {
        NQueenProblem n = new NQueenProblem();
        System.out.println(n.nQueen(4));
    }
}
