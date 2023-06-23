def solution(scores):
    answer = 1
    wanho = scores[0]
    wanho_score= sum(wanho)
    scores.sort(key=lambda x:(-x[0],x[1]))
    tmp = 0
    
    for score in scores:
        if wanho[0] < score[0] and  wanho[1] < score[1]:
            return -1
        
        if wanho_score < sum(score) and tmp <= score[1]:
            answer += 1
            tmp = score[1]
    
    return answer