def solution(n, bans):
    answer = ''
    
    ban_nums = sorted([str_to_num(ban) for ban in bans])
    
    for ban in ban_nums:
        if ban <= n:
            n += 1
        else:
            break
        
    return num_to_str(n)

def str_to_num(s):
    num = 0
    for i, char in enumerate(reversed(s)):
        num += (ord(char) - ord('a') + 1) * (26 ** i)
        
    return num
    
def num_to_str(num):
    res = []
    while num > 0:
        num, mod = divmod(num-1, 26)
        res.append(chr(ord('a') + mod))
        
    return "".join(reversed(res))