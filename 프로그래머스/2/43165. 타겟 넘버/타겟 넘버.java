class Solution {
    public static int cnt;
    public int solution(int[] numbers, int target) {
        cnt = 0;
        dfs(numbers, target, 0, 0);
        int answer = cnt;
        return answer;
    }
    public void dfs(int[] numbers, int target, int n, int sum){
        if (n == numbers.length){
            if (sum == target){
                cnt++;
            }
            return;
        }
        dfs(numbers, target, n+1, sum+numbers[n]);
        dfs(numbers, target, n+1, sum-numbers[n]);
    }
}