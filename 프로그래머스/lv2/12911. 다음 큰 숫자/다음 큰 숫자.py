def solution(n):
    answer = 0
    a = bin(n).count('1')
    x = n+1
    while True:
        b = bin(x).count('1')
        if a != b:
            x+=1
        else:
            break
    
    return x