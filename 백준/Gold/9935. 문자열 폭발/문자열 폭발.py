# Gold 4. 문자열 폭발
import sys

#입력값
string = sys.stdin.readline().rstrip()
explosion_str = sys.stdin.readline().rstrip()

# stack으로 문자열 폭발 구현
stack = []

for i in range(len(string)):
    stack.append(string[i])
    if ''.join(stack[-len(explosion_str):]) == explosion_str:
        for _ in range(len(explosion_str)):
            stack.pop()
#출력값
if stack:
    print(''.join(stack))
else:
    print('FRULA')