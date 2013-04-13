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
package com.google.code.siren4j.component.builder;

import java.util.ArrayList;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.collections.MapUtils;
import org.apache.commons.lang.ArrayUtils;
import org.apache.commons.lang.StringUtils;

import com.google.code.siren4j.component.Action;
import com.google.code.siren4j.component.Entity;
import com.google.code.siren4j.component.Link;
import com.google.code.siren4j.component.impl.ActionImpl;
import com.google.code.siren4j.component.impl.EntityImpl;
import com.google.code.siren4j.component.impl.LinkImpl;
import com.google.code.siren4j.error.Siren4JBuilderValidationException;

public class EntityBuilder extends BaseBuilder<Entity> {

    private List<Entity> subEntities = new ArrayList<Entity>();

    private List<Link> links = new ArrayList<Link>();

    private List<Action> actions = new ArrayList<Action>();

    private Map<String, Object> properties = new LinkedHashMap<String, Object>();

    private EntityBuilder() {
    }

    public static EntityBuilder newInstance() {
        return new EntityBuilder();
    }

    public EntityBuilder setEntityClass(String... entityClass) {
        addStep("setEntityClass", new Object[] { entityClass });
        return this;
    }

    public EntityBuilder setRelationship(String... rel) {
        addStep("setRel", new Object[] { rel });
        return this;
    }

    public EntityBuilder setHref(String href) {
        addStep("setHref", new Object[] { href });
        addStep("setReference", new Object[] { true });
        return this;
    }

    public EntityBuilder addProperty(String name, Object value) {
        addStep("_addProperty", new Object[] { name, value }, true);
        return this;
    }

    public EntityBuilder addProperties(Map<String, Object> properties) {
        for (String key : properties.keySet()) {
            addProperty(key, properties.get(key));
        }
        return this;
    }

    public EntityBuilder addSubEntity(Entity subEntity) {
        addStep("_addEntity", new Object[] { subEntity }, true);
        return this;
    }

    public EntityBuilder addSubEntities(List<Entity> entities) {
        for (Entity entity : entities) {
            addSubEntity(entity);
        }
        return this;
    }

    public EntityBuilder addLink(Link link) {
        addStep("_addLink", new Object[] { link }, true);
        return this;
    }

    public EntityBuilder addLinks(List<Link> links) {
        for (Link link : links) {
            addLink(link);
        }
        return this;
    }

    public EntityBuilder addAction(Action action) {
        addStep("_addAction", new Object[] { action }, true);
        return this;
    }

    public EntityBuilder addActions(List<Action> actions) {
        for (Action action : actions) {
            addAction(action);
        }
        return this;
    }

    void _addEntity(EntityImpl entity) {
        subEntities.add(entity);
    }

    void _addLink(LinkImpl link) {
        links.add(link);
    }

    void _addAction(ActionImpl action) {
        actions.add(action);
    }

    void _addProperty(String name, Object value) {
        properties.put(name, value);
    }

    void _addProperty(String name, String value) {
        properties.put(name, value);
    }

    void _addProperty(String name, Integer value) {
        properties.put(name, value);
    }

    void _addProperty(String name, Long value) {
        properties.put(name, value);
    }

    void _addProperty(String name, Float value) {
        properties.put(name, value);
    }

    void _addProperty(String name, Double value) {
        properties.put(name, value);
    }

    void _addProperty(String name, Boolean value) {
        properties.put(name, value);
    }

    void _addProperty(String name, Date value) {
        properties.put(name, value);
    }

    @Override
    protected void postProcess(Entity obj) {
        EntityImpl entity = (EntityImpl) obj;
        if (!CollectionUtils.isEmpty(subEntities)) {
            entity.setEntities(subEntities);
        }

        if (!CollectionUtils.isEmpty(actions)) {
            entity.setActions(actions);
        }

        if (!CollectionUtils.isEmpty(links)) {
            entity.setLinks(links);
        }

        if (!MapUtils.isEmpty(properties)) {
            entity.setProperties(properties);
        }
    }

    @Override
    protected void validate(Entity obj) {
        validateSubEntities(obj);
    }

    private void validateSubEntities(Entity obj) {
        // Validate that all sub entities have a "rel" set.
        String relRequired = "Sub entities are required to have a <rel> property set.";
        String hrefReqForEmbed = "Sub entities that are embedded links are required to have a <href> property set.";
        if (!CollectionUtils.isEmpty(obj.getEntities())) {
            for (Entity e : obj.getEntities()) {
                if (e.getRel() == null || ArrayUtils.isEmpty(e.getRel())) {
                    throw new Siren4JBuilderValidationException("entities", obj.getClass(), relRequired);
                }
                if (e.isReference() && StringUtils.isBlank(e.getHref())) {
                    throw new Siren4JBuilderValidationException("entities", obj.getClass(), hrefReqForEmbed);
                }
            }
        }
    }

    @Override
    protected Entity createInstance() {
        return new EntityImpl();
    }

}
