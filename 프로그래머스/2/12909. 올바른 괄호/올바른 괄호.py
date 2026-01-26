def solution(s):
    arr = []
    for str in s:
        if str == '(':
            arr.append('(')
        else:
            if len(arr) == 0:
                return False
            else:
                arr.pop()
    if len(arr) == 0:
        return True
    else:
        return False