def solution(food):
    answer = ''
    
    for i in range(1, len(food)):
        for j in range(food[i]//2):
                answer += str(i)       
    
    reverse_str = "".join(reversed(answer))
    return answer+'0'+reverse_str