import heapq as hp

def solution(scoville, K):
    answer = 0
    hp.heapify(scoville)
    
    if scoville[0] >= K:
        return answer
    
    while scoville[0] < K and len(scoville) > 1:
        min1 = hp.heappop(scoville)
        min2 = hp.heappop(scoville)
        
        hp.heappush(scoville, min1 + (min2 * 2))
        answer += 1
        
        if scoville[0] >= K:
            return answer
    if scoville[0] < K:
        return -1
        