package com.example.common.service;

/**
 * A interface of Configuration Service.
 * <p>
 * The purpose of this interface is to supply the same interface of getting properties from different sources, like
 * properties file, <a href="https://community.jboss.org/wiki/PropertiesService">Jboss Properties Service</a>, 
 * <a href="http://tomcat.apache.org/tomcat-5.5-doc/config/globalresources.html">Tomcat Global Naming Resources</a>, etc.    
 * <p>
 * There is a generic getProperty() method, which returns the value of the queried property in String type.
 */
public interface ConfigService {

  /**
   * Gets a property from the configuration.
   * 
   * @param name  the property name to retrieve, null returns null
   * @return the value to which this configuration maps the specified name,
   *         null if the configuration contains no mapping for this name.
   */
  public String getProperty(String name);
}
