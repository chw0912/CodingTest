# Silver 5 7568. 덩치

N = int(input())

inbody = [list(map(int,input().split())) for _ in range(N)]

ans = []

for i in range(N):
    rank = 1
    for j in range(N):
        if inbody[i][0] < inbody[j][0] and inbody[i][1] < inbody[j][1]:
            rank += 1
    print(rank,end=' ')