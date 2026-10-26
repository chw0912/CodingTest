def solution(number, k):
    stack = []
    
    # 그리디 풀이
    for num in number:
        while stack and stack[-1] < num and k > 0:
            stack.pop()
            k -= 1
        stack.append(num)
    
    stack = stack[:len(number)-k]
    
    
    return ''.join(stack)
