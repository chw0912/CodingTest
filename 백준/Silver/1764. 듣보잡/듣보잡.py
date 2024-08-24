# Silver 4. 듣보잡
import sys

input = sys.stdin.readline

N, M = map(int, input().split())

unheardOf = set(input().rstrip() for _ in range(N))

result = list()

for i in range(M):
    str = input().rstrip()
    if str in unheardOf:
        result.append(str)
result.sort()
print(len(result))
for res in result:
    print(res)