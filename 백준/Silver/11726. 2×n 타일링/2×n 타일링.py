# Silver 3. 2xn 타일링
import sys

input = sys.stdin.readline

tile = [0] * 1001

for i in range(1, 1001):
    if i == 1:
        tile[i] = 1
    elif i == 2:
        tile[i] = 2
    else:
        tile[i] = tile[i - 1] + tile[i - 2]

n = int(input())
print(tile[n]%10007)