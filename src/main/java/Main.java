import dominio.Pessoa;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class Main {
    public static void main(String[] args){
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("exemplo-jpa");
        EntityManager em = emf.createEntityManager();

        Pessoa p1 = new Pessoa(null, "Carlos", "carlos@gmail.com");
        em.getTransaction().begin();
        em.persist(p1);
        em.getTransaction().commit();


        Pessoa p = em.find(Pessoa.class, 1);
        System.out.println(p);
        System.out.println(p1.getId());

        em.getTransaction().begin();//Sempre colocar um transaction quando a operacao nao e uma simples consulta
        em.remove(p);
        em.getTransaction().commit();
        
        em.close();
        emf.close();
        System.out.println("Finish");
    }

}
