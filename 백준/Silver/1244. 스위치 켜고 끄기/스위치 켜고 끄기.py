n = int(input())
switches = list(map(int, input().split()))
student_num = int(input())
for _ in range(student_num):
    sex, num = map(int,input().split())
    if sex == 1:
        i = 1
        while True:
            if num * i > n:
                break
            switches[num*i-1] = 1 - switches[num*i-1]
            i += 1
    else:
        switches[num-1] = 1 - switches[num-1]
        i = 1
        while True:
            if 0<=num-i-1<n and 0<=num+i-1<n:
                if switches[num-i-1] == switches[num+i-1]:
                    switches[num-i-1] = 1 - switches[num-i-1]
                    switches[num+i-1] = 1 - switches[num+i-1]
                    i += 1
                else:
                    break
            else: break
for i, s in enumerate(switches, 1):
    print(s, end=" ")
    if i % 20 == 0:
        print()
