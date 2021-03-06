package ru.terra.terramarket.cache;

import org.eclipse.swt.widgets.Shell;

import ru.terra.terramarket.dto.ListDTO;
import ru.terra.terramarket.dto.product.ProductDTO;
import ru.terra.terramarket.network.RestClient;

@Cache
public class ProductsCache extends AbstractCache<ProductDTO> {

  
    @Override
    public void fill(Shell shell) {
        ListDTO<ProductDTO> prods = new RestClient(shell).loadProducts();
        if (prods != null)
            for (ProductDTO prod : prods.data) {
                add(prod.id, prod);
            }
    }
}
