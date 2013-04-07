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

import java.util.List;
import java.util.Map;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.google.code.siren4j.component.Action;
import com.google.code.siren4j.component.Entity;
import com.google.code.siren4j.component.Link;

public class EntityImpl implements Entity {
	
	@JsonProperty(value="class")
	private String[] entityClass;
	
	private String[] rel;
	
	private String href;
	
	private boolean reference;
	
	private Map<String, Object> properties;
	
	private List<Entity> entities;
	
	private List<Link> links;
	
	private List<Action> actions;

	/* (non-Javadoc)
	 * @see com.google.code.siren4j.component.impl.Entity#getEntityClass()
	 */
	public String[] getEntityClass() {
		return entityClass;
	}

	public void setEntityClass(String... entityClass) {
		this.entityClass = entityClass;
	}

	/* (non-Javadoc)
	 * @see com.google.code.siren4j.component.impl.Entity#getProperties()
	 */
	public Map<String, Object> getProperties() {
		return properties;
	}

	public void setProperties(Map<String, Object> properties) {
		this.properties = properties;
	}

	/* (non-Javadoc)
	 * @see com.google.code.siren4j.component.impl.Entity#getEntities()
	 */
	public List<Entity> getEntities() {
		return entities;
	}

	public void setEntities(List<Entity> entities) {
		this.entities = entities;
	}

	/* (non-Javadoc)
	 * @see com.google.code.siren4j.component.impl.Entity#getLinks()
	 */
	public List<Link> getLinks() {
		return links;
	}

	public void setLinks(List<Link> links) {
		this.links = links;
	}

	/* (non-Javadoc)
	 * @see com.google.code.siren4j.component.impl.Entity#getActions()
	 */
	public List<Action> getActions() {
		return actions;
	}

	public void setActions(List<Action> actions) {
		this.actions = actions;
	}

	/* (non-Javadoc)
	 * @see com.google.code.siren4j.component.impl.Entity#getRel()
	 */
	public String[] getRel() {
		return rel;
	}

	public void setRel(String... rel) {
		this.rel = rel;
	}

	public boolean isReference() {
		return reference;
	}

	public void setReference(boolean reference) {
		this.reference = reference;
	}

	public String getHref() {
		return href;
	}

	public void setHref(String href) {
		this.href = href;
	}
	
	

}
