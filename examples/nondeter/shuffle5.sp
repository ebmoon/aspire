variables {
    Array l_in;
    Array l_out;
    hidden NDArray h;
}

signatures {
    shuffle(l_in, h, l_out);
}

language {
    boolean AP -> false | true | Array_equal(L, L);
    Array L -> l_in | l_out | sort(l_in) | sort(l_out);
}

examples {
    Array ArrayEX -> genArray();
    NDArray NDArrayEX -> genNDArray();
}