public class Question {
    String questionText;
    Answer answer;
    int points = 1;

    void printQuestion() {
        System.out.println("Frage: " + this.questionText);
    }

    boolean checkAnswer(String userAnswer) {
        // Testen, ob die Antwort, die der Benutzer eingegeben hat, gleich der im Objekt vorhandenen Antwort ist
        String correctAnswerInLowerCaps = userAnswer.toLowerCase();
        if(correctAnswerInLowerCaps.equals(this.answer.answerText.toLowerCase())) {
            // Punktzahl erhöhen
            System.out.println("Diese Antwort war richtig!");
            return true;
        } else {
            // 0 Punkte vergeben
            System.out.println("Diese Antwort war leider falsch. :(");
            return false;
        }
    }
}
