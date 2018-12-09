package com.linesb.value;

/**
 * Created by linus on 2018-02-26.
 *
 * @param <T>
 */
public interface ValueHolder<T extends ValueHolder<?>> extends Comparable<T> {

    public boolean addValue(T value);

    public boolean removeValue(T value);

    public T setValue(int value, char suffix);

    public T setValue(T value);

    public Value[] getValue();

    public Value getValue(char suffix);

    public Value getMaxValue();
}
