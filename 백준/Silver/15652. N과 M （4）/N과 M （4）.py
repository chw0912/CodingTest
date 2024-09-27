# Silver 3. N과 M (4)
from itertools import combinations_with_replacement
import sys
input = sys.stdin.readline
print = sys.stdout.write

N, M = map(int, input().split())
numbers = range(1, N + 1)

for cwr in combinations_with_replacement(numbers, M):
    print(' '.join(map(str, cwr)) + '\n')