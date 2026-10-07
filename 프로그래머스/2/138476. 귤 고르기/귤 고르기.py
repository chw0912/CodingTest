from collections import Counter

def solution(k, tangerine):
    answer = 0
    
    arr = Counter(tangerine)
    cnt = [v for v in arr.values()]
    
    # 내림차순 정렬
    cnt.sort(reverse=True)
    
    for i in range(len(cnt)):
        k -= cnt[i]
        answer += 1
        if k <= 0:
            break
    
    return answer