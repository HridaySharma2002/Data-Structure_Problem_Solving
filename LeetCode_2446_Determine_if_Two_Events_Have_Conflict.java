class Solution {
    public boolean haveConflict(String[] event1, String[] event2) {
        // Check if event1 starts on or before event2 ends
        // event1[0] is start time of event1, event2[1] is end time of event2
        // compareTo returns <= 0 if event1 starts earlier or exactly when event2 ends
        // AND

        // Check if event2 starts on or before event1 ends
        // event2[0] is start time of event2, event1[1] is end time of event1
        // compareTo returns <= 0 if event2 starts earlier or exactly when event1 ends

        // If both conditions are true, the events overlap (have a conflict)
        return event1[0].compareTo(event2[1]) <= 0 && event2[0].compareTo(event1[1]) <= 0;
    }
}
