package May;

public class CheckIfGivenMovesRCircular
{
    public static boolean function(char path[])
    {
        int x = 0, y = 0;
        int dir = 0;
        for(char step: path){
            if(step == 'L')
                dir = (dir + 3) % 4;
            else if(step == 'R')
                dir = (dir + 1) % 4;
            else{
                if(dir == 0){
                    y++;
                }
                else if(dir == 1){
                    x++;
                }
                else if(dir == 2){
                    y--;
                }
                else{
                    x--;
                }
            }
        }
        System.out.println(x+" "+y);
        return (x == 0) && (y == 0);
    }


    public static void main(String[] args) {
        // Test case 1: Circular path
        char[] path1 = {'G', 'L', 'G', 'L', 'G', 'L', 'G'};
        boolean expected1 = true;
        boolean result1 = CheckIfGivenMovesRCircular.function(path1);
        System.out.println("Test case 1: " + (result1 == expected1 ? "Passed" : "Failed"));

        // Test case 2: Non-circular path
        char[] path2 = {'G', 'G', 'R', 'G', 'G'};
        boolean expected2 = false;
        boolean result2 = CheckIfGivenMovesRCircular.function(path2);
        System.out.println("Test case 2: " + (result2 == expected2 ? "Passed" : "Failed"));
    }
}