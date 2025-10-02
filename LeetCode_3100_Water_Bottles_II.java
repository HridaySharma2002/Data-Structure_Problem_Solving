class Solution {
    public int maxBottlesDrunk(int numBottles, int numExchange) {
        int drinkbottles = numBottles;  // Initially, you drink all full bottles
        while (numExchange <= numBottles) {
            drinkbottles++;       // Drink one more bottle obtained by exchange
            numBottles -= numExchange;  // Use empty bottles for exchange
            numBottles++;        // After drinking the new bottle, you get one empty bottle back
            numExchange++;       // Increase the exchange requirement by 1
        }
        return drinkbottles;
    }
}
