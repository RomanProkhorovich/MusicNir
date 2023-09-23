package com.example.MusicNir.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.LinkedHashSet;
import java.util.Set;

@Entity
@Getter
@Setter
public class User {
    @Id
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(unique = true, nullable = false)
    private String username;
    @Column(nullable = false)
    private String password;
    private String name;

    @ManyToMany(cascade = CascadeType.MERGE)
    @JoinTable(name = "Author_songs",
            joinColumns = @JoinColumn(name = "author_id"),
            inverseJoinColumns = @JoinColumn(name = "songs_id"))
    private Set<Song> favoriteSongs = new LinkedHashSet<>();

    @ManyToMany
    @JoinTable(name = "Author_playlists",
            joinColumns = @JoinColumn(name = "author_id"),
            inverseJoinColumns = @JoinColumn(name = "playlists_id"))
    private Set<Playlist> favoritePlaylists = new LinkedHashSet<>();

    @ManyToMany
    @JoinTable(name = "User_albums",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "albums_id"))
    private Set<Album> albums = new LinkedHashSet<>();

}
