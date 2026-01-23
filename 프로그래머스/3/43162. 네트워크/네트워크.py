from collections import deque 
def solution(n, computers):
    answer = 0
    visited = [False] * n
    
    def bfs(start):
        q = deque()
        q.append(start)
        visited[start] = True
        while q:
            cur = q.popleft()
            for nxt in range(n):
                if computers[cur][nxt] == 1 and not visited[nxt]:
                    visited[nxt] = True
                    q.append(nxt)
    
    for i in range(n):
        if not visited[i]:
            bfs(i)
            answer+=1
    return answer