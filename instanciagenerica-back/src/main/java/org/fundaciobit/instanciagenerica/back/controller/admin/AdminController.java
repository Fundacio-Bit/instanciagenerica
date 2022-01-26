package org.fundaciobit.instanciagenerica.back.controller.admin;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * 
 * @author anadal
 *
 */
@Controller
@RequestMapping(value = "/admin/")
public class AdminController {

  
  @RequestMapping(value = "/option1")
  public ModelAndView option1(HttpSession session,
      HttpServletRequest request, HttpServletResponse response)
      throws Exception {
    
    ModelAndView mav = new ModelAndView("option1Admin");
    mav.addObject("optionNumber", "OPCIÓ ADMIN -1-");
    return mav;
    
  }
  
  
  @RequestMapping(value = "/option2")
  public ModelAndView option2(HttpSession session,
      HttpServletRequest request, HttpServletResponse response)
      throws Exception {
    
    ModelAndView mav = new ModelAndView("option2Admin");
    mav.addObject("optionNumber", "OPCIÓ ADMIN -2-");
    return mav;
  }
  

  @RequestMapping(value = "/option3")
  public ModelAndView option3(HttpSession session,
      HttpServletRequest request, HttpServletResponse response)
      throws Exception {
    
    ModelAndView mav = new ModelAndView("option3Admin");
    mav.addObject("optionNumber", "OPCIÓ ADMIN -3- (Pau's option)");
    return mav;
  }

}
