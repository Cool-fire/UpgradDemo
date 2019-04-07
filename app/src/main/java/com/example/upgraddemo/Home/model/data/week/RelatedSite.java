package com.example.upgraddemo.Home.model.data.week;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class RelatedSite {

    @SerializedName("relation")
    @Expose
    private String relation;
    @SerializedName("api_site_parameter")
    @Expose
    private String apiSiteParameter;
    @SerializedName("site_url")
    @Expose
    private String siteUrl;
    @SerializedName("name")
    @Expose
    private String name;

    public String getRelation() {
        return relation;
    }

    public void setRelation(String relation) {
        this.relation = relation;
    }

    public String getApiSiteParameter() {
        return apiSiteParameter;
    }

    public void setApiSiteParameter(String apiSiteParameter) {
        this.apiSiteParameter = apiSiteParameter;
    }

    public String getSiteUrl() {
        return siteUrl;
    }

    public void setSiteUrl(String siteUrl) {
        this.siteUrl = siteUrl;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}