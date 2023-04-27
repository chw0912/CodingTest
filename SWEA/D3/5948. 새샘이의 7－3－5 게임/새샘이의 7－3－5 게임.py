from itertools import combinations

T = int(input())

for t in range(1, T+1):
    num_arr = list(map(int, input().split()))

    arr = []

    for i in combinations(num_arr, 3):
        arr.append(list(i))

    for a in range(len(arr)):
        arr[a] = sum(arr[a])
    ans = sorted(list(set(arr)))
    print(f'#{t} {ans[-5]}')
