package org.racket.lang.core;

import com.intellij.lexer.FlexLexer;
import com.intellij.psi.tree.IElementType;
import org.racket.lang.core.psi.RacketTypes;
import com.intellij.psi.TokenType;

%%

%class RacketLexer
%implements FlexLexer
%unicode
%function advance
%type IElementType
%eof{  return;
%eof}

//---
CRLF=\R
WHITE_SPACE=[\ \n\r\t\f]

//---
any_char=.

a=[aA]
b=[bB]
c=[cC]
d=[dD]
e=[eE]
f=[fF]
g=[gG]
h=[hH]
i=[iI]
j=[jJ]
k=[kK]
l=[lL]
m=[mM]
n=[nN]
o=[oO]
p=[pP]
q=[qQ]
r=[rR]
s=[sS]
t=[tT]
u=[uU]
v=[vV]
w=[wW]
x=[xX]
y=[yY]
z=[zZ]

//---
digit=[0-9]
digit2=[0-1]
digit8=[0-7]
digit10={digit}
digit16=[a-fA-F0-9]

langchar=[a-zA-Z0-9] | "+" | "-" | "_"

racket_whitespace={WHITE_SPACE} // TODO

line_comment=";"[^\R]*

unicode= "u" {digit16}{1,4}
        | "U" {digit16}{1,6}

character= "#\\" {any_char}
         | "#\\" {character_name}
         | "#\\" [0-3] {digit8} {digit8}
         | "#\\" {unicode}

character_name= {s}{p}{a}{c}{e}
              | {n}{e}{w}{l}{i}{n}{e}
              | {n}{u}{l}
              | {n}{u}{l}{l}
              | {b}{a}{c}{k}{s}{p}{a}{c}{e}
              | {t}{a}{b}
              | {l}{i}{n}{e}{f}{e}{e}{d}
              | {v}{t}{a}{b}
              | {p}{a}{g}{e}
              | {r}{e}{t}{u}{r}{n}
              | {r}{u}{b}{o}{u}{t}


//bad_char="#\\" | "#\\" {alphabetic}{2} | "#\\" [0-3] {digit8}
str=("#px" | "#rx")? "\"" ({string_element} | "\\" {unicode})* "\"" | {byte_str}
byte_str= ("#px" | "#rx")? "#\"" {byte_string_element}* "\""
string_element= [^\"\\] | {string_escape}
byte_string_element=[[\x00-\xFF]--\"\\] | {string_escape}
string_escape="\\\""
             | "\\\\"
             | "\\a"
             | "\\b"
             | "\\t"
             | "\\n"
             | "\\v"
             | "\\f"
             | "\\r"
             | "\\e"
             | "\\'"
             | "\\" {digit8}{1,3}
             | "\\x" {digit16}{1,3} // TODO why 3 and not 2?
             | "\\" \R
//bad_str=...

special_numbers={n}{a}{n} ".0" | {n}{a}{n} ".f"
               | {i}{n}{f} ".0" | {i}{n}{f} ".f"
special_extflonums= {n}{a}{n}".t" | {i}{n}{f}".t"
exponent_marker={e} | {s} | {f} | {d} | {l}
exponent_marker16={s} | {l}
sign=[+-]
exactness="#i" | "#e" | "#I" | "#E"
radix2="#b" | "#B"
radix8="#o" | "#O"
radix10="#d" | "#D"
radix16="#x" | "#X"

//script=...

//identifier_delims=[\",'`()\[\]{};]|{racket_whitespace}
identifier_chars=[^\",'`()\[\]{};\\|\ \n\r\t\f]
identifier_escapes=("\\" {any_char}) | ("|" ~"|")
identifier_start={identifier_escapes} | [^\",'`()\[\]{};\\|\ \n\r\t\f#] | "#%"
identifier={identifier_start} ({identifier_escapes} | {identifier_chars})*

keyword="#:" ({identifier_escapes} | {identifier_chars})*

list_prefix=""|"#hash"|"#hasheq"|"#hasheqv"|"#s"| "#" {digit10}*

line_comment=";".*

//---
langline=("#lang " | "#!") ({langchar} | ({langchar} ({langchar} | "/")* {langchar}))
constant="'" | "`" | "#'" | "#`" | "#&"
booleans=("#true"|"#false"|"#t"|"#f"|"#T"|"#F") [^\",'`()\[\]{};\\|\ \n\r\t\f]*
numbers = {digit10}*
        | {radix16} {digit16}*
        | {radix2} {digit2}*
        | "+" {special_numbers}
        | "-" {special_numbers}
sexp_comment="#;"
dot="."
unquote=","|",@"|"#,"|"#,@"

// ---
block_comment="#|" ~"|#"

%state MAIN

%%

<YYINITIAL> {
  {racket_whitespace}+ { return TokenType.WHITE_SPACE; }
  {langline} { yybegin(MAIN); return RacketTypes.HASH_LANG; }
}

<MAIN> {
 {racket_whitespace}+ { return TokenType.WHITE_SPACE; }
 {booleans} {
          {
              String xs = yytext().toString();
              if (xs.equals("#true")
                  || xs.equals("#false")
                  || xs.equals("#t")
                  || xs.equals("#f")
                  || xs.equals("#T")
                  || xs.equals("#F")) {
                  return RacketTypes.BOOLEAN;
              } else {
                  return TokenType.ERROR_ELEMENT;
              }
          }
      }
 {character} { return RacketTypes.CHARACTER; }
 {numbers} { return RacketTypes.NUMBER; }

 {keyword} { return RacketTypes.KEYWORD; }
 {str} { return RacketTypes.STRING; }
 {line_comment} { return RacketTypes.COMMENT; }
 {sexp_comment} { return RacketTypes.SEXP_COMMENT; }
 {block_comment} { return RacketTypes.COMMENT; }
 // script


 {list_prefix} "(" { return RacketTypes.OPEN_PAREN; }
 ")" { return RacketTypes.CLOSE_PAREN; }
 {list_prefix} "[" { return RacketTypes.OPEN_SQUARE; }
 "]" { return RacketTypes.CLOSE_SQUARE; }

 {constant}  { return RacketTypes.CONSTANT; }
 {dot} { return RacketTypes.DOT; }
 {unquote} { return RacketTypes.UNQUOTE; }

 {identifier}  { return RacketTypes.IDENTIFIER; }
 // #<<

 {CRLF}({CRLF}|{WHITE_SPACE})+ { return TokenType.WHITE_SPACE; }
}

[^] { return TokenType.BAD_CHARACTER; }
