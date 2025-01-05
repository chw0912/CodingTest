# Silver 2. 추월
import sys

input = sys.stdin.readline

N = int(input().rstrip("\n"))

Entry = {input().rstrip("\n") : i for i in range(N)}
Exit = list(int(Entry[input().rstrip("\n")]) for _ in range(N))

cnt = 0
for i in range(N):
    for j in range(i, N):
        if Exit[i] > Exit[j]:
            cnt += 1
            break
print(cnt)