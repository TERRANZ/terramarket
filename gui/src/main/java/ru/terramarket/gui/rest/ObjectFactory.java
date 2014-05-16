
package ru.terramarket.gui.rest;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the ru.terramarket.gui.rest package. 
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {

    private final static QName _CommonDTO_QNAME = new QName("", "commonDTO");
    private final static QName _WayBillDTO_QNAME = new QName("", "wayBillDTO");
    private final static QName _LoginDTO_QNAME = new QName("", "loginDTO");
    private final static QName _PhotoDTO_QNAME = new QName("", "photoDTO");
    private final static QName _SellDTO_QNAME = new QName("", "sellDTO");
    private final static QName _StoreDTO_QNAME = new QName("", "storeDTO");
    private final static QName _ProductDTO_QNAME = new QName("", "productDTO");
    private final static QName _GroupDTO_QNAME = new QName("", "groupDTO");
    private final static QName _SimpleDataDTO_QNAME = new QName("", "simpleDataDTO");
    private final static QName _UserDTO_QNAME = new QName("", "userDTO");
    private final static QName _SellItemDTO_QNAME = new QName("", "sellItemDTO");
    private final static QName _WayBillItemDTO_QNAME = new QName("", "wayBillItemDTO");
    private final static QName _ListDTO_QNAME = new QName("", "listDTO");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: ru.terramarket.gui.rest
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link CommonDTO }
     * 
     */
    public CommonDTO createCommonDTO() {
        return new CommonDTO();
    }

    /**
     * Create an instance of {@link WayBillDTO }
     * 
     */
    public WayBillDTO createWayBillDTO() {
        return new WayBillDTO();
    }

    /**
     * Create an instance of {@link LoginDTO }
     * 
     */
    public LoginDTO createLoginDTO() {
        return new LoginDTO();
    }

    /**
     * Create an instance of {@link PhotoDTO }
     * 
     */
    public PhotoDTO createPhotoDTO() {
        return new PhotoDTO();
    }

    /**
     * Create an instance of {@link SellDTO }
     * 
     */
    public SellDTO createSellDTO() {
        return new SellDTO();
    }

    /**
     * Create an instance of {@link StoreDTO }
     * 
     */
    public StoreDTO createStoreDTO() {
        return new StoreDTO();
    }

    /**
     * Create an instance of {@link ProductDTO }
     * 
     */
    public ProductDTO createProductDTO() {
        return new ProductDTO();
    }

    /**
     * Create an instance of {@link GroupDTO }
     * 
     */
    public GroupDTO createGroupDTO() {
        return new GroupDTO();
    }

    /**
     * Create an instance of {@link SimpleDataDTO }
     * 
     */
    public SimpleDataDTO createSimpleDataDTO() {
        return new SimpleDataDTO();
    }

    /**
     * Create an instance of {@link UserDTO }
     * 
     */
    public UserDTO createUserDTO() {
        return new UserDTO();
    }

    /**
     * Create an instance of {@link SellItemDTO }
     * 
     */
    public SellItemDTO createSellItemDTO() {
        return new SellItemDTO();
    }

    /**
     * Create an instance of {@link WayBillItemDTO }
     * 
     */
    public WayBillItemDTO createWayBillItemDTO() {
        return new WayBillItemDTO();
    }

    /**
     * Create an instance of {@link ListDTO }
     * 
     */
    public ListDTO createListDTO() {
        return new ListDTO();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link CommonDTO }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "commonDTO")
    public JAXBElement<CommonDTO> createCommonDTO(CommonDTO value) {
        return new JAXBElement<CommonDTO>(_CommonDTO_QNAME, CommonDTO.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link WayBillDTO }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "wayBillDTO")
    public JAXBElement<WayBillDTO> createWayBillDTO(WayBillDTO value) {
        return new JAXBElement<WayBillDTO>(_WayBillDTO_QNAME, WayBillDTO.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link LoginDTO }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "loginDTO")
    public JAXBElement<LoginDTO> createLoginDTO(LoginDTO value) {
        return new JAXBElement<LoginDTO>(_LoginDTO_QNAME, LoginDTO.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link PhotoDTO }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "photoDTO")
    public JAXBElement<PhotoDTO> createPhotoDTO(PhotoDTO value) {
        return new JAXBElement<PhotoDTO>(_PhotoDTO_QNAME, PhotoDTO.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link SellDTO }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "sellDTO")
    public JAXBElement<SellDTO> createSellDTO(SellDTO value) {
        return new JAXBElement<SellDTO>(_SellDTO_QNAME, SellDTO.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link StoreDTO }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "storeDTO")
    public JAXBElement<StoreDTO> createStoreDTO(StoreDTO value) {
        return new JAXBElement<StoreDTO>(_StoreDTO_QNAME, StoreDTO.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ProductDTO }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "productDTO")
    public JAXBElement<ProductDTO> createProductDTO(ProductDTO value) {
        return new JAXBElement<ProductDTO>(_ProductDTO_QNAME, ProductDTO.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GroupDTO }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "groupDTO")
    public JAXBElement<GroupDTO> createGroupDTO(GroupDTO value) {
        return new JAXBElement<GroupDTO>(_GroupDTO_QNAME, GroupDTO.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link SimpleDataDTO }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "simpleDataDTO")
    public JAXBElement<SimpleDataDTO> createSimpleDataDTO(SimpleDataDTO value) {
        return new JAXBElement<SimpleDataDTO>(_SimpleDataDTO_QNAME, SimpleDataDTO.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link UserDTO }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "userDTO")
    public JAXBElement<UserDTO> createUserDTO(UserDTO value) {
        return new JAXBElement<UserDTO>(_UserDTO_QNAME, UserDTO.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link SellItemDTO }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "sellItemDTO")
    public JAXBElement<SellItemDTO> createSellItemDTO(SellItemDTO value) {
        return new JAXBElement<SellItemDTO>(_SellItemDTO_QNAME, SellItemDTO.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link WayBillItemDTO }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "wayBillItemDTO")
    public JAXBElement<WayBillItemDTO> createWayBillItemDTO(WayBillItemDTO value) {
        return new JAXBElement<WayBillItemDTO>(_WayBillItemDTO_QNAME, WayBillItemDTO.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ListDTO }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "listDTO")
    public JAXBElement<ListDTO> createListDTO(ListDTO value) {
        return new JAXBElement<ListDTO>(_ListDTO_QNAME, ListDTO.class, null, value);
    }

}
