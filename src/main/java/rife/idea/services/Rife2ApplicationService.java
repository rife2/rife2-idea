/*
 * Copyright 2022-2023 Geert Bevin (gbevin[remove] at uwyn dot com)
 * Licensed under the Apache License, Version 2.0 (the "License")
 */
package rife.idea.services;

import rife.idea.Rife2Bundle;

public class Rife2ApplicationService {
    public Rife2ApplicationService() {
        System.out.println(Rife2Bundle.message("applicationService"));
    }
}
