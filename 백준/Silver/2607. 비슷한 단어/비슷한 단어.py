# Silver 3 2607. 비슷한 단어

N = int(input())
target = list(input())
ans = 0

for i in range(1,N):
    compare = target[:]
    word = input()
    cnt = 0
    for w in word:
        if w in compare:
            compare.remove(w)
        else:
            cnt += 1

    if cnt < 2 and len(compare) < 2:
        ans += 1

print(ans)