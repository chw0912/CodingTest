# [S/W 문제해결 기본] 4일차 - 괄호 짝짓기
from collections import deque

T = 10

for t in range(1, T+1):
    L = int(input())
    lst = list(input())
    dq = deque()

    flag = True
    for l in lst:
        if l in ["<","{","[","("]:
            dq.append(l)
        else:
            tmp = dq.pop()

            if l == ">":
                if tmp != "<":
                    flag = False
                    break
            elif l == "}":
                if tmp != "{":
                    flag = False
                    break
            elif l == "]":
                if tmp != "[":
                    flag = False
                    break
            elif l == ")":
                if tmp != "(":
                    flag = False
                    break

    if flag:
        print(f"#{t} 1")
    elif dq:
        print(f"#{t} 0")
    else:
        print(f"#{t} 0")
