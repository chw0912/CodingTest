# Silver 3. 1,2,3 더하기

import sys

input = sys.stdin.readline

T = int(input())

lst = [0] * (12)

for i in range(1, 11):
    if i == 1:
        lst[i] = 1
    elif i == 2:
        lst[i] = 2
    elif i == 3:
        lst[i] = 4
    else:
        lst[i] = lst[i - 1] + lst[i - 2] + lst[i - 3]


for _ in range(T):
    n = int(input())
    print(lst[n])
    