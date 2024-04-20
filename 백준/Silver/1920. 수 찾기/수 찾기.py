#Silver 4. 수 찾기
import sys


N = int(sys.stdin.readline())

A = set(map(int, sys.stdin.readline().split()))

M = int(sys.stdin.readline())

X = list(map(int, sys.stdin.readline().split()))

# X의 각 원소별 탐색
for num in X:
    # num이 A안에 있으면 1, 없으면 0 출력
    if num in A:
        print(1)
    else:
        print(0)