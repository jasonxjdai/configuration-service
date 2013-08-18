package com.example.common.impl.config;

/**
 * A implementation of Configuration Service providing access to properties
 * though <a href="https://community.jboss.org/wiki/PropertiesService">Jboss
 * Properties Service</a>.
 */
public class JbossPropertyServiceConfigService extends AbstractConfigService {

  @Override
  public String getProperty(String name) {
    if (null == name) {
      return null;
    }
    else {
      return System.getProperty(name);
    }
  }
}
