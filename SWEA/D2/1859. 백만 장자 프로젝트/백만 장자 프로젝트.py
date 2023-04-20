# 테스트 케이스 수
T = int(input())

for t in range(1, T+1):
    # 일 수
    N = int(input())
    # 일별 매매가
    price = list(map(int, input().split()))

    temp = 0 # 갱신 값
    maximum = 0 # 최대 이익값
    for p in range(len(price)-1,-1,-1):
        if temp < price[p]:
            temp = price[p]
        else:
            maximum += temp - price[p]

    print(f'#{t} {maximum}')