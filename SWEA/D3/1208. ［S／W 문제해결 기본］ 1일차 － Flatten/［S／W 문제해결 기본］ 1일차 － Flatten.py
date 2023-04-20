for t in range(1,11):
    dump = int(input())
    nums = list(map(int, input().split()))



    ans = 0

    for n in range(dump):
        max_i = nums.index(max(nums))
        min_i = nums.index(min(nums))

        nums[max_i] -= 1
        nums[min_i] += 1
        ans = max(nums) - min(nums)

    print(f'#{t} {ans}')