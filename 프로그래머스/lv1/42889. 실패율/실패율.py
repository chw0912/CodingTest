def solution(N, stages):
    answer = {}
    
    members = len(stages)
    for i in range(1,N+1):
        if members != 0:
            num = stages.count(i)
            answer[i] = num/members
            members -= num
        else:
            answer[i]=0
    return sorted(answer, key=lambda i : answer[i],reverse=True)

