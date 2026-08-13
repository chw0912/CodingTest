from collections import deque

def solution(priorities, location):
    answer = []
    
    dq = deque((idx, data) for idx, data in enumerate(priorities))
    
    
    while dq:
        process = dq.popleft()
        
        if dq and any(process[1] < q[1] for q in dq):
            dq.append(process)
        else:
            answer.append(process)
    
    for i in answer:
        if i[0] == location:
            return answer.index(i) + 1
