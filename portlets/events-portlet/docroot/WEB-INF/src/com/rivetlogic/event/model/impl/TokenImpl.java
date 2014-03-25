/**
 * Copyright (C) 2014 Rivet Logic Corporation. All rights reserved.
 */

/**
 * Copyright (c) 2000-2013 Liferay, Inc. All rights reserved.
 *
 * This library is free software; you can redistribute it and/or modify it under
 * the terms of the GNU Lesser General Public License as published by the Free
 * Software Foundation; either version 2.1 of the License, or (at your option)
 * any later version.
 *
 * This library is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU Lesser General Public License for more
 * details.
 */

package com.rivetlogic.event.model.impl;

import java.util.Date;

/**
 * The extended model implementation for the Token service. Represents a row in
 * the &quot;rivetlogic_event_Token&quot; database table, with each column
 * mapped to a property of this class.
 * 
 * <p>
 * Helper methods and all application logic should be put in this class.
 * Whenever methods are added, rerun ServiceBuilder to copy their definitions
 * into the {@link com.rivetlogic.event.model.Token} interface.
 * </p>
 * 
 * @author juancarrillo
 */
public class TokenImpl extends TokenBaseImpl {
    /*
     * NOTE FOR DEVELOPERS:
     * 
     * Never reference this class directly. All methods that expect a token
     * model instance should use the {@link com.rivetlogic.event.model.Token}
     * interface instead.
     */
    public TokenImpl() {
    }
    
    public boolean isExpired() {
        Date expiredDate = this.getExpiredDate();
        return (expiredDate != null) && expiredDate.before(new Date());
    }
}