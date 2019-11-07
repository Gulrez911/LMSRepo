import javax.persistence.EntityManager;
import javax.persistence.PersistenceException;

import org.hibernate.exception.SQLGrammarException;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:appContext.xml"})
public class TestJdBc {
	@Autowired
	EntityManager entityManager;
	
	@Test
	public void testQuery(){
		try {
			entityManager.createNativeQuery("select * from abs").getResultList();
		} catch (SQLGrammarException  e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());
			//System.out.println(e.getClass());
			//System.out.println("state "+((SQLException)e).getSQLState());
			//System.out.println("code "+((SQLException)e).getErrorCode());
		}
		catch(PersistenceException e){
			System.out.println(e.getCause().getMessage());
			SQLGrammarException e1 = (SQLGrammarException)e.getCause();
			System.out.println(e1.getSQLException().getMessage());
			System.out.println(e1.getSQLException().getLocalizedMessage());
			
		}
	}

}
