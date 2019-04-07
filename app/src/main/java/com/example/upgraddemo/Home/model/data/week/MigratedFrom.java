package com.example.upgraddemo.Home.model.data.week;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class MigratedFrom {

    @SerializedName("other_site")
    @Expose
    private OtherSite otherSite;
    @SerializedName("on_date")
    @Expose
    private Integer onDate;
    @SerializedName("question_id")
    @Expose
    private Integer questionId;

    public OtherSite getOtherSite() {
        return otherSite;
    }

    public void setOtherSite(OtherSite otherSite) {
        this.otherSite = otherSite;
    }

    public Integer getOnDate() {
        return onDate;
    }

    public void setOnDate(Integer onDate) {
        this.onDate = onDate;
    }

    public Integer getQuestionId() {
        return questionId;
    }

    public void setQuestionId(Integer questionId) {
        this.questionId = questionId;
    }

}