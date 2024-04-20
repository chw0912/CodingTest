#Silver 4. 수 찾기
import sys


N = int(sys.stdin.readline())

A = sorted(list(map(int, sys.stdin.readline().split())))

M = int(sys.stdin.readline())

X = list(map(int, sys.stdin.readline().split()))

for num in X:
    if num in A:
        print(1)
    else:
        print(0)