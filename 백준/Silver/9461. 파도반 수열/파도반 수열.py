# Silver 3. 파도반 수열
import sys

input = sys.stdin.readline

T = int(input())

p = [0] * 101
for i in range(1, 101):
    if i <= 3:
        p[i] = 1
    else:
        p[i] = p[i - 2] + p[i - 3]

for _ in range(T):
    N = int(input())
    print(p[N])