def solution(elements):
    n = len(elements)
    elements = elements * 2
    answer = 0
    lst = []
    
    for i in range(n):
        for j in range(1,n):
            lst.append(sum(elements[i:i+j]))
            

    return len(set(lst))+1