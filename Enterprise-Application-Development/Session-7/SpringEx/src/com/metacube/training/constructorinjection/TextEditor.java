package com.metacube.training.constructorinjection;

import org.springframework.beans.factory.annotation.Autowired;

public class TextEditor {
	private SpellChecker spellChecker;
	
	@Autowired
	public TextEditor(SpellChecker spellChecker) {
		this.spellChecker = spellChecker;
	}

	public void spellingCheck() {
		spellChecker.checkSpelling();
	}

}
