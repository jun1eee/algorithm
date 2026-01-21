from collections import defaultdict
def solution(participant, completion):
    dict = defaultdict(int)
    for name in participant:
        dict[name] += 1
    for name in completion:
        dict[name] -= 1
    for name in dict:
        if dict[name] > 0:
            return name