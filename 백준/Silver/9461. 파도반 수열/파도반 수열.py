# Silver 3. 파도반 수열
import sys

input = sys.stdin.readline

T = int(input())

for _ in range(T):
    N = int(input())
    p = [0] * (N+1)

    for i in range(1, N+1):
        if i <= 3:
            p[i] = 1
        else:
            p[i] = p[i-2] + p[i-3]
    print(p[N])