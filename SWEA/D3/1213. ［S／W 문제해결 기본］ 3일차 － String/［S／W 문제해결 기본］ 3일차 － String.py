#D3. String

T = 10

for t in range(10):
    time = int(input())

    find = input()

    string = input()

    ans = len(string.split(find)) - 1

    print(f'#{time} {ans}')