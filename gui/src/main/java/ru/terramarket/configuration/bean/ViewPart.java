package ru.terramarket.configuration.bean;

import java.util.List;

/**
 * Date: 26.05.14
 * Time: 15:33
 */
public class ViewPart {
    private String id, controllerType;
    private List<String> params;

    public ViewPart() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getControllerType() {
        return controllerType;
    }

    public void setControllerType(String controllerType) {
        this.controllerType = controllerType;
    }

    public List<String> getParams() {
        return params;
    }

    public void setParams(List<String> params) {
        this.params = params;
    }
}
