def solution(a, b, n):
    answer = 0
    
    # 콜라 병 수 구하기
    while n >= a:
        answer += (n//a)*b
        tmp = (n//a)*b
        n = n-(n//a)*a+tmp
    
    return answer