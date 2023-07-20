# Silver 5 1316. 그룹 단어 체커
from collections import Counter

N = int(input())

ans = 0

for _ in range(N):
    word = list(input())
    error = 0

    for i in range(len(word)-1):
        if word[i] != word[i+1]:
            check_word = word[i+1:]
            if check_word.count(word[i]) > 0:
                error += 1
    if error == 0:
        ans += 1
print(ans)