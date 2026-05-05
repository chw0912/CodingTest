# D3. 이진 탐색

T = int(input())

def binary_search(val):
    global ans

    left, right = 0, len(A) - 1
    direction = 0

    while left <= right:
        mid = (left + right) // 2

        if A[mid] == val:
            ans += 1
            return
        elif A[mid] > val:
            if direction == -1:
                return
            right = mid - 1
            direction = -1
        else:
            if direction == 1:
                return
            left = mid + 1
            direction = 1


for t in range(1, T + 1):

    N, M = map(int, input().split())

    A = sorted(list(map(int, input().split())))
    B = list(map(int, input().split()))

    ans = 0

    for b in B:
        binary_search(b)

    print(f'#{t} {ans}')

