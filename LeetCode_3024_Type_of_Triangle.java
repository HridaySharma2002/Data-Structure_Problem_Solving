class Solution {
    public String triangleType(int[] nums) {
        // Check if the sides can form a triangle using the triangle inequality theorem
        if (nums[0] + nums[1] <= nums[2] || 
            nums[0] + nums[2] <= nums[1] || 
            nums[1] + nums[2] <= nums[0]) {
            return "none"; // The sides do not form a triangle
        }

        // Check if all three sides are equal
        if (nums[0] == nums[1] && nums[1] == nums[2]) {
            return "equilateral"; // All sides are equal, it's an equilateral triangle
        }
        // Check if exactly two sides are equal
        else if ((nums[0] == nums[1] && nums[1] != nums[2]) || 
                 (nums[0] == nums[2] && nums[1] != nums[2]) || 
                 (nums[1] == nums[2] && nums[0] != nums[2])) {
            return "isosceles"; // Two sides are equal, it's an isosceles triangle
        }
        // If all sides are different
        else {
            return "scalene"; // All sides are different, it's a scalene triangle
        }
    }
}
