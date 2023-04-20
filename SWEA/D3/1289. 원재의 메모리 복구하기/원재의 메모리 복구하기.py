T = int(input())

for t in range(1, T+1):

    arr = input()

    cnt = 0
    if arr[0] == "1":
        cnt += 1
    for i in range(1,len(arr)):
        if arr[i] != arr[i-1]:
            cnt += 1

    print(f'#{t} {cnt}')
