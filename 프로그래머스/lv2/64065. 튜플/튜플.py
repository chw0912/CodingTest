from collections import Counter
def solution(s):
    answer = []
    s=list(s)
    num = ''
    for i in range(1,len(s)-1):  
        if s[i].isdigit() == True:
            num += s[i]
        elif s[i-1].isdigit() == True and s[i] == ',' or s[i] == '}' :
            answer.append(int(num))
            num = ''
    answer = Counter(answer)
    
    return sorted(answer, key=lambda i : answer[i],reverse=True)