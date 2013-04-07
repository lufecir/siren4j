/*******************************************************************************************
 * The MIT License (MIT)
 * 
 * Copyright (c) 2013 Erik R Serating
 * 
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 * 
 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.
 * 
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
 * SOFTWARE.
 *********************************************************************************************/
package com.google.code.siren4j.component.impl;

import com.google.code.siren4j.component.Field;
import com.google.code.siren4j.meta.FieldType;

public class FieldImpl implements Field {
	
	private String name;
	
	private FieldType type;
	
	private String value;	
	
	
	
	/* (non-Javadoc)
	 * @see com.google.code.siren4j.component.impl.Field#getName()
	 */
	public String getName() {
		return name;
	}




	public void setName(String name) {
		this.name = name;
	}




	/* (non-Javadoc)
	 * @see com.google.code.siren4j.component.impl.Field#getType()
	 */
	public FieldType getType() {
		return type;
	}




	public void setType(FieldType type) {
		this.type = type;
	}




	/* (non-Javadoc)
	 * @see com.google.code.siren4j.component.impl.Field#getValue()
	 */
	public String getValue() {
		return value;
	}




	public void setValue(String value) {
		this.value = value;
	}




	

}