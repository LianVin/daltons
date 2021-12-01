package com.daltons.backend.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.sun.istack.NotNull;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.dom4j.Text;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

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

    @CreationTimestamp
    @NotNull
    @CreationTimestamp
    private Date createdAt;

    @OneToMany(mappedBy = "commentId")
    private List<Comment> comments;

    @OneToMany(mappedBy = "pictureId")
    private List<Picture> picutres;

    @ManyToOne
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    @JoinColumn(name = "USER_ID")
    private User userId;
}
