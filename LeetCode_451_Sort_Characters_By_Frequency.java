class Solution {
    public String frequencySort(String s) {
        //Count the frequency of each character
        Map<Character,Integer> frequency_Map=new HashMap<>();
        for(char c:s.toCharArray()){
            frequency_Map.put(c,frequency_Map.getOrDefault(c,0)+1);
        }

        //Use MaxHeap to sort characters based on frequency
        PriorityQueue<Map.Entry<Character,Integer>> maxheap=new PriorityQueue<>((a,b)-> b.getValue() - a.getValue());
        maxheap.addAll(frequency_Map.entrySet());

        //Build Result String based on Sorted Characters
        StringBuilder result=new StringBuilder();
        while(!maxheap.isEmpty()){
            Map.Entry<Character,Integer> entry=maxheap.poll();
            char character=entry.getKey();
            int frequency=entry.getValue();
            //Append the Character frequency times
            for(int i=0;i<frequency;i++){
                result.append(character);
            }
        }

        return result.toString();
    }
}
