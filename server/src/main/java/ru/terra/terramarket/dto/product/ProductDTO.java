package ru.terra.terramarket.dto.product;

import ru.terra.server.dto.CommonDTO;
import ru.terra.terramarket.db.entity.Photo;
import ru.terra.terramarket.db.entity.Product;
import ru.terra.terramarket.dto.group.GroupDTO;

import java.util.ArrayList;
import java.util.List;

public class ProductDTO extends CommonDTO {

    public String name = "";
    public Integer mincount = 1;
    public String barcode = "";
    public Integer qtype = 0;
    public Integer priceIn = 0, priceOut = 0;
    public GroupDTO group;
    public Integer rating = 0;
    public List<PhotoDTO> photos = new ArrayList<>();
    public String comment = "";

    public ProductDTO(Product prod) {
        if (prod != null) {
            this.id = prod.getId();
            this.name = prod.getName();
            this.comment = prod.getComment();
            this.mincount = prod.getMincount();
            this.barcode = prod.getBarcode();
            this.qtype = prod.getQtype();
            this.priceIn = prod.getPriceIn();
            this.priceOut = prod.getPriceOut();
            this.group = new GroupDTO(prod.getGroup(), false);
            this.rating = prod.getRating();
            for (Photo photo : prod.getPhotoList()) {
                photos.add(new PhotoDTO(photo));
            }
        }
    }

    public ProductDTO(String name, Integer mincount, String barcode, Integer qtype, Integer priceIn, Integer priceOut, GroupDTO group, String comment) {
        this.name = name;
        this.mincount = mincount;
        this.barcode = barcode;
        this.qtype = qtype;
        this.priceIn = priceIn;
        this.priceOut = priceOut;
        this.group = group;
        this.comment = comment;
    }
}
