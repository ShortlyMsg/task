package com.example.task.entity;

import com.sun.istack.NotNull;
import lombok.*;

import javax.persistence.*;
import java.time.LocalDateTime;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Data
@Entity
//@Table(name ="work_items")
public class WorkItem {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private LocalDateTime created;

    private String title;

    private String description;

    @NotNull
    private boolean resolved;

    public void setTitle(String title) {
        this.title = title;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setResolved(boolean resolved) {
        this.resolved = resolved;
    }
}
