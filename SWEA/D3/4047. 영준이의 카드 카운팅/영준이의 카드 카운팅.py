T = int(input())

for t in range(1, T+1):
    cards = input()
    my_cards = {
        'S': [],
        'D': [],
        'H': [],
        'C': []
    }

    for i in range(0, len(cards), 3):
        c = cards[i]
        n = cards[i+1:i+3]

        if n not in my_cards[c]:
            my_cards[c].append(n)
        else:
            print(f'#{t} ERROR', end='')
            break
    else:
        print(f'#{t}', end=' ')
        for key, value in my_cards.items():
            print(13-len(value), end=' ')
    print()