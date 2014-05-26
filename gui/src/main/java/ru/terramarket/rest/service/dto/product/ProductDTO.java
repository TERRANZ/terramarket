package ru.terramarket.rest.service.dto.product;

import ru.terra.server.dto.CommonDTO;
import ru.terramarket.rest.service.dto.group.GroupDTO;

import javax.xml.bind.annotation.XmlRootElement;
import java.util.ArrayList;
import java.util.List;

@XmlRootElement
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

    public ProductDTO() {
    }
}
