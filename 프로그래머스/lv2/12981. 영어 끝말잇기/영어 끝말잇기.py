def solution(n, words):
    answer = []
    L = [words[0]]
    flag = False
    for i in range(len(words)-1):
        if words[i][-1] == words[i+1][0]:
            if words[i+1] not in L:
                L.append(words[i+1])
            else:
                return [(i+1)%n+1,(i+1)//n+1]
        else:
            return [(i+1)%n+1,(i+1)//n+1]
                
    return [0,0]