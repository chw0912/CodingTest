def solution(citations):
    ans = 0
    citations=sorted(citations)
    
    for i in range(len(citations)):
        if citations[i] >= len(citations)-i:
            ans += 1
    return ans