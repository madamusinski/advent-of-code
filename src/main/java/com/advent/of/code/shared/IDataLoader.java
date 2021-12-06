package com.advent.of.code.shared;

public interface IDataLoader<T, R> {

   T loadDataFrom(R r);
}
