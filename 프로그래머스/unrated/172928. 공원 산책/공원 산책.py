def solution(park, routes):
    answer = []
    r,c = 0,0
    start = []
    
    #Start 위치 찾기
    for i,row in enumerate(park):
        if 'S' in row:
            start = [i,row.find('S')]
            break
    
    
    #이동 할 좌표 값 구하기
    for route in routes:
        dir, move = route.split(" ")
        move = int(move)
        
        if dir == 'E':
            loc = start[1] + move
            if loc >= len(park[0]):
                continue
            if 'X' in park[start[0]][start[1] + 1:loc + 1]:
                continue
            else:
                start[1] = loc
        
        if dir == 'W':
            loc = start[1] - move
            if loc < 0:
                continue
            if 'X' in park[start[0]][loc:start[1]]:
                continue
            else:
                start[1] = loc
                
        if dir == 'S':
            loc = start[0] + move
            
            if loc >= len(park):
                continue
            if 'X' in [park[i][start[1]] for i in range(start[0] + 1,loc + 1)]:
                continue
            else:
                start[0] = loc
                
        if dir == 'N':
            loc = start[0] - move
            
            if loc < 0:
                continue
            if 'X' in [park[i][start[1]] for i in range(loc,start[0])]:
                continue
            else:
                start[0] = loc
            
    
    return start