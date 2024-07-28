/*
 * Copyright 2022-2023 Geert Bevin (gbevin[remove] at uwyn dot com)
 * Licensed under the Apache License, Version 2.0 (the "License")
 */
package rife.idea.services;

import com.intellij.openapi.components.Service;
import com.intellij.openapi.project.Project;
import rife.idea.Rife2Bundle;

@Service(Service.Level.PROJECT)
public final class Rife2ProjectService {
    public Rife2ProjectService(Project project) {
        System.out.println(Rife2Bundle.message("projectService", project.getName()));
    }
}
