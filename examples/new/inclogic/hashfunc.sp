variables {
    int M <- PosIEX;
    hidden int h <- IEX;
    ArrayList S;
    boolean collide;
    boolean ok;
}

signatures {
    prog(S, M, h, ok, collide);
}

language {
    boolean B0 -> ok && B;
    boolean B -> false | AP | AP && AP | AP && AP && AP;
    boolean AP -> isPrime(M) | !isPrime(M) | N == N | N != N | N < N | N <= N | collide | !collide;
    int N -> setsize(S) | setsizemod(S, M) | 0 | 1 | M ;
}

examples {
    int IEX  -> ??(4) - 8;
    int PosIEX -> ??(3) + 2;
    ArrayList ALEX-> newArrayList() | add(ALEX, IEX);
    boolean BEX-> true | false;
}