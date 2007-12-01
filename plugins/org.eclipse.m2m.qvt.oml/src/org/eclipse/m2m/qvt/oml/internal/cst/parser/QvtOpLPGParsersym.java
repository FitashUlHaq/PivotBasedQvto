/**
* <copyright>
*
* Copyright (c) 2007 Borland Software Corporation
* 
* All rights reserved. This program and the accompanying materials
* are made available under the terms of the Eclipse Public License v1.0
* which accompanies this distribution, and is available at
* http://www.eclipse.org/legal/epl-v10.html
*
* Contributors:
*     Borland Software Corporation - initial API and implementation
*
* </copyright>
*
* $Id: QvtOpLPGParsersym.java,v 1.24 2007/12/01 23:33:05 radvorak Exp $
*/
/**
* <copyright>
*
* Copyright (c) 2006, 2007 Borland Inc.
* All rights reserved.   This program and the accompanying materials
* are made available under the terms of the Eclipse Public License v1.0
* which accompanies this distribution, and is available at
* http://www.eclipse.org/legal/epl-v10.html
*
* Contributors:
*   Borland - Initial API and implementation
*
* </copyright>
*
* $Id: QvtOpLPGParsersym.java,v 1.24 2007/12/01 23:33:05 radvorak Exp $
*/

package org.eclipse.m2m.qvt.oml.internal.cst.parser;

public interface QvtOpLPGParsersym {
    public final static int
      TK_NUMERIC_OPERATION = 67,
      TK_STRING_LITERAL = 44,
      TK_INTEGER_LITERAL = 68,
      TK_REAL_LITERAL = 69,
      TK_PLUS = 51,
      TK_MINUS = 52,
      TK_MULTIPLY = 23,
      TK_DIVIDE = 24,
      TK_GREATER = 25,
      TK_LESS = 26,
      TK_EQUAL = 5,
      TK_GREATER_EQUAL = 27,
      TK_LESS_EQUAL = 28,
      TK_NOT_EQUAL = 20,
      TK_LPAREN = 1,
      TK_RPAREN = 4,
      TK_LBRACE = 88,
      TK_RBRACE = 86,
      TK_LBRACKET = 119,
      TK_RBRACKET = 110,
      TK_ARROW = 126,
      TK_BAR = 99,
      TK_COMMA = 89,
      TK_COLON = 91,
      TK_COLONCOLON = 90,
      TK_SEMICOLON = 87,
      TK_DOT = 100,
      TK_DOTDOT = 127,
      TK_ATPRE = 102,
      TK_CARET = 128,
      TK_CARETCARET = 129,
      TK_QUESTIONMARK = 111,
      TK_QUOTE_STRING_LITERAL = 130,
      TK_ADD_ASSIGN = 120,
      TK_RESET_ASSIGN = 106,
      TK_AT_SIGN = 135,
      TK_self = 45,
      TK_inv = 139,
      TK_pre = 140,
      TK_post = 141,
      TK_context = 142,
      TK_package = 143,
      TK_endpackage = 144,
      TK_def = 145,
      TK_if = 70,
      TK_then = 131,
      TK_else = 121,
      TK_endif = 122,
      TK_and = 46,
      TK_or = 47,
      TK_xor = 48,
      TK_not = 54,
      TK_implies = 132,
      TK_let = 77,
      TK_in = 93,
      TK_true = 71,
      TK_false = 72,
      TK_body = 29,
      TK_derive = 30,
      TK_init = 21,
      TK_null = 53,
      TK_attr = 146,
      TK_oper = 147,
      TK_Set = 6,
      TK_Bag = 7,
      TK_Sequence = 8,
      TK_Collection = 9,
      TK_OrderedSet = 10,
      TK_iterate = 31,
      TK_forAll = 32,
      TK_exists = 33,
      TK_isUnique = 34,
      TK_any = 35,
      TK_one = 36,
      TK_collect = 37,
      TK_select = 38,
      TK_reject = 39,
      TK_collectNested = 40,
      TK_sortedBy = 41,
      TK_closure = 42,
      TK_oclIsKindOf = 55,
      TK_oclIsTypeOf = 56,
      TK_oclAsType = 57,
      TK_oclIsNew = 58,
      TK_oclIsUndefined = 59,
      TK_oclIsInvalid = 60,
      TK_oclIsInState = 61,
      TK_allInstances = 43,
      TK_String = 11,
      TK_Integer = 12,
      TK_UnlimitedNatural = 13,
      TK_Real = 14,
      TK_Boolean = 15,
      TK_Tuple = 22,
      TK_OclAny = 16,
      TK_OclVoid = 17,
      TK_Invalid = 18,
      TK_OclMessage = 19,
      TK_OclInvalid = 73,
      TK_end = 123,
      TK_while = 74,
      TK_out = 103,
      TK_object = 64,
      TK_transformation = 112,
      TK_import = 113,
      TK_library = 107,
      TK_metamodel = 108,
      TK_mapping = 95,
      TK_query = 96,
      TK_inout = 104,
      TK_when = 133,
      TK_var = 97,
      TK_configuration = 101,
      TK_property = 98,
      TK_map = 62,
      TK_xmap = 63,
      TK_late = 65,
      TK_log = 66,
      TK_assert = 75,
      TK_with = 134,
      TK_resolve = 78,
      TK_resolveone = 79,
      TK_resolveIn = 80,
      TK_resolveoneIn = 81,
      TK_invresolve = 82,
      TK_invresolveone = 83,
      TK_invresolveIn = 84,
      TK_invresolveoneIn = 85,
      TK_modeltype = 109,
      TK_uses = 136,
      TK_where = 137,
      TK_refines = 124,
      TK_enforcing = 138,
      TK_access = 114,
      TK_extends = 115,
      TK_blackbox = 116,
      TK_abstract = 117,
      TK_static = 118,
      TK_result = 49,
      TK_main = 92,
      TK_this = 50,
      TK_switch = 76,
      TK_rename = 105,
      TK_EOF_TOKEN = 94,
      TK_IDENTIFIER = 3,
      TK_INTEGER_RANGE_START = 125,
      TK_ERROR_TOKEN = 2;

      public final static String orderedTerminalSymbols[] = {
                 "",
                 "LPAREN",
                 "ERROR_TOKEN",
                 "IDENTIFIER",
                 "RPAREN",
                 "EQUAL",
                 "Set",
                 "Bag",
                 "Sequence",
                 "Collection",
                 "OrderedSet",
                 "String",
                 "Integer",
                 "UnlimitedNatural",
                 "Real",
                 "Boolean",
                 "OclAny",
                 "OclVoid",
                 "Invalid",
                 "OclMessage",
                 "NOT_EQUAL",
                 "init",
                 "Tuple",
                 "MULTIPLY",
                 "DIVIDE",
                 "GREATER",
                 "LESS",
                 "GREATER_EQUAL",
                 "LESS_EQUAL",
                 "body",
                 "derive",
                 "iterate",
                 "forAll",
                 "exists",
                 "isUnique",
                 "any",
                 "one",
                 "collect",
                 "select",
                 "reject",
                 "collectNested",
                 "sortedBy",
                 "closure",
                 "allInstances",
                 "STRING_LITERAL",
                 "self",
                 "and",
                 "or",
                 "xor",
                 "result",
                 "this",
                 "PLUS",
                 "MINUS",
                 "null",
                 "not",
                 "oclIsKindOf",
                 "oclIsTypeOf",
                 "oclAsType",
                 "oclIsNew",
                 "oclIsUndefined",
                 "oclIsInvalid",
                 "oclIsInState",
                 "map",
                 "xmap",
                 "object",
                 "late",
                 "log",
                 "NUMERIC_OPERATION",
                 "INTEGER_LITERAL",
                 "REAL_LITERAL",
                 "if",
                 "true",
                 "false",
                 "OclInvalid",
                 "while",
                 "assert",
                 "switch",
                 "let",
                 "resolve",
                 "resolveone",
                 "resolveIn",
                 "resolveoneIn",
                 "invresolve",
                 "invresolveone",
                 "invresolveIn",
                 "invresolveoneIn",
                 "RBRACE",
                 "SEMICOLON",
                 "LBRACE",
                 "COMMA",
                 "COLONCOLON",
                 "COLON",
                 "main",
                 "in",
                 "EOF_TOKEN",
                 "mapping",
                 "query",
                 "var",
                 "property",
                 "BAR",
                 "DOT",
                 "configuration",
                 "ATPRE",
                 "out",
                 "inout",
                 "rename",
                 "RESET_ASSIGN",
                 "library",
                 "metamodel",
                 "modeltype",
                 "RBRACKET",
                 "QUESTIONMARK",
                 "transformation",
                 "import",
                 "access",
                 "extends",
                 "blackbox",
                 "abstract",
                 "static",
                 "LBRACKET",
                 "ADD_ASSIGN",
                 "else",
                 "endif",
                 "end",
                 "refines",
                 "INTEGER_RANGE_START",
                 "ARROW",
                 "DOTDOT",
                 "CARET",
                 "CARETCARET",
                 "QUOTE_STRING_LITERAL",
                 "then",
                 "implies",
                 "when",
                 "with",
                 "AT_SIGN",
                 "uses",
                 "where",
                 "enforcing",
                 "inv",
                 "pre",
                 "post",
                 "context",
                 "package",
                 "endpackage",
                 "def",
                 "attr",
                 "oper"
             };

    public final static boolean isValidForParser = true;
}
