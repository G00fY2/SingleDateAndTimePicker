package com.github.florent37.singledateandtimepicker.widget;

import android.util.Pair;

import java.util.Calendar;
import java.util.Date;

public class DateWithLabel extends Pair<String, Date> {


    /**
     * Constructor for a Pair.
     *
     * @param first  the first object in the Pair
     * @param second the second object in the pair
     */
    public DateWithLabel(String first, Date second) {
        super(first, second);
        if (second == null) {
            throw new IllegalArgumentException("null value provided. " +
                    "first=[" + first + "], second=[" + second + "]");
        }
    }

    @Override
    public String toString() {
        return first;
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof Pair)) {
            return false;
        }
        Pair<?, ?> p = (Pair<?, ?>) o;
        return (p.first == first) || (p.first != null && p.first.equals(first))
            && (p.second == second) ||
            (p.second instanceof Date && compareDatesWithoutTime((Date) p.second, second));
    }

    private boolean compareDatesWithoutTime(Date a, Date b) {
        Calendar calA = Calendar.getInstance();
        calA.setTime(a);
        Calendar calB = Calendar.getInstance();
        calB.setTime(b);

        return calA.get(Calendar.YEAR) == calB.get(Calendar.YEAR)
            && calA.get(Calendar.MONTH) == calB.get(Calendar.MONTH)
            && calA.get(Calendar.DATE) == calB.get(Calendar.DATE);
    }
}
