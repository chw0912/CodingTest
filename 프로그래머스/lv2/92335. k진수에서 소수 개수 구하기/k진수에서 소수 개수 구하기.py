import math

def is_prime(num):
    if num < 2:
        return False
    for i in range(2, int(math.sqrt(num)) + 1):
        if num % i == 0:
            return False
    return True

def solution(n, k):
    answer = ''
    
    while n > k:
        n, m = divmod(n, k)
        answer += str(m)
    answer += str(n)
    answer = answer[::-1]
    
    lst = answer.split('0')
    cnt = 0
    
    for num in lst:
        if num != '' and is_prime(int(num)):
            cnt += 1
        
    return cnt
