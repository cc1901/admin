package robort.domain;

import org.codehaus.jackson.annotate.JsonProperty;

import java.util.ArrayList;
import java.util.List;

public class RobotsKnowledge {
    @JsonProperty("knowledge")
    List<String> knowledge;

    public RobotsKnowledge() {
    }

    public RobotsKnowledge(ArrayList<String> knowledge) {
        this.knowledge = knowledge;
    }

    public List<String> getKnowledge() {
        return knowledge;
    }
}
