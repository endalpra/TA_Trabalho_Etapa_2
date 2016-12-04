
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

/**
 *
 * @author jorge
 */
public class TestePesquisa {
    
    EntityManagerFactory emf;
    EntityManager em;
    
    public TestePesquisa() {
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
    public void teste(){
        boolean exception = false;
        try {
            Pesquisa obj = new Pesquisa();
            obj.setNome("Nome da pesquisa 2");
            obj.setData_inicio(Calendar.getInstance());
            obj.setData_termino(Calendar.getInstance());
            em.getTransaction().begin();
            em.persist(obj);
            em.getTransaction().commit();            
        } catch (Exception e){
            e.printStackTrace();
            exception = true;
        }
        Assert.assertEquals(false, exception);
        
    }
    
}
