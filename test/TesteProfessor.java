import br.edu.ifsul.modelo.Pesquisa;
import br.edu.ifsul.modelo.Professor;
import java.util.Calendar;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Jorge
 */
public class TesteProfessor {
    
  EntityManagerFactory emf;
    EntityManager em;
    

    public TesteProfessor() {

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
    public void testePersistirPais() {
        boolean exception = false;
        try {
            Professor obj = new Professor();
            obj.setNome("João");
            obj.setCarga_horaria(60);
            obj.setPesquisa(em.find(Pesquisa.class, 1));
            obj.setNome("Jorge Bavaresco");
            em.getTransaction().begin();
            em.persist(obj);
            em.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
            exception = true;
            
        }
        // verificando se o resultado é igual ao esperado
        Assert.assertEquals(false, exception);
    }
    
}
