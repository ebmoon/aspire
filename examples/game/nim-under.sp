variables {
    Strategy P0;
    hidden Strategy P1;
    int n0;
    int n1;
    boolean win;
}

signatures {
    prog(P0, P1, n0, n1, win);
}

language {
    boolean B -> G && R;
    boolean G -> false | AP | AP && AP | AP && AP && AP | AP && AP && AP && AP | AP && AP && AP && AP && AP |  AP && AP && AP && AP && AP && AP;
    boolean AP -> forall((i, j, x, y) -> (!(i < j) || (x == I)), n0, n1, P0)
                | forall((i, j, x, y) -> (!(i > j) || (x == I)), n0, n1, P0)
                | forall((i, j, x, y) -> (!(i < j) || (y == j - i)), n0, n1, P0)
                | forall((i, j, x, y) -> (!(i > j) || (y == j)), n0, n1, P0)
                | forall((i, j, x, y) -> (!(i < j) || (y == i)), n0, n1, P0)
                | forall((i, j, x, y) -> (!(i > j) || (y == i - j)), n0, n1, P0)
                | N < N | N <= N | N == N | N != N;
    int N -> n0 | n1 | 0;
    boolean I -> 0 | 1;

    boolean R -> win | !win;
}
examples {
    boolean BEX -> ??(1);
    int IEX -> ??(2);
    Strategy StrategyEX -> genStrategy();
}
