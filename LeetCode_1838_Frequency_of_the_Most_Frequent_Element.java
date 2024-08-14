import java.util.HashMap;

public class Solution {
    public int maxFrequency(int[] nums, int k) {
        HashMap<Integer, Integer> frequencyMap = new HashMap<>();
        int maxFreq = 0;
        
        for (int num : nums) {
            frequencyMap.put(num, frequencyMap.getOrDefault(num, 0) + 1);
            int currentFreq = frequencyMap.get(num);
            
            while (currentFreq > maxFreq + 1 && k > 0) {
                int minNum = findMinNum(nums, frequencyMap);
                frequencyMap.put(minNum, frequencyMap.get(minNum) - 1);
                if (frequencyMap.get(minNum) == 0) {
                    frequencyMap.remove(minNum);
                }
                k--;
                currentFreq--;
            }
            
            maxFreq = Math.max(maxFreq, currentFreq);
        }
        
        return maxFreq;
    }
    
    private int findMinNum(int[] nums, HashMap<Integer, Integer> frequencyMap) {
        int minNum = Integer.MAX_VALUE;
        for (int num : nums) {
            if (frequencyMap.containsKey(num) && frequencyMap.get(num) > 0 && num < minNum) {
                minNum = num;
            }
        }
        return minNum;
    }
}
