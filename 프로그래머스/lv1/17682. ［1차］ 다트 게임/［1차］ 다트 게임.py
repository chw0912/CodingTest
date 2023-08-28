def solution(dartResult):
    answer = 0
    num_1 = 0
    num_2 = 0
    
    d = ''
    
    for i in range(len(dartResult)):
        if dartResult[i].isdigit() == True:
            d += dartResult[i]
        elif dartResult[i].isalpha() == True:
            num_2 = num_1
            if dartResult[i] == 'S':
                num_1 = int(d) ** 1
            elif dartResult[i] == 'D':
                num_1 = int(d) ** 2
            elif dartResult[i] == 'T':
                num_1 = int(d) ** 3
            answer += num_1
            d = ''
        else:
            if dartResult[i] == '*':
                answer += (num_1 + num_2)
                num_1 *= 2
            elif dartResult[i] == '#':
                answer += (-2) * num_1
                num_1 = num_1*(-1)

    return answer