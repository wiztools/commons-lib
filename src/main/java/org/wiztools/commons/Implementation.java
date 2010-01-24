/*
 * Copyright WizTools.org
 * Licensed under the Apache License, Version 2.0:
 * http://www.apache.org/licenses/LICENSE-2.0
 */
package org.wiztools.commons;

import java.io.IOException;
import java.net.URL;
import java.net.URLConnection;
import java.util.Enumeration;
import java.util.Hashtable;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * This is a service locator framework. The framework reads from the property
 * file `wiztools-service-locator.properties'.
 * @author subwiz
 */
public class Implementation {

    private static final String PROP_NAME = "wiztools-service-locator.properties";

    private static final Logger LOG = Logger.getLogger(Implementation.class.getName());
        /**
     * This is the variable holding the object cache
     */
    private static final Hashtable<String, Object> ht = new Hashtable<String, Object>();

    private static Properties props = new Properties();
    static{
        try{
            Enumeration<URL> e = Implementation.class.getClassLoader().getResources(PROP_NAME);
            while(e.hasMoreElements()){
                URL url = e.nextElement();
                URLConnection con = url.openConnection();
                con.connect();
                props.load(con.getInputStream());
            }
        }
        catch(IOException ex){
            LOG.log(Level.SEVERE, null, ex);
        }
    }

    public static <T> T of(Class<T> c) throws ImplementationLoadException{
        try{
            final String className = c.getName();
            final String implClassStr = props.getProperty(className);
            // Default class creation behavior:
            boolean isSingleton = false;
            final String isSingletonStr = props.getProperty(className + ".singleton");
            if(isSingletonStr != null){
                isSingleton = Boolean.parseBoolean(isSingletonStr);
            }
            else{
                LOG.finest("Singleton property not set for class: " + className);
            }
            if(!isSingleton){
                return (T) Class.forName(implClassStr).newInstance();
            }
            T o = (T)ht.get(c.getName());
            if(o == null){
                o = (T) Class.forName(implClassStr).newInstance();
                ht.put(c.getName(), o);
                LOG.finest("Class created, and put into cache: " + o.getClass().getName());
            }
            else{
                LOG.finest("Object already available in cache: " + className);
            }
            return o;
        }
        catch(ClassNotFoundException ex){
            throw new ImplementationLoadException(ex);
        }
        catch(InstantiationException ex){
            throw new ImplementationLoadException(ex);
        }
        catch(IllegalAccessException ex){
            throw new ImplementationLoadException(ex);
        }
    }
}
