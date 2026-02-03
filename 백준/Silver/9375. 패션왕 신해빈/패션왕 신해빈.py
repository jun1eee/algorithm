t = int(input())
for _ in range(t):
    clothes = {}
    n = int(input())
    for _ in range(n):
        a, b = input().split()
        if b in clothes:
            clothes[b].append(a)
        else:
            clothes[b] = [a]
    ans = 1
    for v in clothes.values():
        ans *= (len(v) + 1)
    print(ans-1)
            
