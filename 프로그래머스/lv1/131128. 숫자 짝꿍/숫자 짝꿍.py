def solution(X, Y):
    answer = ''
    X = sorted(X, reverse=True)
    Y = sorted(Y, reverse=True)
    i = 0
    j = 0

    while i < len(X) and j < len(Y):
        if X[i] == Y[j]:
            answer += str(X[i])
            i += 1
            j += 1
        elif X[i] > Y[j]:
            i += 1
        else:
            j += 1

    if not answer:
        answer = "-1"
    if answer[0] == "0":
        answer = "0"
    
    return answer