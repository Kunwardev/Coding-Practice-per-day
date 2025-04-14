public class SplitMessageBasedOnLimit {
    public String[] splitMessage(String message, int limit) {
    int low = 1, high = message.length();
    int result = Integer.MAX_VALUE;

    // Binary search to find the minimum number of parts
    while (low <= high) {
        int mid = low + (high - low) / 2;

        int value = checkValidity(message, limit, mid);
        if (value == 0) {
            result = Math.min(result, mid);
            high = mid - 1;
            low = 1; // Reset low to explore smaller values of k
        } else if (value == -1) {
            high = mid - 1;
        } else {
            low = mid + 1;
        }
    }

    // If no valid split is found, return an empty array
    if (result == Integer.MAX_VALUE) {
        return new String[0];
    } else {
        return getFormattedStrings(message, limit, result);
    }
}

private int checkValidity(String message, int limit, int k) {
    int idx = 0;

    for (int i = 1; i <= k; i++) {
        if (idx >= message.length()) {
            return -1; // All characters are already processed
        }

        String format = "<" + i + "/" + k + ">";
        int left = limit - format.length();

        if (left <= 0) {
            return -1; // Not enough space for content
        }

        idx += left;
    }

    if (idx < message.length()) {
        return 1; // Not all characters are processed
    }

    return 0; // Valid split
}

private String[] getFormattedStrings(String message, int limit, int k) {
    String[] result = new String[k];

    int idx = 0;
    for (int i = 1; i <= k; i++) {
        String format = "<" + i + "/" + k + ">";
        int diff = limit - format.length();

        if (idx + diff > message.length()) {
            result[i - 1] = message.substring(idx) + format;
        } else {
            result[i - 1] = message.substring(idx, idx + diff) + format;
        }

        idx += diff;
    }

    return result;
}
}