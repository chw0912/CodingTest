import math
T = int(input())
ans = []
for t in range(1, T+1):
    N = int(input())

    tot = 0 # 라운드 마다의 총점
    for n in range(N):
        x, y = map(int,input().split())
        r = math.ceil(math.sqrt((x*x)+(y*y))/20)

        if r <= 0:
            tot += 10
        elif r <= 11:
            tot += 11 - r
    ans.append(tot)

for x in range(len(ans)):
    print(f"#{x+1} {ans[x]}")