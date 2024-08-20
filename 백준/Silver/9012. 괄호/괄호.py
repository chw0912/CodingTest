# Silver 4. 괄호

T = int(input())

for _ in range(T):
    str = list(input())
    vps = 0
    flag = True

    for text in str:
        if text == "(":
            vps += 1
        else:
            vps -= 1

        if vps < 0:
            flag = False
            break
    if not flag:
        print("NO")
    else:
        if vps == 0:
            print("YES")
        else:
            print("NO")