def solution(id_list, report, k):
    declaration_count = dict()
    declaration_id = dict()
    result = dict()
    
    for user in id_list:
        declaration_count[user] = 0
        declaration_id[user] = []
        result[user] = 0
        
    for repo in report:
        user, reported = repo.split(" ")
        if reported not in declaration_id[user]:
            declaration_id[user].append(reported)
            declaration_count[reported] += 1
        
    for user in id_list:
        for reported in declaration_id[user]:
            if declaration_count[reported] >= k:
                result[user] += 1
        
    
    return list(result.values())