def solution(numbers, target):
    answer = 0
    
    def dfs(idx, goal):
        nonlocal answer

        if idx == len(numbers):
            if goal == target:
                answer += 1
            return

        dfs(idx+1, goal+numbers[idx])
        dfs(idx+1, goal-numbers[idx])
        
    dfs(0, 0)
    
    return answer

