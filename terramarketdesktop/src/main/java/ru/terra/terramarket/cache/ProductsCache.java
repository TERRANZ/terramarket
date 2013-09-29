package ru.terra.terramarket.cache;

import ru.terra.terramarket.dto.ListDTO;
import ru.terra.terramarket.dto.product.ProductDTO;
import ru.terra.terramarket.network.RestClient;

/**
 * User: Vadim Korostelev
 * Date: 21.08.13
 * Time: 12:41
 */
public class ProductsCache extends AbstractCache<Integer, ProductDTO> {
    private static ProductsCache instance = new ProductsCache();

    public static ProductsCache getInstance() {
        return instance;
    }

    private ProductsCache() {
    }

    public void fill() {
        ListDTO<ProductDTO> prods = new RestClient().loadProducts();
        if (prods != null)
            for (ProductDTO prod : prods.data) {
                add(prod.id, prod);
            }
    }
}
