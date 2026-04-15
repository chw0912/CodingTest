def solution(message, spoiler_ranges):
    answer = 0
    
    spoiler_message = [False] * len(message)
    message_range = []
    
    # 사작, 끝
    start = 0
    end = 0
    
    # 단어별 범위 구하기
    while(end != len(message)):
        if message[end] == " " or end == len(message)-1:
            message_range.append((message[start:end+1].strip(), start, end-1))
            start = end + 1
        end += 1
        
    for start,end in spoiler_ranges:
        for i in range(start,end+1):
            spoiler_message[i] = True
        
    words = set()
    for word, start, end in message_range:
        is_spoiler = any(spoiler_message[i] for i in range(start, end+1))
        if not is_spoiler:
            words.add(word)
    
    result = 0
    print(words)
    for word, start, end in message_range:
        if word not in words:
            result+=1
            words.add(word)
    
    return result