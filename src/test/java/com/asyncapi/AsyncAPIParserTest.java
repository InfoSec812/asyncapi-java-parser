package com.asyncapi;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.yaml.YAMLFactory;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.io.InputStream;

import static org.junit.jupiter.api.Assertions.*;

public class AsyncAPIParserTest {

  @Test
  public void canReadAndParseYamlContract() throws IOException {
    var mapper = new ObjectMapper(new YAMLFactory());
    var underTest = new AsyncAPIParser(mapper);

    InputStream testYaml = ClassLoader.getSystemResourceAsStream("test_1.yaml");

    assertNotNull(testYaml);

    var result = underTest.parse(testYaml);

    assertNotNull(result);
    assertEquals("Title of my app", result.getInfo().getTitle());
  }

  @Test
  public void canReadAndParseJsonContract() throws IOException {
    var mapper = new ObjectMapper(new YAMLFactory());
    var underTest = new AsyncAPIParser(mapper);

    InputStream testJson = ClassLoader.getSystemResourceAsStream("test_1.json");

    assertNotNull(testJson);

    var result = underTest.parse(testJson);

    assertNotNull(result);
    assertEquals("Title of my app", result.getInfo().getTitle());
  }
}
