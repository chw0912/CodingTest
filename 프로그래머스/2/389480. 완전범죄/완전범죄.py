import math

def solution(info, n, m):
    # dp[i] = A가 i만큼 훔쳤을 때, B가 훔친 최소 무게
    # 처음에는 아무것도 불가능하므로 모두 무한대로 초기화
    dp = [float('inf')] * n
    
    # 아무 물건도 안 훔쳤을 때 A=0, B=0이므로 dp[0] = 0
    dp[0] = 0 
    
    for a, b in info:
        # 이번 물건을 훔쳤을 때의 결과를 담을 새로운 배열
        next_dp = [float('inf')] * n
        
        for i in range(n):
            # 이전 단계에서 도달 불가능했던 상태면 패스
            if dp[i] == float('inf'):
                continue
            
            # 1. A가 이번 물건을 훔치는 경우
            # A의 새 무게(i + a)가 n보다 작아야 함
            if i + a < n:
                next_dp[i + a] = min(next_dp[i + a], dp[i])
            
            # 2. B가 이번 물건을 훔치는 경우
            # A의 무게는 그대로(i), B의 새 무게(dp[i] + b)가 m보다 작아야 함
            if dp[i] + b < m:
                next_dp[i] = min(next_dp[i], dp[i] + b)
                
        # 갱신된 결과를 다음 물건 탐색에 사용
        dp = next_dp 
        
    # 모든 물건을 다 확인한 후, 무한대가 아닌 값이 있다면
    # 그중 가장 작은 A의 무게(인덱스 i)가 정답!
    for i in range(n):
        if dp[i] != float('inf'):
            return i
            
    # 가능한 경우가 하나도 없었다면 -1 반환
    return -1