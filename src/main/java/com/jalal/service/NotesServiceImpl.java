package com.jalal.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jalal.dao.NotesDao;
import com.jalal.model.Notes;


@Service
public class NotesServiceImpl implements NotesService {

	NotesDao noteDao;	
	@Autowired
	public void setNoteDao(NotesDao noteDao) {
		this.noteDao = noteDao;
	}

	public List<Notes> listAllNotes() {
		return noteDao.listAllNotes();
	}

	public void addNote(Notes note) {
		noteDao.addNote(note);

	}

	public void updateNote(Notes note) {
		noteDao.updateNote(note);

	}

	public void deleteNote(int id) {
		noteDao.deleteNote(id);

	}

	public Notes findNoteById(int id) {
		return noteDao.findNoteById(id);
	}

}
