/*
 * Copyright (C) 2016 Square, Inc.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.squareup.sqlite.android.lang

import com.intellij.lang.BracePair
import com.intellij.lang.PairedBraceMatcher
import com.intellij.psi.PsiFile
import com.intellij.psi.tree.IElementType
import com.squareup.sqlite.android.SQLiteLexer
import com.squareup.sqlite.android.lang.SqliteTokenTypes.TOKEN_ELEMENT_TYPES

class SqlitePairedBraceMatcher : PairedBraceMatcher {
  private val BRACE_PAIRS = arrayOf(BracePair(TOKEN_ELEMENT_TYPES[SQLiteLexer.OPEN_PAR],
      TOKEN_ELEMENT_TYPES[SQLiteLexer.CLOSE_PAR], false))

  override fun getPairs() = BRACE_PAIRS
  override fun isPairedBracesAllowedBeforeType(lbraceType: IElementType,
      contextType: IElementType?) = true
  override fun getCodeConstructStart(file: PsiFile, openingBraceOffset: Int) = openingBraceOffset
}
