T = int(input())

for t in range(1, T+1):
    word = list(input())

    arr = []
    for _ in range(5):
        row = []
        for _ in range(len(word)*4+1):
            row.append('.')
        arr.append(row)

    for i in range(len(arr)):
        for j in range(len(arr[0])):
            if i % 2 == 1 and j % 2 == 1:
                arr[i][j] = '#'
            if i % 4 == 0 and j % 4 == 2:
                arr[i][j] = '#'
            if i == 2 and j % 4 == 0:
                arr[i][j] = '#'
            elif i == 2 and j % 4 == 2:
                arr[i][j] = word[j // 4]

    for n in range(len(arr)):
        print(''.join(arr[n]))
    