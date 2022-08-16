class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> results = new ArrayList<>();
        recurse(results, nums, new Stack<>(), 0);
        return results;
    }

    private void recurse(List<List<Integer>> result, int[] nums, Stack path, int position) {
        if (position == nums.length) {
            result.add(new ArrayList<>(path));
            return;
        }

        path.push(nums[position]);
        recurse(result, nums, path, position + 1);
        path.pop();
        recurse(result, nums, path, position + 1);
    }
}