package com.example.jpacrud.cafe;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "cafe")
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Cafe {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @NonNull
    private String name;
    @Column(name = "map_x")
    private Double mapX;
    @Column(name = "map_y")
    private Double mapY;
    private String site;
    private String note;

    public void updateCafeName(String name) {
        this.name = name;
    }
}
