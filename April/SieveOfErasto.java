package April;

import java.util.Arrays;

public class SieveOfErasto {
    
    boolean[] primes;
    public SieveOfErasto()
    {
        primes = new boolean[10001];
    }

    private void function()
    {
        Arrays.fill(primes, true);
        for(int p=2;p*p<10001;p++){
            if(primes[p]){
                for(int i=p*p;i*i<10001;i+=p){
                    primes[i] = false;
                }
            }
        }
    }

    public static void main(String[] args) {
        SieveOfErasto s = new SieveOfErasto();
        s.function();
        for(int i = 0; i < 100;i++ ){
            System.out.print(s.primes[i]+" ");
        }
    }

}
