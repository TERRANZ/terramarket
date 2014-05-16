
package ru.terramarket.gui.rest;

import java.net.URI;
import java.util.HashMap;
import java.util.Map;
import javax.annotation.Generated;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriBuilder;
import com.sun.jersey.api.client.config.ClientConfig;
import com.sun.jersey.api.client.config.DefaultClientConfig;

@Generated(value = {
    "wadl|http://localhost:18080/terramarket/application.wadl"
}, comments = "wadl2java, http://wadl.java.net", date = "2014-05-11T13:13:07.894+04:00")
public class RestService {

    /**
     * The base URI for the resource represented by this proxy
     * 
     */
    public final static URI BASE_URI;

    static {
        URI originalURI = URI.create("http://localhost:18080/terramarket/");
        // Look up to see if we have any indirection in the local copy
        // of META-INF/java-rs-catalog.xml file, assuming it will be in the
        // oasis:name:tc:entity:xmlns:xml:catalog namespace or similar duck type
        java.io.InputStream is = RestService.class.getResourceAsStream("/META-INF/jax-rs-catalog.xml");
        if (is!=null) {
            try {
                // Ignore the namespace in the catalog, can't use wildcard until
                // we are sure we have XPath 2.0
                String found = javax.xml.xpath.XPathFactory.newInstance().newXPath().evaluate(
                    "/*[name(.) = 'catalog']/*[name(.) = 'uri' and @name ='" + originalURI +"']/@uri", 
                    new org.xml.sax.InputSource(is)); 
                if (found!=null && found.length()>0) {
                    originalURI = java.net.URI.create(found);
                }
                
            }
            catch (Exception ex) {
                ex.printStackTrace();
            }
            finally {
                try {
                    is.close();
                } catch (java.io.IOException e) {
                }
            }
        }
        BASE_URI = originalURI;
    }

    public static RestService.Store store(com.sun.jersey.api.client.Client client, URI baseURI) {
        return new RestService.Store(client, baseURI);
    }

    /**
     * Template method to allow tooling to customize the new Client
     * 
     */
    private static void customizeClientConfiguration(ClientConfig cc) {
    }

    /**
     * Template method to allow tooling to override Client factory
     * 
     */
    private static com.sun.jersey.api.client.Client createClientInstance(ClientConfig cc) {
        return com.sun.jersey.api.client.Client.create(cc);
    }

    /**
     * Create a new Client instance
     * 
     */
    public static com.sun.jersey.api.client.Client createClient() {
        ClientConfig cc = new DefaultClientConfig();
        customizeClientConfiguration(cc);
        return createClientInstance(cc);
    }

    public static RestService.Store store() {
        return store(createClient(), BASE_URI);
    }

    public static RestService.Store store(com.sun.jersey.api.client.Client client) {
        return store(client, BASE_URI);
    }

    public static RestService.Waybill waybill(com.sun.jersey.api.client.Client client, URI baseURI) {
        return new RestService.Waybill(client, baseURI);
    }

    public static RestService.Waybill waybill() {
        return waybill(createClient(), BASE_URI);
    }

    public static RestService.Waybill waybill(com.sun.jersey.api.client.Client client) {
        return waybill(client, BASE_URI);
    }

    public static RestService.Login login(com.sun.jersey.api.client.Client client, URI baseURI) {
        return new RestService.Login(client, baseURI);
    }

    public static RestService.Login login() {
        return login(createClient(), BASE_URI);
    }

    public static RestService.Login login(com.sun.jersey.api.client.Client client) {
        return login(client, BASE_URI);
    }

    public static RestService.Group group(com.sun.jersey.api.client.Client client, URI baseURI) {
        return new RestService.Group(client, baseURI);
    }

    public static RestService.Group group() {
        return group(createClient(), BASE_URI);
    }

    public static RestService.Group group(com.sun.jersey.api.client.Client client) {
        return group(client, BASE_URI);
    }

    public static RestService.Product product(com.sun.jersey.api.client.Client client, URI baseURI) {
        return new RestService.Product(client, baseURI);
    }

    public static RestService.Product product() {
        return product(createClient(), BASE_URI);
    }

    public static RestService.Product product(com.sun.jersey.api.client.Client client) {
        return product(client, BASE_URI);
    }

    public static RestService.Sell sell(com.sun.jersey.api.client.Client client, URI baseURI) {
        return new RestService.Sell(client, baseURI);
    }

    public static RestService.Sell sell() {
        return sell(createClient(), BASE_URI);
    }

    public static RestService.Sell sell(com.sun.jersey.api.client.Client client) {
        return sell(client, BASE_URI);
    }

    public static class Group {

        private com.sun.jersey.api.client.Client _client;
        private UriBuilder _uriBuilder;
        private Map<String, Object> _templateAndMatrixParameterValues;

        private Group(com.sun.jersey.api.client.Client client, UriBuilder uriBuilder, Map<String, Object> map) {
            _client = client;
            _uriBuilder = uriBuilder.clone();
            _templateAndMatrixParameterValues = map;
        }

        /**
         * Create new instance using existing Client instance, and a base URI and any parameters
         * 
         */
        public Group(com.sun.jersey.api.client.Client client, URI baseUri) {
            _client = client;
            _uriBuilder = UriBuilder.fromUri(baseUri);
            _uriBuilder = _uriBuilder.path("/group/");
            _templateAndMatrixParameterValues = new HashMap<String, Object>();
        }

        public RestService.Group.DoUpdateJson doUpdateJson() {
            return new RestService.Group.DoUpdateJson(_client, _uriBuilder.buildFromMap(_templateAndMatrixParameterValues));
        }

        public RestService.Group.DoCreateJson doCreateJson() {
            return new RestService.Group.DoCreateJson(_client, _uriBuilder.buildFromMap(_templateAndMatrixParameterValues));
        }

        public RestService.Group.DoGetJson doGetJson() {
            return new RestService.Group.DoGetJson(_client, _uriBuilder.buildFromMap(_templateAndMatrixParameterValues));
        }

        public RestService.Group.DoDeleteJson doDeleteJson() {
            return new RestService.Group.DoDeleteJson(_client, _uriBuilder.buildFromMap(_templateAndMatrixParameterValues));
        }

        public RestService.Group.DoListJson doListJson() {
            return new RestService.Group.DoListJson(_client, _uriBuilder.buildFromMap(_templateAndMatrixParameterValues));
        }

        public static class DoCreateJson {

            private com.sun.jersey.api.client.Client _client;
            private UriBuilder _uriBuilder;
            private Map<String, Object> _templateAndMatrixParameterValues;

            private DoCreateJson(com.sun.jersey.api.client.Client client, UriBuilder uriBuilder, Map<String, Object> map) {
                _client = client;
                _uriBuilder = uriBuilder.clone();
                _templateAndMatrixParameterValues = map;
            }

            /**
             * Create new instance using existing Client instance, and a base URI and any parameters
             * 
             */
            public DoCreateJson(com.sun.jersey.api.client.Client client, URI baseUri) {
                _client = client;
                _uriBuilder = UriBuilder.fromUri(baseUri);
                _uriBuilder = _uriBuilder.path("do.create.json");
                _templateAndMatrixParameterValues = new HashMap<String, Object>();
            }

            public GroupDTO postAsGroupDTO() {
                UriBuilder localUriBuilder = _uriBuilder.clone();
                com.sun.jersey.api.client.WebResource resource = _client.resource(localUriBuilder.buildFromMap(_templateAndMatrixParameterValues));
                com.sun.jersey.api.client.WebResource.Builder resourceBuilder = resource.getRequestBuilder();
                resourceBuilder = resourceBuilder.accept("application/json");
                com.sun.jersey.api.client.ClientResponse response;
                response = resourceBuilder.method("POST", com.sun.jersey.api.client.ClientResponse.class);
                if (response.getStatus()>= 400) {
                    throw new RestService.WebApplicationExceptionMessage(Response.status(response.getClientResponseStatus()).build());
                }
                return response.getEntity(GroupDTO.class);
            }

            public<T >T postAsJson(com.sun.jersey.api.client.GenericType<T> returnType) {
                UriBuilder localUriBuilder = _uriBuilder.clone();
                com.sun.jersey.api.client.WebResource resource = _client.resource(localUriBuilder.buildFromMap(_templateAndMatrixParameterValues));
                com.sun.jersey.api.client.WebResource.Builder resourceBuilder = resource.getRequestBuilder();
                resourceBuilder = resourceBuilder.accept("application/json");
                com.sun.jersey.api.client.ClientResponse response;
                response = resourceBuilder.method("POST", com.sun.jersey.api.client.ClientResponse.class);
                if (response.getStatus()>= 400) {
                    throw new RestService.WebApplicationExceptionMessage(Response.status(response.getClientResponseStatus()).build());
                }
                return response.getEntity(returnType);
            }

            public<T >T postAsJson(Class<T> returnType) {
                UriBuilder localUriBuilder = _uriBuilder.clone();
                com.sun.jersey.api.client.WebResource resource = _client.resource(localUriBuilder.buildFromMap(_templateAndMatrixParameterValues));
                com.sun.jersey.api.client.WebResource.Builder resourceBuilder = resource.getRequestBuilder();
                resourceBuilder = resourceBuilder.accept("application/json");
                com.sun.jersey.api.client.ClientResponse response;
                response = resourceBuilder.method("POST", com.sun.jersey.api.client.ClientResponse.class);
                if (!com.sun.jersey.api.client.ClientResponse.class.isAssignableFrom(returnType)) {
                    if (response.getStatus()>= 400) {
                        throw new RestService.WebApplicationExceptionMessage(Response.status(response.getClientResponseStatus()).build());
                    }
                }
                if (!com.sun.jersey.api.client.ClientResponse.class.isAssignableFrom(returnType)) {
                    return response.getEntity(returnType);
                } else {
                    return returnType.cast(response);
                }
            }

        }

        public static class DoDeleteJson {

            private com.sun.jersey.api.client.Client _client;
            private UriBuilder _uriBuilder;
            private Map<String, Object> _templateAndMatrixParameterValues;

            private DoDeleteJson(com.sun.jersey.api.client.Client client, UriBuilder uriBuilder, Map<String, Object> map) {
                _client = client;
                _uriBuilder = uriBuilder.clone();
                _templateAndMatrixParameterValues = map;
            }

            /**
             * Create new instance using existing Client instance, and a base URI and any parameters
             * 
             */
            public DoDeleteJson(com.sun.jersey.api.client.Client client, URI baseUri) {
                _client = client;
                _uriBuilder = UriBuilder.fromUri(baseUri);
                _uriBuilder = _uriBuilder.path("do.delete.json");
                _templateAndMatrixParameterValues = new HashMap<String, Object>();
            }

            public SimpleDataDTO getAsSimpleDataDTO() {
                UriBuilder localUriBuilder = _uriBuilder.clone();
                com.sun.jersey.api.client.WebResource resource = _client.resource(localUriBuilder.buildFromMap(_templateAndMatrixParameterValues));
                com.sun.jersey.api.client.WebResource.Builder resourceBuilder = resource.getRequestBuilder();
                resourceBuilder = resourceBuilder.accept("application/json");
                com.sun.jersey.api.client.ClientResponse response;
                response = resourceBuilder.method("GET", com.sun.jersey.api.client.ClientResponse.class);
                if (response.getStatus()>= 400) {
                    throw new RestService.WebApplicationExceptionMessage(Response.status(response.getClientResponseStatus()).build());
                }
                return response.getEntity(SimpleDataDTO.class);
            }

            public<T >T getAsJson(com.sun.jersey.api.client.GenericType<T> returnType) {
                UriBuilder localUriBuilder = _uriBuilder.clone();
                com.sun.jersey.api.client.WebResource resource = _client.resource(localUriBuilder.buildFromMap(_templateAndMatrixParameterValues));
                com.sun.jersey.api.client.WebResource.Builder resourceBuilder = resource.getRequestBuilder();
                resourceBuilder = resourceBuilder.accept("application/json");
                com.sun.jersey.api.client.ClientResponse response;
                response = resourceBuilder.method("GET", com.sun.jersey.api.client.ClientResponse.class);
                if (response.getStatus()>= 400) {
                    throw new RestService.WebApplicationExceptionMessage(Response.status(response.getClientResponseStatus()).build());
                }
                return response.getEntity(returnType);
            }

            public<T >T getAsJson(Class<T> returnType) {
                UriBuilder localUriBuilder = _uriBuilder.clone();
                com.sun.jersey.api.client.WebResource resource = _client.resource(localUriBuilder.buildFromMap(_templateAndMatrixParameterValues));
                com.sun.jersey.api.client.WebResource.Builder resourceBuilder = resource.getRequestBuilder();
                resourceBuilder = resourceBuilder.accept("application/json");
                com.sun.jersey.api.client.ClientResponse response;
                response = resourceBuilder.method("GET", com.sun.jersey.api.client.ClientResponse.class);
                if (!com.sun.jersey.api.client.ClientResponse.class.isAssignableFrom(returnType)) {
                    if (response.getStatus()>= 400) {
                        throw new RestService.WebApplicationExceptionMessage(Response.status(response.getClientResponseStatus()).build());
                    }
                }
                if (!com.sun.jersey.api.client.ClientResponse.class.isAssignableFrom(returnType)) {
                    return response.getEntity(returnType);
                } else {
                    return returnType.cast(response);
                }
            }

            public SimpleDataDTO getAsSimpleDataDTO(Integer id) {
                UriBuilder localUriBuilder = _uriBuilder.clone();
                if (id == null) {
                }
                if (id!= null) {
                    localUriBuilder = localUriBuilder.replaceQueryParam("id", id);
                } else {
                    localUriBuilder = localUriBuilder.replaceQueryParam("id", ((Object[]) null));
                }
                com.sun.jersey.api.client.WebResource resource = _client.resource(localUriBuilder.buildFromMap(_templateAndMatrixParameterValues));
                com.sun.jersey.api.client.WebResource.Builder resourceBuilder = resource.getRequestBuilder();
                resourceBuilder = resourceBuilder.accept("application/json");
                com.sun.jersey.api.client.ClientResponse response;
                response = resourceBuilder.method("GET", com.sun.jersey.api.client.ClientResponse.class);
                if (response.getStatus()>= 400) {
                    throw new RestService.WebApplicationExceptionMessage(Response.status(response.getClientResponseStatus()).build());
                }
                return response.getEntity(SimpleDataDTO.class);
            }

            public<T >T getAsJson(Integer id, com.sun.jersey.api.client.GenericType<T> returnType) {
                UriBuilder localUriBuilder = _uriBuilder.clone();
                if (id == null) {
                }
                if (id!= null) {
                    localUriBuilder = localUriBuilder.replaceQueryParam("id", id);
                } else {
                    localUriBuilder = localUriBuilder.replaceQueryParam("id", ((Object[]) null));
                }
                com.sun.jersey.api.client.WebResource resource = _client.resource(localUriBuilder.buildFromMap(_templateAndMatrixParameterValues));
                com.sun.jersey.api.client.WebResource.Builder resourceBuilder = resource.getRequestBuilder();
                resourceBuilder = resourceBuilder.accept("application/json");
                com.sun.jersey.api.client.ClientResponse response;
                response = resourceBuilder.method("GET", com.sun.jersey.api.client.ClientResponse.class);
                if (response.getStatus()>= 400) {
                    throw new RestService.WebApplicationExceptionMessage(Response.status(response.getClientResponseStatus()).build());
                }
                return response.getEntity(returnType);
            }

            public<T >T getAsJson(Integer id, Class<T> returnType) {
                UriBuilder localUriBuilder = _uriBuilder.clone();
                if (id == null) {
                }
                if (id!= null) {
                    localUriBuilder = localUriBuilder.replaceQueryParam("id", id);
                } else {
                    localUriBuilder = localUriBuilder.replaceQueryParam("id", ((Object[]) null));
                }
                com.sun.jersey.api.client.WebResource resource = _client.resource(localUriBuilder.buildFromMap(_templateAndMatrixParameterValues));
                com.sun.jersey.api.client.WebResource.Builder resourceBuilder = resource.getRequestBuilder();
                resourceBuilder = resourceBuilder.accept("application/json");
                com.sun.jersey.api.client.ClientResponse response;
                response = resourceBuilder.method("GET", com.sun.jersey.api.client.ClientResponse.class);
                if (!com.sun.jersey.api.client.ClientResponse.class.isAssignableFrom(returnType)) {
                    if (response.getStatus()>= 400) {
                        throw new RestService.WebApplicationExceptionMessage(Response.status(response.getClientResponseStatus()).build());
                    }
                }
                if (!com.sun.jersey.api.client.ClientResponse.class.isAssignableFrom(returnType)) {
                    return response.getEntity(returnType);
                } else {
                    return returnType.cast(response);
                }
            }

        }

        public static class DoGetJson {

            private com.sun.jersey.api.client.Client _client;
            private UriBuilder _uriBuilder;
            private Map<String, Object> _templateAndMatrixParameterValues;

            private DoGetJson(com.sun.jersey.api.client.Client client, UriBuilder uriBuilder, Map<String, Object> map) {
                _client = client;
                _uriBuilder = uriBuilder.clone();
                _templateAndMatrixParameterValues = map;
            }

            /**
             * Create new instance using existing Client instance, and a base URI and any parameters
             * 
             */
            public DoGetJson(com.sun.jersey.api.client.Client client, URI baseUri) {
                _client = client;
                _uriBuilder = UriBuilder.fromUri(baseUri);
                _uriBuilder = _uriBuilder.path("do.get.json");
                _templateAndMatrixParameterValues = new HashMap<String, Object>();
            }

            public GroupDTO getAsGroupDTO() {
                UriBuilder localUriBuilder = _uriBuilder.clone();
                com.sun.jersey.api.client.WebResource resource = _client.resource(localUriBuilder.buildFromMap(_templateAndMatrixParameterValues));
                com.sun.jersey.api.client.WebResource.Builder resourceBuilder = resource.getRequestBuilder();
                resourceBuilder = resourceBuilder.accept("application/json");
                com.sun.jersey.api.client.ClientResponse response;
                response = resourceBuilder.method("GET", com.sun.jersey.api.client.ClientResponse.class);
                if (response.getStatus()>= 400) {
                    throw new RestService.WebApplicationExceptionMessage(Response.status(response.getClientResponseStatus()).build());
                }
                return response.getEntity(GroupDTO.class);
            }

            public<T >T getAsJson(com.sun.jersey.api.client.GenericType<T> returnType) {
                UriBuilder localUriBuilder = _uriBuilder.clone();
                com.sun.jersey.api.client.WebResource resource = _client.resource(localUriBuilder.buildFromMap(_templateAndMatrixParameterValues));
                com.sun.jersey.api.client.WebResource.Builder resourceBuilder = resource.getRequestBuilder();
                resourceBuilder = resourceBuilder.accept("application/json");
                com.sun.jersey.api.client.ClientResponse response;
                response = resourceBuilder.method("GET", com.sun.jersey.api.client.ClientResponse.class);
                if (response.getStatus()>= 400) {
                    throw new RestService.WebApplicationExceptionMessage(Response.status(response.getClientResponseStatus()).build());
                }
                return response.getEntity(returnType);
            }

            public<T >T getAsJson(Class<T> returnType) {
                UriBuilder localUriBuilder = _uriBuilder.clone();
                com.sun.jersey.api.client.WebResource resource = _client.resource(localUriBuilder.buildFromMap(_templateAndMatrixParameterValues));
                com.sun.jersey.api.client.WebResource.Builder resourceBuilder = resource.getRequestBuilder();
                resourceBuilder = resourceBuilder.accept("application/json");
                com.sun.jersey.api.client.ClientResponse response;
                response = resourceBuilder.method("GET", com.sun.jersey.api.client.ClientResponse.class);
                if (!com.sun.jersey.api.client.ClientResponse.class.isAssignableFrom(returnType)) {
                    if (response.getStatus()>= 400) {
                        throw new RestService.WebApplicationExceptionMessage(Response.status(response.getClientResponseStatus()).build());
                    }
                }
                if (!com.sun.jersey.api.client.ClientResponse.class.isAssignableFrom(returnType)) {
                    return response.getEntity(returnType);
                } else {
                    return returnType.cast(response);
                }
            }

            public GroupDTO getAsGroupDTO(Integer id) {
                UriBuilder localUriBuilder = _uriBuilder.clone();
                if (id == null) {
                }
                if (id!= null) {
                    localUriBuilder = localUriBuilder.replaceQueryParam("id", id);
                } else {
                    localUriBuilder = localUriBuilder.replaceQueryParam("id", ((Object[]) null));
                }
                com.sun.jersey.api.client.WebResource resource = _client.resource(localUriBuilder.buildFromMap(_templateAndMatrixParameterValues));
                com.sun.jersey.api.client.WebResource.Builder resourceBuilder = resource.getRequestBuilder();
                resourceBuilder = resourceBuilder.accept("application/json");
                com.sun.jersey.api.client.ClientResponse response;
                response = resourceBuilder.method("GET", com.sun.jersey.api.client.ClientResponse.class);
                if (response.getStatus()>= 400) {
                    throw new RestService.WebApplicationExceptionMessage(Response.status(response.getClientResponseStatus()).build());
                }
                return response.getEntity(GroupDTO.class);
            }

            public<T >T getAsJson(Integer id, com.sun.jersey.api.client.GenericType<T> returnType) {
                UriBuilder localUriBuilder = _uriBuilder.clone();
                if (id == null) {
                }
                if (id!= null) {
                    localUriBuilder = localUriBuilder.replaceQueryParam("id", id);
                } else {
                    localUriBuilder = localUriBuilder.replaceQueryParam("id", ((Object[]) null));
                }
                com.sun.jersey.api.client.WebResource resource = _client.resource(localUriBuilder.buildFromMap(_templateAndMatrixParameterValues));
                com.sun.jersey.api.client.WebResource.Builder resourceBuilder = resource.getRequestBuilder();
                resourceBuilder = resourceBuilder.accept("application/json");
                com.sun.jersey.api.client.ClientResponse response;
                response = resourceBuilder.method("GET", com.sun.jersey.api.client.ClientResponse.class);
                if (response.getStatus()>= 400) {
                    throw new RestService.WebApplicationExceptionMessage(Response.status(response.getClientResponseStatus()).build());
                }
                return response.getEntity(returnType);
            }

            public<T >T getAsJson(Integer id, Class<T> returnType) {
                UriBuilder localUriBuilder = _uriBuilder.clone();
                if (id == null) {
                }
                if (id!= null) {
                    localUriBuilder = localUriBuilder.replaceQueryParam("id", id);
                } else {
                    localUriBuilder = localUriBuilder.replaceQueryParam("id", ((Object[]) null));
                }
                com.sun.jersey.api.client.WebResource resource = _client.resource(localUriBuilder.buildFromMap(_templateAndMatrixParameterValues));
                com.sun.jersey.api.client.WebResource.Builder resourceBuilder = resource.getRequestBuilder();
                resourceBuilder = resourceBuilder.accept("application/json");
                com.sun.jersey.api.client.ClientResponse response;
                response = resourceBuilder.method("GET", com.sun.jersey.api.client.ClientResponse.class);
                if (!com.sun.jersey.api.client.ClientResponse.class.isAssignableFrom(returnType)) {
                    if (response.getStatus()>= 400) {
                        throw new RestService.WebApplicationExceptionMessage(Response.status(response.getClientResponseStatus()).build());
                    }
                }
                if (!com.sun.jersey.api.client.ClientResponse.class.isAssignableFrom(returnType)) {
                    return response.getEntity(returnType);
                } else {
                    return returnType.cast(response);
                }
            }

        }

        public static class DoListJson {

            private com.sun.jersey.api.client.Client _client;
            private UriBuilder _uriBuilder;
            private Map<String, Object> _templateAndMatrixParameterValues;

            private DoListJson(com.sun.jersey.api.client.Client client, UriBuilder uriBuilder, Map<String, Object> map) {
                _client = client;
                _uriBuilder = uriBuilder.clone();
                _templateAndMatrixParameterValues = map;
            }

            /**
             * Create new instance using existing Client instance, and a base URI and any parameters
             * 
             */
            public DoListJson(com.sun.jersey.api.client.Client client, URI baseUri) {
                _client = client;
                _uriBuilder = UriBuilder.fromUri(baseUri);
                _uriBuilder = _uriBuilder.path("do.list.json");
                _templateAndMatrixParameterValues = new HashMap<String, Object>();
            }

            public ListDTO getAsListDTO() {
                UriBuilder localUriBuilder = _uriBuilder.clone();
                com.sun.jersey.api.client.WebResource resource = _client.resource(localUriBuilder.buildFromMap(_templateAndMatrixParameterValues));
                com.sun.jersey.api.client.WebResource.Builder resourceBuilder = resource.getRequestBuilder();
                resourceBuilder = resourceBuilder.accept("application/json");
                com.sun.jersey.api.client.ClientResponse response;
                response = resourceBuilder.method("GET", com.sun.jersey.api.client.ClientResponse.class);
                if (response.getStatus()>= 400) {
                    throw new RestService.WebApplicationExceptionMessage(Response.status(response.getClientResponseStatus()).build());
                }
                return response.getEntity(ListDTO.class);
            }

            public<T >T getAsJson(com.sun.jersey.api.client.GenericType<T> returnType) {
                UriBuilder localUriBuilder = _uriBuilder.clone();
                com.sun.jersey.api.client.WebResource resource = _client.resource(localUriBuilder.buildFromMap(_templateAndMatrixParameterValues));
                com.sun.jersey.api.client.WebResource.Builder resourceBuilder = resource.getRequestBuilder();
                resourceBuilder = resourceBuilder.accept("application/json");
                com.sun.jersey.api.client.ClientResponse response;
                response = resourceBuilder.method("GET", com.sun.jersey.api.client.ClientResponse.class);
                if (response.getStatus()>= 400) {
                    throw new RestService.WebApplicationExceptionMessage(Response.status(response.getClientResponseStatus()).build());
                }
                return response.getEntity(returnType);
            }

            public<T >T getAsJson(Class<T> returnType) {
                UriBuilder localUriBuilder = _uriBuilder.clone();
                com.sun.jersey.api.client.WebResource resource = _client.resource(localUriBuilder.buildFromMap(_templateAndMatrixParameterValues));
                com.sun.jersey.api.client.WebResource.Builder resourceBuilder = resource.getRequestBuilder();
                resourceBuilder = resourceBuilder.accept("application/json");
                com.sun.jersey.api.client.ClientResponse response;
                response = resourceBuilder.method("GET", com.sun.jersey.api.client.ClientResponse.class);
                if (!com.sun.jersey.api.client.ClientResponse.class.isAssignableFrom(returnType)) {
                    if (response.getStatus()>= 400) {
                        throw new RestService.WebApplicationExceptionMessage(Response.status(response.getClientResponseStatus()).build());
                    }
                }
                if (!com.sun.jersey.api.client.ClientResponse.class.isAssignableFrom(returnType)) {
                    return response.getEntity(returnType);
                } else {
                    return returnType.cast(response);
                }
            }

            public ListDTO getAsListDTO(Boolean all, Integer page, Integer perpage) {
                UriBuilder localUriBuilder = _uriBuilder.clone();
                if (all == null) {
                }
                if (all!= null) {
                    localUriBuilder = localUriBuilder.replaceQueryParam("all", all);
                } else {
                    localUriBuilder = localUriBuilder.replaceQueryParam("all", ((Object[]) null));
                }
                if (page == null) {
                }
                if (page!= null) {
                    localUriBuilder = localUriBuilder.replaceQueryParam("page", page);
                } else {
                    localUriBuilder = localUriBuilder.replaceQueryParam("page", ((Object[]) null));
                }
                if (perpage == null) {
                }
                if (perpage!= null) {
                    localUriBuilder = localUriBuilder.replaceQueryParam("perpage", perpage);
                } else {
                    localUriBuilder = localUriBuilder.replaceQueryParam("perpage", ((Object[]) null));
                }
                com.sun.jersey.api.client.WebResource resource = _client.resource(localUriBuilder.buildFromMap(_templateAndMatrixParameterValues));
                com.sun.jersey.api.client.WebResource.Builder resourceBuilder = resource.getRequestBuilder();
                resourceBuilder = resourceBuilder.accept("application/json");
                com.sun.jersey.api.client.ClientResponse response;
                response = resourceBuilder.method("GET", com.sun.jersey.api.client.ClientResponse.class);
                if (response.getStatus()>= 400) {
                    throw new RestService.WebApplicationExceptionMessage(Response.status(response.getClientResponseStatus()).build());
                }
                return response.getEntity(ListDTO.class);
            }

            public<T >T getAsJson(Boolean all, Integer page, Integer perpage, com.sun.jersey.api.client.GenericType<T> returnType) {
                UriBuilder localUriBuilder = _uriBuilder.clone();
                if (all == null) {
                }
                if (all!= null) {
                    localUriBuilder = localUriBuilder.replaceQueryParam("all", all);
                } else {
                    localUriBuilder = localUriBuilder.replaceQueryParam("all", ((Object[]) null));
                }
                if (page == null) {
                }
                if (page!= null) {
                    localUriBuilder = localUriBuilder.replaceQueryParam("page", page);
                } else {
                    localUriBuilder = localUriBuilder.replaceQueryParam("page", ((Object[]) null));
                }
                if (perpage == null) {
                }
                if (perpage!= null) {
                    localUriBuilder = localUriBuilder.replaceQueryParam("perpage", perpage);
                } else {
                    localUriBuilder = localUriBuilder.replaceQueryParam("perpage", ((Object[]) null));
                }
                com.sun.jersey.api.client.WebResource resource = _client.resource(localUriBuilder.buildFromMap(_templateAndMatrixParameterValues));
                com.sun.jersey.api.client.WebResource.Builder resourceBuilder = resource.getRequestBuilder();
                resourceBuilder = resourceBuilder.accept("application/json");
                com.sun.jersey.api.client.ClientResponse response;
                response = resourceBuilder.method("GET", com.sun.jersey.api.client.ClientResponse.class);
                if (response.getStatus()>= 400) {
                    throw new RestService.WebApplicationExceptionMessage(Response.status(response.getClientResponseStatus()).build());
                }
                return response.getEntity(returnType);
            }

            public<T >T getAsJson(Boolean all, Integer page, Integer perpage, Class<T> returnType) {
                UriBuilder localUriBuilder = _uriBuilder.clone();
                if (all == null) {
                }
                if (all!= null) {
                    localUriBuilder = localUriBuilder.replaceQueryParam("all", all);
                } else {
                    localUriBuilder = localUriBuilder.replaceQueryParam("all", ((Object[]) null));
                }
                if (page == null) {
                }
                if (page!= null) {
                    localUriBuilder = localUriBuilder.replaceQueryParam("page", page);
                } else {
                    localUriBuilder = localUriBuilder.replaceQueryParam("page", ((Object[]) null));
                }
                if (perpage == null) {
                }
                if (perpage!= null) {
                    localUriBuilder = localUriBuilder.replaceQueryParam("perpage", perpage);
                } else {
                    localUriBuilder = localUriBuilder.replaceQueryParam("perpage", ((Object[]) null));
                }
                com.sun.jersey.api.client.WebResource resource = _client.resource(localUriBuilder.buildFromMap(_templateAndMatrixParameterValues));
                com.sun.jersey.api.client.WebResource.Builder resourceBuilder = resource.getRequestBuilder();
                resourceBuilder = resourceBuilder.accept("application/json");
                com.sun.jersey.api.client.ClientResponse response;
                response = resourceBuilder.method("GET", com.sun.jersey.api.client.ClientResponse.class);
                if (!com.sun.jersey.api.client.ClientResponse.class.isAssignableFrom(returnType)) {
                    if (response.getStatus()>= 400) {
                        throw new RestService.WebApplicationExceptionMessage(Response.status(response.getClientResponseStatus()).build());
                    }
                }
                if (!com.sun.jersey.api.client.ClientResponse.class.isAssignableFrom(returnType)) {
                    return response.getEntity(returnType);
                } else {
                    return returnType.cast(response);
                }
            }

        }

        public static class DoUpdateJson {

            private com.sun.jersey.api.client.Client _client;
            private UriBuilder _uriBuilder;
            private Map<String, Object> _templateAndMatrixParameterValues;

            private DoUpdateJson(com.sun.jersey.api.client.Client client, UriBuilder uriBuilder, Map<String, Object> map) {
                _client = client;
                _uriBuilder = uriBuilder.clone();
                _templateAndMatrixParameterValues = map;
            }

            /**
             * Create new instance using existing Client instance, and a base URI and any parameters
             * 
             */
            public DoUpdateJson(com.sun.jersey.api.client.Client client, URI baseUri) {
                _client = client;
                _uriBuilder = UriBuilder.fromUri(baseUri);
                _uriBuilder = _uriBuilder.path("do.update.json");
                _templateAndMatrixParameterValues = new HashMap<String, Object>();
            }

            public SimpleDataDTO postAsSimpleDataDTO() {
                UriBuilder localUriBuilder = _uriBuilder.clone();
                com.sun.jersey.api.client.WebResource resource = _client.resource(localUriBuilder.buildFromMap(_templateAndMatrixParameterValues));
                com.sun.jersey.api.client.WebResource.Builder resourceBuilder = resource.getRequestBuilder();
                resourceBuilder = resourceBuilder.accept("application/json");
                com.sun.jersey.api.client.ClientResponse response;
                response = resourceBuilder.method("POST", com.sun.jersey.api.client.ClientResponse.class);
                if (response.getStatus()>= 400) {
                    throw new RestService.WebApplicationExceptionMessage(Response.status(response.getClientResponseStatus()).build());
                }
                return response.getEntity(SimpleDataDTO.class);
            }

            public<T >T postAsJson(com.sun.jersey.api.client.GenericType<T> returnType) {
                UriBuilder localUriBuilder = _uriBuilder.clone();
                com.sun.jersey.api.client.WebResource resource = _client.resource(localUriBuilder.buildFromMap(_templateAndMatrixParameterValues));
                com.sun.jersey.api.client.WebResource.Builder resourceBuilder = resource.getRequestBuilder();
                resourceBuilder = resourceBuilder.accept("application/json");
                com.sun.jersey.api.client.ClientResponse response;
                response = resourceBuilder.method("POST", com.sun.jersey.api.client.ClientResponse.class);
                if (response.getStatus()>= 400) {
                    throw new RestService.WebApplicationExceptionMessage(Response.status(response.getClientResponseStatus()).build());
                }
                return response.getEntity(returnType);
            }

            public<T >T postAsJson(Class<T> returnType) {
                UriBuilder localUriBuilder = _uriBuilder.clone();
                com.sun.jersey.api.client.WebResource resource = _client.resource(localUriBuilder.buildFromMap(_templateAndMatrixParameterValues));
                com.sun.jersey.api.client.WebResource.Builder resourceBuilder = resource.getRequestBuilder();
                resourceBuilder = resourceBuilder.accept("application/json");
                com.sun.jersey.api.client.ClientResponse response;
                response = resourceBuilder.method("POST", com.sun.jersey.api.client.ClientResponse.class);
                if (!com.sun.jersey.api.client.ClientResponse.class.isAssignableFrom(returnType)) {
                    if (response.getStatus()>= 400) {
                        throw new RestService.WebApplicationExceptionMessage(Response.status(response.getClientResponseStatus()).build());
                    }
                }
                if (!com.sun.jersey.api.client.ClientResponse.class.isAssignableFrom(returnType)) {
                    return response.getEntity(returnType);
                } else {
                    return returnType.cast(response);
                }
            }

        }

    }

    public static class Login {

        private com.sun.jersey.api.client.Client _client;
        private UriBuilder _uriBuilder;
        private Map<String, Object> _templateAndMatrixParameterValues;

        private Login(com.sun.jersey.api.client.Client client, UriBuilder uriBuilder, Map<String, Object> map) {
            _client = client;
            _uriBuilder = uriBuilder.clone();
            _templateAndMatrixParameterValues = map;
        }

        /**
         * Create new instance using existing Client instance, and a base URI and any parameters
         * 
         */
        public Login(com.sun.jersey.api.client.Client client, URI baseUri) {
            _client = client;
            _uriBuilder = UriBuilder.fromUri(baseUri);
            _uriBuilder = _uriBuilder.path("/login/");
            _templateAndMatrixParameterValues = new HashMap<String, Object>();
        }

        public RestService.Login.DoLoginJson doLoginJson() {
            return new RestService.Login.DoLoginJson(_client, _uriBuilder.buildFromMap(_templateAndMatrixParameterValues));
        }

        public RestService.Login.DoGetJson doGetJson() {
            return new RestService.Login.DoGetJson(_client, _uriBuilder.buildFromMap(_templateAndMatrixParameterValues));
        }

        public RestService.Login.DoDeleteJson doDeleteJson() {
            return new RestService.Login.DoDeleteJson(_client, _uriBuilder.buildFromMap(_templateAndMatrixParameterValues));
        }

        public RestService.Login.DoListJson doListJson() {
            return new RestService.Login.DoListJson(_client, _uriBuilder.buildFromMap(_templateAndMatrixParameterValues));
        }

        public static class DoDeleteJson {

            private com.sun.jersey.api.client.Client _client;
            private UriBuilder _uriBuilder;
            private Map<String, Object> _templateAndMatrixParameterValues;

            private DoDeleteJson(com.sun.jersey.api.client.Client client, UriBuilder uriBuilder, Map<String, Object> map) {
                _client = client;
                _uriBuilder = uriBuilder.clone();
                _templateAndMatrixParameterValues = map;
            }

            /**
             * Create new instance using existing Client instance, and a base URI and any parameters
             * 
             */
            public DoDeleteJson(com.sun.jersey.api.client.Client client, URI baseUri) {
                _client = client;
                _uriBuilder = UriBuilder.fromUri(baseUri);
                _uriBuilder = _uriBuilder.path("do.delete.json");
                _templateAndMatrixParameterValues = new HashMap<String, Object>();
            }

            public SimpleDataDTO getAsSimpleDataDTO() {
                UriBuilder localUriBuilder = _uriBuilder.clone();
                com.sun.jersey.api.client.WebResource resource = _client.resource(localUriBuilder.buildFromMap(_templateAndMatrixParameterValues));
                com.sun.jersey.api.client.WebResource.Builder resourceBuilder = resource.getRequestBuilder();
                resourceBuilder = resourceBuilder.accept("application/json");
                com.sun.jersey.api.client.ClientResponse response;
                response = resourceBuilder.method("GET", com.sun.jersey.api.client.ClientResponse.class);
                if (response.getStatus()>= 400) {
                    throw new RestService.WebApplicationExceptionMessage(Response.status(response.getClientResponseStatus()).build());
                }
                return response.getEntity(SimpleDataDTO.class);
            }

            public<T >T getAsJson(com.sun.jersey.api.client.GenericType<T> returnType) {
                UriBuilder localUriBuilder = _uriBuilder.clone();
                com.sun.jersey.api.client.WebResource resource = _client.resource(localUriBuilder.buildFromMap(_templateAndMatrixParameterValues));
                com.sun.jersey.api.client.WebResource.Builder resourceBuilder = resource.getRequestBuilder();
                resourceBuilder = resourceBuilder.accept("application/json");
                com.sun.jersey.api.client.ClientResponse response;
                response = resourceBuilder.method("GET", com.sun.jersey.api.client.ClientResponse.class);
                if (response.getStatus()>= 400) {
                    throw new RestService.WebApplicationExceptionMessage(Response.status(response.getClientResponseStatus()).build());
                }
                return response.getEntity(returnType);
            }

            public<T >T getAsJson(Class<T> returnType) {
                UriBuilder localUriBuilder = _uriBuilder.clone();
                com.sun.jersey.api.client.WebResource resource = _client.resource(localUriBuilder.buildFromMap(_templateAndMatrixParameterValues));
                com.sun.jersey.api.client.WebResource.Builder resourceBuilder = resource.getRequestBuilder();
                resourceBuilder = resourceBuilder.accept("application/json");
                com.sun.jersey.api.client.ClientResponse response;
                response = resourceBuilder.method("GET", com.sun.jersey.api.client.ClientResponse.class);
                if (!com.sun.jersey.api.client.ClientResponse.class.isAssignableFrom(returnType)) {
                    if (response.getStatus()>= 400) {
                        throw new RestService.WebApplicationExceptionMessage(Response.status(response.getClientResponseStatus()).build());
                    }
                }
                if (!com.sun.jersey.api.client.ClientResponse.class.isAssignableFrom(returnType)) {
                    return response.getEntity(returnType);
                } else {
                    return returnType.cast(response);
                }
            }

            public SimpleDataDTO getAsSimpleDataDTO(Integer id) {
                UriBuilder localUriBuilder = _uriBuilder.clone();
                if (id == null) {
                }
                if (id!= null) {
                    localUriBuilder = localUriBuilder.replaceQueryParam("id", id);
                } else {
                    localUriBuilder = localUriBuilder.replaceQueryParam("id", ((Object[]) null));
                }
                com.sun.jersey.api.client.WebResource resource = _client.resource(localUriBuilder.buildFromMap(_templateAndMatrixParameterValues));
                com.sun.jersey.api.client.WebResource.Builder resourceBuilder = resource.getRequestBuilder();
                resourceBuilder = resourceBuilder.accept("application/json");
                com.sun.jersey.api.client.ClientResponse response;
                response = resourceBuilder.method("GET", com.sun.jersey.api.client.ClientResponse.class);
                if (response.getStatus()>= 400) {
                    throw new RestService.WebApplicationExceptionMessage(Response.status(response.getClientResponseStatus()).build());
                }
                return response.getEntity(SimpleDataDTO.class);
            }

            public<T >T getAsJson(Integer id, com.sun.jersey.api.client.GenericType<T> returnType) {
                UriBuilder localUriBuilder = _uriBuilder.clone();
                if (id == null) {
                }
                if (id!= null) {
                    localUriBuilder = localUriBuilder.replaceQueryParam("id", id);
                } else {
                    localUriBuilder = localUriBuilder.replaceQueryParam("id", ((Object[]) null));
                }
                com.sun.jersey.api.client.WebResource resource = _client.resource(localUriBuilder.buildFromMap(_templateAndMatrixParameterValues));
                com.sun.jersey.api.client.WebResource.Builder resourceBuilder = resource.getRequestBuilder();
                resourceBuilder = resourceBuilder.accept("application/json");
                com.sun.jersey.api.client.ClientResponse response;
                response = resourceBuilder.method("GET", com.sun.jersey.api.client.ClientResponse.class);
                if (response.getStatus()>= 400) {
                    throw new RestService.WebApplicationExceptionMessage(Response.status(response.getClientResponseStatus()).build());
                }
                return response.getEntity(returnType);
            }

            public<T >T getAsJson(Integer id, Class<T> returnType) {
                UriBuilder localUriBuilder = _uriBuilder.clone();
                if (id == null) {
                }
                if (id!= null) {
                    localUriBuilder = localUriBuilder.replaceQueryParam("id", id);
                } else {
                    localUriBuilder = localUriBuilder.replaceQueryParam("id", ((Object[]) null));
                }
                com.sun.jersey.api.client.WebResource resource = _client.resource(localUriBuilder.buildFromMap(_templateAndMatrixParameterValues));
                com.sun.jersey.api.client.WebResource.Builder resourceBuilder = resource.getRequestBuilder();
                resourceBuilder = resourceBuilder.accept("application/json");
                com.sun.jersey.api.client.ClientResponse response;
                response = resourceBuilder.method("GET", com.sun.jersey.api.client.ClientResponse.class);
                if (!com.sun.jersey.api.client.ClientResponse.class.isAssignableFrom(returnType)) {
                    if (response.getStatus()>= 400) {
                        throw new RestService.WebApplicationExceptionMessage(Response.status(response.getClientResponseStatus()).build());
                    }
                }
                if (!com.sun.jersey.api.client.ClientResponse.class.isAssignableFrom(returnType)) {
                    return response.getEntity(returnType);
                } else {
                    return returnType.cast(response);
                }
            }

        }

        public static class DoGetJson {

            private com.sun.jersey.api.client.Client _client;
            private UriBuilder _uriBuilder;
            private Map<String, Object> _templateAndMatrixParameterValues;

            private DoGetJson(com.sun.jersey.api.client.Client client, UriBuilder uriBuilder, Map<String, Object> map) {
                _client = client;
                _uriBuilder = uriBuilder.clone();
                _templateAndMatrixParameterValues = map;
            }

            /**
             * Create new instance using existing Client instance, and a base URI and any parameters
             * 
             */
            public DoGetJson(com.sun.jersey.api.client.Client client, URI baseUri) {
                _client = client;
                _uriBuilder = UriBuilder.fromUri(baseUri);
                _uriBuilder = _uriBuilder.path("do.get.json");
                _templateAndMatrixParameterValues = new HashMap<String, Object>();
            }

            public UserDTO getAsUserDTO() {
                UriBuilder localUriBuilder = _uriBuilder.clone();
                com.sun.jersey.api.client.WebResource resource = _client.resource(localUriBuilder.buildFromMap(_templateAndMatrixParameterValues));
                com.sun.jersey.api.client.WebResource.Builder resourceBuilder = resource.getRequestBuilder();
                resourceBuilder = resourceBuilder.accept("application/json");
                com.sun.jersey.api.client.ClientResponse response;
                response = resourceBuilder.method("GET", com.sun.jersey.api.client.ClientResponse.class);
                if (response.getStatus()>= 400) {
                    throw new RestService.WebApplicationExceptionMessage(Response.status(response.getClientResponseStatus()).build());
                }
                return response.getEntity(UserDTO.class);
            }

            public<T >T getAsJson(com.sun.jersey.api.client.GenericType<T> returnType) {
                UriBuilder localUriBuilder = _uriBuilder.clone();
                com.sun.jersey.api.client.WebResource resource = _client.resource(localUriBuilder.buildFromMap(_templateAndMatrixParameterValues));
                com.sun.jersey.api.client.WebResource.Builder resourceBuilder = resource.getRequestBuilder();
                resourceBuilder = resourceBuilder.accept("application/json");
                com.sun.jersey.api.client.ClientResponse response;
                response = resourceBuilder.method("GET", com.sun.jersey.api.client.ClientResponse.class);
                if (response.getStatus()>= 400) {
                    throw new RestService.WebApplicationExceptionMessage(Response.status(response.getClientResponseStatus()).build());
                }
                return response.getEntity(returnType);
            }

            public<T >T getAsJson(Class<T> returnType) {
                UriBuilder localUriBuilder = _uriBuilder.clone();
                com.sun.jersey.api.client.WebResource resource = _client.resource(localUriBuilder.buildFromMap(_templateAndMatrixParameterValues));
                com.sun.jersey.api.client.WebResource.Builder resourceBuilder = resource.getRequestBuilder();
                resourceBuilder = resourceBuilder.accept("application/json");
                com.sun.jersey.api.client.ClientResponse response;
                response = resourceBuilder.method("GET", com.sun.jersey.api.client.ClientResponse.class);
                if (!com.sun.jersey.api.client.ClientResponse.class.isAssignableFrom(returnType)) {
                    if (response.getStatus()>= 400) {
                        throw new RestService.WebApplicationExceptionMessage(Response.status(response.getClientResponseStatus()).build());
                    }
                }
                if (!com.sun.jersey.api.client.ClientResponse.class.isAssignableFrom(returnType)) {
                    return response.getEntity(returnType);
                } else {
                    return returnType.cast(response);
                }
            }

            public UserDTO getAsUserDTO(Integer id) {
                UriBuilder localUriBuilder = _uriBuilder.clone();
                if (id == null) {
                }
                if (id!= null) {
                    localUriBuilder = localUriBuilder.replaceQueryParam("id", id);
                } else {
                    localUriBuilder = localUriBuilder.replaceQueryParam("id", ((Object[]) null));
                }
                com.sun.jersey.api.client.WebResource resource = _client.resource(localUriBuilder.buildFromMap(_templateAndMatrixParameterValues));
                com.sun.jersey.api.client.WebResource.Builder resourceBuilder = resource.getRequestBuilder();
                resourceBuilder = resourceBuilder.accept("application/json");
                com.sun.jersey.api.client.ClientResponse response;
                response = resourceBuilder.method("GET", com.sun.jersey.api.client.ClientResponse.class);
                if (response.getStatus()>= 400) {
                    throw new RestService.WebApplicationExceptionMessage(Response.status(response.getClientResponseStatus()).build());
                }
                return response.getEntity(UserDTO.class);
            }

            public<T >T getAsJson(Integer id, com.sun.jersey.api.client.GenericType<T> returnType) {
                UriBuilder localUriBuilder = _uriBuilder.clone();
                if (id == null) {
                }
                if (id!= null) {
                    localUriBuilder = localUriBuilder.replaceQueryParam("id", id);
                } else {
                    localUriBuilder = localUriBuilder.replaceQueryParam("id", ((Object[]) null));
                }
                com.sun.jersey.api.client.WebResource resource = _client.resource(localUriBuilder.buildFromMap(_templateAndMatrixParameterValues));
                com.sun.jersey.api.client.WebResource.Builder resourceBuilder = resource.getRequestBuilder();
                resourceBuilder = resourceBuilder.accept("application/json");
                com.sun.jersey.api.client.ClientResponse response;
                response = resourceBuilder.method("GET", com.sun.jersey.api.client.ClientResponse.class);
                if (response.getStatus()>= 400) {
                    throw new RestService.WebApplicationExceptionMessage(Response.status(response.getClientResponseStatus()).build());
                }
                return response.getEntity(returnType);
            }

            public<T >T getAsJson(Integer id, Class<T> returnType) {
                UriBuilder localUriBuilder = _uriBuilder.clone();
                if (id == null) {
                }
                if (id!= null) {
                    localUriBuilder = localUriBuilder.replaceQueryParam("id", id);
                } else {
                    localUriBuilder = localUriBuilder.replaceQueryParam("id", ((Object[]) null));
                }
                com.sun.jersey.api.client.WebResource resource = _client.resource(localUriBuilder.buildFromMap(_templateAndMatrixParameterValues));
                com.sun.jersey.api.client.WebResource.Builder resourceBuilder = resource.getRequestBuilder();
                resourceBuilder = resourceBuilder.accept("application/json");
                com.sun.jersey.api.client.ClientResponse response;
                response = resourceBuilder.method("GET", com.sun.jersey.api.client.ClientResponse.class);
                if (!com.sun.jersey.api.client.ClientResponse.class.isAssignableFrom(returnType)) {
                    if (response.getStatus()>= 400) {
                        throw new RestService.WebApplicationExceptionMessage(Response.status(response.getClientResponseStatus()).build());
                    }
                }
                if (!com.sun.jersey.api.client.ClientResponse.class.isAssignableFrom(returnType)) {
                    return response.getEntity(returnType);
                } else {
                    return returnType.cast(response);
                }
            }

        }

        public static class DoListJson {

            private com.sun.jersey.api.client.Client _client;
            private UriBuilder _uriBuilder;
            private Map<String, Object> _templateAndMatrixParameterValues;

            private DoListJson(com.sun.jersey.api.client.Client client, UriBuilder uriBuilder, Map<String, Object> map) {
                _client = client;
                _uriBuilder = uriBuilder.clone();
                _templateAndMatrixParameterValues = map;
            }

            /**
             * Create new instance using existing Client instance, and a base URI and any parameters
             * 
             */
            public DoListJson(com.sun.jersey.api.client.Client client, URI baseUri) {
                _client = client;
                _uriBuilder = UriBuilder.fromUri(baseUri);
                _uriBuilder = _uriBuilder.path("do.list.json");
                _templateAndMatrixParameterValues = new HashMap<String, Object>();
            }

            public ListDTO getAsListDTO() {
                UriBuilder localUriBuilder = _uriBuilder.clone();
                com.sun.jersey.api.client.WebResource resource = _client.resource(localUriBuilder.buildFromMap(_templateAndMatrixParameterValues));
                com.sun.jersey.api.client.WebResource.Builder resourceBuilder = resource.getRequestBuilder();
                resourceBuilder = resourceBuilder.accept("application/json");
                com.sun.jersey.api.client.ClientResponse response;
                response = resourceBuilder.method("GET", com.sun.jersey.api.client.ClientResponse.class);
                if (response.getStatus()>= 400) {
                    throw new RestService.WebApplicationExceptionMessage(Response.status(response.getClientResponseStatus()).build());
                }
                return response.getEntity(ListDTO.class);
            }

            public<T >T getAsJson(com.sun.jersey.api.client.GenericType<T> returnType) {
                UriBuilder localUriBuilder = _uriBuilder.clone();
                com.sun.jersey.api.client.WebResource resource = _client.resource(localUriBuilder.buildFromMap(_templateAndMatrixParameterValues));
                com.sun.jersey.api.client.WebResource.Builder resourceBuilder = resource.getRequestBuilder();
                resourceBuilder = resourceBuilder.accept("application/json");
                com.sun.jersey.api.client.ClientResponse response;
                response = resourceBuilder.method("GET", com.sun.jersey.api.client.ClientResponse.class);
                if (response.getStatus()>= 400) {
                    throw new RestService.WebApplicationExceptionMessage(Response.status(response.getClientResponseStatus()).build());
                }
                return response.getEntity(returnType);
            }

            public<T >T getAsJson(Class<T> returnType) {
                UriBuilder localUriBuilder = _uriBuilder.clone();
                com.sun.jersey.api.client.WebResource resource = _client.resource(localUriBuilder.buildFromMap(_templateAndMatrixParameterValues));
                com.sun.jersey.api.client.WebResource.Builder resourceBuilder = resource.getRequestBuilder();
                resourceBuilder = resourceBuilder.accept("application/json");
                com.sun.jersey.api.client.ClientResponse response;
                response = resourceBuilder.method("GET", com.sun.jersey.api.client.ClientResponse.class);
                if (!com.sun.jersey.api.client.ClientResponse.class.isAssignableFrom(returnType)) {
                    if (response.getStatus()>= 400) {
                        throw new RestService.WebApplicationExceptionMessage(Response.status(response.getClientResponseStatus()).build());
                    }
                }
                if (!com.sun.jersey.api.client.ClientResponse.class.isAssignableFrom(returnType)) {
                    return response.getEntity(returnType);
                } else {
                    return returnType.cast(response);
                }
            }

            public ListDTO getAsListDTO(Boolean all, Integer page, Integer perpage) {
                UriBuilder localUriBuilder = _uriBuilder.clone();
                if (all == null) {
                }
                if (all!= null) {
                    localUriBuilder = localUriBuilder.replaceQueryParam("all", all);
                } else {
                    localUriBuilder = localUriBuilder.replaceQueryParam("all", ((Object[]) null));
                }
                if (page == null) {
                }
                if (page!= null) {
                    localUriBuilder = localUriBuilder.replaceQueryParam("page", page);
                } else {
                    localUriBuilder = localUriBuilder.replaceQueryParam("page", ((Object[]) null));
                }
                if (perpage == null) {
                }
                if (perpage!= null) {
                    localUriBuilder = localUriBuilder.replaceQueryParam("perpage", perpage);
                } else {
                    localUriBuilder = localUriBuilder.replaceQueryParam("perpage", ((Object[]) null));
                }
                com.sun.jersey.api.client.WebResource resource = _client.resource(localUriBuilder.buildFromMap(_templateAndMatrixParameterValues));
                com.sun.jersey.api.client.WebResource.Builder resourceBuilder = resource.getRequestBuilder();
                resourceBuilder = resourceBuilder.accept("application/json");
                com.sun.jersey.api.client.ClientResponse response;
                response = resourceBuilder.method("GET", com.sun.jersey.api.client.ClientResponse.class);
                if (response.getStatus()>= 400) {
                    throw new RestService.WebApplicationExceptionMessage(Response.status(response.getClientResponseStatus()).build());
                }
                return response.getEntity(ListDTO.class);
            }

            public<T >T getAsJson(Boolean all, Integer page, Integer perpage, com.sun.jersey.api.client.GenericType<T> returnType) {
                UriBuilder localUriBuilder = _uriBuilder.clone();
                if (all == null) {
                }
                if (all!= null) {
                    localUriBuilder = localUriBuilder.replaceQueryParam("all", all);
                } else {
                    localUriBuilder = localUriBuilder.replaceQueryParam("all", ((Object[]) null));
                }
                if (page == null) {
                }
                if (page!= null) {
                    localUriBuilder = localUriBuilder.replaceQueryParam("page", page);
                } else {
                    localUriBuilder = localUriBuilder.replaceQueryParam("page", ((Object[]) null));
                }
                if (perpage == null) {
                }
                if (perpage!= null) {
                    localUriBuilder = localUriBuilder.replaceQueryParam("perpage", perpage);
                } else {
                    localUriBuilder = localUriBuilder.replaceQueryParam("perpage", ((Object[]) null));
                }
                com.sun.jersey.api.client.WebResource resource = _client.resource(localUriBuilder.buildFromMap(_templateAndMatrixParameterValues));
                com.sun.jersey.api.client.WebResource.Builder resourceBuilder = resource.getRequestBuilder();
                resourceBuilder = resourceBuilder.accept("application/json");
                com.sun.jersey.api.client.ClientResponse response;
                response = resourceBuilder.method("GET", com.sun.jersey.api.client.ClientResponse.class);
                if (response.getStatus()>= 400) {
                    throw new RestService.WebApplicationExceptionMessage(Response.status(response.getClientResponseStatus()).build());
                }
                return response.getEntity(returnType);
            }

            public<T >T getAsJson(Boolean all, Integer page, Integer perpage, Class<T> returnType) {
                UriBuilder localUriBuilder = _uriBuilder.clone();
                if (all == null) {
                }
                if (all!= null) {
                    localUriBuilder = localUriBuilder.replaceQueryParam("all", all);
                } else {
                    localUriBuilder = localUriBuilder.replaceQueryParam("all", ((Object[]) null));
                }
                if (page == null) {
                }
                if (page!= null) {
                    localUriBuilder = localUriBuilder.replaceQueryParam("page", page);
                } else {
                    localUriBuilder = localUriBuilder.replaceQueryParam("page", ((Object[]) null));
                }
                if (perpage == null) {
                }
                if (perpage!= null) {
                    localUriBuilder = localUriBuilder.replaceQueryParam("perpage", perpage);
                } else {
                    localUriBuilder = localUriBuilder.replaceQueryParam("perpage", ((Object[]) null));
                }
                com.sun.jersey.api.client.WebResource resource = _client.resource(localUriBuilder.buildFromMap(_templateAndMatrixParameterValues));
                com.sun.jersey.api.client.WebResource.Builder resourceBuilder = resource.getRequestBuilder();
                resourceBuilder = resourceBuilder.accept("application/json");
                com.sun.jersey.api.client.ClientResponse response;
                response = resourceBuilder.method("GET", com.sun.jersey.api.client.ClientResponse.class);
                if (!com.sun.jersey.api.client.ClientResponse.class.isAssignableFrom(returnType)) {
                    if (response.getStatus()>= 400) {
                        throw new RestService.WebApplicationExceptionMessage(Response.status(response.getClientResponseStatus()).build());
                    }
                }
                if (!com.sun.jersey.api.client.ClientResponse.class.isAssignableFrom(returnType)) {
                    return response.getEntity(returnType);
                } else {
                    return returnType.cast(response);
                }
            }

        }

        public static class DoLoginJson {

            private com.sun.jersey.api.client.Client _client;
            private UriBuilder _uriBuilder;
            private Map<String, Object> _templateAndMatrixParameterValues;

            private DoLoginJson(com.sun.jersey.api.client.Client client, UriBuilder uriBuilder, Map<String, Object> map) {
                _client = client;
                _uriBuilder = uriBuilder.clone();
                _templateAndMatrixParameterValues = map;
            }

            /**
             * Create new instance using existing Client instance, and a base URI and any parameters
             * 
             */
            public DoLoginJson(com.sun.jersey.api.client.Client client, URI baseUri) {
                _client = client;
                _uriBuilder = UriBuilder.fromUri(baseUri);
                _uriBuilder = _uriBuilder.path("do.login.json");
                _templateAndMatrixParameterValues = new HashMap<String, Object>();
            }

            public LoginDTO getAsLoginDTO() {
                UriBuilder localUriBuilder = _uriBuilder.clone();
                com.sun.jersey.api.client.WebResource resource = _client.resource(localUriBuilder.buildFromMap(_templateAndMatrixParameterValues));
                com.sun.jersey.api.client.WebResource.Builder resourceBuilder = resource.getRequestBuilder();
                resourceBuilder = resourceBuilder.accept("application/json");
                com.sun.jersey.api.client.ClientResponse response;
                response = resourceBuilder.method("GET", com.sun.jersey.api.client.ClientResponse.class);
                if (response.getStatus()>= 400) {
                    throw new RestService.WebApplicationExceptionMessage(Response.status(response.getClientResponseStatus()).build());
                }
                return response.getEntity(LoginDTO.class);
            }

            public<T >T getAsJson(com.sun.jersey.api.client.GenericType<T> returnType) {
                UriBuilder localUriBuilder = _uriBuilder.clone();
                com.sun.jersey.api.client.WebResource resource = _client.resource(localUriBuilder.buildFromMap(_templateAndMatrixParameterValues));
                com.sun.jersey.api.client.WebResource.Builder resourceBuilder = resource.getRequestBuilder();
                resourceBuilder = resourceBuilder.accept("application/json");
                com.sun.jersey.api.client.ClientResponse response;
                response = resourceBuilder.method("GET", com.sun.jersey.api.client.ClientResponse.class);
                if (response.getStatus()>= 400) {
                    throw new RestService.WebApplicationExceptionMessage(Response.status(response.getClientResponseStatus()).build());
                }
                return response.getEntity(returnType);
            }

            public<T >T getAsJson(Class<T> returnType) {
                UriBuilder localUriBuilder = _uriBuilder.clone();
                com.sun.jersey.api.client.WebResource resource = _client.resource(localUriBuilder.buildFromMap(_templateAndMatrixParameterValues));
                com.sun.jersey.api.client.WebResource.Builder resourceBuilder = resource.getRequestBuilder();
                resourceBuilder = resourceBuilder.accept("application/json");
                com.sun.jersey.api.client.ClientResponse response;
                response = resourceBuilder.method("GET", com.sun.jersey.api.client.ClientResponse.class);
                if (!com.sun.jersey.api.client.ClientResponse.class.isAssignableFrom(returnType)) {
                    if (response.getStatus()>= 400) {
                        throw new RestService.WebApplicationExceptionMessage(Response.status(response.getClientResponseStatus()).build());
                    }
                }
                if (!com.sun.jersey.api.client.ClientResponse.class.isAssignableFrom(returnType)) {
                    return response.getEntity(returnType);
                } else {
                    return returnType.cast(response);
                }
            }

            public LoginDTO getAsLoginDTO(String user, String pass) {
                UriBuilder localUriBuilder = _uriBuilder.clone();
                if (user == null) {
                }
                if (user!= null) {
                    localUriBuilder = localUriBuilder.replaceQueryParam("user", user);
                } else {
                    localUriBuilder = localUriBuilder.replaceQueryParam("user", ((Object[]) null));
                }
                if (pass == null) {
                }
                if (pass!= null) {
                    localUriBuilder = localUriBuilder.replaceQueryParam("pass", pass);
                } else {
                    localUriBuilder = localUriBuilder.replaceQueryParam("pass", ((Object[]) null));
                }
                com.sun.jersey.api.client.WebResource resource = _client.resource(localUriBuilder.buildFromMap(_templateAndMatrixParameterValues));
                com.sun.jersey.api.client.WebResource.Builder resourceBuilder = resource.getRequestBuilder();
                resourceBuilder = resourceBuilder.accept("application/json");
                com.sun.jersey.api.client.ClientResponse response;
                response = resourceBuilder.method("GET", com.sun.jersey.api.client.ClientResponse.class);
                if (response.getStatus()>= 400) {
                    throw new RestService.WebApplicationExceptionMessage(Response.status(response.getClientResponseStatus()).build());
                }
                return response.getEntity(LoginDTO.class);
            }

            public<T >T getAsJson(String user, String pass, com.sun.jersey.api.client.GenericType<T> returnType) {
                UriBuilder localUriBuilder = _uriBuilder.clone();
                if (user == null) {
                }
                if (user!= null) {
                    localUriBuilder = localUriBuilder.replaceQueryParam("user", user);
                } else {
                    localUriBuilder = localUriBuilder.replaceQueryParam("user", ((Object[]) null));
                }
                if (pass == null) {
                }
                if (pass!= null) {
                    localUriBuilder = localUriBuilder.replaceQueryParam("pass", pass);
                } else {
                    localUriBuilder = localUriBuilder.replaceQueryParam("pass", ((Object[]) null));
                }
                com.sun.jersey.api.client.WebResource resource = _client.resource(localUriBuilder.buildFromMap(_templateAndMatrixParameterValues));
                com.sun.jersey.api.client.WebResource.Builder resourceBuilder = resource.getRequestBuilder();
                resourceBuilder = resourceBuilder.accept("application/json");
                com.sun.jersey.api.client.ClientResponse response;
                response = resourceBuilder.method("GET", com.sun.jersey.api.client.ClientResponse.class);
                if (response.getStatus()>= 400) {
                    throw new RestService.WebApplicationExceptionMessage(Response.status(response.getClientResponseStatus()).build());
                }
                return response.getEntity(returnType);
            }

            public<T >T getAsJson(String user, String pass, Class<T> returnType) {
                UriBuilder localUriBuilder = _uriBuilder.clone();
                if (user == null) {
                }
                if (user!= null) {
                    localUriBuilder = localUriBuilder.replaceQueryParam("user", user);
                } else {
                    localUriBuilder = localUriBuilder.replaceQueryParam("user", ((Object[]) null));
                }
                if (pass == null) {
                }
                if (pass!= null) {
                    localUriBuilder = localUriBuilder.replaceQueryParam("pass", pass);
                } else {
                    localUriBuilder = localUriBuilder.replaceQueryParam("pass", ((Object[]) null));
                }
                com.sun.jersey.api.client.WebResource resource = _client.resource(localUriBuilder.buildFromMap(_templateAndMatrixParameterValues));
                com.sun.jersey.api.client.WebResource.Builder resourceBuilder = resource.getRequestBuilder();
                resourceBuilder = resourceBuilder.accept("application/json");
                com.sun.jersey.api.client.ClientResponse response;
                response = resourceBuilder.method("GET", com.sun.jersey.api.client.ClientResponse.class);
                if (!com.sun.jersey.api.client.ClientResponse.class.isAssignableFrom(returnType)) {
                    if (response.getStatus()>= 400) {
                        throw new RestService.WebApplicationExceptionMessage(Response.status(response.getClientResponseStatus()).build());
                    }
                }
                if (!com.sun.jersey.api.client.ClientResponse.class.isAssignableFrom(returnType)) {
                    return response.getEntity(returnType);
                } else {
                    return returnType.cast(response);
                }
            }

        }

    }

    public static class Product {

        private com.sun.jersey.api.client.Client _client;
        private UriBuilder _uriBuilder;
        private Map<String, Object> _templateAndMatrixParameterValues;

        private Product(com.sun.jersey.api.client.Client client, UriBuilder uriBuilder, Map<String, Object> map) {
            _client = client;
            _uriBuilder = uriBuilder.clone();
            _templateAndMatrixParameterValues = map;
        }

        /**
         * Create new instance using existing Client instance, and a base URI and any parameters
         * 
         */
        public Product(com.sun.jersey.api.client.Client client, URI baseUri) {
            _client = client;
            _uriBuilder = UriBuilder.fromUri(baseUri);
            _uriBuilder = _uriBuilder.path("/product/");
            _templateAndMatrixParameterValues = new HashMap<String, Object>();
        }

        public RestService.Product.DoUpdateJson doUpdateJson() {
            return new RestService.Product.DoUpdateJson(_client, _uriBuilder.buildFromMap(_templateAndMatrixParameterValues));
        }

        public RestService.Product.DoCreateJson doCreateJson() {
            return new RestService.Product.DoCreateJson(_client, _uriBuilder.buildFromMap(_templateAndMatrixParameterValues));
        }

        public RestService.Product.DoGetJson doGetJson() {
            return new RestService.Product.DoGetJson(_client, _uriBuilder.buildFromMap(_templateAndMatrixParameterValues));
        }

        public RestService.Product.DoDeleteJson doDeleteJson() {
            return new RestService.Product.DoDeleteJson(_client, _uriBuilder.buildFromMap(_templateAndMatrixParameterValues));
        }

        public RestService.Product.DoListJson doListJson() {
            return new RestService.Product.DoListJson(_client, _uriBuilder.buildFromMap(_templateAndMatrixParameterValues));
        }

        public static class DoCreateJson {

            private com.sun.jersey.api.client.Client _client;
            private UriBuilder _uriBuilder;
            private Map<String, Object> _templateAndMatrixParameterValues;

            private DoCreateJson(com.sun.jersey.api.client.Client client, UriBuilder uriBuilder, Map<String, Object> map) {
                _client = client;
                _uriBuilder = uriBuilder.clone();
                _templateAndMatrixParameterValues = map;
            }

            /**
             * Create new instance using existing Client instance, and a base URI and any parameters
             * 
             */
            public DoCreateJson(com.sun.jersey.api.client.Client client, URI baseUri) {
                _client = client;
                _uriBuilder = UriBuilder.fromUri(baseUri);
                _uriBuilder = _uriBuilder.path("do.create.json");
                _templateAndMatrixParameterValues = new HashMap<String, Object>();
            }

            public ProductDTO postAsProductDTO() {
                UriBuilder localUriBuilder = _uriBuilder.clone();
                com.sun.jersey.api.client.WebResource resource = _client.resource(localUriBuilder.buildFromMap(_templateAndMatrixParameterValues));
                com.sun.jersey.api.client.WebResource.Builder resourceBuilder = resource.getRequestBuilder();
                resourceBuilder = resourceBuilder.accept("application/json");
                com.sun.jersey.api.client.ClientResponse response;
                response = resourceBuilder.method("POST", com.sun.jersey.api.client.ClientResponse.class);
                if (response.getStatus()>= 400) {
                    throw new RestService.WebApplicationExceptionMessage(Response.status(response.getClientResponseStatus()).build());
                }
                return response.getEntity(ProductDTO.class);
            }

            public<T >T postAsJson(com.sun.jersey.api.client.GenericType<T> returnType) {
                UriBuilder localUriBuilder = _uriBuilder.clone();
                com.sun.jersey.api.client.WebResource resource = _client.resource(localUriBuilder.buildFromMap(_templateAndMatrixParameterValues));
                com.sun.jersey.api.client.WebResource.Builder resourceBuilder = resource.getRequestBuilder();
                resourceBuilder = resourceBuilder.accept("application/json");
                com.sun.jersey.api.client.ClientResponse response;
                response = resourceBuilder.method("POST", com.sun.jersey.api.client.ClientResponse.class);
                if (response.getStatus()>= 400) {
                    throw new RestService.WebApplicationExceptionMessage(Response.status(response.getClientResponseStatus()).build());
                }
                return response.getEntity(returnType);
            }

            public<T >T postAsJson(Class<T> returnType) {
                UriBuilder localUriBuilder = _uriBuilder.clone();
                com.sun.jersey.api.client.WebResource resource = _client.resource(localUriBuilder.buildFromMap(_templateAndMatrixParameterValues));
                com.sun.jersey.api.client.WebResource.Builder resourceBuilder = resource.getRequestBuilder();
                resourceBuilder = resourceBuilder.accept("application/json");
                com.sun.jersey.api.client.ClientResponse response;
                response = resourceBuilder.method("POST", com.sun.jersey.api.client.ClientResponse.class);
                if (!com.sun.jersey.api.client.ClientResponse.class.isAssignableFrom(returnType)) {
                    if (response.getStatus()>= 400) {
                        throw new RestService.WebApplicationExceptionMessage(Response.status(response.getClientResponseStatus()).build());
                    }
                }
                if (!com.sun.jersey.api.client.ClientResponse.class.isAssignableFrom(returnType)) {
                    return response.getEntity(returnType);
                } else {
                    return returnType.cast(response);
                }
            }

            public ProductDTO postAsProductDTO(String name, Integer mincount, String barcode, Integer qtype, Integer pricein, Integer priceout, Integer groupid, String comment) {
                UriBuilder localUriBuilder = _uriBuilder.clone();
                if (name == null) {
                }
                if (name!= null) {
                    localUriBuilder = localUriBuilder.replaceQueryParam("name", name);
                } else {
                    localUriBuilder = localUriBuilder.replaceQueryParam("name", ((Object[]) null));
                }
                if (mincount == null) {
                }
                if (mincount!= null) {
                    localUriBuilder = localUriBuilder.replaceQueryParam("mincount", mincount);
                } else {
                    localUriBuilder = localUriBuilder.replaceQueryParam("mincount", ((Object[]) null));
                }
                if (barcode == null) {
                }
                if (barcode!= null) {
                    localUriBuilder = localUriBuilder.replaceQueryParam("barcode", barcode);
                } else {
                    localUriBuilder = localUriBuilder.replaceQueryParam("barcode", ((Object[]) null));
                }
                if (qtype == null) {
                }
                if (qtype!= null) {
                    localUriBuilder = localUriBuilder.replaceQueryParam("qtype", qtype);
                } else {
                    localUriBuilder = localUriBuilder.replaceQueryParam("qtype", ((Object[]) null));
                }
                if (pricein == null) {
                }
                if (pricein!= null) {
                    localUriBuilder = localUriBuilder.replaceQueryParam("pricein", pricein);
                } else {
                    localUriBuilder = localUriBuilder.replaceQueryParam("pricein", ((Object[]) null));
                }
                if (priceout == null) {
                }
                if (priceout!= null) {
                    localUriBuilder = localUriBuilder.replaceQueryParam("priceout", priceout);
                } else {
                    localUriBuilder = localUriBuilder.replaceQueryParam("priceout", ((Object[]) null));
                }
                if (groupid == null) {
                }
                if (groupid!= null) {
                    localUriBuilder = localUriBuilder.replaceQueryParam("groupid", groupid);
                } else {
                    localUriBuilder = localUriBuilder.replaceQueryParam("groupid", ((Object[]) null));
                }
                if (comment == null) {
                }
                if (comment!= null) {
                    localUriBuilder = localUriBuilder.replaceQueryParam("comment", comment);
                } else {
                    localUriBuilder = localUriBuilder.replaceQueryParam("comment", ((Object[]) null));
                }
                com.sun.jersey.api.client.WebResource resource = _client.resource(localUriBuilder.buildFromMap(_templateAndMatrixParameterValues));
                com.sun.jersey.api.client.WebResource.Builder resourceBuilder = resource.getRequestBuilder();
                resourceBuilder = resourceBuilder.accept("application/json");
                com.sun.jersey.api.client.ClientResponse response;
                response = resourceBuilder.method("POST", com.sun.jersey.api.client.ClientResponse.class);
                if (response.getStatus()>= 400) {
                    throw new RestService.WebApplicationExceptionMessage(Response.status(response.getClientResponseStatus()).build());
                }
                return response.getEntity(ProductDTO.class);
            }

            public<T >T postAsJson(String name, Integer mincount, String barcode, Integer qtype, Integer pricein, Integer priceout, Integer groupid, String comment, com.sun.jersey.api.client.GenericType<T> returnType) {
                UriBuilder localUriBuilder = _uriBuilder.clone();
                if (name == null) {
                }
                if (name!= null) {
                    localUriBuilder = localUriBuilder.replaceQueryParam("name", name);
                } else {
                    localUriBuilder = localUriBuilder.replaceQueryParam("name", ((Object[]) null));
                }
                if (mincount == null) {
                }
                if (mincount!= null) {
                    localUriBuilder = localUriBuilder.replaceQueryParam("mincount", mincount);
                } else {
                    localUriBuilder = localUriBuilder.replaceQueryParam("mincount", ((Object[]) null));
                }
                if (barcode == null) {
                }
                if (barcode!= null) {
                    localUriBuilder = localUriBuilder.replaceQueryParam("barcode", barcode);
                } else {
                    localUriBuilder = localUriBuilder.replaceQueryParam("barcode", ((Object[]) null));
                }
                if (qtype == null) {
                }
                if (qtype!= null) {
                    localUriBuilder = localUriBuilder.replaceQueryParam("qtype", qtype);
                } else {
                    localUriBuilder = localUriBuilder.replaceQueryParam("qtype", ((Object[]) null));
                }
                if (pricein == null) {
                }
                if (pricein!= null) {
                    localUriBuilder = localUriBuilder.replaceQueryParam("pricein", pricein);
                } else {
                    localUriBuilder = localUriBuilder.replaceQueryParam("pricein", ((Object[]) null));
                }
                if (priceout == null) {
                }
                if (priceout!= null) {
                    localUriBuilder = localUriBuilder.replaceQueryParam("priceout", priceout);
                } else {
                    localUriBuilder = localUriBuilder.replaceQueryParam("priceout", ((Object[]) null));
                }
                if (groupid == null) {
                }
                if (groupid!= null) {
                    localUriBuilder = localUriBuilder.replaceQueryParam("groupid", groupid);
                } else {
                    localUriBuilder = localUriBuilder.replaceQueryParam("groupid", ((Object[]) null));
                }
                if (comment == null) {
                }
                if (comment!= null) {
                    localUriBuilder = localUriBuilder.replaceQueryParam("comment", comment);
                } else {
                    localUriBuilder = localUriBuilder.replaceQueryParam("comment", ((Object[]) null));
                }
                com.sun.jersey.api.client.WebResource resource = _client.resource(localUriBuilder.buildFromMap(_templateAndMatrixParameterValues));
                com.sun.jersey.api.client.WebResource.Builder resourceBuilder = resource.getRequestBuilder();
                resourceBuilder = resourceBuilder.accept("application/json");
                com.sun.jersey.api.client.ClientResponse response;
                response = resourceBuilder.method("POST", com.sun.jersey.api.client.ClientResponse.class);
                if (response.getStatus()>= 400) {
                    throw new RestService.WebApplicationExceptionMessage(Response.status(response.getClientResponseStatus()).build());
                }
                return response.getEntity(returnType);
            }

            public<T >T postAsJson(String name, Integer mincount, String barcode, Integer qtype, Integer pricein, Integer priceout, Integer groupid, String comment, Class<T> returnType) {
                UriBuilder localUriBuilder = _uriBuilder.clone();
                if (name == null) {
                }
                if (name!= null) {
                    localUriBuilder = localUriBuilder.replaceQueryParam("name", name);
                } else {
                    localUriBuilder = localUriBuilder.replaceQueryParam("name", ((Object[]) null));
                }
                if (mincount == null) {
                }
                if (mincount!= null) {
                    localUriBuilder = localUriBuilder.replaceQueryParam("mincount", mincount);
                } else {
                    localUriBuilder = localUriBuilder.replaceQueryParam("mincount", ((Object[]) null));
                }
                if (barcode == null) {
                }
                if (barcode!= null) {
                    localUriBuilder = localUriBuilder.replaceQueryParam("barcode", barcode);
                } else {
                    localUriBuilder = localUriBuilder.replaceQueryParam("barcode", ((Object[]) null));
                }
                if (qtype == null) {
                }
                if (qtype!= null) {
                    localUriBuilder = localUriBuilder.replaceQueryParam("qtype", qtype);
                } else {
                    localUriBuilder = localUriBuilder.replaceQueryParam("qtype", ((Object[]) null));
                }
                if (pricein == null) {
                }
                if (pricein!= null) {
                    localUriBuilder = localUriBuilder.replaceQueryParam("pricein", pricein);
                } else {
                    localUriBuilder = localUriBuilder.replaceQueryParam("pricein", ((Object[]) null));
                }
                if (priceout == null) {
                }
                if (priceout!= null) {
                    localUriBuilder = localUriBuilder.replaceQueryParam("priceout", priceout);
                } else {
                    localUriBuilder = localUriBuilder.replaceQueryParam("priceout", ((Object[]) null));
                }
                if (groupid == null) {
                }
                if (groupid!= null) {
                    localUriBuilder = localUriBuilder.replaceQueryParam("groupid", groupid);
                } else {
                    localUriBuilder = localUriBuilder.replaceQueryParam("groupid", ((Object[]) null));
                }
                if (comment == null) {
                }
                if (comment!= null) {
                    localUriBuilder = localUriBuilder.replaceQueryParam("comment", comment);
                } else {
                    localUriBuilder = localUriBuilder.replaceQueryParam("comment", ((Object[]) null));
                }
                com.sun.jersey.api.client.WebResource resource = _client.resource(localUriBuilder.buildFromMap(_templateAndMatrixParameterValues));
                com.sun.jersey.api.client.WebResource.Builder resourceBuilder = resource.getRequestBuilder();
                resourceBuilder = resourceBuilder.accept("application/json");
                com.sun.jersey.api.client.ClientResponse response;
                response = resourceBuilder.method("POST", com.sun.jersey.api.client.ClientResponse.class);
                if (!com.sun.jersey.api.client.ClientResponse.class.isAssignableFrom(returnType)) {
                    if (response.getStatus()>= 400) {
                        throw new RestService.WebApplicationExceptionMessage(Response.status(response.getClientResponseStatus()).build());
                    }
                }
                if (!com.sun.jersey.api.client.ClientResponse.class.isAssignableFrom(returnType)) {
                    return response.getEntity(returnType);
                } else {
                    return returnType.cast(response);
                }
            }

        }

        public static class DoDeleteJson {

            private com.sun.jersey.api.client.Client _client;
            private UriBuilder _uriBuilder;
            private Map<String, Object> _templateAndMatrixParameterValues;

            private DoDeleteJson(com.sun.jersey.api.client.Client client, UriBuilder uriBuilder, Map<String, Object> map) {
                _client = client;
                _uriBuilder = uriBuilder.clone();
                _templateAndMatrixParameterValues = map;
            }

            /**
             * Create new instance using existing Client instance, and a base URI and any parameters
             * 
             */
            public DoDeleteJson(com.sun.jersey.api.client.Client client, URI baseUri) {
                _client = client;
                _uriBuilder = UriBuilder.fromUri(baseUri);
                _uriBuilder = _uriBuilder.path("do.delete.json");
                _templateAndMatrixParameterValues = new HashMap<String, Object>();
            }

            public SimpleDataDTO getAsSimpleDataDTO() {
                UriBuilder localUriBuilder = _uriBuilder.clone();
                com.sun.jersey.api.client.WebResource resource = _client.resource(localUriBuilder.buildFromMap(_templateAndMatrixParameterValues));
                com.sun.jersey.api.client.WebResource.Builder resourceBuilder = resource.getRequestBuilder();
                resourceBuilder = resourceBuilder.accept("application/json");
                com.sun.jersey.api.client.ClientResponse response;
                response = resourceBuilder.method("GET", com.sun.jersey.api.client.ClientResponse.class);
                if (response.getStatus()>= 400) {
                    throw new RestService.WebApplicationExceptionMessage(Response.status(response.getClientResponseStatus()).build());
                }
                return response.getEntity(SimpleDataDTO.class);
            }

            public<T >T getAsJson(com.sun.jersey.api.client.GenericType<T> returnType) {
                UriBuilder localUriBuilder = _uriBuilder.clone();
                com.sun.jersey.api.client.WebResource resource = _client.resource(localUriBuilder.buildFromMap(_templateAndMatrixParameterValues));
                com.sun.jersey.api.client.WebResource.Builder resourceBuilder = resource.getRequestBuilder();
                resourceBuilder = resourceBuilder.accept("application/json");
                com.sun.jersey.api.client.ClientResponse response;
                response = resourceBuilder.method("GET", com.sun.jersey.api.client.ClientResponse.class);
                if (response.getStatus()>= 400) {
                    throw new RestService.WebApplicationExceptionMessage(Response.status(response.getClientResponseStatus()).build());
                }
                return response.getEntity(returnType);
            }

            public<T >T getAsJson(Class<T> returnType) {
                UriBuilder localUriBuilder = _uriBuilder.clone();
                com.sun.jersey.api.client.WebResource resource = _client.resource(localUriBuilder.buildFromMap(_templateAndMatrixParameterValues));
                com.sun.jersey.api.client.WebResource.Builder resourceBuilder = resource.getRequestBuilder();
                resourceBuilder = resourceBuilder.accept("application/json");
                com.sun.jersey.api.client.ClientResponse response;
                response = resourceBuilder.method("GET", com.sun.jersey.api.client.ClientResponse.class);
                if (!com.sun.jersey.api.client.ClientResponse.class.isAssignableFrom(returnType)) {
                    if (response.getStatus()>= 400) {
                        throw new RestService.WebApplicationExceptionMessage(Response.status(response.getClientResponseStatus()).build());
                    }
                }
                if (!com.sun.jersey.api.client.ClientResponse.class.isAssignableFrom(returnType)) {
                    return response.getEntity(returnType);
                } else {
                    return returnType.cast(response);
                }
            }

            public SimpleDataDTO getAsSimpleDataDTO(Integer id) {
                UriBuilder localUriBuilder = _uriBuilder.clone();
                if (id == null) {
                }
                if (id!= null) {
                    localUriBuilder = localUriBuilder.replaceQueryParam("id", id);
                } else {
                    localUriBuilder = localUriBuilder.replaceQueryParam("id", ((Object[]) null));
                }
                com.sun.jersey.api.client.WebResource resource = _client.resource(localUriBuilder.buildFromMap(_templateAndMatrixParameterValues));
                com.sun.jersey.api.client.WebResource.Builder resourceBuilder = resource.getRequestBuilder();
                resourceBuilder = resourceBuilder.accept("application/json");
                com.sun.jersey.api.client.ClientResponse response;
                response = resourceBuilder.method("GET", com.sun.jersey.api.client.ClientResponse.class);
                if (response.getStatus()>= 400) {
                    throw new RestService.WebApplicationExceptionMessage(Response.status(response.getClientResponseStatus()).build());
                }
                return response.getEntity(SimpleDataDTO.class);
            }

            public<T >T getAsJson(Integer id, com.sun.jersey.api.client.GenericType<T> returnType) {
                UriBuilder localUriBuilder = _uriBuilder.clone();
                if (id == null) {
                }
                if (id!= null) {
                    localUriBuilder = localUriBuilder.replaceQueryParam("id", id);
                } else {
                    localUriBuilder = localUriBuilder.replaceQueryParam("id", ((Object[]) null));
                }
                com.sun.jersey.api.client.WebResource resource = _client.resource(localUriBuilder.buildFromMap(_templateAndMatrixParameterValues));
                com.sun.jersey.api.client.WebResource.Builder resourceBuilder = resource.getRequestBuilder();
                resourceBuilder = resourceBuilder.accept("application/json");
                com.sun.jersey.api.client.ClientResponse response;
                response = resourceBuilder.method("GET", com.sun.jersey.api.client.ClientResponse.class);
                if (response.getStatus()>= 400) {
                    throw new RestService.WebApplicationExceptionMessage(Response.status(response.getClientResponseStatus()).build());
                }
                return response.getEntity(returnType);
            }

            public<T >T getAsJson(Integer id, Class<T> returnType) {
                UriBuilder localUriBuilder = _uriBuilder.clone();
                if (id == null) {
                }
                if (id!= null) {
                    localUriBuilder = localUriBuilder.replaceQueryParam("id", id);
                } else {
                    localUriBuilder = localUriBuilder.replaceQueryParam("id", ((Object[]) null));
                }
                com.sun.jersey.api.client.WebResource resource = _client.resource(localUriBuilder.buildFromMap(_templateAndMatrixParameterValues));
                com.sun.jersey.api.client.WebResource.Builder resourceBuilder = resource.getRequestBuilder();
                resourceBuilder = resourceBuilder.accept("application/json");
                com.sun.jersey.api.client.ClientResponse response;
                response = resourceBuilder.method("GET", com.sun.jersey.api.client.ClientResponse.class);
                if (!com.sun.jersey.api.client.ClientResponse.class.isAssignableFrom(returnType)) {
                    if (response.getStatus()>= 400) {
                        throw new RestService.WebApplicationExceptionMessage(Response.status(response.getClientResponseStatus()).build());
                    }
                }
                if (!com.sun.jersey.api.client.ClientResponse.class.isAssignableFrom(returnType)) {
                    return response.getEntity(returnType);
                } else {
                    return returnType.cast(response);
                }
            }

        }

        public static class DoGetJson {

            private com.sun.jersey.api.client.Client _client;
            private UriBuilder _uriBuilder;
            private Map<String, Object> _templateAndMatrixParameterValues;

            private DoGetJson(com.sun.jersey.api.client.Client client, UriBuilder uriBuilder, Map<String, Object> map) {
                _client = client;
                _uriBuilder = uriBuilder.clone();
                _templateAndMatrixParameterValues = map;
            }

            /**
             * Create new instance using existing Client instance, and a base URI and any parameters
             * 
             */
            public DoGetJson(com.sun.jersey.api.client.Client client, URI baseUri) {
                _client = client;
                _uriBuilder = UriBuilder.fromUri(baseUri);
                _uriBuilder = _uriBuilder.path("do.get.json");
                _templateAndMatrixParameterValues = new HashMap<String, Object>();
            }

            public ProductDTO getAsProductDTO() {
                UriBuilder localUriBuilder = _uriBuilder.clone();
                com.sun.jersey.api.client.WebResource resource = _client.resource(localUriBuilder.buildFromMap(_templateAndMatrixParameterValues));
                com.sun.jersey.api.client.WebResource.Builder resourceBuilder = resource.getRequestBuilder();
                resourceBuilder = resourceBuilder.accept("application/json");
                com.sun.jersey.api.client.ClientResponse response;
                response = resourceBuilder.method("GET", com.sun.jersey.api.client.ClientResponse.class);
                if (response.getStatus()>= 400) {
                    throw new RestService.WebApplicationExceptionMessage(Response.status(response.getClientResponseStatus()).build());
                }
                return response.getEntity(ProductDTO.class);
            }

            public<T >T getAsJson(com.sun.jersey.api.client.GenericType<T> returnType) {
                UriBuilder localUriBuilder = _uriBuilder.clone();
                com.sun.jersey.api.client.WebResource resource = _client.resource(localUriBuilder.buildFromMap(_templateAndMatrixParameterValues));
                com.sun.jersey.api.client.WebResource.Builder resourceBuilder = resource.getRequestBuilder();
                resourceBuilder = resourceBuilder.accept("application/json");
                com.sun.jersey.api.client.ClientResponse response;
                response = resourceBuilder.method("GET", com.sun.jersey.api.client.ClientResponse.class);
                if (response.getStatus()>= 400) {
                    throw new RestService.WebApplicationExceptionMessage(Response.status(response.getClientResponseStatus()).build());
                }
                return response.getEntity(returnType);
            }

            public<T >T getAsJson(Class<T> returnType) {
                UriBuilder localUriBuilder = _uriBuilder.clone();
                com.sun.jersey.api.client.WebResource resource = _client.resource(localUriBuilder.buildFromMap(_templateAndMatrixParameterValues));
                com.sun.jersey.api.client.WebResource.Builder resourceBuilder = resource.getRequestBuilder();
                resourceBuilder = resourceBuilder.accept("application/json");
                com.sun.jersey.api.client.ClientResponse response;
                response = resourceBuilder.method("GET", com.sun.jersey.api.client.ClientResponse.class);
                if (!com.sun.jersey.api.client.ClientResponse.class.isAssignableFrom(returnType)) {
                    if (response.getStatus()>= 400) {
                        throw new RestService.WebApplicationExceptionMessage(Response.status(response.getClientResponseStatus()).build());
                    }
                }
                if (!com.sun.jersey.api.client.ClientResponse.class.isAssignableFrom(returnType)) {
                    return response.getEntity(returnType);
                } else {
                    return returnType.cast(response);
                }
            }

            public ProductDTO getAsProductDTO(Integer id) {
                UriBuilder localUriBuilder = _uriBuilder.clone();
                if (id == null) {
                }
                if (id!= null) {
                    localUriBuilder = localUriBuilder.replaceQueryParam("id", id);
                } else {
                    localUriBuilder = localUriBuilder.replaceQueryParam("id", ((Object[]) null));
                }
                com.sun.jersey.api.client.WebResource resource = _client.resource(localUriBuilder.buildFromMap(_templateAndMatrixParameterValues));
                com.sun.jersey.api.client.WebResource.Builder resourceBuilder = resource.getRequestBuilder();
                resourceBuilder = resourceBuilder.accept("application/json");
                com.sun.jersey.api.client.ClientResponse response;
                response = resourceBuilder.method("GET", com.sun.jersey.api.client.ClientResponse.class);
                if (response.getStatus()>= 400) {
                    throw new RestService.WebApplicationExceptionMessage(Response.status(response.getClientResponseStatus()).build());
                }
                return response.getEntity(ProductDTO.class);
            }

            public<T >T getAsJson(Integer id, com.sun.jersey.api.client.GenericType<T> returnType) {
                UriBuilder localUriBuilder = _uriBuilder.clone();
                if (id == null) {
                }
                if (id!= null) {
                    localUriBuilder = localUriBuilder.replaceQueryParam("id", id);
                } else {
                    localUriBuilder = localUriBuilder.replaceQueryParam("id", ((Object[]) null));
                }
                com.sun.jersey.api.client.WebResource resource = _client.resource(localUriBuilder.buildFromMap(_templateAndMatrixParameterValues));
                com.sun.jersey.api.client.WebResource.Builder resourceBuilder = resource.getRequestBuilder();
                resourceBuilder = resourceBuilder.accept("application/json");
                com.sun.jersey.api.client.ClientResponse response;
                response = resourceBuilder.method("GET", com.sun.jersey.api.client.ClientResponse.class);
                if (response.getStatus()>= 400) {
                    throw new RestService.WebApplicationExceptionMessage(Response.status(response.getClientResponseStatus()).build());
                }
                return response.getEntity(returnType);
            }

            public<T >T getAsJson(Integer id, Class<T> returnType) {
                UriBuilder localUriBuilder = _uriBuilder.clone();
                if (id == null) {
                }
                if (id!= null) {
                    localUriBuilder = localUriBuilder.replaceQueryParam("id", id);
                } else {
                    localUriBuilder = localUriBuilder.replaceQueryParam("id", ((Object[]) null));
                }
                com.sun.jersey.api.client.WebResource resource = _client.resource(localUriBuilder.buildFromMap(_templateAndMatrixParameterValues));
                com.sun.jersey.api.client.WebResource.Builder resourceBuilder = resource.getRequestBuilder();
                resourceBuilder = resourceBuilder.accept("application/json");
                com.sun.jersey.api.client.ClientResponse response;
                response = resourceBuilder.method("GET", com.sun.jersey.api.client.ClientResponse.class);
                if (!com.sun.jersey.api.client.ClientResponse.class.isAssignableFrom(returnType)) {
                    if (response.getStatus()>= 400) {
                        throw new RestService.WebApplicationExceptionMessage(Response.status(response.getClientResponseStatus()).build());
                    }
                }
                if (!com.sun.jersey.api.client.ClientResponse.class.isAssignableFrom(returnType)) {
                    return response.getEntity(returnType);
                } else {
                    return returnType.cast(response);
                }
            }

        }

        public static class DoListJson {

            private com.sun.jersey.api.client.Client _client;
            private UriBuilder _uriBuilder;
            private Map<String, Object> _templateAndMatrixParameterValues;

            private DoListJson(com.sun.jersey.api.client.Client client, UriBuilder uriBuilder, Map<String, Object> map) {
                _client = client;
                _uriBuilder = uriBuilder.clone();
                _templateAndMatrixParameterValues = map;
            }

            /**
             * Create new instance using existing Client instance, and a base URI and any parameters
             * 
             */
            public DoListJson(com.sun.jersey.api.client.Client client, URI baseUri) {
                _client = client;
                _uriBuilder = UriBuilder.fromUri(baseUri);
                _uriBuilder = _uriBuilder.path("do.list.json");
                _templateAndMatrixParameterValues = new HashMap<String, Object>();
            }

            public ListDTO getAsListDTO() {
                UriBuilder localUriBuilder = _uriBuilder.clone();
                com.sun.jersey.api.client.WebResource resource = _client.resource(localUriBuilder.buildFromMap(_templateAndMatrixParameterValues));
                com.sun.jersey.api.client.WebResource.Builder resourceBuilder = resource.getRequestBuilder();
                resourceBuilder = resourceBuilder.accept("application/json");
                com.sun.jersey.api.client.ClientResponse response;
                response = resourceBuilder.method("GET", com.sun.jersey.api.client.ClientResponse.class);
                if (response.getStatus()>= 400) {
                    throw new RestService.WebApplicationExceptionMessage(Response.status(response.getClientResponseStatus()).build());
                }
                return response.getEntity(ListDTO.class);
            }

            public<T >T getAsJson(com.sun.jersey.api.client.GenericType<T> returnType) {
                UriBuilder localUriBuilder = _uriBuilder.clone();
                com.sun.jersey.api.client.WebResource resource = _client.resource(localUriBuilder.buildFromMap(_templateAndMatrixParameterValues));
                com.sun.jersey.api.client.WebResource.Builder resourceBuilder = resource.getRequestBuilder();
                resourceBuilder = resourceBuilder.accept("application/json");
                com.sun.jersey.api.client.ClientResponse response;
                response = resourceBuilder.method("GET", com.sun.jersey.api.client.ClientResponse.class);
                if (response.getStatus()>= 400) {
                    throw new RestService.WebApplicationExceptionMessage(Response.status(response.getClientResponseStatus()).build());
                }
                return response.getEntity(returnType);
            }

            public<T >T getAsJson(Class<T> returnType) {
                UriBuilder localUriBuilder = _uriBuilder.clone();
                com.sun.jersey.api.client.WebResource resource = _client.resource(localUriBuilder.buildFromMap(_templateAndMatrixParameterValues));
                com.sun.jersey.api.client.WebResource.Builder resourceBuilder = resource.getRequestBuilder();
                resourceBuilder = resourceBuilder.accept("application/json");
                com.sun.jersey.api.client.ClientResponse response;
                response = resourceBuilder.method("GET", com.sun.jersey.api.client.ClientResponse.class);
                if (!com.sun.jersey.api.client.ClientResponse.class.isAssignableFrom(returnType)) {
                    if (response.getStatus()>= 400) {
                        throw new RestService.WebApplicationExceptionMessage(Response.status(response.getClientResponseStatus()).build());
                    }
                }
                if (!com.sun.jersey.api.client.ClientResponse.class.isAssignableFrom(returnType)) {
                    return response.getEntity(returnType);
                } else {
                    return returnType.cast(response);
                }
            }

            public ListDTO getAsListDTO(Boolean all, Integer page, Integer perpage) {
                UriBuilder localUriBuilder = _uriBuilder.clone();
                if (all == null) {
                }
                if (all!= null) {
                    localUriBuilder = localUriBuilder.replaceQueryParam("all", all);
                } else {
                    localUriBuilder = localUriBuilder.replaceQueryParam("all", ((Object[]) null));
                }
                if (page == null) {
                }
                if (page!= null) {
                    localUriBuilder = localUriBuilder.replaceQueryParam("page", page);
                } else {
                    localUriBuilder = localUriBuilder.replaceQueryParam("page", ((Object[]) null));
                }
                if (perpage == null) {
                }
                if (perpage!= null) {
                    localUriBuilder = localUriBuilder.replaceQueryParam("perpage", perpage);
                } else {
                    localUriBuilder = localUriBuilder.replaceQueryParam("perpage", ((Object[]) null));
                }
                com.sun.jersey.api.client.WebResource resource = _client.resource(localUriBuilder.buildFromMap(_templateAndMatrixParameterValues));
                com.sun.jersey.api.client.WebResource.Builder resourceBuilder = resource.getRequestBuilder();
                resourceBuilder = resourceBuilder.accept("application/json");
                com.sun.jersey.api.client.ClientResponse response;
                response = resourceBuilder.method("GET", com.sun.jersey.api.client.ClientResponse.class);
                if (response.getStatus()>= 400) {
                    throw new RestService.WebApplicationExceptionMessage(Response.status(response.getClientResponseStatus()).build());
                }
                return response.getEntity(ListDTO.class);
            }

            public<T >T getAsJson(Boolean all, Integer page, Integer perpage, com.sun.jersey.api.client.GenericType<T> returnType) {
                UriBuilder localUriBuilder = _uriBuilder.clone();
                if (all == null) {
                }
                if (all!= null) {
                    localUriBuilder = localUriBuilder.replaceQueryParam("all", all);
                } else {
                    localUriBuilder = localUriBuilder.replaceQueryParam("all", ((Object[]) null));
                }
                if (page == null) {
                }
                if (page!= null) {
                    localUriBuilder = localUriBuilder.replaceQueryParam("page", page);
                } else {
                    localUriBuilder = localUriBuilder.replaceQueryParam("page", ((Object[]) null));
                }
                if (perpage == null) {
                }
                if (perpage!= null) {
                    localUriBuilder = localUriBuilder.replaceQueryParam("perpage", perpage);
                } else {
                    localUriBuilder = localUriBuilder.replaceQueryParam("perpage", ((Object[]) null));
                }
                com.sun.jersey.api.client.WebResource resource = _client.resource(localUriBuilder.buildFromMap(_templateAndMatrixParameterValues));
                com.sun.jersey.api.client.WebResource.Builder resourceBuilder = resource.getRequestBuilder();
                resourceBuilder = resourceBuilder.accept("application/json");
                com.sun.jersey.api.client.ClientResponse response;
                response = resourceBuilder.method("GET", com.sun.jersey.api.client.ClientResponse.class);
                if (response.getStatus()>= 400) {
                    throw new RestService.WebApplicationExceptionMessage(Response.status(response.getClientResponseStatus()).build());
                }
                return response.getEntity(returnType);
            }

            public<T >T getAsJson(Boolean all, Integer page, Integer perpage, Class<T> returnType) {
                UriBuilder localUriBuilder = _uriBuilder.clone();
                if (all == null) {
                }
                if (all!= null) {
                    localUriBuilder = localUriBuilder.replaceQueryParam("all", all);
                } else {
                    localUriBuilder = localUriBuilder.replaceQueryParam("all", ((Object[]) null));
                }
                if (page == null) {
                }
                if (page!= null) {
                    localUriBuilder = localUriBuilder.replaceQueryParam("page", page);
                } else {
                    localUriBuilder = localUriBuilder.replaceQueryParam("page", ((Object[]) null));
                }
                if (perpage == null) {
                }
                if (perpage!= null) {
                    localUriBuilder = localUriBuilder.replaceQueryParam("perpage", perpage);
                } else {
                    localUriBuilder = localUriBuilder.replaceQueryParam("perpage", ((Object[]) null));
                }
                com.sun.jersey.api.client.WebResource resource = _client.resource(localUriBuilder.buildFromMap(_templateAndMatrixParameterValues));
                com.sun.jersey.api.client.WebResource.Builder resourceBuilder = resource.getRequestBuilder();
                resourceBuilder = resourceBuilder.accept("application/json");
                com.sun.jersey.api.client.ClientResponse response;
                response = resourceBuilder.method("GET", com.sun.jersey.api.client.ClientResponse.class);
                if (!com.sun.jersey.api.client.ClientResponse.class.isAssignableFrom(returnType)) {
                    if (response.getStatus()>= 400) {
                        throw new RestService.WebApplicationExceptionMessage(Response.status(response.getClientResponseStatus()).build());
                    }
                }
                if (!com.sun.jersey.api.client.ClientResponse.class.isAssignableFrom(returnType)) {
                    return response.getEntity(returnType);
                } else {
                    return returnType.cast(response);
                }
            }

        }

        public static class DoUpdateJson {

            private com.sun.jersey.api.client.Client _client;
            private UriBuilder _uriBuilder;
            private Map<String, Object> _templateAndMatrixParameterValues;

            private DoUpdateJson(com.sun.jersey.api.client.Client client, UriBuilder uriBuilder, Map<String, Object> map) {
                _client = client;
                _uriBuilder = uriBuilder.clone();
                _templateAndMatrixParameterValues = map;
            }

            /**
             * Create new instance using existing Client instance, and a base URI and any parameters
             * 
             */
            public DoUpdateJson(com.sun.jersey.api.client.Client client, URI baseUri) {
                _client = client;
                _uriBuilder = UriBuilder.fromUri(baseUri);
                _uriBuilder = _uriBuilder.path("do.update.json");
                _templateAndMatrixParameterValues = new HashMap<String, Object>();
            }

            public SimpleDataDTO postAsSimpleDataDTO() {
                UriBuilder localUriBuilder = _uriBuilder.clone();
                com.sun.jersey.api.client.WebResource resource = _client.resource(localUriBuilder.buildFromMap(_templateAndMatrixParameterValues));
                com.sun.jersey.api.client.WebResource.Builder resourceBuilder = resource.getRequestBuilder();
                resourceBuilder = resourceBuilder.accept("application/json");
                com.sun.jersey.api.client.ClientResponse response;
                response = resourceBuilder.method("POST", com.sun.jersey.api.client.ClientResponse.class);
                if (response.getStatus()>= 400) {
                    throw new RestService.WebApplicationExceptionMessage(Response.status(response.getClientResponseStatus()).build());
                }
                return response.getEntity(SimpleDataDTO.class);
            }

            public<T >T postAsJson(com.sun.jersey.api.client.GenericType<T> returnType) {
                UriBuilder localUriBuilder = _uriBuilder.clone();
                com.sun.jersey.api.client.WebResource resource = _client.resource(localUriBuilder.buildFromMap(_templateAndMatrixParameterValues));
                com.sun.jersey.api.client.WebResource.Builder resourceBuilder = resource.getRequestBuilder();
                resourceBuilder = resourceBuilder.accept("application/json");
                com.sun.jersey.api.client.ClientResponse response;
                response = resourceBuilder.method("POST", com.sun.jersey.api.client.ClientResponse.class);
                if (response.getStatus()>= 400) {
                    throw new RestService.WebApplicationExceptionMessage(Response.status(response.getClientResponseStatus()).build());
                }
                return response.getEntity(returnType);
            }

            public<T >T postAsJson(Class<T> returnType) {
                UriBuilder localUriBuilder = _uriBuilder.clone();
                com.sun.jersey.api.client.WebResource resource = _client.resource(localUriBuilder.buildFromMap(_templateAndMatrixParameterValues));
                com.sun.jersey.api.client.WebResource.Builder resourceBuilder = resource.getRequestBuilder();
                resourceBuilder = resourceBuilder.accept("application/json");
                com.sun.jersey.api.client.ClientResponse response;
                response = resourceBuilder.method("POST", com.sun.jersey.api.client.ClientResponse.class);
                if (!com.sun.jersey.api.client.ClientResponse.class.isAssignableFrom(returnType)) {
                    if (response.getStatus()>= 400) {
                        throw new RestService.WebApplicationExceptionMessage(Response.status(response.getClientResponseStatus()).build());
                    }
                }
                if (!com.sun.jersey.api.client.ClientResponse.class.isAssignableFrom(returnType)) {
                    return response.getEntity(returnType);
                } else {
                    return returnType.cast(response);
                }
            }

            public SimpleDataDTO postAsSimpleDataDTO(String name, Integer mincount, String barcode, Integer qtype, Integer pricein, Integer priceout, Integer groupid, String comment) {
                UriBuilder localUriBuilder = _uriBuilder.clone();
                if (name == null) {
                }
                if (name!= null) {
                    localUriBuilder = localUriBuilder.replaceQueryParam("name", name);
                } else {
                    localUriBuilder = localUriBuilder.replaceQueryParam("name", ((Object[]) null));
                }
                if (mincount == null) {
                }
                if (mincount!= null) {
                    localUriBuilder = localUriBuilder.replaceQueryParam("mincount", mincount);
                } else {
                    localUriBuilder = localUriBuilder.replaceQueryParam("mincount", ((Object[]) null));
                }
                if (barcode == null) {
                }
                if (barcode!= null) {
                    localUriBuilder = localUriBuilder.replaceQueryParam("barcode", barcode);
                } else {
                    localUriBuilder = localUriBuilder.replaceQueryParam("barcode", ((Object[]) null));
                }
                if (qtype == null) {
                }
                if (qtype!= null) {
                    localUriBuilder = localUriBuilder.replaceQueryParam("qtype", qtype);
                } else {
                    localUriBuilder = localUriBuilder.replaceQueryParam("qtype", ((Object[]) null));
                }
                if (pricein == null) {
                }
                if (pricein!= null) {
                    localUriBuilder = localUriBuilder.replaceQueryParam("pricein", pricein);
                } else {
                    localUriBuilder = localUriBuilder.replaceQueryParam("pricein", ((Object[]) null));
                }
                if (priceout == null) {
                }
                if (priceout!= null) {
                    localUriBuilder = localUriBuilder.replaceQueryParam("priceout", priceout);
                } else {
                    localUriBuilder = localUriBuilder.replaceQueryParam("priceout", ((Object[]) null));
                }
                if (groupid == null) {
                }
                if (groupid!= null) {
                    localUriBuilder = localUriBuilder.replaceQueryParam("groupid", groupid);
                } else {
                    localUriBuilder = localUriBuilder.replaceQueryParam("groupid", ((Object[]) null));
                }
                if (comment == null) {
                }
                if (comment!= null) {
                    localUriBuilder = localUriBuilder.replaceQueryParam("comment", comment);
                } else {
                    localUriBuilder = localUriBuilder.replaceQueryParam("comment", ((Object[]) null));
                }
                com.sun.jersey.api.client.WebResource resource = _client.resource(localUriBuilder.buildFromMap(_templateAndMatrixParameterValues));
                com.sun.jersey.api.client.WebResource.Builder resourceBuilder = resource.getRequestBuilder();
                resourceBuilder = resourceBuilder.accept("application/json");
                com.sun.jersey.api.client.ClientResponse response;
                response = resourceBuilder.method("POST", com.sun.jersey.api.client.ClientResponse.class);
                if (response.getStatus()>= 400) {
                    throw new RestService.WebApplicationExceptionMessage(Response.status(response.getClientResponseStatus()).build());
                }
                return response.getEntity(SimpleDataDTO.class);
            }

            public<T >T postAsJson(String name, Integer mincount, String barcode, Integer qtype, Integer pricein, Integer priceout, Integer groupid, String comment, com.sun.jersey.api.client.GenericType<T> returnType) {
                UriBuilder localUriBuilder = _uriBuilder.clone();
                if (name == null) {
                }
                if (name!= null) {
                    localUriBuilder = localUriBuilder.replaceQueryParam("name", name);
                } else {
                    localUriBuilder = localUriBuilder.replaceQueryParam("name", ((Object[]) null));
                }
                if (mincount == null) {
                }
                if (mincount!= null) {
                    localUriBuilder = localUriBuilder.replaceQueryParam("mincount", mincount);
                } else {
                    localUriBuilder = localUriBuilder.replaceQueryParam("mincount", ((Object[]) null));
                }
                if (barcode == null) {
                }
                if (barcode!= null) {
                    localUriBuilder = localUriBuilder.replaceQueryParam("barcode", barcode);
                } else {
                    localUriBuilder = localUriBuilder.replaceQueryParam("barcode", ((Object[]) null));
                }
                if (qtype == null) {
                }
                if (qtype!= null) {
                    localUriBuilder = localUriBuilder.replaceQueryParam("qtype", qtype);
                } else {
                    localUriBuilder = localUriBuilder.replaceQueryParam("qtype", ((Object[]) null));
                }
                if (pricein == null) {
                }
                if (pricein!= null) {
                    localUriBuilder = localUriBuilder.replaceQueryParam("pricein", pricein);
                } else {
                    localUriBuilder = localUriBuilder.replaceQueryParam("pricein", ((Object[]) null));
                }
                if (priceout == null) {
                }
                if (priceout!= null) {
                    localUriBuilder = localUriBuilder.replaceQueryParam("priceout", priceout);
                } else {
                    localUriBuilder = localUriBuilder.replaceQueryParam("priceout", ((Object[]) null));
                }
                if (groupid == null) {
                }
                if (groupid!= null) {
                    localUriBuilder = localUriBuilder.replaceQueryParam("groupid", groupid);
                } else {
                    localUriBuilder = localUriBuilder.replaceQueryParam("groupid", ((Object[]) null));
                }
                if (comment == null) {
                }
                if (comment!= null) {
                    localUriBuilder = localUriBuilder.replaceQueryParam("comment", comment);
                } else {
                    localUriBuilder = localUriBuilder.replaceQueryParam("comment", ((Object[]) null));
                }
                com.sun.jersey.api.client.WebResource resource = _client.resource(localUriBuilder.buildFromMap(_templateAndMatrixParameterValues));
                com.sun.jersey.api.client.WebResource.Builder resourceBuilder = resource.getRequestBuilder();
                resourceBuilder = resourceBuilder.accept("application/json");
                com.sun.jersey.api.client.ClientResponse response;
                response = resourceBuilder.method("POST", com.sun.jersey.api.client.ClientResponse.class);
                if (response.getStatus()>= 400) {
                    throw new RestService.WebApplicationExceptionMessage(Response.status(response.getClientResponseStatus()).build());
                }
                return response.getEntity(returnType);
            }

            public<T >T postAsJson(String name, Integer mincount, String barcode, Integer qtype, Integer pricein, Integer priceout, Integer groupid, String comment, Class<T> returnType) {
                UriBuilder localUriBuilder = _uriBuilder.clone();
                if (name == null) {
                }
                if (name!= null) {
                    localUriBuilder = localUriBuilder.replaceQueryParam("name", name);
                } else {
                    localUriBuilder = localUriBuilder.replaceQueryParam("name", ((Object[]) null));
                }
                if (mincount == null) {
                }
                if (mincount!= null) {
                    localUriBuilder = localUriBuilder.replaceQueryParam("mincount", mincount);
                } else {
                    localUriBuilder = localUriBuilder.replaceQueryParam("mincount", ((Object[]) null));
                }
                if (barcode == null) {
                }
                if (barcode!= null) {
                    localUriBuilder = localUriBuilder.replaceQueryParam("barcode", barcode);
                } else {
                    localUriBuilder = localUriBuilder.replaceQueryParam("barcode", ((Object[]) null));
                }
                if (qtype == null) {
                }
                if (qtype!= null) {
                    localUriBuilder = localUriBuilder.replaceQueryParam("qtype", qtype);
                } else {
                    localUriBuilder = localUriBuilder.replaceQueryParam("qtype", ((Object[]) null));
                }
                if (pricein == null) {
                }
                if (pricein!= null) {
                    localUriBuilder = localUriBuilder.replaceQueryParam("pricein", pricein);
                } else {
                    localUriBuilder = localUriBuilder.replaceQueryParam("pricein", ((Object[]) null));
                }
                if (priceout == null) {
                }
                if (priceout!= null) {
                    localUriBuilder = localUriBuilder.replaceQueryParam("priceout", priceout);
                } else {
                    localUriBuilder = localUriBuilder.replaceQueryParam("priceout", ((Object[]) null));
                }
                if (groupid == null) {
                }
                if (groupid!= null) {
                    localUriBuilder = localUriBuilder.replaceQueryParam("groupid", groupid);
                } else {
                    localUriBuilder = localUriBuilder.replaceQueryParam("groupid", ((Object[]) null));
                }
                if (comment == null) {
                }
                if (comment!= null) {
                    localUriBuilder = localUriBuilder.replaceQueryParam("comment", comment);
                } else {
                    localUriBuilder = localUriBuilder.replaceQueryParam("comment", ((Object[]) null));
                }
                com.sun.jersey.api.client.WebResource resource = _client.resource(localUriBuilder.buildFromMap(_templateAndMatrixParameterValues));
                com.sun.jersey.api.client.WebResource.Builder resourceBuilder = resource.getRequestBuilder();
                resourceBuilder = resourceBuilder.accept("application/json");
                com.sun.jersey.api.client.ClientResponse response;
                response = resourceBuilder.method("POST", com.sun.jersey.api.client.ClientResponse.class);
                if (!com.sun.jersey.api.client.ClientResponse.class.isAssignableFrom(returnType)) {
                    if (response.getStatus()>= 400) {
                        throw new RestService.WebApplicationExceptionMessage(Response.status(response.getClientResponseStatus()).build());
                    }
                }
                if (!com.sun.jersey.api.client.ClientResponse.class.isAssignableFrom(returnType)) {
                    return response.getEntity(returnType);
                } else {
                    return returnType.cast(response);
                }
            }

        }

    }

    public static class Sell {

        private com.sun.jersey.api.client.Client _client;
        private UriBuilder _uriBuilder;
        private Map<String, Object> _templateAndMatrixParameterValues;

        private Sell(com.sun.jersey.api.client.Client client, UriBuilder uriBuilder, Map<String, Object> map) {
            _client = client;
            _uriBuilder = uriBuilder.clone();
            _templateAndMatrixParameterValues = map;
        }

        /**
         * Create new instance using existing Client instance, and a base URI and any parameters
         * 
         */
        public Sell(com.sun.jersey.api.client.Client client, URI baseUri) {
            _client = client;
            _uriBuilder = UriBuilder.fromUri(baseUri);
            _uriBuilder = _uriBuilder.path("/sell/");
            _templateAndMatrixParameterValues = new HashMap<String, Object>();
        }

        public RestService.Sell.DoSellJson doSellJson() {
            return new RestService.Sell.DoSellJson(_client, _uriBuilder.buildFromMap(_templateAndMatrixParameterValues));
        }

        public RestService.Sell.DoGetJson doGetJson() {
            return new RestService.Sell.DoGetJson(_client, _uriBuilder.buildFromMap(_templateAndMatrixParameterValues));
        }

        public RestService.Sell.DoDeleteJson doDeleteJson() {
            return new RestService.Sell.DoDeleteJson(_client, _uriBuilder.buildFromMap(_templateAndMatrixParameterValues));
        }

        public RestService.Sell.DoListJson doListJson() {
            return new RestService.Sell.DoListJson(_client, _uriBuilder.buildFromMap(_templateAndMatrixParameterValues));
        }

        public static class DoDeleteJson {

            private com.sun.jersey.api.client.Client _client;
            private UriBuilder _uriBuilder;
            private Map<String, Object> _templateAndMatrixParameterValues;

            private DoDeleteJson(com.sun.jersey.api.client.Client client, UriBuilder uriBuilder, Map<String, Object> map) {
                _client = client;
                _uriBuilder = uriBuilder.clone();
                _templateAndMatrixParameterValues = map;
            }

            /**
             * Create new instance using existing Client instance, and a base URI and any parameters
             * 
             */
            public DoDeleteJson(com.sun.jersey.api.client.Client client, URI baseUri) {
                _client = client;
                _uriBuilder = UriBuilder.fromUri(baseUri);
                _uriBuilder = _uriBuilder.path("do.delete.json");
                _templateAndMatrixParameterValues = new HashMap<String, Object>();
            }

            public SimpleDataDTO getAsSimpleDataDTO() {
                UriBuilder localUriBuilder = _uriBuilder.clone();
                com.sun.jersey.api.client.WebResource resource = _client.resource(localUriBuilder.buildFromMap(_templateAndMatrixParameterValues));
                com.sun.jersey.api.client.WebResource.Builder resourceBuilder = resource.getRequestBuilder();
                resourceBuilder = resourceBuilder.accept("application/json");
                com.sun.jersey.api.client.ClientResponse response;
                response = resourceBuilder.method("GET", com.sun.jersey.api.client.ClientResponse.class);
                if (response.getStatus()>= 400) {
                    throw new RestService.WebApplicationExceptionMessage(Response.status(response.getClientResponseStatus()).build());
                }
                return response.getEntity(SimpleDataDTO.class);
            }

            public<T >T getAsJson(com.sun.jersey.api.client.GenericType<T> returnType) {
                UriBuilder localUriBuilder = _uriBuilder.clone();
                com.sun.jersey.api.client.WebResource resource = _client.resource(localUriBuilder.buildFromMap(_templateAndMatrixParameterValues));
                com.sun.jersey.api.client.WebResource.Builder resourceBuilder = resource.getRequestBuilder();
                resourceBuilder = resourceBuilder.accept("application/json");
                com.sun.jersey.api.client.ClientResponse response;
                response = resourceBuilder.method("GET", com.sun.jersey.api.client.ClientResponse.class);
                if (response.getStatus()>= 400) {
                    throw new RestService.WebApplicationExceptionMessage(Response.status(response.getClientResponseStatus()).build());
                }
                return response.getEntity(returnType);
            }

            public<T >T getAsJson(Class<T> returnType) {
                UriBuilder localUriBuilder = _uriBuilder.clone();
                com.sun.jersey.api.client.WebResource resource = _client.resource(localUriBuilder.buildFromMap(_templateAndMatrixParameterValues));
                com.sun.jersey.api.client.WebResource.Builder resourceBuilder = resource.getRequestBuilder();
                resourceBuilder = resourceBuilder.accept("application/json");
                com.sun.jersey.api.client.ClientResponse response;
                response = resourceBuilder.method("GET", com.sun.jersey.api.client.ClientResponse.class);
                if (!com.sun.jersey.api.client.ClientResponse.class.isAssignableFrom(returnType)) {
                    if (response.getStatus()>= 400) {
                        throw new RestService.WebApplicationExceptionMessage(Response.status(response.getClientResponseStatus()).build());
                    }
                }
                if (!com.sun.jersey.api.client.ClientResponse.class.isAssignableFrom(returnType)) {
                    return response.getEntity(returnType);
                } else {
                    return returnType.cast(response);
                }
            }

            public SimpleDataDTO getAsSimpleDataDTO(Integer id) {
                UriBuilder localUriBuilder = _uriBuilder.clone();
                if (id == null) {
                }
                if (id!= null) {
                    localUriBuilder = localUriBuilder.replaceQueryParam("id", id);
                } else {
                    localUriBuilder = localUriBuilder.replaceQueryParam("id", ((Object[]) null));
                }
                com.sun.jersey.api.client.WebResource resource = _client.resource(localUriBuilder.buildFromMap(_templateAndMatrixParameterValues));
                com.sun.jersey.api.client.WebResource.Builder resourceBuilder = resource.getRequestBuilder();
                resourceBuilder = resourceBuilder.accept("application/json");
                com.sun.jersey.api.client.ClientResponse response;
                response = resourceBuilder.method("GET", com.sun.jersey.api.client.ClientResponse.class);
                if (response.getStatus()>= 400) {
                    throw new RestService.WebApplicationExceptionMessage(Response.status(response.getClientResponseStatus()).build());
                }
                return response.getEntity(SimpleDataDTO.class);
            }

            public<T >T getAsJson(Integer id, com.sun.jersey.api.client.GenericType<T> returnType) {
                UriBuilder localUriBuilder = _uriBuilder.clone();
                if (id == null) {
                }
                if (id!= null) {
                    localUriBuilder = localUriBuilder.replaceQueryParam("id", id);
                } else {
                    localUriBuilder = localUriBuilder.replaceQueryParam("id", ((Object[]) null));
                }
                com.sun.jersey.api.client.WebResource resource = _client.resource(localUriBuilder.buildFromMap(_templateAndMatrixParameterValues));
                com.sun.jersey.api.client.WebResource.Builder resourceBuilder = resource.getRequestBuilder();
                resourceBuilder = resourceBuilder.accept("application/json");
                com.sun.jersey.api.client.ClientResponse response;
                response = resourceBuilder.method("GET", com.sun.jersey.api.client.ClientResponse.class);
                if (response.getStatus()>= 400) {
                    throw new RestService.WebApplicationExceptionMessage(Response.status(response.getClientResponseStatus()).build());
                }
                return response.getEntity(returnType);
            }

            public<T >T getAsJson(Integer id, Class<T> returnType) {
                UriBuilder localUriBuilder = _uriBuilder.clone();
                if (id == null) {
                }
                if (id!= null) {
                    localUriBuilder = localUriBuilder.replaceQueryParam("id", id);
                } else {
                    localUriBuilder = localUriBuilder.replaceQueryParam("id", ((Object[]) null));
                }
                com.sun.jersey.api.client.WebResource resource = _client.resource(localUriBuilder.buildFromMap(_templateAndMatrixParameterValues));
                com.sun.jersey.api.client.WebResource.Builder resourceBuilder = resource.getRequestBuilder();
                resourceBuilder = resourceBuilder.accept("application/json");
                com.sun.jersey.api.client.ClientResponse response;
                response = resourceBuilder.method("GET", com.sun.jersey.api.client.ClientResponse.class);
                if (!com.sun.jersey.api.client.ClientResponse.class.isAssignableFrom(returnType)) {
                    if (response.getStatus()>= 400) {
                        throw new RestService.WebApplicationExceptionMessage(Response.status(response.getClientResponseStatus()).build());
                    }
                }
                if (!com.sun.jersey.api.client.ClientResponse.class.isAssignableFrom(returnType)) {
                    return response.getEntity(returnType);
                } else {
                    return returnType.cast(response);
                }
            }

        }

        public static class DoGetJson {

            private com.sun.jersey.api.client.Client _client;
            private UriBuilder _uriBuilder;
            private Map<String, Object> _templateAndMatrixParameterValues;

            private DoGetJson(com.sun.jersey.api.client.Client client, UriBuilder uriBuilder, Map<String, Object> map) {
                _client = client;
                _uriBuilder = uriBuilder.clone();
                _templateAndMatrixParameterValues = map;
            }

            /**
             * Create new instance using existing Client instance, and a base URI and any parameters
             * 
             */
            public DoGetJson(com.sun.jersey.api.client.Client client, URI baseUri) {
                _client = client;
                _uriBuilder = UriBuilder.fromUri(baseUri);
                _uriBuilder = _uriBuilder.path("do.get.json");
                _templateAndMatrixParameterValues = new HashMap<String, Object>();
            }

            public SellDTO getAsSellDTO() {
                UriBuilder localUriBuilder = _uriBuilder.clone();
                com.sun.jersey.api.client.WebResource resource = _client.resource(localUriBuilder.buildFromMap(_templateAndMatrixParameterValues));
                com.sun.jersey.api.client.WebResource.Builder resourceBuilder = resource.getRequestBuilder();
                resourceBuilder = resourceBuilder.accept("application/json");
                com.sun.jersey.api.client.ClientResponse response;
                response = resourceBuilder.method("GET", com.sun.jersey.api.client.ClientResponse.class);
                if (response.getStatus()>= 400) {
                    throw new RestService.WebApplicationExceptionMessage(Response.status(response.getClientResponseStatus()).build());
                }
                return response.getEntity(SellDTO.class);
            }

            public<T >T getAsJson(com.sun.jersey.api.client.GenericType<T> returnType) {
                UriBuilder localUriBuilder = _uriBuilder.clone();
                com.sun.jersey.api.client.WebResource resource = _client.resource(localUriBuilder.buildFromMap(_templateAndMatrixParameterValues));
                com.sun.jersey.api.client.WebResource.Builder resourceBuilder = resource.getRequestBuilder();
                resourceBuilder = resourceBuilder.accept("application/json");
                com.sun.jersey.api.client.ClientResponse response;
                response = resourceBuilder.method("GET", com.sun.jersey.api.client.ClientResponse.class);
                if (response.getStatus()>= 400) {
                    throw new RestService.WebApplicationExceptionMessage(Response.status(response.getClientResponseStatus()).build());
                }
                return response.getEntity(returnType);
            }

            public<T >T getAsJson(Class<T> returnType) {
                UriBuilder localUriBuilder = _uriBuilder.clone();
                com.sun.jersey.api.client.WebResource resource = _client.resource(localUriBuilder.buildFromMap(_templateAndMatrixParameterValues));
                com.sun.jersey.api.client.WebResource.Builder resourceBuilder = resource.getRequestBuilder();
                resourceBuilder = resourceBuilder.accept("application/json");
                com.sun.jersey.api.client.ClientResponse response;
                response = resourceBuilder.method("GET", com.sun.jersey.api.client.ClientResponse.class);
                if (!com.sun.jersey.api.client.ClientResponse.class.isAssignableFrom(returnType)) {
                    if (response.getStatus()>= 400) {
                        throw new RestService.WebApplicationExceptionMessage(Response.status(response.getClientResponseStatus()).build());
                    }
                }
                if (!com.sun.jersey.api.client.ClientResponse.class.isAssignableFrom(returnType)) {
                    return response.getEntity(returnType);
                } else {
                    return returnType.cast(response);
                }
            }

            public SellDTO getAsSellDTO(Integer id) {
                UriBuilder localUriBuilder = _uriBuilder.clone();
                if (id == null) {
                }
                if (id!= null) {
                    localUriBuilder = localUriBuilder.replaceQueryParam("id", id);
                } else {
                    localUriBuilder = localUriBuilder.replaceQueryParam("id", ((Object[]) null));
                }
                com.sun.jersey.api.client.WebResource resource = _client.resource(localUriBuilder.buildFromMap(_templateAndMatrixParameterValues));
                com.sun.jersey.api.client.WebResource.Builder resourceBuilder = resource.getRequestBuilder();
                resourceBuilder = resourceBuilder.accept("application/json");
                com.sun.jersey.api.client.ClientResponse response;
                response = resourceBuilder.method("GET", com.sun.jersey.api.client.ClientResponse.class);
                if (response.getStatus()>= 400) {
                    throw new RestService.WebApplicationExceptionMessage(Response.status(response.getClientResponseStatus()).build());
                }
                return response.getEntity(SellDTO.class);
            }

            public<T >T getAsJson(Integer id, com.sun.jersey.api.client.GenericType<T> returnType) {
                UriBuilder localUriBuilder = _uriBuilder.clone();
                if (id == null) {
                }
                if (id!= null) {
                    localUriBuilder = localUriBuilder.replaceQueryParam("id", id);
                } else {
                    localUriBuilder = localUriBuilder.replaceQueryParam("id", ((Object[]) null));
                }
                com.sun.jersey.api.client.WebResource resource = _client.resource(localUriBuilder.buildFromMap(_templateAndMatrixParameterValues));
                com.sun.jersey.api.client.WebResource.Builder resourceBuilder = resource.getRequestBuilder();
                resourceBuilder = resourceBuilder.accept("application/json");
                com.sun.jersey.api.client.ClientResponse response;
                response = resourceBuilder.method("GET", com.sun.jersey.api.client.ClientResponse.class);
                if (response.getStatus()>= 400) {
                    throw new RestService.WebApplicationExceptionMessage(Response.status(response.getClientResponseStatus()).build());
                }
                return response.getEntity(returnType);
            }

            public<T >T getAsJson(Integer id, Class<T> returnType) {
                UriBuilder localUriBuilder = _uriBuilder.clone();
                if (id == null) {
                }
                if (id!= null) {
                    localUriBuilder = localUriBuilder.replaceQueryParam("id", id);
                } else {
                    localUriBuilder = localUriBuilder.replaceQueryParam("id", ((Object[]) null));
                }
                com.sun.jersey.api.client.WebResource resource = _client.resource(localUriBuilder.buildFromMap(_templateAndMatrixParameterValues));
                com.sun.jersey.api.client.WebResource.Builder resourceBuilder = resource.getRequestBuilder();
                resourceBuilder = resourceBuilder.accept("application/json");
                com.sun.jersey.api.client.ClientResponse response;
                response = resourceBuilder.method("GET", com.sun.jersey.api.client.ClientResponse.class);
                if (!com.sun.jersey.api.client.ClientResponse.class.isAssignableFrom(returnType)) {
                    if (response.getStatus()>= 400) {
                        throw new RestService.WebApplicationExceptionMessage(Response.status(response.getClientResponseStatus()).build());
                    }
                }
                if (!com.sun.jersey.api.client.ClientResponse.class.isAssignableFrom(returnType)) {
                    return response.getEntity(returnType);
                } else {
                    return returnType.cast(response);
                }
            }

        }

        public static class DoListJson {

            private com.sun.jersey.api.client.Client _client;
            private UriBuilder _uriBuilder;
            private Map<String, Object> _templateAndMatrixParameterValues;

            private DoListJson(com.sun.jersey.api.client.Client client, UriBuilder uriBuilder, Map<String, Object> map) {
                _client = client;
                _uriBuilder = uriBuilder.clone();
                _templateAndMatrixParameterValues = map;
            }

            /**
             * Create new instance using existing Client instance, and a base URI and any parameters
             * 
             */
            public DoListJson(com.sun.jersey.api.client.Client client, URI baseUri) {
                _client = client;
                _uriBuilder = UriBuilder.fromUri(baseUri);
                _uriBuilder = _uriBuilder.path("do.list.json");
                _templateAndMatrixParameterValues = new HashMap<String, Object>();
            }

            public ListDTO getAsListDTO() {
                UriBuilder localUriBuilder = _uriBuilder.clone();
                com.sun.jersey.api.client.WebResource resource = _client.resource(localUriBuilder.buildFromMap(_templateAndMatrixParameterValues));
                com.sun.jersey.api.client.WebResource.Builder resourceBuilder = resource.getRequestBuilder();
                resourceBuilder = resourceBuilder.accept("application/json");
                com.sun.jersey.api.client.ClientResponse response;
                response = resourceBuilder.method("GET", com.sun.jersey.api.client.ClientResponse.class);
                if (response.getStatus()>= 400) {
                    throw new RestService.WebApplicationExceptionMessage(Response.status(response.getClientResponseStatus()).build());
                }
                return response.getEntity(ListDTO.class);
            }

            public<T >T getAsJson(com.sun.jersey.api.client.GenericType<T> returnType) {
                UriBuilder localUriBuilder = _uriBuilder.clone();
                com.sun.jersey.api.client.WebResource resource = _client.resource(localUriBuilder.buildFromMap(_templateAndMatrixParameterValues));
                com.sun.jersey.api.client.WebResource.Builder resourceBuilder = resource.getRequestBuilder();
                resourceBuilder = resourceBuilder.accept("application/json");
                com.sun.jersey.api.client.ClientResponse response;
                response = resourceBuilder.method("GET", com.sun.jersey.api.client.ClientResponse.class);
                if (response.getStatus()>= 400) {
                    throw new RestService.WebApplicationExceptionMessage(Response.status(response.getClientResponseStatus()).build());
                }
                return response.getEntity(returnType);
            }

            public<T >T getAsJson(Class<T> returnType) {
                UriBuilder localUriBuilder = _uriBuilder.clone();
                com.sun.jersey.api.client.WebResource resource = _client.resource(localUriBuilder.buildFromMap(_templateAndMatrixParameterValues));
                com.sun.jersey.api.client.WebResource.Builder resourceBuilder = resource.getRequestBuilder();
                resourceBuilder = resourceBuilder.accept("application/json");
                com.sun.jersey.api.client.ClientResponse response;
                response = resourceBuilder.method("GET", com.sun.jersey.api.client.ClientResponse.class);
                if (!com.sun.jersey.api.client.ClientResponse.class.isAssignableFrom(returnType)) {
                    if (response.getStatus()>= 400) {
                        throw new RestService.WebApplicationExceptionMessage(Response.status(response.getClientResponseStatus()).build());
                    }
                }
                if (!com.sun.jersey.api.client.ClientResponse.class.isAssignableFrom(returnType)) {
                    return response.getEntity(returnType);
                } else {
                    return returnType.cast(response);
                }
            }

            public ListDTO getAsListDTO(Boolean all, Integer page, Integer perpage) {
                UriBuilder localUriBuilder = _uriBuilder.clone();
                if (all == null) {
                }
                if (all!= null) {
                    localUriBuilder = localUriBuilder.replaceQueryParam("all", all);
                } else {
                    localUriBuilder = localUriBuilder.replaceQueryParam("all", ((Object[]) null));
                }
                if (page == null) {
                }
                if (page!= null) {
                    localUriBuilder = localUriBuilder.replaceQueryParam("page", page);
                } else {
                    localUriBuilder = localUriBuilder.replaceQueryParam("page", ((Object[]) null));
                }
                if (perpage == null) {
                }
                if (perpage!= null) {
                    localUriBuilder = localUriBuilder.replaceQueryParam("perpage", perpage);
                } else {
                    localUriBuilder = localUriBuilder.replaceQueryParam("perpage", ((Object[]) null));
                }
                com.sun.jersey.api.client.WebResource resource = _client.resource(localUriBuilder.buildFromMap(_templateAndMatrixParameterValues));
                com.sun.jersey.api.client.WebResource.Builder resourceBuilder = resource.getRequestBuilder();
                resourceBuilder = resourceBuilder.accept("application/json");
                com.sun.jersey.api.client.ClientResponse response;
                response = resourceBuilder.method("GET", com.sun.jersey.api.client.ClientResponse.class);
                if (response.getStatus()>= 400) {
                    throw new RestService.WebApplicationExceptionMessage(Response.status(response.getClientResponseStatus()).build());
                }
                return response.getEntity(ListDTO.class);
            }

            public<T >T getAsJson(Boolean all, Integer page, Integer perpage, com.sun.jersey.api.client.GenericType<T> returnType) {
                UriBuilder localUriBuilder = _uriBuilder.clone();
                if (all == null) {
                }
                if (all!= null) {
                    localUriBuilder = localUriBuilder.replaceQueryParam("all", all);
                } else {
                    localUriBuilder = localUriBuilder.replaceQueryParam("all", ((Object[]) null));
                }
                if (page == null) {
                }
                if (page!= null) {
                    localUriBuilder = localUriBuilder.replaceQueryParam("page", page);
                } else {
                    localUriBuilder = localUriBuilder.replaceQueryParam("page", ((Object[]) null));
                }
                if (perpage == null) {
                }
                if (perpage!= null) {
                    localUriBuilder = localUriBuilder.replaceQueryParam("perpage", perpage);
                } else {
                    localUriBuilder = localUriBuilder.replaceQueryParam("perpage", ((Object[]) null));
                }
                com.sun.jersey.api.client.WebResource resource = _client.resource(localUriBuilder.buildFromMap(_templateAndMatrixParameterValues));
                com.sun.jersey.api.client.WebResource.Builder resourceBuilder = resource.getRequestBuilder();
                resourceBuilder = resourceBuilder.accept("application/json");
                com.sun.jersey.api.client.ClientResponse response;
                response = resourceBuilder.method("GET", com.sun.jersey.api.client.ClientResponse.class);
                if (response.getStatus()>= 400) {
                    throw new RestService.WebApplicationExceptionMessage(Response.status(response.getClientResponseStatus()).build());
                }
                return response.getEntity(returnType);
            }

            public<T >T getAsJson(Boolean all, Integer page, Integer perpage, Class<T> returnType) {
                UriBuilder localUriBuilder = _uriBuilder.clone();
                if (all == null) {
                }
                if (all!= null) {
                    localUriBuilder = localUriBuilder.replaceQueryParam("all", all);
                } else {
                    localUriBuilder = localUriBuilder.replaceQueryParam("all", ((Object[]) null));
                }
                if (page == null) {
                }
                if (page!= null) {
                    localUriBuilder = localUriBuilder.replaceQueryParam("page", page);
                } else {
                    localUriBuilder = localUriBuilder.replaceQueryParam("page", ((Object[]) null));
                }
                if (perpage == null) {
                }
                if (perpage!= null) {
                    localUriBuilder = localUriBuilder.replaceQueryParam("perpage", perpage);
                } else {
                    localUriBuilder = localUriBuilder.replaceQueryParam("perpage", ((Object[]) null));
                }
                com.sun.jersey.api.client.WebResource resource = _client.resource(localUriBuilder.buildFromMap(_templateAndMatrixParameterValues));
                com.sun.jersey.api.client.WebResource.Builder resourceBuilder = resource.getRequestBuilder();
                resourceBuilder = resourceBuilder.accept("application/json");
                com.sun.jersey.api.client.ClientResponse response;
                response = resourceBuilder.method("GET", com.sun.jersey.api.client.ClientResponse.class);
                if (!com.sun.jersey.api.client.ClientResponse.class.isAssignableFrom(returnType)) {
                    if (response.getStatus()>= 400) {
                        throw new RestService.WebApplicationExceptionMessage(Response.status(response.getClientResponseStatus()).build());
                    }
                }
                if (!com.sun.jersey.api.client.ClientResponse.class.isAssignableFrom(returnType)) {
                    return response.getEntity(returnType);
                } else {
                    return returnType.cast(response);
                }
            }

        }

        public static class DoSellJson {

            private com.sun.jersey.api.client.Client _client;
            private UriBuilder _uriBuilder;
            private Map<String, Object> _templateAndMatrixParameterValues;

            private DoSellJson(com.sun.jersey.api.client.Client client, UriBuilder uriBuilder, Map<String, Object> map) {
                _client = client;
                _uriBuilder = uriBuilder.clone();
                _templateAndMatrixParameterValues = map;
            }

            /**
             * Create new instance using existing Client instance, and a base URI and any parameters
             * 
             */
            public DoSellJson(com.sun.jersey.api.client.Client client, URI baseUri) {
                _client = client;
                _uriBuilder = UriBuilder.fromUri(baseUri);
                _uriBuilder = _uriBuilder.path("do.sell.json");
                _templateAndMatrixParameterValues = new HashMap<String, Object>();
            }

            public SimpleDataDTO postAsSimpleDataDTO() {
                UriBuilder localUriBuilder = _uriBuilder.clone();
                com.sun.jersey.api.client.WebResource resource = _client.resource(localUriBuilder.buildFromMap(_templateAndMatrixParameterValues));
                com.sun.jersey.api.client.WebResource.Builder resourceBuilder = resource.getRequestBuilder();
                resourceBuilder = resourceBuilder.accept("application/json");
                com.sun.jersey.api.client.ClientResponse response;
                response = resourceBuilder.method("POST", com.sun.jersey.api.client.ClientResponse.class);
                if (response.getStatus()>= 400) {
                    throw new RestService.WebApplicationExceptionMessage(Response.status(response.getClientResponseStatus()).build());
                }
                return response.getEntity(SimpleDataDTO.class);
            }

            public<T >T postAsJson(com.sun.jersey.api.client.GenericType<T> returnType) {
                UriBuilder localUriBuilder = _uriBuilder.clone();
                com.sun.jersey.api.client.WebResource resource = _client.resource(localUriBuilder.buildFromMap(_templateAndMatrixParameterValues));
                com.sun.jersey.api.client.WebResource.Builder resourceBuilder = resource.getRequestBuilder();
                resourceBuilder = resourceBuilder.accept("application/json");
                com.sun.jersey.api.client.ClientResponse response;
                response = resourceBuilder.method("POST", com.sun.jersey.api.client.ClientResponse.class);
                if (response.getStatus()>= 400) {
                    throw new RestService.WebApplicationExceptionMessage(Response.status(response.getClientResponseStatus()).build());
                }
                return response.getEntity(returnType);
            }

            public<T >T postAsJson(Class<T> returnType) {
                UriBuilder localUriBuilder = _uriBuilder.clone();
                com.sun.jersey.api.client.WebResource resource = _client.resource(localUriBuilder.buildFromMap(_templateAndMatrixParameterValues));
                com.sun.jersey.api.client.WebResource.Builder resourceBuilder = resource.getRequestBuilder();
                resourceBuilder = resourceBuilder.accept("application/json");
                com.sun.jersey.api.client.ClientResponse response;
                response = resourceBuilder.method("POST", com.sun.jersey.api.client.ClientResponse.class);
                if (!com.sun.jersey.api.client.ClientResponse.class.isAssignableFrom(returnType)) {
                    if (response.getStatus()>= 400) {
                        throw new RestService.WebApplicationExceptionMessage(Response.status(response.getClientResponseStatus()).build());
                    }
                }
                if (!com.sun.jersey.api.client.ClientResponse.class.isAssignableFrom(returnType)) {
                    return response.getEntity(returnType);
                } else {
                    return returnType.cast(response);
                }
            }

            public SimpleDataDTO postAsSimpleDataDTO(String counts, String products) {
                UriBuilder localUriBuilder = _uriBuilder.clone();
                if (counts == null) {
                }
                if (counts!= null) {
                    localUriBuilder = localUriBuilder.replaceQueryParam("counts", counts);
                } else {
                    localUriBuilder = localUriBuilder.replaceQueryParam("counts", ((Object[]) null));
                }
                if (products == null) {
                }
                if (products!= null) {
                    localUriBuilder = localUriBuilder.replaceQueryParam("products", products);
                } else {
                    localUriBuilder = localUriBuilder.replaceQueryParam("products", ((Object[]) null));
                }
                com.sun.jersey.api.client.WebResource resource = _client.resource(localUriBuilder.buildFromMap(_templateAndMatrixParameterValues));
                com.sun.jersey.api.client.WebResource.Builder resourceBuilder = resource.getRequestBuilder();
                resourceBuilder = resourceBuilder.accept("application/json");
                com.sun.jersey.api.client.ClientResponse response;
                response = resourceBuilder.method("POST", com.sun.jersey.api.client.ClientResponse.class);
                if (response.getStatus()>= 400) {
                    throw new RestService.WebApplicationExceptionMessage(Response.status(response.getClientResponseStatus()).build());
                }
                return response.getEntity(SimpleDataDTO.class);
            }

            public<T >T postAsJson(String counts, String products, com.sun.jersey.api.client.GenericType<T> returnType) {
                UriBuilder localUriBuilder = _uriBuilder.clone();
                if (counts == null) {
                }
                if (counts!= null) {
                    localUriBuilder = localUriBuilder.replaceQueryParam("counts", counts);
                } else {
                    localUriBuilder = localUriBuilder.replaceQueryParam("counts", ((Object[]) null));
                }
                if (products == null) {
                }
                if (products!= null) {
                    localUriBuilder = localUriBuilder.replaceQueryParam("products", products);
                } else {
                    localUriBuilder = localUriBuilder.replaceQueryParam("products", ((Object[]) null));
                }
                com.sun.jersey.api.client.WebResource resource = _client.resource(localUriBuilder.buildFromMap(_templateAndMatrixParameterValues));
                com.sun.jersey.api.client.WebResource.Builder resourceBuilder = resource.getRequestBuilder();
                resourceBuilder = resourceBuilder.accept("application/json");
                com.sun.jersey.api.client.ClientResponse response;
                response = resourceBuilder.method("POST", com.sun.jersey.api.client.ClientResponse.class);
                if (response.getStatus()>= 400) {
                    throw new RestService.WebApplicationExceptionMessage(Response.status(response.getClientResponseStatus()).build());
                }
                return response.getEntity(returnType);
            }

            public<T >T postAsJson(String counts, String products, Class<T> returnType) {
                UriBuilder localUriBuilder = _uriBuilder.clone();
                if (counts == null) {
                }
                if (counts!= null) {
                    localUriBuilder = localUriBuilder.replaceQueryParam("counts", counts);
                } else {
                    localUriBuilder = localUriBuilder.replaceQueryParam("counts", ((Object[]) null));
                }
                if (products == null) {
                }
                if (products!= null) {
                    localUriBuilder = localUriBuilder.replaceQueryParam("products", products);
                } else {
                    localUriBuilder = localUriBuilder.replaceQueryParam("products", ((Object[]) null));
                }
                com.sun.jersey.api.client.WebResource resource = _client.resource(localUriBuilder.buildFromMap(_templateAndMatrixParameterValues));
                com.sun.jersey.api.client.WebResource.Builder resourceBuilder = resource.getRequestBuilder();
                resourceBuilder = resourceBuilder.accept("application/json");
                com.sun.jersey.api.client.ClientResponse response;
                response = resourceBuilder.method("POST", com.sun.jersey.api.client.ClientResponse.class);
                if (!com.sun.jersey.api.client.ClientResponse.class.isAssignableFrom(returnType)) {
                    if (response.getStatus()>= 400) {
                        throw new RestService.WebApplicationExceptionMessage(Response.status(response.getClientResponseStatus()).build());
                    }
                }
                if (!com.sun.jersey.api.client.ClientResponse.class.isAssignableFrom(returnType)) {
                    return response.getEntity(returnType);
                } else {
                    return returnType.cast(response);
                }
            }

        }

    }

    public static class Store {

        private com.sun.jersey.api.client.Client _client;
        private UriBuilder _uriBuilder;
        private Map<String, Object> _templateAndMatrixParameterValues;

        private Store(com.sun.jersey.api.client.Client client, UriBuilder uriBuilder, Map<String, Object> map) {
            _client = client;
            _uriBuilder = uriBuilder.clone();
            _templateAndMatrixParameterValues = map;
        }

        /**
         * Create new instance using existing Client instance, and a base URI and any parameters
         * 
         */
        public Store(com.sun.jersey.api.client.Client client, URI baseUri) {
            _client = client;
            _uriBuilder = UriBuilder.fromUri(baseUri);
            _uriBuilder = _uriBuilder.path("/store/");
            _templateAndMatrixParameterValues = new HashMap<String, Object>();
        }

        public RestService.Store.DoUpdateJson doUpdateJson() {
            return new RestService.Store.DoUpdateJson(_client, _uriBuilder.buildFromMap(_templateAndMatrixParameterValues));
        }

        public RestService.Store.DoCreateJson doCreateJson() {
            return new RestService.Store.DoCreateJson(_client, _uriBuilder.buildFromMap(_templateAndMatrixParameterValues));
        }

        public RestService.Store.DoGetJson doGetJson() {
            return new RestService.Store.DoGetJson(_client, _uriBuilder.buildFromMap(_templateAndMatrixParameterValues));
        }

        public RestService.Store.DoDeleteJson doDeleteJson() {
            return new RestService.Store.DoDeleteJson(_client, _uriBuilder.buildFromMap(_templateAndMatrixParameterValues));
        }

        public RestService.Store.DoListJson doListJson() {
            return new RestService.Store.DoListJson(_client, _uriBuilder.buildFromMap(_templateAndMatrixParameterValues));
        }

        public static class DoCreateJson {

            private com.sun.jersey.api.client.Client _client;
            private UriBuilder _uriBuilder;
            private Map<String, Object> _templateAndMatrixParameterValues;

            private DoCreateJson(com.sun.jersey.api.client.Client client, UriBuilder uriBuilder, Map<String, Object> map) {
                _client = client;
                _uriBuilder = uriBuilder.clone();
                _templateAndMatrixParameterValues = map;
            }

            /**
             * Create new instance using existing Client instance, and a base URI and any parameters
             * 
             */
            public DoCreateJson(com.sun.jersey.api.client.Client client, URI baseUri) {
                _client = client;
                _uriBuilder = UriBuilder.fromUri(baseUri);
                _uriBuilder = _uriBuilder.path("do.create.json");
                _templateAndMatrixParameterValues = new HashMap<String, Object>();
            }

            public SimpleDataDTO postAsSimpleDataDTO() {
                UriBuilder localUriBuilder = _uriBuilder.clone();
                com.sun.jersey.api.client.WebResource resource = _client.resource(localUriBuilder.buildFromMap(_templateAndMatrixParameterValues));
                com.sun.jersey.api.client.WebResource.Builder resourceBuilder = resource.getRequestBuilder();
                resourceBuilder = resourceBuilder.accept("application/json");
                com.sun.jersey.api.client.ClientResponse response;
                response = resourceBuilder.method("POST", com.sun.jersey.api.client.ClientResponse.class);
                if (response.getStatus()>= 400) {
                    throw new RestService.WebApplicationExceptionMessage(Response.status(response.getClientResponseStatus()).build());
                }
                return response.getEntity(SimpleDataDTO.class);
            }

            public<T >T postAsJson(com.sun.jersey.api.client.GenericType<T> returnType) {
                UriBuilder localUriBuilder = _uriBuilder.clone();
                com.sun.jersey.api.client.WebResource resource = _client.resource(localUriBuilder.buildFromMap(_templateAndMatrixParameterValues));
                com.sun.jersey.api.client.WebResource.Builder resourceBuilder = resource.getRequestBuilder();
                resourceBuilder = resourceBuilder.accept("application/json");
                com.sun.jersey.api.client.ClientResponse response;
                response = resourceBuilder.method("POST", com.sun.jersey.api.client.ClientResponse.class);
                if (response.getStatus()>= 400) {
                    throw new RestService.WebApplicationExceptionMessage(Response.status(response.getClientResponseStatus()).build());
                }
                return response.getEntity(returnType);
            }

            public<T >T postAsJson(Class<T> returnType) {
                UriBuilder localUriBuilder = _uriBuilder.clone();
                com.sun.jersey.api.client.WebResource resource = _client.resource(localUriBuilder.buildFromMap(_templateAndMatrixParameterValues));
                com.sun.jersey.api.client.WebResource.Builder resourceBuilder = resource.getRequestBuilder();
                resourceBuilder = resourceBuilder.accept("application/json");
                com.sun.jersey.api.client.ClientResponse response;
                response = resourceBuilder.method("POST", com.sun.jersey.api.client.ClientResponse.class);
                if (!com.sun.jersey.api.client.ClientResponse.class.isAssignableFrom(returnType)) {
                    if (response.getStatus()>= 400) {
                        throw new RestService.WebApplicationExceptionMessage(Response.status(response.getClientResponseStatus()).build());
                    }
                }
                if (!com.sun.jersey.api.client.ClientResponse.class.isAssignableFrom(returnType)) {
                    return response.getEntity(returnType);
                } else {
                    return returnType.cast(response);
                }
            }

            public SimpleDataDTO postAsSimpleDataDTO(Integer product, Integer count) {
                UriBuilder localUriBuilder = _uriBuilder.clone();
                if (product == null) {
                }
                if (product!= null) {
                    localUriBuilder = localUriBuilder.replaceQueryParam("product", product);
                } else {
                    localUriBuilder = localUriBuilder.replaceQueryParam("product", ((Object[]) null));
                }
                if (count == null) {
                }
                if (count!= null) {
                    localUriBuilder = localUriBuilder.replaceQueryParam("count", count);
                } else {
                    localUriBuilder = localUriBuilder.replaceQueryParam("count", ((Object[]) null));
                }
                com.sun.jersey.api.client.WebResource resource = _client.resource(localUriBuilder.buildFromMap(_templateAndMatrixParameterValues));
                com.sun.jersey.api.client.WebResource.Builder resourceBuilder = resource.getRequestBuilder();
                resourceBuilder = resourceBuilder.accept("application/json");
                com.sun.jersey.api.client.ClientResponse response;
                response = resourceBuilder.method("POST", com.sun.jersey.api.client.ClientResponse.class);
                if (response.getStatus()>= 400) {
                    throw new RestService.WebApplicationExceptionMessage(Response.status(response.getClientResponseStatus()).build());
                }
                return response.getEntity(SimpleDataDTO.class);
            }

            public<T >T postAsJson(Integer product, Integer count, com.sun.jersey.api.client.GenericType<T> returnType) {
                UriBuilder localUriBuilder = _uriBuilder.clone();
                if (product == null) {
                }
                if (product!= null) {
                    localUriBuilder = localUriBuilder.replaceQueryParam("product", product);
                } else {
                    localUriBuilder = localUriBuilder.replaceQueryParam("product", ((Object[]) null));
                }
                if (count == null) {
                }
                if (count!= null) {
                    localUriBuilder = localUriBuilder.replaceQueryParam("count", count);
                } else {
                    localUriBuilder = localUriBuilder.replaceQueryParam("count", ((Object[]) null));
                }
                com.sun.jersey.api.client.WebResource resource = _client.resource(localUriBuilder.buildFromMap(_templateAndMatrixParameterValues));
                com.sun.jersey.api.client.WebResource.Builder resourceBuilder = resource.getRequestBuilder();
                resourceBuilder = resourceBuilder.accept("application/json");
                com.sun.jersey.api.client.ClientResponse response;
                response = resourceBuilder.method("POST", com.sun.jersey.api.client.ClientResponse.class);
                if (response.getStatus()>= 400) {
                    throw new RestService.WebApplicationExceptionMessage(Response.status(response.getClientResponseStatus()).build());
                }
                return response.getEntity(returnType);
            }

            public<T >T postAsJson(Integer product, Integer count, Class<T> returnType) {
                UriBuilder localUriBuilder = _uriBuilder.clone();
                if (product == null) {
                }
                if (product!= null) {
                    localUriBuilder = localUriBuilder.replaceQueryParam("product", product);
                } else {
                    localUriBuilder = localUriBuilder.replaceQueryParam("product", ((Object[]) null));
                }
                if (count == null) {
                }
                if (count!= null) {
                    localUriBuilder = localUriBuilder.replaceQueryParam("count", count);
                } else {
                    localUriBuilder = localUriBuilder.replaceQueryParam("count", ((Object[]) null));
                }
                com.sun.jersey.api.client.WebResource resource = _client.resource(localUriBuilder.buildFromMap(_templateAndMatrixParameterValues));
                com.sun.jersey.api.client.WebResource.Builder resourceBuilder = resource.getRequestBuilder();
                resourceBuilder = resourceBuilder.accept("application/json");
                com.sun.jersey.api.client.ClientResponse response;
                response = resourceBuilder.method("POST", com.sun.jersey.api.client.ClientResponse.class);
                if (!com.sun.jersey.api.client.ClientResponse.class.isAssignableFrom(returnType)) {
                    if (response.getStatus()>= 400) {
                        throw new RestService.WebApplicationExceptionMessage(Response.status(response.getClientResponseStatus()).build());
                    }
                }
                if (!com.sun.jersey.api.client.ClientResponse.class.isAssignableFrom(returnType)) {
                    return response.getEntity(returnType);
                } else {
                    return returnType.cast(response);
                }
            }

        }

        public static class DoDeleteJson {

            private com.sun.jersey.api.client.Client _client;
            private UriBuilder _uriBuilder;
            private Map<String, Object> _templateAndMatrixParameterValues;

            private DoDeleteJson(com.sun.jersey.api.client.Client client, UriBuilder uriBuilder, Map<String, Object> map) {
                _client = client;
                _uriBuilder = uriBuilder.clone();
                _templateAndMatrixParameterValues = map;
            }

            /**
             * Create new instance using existing Client instance, and a base URI and any parameters
             * 
             */
            public DoDeleteJson(com.sun.jersey.api.client.Client client, URI baseUri) {
                _client = client;
                _uriBuilder = UriBuilder.fromUri(baseUri);
                _uriBuilder = _uriBuilder.path("do.delete.json");
                _templateAndMatrixParameterValues = new HashMap<String, Object>();
            }

            public SimpleDataDTO getAsSimpleDataDTO() {
                UriBuilder localUriBuilder = _uriBuilder.clone();
                com.sun.jersey.api.client.WebResource resource = _client.resource(localUriBuilder.buildFromMap(_templateAndMatrixParameterValues));
                com.sun.jersey.api.client.WebResource.Builder resourceBuilder = resource.getRequestBuilder();
                resourceBuilder = resourceBuilder.accept("application/json");
                com.sun.jersey.api.client.ClientResponse response;
                response = resourceBuilder.method("GET", com.sun.jersey.api.client.ClientResponse.class);
                if (response.getStatus()>= 400) {
                    throw new RestService.WebApplicationExceptionMessage(Response.status(response.getClientResponseStatus()).build());
                }
                return response.getEntity(SimpleDataDTO.class);
            }

            public<T >T getAsJson(com.sun.jersey.api.client.GenericType<T> returnType) {
                UriBuilder localUriBuilder = _uriBuilder.clone();
                com.sun.jersey.api.client.WebResource resource = _client.resource(localUriBuilder.buildFromMap(_templateAndMatrixParameterValues));
                com.sun.jersey.api.client.WebResource.Builder resourceBuilder = resource.getRequestBuilder();
                resourceBuilder = resourceBuilder.accept("application/json");
                com.sun.jersey.api.client.ClientResponse response;
                response = resourceBuilder.method("GET", com.sun.jersey.api.client.ClientResponse.class);
                if (response.getStatus()>= 400) {
                    throw new RestService.WebApplicationExceptionMessage(Response.status(response.getClientResponseStatus()).build());
                }
                return response.getEntity(returnType);
            }

            public<T >T getAsJson(Class<T> returnType) {
                UriBuilder localUriBuilder = _uriBuilder.clone();
                com.sun.jersey.api.client.WebResource resource = _client.resource(localUriBuilder.buildFromMap(_templateAndMatrixParameterValues));
                com.sun.jersey.api.client.WebResource.Builder resourceBuilder = resource.getRequestBuilder();
                resourceBuilder = resourceBuilder.accept("application/json");
                com.sun.jersey.api.client.ClientResponse response;
                response = resourceBuilder.method("GET", com.sun.jersey.api.client.ClientResponse.class);
                if (!com.sun.jersey.api.client.ClientResponse.class.isAssignableFrom(returnType)) {
                    if (response.getStatus()>= 400) {
                        throw new RestService.WebApplicationExceptionMessage(Response.status(response.getClientResponseStatus()).build());
                    }
                }
                if (!com.sun.jersey.api.client.ClientResponse.class.isAssignableFrom(returnType)) {
                    return response.getEntity(returnType);
                } else {
                    return returnType.cast(response);
                }
            }

            public SimpleDataDTO getAsSimpleDataDTO(Integer id) {
                UriBuilder localUriBuilder = _uriBuilder.clone();
                if (id == null) {
                }
                if (id!= null) {
                    localUriBuilder = localUriBuilder.replaceQueryParam("id", id);
                } else {
                    localUriBuilder = localUriBuilder.replaceQueryParam("id", ((Object[]) null));
                }
                com.sun.jersey.api.client.WebResource resource = _client.resource(localUriBuilder.buildFromMap(_templateAndMatrixParameterValues));
                com.sun.jersey.api.client.WebResource.Builder resourceBuilder = resource.getRequestBuilder();
                resourceBuilder = resourceBuilder.accept("application/json");
                com.sun.jersey.api.client.ClientResponse response;
                response = resourceBuilder.method("GET", com.sun.jersey.api.client.ClientResponse.class);
                if (response.getStatus()>= 400) {
                    throw new RestService.WebApplicationExceptionMessage(Response.status(response.getClientResponseStatus()).build());
                }
                return response.getEntity(SimpleDataDTO.class);
            }

            public<T >T getAsJson(Integer id, com.sun.jersey.api.client.GenericType<T> returnType) {
                UriBuilder localUriBuilder = _uriBuilder.clone();
                if (id == null) {
                }
                if (id!= null) {
                    localUriBuilder = localUriBuilder.replaceQueryParam("id", id);
                } else {
                    localUriBuilder = localUriBuilder.replaceQueryParam("id", ((Object[]) null));
                }
                com.sun.jersey.api.client.WebResource resource = _client.resource(localUriBuilder.buildFromMap(_templateAndMatrixParameterValues));
                com.sun.jersey.api.client.WebResource.Builder resourceBuilder = resource.getRequestBuilder();
                resourceBuilder = resourceBuilder.accept("application/json");
                com.sun.jersey.api.client.ClientResponse response;
                response = resourceBuilder.method("GET", com.sun.jersey.api.client.ClientResponse.class);
                if (response.getStatus()>= 400) {
                    throw new RestService.WebApplicationExceptionMessage(Response.status(response.getClientResponseStatus()).build());
                }
                return response.getEntity(returnType);
            }

            public<T >T getAsJson(Integer id, Class<T> returnType) {
                UriBuilder localUriBuilder = _uriBuilder.clone();
                if (id == null) {
                }
                if (id!= null) {
                    localUriBuilder = localUriBuilder.replaceQueryParam("id", id);
                } else {
                    localUriBuilder = localUriBuilder.replaceQueryParam("id", ((Object[]) null));
                }
                com.sun.jersey.api.client.WebResource resource = _client.resource(localUriBuilder.buildFromMap(_templateAndMatrixParameterValues));
                com.sun.jersey.api.client.WebResource.Builder resourceBuilder = resource.getRequestBuilder();
                resourceBuilder = resourceBuilder.accept("application/json");
                com.sun.jersey.api.client.ClientResponse response;
                response = resourceBuilder.method("GET", com.sun.jersey.api.client.ClientResponse.class);
                if (!com.sun.jersey.api.client.ClientResponse.class.isAssignableFrom(returnType)) {
                    if (response.getStatus()>= 400) {
                        throw new RestService.WebApplicationExceptionMessage(Response.status(response.getClientResponseStatus()).build());
                    }
                }
                if (!com.sun.jersey.api.client.ClientResponse.class.isAssignableFrom(returnType)) {
                    return response.getEntity(returnType);
                } else {
                    return returnType.cast(response);
                }
            }

        }

        public static class DoGetJson {

            private com.sun.jersey.api.client.Client _client;
            private UriBuilder _uriBuilder;
            private Map<String, Object> _templateAndMatrixParameterValues;

            private DoGetJson(com.sun.jersey.api.client.Client client, UriBuilder uriBuilder, Map<String, Object> map) {
                _client = client;
                _uriBuilder = uriBuilder.clone();
                _templateAndMatrixParameterValues = map;
            }

            /**
             * Create new instance using existing Client instance, and a base URI and any parameters
             * 
             */
            public DoGetJson(com.sun.jersey.api.client.Client client, URI baseUri) {
                _client = client;
                _uriBuilder = UriBuilder.fromUri(baseUri);
                _uriBuilder = _uriBuilder.path("do.get.json");
                _templateAndMatrixParameterValues = new HashMap<String, Object>();
            }

            public StoreDTO getAsStoreDTO() {
                UriBuilder localUriBuilder = _uriBuilder.clone();
                com.sun.jersey.api.client.WebResource resource = _client.resource(localUriBuilder.buildFromMap(_templateAndMatrixParameterValues));
                com.sun.jersey.api.client.WebResource.Builder resourceBuilder = resource.getRequestBuilder();
                resourceBuilder = resourceBuilder.accept("application/json");
                com.sun.jersey.api.client.ClientResponse response;
                response = resourceBuilder.method("GET", com.sun.jersey.api.client.ClientResponse.class);
                if (response.getStatus()>= 400) {
                    throw new RestService.WebApplicationExceptionMessage(Response.status(response.getClientResponseStatus()).build());
                }
                return response.getEntity(StoreDTO.class);
            }

            public<T >T getAsJson(com.sun.jersey.api.client.GenericType<T> returnType) {
                UriBuilder localUriBuilder = _uriBuilder.clone();
                com.sun.jersey.api.client.WebResource resource = _client.resource(localUriBuilder.buildFromMap(_templateAndMatrixParameterValues));
                com.sun.jersey.api.client.WebResource.Builder resourceBuilder = resource.getRequestBuilder();
                resourceBuilder = resourceBuilder.accept("application/json");
                com.sun.jersey.api.client.ClientResponse response;
                response = resourceBuilder.method("GET", com.sun.jersey.api.client.ClientResponse.class);
                if (response.getStatus()>= 400) {
                    throw new RestService.WebApplicationExceptionMessage(Response.status(response.getClientResponseStatus()).build());
                }
                return response.getEntity(returnType);
            }

            public<T >T getAsJson(Class<T> returnType) {
                UriBuilder localUriBuilder = _uriBuilder.clone();
                com.sun.jersey.api.client.WebResource resource = _client.resource(localUriBuilder.buildFromMap(_templateAndMatrixParameterValues));
                com.sun.jersey.api.client.WebResource.Builder resourceBuilder = resource.getRequestBuilder();
                resourceBuilder = resourceBuilder.accept("application/json");
                com.sun.jersey.api.client.ClientResponse response;
                response = resourceBuilder.method("GET", com.sun.jersey.api.client.ClientResponse.class);
                if (!com.sun.jersey.api.client.ClientResponse.class.isAssignableFrom(returnType)) {
                    if (response.getStatus()>= 400) {
                        throw new RestService.WebApplicationExceptionMessage(Response.status(response.getClientResponseStatus()).build());
                    }
                }
                if (!com.sun.jersey.api.client.ClientResponse.class.isAssignableFrom(returnType)) {
                    return response.getEntity(returnType);
                } else {
                    return returnType.cast(response);
                }
            }

            public StoreDTO getAsStoreDTO(Integer id) {
                UriBuilder localUriBuilder = _uriBuilder.clone();
                if (id == null) {
                }
                if (id!= null) {
                    localUriBuilder = localUriBuilder.replaceQueryParam("id", id);
                } else {
                    localUriBuilder = localUriBuilder.replaceQueryParam("id", ((Object[]) null));
                }
                com.sun.jersey.api.client.WebResource resource = _client.resource(localUriBuilder.buildFromMap(_templateAndMatrixParameterValues));
                com.sun.jersey.api.client.WebResource.Builder resourceBuilder = resource.getRequestBuilder();
                resourceBuilder = resourceBuilder.accept("application/json");
                com.sun.jersey.api.client.ClientResponse response;
                response = resourceBuilder.method("GET", com.sun.jersey.api.client.ClientResponse.class);
                if (response.getStatus()>= 400) {
                    throw new RestService.WebApplicationExceptionMessage(Response.status(response.getClientResponseStatus()).build());
                }
                return response.getEntity(StoreDTO.class);
            }

            public<T >T getAsJson(Integer id, com.sun.jersey.api.client.GenericType<T> returnType) {
                UriBuilder localUriBuilder = _uriBuilder.clone();
                if (id == null) {
                }
                if (id!= null) {
                    localUriBuilder = localUriBuilder.replaceQueryParam("id", id);
                } else {
                    localUriBuilder = localUriBuilder.replaceQueryParam("id", ((Object[]) null));
                }
                com.sun.jersey.api.client.WebResource resource = _client.resource(localUriBuilder.buildFromMap(_templateAndMatrixParameterValues));
                com.sun.jersey.api.client.WebResource.Builder resourceBuilder = resource.getRequestBuilder();
                resourceBuilder = resourceBuilder.accept("application/json");
                com.sun.jersey.api.client.ClientResponse response;
                response = resourceBuilder.method("GET", com.sun.jersey.api.client.ClientResponse.class);
                if (response.getStatus()>= 400) {
                    throw new RestService.WebApplicationExceptionMessage(Response.status(response.getClientResponseStatus()).build());
                }
                return response.getEntity(returnType);
            }

            public<T >T getAsJson(Integer id, Class<T> returnType) {
                UriBuilder localUriBuilder = _uriBuilder.clone();
                if (id == null) {
                }
                if (id!= null) {
                    localUriBuilder = localUriBuilder.replaceQueryParam("id", id);
                } else {
                    localUriBuilder = localUriBuilder.replaceQueryParam("id", ((Object[]) null));
                }
                com.sun.jersey.api.client.WebResource resource = _client.resource(localUriBuilder.buildFromMap(_templateAndMatrixParameterValues));
                com.sun.jersey.api.client.WebResource.Builder resourceBuilder = resource.getRequestBuilder();
                resourceBuilder = resourceBuilder.accept("application/json");
                com.sun.jersey.api.client.ClientResponse response;
                response = resourceBuilder.method("GET", com.sun.jersey.api.client.ClientResponse.class);
                if (!com.sun.jersey.api.client.ClientResponse.class.isAssignableFrom(returnType)) {
                    if (response.getStatus()>= 400) {
                        throw new RestService.WebApplicationExceptionMessage(Response.status(response.getClientResponseStatus()).build());
                    }
                }
                if (!com.sun.jersey.api.client.ClientResponse.class.isAssignableFrom(returnType)) {
                    return response.getEntity(returnType);
                } else {
                    return returnType.cast(response);
                }
            }

        }

        public static class DoListJson {

            private com.sun.jersey.api.client.Client _client;
            private UriBuilder _uriBuilder;
            private Map<String, Object> _templateAndMatrixParameterValues;

            private DoListJson(com.sun.jersey.api.client.Client client, UriBuilder uriBuilder, Map<String, Object> map) {
                _client = client;
                _uriBuilder = uriBuilder.clone();
                _templateAndMatrixParameterValues = map;
            }

            /**
             * Create new instance using existing Client instance, and a base URI and any parameters
             * 
             */
            public DoListJson(com.sun.jersey.api.client.Client client, URI baseUri) {
                _client = client;
                _uriBuilder = UriBuilder.fromUri(baseUri);
                _uriBuilder = _uriBuilder.path("do.list.json");
                _templateAndMatrixParameterValues = new HashMap<String, Object>();
            }

            public ListDTO getAsListDTO() {
                UriBuilder localUriBuilder = _uriBuilder.clone();
                com.sun.jersey.api.client.WebResource resource = _client.resource(localUriBuilder.buildFromMap(_templateAndMatrixParameterValues));
                com.sun.jersey.api.client.WebResource.Builder resourceBuilder = resource.getRequestBuilder();
                resourceBuilder = resourceBuilder.accept("application/json");
                com.sun.jersey.api.client.ClientResponse response;
                response = resourceBuilder.method("GET", com.sun.jersey.api.client.ClientResponse.class);
                if (response.getStatus()>= 400) {
                    throw new RestService.WebApplicationExceptionMessage(Response.status(response.getClientResponseStatus()).build());
                }
                return response.getEntity(ListDTO.class);
            }

            public<T >T getAsJson(com.sun.jersey.api.client.GenericType<T> returnType) {
                UriBuilder localUriBuilder = _uriBuilder.clone();
                com.sun.jersey.api.client.WebResource resource = _client.resource(localUriBuilder.buildFromMap(_templateAndMatrixParameterValues));
                com.sun.jersey.api.client.WebResource.Builder resourceBuilder = resource.getRequestBuilder();
                resourceBuilder = resourceBuilder.accept("application/json");
                com.sun.jersey.api.client.ClientResponse response;
                response = resourceBuilder.method("GET", com.sun.jersey.api.client.ClientResponse.class);
                if (response.getStatus()>= 400) {
                    throw new RestService.WebApplicationExceptionMessage(Response.status(response.getClientResponseStatus()).build());
                }
                return response.getEntity(returnType);
            }

            public<T >T getAsJson(Class<T> returnType) {
                UriBuilder localUriBuilder = _uriBuilder.clone();
                com.sun.jersey.api.client.WebResource resource = _client.resource(localUriBuilder.buildFromMap(_templateAndMatrixParameterValues));
                com.sun.jersey.api.client.WebResource.Builder resourceBuilder = resource.getRequestBuilder();
                resourceBuilder = resourceBuilder.accept("application/json");
                com.sun.jersey.api.client.ClientResponse response;
                response = resourceBuilder.method("GET", com.sun.jersey.api.client.ClientResponse.class);
                if (!com.sun.jersey.api.client.ClientResponse.class.isAssignableFrom(returnType)) {
                    if (response.getStatus()>= 400) {
                        throw new RestService.WebApplicationExceptionMessage(Response.status(response.getClientResponseStatus()).build());
                    }
                }
                if (!com.sun.jersey.api.client.ClientResponse.class.isAssignableFrom(returnType)) {
                    return response.getEntity(returnType);
                } else {
                    return returnType.cast(response);
                }
            }

            public ListDTO getAsListDTO(Boolean all, Integer page, Integer perpage) {
                UriBuilder localUriBuilder = _uriBuilder.clone();
                if (all == null) {
                }
                if (all!= null) {
                    localUriBuilder = localUriBuilder.replaceQueryParam("all", all);
                } else {
                    localUriBuilder = localUriBuilder.replaceQueryParam("all", ((Object[]) null));
                }
                if (page == null) {
                }
                if (page!= null) {
                    localUriBuilder = localUriBuilder.replaceQueryParam("page", page);
                } else {
                    localUriBuilder = localUriBuilder.replaceQueryParam("page", ((Object[]) null));
                }
                if (perpage == null) {
                }
                if (perpage!= null) {
                    localUriBuilder = localUriBuilder.replaceQueryParam("perpage", perpage);
                } else {
                    localUriBuilder = localUriBuilder.replaceQueryParam("perpage", ((Object[]) null));
                }
                com.sun.jersey.api.client.WebResource resource = _client.resource(localUriBuilder.buildFromMap(_templateAndMatrixParameterValues));
                com.sun.jersey.api.client.WebResource.Builder resourceBuilder = resource.getRequestBuilder();
                resourceBuilder = resourceBuilder.accept("application/json");
                com.sun.jersey.api.client.ClientResponse response;
                response = resourceBuilder.method("GET", com.sun.jersey.api.client.ClientResponse.class);
                if (response.getStatus()>= 400) {
                    throw new RestService.WebApplicationExceptionMessage(Response.status(response.getClientResponseStatus()).build());
                }
                return response.getEntity(ListDTO.class);
            }

            public<T >T getAsJson(Boolean all, Integer page, Integer perpage, com.sun.jersey.api.client.GenericType<T> returnType) {
                UriBuilder localUriBuilder = _uriBuilder.clone();
                if (all == null) {
                }
                if (all!= null) {
                    localUriBuilder = localUriBuilder.replaceQueryParam("all", all);
                } else {
                    localUriBuilder = localUriBuilder.replaceQueryParam("all", ((Object[]) null));
                }
                if (page == null) {
                }
                if (page!= null) {
                    localUriBuilder = localUriBuilder.replaceQueryParam("page", page);
                } else {
                    localUriBuilder = localUriBuilder.replaceQueryParam("page", ((Object[]) null));
                }
                if (perpage == null) {
                }
                if (perpage!= null) {
                    localUriBuilder = localUriBuilder.replaceQueryParam("perpage", perpage);
                } else {
                    localUriBuilder = localUriBuilder.replaceQueryParam("perpage", ((Object[]) null));
                }
                com.sun.jersey.api.client.WebResource resource = _client.resource(localUriBuilder.buildFromMap(_templateAndMatrixParameterValues));
                com.sun.jersey.api.client.WebResource.Builder resourceBuilder = resource.getRequestBuilder();
                resourceBuilder = resourceBuilder.accept("application/json");
                com.sun.jersey.api.client.ClientResponse response;
                response = resourceBuilder.method("GET", com.sun.jersey.api.client.ClientResponse.class);
                if (response.getStatus()>= 400) {
                    throw new RestService.WebApplicationExceptionMessage(Response.status(response.getClientResponseStatus()).build());
                }
                return response.getEntity(returnType);
            }

            public<T >T getAsJson(Boolean all, Integer page, Integer perpage, Class<T> returnType) {
                UriBuilder localUriBuilder = _uriBuilder.clone();
                if (all == null) {
                }
                if (all!= null) {
                    localUriBuilder = localUriBuilder.replaceQueryParam("all", all);
                } else {
                    localUriBuilder = localUriBuilder.replaceQueryParam("all", ((Object[]) null));
                }
                if (page == null) {
                }
                if (page!= null) {
                    localUriBuilder = localUriBuilder.replaceQueryParam("page", page);
                } else {
                    localUriBuilder = localUriBuilder.replaceQueryParam("page", ((Object[]) null));
                }
                if (perpage == null) {
                }
                if (perpage!= null) {
                    localUriBuilder = localUriBuilder.replaceQueryParam("perpage", perpage);
                } else {
                    localUriBuilder = localUriBuilder.replaceQueryParam("perpage", ((Object[]) null));
                }
                com.sun.jersey.api.client.WebResource resource = _client.resource(localUriBuilder.buildFromMap(_templateAndMatrixParameterValues));
                com.sun.jersey.api.client.WebResource.Builder resourceBuilder = resource.getRequestBuilder();
                resourceBuilder = resourceBuilder.accept("application/json");
                com.sun.jersey.api.client.ClientResponse response;
                response = resourceBuilder.method("GET", com.sun.jersey.api.client.ClientResponse.class);
                if (!com.sun.jersey.api.client.ClientResponse.class.isAssignableFrom(returnType)) {
                    if (response.getStatus()>= 400) {
                        throw new RestService.WebApplicationExceptionMessage(Response.status(response.getClientResponseStatus()).build());
                    }
                }
                if (!com.sun.jersey.api.client.ClientResponse.class.isAssignableFrom(returnType)) {
                    return response.getEntity(returnType);
                } else {
                    return returnType.cast(response);
                }
            }

        }

        public static class DoUpdateJson {

            private com.sun.jersey.api.client.Client _client;
            private UriBuilder _uriBuilder;
            private Map<String, Object> _templateAndMatrixParameterValues;

            private DoUpdateJson(com.sun.jersey.api.client.Client client, UriBuilder uriBuilder, Map<String, Object> map) {
                _client = client;
                _uriBuilder = uriBuilder.clone();
                _templateAndMatrixParameterValues = map;
            }

            /**
             * Create new instance using existing Client instance, and a base URI and any parameters
             * 
             */
            public DoUpdateJson(com.sun.jersey.api.client.Client client, URI baseUri) {
                _client = client;
                _uriBuilder = UriBuilder.fromUri(baseUri);
                _uriBuilder = _uriBuilder.path("do.update.json");
                _templateAndMatrixParameterValues = new HashMap<String, Object>();
            }

            public SimpleDataDTO postAsSimpleDataDTO() {
                UriBuilder localUriBuilder = _uriBuilder.clone();
                com.sun.jersey.api.client.WebResource resource = _client.resource(localUriBuilder.buildFromMap(_templateAndMatrixParameterValues));
                com.sun.jersey.api.client.WebResource.Builder resourceBuilder = resource.getRequestBuilder();
                resourceBuilder = resourceBuilder.accept("application/json");
                com.sun.jersey.api.client.ClientResponse response;
                response = resourceBuilder.method("POST", com.sun.jersey.api.client.ClientResponse.class);
                if (response.getStatus()>= 400) {
                    throw new RestService.WebApplicationExceptionMessage(Response.status(response.getClientResponseStatus()).build());
                }
                return response.getEntity(SimpleDataDTO.class);
            }

            public<T >T postAsJson(com.sun.jersey.api.client.GenericType<T> returnType) {
                UriBuilder localUriBuilder = _uriBuilder.clone();
                com.sun.jersey.api.client.WebResource resource = _client.resource(localUriBuilder.buildFromMap(_templateAndMatrixParameterValues));
                com.sun.jersey.api.client.WebResource.Builder resourceBuilder = resource.getRequestBuilder();
                resourceBuilder = resourceBuilder.accept("application/json");
                com.sun.jersey.api.client.ClientResponse response;
                response = resourceBuilder.method("POST", com.sun.jersey.api.client.ClientResponse.class);
                if (response.getStatus()>= 400) {
                    throw new RestService.WebApplicationExceptionMessage(Response.status(response.getClientResponseStatus()).build());
                }
                return response.getEntity(returnType);
            }

            public<T >T postAsJson(Class<T> returnType) {
                UriBuilder localUriBuilder = _uriBuilder.clone();
                com.sun.jersey.api.client.WebResource resource = _client.resource(localUriBuilder.buildFromMap(_templateAndMatrixParameterValues));
                com.sun.jersey.api.client.WebResource.Builder resourceBuilder = resource.getRequestBuilder();
                resourceBuilder = resourceBuilder.accept("application/json");
                com.sun.jersey.api.client.ClientResponse response;
                response = resourceBuilder.method("POST", com.sun.jersey.api.client.ClientResponse.class);
                if (!com.sun.jersey.api.client.ClientResponse.class.isAssignableFrom(returnType)) {
                    if (response.getStatus()>= 400) {
                        throw new RestService.WebApplicationExceptionMessage(Response.status(response.getClientResponseStatus()).build());
                    }
                }
                if (!com.sun.jersey.api.client.ClientResponse.class.isAssignableFrom(returnType)) {
                    return response.getEntity(returnType);
                } else {
                    return returnType.cast(response);
                }
            }

            public SimpleDataDTO postAsSimpleDataDTO(Integer product, Integer count) {
                UriBuilder localUriBuilder = _uriBuilder.clone();
                if (product == null) {
                }
                if (product!= null) {
                    localUriBuilder = localUriBuilder.replaceQueryParam("product", product);
                } else {
                    localUriBuilder = localUriBuilder.replaceQueryParam("product", ((Object[]) null));
                }
                if (count == null) {
                }
                if (count!= null) {
                    localUriBuilder = localUriBuilder.replaceQueryParam("count", count);
                } else {
                    localUriBuilder = localUriBuilder.replaceQueryParam("count", ((Object[]) null));
                }
                com.sun.jersey.api.client.WebResource resource = _client.resource(localUriBuilder.buildFromMap(_templateAndMatrixParameterValues));
                com.sun.jersey.api.client.WebResource.Builder resourceBuilder = resource.getRequestBuilder();
                resourceBuilder = resourceBuilder.accept("application/json");
                com.sun.jersey.api.client.ClientResponse response;
                response = resourceBuilder.method("POST", com.sun.jersey.api.client.ClientResponse.class);
                if (response.getStatus()>= 400) {
                    throw new RestService.WebApplicationExceptionMessage(Response.status(response.getClientResponseStatus()).build());
                }
                return response.getEntity(SimpleDataDTO.class);
            }

            public<T >T postAsJson(Integer product, Integer count, com.sun.jersey.api.client.GenericType<T> returnType) {
                UriBuilder localUriBuilder = _uriBuilder.clone();
                if (product == null) {
                }
                if (product!= null) {
                    localUriBuilder = localUriBuilder.replaceQueryParam("product", product);
                } else {
                    localUriBuilder = localUriBuilder.replaceQueryParam("product", ((Object[]) null));
                }
                if (count == null) {
                }
                if (count!= null) {
                    localUriBuilder = localUriBuilder.replaceQueryParam("count", count);
                } else {
                    localUriBuilder = localUriBuilder.replaceQueryParam("count", ((Object[]) null));
                }
                com.sun.jersey.api.client.WebResource resource = _client.resource(localUriBuilder.buildFromMap(_templateAndMatrixParameterValues));
                com.sun.jersey.api.client.WebResource.Builder resourceBuilder = resource.getRequestBuilder();
                resourceBuilder = resourceBuilder.accept("application/json");
                com.sun.jersey.api.client.ClientResponse response;
                response = resourceBuilder.method("POST", com.sun.jersey.api.client.ClientResponse.class);
                if (response.getStatus()>= 400) {
                    throw new RestService.WebApplicationExceptionMessage(Response.status(response.getClientResponseStatus()).build());
                }
                return response.getEntity(returnType);
            }

            public<T >T postAsJson(Integer product, Integer count, Class<T> returnType) {
                UriBuilder localUriBuilder = _uriBuilder.clone();
                if (product == null) {
                }
                if (product!= null) {
                    localUriBuilder = localUriBuilder.replaceQueryParam("product", product);
                } else {
                    localUriBuilder = localUriBuilder.replaceQueryParam("product", ((Object[]) null));
                }
                if (count == null) {
                }
                if (count!= null) {
                    localUriBuilder = localUriBuilder.replaceQueryParam("count", count);
                } else {
                    localUriBuilder = localUriBuilder.replaceQueryParam("count", ((Object[]) null));
                }
                com.sun.jersey.api.client.WebResource resource = _client.resource(localUriBuilder.buildFromMap(_templateAndMatrixParameterValues));
                com.sun.jersey.api.client.WebResource.Builder resourceBuilder = resource.getRequestBuilder();
                resourceBuilder = resourceBuilder.accept("application/json");
                com.sun.jersey.api.client.ClientResponse response;
                response = resourceBuilder.method("POST", com.sun.jersey.api.client.ClientResponse.class);
                if (!com.sun.jersey.api.client.ClientResponse.class.isAssignableFrom(returnType)) {
                    if (response.getStatus()>= 400) {
                        throw new RestService.WebApplicationExceptionMessage(Response.status(response.getClientResponseStatus()).build());
                    }
                }
                if (!com.sun.jersey.api.client.ClientResponse.class.isAssignableFrom(returnType)) {
                    return response.getEntity(returnType);
                } else {
                    return returnType.cast(response);
                }
            }

        }

    }

    public static class Waybill {

        private com.sun.jersey.api.client.Client _client;
        private UriBuilder _uriBuilder;
        private Map<String, Object> _templateAndMatrixParameterValues;

        private Waybill(com.sun.jersey.api.client.Client client, UriBuilder uriBuilder, Map<String, Object> map) {
            _client = client;
            _uriBuilder = uriBuilder.clone();
            _templateAndMatrixParameterValues = map;
        }

        /**
         * Create new instance using existing Client instance, and a base URI and any parameters
         * 
         */
        public Waybill(com.sun.jersey.api.client.Client client, URI baseUri) {
            _client = client;
            _uriBuilder = UriBuilder.fromUri(baseUri);
            _uriBuilder = _uriBuilder.path("/waybill/");
            _templateAndMatrixParameterValues = new HashMap<String, Object>();
        }

        public RestService.Waybill.DoUpdateitemsJson doUpdateitemsJson() {
            return new RestService.Waybill.DoUpdateitemsJson(_client, _uriBuilder.buildFromMap(_templateAndMatrixParameterValues));
        }

        public RestService.Waybill.DoUpdateJson doUpdateJson() {
            return new RestService.Waybill.DoUpdateJson(_client, _uriBuilder.buildFromMap(_templateAndMatrixParameterValues));
        }

        public RestService.Waybill.DoCreateJson doCreateJson() {
            return new RestService.Waybill.DoCreateJson(_client, _uriBuilder.buildFromMap(_templateAndMatrixParameterValues));
        }

        public RestService.Waybill.DoGetJson doGetJson() {
            return new RestService.Waybill.DoGetJson(_client, _uriBuilder.buildFromMap(_templateAndMatrixParameterValues));
        }

        public RestService.Waybill.DoDeleteJson doDeleteJson() {
            return new RestService.Waybill.DoDeleteJson(_client, _uriBuilder.buildFromMap(_templateAndMatrixParameterValues));
        }

        public RestService.Waybill.DoListJson doListJson() {
            return new RestService.Waybill.DoListJson(_client, _uriBuilder.buildFromMap(_templateAndMatrixParameterValues));
        }

        public static class DoCreateJson {

            private com.sun.jersey.api.client.Client _client;
            private UriBuilder _uriBuilder;
            private Map<String, Object> _templateAndMatrixParameterValues;

            private DoCreateJson(com.sun.jersey.api.client.Client client, UriBuilder uriBuilder, Map<String, Object> map) {
                _client = client;
                _uriBuilder = uriBuilder.clone();
                _templateAndMatrixParameterValues = map;
            }

            /**
             * Create new instance using existing Client instance, and a base URI and any parameters
             * 
             */
            public DoCreateJson(com.sun.jersey.api.client.Client client, URI baseUri) {
                _client = client;
                _uriBuilder = UriBuilder.fromUri(baseUri);
                _uriBuilder = _uriBuilder.path("do.create.json");
                _templateAndMatrixParameterValues = new HashMap<String, Object>();
            }

            public WayBillDTO postAsWayBillDTO() {
                UriBuilder localUriBuilder = _uriBuilder.clone();
                com.sun.jersey.api.client.WebResource resource = _client.resource(localUriBuilder.buildFromMap(_templateAndMatrixParameterValues));
                com.sun.jersey.api.client.WebResource.Builder resourceBuilder = resource.getRequestBuilder();
                resourceBuilder = resourceBuilder.accept("application/json");
                com.sun.jersey.api.client.ClientResponse response;
                response = resourceBuilder.method("POST", com.sun.jersey.api.client.ClientResponse.class);
                if (response.getStatus()>= 400) {
                    throw new RestService.WebApplicationExceptionMessage(Response.status(response.getClientResponseStatus()).build());
                }
                return response.getEntity(WayBillDTO.class);
            }

            public<T >T postAsJson(com.sun.jersey.api.client.GenericType<T> returnType) {
                UriBuilder localUriBuilder = _uriBuilder.clone();
                com.sun.jersey.api.client.WebResource resource = _client.resource(localUriBuilder.buildFromMap(_templateAndMatrixParameterValues));
                com.sun.jersey.api.client.WebResource.Builder resourceBuilder = resource.getRequestBuilder();
                resourceBuilder = resourceBuilder.accept("application/json");
                com.sun.jersey.api.client.ClientResponse response;
                response = resourceBuilder.method("POST", com.sun.jersey.api.client.ClientResponse.class);
                if (response.getStatus()>= 400) {
                    throw new RestService.WebApplicationExceptionMessage(Response.status(response.getClientResponseStatus()).build());
                }
                return response.getEntity(returnType);
            }

            public<T >T postAsJson(Class<T> returnType) {
                UriBuilder localUriBuilder = _uriBuilder.clone();
                com.sun.jersey.api.client.WebResource resource = _client.resource(localUriBuilder.buildFromMap(_templateAndMatrixParameterValues));
                com.sun.jersey.api.client.WebResource.Builder resourceBuilder = resource.getRequestBuilder();
                resourceBuilder = resourceBuilder.accept("application/json");
                com.sun.jersey.api.client.ClientResponse response;
                response = resourceBuilder.method("POST", com.sun.jersey.api.client.ClientResponse.class);
                if (!com.sun.jersey.api.client.ClientResponse.class.isAssignableFrom(returnType)) {
                    if (response.getStatus()>= 400) {
                        throw new RestService.WebApplicationExceptionMessage(Response.status(response.getClientResponseStatus()).build());
                    }
                }
                if (!com.sun.jersey.api.client.ClientResponse.class.isAssignableFrom(returnType)) {
                    return response.getEntity(returnType);
                } else {
                    return returnType.cast(response);
                }
            }

            public WayBillDTO postAsWayBillDTO(Long date, Integer count, String products, String counts, String title, String supplier) {
                UriBuilder localUriBuilder = _uriBuilder.clone();
                if (date == null) {
                }
                if (date!= null) {
                    localUriBuilder = localUriBuilder.replaceQueryParam("date", date);
                } else {
                    localUriBuilder = localUriBuilder.replaceQueryParam("date", ((Object[]) null));
                }
                if (count == null) {
                }
                if (count!= null) {
                    localUriBuilder = localUriBuilder.replaceQueryParam("count", count);
                } else {
                    localUriBuilder = localUriBuilder.replaceQueryParam("count", ((Object[]) null));
                }
                if (products == null) {
                }
                if (products!= null) {
                    localUriBuilder = localUriBuilder.replaceQueryParam("products", products);
                } else {
                    localUriBuilder = localUriBuilder.replaceQueryParam("products", ((Object[]) null));
                }
                if (counts == null) {
                }
                if (counts!= null) {
                    localUriBuilder = localUriBuilder.replaceQueryParam("counts", counts);
                } else {
                    localUriBuilder = localUriBuilder.replaceQueryParam("counts", ((Object[]) null));
                }
                if (title == null) {
                }
                if (title!= null) {
                    localUriBuilder = localUriBuilder.replaceQueryParam("title", title);
                } else {
                    localUriBuilder = localUriBuilder.replaceQueryParam("title", ((Object[]) null));
                }
                if (supplier == null) {
                }
                if (supplier!= null) {
                    localUriBuilder = localUriBuilder.replaceQueryParam("supplier", supplier);
                } else {
                    localUriBuilder = localUriBuilder.replaceQueryParam("supplier", ((Object[]) null));
                }
                com.sun.jersey.api.client.WebResource resource = _client.resource(localUriBuilder.buildFromMap(_templateAndMatrixParameterValues));
                com.sun.jersey.api.client.WebResource.Builder resourceBuilder = resource.getRequestBuilder();
                resourceBuilder = resourceBuilder.accept("application/json");
                com.sun.jersey.api.client.ClientResponse response;
                response = resourceBuilder.method("POST", com.sun.jersey.api.client.ClientResponse.class);
                if (response.getStatus()>= 400) {
                    throw new RestService.WebApplicationExceptionMessage(Response.status(response.getClientResponseStatus()).build());
                }
                return response.getEntity(WayBillDTO.class);
            }

            public<T >T postAsJson(Long date, Integer count, String products, String counts, String title, String supplier, com.sun.jersey.api.client.GenericType<T> returnType) {
                UriBuilder localUriBuilder = _uriBuilder.clone();
                if (date == null) {
                }
                if (date!= null) {
                    localUriBuilder = localUriBuilder.replaceQueryParam("date", date);
                } else {
                    localUriBuilder = localUriBuilder.replaceQueryParam("date", ((Object[]) null));
                }
                if (count == null) {
                }
                if (count!= null) {
                    localUriBuilder = localUriBuilder.replaceQueryParam("count", count);
                } else {
                    localUriBuilder = localUriBuilder.replaceQueryParam("count", ((Object[]) null));
                }
                if (products == null) {
                }
                if (products!= null) {
                    localUriBuilder = localUriBuilder.replaceQueryParam("products", products);
                } else {
                    localUriBuilder = localUriBuilder.replaceQueryParam("products", ((Object[]) null));
                }
                if (counts == null) {
                }
                if (counts!= null) {
                    localUriBuilder = localUriBuilder.replaceQueryParam("counts", counts);
                } else {
                    localUriBuilder = localUriBuilder.replaceQueryParam("counts", ((Object[]) null));
                }
                if (title == null) {
                }
                if (title!= null) {
                    localUriBuilder = localUriBuilder.replaceQueryParam("title", title);
                } else {
                    localUriBuilder = localUriBuilder.replaceQueryParam("title", ((Object[]) null));
                }
                if (supplier == null) {
                }
                if (supplier!= null) {
                    localUriBuilder = localUriBuilder.replaceQueryParam("supplier", supplier);
                } else {
                    localUriBuilder = localUriBuilder.replaceQueryParam("supplier", ((Object[]) null));
                }
                com.sun.jersey.api.client.WebResource resource = _client.resource(localUriBuilder.buildFromMap(_templateAndMatrixParameterValues));
                com.sun.jersey.api.client.WebResource.Builder resourceBuilder = resource.getRequestBuilder();
                resourceBuilder = resourceBuilder.accept("application/json");
                com.sun.jersey.api.client.ClientResponse response;
                response = resourceBuilder.method("POST", com.sun.jersey.api.client.ClientResponse.class);
                if (response.getStatus()>= 400) {
                    throw new RestService.WebApplicationExceptionMessage(Response.status(response.getClientResponseStatus()).build());
                }
                return response.getEntity(returnType);
            }

            public<T >T postAsJson(Long date, Integer count, String products, String counts, String title, String supplier, Class<T> returnType) {
                UriBuilder localUriBuilder = _uriBuilder.clone();
                if (date == null) {
                }
                if (date!= null) {
                    localUriBuilder = localUriBuilder.replaceQueryParam("date", date);
                } else {
                    localUriBuilder = localUriBuilder.replaceQueryParam("date", ((Object[]) null));
                }
                if (count == null) {
                }
                if (count!= null) {
                    localUriBuilder = localUriBuilder.replaceQueryParam("count", count);
                } else {
                    localUriBuilder = localUriBuilder.replaceQueryParam("count", ((Object[]) null));
                }
                if (products == null) {
                }
                if (products!= null) {
                    localUriBuilder = localUriBuilder.replaceQueryParam("products", products);
                } else {
                    localUriBuilder = localUriBuilder.replaceQueryParam("products", ((Object[]) null));
                }
                if (counts == null) {
                }
                if (counts!= null) {
                    localUriBuilder = localUriBuilder.replaceQueryParam("counts", counts);
                } else {
                    localUriBuilder = localUriBuilder.replaceQueryParam("counts", ((Object[]) null));
                }
                if (title == null) {
                }
                if (title!= null) {
                    localUriBuilder = localUriBuilder.replaceQueryParam("title", title);
                } else {
                    localUriBuilder = localUriBuilder.replaceQueryParam("title", ((Object[]) null));
                }
                if (supplier == null) {
                }
                if (supplier!= null) {
                    localUriBuilder = localUriBuilder.replaceQueryParam("supplier", supplier);
                } else {
                    localUriBuilder = localUriBuilder.replaceQueryParam("supplier", ((Object[]) null));
                }
                com.sun.jersey.api.client.WebResource resource = _client.resource(localUriBuilder.buildFromMap(_templateAndMatrixParameterValues));
                com.sun.jersey.api.client.WebResource.Builder resourceBuilder = resource.getRequestBuilder();
                resourceBuilder = resourceBuilder.accept("application/json");
                com.sun.jersey.api.client.ClientResponse response;
                response = resourceBuilder.method("POST", com.sun.jersey.api.client.ClientResponse.class);
                if (!com.sun.jersey.api.client.ClientResponse.class.isAssignableFrom(returnType)) {
                    if (response.getStatus()>= 400) {
                        throw new RestService.WebApplicationExceptionMessage(Response.status(response.getClientResponseStatus()).build());
                    }
                }
                if (!com.sun.jersey.api.client.ClientResponse.class.isAssignableFrom(returnType)) {
                    return response.getEntity(returnType);
                } else {
                    return returnType.cast(response);
                }
            }

        }

        public static class DoDeleteJson {

            private com.sun.jersey.api.client.Client _client;
            private UriBuilder _uriBuilder;
            private Map<String, Object> _templateAndMatrixParameterValues;

            private DoDeleteJson(com.sun.jersey.api.client.Client client, UriBuilder uriBuilder, Map<String, Object> map) {
                _client = client;
                _uriBuilder = uriBuilder.clone();
                _templateAndMatrixParameterValues = map;
            }

            /**
             * Create new instance using existing Client instance, and a base URI and any parameters
             * 
             */
            public DoDeleteJson(com.sun.jersey.api.client.Client client, URI baseUri) {
                _client = client;
                _uriBuilder = UriBuilder.fromUri(baseUri);
                _uriBuilder = _uriBuilder.path("do.delete.json");
                _templateAndMatrixParameterValues = new HashMap<String, Object>();
            }

            public SimpleDataDTO getAsSimpleDataDTO() {
                UriBuilder localUriBuilder = _uriBuilder.clone();
                com.sun.jersey.api.client.WebResource resource = _client.resource(localUriBuilder.buildFromMap(_templateAndMatrixParameterValues));
                com.sun.jersey.api.client.WebResource.Builder resourceBuilder = resource.getRequestBuilder();
                resourceBuilder = resourceBuilder.accept("application/json");
                com.sun.jersey.api.client.ClientResponse response;
                response = resourceBuilder.method("GET", com.sun.jersey.api.client.ClientResponse.class);
                if (response.getStatus()>= 400) {
                    throw new RestService.WebApplicationExceptionMessage(Response.status(response.getClientResponseStatus()).build());
                }
                return response.getEntity(SimpleDataDTO.class);
            }

            public<T >T getAsJson(com.sun.jersey.api.client.GenericType<T> returnType) {
                UriBuilder localUriBuilder = _uriBuilder.clone();
                com.sun.jersey.api.client.WebResource resource = _client.resource(localUriBuilder.buildFromMap(_templateAndMatrixParameterValues));
                com.sun.jersey.api.client.WebResource.Builder resourceBuilder = resource.getRequestBuilder();
                resourceBuilder = resourceBuilder.accept("application/json");
                com.sun.jersey.api.client.ClientResponse response;
                response = resourceBuilder.method("GET", com.sun.jersey.api.client.ClientResponse.class);
                if (response.getStatus()>= 400) {
                    throw new RestService.WebApplicationExceptionMessage(Response.status(response.getClientResponseStatus()).build());
                }
                return response.getEntity(returnType);
            }

            public<T >T getAsJson(Class<T> returnType) {
                UriBuilder localUriBuilder = _uriBuilder.clone();
                com.sun.jersey.api.client.WebResource resource = _client.resource(localUriBuilder.buildFromMap(_templateAndMatrixParameterValues));
                com.sun.jersey.api.client.WebResource.Builder resourceBuilder = resource.getRequestBuilder();
                resourceBuilder = resourceBuilder.accept("application/json");
                com.sun.jersey.api.client.ClientResponse response;
                response = resourceBuilder.method("GET", com.sun.jersey.api.client.ClientResponse.class);
                if (!com.sun.jersey.api.client.ClientResponse.class.isAssignableFrom(returnType)) {
                    if (response.getStatus()>= 400) {
                        throw new RestService.WebApplicationExceptionMessage(Response.status(response.getClientResponseStatus()).build());
                    }
                }
                if (!com.sun.jersey.api.client.ClientResponse.class.isAssignableFrom(returnType)) {
                    return response.getEntity(returnType);
                } else {
                    return returnType.cast(response);
                }
            }

            public SimpleDataDTO getAsSimpleDataDTO(Integer id) {
                UriBuilder localUriBuilder = _uriBuilder.clone();
                if (id == null) {
                }
                if (id!= null) {
                    localUriBuilder = localUriBuilder.replaceQueryParam("id", id);
                } else {
                    localUriBuilder = localUriBuilder.replaceQueryParam("id", ((Object[]) null));
                }
                com.sun.jersey.api.client.WebResource resource = _client.resource(localUriBuilder.buildFromMap(_templateAndMatrixParameterValues));
                com.sun.jersey.api.client.WebResource.Builder resourceBuilder = resource.getRequestBuilder();
                resourceBuilder = resourceBuilder.accept("application/json");
                com.sun.jersey.api.client.ClientResponse response;
                response = resourceBuilder.method("GET", com.sun.jersey.api.client.ClientResponse.class);
                if (response.getStatus()>= 400) {
                    throw new RestService.WebApplicationExceptionMessage(Response.status(response.getClientResponseStatus()).build());
                }
                return response.getEntity(SimpleDataDTO.class);
            }

            public<T >T getAsJson(Integer id, com.sun.jersey.api.client.GenericType<T> returnType) {
                UriBuilder localUriBuilder = _uriBuilder.clone();
                if (id == null) {
                }
                if (id!= null) {
                    localUriBuilder = localUriBuilder.replaceQueryParam("id", id);
                } else {
                    localUriBuilder = localUriBuilder.replaceQueryParam("id", ((Object[]) null));
                }
                com.sun.jersey.api.client.WebResource resource = _client.resource(localUriBuilder.buildFromMap(_templateAndMatrixParameterValues));
                com.sun.jersey.api.client.WebResource.Builder resourceBuilder = resource.getRequestBuilder();
                resourceBuilder = resourceBuilder.accept("application/json");
                com.sun.jersey.api.client.ClientResponse response;
                response = resourceBuilder.method("GET", com.sun.jersey.api.client.ClientResponse.class);
                if (response.getStatus()>= 400) {
                    throw new RestService.WebApplicationExceptionMessage(Response.status(response.getClientResponseStatus()).build());
                }
                return response.getEntity(returnType);
            }

            public<T >T getAsJson(Integer id, Class<T> returnType) {
                UriBuilder localUriBuilder = _uriBuilder.clone();
                if (id == null) {
                }
                if (id!= null) {
                    localUriBuilder = localUriBuilder.replaceQueryParam("id", id);
                } else {
                    localUriBuilder = localUriBuilder.replaceQueryParam("id", ((Object[]) null));
                }
                com.sun.jersey.api.client.WebResource resource = _client.resource(localUriBuilder.buildFromMap(_templateAndMatrixParameterValues));
                com.sun.jersey.api.client.WebResource.Builder resourceBuilder = resource.getRequestBuilder();
                resourceBuilder = resourceBuilder.accept("application/json");
                com.sun.jersey.api.client.ClientResponse response;
                response = resourceBuilder.method("GET", com.sun.jersey.api.client.ClientResponse.class);
                if (!com.sun.jersey.api.client.ClientResponse.class.isAssignableFrom(returnType)) {
                    if (response.getStatus()>= 400) {
                        throw new RestService.WebApplicationExceptionMessage(Response.status(response.getClientResponseStatus()).build());
                    }
                }
                if (!com.sun.jersey.api.client.ClientResponse.class.isAssignableFrom(returnType)) {
                    return response.getEntity(returnType);
                } else {
                    return returnType.cast(response);
                }
            }

        }

        public static class DoGetJson {

            private com.sun.jersey.api.client.Client _client;
            private UriBuilder _uriBuilder;
            private Map<String, Object> _templateAndMatrixParameterValues;

            private DoGetJson(com.sun.jersey.api.client.Client client, UriBuilder uriBuilder, Map<String, Object> map) {
                _client = client;
                _uriBuilder = uriBuilder.clone();
                _templateAndMatrixParameterValues = map;
            }

            /**
             * Create new instance using existing Client instance, and a base URI and any parameters
             * 
             */
            public DoGetJson(com.sun.jersey.api.client.Client client, URI baseUri) {
                _client = client;
                _uriBuilder = UriBuilder.fromUri(baseUri);
                _uriBuilder = _uriBuilder.path("do.get.json");
                _templateAndMatrixParameterValues = new HashMap<String, Object>();
            }

            public WayBillDTO getAsWayBillDTO() {
                UriBuilder localUriBuilder = _uriBuilder.clone();
                com.sun.jersey.api.client.WebResource resource = _client.resource(localUriBuilder.buildFromMap(_templateAndMatrixParameterValues));
                com.sun.jersey.api.client.WebResource.Builder resourceBuilder = resource.getRequestBuilder();
                resourceBuilder = resourceBuilder.accept("application/json");
                com.sun.jersey.api.client.ClientResponse response;
                response = resourceBuilder.method("GET", com.sun.jersey.api.client.ClientResponse.class);
                if (response.getStatus()>= 400) {
                    throw new RestService.WebApplicationExceptionMessage(Response.status(response.getClientResponseStatus()).build());
                }
                return response.getEntity(WayBillDTO.class);
            }

            public<T >T getAsJson(com.sun.jersey.api.client.GenericType<T> returnType) {
                UriBuilder localUriBuilder = _uriBuilder.clone();
                com.sun.jersey.api.client.WebResource resource = _client.resource(localUriBuilder.buildFromMap(_templateAndMatrixParameterValues));
                com.sun.jersey.api.client.WebResource.Builder resourceBuilder = resource.getRequestBuilder();
                resourceBuilder = resourceBuilder.accept("application/json");
                com.sun.jersey.api.client.ClientResponse response;
                response = resourceBuilder.method("GET", com.sun.jersey.api.client.ClientResponse.class);
                if (response.getStatus()>= 400) {
                    throw new RestService.WebApplicationExceptionMessage(Response.status(response.getClientResponseStatus()).build());
                }
                return response.getEntity(returnType);
            }

            public<T >T getAsJson(Class<T> returnType) {
                UriBuilder localUriBuilder = _uriBuilder.clone();
                com.sun.jersey.api.client.WebResource resource = _client.resource(localUriBuilder.buildFromMap(_templateAndMatrixParameterValues));
                com.sun.jersey.api.client.WebResource.Builder resourceBuilder = resource.getRequestBuilder();
                resourceBuilder = resourceBuilder.accept("application/json");
                com.sun.jersey.api.client.ClientResponse response;
                response = resourceBuilder.method("GET", com.sun.jersey.api.client.ClientResponse.class);
                if (!com.sun.jersey.api.client.ClientResponse.class.isAssignableFrom(returnType)) {
                    if (response.getStatus()>= 400) {
                        throw new RestService.WebApplicationExceptionMessage(Response.status(response.getClientResponseStatus()).build());
                    }
                }
                if (!com.sun.jersey.api.client.ClientResponse.class.isAssignableFrom(returnType)) {
                    return response.getEntity(returnType);
                } else {
                    return returnType.cast(response);
                }
            }

            public WayBillDTO getAsWayBillDTO(Integer id) {
                UriBuilder localUriBuilder = _uriBuilder.clone();
                if (id == null) {
                }
                if (id!= null) {
                    localUriBuilder = localUriBuilder.replaceQueryParam("id", id);
                } else {
                    localUriBuilder = localUriBuilder.replaceQueryParam("id", ((Object[]) null));
                }
                com.sun.jersey.api.client.WebResource resource = _client.resource(localUriBuilder.buildFromMap(_templateAndMatrixParameterValues));
                com.sun.jersey.api.client.WebResource.Builder resourceBuilder = resource.getRequestBuilder();
                resourceBuilder = resourceBuilder.accept("application/json");
                com.sun.jersey.api.client.ClientResponse response;
                response = resourceBuilder.method("GET", com.sun.jersey.api.client.ClientResponse.class);
                if (response.getStatus()>= 400) {
                    throw new RestService.WebApplicationExceptionMessage(Response.status(response.getClientResponseStatus()).build());
                }
                return response.getEntity(WayBillDTO.class);
            }

            public<T >T getAsJson(Integer id, com.sun.jersey.api.client.GenericType<T> returnType) {
                UriBuilder localUriBuilder = _uriBuilder.clone();
                if (id == null) {
                }
                if (id!= null) {
                    localUriBuilder = localUriBuilder.replaceQueryParam("id", id);
                } else {
                    localUriBuilder = localUriBuilder.replaceQueryParam("id", ((Object[]) null));
                }
                com.sun.jersey.api.client.WebResource resource = _client.resource(localUriBuilder.buildFromMap(_templateAndMatrixParameterValues));
                com.sun.jersey.api.client.WebResource.Builder resourceBuilder = resource.getRequestBuilder();
                resourceBuilder = resourceBuilder.accept("application/json");
                com.sun.jersey.api.client.ClientResponse response;
                response = resourceBuilder.method("GET", com.sun.jersey.api.client.ClientResponse.class);
                if (response.getStatus()>= 400) {
                    throw new RestService.WebApplicationExceptionMessage(Response.status(response.getClientResponseStatus()).build());
                }
                return response.getEntity(returnType);
            }

            public<T >T getAsJson(Integer id, Class<T> returnType) {
                UriBuilder localUriBuilder = _uriBuilder.clone();
                if (id == null) {
                }
                if (id!= null) {
                    localUriBuilder = localUriBuilder.replaceQueryParam("id", id);
                } else {
                    localUriBuilder = localUriBuilder.replaceQueryParam("id", ((Object[]) null));
                }
                com.sun.jersey.api.client.WebResource resource = _client.resource(localUriBuilder.buildFromMap(_templateAndMatrixParameterValues));
                com.sun.jersey.api.client.WebResource.Builder resourceBuilder = resource.getRequestBuilder();
                resourceBuilder = resourceBuilder.accept("application/json");
                com.sun.jersey.api.client.ClientResponse response;
                response = resourceBuilder.method("GET", com.sun.jersey.api.client.ClientResponse.class);
                if (!com.sun.jersey.api.client.ClientResponse.class.isAssignableFrom(returnType)) {
                    if (response.getStatus()>= 400) {
                        throw new RestService.WebApplicationExceptionMessage(Response.status(response.getClientResponseStatus()).build());
                    }
                }
                if (!com.sun.jersey.api.client.ClientResponse.class.isAssignableFrom(returnType)) {
                    return response.getEntity(returnType);
                } else {
                    return returnType.cast(response);
                }
            }

        }

        public static class DoListJson {

            private com.sun.jersey.api.client.Client _client;
            private UriBuilder _uriBuilder;
            private Map<String, Object> _templateAndMatrixParameterValues;

            private DoListJson(com.sun.jersey.api.client.Client client, UriBuilder uriBuilder, Map<String, Object> map) {
                _client = client;
                _uriBuilder = uriBuilder.clone();
                _templateAndMatrixParameterValues = map;
            }

            /**
             * Create new instance using existing Client instance, and a base URI and any parameters
             * 
             */
            public DoListJson(com.sun.jersey.api.client.Client client, URI baseUri) {
                _client = client;
                _uriBuilder = UriBuilder.fromUri(baseUri);
                _uriBuilder = _uriBuilder.path("do.list.json");
                _templateAndMatrixParameterValues = new HashMap<String, Object>();
            }

            public ListDTO getAsListDTO() {
                UriBuilder localUriBuilder = _uriBuilder.clone();
                com.sun.jersey.api.client.WebResource resource = _client.resource(localUriBuilder.buildFromMap(_templateAndMatrixParameterValues));
                com.sun.jersey.api.client.WebResource.Builder resourceBuilder = resource.getRequestBuilder();
                resourceBuilder = resourceBuilder.accept("application/json");
                com.sun.jersey.api.client.ClientResponse response;
                response = resourceBuilder.method("GET", com.sun.jersey.api.client.ClientResponse.class);
                if (response.getStatus()>= 400) {
                    throw new RestService.WebApplicationExceptionMessage(Response.status(response.getClientResponseStatus()).build());
                }
                return response.getEntity(ListDTO.class);
            }

            public<T >T getAsJson(com.sun.jersey.api.client.GenericType<T> returnType) {
                UriBuilder localUriBuilder = _uriBuilder.clone();
                com.sun.jersey.api.client.WebResource resource = _client.resource(localUriBuilder.buildFromMap(_templateAndMatrixParameterValues));
                com.sun.jersey.api.client.WebResource.Builder resourceBuilder = resource.getRequestBuilder();
                resourceBuilder = resourceBuilder.accept("application/json");
                com.sun.jersey.api.client.ClientResponse response;
                response = resourceBuilder.method("GET", com.sun.jersey.api.client.ClientResponse.class);
                if (response.getStatus()>= 400) {
                    throw new RestService.WebApplicationExceptionMessage(Response.status(response.getClientResponseStatus()).build());
                }
                return response.getEntity(returnType);
            }

            public<T >T getAsJson(Class<T> returnType) {
                UriBuilder localUriBuilder = _uriBuilder.clone();
                com.sun.jersey.api.client.WebResource resource = _client.resource(localUriBuilder.buildFromMap(_templateAndMatrixParameterValues));
                com.sun.jersey.api.client.WebResource.Builder resourceBuilder = resource.getRequestBuilder();
                resourceBuilder = resourceBuilder.accept("application/json");
                com.sun.jersey.api.client.ClientResponse response;
                response = resourceBuilder.method("GET", com.sun.jersey.api.client.ClientResponse.class);
                if (!com.sun.jersey.api.client.ClientResponse.class.isAssignableFrom(returnType)) {
                    if (response.getStatus()>= 400) {
                        throw new RestService.WebApplicationExceptionMessage(Response.status(response.getClientResponseStatus()).build());
                    }
                }
                if (!com.sun.jersey.api.client.ClientResponse.class.isAssignableFrom(returnType)) {
                    return response.getEntity(returnType);
                } else {
                    return returnType.cast(response);
                }
            }

            public ListDTO getAsListDTO(Boolean all, Integer page, Integer perpage) {
                UriBuilder localUriBuilder = _uriBuilder.clone();
                if (all == null) {
                }
                if (all!= null) {
                    localUriBuilder = localUriBuilder.replaceQueryParam("all", all);
                } else {
                    localUriBuilder = localUriBuilder.replaceQueryParam("all", ((Object[]) null));
                }
                if (page == null) {
                }
                if (page!= null) {
                    localUriBuilder = localUriBuilder.replaceQueryParam("page", page);
                } else {
                    localUriBuilder = localUriBuilder.replaceQueryParam("page", ((Object[]) null));
                }
                if (perpage == null) {
                }
                if (perpage!= null) {
                    localUriBuilder = localUriBuilder.replaceQueryParam("perpage", perpage);
                } else {
                    localUriBuilder = localUriBuilder.replaceQueryParam("perpage", ((Object[]) null));
                }
                com.sun.jersey.api.client.WebResource resource = _client.resource(localUriBuilder.buildFromMap(_templateAndMatrixParameterValues));
                com.sun.jersey.api.client.WebResource.Builder resourceBuilder = resource.getRequestBuilder();
                resourceBuilder = resourceBuilder.accept("application/json");
                com.sun.jersey.api.client.ClientResponse response;
                response = resourceBuilder.method("GET", com.sun.jersey.api.client.ClientResponse.class);
                if (response.getStatus()>= 400) {
                    throw new RestService.WebApplicationExceptionMessage(Response.status(response.getClientResponseStatus()).build());
                }
                return response.getEntity(ListDTO.class);
            }

            public<T >T getAsJson(Boolean all, Integer page, Integer perpage, com.sun.jersey.api.client.GenericType<T> returnType) {
                UriBuilder localUriBuilder = _uriBuilder.clone();
                if (all == null) {
                }
                if (all!= null) {
                    localUriBuilder = localUriBuilder.replaceQueryParam("all", all);
                } else {
                    localUriBuilder = localUriBuilder.replaceQueryParam("all", ((Object[]) null));
                }
                if (page == null) {
                }
                if (page!= null) {
                    localUriBuilder = localUriBuilder.replaceQueryParam("page", page);
                } else {
                    localUriBuilder = localUriBuilder.replaceQueryParam("page", ((Object[]) null));
                }
                if (perpage == null) {
                }
                if (perpage!= null) {
                    localUriBuilder = localUriBuilder.replaceQueryParam("perpage", perpage);
                } else {
                    localUriBuilder = localUriBuilder.replaceQueryParam("perpage", ((Object[]) null));
                }
                com.sun.jersey.api.client.WebResource resource = _client.resource(localUriBuilder.buildFromMap(_templateAndMatrixParameterValues));
                com.sun.jersey.api.client.WebResource.Builder resourceBuilder = resource.getRequestBuilder();
                resourceBuilder = resourceBuilder.accept("application/json");
                com.sun.jersey.api.client.ClientResponse response;
                response = resourceBuilder.method("GET", com.sun.jersey.api.client.ClientResponse.class);
                if (response.getStatus()>= 400) {
                    throw new RestService.WebApplicationExceptionMessage(Response.status(response.getClientResponseStatus()).build());
                }
                return response.getEntity(returnType);
            }

            public<T >T getAsJson(Boolean all, Integer page, Integer perpage, Class<T> returnType) {
                UriBuilder localUriBuilder = _uriBuilder.clone();
                if (all == null) {
                }
                if (all!= null) {
                    localUriBuilder = localUriBuilder.replaceQueryParam("all", all);
                } else {
                    localUriBuilder = localUriBuilder.replaceQueryParam("all", ((Object[]) null));
                }
                if (page == null) {
                }
                if (page!= null) {
                    localUriBuilder = localUriBuilder.replaceQueryParam("page", page);
                } else {
                    localUriBuilder = localUriBuilder.replaceQueryParam("page", ((Object[]) null));
                }
                if (perpage == null) {
                }
                if (perpage!= null) {
                    localUriBuilder = localUriBuilder.replaceQueryParam("perpage", perpage);
                } else {
                    localUriBuilder = localUriBuilder.replaceQueryParam("perpage", ((Object[]) null));
                }
                com.sun.jersey.api.client.WebResource resource = _client.resource(localUriBuilder.buildFromMap(_templateAndMatrixParameterValues));
                com.sun.jersey.api.client.WebResource.Builder resourceBuilder = resource.getRequestBuilder();
                resourceBuilder = resourceBuilder.accept("application/json");
                com.sun.jersey.api.client.ClientResponse response;
                response = resourceBuilder.method("GET", com.sun.jersey.api.client.ClientResponse.class);
                if (!com.sun.jersey.api.client.ClientResponse.class.isAssignableFrom(returnType)) {
                    if (response.getStatus()>= 400) {
                        throw new RestService.WebApplicationExceptionMessage(Response.status(response.getClientResponseStatus()).build());
                    }
                }
                if (!com.sun.jersey.api.client.ClientResponse.class.isAssignableFrom(returnType)) {
                    return response.getEntity(returnType);
                } else {
                    return returnType.cast(response);
                }
            }

        }

        public static class DoUpdateitemsJson {

            private com.sun.jersey.api.client.Client _client;
            private UriBuilder _uriBuilder;
            private Map<String, Object> _templateAndMatrixParameterValues;

            private DoUpdateitemsJson(com.sun.jersey.api.client.Client client, UriBuilder uriBuilder, Map<String, Object> map) {
                _client = client;
                _uriBuilder = uriBuilder.clone();
                _templateAndMatrixParameterValues = map;
            }

            /**
             * Create new instance using existing Client instance, and a base URI and any parameters
             * 
             */
            public DoUpdateitemsJson(com.sun.jersey.api.client.Client client, URI baseUri) {
                _client = client;
                _uriBuilder = UriBuilder.fromUri(baseUri);
                _uriBuilder = _uriBuilder.path("do.updateitems.json");
                _templateAndMatrixParameterValues = new HashMap<String, Object>();
            }

            public SimpleDataDTO getAsSimpleDataDTO() {
                UriBuilder localUriBuilder = _uriBuilder.clone();
                com.sun.jersey.api.client.WebResource resource = _client.resource(localUriBuilder.buildFromMap(_templateAndMatrixParameterValues));
                com.sun.jersey.api.client.WebResource.Builder resourceBuilder = resource.getRequestBuilder();
                resourceBuilder = resourceBuilder.accept("application/json");
                com.sun.jersey.api.client.ClientResponse response;
                response = resourceBuilder.method("GET", com.sun.jersey.api.client.ClientResponse.class);
                if (response.getStatus()>= 400) {
                    throw new RestService.WebApplicationExceptionMessage(Response.status(response.getClientResponseStatus()).build());
                }
                return response.getEntity(SimpleDataDTO.class);
            }

            public<T >T getAsJson(com.sun.jersey.api.client.GenericType<T> returnType) {
                UriBuilder localUriBuilder = _uriBuilder.clone();
                com.sun.jersey.api.client.WebResource resource = _client.resource(localUriBuilder.buildFromMap(_templateAndMatrixParameterValues));
                com.sun.jersey.api.client.WebResource.Builder resourceBuilder = resource.getRequestBuilder();
                resourceBuilder = resourceBuilder.accept("application/json");
                com.sun.jersey.api.client.ClientResponse response;
                response = resourceBuilder.method("GET", com.sun.jersey.api.client.ClientResponse.class);
                if (response.getStatus()>= 400) {
                    throw new RestService.WebApplicationExceptionMessage(Response.status(response.getClientResponseStatus()).build());
                }
                return response.getEntity(returnType);
            }

            public<T >T getAsJson(Class<T> returnType) {
                UriBuilder localUriBuilder = _uriBuilder.clone();
                com.sun.jersey.api.client.WebResource resource = _client.resource(localUriBuilder.buildFromMap(_templateAndMatrixParameterValues));
                com.sun.jersey.api.client.WebResource.Builder resourceBuilder = resource.getRequestBuilder();
                resourceBuilder = resourceBuilder.accept("application/json");
                com.sun.jersey.api.client.ClientResponse response;
                response = resourceBuilder.method("GET", com.sun.jersey.api.client.ClientResponse.class);
                if (!com.sun.jersey.api.client.ClientResponse.class.isAssignableFrom(returnType)) {
                    if (response.getStatus()>= 400) {
                        throw new RestService.WebApplicationExceptionMessage(Response.status(response.getClientResponseStatus()).build());
                    }
                }
                if (!com.sun.jersey.api.client.ClientResponse.class.isAssignableFrom(returnType)) {
                    return response.getEntity(returnType);
                } else {
                    return returnType.cast(response);
                }
            }

            public SimpleDataDTO getAsSimpleDataDTO(Integer id, String counts, String products) {
                UriBuilder localUriBuilder = _uriBuilder.clone();
                if (id == null) {
                }
                if (id!= null) {
                    localUriBuilder = localUriBuilder.replaceQueryParam("id", id);
                } else {
                    localUriBuilder = localUriBuilder.replaceQueryParam("id", ((Object[]) null));
                }
                if (counts == null) {
                }
                if (counts!= null) {
                    localUriBuilder = localUriBuilder.replaceQueryParam("counts", counts);
                } else {
                    localUriBuilder = localUriBuilder.replaceQueryParam("counts", ((Object[]) null));
                }
                if (products == null) {
                }
                if (products!= null) {
                    localUriBuilder = localUriBuilder.replaceQueryParam("products", products);
                } else {
                    localUriBuilder = localUriBuilder.replaceQueryParam("products", ((Object[]) null));
                }
                com.sun.jersey.api.client.WebResource resource = _client.resource(localUriBuilder.buildFromMap(_templateAndMatrixParameterValues));
                com.sun.jersey.api.client.WebResource.Builder resourceBuilder = resource.getRequestBuilder();
                resourceBuilder = resourceBuilder.accept("application/json");
                com.sun.jersey.api.client.ClientResponse response;
                response = resourceBuilder.method("GET", com.sun.jersey.api.client.ClientResponse.class);
                if (response.getStatus()>= 400) {
                    throw new RestService.WebApplicationExceptionMessage(Response.status(response.getClientResponseStatus()).build());
                }
                return response.getEntity(SimpleDataDTO.class);
            }

            public<T >T getAsJson(Integer id, String counts, String products, com.sun.jersey.api.client.GenericType<T> returnType) {
                UriBuilder localUriBuilder = _uriBuilder.clone();
                if (id == null) {
                }
                if (id!= null) {
                    localUriBuilder = localUriBuilder.replaceQueryParam("id", id);
                } else {
                    localUriBuilder = localUriBuilder.replaceQueryParam("id", ((Object[]) null));
                }
                if (counts == null) {
                }
                if (counts!= null) {
                    localUriBuilder = localUriBuilder.replaceQueryParam("counts", counts);
                } else {
                    localUriBuilder = localUriBuilder.replaceQueryParam("counts", ((Object[]) null));
                }
                if (products == null) {
                }
                if (products!= null) {
                    localUriBuilder = localUriBuilder.replaceQueryParam("products", products);
                } else {
                    localUriBuilder = localUriBuilder.replaceQueryParam("products", ((Object[]) null));
                }
                com.sun.jersey.api.client.WebResource resource = _client.resource(localUriBuilder.buildFromMap(_templateAndMatrixParameterValues));
                com.sun.jersey.api.client.WebResource.Builder resourceBuilder = resource.getRequestBuilder();
                resourceBuilder = resourceBuilder.accept("application/json");
                com.sun.jersey.api.client.ClientResponse response;
                response = resourceBuilder.method("GET", com.sun.jersey.api.client.ClientResponse.class);
                if (response.getStatus()>= 400) {
                    throw new RestService.WebApplicationExceptionMessage(Response.status(response.getClientResponseStatus()).build());
                }
                return response.getEntity(returnType);
            }

            public<T >T getAsJson(Integer id, String counts, String products, Class<T> returnType) {
                UriBuilder localUriBuilder = _uriBuilder.clone();
                if (id == null) {
                }
                if (id!= null) {
                    localUriBuilder = localUriBuilder.replaceQueryParam("id", id);
                } else {
                    localUriBuilder = localUriBuilder.replaceQueryParam("id", ((Object[]) null));
                }
                if (counts == null) {
                }
                if (counts!= null) {
                    localUriBuilder = localUriBuilder.replaceQueryParam("counts", counts);
                } else {
                    localUriBuilder = localUriBuilder.replaceQueryParam("counts", ((Object[]) null));
                }
                if (products == null) {
                }
                if (products!= null) {
                    localUriBuilder = localUriBuilder.replaceQueryParam("products", products);
                } else {
                    localUriBuilder = localUriBuilder.replaceQueryParam("products", ((Object[]) null));
                }
                com.sun.jersey.api.client.WebResource resource = _client.resource(localUriBuilder.buildFromMap(_templateAndMatrixParameterValues));
                com.sun.jersey.api.client.WebResource.Builder resourceBuilder = resource.getRequestBuilder();
                resourceBuilder = resourceBuilder.accept("application/json");
                com.sun.jersey.api.client.ClientResponse response;
                response = resourceBuilder.method("GET", com.sun.jersey.api.client.ClientResponse.class);
                if (!com.sun.jersey.api.client.ClientResponse.class.isAssignableFrom(returnType)) {
                    if (response.getStatus()>= 400) {
                        throw new RestService.WebApplicationExceptionMessage(Response.status(response.getClientResponseStatus()).build());
                    }
                }
                if (!com.sun.jersey.api.client.ClientResponse.class.isAssignableFrom(returnType)) {
                    return response.getEntity(returnType);
                } else {
                    return returnType.cast(response);
                }
            }

        }

        public static class DoUpdateJson {

            private com.sun.jersey.api.client.Client _client;
            private UriBuilder _uriBuilder;
            private Map<String, Object> _templateAndMatrixParameterValues;

            private DoUpdateJson(com.sun.jersey.api.client.Client client, UriBuilder uriBuilder, Map<String, Object> map) {
                _client = client;
                _uriBuilder = uriBuilder.clone();
                _templateAndMatrixParameterValues = map;
            }

            /**
             * Create new instance using existing Client instance, and a base URI and any parameters
             * 
             */
            public DoUpdateJson(com.sun.jersey.api.client.Client client, URI baseUri) {
                _client = client;
                _uriBuilder = UriBuilder.fromUri(baseUri);
                _uriBuilder = _uriBuilder.path("do.update.json");
                _templateAndMatrixParameterValues = new HashMap<String, Object>();
            }

            public SimpleDataDTO postAsSimpleDataDTO() {
                UriBuilder localUriBuilder = _uriBuilder.clone();
                com.sun.jersey.api.client.WebResource resource = _client.resource(localUriBuilder.buildFromMap(_templateAndMatrixParameterValues));
                com.sun.jersey.api.client.WebResource.Builder resourceBuilder = resource.getRequestBuilder();
                resourceBuilder = resourceBuilder.accept("application/json");
                com.sun.jersey.api.client.ClientResponse response;
                response = resourceBuilder.method("POST", com.sun.jersey.api.client.ClientResponse.class);
                if (response.getStatus()>= 400) {
                    throw new RestService.WebApplicationExceptionMessage(Response.status(response.getClientResponseStatus()).build());
                }
                return response.getEntity(SimpleDataDTO.class);
            }

            public<T >T postAsJson(com.sun.jersey.api.client.GenericType<T> returnType) {
                UriBuilder localUriBuilder = _uriBuilder.clone();
                com.sun.jersey.api.client.WebResource resource = _client.resource(localUriBuilder.buildFromMap(_templateAndMatrixParameterValues));
                com.sun.jersey.api.client.WebResource.Builder resourceBuilder = resource.getRequestBuilder();
                resourceBuilder = resourceBuilder.accept("application/json");
                com.sun.jersey.api.client.ClientResponse response;
                response = resourceBuilder.method("POST", com.sun.jersey.api.client.ClientResponse.class);
                if (response.getStatus()>= 400) {
                    throw new RestService.WebApplicationExceptionMessage(Response.status(response.getClientResponseStatus()).build());
                }
                return response.getEntity(returnType);
            }

            public<T >T postAsJson(Class<T> returnType) {
                UriBuilder localUriBuilder = _uriBuilder.clone();
                com.sun.jersey.api.client.WebResource resource = _client.resource(localUriBuilder.buildFromMap(_templateAndMatrixParameterValues));
                com.sun.jersey.api.client.WebResource.Builder resourceBuilder = resource.getRequestBuilder();
                resourceBuilder = resourceBuilder.accept("application/json");
                com.sun.jersey.api.client.ClientResponse response;
                response = resourceBuilder.method("POST", com.sun.jersey.api.client.ClientResponse.class);
                if (!com.sun.jersey.api.client.ClientResponse.class.isAssignableFrom(returnType)) {
                    if (response.getStatus()>= 400) {
                        throw new RestService.WebApplicationExceptionMessage(Response.status(response.getClientResponseStatus()).build());
                    }
                }
                if (!com.sun.jersey.api.client.ClientResponse.class.isAssignableFrom(returnType)) {
                    return response.getEntity(returnType);
                } else {
                    return returnType.cast(response);
                }
            }

            public SimpleDataDTO postAsSimpleDataDTO(Long date, Integer count, String products, String counts, String title, String supplier) {
                UriBuilder localUriBuilder = _uriBuilder.clone();
                if (date == null) {
                }
                if (date!= null) {
                    localUriBuilder = localUriBuilder.replaceQueryParam("date", date);
                } else {
                    localUriBuilder = localUriBuilder.replaceQueryParam("date", ((Object[]) null));
                }
                if (count == null) {
                }
                if (count!= null) {
                    localUriBuilder = localUriBuilder.replaceQueryParam("count", count);
                } else {
                    localUriBuilder = localUriBuilder.replaceQueryParam("count", ((Object[]) null));
                }
                if (products == null) {
                }
                if (products!= null) {
                    localUriBuilder = localUriBuilder.replaceQueryParam("products", products);
                } else {
                    localUriBuilder = localUriBuilder.replaceQueryParam("products", ((Object[]) null));
                }
                if (counts == null) {
                }
                if (counts!= null) {
                    localUriBuilder = localUriBuilder.replaceQueryParam("counts", counts);
                } else {
                    localUriBuilder = localUriBuilder.replaceQueryParam("counts", ((Object[]) null));
                }
                if (title == null) {
                }
                if (title!= null) {
                    localUriBuilder = localUriBuilder.replaceQueryParam("title", title);
                } else {
                    localUriBuilder = localUriBuilder.replaceQueryParam("title", ((Object[]) null));
                }
                if (supplier == null) {
                }
                if (supplier!= null) {
                    localUriBuilder = localUriBuilder.replaceQueryParam("supplier", supplier);
                } else {
                    localUriBuilder = localUriBuilder.replaceQueryParam("supplier", ((Object[]) null));
                }
                com.sun.jersey.api.client.WebResource resource = _client.resource(localUriBuilder.buildFromMap(_templateAndMatrixParameterValues));
                com.sun.jersey.api.client.WebResource.Builder resourceBuilder = resource.getRequestBuilder();
                resourceBuilder = resourceBuilder.accept("application/json");
                com.sun.jersey.api.client.ClientResponse response;
                response = resourceBuilder.method("POST", com.sun.jersey.api.client.ClientResponse.class);
                if (response.getStatus()>= 400) {
                    throw new RestService.WebApplicationExceptionMessage(Response.status(response.getClientResponseStatus()).build());
                }
                return response.getEntity(SimpleDataDTO.class);
            }

            public<T >T postAsJson(Long date, Integer count, String products, String counts, String title, String supplier, com.sun.jersey.api.client.GenericType<T> returnType) {
                UriBuilder localUriBuilder = _uriBuilder.clone();
                if (date == null) {
                }
                if (date!= null) {
                    localUriBuilder = localUriBuilder.replaceQueryParam("date", date);
                } else {
                    localUriBuilder = localUriBuilder.replaceQueryParam("date", ((Object[]) null));
                }
                if (count == null) {
                }
                if (count!= null) {
                    localUriBuilder = localUriBuilder.replaceQueryParam("count", count);
                } else {
                    localUriBuilder = localUriBuilder.replaceQueryParam("count", ((Object[]) null));
                }
                if (products == null) {
                }
                if (products!= null) {
                    localUriBuilder = localUriBuilder.replaceQueryParam("products", products);
                } else {
                    localUriBuilder = localUriBuilder.replaceQueryParam("products", ((Object[]) null));
                }
                if (counts == null) {
                }
                if (counts!= null) {
                    localUriBuilder = localUriBuilder.replaceQueryParam("counts", counts);
                } else {
                    localUriBuilder = localUriBuilder.replaceQueryParam("counts", ((Object[]) null));
                }
                if (title == null) {
                }
                if (title!= null) {
                    localUriBuilder = localUriBuilder.replaceQueryParam("title", title);
                } else {
                    localUriBuilder = localUriBuilder.replaceQueryParam("title", ((Object[]) null));
                }
                if (supplier == null) {
                }
                if (supplier!= null) {
                    localUriBuilder = localUriBuilder.replaceQueryParam("supplier", supplier);
                } else {
                    localUriBuilder = localUriBuilder.replaceQueryParam("supplier", ((Object[]) null));
                }
                com.sun.jersey.api.client.WebResource resource = _client.resource(localUriBuilder.buildFromMap(_templateAndMatrixParameterValues));
                com.sun.jersey.api.client.WebResource.Builder resourceBuilder = resource.getRequestBuilder();
                resourceBuilder = resourceBuilder.accept("application/json");
                com.sun.jersey.api.client.ClientResponse response;
                response = resourceBuilder.method("POST", com.sun.jersey.api.client.ClientResponse.class);
                if (response.getStatus()>= 400) {
                    throw new RestService.WebApplicationExceptionMessage(Response.status(response.getClientResponseStatus()).build());
                }
                return response.getEntity(returnType);
            }

            public<T >T postAsJson(Long date, Integer count, String products, String counts, String title, String supplier, Class<T> returnType) {
                UriBuilder localUriBuilder = _uriBuilder.clone();
                if (date == null) {
                }
                if (date!= null) {
                    localUriBuilder = localUriBuilder.replaceQueryParam("date", date);
                } else {
                    localUriBuilder = localUriBuilder.replaceQueryParam("date", ((Object[]) null));
                }
                if (count == null) {
                }
                if (count!= null) {
                    localUriBuilder = localUriBuilder.replaceQueryParam("count", count);
                } else {
                    localUriBuilder = localUriBuilder.replaceQueryParam("count", ((Object[]) null));
                }
                if (products == null) {
                }
                if (products!= null) {
                    localUriBuilder = localUriBuilder.replaceQueryParam("products", products);
                } else {
                    localUriBuilder = localUriBuilder.replaceQueryParam("products", ((Object[]) null));
                }
                if (counts == null) {
                }
                if (counts!= null) {
                    localUriBuilder = localUriBuilder.replaceQueryParam("counts", counts);
                } else {
                    localUriBuilder = localUriBuilder.replaceQueryParam("counts", ((Object[]) null));
                }
                if (title == null) {
                }
                if (title!= null) {
                    localUriBuilder = localUriBuilder.replaceQueryParam("title", title);
                } else {
                    localUriBuilder = localUriBuilder.replaceQueryParam("title", ((Object[]) null));
                }
                if (supplier == null) {
                }
                if (supplier!= null) {
                    localUriBuilder = localUriBuilder.replaceQueryParam("supplier", supplier);
                } else {
                    localUriBuilder = localUriBuilder.replaceQueryParam("supplier", ((Object[]) null));
                }
                com.sun.jersey.api.client.WebResource resource = _client.resource(localUriBuilder.buildFromMap(_templateAndMatrixParameterValues));
                com.sun.jersey.api.client.WebResource.Builder resourceBuilder = resource.getRequestBuilder();
                resourceBuilder = resourceBuilder.accept("application/json");
                com.sun.jersey.api.client.ClientResponse response;
                response = resourceBuilder.method("POST", com.sun.jersey.api.client.ClientResponse.class);
                if (!com.sun.jersey.api.client.ClientResponse.class.isAssignableFrom(returnType)) {
                    if (response.getStatus()>= 400) {
                        throw new RestService.WebApplicationExceptionMessage(Response.status(response.getClientResponseStatus()).build());
                    }
                }
                if (!com.sun.jersey.api.client.ClientResponse.class.isAssignableFrom(returnType)) {
                    return response.getEntity(returnType);
                } else {
                    return returnType.cast(response);
                }
            }

        }

    }


    /**
     * Workaround for JAX_RS_SPEC-312
     * 
     */
    private static class WebApplicationExceptionMessage
        extends WebApplicationException
    {


        private WebApplicationExceptionMessage(Response response) {
            super(response);
        }

        /**
         * Workaround for JAX_RS_SPEC-312
         * 
         */
        public String getMessage() {
            Response response = getResponse();
            Response.Status status = Response.Status.fromStatusCode(response.getStatus());
            if (status!= null) {
                return (response.getStatus()+(" "+ status.getReasonPhrase()));
            } else {
                return Integer.toString(response.getStatus());
            }
        }

        public String toString() {
            String s = "javax.ws.rs.WebApplicationException";
            String message = getLocalizedMessage();
            return (s +(": "+ message));
        }

    }

}
