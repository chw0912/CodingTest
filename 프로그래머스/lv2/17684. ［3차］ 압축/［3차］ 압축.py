def solution(msg):
    alpha = [0,'A','B','C','D','E','F',
              'G','H','I','J','K','L','M',
              'N','O','P','Q','R','S','T',
              'U','V','W','X','Y','Z']
    answer = []

    s = msg[0]
    i = 0
    while i < len(msg):
        if s in alpha:
            if i != len(msg)-1:
                i += 1
            else:
                answer.append(alpha.index(s))
                break
            s += msg[i]
            
        else:
            alpha.append(s)
            answer.append(alpha.index(s[:-1]))
            s = msg[i]
    
    return answer