/*
 * Copyright WizTools.org
 * Licensed under the Apache License, Version 2.0:
 * http://www.apache.org/licenses/LICENSE-2.0
 */
package org.wiztools.commons;

/**
 * Digest Algorithm string used by Java Security.
 * @author subwiz
 */
public interface DigestAlgorithm {
    public String MD2 = "MD2";
    public String MD5 = "MD5";

    public String SHA_1 = "SHA-1";
    public String SHA_256 = "SHA-256";
    public String SHA_384 = "SHA-384";
    public String SHA_512 = "SHA-512";

    public String[] ALL = new String[]{MD2, MD5, SHA_1, SHA_256, SHA_384, SHA_512};
}
