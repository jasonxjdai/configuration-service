package com.example.common.impl.config;

import static org.junit.Assert.*;
import org.junit.*;
import com.example.common.service.ConfigService;

public abstract class AbstractConfigServiceTest {
  /**
   * Generic Configuration Service
   */
  protected ConfigService configService;
  
  /**
   * Configuration Service with no properties 
   */
  protected ConfigService emptyConfigService;

  @Test
  public void nameIsNull() {
    assertNull(configService.getProperty(null));
  }

  @Test
  public void nonExistProperty() {
    assertNull(configService.getProperty("NonExistProperty"));
  }

  @Test
  public void nameIsNullInEmptyConfig() {
    assertNull(emptyConfigService.getProperty(null));
  }

  @Test
  public void nonExistPropertyInEmptyConfig() {
    assertNull(emptyConfigService.getProperty("NonExistProperty"));
  }
}
