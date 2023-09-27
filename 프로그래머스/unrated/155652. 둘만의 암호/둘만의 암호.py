def solution(s, skip, index):
    alpha=list('abcdefghijklmnopqrstuvwxyz')
    answer = ''
    
    for d in skip:
        del alpha[alpha.index(d)]
    
    for x in s:
        i = alpha.index(x)
        for j in range(index):
            if alpha[i] in skip:
                i += 1
            i += 1
            i = i % len(alpha)
        
        answer += alpha[i]
    return answer