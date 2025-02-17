// M = 12

variables {
    hidden int x <- IEX;
    hidden int y <- IEX;
    int a <- IEX;
    int b <- IEX;
    int o <- IEX;
}

signatures {
    funab_M8(a, b, x, y, o);
}

language {
    boolean B -> false | AP | AP && AP | AP && AP && AP ;
    boolean AP ->  N == N | gcd(V, 8) % C == 0 | gcd(V, 8) == C ;
    int N -> V | C;
    int V -> a | b | o;
    int C -> 0 | 1 | 2 | 4 | 8;
}

examples {
    int IEX -> ??(3) | 8 + ??(2);
    boolean BEX-> true | false;
}