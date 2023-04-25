T = 10

for t in range(1, T+1):
    N, arr = input().split()

    a = list(arr)

    i = 0
    while i <= len(a)-2:
        if a[i] != a[i+1]:
            i += 1
        else:
            del a[i:i + 2]
            i = 0
    print(f"#{t} {''.join(a)}")