package com.example.common.impl.config;

import java.util.*;
import org.apache.commons.logging.*;
import com.example.common.service.ConfigService;

/**
 * Abstract configuration class.
 * <p>
 * Provides basic functionality but does not store any data.
 */
public abstract class AbstractConfigService implements ConfigService {
  /** Stores the properties. */
  protected Properties properties = new Properties();

  /** Stores the logger. */
  protected static Log logger = LogFactory.getLog(AbstractConfigService.class.getName());

  @Override
  public String getProperty(String name) {
    if (null == name) {
      return null;
    }
    else {
      return (String) properties.get(name);
    }
  }
}
