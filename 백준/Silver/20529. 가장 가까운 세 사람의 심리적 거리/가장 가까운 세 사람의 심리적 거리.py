# Silver 1 - 20529. 가장 가까운 세 사람의 심리적 거리
from itertools import combinations

mbtis = ['ISTJ', 'ISFJ', 'INFJ', 'INTJ',
         'ISTP', 'ISFP', 'INFP', 'INTP',
         'ESTP', 'ESFP', 'ENFP', 'ENTP',
         'ESTJ', 'ESFJ', 'ENFJ', 'ENTJ']

T = int(input())

for t in range(T):
    N = int(input())
    table = {mbti : 0 for mbti in mbtis}
    temp = input().split()

    if N > 32:
        print(0)
        continue
    else:
        temp = list(combinations(temp, 3))
        score_list = []
        for combi in temp:
            score = 0
            for i in range(4):
                if (combi[0][i] == combi[1][i] and
                    combi[0][i] == combi[2][i] and
                    combi[1][i] == combi[2][i]):
                    score += 0
                else:
                    score += 2

            score_list.append(score)
        print(min(score_list))

