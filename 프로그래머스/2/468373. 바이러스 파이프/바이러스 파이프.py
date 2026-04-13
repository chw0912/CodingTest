from collections import deque
import copy

global adj, N, K

def solution(n, infection, edges, k):
    global adj, N, K
    
    answer = 0
    
    N = n
    K = k
    adj = [[] for _ in range(n+1)]
    infected = [[] * 4] # 1 : A, 2 : B, 3: C
    
    for idx, nxt, pipe in edges:
        adj[idx].append((nxt, pipe))
        adj[nxt].append((idx, pipe))
    
    # 감염된 노드 리스트
    infected = {infection}
    
    answer = combi(0, infected)
    
    return answer

# 재귀를 통해 가능한 조합에서 최대값을 반환
def combi(depth, current_status):
    # K만큼 반복했다면 감염된 노드의 길이를 반환
    if depth == K:
        return len(current_status)
    
    # 결과값 저장
    result = 0
    
    # A 부터 방문하여 가능한 모든 조합 찾기
    for typ in range(1, 4):
        next_status = bfs(typ, current_status)
        
        result = max(result, combi(depth + 1, next_status))
    
    return result
                     

# 특정 파이프 타입을 통해 추가로 감염될 노드들을 찾기
# pipe_type : 파이프 타입, current_infected : 현재 감염된 노드 리스트
def bfs(pipe_type, current_infected):
    dq = deque(current_infected)
    visited = current_infected.copy()
    
    while dq:
        # 현재 노드의 번호
        cur = dq.popleft()
        
        # nxt : 다음 노드, p_type : 다음 노드의 파이프 타입
        for nxt, p_type in adj[cur]:
            # 다음 노드가 방문하지 않은 상태이고
            # 찾는 파이프와 일치한다면
            # 큐에 추가 및 방문 처리
            if nxt not in visited and p_type == pipe_type:
                dq.append(nxt)
                visited.add(nxt)
                
    return visited
        
        
        