
import br.edu.ifsul.modelo.Aluno;
import br.edu.ifsul.modelo.Disciplina;
import br.edu.ifsul.modelo.Pesquisa;
import java.util.Calendar;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class TestePersistirAluno {
    
  EntityManagerFactory emf;
    EntityManager em;
    

    public TestePersistirAluno() {

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
            Aluno obj = new Aluno();
            obj.setNome("Pedro");
            obj.setEndereco("R. das Jabuticabas");
            obj.setData_ingresso(Calendar.getInstance());
            obj.setMatricula(123456789);
            obj.setPesquisa(em.find(Pesquisa.class, 1));
            Disciplina d = em.find(Disciplina.class, 1);
            obj.getDisciplinas().add(d);
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
