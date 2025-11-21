for t in range(1, 11):
    # 건물의 개수
    N = int(input())
    # 건물 높이 리스트
    buildings = list(map(int, input().split()))

    # 결과값
    result = 0

    for i in range(2, N-2):
        building = buildings[i]
        temp = 0
        for j in range(i-2,i+3):
            if i != j:
                temp = max(temp, buildings[j])

        view = building - temp

        if view >= 0:
            result += view


    print(f"#{t} {result}")