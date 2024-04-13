# Silver 5. 단어 정렬

N = int(input())

lst = list(input() for _ in range(N))

set_lst = list(set(lst))

set_lst.sort()
set_lst.sort(key=len)

for i in set_lst:
    print(i)
