package com.util;

import java.util.List;

public class OrganizationForm {
    private String name;

    private String description;

    private String orgType;

    private String category;

    private String pid;

    private String divisionId;

    private String tenantId;

    private Boolean independentTenent;

    private String walletId;

    private Boolean independentWallet;

    private List<String> adminUsers;

    private String bizId;

    private Boolean canAdminTenant;

    private Boolean canAdminWallet;


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getOrgType() {
        return orgType;
    }

    public void setOrgType(String orgType) {
        this.orgType = orgType;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getPid() {
        return pid;
    }

    public void setPid(String pid) {
        this.pid = pid;
    }

    public String getDivisionId() {
        return divisionId;
    }

    public void setDivisionId(String divisionId) {
        this.divisionId = divisionId;
    }

    public String getTenantId() {
        return tenantId;
    }

    public void setTenantId(String tenantId) {
        this.tenantId = tenantId;
    }

    public Boolean getIndependentTenent() {
        return independentTenent;
    }

    public void setIndependentTenent(Boolean independentTenent) {
        this.independentTenent = independentTenent;
    }

    public String getWalletId() {
        return walletId;
    }

    public void setWalletId(String walletId) {
        this.walletId = walletId;
    }

    public Boolean getIndependentWallet() {
        return independentWallet;
    }

    public void setIndependentWallet(Boolean independentWallet) {
        this.independentWallet = independentWallet;
    }

    public List<String> getAdminUsers() {
        return adminUsers;
    }

    public void setAdminUsers(List<String> adminUsers) {
        this.adminUsers = adminUsers;
    }

    public String getBizId() {
        return bizId;
    }

    public void setBizId(String bizId) {
        this.bizId = bizId;
    }

    public Boolean getCanAdminTenant() {
        return canAdminTenant;
    }

    public void setCanAdminTenant(Boolean canAdminTenant) {
        this.canAdminTenant = canAdminTenant;
    }

    public Boolean getCanAdminWallet() {
        return canAdminWallet;
    }

    public void setCanAdminWallet(Boolean canAdminWallet) {
        this.canAdminWallet = canAdminWallet;
    }
}
