#Silver 3. 수강신청

import sys

input = sys.stdin.readline

K, L = map(int, input().split())

dict = {}
for i in range(L):
    dict[input().rstrip()] = i

result = sorted(dict.items(), key=lambda x: x[1])

if K > len(result):
    K = len(result)

for i in range(K):
    print(result[i][0])