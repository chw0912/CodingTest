from collections import deque
def solution(s):
    answer = 0
    
    for i in range(len(s)):
        L = s[i:] + s[0:i]
        dq = deque()
        flag = True
        for l in L:
            if l == '[' or l == '{' or l == '(':
                dq.append(l)
            elif dq:
                if dq[-1] == '[' and l == ']':
                    dq.pop()
                elif dq[-1] == '(' and l == ')':
                    dq.pop()
                elif dq[-1] == '{' and l == '}':
                    dq.pop()
                else:
                    break
            elif L[0] == ']' or L[0] == '}' or L[0] == ')':
                flag = False
                break
                
        if not flag:
            continue
        else:
            if len(dq) == 0:
                answer += 1
            
    return answer