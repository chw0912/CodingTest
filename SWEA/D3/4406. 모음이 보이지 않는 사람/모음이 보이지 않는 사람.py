T = int(input())

for t in range(1, T+1):
    text = list(input())

    vowel = ['a', 'e', 'i', 'o', 'u']

    for i in range(len(text)):
        for v in vowel:
            if v in text:
                text.remove(v)
    print(f"#{t} {''.join(text)}")