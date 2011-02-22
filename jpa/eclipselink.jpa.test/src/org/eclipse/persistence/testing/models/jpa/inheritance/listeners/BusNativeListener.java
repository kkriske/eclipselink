/*******************************************************************************
 * Copyright (c) 2011 Oracle. All rights reserved.
 * This program and the accompanying materials are made available under the 
 * terms of the Eclipse Public License v1.0 and Eclipse Distribution License v. 1.0 
 * which accompanies this distribution. 
 * The Eclipse Public License is available at http://www.eclipse.org/legal/epl-v10.html
 * and the Eclipse Distribution License is available at 
 * http://www.eclipse.org/org/documents/edl-v10.php.
 *
 * Contributors:
 *     01/05/2010-2.1 Guy Pelletier 
 *       - 211324: Add additional event(s) support to the EclipseLink-ORM.XML Schema
 ******************************************************************************/
package org.eclipse.persistence.testing.models.jpa.inheritance.listeners;

import org.eclipse.persistence.descriptors.DescriptorEvent;
import org.eclipse.persistence.descriptors.DescriptorEventAdapter;
import org.eclipse.persistence.testing.models.jpa.inheritance.Bus;
import org.eclipse.persistence.testing.models.jpa.inheritance.Vehicle;

/**
 * A listener class that implements DescriptorEventListener (directly or through
 * an adapter) is added to the descriptor's event manager directly.
 * 
 * @author gpelleti
 */
public class BusNativeListener extends DescriptorEventAdapter {
    public static int PRE_WRITE_COUNT = 0;
    public static int POST_WRITE_COUNT = 0;
    public static int PRE_UPDATE_COUNT = 0;
    
    public void preWrite(DescriptorEvent event) {
        PRE_WRITE_COUNT++;
    }
    
    public void postWrite(DescriptorEvent event) {
        POST_WRITE_COUNT++;
    }
    
    public void preUpdate(DescriptorEvent event) {
        PRE_UPDATE_COUNT++;
        Bus bus = (Bus)event.getSource();
        
        if (bus.getDescription() != null && bus.getDescription().equals("QueryInNativePreUpdateEvent")){
            org.eclipse.persistence.queries.ReadAllQuery query = new org.eclipse.persistence.queries.ReadAllQuery(Vehicle.class);
            /*
             * load objects into this UnitOfWork, resulting in a ConcurrentModificationException if the UOW is iterating over its 
             * collection of clones
             */
            Object results = event.getSession().executeQuery(query);
        }
    }
}
