# Silver 4. 큐
import sys


input = sys.stdin.readline

N = int(input().rstrip())

queue = []

for _ in range(N):
    command = input().rstrip()
    if "push" in command:
        queue.append(command.split()[1])
    elif "pop" == command:
        if queue:
            pop_num = queue.pop(0)
            print(pop_num)
        else:
            print(-1)
    elif "size" == command:
        print(len(queue))
    elif "empty" == command:
        if queue:
            print(0)
        else:
            print(1)
    elif "front" == command:
        if queue:
            print(queue[0])
        else:
            print(-1)
    elif "back" == command:
        if queue:
            print(queue[-1])
        else:
            print(-1)