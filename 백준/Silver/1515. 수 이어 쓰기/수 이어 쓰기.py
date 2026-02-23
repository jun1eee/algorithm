import sys
input = sys.stdin.readline
target = input().rstrip()

i = 0
num = 1
while True:
    for ch in str(num):
        if i < len(target) and target[i] == ch:
            i += 1
        if i == len(target):
            print(num)
            exit()
    num += 1