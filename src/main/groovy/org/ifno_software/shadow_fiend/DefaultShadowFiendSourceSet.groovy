/*
 * Copyright 2015 Maksym Palamarchuk
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.ifno_software.shadow_fiend

import org.gradle.api.file.SourceDirectorySet
import org.gradle.api.internal.file.DefaultSourceDirectorySet
import org.gradle.api.internal.file.FileResolver
import org.gradle.util.ConfigureUtil

/**
 * Created by inferno on 11/14/15.
 */
class DefaultShadowFiendSourceSet implements ShadowFiendSourceSet {
    private final SourceDirectorySet sql;

    DefaultShadowFiendSourceSet(String displayName, FileResolver fileResolver) {
        sql = new DefaultSourceDirectorySet(String.format("%s SQL source", displayName), fileResolver);
        sql.getFilter().include("**/*.sql", "**/*.sf");
    }

    @Override
    public SourceDirectorySet getSql() {
        println("getSql")
        return sql
    }

    @Override
    public ShadowFiendSourceSet sql(Closure configureClosure) {
        println("sql")
        ConfigureUtil.configure(configureClosure, getSql());
        return this;
    }
}
