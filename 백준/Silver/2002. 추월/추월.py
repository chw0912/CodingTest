# Silver 2. 추월

N = int(input())

Entry = {input().rstrip() : i for i in range(N)}
Exit = list(int(Entry[input().rstrip()]) for _ in range(N))

cnt = 0
for i in range(N):
    for j in range(i, N):
        if Exit[i] > Exit[j]:
            cnt += 1
            break
print(cnt)