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
package org.bedework.util.timezones;

import org.bedework.util.caching.FlushMap;

import net.fortuna.ical4j.model.TimeZone;
import net.fortuna.ical4j.model.TimeZoneRegistry;

/**
 * An implementation of <code>TimeZoneRegistry</code> which
 * does not fetch timezones - only caches.
 *
 * @author Mike Douglass
 */
public class TimeZoneRegistryNoFetch implements TimeZoneRegistry {
  protected FlushMap<String, TimeZone> timezones =
          new FlushMap<>(60 * 1000 * 60, // 1 hour
                         100); // 100 timezones

  @Override
  public void register(final TimeZone timezone) {
    try {
      Timezones.registerTz(timezone.getID(), timezone);
    } catch (final Throwable t) {
      throw new RuntimeException(t);
    }
  }

  @Override
  public void register(final TimeZone timezone,
                       final boolean update) {
    timezones.put(timezone.getID(), timezone);
  }

  @Override
  public void clear() {
  }

  @Override
  public TimeZone getTimeZone(final String id) {
    return timezones.get(id);
  }
}

