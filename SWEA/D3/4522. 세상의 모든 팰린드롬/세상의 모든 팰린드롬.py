for t in range(1, int(input())+1):
    text = list(input())

    palindrome1 = []
    palindrome2 = []
    flag = True
    if len(text) % 2 == 0:
        for i in range(len(text)//2):
            palindrome1 += text[i]
            palindrome2 += text[-(i+1)]

        for i in range(len(palindrome1)):
            if palindrome1[i] != palindrome2[i]:
                if palindrome1[i] == '?':
                    palindrome1[i] = palindrome2[i]
                elif palindrome2[i] == '?':
                    palindrome2[i] = palindrome1[i]
                else:
                    flag = False
    elif len(text) % 2 == 1:
        for i in range(len(text)//2):
            palindrome1 += text[i]
            palindrome2 += text[-(i+1)]
        
        for i in range(len(palindrome1)):
            if palindrome1[i] != palindrome2[i]:
                if palindrome1[i] == '?':
                    palindrome1[i] = palindrome2[i]
                elif palindrome2[i] == '?':
                    palindrome2[i] = palindrome1[i]
                else:
                    flag = False
    if not flag:
        print(f'#{t} Not exist')
    else:
        print(f'#{t} Exist')