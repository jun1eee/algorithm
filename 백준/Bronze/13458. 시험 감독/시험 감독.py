n = int(input())
people = list(map(int, input().split()))
b, c = map(int,input().split())
ans = 0
ans += n
for p in people:
    tmp = p - b 
    if tmp < 0:
        continue
    else:
        ans += tmp // c
        if tmp % c != 0:
            ans += 1
print(ans)