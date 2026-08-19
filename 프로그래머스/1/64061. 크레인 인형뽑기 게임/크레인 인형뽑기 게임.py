from collections import deque

def solution(board, moves):
    answer = 0
    
    depth = len(board)
    basket = deque()
    
    for m in moves:
        for d in range(depth):
            curr = board[d][m-1]
            
            if curr == 0:
                continue
                
            if basket and basket[-1] == curr:
                answer += 2
                basket.pop()
                board[d][m-1] = 0
                break
            
            basket.append(curr)
            board[d][m-1] = 0
            break
                
    return answer