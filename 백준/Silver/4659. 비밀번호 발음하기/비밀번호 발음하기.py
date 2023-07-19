# Silver 5 4659. 비밀번호 발음하기

vowel = ['a', 'e', 'i', 'o', 'u']

while(1):
    word = input()

    if word == 'end':
        break
    # 모음 1개 이상인지 확인하기
    v_flag = 0

    # 자음, 모음 3번 연속 되는지 확인하기
    v_cnt = 0
    c_cnt = 0

    # 발음 (가능 : 0 / 불가능 : 1)
    err = 0

    for i in range(len(word)):
        if i > 0:
            if word[i] == word[i-1]:
                if word[i] != 'e' and word[i] != 'o':
                    err = 1
                    break
        if word[i] in vowel:
            v_flag = 1
            v_cnt += 1
            c_cnt = 0
            if v_cnt == 3:
                err = 1
                break
        else:
            v_cnt = 0
            c_cnt += 1
            if c_cnt == 3:
                err = 1
                break
    if err != 1 and v_flag == 1:
        print(f"<{''.join(word)}> is acceptable.")
    else:
        print(f"<{''.join(word)}> is not acceptable.")

