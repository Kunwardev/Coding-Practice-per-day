import java.util.Comparator;
import java.util.PriorityQueue;

class Solution {

    class Pair{
        char c;
        int freq;

        public Pair(char c, int freq){
            this.c = c;
            this.freq = freq;
        }
    }

    class FrequencyComparator implements Comparator<Pair>{
        public int compare(Pair a, Pair b){
            return b.freq - a.freq;
        }
    }

    public String frequencySort(String s) {
        int[] freq = new int[26];
        PriorityQueue<Pair> pq = new PriorityQueue<>(new FrequencyComparator());
        for(char c: s.toCharArray()){
            freq[c-'a']++;
        }
        for(char c: s.toCharArray()){
            if(freq[c-'a'] > 0){
                pq.add(new Pair(c, freq[c-'a']));
                freq[c-'a'] = 0;
            }
        }
        StringBuilder sb = new StringBuilder();
        while(!pq.isEmpty()){
            Pair charFreq = pq.poll();
            for(int i=0;i<charFreq.freq;i++){
                sb.append(charFreq.c);
            }
        }
        System.out.println(sb);
        return sb.toString();
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        // Test case 1
        String input1 = "tree";
        String expectedOutput1 = "eert";
        String actualOutput1 = solution.frequencySort(input1);
        System.out.println("Test case 1: " + (expectedOutput1.equals(actualOutput1) ? "Passed" : "Failed"));

        // Test case 2
        String input2 = "cccaaa";
        String expectedOutput2 = "aaaccc";
        String actualOutput2 = solution.frequencySort(input2);
        System.out.println("Test case 2: " + (expectedOutput2.equals(actualOutput2) ? "Passed" : "Failed"));

        // Test case 3
        String input3 = "aabb";
        String expectedOutput3 = "bbaa";
        String actualOutput3 = solution.frequencySort(input3);
        System.out.println("Test case 3: " + (expectedOutput3.equals(actualOutput3) ? "Passed" : "Failed"));

    }
    
}