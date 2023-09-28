def solution(k, score):
    answer = []
    k_score=[]
    
    for i in score:
        k_score.append(i)
        k_score.sort(reverse=True)
        
        if len(k_score) > k:
            k_score.pop()
        
        answer.append(k_score[-1])
    return answer