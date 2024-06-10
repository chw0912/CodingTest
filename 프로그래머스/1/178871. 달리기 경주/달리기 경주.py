def solution(players, callings):
    
    # 선수들의 초기 랭킹을 딕셔너리 타입으로 저장
    player_ranking = {player:int(rank) for rank,player in enumerate(players)}
    
    for call in callings:
        current_ranking = player_ranking[call]
        
        player_ranking[call] -= 1
        player_ranking[players[current_ranking-1]] += 1
        
        players[current_ranking-1], players[current_ranking] = call, players[current_ranking-1]
        
    return players