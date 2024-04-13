# Silver 5. 단어 정렬
import sys

N = int(sys.stdin.readline())

lst = list(sys.stdin.readline().strip() for _ in range(N))

set_lst = list(set(lst))

set_lst.sort()
set_lst.sort(key=len)

for i in set_lst:
    print(i)
