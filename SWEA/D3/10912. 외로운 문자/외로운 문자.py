T = int(input())

for t in range(1,T+1):
    text = sorted(list(input()))
    result = ''
    i = 0
    while True:
        if text.count(text[i]) >= 2:
            text.remove(text[i])
            text.remove(text[i])
        else:
            result += text[i]
            i += 1
        if len(text) <= i:
            break

    if len(result) == 0:
        print(f"#{t} Good")
    else:
        print(f"#{t} {result}")