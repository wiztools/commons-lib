package org.wiztools.commons;

import java.nio.charset.Charset;

/**
 * Defines common charsets supported in all Java platforms.
 * @author subwiz
 */
public interface CommonCharset{
  public Charset US_ASCII =  Charset.forName("US-ASCII");
  public Charset ISO_8859_1 = Charset.forName("ISO-8859-1");
  public Charset UTF_8 = Charset.forName("UTF-8");
  public Charset UTF_16BE = Charset.forName("UTF-16BE");
  public Charset UTF_16LE = Charset.forName("UTF-16LE");
  public Charset UTF_16 = Charset.forName("UTF-16");
}
