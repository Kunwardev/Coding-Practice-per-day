package January;

public class ImplementPOW {
    
    private double power(double b, int e){
        if(e == 0)
            return 1;
        if(e < 0)
            return 1 / power(b, -e);
        double half = power(b, e / 2);
        if(e % 2 == 0)
            return half * half;
        return b * half * half;
    }

    public static void main(String[] args) {
        ImplementPOW p = new ImplementPOW();
        p.power(5, 2);
    }

}
