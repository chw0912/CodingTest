# def solution(N, stages):
#     answer = {}
    
#     members = len(stages)
#     for i in range(1,N+1):
#         num = stages.count(i+1)
#         answer[i] = num/members
#         members -= num
    
#     return sorted(answer, key=lambda i : answer[i]+1,reverse=True)

def solution(N, stages):
    level = {}
    t = len(stages)

    for i in range(1, N+1):
        if t == 0: 
            level[i] = 0
        else:
            level[i] = stages.count(i)/t
            t -= stages.count(i)
    print(level)
    return sorted(level, key=lambda x:level[x], reverse=True)