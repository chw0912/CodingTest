def solution(n, submit):
    allCase = insertAllCase()

    while len(allCase) > 1:
        num = allCase[0]
        result = submit(num)
        
        parts = result.split()
        strike = int(parts[0][0])
        ball = int(parts[1][0])
        
        allCase = filterList(allCase, num, strike, ball)
    
    return allCase[0]

def insertAllCase():
    lst = list()
    for a in range(1, 10):
        for b in range(1,10):
            if a == b:
                continue
            for c in range(1, 10):
                if a == c or b == c:
                    continue
                for d in range(1, 10):
                    if d == a or d == b or d == c:
                        continue
                    lst.append(1000*a + 100*b + 10*c + d)
    return lst

def filterList(lst, num, strike, ball):
    newList = list()
    strNum = str(num)
    numSet = set()
    numSet.add(strNum[0])
    numSet.add(strNum[1])
    numSet.add(strNum[2])
    numSet.add(strNum[3])
    
    for ele in lst:
        strEle = str(ele)
        strikeCnt = 0
        ballCnt = 0
        
        for i in range(4):
            if strNum[i] == strEle[i]:
                strikeCnt += 1
            elif strEle[i] in numSet:
                ballCnt += 1
            
        if strikeCnt == strike and ballCnt == ball:
            newList.append(ele)
    return newList