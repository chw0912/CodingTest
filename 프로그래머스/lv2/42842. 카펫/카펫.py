from math import sqrt

def solution(brown, yellow):
    answer = []
    total = brown + yellow
    
    for i in range(1,total+1):
        if total % i == 0:
            if total - ((total//i)*2 + (i-2)*2) == yellow:
                    return [total//i,i]