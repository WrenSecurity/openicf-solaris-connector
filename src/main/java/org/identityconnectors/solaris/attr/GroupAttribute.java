/*
 * ====================
 * DO NOT ALTER OR REMOVE COPYRIGHT NOTICES OR THIS HEADER.
 *
 * Copyright 2008-2009 Sun Microsystems, Inc. All rights reserved.
 *
 * The contents of this file are subject to the terms of the Common Development
 * and Distribution License("CDDL") (the "License").  You may not use this file
 * except in compliance with the License.
 *
 * You can obtain a copy of the License at
 * http://opensource.org/licenses/cddl1.php
 * See the License for the specific language governing permissions and limitations
 * under the License.
 *
 * When distributing the Covered Code, include this CDDL Header Notice in each file
 * and include the License file at http://opensource.org/licenses/cddl1.php.
 * If applicable, add the following below this CDDL Header, with the fields
 * enclosed by brackets [] replaced by your own identifying information:
 * "Portions Copyrighted [year] [name of copyright owner]"
 * ====================
 */

package org.identityconnectors.solaris.attr;

import java.util.HashMap;
import java.util.Map;

import org.identityconnectors.framework.common.objects.Name;

public enum GroupAttribute implements ConnectorAttribute {
    // @formatter:off
    GROUPNAME(Name.NAME, NativeAttribute.NAME),
    GID("gid", NativeAttribute.ID),
    USERS("users", NativeAttribute.USERS);
    // @formatter:on

    private String name;
    private NativeAttribute nativeAttr;

    private static final Map<String, GroupAttribute> STRING_TO_GROUP =
            new HashMap<String, GroupAttribute>();
    static {
        for (GroupAttribute grpAttr : values()) {
            STRING_TO_GROUP.put(grpAttr.getName(), grpAttr);
        }
    }

    public static GroupAttribute forAttributeName(String groupAttr) {
        return STRING_TO_GROUP.get(groupAttr);
    }

    private GroupAttribute(String name, NativeAttribute nativeAttr) {
        this.name = name;
        this.nativeAttr = nativeAttr;
    }

    public String getName() {
        return name;
    }

    public NativeAttribute getNative() {
        return nativeAttr;
    }

}
