package com.example.common.impl.config;

import static org.junit.Assert.*;
import org.junit.*;
import static org.mockito.Mockito.*;

public class ChainedConfigServiceTest extends AbstractConfigServiceTest {

  @Before
  public void setUp() throws Exception {
    
    // mock configuration service 1
    TomcatNamingResourceConfigService config1 = mock(TomcatNamingResourceConfigService.class);
    when(config1.getProperty("property1")).thenReturn("Property property1 From config1");
    
    // mock configuration service 2
    JbossPropertyServiceConfigService config2= mock(JbossPropertyServiceConfigService.class);
    when(config2.getProperty("property1")).thenReturn("Property property1 From config2");
    when(config2.getProperty("property2")).thenReturn("Property property2 From config2");

    // create Chained Configuration Service with config1 and config2 in order
    configService = new ChainedConfigService(config1, config2);
    
    // create Chained Configuration Service with no properties
    emptyConfigService = new ChainedConfigService();
  }

  @Test
  public void samePropertyNameReturnFromFromSecond() {
    assertEquals("Property property2 From config2", configService.getProperty("property2"));
  }
}
