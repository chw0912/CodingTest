def solution(d, budget):
    answer = 0
    d_Sort = sorted(d)
    cnt = 0
    for i in range(len(d)):
        if budget - d_Sort[i] >= 0:
            budget -= d_Sort[i]
            cnt += 1
        else:
            break
    
    return cnt