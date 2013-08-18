package com.example.common.impl.config;

import static org.junit.Assert.*;
import static org.mockito.Mockito.when;
import static org.powermock.api.mockito.PowerMockito.*;

import org.junit.*;
import org.junit.runner.RunWith;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

@RunWith(PowerMockRunner.class)
@PrepareForTest( { JbossPropertyServiceConfigService.class })
public class JbossPropertyServiceConfigServiceTest extends AbstractConfigServiceTest {

  @Before
  public void setUp() throws Exception {
    configService = new JbossPropertyServiceConfigService();
    emptyConfigService = new JbossPropertyServiceConfigService();
  }

  @Test
  public void foundPropertyName() {
    
    // mock System class with PowerMock
    mockStatic(System.class);
    when(System.getProperty("property")).thenReturn("value");

    assertEquals("value", configService.getProperty("property"));
  }

}
