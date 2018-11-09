package mx.unam.ciencias.is.sistemacolaborativo.mapeobd;
// Generated 21/10/2018 07:40:03 PM by Hibernate Tools 4.3.1


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * Resena generated by hbm2java
 */
@Entity
@Table
public class Resena  implements java.io.Serializable {


    @Id@GeneratedValue(strategy =GenerationType.IDENTITY ) 
    @Column(name="idresena")
     private int idresena;
    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="fk_id_usuario")
     private Usuario fk_id_usuario;
    @Column(name="comentario")
     private String comentario;
    @Column(name="calificacion")
     private int calificacion;

    public Resena() {
    }

	
    public Resena(int idresena, Usuario fk_id_usuario, int calificacion) {
        this.idresena = idresena;
        this.fk_id_usuario = fk_id_usuario;
        this.calificacion = calificacion;
    }
    public Resena(int idresena, Usuario fk_id_usuario, String comentario, int calificacion) {
       this.idresena = idresena;
       this.fk_id_usuario = fk_id_usuario;
       this.comentario = comentario;
       this.calificacion = calificacion;
    }
   
    public int getIdresena() {
        return this.idresena;
    }
    
    public void setIdresena(int idresena) {
        this.idresena = idresena;
    }

    public Usuario getUsuario() {
        return this.fk_id_usuario;
    }
    
    public void setUsuario(Usuario fk_id_usuario) {
        this.fk_id_usuario = fk_id_usuario;
    }

    
    public String getComentario() {
        return this.comentario;
    }
    
    public void setComentario(String comentario) {
        this.comentario = comentario;
    }

    
    public int getCalificacion() {
        return this.calificacion;
    }
    
    public void setCalificacion(int calificacion) {
        this.calificacion = calificacion;
    }




}


