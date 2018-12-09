package com.linesb.value;

/**
 * Created by linus on 2018-02-26.
 *
 * @param <T>
 */
public abstract class AbstractCurrency<T extends ValueHolder<?>> extends AbstractValueHolder<T> {

    public AbstractCurrency() {
        super();
    }

    public AbstractCurrency(Value[] value) {
        super(value);
    }

    public AbstractCurrency(int value) {
        super(value);
    }

    public AbstractCurrency(int value, char suffix) {
        super(value, suffix);
    }

    public abstract CurrencyType getType();

    @Override
    public int compareTo(T valueHolder) {
        if (valueHolder instanceof AbstractCurrency && ((AbstractCurrency) valueHolder).getType().equals(getType())) {
            return super.compareTo(valueHolder);
        }
        return -1;
    }

    public enum CurrencyType {
        GOLD,
        DIAMOND
    }
}
