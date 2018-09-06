package com.metacube.training.autowiringbyname;

import org.springframework.beans.factory.annotation.Autowired;

public class TextEditor {
	@Autowired
	private SpellChecker spellCheckerName;
	private String word;
	
	public void spellCheck() {
		spellCheckerName.checkSpelling(getWord());
	}

	public String getWord() {
		return word;
	}

	public void setWord(String word) {
		this.word = word;
	}

	public SpellChecker getSpellCheckerName() {
		return spellCheckerName;
	}

	public void setSpellCheckerName(SpellChecker spellCheckerName) {
		this.spellCheckerName = spellCheckerName;
	}
}
