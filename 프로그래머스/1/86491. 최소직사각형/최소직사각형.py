def solution(sizes):
    n = len(sizes)
    for i in range(n):
        if sizes[i][0] < sizes[i][1]:
            sizes[i][0], sizes[i][1] = sizes[i][1], sizes[i][0]
    max_a = -1
    max_b = -1
    for i in range(n):
        if max_a <= sizes[i][0]:
            max_a = sizes[i][0]
        if max_b <= sizes[i][1]:
            max_b = sizes[i][1]
    answer = max_a * max_b
    return answer