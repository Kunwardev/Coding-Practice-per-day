package May;

public class LookAndSayPattern
{
	private static String function(int n){
        if(n == 1)
            return "1";
        String curr = "1";
        for(int i=2; i<=n; i++){
            StringBuilder next = new StringBuilder();
            int current = 1;
            for(int j=1;j<curr.length();j++){
                if(curr.charAt(j) == curr.charAt(j-1)){
                    current++;
                }else{
                    next.append(current+"").append(curr.charAt(j-1));
                    current = 1;
                }
            }
            next.append(current+"").append(curr.charAt(curr.length()-1));
            curr = next.toString();
            System.out.println(curr);
        }
        return curr;
    }

    public static void main(String[] args) {
        String result1 = LookAndSayPattern.function(1);
        String expected1 = "1";
        System.out.println("Test case 1: " + (expected1.equals(result1) ? "Passed" : "Failed"));

        // Test case 2: n = 2
        String result2 = LookAndSayPattern.function(2);
        String expected2 = "11";
        System.out.println("Test case 2: " + (expected2.equals(result2) ? "Passed" : "Failed"));

        // Test case 3: n = 3
        String result3 = LookAndSayPattern.function(3);
        String expected3 = "21";
        System.out.println("Test case 3: " + (expected3.equals(result3) ? "Passed" : "Failed"));

        // Test case 4: n = 4
        String result4 = LookAndSayPattern.function(4);
        String expected4 = "1211";
        System.out.println("Test case 4: " + (expected4.equals(result4) ? "Passed" : "Failed"));

        // Test case 5: n = 5
        String result5 = LookAndSayPattern.function(5);
        String expected5 = "111221";
        System.out.println("Test case 5: " + (expected5.equals(result5) ? "Passed" : "Failed"));

        // Test case 6: n = 6
        String result6 = LookAndSayPattern.function(6);
        String expected6 = "312211";
        System.out.println("Test case 6: " + (expected6.equals(result6) ? "Passed" : "Failed"));
    }

}