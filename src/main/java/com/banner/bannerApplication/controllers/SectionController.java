package com.banner.bannerApplication.controllers;

import com.banner.bannerApplication.entities.*;
import com.banner.bannerApplication.repositories.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import org.springframework.web.servlet.ModelAndView;
import java.time.LocalDateTime;

import java.text.ParseException;
import java.time.LocalDateTime;

@Controller
@RequestMapping("section")

public class SectionController {

    @Autowired
    private SectionRepository sectionRepository;
    @Autowired
    private CourseRepository courseRepository;
    @Autowired
    private ProfessorRepository professorRepository;
    @Autowired
    private RoomsRepository roomsRepository;
    @Autowired
    private UserRepository userRepository;

    // Create
    // Section Controllers
    @RequestMapping(method = RequestMethod.POST)
    public ModelAndView addSection(@RequestParam Long courseId, @RequestParam Long sectionNumber,
                                   @RequestParam Long professorId, @RequestParam Long roomId,
                                   @RequestParam Long userId,
                                   @RequestParam String startDate, @RequestParam String endDate,
                                   @RequestParam String startTime, @RequestParam String endTime,
                                   @RequestParam String classDate) throws ParseException {

        Course course = courseRepository.findOne(courseId);
        Professor professor = professorRepository.findOne(professorId);
        User user = userRepository.findOne(userId);
        Rooms room = roomsRepository.findOne(roomId);

        Section n = new Section();
        n.setSectionNumber(sectionNumber);
        n.setCourse(course);
        n.setProfessor(professor);
        n.setUser(user);
        n.setRoom(room);
        n.setStartDate(startDate);
        n.setEndDate(endDate);
        n.setStartTime(startTime);
        n.setEndTIme(endTime);
        n.setClassDate(classDate);
        sectionRepository.save(n);
        return new ModelAndView("redirect:/faculty/view/" + courseId);
    }

    @GetMapping(path="/add/{id}")
    public String createSection(@PathVariable Long id, Model model) {
        Course course = courseRepository.findOne(id);

        Iterable<Professor> professors = professorRepository.findAll();
        if (professors == null) {
            System.out.println(" Is it Null?");
        }
        Iterable<Rooms> allRooms = roomsRepository.findAll();
        Iterable<User> users = userRepository.findAll();

        model.addAttribute("allRooms", allRooms);
        model.addAttribute("professors", professors);
        model.addAttribute("course", course);
        model.addAttribute("users", users);
        return "create-section";
    }

    // Delete
    //needs to be fixed
    @GetMapping(path="/delete/{id}")
    public ModelAndView RemoveSection(@PathVariable Long id) {
        Section section = sectionRepository.findOne(id);
        Long courseId = section.getCourse().getCourseId();

        sectionRepository.delete(id);
        return new ModelAndView("redirect:/faculty/view/"+ courseId);
    }

    // Read All
    @GetMapping(path="")
    public String showall(Model model) {
        Iterable<Section> allsections = sectionRepository.findAll();
        model.addAttribute("allsections", allsections);
        return "sectionpage";
    }

    // UPDATE page
    @GetMapping(path="/update/{id}")
    public String updateSection(@PathVariable Long id,
                               Model model) {

        Section section = sectionRepository.findOne(id);
        Iterable<Professor> professors = professorRepository.findAll();
        Iterable<User> users = userRepository.findAll();

        model.addAttribute("section", section);
        model.addAttribute("professors", professors);
        model.addAttribute("users", users);
        return "update-section";
    }

    // UPDATE section
    @GetMapping(path="/update")
    public ModelAndView updateCourse(@RequestParam Long sectionId, @RequestParam Long sectionNumber,
                                     @RequestParam Long professorId,  @RequestParam Long userId,
                                     @RequestParam String startDate,
                                     @RequestParam String endDate, @RequestParam String startTime,
                                     @RequestParam String endTime, @RequestParam String classDate) throws ParseException
    {

        Professor professor = professorRepository.findOne(professorId);
        User user = userRepository.findOne(userId);
        Section n = sectionRepository.findOne(sectionId);
        n.setSectionNumber(sectionNumber);
        n.setProfessor(professor);
        n.setUser(user);
        n.setStartDate(startDate);
        n.setEndDate(endDate);
        n.setStartTime(startTime);
        n.setEndTIme(endTime);
        n.setClassDate(classDate);
        sectionRepository.save(n);
        return new ModelAndView("redirect:/faculty/view/" + n.getCourse().getCourseId());
    }

}
