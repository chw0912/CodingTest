def solution(numbers):
    answer = -1
    nums = [0,1,2,3,4,5,6,7,8,9]
    for i in range(len(numbers)):
        if numbers[i] in nums:
            nums.remove(numbers[i])
    
    return sum(nums)