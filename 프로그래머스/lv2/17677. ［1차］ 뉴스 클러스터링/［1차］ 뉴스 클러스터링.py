import math
def solution(str1, str2):
    answer = 0
       
    lst_1 = []
    lst_2 = []

    for i in range(len(str1)-1):
        s = str1[i]+str1[i+1]
        s = s.upper()
        if s.isalpha() == True:
            lst_1.append(s)
        
    for i in range(len(str2)-1):
        s = str2[i]+str2[i+1]
        s = s.upper()
        if s.isalpha() == True: 
            lst_2.append(s)
    
    inter = 0
        
    for i in range(len(lst_1)):
        if lst_1[i] in lst_2:
            lst_2.remove(lst_1[i])
            inter += 1
          
    union = len(lst_1) + len(lst_2)
    
    if inter == 0 and union > 0:
        return 0
    elif inter == 0 and union == 0:
        return 65536
    
    answer = (inter/union) * 65536 
    return int(answer)