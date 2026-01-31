n = int(input())
ans = 0
for _ in range(n):
    word = input()
    word_set = set()
    check = True
    for i, w in enumerate(word):
        if w in word_set:
            if word[i] == word[i-1]:
                continue
            else:
                check = False
                break
        else:
            word_set.add(w)
    if check:
        ans += 1
print(ans)