package com.linesb.value;

public class Health extends AbstractValueHolder<Health> {

    public Health() {
        super();
    }

    public Health(Value[] value) {
        super(value);
    }

    public Health(int value) {
        super(value);
    }

    public Health(int value, char suffix) {
        super(value, suffix);
    }
}
