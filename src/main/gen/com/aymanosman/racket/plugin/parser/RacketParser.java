// This is a generated file. Not intended for manual editing.
package com.aymanosman.racket.plugin.parser;

import com.intellij.lang.PsiBuilder;
import com.intellij.lang.PsiBuilder.Marker;
import static com.aymanosman.racket.plugin.psi.RacketTypes.*;
import static com.intellij.lang.parser.GeneratedParserUtilBase.*;
import com.intellij.psi.tree.IElementType;
import com.intellij.lang.ASTNode;
import com.intellij.psi.tree.TokenSet;
import com.intellij.lang.PsiParser;
import com.intellij.lang.LightPsiParser;

@SuppressWarnings({"SimplifiableIfStatement", "UnusedAssignment"})
public class RacketParser implements PsiParser, LightPsiParser {

  public ASTNode parse(IElementType t, PsiBuilder b) {
    parseLight(t, b);
    return b.getTreeBuilt();
  }

  public void parseLight(IElementType t, PsiBuilder b) {
    boolean r;
    b = adapt_builder_(t, b, this, null);
    Marker m = enter_section_(b, 0, _COLLAPSE_, null);
    r = parse_root_(t, b);
    exit_section_(b, 0, m, t, r, true, TRUE_CONDITION);
  }

  protected boolean parse_root_(IElementType t, PsiBuilder b) {
    return parse_root_(t, b, 0);
  }

  static boolean parse_root_(IElementType t, PsiBuilder b, int l) {
    return RacketFile(b, l + 1);
  }

  /* ********************************************************** */
  // Property | COMMENT | CRLF
  static boolean Item_(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "Item_")) return false;
    boolean r;
    r = Property(b, l + 1);
    if (!r) r = consumeToken(b, COMMENT);
    if (!r) r = consumeToken(b, CRLF);
    return r;
  }

  /* ********************************************************** */
  // (KEY? SEPARATOR VALUE?) | KEY
  public static boolean Property(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "Property")) return false;
    if (!nextTokenIs(b, "<property>", KEY, SEPARATOR)) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, PROPERTY, "<property>");
    r = Property_0(b, l + 1);
    if (!r) r = consumeToken(b, KEY);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // KEY? SEPARATOR VALUE?
  private static boolean Property_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "Property_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = Property_0_0(b, l + 1);
    r = r && consumeToken(b, SEPARATOR);
    r = r && Property_0_2(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // KEY?
  private static boolean Property_0_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "Property_0_0")) return false;
    consumeToken(b, KEY);
    return true;
  }

  // VALUE?
  private static boolean Property_0_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "Property_0_2")) return false;
    consumeToken(b, VALUE);
    return true;
  }

  /* ********************************************************** */
  // Item_*
  static boolean RacketFile(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "RacketFile")) return false;
    while (true) {
      int c = current_position_(b);
      if (!Item_(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "RacketFile", c)) break;
    }
    return true;
  }

}
