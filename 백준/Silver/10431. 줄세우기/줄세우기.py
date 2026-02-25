import sys
from collections import deque
input = sys.stdin.readline
n = int(input())
for _ in range(n):
    arr = list(map(int,input().split()))
    total = 0 
    for i in range(1,20):
        for j in range(i+1, 21):
            if arr[i] > arr[j]:
                arr[i], arr[j] = arr[j], arr[i]
                total+=1
    print(arr[0], total)
