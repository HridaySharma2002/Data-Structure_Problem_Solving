class Solution {
    public int beautySum(String s) {
        //To Store the total beauty sum
        int total_beauty=0;

        //Iterate over all the starting points of the substring
        for(int start=0;start<s.length();start++){

            //Track the max and min frequencies
            int maxfreq=0,minfreq=Integer.MAX_VALUE;

            //Frequency Array of Characters
            int freq[]=new int[26];

            //Iterate over all ending points of substring
            for(int end=start;end<s.length();end++){

            char current_Char=s.charAt(end);

            //Update Frequency
            freq[current_Char-'a']++;

            //Update Maximum Frequency
            maxfreq=Math.max(maxfreq,freq[current_Char-'a']);

            //Update Minimum Frequency
            //Only consider character that have appeared only once
            minfreq=Integer.MAX_VALUE;
            for(int f:freq){
                if(f>0){
                    minfreq=Math.min(minfreq,f);
                }
            }

            //Calculate beauty if minfreq is valid
            if(minfreq!=Integer.MAX_VALUE){
                total_beauty+=(maxfreq-minfreq);
            }
        }
    }
        
        return total_beauty;
    }
}
