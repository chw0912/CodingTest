# Silver 5 - 15312. 이름 궁합

Alpha = [3, 2, 1, 2, 3, 3,
         2, 3, 3, 2, 2, 1,
         2, 2, 1, 2, 2, 2,
         1, 2, 1, 1, 1, 2,
         2, 1]

A = list(input())
B = list(input())

compatibility = []

for i in range(len(A)):
    compatibility.append(Alpha[ord(A[i])-65])
    compatibility.append(Alpha[ord(B[i])-65])

while len(compatibility) != 2:
    tmp = []
    for i in range(len(compatibility)-1):
        num = compatibility[i] + compatibility[i+1]
        if num >= 10:
            num -= 10
        tmp.append(num)
    compatibility = tmp

print(compatibility[0],end='')
print(compatibility[1])