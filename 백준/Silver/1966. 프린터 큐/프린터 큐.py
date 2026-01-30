from collections import deque
t = int(input())
for _ in range(t):
    n, m = map(int, input().split())
    scores = deque(map(int, input().split()))
    cnt = 0
    
    while scores:
        best = max(scores) 
        front = scores.popleft()
        
        m -= 1 
        
        if front == best:
            cnt += 1
            if m < 0: 
                print(cnt)
                break
        else:
            scores.append(front)
            if m < 0:
                m = len(scores) - 1