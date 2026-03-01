def solution(alp, cop, problems):
    
    max_alp = 0
    max_cop = 0
    
    # 입력으로 주어진 problmes에서 최대 알고력, 코딩력을 구하기
    for problem in problems:
        max_alp = max(max_alp, problem[0])
        max_cop = max(max_cop, problem[1])
        
    # 만약 최대 알고력이 초기 알고력보다 작다면 작은값을 알고력에 대입
    alp = min(alp, max_alp)
    # 만약 최대 코딩력이 초기 코딩력보다 작다면 작은값을 코딩력에 대입
    cop = min(cop, max_cop)
            
    
    # 제한사항의 주어진 최대 알고력 및 코딩력 크기만큼의 2차원 dp 배열 생성
    dp = [[151] * (max_cop + 1) for _ in range(max_alp + 1)]
    
    # 초기 시간을 0으로 초기화
    dp[alp][cop] = 0
    
    
    for i in range(alp, max_alp + 1):
        for j in range(cop, max_cop + 1):
            
            # 알고력(i)을 높이기 위한 알고력 공부하기
            if i+1 <= max_alp:
                # 알고력(i) 1을 높이기 위해 1의 시간이 필요 
                dp[i+1][j] = min(dp[i][j]+1, dp[i+1][j])
                

            # 코딩력(j)을 높이기 위한 코딩력 공부하기
            if j+1 <= max_cop:
                # 코딩력(j) 1을 높이기 위해 1의 시간이 필요
                dp[i][j+1] = min(dp[i][j]+1, dp[i][j+1])
                
            # 문제를 풀 수 있는 문제로 알고력 및 코딩력 공부하기
            for alp_req, cop_req, alp_rwd, cop_rwd, cost in problems:
                # 만약 현재 알고력(i)과 코딩력(j)이 요구하는 알고력(alp_req)과 코딩력(cop_req)보다 크거나 같다면 
                if alp_req <= i and cop_req <= j:
                    
                    # 최대 알고력(max_alp) 및 코딩력(max_cop)과 
                    # 현재 알고력(i)과 코딩력(j)에 증가값(alp_rwd, cop_rwd)을 더한 값을 비교
                    new_alp = min(max_alp, i + alp_rwd)
                    new_cop = min(max_cop, j + cop_rwd)
                    
                    # 다음 알고력 및 코딩력을 현재 알고력 및 코딩력에 소요시간을 더한 값을 비교하여 최소값을 대입  
                    dp[new_alp][new_cop] = min(dp[new_alp][new_cop], dp[i][j] + cost)
                    
            
    return dp[-1][-1]