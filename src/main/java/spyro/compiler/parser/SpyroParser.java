// Generated from Spyro.g4 by ANTLR 4.13.1

package spyro.compiler.parser;

import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast", "CheckReturnValue"})
public class SpyroParser extends Parser {
	static { RuntimeMetaData.checkVersion("4.13.1", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__0=1, T__1=2, VARIABLES=3, SIGNATURES=4, RELATIONS=5, LANGUAGE=6, EXAMPLES=7, 
		ASSUMPTIONS=8, OR=9, AND=10, EQ=11, NEQ=12, GT=13, LT=14, GTEQ=15, LTEQ=16, 
		PLUS=17, MINUS=18, MULT=19, DIV=20, MOD=21, NOT=22, SEMI=23, ASSIGN=24, 
		LPAREN=25, RPAREN=26, LSQUAR=27, RSQUAR=28, LBRACE=29, RBRACE=30, ARROW=31, 
		LARROW=32, HIDDENVAR=33, TRUE=34, FALSE=35, NULL=36, HOLE=37, ID=38, INT=39, 
		FLOAT=40, STRING=41, COMMENT=42, SPACE=43, OTHER=44;
	public static final int
		RULE_parse = 0, RULE_program = 1, RULE_declVariables = 2, RULE_declVar = 3, 
		RULE_exGenNote = 4, RULE_declSignatures = 5, RULE_declSig = 6, RULE_declRelations = 7, 
		RULE_declRel = 8, RULE_declLanguage = 9, RULE_declLanguageRule = 10, RULE_declNonterminalParam = 11, 
		RULE_declExamples = 12, RULE_declExampleRule = 13, RULE_declAssumptions = 14, 
		RULE_declAssumption = 15, RULE_type = 16, RULE_expr = 17, RULE_atom = 18;
	private static String[] makeRuleNames() {
		return new String[] {
			"parse", "program", "declVariables", "declVar", "exGenNote", "declSignatures", 
			"declSig", "declRelations", "declRel", "declLanguage", "declLanguageRule", 
			"declNonterminalParam", "declExamples", "declExampleRule", "declAssumptions", 
			"declAssumption", "type", "expr", "atom"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "'|'", "','", "'variables'", "'signatures'", "'relations'", "'language'", 
			"'examples'", "'assumptions'", "'||'", "'&&'", "'=='", "'!='", "'>'", 
			"'<'", "'>='", "'<='", "'+'", "'-'", "'*'", "'/'", "'%'", "'!'", "';'", 
			"'='", "'('", "')'", "'['", "']'", "'{'", "'}'", "'->'", "'<-'", "'hidden'", 
			"'true'", "'false'", "'null'", "'??'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, null, null, "VARIABLES", "SIGNATURES", "RELATIONS", "LANGUAGE", 
			"EXAMPLES", "ASSUMPTIONS", "OR", "AND", "EQ", "NEQ", "GT", "LT", "GTEQ", 
			"LTEQ", "PLUS", "MINUS", "MULT", "DIV", "MOD", "NOT", "SEMI", "ASSIGN", 
			"LPAREN", "RPAREN", "LSQUAR", "RSQUAR", "LBRACE", "RBRACE", "ARROW", 
			"LARROW", "HIDDENVAR", "TRUE", "FALSE", "NULL", "HOLE", "ID", "INT", 
			"FLOAT", "STRING", "COMMENT", "SPACE", "OTHER"
		};
	}
	private static final String[] _SYMBOLIC_NAMES = makeSymbolicNames();
	public static final Vocabulary VOCABULARY = new VocabularyImpl(_LITERAL_NAMES, _SYMBOLIC_NAMES);

	/**
	 * @deprecated Use {@link #VOCABULARY} instead.
	 */
	@Deprecated
	public static final String[] tokenNames;
	static {
		tokenNames = new String[_SYMBOLIC_NAMES.length];
		for (int i = 0; i < tokenNames.length; i++) {
			tokenNames[i] = VOCABULARY.getLiteralName(i);
			if (tokenNames[i] == null) {
				tokenNames[i] = VOCABULARY.getSymbolicName(i);
			}

			if (tokenNames[i] == null) {
				tokenNames[i] = "<INVALID>";
			}
		}
	}

	@Override
	@Deprecated
	public String[] getTokenNames() {
		return tokenNames;
	}

	@Override

	public Vocabulary getVocabulary() {
		return VOCABULARY;
	}

	@Override
	public String getGrammarFileName() { return "Spyro.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }

	public SpyroParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@SuppressWarnings("CheckReturnValue")
	public static class ParseContext extends ParserRuleContext {
		public ProgramContext program() {
			return getRuleContext(ProgramContext.class,0);
		}
		public TerminalNode EOF() { return getToken(SpyroParser.EOF, 0); }
		public ParseContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_parse; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SpyroVisitor ) return ((SpyroVisitor<? extends T>)visitor).visitParse(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ParseContext parse() throws RecognitionException {
		ParseContext _localctx = new ParseContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_parse);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(38);
			program();
			setState(39);
			match(EOF);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class ProgramContext extends ParserRuleContext {
		public DeclVariablesContext declVariables() {
			return getRuleContext(DeclVariablesContext.class,0);
		}
		public DeclSignaturesContext declSignatures() {
			return getRuleContext(DeclSignaturesContext.class,0);
		}
		public DeclLanguageContext declLanguage() {
			return getRuleContext(DeclLanguageContext.class,0);
		}
		public DeclExamplesContext declExamples() {
			return getRuleContext(DeclExamplesContext.class,0);
		}
		public DeclRelationsContext declRelations() {
			return getRuleContext(DeclRelationsContext.class,0);
		}
		public DeclAssumptionsContext declAssumptions() {
			return getRuleContext(DeclAssumptionsContext.class,0);
		}
		public ProgramContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_program; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SpyroVisitor ) return ((SpyroVisitor<? extends T>)visitor).visitProgram(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ProgramContext program() throws RecognitionException {
		ProgramContext _localctx = new ProgramContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_program);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(41);
			declVariables();
			setState(42);
			declSignatures();
			setState(44);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==RELATIONS) {
				{
				setState(43);
				declRelations();
				}
			}

			setState(46);
			declLanguage();
			setState(47);
			declExamples();
			setState(49);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==ASSUMPTIONS) {
				{
				setState(48);
				declAssumptions();
				}
			}

			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class DeclVariablesContext extends ParserRuleContext {
		public TerminalNode VARIABLES() { return getToken(SpyroParser.VARIABLES, 0); }
		public TerminalNode LBRACE() { return getToken(SpyroParser.LBRACE, 0); }
		public TerminalNode RBRACE() { return getToken(SpyroParser.RBRACE, 0); }
		public List<DeclVarContext> declVar() {
			return getRuleContexts(DeclVarContext.class);
		}
		public DeclVarContext declVar(int i) {
			return getRuleContext(DeclVarContext.class,i);
		}
		public DeclVariablesContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_declVariables; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SpyroVisitor ) return ((SpyroVisitor<? extends T>)visitor).visitDeclVariables(this);
			else return visitor.visitChildren(this);
		}
	}

	public final DeclVariablesContext declVariables() throws RecognitionException {
		DeclVariablesContext _localctx = new DeclVariablesContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_declVariables);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(51);
			match(VARIABLES);
			setState(52);
			match(LBRACE);
			setState(54); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(53);
				declVar();
				}
				}
				setState(56); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( _la==HIDDENVAR || _la==ID );
			setState(58);
			match(RBRACE);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class DeclVarContext extends ParserRuleContext {
		public DeclVarContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_declVar; }
	 
		public DeclVarContext() { }
		public void copyFrom(DeclVarContext ctx) {
			super.copyFrom(ctx);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class DeclHiddenVarContext extends DeclVarContext {
		public TerminalNode HIDDENVAR() { return getToken(SpyroParser.HIDDENVAR, 0); }
		public TypeContext type() {
			return getRuleContext(TypeContext.class,0);
		}
		public TerminalNode ID() { return getToken(SpyroParser.ID, 0); }
		public TerminalNode SEMI() { return getToken(SpyroParser.SEMI, 0); }
		public ExGenNoteContext exGenNote() {
			return getRuleContext(ExGenNoteContext.class,0);
		}
		public DeclHiddenVarContext(DeclVarContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SpyroVisitor ) return ((SpyroVisitor<? extends T>)visitor).visitDeclHiddenVar(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class DeclVisibleVarContext extends DeclVarContext {
		public TypeContext type() {
			return getRuleContext(TypeContext.class,0);
		}
		public TerminalNode ID() { return getToken(SpyroParser.ID, 0); }
		public TerminalNode SEMI() { return getToken(SpyroParser.SEMI, 0); }
		public ExGenNoteContext exGenNote() {
			return getRuleContext(ExGenNoteContext.class,0);
		}
		public DeclVisibleVarContext(DeclVarContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SpyroVisitor ) return ((SpyroVisitor<? extends T>)visitor).visitDeclVisibleVar(this);
			else return visitor.visitChildren(this);
		}
	}

	public final DeclVarContext declVar() throws RecognitionException {
		DeclVarContext _localctx = new DeclVarContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_declVar);
		int _la;
		try {
			setState(75);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case ID:
				_localctx = new DeclVisibleVarContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(60);
				type(0);
				setState(61);
				match(ID);
				setState(63);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==LARROW) {
					{
					setState(62);
					exGenNote();
					}
				}

				setState(65);
				match(SEMI);
				}
				break;
			case HIDDENVAR:
				_localctx = new DeclHiddenVarContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(67);
				match(HIDDENVAR);
				setState(68);
				type(0);
				setState(69);
				match(ID);
				setState(71);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==LARROW) {
					{
					setState(70);
					exGenNote();
					}
				}

				setState(73);
				match(SEMI);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class ExGenNoteContext extends ParserRuleContext {
		public TerminalNode LARROW() { return getToken(SpyroParser.LARROW, 0); }
		public TerminalNode ID() { return getToken(SpyroParser.ID, 0); }
		public ExGenNoteContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_exGenNote; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SpyroVisitor ) return ((SpyroVisitor<? extends T>)visitor).visitExGenNote(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ExGenNoteContext exGenNote() throws RecognitionException {
		ExGenNoteContext _localctx = new ExGenNoteContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_exGenNote);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(77);
			match(LARROW);
			setState(78);
			match(ID);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class DeclSignaturesContext extends ParserRuleContext {
		public TerminalNode SIGNATURES() { return getToken(SpyroParser.SIGNATURES, 0); }
		public TerminalNode LBRACE() { return getToken(SpyroParser.LBRACE, 0); }
		public TerminalNode RBRACE() { return getToken(SpyroParser.RBRACE, 0); }
		public List<DeclSigContext> declSig() {
			return getRuleContexts(DeclSigContext.class);
		}
		public DeclSigContext declSig(int i) {
			return getRuleContext(DeclSigContext.class,i);
		}
		public DeclSignaturesContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_declSignatures; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SpyroVisitor ) return ((SpyroVisitor<? extends T>)visitor).visitDeclSignatures(this);
			else return visitor.visitChildren(this);
		}
	}

	public final DeclSignaturesContext declSignatures() throws RecognitionException {
		DeclSignaturesContext _localctx = new DeclSignaturesContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_declSignatures);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(80);
			match(SIGNATURES);
			setState(81);
			match(LBRACE);
			setState(85);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & 1082369769472L) != 0)) {
				{
				{
				setState(82);
				declSig();
				}
				}
				setState(87);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(88);
			match(RBRACE);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class DeclSigContext extends ParserRuleContext {
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public TerminalNode SEMI() { return getToken(SpyroParser.SEMI, 0); }
		public DeclSigContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_declSig; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SpyroVisitor ) return ((SpyroVisitor<? extends T>)visitor).visitDeclSig(this);
			else return visitor.visitChildren(this);
		}
	}

	public final DeclSigContext declSig() throws RecognitionException {
		DeclSigContext _localctx = new DeclSigContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_declSig);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(90);
			expr(0);
			setState(91);
			match(SEMI);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class DeclRelationsContext extends ParserRuleContext {
		public TerminalNode RELATIONS() { return getToken(SpyroParser.RELATIONS, 0); }
		public TerminalNode LBRACE() { return getToken(SpyroParser.LBRACE, 0); }
		public TerminalNode RBRACE() { return getToken(SpyroParser.RBRACE, 0); }
		public List<DeclRelContext> declRel() {
			return getRuleContexts(DeclRelContext.class);
		}
		public DeclRelContext declRel(int i) {
			return getRuleContext(DeclRelContext.class,i);
		}
		public DeclRelationsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_declRelations; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SpyroVisitor ) return ((SpyroVisitor<? extends T>)visitor).visitDeclRelations(this);
			else return visitor.visitChildren(this);
		}
	}

	public final DeclRelationsContext declRelations() throws RecognitionException {
		DeclRelationsContext _localctx = new DeclRelationsContext(_ctx, getState());
		enterRule(_localctx, 14, RULE_declRelations);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(93);
			match(RELATIONS);
			setState(94);
			match(LBRACE);
			setState(96); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(95);
				declRel();
				}
				}
				setState(98); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & 1082369769472L) != 0) );
			setState(100);
			match(RBRACE);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class DeclRelContext extends ParserRuleContext {
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public TerminalNode SEMI() { return getToken(SpyroParser.SEMI, 0); }
		public DeclRelContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_declRel; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SpyroVisitor ) return ((SpyroVisitor<? extends T>)visitor).visitDeclRel(this);
			else return visitor.visitChildren(this);
		}
	}

	public final DeclRelContext declRel() throws RecognitionException {
		DeclRelContext _localctx = new DeclRelContext(_ctx, getState());
		enterRule(_localctx, 16, RULE_declRel);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(102);
			expr(0);
			setState(103);
			match(SEMI);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class DeclLanguageContext extends ParserRuleContext {
		public TerminalNode LANGUAGE() { return getToken(SpyroParser.LANGUAGE, 0); }
		public TerminalNode LBRACE() { return getToken(SpyroParser.LBRACE, 0); }
		public TerminalNode RBRACE() { return getToken(SpyroParser.RBRACE, 0); }
		public List<DeclLanguageRuleContext> declLanguageRule() {
			return getRuleContexts(DeclLanguageRuleContext.class);
		}
		public DeclLanguageRuleContext declLanguageRule(int i) {
			return getRuleContext(DeclLanguageRuleContext.class,i);
		}
		public DeclLanguageContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_declLanguage; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SpyroVisitor ) return ((SpyroVisitor<? extends T>)visitor).visitDeclLanguage(this);
			else return visitor.visitChildren(this);
		}
	}

	public final DeclLanguageContext declLanguage() throws RecognitionException {
		DeclLanguageContext _localctx = new DeclLanguageContext(_ctx, getState());
		enterRule(_localctx, 18, RULE_declLanguage);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(105);
			match(LANGUAGE);
			setState(106);
			match(LBRACE);
			setState(108); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(107);
				declLanguageRule();
				}
				}
				setState(110); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( _la==ID );
			setState(112);
			match(RBRACE);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class DeclLanguageRuleContext extends ParserRuleContext {
		public TypeContext type() {
			return getRuleContext(TypeContext.class,0);
		}
		public TerminalNode ID() { return getToken(SpyroParser.ID, 0); }
		public TerminalNode ARROW() { return getToken(SpyroParser.ARROW, 0); }
		public TerminalNode SEMI() { return getToken(SpyroParser.SEMI, 0); }
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public DeclNonterminalParamContext declNonterminalParam() {
			return getRuleContext(DeclNonterminalParamContext.class,0);
		}
		public DeclLanguageRuleContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_declLanguageRule; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SpyroVisitor ) return ((SpyroVisitor<? extends T>)visitor).visitDeclLanguageRule(this);
			else return visitor.visitChildren(this);
		}
	}

	public final DeclLanguageRuleContext declLanguageRule() throws RecognitionException {
		DeclLanguageRuleContext _localctx = new DeclLanguageRuleContext(_ctx, getState());
		enterRule(_localctx, 20, RULE_declLanguageRule);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(114);
			type(0);
			setState(115);
			match(ID);
			setState(117);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==LSQUAR) {
				{
				setState(116);
				declNonterminalParam();
				}
			}

			setState(119);
			match(ARROW);
			{
			setState(120);
			expr(0);
			setState(125);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__0) {
				{
				{
				setState(121);
				match(T__0);
				setState(122);
				expr(0);
				}
				}
				setState(127);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
			setState(128);
			match(SEMI);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class DeclNonterminalParamContext extends ParserRuleContext {
		public TerminalNode LSQUAR() { return getToken(SpyroParser.LSQUAR, 0); }
		public TerminalNode RSQUAR() { return getToken(SpyroParser.RSQUAR, 0); }
		public List<TerminalNode> ID() { return getTokens(SpyroParser.ID); }
		public TerminalNode ID(int i) {
			return getToken(SpyroParser.ID, i);
		}
		public DeclNonterminalParamContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_declNonterminalParam; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SpyroVisitor ) return ((SpyroVisitor<? extends T>)visitor).visitDeclNonterminalParam(this);
			else return visitor.visitChildren(this);
		}
	}

	public final DeclNonterminalParamContext declNonterminalParam() throws RecognitionException {
		DeclNonterminalParamContext _localctx = new DeclNonterminalParamContext(_ctx, getState());
		enterRule(_localctx, 22, RULE_declNonterminalParam);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(130);
			match(LSQUAR);
			setState(139);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==ID) {
				{
				setState(131);
				match(ID);
				setState(136);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==T__1) {
					{
					{
					setState(132);
					match(T__1);
					setState(133);
					match(ID);
					}
					}
					setState(138);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
			}

			setState(141);
			match(RSQUAR);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class DeclExamplesContext extends ParserRuleContext {
		public TerminalNode EXAMPLES() { return getToken(SpyroParser.EXAMPLES, 0); }
		public TerminalNode LBRACE() { return getToken(SpyroParser.LBRACE, 0); }
		public TerminalNode RBRACE() { return getToken(SpyroParser.RBRACE, 0); }
		public List<DeclExampleRuleContext> declExampleRule() {
			return getRuleContexts(DeclExampleRuleContext.class);
		}
		public DeclExampleRuleContext declExampleRule(int i) {
			return getRuleContext(DeclExampleRuleContext.class,i);
		}
		public DeclExamplesContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_declExamples; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SpyroVisitor ) return ((SpyroVisitor<? extends T>)visitor).visitDeclExamples(this);
			else return visitor.visitChildren(this);
		}
	}

	public final DeclExamplesContext declExamples() throws RecognitionException {
		DeclExamplesContext _localctx = new DeclExamplesContext(_ctx, getState());
		enterRule(_localctx, 24, RULE_declExamples);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(143);
			match(EXAMPLES);
			setState(144);
			match(LBRACE);
			setState(148);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==ID) {
				{
				{
				setState(145);
				declExampleRule();
				}
				}
				setState(150);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(151);
			match(RBRACE);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class DeclExampleRuleContext extends ParserRuleContext {
		public TypeContext type() {
			return getRuleContext(TypeContext.class,0);
		}
		public TerminalNode ID() { return getToken(SpyroParser.ID, 0); }
		public TerminalNode ARROW() { return getToken(SpyroParser.ARROW, 0); }
		public TerminalNode SEMI() { return getToken(SpyroParser.SEMI, 0); }
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public DeclExampleRuleContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_declExampleRule; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SpyroVisitor ) return ((SpyroVisitor<? extends T>)visitor).visitDeclExampleRule(this);
			else return visitor.visitChildren(this);
		}
	}

	public final DeclExampleRuleContext declExampleRule() throws RecognitionException {
		DeclExampleRuleContext _localctx = new DeclExampleRuleContext(_ctx, getState());
		enterRule(_localctx, 26, RULE_declExampleRule);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(153);
			type(0);
			setState(154);
			match(ID);
			setState(155);
			match(ARROW);
			{
			setState(156);
			expr(0);
			setState(161);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__0) {
				{
				{
				setState(157);
				match(T__0);
				setState(158);
				expr(0);
				}
				}
				setState(163);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
			setState(164);
			match(SEMI);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class DeclAssumptionsContext extends ParserRuleContext {
		public TerminalNode ASSUMPTIONS() { return getToken(SpyroParser.ASSUMPTIONS, 0); }
		public TerminalNode LBRACE() { return getToken(SpyroParser.LBRACE, 0); }
		public TerminalNode RBRACE() { return getToken(SpyroParser.RBRACE, 0); }
		public List<DeclAssumptionContext> declAssumption() {
			return getRuleContexts(DeclAssumptionContext.class);
		}
		public DeclAssumptionContext declAssumption(int i) {
			return getRuleContext(DeclAssumptionContext.class,i);
		}
		public DeclAssumptionsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_declAssumptions; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SpyroVisitor ) return ((SpyroVisitor<? extends T>)visitor).visitDeclAssumptions(this);
			else return visitor.visitChildren(this);
		}
	}

	public final DeclAssumptionsContext declAssumptions() throws RecognitionException {
		DeclAssumptionsContext _localctx = new DeclAssumptionsContext(_ctx, getState());
		enterRule(_localctx, 28, RULE_declAssumptions);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(166);
			match(ASSUMPTIONS);
			setState(167);
			match(LBRACE);
			setState(169); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(168);
				declAssumption();
				}
				}
				setState(171); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & 1082369769472L) != 0) );
			setState(173);
			match(RBRACE);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class DeclAssumptionContext extends ParserRuleContext {
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public TerminalNode SEMI() { return getToken(SpyroParser.SEMI, 0); }
		public DeclAssumptionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_declAssumption; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SpyroVisitor ) return ((SpyroVisitor<? extends T>)visitor).visitDeclAssumption(this);
			else return visitor.visitChildren(this);
		}
	}

	public final DeclAssumptionContext declAssumption() throws RecognitionException {
		DeclAssumptionContext _localctx = new DeclAssumptionContext(_ctx, getState());
		enterRule(_localctx, 30, RULE_declAssumption);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(175);
			expr(0);
			setState(176);
			match(SEMI);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class TypeContext extends ParserRuleContext {
		public TypeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_type; }
	 
		public TypeContext() { }
		public void copyFrom(TypeContext ctx) {
			super.copyFrom(ctx);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class ArrayTypeContext extends TypeContext {
		public TypeContext type() {
			return getRuleContext(TypeContext.class,0);
		}
		public TerminalNode LSQUAR() { return getToken(SpyroParser.LSQUAR, 0); }
		public TerminalNode INT() { return getToken(SpyroParser.INT, 0); }
		public TerminalNode RSQUAR() { return getToken(SpyroParser.RSQUAR, 0); }
		public ArrayTypeContext(TypeContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SpyroVisitor ) return ((SpyroVisitor<? extends T>)visitor).visitArrayType(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class ScalarTypeContext extends TypeContext {
		public TerminalNode ID() { return getToken(SpyroParser.ID, 0); }
		public ScalarTypeContext(TypeContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SpyroVisitor ) return ((SpyroVisitor<? extends T>)visitor).visitScalarType(this);
			else return visitor.visitChildren(this);
		}
	}

	public final TypeContext type() throws RecognitionException {
		return type(0);
	}

	private TypeContext type(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		TypeContext _localctx = new TypeContext(_ctx, _parentState);
		TypeContext _prevctx = _localctx;
		int _startState = 32;
		enterRecursionRule(_localctx, 32, RULE_type, _p);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			{
			_localctx = new ScalarTypeContext(_localctx);
			_ctx = _localctx;
			_prevctx = _localctx;

			setState(179);
			match(ID);
			}
			_ctx.stop = _input.LT(-1);
			setState(187);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,16,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					{
					_localctx = new ArrayTypeContext(new TypeContext(_parentctx, _parentState));
					pushNewRecursionContext(_localctx, _startState, RULE_type);
					setState(181);
					if (!(precpred(_ctx, 1))) throw new FailedPredicateException(this, "precpred(_ctx, 1)");
					setState(182);
					match(LSQUAR);
					setState(183);
					match(INT);
					setState(184);
					match(RSQUAR);
					}
					} 
				}
				setState(189);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,16,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			unrollRecursionContexts(_parentctx);
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class ExprContext extends ParserRuleContext {
		public ExprContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_expr; }
	 
		public ExprContext() { }
		public void copyFrom(ExprContext ctx) {
			super.copyFrom(ctx);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class NontFuncExprContext extends ExprContext {
		public TerminalNode ID() { return getToken(SpyroParser.ID, 0); }
		public TerminalNode LSQUAR() { return getToken(SpyroParser.LSQUAR, 0); }
		public TerminalNode RSQUAR() { return getToken(SpyroParser.RSQUAR, 0); }
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public NontFuncExprContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SpyroVisitor ) return ((SpyroVisitor<? extends T>)visitor).visitNontFuncExpr(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class AtomExprContext extends ExprContext {
		public AtomContext atom() {
			return getRuleContext(AtomContext.class,0);
		}
		public AtomExprContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SpyroVisitor ) return ((SpyroVisitor<? extends T>)visitor).visitAtomExpr(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class OrExprContext extends ExprContext {
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public TerminalNode OR() { return getToken(SpyroParser.OR, 0); }
		public OrExprContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SpyroVisitor ) return ((SpyroVisitor<? extends T>)visitor).visitOrExpr(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class AdditiveExprContext extends ExprContext {
		public Token op;
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public TerminalNode PLUS() { return getToken(SpyroParser.PLUS, 0); }
		public TerminalNode MINUS() { return getToken(SpyroParser.MINUS, 0); }
		public AdditiveExprContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SpyroVisitor ) return ((SpyroVisitor<? extends T>)visitor).visitAdditiveExpr(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class RelationalExprContext extends ExprContext {
		public Token op;
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public TerminalNode LTEQ() { return getToken(SpyroParser.LTEQ, 0); }
		public TerminalNode GTEQ() { return getToken(SpyroParser.GTEQ, 0); }
		public TerminalNode LT() { return getToken(SpyroParser.LT, 0); }
		public TerminalNode GT() { return getToken(SpyroParser.GT, 0); }
		public RelationalExprContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SpyroVisitor ) return ((SpyroVisitor<? extends T>)visitor).visitRelationalExpr(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class AnonFuncExprContext extends ExprContext {
		public TerminalNode LPAREN() { return getToken(SpyroParser.LPAREN, 0); }
		public List<TerminalNode> ID() { return getTokens(SpyroParser.ID); }
		public TerminalNode ID(int i) {
			return getToken(SpyroParser.ID, i);
		}
		public TerminalNode RPAREN() { return getToken(SpyroParser.RPAREN, 0); }
		public TerminalNode ARROW() { return getToken(SpyroParser.ARROW, 0); }
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public AnonFuncExprContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SpyroVisitor ) return ((SpyroVisitor<? extends T>)visitor).visitAnonFuncExpr(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class ParenExprContext extends ExprContext {
		public TerminalNode LPAREN() { return getToken(SpyroParser.LPAREN, 0); }
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public TerminalNode RPAREN() { return getToken(SpyroParser.RPAREN, 0); }
		public ParenExprContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SpyroVisitor ) return ((SpyroVisitor<? extends T>)visitor).visitParenExpr(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class FunctionExprContext extends ExprContext {
		public TerminalNode ID() { return getToken(SpyroParser.ID, 0); }
		public TerminalNode LPAREN() { return getToken(SpyroParser.LPAREN, 0); }
		public TerminalNode RPAREN() { return getToken(SpyroParser.RPAREN, 0); }
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public FunctionExprContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SpyroVisitor ) return ((SpyroVisitor<? extends T>)visitor).visitFunctionExpr(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class NotExprContext extends ExprContext {
		public TerminalNode NOT() { return getToken(SpyroParser.NOT, 0); }
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public NotExprContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SpyroVisitor ) return ((SpyroVisitor<? extends T>)visitor).visitNotExpr(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class UnaryMinusExprContext extends ExprContext {
		public TerminalNode MINUS() { return getToken(SpyroParser.MINUS, 0); }
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public UnaryMinusExprContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SpyroVisitor ) return ((SpyroVisitor<? extends T>)visitor).visitUnaryMinusExpr(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class MultiplicationExprContext extends ExprContext {
		public Token op;
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public TerminalNode MULT() { return getToken(SpyroParser.MULT, 0); }
		public TerminalNode DIV() { return getToken(SpyroParser.DIV, 0); }
		public TerminalNode MOD() { return getToken(SpyroParser.MOD, 0); }
		public MultiplicationExprContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SpyroVisitor ) return ((SpyroVisitor<? extends T>)visitor).visitMultiplicationExpr(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class EqualityExprContext extends ExprContext {
		public Token op;
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public TerminalNode EQ() { return getToken(SpyroParser.EQ, 0); }
		public TerminalNode NEQ() { return getToken(SpyroParser.NEQ, 0); }
		public EqualityExprContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SpyroVisitor ) return ((SpyroVisitor<? extends T>)visitor).visitEqualityExpr(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class AndExprContext extends ExprContext {
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public TerminalNode AND() { return getToken(SpyroParser.AND, 0); }
		public AndExprContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SpyroVisitor ) return ((SpyroVisitor<? extends T>)visitor).visitAndExpr(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ExprContext expr() throws RecognitionException {
		return expr(0);
	}

	private ExprContext expr(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		ExprContext _localctx = new ExprContext(_ctx, _parentState);
		ExprContext _prevctx = _localctx;
		int _startState = 34;
		enterRecursionRule(_localctx, 34, RULE_expr, _p);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(238);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,22,_ctx) ) {
			case 1:
				{
				_localctx = new AnonFuncExprContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;

				setState(191);
				match(LPAREN);
				setState(192);
				match(ID);
				setState(197);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==T__1) {
					{
					{
					setState(193);
					match(T__1);
					setState(194);
					match(ID);
					}
					}
					setState(199);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(200);
				match(RPAREN);
				setState(201);
				match(ARROW);
				setState(202);
				expr(13);
				}
				break;
			case 2:
				{
				_localctx = new ParenExprContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(203);
				match(LPAREN);
				setState(204);
				expr(0);
				setState(205);
				match(RPAREN);
				}
				break;
			case 3:
				{
				_localctx = new FunctionExprContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(207);
				match(ID);
				setState(208);
				match(LPAREN);
				setState(217);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & 1082369769472L) != 0)) {
					{
					setState(209);
					expr(0);
					setState(214);
					_errHandler.sync(this);
					_la = _input.LA(1);
					while (_la==T__1) {
						{
						{
						setState(210);
						match(T__1);
						setState(211);
						expr(0);
						}
						}
						setState(216);
						_errHandler.sync(this);
						_la = _input.LA(1);
					}
					}
				}

				setState(219);
				match(RPAREN);
				}
				break;
			case 4:
				{
				_localctx = new UnaryMinusExprContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(220);
				match(MINUS);
				setState(221);
				expr(10);
				}
				break;
			case 5:
				{
				_localctx = new NotExprContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(222);
				match(NOT);
				setState(223);
				expr(9);
				}
				break;
			case 6:
				{
				_localctx = new AtomExprContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(224);
				atom();
				}
				break;
			case 7:
				{
				_localctx = new NontFuncExprContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(225);
				match(ID);
				setState(226);
				match(LSQUAR);
				setState(235);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & 1082369769472L) != 0)) {
					{
					setState(227);
					expr(0);
					setState(232);
					_errHandler.sync(this);
					_la = _input.LA(1);
					while (_la==T__1) {
						{
						{
						setState(228);
						match(T__1);
						setState(229);
						expr(0);
						}
						}
						setState(234);
						_errHandler.sync(this);
						_la = _input.LA(1);
					}
					}
				}

				setState(237);
				match(RSQUAR);
				}
				break;
			}
			_ctx.stop = _input.LT(-1);
			setState(260);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,24,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(258);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,23,_ctx) ) {
					case 1:
						{
						_localctx = new MultiplicationExprContext(new ExprContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(240);
						if (!(precpred(_ctx, 8))) throw new FailedPredicateException(this, "precpred(_ctx, 8)");
						setState(241);
						((MultiplicationExprContext)_localctx).op = _input.LT(1);
						_la = _input.LA(1);
						if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & 3670016L) != 0)) ) {
							((MultiplicationExprContext)_localctx).op = (Token)_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(242);
						expr(9);
						}
						break;
					case 2:
						{
						_localctx = new AdditiveExprContext(new ExprContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(243);
						if (!(precpred(_ctx, 7))) throw new FailedPredicateException(this, "precpred(_ctx, 7)");
						setState(244);
						((AdditiveExprContext)_localctx).op = _input.LT(1);
						_la = _input.LA(1);
						if ( !(_la==PLUS || _la==MINUS) ) {
							((AdditiveExprContext)_localctx).op = (Token)_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(245);
						expr(8);
						}
						break;
					case 3:
						{
						_localctx = new RelationalExprContext(new ExprContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(246);
						if (!(precpred(_ctx, 6))) throw new FailedPredicateException(this, "precpred(_ctx, 6)");
						setState(247);
						((RelationalExprContext)_localctx).op = _input.LT(1);
						_la = _input.LA(1);
						if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & 122880L) != 0)) ) {
							((RelationalExprContext)_localctx).op = (Token)_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(248);
						expr(7);
						}
						break;
					case 4:
						{
						_localctx = new EqualityExprContext(new ExprContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(249);
						if (!(precpred(_ctx, 5))) throw new FailedPredicateException(this, "precpred(_ctx, 5)");
						setState(250);
						((EqualityExprContext)_localctx).op = _input.LT(1);
						_la = _input.LA(1);
						if ( !(_la==EQ || _la==NEQ) ) {
							((EqualityExprContext)_localctx).op = (Token)_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(251);
						expr(6);
						}
						break;
					case 5:
						{
						_localctx = new AndExprContext(new ExprContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(252);
						if (!(precpred(_ctx, 4))) throw new FailedPredicateException(this, "precpred(_ctx, 4)");
						setState(253);
						match(AND);
						setState(254);
						expr(5);
						}
						break;
					case 6:
						{
						_localctx = new OrExprContext(new ExprContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(255);
						if (!(precpred(_ctx, 3))) throw new FailedPredicateException(this, "precpred(_ctx, 3)");
						setState(256);
						match(OR);
						setState(257);
						expr(4);
						}
						break;
					}
					} 
				}
				setState(262);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,24,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			unrollRecursionContexts(_parentctx);
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class AtomContext extends ParserRuleContext {
		public AtomContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_atom; }
	 
		public AtomContext() { }
		public void copyFrom(AtomContext ctx) {
			super.copyFrom(ctx);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class BooleanAtomContext extends AtomContext {
		public TerminalNode TRUE() { return getToken(SpyroParser.TRUE, 0); }
		public TerminalNode FALSE() { return getToken(SpyroParser.FALSE, 0); }
		public BooleanAtomContext(AtomContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SpyroVisitor ) return ((SpyroVisitor<? extends T>)visitor).visitBooleanAtom(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class IdAtomContext extends AtomContext {
		public TerminalNode ID() { return getToken(SpyroParser.ID, 0); }
		public IdAtomContext(AtomContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SpyroVisitor ) return ((SpyroVisitor<? extends T>)visitor).visitIdAtom(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class SizedHoleAtomContext extends AtomContext {
		public TerminalNode HOLE() { return getToken(SpyroParser.HOLE, 0); }
		public TerminalNode LPAREN() { return getToken(SpyroParser.LPAREN, 0); }
		public TerminalNode INT() { return getToken(SpyroParser.INT, 0); }
		public TerminalNode RPAREN() { return getToken(SpyroParser.RPAREN, 0); }
		public SizedHoleAtomContext(AtomContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SpyroVisitor ) return ((SpyroVisitor<? extends T>)visitor).visitSizedHoleAtom(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class UnsizedHoleAtomContext extends AtomContext {
		public TerminalNode HOLE() { return getToken(SpyroParser.HOLE, 0); }
		public UnsizedHoleAtomContext(AtomContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SpyroVisitor ) return ((SpyroVisitor<? extends T>)visitor).visitUnsizedHoleAtom(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class NumberAtomContext extends AtomContext {
		public TerminalNode INT() { return getToken(SpyroParser.INT, 0); }
		public NumberAtomContext(AtomContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SpyroVisitor ) return ((SpyroVisitor<? extends T>)visitor).visitNumberAtom(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class NullAtomContext extends AtomContext {
		public TerminalNode NULL() { return getToken(SpyroParser.NULL, 0); }
		public NullAtomContext(AtomContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SpyroVisitor ) return ((SpyroVisitor<? extends T>)visitor).visitNullAtom(this);
			else return visitor.visitChildren(this);
		}
	}

	public final AtomContext atom() throws RecognitionException {
		AtomContext _localctx = new AtomContext(_ctx, getState());
		enterRule(_localctx, 36, RULE_atom);
		int _la;
		try {
			setState(272);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,25,_ctx) ) {
			case 1:
				_localctx = new NumberAtomContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(263);
				match(INT);
				}
				break;
			case 2:
				_localctx = new BooleanAtomContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(264);
				_la = _input.LA(1);
				if ( !(_la==TRUE || _la==FALSE) ) {
				_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				}
				break;
			case 3:
				_localctx = new IdAtomContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(265);
				match(ID);
				}
				break;
			case 4:
				_localctx = new NullAtomContext(_localctx);
				enterOuterAlt(_localctx, 4);
				{
				setState(266);
				match(NULL);
				}
				break;
			case 5:
				_localctx = new UnsizedHoleAtomContext(_localctx);
				enterOuterAlt(_localctx, 5);
				{
				setState(267);
				match(HOLE);
				}
				break;
			case 6:
				_localctx = new SizedHoleAtomContext(_localctx);
				enterOuterAlt(_localctx, 6);
				{
				setState(268);
				match(HOLE);
				setState(269);
				match(LPAREN);
				setState(270);
				match(INT);
				setState(271);
				match(RPAREN);
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public boolean sempred(RuleContext _localctx, int ruleIndex, int predIndex) {
		switch (ruleIndex) {
		case 16:
			return type_sempred((TypeContext)_localctx, predIndex);
		case 17:
			return expr_sempred((ExprContext)_localctx, predIndex);
		}
		return true;
	}
	private boolean type_sempred(TypeContext _localctx, int predIndex) {
		switch (predIndex) {
		case 0:
			return precpred(_ctx, 1);
		}
		return true;
	}
	private boolean expr_sempred(ExprContext _localctx, int predIndex) {
		switch (predIndex) {
		case 1:
			return precpred(_ctx, 8);
		case 2:
			return precpred(_ctx, 7);
		case 3:
			return precpred(_ctx, 6);
		case 4:
			return precpred(_ctx, 5);
		case 5:
			return precpred(_ctx, 4);
		case 6:
			return precpred(_ctx, 3);
		}
		return true;
	}

	public static final String _serializedATN =
		"\u0004\u0001,\u0113\u0002\u0000\u0007\u0000\u0002\u0001\u0007\u0001\u0002"+
		"\u0002\u0007\u0002\u0002\u0003\u0007\u0003\u0002\u0004\u0007\u0004\u0002"+
		"\u0005\u0007\u0005\u0002\u0006\u0007\u0006\u0002\u0007\u0007\u0007\u0002"+
		"\b\u0007\b\u0002\t\u0007\t\u0002\n\u0007\n\u0002\u000b\u0007\u000b\u0002"+
		"\f\u0007\f\u0002\r\u0007\r\u0002\u000e\u0007\u000e\u0002\u000f\u0007\u000f"+
		"\u0002\u0010\u0007\u0010\u0002\u0011\u0007\u0011\u0002\u0012\u0007\u0012"+
		"\u0001\u0000\u0001\u0000\u0001\u0000\u0001\u0001\u0001\u0001\u0001\u0001"+
		"\u0003\u0001-\b\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0003\u0001"+
		"2\b\u0001\u0001\u0002\u0001\u0002\u0001\u0002\u0004\u00027\b\u0002\u000b"+
		"\u0002\f\u00028\u0001\u0002\u0001\u0002\u0001\u0003\u0001\u0003\u0001"+
		"\u0003\u0003\u0003@\b\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0001"+
		"\u0003\u0001\u0003\u0001\u0003\u0003\u0003H\b\u0003\u0001\u0003\u0001"+
		"\u0003\u0003\u0003L\b\u0003\u0001\u0004\u0001\u0004\u0001\u0004\u0001"+
		"\u0005\u0001\u0005\u0001\u0005\u0005\u0005T\b\u0005\n\u0005\f\u0005W\t"+
		"\u0005\u0001\u0005\u0001\u0005\u0001\u0006\u0001\u0006\u0001\u0006\u0001"+
		"\u0007\u0001\u0007\u0001\u0007\u0004\u0007a\b\u0007\u000b\u0007\f\u0007"+
		"b\u0001\u0007\u0001\u0007\u0001\b\u0001\b\u0001\b\u0001\t\u0001\t\u0001"+
		"\t\u0004\tm\b\t\u000b\t\f\tn\u0001\t\u0001\t\u0001\n\u0001\n\u0001\n\u0003"+
		"\nv\b\n\u0001\n\u0001\n\u0001\n\u0001\n\u0005\n|\b\n\n\n\f\n\u007f\t\n"+
		"\u0001\n\u0001\n\u0001\u000b\u0001\u000b\u0001\u000b\u0001\u000b\u0005"+
		"\u000b\u0087\b\u000b\n\u000b\f\u000b\u008a\t\u000b\u0003\u000b\u008c\b"+
		"\u000b\u0001\u000b\u0001\u000b\u0001\f\u0001\f\u0001\f\u0005\f\u0093\b"+
		"\f\n\f\f\f\u0096\t\f\u0001\f\u0001\f\u0001\r\u0001\r\u0001\r\u0001\r\u0001"+
		"\r\u0001\r\u0005\r\u00a0\b\r\n\r\f\r\u00a3\t\r\u0001\r\u0001\r\u0001\u000e"+
		"\u0001\u000e\u0001\u000e\u0004\u000e\u00aa\b\u000e\u000b\u000e\f\u000e"+
		"\u00ab\u0001\u000e\u0001\u000e\u0001\u000f\u0001\u000f\u0001\u000f\u0001"+
		"\u0010\u0001\u0010\u0001\u0010\u0001\u0010\u0001\u0010\u0001\u0010\u0001"+
		"\u0010\u0005\u0010\u00ba\b\u0010\n\u0010\f\u0010\u00bd\t\u0010\u0001\u0011"+
		"\u0001\u0011\u0001\u0011\u0001\u0011\u0001\u0011\u0005\u0011\u00c4\b\u0011"+
		"\n\u0011\f\u0011\u00c7\t\u0011\u0001\u0011\u0001\u0011\u0001\u0011\u0001"+
		"\u0011\u0001\u0011\u0001\u0011\u0001\u0011\u0001\u0011\u0001\u0011\u0001"+
		"\u0011\u0001\u0011\u0001\u0011\u0005\u0011\u00d5\b\u0011\n\u0011\f\u0011"+
		"\u00d8\t\u0011\u0003\u0011\u00da\b\u0011\u0001\u0011\u0001\u0011\u0001"+
		"\u0011\u0001\u0011\u0001\u0011\u0001\u0011\u0001\u0011\u0001\u0011\u0001"+
		"\u0011\u0001\u0011\u0001\u0011\u0005\u0011\u00e7\b\u0011\n\u0011\f\u0011"+
		"\u00ea\t\u0011\u0003\u0011\u00ec\b\u0011\u0001\u0011\u0003\u0011\u00ef"+
		"\b\u0011\u0001\u0011\u0001\u0011\u0001\u0011\u0001\u0011\u0001\u0011\u0001"+
		"\u0011\u0001\u0011\u0001\u0011\u0001\u0011\u0001\u0011\u0001\u0011\u0001"+
		"\u0011\u0001\u0011\u0001\u0011\u0001\u0011\u0001\u0011\u0001\u0011\u0001"+
		"\u0011\u0005\u0011\u0103\b\u0011\n\u0011\f\u0011\u0106\t\u0011\u0001\u0012"+
		"\u0001\u0012\u0001\u0012\u0001\u0012\u0001\u0012\u0001\u0012\u0001\u0012"+
		"\u0001\u0012\u0001\u0012\u0003\u0012\u0111\b\u0012\u0001\u0012\u0000\u0002"+
		" \"\u0013\u0000\u0002\u0004\u0006\b\n\f\u000e\u0010\u0012\u0014\u0016"+
		"\u0018\u001a\u001c\u001e \"$\u0000\u0005\u0001\u0000\u0013\u0015\u0001"+
		"\u0000\u0011\u0012\u0001\u0000\r\u0010\u0001\u0000\u000b\f\u0001\u0000"+
		"\"#\u0126\u0000&\u0001\u0000\u0000\u0000\u0002)\u0001\u0000\u0000\u0000"+
		"\u00043\u0001\u0000\u0000\u0000\u0006K\u0001\u0000\u0000\u0000\bM\u0001"+
		"\u0000\u0000\u0000\nP\u0001\u0000\u0000\u0000\fZ\u0001\u0000\u0000\u0000"+
		"\u000e]\u0001\u0000\u0000\u0000\u0010f\u0001\u0000\u0000\u0000\u0012i"+
		"\u0001\u0000\u0000\u0000\u0014r\u0001\u0000\u0000\u0000\u0016\u0082\u0001"+
		"\u0000\u0000\u0000\u0018\u008f\u0001\u0000\u0000\u0000\u001a\u0099\u0001"+
		"\u0000\u0000\u0000\u001c\u00a6\u0001\u0000\u0000\u0000\u001e\u00af\u0001"+
		"\u0000\u0000\u0000 \u00b2\u0001\u0000\u0000\u0000\"\u00ee\u0001\u0000"+
		"\u0000\u0000$\u0110\u0001\u0000\u0000\u0000&\'\u0003\u0002\u0001\u0000"+
		"\'(\u0005\u0000\u0000\u0001(\u0001\u0001\u0000\u0000\u0000)*\u0003\u0004"+
		"\u0002\u0000*,\u0003\n\u0005\u0000+-\u0003\u000e\u0007\u0000,+\u0001\u0000"+
		"\u0000\u0000,-\u0001\u0000\u0000\u0000-.\u0001\u0000\u0000\u0000./\u0003"+
		"\u0012\t\u0000/1\u0003\u0018\f\u000002\u0003\u001c\u000e\u000010\u0001"+
		"\u0000\u0000\u000012\u0001\u0000\u0000\u00002\u0003\u0001\u0000\u0000"+
		"\u000034\u0005\u0003\u0000\u000046\u0005\u001d\u0000\u000057\u0003\u0006"+
		"\u0003\u000065\u0001\u0000\u0000\u000078\u0001\u0000\u0000\u000086\u0001"+
		"\u0000\u0000\u000089\u0001\u0000\u0000\u00009:\u0001\u0000\u0000\u0000"+
		":;\u0005\u001e\u0000\u0000;\u0005\u0001\u0000\u0000\u0000<=\u0003 \u0010"+
		"\u0000=?\u0005&\u0000\u0000>@\u0003\b\u0004\u0000?>\u0001\u0000\u0000"+
		"\u0000?@\u0001\u0000\u0000\u0000@A\u0001\u0000\u0000\u0000AB\u0005\u0017"+
		"\u0000\u0000BL\u0001\u0000\u0000\u0000CD\u0005!\u0000\u0000DE\u0003 \u0010"+
		"\u0000EG\u0005&\u0000\u0000FH\u0003\b\u0004\u0000GF\u0001\u0000\u0000"+
		"\u0000GH\u0001\u0000\u0000\u0000HI\u0001\u0000\u0000\u0000IJ\u0005\u0017"+
		"\u0000\u0000JL\u0001\u0000\u0000\u0000K<\u0001\u0000\u0000\u0000KC\u0001"+
		"\u0000\u0000\u0000L\u0007\u0001\u0000\u0000\u0000MN\u0005 \u0000\u0000"+
		"NO\u0005&\u0000\u0000O\t\u0001\u0000\u0000\u0000PQ\u0005\u0004\u0000\u0000"+
		"QU\u0005\u001d\u0000\u0000RT\u0003\f\u0006\u0000SR\u0001\u0000\u0000\u0000"+
		"TW\u0001\u0000\u0000\u0000US\u0001\u0000\u0000\u0000UV\u0001\u0000\u0000"+
		"\u0000VX\u0001\u0000\u0000\u0000WU\u0001\u0000\u0000\u0000XY\u0005\u001e"+
		"\u0000\u0000Y\u000b\u0001\u0000\u0000\u0000Z[\u0003\"\u0011\u0000[\\\u0005"+
		"\u0017\u0000\u0000\\\r\u0001\u0000\u0000\u0000]^\u0005\u0005\u0000\u0000"+
		"^`\u0005\u001d\u0000\u0000_a\u0003\u0010\b\u0000`_\u0001\u0000\u0000\u0000"+
		"ab\u0001\u0000\u0000\u0000b`\u0001\u0000\u0000\u0000bc\u0001\u0000\u0000"+
		"\u0000cd\u0001\u0000\u0000\u0000de\u0005\u001e\u0000\u0000e\u000f\u0001"+
		"\u0000\u0000\u0000fg\u0003\"\u0011\u0000gh\u0005\u0017\u0000\u0000h\u0011"+
		"\u0001\u0000\u0000\u0000ij\u0005\u0006\u0000\u0000jl\u0005\u001d\u0000"+
		"\u0000km\u0003\u0014\n\u0000lk\u0001\u0000\u0000\u0000mn\u0001\u0000\u0000"+
		"\u0000nl\u0001\u0000\u0000\u0000no\u0001\u0000\u0000\u0000op\u0001\u0000"+
		"\u0000\u0000pq\u0005\u001e\u0000\u0000q\u0013\u0001\u0000\u0000\u0000"+
		"rs\u0003 \u0010\u0000su\u0005&\u0000\u0000tv\u0003\u0016\u000b\u0000u"+
		"t\u0001\u0000\u0000\u0000uv\u0001\u0000\u0000\u0000vw\u0001\u0000\u0000"+
		"\u0000wx\u0005\u001f\u0000\u0000x}\u0003\"\u0011\u0000yz\u0005\u0001\u0000"+
		"\u0000z|\u0003\"\u0011\u0000{y\u0001\u0000\u0000\u0000|\u007f\u0001\u0000"+
		"\u0000\u0000}{\u0001\u0000\u0000\u0000}~\u0001\u0000\u0000\u0000~\u0080"+
		"\u0001\u0000\u0000\u0000\u007f}\u0001\u0000\u0000\u0000\u0080\u0081\u0005"+
		"\u0017\u0000\u0000\u0081\u0015\u0001\u0000\u0000\u0000\u0082\u008b\u0005"+
		"\u001b\u0000\u0000\u0083\u0088\u0005&\u0000\u0000\u0084\u0085\u0005\u0002"+
		"\u0000\u0000\u0085\u0087\u0005&\u0000\u0000\u0086\u0084\u0001\u0000\u0000"+
		"\u0000\u0087\u008a\u0001\u0000\u0000\u0000\u0088\u0086\u0001\u0000\u0000"+
		"\u0000\u0088\u0089\u0001\u0000\u0000\u0000\u0089\u008c\u0001\u0000\u0000"+
		"\u0000\u008a\u0088\u0001\u0000\u0000\u0000\u008b\u0083\u0001\u0000\u0000"+
		"\u0000\u008b\u008c\u0001\u0000\u0000\u0000\u008c\u008d\u0001\u0000\u0000"+
		"\u0000\u008d\u008e\u0005\u001c\u0000\u0000\u008e\u0017\u0001\u0000\u0000"+
		"\u0000\u008f\u0090\u0005\u0007\u0000\u0000\u0090\u0094\u0005\u001d\u0000"+
		"\u0000\u0091\u0093\u0003\u001a\r\u0000\u0092\u0091\u0001\u0000\u0000\u0000"+
		"\u0093\u0096\u0001\u0000\u0000\u0000\u0094\u0092\u0001\u0000\u0000\u0000"+
		"\u0094\u0095\u0001\u0000\u0000\u0000\u0095\u0097\u0001\u0000\u0000\u0000"+
		"\u0096\u0094\u0001\u0000\u0000\u0000\u0097\u0098\u0005\u001e\u0000\u0000"+
		"\u0098\u0019\u0001\u0000\u0000\u0000\u0099\u009a\u0003 \u0010\u0000\u009a"+
		"\u009b\u0005&\u0000\u0000\u009b\u009c\u0005\u001f\u0000\u0000\u009c\u00a1"+
		"\u0003\"\u0011\u0000\u009d\u009e\u0005\u0001\u0000\u0000\u009e\u00a0\u0003"+
		"\"\u0011\u0000\u009f\u009d\u0001\u0000\u0000\u0000\u00a0\u00a3\u0001\u0000"+
		"\u0000\u0000\u00a1\u009f\u0001\u0000\u0000\u0000\u00a1\u00a2\u0001\u0000"+
		"\u0000\u0000\u00a2\u00a4\u0001\u0000\u0000\u0000\u00a3\u00a1\u0001\u0000"+
		"\u0000\u0000\u00a4\u00a5\u0005\u0017\u0000\u0000\u00a5\u001b\u0001\u0000"+
		"\u0000\u0000\u00a6\u00a7\u0005\b\u0000\u0000\u00a7\u00a9\u0005\u001d\u0000"+
		"\u0000\u00a8\u00aa\u0003\u001e\u000f\u0000\u00a9\u00a8\u0001\u0000\u0000"+
		"\u0000\u00aa\u00ab\u0001\u0000\u0000\u0000\u00ab\u00a9\u0001\u0000\u0000"+
		"\u0000\u00ab\u00ac\u0001\u0000\u0000\u0000\u00ac\u00ad\u0001\u0000\u0000"+
		"\u0000\u00ad\u00ae\u0005\u001e\u0000\u0000\u00ae\u001d\u0001\u0000\u0000"+
		"\u0000\u00af\u00b0\u0003\"\u0011\u0000\u00b0\u00b1\u0005\u0017\u0000\u0000"+
		"\u00b1\u001f\u0001\u0000\u0000\u0000\u00b2\u00b3\u0006\u0010\uffff\uffff"+
		"\u0000\u00b3\u00b4\u0005&\u0000\u0000\u00b4\u00bb\u0001\u0000\u0000\u0000"+
		"\u00b5\u00b6\n\u0001\u0000\u0000\u00b6\u00b7\u0005\u001b\u0000\u0000\u00b7"+
		"\u00b8\u0005\'\u0000\u0000\u00b8\u00ba\u0005\u001c\u0000\u0000\u00b9\u00b5"+
		"\u0001\u0000\u0000\u0000\u00ba\u00bd\u0001\u0000\u0000\u0000\u00bb\u00b9"+
		"\u0001\u0000\u0000\u0000\u00bb\u00bc\u0001\u0000\u0000\u0000\u00bc!\u0001"+
		"\u0000\u0000\u0000\u00bd\u00bb\u0001\u0000\u0000\u0000\u00be\u00bf\u0006"+
		"\u0011\uffff\uffff\u0000\u00bf\u00c0\u0005\u0019\u0000\u0000\u00c0\u00c5"+
		"\u0005&\u0000\u0000\u00c1\u00c2\u0005\u0002\u0000\u0000\u00c2\u00c4\u0005"+
		"&\u0000\u0000\u00c3\u00c1\u0001\u0000\u0000\u0000\u00c4\u00c7\u0001\u0000"+
		"\u0000\u0000\u00c5\u00c3\u0001\u0000\u0000\u0000\u00c5\u00c6\u0001\u0000"+
		"\u0000\u0000\u00c6\u00c8\u0001\u0000\u0000\u0000\u00c7\u00c5\u0001\u0000"+
		"\u0000\u0000\u00c8\u00c9\u0005\u001a\u0000\u0000\u00c9\u00ca\u0005\u001f"+
		"\u0000\u0000\u00ca\u00ef\u0003\"\u0011\r\u00cb\u00cc\u0005\u0019\u0000"+
		"\u0000\u00cc\u00cd\u0003\"\u0011\u0000\u00cd\u00ce\u0005\u001a\u0000\u0000"+
		"\u00ce\u00ef\u0001\u0000\u0000\u0000\u00cf\u00d0\u0005&\u0000\u0000\u00d0"+
		"\u00d9\u0005\u0019\u0000\u0000\u00d1\u00d6\u0003\"\u0011\u0000\u00d2\u00d3"+
		"\u0005\u0002\u0000\u0000\u00d3\u00d5\u0003\"\u0011\u0000\u00d4\u00d2\u0001"+
		"\u0000\u0000\u0000\u00d5\u00d8\u0001\u0000\u0000\u0000\u00d6\u00d4\u0001"+
		"\u0000\u0000\u0000\u00d6\u00d7\u0001\u0000\u0000\u0000\u00d7\u00da\u0001"+
		"\u0000\u0000\u0000\u00d8\u00d6\u0001\u0000\u0000\u0000\u00d9\u00d1\u0001"+
		"\u0000\u0000\u0000\u00d9\u00da\u0001\u0000\u0000\u0000\u00da\u00db\u0001"+
		"\u0000\u0000\u0000\u00db\u00ef\u0005\u001a\u0000\u0000\u00dc\u00dd\u0005"+
		"\u0012\u0000\u0000\u00dd\u00ef\u0003\"\u0011\n\u00de\u00df\u0005\u0016"+
		"\u0000\u0000\u00df\u00ef\u0003\"\u0011\t\u00e0\u00ef\u0003$\u0012\u0000"+
		"\u00e1\u00e2\u0005&\u0000\u0000\u00e2\u00eb\u0005\u001b\u0000\u0000\u00e3"+
		"\u00e8\u0003\"\u0011\u0000\u00e4\u00e5\u0005\u0002\u0000\u0000\u00e5\u00e7"+
		"\u0003\"\u0011\u0000\u00e6\u00e4\u0001\u0000\u0000\u0000\u00e7\u00ea\u0001"+
		"\u0000\u0000\u0000\u00e8\u00e6\u0001\u0000\u0000\u0000\u00e8\u00e9\u0001"+
		"\u0000\u0000\u0000\u00e9\u00ec\u0001\u0000\u0000\u0000\u00ea\u00e8\u0001"+
		"\u0000\u0000\u0000\u00eb\u00e3\u0001\u0000\u0000\u0000\u00eb\u00ec\u0001"+
		"\u0000\u0000\u0000\u00ec\u00ed\u0001\u0000\u0000\u0000\u00ed\u00ef\u0005"+
		"\u001c\u0000\u0000\u00ee\u00be\u0001\u0000\u0000\u0000\u00ee\u00cb\u0001"+
		"\u0000\u0000\u0000\u00ee\u00cf\u0001\u0000\u0000\u0000\u00ee\u00dc\u0001"+
		"\u0000\u0000\u0000\u00ee\u00de\u0001\u0000\u0000\u0000\u00ee\u00e0\u0001"+
		"\u0000\u0000\u0000\u00ee\u00e1\u0001\u0000\u0000\u0000\u00ef\u0104\u0001"+
		"\u0000\u0000\u0000\u00f0\u00f1\n\b\u0000\u0000\u00f1\u00f2\u0007\u0000"+
		"\u0000\u0000\u00f2\u0103\u0003\"\u0011\t\u00f3\u00f4\n\u0007\u0000\u0000"+
		"\u00f4\u00f5\u0007\u0001\u0000\u0000\u00f5\u0103\u0003\"\u0011\b\u00f6"+
		"\u00f7\n\u0006\u0000\u0000\u00f7\u00f8\u0007\u0002\u0000\u0000\u00f8\u0103"+
		"\u0003\"\u0011\u0007\u00f9\u00fa\n\u0005\u0000\u0000\u00fa\u00fb\u0007"+
		"\u0003\u0000\u0000\u00fb\u0103\u0003\"\u0011\u0006\u00fc\u00fd\n\u0004"+
		"\u0000\u0000\u00fd\u00fe\u0005\n\u0000\u0000\u00fe\u0103\u0003\"\u0011"+
		"\u0005\u00ff\u0100\n\u0003\u0000\u0000\u0100\u0101\u0005\t\u0000\u0000"+
		"\u0101\u0103\u0003\"\u0011\u0004\u0102\u00f0\u0001\u0000\u0000\u0000\u0102"+
		"\u00f3\u0001\u0000\u0000\u0000\u0102\u00f6\u0001\u0000\u0000\u0000\u0102"+
		"\u00f9\u0001\u0000\u0000\u0000\u0102\u00fc\u0001\u0000\u0000\u0000\u0102"+
		"\u00ff\u0001\u0000\u0000\u0000\u0103\u0106\u0001\u0000\u0000\u0000\u0104"+
		"\u0102\u0001\u0000\u0000\u0000\u0104\u0105\u0001\u0000\u0000\u0000\u0105"+
		"#\u0001\u0000\u0000\u0000\u0106\u0104\u0001\u0000\u0000\u0000\u0107\u0111"+
		"\u0005\'\u0000\u0000\u0108\u0111\u0007\u0004\u0000\u0000\u0109\u0111\u0005"+
		"&\u0000\u0000\u010a\u0111\u0005$\u0000\u0000\u010b\u0111\u0005%\u0000"+
		"\u0000\u010c\u010d\u0005%\u0000\u0000\u010d\u010e\u0005\u0019\u0000\u0000"+
		"\u010e\u010f\u0005\'\u0000\u0000\u010f\u0111\u0005\u001a\u0000\u0000\u0110"+
		"\u0107\u0001\u0000\u0000\u0000\u0110\u0108\u0001\u0000\u0000\u0000\u0110"+
		"\u0109\u0001\u0000\u0000\u0000\u0110\u010a\u0001\u0000\u0000\u0000\u0110"+
		"\u010b\u0001\u0000\u0000\u0000\u0110\u010c\u0001\u0000\u0000\u0000\u0111"+
		"%\u0001\u0000\u0000\u0000\u001a,18?GKUbnu}\u0088\u008b\u0094\u00a1\u00ab"+
		"\u00bb\u00c5\u00d6\u00d9\u00e8\u00eb\u00ee\u0102\u0104\u0110";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}