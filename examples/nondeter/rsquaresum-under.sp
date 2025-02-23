variables {
    int n <- IEX1;
    int s <- IEX2;
    hidden NDArray h;
}

signatures {
    rsum(n, h, s);
}

language {
    boolean B -> false | AP;
    boolean AP -> L < R | L <= R | L > R | L >= R | L == R;
    int L -> C * n * n + C * n + C;
    int R -> s ;
    int C -> 0 | 1 | 2 | 3 | 6 | -1 | -2 | -3 | 6 ;
}

examples {
    int IEX1 -> ??(3);
    int IEX2 -> ??(6) | -??(6);
    NDArray NDArrayEX -> genNDArray();
}