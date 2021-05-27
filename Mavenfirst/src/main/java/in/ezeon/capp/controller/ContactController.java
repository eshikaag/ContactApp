package in.ezeon.capp.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import in.ezeon.capp.domain.Contact;
import in.ezeon.capp.service.ContactService;

@Controller
public class ContactController {
@Autowired
 private ContactService contactService;

    @RequestMapping(value = "/user/contact_form")
    public String contactForm(Model m) {
        Contact contact = new Contact();//from domain cls reuse
        m.addAttribute("command", contact);
        return "contact_form";//JSP form view
    }
    
    
//    @RequestMapping(value = "/user/save_contact")
//    public String saveOrUpdateContact(@ModelAttribute("command") Contact c, Model m, HttpSession session) {
//       
//            try {
//                Integer userId = (Integer) session.getAttribute("userId");
//         c.setUserid(userId);//FK ; logged in userId
//               contactService.save(c);
//               System.out.println("saved");
//               return "redirect:clist?act=sv";//redirect user to contact list url
//            } catch (Exception e) {
//                e.printStackTrace();
//                m.addAttribute("err", "Failed to save contact");
//                return "contact_form";
//            }
//        
//    }
//    
    
    
    @RequestMapping(value = "/user/save_contact")
    public String saveOrUpdateContact(@ModelAttribute("command") Contact c, Model m, HttpSession session) {
        Integer contactId = (Integer) session.getAttribute("aContactId");
        if (contactId == null) {
            //save task
            try {
                Integer userId = (Integer) session.getAttribute("userId");
                c.setUserid(userId);//FK ; logged in userId
                contactService.save(c);
                return "redirect:clist?act=sv";//redirect user to contact list url
            } catch (Exception e) {
                e.printStackTrace();
                m.addAttribute("err", "Failed to save contact");
                return "contact_form";
            }
        } else {
            //update task
            try {
                c.setContactid(contactId); //PK
                contactService.update(c);
                session.removeAttribute("aContactId");
                return "redirect:clist?act=ed";//redirect user to contact list url
            } catch (Exception e) {
                e.printStackTrace();
                m.addAttribute("err", "Failed to Edit contact");
                return "contact_form";
            }
        }
    }
    @RequestMapping(value = "/user/clist")
    public String contactList(Model m, HttpSession session) {
        Integer userId = (Integer) session.getAttribute("userId");
        m.addAttribute("contactList", contactService.findUserContact(userId));//used in clist
        //we added this contactlist att to model now can access all att of that userid using contactlist in clist
        return "clist"; //JSP
    }
    
    @RequestMapping(value = "/user/del_contact")//In Spring MVC, the @RequestParam annotation is used to read the form data and bind it automatically to the parameter present in the provided method. So, it ignores the requirement of HttpServletRequest object to read the provided data.
    
    public String deleteContact(@RequestParam("cid") Integer contactId) {
        contactService.delete(contactId);
        return "redirect:clist?act=del";
    }
    
    
    @RequestMapping(value = "/user/edit_contact")
    public String prepareEditForm(Model m, HttpSession session, @RequestParam("cid") Integer contactId) {
        session.setAttribute("aContactId", contactId);
        Contact c = contactService.findById(contactId);
        m.addAttribute("command", c);
        return "contact_form";//JSP form view
    }
    
    
    
    
    

    @RequestMapping(value = "/user/contact_search")
    public String contactSearch(Model m, HttpSession session, @RequestParam("freeText") String freeText) {
        Integer userId = (Integer) session.getAttribute("userId");
        m.addAttribute("contactList", contactService.findUserContact(userId, freeText));
        return "clist"; //JSP
    }
    
    
//    @RequestMapping(value = "/user/bulk_cdelete")
//    public String deleteBulkContact(@RequestParam("cid") Integer[] contactIds) {
//        contactService.delete(contactIds);
//        return "redirect:clist?act=del";
//    }
}
