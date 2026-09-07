from collections import defaultdict
from bisect import bisect_left

def solution(info, query):
    answer = []
    
    info_dict = defaultdict(list)
    
    
    # 지원자 정보 저장하기
    for person in info:
        lan, job, his, foo, sco = person.split(" ")
        score = int(sco)
        
        for l_cond in [lan, '-']:
            for j_cond in [job, '-']:
                for h_cond in [his, '-']:
                    for f_cond in [foo, '-']:
                        key = l_cond + j_cond + h_cond + f_cond
                        info_dict[key].append(score)
    
    for key in info_dict:
        info_dict[key].sort()
        
    for q in query:
        q = q.replace(" and ", " ").split(" ")
        q_key = q[0] + q[1] + q[2] + q[3]
        q_score = int(q[4])
        
        if q_key in info_dict:
            scores = info_dict[q_key]
            
            idx = bisect_left(scores, q_score)
            
            answer.append(len(scores) - idx)
        else:
            answer.append(0)
    
    
    return answer


        
        