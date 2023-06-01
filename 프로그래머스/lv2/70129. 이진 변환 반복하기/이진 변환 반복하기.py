def solution(s):
    
    cnt = 0 #변환 횟수
    zero_cnt = 0 #0 제거후 총 길이
    
    while len(s) != 1:
        zero = len(s) - s.count('0') # 0 제거후 길이
        zero_cnt += s.count('0')
        char = str(bin(zero))
        s=''
        for i in range(2,len(char)):
            s += char[i]
        cnt+=1
        
    return [cnt,zero_cnt]