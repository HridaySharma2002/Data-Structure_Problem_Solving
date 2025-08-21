class Solution {
    public boolean checkPerfectNumber(int num) {
        // Perfect numbers must be greater than 1
        if(num <= 1){
            return false;
        }
        int sum = 1; // 1 is always a divisor (except for num = 1)
        // Loop from 2 up to sqrt(num)
        for(int i = 2; i * i <= num; i++){
            // If i is a divisor of num
            if(num % i == 0){
                sum += i; // Add the divisor
                // If divisors are not the same (i.e., not a square root), add the paired divisor
                // This avoids adding the square root twice when num is a perfect square
                if(i != num / i){
                    sum += num / i;
                }
            }
        }
        // If the sum of divisors equals num, it's a perfect number
        return sum == num;
    }
}
