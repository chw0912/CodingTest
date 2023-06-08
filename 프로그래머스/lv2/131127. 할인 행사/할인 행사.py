from collections import Counter
def solution(want, number, discount):
    answer = 0

    for i in range(len(discount)-9):
        dis = Counter(discount[i:i+10])
        num = 0
        for j in range(len(want)):
            if want[j] not in dis:
                break
            elif want[j] in dis and dis[want[j]] >= number[j]:
                num += 1
        if num == len(want):
            answer += 1
        
                    
    return answer