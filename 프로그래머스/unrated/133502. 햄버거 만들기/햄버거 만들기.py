def solution(ingredient):
    answer = 0
    current_stack = []
    
    for i in ingredient:
        current_stack.append(i)
        
        if current_stack[-4:] == [1,2,3,1]:
            del current_stack[-4:]
            answer += 1
    
    return answer