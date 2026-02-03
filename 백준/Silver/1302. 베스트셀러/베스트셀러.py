from collections import defaultdict
n = int(input())
books = defaultdict(int)
for _ in range(n):
    b = input()
    books[b] += 1
ans = []
max_val = max(books.values())
for k, v in books.items():
    if v == max_val:
        ans.append(k)
ans.sort()
print(ans[0])