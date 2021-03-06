/*
 * Sonar .NET Plugin :: NDeps
 * Copyright (C) 2010 Jose Chillan, Alexandre Victoor and SonarSource
 * dev@sonar.codehaus.org
 *
 * This program is free software; you can redistribute it and/or
 * modify it under the terms of the GNU Lesser General Public
 * License as published by the Free Software Foundation; either
 * version 3 of the License, or (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the GNU
 * Lesser General Public License for more details.
 *
 * You should have received a copy of the GNU Lesser General Public
 * License along with this program; if not, write to the Free Software
 * Foundation, Inc., 51 Franklin Street, Fifth Floor, Boston, MA  02
 */
package org.sonar.plugins.csharp.ndeps.decorators;

import org.sonar.plugins.csharp.ndeps.common.NDepsConstants;

import org.sonar.api.batch.Decorator;
import org.sonar.api.resources.Project;
import org.sonar.plugins.dotnet.api.microsoft.MicrosoftWindowsEnvironment;

public abstract class DecoratorSupport implements Decorator {

  private final MicrosoftWindowsEnvironment microsoftWindowsEnvironment;

  public DecoratorSupport(MicrosoftWindowsEnvironment microsoftWindowsEnvironment) {
    this.microsoftWindowsEnvironment = microsoftWindowsEnvironment;
  }

  public boolean shouldExecuteOnProject(Project project) {
    return NDepsConstants.isLanguageSupported(project.getLanguageKey())
      && !project.isRoot()
      && !microsoftWindowsEnvironment.getCurrentProject(project.getName()).isWebProject();
  }

}
