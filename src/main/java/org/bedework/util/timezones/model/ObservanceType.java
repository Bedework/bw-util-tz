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

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.xml.datatype.XMLGregorianCalendar;

/**
 *
 *         In an expanded timezone, the observance element specifies a
 *         single timezone observance.
 *
 *         The utc-offset-from element defines the UTC offset in hours
 *         and minutes before the start of this observance.
 *
 *         The utc-offset-to element defines the UTC offset in hours and
 *         minutes at and after the start of this observance.
 *
 *
 * <pre>
   ; Information about a timezone available on the server
   observance : {
     oname,
     ?olocal_names,
     onset,
     utc_offset_from,
     utc_offset_to
   }

   ; Observance name
   oname "name" : string

   ; Array of localized observance names
   olocal_names "local-names" : [ * :string]

   ; The local time at which the observance takes effect
   ; [RFC3339] value modified to exclude "time-offset" part
   onset "onset" : date-time

   ; The UTC offset in seconds before the start of this observance
   utc_offset_from "utc-offset-from" : integer

   ; The UTC offset in seconds at and after the start of this observance
   utc_offset_to "utc-offset-to" : integer

 * </pre>
 *
 *
 */
public class ObservanceType {
  protected String name;
  protected String onset;
  protected int utcOffsetFrom;
  protected int utcOffsetTo;

  /**
   * Gets the value of the name property.
   *
   * @return
   *     possible object is
   *     {@link String }
   *
   */
  public String getName() {
    return name;
  }

  /**
   * Sets the value of the name property.
   *
   * @param value
   *     allowed object is
   *     {@link String }
   *
   */
  public void setName(final String value) {
    name = value;
  }

  /**
   * Gets the value of the onset property.
   *
   * @return
   *     possible object is
   *     {@link XMLGregorianCalendar }
   *
   */
  public String getOnset() {
    return onset;
  }

  /**
   * Sets the value of the onset property.
   *
   * @param value
   *     allowed object is
   *     {@link XMLGregorianCalendar }
   *
   */
  public void setOnset(final String value) {
    onset = value;
  }

  /**
   * Gets the value of the utcOffsetFrom property - seconds.
   *
   * @return int seconds
   *
   */
  @JsonProperty("utc-offset-from")
  public int getUtcOffsetFrom() {
    return utcOffsetFrom;
  }

  /**
   * Sets the value of the utcOffsetFrom property.
   *
   * @param value seconds
   *
   */
  public void setUtcOffsetFrom(final int value) {
    utcOffsetFrom = value;
  }

  /**
   * Gets the value of the utcOffsetTo property - seconds.
   *
   * @return int seconds
   *
   */
  @JsonProperty("utc-offset-to")
  public int getUtcOffsetTo() {
    return utcOffsetTo;
  }

  /**
   * Sets the value of the utcOffsetTo property.
   *
   * @param value seconds
   *
   */
  public void setUtcOffsetTo(final int value) {
    utcOffsetTo = value;
  }

  @Override
  public String toString() {
    final ToString ts = new ToString(this);

    ts.append("name", getName());
    ts.append("onset", getOnset());
    ts.append("offset-from", getUtcOffsetFrom());
    ts.append("offset-to", getUtcOffsetTo());

    return ts.toString();
  }

}
