def solution(ingredient):
    answer = 0
    current_stack = [] # 현재 재료 상태
    
    for i in ingredient:
        current_stack.append(i)
        
        if current_stack[-4:] == [1,2,3,1]:
            del current_stack[-4:]
            answer += 1
    
    return answer