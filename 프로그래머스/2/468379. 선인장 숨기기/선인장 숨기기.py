from collections import deque

def solution(m, n, h, w, drops):
    total = m * n
    INF = len(drops)+1
    
    rain = [INF] * total
    
    # 2차원 배열을 1차원으로 압축
    for i in range(len(drops)):
        r, c = drops[i]
        rain[r * n + c] = i + 1
        
    new_n = n - w + 1
    row_min = [0] * (m * new_n)
    
    # 가로 슬라이딩 윈도우
    for r in range(m):
        dq = deque()
        
        for c in range(n):
            while dq and rain[r * n + dq[-1]] >= rain[r*n + c]:
                dq.pop()
                
            dq.append(c)
            if dq[0] <= c - w:
                dq.popleft()
                
            if c >= w - 1:
                row_min[r * new_n + (c - w + 1)] = rain[r * n + dq[0]]
                

    
    best_time = -1
    best_r = 0
    best_c = 0
    
    # 세로 슬라이딩 윈도우
    for c in range(new_n):
        dq = deque()
        
        for r in range(m):
            val = row_min[r * new_n + c]
            
            while dq and row_min[dq[-1] * new_n + c] >= val:
                dq.pop()
                
            dq.append(r)
            
            if dq[0] <= r - h:
                dq.popleft()
            
            if r >= h - 1:
                cur = row_min[dq[0] * new_n + c]
                sr = r - h + 1
                
                if (cur > best_time or
                   (cur == best_time and (sr < best_r or (sr == best_r and c < best_c)))):
                    
                    best_time = cur
                    best_r = sr
                    best_c = c

                
    return [best_r, best_c]