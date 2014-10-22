from math import sqrt, ceil, floor

def factorize(n):
    """
    Faktorizira �tevilo n.

    �e je �tevilo n sodo, vrne njegovo polovico in 2. Tako se izogne neskon�ni zanki v primeru,
    ko je n oblike 4k + 2, saj takih ni mogo�e izraziti kot (x+y)(x-y), kjer sta x in y cela.
    """
    
    def isSquare(m):
        """
        Preveri, �e je �tevilo popoln kvadrat, in vrne njegov koren, �e je.

        �tevilo m koreni, nato pa preveri enakost kvadrata zgornjega in spodnjega celega dela
        korena z m. �e je dose�ena enakost, vrne zgornji oziroma spodnji celi del, sicer pa False.
        """
        
        s = sqrt(m)
        f, c = long(floor(s)), long(ceil(s))
        if f*f == m:
            return f
        if c*c == m:
            return c
        return False

    if n % 2 == 0:
        return long(n/2), 2L

    x = long(ceil(sqrt(n)))
    while True:
        y = isSquare(x*x - n)
        if y != False:
            return x+y, x-y
        x += 1

print factorize(63751865072128889063539)        