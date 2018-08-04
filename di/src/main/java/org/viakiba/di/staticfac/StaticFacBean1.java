package org.viakiba.di.staticfac;

/**
 * @description
 * @author viakiba
 * @date Create in 8:24 2018/8/4
 */
public class StaticFacBean1 {
    private String name = "StaticFacBean1";

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "StaticFacBean1{" +
                "name='" + name + '\'' +
                '}';
    }
}
