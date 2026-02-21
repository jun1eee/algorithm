import sys
input = sys.stdin.readline
n, game = input().rstrip().split()
n = int(n)
people = set()
for _ in range(n):
    people.add(input().rstrip())
if game == 'Y':
    print(len(people))
elif game == 'F':
    print(len(people)//2)
else :
    print(len(people)//3)