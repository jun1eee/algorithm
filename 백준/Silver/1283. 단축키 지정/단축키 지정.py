n = int(input())
options = [input() for _ in range(n)]

used = set()

def func(option) :
    words = option.split()
    
    for i, word in enumerate(words):
        first = word[0].lower()
        if first not in used:
            used.add(first)
            words[i] = '[' + word[0] +']' + word[1:]
            return ' '.join(words)
    
    for i, chr in enumerate(option):
        if chr != ' ':
            lower_chr = chr.lower()
            if lower_chr not in used:
                used.add(lower_chr)
                return option[:i] + '[' + chr + ']' + option[i+1:]
    return option            

for option in options:
    print(func(option))