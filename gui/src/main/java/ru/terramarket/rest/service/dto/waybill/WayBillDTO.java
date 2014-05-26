package ru.terramarket.rest.service.dto.waybill;

import ru.terra.server.dto.CommonDTO;
import ru.terra.server.dto.UserDTO;

import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

@XmlRootElement
public class WayBillDTO extends CommonDTO {

    public int count;
    public Long selldate;
    public List<WayBillItemDTO> waybillItems;
    public UserDTO user;
    public String supplier, title;

    public WayBillDTO() {
    }
}
