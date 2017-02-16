package com.angular.spring.model.responses;

/**
 * Created by baynescorps on 15/02/2017.
 */
public class APIMeta {
    private String code;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        APIMeta apiMeta = (APIMeta) o;

        return !(code != null ? !code.equals(apiMeta.code) : apiMeta.code != null);

    }
}
