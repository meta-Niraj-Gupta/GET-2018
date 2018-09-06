package com.metacube.training.autowirebyconstructor;

import org.springframework.beans.factory.annotation.Autowired;

public class TextEditor {
	private SpellChecker spellChecker;
	private String word;
	
	@Autowired
	public TextEditor(SpellChecker spellChecker, String word) {
		this.spellChecker = spellChecker;
		this.word = word;
	}

	public SpellChecker getSpellChecker() {
		return spellChecker;
	}
	
	public String getWord() {
		return word;
	}

	public void spellCheck() {
		spellChecker.checkSpelling(getWord());
	}
}
