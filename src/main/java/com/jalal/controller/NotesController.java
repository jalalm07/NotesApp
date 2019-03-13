package com.jalal.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.jalal.model.Notes;
import com.jalal.service.NotesService;

@Controller
@RequestMapping(value="/note")
public class NotesController {
	
	@Autowired
	NotesService noteService;
	
	@RequestMapping(value="/list", method= RequestMethod.GET)
	public ModelAndView list() {
		ModelAndView model = new ModelAndView("note_page");
		
		List<Notes> list = noteService.listAllNotes();
		//System.out.println(list.toString());
		model.addObject("listNote", list);
		
		return model;
	}
	
	@RequestMapping(value="/add", method= RequestMethod.GET)
	public ModelAndView add() {
		ModelAndView model = new ModelAndView("note_form");
		
		Notes note = new Notes();
		model.addObject("noteForm", note);
		
		return model;
	}
	
	@RequestMapping(value="/update/{id}", method= RequestMethod.GET)
	public ModelAndView update(@PathVariable("id") int id) {
		ModelAndView model = new ModelAndView("note_form");
		
		Notes note = noteService.findNoteById(id);
		model.addObject("noteForm", note);
		
		return model;
	}
	
	
	
	@RequestMapping(value="/save", method= RequestMethod.GET)
	public ModelAndView save(@ModelAttribute("noteForm") Notes note) {
		if(note!=null && note.getId()!=null) {
			noteService.updateNote(note);
		}else {
			noteService.addNote(note);
		}
		return new ModelAndView("redirect:/note/list");
	}
	
	
	@RequestMapping(value="/delete/{id}", method= RequestMethod.GET)
	public ModelAndView delete(@PathVariable("id") int id) {
		noteService.deleteNote(id);
		return new ModelAndView("redirect:/note/list");
	}
	

}
