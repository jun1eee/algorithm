import sys
input = sys.stdin.readline
lst = ['a', 'e', 'i', 'o', 'u']
while True:
    word = input().rstrip()
    if word == "end":
        break
    check = True
    has_vowel = False
    for l in lst:
        if l in word:
            has_vowel = True
            break
    if not has_vowel:
        check = False
    for i in range(len(word)-2):
        if word[i] in lst and word[i+1] in lst and word[i+2] in lst:
            check = False
            break
        if word[i] not in lst and word[i+1] not in lst and word[i+2] not in lst:
            check = False
            break
    for i in range(len(word)-1):
        if word[i] == word[i+1]:
            if word[i] in ['e','o']:
                continue
            else:
                check = False
                break
    if check :
        print("<"+word+">"+" is acceptable.")
    else:
        print("<"+word+">"+" is not acceptable.")