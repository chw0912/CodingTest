def solution(k, m, score):
    answer = 0
    
    score = sorted(score)
    
    while len(score) >= m:
        tmp = []
        
        for i in range(m):
            tmp.append(score.pop())
        answer += min(tmp)*m
        
    return answer