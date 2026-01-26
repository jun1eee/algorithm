from collections import deque
def solution(begin, target, words):
    if target not in words:
        return 0
    return bfs(begin, target, words)
def bfs(begin, target, words):
    q = deque()
    q.append((begin, 0))
    while q:
        curr, cnt = q.popleft()
        if curr == target:
            return cnt
        for word in words:
            num = 0
            for i in range(len(word)):
                if curr[i] != word[i]:
                    num += 1
            if num == 1:
                q.append((word, cnt+1))
            