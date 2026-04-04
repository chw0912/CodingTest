def solution(mats, park):
    answer = -1
    
    mats = sorted(mats, reverse=True)

    # 돗자리
    for m in mats:
        # 공원
        for i in range(len(park)-m+1):
            for j in range(len(park[0])-m+1):
                if park[i][j] == "-1":
                    if check(park, m, i, j):
                        return m         
    
    return answer

def check(park, mat_size, x, y):
    is_possible = True
    
    for i in range(mat_size):
        nx = x + i
        for j in range(mat_size):
            ny = y + j
            
            if park[nx][ny] != "-1":
                is_possible = False
                
    return is_possible