package com.linesb.value;

public class Defense extends AbstractValueHolder<Defense> {
	
	public Defense() {
        super();
    }

    public Defense(Value[] value) {
        super(value);
    }

    public Defense(int value) {
        super(value);
    }

    public Defense(int value, char suffix) {
        super(value, suffix);
    }
}
