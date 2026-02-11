n = int(input())
nums = list(map(int,input().split()))
ops = list(map(int,input().split()))
max_ans = -10**9
min_ans = 10**9

def dfs(index, val, plus, minus, mul, div):
    global max_ans, min_ans
    if index == n:
        max_ans = max(max_ans, val)
        min_ans = min(min_ans, val)
        return
    if plus:
        dfs(index+1, val+nums[index], plus-1, minus, mul, div)
    if minus:
        dfs(index+1, val-nums[index], plus, minus-1, mul, div)
    if mul:
        dfs(index+1, val*nums[index], plus, minus, mul-1, div)
    if div:
        dfs(index+1, int(val/nums[index]), plus, minus, mul, div-1)

dfs(1, nums[0], ops[0], ops[1], ops[2], ops[3])

print(max_ans)
print(min_ans)