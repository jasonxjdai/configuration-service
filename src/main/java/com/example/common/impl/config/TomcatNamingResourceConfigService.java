package com.example.common.impl.config;

import javax.naming.*;

/**
 * A implementation of Configuration Service providing access to properties though 
 * <a href="http://tomcat.apache.org/tomcat-5.5-doc/config/globalresources.html">Tomcat Global Naming Resources</a>.
 */
public class TomcatNamingResourceConfigService extends AbstractConfigService {

  /**
   * Creates a TomcatNamingResourceConfigService from Tomcat Global Naming Resources.
   */
  public TomcatNamingResourceConfigService() {
    try {
      Context initCtx = new InitialContext();
      NamingEnumeration<Binding> bindings = initCtx.listBindings("java:comp/env");

      while (bindings.hasMore()) {
        Binding bd = bindings.next();
        properties.setProperty(bd.getName(), bd.getObject().toString());
      }

      initCtx.close();
    }
    catch (NamingException e) {
      logger.debug("javax.naming.NameNotFoundException: 'java:comp/env' not bound");
    }
  }  
}
