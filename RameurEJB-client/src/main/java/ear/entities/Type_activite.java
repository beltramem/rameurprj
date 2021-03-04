package ear.entities;


import java.io.Serializable;


import javax.persistence.*;



public class Type_activite implements Serializable {



    //private static final long serialVersionUID = 0l;

    private String id;

    private String nom;

    private String description;



    public String getId() {

        return id;

    }



    public String getNom() {

        return nom;

    }



    public String getDescription() {

        return description;

    }



    public void setId(String id) {

        this.id = id;

    }



    public void setNom(String nom) {

        this.nom = nom;

    }



    public void setDescription(String description) {

        this.description = description;

    }



    public Type_activite(String id, String nom, String description) {

        this.id = id;

        this.nom = nom;

        this.description = description;

    }



    public Type_activite() {

    }







}