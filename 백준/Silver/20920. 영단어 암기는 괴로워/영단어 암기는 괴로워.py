import sys
input = sys.stdin.readline
n, m = map(int, input().split())
words = {}
ans = []
for _ in range(n):
    word = input().rstrip()
    if len(word) < m:
        continue
    if word in words:
        words[word] += 1
    else:
        ans.append(word)
        words[word] = 1
ans.sort(key=lambda x: (-words[x], -len(x),x))
for a in ans:
    print(a)