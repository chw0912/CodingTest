def solution(n, t, m, p):
    data = {0:'0', 1:'1', 2:'2', 3:'3', 
            4:'4', 5:'5', 6:'6', 7:'7', 
            8:'8', 9:'9',10:'A',11:'B',
            12:'C', 13:'D',14:'E',15:'F'}
    answer = ''
    
    for i in range(t*m):
        tmp = ''
        k = i
        while True:
            div,mod = divmod(k,n)
            if div < n:
                tmp += data[mod]
                if div != 0:
                    tmp += data[div]
                break
            else:
                tmp += data[mod]
                k = k//n
        
        answer += tmp[::-1]
    ans = ''
    for i in range(p-1,t*m,m):
        ans+=answer[i]
    
    return ans