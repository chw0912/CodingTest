from collections import deque
def solution(progresses, speeds):
    answer = []
    
    for i in range(len(progresses)):
        progresses[i] = 100 - progresses[i]
        
    p_div = []
    
    for i in range(len(progresses)):
        div = progresses[i] // speeds[i]
        mod = progresses[i] % speeds[i]
        if mod != 0:
            div += 1
        p_div.append(div)
    dq = deque(p_div)
    
    while dq:
        p = dq.popleft()
        cnt = 0
        while dq:
            if p < dq[0]:
                cnt += 1
                
                break
            else:
                cnt+=1
                dq.popleft()
        answer.append(cnt)
    answer[-1] += 1
        
    
    return answer