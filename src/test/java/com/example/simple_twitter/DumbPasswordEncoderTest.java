package com.example.simple_twitter;

import org.junit.Test;
import static org.hamcrest.Matchers.containsString;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;

public class DumbPasswordEncoderTest {

  @Test
  public void encode() {
    DumbPasswordEncoder encoder = new DumbPasswordEncoder();
    assertEquals("secret: 'mypswd'", encoder.encode("mypswd"));
    assertThat(encoder.encode("mypswd"), containsString("mypswd"));
  }
}
