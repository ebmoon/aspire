//
// ----- Query -----
//

variables {
    int M <- posIEX;
    int x <- IEX;
    int a <- IEX;
    hidden int y <- IEX;
}

signatures {
    remhash(a, x, M, y);
}

relations {
    lt0(y);
}
// The query is "\exists y. y = modmul(a, x, M) /\ y < 0".


//
// ----- DSL -----
//

language {
    boolean B -> false | AP | AP && AP | AP && AP && AP | AP && AP && AP && AP | AP && AP && AP && AP && AP | AP && AP && AP && AP && AP && AP;
    boolean AP -> isPrime(M) | !isPrime(M) | N == N | N != N | N < N | N <= N ;
    int N -> a | x | M | 0 | -M ;
}

examples {
    int IEX -> ??(4) - 8;
    int posIEX-> ??(3);
}