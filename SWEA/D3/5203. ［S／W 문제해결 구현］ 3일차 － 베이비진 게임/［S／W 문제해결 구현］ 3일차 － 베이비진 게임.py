# D3. 베이비진 게임

T = int(input())

for t in range(1, T+1):

    player1 = []
    player1_card = [0 for i in range(10)]
    player2 = []
    player2_card = [0 for i in range(10)]

    cards = list(map(int, input().split()))

    for i in range(len(cards)):
        if i % 2 == 0:
            player1.append(cards[i])
        else:
            player2.append(cards[i])

    player1_win = False
    player2_win = False

    for i in range(6):
        player1_card[player1[i]] += 1
        player2_card[player2[i]] += 1

        if i < 2:
            continue

        # run
        for i in range(8):
            if player1_card[i] > 0 and player1_card[i+1] > 0 and player1_card[i+2] > 0:
                player1_win = True
            if player2_card[i] > 0 and player2_card[i+1] > 0 and player2_card[i+2] > 0:
                player2_win = True

        # triplet
        for card in player1_card:
            if card == 3:
                player1_win = True

        for card in player2_card:
            if card == 3:
                player2_win = True


        if player1_win and player2_win:
            print(f'#{t} 1')
            break

        if player1_win and not player2_win:
            print(f'#{t} 1')
            break
        if player2_win and not player1_win:
            print(f'#{t} 2')
            break
    else:
        print(f'#{t} 0')