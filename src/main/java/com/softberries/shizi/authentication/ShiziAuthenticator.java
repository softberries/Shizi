package com.softberries.shizi.authentication;

import javax.inject.Inject;

import org.jboss.seam.security.Authenticator;
import org.jboss.seam.security.BaseAuthenticator;
import org.jboss.seam.security.Credentials;
import org.picketlink.idm.impl.api.PasswordCredential;
import org.picketlink.idm.impl.api.model.SimpleUser;

/**
 * Simple authenticator for Shizi app
 * @author Krzysztof Grajek
 *
 */
public class ShiziAuthenticator extends BaseAuthenticator implements Authenticator
{
   @Inject Credentials credentials;
   
   @Override
   public void authenticate()
   {
      if ("demo".equals(credentials.getUsername()) && 
            credentials.getCredential() instanceof PasswordCredential &&
            "demo".equals(((PasswordCredential) credentials.getCredential()).getValue()))
      {
         setStatus(AuthenticationStatus.SUCCESS);
         setUser(new SimpleUser("demo"));
      }
      else
      {
         setStatus(AuthenticationStatus.FAILURE);
      }
   }

}
