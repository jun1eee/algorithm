n = int(input())
nums = list(map(int,input().split()))
tmp = list(set(nums))
tmp.sort()
dict = {}
for i,v in enumerate(tmp):
    dict[v] = i
for n in nums:
    print(dict[n], end= " ")