import math

def solution(begin, end):
    answer = []
    
    for n in range(begin, end+1):
        answer.append(maxBlock(n))
    
    return answer

def maxBlock(n):
    tmp = [1]
    if n == 1:
        return 0
    for i in range(2, int(math.sqrt(n))+ 1):
        if n%i == 0 and i <= 1e7:
            tmp.append(i)
            if(n//i <= 1e7 and n//i != n):
                tmp.append(n//i)
    return max(tmp)