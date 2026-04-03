def solution(wallet, bill):
    answer = 0
    
    wallet.sort()
    
    while bill[0] > wallet[0] or bill[1] > wallet[1]:
        
        # 가로
        width = bill[0]
        # 세로
        length = bill[1]
        
        if width >= length:
            width //= 2
        else:
            length //= 2
        
        bill[0] = width
        bill[1] = length
        
        bill.sort()
            
        answer += 1
    
    return answer