import math

def solution(cost, hint):
    ticket = [0] * len(cost)
    answer = dfs(0, ticket, cost, hint, 0)
    
    return answer


def dfs(stage, ticket, cost, hint, totalCost):
    result = float('inf');
    if stage == len(cost):
        return totalCost
    
    # 현재 가지고 있는 힌트권 개수
    hintTicket = ticket[stage]
    
    # 힌트권은 N-1개까지 사용가능
    if hintTicket >= len(cost):
        hintTicket = len(cost) - 1
    
    # 사용 티켓 개수만큼 차감
    ticket[stage] -= hintTicket
    
    # 현재 문제 해결 비용
    totalCost += cost[stage][hintTicket]
    
    # 힌트 번들을 구매하지 않았을 때
    result = min(result, dfs(stage+1, list(ticket), cost, hint, totalCost))
    
    # 힌트 번들을 구매했을 때
    if stage < len(cost)-1 and len(hint[stage]) > 0: 
        totalCost += hint[stage][0]
        
        # 구매 후 티켓 상태르 담을 새로운 리스트 생성
        next_ticket = list(ticket)
        
        for h in hint[stage][1:]:
            next_ticket[h-1] += 1
        result = min(result, dfs(stage+1, next_ticket, cost, hint, totalCost))
    
    return result
    