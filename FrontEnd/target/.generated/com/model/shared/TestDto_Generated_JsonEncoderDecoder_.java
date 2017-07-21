package com.model.shared;

public class TestDto_Generated_JsonEncoderDecoder_ extends org.fusesource.restygwt.client.AbstractJsonEncoderDecoder<com.model.shared.TestDto> {
  
  public static final TestDto_Generated_JsonEncoderDecoder_ INSTANCE = new TestDto_Generated_JsonEncoderDecoder_();
  
  public com.google.gwt.json.client.JSONValue encode(com.model.shared.TestDto value) {
    if( value==null ) {
      return getNullType();
    }
    com.google.gwt.json.client.JSONObject rc = new com.google.gwt.json.client.JSONObject();
    com.model.shared.TestDto parseValue = (com.model.shared.TestDto)value;
    isNotNullValuePut(org.fusesource.restygwt.client.AbstractJsonEncoderDecoder.STRING.encode(parseValue.getMessage()), rc, "message");
    return rc;
  }
  
  public com.model.shared.TestDto decode(com.google.gwt.json.client.JSONValue value) {
    if( value == null || value.isNull()!=null ) {
      return null;
    }
    com.google.gwt.json.client.JSONObject object = toObject(value);
    com.model.shared.TestDto rc = new com.model.shared.TestDto();
    rc.setMessage(getValueToSet(org.fusesource.restygwt.client.AbstractJsonEncoderDecoder.STRING.decode(object.get("message")), null));
    return rc;
  }
  
}
