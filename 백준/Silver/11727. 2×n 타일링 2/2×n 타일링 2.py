# Silver 3. 2xn 타일링 2
import sys

input = sys.stdin.readline

n = int(input())

tiles = [0] * (n+1)

for i in range(1, n+1):
    if i == 1:
        tiles[i] = 1
    elif i == 2:
        tiles[i] = 3
    else:
        tiles[i] = tiles[i-1] + tiles[i-2]*2
print(tiles[n] % 10007)