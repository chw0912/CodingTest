from collections import deque

def solution(x, y, n):
    visited = set()
    visited.add(x)
    
    dq = deque()
    dq.append((x, 0))
    
    while dq:
        cur_val, depth = dq.popleft()
        
        if cur_val == y:
            return depth
        for next_val in (cur_val + n, cur_val * 2, cur_val * 3):
            if next_val <= y and next_val not in visited:
                visited.add(next_val)
                dq.append((next_val, depth+1))
    
    return -1

