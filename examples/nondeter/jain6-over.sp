variables {
    hidden NDArray h;
    int x;
    int y;
    int z;
}

signatures {
    prog(h, x, y, z);
}

language {
    boolean B -> true | AP | AP || AP | AP || AP || AP;
    boolean AP ->  L == R | L != R;
    int L -> N | N % C;
    int R -> 0 | 1 | 2 | 4 | 8;
    int N -> x | y | z | 4 * x + 2 * y + z;
    int C -> 1 | 2 | 4 | 8;
}

examples {
    int IEX -> ??(5);
    NDArray NDArrayEX -> genNDArray();
}