package com.metacube.training.setterinjection;

import org.springframework.beans.factory.annotation.Autowired;

import com.metacube.training.setterinjection.SpellChecker;

public class TextEditor {
	private SpellChecker spellChecker;

	public void spellingCheck() {
		spellChecker.checkSpelling();
	}

	public SpellChecker getSpellChecker() {
		return spellChecker;
	}
	
	@Autowired
	public void setSpellChecker(SpellChecker spellChecker) {
		this.spellChecker = spellChecker;
	}
}
