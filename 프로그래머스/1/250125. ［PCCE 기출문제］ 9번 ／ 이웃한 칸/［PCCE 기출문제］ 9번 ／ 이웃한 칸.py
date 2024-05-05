from collections import  deque

dx = [0, 1, -1, 0]
dy = [1, 0, 0, -1]

def bfs(board,x,y):
    n = len(board)
    target = board[x][y]
    count = 0
    
        
    for i in range(4):
        nx = x + dx[i]
        ny = y + dy[i]

        if 0 <= nx < n and 0 <= ny < n:
            if board[nx][ny] == target:
                count += 1
    return count
    

def solution(board, h, w):
    
    return bfs(board,h,w)