/*
 *    GeoTools - The Open Source Java GIS Toolkit
 *    http://geotools.org
 *
 *    (C) 2002-2008, Open Source Geospatial Foundation (OSGeo)
 *
 *    This library is free software; you can redistribute it and/or
 *    modify it under the terms of the GNU Lesser General Public
 *    License as published by the Free Software Foundation;
 *    version 2.1 of the License.
 *
 *    This library is distributed in the hope that it will be useful,
 *    but WITHOUT ANY WARRANTY; without even the implied warranty of
 *    MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the GNU
 *    Lesser General Public License for more details.
 */
package org.geotools.filter.v1_0;

import javax.xml.namespace.QName;
import org.geotools.api.filter.FilterFactory;
import org.geotools.api.filter.PropertyIsEqualTo;
import org.geotools.api.filter.expression.Expression;
import org.geotools.xsd.AbstractComplexBinding;
import org.geotools.xsd.ElementInstance;
import org.geotools.xsd.Node;

/**
 * Binding object for the element http://www.opengis.net/ogc:PropertyIsEqualTo.
 *
 * <p>
 *
 * <pre>
 *         <code>
 *  &lt;xsd:element name="PropertyIsEqualTo"
 *      substitutionGroup="ogc:comparisonOps" type="ogc:BinaryComparisonOpType"/&gt;
 *
 *          </code>
 *         </pre>
 *
 * @generated
 */
public class OGCPropertyIsEqualToBinding extends AbstractComplexBinding {
    FilterFactory filterfactory;

    public OGCPropertyIsEqualToBinding(FilterFactory filterfactory) {
        this.filterfactory = filterfactory;
    }

    /** @generated */
    @Override
    public QName getTarget() {
        return OGC.PropertyIsEqualTo;
    }

    /**
     *
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     *
     * @generated modifiable
     */
    @Override
    public Class getType() {
        return PropertyIsEqualTo.class;
    }

    @Override
    public int getExecutionMode() {
        return AFTER;
    }

    /**
     *
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     *
     * @generated modifiable
     */
    @Override
    public Object parse(ElementInstance instance, Node node, Object value) throws Exception {
        Expression e1 = (Expression) node.getChildValue(0);
        Expression e2 = (Expression) node.getChildValue(1);

        // &lt;xsd:attribute default="true" name="matchCase" type="xsd:boolean" use="optional"/&gt;
        Boolean matchCase = Boolean.TRUE;

        if (node.hasAttribute("matchCase")) {
            matchCase = (Boolean) node.getAttributeValue("matchCase");
        }

        return filterfactory.equal(e1, e2, matchCase.booleanValue());
    }
}
