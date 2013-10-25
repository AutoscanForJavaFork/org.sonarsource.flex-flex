/*
 * Sonar Flex Plugin
 * Copyright (C) 2010 SonarSource
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
package org.sonar.flex.checks;

import com.sonar.sslr.squid.checks.CheckMessagesVerifier;
import org.junit.Test;
import org.sonar.flex.FlexAstScanner;
import org.sonar.squid.api.SourceFile;

import java.io.File;

public class FieldNameCheckTest {

  private FieldNameCheck check = new FieldNameCheck();

  @Test
  public void defaults(){
    SourceFile file = FlexAstScanner.scanSingleFile(new File("src/test/resources/checks/FieldName.as"), check);
    CheckMessagesVerifier.verify(file.getCheckMessages())
      .next().atLine(3).withMessage("Rename this variable name to match the regular expression " + check.format)
      .noMore();
  }

  @Test
  public void custom() {
    check.format = "[a-z][a-zA-Z]+";

    SourceFile file = FlexAstScanner.scanSingleFile(new File("src/test/resources/checks/FieldName.as"), check);
    CheckMessagesVerifier.verify(file.getCheckMessages())
      .next().atLine(2)
      .next().atLine(2)
      .next().atLine(3)
      .noMore();
  }
}
