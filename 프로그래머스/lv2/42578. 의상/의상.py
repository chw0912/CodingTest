from collections import Counter

def solution(clothes):
    cloth_counter = Counter([ctype for _, ctype in clothes])
    answer = 1

    for count in cloth_counter.values():
        answer *= (count + 1)

    return answer - 1