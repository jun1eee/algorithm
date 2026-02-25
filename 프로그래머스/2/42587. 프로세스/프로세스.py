from collections import deque
def solution(priorities, location):
    q = deque((i,p) for i, p in enumerate(priorities))
    answer = 0
    while q:
        i, p = q.popleft()
        if q and max(q, key=lambda x:x[1])[1] > p:
            q.append((i,p))
        else:
            answer += 1
            if i == location:
                return answer