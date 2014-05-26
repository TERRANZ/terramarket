
package ru.terramarket.rest.service;

import com.sun.jersey.api.client.config.ClientConfig;
import com.sun.jersey.api.client.config.DefaultClientConfig;

import javax.annotation.Generated;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.Response;
import java.net.URI;

@Generated(value = {
        "wadl|http://localhost:18080/terramarket/application.wadl"
}, comments = "wadl2java, http://wadl.java.net", date = "2014-05-16T16:04:46.515+04:00")
public class TMRestServiceBase {

    /**
     * The base URI for the resource represented by this proxy
     */
    public final static URI BASE_URI;

    static {
        URI originalURI = URI.create("http://localhost:18080/terramarket/");
        // Look up to see if we have any indirection in the local copy
        // of META-INF/java-rs-catalog.xml file, assuming it will be in the
        // oasis:name:tc:entity:xmlns:xml:catalog namespace or similar duck type
        java.io.InputStream is = TMRestServiceBase.class.getResourceAsStream("/META-INF/jax-rs-catalog.xml");
        if (is != null) {
            try {
                // Ignore the namespace in the catalog, can't use wildcard until
                // we are sure we have XPath 2.0
                String found = javax.xml.xpath.XPathFactory.newInstance().newXPath().evaluate(
                        "/*[name(.) = 'catalog']/*[name(.) = 'uri' and @name ='" + originalURI + "']/@uri",
                        new org.xml.sax.InputSource(is));
                if (found != null && found.length() > 0) {
                    originalURI = java.net.URI.create(found);
                }

            } catch (Exception ex) {
                ex.printStackTrace();
            } finally {
                try {
                    is.close();
                } catch (java.io.IOException e) {
                }
            }
        }
        BASE_URI = originalURI;
    }

    public static Login login(com.sun.jersey.api.client.Client client, URI baseURI) {
        return new Login(client, baseURI);
    }

    /**
     * Template method to allow tooling to customize the new Client
     */
    private static void customizeClientConfiguration(ClientConfig cc) {
    }

    /**
     * Template method to allow tooling to override Client factory
     */
    private static com.sun.jersey.api.client.Client createClientInstance(ClientConfig cc) {
        return com.sun.jersey.api.client.Client.create(cc);
    }

    /**
     * Create a new Client instance
     */
    public static com.sun.jersey.api.client.Client createClient() {
        ClientConfig cc = new DefaultClientConfig();
        customizeClientConfiguration(cc);
        return createClientInstance(cc);
    }

    public static Login login() {
        return login(createClient(), BASE_URI);
    }

    public static Login login(com.sun.jersey.api.client.Client client) {
        return login(client, BASE_URI);
    }

    public static Sell sell(com.sun.jersey.api.client.Client client, URI baseURI) {
        return new Sell(client, baseURI);
    }

    public static Sell sell() {
        return sell(createClient(), BASE_URI);
    }

    public static Sell sell(com.sun.jersey.api.client.Client client) {
        return sell(client, BASE_URI);
    }

    public static Waybill waybill(com.sun.jersey.api.client.Client client, URI baseURI) {
        return new Waybill(client, baseURI);
    }

    public static Waybill waybill() {
        return waybill(createClient(), BASE_URI);
    }

    public static Waybill waybill(com.sun.jersey.api.client.Client client) {
        return waybill(client, BASE_URI);
    }

    public static Product product(com.sun.jersey.api.client.Client client, URI baseURI) {
        return new Product(client, baseURI);
    }

    public static Product product() {
        return product(createClient(), BASE_URI);
    }

    public static Product product(com.sun.jersey.api.client.Client client) {
        return product(client, BASE_URI);
    }

    public static Store store(com.sun.jersey.api.client.Client client, URI baseURI) {
        return new Store(client, baseURI);
    }

    public static Store store() {
        return store(createClient(), BASE_URI);
    }

    public static Store store(com.sun.jersey.api.client.Client client) {
        return store(client, BASE_URI);
    }

    public static Group group(com.sun.jersey.api.client.Client client, URI baseURI) {
        return new Group(client, baseURI);
    }

    public static Group group() {
        return group(createClient(), BASE_URI);
    }

    public static Group group(com.sun.jersey.api.client.Client client) {
        return group(client, BASE_URI);
    }


    /**
     * Workaround for JAX_RS_SPEC-312
     */
    protected static class WebApplicationExceptionMessage extends WebApplicationException {
        public WebApplicationExceptionMessage(Response response) {
            super(response);
        }

        /**
         * Workaround for JAX_RS_SPEC-312
         */
        public String getMessage() {
            Response response = getResponse();
            Response.Status status = Response.Status.fromStatusCode(response.getStatus());
            if (status != null) {
                return (response.getStatus() + (" " + status.getReasonPhrase()));
            } else {
                return Integer.toString(response.getStatus());
            }
        }

        public String toString() {
            String s = "javax.ws.rs.WebApplicationException";
            String message = getLocalizedMessage();
            return (s + (": " + message));
        }

    }

}
