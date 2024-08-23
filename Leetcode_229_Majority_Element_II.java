class Solution {
    public List<Integer> majorityElement(int[] nums) {
        int count1=0,count2=0;
        int el1=Integer.MIN_VALUE;
        int el2=Integer.MIN_VALUE;
        for(int i=0;i<nums.length;i++){
            if(count1==0&& el2!=nums[i]){
                count1=1;
                el1=nums[i];
            }
            else if(count2==0&& el1!=nums[i]){
                count2=1;
                el2=nums[i];
            }
            else if(el1==nums[i]){
                count1++;
            }
            else if(el2==nums[i]){
                count2++;
            }
            else{
                count1--;
                count2--;
            }
        }

        //For Manual Checking
        List<Integer> ls=new ArrayList<>();
        count1=0;
        count2=0;
        for(int i=0;i<nums.length;i++){
            if(el1==nums[i]){
                count1++;
            }
            if(el2==nums[i]){
                count2++;
            }
        }
        int minimum=(int)(nums.length/3)+1;
        if(count1>=minimum){
            ls.add(el1);
        }
        if(count2>=minimum){
            ls.add(el2);
        }
        return ls;
    }
}
