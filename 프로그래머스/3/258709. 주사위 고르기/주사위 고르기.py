from itertools import combinations

def get_sums(dice_group):
    if not dice_group:
        return {}
        
    # 초기값: 주사위 0개를 굴렸을 때의 합계 0은 1가지 경우의 수
    sums = {0: 1} 
    
    # A 또는 B가 선택한 각 주사위(current_dice)를 순회
    for current_dice in dice_group:
        new_sums = {}
        
        # 이전까지의 합(prev_sum)과 그 횟수(count)
        for prev_sum, count in sums.items():
            
            # 현재 주사위의 각 면(face)을 더함
            for face in current_dice:
                new_sum = prev_sum + face
                
                # 새로운 합계의 횟수를 업데이트: 이전 합계의 횟수만큼 누적
                new_sums[new_sum] = new_sums.get(new_sum, 0) + count
        
        sums = new_sums
        
    return sums

def win_game_fast(A, B):
    A_sums = get_sums(A)
    B_sums = get_sums(B)
    
    A_win = 0
    B_win = 0
    
    # A의 가능한 합계와 B의 가능한 합계를 비교
    for a_sum, a_count in A_sums.items():
        for b_sum, b_count in B_sums.items():
            
            if a_sum > b_sum:
                # A의 승리 횟수 누적
                A_win += a_count * b_count
                
            elif a_sum < b_sum:
                # B의 승리 횟수 (A의 패배 횟수) 누적
                B_win += a_count * b_count
                
    return A_win, B_win

def solution(dice):
    answer = []
    diceLen = len(dice)
    n = diceLen // 2
    # 주사위 인덱스 (0부터 시작)
    combi = list(combinations([i for i in range(diceLen)], n))
    max_wins = -1 # 최대 승리 횟수
    
    # 모든 A의 조합을 순회
    for A_indices in combi:
        # B_indices는 A_indices를 제외한 나머지 인덱스
        all_indices = set(range(diceLen))
        B_indices = tuple(all_indices - set(A_indices))
        
        # A와 B가 선택한 실제 주사위 면 정보
        A = [dice[c] for c in A_indices]
        B = [dice[c] for c in B_indices]
        
        # DP/분포를 이용한 빠른 승리 횟수 계산
        A_win, B_win = win_game_fast(A, B)
        
        # 현재 A 조합의 승리 횟수가 최대 승리 횟수보다 높으면 갱신
        if A_win > max_wins:
            max_wins = A_win
            answer = list(A_indices)
        
        # 현재 B 조합의 승리 횟수가 최대 승리 횟수보다 높으면 갱신
        # B_indices는 A_indices의 보완 조합이므로, 이 검사를 통해 모든 조합의 최대 승률을 검사
        if B_win > max_wins:
            max_wins = B_win
            answer = list(B_indices)
            
    # 주사위 인덱스는 1부터 시작하므로 +1 처리하여 반환
    return [a + 1 for a in answer]