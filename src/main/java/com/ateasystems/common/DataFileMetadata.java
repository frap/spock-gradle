package com.ateasystems.common;

import cyclops.control.Eval;
import cyclops.control.Maybe;
import cyclops.function.Memoize;
import cyclops.control.Option;
import lombok.AllArgsConstructor;
import lombok.Getter;


import java.util.function.Function;


@AllArgsConstructor
@Getter
public abstract class DataFileMetadata {

    private final long customerId;
    private final String type;

    private final Option<String> contents = Maybe.fromEval(Eval.later(this::loadContents))
            .concatMap(Function.identity());

    protected abstract Option<String> loadContents();

}

