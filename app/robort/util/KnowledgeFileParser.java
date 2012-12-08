package robort.util;

import org.dom4j.Element;
import org.dom4j.ElementHandler;
import org.dom4j.ElementPath;
import play.Logger;

public class KnowledgeFileParser implements ElementHandler {

    public static final String ANSWER_NODE_NAME = "answer";
    public static final String QUESTION_NODE_NAME = "question";
    private String answerText;
    private String newQuestionText;

    @Override
    public void onStart(ElementPath elementPath) {

    }

    public KnowledgeFileParser(String answerText, String newQuestionText) {
        this.answerText = answerText;
        this.newQuestionText = newQuestionText;
    }

    @Override
    public void onEnd(ElementPath elementPath) {
        Element currentElement = elementPath.getCurrent();
        System.out.println(currentElement.getName() + "------------" + currentElement.getText());
        if (currentElement.getName().equals(ANSWER_NODE_NAME) && currentElement.getText().equals(answerText)) {
            Logger.info("node name: " + currentElement.getName());
            Logger.info("---------------------");
            Logger.info("answer: " + currentElement.getText());
            Element parent = currentElement.getParent();
            if (parent == null) {
                Logger.error("no qa element.............");
                return;
            }
            Element question = parent.addElement(QUESTION_NODE_NAME);
            question.addText(newQuestionText);
            Logger.info("---------------------");
            Logger.info("new question: " + newQuestionText);
        }
    }
}
