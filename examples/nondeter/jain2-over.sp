variables {
    hidden NDArray h;
    int x;
    int y;
}

signatures {
    prog(h, x, y);
}

language {
    boolean B -> true | AP | AP || AP | AP || AP || AP;
    boolean AP ->  L == R | L != R;
    int L -> N | N % C;
    int R -> 0 | 1 | 2;
    int N -> x | y | x + y;
    int C -> 1 | 2;
}

examples {
    int IEX -> ??(5);
    NDArray NDArrayEX -> genNDArray();
}