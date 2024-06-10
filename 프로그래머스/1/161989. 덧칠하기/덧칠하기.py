def solution(n, m, section):
    answer = 0
    paint = section[0] + m - 1
    cnt = 1
    
    for s in section:
        if paint < s:
            paint = s + m - 1
            cnt += 1
    
    return cnt