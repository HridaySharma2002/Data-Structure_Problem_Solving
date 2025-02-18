class Solution {
    public boolean isNStraightHand(int[] hand, int groupSize) {
        // Step 1: Check if the total number of cards is divisible by groupSize
        // If not, it's impossible to divide the cards into groups of size groupSize
        if (hand.length % groupSize != 0) {
            return false;
        }

        // Step 2: Count the frequency of each card using a TreeMap
        // TreeMap is used to keep the keys (card values) sorted
        TreeMap<Integer, Integer> card_count = new TreeMap<>();
        for (int card : hand) {
            // Increment the count for the current card
            card_count.put(card, card_count.getOrDefault(card, 0) + 1);
        }

        // Step 3: Try to form groups of size groupSize
        while (!card_count.isEmpty()) {
            // Get the smallest card value (first key in the TreeMap)
            int first_card = card_count.firstKey();

            // Attempt to form a group starting from the smallest card
            for (int i = 0; i < groupSize; i++) {
                int current_card = first_card + i; // The current card in the group

                // Check if the current card exists in the map
                if (!card_count.containsKey(current_card)) {
                    return false; // If the card is missing, we cannot form a valid group
                }

                // Decrease the count of the current card
                card_count.put(current_card, card_count.get(current_card) - 1);

                // If the count of the current card becomes zero, remove it from the map
                if (card_count.get(current_card) == 0) {
                    card_count.remove(current_card);
                }
            }
        }

        // If all cards are successfully grouped, return true
        return true;
    }
}
