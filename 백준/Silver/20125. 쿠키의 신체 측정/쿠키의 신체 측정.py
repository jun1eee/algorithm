import sys
input = sys.stdin.readline
n = int(input())
arr = [input() for _ in range(n)]
heart_r, heart_c = 0, 0
check = False
for i in range(n):
    for j in range(n):
        if arr[i][j] == '*':
            heart_r = i + 1
            heart_c = j
            check = True
            break
    if check:
        break
left_arm, right_arm, waist, left_leg, right_leg = 0, 0, 0, 0, 0
for j in range(heart_c):
    if arr[heart_r][j] == '*':
        left_arm += 1
for j in range(heart_c+1,n):
    if arr[heart_r][j] == '*':
        right_arm += 1
for i in range(heart_r+1, n):
    if arr[i][heart_c] == '*':
        waist += 1
for i in range(heart_r+waist+1, n):
    if arr[i][heart_c-1] == '*':
        left_leg += 1
    if arr[i][heart_c+1] == '*':
        right_leg += 1
print(heart_r+1, heart_c+1)
print(left_arm, right_arm, waist, left_leg, right_leg)