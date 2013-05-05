package com.google.code.siren4j.component.testpojos;

import com.google.code.siren4j.annotations.Siren4JEntity;
import com.google.code.siren4j.resource.BaseResource;

@Siren4JEntity(uri = "/NonNamePojos/{id}")
public class NoNamePojo extends BaseResource {
     
    private String id;
    private String name;
    private String val;
    
    
    
    public NoNamePojo() {
        
    }

    

    public NoNamePojo(String id, String name, String val) {
        super();
        this.id = id;
        this.name = name;
        this.val = val;
    }



    public String getId() {
        return id;
    }



    public void setId(String id) {
        this.id = id;
    }



    public String getName() {
        return name;
    }



    public void setName(String name) {
        this.name = name;
    }



    public String getVal() {
        return val;
    }



    public void setVal(String val) {
        this.val = val;
    }
    
    

}
