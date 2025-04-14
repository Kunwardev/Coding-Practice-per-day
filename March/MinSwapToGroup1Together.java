package March;

public class MinSwapToGroup1Together{

    public int minSwaps(int[] data) {
        // Need to have a sliding window (equal to size of number of 1s) that will keep all the 1s and will count how many 0s are present in that window, then will move that window till end and make sure, if the count of 0s is reducing. If yes, then that is the count of min swaps required.
        int length = data.length;
        int windowSize = 0;
        int zeroCount = 0;
        int minSwap = Integer.MAX_VALUE;
        for(int i=0;i<length;i++){
            if(data[i] == 1)
                windowSize++;
        }
        for(int i=0;i<windowSize;i++){
            if(data[i] == 0)
                zeroCount++;
        }
        minSwap = Math.min(zeroCount, minSwap);
        for(int i=windowSize;i<length;i++){
            if(data[i] == 0)
                zeroCount++;
            if(data[i-windowSize] == 0)
                zeroCount--;
            minSwap = Math.min(minSwap, zeroCount);
        }
        return minSwap;
    }

    public static void main(String[] args) {
        // Test case 1
        MinSwapToGroup1Together solution = new MinSwapToGroup1Together();
        int[] data1 = {1, 0, 1, 0, 1};
        int result1 = solution.minSwaps(data1);
        System.out.println("Test case 1: " + (result1 == 1 ? "Passed" : "Failed"));

        // Test case 2
        int[] data2 = {0, 0, 0, 1, 0};
        int result2 = solution.minSwaps(data2);
        System.out.println("Test case 2: " + (result2 == 0 ? "Passed" : "Failed"));

        // Test case 3
        int[] data3 = {1, 0, 1, 0, 1, 0, 0, 1, 1, 0, 1};
        int result3 = solution.minSwaps(data3);
        System.out.println("Test case 3: " + (result3 == 3 ? "Passed" : "Failed"));

        // Test case 4
        int[] data4 = {1, 1, 1, 1, 1};
        int result4 = solution.minSwaps(data4);
        System.out.println("Test case 4: " + (result4 == 0 ? "Passed" : "Failed"));

        // Test case 5
        int[] data5 = {0, 0, 0, 0, 0};
        int result5 = solution.minSwaps(data5);
        System.out.println("Test case 5: " + (result5 == 0 ? "Passed" : "Failed"));
    }


}