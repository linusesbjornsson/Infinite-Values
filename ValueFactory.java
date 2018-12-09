package com.linesb.value;

public abstract class ValueFactory {

    private static final int VALUE_LIMIT = 16;

    public static Value[] createValue() {
        Value[] value = new Value[VALUE_LIMIT];
        value[0] = new Value(Character.MIN_VALUE);
        value[1] = new Value('K');
        value[2] = new Value('M');
        value[3] = new Value('B');
        value[4] = new Value('T');
        value[5] = new Value('Q');
        value[6] = new Value('R');
        value[7] = new Value('S');
        value[8] = new Value('V');
        value[9] = new Value('L');
        value[10] = new Value('C');
        value[11] = new Value('P');
        value[12] = new Value('O');
        value[13] = new Value('E');
        value[14] = new Value('Z');
        value[15] = new Value('X');
        return value;
    }

    public static Value[] createValue(int value) {
        return createValue(value, Character.MIN_VALUE);
    }

    public static Value[] createValue(int value, char suffix) {
        Value[] valueArray = createValue();
        for (int i = 0; i < valueArray.length; i++) {
            if (valueArray[i].getSuffix() == suffix) {
                int rest = valueArray[i].addValue(value);
                if (rest > 0) {
                    int j = i;
                    if (j + 1 < valueArray.length) {
                        j++;
                        while (j < valueArray.length && rest > 0) {
                            rest = valueArray[j].addValue(rest);
                            j++;
                        }
                    }
                }
            }
        }
        return valueArray;
    }
}
