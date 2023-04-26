T = int(input())

arr = [0 for _ in range(301)]
arr[0] = 1
for i in range(1, len(arr)):
    arr[i] = arr[i-1] + i + 1

for t in range(1,T+1):
    p, q = map(int, input().split())

    x, y, w, z = 0, 0, 0, 0

    for n in range(len(arr)):
        if arr[n] >= p:
            x = n - (arr[n] - p)
            y = abs(arr[n]-p)
            break

    for n in range(len(arr)):
        if arr[n] >= q:
            w = n - (arr[n] - q)
            z = abs(arr[n] - q)
            break

    s, d = x+w+2, y+z+2
    a = arr[s-1] + s * (d-1) + sum([i for i in range(d-1)])
    
    print(f'#{t} {a}')

