 /*
 * Light Portal
 *
 * Copyright (c) 2009, Light Portal, Inc or third-party contributors as
 * indicated by the @author tags or express copyright attribution
 * statements applied by the authors.  All third-party contributions are
 * distributed under license by Light Portal, Inc.
 *
 * This copyrighted material is made available to anyone wishing to use, modify,
 * copy, or redistribute it subject to the terms and conditions of the GNU
 * Lesser General Public License, as published by the Free Software Foundation.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of MERCHANTABILITY
 * or FITNESS FOR A PARTICULAR PURPOSE.  See the GNU Lesser General Public License
 * for more details.
 *
 * You should have received a copy of the GNU Lesser General Public License
 * along with this distribution; if not, write to:
 * Free Software Foundation, Inc.
 * 51 Franklin Street, Fifth Floor
 * Boston, MA  02110-1301  USA
 *
 */
package org.light.portal.core.event;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
/**
 * 
 * @author Jianmin Liu
 **/
public abstract class ServletEvent implements Event {

	public void execute(Object... args) throws Exception {
		if(args.length != 2) throw new RuntimeException("Event is not ServletEvent type.");
		HttpServletRequest request = null;
		HttpServletResponse response = null;
		try{
			request = (HttpServletRequest)args[0];
			response = (HttpServletResponse)args[1];
		}catch(Exception ex){
			throw new RuntimeException("Event is not ServletEvent type.");
		}
		if(request != null && response != null)
			this.execute(request,response);
	}
	public abstract void execute(HttpServletRequest request, HttpServletResponse response) throws Exception;
}
