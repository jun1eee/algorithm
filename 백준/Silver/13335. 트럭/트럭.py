from collections import deque

n, l, w = map(int, input().split())
trucks = deque(map(int, input().split()))
bridge = deque([0] * l)
weight = 0
time = 0

while trucks or weight > 0:
    out = bridge.popleft()
    weight -= out

    if trucks and weight + trucks[0] <= w:
        t = trucks.popleft()
        bridge.append(t)
        weight += t
    else:
        bridge.append(0)

    time += 1

print(time)
