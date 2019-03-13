package com.jalal.dao;

import java.util.List;

import com.jalal.model.Notes;

public interface NotesDao {
	
	public List<Notes> listAllNotes();
	public void addNote(Notes note);
	public void updateNote(Notes note);
	public void deleteNote(int id);
	public Notes findNoteById(int id);

}
