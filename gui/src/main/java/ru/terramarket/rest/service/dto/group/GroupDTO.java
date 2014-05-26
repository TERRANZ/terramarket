package ru.terramarket.rest.service.dto.group;

import ru.terra.server.dto.CommonDTO;
import ru.terramarket.rest.service.dto.product.ProductDTO;

import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

@XmlRootElement
public class GroupDTO extends CommonDTO {

    public String name;
    public int parent;
    public List<ProductDTO> productList;


    public GroupDTO() {
    }


}
