# Bronze 4 - 2845. 파티가 끝나고 난 뒤

L, P = map(int, input().split())
party = list(map(int,input().split()))

for i in range(len(party)):
    print(party[i] - (L*P), end=' ')