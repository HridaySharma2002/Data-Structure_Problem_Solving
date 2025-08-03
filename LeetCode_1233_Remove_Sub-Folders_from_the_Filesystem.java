class Solution {
    public List<String> removeSubfolders(String[] folder) {
        // Sort the folder paths lexicographically.
        // This ensures that a parent folder (e.g., "/a") will always appear before its sub-folders (e.g., "/a/b").
        Arrays.sort(folder);

        // Initialize a list to store the resulting parent folders.
        List<String> result = new ArrayList<>();
        
        // If the input array is empty, return the empty list.
        if (folder.length == 0) {
            return result;
        }

        // The first folder in the sorted list is guaranteed to be a parent folder,
        // so add it to the result and set it as the last added folder.
        String lastAdded = folder[0];
        result.add(folder[0]);

        // Iterate through the rest of the sorted folders starting from the second element.
        for (int i = 1; i < folder.length; i++) {
            // Check if the current folder is a sub-folder of the last added folder.
            // A sub-folder must start with the parent folder's path followed by a "/".
            // For example, "/a/b" starts with "/a" + "/", but "/ab" does not.
            if (!folder[i].startsWith(lastAdded + "/")) {
                // If it's not a sub-folder, it's a new parent folder.
                // Add it to the result list.
                result.add(folder[i]);
                // Update the last added folder to the current one for subsequent checks.
                lastAdded = folder[i];
            }
        }
        
        // Return the final list containing only the parent folders.
        return result;
    }
}
