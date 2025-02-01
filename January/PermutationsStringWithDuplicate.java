package January;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class PermutationsStringWithDuplicate {
    private void swap(StringBuilder sb, int i, int j){
        char temp = sb.charAt(i);
        sb.setCharAt(i, sb.charAt(j));
        sb.setCharAt(j, temp);
    }
    
    private void findPermutationUtil(StringBuilder sb, int index, Set<String> set)
    {
        if(index == sb.length()){
            set.add(sb.toString());
            return;
        }
        for(int i=index; i<sb.length(); i++){
            swap(sb, i, index);
            findPermutationUtil(sb, index+1, set);
            swap(sb, i, index);
        }
    }
    
    public ArrayList<String> findPermutation(String s) {
        // Code here
        int index = 0;
        ArrayList<String> result = new ArrayList<>();
        Set<String> arr = new HashSet<>();
        StringBuilder sb = new StringBuilder(s);
        findPermutationUtil(sb, index, arr);
        result.addAll(arr);
        return result;
    }

    public static void main(String[] args) {
        PermutationsStringWithDuplicate pStringWithDuplicate = new PermutationsStringWithDuplicate();
        String s1 = "AAA";
        String s2 = "ABCD";
        System.out.println(pStringWithDuplicate.findPermutation(s1));
        System.out.println(pStringWithDuplicate.findPermutation(s2));
    }

}
