# Silver 2. 랜선 자르기
import sys
N, K = map(int, sys.stdin.readline().split())
lans = [int(sys.stdin.readline()) for _ in range(N)]
start, end = 1, max(lans)

while start <= end:
    mid = (start + end) // 2
    lines = 0
    for lan in lans:
        lines += lan // mid

    if lines >= K:
        start = mid + 1
    else:
        end = mid - 1
print(end)