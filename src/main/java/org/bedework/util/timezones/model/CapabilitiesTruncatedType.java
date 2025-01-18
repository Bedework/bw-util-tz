/* ********************************************************************
    Licensed to Jasig under one or more contributor license
    agreements. See the NOTICE file distributed with this work
    for additional information regarding copyright ownership.
    Jasig licenses this file to you under the Apache License,
    Version 2.0 (the "License"); you may not use this file
    except in compliance with the License. You may obtain a
    copy of the License at:

    http://www.apache.org/licenses/LICENSE-2.0

    Unless required by applicable law or agreed to in writing,
    software distributed under the License is distributed on
    an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
    KIND, either express or implied. See the License for the
    specific language governing permissions and limitations
    under the License.
 */
package org.bedework.util.timezones.model;

import org.bedework.base.ToString;

import java.util.ArrayList;
import java.util.List;

/**
 *
 *         The element used as the container for information about the
 *         servers handling of truncation.
 *
 * <pre>
   truncation "info" : {
     primary_source / secondary_source,
     contacts
   }

   ; The source of the timezone data provided by a "primary" server
   primary_source "primary-source" : string

   ; The timezone server from which data is provided by a "secondary"
   ; server
   secondary_source "secondary-source" : uri

   ; Array of URIs providing contact details for the server
   ; administrator
   contacts "contacts" : [ * :uri ]
 * </pre>
 *
 *
 */
public class CapabilitiesTruncatedType {
  protected boolean any;
  protected List<Integer> years;
  protected boolean untruncated;

  /**
   * Gets the value of the any property.
   *
   * @return
   *     possible object is
   *     {@link boolean }
   *
   */
  public boolean getAny() {
    return any;
  }

  /**
   * Sets the value of the any property.
   *
   * @param value
   *     allowed object is
   *     {@link String }
   *
   */
  public void setAny(final boolean value) {
    any = value;
  }

  /**
   * Gets the value of the years property.
   *
   * <p>
   * This accessor method returns a reference to the live list,
   * not a snapshot. Therefore any modification you make to the
   * returned list will be present inside the Json object.
   * This is why there is not a <CODE>set</CODE> method for the years property.
   *
   * <p>
   * For example, to add a new item, do as follows:
   * <pre>
   *    getContacts().add(newItem);
   * </pre>
   *
   *
   * <p>
   * Objects of the following type(s) are allowed in the list
   * {@link String }
   * @return list of years
   */
  public List<Integer> getYears() {
    if (years == null) {
      years = new ArrayList<>();
    }
    return years;
  }

  /** Indicates whether the server can can supply untruncated When
   * set to "true" indicates that, in addition to truncated data being
   * available, the server can return untruncated data if an action "get"
   * request is executed without a "truncated" query parameter
   *
   * @return true for untruncated available
   *
   */
  public boolean getUntruncated() {
    return untruncated;
  }

  /**
   * Sets the value of the untruncated property.
   *
   * @param value
   *     allowed object is
   *     {@link String }
   *
   */
  public void setUntruncated(final boolean value) {
    untruncated = value;
  }

  @Override
  public String toString() {
    final ToString ts = new ToString(this);

    ts.append("any", getAny());
    ts.append("years", getYears(), false);
    ts.append("untruncated", getUntruncated());

    return ts.toString();
  }
}
