package controller;



import model.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.FlashMap;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import service.ICustomerService;

@Controller
@RequestMapping("/customers")
public class CustomerController {
    @Autowired
    private ICustomerService iCustomerService;
    @PostMapping
    public ModelAndView saveCustomer(@ModelAttribute Customer customer,RedirectAttributes redirectAttributes){
        ModelAndView modelAndView=new ModelAndView("redirect:/customers/create");
        iCustomerService.save(customer);
        redirectAttributes.addFlashAttribute("message","create success "+customer.getName());
        return modelAndView;
    }
    @GetMapping
    public ModelAndView showList(){
        ModelAndView modelAndView=new ModelAndView("list");
        modelAndView.addObject("customers",iCustomerService.findAll());
        return modelAndView;
    }
    @GetMapping("/create")
    public ModelAndView showCustomer(){
        ModelAndView modelAndView=new ModelAndView("create");
        modelAndView.addObject("customer",new Customer());
        return modelAndView;
    }
    @GetMapping("/{id}/delete")
    public ModelAndView showDeleteInformation(@PathVariable Long id){
        ModelAndView modelAndView=new ModelAndView("delete");
        modelAndView.addObject("customer",iCustomerService.findByID(id));
        return modelAndView;
    }
    @PostMapping("/{id}/delete")
    public ModelAndView deleteUser(@PathVariable Long id,RedirectAttributes redirectAttributes){
        redirectAttributes.addFlashAttribute("message","delete success user '"+
                                               iCustomerService.findByID(id).getName()+"'");
        iCustomerService.remove(id);
        ModelAndView modelAndView=new ModelAndView("redirect:/customers");
        return modelAndView;
    }
    @GetMapping("/{id}/edit")
    public ModelAndView showEdit(@PathVariable Long id){
        ModelAndView modelAndView= new ModelAndView("edit");
        modelAndView.addObject("customer",iCustomerService.findByID(id));
        return modelAndView;
    }
    @PostMapping("/{id}/edit")
    public ModelAndView edit(@ModelAttribute Customer customer,@PathVariable Long id, RedirectAttributes redirectAttributes){
        customer.setId(id);
        iCustomerService.update(customer);
        redirectAttributes.addFlashAttribute("customer",customer);
        redirectAttributes.addFlashAttribute("message","edit success "+customer.getName()+".");
        ModelAndView modelAndView= new ModelAndView("redirect:/customers/"+customer.getId()+"/edit");
        return modelAndView;
    }
}
