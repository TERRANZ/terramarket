package ru.terramarket.rest.service.dto.sell;

import ru.terra.server.dto.CommonDTO;
import ru.terra.server.dto.UserDTO;

import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

@XmlRootElement
public class SellDTO extends CommonDTO {

    public Long sellDate;
    public List<SellItemDTO> sellItems;
    public UserDTO user;

    public SellDTO() {
    }
}
