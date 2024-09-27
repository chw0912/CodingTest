# Silver 3. N과 M (4)
from itertools import combinations_with_replacement
import sys
input = sys.stdin.readline

N, M = map(int, input().split())
numbers = [i for i in range(1, N + 1)]



for cwr in combinations_with_replacement(numbers, M):
    for num in cwr:
        print(num, end=" ")
    print()