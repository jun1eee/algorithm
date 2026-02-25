def solution(brown, yellow):
    for x in range(1, int(yellow**0.5) + 1):
        if yellow % x == 0:
            y = yellow // x
            if (x + y)*2 + 4 == brown:
                return [y+2,x+2]
