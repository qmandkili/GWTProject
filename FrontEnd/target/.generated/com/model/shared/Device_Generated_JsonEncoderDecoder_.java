package com.model.shared;

public class Device_Generated_JsonEncoderDecoder_ extends org.fusesource.restygwt.client.AbstractJsonEncoderDecoder<com.model.shared.Device> {
  
  public static final Device_Generated_JsonEncoderDecoder_ INSTANCE = new Device_Generated_JsonEncoderDecoder_();
  
  public com.google.gwt.json.client.JSONValue encode(com.model.shared.Device value) {
    if( value==null ) {
      return getNullType();
    }
    com.google.gwt.json.client.JSONObject rc = new com.google.gwt.json.client.JSONObject();
    com.model.shared.Device parseValue = (com.model.shared.Device)value;
    isNotNullValuePut(org.fusesource.restygwt.client.AbstractJsonEncoderDecoder.BIG_INTEGER.encode(parseValue.getId()), rc, "id");
    isNotNullValuePut(org.fusesource.restygwt.client.AbstractJsonEncoderDecoder.STRING.encode(parseValue.getName()), rc, "name");
    isNotNullValuePut(org.fusesource.restygwt.client.AbstractJsonEncoderDecoder.STRING.encode(parseValue.getDescription()), rc, "description");
    return rc;
  }
  
  public com.model.shared.Device decode(com.google.gwt.json.client.JSONValue value) {
    if( value == null || value.isNull()!=null ) {
      return null;
    }
    com.google.gwt.json.client.JSONObject object = toObject(value);
    com.model.shared.Device rc = new com.model.shared.Device();
    rc.setId(getValueToSet(org.fusesource.restygwt.client.AbstractJsonEncoderDecoder.BIG_INTEGER.decode(object.get("id")), null));
    rc.setName(getValueToSet(org.fusesource.restygwt.client.AbstractJsonEncoderDecoder.STRING.decode(object.get("name")), null));
    rc.setDescription(getValueToSet(org.fusesource.restygwt.client.AbstractJsonEncoderDecoder.STRING.decode(object.get("description")), null));
    return rc;
  }
  
}
