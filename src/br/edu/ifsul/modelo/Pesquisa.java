package br.edu.ifsul.modelo;

import java.io.Serializable;
import java.util.Calendar;
import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotBlank;

/**
 *
 * @author Érico
 */
@Entity
@Table(name="pequisa")
public class Pesquisa implements Serializable{
     @Id
    @SequenceGenerator(name = "seq_pesquisa", sequenceName = "seq_pesquisa_id", 
            allocationSize = 1)
    @GeneratedValue(generator = "seq_pesquisa", strategy = GenerationType.SEQUENCE)
    private Integer id;
    @NotBlank(message = "O nome não pode ser em branco")
    @NotNull(message = "O nome não pode ser nulo")
    @Length(max = 50, message = "O nome não pode ter mais que {max} caracteres")
    @Column(name = "nome", length = 50, nullable = false)
    private String nome;
    @NotNull(message = "A data de início não pode ser nula")
    @Temporal(TemporalType.DATE)
    @Column(name = "data_inicio", nullable = false)
    private Calendar data_inicio;
    @NotNull(message = "A data de término não pode ser nula")
    @Temporal(TemporalType.DATE)
    @Column(name = "data_termino", nullable = false)
    private Calendar data_termino;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Calendar getData_inicio() {
        return data_inicio;
    }

    public void setData_inicio(Calendar data_inicio) {
        this.data_inicio = data_inicio;
    }

    public Calendar getData_termino() {
        return data_termino;
    }

    public void setData_termino(Calendar data_termino) {
        this.data_termino = data_termino;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 53 * hash + Objects.hashCode(this.id);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Pesquisa other = (Pesquisa) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        return true;
    }
    
}
