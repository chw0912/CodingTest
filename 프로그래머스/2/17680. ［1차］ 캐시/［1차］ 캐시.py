from collections import deque

def solution(cacheSize, cities):
    time = 0
    
    cache = deque()
    
    if cacheSize == 0:
        return len(cities) * 5
    
    for i in range(len(cities)):
        city = cities[i].lower();
        
        if city in cache:
            time += 1
            cache.remove(city)
            cache.append(city)
        else:
            time += 5
            if len(cache) < cacheSize:
                cache.append(city)
            else:
                cache.popleft()
                cache.append(city)
    
    return time