package com.indhio.roo.conference.domain;

import javax.persistence.ManyToOne;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import org.springframework.roo.addon.javabean.RooJavaBean;
import org.springframework.roo.addon.jpa.activerecord.RooJpaActiveRecord;
import org.springframework.roo.addon.tostring.RooToString;

@RooJavaBean
@RooToString
@RooJpaActiveRecord
public class Talk {

    @NotNull
    private String title;

    @NotNull
    @Size(max = 4000)
    private String description;

    @NotNull
    @ManyToOne
    private Speaker speaker;
}
