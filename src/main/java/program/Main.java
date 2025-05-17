/**
 * @author Daniel Gil
 */
package program;

import dominio.Pessoa;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.logging.Level;
import java.util.logging.LogManager;
import java.util.logging.Logger;

public class Main {
    public static void main(String[] args) {

        // Reset dos logs antes de qualquer uso do Hibernate
        LogManager.getLogManager().reset();

        // Define o nível do logger raiz para WARNING
        Logger rootLogger = Logger.getLogger("");
        rootLogger.setLevel(Level.WARNING);
        for (var handler : rootLogger.getHandlers()) {
            handler.setLevel(Level.WARNING);
        }

        // Define níveis específicos do Hibernate para WARNING ou SEVERE
        Logger.getLogger("org.hibernate").setLevel(Level.WARNING);
        Logger.getLogger("org.hibernate.engine.jdbc.connections.internal.DriverManagerConnectionProviderImpl").setLevel(Level.SEVERE);
        Logger.getLogger("org.hibernate.service").setLevel(Level.WARNING);
        Logger.getLogger("org.hibernate.jpa.internal.util.LogHelper").setLevel(Level.WARNING);
        Logger.getLogger("org.hibernate.Version").setLevel(Level.WARNING);
        Logger.getLogger("org.hibernate.annotations").setLevel(Level.WARNING);
        Logger.getLogger("org.hibernate.dialect").setLevel(Level.WARNING);
        Logger.getLogger("org.hibernate.resource.transaction").setLevel(Level.WARNING);
        Logger.getLogger("org.hibernate.engine.transaction").setLevel(Level.WARNING);

        System.out.println("JPA - Hibernate - Maven - Xampp");

        // cria uma persistência com o persistence.xml, para cria conexão háa DB
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("exemplo-jpa");
        EntityManager em = emf.createEntityManager(); // instancia a persistência através do factory

        // Inserir dados na DB
        Pessoa p1 = new Pessoa(null, "Daniel", "Daniel@Daniel");
        Pessoa p2 = new Pessoa(null, "Ana", "Ana@Ana");
        Pessoa p3 = new Pessoa(null, "Elisa", "Elisa@Elisa");
        Pessoa p4 = new Pessoa(null, "Francisca", "Francisca@Francisca");
        Pessoa p5 = new Pessoa(null, "Bernardo", "Bernardo@Bernardo");


        em.getTransaction().begin(); // inicia a transação com a DB
        em.persist(p1); // Coloca o obj na DB
        em.persist(p2);
        em.persist(p3);
        em.persist(p4);
        em.persist(p5);
        em.getTransaction().commit(); // confirma alterações
        System.out.println("* Dados inseridos * ("+ p1.getNome()+", "+ p2.getNome()+", "+ p3.getNome()+", "+ p4.getNome()+", "+ p5.getNome()+")");

        // Consultar dados
        Pessoa p = em.find(Pessoa.class, 2); // consulta DB pelo indice 2
        System.out.println("Consulta: " + p.getNome());

        // Apagar dados
        em.getTransaction().begin(); // inicia a transação com a DB
        em.remove(p); // apaga pessoa da DB pelo indice 2
        em.getTransaction().commit(); // confirma alterações
        System.out.println("Removido: " + p.getNome());

        em.close();
        emf.close();
    }
}