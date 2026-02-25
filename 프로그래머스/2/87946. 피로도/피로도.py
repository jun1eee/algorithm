def solution(k, dungeons):
    n = len(dungeons)
    visited = [False] * n
    answer = 0
    def dfs(cur_k, cnt):
        nonlocal answer
        answer = max(answer,cnt)
        
        for i in range(n):
            need, cost = dungeons[i]
            if cur_k >= need and not visited[i]:
                visited[i] = True
                dfs(cur_k - cost, cnt + 1)
                visited[i] = False
    dfs(k,0)
    return answer