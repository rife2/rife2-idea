package rife.idea.services;

import com.intellij.openapi.project.Project;
import rife.idea.Rife2Bundle;

public final class Rife2ProjectService {
    public Rife2ProjectService(Project project) {
        System.out.println(Rife2Bundle.message("projectService", project.getName()));
    }
}
