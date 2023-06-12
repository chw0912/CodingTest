DIRS = ((-1, 0), (1, 0), (0, -1), (0, 1))


def solution(maps):
    MAX_R, MAX_C = len(maps), len(maps[0])

    def dfs(start_r, start_c, start_count):
        nonlocal visited

        stack = [(start_r, start_c)]
        visited[start_r][start_c] = True
        counts = start_count
        while stack:
            curr_r, curr_c = stack.pop()
            for dir_r, dir_c in DIRS:
                post_r, post_c = curr_r + dir_r, curr_c + dir_c
                if 0 <= post_r < MAX_R and 0 <= post_c < MAX_C and maps[post_r][post_c] != 'X' and not visited[post_r][post_c]:
                    visited[post_r][post_c] = True
                    counts += int(maps[post_r][post_c])
                    stack.append((post_r, post_c))

        return counts

    islands = []
    visited = [[False] * MAX_C for _ in range(MAX_R)]
    for r in range(MAX_R):
        for c in range(MAX_C):
            if maps[r][c] != 'X' and not visited[r][c]:
                islands.append(dfs(r, c, int(maps[r][c])))

    return sorted(islands) if islands else [-1]

# from collections import deque
# dx = [-1, 1, 0, 0]
# dy = [0, 0, -1, 1]  

# def search(maps,x,y,height,width):
#     answer = []
#     dq = deque()
#     dq.append((x, y))
#     num=0
#     while dq:
#         x, y = dq.popleft()

#         for i in range(4):
#             nx = x + dx[i]
#             ny = y + dy[i]

#             if 0 <= nx < height and 0 <= ny < width:
#                 if maps[nx][ny] != 'X' or maps[nx][ny] != '0':
#                     num += int(maps[x][y])
#                     maps[x][y] = '0'
#                     dq.append((nx, ny))

#     answer.append(num)
#     return 
        
# def solution(maps):
#     answer = []
#     maps = [list(maps[i]) for i in range(len(maps))]
    
#     for x in range(len(maps)):
#         for y in range(len(maps[0])):
#             if maps[x][y] != 'X' or maps[x][y] != '0':
#                 answer.append(search(maps,x,y,len(maps),len(maps[0])))
            
#     return maps