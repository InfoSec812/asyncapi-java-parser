package com.asyncapi;

import com.asyncapi.schema.AsyncAPI300Schema;
import com.asyncapi.schema.Info;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.yaml.YAMLFactory;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;

public class AsyncAPIParser {

  private final ObjectMapper mapper;

  public AsyncAPIParser(ObjectMapper mapper) {
    super();
    this.mapper = mapper;
    mapper.findAndRegisterModules();
  }

  public AsyncAPI300Schema parse(String specification) throws JsonProcessingException {
    return mapper.readValue(specification, AsyncAPI300Schema.class);
  }

  public AsyncAPI300Schema parse(File specification) throws IOException {
    return mapper.readValue(specification, AsyncAPI300Schema.class);
  }

  public AsyncAPI300Schema parse(InputStream specification) throws IOException {
    return mapper.readValue(specification, AsyncAPI300Schema.class);
  }

}
