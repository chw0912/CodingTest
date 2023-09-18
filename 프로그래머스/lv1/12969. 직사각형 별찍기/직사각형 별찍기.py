a, b = map(int, input().strip().split(' '))
answer = ''
for i in range(b):
    tmp = ''
    for j in range(a):
        tmp += '*'
    print(tmp)