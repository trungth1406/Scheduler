package com.achttee.model;


import com.achttee.model.abstraction.AbstractNote;

import java.util.HashMap;
import java.util.Map;


/**
 * @author trungtran
 * @apiNote Category for {@link Activity}
 */
public  class Category  {

    private Map<String,AbstractNote> map = new HashMap<>();
    private String name;
    private String icon;



    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }
}
