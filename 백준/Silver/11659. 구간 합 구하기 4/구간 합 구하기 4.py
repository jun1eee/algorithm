import sys
input = sys.stdin.readline

n, m = map(int, input().split())
arr = list(map(int, input().split()))

prefix = [0] * (n + 1)
for k in range(1, n + 1):
    prefix[k] = prefix[k-1] + arr[k-1]

out = []
for _ in range(m):
    i, j = map(int, input().split())
    out.append(str(prefix[j] - prefix[i-1]))

sys.stdout.write("\n".join(out))