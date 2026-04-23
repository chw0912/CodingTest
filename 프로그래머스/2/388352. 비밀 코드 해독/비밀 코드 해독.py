from itertools import combinations

def solution(n, q, ans):
    answer = 0
    
    nums = [i for i in range(1, n+1)]
    
    combi = combinations(nums, 5)
    
    for com in combi:
        flag = True
        for i in range(len(q)):
            if len(list(set(com) & set(q[i]))) != ans[i]:
                flag = False
        
        if not flag:
            continue
        answer += 1
        
    
    return answer