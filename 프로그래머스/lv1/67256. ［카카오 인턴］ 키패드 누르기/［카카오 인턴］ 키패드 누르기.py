from collections import deque

dx = [-1, 1, 0, 0]
dy = [0, 0, -1, 1]

def solution(numbers, hand):
    answer = ''
    dq = deque(numbers)
    
    keypad = [
              [1, 2, 3],
              [4, 5, 6],
              [7, 8, 9],
              ['*', 0, '#']
             ]
    pad = {1:'L',4:'L',7:'L', 3:'R',6:'R',9:'R'}
    
    left = [3,0]
    right = [3,2]
    mid = []
    cnt=0
    while dq:
        find = dq.popleft()
        if find in pad:
            answer += pad[find]
            for i in range(4):
                for j in range(3):
                    if keypad[i][j] == find:
                        if pad[find] == 'L':
                            left = [i, j]
                        elif pad[find]=='R':
                            right = [i, j]
        else:
            
            for i in range(4):
                for j in range(3):
                    if keypad[i][j] == find:
                        mid = [i,j]
            left_d = 0
            right_d = 0
            
            for a,b,c in zip(left,right,mid):
                left_d += abs(a-c)
                right_d += abs(b-c)
            
            if left_d < right_d:
                answer += 'L'
                left = mid  
            elif left_d > right_d:
                answer += 'R'
                right = mid
            else:
                if hand == 'left':
                    answer += 'L'
                    left = mid
                elif hand == 'right':
                    answer += 'R'
                    right = mid
                
    return answer