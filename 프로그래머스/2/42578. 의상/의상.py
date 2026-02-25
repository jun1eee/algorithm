def solution(clothes):
    dic = {}
    for a, b in clothes:
        dic[b] = dic.get(b,0) + 1
    answer = 1
    for d in dic.values():
        answer *= (d+1)
    return answer - 1