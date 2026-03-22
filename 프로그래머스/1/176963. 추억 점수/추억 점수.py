def solution(name, yearning, photo):
    answer = []
    
    # 이름 : 그리움 점수
    dic = {}
    
    for i in range(len(name)):
        dic[name[i]] = yearning[i]
    
    for arr in photo:
        temp = 0
        for i in arr:
            if i in dic.keys():
                temp += int(dic.get(i))
        answer.append(temp)
            
            
    
    return answer