# Silver 5. 수 정렬하기 2

N = int(input())

lst = []

for _ in range(N):
    num = int(input())
    lst.append(num)

lst = sorted(set(lst))
for i in range(N):
    print(lst[i])