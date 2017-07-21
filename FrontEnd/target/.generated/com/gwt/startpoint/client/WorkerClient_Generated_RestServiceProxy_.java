package com.gwt.startpoint.client;

public class WorkerClient_Generated_RestServiceProxy_ implements com.gwt.startpoint.client.WorkerClient, org.fusesource.restygwt.client.RestServiceProxy {
  private org.fusesource.restygwt.client.Resource resource = null;
  
  public void setResource(org.fusesource.restygwt.client.Resource resource) {
    this.resource = resource;
  }
  public org.fusesource.restygwt.client.Resource getResource() {
    if (this.resource == null) {
      String serviceRoot = org.fusesource.restygwt.client.Defaults.getServiceRoot();
      this.resource = new org.fusesource.restygwt.client.Resource(serviceRoot);
    }
    return this.resource;
  }
  private org.fusesource.restygwt.client.Dispatcher dispatcher = null;
  
  public void setDispatcher(org.fusesource.restygwt.client.Dispatcher dispatcher) {
    this.dispatcher = dispatcher;
  }
  
  public org.fusesource.restygwt.client.Dispatcher getDispatcher() {
    return this.dispatcher;
  }
  public void delete(java.math.BigInteger id, org.fusesource.restygwt.client.MethodCallback<java.lang.String> callback) {
    final java.math.BigInteger final_id = id;
    final org.fusesource.restygwt.client.Method __method =
    getResource()
    .resolve("/device/delete")
    .delete();
    __method.setDispatcher(this.dispatcher);
    __method.header(org.fusesource.restygwt.client.Resource.HEADER_ACCEPT, org.fusesource.restygwt.client.Resource.CONTENT_TYPE_JSON);
    __method.json(org.fusesource.restygwt.client.AbstractJsonEncoderDecoder.BIG_INTEGER.encode(id));
    try {
      __method.send(new org.fusesource.restygwt.client.AbstractRequestCallback<java.lang.String>(__method, callback) {
        protected java.lang.String parseResult() throws Exception {
          try {
            return org.fusesource.restygwt.client.AbstractJsonEncoderDecoder.STRING.decode(com.google.gwt.json.client.JSONParser.parse(__method.getResponse().getText()));
          } catch (Throwable __e) {
            throw new org.fusesource.restygwt.client.ResponseFormatException("Response was NOT a valid JSON document", __e);
          }
        }
      });
    } catch (com.google.gwt.http.client.RequestException __e) {
      callback.onFailure(__method,__e);
    }
  }
  public void get(org.fusesource.restygwt.client.MethodCallback<com.model.shared.TestDto> callback) {
    final org.fusesource.restygwt.client.Method __method =
    getResource()
    .resolve("/test")
    .get();
    __method.setDispatcher(this.dispatcher);
    __method.header(org.fusesource.restygwt.client.Resource.HEADER_ACCEPT, org.fusesource.restygwt.client.Resource.CONTENT_TYPE_JSON);
    try {
      __method.send(new org.fusesource.restygwt.client.AbstractRequestCallback<com.model.shared.TestDto>(__method, callback) {
        protected com.model.shared.TestDto parseResult() throws Exception {
          try {
            return com.model.shared.TestDto_Generated_JsonEncoderDecoder_.INSTANCE.decode(com.google.gwt.json.client.JSONParser.parse(__method.getResponse().getText()));
          } catch (Throwable __e) {
            throw new org.fusesource.restygwt.client.ResponseFormatException("Response was NOT a valid JSON document", __e);
          }
        }
      });
    } catch (com.google.gwt.http.client.RequestException __e) {
      callback.onFailure(__method,__e);
    }
  }
  public void getAll(org.fusesource.restygwt.client.MethodCallback<java.util.List<com.model.shared.Device>> callback) {
    final org.fusesource.restygwt.client.Method __method =
    getResource()
    .resolve("/device/get")
    .get();
    __method.setDispatcher(this.dispatcher);
    __method.header(org.fusesource.restygwt.client.Resource.HEADER_ACCEPT, org.fusesource.restygwt.client.Resource.CONTENT_TYPE_JSON);
    try {
      __method.send(new org.fusesource.restygwt.client.AbstractRequestCallback<java.util.List<com.model.shared.Device>>(__method, callback) {
        protected java.util.List<com.model.shared.Device> parseResult() throws Exception {
          try {
            return org.fusesource.restygwt.client.AbstractJsonEncoderDecoder.toList(com.google.gwt.json.client.JSONParser.parse(__method.getResponse().getText()), com.model.shared.Device_Generated_JsonEncoderDecoder_.INSTANCE);
          } catch (Throwable __e) {
            throw new org.fusesource.restygwt.client.ResponseFormatException("Response was NOT a valid JSON document", __e);
          }
        }
      });
    } catch (com.google.gwt.http.client.RequestException __e) {
      callback.onFailure(__method,__e);
    }
  }
  public void getById(java.math.BigInteger id, org.fusesource.restygwt.client.MethodCallback<com.model.shared.Device> callback) {
    final java.math.BigInteger final_id = id;
    final org.fusesource.restygwt.client.Method __method =
    getResource()
    .resolve("/device/get/"+((id != null ? id.toString() : null)== null? null : com.google.gwt.http.client.URL.encodePathSegment((id != null ? id.toString() : null)))+"")
    .get();
    __method.setDispatcher(this.dispatcher);
    __method.header(org.fusesource.restygwt.client.Resource.HEADER_ACCEPT, org.fusesource.restygwt.client.Resource.CONTENT_TYPE_JSON);
    try {
      __method.send(new org.fusesource.restygwt.client.AbstractRequestCallback<com.model.shared.Device>(__method, callback) {
        protected com.model.shared.Device parseResult() throws Exception {
          try {
            return com.model.shared.Device_Generated_JsonEncoderDecoder_.INSTANCE.decode(com.google.gwt.json.client.JSONParser.parse(__method.getResponse().getText()));
          } catch (Throwable __e) {
            throw new org.fusesource.restygwt.client.ResponseFormatException("Response was NOT a valid JSON document", __e);
          }
        }
      });
    } catch (com.google.gwt.http.client.RequestException __e) {
      callback.onFailure(__method,__e);
    }
  }
  public void post(com.model.shared.Device device, org.fusesource.restygwt.client.MethodCallback<java.lang.String> callback) {
    final com.model.shared.Device final_device = device;
    final org.fusesource.restygwt.client.Method __method =
    getResource()
    .resolve("/device/create")
    .post();
    __method.setDispatcher(this.dispatcher);
    __method.header(org.fusesource.restygwt.client.Resource.HEADER_ACCEPT, org.fusesource.restygwt.client.Resource.CONTENT_TYPE_JSON);
    __method.json(com.model.shared.Device_Generated_JsonEncoderDecoder_.INSTANCE.encode(device));
    try {
      __method.send(new org.fusesource.restygwt.client.AbstractRequestCallback<java.lang.String>(__method, callback) {
        protected java.lang.String parseResult() throws Exception {
          try {
            return org.fusesource.restygwt.client.AbstractJsonEncoderDecoder.STRING.decode(com.google.gwt.json.client.JSONParser.parse(__method.getResponse().getText()));
          } catch (Throwable __e) {
            throw new org.fusesource.restygwt.client.ResponseFormatException("Response was NOT a valid JSON document", __e);
          }
        }
      });
    } catch (com.google.gwt.http.client.RequestException __e) {
      callback.onFailure(__method,__e);
    }
  }
  public void update(com.model.shared.Device device, org.fusesource.restygwt.client.MethodCallback<java.lang.String> callback) {
    final com.model.shared.Device final_device = device;
    final org.fusesource.restygwt.client.Method __method =
    getResource()
    .resolve("/device/update")
    .put();
    __method.setDispatcher(this.dispatcher);
    __method.header(org.fusesource.restygwt.client.Resource.HEADER_ACCEPT, org.fusesource.restygwt.client.Resource.CONTENT_TYPE_JSON);
    __method.json(com.model.shared.Device_Generated_JsonEncoderDecoder_.INSTANCE.encode(device));
    try {
      __method.send(new org.fusesource.restygwt.client.AbstractRequestCallback<java.lang.String>(__method, callback) {
        protected java.lang.String parseResult() throws Exception {
          try {
            return org.fusesource.restygwt.client.AbstractJsonEncoderDecoder.STRING.decode(com.google.gwt.json.client.JSONParser.parse(__method.getResponse().getText()));
          } catch (Throwable __e) {
            throw new org.fusesource.restygwt.client.ResponseFormatException("Response was NOT a valid JSON document", __e);
          }
        }
      });
    } catch (com.google.gwt.http.client.RequestException __e) {
      callback.onFailure(__method,__e);
    }
  }
}
