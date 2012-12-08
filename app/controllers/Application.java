package controllers;

import robort.form.KnowledgeEditor;
import play.data.Form;
import play.mvc.*;

import robort.service.EditKnowledgeService;
import robort.service.RestartEngineService;
import views.html.*;

public class Application extends Controller {

    public static Result index() {
        return ok(index.render("Your new application is ready."));
    }

    public static Result knowledgeEditor() {
        return ok(knowledgeEditor.render());
    }

    public static Result editKnowledge() {
        Form<KnowledgeEditor> knowledgeEditorForm = form(KnowledgeEditor.class);
        KnowledgeEditor knowledgeEditor = knowledgeEditorForm.bindFromRequest().get();

        new EditKnowledgeService().editKnowledge(knowledgeEditor);
        return redirect("/knowledge-editor");
    }

    public static Result restartEngine() {
        new RestartEngineService().restart();
        return redirect("/knowledge-editor");
    }

}