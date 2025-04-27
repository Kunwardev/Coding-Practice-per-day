package April.XOR;

public class FindDuplicate {
    
    public static int findDuplicate(int[] arr){
        int xor = 0;
        for(int i: arr)
            xor ^= i;
        for(int i=1;i<=arr.length-1;i++)
            xor ^= i;
        return xor;
    }

}
