def solution(sequence, k):
    answer = []
    cnt = 0
    r = 0
    
    for l in range(len(sequence)):
        
        while cnt < k and r < len(sequence):
            cnt += sequence[r]
            r += 1
        if cnt == k:
            if not answer:
                answer = [l,r-1]
            else:
                answer = [l, r-1] if answer[1]-answer[0] > r-1-l else answer
        cnt -= sequence[l]
        
        
    return answer