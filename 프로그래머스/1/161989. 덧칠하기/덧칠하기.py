def solution(n, m, section):
    answer = 0
    paint = section[0] + m - 1 # 맨 처음 구역 + m - 1 까지의 구역을 페인트 칠하기
    cnt = 1 # 페인트 칠한 횟수
    
    # 주어진 원소들로만 페인트 칠하기
    for s in section:
        # 만약 페인트 칠한 구역보다 s가 크면 s에서 다시 m - 1 만큼 페인트 칠하기 
        if paint < s:
            paint = s + m - 1
            cnt += 1
    
    return cnt