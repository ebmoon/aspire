variables {
    hidden NDArray h;
    int y;
}

signatures {
    prog(h, y);
}

language {
    boolean B -> false | AP | AP && AP | AP && AP && AP;
    boolean AP -> L < R | L <= R | L > R | L >= R | L == R | L != R;
    int L -> N | N % C;
    int R -> C;
    int N -> y;
    int C -> ??(2);
}

examples {
    int IEX -> ??(5);
    NDArray NDArrayEX -> genNDArray();
}