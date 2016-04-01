/*
 * Copyright WizTools.org
 * Licensed under the Apache License, Version 2.0:
 * http://www.apache.org/licenses/LICENSE-2.0
 */
package org.wiztools.commons;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

/**
 * A HashSet implementation of the ExpiryCollection.
 * @author subwiz
 */
public class ExpiryHashSet<T> extends AbstractExpiryCollection<T> {

    private final Set<AbstractExpiryCollection.Encp> data = new HashSet<>();

    public ExpiryHashSet(final long cleanerThreadIntervalInMilliSecond){
        super(cleanerThreadIntervalInMilliSecond);
    }

    @Override
    public Collection<AbstractExpiryCollection.Encp> getData() {
        return data;
    }

}
