# Silver 3 2108. 통계학
import sys
from collections import Counter

N = int(input())

arr = sorted([int(sys.stdin.readline()) for _ in range(N)])

# 산술평균
print(round(sum(arr)/N))
# 중앙값
print(arr[len(arr)//2])
# 최빈값
Counter = Counter(arr)
mx = max(Counter.values())
mx_dic = []

for i in Counter:
    if mx == Counter[i]:
        mx_dic.append(i)

if len(mx_dic)>1:
    print(mx_dic[1])
else:
    print(mx_dic[0])

# 범위
print(max(arr)-min(arr))