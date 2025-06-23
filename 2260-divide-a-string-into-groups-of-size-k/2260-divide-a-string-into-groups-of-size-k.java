class Solution {
    public String[] divideString(String s, int k, char fill) {
        int totalGroups = (s.length() + k - 1) / k; // round up division
        String[] result = new String[totalGroups];

        int index = 0;

        for (int i = 0; i < s.length(); i += k) {
            int end = Math.min(i + k, s.length());
            String group = s.substring(i, end);

            // If the last group is short, fill with the fill character
            if (group.length() < k) {
                int remaining = k - group.length();
                StringBuilder sb = new StringBuilder(group);
                for (int j = 0; j < remaining; j++) {
                    sb.append(fill);
                }
                group = sb.toString();
            }

            result[index++] = group;
        }

        return result;
    }
}
