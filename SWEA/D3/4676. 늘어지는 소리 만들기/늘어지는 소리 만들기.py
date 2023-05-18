T = int(input())

for t in range(1, T+1):
    L = list(input())
    H = int(input())
    index_h = sorted(list(map(int, input().split())))
    h = [''] * 100


    for i in range(H):
        j = index_h[i]
        h[j] += '-'

    for i in range(len(L)):
        h[i] += L[i]
    print(f"#{t} {''.join(h)}")