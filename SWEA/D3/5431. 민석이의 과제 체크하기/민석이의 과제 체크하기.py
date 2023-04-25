T = int(input())

for t in range(1, T+1):
    N, K = map(int, input().split())
    arr = list(map(int, input().split()))

    student = [n for n in range(1, N+1)]

    for i in range(len(arr)):
        student.remove(arr[i])

    print(f'#{t}', *student)

