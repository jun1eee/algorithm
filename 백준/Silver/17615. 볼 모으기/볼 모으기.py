n = int(input())
arr = input()

r_cnt = arr.count('R')
b_cnt = n - r_cnt

# 1) R을 왼쪽으로 모으기
left_r = 0
for ch in arr:
    if ch == 'R':
        left_r += 1
    else:
        break
move1 = r_cnt - left_r

# 2) R을 오른쪽으로 모으기
right_r = 0
for ch in reversed(arr):
    if ch == 'R':
        right_r += 1
    else:
        break
move2 = r_cnt - right_r

# 3) B를 왼쪽으로 모으기
left_b = 0
for ch in arr:
    if ch == 'B':
        left_b += 1
    else:
        break
move3 = b_cnt - left_b

# 4) B를 오른쪽으로 모으기
right_b = 0
for ch in reversed(arr):
    if ch == 'B':
        right_b += 1
    else:
        break
move4 = b_cnt - right_b

print(min(move1, move2, move3, move4))