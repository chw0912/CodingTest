from itertools import product

rate = [10, 20, 30, 40]

def solution(users, emoticons):
    answer =[]
    rateProd = prod(rate, len(emoticons))
    
    
    return service(users, rateProd, emoticons)

# 유저가 이모티콘 플러스 서비스를 가입할지
# 개별 구매할지 계산하는 함수
def service(users, rateProd, emoticons):
    
    ans = [0,0]
    
    # 모든 조합(각 이모티콘 별 할인율의 조합)
    for p in rateProd:
        
        # 서비스 가입자
        plusPurchase = 0
        # 이모티콘 개별 구매
        emojiPurchase = 0
        
        # 모든 유저를 순회
        for user in users:
            # 유저가 구매한 이모티콘 금액의 합
            uc = 0
            
            # 해당 조합(p)을 순회
            # for discount in p:   
            for i in range(len(p)):
                
                # p[i]의 할인율이 유저 희망 할인율보다 크거나 같다면:
                # 30 : 25 / 30 : 30
                # i는 i번째 이모티콘 할인율
                if p[i] >= user[0]:
                    uc += emoticons[i] * (100 - p[i]) / 100
                    
                    # 이모티콘 구매 비용이 유저의 희망 가격을 이상일 경우
                    if uc >= user[1]:
                        # 이모티콘 플러스 서비스 가입
                        plusPurchase += 1
                        break
            
            # 모든 반복문을 순회했을 때 실행
            # 이모티콘 플러스 가입을 하지 않았을 경우
            else: 
                emojiPurchase += uc
                
        # 비교
        # 플러스 가입자가 많은경우
        if plusPurchase > ans[0]:
            ans[0] = plusPurchase
            ans[1] = emojiPurchase
        # 플러스 가입자가 같은 
        elif plusPurchase == ans[0]:
            ans[1] = max(ans[1], emojiPurchase)
                    
    return ans



# 모든 이모티콘의 10,20,30,40% 할인된 가격 표
def discount(emoticons):
    table = []
    
    for i in range(4):
        temp = []
        for j in range(len(emoticons)):
            discount = emoticons[j] - (emoticons[j] * (i+1) * 0.1)
            temp.append(discount)
        table.append(temp)
    
    return table
    
    
# 순열
# 모든 할인율 별 순열 조합
def prod(discountRate, emoticonLen):
    perm = []
    
    for p in product(discountRate, repeat=emoticonLen):
        perm.append(p)
    
    return perm
    