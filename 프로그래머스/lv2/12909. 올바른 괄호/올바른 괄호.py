def solution(s):
    
    stack = []
    
    for w in s:
        if w == '(':
            stack.append(w)
        else:
            if stack == []:
                return False
            else:
                stack.pop()
                
    return stack == []