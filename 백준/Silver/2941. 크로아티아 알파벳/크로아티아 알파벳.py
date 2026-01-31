alphabet = ['c=','c-','dz=','d-','lj','nj','s=','z=']
word = input()
length = len(word)
for a in alphabet:
    if a in word:
        cnt = word.count(a)
        length -= (len(a)-1)*cnt
        if a == 'dz=':
            length += 1 * cnt
print(length)