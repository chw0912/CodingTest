def solution(n):
    answer = 0
    num_list = [i for i in range(0,n+1)]
    
    for i in range(1,n+1):
        x=0
        for j in range(i,n+1):
            x += j
            if x == n:
                answer += 1
                break
            elif x > n:
                break
    
    return answer