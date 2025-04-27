package April;

public class MajorityElement {
    
    private int function(int[] arr){
        int n = arr.length;
        int count = 0, major = 0;
        for(int a: arr){
            if(count == 0){
                count = 1;
                major = a;
            }
            else if(major == a){
                count++;
            }else{
                count--;
            }
        }
        count = 0;
        for(int a: arr){
            if(major == a)
                count++;
        }
        if(count > n/2)
            return major;
        return -1;
    }

}
