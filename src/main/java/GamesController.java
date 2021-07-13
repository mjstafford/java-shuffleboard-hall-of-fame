import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.commons.beanutils.BeanUtils;

@WebServlet(urlPatterns = {"/games/new", "/games"})
public class GamesController extends HttpServlet {

  @Override
  protected void doGet(HttpServletRequest req, HttpServletResponse resp)
      throws IOException, ServletException {

    if(req.getServletPath().equals("/games/new")) {
      RequestDispatcher dispatcher = req.getRequestDispatcher("/views/games/new.jsp");
      dispatcher.forward(req, resp);
    }
    else if(req.getServletPath().equals("/games")) {
      EntityManagerFactory emf = getEMF();
      EntityManager em = emf.createEntityManager();

      GameService service = new GameService(em);
      List<Game> games = service.findAll();

      System.out.println("games: " + games);
      req.setAttribute("games",games);

      RequestDispatcher dispatcher = req.getRequestDispatcher("/views/games/index.jsp");
      dispatcher.forward(req, resp);
    }
  }

  @Override
  protected void doPost(HttpServletRequest req, HttpServletResponse resp)
      throws IOException, ServletException {
    if(req.getServletPath().equals("/games")){
      Game game = new Game();
      try {
        BeanUtils.populate(game, req.getParameterMap());
      } catch (IllegalAccessException e) {
        e.printStackTrace();
      } catch (InvocationTargetException e) {
        e.printStackTrace();
      }
      EntityManagerFactory emf = getEMF();
      EntityManager em = emf.createEntityManager();

      GameService service = new GameService(em);

      //save it to db
      if(!service.save(game)) {
        System.out.println("File didn't save");
        resp.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
        em.close();
      } else {
        em.close();
        resp.sendRedirect("/games/new");
      }
    }
  }

  private EntityManagerFactory getEMF(){
    return (EntityManagerFactory) this.getServletContext().getAttribute("emf");
  }
}
