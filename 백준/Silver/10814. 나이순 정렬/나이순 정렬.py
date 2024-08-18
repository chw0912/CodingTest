# Silver 5. 나이순 정렬
N = int(input())
judge = []


for i in range(1, N + 1):
    age, name = input().split()
    judge.append((int(age), i, name))
judge.sort(key=lambda x: (x[0],x[1]))

for age,_,name in judge:
    print(age, name)