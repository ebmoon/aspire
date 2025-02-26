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
    boolean AP -> L < R | L <= R | L > R | L >= R | L == R ;
    int L -> C * n * n + C * n + C;
    int R -> C * s;
    int C -> 0 | 1 | 2 | -1 | -2;
}

examples {
    int IEX1 -> ??(4);
    int IEX2 -> ??(5) | -??(5);
    NDArray NDArrayEX -> genNDArray();
}