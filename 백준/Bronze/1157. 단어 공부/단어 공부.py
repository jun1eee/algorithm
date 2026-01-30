word = input().upper()
word_set = list(set(word))
cnt = []
for w in word_set:
    cnt.append(word.count(w))
if cnt.count(max(cnt)) >= 2:
    print("?")
else:
    print(word_set[cnt.index(max(cnt))])