# Silver 3. N과 M (1)
from itertools import permutations
import sys

input = sys.stdin.readline

N, M = map(int, input().split())

numbers = [i for i in range(1, N + 1)]

perms = list(permutations(numbers, M))

for perm in perms:
    print(*perm)