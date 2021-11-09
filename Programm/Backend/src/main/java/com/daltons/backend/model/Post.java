package com.daltons.backend.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.sun.istack.NotNull;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.dom4j.Text;

import javax.persistence.*;
import java.util.Date;

@Entity
@Getter
@Setter
@Table(name = "post")
@NoArgsConstructor
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
@ToString
public class Post {
    @Id
    @Column(name = "POST_ID", nullable = false)
    private int postId;

    @NotNull
    private String title;

    @NotNull
    private String text;

    @NotNull
    private boolean isConcert;

    @NotNull
    private Date createdAt;

    @ManyToOne
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    @JoinColumn(name = "USER_ID")
    private User userId;
}
