import java.util.List;
import java.util.Set;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;

public class GameService {
  private EntityManager em;

  public GameService(EntityManager em) {
    this.em = em;
  }

  public boolean save(Game game){
    //probably should move validate to controller level
    //would make it easier to figure out how to handle non-valid entries prior to attempting to save
    ValidatorFactory vf = Validation.buildDefaultValidatorFactory();
    Validator validator = vf.getValidator();
    Set<ConstraintViolation<Game>> violations = validator.validate(game);
    if (violations.size() > 0) {
      for (ConstraintViolation<Game> violation : violations) {
        System.out.println(violation.getPropertyPath() + ": " + violation.getMessage());
      }
      return false;
    } else {
      try{
        em.getTransaction().begin();
        em.persist(game);
        em.getTransaction().commit();
        System.out.println("committed the record!");
        return true;
      } catch (Exception ex){
        em.getTransaction().rollback();
        return false;
      }
    }
  }

  public List<Game> findAll(){
    TypedQuery<Game> query = em.createQuery("SELECT g FROM Game g", Game.class);
    List<Game> games = query.getResultList();
    System.out.println(games.toString());
    return games;
  }
}
