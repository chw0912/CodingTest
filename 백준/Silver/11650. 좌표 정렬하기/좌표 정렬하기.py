# Silver 5. 좌표 정렬하기

N = int(input())

lst = []

for _ in range(N):
    x, y = map(int, input().split())
    lst.append([x,y])

lst = sorted(lst)
for i in range(N):
    print(f"{lst[i][0]} {lst[i][1]}")