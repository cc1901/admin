package robort.form;

import play.data.validation.Constraints;

public class KnowledgeEditor {
    @Constraints.Required
    public String knowledgeFile;

    @Constraints.Required
    public String question;

    @Constraints.Required
    public String answer;

    public String getKnowledgeFile() {
        return knowledgeFile;
    }

    public void setKnowledgeFile(String knowledgeFile) {
        this.knowledgeFile = knowledgeFile;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }
}
