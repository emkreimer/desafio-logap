package br.emkreimer.dooshop.service;

import br.emkreimer.dooshop.model.CharResponse;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
public class CaractereService {

    public CharResponse getResults(String word) {
        long startTime = System.currentTimeMillis();
        Character vowel = findPatternVowel(word);
        long endTime = System.currentTimeMillis();
        return new CharResponse(word, vowel, endTime-startTime);
    }

    public Character findPatternVowel(String word) {
        boolean consonant = false;
        String vowels = "aeiouAEIOU";
        Set<Character> vowelSet = new HashSet<>();

        for(int i = 0; i < word.length(); i++) {
            Character c = word.charAt(i);

            // if not a vowel, the letter is a consonant
            if(vowels.indexOf(c) < 0) {
                consonant = true;
            } else {
                if(consonant && !vowelSet.contains(c)) {
                    vowelSet.add(c);
                    if (i > 0 && vowels.indexOf(word.charAt(i - 1)) != -1) {
                        return c;
                    }
                }
            }
        }
        return '\0';
    }
}
