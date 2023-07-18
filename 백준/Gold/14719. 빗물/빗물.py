# Gold 5 14719. 빗물

H, W = map(int,input().split())

lst = list(map(int,input().split()))

sum_rain = 0

for i in range(1, W-1):
    left_max = max(lst[:i])
    right_max = max(lst[i+1:])

    compare = min(left_max,right_max)

    if lst[i] < compare:
        sum_rain += compare-lst[i]

print(sum_rain)