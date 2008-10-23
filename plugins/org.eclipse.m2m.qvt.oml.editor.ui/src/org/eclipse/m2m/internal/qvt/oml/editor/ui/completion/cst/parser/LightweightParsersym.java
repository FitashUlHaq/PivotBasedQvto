/**
* <copyright>
*
* Copyright (c) 2005, 2008 IBM Corporation and others.
* All rights reserved.   This program and the accompanying materials
* are made available under the terms of the Eclipse Public License v1.0
* which accompanies this distribution, and is available at
* http://www.eclipse.org/legal/epl-v10.html
*
* Contributors:
*   IBM - Initial API and implementation
*   E.D.Willink - Elimination of some shift-reduce conflicts
*   E.D.Willink - Remove unnecessary warning suppression
*   E.D.Willink - 225493 Need ability to set CSTNode offsets
*
* </copyright>
*
* $Id: LightweightParsersym.java,v 1.12 2008/10/23 20:06:29 aigdalov Exp $
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
* $Id: LightweightParsersym.java,v 1.12 2008/10/23 20:06:29 aigdalov Exp $
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
* $Id: LightweightParsersym.java,v 1.12 2008/10/23 20:06:29 aigdalov Exp $
*/

package org.eclipse.m2m.internal.qvt.oml.editor.ui.completion.cst.parser;

public interface LightweightParsersym {
    public final static int
      TK_NUMERIC_OPERATION = 67,
      TK_STRING_LITERAL = 46,
      TK_INTEGER_LITERAL = 68,
      TK_REAL_LITERAL = 69,
      TK_PLUS = 51,
      TK_MINUS = 52,
      TK_MULTIPLY = 27,
      TK_DIVIDE = 28,
      TK_GREATER = 21,
      TK_LESS = 22,
      TK_EQUAL = 19,
      TK_GREATER_EQUAL = 23,
      TK_LESS_EQUAL = 24,
      TK_NOT_EQUAL = 25,
      TK_LPAREN = 1,
      TK_RPAREN = 4,
      TK_LBRACE = 89,
      TK_RBRACE = 87,
      TK_LBRACKET = 110,
      TK_RBRACKET = 122,
      TK_ARROW = 139,
      TK_BAR = 94,
      TK_COMMA = 88,
      TK_COLON = 90,
      TK_COLONCOLON = 91,
      TK_SEMICOLON = 86,
      TK_DOT = 111,
      TK_DOTDOT = 140,
      TK_ATPRE = 123,
      TK_CARET = 141,
      TK_CARETCARET = 142,
      TK_QUESTIONMARK = 124,
      TK_QUOTE_STRING_LITERAL = 130,
      TK_ADD_ASSIGN = 131,
      TK_RESET_ASSIGN = 101,
      TK_AT_SIGN = 118,
      TK_EXCLAMATION_MARK = 125,
      TK_NOT_EQUAL_EXEQ = 119,
      TK_INTEGER_RANGE_START = 132,
      TK_self = 29,
      TK_inv = 159,
      TK_pre = 160,
      TK_post = 161,
      TK_endpackage = 162,
      TK_def = 163,
      TK_if = 70,
      TK_then = 143,
      TK_else = 133,
      TK_endif = 134,
      TK_and = 47,
      TK_or = 48,
      TK_xor = 49,
      TK_not = 54,
      TK_implies = 144,
      TK_let = 77,
      TK_in = 92,
      TK_true = 71,
      TK_false = 72,
      TK_body = 30,
      TK_derive = 31,
      TK_init = 26,
      TK_null = 53,
      TK_Set = 5,
      TK_Bag = 6,
      TK_Sequence = 7,
      TK_Collection = 8,
      TK_OrderedSet = 9,
      TK_iterate = 32,
      TK_forAll = 33,
      TK_exists = 34,
      TK_isUnique = 35,
      TK_any = 36,
      TK_one = 37,
      TK_collect = 38,
      TK_select = 39,
      TK_reject = 40,
      TK_collectNested = 41,
      TK_sortedBy = 42,
      TK_closure = 43,
      TK_oclIsKindOf = 55,
      TK_oclIsTypeOf = 56,
      TK_oclAsType = 57,
      TK_oclIsNew = 58,
      TK_oclIsUndefined = 59,
      TK_oclIsInvalid = 60,
      TK_oclIsInState = 61,
      TK_allInstances = 44,
      TK_String = 10,
      TK_Integer = 11,
      TK_UnlimitedNatural = 12,
      TK_Real = 13,
      TK_Boolean = 14,
      TK_Tuple = 20,
      TK_OclAny = 15,
      TK_OclVoid = 16,
      TK_Invalid = 17,
      TK_OclMessage = 18,
      TK_OclInvalid = 73,
      TK_end = 120,
      TK_while = 74,
      TK_when = 126,
      TK_var = 107,
      TK_log = 102,
      TK_assert = 108,
      TK_with = 147,
      TK_switch = 65,
      TK_case = 145,
      TK_xselect = 148,
      TK_xcollect = 149,
      TK_selectOne = 150,
      TK_collectOne = 151,
      TK_collectselect = 152,
      TK_collectselectOne = 153,
      TK_return = 109,
      TK_forEach = 154,
      TK_forOne = 155,
      TK_compute = 75,
      TK_new = 76,
      TK_out = 99,
      TK_object = 62,
      TK_transformation = 121,
      TK_import = 127,
      TK_library = 114,
      TK_metamodel = 115,
      TK_mapping = 103,
      TK_query = 104,
      TK_helper = 105,
      TK_inout = 100,
      TK_configuration = 112,
      TK_intermediate = 113,
      TK_property = 106,
      TK_population = 146,
      TK_map = 63,
      TK_xmap = 64,
      TK_late = 66,
      TK_resolve = 78,
      TK_resolveone = 79,
      TK_resolveIn = 80,
      TK_resolveoneIn = 81,
      TK_invresolve = 82,
      TK_invresolveone = 83,
      TK_invresolveIn = 84,
      TK_invresolveoneIn = 85,
      TK_modeltype = 116,
      TK_uses = 156,
      TK_where = 157,
      TK_refines = 135,
      TK_enforcing = 158,
      TK_access = 128,
      TK_extends = 129,
      TK_blackbox = 96,
      TK_abstract = 97,
      TK_static = 98,
      TK_result = 45,
      TK_main = 93,
      TK_this = 50,
      TK_rename = 117,
      TK_inherits = 136,
      TK_merges = 137,
      TK_disjuncts = 138,
      TK_IDENTIFIER = 2,
      TK_ERROR_TOKEN = 3,
      TK_EOF_TOKEN = 95;

      public final static String orderedTerminalSymbols[] = {
                 "",
                 "LPAREN",
                 "IDENTIFIER",
                 "ERROR_TOKEN",
                 "RPAREN",
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
                 "EQUAL",
                 "Tuple",
                 "GREATER",
                 "LESS",
                 "GREATER_EQUAL",
                 "LESS_EQUAL",
                 "NOT_EQUAL",
                 "init",
                 "MULTIPLY",
                 "DIVIDE",
                 "self",
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
                 "result",
                 "STRING_LITERAL",
                 "and",
                 "or",
                 "xor",
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
                 "object",
                 "map",
                 "xmap",
                 "switch",
                 "late",
                 "NUMERIC_OPERATION",
                 "INTEGER_LITERAL",
                 "REAL_LITERAL",
                 "if",
                 "true",
                 "false",
                 "OclInvalid",
                 "while",
                 "compute",
                 "new",
                 "let",
                 "resolve",
                 "resolveone",
                 "resolveIn",
                 "resolveoneIn",
                 "invresolve",
                 "invresolveone",
                 "invresolveIn",
                 "invresolveoneIn",
                 "SEMICOLON",
                 "RBRACE",
                 "COMMA",
                 "LBRACE",
                 "COLON",
                 "COLONCOLON",
                 "in",
                 "main",
                 "BAR",
                 "EOF_TOKEN",
                 "blackbox",
                 "abstract",
                 "static",
                 "out",
                 "inout",
                 "RESET_ASSIGN",
                 "log",
                 "mapping",
                 "query",
                 "helper",
                 "property",
                 "var",
                 "assert",
                 "return",
                 "LBRACKET",
                 "DOT",
                 "configuration",
                 "intermediate",
                 "library",
                 "metamodel",
                 "modeltype",
                 "rename",
                 "AT_SIGN",
                 "NOT_EQUAL_EXEQ",
                 "end",
                 "transformation",
                 "RBRACKET",
                 "ATPRE",
                 "QUESTIONMARK",
                 "EXCLAMATION_MARK",
                 "when",
                 "import",
                 "access",
                 "extends",
                 "QUOTE_STRING_LITERAL",
                 "ADD_ASSIGN",
                 "INTEGER_RANGE_START",
                 "else",
                 "endif",
                 "refines",
                 "inherits",
                 "merges",
                 "disjuncts",
                 "ARROW",
                 "DOTDOT",
                 "CARET",
                 "CARETCARET",
                 "then",
                 "implies",
                 "case",
                 "population",
                 "with",
                 "xselect",
                 "xcollect",
                 "selectOne",
                 "collectOne",
                 "collectselect",
                 "collectselectOne",
                 "forEach",
                 "forOne",
                 "uses",
                 "where",
                 "enforcing",
                 "inv",
                 "pre",
                 "post",
                 "endpackage",
                 "def"
             };

    public final static boolean isValidForParser = true;
}
