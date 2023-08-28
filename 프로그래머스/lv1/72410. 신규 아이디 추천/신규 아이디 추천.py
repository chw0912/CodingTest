def solution(new_id):
    answer = ''
    
    tmp = ''
    new_id = new_id.lower()
    
    # 1단계, 2단계
    for i in new_id:
        if i.isalpha() or i.isdigit() or i in ['-','_','.']:
            tmp += i
    # 3단계
    while '..' in tmp:
        tmp = tmp.replace('..','.')
    
    # 4단계
    while tmp.startswith('.') or tmp.endswith('.'):
        if tmp.startswith('.'):
            tmp = tmp[1:]
        if tmp.endswith('.'):
            tmp = tmp[:-1]
    # 5단계
    if not tmp:
        tmp += 'a'
    
    # 6단계
    if len(tmp) > 15:
        tmp = tmp[:15]
        if tmp.endswith('.'):
            tmp = tmp[:-1]
        
    # 7단계
    if len(tmp) < 3:
        while len(tmp) < 3:
            tmp += tmp[-1]
                
    return tmp