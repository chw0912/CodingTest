import math

def solution(signals):
    answer = 0
    cycle = []
    cycle_lengths = [] # 각 신호등의 주기 길이를 저장할 리스트
    
    # 1. 신호등 주기 리스트 생성 및 주기 길이 계산
    for i in range(len(signals)):
        length = sum(signals[i])
        cycle.append([0] * length)
        cycle_lengths.append(length) # 주기 길이 저장
        
    for idx, val in enumerate(signals):
        g = val[0]
        y = val[1]
        r = val[2]
        
        # 신호등 값 할당 (초록: 1, 노랑: 2, 빨강: 3)
        for i in range(0, g):
            cycle[idx][i] = 1
        for i in range(g, g+y):
            cycle[idx][i] = 2
        for i in range(g+y, g+y+r):
            cycle[idx][i] = 3
    
    # 2. 최대 검사 시간(최소공배수) 구하기
    max_time = 1
    for length in cycle_lengths:
        # 두 수의 곱을 최대공약수로 나누면 최소공배수가 된다.
        max_time = (max_time * length) // math.gcd(max_time, length)
    
    # 3. 모든 신호등이 동시에 노란색(2)이 되는 시간 찾기
    for time in range(max_time):
        visited = [False] * len(signals)
        
        for idx in range(len(signals)):
            # 현재 시간에 idx번째 신호등이 노란색인지 확인
            if cycle[idx][time % len(cycle[idx])] == 2:
                visited[idx] = True
        
        # 모든 신호등이 노란색 신호등이면 현재 시간 반환
        if all(visited):
            return time+1
        
    # max_time까지 돌았는데도 못 찾았다면 영원히 불가능한 경우이므로 -1 반환
    return -1