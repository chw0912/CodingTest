# D3 - 27005. 산불수열

T = int(input())

A = [1, 1]

for i in range(2, 1001):

    forbidden = [2 * A[i - k] - A[i - (2*k)] for k in range(1, i // 2 + 1)]

    c = 1
    while c in forbidden:
        c += 1
    A.append(c)

for t in range(T):
    idx = int(input())

    print(A[idx])
