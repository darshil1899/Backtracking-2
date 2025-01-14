/*
 * Time Complexity: O(N(2^N))
 * Space Complexity: O(N)
 */
class Solution {

    private boolean isPalindrome(String s, int start, int end) {
        while (start <= end) {
            if (s.charAt(start++) != s.charAt(end--))
                return false;
        }
        return true;
    }

    private void dfs(int index, String s, List<String> path, List<List<String>> res) {
        if (index == s.length()) {
            res.add(new ArrayList<>(path));
            return;
        }
        for (int i = index; i < s.length(); ++i) {
            if (isPalindrome(s, index, i)) {

                path.add(s.substring(index, i + 1));
                dfs(i + 1, s, path, res);

                path.remove(path.size() - 1);
            }
        }
    }

    public List<List<String>> partition(String s) {
        List<List<String>> res = new ArrayList<List<String>>();
        List<String> path = new ArrayList<>();
        dfs(0, s, path, res);
        return res;
    }
}
