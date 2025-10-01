class Solution {
    public int numWaterBottles(int numBottles, int numExchange) {
        // You start with numBottles full bottles, so you can drink all of them.
        // Each time you drink a bottle, you get an empty bottle.
        // For every numExchange empty bottles, you can exchange them for one full bottle.
        // The formula below calculates the total bottles you can drink:
        // numBottles: initial bottles you can drink
        // (numBottles - 1) / (numExchange - 1): total extra bottles you get by exchanging
        // This works because after each exchange, you lose (numExchange - 1) bottles per new bottle gained.
        return numBottles + (numBottles - 1) / (numExchange - 1);
    }
}
