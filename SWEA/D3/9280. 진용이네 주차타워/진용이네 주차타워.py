from collections import  deque

T = int(input())

for t in range(1, T+1):
    N, M = map(int, input().split())
    R = [int(input()) for _ in range(N)]
    W = [0] + [int(input()) for _ in range(M)]
    car = [int(input()) for _ in range(2*M)]
    parking = [0] * N
    cost = 0

    wait_car = []
    while car:

        if wait_car:
            for i in range(N):
                if parking[i] == 0:
                    parking[i] = wait_car.pop(0)

        car_num = car.pop(0)
        if car_num > 0:
            for i in range(N):
                if parking[i] == 0:
                    parking[i] = car_num
                    break
            else:
                wait_car.append(car_num)
        else:
            car_num = abs(car_num)

            park_num = 0
            for i in range(N):
                if parking[i] == car_num:
                    park_num = i
                    parking[i] = 0
                    cost += (W[car_num] * R[park_num])
                    break

    print(f'#{t} {cost}')
