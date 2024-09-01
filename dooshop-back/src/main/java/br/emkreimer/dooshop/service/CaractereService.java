package br.emkreimer.dooshop.service;

import br.emkreimer.dooshop.domain.model.CharResponse;
import org.springframework.stereotype.Service;

import java.time.Duration;
import java.time.Instant;
import java.util.HashSet;
import java.util.Set;

@Service
public class CaractereService {

    public CharResponse getResults(String word) {
        CharResponse response = new CharResponse();
        response.setString(word);

        Instant start = Instant.now();
        Character vowel = findPatternVowel(word);
        Instant end = Instant.now();

        response.setVogal(vowel);
        response.setTempoTotal(Duration.between(start, end).toMillis());

        return response;
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
                // if the vowel is unique
                if(!vowelSet.contains(c)) {
                    // if it is preceded by 2 letters
                    // and i-1 is a consonant
                    // and i-2 is a vowel
                    if (i >= 2 && consonant && vowelSet.contains(word.charAt(i-2))) {
                        return c;
                    }
                    vowelSet.add(c);
                    consonant = false;
                }

            }
        }
        return null;
    }
}
