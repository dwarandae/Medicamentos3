/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BusinessLogic.Services;

import Presentation.Beans.SessionBean;
import java.io.IOException;
import javax.enterprise.inject.spi.Bean;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author omdej
 * Class inactive and set for future use. Check filters mapping in web.xml.
 */
public class AuthorizationFilter implements Filter {
    
    private FilterConfig filterConfig = null;

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        this.filterConfig = filterConfig;
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        HttpServletRequest req = (HttpServletRequest) request;
        HttpSession session = req.getSession(false);
        HttpServletResponse res = (HttpServletResponse) response;
        boolean goingToLogin = req.getRequestURI().contains("login.xhtml"),
                goingToRegistration = req.getRequestURI().contains("createCustomerAccount.xhtml"),
                goingToIndex = req.getRequestURI().contains("index.xhtml");
        if(session != null && !session.isNew() && session.getAttribute("sessionBean") != null) {
            SessionBean sessionBean = (SessionBean) session.getAttribute("sessionBean");
            if (sessionBean.isLoggedIn() && !goingToLogin && !goingToRegistration) {
                chain.doFilter(request, response);
            } else if (sessionBean.isLoggedIn()) {
                res.sendRedirect("/Medicamentos3/faces/index.xhtml");
            } else if (!goingToLogin) {
                res.sendRedirect("/Medicamentos3/faces/login.xhtml");
            } else {
                chain.doFilter(request, response);
            }
        } else {
            if (!goingToLogin && !goingToRegistration && !goingToIndex) {
                res.sendRedirect("/Medicamentos3/faces/login.xhtml");
            } else {
                chain.doFilter(request, response);
            }
        }
    }

    @Override
    public void destroy() {}
    
}
