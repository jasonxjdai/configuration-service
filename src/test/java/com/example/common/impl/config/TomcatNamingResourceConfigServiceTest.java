package com.example.common.impl.config;

import static org.junit.Assert.*;

import org.junit.*;

import javax.naming.*;

import org.springframework.mock.jndi.SimpleNamingContextBuilder;


public class TomcatNamingResourceConfigServiceTest extends AbstractConfigServiceTest {
  /**
   * Mock JNDI with Sprint Test Framework.
   * @throws NamingException
   */
  @BeforeClass
  public static void mockJndi() throws NamingException {
    SimpleNamingContextBuilder builder = SimpleNamingContextBuilder.emptyActivatedContextBuilder();
    builder.bind("java:comp/env/property", "value");
  }
  
  @Before
  public void setUp() throws Exception {
    configService = new TomcatNamingResourceConfigService();
    emptyConfigService = new TomcatNamingResourceConfigService();
  }
  
  @Test
  public void foundPropertyName() throws NamingException {
    assertEquals("value", configService.getProperty("property"));
  }
}
