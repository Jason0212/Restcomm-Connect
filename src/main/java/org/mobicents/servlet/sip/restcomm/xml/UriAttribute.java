/*
 * This is free software; you can redistribute it and/or modify it
 * under the terms of the GNU Lesser General Public License as
 * published by the Free Software Foundation; either version 2.1 of
 * the License, or (at your option) any later version.
 *
 * This software is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the GNU
 * Lesser General Public License for more details.
 *
 * You should have received a copy of the GNU Lesser General Public
 * License along with this software; if not, write to the Free
 * Software Foundation, Inc., 51 Franklin St, Fifth Floor, Boston, MA
 * 02110-1301 USA, or see the FSF site: http://www.fsf.org.
 */
package org.mobicents.servlet.sip.restcomm.xml;

import java.net.URI;
import java.net.URISyntaxException;

import org.mobicents.servlet.sip.restcomm.annotations.concurrency.NotThreadSafe;

/**
 * @author quintana.thomas@gmail.com (Thomas Quintana)
 */
@NotThreadSafe public abstract class UriAttribute extends AbstractAttribute {
  public UriAttribute() {
    super();
  }

  @Override public abstract String getName();
  
  public final URI getUriValue() throws URISyntaxException {
    return new URI(value);
  }

  @Override public boolean isSupportedValue(final String value) {
    try {
	  new URI(value);
	  return true;
	} catch(final URISyntaxException exception) {
	  return false;
	}
  }
  
  public void setUriValue(final URI newValue) {
    setValue(newValue.toString());
  }
}
