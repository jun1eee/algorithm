def solution(n, lost, reserve):
    lost = set(lost)
    reserve = set(reserve)
    
    inter = lost & reserve
    lost -= inter
    reserve -= inter

    for r in reserve:
        if r-1 in lost:
            lost.remove(r-1)
        elif r+1 in lost:
            lost.remove(r+1)

    return n - len(lost)
