//
// ----- Query -----
//

variables {
    int M <- posIEX;
    hidden int x <- IEX;
    int a <- IEX;
    int y <- IEX;
}

signatures {
    remhash(a, x, M, y);
}

// The query is "\exists x. y = modmul(a, x, M)".


//
// ----- DSL -----
//

language {
    boolean B -> false | AP | AP && AP | AP && AP && AP | AP && AP && AP && AP | AP && AP && AP && AP && AP | AP && AP && AP && AP && AP && AP;
    boolean AP -> isPrime(M) | !isPrime(M) | N == N | N != N | N < N | N <= N ;
    int N -> a | y | M | 0 | -M ;
}

examples {
    int IEX -> ??(4) - 8;
    int posIEX-> ??(3);
}