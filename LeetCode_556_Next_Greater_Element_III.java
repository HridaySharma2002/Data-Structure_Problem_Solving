class Solution {
    public int nextGreaterElement(int n) {
        char[] digits=String.valueOf(n).toCharArray();
        int length=digits.length;

        //Finding the rightmost ascent
        int i=length-2;
        while(i>=0 && digits[i]>=digits[i+1]){
            i--;
        }

        //If no ascent is found return -1
        if(i<0){
            return -1;
        }

        //Finding the smallest digit on the right side of the ascent that is larger than digits[i]
        int j=length-1;
        while(digits[j]<=digits[i]){
            j--;
        }

        //Swap the founded digits
        swap(digits,i,j);

        //Reverse the Sequence after the original position of i
        reverse(digits,i+1,length-1);

        //Convert the character array back to an integer
        long result=Long.parseLong(new String(digits));

        //Check if the result fits in a 32 bit integer or not
        return (result<=Integer.MAX_VALUE)?(int) result:-1;

    }

    //Helper Method to Swap two elements in the array
    private void swap(char[] arr,int i,int j){
        char temp=arr[i];
        arr[i]=arr[j];
        arr[j]=temp;
    }

    //Helper Method to Reverse the position of elements of the array
    private void reverse(char[] arr,int start,int end){
        while(start<end){
            swap(arr,start,end);
            start++;
            end--;
        }
    }
}
