def solution(lottos, win_nums):
    answer = []
    
    rank = {6:1, 5:2, 4:3, 3:4, 2:5, 1:6, 0:1}
    
    cnt = 0
    zero_count = 0
    
    for num in lottos:
        if num in win_nums:
            cnt += 1
            continue
        elif num == 0:
            zero_count += 1

    if cnt == 0 and zero_count >= 1:
        return [rank[zero_count],6]
    elif cnt==0 and zero_count == 0:
        return [6,6]
    return [rank[cnt+zero_count],rank[cnt]]