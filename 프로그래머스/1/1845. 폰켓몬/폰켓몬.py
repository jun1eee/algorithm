from collections import defaultdict
def solution(nums):
    answer = 0
    dic = defaultdict(int)
    for n in nums:
        dic[n] += 1
    if len(nums)/2 <= len(dic):
        return len(nums)/2
    else:
        return len(dic)
    