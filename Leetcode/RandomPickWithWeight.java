package Leetcode;

public class RandomPickWithWeight {
    
    private static int function(int[] arr){
        int sum = 0;
        int[] prefixSum = new int[arr.length];
        for(int i=0;i < arr.length;i++){
            sum += arr[i];
            prefixSum[i] = sum;
        }
        int left = 0, right = arr.length;
        double random = Math.random()*sum;
        System.out.println(random);
        while(left < right){
            int mid = (left + (right-left) / 2);
            if(prefixSum[mid] < random){
                left = mid+1;
            }else{
                right = mid;
            }
        }
        return left;
    }

    public static void main(String[] args) {
        int[] weights = {1, 3, 2, 4};
        int result = RandomPickWithWeight.function(weights);
        System.out.println(result);

    }

}
