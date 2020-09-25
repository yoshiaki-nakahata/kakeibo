package controllers;

import java.io.IOException;
import java.sql.Date;
import java.sql.Timestamp;
import java.util.List;

import javax.persistence.EntityManager;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import models.Kakeibo;
import models.validators.KakeiboValidator;
import utils.DBUtil;

/**
 * Servlet implementation class CreateServlet
 */
@WebServlet("/create")
public class CreateServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public CreateServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

    /**
     * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String _token = (String)request.getParameter("_token");
        if(_token != null && _token.equals(request.getSession().getId())) {
            EntityManager em = DBUtil.createEntityManager();

            Kakeibo k = new Kakeibo();



            Date kakeibo_date = new Date(System.currentTimeMillis());
            String rd_str = request.getParameter("kakeibo_date");
            if(rd_str != null && !rd_str.equals("")) {
                kakeibo_date = Date.valueOf(request.getParameter("kakeibo_date"));
            }
            k.setKakeibo_date(kakeibo_date);

            k.setSyokuhi(request.getParameter("syokuhi"));
            k.setNitiyouhin(request.getParameter("nitiyouhin"));
            k.setKousai(request.getParameter("kousai"));
            k.setBiyou(request.getParameter("biyou"));
            k.setKoutuu(request.getParameter("koutuu"));
            k.setIryou(request.getParameter("iryou"));
            k.setTuusin(request.getParameter("tuusin"));
            k.setSuidou(request.getParameter("suidou"));
            k.setGasu(request.getParameter("gasu"));
            k.setDenki(request.getParameter("denki"));
            k.setYatin(request.getParameter("yatin"));
            k.setZeikin(request.getParameter("zeikin"));
            k.setHoken(request.getParameter("hoken"));
            k.setSonota(request.getParameter("sonota"));



            Timestamp currentTime = new Timestamp(System.currentTimeMillis());
            k.setCreated_at(currentTime);
            k.setUpdated_at(currentTime);

            List<String> errors = KakeiboValidator.validate(k);
            if(errors.size() > 0) {
                em.close();

                request.setAttribute("_token", request.getSession().getId());
                request.setAttribute("kakeibo", k);
                request.setAttribute("errors", errors);

                RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/views/kakeibos/new.jsp");
                rd.forward(request, response);
            } else {
                em.getTransaction().begin();
                em.persist(k);
                em.getTransaction().commit();
                em.close();
                request.getSession().setAttribute("flush", "登録が完了しました。");

                response.sendRedirect(request.getContextPath() + "/index");
            }
        }
    }

}