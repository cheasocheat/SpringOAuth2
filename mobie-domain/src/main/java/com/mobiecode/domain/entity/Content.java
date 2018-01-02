package com.mobiecode.domain.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.mobiecode.domain.base.BaseEntity;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;

@Entity
@Table(name = "tb_content")
@EntityListeners(AuditingEntityListener.class)
@JsonIgnoreProperties(value = {"createdAt", "updatedAt"}, allowGetters = true)
public class Content extends BaseEntity {
    private String title;
    private String titleEn;
    private String description;
    private String descriptionEn;


    @Override
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "con_id", nullable = false, unique = true)
    public Long getId() {
        return id;
    }

    @Column(name = "con_title")
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @Column(name = "con_title_en")
    public String getTitleEn() {
        return titleEn;
    }

    public void setTitleEn(String titleEn) {
        this.titleEn = titleEn;
    }

    @Column(name = "con_desc")
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Column(name = "con_desc_en")
    public String getDescriptionEn() {
        return descriptionEn;
    }

    public void setDescriptionEn(String descriptionEn) {
        this.descriptionEn = descriptionEn;
    }
}