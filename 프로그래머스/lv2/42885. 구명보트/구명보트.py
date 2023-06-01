from collections import deque

def solution(people, limit):
    people = sorted(people)
    dq=deque(people)
    cnt=0
    
    while dq:
        escape_L = dq.popleft()
        
        while dq:
            escape_R=dq.pop()
            if escape_L + escape_R > limit:
                cnt+=1
            else:
                break
        cnt += 1
    
    return cnt