def solution(record):
    dic = {}
    answer = []
    
    record = [record[i].split(' ') for i in range(len(record))]
    
    
    for i in range(len(record)):
        if record[i][0] == 'Enter' or record[i][0] =='Change':
            dic[record[i][1]]=record[i][2]
            
    for i in range(len(record)):
        if record[i][0] =='Enter':
            answer.append(f'{dic[record[i][1]]}님이 들어왔습니다.')
        elif record[i][0] == 'Leave':
            answer.append(f'{dic[record[i][1]]}님이 나갔습니다.')
        
    
    return answer