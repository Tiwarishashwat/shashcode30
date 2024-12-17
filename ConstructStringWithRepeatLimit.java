class Solution {
    public String repeatLimitedString(String s, int repeatLimit) {
        int[] freq = new int[26];
        for (char ch : s.toCharArray()) {
            freq[ch - 'a']++;
        }

        StringBuilder sb = new StringBuilder();
        int index = 25; // Start from the largest character
        while (index >= 0) {
            if (freq[index] == 0) {
                index--;
                continue;
            }

            int used = Math.min(freq[index], repeatLimit);
            for (int k = 0; k < used; k++) {
                sb.append((char) ('a' + index));
            }
            freq[index] -= used;

            if (freq[index] > 0) { // find a smaller character
                int prevIndex = index - 1;
                while (prevIndex >= 0 && freq[prevIndex] == 0) {
                    prevIndex--;
                }
                if (prevIndex < 0) {
                    break;
                }
                sb.append((char) ('a' + prevIndex));
                freq[prevIndex]--;
            }
        }

        return sb.toString();
    }
}
