package com.linesb.value;

import com.dungeon.clickers.Formatter;

public class ValueHolderFormatter implements Formatter {

    private final ValueHolder<?> value;
    private final int THRESHOLD = 100;

    public ValueHolderFormatter(ValueHolder<?> value) {
        this.value = value;
    }

    @Override
    public String format() {
        Value[] valueArray = value.getValue();
        int i = valueArray.length - 1;
        int highestValue = -1;
        while (i >= 0 && highestValue == -1) {
            if (valueArray[i].getValue() > 0) {
                if (highestValue == -1) {
                    highestValue = i;
                }
            }
            i--;
        }
        if (highestValue != -1) {
            if (valueArray[highestValue].getValue() >= THRESHOLD) {
                return valueArray[highestValue].toString();
            } else if (highestValue - 1 >= 0) {
                StringBuilder sb = new StringBuilder();
                int newValue = (valueArray[highestValue - 1].getValue() + valueArray[highestValue].getValue() * Value.THRESHOLD);
                sb.append(formatNumber(newValue));
                char suffix = valueArray[highestValue - 1].getSuffix();
                if (suffix != Character.MIN_VALUE) {
                    sb.append(suffix);
                }
                return sb.toString();
            }
        }
        return formatNumber(valueArray[0].getValue()) + valueArray[0].getSuffix();
    }

    private String formatNumber(int number) {
        String numberString = Integer.toString(number);
        if (numberString.length() >= 3) {
            StringBuilder sb = new StringBuilder();
            sb.append(numberString.charAt(0)).append(",");
            for (int i = 1; i < numberString.length(); i++) {
                sb.append(numberString.charAt(i));
            }
            return sb.toString();
        }
        return numberString;
    }

}
