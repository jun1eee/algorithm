n = int(input())
switches = list(map(int,input().split()))
k = int(input())
for _ in range(k):
    sex, number = map(int, input().split())
    if sex == 1:
        index = number-1
        while index < n:    
            switches[index] ^= 1
            index += number
    else:
        switches[number-1] ^= 1
        left = right = number-1
        while True:
            if left-1 >= 0 and right+1 < n and switches[left-1] == switches[right+1]:
                switches[left-1] ^= 1
                switches[right+1] ^= 1
                left -= 1
                right += 1
            else:
                break
for i, s in enumerate(switches, 1):
    print(s, end=" ")
    if i % 20 == 0:
        print()