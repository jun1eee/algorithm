numbers = list(map(int,input()))
count = [0]*10
for n in numbers:
    count[n] += 1
max_num = -1
for i in range(10):
    if i == 6 or i == 9:
        continue
    max_num = max(max_num, count[i])
max_num = max(max_num, ((count[6] + count[9] + 1)//2))
print(max_num)