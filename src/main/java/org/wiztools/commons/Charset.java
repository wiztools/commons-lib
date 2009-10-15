package org.wiztools.commons;

/**
 *
 * @author subwiz
 */
public interface Charset{
  public java.nio.charset.Charset US_ASCII = java.nio.charset.Charset.forName("US-ASCII");
  public java.nio.charset.Charset ISO_8859_1 = java.nio.charset.Charset.forName("ISO-8859-1");
  public java.nio.charset.Charset UTF_8 = java.nio.charset.Charset.forName("UTF-8");
  public java.nio.charset.Charset UTF_16BE = java.nio.charset.Charset.forName("UTF-16BE");
  public java.nio.charset.Charset UTF_16LE = java.nio.charset.Charset.forName("UTF-16LE");
  public java.nio.charset.Charset UTF_16 = java.nio.charset.Charset.forName("UTF-16");
}
