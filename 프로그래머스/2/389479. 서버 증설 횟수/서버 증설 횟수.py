def solution(players, m, k):
    answer = server(players, m, k)

    return answer

def server(p,m,k):
    count = 0
    for i in range(len(p)):
        # 접속 인원이 서버의 최대 이용자수를 넘지 않으면 증설할 필요 없음
        if p[i] < m:
            continue
        else:
            # 나눈 몫이 증설 횟수
            div = (p[i])//m
            count += div
            # 운영 시간 i: 현재 시간, j: 운영 가능 시간, k: 서버 한대 운영 가능한 시간
            for j in range(k):
                if i+j < 24:
                    # 증설된 만큼 인원수 제거
                    p[i+j] -= div * m

    return count