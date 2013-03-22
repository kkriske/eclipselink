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
 *     Oracle - initial API and implementation from Oracle TopLink
 ******************************************************************************/  
package org.eclipse.persistence.testing.tests.validation;

import java.util.Vector;


public class ConstructorProject extends org.eclipse.persistence.sessions.Project {


    public ConstructorProject() {
        applyPROJECT();
        applyLOGIN();

        buildNoParamConstructorDescriptor();
        buildPrivateConstructorDescriptor();
    }

    /**
     * TopLink generated method. 
     * <b>WARNING</b>: This code was generated by an automated tool.
     * Any changes will be lost when the code is re-generated
     */
    protected void applyLOGIN() {
        org.eclipse.persistence.sessions.DatabaseLogin login = new org.eclipse.persistence.sessions.DatabaseLogin();

        login.setDriverClassName("sun.jdbc.odbc.JdbcOdbcDriver");
        login.setConnectionString("jdbc:odbc:MSACCESS");
        login.setPlatformClassName("org.eclipse.persistence.platform.database.AccessPlatform");
    }

    /**
     * TopLink generated method. 
     * <b>WARNING</b>: This code was generated by an automated tool.
     * Any changes will be lost when the code is re-generated
     */
    protected void applyPROJECT() {
        setName("Employee");
    }

    /**
     * This method was created in VisualAge.
     */
    public void buildNoParamConstructorDescriptor() {
        org.eclipse.persistence.descriptors.RelationalDescriptor descriptor = new org.eclipse.persistence.descriptors.RelationalDescriptor();

        // SECTION: DESCRIPTOR
        descriptor.setJavaClass(org.eclipse.persistence.testing.tests.validation.NoParamConstructor.class);
        Vector vector = new Vector();
        vector.addElement("NO_PARAM_CONST_TBL");
        descriptor.setTableNames(vector);
        descriptor.addPrimaryKeyFieldName("NO_PARAM_CONST_TBL.NO_CONST_ID");

        // SECTION: PROPERTIES
        descriptor.setIdentityMapClass(org.eclipse.persistence.internal.identitymaps.FullIdentityMap.class);
        descriptor.setSequenceNumberName("NO_PARAM_CONST_ID_SEQ");
        descriptor.setSequenceNumberFieldName("NO_PARAM_CONST_ID");
        descriptor.setExistenceChecking("Check cache");
        descriptor.setIdentityMapSize(100);

        // SECTION: DIRECTTOFIELDMAPPING
        org.eclipse.persistence.mappings.DirectToFieldMapping directtofieldmapping = new org.eclipse.persistence.mappings.DirectToFieldMapping();
        directtofieldmapping.setAttributeName("id");
        directtofieldmapping.setIsReadOnly(false);
        directtofieldmapping.setFieldName("NO_PARAM_CONST_TBL.NO_CONST_ID");
        descriptor.addMapping(directtofieldmapping);


        // SECTION: COPY POLICY
        descriptor.createCopyPolicy("constructor");

        // SECTION: INSTANTIATION POLICY
        descriptor.createInstantiationPolicy("constructor");


        addDescriptor(descriptor);
    }

    /**
     * This method was created in VisualAge.
     */
    public void buildPrivateConstructorDescriptor() {
        org.eclipse.persistence.descriptors.RelationalDescriptor descriptor = new org.eclipse.persistence.descriptors.RelationalDescriptor();


        // SECTION: DESCRIPTOR
        descriptor.setJavaClass(org.eclipse.persistence.testing.tests.validation.PrivateConstructor.class);
        Vector vector = new Vector();
        vector.addElement("PRIVATE_CONST_TBL");
        descriptor.setTableNames(vector);
        descriptor.addPrimaryKeyFieldName("PRIVATE_CONST_TBL.PRIVATE_CONST_ID");

        // SECTION: PROPERTIES
        descriptor.setIdentityMapClass(org.eclipse.persistence.internal.identitymaps.FullIdentityMap.class);
        descriptor.setSequenceNumberName("PRIVATE_CONST_ID_SEQ");
        descriptor.setSequenceNumberFieldName("PRIVATE_CONST_ID");
        descriptor.setExistenceChecking("Check cache");
        descriptor.setIdentityMapSize(100);

        // SECTION: DIRECTTOFIELDMAPPING
        org.eclipse.persistence.mappings.DirectToFieldMapping directtofieldmapping = new org.eclipse.persistence.mappings.DirectToFieldMapping();
        directtofieldmapping.setAttributeName("id");
        directtofieldmapping.setIsReadOnly(false);
        directtofieldmapping.setFieldName("PRIVATE_CONST_TBL.PRIVATE_CONST_ID");
        descriptor.addMapping(directtofieldmapping);


        // SECTION: COPY POLICY
        descriptor.createCopyPolicy("constructor");

        // SECTION: INSTANTIATION POLICY
        descriptor.createInstantiationPolicy("constructor");


        addDescriptor(descriptor);
    }
}
