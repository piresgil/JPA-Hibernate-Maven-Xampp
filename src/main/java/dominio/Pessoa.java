/**
 * @author Daniel Gil
 */
package dominio;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.io.Serializable;

/**
 * Represents a person entity.
 * This class is annotated with JPA annotations to map it to a database table.
 */
@Entity
public class Pessoa implements Serializable {
    // Variables

    /**
     * Unique identifier for the person.
     * This field is the primary key and its value is generated automatically by the database.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String nome;
    private String email;

    /**
     * Default constructor for the Pessoa class.
     * It initializes a new empty Pessoa object.
     */
    public Pessoa() {

    }

    /**
     * Constructor for the Pessoa class with specified id, name, and email.
     *
     * @param id    The unique identifier of the person.
     * @param nome  The name of the person.
     * @param email The email address of the person.
     */
    public Pessoa(Integer id, String nome, String email) {
        this.id = id;
        this.nome = nome;
        this.email = email;
    }

    /**
     * Retrieves the unique identifier of the person.
     *
     * @return The person's ID.
     */
    public Integer getId() {
        return id;
    }

    /**
     * Sets the unique identifier of the person.
     *
     * @param id The new ID for the person.
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * Retrieves the name of the person.
     *
     * @return The person's name.
     */
    public String getNome() {
        return nome;
    }

    /**
     * Sets the name of the person.
     *
     * @param nome The new name for the person.
     */
    public void setNome(String nome) {
        this.nome = nome;
    }

    /**
     * Retrieves the email address of the person.
     *
     * @return The person's email address.
     */
    public String getEmail() {
        return email;
    }

    /**
     * Sets the email address of the person.
     *
     * @param email The new email address for the person.
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * Returns a string representation of the Pessoa object.
     * This includes the person's ID, name, and email address.
     *
     * @return A string containing the details of the Pessoa object.
     */
    @Override
    public String toString() {
        return "Pessoa{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}
