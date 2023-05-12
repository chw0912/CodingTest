T = int(input())

for t in range(1, T+1):
    N = int(input())

    odd_rooms = [i for i in range(1,400,2)]
    even_rooms = [i for i in range(2,401,2)]
    empty_rooms = [0 for i in range(401)]
    start = 0
    end = 0


    for i in range(N):
        current, target = map(int, input().split())

        if current < target:
            if current % 2 == 0:
                start = even_rooms.index(current)
            else:
                start = odd_rooms.index(current)
            if target % 2 == 0:
                end = even_rooms.index(target)
            else:
                end = odd_rooms.index(target)
        elif current > target:
            if target % 2 == 0:
                start = even_rooms.index(target)
            else:
                start = odd_rooms.index(target)
            if current % 2 == 0:
                end = even_rooms.index(current)
            else:
                end = odd_rooms.index(current)
        else:
            break

        for j in range(start, end+1):
            empty_rooms[j] += 1

    print(f'#{t} {max(empty_rooms)}')
