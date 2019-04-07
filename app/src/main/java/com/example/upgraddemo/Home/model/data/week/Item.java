package com.example.upgraddemo.Home.model.data.week;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Item {

    @SerializedName("tags")
    @Expose
    private List<String> tags = null;
    @SerializedName("owner")
    @Expose
    private Owner owner;
    @SerializedName("is_answered")
    @Expose
    private Boolean isAnswered;
    @SerializedName("view_count")
    @Expose
    private Integer viewCount;
    @SerializedName("answer_count")
    @Expose
    private Integer answerCount;
    @SerializedName("score")
    @Expose
    private Integer score;
    @SerializedName("last_activity_date")
    @Expose
    private Integer lastActivityDate;
    @SerializedName("creation_date")
    @Expose
    private Integer creationDate;
    @SerializedName("last_edit_date")
    @Expose
    private Integer lastEditDate;
    @SerializedName("question_id")
    @Expose
    private Integer questionId;
    @SerializedName("link")
    @Expose
    private String link;
    @SerializedName("title")
    @Expose
    private String title;
    @SerializedName("bounty_amount")
    @Expose
    private Integer bountyAmount;
    @SerializedName("bounty_closes_date")
    @Expose
    private Integer bountyClosesDate;
    @SerializedName("accepted_answer_id")
    @Expose
    private Integer acceptedAnswerId;
    @SerializedName("migrated_from")
    @Expose
    private MigratedFrom migratedFrom;

    public List<String> getTags() {
        return tags;
    }

    public void setTags(List<String> tags) {
        this.tags = tags;
    }

    public Owner getOwner() {
        return owner;
    }

    public void setOwner(Owner owner) {
        this.owner = owner;
    }

    public Boolean getIsAnswered() {
        return isAnswered;
    }

    public void setIsAnswered(Boolean isAnswered) {
        this.isAnswered = isAnswered;
    }

    public Integer getViewCount() {
        return viewCount;
    }

    public void setViewCount(Integer viewCount) {
        this.viewCount = viewCount;
    }

    public Integer getAnswerCount() {
        return answerCount;
    }

    public void setAnswerCount(Integer answerCount) {
        this.answerCount = answerCount;
    }

    public Integer getScore() {
        return score;
    }

    public void setScore(Integer score) {
        this.score = score;
    }

    public Integer getLastActivityDate() {
        return lastActivityDate;
    }

    public void setLastActivityDate(Integer lastActivityDate) {
        this.lastActivityDate = lastActivityDate;
    }

    public Integer getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(Integer creationDate) {
        this.creationDate = creationDate;
    }

    public Integer getLastEditDate() {
        return lastEditDate;
    }

    public void setLastEditDate(Integer lastEditDate) {
        this.lastEditDate = lastEditDate;
    }

    public Integer getQuestionId() {
        return questionId;
    }

    public void setQuestionId(Integer questionId) {
        this.questionId = questionId;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Integer getBountyAmount() {
        return bountyAmount;
    }

    public void setBountyAmount(Integer bountyAmount) {
        this.bountyAmount = bountyAmount;
    }

    public Integer getBountyClosesDate() {
        return bountyClosesDate;
    }

    public void setBountyClosesDate(Integer bountyClosesDate) {
        this.bountyClosesDate = bountyClosesDate;
    }

    public Integer getAcceptedAnswerId() {
        return acceptedAnswerId;
    }

    public void setAcceptedAnswerId(Integer acceptedAnswerId) {
        this.acceptedAnswerId = acceptedAnswerId;
    }

    public MigratedFrom getMigratedFrom() {
        return migratedFrom;
    }

    public void setMigratedFrom(MigratedFrom migratedFrom) {
        this.migratedFrom = migratedFrom;
    }

}