def solution(s):
    
    stack = []
    
    # 규칙
    for w in s:
        if w == '(':
            stack.append(w)
        else:
            if stack == []:
                return False
            else:
                stack.pop()
                
    return stack == []