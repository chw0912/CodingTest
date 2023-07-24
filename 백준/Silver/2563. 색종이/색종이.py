# Silver 5. 색종이

N = int(input())

arr = [[0 for _ in range(100)] for _ in range(100)]

for n in range(N):
    x,y = map(int,input().split())
    end_x = x + 10
    if end_x > 100:
        end_x = 100
    end_y = y + 10
    if end_y > 100:
        end_y = 100

    for i in range(x, end_x):
        for j in range(y, end_y):
            arr[i][j] = 1
cnt = 0
for a in range(100):
    cnt += arr[a].count(1)
print(cnt)