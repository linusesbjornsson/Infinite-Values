package com.linesb.value;

/**
 * Created by linus on 2018-03-05.
 */

public class DefaultValue extends AbstractValueHolder<DefaultValue> {

    public DefaultValue() {
        super();
    }

    public DefaultValue(Value[] value) {
        super(value);
    }

    public DefaultValue(int value) {
        super(value);
    }

    public DefaultValue(int value, char suffix) {
        super(value, suffix);
    }
}
