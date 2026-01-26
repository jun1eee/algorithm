def solution(progresses, speeds):
    arr = []
    for i in range(len(progresses)):
        a = (100 - progresses[i]) // speeds[i]
        b = (100 - progresses[i]) % speeds[i]
        if b != 0:
            a += 1
        arr.append(a)

    answer = []
    i = 0
    while i < len(arr):
        target_day = arr[i]
        cnt = 1
        
        while i + 1 < len(arr) and arr[i + 1] <= target_day:
            cnt += 1
            i += 1
        
        answer.append(cnt)
        i += 1
        
    return answer