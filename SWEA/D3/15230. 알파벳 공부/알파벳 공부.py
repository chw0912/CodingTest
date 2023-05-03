T = int(input())

for t in range(1, T+1):
    eng = 'abcdefghijklmnopqrstuvwxyz'

    arr = list(input())
    cnt = 0
    idx = 0

    if 'a' in arr:
        for i in range(0,len(arr)):
            if arr[i] == eng[cnt]:
                cnt += 1
            else:
                break
        print(f'#{t} {cnt}')
    else:
        print(f'#{t} 0')
