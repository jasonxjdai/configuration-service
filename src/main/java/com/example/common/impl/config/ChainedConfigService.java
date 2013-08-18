package com.example.common.impl.config;

import com.example.common.service.ConfigService;

/**
 * ChainedConfigService allows you to add multiple Configuration Service to an aggregated configuration. 
 * <p>
 * If you add Configuration1, and then Configuration2, any properties shared will mean that the value defined by Configuration1 will be returned. 
 * If Configuration1 doesn't have the property, then Configuration2 will be checked. 
 * You can add multiple different types or the same type of configuration service.
 */
public class ChainedConfigService extends AbstractConfigService {

  /** Stores the ordered list of configuration service.*/
  private ConfigService[] configServices;

  /**
   * Creates a ChainedConfigService object with a list of configuration services
   * with same type or different types in order.
   * 
   * @param services  the ordered list of configuration services to store
   */
  public ChainedConfigService(ConfigService... services) {
    if (null == services)
      throw new IllegalArgumentException();
    this.configServices = services;
  }

  @Override
  public String getProperty(String name) {
    for (int i = 0; i < configServices.length; i++) {
      String value = configServices[i].getProperty(name);
      if (null != value) {
        return value;
      }
    }
    return null;
  }

}
