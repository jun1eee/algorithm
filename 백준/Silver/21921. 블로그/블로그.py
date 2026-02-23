import sys
input = sys.stdin.readline
n, x = map(int,input().split())
arr = list(map(int,input().split()))
sum_arr = sum(arr[:x])
max_sum = sum_arr
cnt = 1
for i in range(x, n):
    sum_arr += arr[i]
    sum_arr -= arr[i-x]
    
    if sum_arr > max_sum:
        max_sum = sum_arr
        cnt = 1
    elif sum_arr == max_sum:
        cnt += 1
if max_sum == 0:
    print("SAD")
else:
    print(max_sum)
    print(cnt)