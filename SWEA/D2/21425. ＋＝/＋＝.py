# D2 - 21425. +=

T = int(input())

str = ""

for t in range(T):
    A, B, N = map(int, input().split())
    cnt = 0

    while A <= N and B <= N:
        if A <= B:
            A += B
            cnt += 1
        else:
            B += A
            cnt += 1

    str += f"{cnt}\n"

print(str)