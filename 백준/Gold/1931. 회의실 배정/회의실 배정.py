n = int(input())
meetings = [list(map(int, input().split())) for _ in range(n)]
meetings.sort(key=lambda x: (x[1], x[0]))
cnt = 0
last_end = 0

for start, end in meetings:
    if start >= last_end:
        cnt += 1
        last_end = end
print(cnt)