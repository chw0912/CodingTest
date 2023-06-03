def solution(n, a, b):
    answer = 0
    if a > b:
        a, b = b, a

    while n > 1:
        n = (n + 1) // 2
        answer += 1

        if a % 2 == 1 and b == a + 1:
            break

        a = (a + 1) // 2
        b = (b + 1) // 2

    return answer