# Silver 5 2941. 크로아티아 알파벳

Alphabet=['c=', 'c-', 'dz=', 'd-',
          'lj', 'nj', 's=', 'z=']

word = input()

lst = word

for alpha in Alphabet:
    cnt = lst.count(alpha)
    if alpha in word:
        lst = lst.replace(alpha,'.')
print(len(lst))