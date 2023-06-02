def solution(picks, minerals):
    answer = 0
    arr = []
    mineral=[0,0,0]
    for i in range(len(minerals)):
        if i % 5 == 0 and i != 0:
            arr.append(mineral)
            mineral=[0,0,0]
        if minerals[i] == 'diamond':
            mineral[0] += 1
        elif minerals[i] == 'iron':
            mineral[1] += 1
        else:
            mineral[2] += 1
    if mineral != [0,0,0]:
        arr.append(mineral)
    
    arr = arr[:sum(picks)] 
    
    arr = sorted(arr, reverse=True)
    
    for i in range(len(arr)):
        if picks[0] != 0:
            picks[0] -= 1
            answer += sum(arr[0])*1
            arr.remove(arr[0])
        elif picks[1] != 0:
            picks[1] -= 1
            answer += arr[0][0]*5 + arr[0][1]*1 + arr[0][2]*1
            arr.remove(arr[0])
        elif picks[2] != 0:
            picks[2] -= 1
            answer += arr[0][0]*25 + arr[0][1]*5 + arr[0][2]*1
            arr.remove(arr[0])
    
    return answer