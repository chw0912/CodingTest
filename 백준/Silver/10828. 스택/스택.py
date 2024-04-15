# Silver 4. 스택
import sys

N = int(input())

stack = []

def command(cmd):
    if cmd[0] == 'push':
        stack.append(int(cmd[1]))
    elif cmd[0] == 'pop':
        if stack:
            print(stack[-1])
            stack.pop()
        else:
            print(-1)
    elif cmd[0] == 'size':
        print(len(stack))
    elif cmd[0] == 'empty':
        if stack:
            print(0)
        else:
            print(1)
    elif cmd[0] == 'top':
        if stack:
            print(stack[-1])
        else:
            print(-1)

for _ in range(N):
    cmd = sys.stdin.readline().split()
    command(cmd)
