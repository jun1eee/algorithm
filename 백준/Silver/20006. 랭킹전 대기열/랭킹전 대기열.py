import sys 
input = sys.stdin.readline
p, m = map(int,input().split())
rooms = []
for _ in range(p):
    l, n = input().split()
    l = int(l)
    check = False
    for r in rooms:
        if len(r) == m:
            continue
        if r[0][0] - 10 <= l <= r[0][0] + 10:
            check = True
            r.append([l,n])
            break
    if not check:
        rooms.append([[l,n]])
for r in rooms:
    r.sort(key=lambda x: x[1])
    if len(r) == m:
        print("Started!")
    else:
        print("Waiting!")
    for l, n in r:
        print(l, n)
            