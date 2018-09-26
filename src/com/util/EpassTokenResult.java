package com.util;

public class EpassTokenResult {


    /**
     * refresh_token : oePoL8H7szup0HxKAKbU4HdjBpYfTW
     * token_type : Bearer
     * access_token : 6hHMTDzpsK7mri3o829gkA3cUoJ8MB
     * expires_in : 36000
     * scope : profile
     */

    private String refresh_token;
    private String token_type;
    private String access_token;
    private int expires_in;
    private String scope;

    private String error;

    private String detail;

    public String getRefresh_token() {
        return refresh_token;
    }

    public void setRefresh_token(String refresh_token) {
        this.refresh_token = refresh_token;
    }

    public String getToken_type() {
        return token_type;
    }

    public void setToken_type(String token_type) {
        this.token_type = token_type;
    }

    public String getAccess_token() {
        return access_token;
    }

    public void setAccess_token(String access_token) {
        this.access_token = access_token;
    }

    public int getExpires_in() {
        return expires_in;
    }

    public void setExpires_in(int expires_in) {
        this.expires_in = expires_in;
    }

    public String getScope() {
        return scope;
    }

    public void setScope(String scope) {
        this.scope = scope;
    }

    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }

    public String getDetail() {
        return detail;
    }

    public void setDetail(String detail) {
        this.detail = detail;
    }
}
