/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entities;

import java.util.Date;


/**
 *
 * @author acer hiba
 */
public class Evennement {
    private int id;
    private String titre;
    private String description;
    private String image;
    private int participants ;
    private Date last_modification;
    private Date due_date;
    private Date start_date;
    
    
    
    

    public Evennement(int id, String titre, String description, String image, int participants, Date last_modification, Date due_date, Date start_date) {
        this.id = id;
        this.titre = titre;
        this.description = description;
        this.image = image;
        this.participants = participants;
        this.last_modification = last_modification;
        this.due_date = due_date;
        this.start_date = start_date;
        
    }
   
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    
    
    public Date getStart_date() {
        return start_date;
    }

    public void setStart_date(Date start_date) {
        this.start_date = start_date;
    }

    
    
    public Date getDue_date() {
        return due_date;
    }

    public Evennement() {
    }
    

    public void setDue_date(Date due_date) {
        this.due_date = due_date;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getParticipants() {
        return participants;
    }

    public void setParticipants(int participants) {
        this.participants = participants;
    }

    public String getTitre() {
        return titre;
    }

    public void setTitre(String titre) {
        this.titre = titre;
    }

    public Date getLast_modification() {
        return last_modification;
    }

    public void setLast_modification(Date last_modification) {
        this.last_modification = last_modification;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String Image) {
        this.image = Image;
    }

   
    
    
}

