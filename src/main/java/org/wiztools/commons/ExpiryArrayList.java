/*
 * Copyright WizTools.org
 * Licensed under the Apache License, Version 2.0:
 * http://www.apache.org/licenses/LICENSE-2.0
 */
package org.wiztools.commons;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * ArrayList implementation of ExpiryCollection
 * @author subwiz
 */
public class ExpiryArrayList<T> extends AbstractExpiryCollection<T> {
    private final List<AbstractExpiryCollection.Encp> data = new ArrayList<>();

    public ExpiryArrayList(final long cleanerThreadIntervalInMilliSecond) {
        super(cleanerThreadIntervalInMilliSecond);
    }

    @Override
    public Collection<AbstractExpiryCollection.Encp> getData() {
        return data;
    }


}
