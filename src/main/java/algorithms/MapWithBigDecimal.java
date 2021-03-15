package algorithms;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class MapWithBigDecimal {
    public static void main(String[] args) {
        Set m = new HashSet();
        m.add(new BigDecimal("1.00"));
        m.add(new BigDecimal("1.0"));
        m.add(new BigDecimal("1.00"));
        m.add(new BigDecimal("1.0"));
        System.out.println(m.size());
    }
}
