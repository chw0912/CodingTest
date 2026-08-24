def solution(targets):
    answer = 0
    targets.sort(key = lambda x: x[1])
    start = 0
    end = 0
    
    for s, e in targets:
        if s >= end:
            start = s
            end = e
            answer += 1
            
    return answer