def solution(n):
    answer = 0
    
    num1 = 1
    num2 = 2
    for i in range(1,n-1):
        num2 = (num1 + num2)%1000000007
        num1 = num2 - num1
            
    
    return num2