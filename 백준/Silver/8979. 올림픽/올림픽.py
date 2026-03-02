import sys
input = sys.stdin.readline
n, k = map(int,input().split())
countries = [list(map(int,input().split())) for _ in range(n)]
countries.sort(key=lambda x: (-x[1], -x[2], -x[3]))

rank = 1
prev = countries[0][1:]
rank_dict = {countries[0][0]:1}

for i in range(1,n):
    cur = countries[i][1:]
    
    if cur != prev:
        rank += 1
    
    rank_dict[countries[i][0]] = rank
    prev = cur

print(rank_dict[k])