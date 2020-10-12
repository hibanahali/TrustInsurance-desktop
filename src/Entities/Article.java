/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entities;

/**
 *
 * @author acer hiba
 */
public class Article {
    
    private int id;
    private String titre;
    private String text;
    private String image;
    private int likes;

    public Article(int id, String titre, String text, int likes) {
        this.id = id;
        this.titre = titre;
        this.text = text;
        this.likes = likes;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public Article(int id, String titre, String text, String image, int likes) {
        this.id = id;
        this.titre = titre;
        this.text = text;
        this.image = image;
        this.likes = likes;
    }

    public Article() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitre() {
        return titre;
    }

    public void setTitre(String titre) {
        this.titre = titre;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public int getLikes() {
        return likes;
    }

    public void setLikes(int likes) {
        this.likes = likes;
    }

    @Override
    public String toString() {
        return "Article{" + "id=" + id + ", titre=" + titre + ", text=" + text + ", likes=" + likes + '}';
    }
    
    
}
