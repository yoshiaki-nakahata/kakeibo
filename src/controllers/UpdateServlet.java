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
 * Servlet implementation class UpdateServlet
 */
@WebServlet("/update")
public class UpdateServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateServlet() {
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

            Kakeibo k = em.find(Kakeibo.class, (Integer)(request.getSession().getAttribute("kakeibo_id")));

            k.setKakeibo_date(Date.valueOf(request.getParameter("kakeibo_date")));
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




            k.setUpdated_at(new Timestamp(System.currentTimeMillis()));

            List<String> errors = KakeiboValidator.validate(k);
            if(errors.size() > 0) {
                em.close();

                request.setAttribute("_token", request.getSession().getId());
                request.setAttribute("kakeibo", k);
                request.setAttribute("errors", errors);

                RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/views/kakeibos/edit.jsp");
                rd.forward(request, response);
            } else {
                em.getTransaction().begin();
                em.getTransaction().commit();
                em.close();
                request.getSession().setAttribute("flush", "更新が完了しました。");

                request.getSession().removeAttribute("kakeibo_id");

                response.sendRedirect(request.getContextPath() + "/index");
            }
        }
    }

}

