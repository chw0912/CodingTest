def solution(keymap, targets):
    result = []
    keymap = [list(keymap[i]) for i in range(len(keymap))]
    test = {}
    # keymap 원소들을 {키 : 순서} 형태로 딕셔너리에 저장
    for i in range(len(keymap)):
        for turn, key in enumerate(keymap[i]):
            if key not in test:
                test[key] = turn + 1
            elif key in test and test[key] > turn:
                test[key] = turn + 1
                    
    
    # target을 만들기 위한 최소 횟수 구하기
    for i in range(len(targets)):
        cnt = 0
        for target in targets[i]:
            if target in test:
                cnt += test[target]
            else:
                cnt = 0
                result.append(-1)
                break
        if cnt:
            result.append(cnt)
            
    return result