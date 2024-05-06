def solution(bandage, health, attacks):
    answer = 0
    # 게임 마지막 시간 
    last_Time = attacks[-1][0]
    # 최대 체력
    max_HP = health
    # 시전 시간, 초당 회복량, 추가 회복량 
    t, x, y = bandage[0],bandage[1],bandage[2]
    
    
    # 게임 시간 생성
    play_Time = [0] * (last_Time + 1)
    
    # 공격 시간별 피해량 play_Time에 저장
    for i in range(len(attacks)):
        play_Time[attacks[i][0]] = attacks[i][1]
        
    #연속 성공 횟수
    count = 0    
    for i in range(1,len(play_Time)):
        if play_Time[i] == 0:
            health += x
            count += 1
            if count == t:
                health += y
                count = 0
            if health >= max_HP:
                health = max_HP
        else:
            health -= play_Time[i]
            count = 0
            if health <= 0:
                health = -1
                break
        
        print()
    return health
