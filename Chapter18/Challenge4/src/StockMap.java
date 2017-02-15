import java.util.HashMap;
import java.util.Map;

/**
 * Author: Andrew Laing
 * Email:  parisianconnections@gmail.com
 * Date:   31/01/2017.
 */
public class StockMap
{
    private Map<String, Stock> stocks;

    public StockMap()
    {
        stocks = new HashMap<String, Stock>();
    }

    public void add(String key, Stock value)
    {
        stocks.put(key, value);
    }

    public Stock search(String symbol)
    {
        return stocks.get(symbol.toUpperCase());
    }
}
