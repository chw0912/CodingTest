T = int(input())

for t in range(1, T+1):
    # TC 문자열을 리스트로 저장
    word = list(input())
    # '.' 을 5 x (len(word)*4+1) 리스트에 저장
    arr = []
    for _ in range(5):
        row = []
        for _ in range(len(word)*4+1):
            row.append('.')
        arr.append(row)
    
    # 조건 충족 시 '#' 또는 word를 해당 리스트에 저장 
    for i in range(len(arr)):
        for j in range(len(arr[0])):
            if i % 2 == 1 and j % 2 == 1:
                arr[i][j] = '#'
            if i % 4 == 0 and j % 4 == 2:
                arr[i][j] = '#'
            if i == 2:
                if j % 4 == 0:
                    arr[i][j] = '#'
                elif j % 4 == 2:
                    arr[i][j] = word[j // 4]

    for n in range(len(arr)):
        print(''.join(arr[n]))
