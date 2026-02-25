import sys
input = sys.stdin.readline
T = int(input())
for _ in range(T):
    n = int(input())
    arr = list(map(int,input().split()))
    counter = {}
    for a in arr:
        counter[a] = counter.get(a,0) + 1
        
    teams = {}
    rank = 1
    for i in range(n):
        if counter[arr[i]] == 6:
            if arr[i] in teams:
                teams[arr[i]].append(rank)
            else:
                teams[arr[i]] = [rank]
            rank += 1
    print(sorted(teams, key=lambda x:(sum(teams[x][0:4]), teams[x][4]))[0])