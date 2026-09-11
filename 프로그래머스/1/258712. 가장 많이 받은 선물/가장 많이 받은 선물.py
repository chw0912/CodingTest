def solution(friends, gifts):
    answer = -10001
    
    dic = {val : idx for idx, val in enumerate(friends)}
    
    lst = [[0 for _ in range(len(friends))] for _ in range(len(friends))]
    
    next_month = [0 for _ in range(len(friends))]
    visited = [[False for _ in range(len(friends))] for _ in range(len(friends))]
    
    
    for gift in gifts:
        A, B = gift.split(" ")
        lst[dic[A]][dic[B]] += 1
    
    for i in range(len(friends)):
        for j in range(len(friends)):
            if i == j: 
                continue
            
            if visited[i][j]:
                continue
            
            A = sum(lst[i]) - sum([row[i] for row in lst])
            B = sum(lst[j]) - sum([row[j] for row in lst])
            
            # 두 사람이 선물을 주고받은 기록이 없거나 같다면,
            # 선물지수가 큰 사람이 작은사람에게 선물을 하나 받는다.
            # i -> A, j -> B
            visited[i][j] = True
            visited[j][i] = True
            if lst[i][j] == lst[j][i]:
                
                if A > B:
                    next_month[i] += 1
                elif B > A:
                    next_month[j] += 1
            else:
                if lst[i][j] > lst[j][i]:
                    next_month[i] += 1
                elif lst[j][i] > lst[i][j]:
                    next_month[j] += 1
        
        
    return max(next_month)

