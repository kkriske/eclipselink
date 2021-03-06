/*
 * Copyright (c) 1998, 2020 Oracle and/or its affiliates. All rights reserved.
 *
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License v. 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0,
 * or the Eclipse Distribution License v. 1.0 which is available at
 * http://www.eclipse.org/org/documents/edl-v10.php.
 *
 * SPDX-License-Identifier: EPL-2.0 OR BSD-3-Clause
 */

// Contributors:
//     Mike Norman - June 2008, created utils DBWS test package
package dbws.testing;

//javase imports
import java.io.StringWriter;
import org.w3c.dom.Document;

//java eXtension imports
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

public class DBWSTestHelper {

    public static final String CONSTANT_PROJECT_BUILD_VERSION =
        "Eclipse Persistence Services - some version (some build date)";
    public static final String DATABASE_DRIVER = "oracle.jdbc.OracleDriver";
    public static final String DATABASE_PLATFORM = "org.eclipse.persistence.platform.database.oracle.Oracle11Platform";
    public static final String DATABASE_USERNAME_KEY = "db.user";
    public static final String DEFAULT_DATABASE_USERNAME = "user";
    public static final String DATABASE_PASSWORD_KEY = "db.pwd";
    public static final String DEFAULT_DATABASE_PASSWORD = "password";
    public static final String DATABASE_URL_KEY = "db.url";
    public static final String DEFAULT_DATABASE_URL = "jdbc:oracle:thin:@localhost:1521:ORCL";
    public final static String DATABASE_DDL_CREATE_KEY = "db.ddl.create";
    public final static String DATABASE_DDL_DROP_KEY = "db.ddl.drop";
    public final static String DATABASE_DDL_DEBUG_KEY = "db.ddl.debug";
    public final static String DEFAULT_DATABASE_DDL_CREATE = "false";
    public final static String DEFAULT_DATABASE_DDL_DROP = "false";
    public final static String DEFAULT_DATABASE_DDL_DEBUG = "false";

    public static String documentToString(Document doc) {
        DOMSource domSource = new DOMSource(doc);
        StringWriter stringWriter = new StringWriter();
        StreamResult result = new StreamResult(stringWriter);
        try {
            Transformer transformer = TransformerFactory.newInstance().newTransformer();
            transformer.setOutputProperty("indent", "yes");
            transformer.transform(domSource, result);
            return stringWriter.toString();
        } catch (Exception e) {
            // e.printStackTrace();
            return "<empty/>";
        }
    }
}
