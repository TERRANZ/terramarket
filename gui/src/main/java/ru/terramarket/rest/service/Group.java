package ru.terramarket.rest.service;

import ru.terramarket.rest.dto.GroupDTO;
import ru.terramarket.rest.dto.ListDTO;
import ru.terramarket.rest.dto.SimpleDataDTO;

import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriBuilder;
import java.net.URI;
import java.util.HashMap;
import java.util.Map;

/**
 * Date: 26.05.14
 * Time: 16:11
 */
public class Group extends TMRestServiceBase {

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
     */
    public Group(com.sun.jersey.api.client.Client client, URI baseUri) {
        _client = client;
        _uriBuilder = UriBuilder.fromUri(baseUri);
        _uriBuilder = _uriBuilder.path("/group/");
        _templateAndMatrixParameterValues = new HashMap<String, Object>();
    }

    public DoUpdateJson doUpdateJson() {
        return new DoUpdateJson(_client, _uriBuilder.buildFromMap(_templateAndMatrixParameterValues));
    }

    public DoCreateJson doCreateJson() {
        return new DoCreateJson(_client, _uriBuilder.buildFromMap(_templateAndMatrixParameterValues));
    }

    public DoGetJson doGetJson() {
        return new DoGetJson(_client, _uriBuilder.buildFromMap(_templateAndMatrixParameterValues));
    }

    public DoDeleteJson doDeleteJson() {
        return new DoDeleteJson(_client, _uriBuilder.buildFromMap(_templateAndMatrixParameterValues));
    }

    public DoListJson doListJson() {
        return new DoListJson(_client, _uriBuilder.buildFromMap(_templateAndMatrixParameterValues));
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
            if (response.getStatus() >= 400) {
                throw new TMRestServiceBase.WebApplicationExceptionMessage(Response.status(response.getStatusInfo()).build());
            }
            return response.getEntity(GroupDTO.class);
        }

        public <T> T postAsJson(com.sun.jersey.api.client.GenericType<T> returnType) {
            UriBuilder localUriBuilder = _uriBuilder.clone();
            com.sun.jersey.api.client.WebResource resource = _client.resource(localUriBuilder.buildFromMap(_templateAndMatrixParameterValues));
            com.sun.jersey.api.client.WebResource.Builder resourceBuilder = resource.getRequestBuilder();
            resourceBuilder = resourceBuilder.accept("application/json");
            com.sun.jersey.api.client.ClientResponse response;
            response = resourceBuilder.method("POST", com.sun.jersey.api.client.ClientResponse.class);
            if (response.getStatus() >= 400) {
                throw new TMRestServiceBase.WebApplicationExceptionMessage(Response.status(response.getStatusInfo()).build());
            }
            return response.getEntity(returnType);
        }

        public <T> T postAsJson(Class<T> returnType) {
            UriBuilder localUriBuilder = _uriBuilder.clone();
            com.sun.jersey.api.client.WebResource resource = _client.resource(localUriBuilder.buildFromMap(_templateAndMatrixParameterValues));
            com.sun.jersey.api.client.WebResource.Builder resourceBuilder = resource.getRequestBuilder();
            resourceBuilder = resourceBuilder.accept("application/json");
            com.sun.jersey.api.client.ClientResponse response;
            response = resourceBuilder.method("POST", com.sun.jersey.api.client.ClientResponse.class);
            if (!com.sun.jersey.api.client.ClientResponse.class.isAssignableFrom(returnType)) {
                if (response.getStatus() >= 400) {
                    throw new TMRestServiceBase.WebApplicationExceptionMessage(Response.status(response.getStatusInfo()).build());
                }
            }
            if (!com.sun.jersey.api.client.ClientResponse.class.isAssignableFrom(returnType)) {
                return response.getEntity(returnType);
            } else {
                return returnType.cast(response);
            }
        }

        public GroupDTO putAsGroupDTO() {
            UriBuilder localUriBuilder = _uriBuilder.clone();
            com.sun.jersey.api.client.WebResource resource = _client.resource(localUriBuilder.buildFromMap(_templateAndMatrixParameterValues));
            com.sun.jersey.api.client.WebResource.Builder resourceBuilder = resource.getRequestBuilder();
            resourceBuilder = resourceBuilder.accept("application/json");
            com.sun.jersey.api.client.ClientResponse response;
            response = resourceBuilder.method("PUT", com.sun.jersey.api.client.ClientResponse.class);
            if (response.getStatus() >= 400) {
                throw new TMRestServiceBase.WebApplicationExceptionMessage(Response.status(response.getStatusInfo()).build());
            }
            return response.getEntity(GroupDTO.class);
        }

        public <T> T putAsJson(com.sun.jersey.api.client.GenericType<T> returnType) {
            UriBuilder localUriBuilder = _uriBuilder.clone();
            com.sun.jersey.api.client.WebResource resource = _client.resource(localUriBuilder.buildFromMap(_templateAndMatrixParameterValues));
            com.sun.jersey.api.client.WebResource.Builder resourceBuilder = resource.getRequestBuilder();
            resourceBuilder = resourceBuilder.accept("application/json");
            com.sun.jersey.api.client.ClientResponse response;
            response = resourceBuilder.method("PUT", com.sun.jersey.api.client.ClientResponse.class);
            if (response.getStatus() >= 400) {
                throw new TMRestServiceBase.WebApplicationExceptionMessage(Response.status(response.getStatusInfo()).build());
            }
            return response.getEntity(returnType);
        }

        public <T> T putAsJson(Class<T> returnType) {
            UriBuilder localUriBuilder = _uriBuilder.clone();
            com.sun.jersey.api.client.WebResource resource = _client.resource(localUriBuilder.buildFromMap(_templateAndMatrixParameterValues));
            com.sun.jersey.api.client.WebResource.Builder resourceBuilder = resource.getRequestBuilder();
            resourceBuilder = resourceBuilder.accept("application/json");
            com.sun.jersey.api.client.ClientResponse response;
            response = resourceBuilder.method("PUT", com.sun.jersey.api.client.ClientResponse.class);
            if (!com.sun.jersey.api.client.ClientResponse.class.isAssignableFrom(returnType)) {
                if (response.getStatus() >= 400) {
                    throw new TMRestServiceBase.WebApplicationExceptionMessage(Response.status(response.getStatusInfo()).build());
                }
            }
            if (!com.sun.jersey.api.client.ClientResponse.class.isAssignableFrom(returnType)) {
                return response.getEntity(returnType);
            } else {
                return returnType.cast(response);
            }
        }

        public GroupDTO putAsGroupDTO(String json) {
            UriBuilder localUriBuilder = _uriBuilder.clone();
            if (json == null) {
            }
            if (json != null) {
                localUriBuilder = localUriBuilder.replaceQueryParam("json", json);
            } else {
                localUriBuilder = localUriBuilder.replaceQueryParam("json", ((Object[]) null));
            }
            com.sun.jersey.api.client.WebResource resource = _client.resource(localUriBuilder.buildFromMap(_templateAndMatrixParameterValues));
            com.sun.jersey.api.client.WebResource.Builder resourceBuilder = resource.getRequestBuilder();
            resourceBuilder = resourceBuilder.accept("application/json");
            com.sun.jersey.api.client.ClientResponse response;
            response = resourceBuilder.method("PUT", com.sun.jersey.api.client.ClientResponse.class);
            if (response.getStatus() >= 400) {
                throw new TMRestServiceBase.WebApplicationExceptionMessage(Response.status(response.getStatusInfo()).build());
            }
            return response.getEntity(GroupDTO.class);
        }

        public <T> T putAsJson(String json, com.sun.jersey.api.client.GenericType<T> returnType) {
            UriBuilder localUriBuilder = _uriBuilder.clone();
            if (json == null) {
            }
            if (json != null) {
                localUriBuilder = localUriBuilder.replaceQueryParam("json", json);
            } else {
                localUriBuilder = localUriBuilder.replaceQueryParam("json", ((Object[]) null));
            }
            com.sun.jersey.api.client.WebResource resource = _client.resource(localUriBuilder.buildFromMap(_templateAndMatrixParameterValues));
            com.sun.jersey.api.client.WebResource.Builder resourceBuilder = resource.getRequestBuilder();
            resourceBuilder = resourceBuilder.accept("application/json");
            com.sun.jersey.api.client.ClientResponse response;
            response = resourceBuilder.method("PUT", com.sun.jersey.api.client.ClientResponse.class);
            if (response.getStatus() >= 400) {
                throw new TMRestServiceBase.WebApplicationExceptionMessage(Response.status(response.getStatusInfo()).build());
            }
            return response.getEntity(returnType);
        }

        public <T> T putAsJson(String json, Class<T> returnType) {
            UriBuilder localUriBuilder = _uriBuilder.clone();
            if (json == null) {
            }
            if (json != null) {
                localUriBuilder = localUriBuilder.replaceQueryParam("json", json);
            } else {
                localUriBuilder = localUriBuilder.replaceQueryParam("json", ((Object[]) null));
            }
            com.sun.jersey.api.client.WebResource resource = _client.resource(localUriBuilder.buildFromMap(_templateAndMatrixParameterValues));
            com.sun.jersey.api.client.WebResource.Builder resourceBuilder = resource.getRequestBuilder();
            resourceBuilder = resourceBuilder.accept("application/json");
            com.sun.jersey.api.client.ClientResponse response;
            response = resourceBuilder.method("PUT", com.sun.jersey.api.client.ClientResponse.class);
            if (!com.sun.jersey.api.client.ClientResponse.class.isAssignableFrom(returnType)) {
                if (response.getStatus() >= 400) {
                    throw new TMRestServiceBase.WebApplicationExceptionMessage(Response.status(response.getStatusInfo()).build());
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
         */
        public DoDeleteJson(com.sun.jersey.api.client.Client client, URI baseUri) {
            _client = client;
            _uriBuilder = UriBuilder.fromUri(baseUri);
            _uriBuilder = _uriBuilder.path("do.delete.json");
            _templateAndMatrixParameterValues = new HashMap<String, Object>();
        }

        public SimpleDataDTO deleteAsSimpleDataDTO() {
            UriBuilder localUriBuilder = _uriBuilder.clone();
            com.sun.jersey.api.client.WebResource resource = _client.resource(localUriBuilder.buildFromMap(_templateAndMatrixParameterValues));
            com.sun.jersey.api.client.WebResource.Builder resourceBuilder = resource.getRequestBuilder();
            resourceBuilder = resourceBuilder.accept("application/json");
            com.sun.jersey.api.client.ClientResponse response;
            response = resourceBuilder.method("DELETE", com.sun.jersey.api.client.ClientResponse.class);
            if (response.getStatus() >= 400) {
                throw new TMRestServiceBase.WebApplicationExceptionMessage(Response.status(response.getStatusInfo()).build());
            }
            return response.getEntity(SimpleDataDTO.class);
        }

        public <T> T deleteAsJson(com.sun.jersey.api.client.GenericType<T> returnType) {
            UriBuilder localUriBuilder = _uriBuilder.clone();
            com.sun.jersey.api.client.WebResource resource = _client.resource(localUriBuilder.buildFromMap(_templateAndMatrixParameterValues));
            com.sun.jersey.api.client.WebResource.Builder resourceBuilder = resource.getRequestBuilder();
            resourceBuilder = resourceBuilder.accept("application/json");
            com.sun.jersey.api.client.ClientResponse response;
            response = resourceBuilder.method("DELETE", com.sun.jersey.api.client.ClientResponse.class);
            if (response.getStatus() >= 400) {
                throw new TMRestServiceBase.WebApplicationExceptionMessage(Response.status(response.getStatusInfo()).build());
            }
            return response.getEntity(returnType);
        }

        public <T> T deleteAsJson(Class<T> returnType) {
            UriBuilder localUriBuilder = _uriBuilder.clone();
            com.sun.jersey.api.client.WebResource resource = _client.resource(localUriBuilder.buildFromMap(_templateAndMatrixParameterValues));
            com.sun.jersey.api.client.WebResource.Builder resourceBuilder = resource.getRequestBuilder();
            resourceBuilder = resourceBuilder.accept("application/json");
            com.sun.jersey.api.client.ClientResponse response;
            response = resourceBuilder.method("DELETE", com.sun.jersey.api.client.ClientResponse.class);
            if (!com.sun.jersey.api.client.ClientResponse.class.isAssignableFrom(returnType)) {
                if (response.getStatus() >= 400) {
                    throw new TMRestServiceBase.WebApplicationExceptionMessage(Response.status(response.getStatusInfo()).build());
                }
            }
            if (!com.sun.jersey.api.client.ClientResponse.class.isAssignableFrom(returnType)) {
                return response.getEntity(returnType);
            } else {
                return returnType.cast(response);
            }
        }

        public SimpleDataDTO deleteAsSimpleDataDTO(Integer id) {
            UriBuilder localUriBuilder = _uriBuilder.clone();
            if (id == null) {
            }
            if (id != null) {
                localUriBuilder = localUriBuilder.replaceQueryParam("id", id);
            } else {
                localUriBuilder = localUriBuilder.replaceQueryParam("id", ((Object[]) null));
            }
            com.sun.jersey.api.client.WebResource resource = _client.resource(localUriBuilder.buildFromMap(_templateAndMatrixParameterValues));
            com.sun.jersey.api.client.WebResource.Builder resourceBuilder = resource.getRequestBuilder();
            resourceBuilder = resourceBuilder.accept("application/json");
            com.sun.jersey.api.client.ClientResponse response;
            response = resourceBuilder.method("DELETE", com.sun.jersey.api.client.ClientResponse.class);
            if (response.getStatus() >= 400) {
                throw new TMRestServiceBase.WebApplicationExceptionMessage(Response.status(response.getStatusInfo()).build());
            }
            return response.getEntity(SimpleDataDTO.class);
        }

        public <T> T deleteAsJson(Integer id, com.sun.jersey.api.client.GenericType<T> returnType) {
            UriBuilder localUriBuilder = _uriBuilder.clone();
            if (id == null) {
            }
            if (id != null) {
                localUriBuilder = localUriBuilder.replaceQueryParam("id", id);
            } else {
                localUriBuilder = localUriBuilder.replaceQueryParam("id", ((Object[]) null));
            }
            com.sun.jersey.api.client.WebResource resource = _client.resource(localUriBuilder.buildFromMap(_templateAndMatrixParameterValues));
            com.sun.jersey.api.client.WebResource.Builder resourceBuilder = resource.getRequestBuilder();
            resourceBuilder = resourceBuilder.accept("application/json");
            com.sun.jersey.api.client.ClientResponse response;
            response = resourceBuilder.method("DELETE", com.sun.jersey.api.client.ClientResponse.class);
            if (response.getStatus() >= 400) {
                throw new TMRestServiceBase.WebApplicationExceptionMessage(Response.status(response.getStatusInfo()).build());
            }
            return response.getEntity(returnType);
        }

        public <T> T deleteAsJson(Integer id, Class<T> returnType) {
            UriBuilder localUriBuilder = _uriBuilder.clone();
            if (id == null) {
            }
            if (id != null) {
                localUriBuilder = localUriBuilder.replaceQueryParam("id", id);
            } else {
                localUriBuilder = localUriBuilder.replaceQueryParam("id", ((Object[]) null));
            }
            com.sun.jersey.api.client.WebResource resource = _client.resource(localUriBuilder.buildFromMap(_templateAndMatrixParameterValues));
            com.sun.jersey.api.client.WebResource.Builder resourceBuilder = resource.getRequestBuilder();
            resourceBuilder = resourceBuilder.accept("application/json");
            com.sun.jersey.api.client.ClientResponse response;
            response = resourceBuilder.method("DELETE", com.sun.jersey.api.client.ClientResponse.class);
            if (!com.sun.jersey.api.client.ClientResponse.class.isAssignableFrom(returnType)) {
                if (response.getStatus() >= 400) {
                    throw new TMRestServiceBase.WebApplicationExceptionMessage(Response.status(response.getStatusInfo()).build());
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
            if (response.getStatus() >= 400) {
                throw new TMRestServiceBase.WebApplicationExceptionMessage(Response.status(response.getStatusInfo()).build());
            }
            return response.getEntity(GroupDTO.class);
        }

        public <T> T getAsJson(com.sun.jersey.api.client.GenericType<T> returnType) {
            UriBuilder localUriBuilder = _uriBuilder.clone();
            com.sun.jersey.api.client.WebResource resource = _client.resource(localUriBuilder.buildFromMap(_templateAndMatrixParameterValues));
            com.sun.jersey.api.client.WebResource.Builder resourceBuilder = resource.getRequestBuilder();
            resourceBuilder = resourceBuilder.accept("application/json");
            com.sun.jersey.api.client.ClientResponse response;
            response = resourceBuilder.method("GET", com.sun.jersey.api.client.ClientResponse.class);
            if (response.getStatus() >= 400) {
                throw new TMRestServiceBase.WebApplicationExceptionMessage(Response.status(response.getStatusInfo()).build());
            }
            return response.getEntity(returnType);
        }

        public <T> T getAsJson(Class<T> returnType) {
            UriBuilder localUriBuilder = _uriBuilder.clone();
            com.sun.jersey.api.client.WebResource resource = _client.resource(localUriBuilder.buildFromMap(_templateAndMatrixParameterValues));
            com.sun.jersey.api.client.WebResource.Builder resourceBuilder = resource.getRequestBuilder();
            resourceBuilder = resourceBuilder.accept("application/json");
            com.sun.jersey.api.client.ClientResponse response;
            response = resourceBuilder.method("GET", com.sun.jersey.api.client.ClientResponse.class);
            if (!com.sun.jersey.api.client.ClientResponse.class.isAssignableFrom(returnType)) {
                if (response.getStatus() >= 400) {
                    throw new TMRestServiceBase.WebApplicationExceptionMessage(Response.status(response.getStatusInfo()).build());
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
            if (id != null) {
                localUriBuilder = localUriBuilder.replaceQueryParam("id", id);
            } else {
                localUriBuilder = localUriBuilder.replaceQueryParam("id", ((Object[]) null));
            }
            com.sun.jersey.api.client.WebResource resource = _client.resource(localUriBuilder.buildFromMap(_templateAndMatrixParameterValues));
            com.sun.jersey.api.client.WebResource.Builder resourceBuilder = resource.getRequestBuilder();
            resourceBuilder = resourceBuilder.accept("application/json");
            com.sun.jersey.api.client.ClientResponse response;
            response = resourceBuilder.method("GET", com.sun.jersey.api.client.ClientResponse.class);
            if (response.getStatus() >= 400) {
                throw new TMRestServiceBase.WebApplicationExceptionMessage(Response.status(response.getStatusInfo()).build());
            }
            return response.getEntity(GroupDTO.class);
        }

        public <T> T getAsJson(Integer id, com.sun.jersey.api.client.GenericType<T> returnType) {
            UriBuilder localUriBuilder = _uriBuilder.clone();
            if (id == null) {
            }
            if (id != null) {
                localUriBuilder = localUriBuilder.replaceQueryParam("id", id);
            } else {
                localUriBuilder = localUriBuilder.replaceQueryParam("id", ((Object[]) null));
            }
            com.sun.jersey.api.client.WebResource resource = _client.resource(localUriBuilder.buildFromMap(_templateAndMatrixParameterValues));
            com.sun.jersey.api.client.WebResource.Builder resourceBuilder = resource.getRequestBuilder();
            resourceBuilder = resourceBuilder.accept("application/json");
            com.sun.jersey.api.client.ClientResponse response;
            response = resourceBuilder.method("GET", com.sun.jersey.api.client.ClientResponse.class);
            if (response.getStatus() >= 400) {
                throw new TMRestServiceBase.WebApplicationExceptionMessage(Response.status(response.getStatusInfo()).build());
            }
            return response.getEntity(returnType);
        }

        public <T> T getAsJson(Integer id, Class<T> returnType) {
            UriBuilder localUriBuilder = _uriBuilder.clone();
            if (id == null) {
            }
            if (id != null) {
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
                if (response.getStatus() >= 400) {
                    throw new TMRestServiceBase.WebApplicationExceptionMessage(Response.status(response.getStatusInfo()).build());
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
            if (response.getStatus() >= 400) {
                throw new TMRestServiceBase.WebApplicationExceptionMessage(Response.status(response.getStatusInfo()).build());
            }
            return response.getEntity(ListDTO.class);
        }

        public <T> T getAsJson(com.sun.jersey.api.client.GenericType<T> returnType) {
            UriBuilder localUriBuilder = _uriBuilder.clone();
            com.sun.jersey.api.client.WebResource resource = _client.resource(localUriBuilder.buildFromMap(_templateAndMatrixParameterValues));
            com.sun.jersey.api.client.WebResource.Builder resourceBuilder = resource.getRequestBuilder();
            resourceBuilder = resourceBuilder.accept("application/json");
            com.sun.jersey.api.client.ClientResponse response;
            response = resourceBuilder.method("GET", com.sun.jersey.api.client.ClientResponse.class);
            if (response.getStatus() >= 400) {
                throw new TMRestServiceBase.WebApplicationExceptionMessage(Response.status(response.getStatusInfo()).build());
            }
            return response.getEntity(returnType);
        }

        public <T> T getAsJson(Class<T> returnType) {
            UriBuilder localUriBuilder = _uriBuilder.clone();
            com.sun.jersey.api.client.WebResource resource = _client.resource(localUriBuilder.buildFromMap(_templateAndMatrixParameterValues));
            com.sun.jersey.api.client.WebResource.Builder resourceBuilder = resource.getRequestBuilder();
            resourceBuilder = resourceBuilder.accept("application/json");
            com.sun.jersey.api.client.ClientResponse response;
            response = resourceBuilder.method("GET", com.sun.jersey.api.client.ClientResponse.class);
            if (!com.sun.jersey.api.client.ClientResponse.class.isAssignableFrom(returnType)) {
                if (response.getStatus() >= 400) {
                    throw new TMRestServiceBase.WebApplicationExceptionMessage(Response.status(response.getStatusInfo()).build());
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
            if (all != null) {
                localUriBuilder = localUriBuilder.replaceQueryParam("all", all);
            } else {
                localUriBuilder = localUriBuilder.replaceQueryParam("all", ((Object[]) null));
            }
            if (page == null) {
            }
            if (page != null) {
                localUriBuilder = localUriBuilder.replaceQueryParam("page", page);
            } else {
                localUriBuilder = localUriBuilder.replaceQueryParam("page", ((Object[]) null));
            }
            if (perpage == null) {
            }
            if (perpage != null) {
                localUriBuilder = localUriBuilder.replaceQueryParam("perpage", perpage);
            } else {
                localUriBuilder = localUriBuilder.replaceQueryParam("perpage", ((Object[]) null));
            }
            com.sun.jersey.api.client.WebResource resource = _client.resource(localUriBuilder.buildFromMap(_templateAndMatrixParameterValues));
            com.sun.jersey.api.client.WebResource.Builder resourceBuilder = resource.getRequestBuilder();
            resourceBuilder = resourceBuilder.accept("application/json");
            com.sun.jersey.api.client.ClientResponse response;
            response = resourceBuilder.method("GET", com.sun.jersey.api.client.ClientResponse.class);
            if (response.getStatus() >= 400) {
                throw new TMRestServiceBase.WebApplicationExceptionMessage(Response.status(response.getStatusInfo()).build());
            }
            return response.getEntity(ListDTO.class);
        }

        public <T> T getAsJson(Boolean all, Integer page, Integer perpage, com.sun.jersey.api.client.GenericType<T> returnType) {
            UriBuilder localUriBuilder = _uriBuilder.clone();
            if (all == null) {
            }
            if (all != null) {
                localUriBuilder = localUriBuilder.replaceQueryParam("all", all);
            } else {
                localUriBuilder = localUriBuilder.replaceQueryParam("all", ((Object[]) null));
            }
            if (page == null) {
            }
            if (page != null) {
                localUriBuilder = localUriBuilder.replaceQueryParam("page", page);
            } else {
                localUriBuilder = localUriBuilder.replaceQueryParam("page", ((Object[]) null));
            }
            if (perpage == null) {
            }
            if (perpage != null) {
                localUriBuilder = localUriBuilder.replaceQueryParam("perpage", perpage);
            } else {
                localUriBuilder = localUriBuilder.replaceQueryParam("perpage", ((Object[]) null));
            }
            com.sun.jersey.api.client.WebResource resource = _client.resource(localUriBuilder.buildFromMap(_templateAndMatrixParameterValues));
            com.sun.jersey.api.client.WebResource.Builder resourceBuilder = resource.getRequestBuilder();
            resourceBuilder = resourceBuilder.accept("application/json");
            com.sun.jersey.api.client.ClientResponse response;
            response = resourceBuilder.method("GET", com.sun.jersey.api.client.ClientResponse.class);
            if (response.getStatus() >= 400) {
                throw new TMRestServiceBase.WebApplicationExceptionMessage(Response.status(response.getStatusInfo()).build());
            }
            return response.getEntity(returnType);
        }

        public <T> T getAsJson(Boolean all, Integer page, Integer perpage, Class<T> returnType) {
            UriBuilder localUriBuilder = _uriBuilder.clone();
            if (all == null) {
            }
            if (all != null) {
                localUriBuilder = localUriBuilder.replaceQueryParam("all", all);
            } else {
                localUriBuilder = localUriBuilder.replaceQueryParam("all", ((Object[]) null));
            }
            if (page == null) {
            }
            if (page != null) {
                localUriBuilder = localUriBuilder.replaceQueryParam("page", page);
            } else {
                localUriBuilder = localUriBuilder.replaceQueryParam("page", ((Object[]) null));
            }
            if (perpage == null) {
            }
            if (perpage != null) {
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
                if (response.getStatus() >= 400) {
                    throw new TMRestServiceBase.WebApplicationExceptionMessage(Response.status(response.getStatusInfo()).build());
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
            if (response.getStatus() >= 400) {
                throw new TMRestServiceBase.WebApplicationExceptionMessage(Response.status(response.getStatusInfo()).build());
            }
            return response.getEntity(SimpleDataDTO.class);
        }

        public <T> T postAsJson(com.sun.jersey.api.client.GenericType<T> returnType) {
            UriBuilder localUriBuilder = _uriBuilder.clone();
            com.sun.jersey.api.client.WebResource resource = _client.resource(localUriBuilder.buildFromMap(_templateAndMatrixParameterValues));
            com.sun.jersey.api.client.WebResource.Builder resourceBuilder = resource.getRequestBuilder();
            resourceBuilder = resourceBuilder.accept("application/json");
            com.sun.jersey.api.client.ClientResponse response;
            response = resourceBuilder.method("POST", com.sun.jersey.api.client.ClientResponse.class);
            if (response.getStatus() >= 400) {
                throw new TMRestServiceBase.WebApplicationExceptionMessage(Response.status(response.getStatusInfo()).build());
            }
            return response.getEntity(returnType);
        }

        public <T> T postAsJson(Class<T> returnType) {
            UriBuilder localUriBuilder = _uriBuilder.clone();
            com.sun.jersey.api.client.WebResource resource = _client.resource(localUriBuilder.buildFromMap(_templateAndMatrixParameterValues));
            com.sun.jersey.api.client.WebResource.Builder resourceBuilder = resource.getRequestBuilder();
            resourceBuilder = resourceBuilder.accept("application/json");
            com.sun.jersey.api.client.ClientResponse response;
            response = resourceBuilder.method("POST", com.sun.jersey.api.client.ClientResponse.class);
            if (!com.sun.jersey.api.client.ClientResponse.class.isAssignableFrom(returnType)) {
                if (response.getStatus() >= 400) {
                    throw new TMRestServiceBase.WebApplicationExceptionMessage(Response.status(response.getStatusInfo()).build());
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
