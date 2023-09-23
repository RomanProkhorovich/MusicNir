package com.example.MusicNir.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.LinkedHashSet;
import java.util.Set;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Album {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(nullable = false)
    private String title;

    @OneToOne(orphanRemoval = true)
    @JoinColumn(name = "author_id")
    private User user;

    @OneToMany
    @JoinColumn(name = "album_id")
    private Set<Song> songs = new LinkedHashSet<>();



}
