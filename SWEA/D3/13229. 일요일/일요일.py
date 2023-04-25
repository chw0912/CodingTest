T = int(input())

for t in range(1, T+1):
    weeks = {'MON':1,'TUE':2,'WED':3,'THU':4,'FRI':5,'SAT':6,'SUN':0}

    day = input()

    ans = 0

    if day in weeks:
        ans = 7 - weeks[day]

    print(f'#{t} {ans}')