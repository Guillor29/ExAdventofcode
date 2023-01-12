package Day;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class Monkey {
    public List<BigDecimal> items = new ArrayList<BigDecimal>();
    public List<Long> itemsLong = new ArrayList<Long>();

    public String operation = "";
    public int test = 0;
    public int trueValue = 0;
    public int falseValue = 0;
    public int inspect = 0;
}

