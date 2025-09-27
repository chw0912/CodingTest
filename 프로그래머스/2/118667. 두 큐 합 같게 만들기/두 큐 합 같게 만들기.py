from collections import deque

def solution(queue1, queue2):
    answer = 0
    
    q1 = deque(queue1)
    q2 = deque(queue2)
    
    q1Sum = sum(queue1)
    q2Sum = sum(queue2)
    
    qSum = q1Sum + q2Sum // 2 # 모든 큐의 합의 절반
    
    
    while(True):
        
        # 두 큐의 합이 같을 경우
        if (compare(q1Sum, q2Sum)):  
            return answer
        
        # 큐의 합이 큰 리스트에서 추출 후 추가
        if (q1Sum < q2Sum):
            tmp = q2.popleft()
            q1Sum += tmp
            q2Sum -= tmp
            q1.append(tmp)  
        elif (q1Sum > q2Sum):
            tmp = q1.popleft()
            q2Sum += tmp
            q1Sum -= tmp
            q2.append(tmp)
            
        
        answer += 1
        
        # 두 큐의 합을 같게 하지 못할 경우
        if (answer > len(queue1) * 4):
            return -1
        
        
    
    return answer

def compare(q1Sum, q2Sum):
    if (q1Sum == q2Sum):
        return True
        
    return False

# 큐의 합이 큰 곳에서
    # pop(0) 후 큐의 합이 작은 곳으로 add
    
# 위 과정을 반복하여 두 큐의 합이 같아질 때 멈추기