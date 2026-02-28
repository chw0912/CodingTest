from collections import deque

def solution(coin, cards):
    answer = 1
    n = len(cards)
    s = n//3
    
    
    hand = deque(cards[:s])
    deck = deque(cards[s:])
    
    pending = []
    
    while coin >= 0 and deck:
        
        pending.append(deck.popleft())
        pending.append(deck.popleft())
        
        if check(hand,hand,n+1):
            pass
        elif coin >= 1 and check(hand, pending, n+1):
            coin -= 1
        elif coin >= 2 and check(pending, pending, n+1):
            coin -= 2
        else:
            break
        
        answer += 1
         
    return answer

# 체크
def check(deck1, deck2, target):
    
    operand = set(deck2)
    for card in deck1:
        if target-card in operand:
            deck1.remove(card)
            deck2.remove(target-card)
            return True
    
    return False
        
    
    