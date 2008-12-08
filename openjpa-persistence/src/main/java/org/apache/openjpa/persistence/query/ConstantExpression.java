/*
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements.  See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership.  The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License.  You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied.  See the License for the
 * specific language governing permissions and limitations
 * under the License.
 */
package org.apache.openjpa.persistence.query;

import java.util.Arrays;

/**
 * Denotes a Value based expression such as Number, String or Date.
 * 
 * @author Pinaki Poddar
 *
 */
class ConstantExpression extends ExpressionImpl {
	private final Object _value;
	
	public ConstantExpression(Object value) {
		_value = value;
	}
	
	@Override
	public String asExpression(AliasContext ctx) {
		return JPQLHelper.toJPQL(ctx, _value);
	}
	
	@Override
	public String asProjection(AliasContext ctx) {
		return asExpression(ctx);
	}
}
