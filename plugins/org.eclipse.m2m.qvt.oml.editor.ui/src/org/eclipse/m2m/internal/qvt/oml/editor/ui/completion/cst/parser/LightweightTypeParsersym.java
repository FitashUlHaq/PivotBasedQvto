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
* $Id: LightweightTypeParsersym.java,v 1.56 2009/04/22 09:54:40 aigdalov Exp $
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
* $Id: LightweightTypeParsersym.java,v 1.56 2009/04/22 09:54:40 aigdalov Exp $
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
* $Id: LightweightTypeParsersym.java,v 1.56 2009/04/22 09:54:40 aigdalov Exp $
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
* $Id: LightweightTypeParsersym.java,v 1.56 2009/04/22 09:54:40 aigdalov Exp $
*/

package org.eclipse.m2m.internal.qvt.oml.editor.ui.completion.cst.parser;

public interface LightweightTypeParsersym {
    public final static int
      TK_NUMERIC_OPERATION = 71,
      TK_STRING_LITERAL = 39,
      TK_INTEGER_LITERAL = 55,
      TK_REAL_LITERAL = 56,
      TK_PLUS = 35,
      TK_MINUS = 36,
      TK_MULTIPLY = 15,
      TK_DIVIDE = 26,
      TK_GREATER = 21,
      TK_LESS = 22,
      TK_EQUAL = 4,
      TK_GREATER_EQUAL = 23,
      TK_LESS_EQUAL = 24,
      TK_NOT_EQUAL = 25,
      TK_LPAREN = 1,
      TK_RPAREN = 2,
      TK_LBRACE = 94,
      TK_RBRACE = 96,
      TK_LBRACKET = 100,
      TK_RBRACKET = 104,
      TK_ARROW = 107,
      TK_BAR = 97,
      TK_COMMA = 93,
      TK_COLON = 98,
      TK_COLONCOLON = 95,
      TK_SEMICOLON = 99,
      TK_DOT = 108,
      TK_DOTDOT = 115,
      TK_ATPRE = 102,
      TK_CARET = 109,
      TK_CARETCARET = 110,
      TK_QUESTIONMARK = 105,
      TK_ADD_ASSIGN = 116,
      TK_RESET_ASSIGN = 101,
      TK_AT_SIGN = 121,
      TK_EXCLAMATION_MARK = 106,
      TK_NOT_EQUAL_EXEQ = 103,
      TK_INTEGER_RANGE_START = 111,
      TK_class = 134,
      TK_composes = 135,
      TK_constructor = 136,
      TK_datatype = 137,
      TK_default = 138,
      TK_derived = 139,
      TK_do = 140,
      TK_elif = 141,
      TK_enum = 142,
      TK_except = 143,
      TK_exception = 144,
      TK_from = 145,
      TK_literal = 146,
      TK_ordered = 147,
      TK_primitive = 148,
      TK_raise = 149,
      TK_readonly = 150,
      TK_references = 151,
      TK_tag = 152,
      TK_try = 153,
      TK_typedef = 154,
      TK_unlimited = 155,
      TK_invalid = 156,
      TK_COLONCOLONEQUAL = 117,
      TK_STEREOTYPE_QUALIFIER_OPEN = 157,
      TK_STEREOTYPE_QUALIFIER_CLOSE = 158,
      TK_MULTIPLICITY_RANGE = 159,
      TK_TILDE_SIGN = 160,
      TK_self = 27,
      TK_inv = 161,
      TK_pre = 162,
      TK_post = 163,
      TK_endpackage = 164,
      TK_def = 165,
      TK_if = 72,
      TK_then = 118,
      TK_else = 112,
      TK_endif = 113,
      TK_and = 29,
      TK_or = 30,
      TK_xor = 31,
      TK_not = 57,
      TK_implies = 119,
      TK_let = 80,
      TK_in = 114,
      TK_true = 58,
      TK_false = 59,
      TK_body = 40,
      TK_derive = 41,
      TK_init = 166,
      TK_null = 32,
      TK_Set = 16,
      TK_Bag = 17,
      TK_Sequence = 18,
      TK_Collection = 19,
      TK_OrderedSet = 20,
      TK_iterate = 42,
      TK_forAll = 43,
      TK_exists = 44,
      TK_isUnique = 45,
      TK_any = 46,
      TK_one = 47,
      TK_collect = 48,
      TK_select = 49,
      TK_reject = 50,
      TK_collectNested = 51,
      TK_sortedBy = 52,
      TK_closure = 53,
      TK_oclIsKindOf = 60,
      TK_oclIsTypeOf = 61,
      TK_oclAsType = 62,
      TK_oclIsNew = 63,
      TK_oclIsUndefined = 64,
      TK_oclIsInvalid = 65,
      TK_oclIsInState = 66,
      TK_allInstances = 54,
      TK_String = 5,
      TK_Integer = 6,
      TK_UnlimitedNatural = 7,
      TK_Real = 8,
      TK_Boolean = 9,
      TK_Tuple = 33,
      TK_OclAny = 10,
      TK_OclVoid = 11,
      TK_Invalid = 12,
      TK_OclMessage = 13,
      TK_OclInvalid = 73,
      TK_end = 167,
      TK_while = 74,
      TK_when = 122,
      TK_var = 82,
      TK_log = 81,
      TK_assert = 83,
      TK_with = 123,
      TK_switch = 69,
      TK_case = 120,
      TK_xselect = 124,
      TK_xcollect = 125,
      TK_selectOne = 126,
      TK_collectOne = 127,
      TK_collectselect = 128,
      TK_collectselectOne = 129,
      TK_return = 84,
      TK_forEach = 130,
      TK_forOne = 131,
      TK_compute = 75,
      TK_new = 76,
      TK_List = 37,
      TK_Dict = 38,
      TK_break = 77,
      TK_continue = 78,
      TK_out = 168,
      TK_object = 79,
      TK_transformation = 169,
      TK_import = 170,
      TK_library = 171,
      TK_metamodel = 172,
      TK_mapping = 173,
      TK_query = 174,
      TK_helper = 175,
      TK_inout = 176,
      TK_configuration = 177,
      TK_intermediate = 178,
      TK_property = 179,
      TK_opposites = 180,
      TK_population = 181,
      TK_map = 67,
      TK_xmap = 68,
      TK_late = 70,
      TK_resolve = 85,
      TK_resolveone = 86,
      TK_resolveIn = 87,
      TK_resolveoneIn = 88,
      TK_invresolve = 89,
      TK_invresolveone = 90,
      TK_invresolveIn = 91,
      TK_invresolveoneIn = 92,
      TK_modeltype = 182,
      TK_uses = 183,
      TK_where = 184,
      TK_refines = 185,
      TK_access = 186,
      TK_extends = 187,
      TK_blackbox = 188,
      TK_abstract = 189,
      TK_static = 190,
      TK_result = 28,
      TK_main = 132,
      TK_this = 34,
      TK_rename = 191,
      TK_inherits = 192,
      TK_merges = 193,
      TK_disjuncts = 194,
      TK_IDENTIFIER = 3,
      TK_ERROR_TOKEN = 14,
      TK_EOF_TOKEN = 133;

      public final static String orderedTerminalSymbols[] = {
                 "",
                 "LPAREN",
                 "RPAREN",
                 "IDENTIFIER",
                 "EQUAL",
                 "String",
                 "Integer",
                 "UnlimitedNatural",
                 "Real",
                 "Boolean",
                 "OclAny",
                 "OclVoid",
                 "Invalid",
                 "OclMessage",
                 "ERROR_TOKEN",
                 "MULTIPLY",
                 "Set",
                 "Bag",
                 "Sequence",
                 "Collection",
                 "OrderedSet",
                 "GREATER",
                 "LESS",
                 "GREATER_EQUAL",
                 "LESS_EQUAL",
                 "NOT_EQUAL",
                 "DIVIDE",
                 "self",
                 "result",
                 "and",
                 "or",
                 "xor",
                 "null",
                 "Tuple",
                 "this",
                 "PLUS",
                 "MINUS",
                 "List",
                 "Dict",
                 "STRING_LITERAL",
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
                 "INTEGER_LITERAL",
                 "REAL_LITERAL",
                 "not",
                 "true",
                 "false",
                 "oclIsKindOf",
                 "oclIsTypeOf",
                 "oclAsType",
                 "oclIsNew",
                 "oclIsUndefined",
                 "oclIsInvalid",
                 "oclIsInState",
                 "map",
                 "xmap",
                 "switch",
                 "late",
                 "NUMERIC_OPERATION",
                 "if",
                 "OclInvalid",
                 "while",
                 "compute",
                 "new",
                 "break",
                 "continue",
                 "object",
                 "let",
                 "log",
                 "var",
                 "assert",
                 "return",
                 "resolve",
                 "resolveone",
                 "resolveIn",
                 "resolveoneIn",
                 "invresolve",
                 "invresolveone",
                 "invresolveIn",
                 "invresolveoneIn",
                 "COMMA",
                 "LBRACE",
                 "COLONCOLON",
                 "RBRACE",
                 "BAR",
                 "COLON",
                 "SEMICOLON",
                 "LBRACKET",
                 "RESET_ASSIGN",
                 "ATPRE",
                 "NOT_EQUAL_EXEQ",
                 "RBRACKET",
                 "QUESTIONMARK",
                 "EXCLAMATION_MARK",
                 "ARROW",
                 "DOT",
                 "CARET",
                 "CARETCARET",
                 "INTEGER_RANGE_START",
                 "else",
                 "endif",
                 "in",
                 "DOTDOT",
                 "ADD_ASSIGN",
                 "COLONCOLONEQUAL",
                 "then",
                 "implies",
                 "case",
                 "AT_SIGN",
                 "when",
                 "with",
                 "xselect",
                 "xcollect",
                 "selectOne",
                 "collectOne",
                 "collectselect",
                 "collectselectOne",
                 "forEach",
                 "forOne",
                 "main",
                 "EOF_TOKEN",
                 "class",
                 "composes",
                 "constructor",
                 "datatype",
                 "default",
                 "derived",
                 "do",
                 "elif",
                 "enum",
                 "except",
                 "exception",
                 "from",
                 "literal",
                 "ordered",
                 "primitive",
                 "raise",
                 "readonly",
                 "references",
                 "tag",
                 "try",
                 "typedef",
                 "unlimited",
                 "invalid",
                 "STEREOTYPE_QUALIFIER_OPEN",
                 "STEREOTYPE_QUALIFIER_CLOSE",
                 "MULTIPLICITY_RANGE",
                 "TILDE_SIGN",
                 "inv",
                 "pre",
                 "post",
                 "endpackage",
                 "def",
                 "init",
                 "end",
                 "out",
                 "transformation",
                 "import",
                 "library",
                 "metamodel",
                 "mapping",
                 "query",
                 "helper",
                 "inout",
                 "configuration",
                 "intermediate",
                 "property",
                 "opposites",
                 "population",
                 "modeltype",
                 "uses",
                 "where",
                 "refines",
                 "access",
                 "extends",
                 "blackbox",
                 "abstract",
                 "static",
                 "rename",
                 "inherits",
                 "merges",
                 "disjuncts"
             };

    public final static boolean isValidForParser = true;
}
