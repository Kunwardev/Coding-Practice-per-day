package Leetcode;

import java.util.ArrayList;
import java.util.List;
import java.util.TreeSet;

public class BlockPlacementQuery {
    public List<Boolean> getResults(int[][] queries) {
        List<Boolean> result = new ArrayList<>();
        TreeSet<Integer> obstacles = new TreeSet<>();
        obstacles.add(0); // Add origin as an obstacle
        
        for (int[] query : queries) {
            if (query[0] == 1) {
                // Type 1: Add obstacle
                obstacles.add(query[1]);
            } else {
                // Type 2: Check if block can be placed
                int x = query[1];
                int size = query[2];
                
                // Get all obstacles in range [0, x]
                List<Integer> obsInRange = new ArrayList<>(obstacles.headSet(x + 1));
                boolean possible = false;
                
                // Check gaps between obstacles
                for (int i = 0; i < obsInRange.size() - 1; i++) {
                    int gap = obsInRange.get(i + 1) - obsInRange.get(i);
                    if (gap >= size) {
                        possible = true;
                        break;
                    }
                }
                
                // Check last gap (if x is greater than last obstacle)
                if (!possible && x - obstacles.floor(x) >= size) {
                    possible = true;
                }
                
                result.add(possible);
            }
        }
        
        return result;
    }
}
