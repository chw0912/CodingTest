# Silver 5 - 11004. K번째 수

N, K = map(int, input().split())
arr = list(map(int, input().split()))

arr.sort()

print(arr[K-1])