package robort.service;

import robort.form.KnowledgeEditor;

public class EditKnowledgeService {

    public void editKnowledge(KnowledgeEditor knowledgeEditor) {
        KnowledgeFileModifier knowledgeFileModifier = new KnowledgeFileModifier();
        knowledgeFileModifier.modifyKnowledgeFile(knowledgeEditor.knowledgeFile.trim(),
                knowledgeEditor.answer.trim(), knowledgeEditor.question.trim());
    }
}
