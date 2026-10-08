def solution(number, limit, power):
    answer = 0
    weapon = []
    
    # 철의 무게 계산
    for i in range(1,number+1):
        cnt = 0
        for j in range(1,int(i**0.5)+1):
            if i % j == 0:
                if i != j*j:
                    cnt += 2
                else:
                    cnt += 1
        weapon.append(cnt)
    
    for i in range(len(weapon)):
        if weapon[i] > limit:
            weapon[i] = power
    
    return sum(weapon)