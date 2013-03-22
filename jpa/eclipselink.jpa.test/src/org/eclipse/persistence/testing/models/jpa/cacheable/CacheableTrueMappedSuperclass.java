/*******************************************************************************
 * Copyright (c) 1998, 2013 Oracle and/or its affiliates. All rights reserved.
 * This program and the accompanying materials are made available under the 
 * terms of the Eclipse Public License v1.0 and Eclipse Distribution License v. 1.0 
 * which accompanies this distribution. 
 * The Eclipse Public License is available at http://www.eclipse.org/legal/epl-v10.html
 * and the Eclipse Distribution License is available at 
 * http://www.eclipse.org/org/documents/edl-v10.php.
 *
 * Contributors:
 *     06/16/2009-2.0 Guy Pelletier 
 *       - 277039: JPA 2.0 Cache Usage Settings
 ******************************************************************************/
package org.eclipse.persistence.testing.models.jpa.cacheable;

import static javax.persistence.GenerationType.TABLE;

import javax.persistence.Cacheable;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

@MappedSuperclass
@Cacheable(true)
public class CacheableTrueMappedSuperclass {
    private int id;
    
    public CacheableTrueMappedSuperclass() {}
    
    @Id
    @GeneratedValue(strategy=TABLE, generator="CACHEABLE_TABLE_GENERATOR")
    public int getId() {
        return id;
    }
    
    public void setId(int id) {
        this.id = id;
    }
}
