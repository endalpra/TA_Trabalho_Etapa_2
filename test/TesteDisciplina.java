
import br.edu.ifsul.modelo.Disciplina;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class TesteDisciplina {

    EntityManagerFactory emf;
    EntityManager em;

    public TesteDisciplina() {

    }

    @Before
    public void setUp() {
        emf = Persistence.createEntityManagerFactory("TA_Trabalho_Etapa_2-ModelPU");
        em = emf.createEntityManager();
    }

    @After
    public void tearDown() {
        em.close();
        emf.close();
    }

    @Test
    public void testeDisciplina() {
        boolean exception = false;
        try {
            Disciplina d = new Disciplina();
            d.setNome("TA");
            d.setCreditos(5);
            em.getTransaction().begin();
            em.persist(d);
            em.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
            exception = true;

        }
        // verificando se o resultado é igual ao esperado
        Assert.assertEquals(false, exception);
    }

}
