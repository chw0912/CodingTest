def solution(arr, divisor):
    answer = []
    
    for a in arr:
        # 나머지가 0
        if a % divisor == 0:
            answer.append(a)
    if len(answer) == 0:
        return [-1]
    return sorted(answer)