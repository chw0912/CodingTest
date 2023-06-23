from itertools import product

def solution(user_id, banned_id):
    answer = []  # 빈 리스트로 초기화

    candidates = []

    for banned in banned_id:
        matches = []
        for user in user_id:
            if len(banned) == len(user):
                is_match = True
                for b, u in zip(banned, user):
                    if b != '*' and b != u:
                        is_match = False
                        break
                if is_match:
                    matches.append(user)
        
        candidates.append(matches)
    
    for perm in product(*candidates):
        if len(set(perm)) == len(banned_id) and sorted(perm) not in answer:
            answer.append(sorted(perm))
    
    return len(answer)
# from itertools import product
# def solution(user_id, banned_id):
#     answer = 1
#     total = []
#     for i in range(len(banned_id)):
#         cnt = 0
#         length = 0
#         lst = []
        
#         for j in range(len(user_id)):
#             if len(banned_id[i]) == len(user_id[j]):
#                 for k in range(len(banned_id[i])):
#                     if banned_id[i][k] == '*' and banned_id[i][k] != user_id[j][k]:
#                         length += 1
#                     elif banned_id[i][k] == user_id[j][k]:
#                         length += 1
#                     else:
#                         break
#                 if length == len(user_id[j]):
#                     lst.append(user_id[j])
#                 length = 0 
#         total.append(lst) 
    
#     al_li = list(product(*total))
#     ans = []
#     for i in range(len(al_li)):
#         if len(set(al_li[i])) == len(total):
#             al_li[i] = sorted(al_li[i])
#             if al_li[i] not in ans: 
#                 ans.append(al_li[i])
                
#     return len(ans)