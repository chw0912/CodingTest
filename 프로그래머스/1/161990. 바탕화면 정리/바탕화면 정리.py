def solution(wallpaper):
    answer = []
    lux = []
    luy = []
    rdx = []
    rdy = []
    
    # 점 S 좌표, E 좌표
    for i in range(len(wallpaper)):
        for j in range(len(wallpaper[0])):
            if wallpaper[i][j] == '#':
                lux.append(i)
                luy.append(j)
                rdx.append(i+1)
                rdy.append(j+1)
    
    return [min(lux),min(luy),max(rdx),max(rdy)]