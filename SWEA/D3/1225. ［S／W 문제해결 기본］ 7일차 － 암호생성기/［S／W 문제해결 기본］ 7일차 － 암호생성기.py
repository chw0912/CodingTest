# 암호 생성기
T = 10

for t in range(1, T+1):
    N = int(input())

    numbers = list(map(int, input().split()))

    idx = 0

    minus = 1

    while True:
        numbers[idx] -= minus

        if numbers[idx] <= 0:
            numbers[idx] = 0
            break

        idx = (idx + 1) % 8
        minus = (minus % 5) + 1

    if idx != 7:
        result = numbers[idx+1:] + numbers[:idx+1]
        print(f"#{t}", end = ' ')
        for i in range(8):
            print(f"{result[i]}", end= ' ')
        print()
    else:
        print(f"#{t} {numbers}")