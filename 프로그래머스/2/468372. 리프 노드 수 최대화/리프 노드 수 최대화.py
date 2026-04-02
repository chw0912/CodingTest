def solution(dist_limit, split_limit):
    max_leaves = 1
    
    # 1. 탐색할 a와 b의 최대 범위를 구합니다.
    # (분배도가 split_limit을 넘지 않는 선까지만 탐색하면 됩니다.)
    max_a = 0
    while (1 << max_a) <= split_limit:
        max_a += 1
        
    max_b = 0
    while (3 ** max_b) <= split_limit:
        max_b += 1
        
    # 2. 가능한 모든 (a, b) 층의 조합을 확인합니다.
    for a in range(max_a + 1):
        for b in range(max_b + 1):
            # N: 이 층까지 완전히 분배했을 때 생성되는 리프 노드 수 (이 값이 곧 분배도)
            N = (1 << a) * (3 ** b)
            
            # 조건 1: 분배도가 split_limit을 초과하면 불가능한 트리이므로 패스
            if N > split_limit:
                continue
                
            # S: 이 층까지 구성하는 데 사용한 분배 노드의 총합
            S = (1 << a) - 1
            if b > 0:
                S += (1 << a) * ((3 ** b) - 1) // 2
                
            # 조건 2: 예산(dist_limit)을 초과하면 불가능한 트리이므로 패스
            if S > dist_limit:
                continue
                
            # --- 유효한 트리 구조를 찾았습니다! 이제 3가지 경우의 수를 확인합니다 ---
            
            # 경우 A: 여기서 더 이상 분배하지 않고 멈추는 경우
            max_leaves = max(max_leaves, N)
            
            # 경우 B: 남은 예산(dist_limit - S)을 영끌해서, 
            # 마지막 층의 노드 중 일부만 2개씩 부분 분배하는 경우
            if N * 2 <= split_limit:
                # 최대 N개의 노드를 분배할 수 있지만, 남은 예산만큼만 가능
                r = min(N, dist_limit - S) 
                # 노드 하나를 2개로 분배할 때마다 리프 노드는 1개(2-1)씩 늘어남
                max_leaves = max(max_leaves, N + r * 1) 
                
            # 경우 C: 남은 예산을 영끌해서, 
            # 마지막 층의 노드 중 일부만 3개씩 부분 분배하는 경우
            if N * 3 <= split_limit:
                r = min(N, dist_limit - S)
                # 노드 하나를 3개로 분배할 때마다 리프 노드는 2개(3-1)씩 늘어남
                max_leaves = max(max_leaves, N + r * 2) 
                
    return max_leaves