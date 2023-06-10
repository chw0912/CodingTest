from itertools import permutations
def solution(k, dungeons):
    answer = 0
    
    combi = [list(com) for com in permutations(dungeons,len(dungeons))]
    
    possible = []
    i=0
    while i < len(combi):
        p = k
        cnt = 0
        for j in combi[i]:
            if p >= j[0]:
                p = p - j[1]
                cnt += 1
            elif p < j[0]:
                break
        
        possible.append(cnt)
        i += 1
            
    return max(possible)