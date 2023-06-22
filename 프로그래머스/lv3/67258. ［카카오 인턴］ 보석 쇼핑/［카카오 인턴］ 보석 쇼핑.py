def solution(gems):
    num = len(set(gems))
    answer = []
    idx = []
    length = []
    left = 0
    gem_dict = {}

    for right in range(len(gems)):
        gem_dict[gems[right]] = gem_dict.get(gems[right], 0) + 1

        while len(gem_dict) == num:
            length.append(right - left)
            idx.append([left + 1, right + 1])

            gem_dict[gems[left]] -= 1
            if gem_dict[gems[left]] == 0:
                del gem_dict[gems[left]]

            left += 1

    index = length.index(min(length))
    return idx[index]
# def solution(gems):
#     num = len(set(gems))
#     answer = []
#     idx = []
#     length=[]
#     left = 0
#     for left in range(len(gems)):
#         for right in range(len(gems)):
#             if len(set(gems[left:right+1])) == num:
#                 idx.append([left+1,right+1])
#                 length.append(right-left)
                
#     index = length.index(min(length))
#     return idx[index]