lang = ['ZRO', 'ONE', 'TWO', 'THR', 'FOR',
        'FIV', 'SIX', 'SVN', 'EGT', 'NIN']

T = int(input())

for t in range(1, T+1):
    A, N = input().split()
    arr = list(input().split())

    for i in range(int(N)):
        arr[i] = lang.index(arr[i])
    arr = sorted(arr)

    for i in range(int(N)):
        arr[i] = lang[arr[i]]

    print(f'#{t}')
    print(*arr)