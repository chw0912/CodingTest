# Silver 4 1158. 요세푸스 문제

N, K = map(int, input().split())

lst = [i for i in range(1, N+1)]

ans = []
num = 0

for i in range(N):
    num += K-1
    if num >= len(lst):
        num %= len(lst)
    ans.append(str(lst[num]))
    lst.pop(num)

print(f"<{', '.join(ans)}>")