package com.test.application.web;

import com.test.application.data.models.Project;
import com.test.application.exception.ProjectNotFoundException;
import com.test.application.service.ProjectCategoryService;
import com.test.application.service.ProjectService;
import com.test.application.service.impl.ProjectServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

/**
 * @author invzbl3 on 12/29/2022
 * @project RestApiApplication
 */
@Controller
public class AdminController {

    @Autowired
    ProjectServiceImpl projectServiceImpl;

    @Autowired
    ProjectService projectService;

    @Autowired
    ProjectCategoryService categoryService;

    @GetMapping("/admin/project/add")
    public ModelAndView addView() {
        ModelAndView modelAndView = new ModelAndView("admin/project/add");
        modelAndView.addObject("pcList", categoryService.get());
        modelAndView.addObject("command", new Project());
        return modelAndView;
    }

    @PostMapping("/admin/project/add")
    public String add(@ModelAttribute("command")
                          @Valid Project project,
                          BindingResult result,
                          Model model,
                          final RedirectAttributes redirectAttributes) {
        if(result.hasErrors()) {
            model.addAttribute("pcList", categoryService.get());
            return "admin/project/add";
        }
        projectService.save(project);
        redirectAttributes.addFlashAttribute("msg", "Project added successfully");
        redirectAttributes.addFlashAttribute("class", "alert-success");
        return "redirect:/admin/project/add";
    }

    @GetMapping("/admin/project/list")
    public ModelAndView list() {
        List<Project> projectList = projectServiceImpl.get();
        ModelAndView modelAndView = new ModelAndView("/admin/project/list");
        modelAndView.addObject("projectList", projectList);
        return modelAndView;
    }

    @GetMapping("/admin/project/delete")
    public String list(@RequestParam("id") long id,
                       final RedirectAttributes redirectAttributes) {
        projectService.delete(id);
        redirectAttributes.addFlashAttribute("msg", "Project deleted successfully");
        redirectAttributes.addFlashAttribute("class", "alert-success");
        return "redirect:/admin/project/list";
    }

    @GetMapping("/admin/project/update")
    public ModelAndView updateView(long id) throws ProjectNotFoundException {
        Optional<Project> optional = projectService.findById(id);
        Project product = optional.get();
        ModelAndView modelAndView = new ModelAndView("admin/project/add");
        modelAndView.addObject("command", product);
        modelAndView.addObject("pcList", categoryService.get());
        return modelAndView;
    }

    @PostMapping("/admin/project/update")
    public String updateView(@ModelAttribute("command") @Valid Project project,
                             BindingResult result,
                             Model model,
                             final RedirectAttributes redirectAttributes) {
        if(result.hasErrors()) {
            model.addAttribute("pcList", categoryService.get());
            return "admin/project/add";
        }
        productService.save(project);
        redirectAttributes.addFlashAttribute("msg", "Project Updated successfully");
        redirectAttributes.addFlashAttribute("class", "alert-success");
        return "redirect:/admin/project/list";
    }

    @GetMapping("/admin/project/report")
    public ModelAndView report() {
        ModelAndView modelAndView = new ModelAndView("admin/project/report");
        modelAndView.addObject("pList", productService.get());
        return modelAndView;
    }
}