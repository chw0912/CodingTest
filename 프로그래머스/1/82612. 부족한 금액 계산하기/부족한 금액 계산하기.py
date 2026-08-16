def solution(price, money, count):
        x=0
        for i in range(1,count+1):
            x += (i*price)
            
        if x>money:
            return x-money
        else:
            return 0
