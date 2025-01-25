/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DataStructure.Array;

/**
 *
 * @author kunwar
 */
public class NextPermutationOfArray {
    
    public void function(int[] nums) {
        int length = nums.length;
        int mark = -1;
        for(int index=length-1; index>=1; index--){
            if(nums[index] > nums[index-1]){
                mark = index-1;
                break;
            }
        }
        if(mark == -1){
            reverse(nums, 0, length-1);
            return;
        }
        int swapIndex = -1;
        for(int index=length-1; index > mark; index--){
            if(nums[index] > nums[mark]){
                swapIndex = index;
                break;
            }
        }
        swap(nums, mark, swapIndex);
        reverse(nums, mark+1, length-1);
    }
    
    
    private void swap(int[] nums, int i, int j){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
    
    private void reverse(int[] nums, int i, int j){
        while(i<j){
            swap(nums, i, j);
            i++;
            j--;
        }
    }
    
    public static void main(String[] args) {
        int[] nums = new int[]{3,1,5,2,5,6};
        NextPermutationOfArray n = new NextPermutationOfArray();
        n.function(nums);
        for(int i: nums){
            System.out.print(i+" ");
        }
    }
    
}
