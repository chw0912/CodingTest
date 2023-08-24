from collections import deque

def solution(bridge_length, weight, truck_weights):
    bridge = [0 for _ in range(bridge_length)] 
    bridge_sum = sum(bridge)

    truck_weights = deque(truck_weights)
    bridge = deque(bridge)

    answer = 0

    while truck_weights:
        bridge_sum -= bridge[-1] 
        bridge_sum += bridge[0] 
        if truck_weights[0] + bridge_sum <= weight:
            bridge.insert(0, truck_weights[0]) 
            truck_weights.popleft()
            bridge.pop() 
            answer += 1
        else:
            bridge.insert(0, 0) 
            bridge.pop() 
            answer += 1 

    return answer + bridge_length  