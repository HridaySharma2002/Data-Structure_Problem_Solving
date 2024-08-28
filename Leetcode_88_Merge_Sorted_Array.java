class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
            //Declaring a 3rd Array and 2 pointers
    int[] arr3=new int[n+m];
    int left=0;
    int right=0;
    int index=0;

    //Insert elements from 2 arrays into third array using left and right
    while(left < m && right < n){
        if(nums1[left] <= nums2[right]){
            arr3[index]=nums1[left];
            left++;
            index++;
        }
        else{
            arr3[index]=nums2[right];
            right++;
            index++;
        }
    }

    //If right pointer reaches the end
    while(left<m){
        arr3[index++]=nums1[left++];
    }

    //If left pointer reaches end
    while(right<n){
        arr3[index++]=nums2[right++];
    }

    //Fill back elements from arr3 to arr1 and arr2
    for(int i=0;i<n+m;i++){
            nums1[i]=arr3[i];
    }
}
}
