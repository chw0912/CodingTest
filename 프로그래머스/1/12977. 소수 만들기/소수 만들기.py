from itertools import combinations

def solution(nums):
    answer = 0

    combi = [com for com in combinations(nums, 3)]
    
    for com in combi:
        prime = sum(com)
        flag = True
        for num in range(2, prime):
            if prime % num == 0:
                flag = False
                break
        if flag:
            answer += 1
            
    return answer