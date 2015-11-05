package io.lattekit.dsl.ide.contentassist.antlr.internal; 

import java.io.InputStream;
import org.eclipse.xtext.*;
import org.eclipse.xtext.parser.*;
import org.eclipse.xtext.parser.impl.*;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.parser.antlr.XtextTokenStream;
import org.eclipse.xtext.parser.antlr.XtextTokenStream.HiddenTokens;
import org.eclipse.xtext.ide.editor.contentassist.antlr.internal.AbstractInternalContentAssistParser;
import org.eclipse.xtext.ide.editor.contentassist.antlr.internal.DFA;
import io.lattekit.dsl.services.LatteCSSGrammarAccess;



import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

@SuppressWarnings("all")
public class InternalLatteCSSParser extends AbstractInternalContentAssistParser {
    public static final String[] tokenNames = new String[] {
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "RULE_INT", "RULE_REAL", "RULE_ID", "RULE_STRING", "RULE_HEX_NUMBER", "RULE_ML_COMMENT", "RULE_SL_COMMENT", "RULE_WS", "RULE_ANY_OTHER", "'normal'", "'bold'", "'bold-italic'", "'width'", "'height'", "'border-width'", "'border-radius'", "'margin'", "'padding'", "'border-top-left-radius'", "'border-top-right-radius'", "'border-bottom-left-radius'", "'border-bottom-right-radius'", "'border-left-width'", "'border-right-width'", "'border-top-width'", "'border-bottom-width'", "'font-size'", "'translate-x'", "'translate-y'", "'margin-left'", "'margin-right'", "'margin-top'", "'margin-bottom'", "'padding-left'", "'padding-right'", "'padding-top'", "'padding-bottom'", "'x'", "'y'", "'elevation'", "'border'", "'border-top'", "'border-bottom'", "'border-left'", "'border-right'", "'solid'", "'dashed'", "'dotted'", "'repeat-x'", "'mirror-x'", "'clamp-x'", "'no-repeat-x'", "'repeat-y'", "'mirror-y'", "'clamp-y'", "'no-repeat-y'", "'top'", "'bottom'", "'left'", "'right'", "'center_vertical'", "'fill_vertical'", "'center_horizontal'", "'fill_horizontal'", "'center'", "'fill'", "'clip_vertical'", "'clip_horizontal'", "'start'", "'end'", "'add'", "'clear'", "'darken'", "'dst'", "'dst_atop'", "'dst_in'", "'dst_out'", "'dst_over'", "'lighten'", "'multiply'", "'overlay'", "'screen'", "'src'", "'src_atop'", "'src_in'", "'src_out'", "'src_over'", "'xor'", "'border-top-color'", "'border-left-color'", "'border-right-color'", "'border-bottom-color'", "'ripple-color'", "'background-color'", "'text-color'", "'background-filter-color'", "'justify'", "'accelerate-decelerate'", "'accelerate'", "'anticipate'", "'anticipate-overshoot'", "'bounce'", "'cycle'", "'decelerate'", "'fast-out'", "'fast-out-slow'", "'linear'", "'linear-out'", "'overshoot'", "'translateX'", "'translateY'", "'s'", "'ms'", "'match_parent'", "'wrap_content'", "'dp'", "'px'", "'sp'", "'pt'", "'mm'", "'repeat'", "'reflect'", "'aliceblue'", "'antiquewhite'", "'aqua'", "'aquamarine'", "'azure'", "'beige'", "'bisque'", "'black'", "'blanchedalmond'", "'blue'", "'blueviolet'", "'brown'", "'burlywood'", "'cadetblue'", "'chartreuse'", "'chocolate'", "'coral'", "'cornflowerblue'", "'cornsilk'", "'crimson'", "'cyan'", "'darkblue'", "'darkcyan'", "'darkgoldenrod'", "'darkgray'", "'darkgreen'", "'darkgrey'", "'darkkhaki'", "'darkmagenta'", "'darkolivegreen'", "'darkorange'", "'darkorchid'", "'darkred'", "'darksalmon'", "'darkseagreen'", "'darkslateblue'", "'darkslategray'", "'darkslategrey'", "'darkturquoise'", "'darkviolet'", "'deeppink'", "'deepskyblue'", "'dimgray'", "'dimgrey'", "'dodgerblue'", "'firebrick'", "'floralwhite'", "'forestgreen'", "'fuchsia'", "'gainsboro'", "'ghostwhite'", "'gold'", "'goldenrod'", "'gray'", "'green'", "'greenyellow'", "'grey'", "'honeydew'", "'hotpink'", "'indianred'", "'indigo'", "'ivory'", "'khaki'", "'lavender'", "'lavenderblush'", "'lawngreen'", "'lemonchiffon'", "'lightblue'", "'lightcoral'", "'lightcyan'", "'lightgoldenrodyellow'", "'lightgray'", "'lightgreen'", "'lightgrey'", "'lightpink'", "'lightsalmon'", "'lightseagreen'", "'lightskyblue'", "'lightslategray'", "'lightslategrey'", "'lightsteelblue'", "'lightyellow'", "'lime'", "'limegreen'", "'linen'", "'magenta'", "'maroon'", "'mediumaquamarine'", "'mediumblue'", "'mediumorchid'", "'mediumpurple'", "'mediumseagreen'", "'mediumslateblue'", "'mediumspringgreen'", "'mediumturquoise'", "'mediumvioletred'", "'midnightblue'", "'mintcream'", "'mistyrose'", "'moccasin'", "'navajowhite'", "'navy'", "'oldlace'", "'olive'", "'olivedrab'", "'orange'", "'orangered'", "'orchid'", "'palegoldenrod'", "'palegreen'", "'paleturquoise'", "'palevioletred'", "'papayawhip'", "'peachpuff'", "'peru'", "'pink'", "'plum'", "'powderblue'", "'purple'", "'red'", "'rosybrown'", "'royalblue'", "'saddlebrown'", "'salmon'", "'sandybrown'", "'seagreen'", "'seashell'", "'sienna'", "'silver'", "'skyblue'", "'slateblue'", "'slategray'", "'slategrey'", "'snow'", "'springgreen'", "'steelblue'", "'tan'", "'teal'", "'thistle'", "'tomato'", "'turquoise'", "'violet'", "'wheat'", "'white'", "'whitesmoke'", "'yellow'", "'yellowgreen'", "'transparent'", "'{'", "'}'", "','", "'#'", "'.'", "':'", "';'", "'('", "')'", "'to'", "'stops'", "'radial'", "'focus'", "'rgb'", "'rgba'", "'font-family'", "'font-style'", "'background'", "'transition'", "'background-drawable'", "'background-repeat'", "'background-filter'", "'background-gravity'", "'background-filter-type'", "'border-color'", "'text-align'"
    };
    public static final int T__144=144;
    public static final int T__265=265;
    public static final int T__143=143;
    public static final int T__264=264;
    public static final int T__146=146;
    public static final int T__267=267;
    public static final int T__50=50;
    public static final int T__145=145;
    public static final int T__266=266;
    public static final int T__140=140;
    public static final int T__261=261;
    public static final int T__260=260;
    public static final int T__142=142;
    public static final int T__263=263;
    public static final int T__141=141;
    public static final int T__262=262;
    public static final int T__59=59;
    public static final int T__55=55;
    public static final int T__56=56;
    public static final int T__57=57;
    public static final int T__58=58;
    public static final int T__51=51;
    public static final int T__137=137;
    public static final int T__258=258;
    public static final int T__52=52;
    public static final int T__136=136;
    public static final int T__257=257;
    public static final int T__53=53;
    public static final int T__139=139;
    public static final int T__54=54;
    public static final int T__138=138;
    public static final int T__259=259;
    public static final int T__133=133;
    public static final int T__254=254;
    public static final int T__132=132;
    public static final int T__253=253;
    public static final int T__60=60;
    public static final int T__135=135;
    public static final int T__256=256;
    public static final int T__61=61;
    public static final int T__134=134;
    public static final int T__255=255;
    public static final int T__250=250;
    public static final int RULE_ID=6;
    public static final int T__131=131;
    public static final int T__252=252;
    public static final int T__130=130;
    public static final int T__251=251;
    public static final int RULE_REAL=5;
    public static final int RULE_INT=4;
    public static final int T__66=66;
    public static final int T__67=67;
    public static final int T__129=129;
    public static final int T__68=68;
    public static final int T__69=69;
    public static final int T__62=62;
    public static final int T__126=126;
    public static final int T__247=247;
    public static final int T__63=63;
    public static final int T__125=125;
    public static final int T__246=246;
    public static final int T__64=64;
    public static final int T__128=128;
    public static final int T__249=249;
    public static final int T__65=65;
    public static final int T__127=127;
    public static final int T__248=248;
    public static final int T__166=166;
    public static final int T__287=287;
    public static final int T__165=165;
    public static final int T__286=286;
    public static final int T__168=168;
    public static final int T__289=289;
    public static final int T__167=167;
    public static final int T__288=288;
    public static final int T__162=162;
    public static final int T__283=283;
    public static final int T__161=161;
    public static final int T__282=282;
    public static final int T__164=164;
    public static final int T__285=285;
    public static final int T__163=163;
    public static final int T__284=284;
    public static final int T__160=160;
    public static final int T__281=281;
    public static final int T__280=280;
    public static final int T__37=37;
    public static final int T__38=38;
    public static final int T__39=39;
    public static final int T__33=33;
    public static final int T__34=34;
    public static final int T__35=35;
    public static final int T__36=36;
    public static final int T__159=159;
    public static final int T__30=30;
    public static final int T__158=158;
    public static final int T__279=279;
    public static final int T__31=31;
    public static final int T__32=32;
    public static final int T__155=155;
    public static final int T__276=276;
    public static final int T__154=154;
    public static final int T__275=275;
    public static final int T__157=157;
    public static final int T__278=278;
    public static final int T__156=156;
    public static final int T__277=277;
    public static final int T__151=151;
    public static final int T__272=272;
    public static final int T__150=150;
    public static final int T__271=271;
    public static final int T__153=153;
    public static final int T__274=274;
    public static final int T__152=152;
    public static final int T__273=273;
    public static final int T__270=270;
    public static final int T__48=48;
    public static final int T__49=49;
    public static final int T__44=44;
    public static final int T__45=45;
    public static final int T__46=46;
    public static final int T__47=47;
    public static final int T__40=40;
    public static final int T__148=148;
    public static final int T__269=269;
    public static final int T__41=41;
    public static final int T__147=147;
    public static final int T__268=268;
    public static final int T__42=42;
    public static final int T__43=43;
    public static final int T__149=149;
    public static final int T__100=100;
    public static final int T__221=221;
    public static final int T__220=220;
    public static final int T__102=102;
    public static final int T__223=223;
    public static final int T__101=101;
    public static final int T__222=222;
    public static final int T__19=19;
    public static final int T__15=15;
    public static final int T__16=16;
    public static final int T__17=17;
    public static final int T__18=18;
    public static final int T__218=218;
    public static final int T__217=217;
    public static final int T__13=13;
    public static final int T__14=14;
    public static final int T__219=219;
    public static final int T__214=214;
    public static final int T__213=213;
    public static final int T__216=216;
    public static final int T__215=215;
    public static final int T__210=210;
    public static final int T__212=212;
    public static final int T__211=211;
    public static final int T__26=26;
    public static final int T__27=27;
    public static final int T__28=28;
    public static final int T__29=29;
    public static final int T__22=22;
    public static final int T__207=207;
    public static final int T__23=23;
    public static final int T__206=206;
    public static final int T__24=24;
    public static final int T__209=209;
    public static final int T__25=25;
    public static final int T__208=208;
    public static final int T__203=203;
    public static final int T__202=202;
    public static final int T__20=20;
    public static final int T__205=205;
    public static final int T__21=21;
    public static final int T__204=204;
    public static final int T__122=122;
    public static final int T__243=243;
    public static final int T__121=121;
    public static final int T__242=242;
    public static final int T__124=124;
    public static final int T__245=245;
    public static final int T__123=123;
    public static final int T__244=244;
    public static final int T__120=120;
    public static final int T__241=241;
    public static final int T__240=240;
    public static final int RULE_SL_COMMENT=10;
    public static final int T__119=119;
    public static final int T__118=118;
    public static final int T__239=239;
    public static final int T__115=115;
    public static final int T__236=236;
    public static final int EOF=-1;
    public static final int T__114=114;
    public static final int T__235=235;
    public static final int T__117=117;
    public static final int T__238=238;
    public static final int T__116=116;
    public static final int T__237=237;
    public static final int T__111=111;
    public static final int T__232=232;
    public static final int T__110=110;
    public static final int T__231=231;
    public static final int T__113=113;
    public static final int T__234=234;
    public static final int T__112=112;
    public static final int T__233=233;
    public static final int T__230=230;
    public static final int T__108=108;
    public static final int T__229=229;
    public static final int T__107=107;
    public static final int T__228=228;
    public static final int T__109=109;
    public static final int T__104=104;
    public static final int T__225=225;
    public static final int T__103=103;
    public static final int T__224=224;
    public static final int T__106=106;
    public static final int T__227=227;
    public static final int T__105=105;
    public static final int T__226=226;
    public static final int RULE_ML_COMMENT=9;
    public static final int T__201=201;
    public static final int T__200=200;
    public static final int RULE_HEX_NUMBER=8;
    public static final int T__91=91;
    public static final int T__188=188;
    public static final int T__92=92;
    public static final int T__187=187;
    public static final int T__93=93;
    public static final int T__94=94;
    public static final int T__189=189;
    public static final int T__184=184;
    public static final int T__183=183;
    public static final int T__186=186;
    public static final int T__90=90;
    public static final int T__185=185;
    public static final int T__180=180;
    public static final int T__182=182;
    public static final int T__181=181;
    public static final int T__99=99;
    public static final int T__95=95;
    public static final int T__96=96;
    public static final int T__97=97;
    public static final int T__98=98;
    public static final int T__177=177;
    public static final int T__298=298;
    public static final int T__176=176;
    public static final int T__297=297;
    public static final int T__179=179;
    public static final int T__178=178;
    public static final int T__299=299;
    public static final int T__173=173;
    public static final int T__294=294;
    public static final int T__172=172;
    public static final int T__293=293;
    public static final int T__175=175;
    public static final int T__296=296;
    public static final int T__174=174;
    public static final int T__295=295;
    public static final int T__290=290;
    public static final int T__171=171;
    public static final int T__292=292;
    public static final int T__170=170;
    public static final int T__291=291;
    public static final int T__169=169;
    public static final int T__70=70;
    public static final int T__71=71;
    public static final int T__72=72;
    public static final int RULE_STRING=7;
    public static final int T__77=77;
    public static final int T__78=78;
    public static final int T__79=79;
    public static final int T__73=73;
    public static final int T__74=74;
    public static final int T__75=75;
    public static final int T__76=76;
    public static final int T__80=80;
    public static final int T__199=199;
    public static final int T__81=81;
    public static final int T__198=198;
    public static final int T__82=82;
    public static final int T__83=83;
    public static final int T__195=195;
    public static final int T__194=194;
    public static final int RULE_WS=11;
    public static final int T__197=197;
    public static final int T__196=196;
    public static final int T__191=191;
    public static final int T__190=190;
    public static final int T__193=193;
    public static final int T__192=192;
    public static final int RULE_ANY_OTHER=12;
    public static final int T__88=88;
    public static final int T__89=89;
    public static final int T__84=84;
    public static final int T__85=85;
    public static final int T__86=86;
    public static final int T__87=87;

    // delegates
    // delegators


        public InternalLatteCSSParser(TokenStream input) {
            this(input, new RecognizerSharedState());
        }
        public InternalLatteCSSParser(TokenStream input, RecognizerSharedState state) {
            super(input, state);
             
        }
        

    public String[] getTokenNames() { return InternalLatteCSSParser.tokenNames; }
    public String getGrammarFileName() { return "InternalLatteCSS.g"; }


     
     	private LatteCSSGrammarAccess grammarAccess;
     	
        public void setGrammarAccess(LatteCSSGrammarAccess grammarAccess) {
        	this.grammarAccess = grammarAccess;
        }
        
        @Override
        protected Grammar getGrammar() {
        	return grammarAccess.getGrammar();
        }
        
        @Override
        protected String getValueForTokenName(String tokenName) {
        	return tokenName;
        }




    // $ANTLR start "entryRuleCSS"
    // InternalLatteCSS.g:60:1: entryRuleCSS : ruleCSS EOF ;
    public final void entryRuleCSS() throws RecognitionException {
        try {
            // InternalLatteCSS.g:61:1: ( ruleCSS EOF )
            // InternalLatteCSS.g:62:1: ruleCSS EOF
            {
             before(grammarAccess.getCSSRule()); 
            pushFollow(FOLLOW_1);
            ruleCSS();

            state._fsp--;

             after(grammarAccess.getCSSRule()); 
            match(input,EOF,FOLLOW_2); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleCSS"


    // $ANTLR start "ruleCSS"
    // InternalLatteCSS.g:69:1: ruleCSS : ( ( ( rule__CSS__DefinitionsAssignment ) ) ( ( rule__CSS__DefinitionsAssignment )* ) ) ;
    public final void ruleCSS() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalLatteCSS.g:73:2: ( ( ( ( rule__CSS__DefinitionsAssignment ) ) ( ( rule__CSS__DefinitionsAssignment )* ) ) )
            // InternalLatteCSS.g:74:1: ( ( ( rule__CSS__DefinitionsAssignment ) ) ( ( rule__CSS__DefinitionsAssignment )* ) )
            {
            // InternalLatteCSS.g:74:1: ( ( ( rule__CSS__DefinitionsAssignment ) ) ( ( rule__CSS__DefinitionsAssignment )* ) )
            // InternalLatteCSS.g:75:1: ( ( rule__CSS__DefinitionsAssignment ) ) ( ( rule__CSS__DefinitionsAssignment )* )
            {
            // InternalLatteCSS.g:75:1: ( ( rule__CSS__DefinitionsAssignment ) )
            // InternalLatteCSS.g:76:1: ( rule__CSS__DefinitionsAssignment )
            {
             before(grammarAccess.getCSSAccess().getDefinitionsAssignment()); 
            // InternalLatteCSS.g:77:1: ( rule__CSS__DefinitionsAssignment )
            // InternalLatteCSS.g:77:2: rule__CSS__DefinitionsAssignment
            {
            pushFollow(FOLLOW_3);
            rule__CSS__DefinitionsAssignment();

            state._fsp--;


            }

             after(grammarAccess.getCSSAccess().getDefinitionsAssignment()); 

            }

            // InternalLatteCSS.g:80:1: ( ( rule__CSS__DefinitionsAssignment )* )
            // InternalLatteCSS.g:81:1: ( rule__CSS__DefinitionsAssignment )*
            {
             before(grammarAccess.getCSSAccess().getDefinitionsAssignment()); 
            // InternalLatteCSS.g:82:1: ( rule__CSS__DefinitionsAssignment )*
            loop1:
            do {
                int alt1=2;
                int LA1_0 = input.LA(1);

                if ( (LA1_0==RULE_ID||(LA1_0>=277 && LA1_0<=278)) ) {
                    alt1=1;
                }


                switch (alt1) {
            	case 1 :
            	    // InternalLatteCSS.g:82:2: rule__CSS__DefinitionsAssignment
            	    {
            	    pushFollow(FOLLOW_3);
            	    rule__CSS__DefinitionsAssignment();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop1;
                }
            } while (true);

             after(grammarAccess.getCSSAccess().getDefinitionsAssignment()); 

            }


            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleCSS"


    // $ANTLR start "entryRuleDefinition"
    // InternalLatteCSS.g:95:1: entryRuleDefinition : ruleDefinition EOF ;
    public final void entryRuleDefinition() throws RecognitionException {
        try {
            // InternalLatteCSS.g:96:1: ( ruleDefinition EOF )
            // InternalLatteCSS.g:97:1: ruleDefinition EOF
            {
             before(grammarAccess.getDefinitionRule()); 
            pushFollow(FOLLOW_1);
            ruleDefinition();

            state._fsp--;

             after(grammarAccess.getDefinitionRule()); 
            match(input,EOF,FOLLOW_2); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleDefinition"


    // $ANTLR start "ruleDefinition"
    // InternalLatteCSS.g:104:1: ruleDefinition : ( ( rule__Definition__Group__0 ) ) ;
    public final void ruleDefinition() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalLatteCSS.g:108:2: ( ( ( rule__Definition__Group__0 ) ) )
            // InternalLatteCSS.g:109:1: ( ( rule__Definition__Group__0 ) )
            {
            // InternalLatteCSS.g:109:1: ( ( rule__Definition__Group__0 ) )
            // InternalLatteCSS.g:110:1: ( rule__Definition__Group__0 )
            {
             before(grammarAccess.getDefinitionAccess().getGroup()); 
            // InternalLatteCSS.g:111:1: ( rule__Definition__Group__0 )
            // InternalLatteCSS.g:111:2: rule__Definition__Group__0
            {
            pushFollow(FOLLOW_2);
            rule__Definition__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getDefinitionAccess().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleDefinition"


    // $ANTLR start "entryRuleSelector"
    // InternalLatteCSS.g:123:1: entryRuleSelector : ruleSelector EOF ;
    public final void entryRuleSelector() throws RecognitionException {
        try {
            // InternalLatteCSS.g:124:1: ( ruleSelector EOF )
            // InternalLatteCSS.g:125:1: ruleSelector EOF
            {
             before(grammarAccess.getSelectorRule()); 
            pushFollow(FOLLOW_1);
            ruleSelector();

            state._fsp--;

             after(grammarAccess.getSelectorRule()); 
            match(input,EOF,FOLLOW_2); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleSelector"


    // $ANTLR start "ruleSelector"
    // InternalLatteCSS.g:132:1: ruleSelector : ( ( ( rule__Selector__SimpleSelectorAssignment ) ) ( ( rule__Selector__SimpleSelectorAssignment )* ) ) ;
    public final void ruleSelector() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalLatteCSS.g:136:2: ( ( ( ( rule__Selector__SimpleSelectorAssignment ) ) ( ( rule__Selector__SimpleSelectorAssignment )* ) ) )
            // InternalLatteCSS.g:137:1: ( ( ( rule__Selector__SimpleSelectorAssignment ) ) ( ( rule__Selector__SimpleSelectorAssignment )* ) )
            {
            // InternalLatteCSS.g:137:1: ( ( ( rule__Selector__SimpleSelectorAssignment ) ) ( ( rule__Selector__SimpleSelectorAssignment )* ) )
            // InternalLatteCSS.g:138:1: ( ( rule__Selector__SimpleSelectorAssignment ) ) ( ( rule__Selector__SimpleSelectorAssignment )* )
            {
            // InternalLatteCSS.g:138:1: ( ( rule__Selector__SimpleSelectorAssignment ) )
            // InternalLatteCSS.g:139:1: ( rule__Selector__SimpleSelectorAssignment )
            {
             before(grammarAccess.getSelectorAccess().getSimpleSelectorAssignment()); 
            // InternalLatteCSS.g:140:1: ( rule__Selector__SimpleSelectorAssignment )
            // InternalLatteCSS.g:140:2: rule__Selector__SimpleSelectorAssignment
            {
            pushFollow(FOLLOW_3);
            rule__Selector__SimpleSelectorAssignment();

            state._fsp--;


            }

             after(grammarAccess.getSelectorAccess().getSimpleSelectorAssignment()); 

            }

            // InternalLatteCSS.g:143:1: ( ( rule__Selector__SimpleSelectorAssignment )* )
            // InternalLatteCSS.g:144:1: ( rule__Selector__SimpleSelectorAssignment )*
            {
             before(grammarAccess.getSelectorAccess().getSimpleSelectorAssignment()); 
            // InternalLatteCSS.g:145:1: ( rule__Selector__SimpleSelectorAssignment )*
            loop2:
            do {
                int alt2=2;
                int LA2_0 = input.LA(1);

                if ( (LA2_0==RULE_ID||(LA2_0>=277 && LA2_0<=278)) ) {
                    alt2=1;
                }


                switch (alt2) {
            	case 1 :
            	    // InternalLatteCSS.g:145:2: rule__Selector__SimpleSelectorAssignment
            	    {
            	    pushFollow(FOLLOW_3);
            	    rule__Selector__SimpleSelectorAssignment();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop2;
                }
            } while (true);

             after(grammarAccess.getSelectorAccess().getSimpleSelectorAssignment()); 

            }


            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleSelector"


    // $ANTLR start "entryRuleSimpleSelector"
    // InternalLatteCSS.g:158:1: entryRuleSimpleSelector : ruleSimpleSelector EOF ;
    public final void entryRuleSimpleSelector() throws RecognitionException {
        try {
            // InternalLatteCSS.g:159:1: ( ruleSimpleSelector EOF )
            // InternalLatteCSS.g:160:1: ruleSimpleSelector EOF
            {
             before(grammarAccess.getSimpleSelectorRule()); 
            pushFollow(FOLLOW_1);
            ruleSimpleSelector();

            state._fsp--;

             after(grammarAccess.getSimpleSelectorRule()); 
            match(input,EOF,FOLLOW_2); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleSimpleSelector"


    // $ANTLR start "ruleSimpleSelector"
    // InternalLatteCSS.g:167:1: ruleSimpleSelector : ( ( rule__SimpleSelector__Alternatives ) ) ;
    public final void ruleSimpleSelector() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalLatteCSS.g:171:2: ( ( ( rule__SimpleSelector__Alternatives ) ) )
            // InternalLatteCSS.g:172:1: ( ( rule__SimpleSelector__Alternatives ) )
            {
            // InternalLatteCSS.g:172:1: ( ( rule__SimpleSelector__Alternatives ) )
            // InternalLatteCSS.g:173:1: ( rule__SimpleSelector__Alternatives )
            {
             before(grammarAccess.getSimpleSelectorAccess().getAlternatives()); 
            // InternalLatteCSS.g:174:1: ( rule__SimpleSelector__Alternatives )
            // InternalLatteCSS.g:174:2: rule__SimpleSelector__Alternatives
            {
            pushFollow(FOLLOW_2);
            rule__SimpleSelector__Alternatives();

            state._fsp--;


            }

             after(grammarAccess.getSimpleSelectorAccess().getAlternatives()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleSimpleSelector"


    // $ANTLR start "entryRuleIdSelector"
    // InternalLatteCSS.g:186:1: entryRuleIdSelector : ruleIdSelector EOF ;
    public final void entryRuleIdSelector() throws RecognitionException {
        try {
            // InternalLatteCSS.g:187:1: ( ruleIdSelector EOF )
            // InternalLatteCSS.g:188:1: ruleIdSelector EOF
            {
             before(grammarAccess.getIdSelectorRule()); 
            pushFollow(FOLLOW_1);
            ruleIdSelector();

            state._fsp--;

             after(grammarAccess.getIdSelectorRule()); 
            match(input,EOF,FOLLOW_2); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleIdSelector"


    // $ANTLR start "ruleIdSelector"
    // InternalLatteCSS.g:195:1: ruleIdSelector : ( ( rule__IdSelector__Group__0 ) ) ;
    public final void ruleIdSelector() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalLatteCSS.g:199:2: ( ( ( rule__IdSelector__Group__0 ) ) )
            // InternalLatteCSS.g:200:1: ( ( rule__IdSelector__Group__0 ) )
            {
            // InternalLatteCSS.g:200:1: ( ( rule__IdSelector__Group__0 ) )
            // InternalLatteCSS.g:201:1: ( rule__IdSelector__Group__0 )
            {
             before(grammarAccess.getIdSelectorAccess().getGroup()); 
            // InternalLatteCSS.g:202:1: ( rule__IdSelector__Group__0 )
            // InternalLatteCSS.g:202:2: rule__IdSelector__Group__0
            {
            pushFollow(FOLLOW_2);
            rule__IdSelector__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getIdSelectorAccess().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleIdSelector"


    // $ANTLR start "entryRuleClassSelector"
    // InternalLatteCSS.g:214:1: entryRuleClassSelector : ruleClassSelector EOF ;
    public final void entryRuleClassSelector() throws RecognitionException {
        try {
            // InternalLatteCSS.g:215:1: ( ruleClassSelector EOF )
            // InternalLatteCSS.g:216:1: ruleClassSelector EOF
            {
             before(grammarAccess.getClassSelectorRule()); 
            pushFollow(FOLLOW_1);
            ruleClassSelector();

            state._fsp--;

             after(grammarAccess.getClassSelectorRule()); 
            match(input,EOF,FOLLOW_2); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleClassSelector"


    // $ANTLR start "ruleClassSelector"
    // InternalLatteCSS.g:223:1: ruleClassSelector : ( ( rule__ClassSelector__Group__0 ) ) ;
    public final void ruleClassSelector() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalLatteCSS.g:227:2: ( ( ( rule__ClassSelector__Group__0 ) ) )
            // InternalLatteCSS.g:228:1: ( ( rule__ClassSelector__Group__0 ) )
            {
            // InternalLatteCSS.g:228:1: ( ( rule__ClassSelector__Group__0 ) )
            // InternalLatteCSS.g:229:1: ( rule__ClassSelector__Group__0 )
            {
             before(grammarAccess.getClassSelectorAccess().getGroup()); 
            // InternalLatteCSS.g:230:1: ( rule__ClassSelector__Group__0 )
            // InternalLatteCSS.g:230:2: rule__ClassSelector__Group__0
            {
            pushFollow(FOLLOW_2);
            rule__ClassSelector__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getClassSelectorAccess().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleClassSelector"


    // $ANTLR start "entryRulePseudoClassSelector"
    // InternalLatteCSS.g:242:1: entryRulePseudoClassSelector : rulePseudoClassSelector EOF ;
    public final void entryRulePseudoClassSelector() throws RecognitionException {
        try {
            // InternalLatteCSS.g:243:1: ( rulePseudoClassSelector EOF )
            // InternalLatteCSS.g:244:1: rulePseudoClassSelector EOF
            {
             before(grammarAccess.getPseudoClassSelectorRule()); 
            pushFollow(FOLLOW_1);
            rulePseudoClassSelector();

            state._fsp--;

             after(grammarAccess.getPseudoClassSelectorRule()); 
            match(input,EOF,FOLLOW_2); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRulePseudoClassSelector"


    // $ANTLR start "rulePseudoClassSelector"
    // InternalLatteCSS.g:251:1: rulePseudoClassSelector : ( ( rule__PseudoClassSelector__Group__0 ) ) ;
    public final void rulePseudoClassSelector() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalLatteCSS.g:255:2: ( ( ( rule__PseudoClassSelector__Group__0 ) ) )
            // InternalLatteCSS.g:256:1: ( ( rule__PseudoClassSelector__Group__0 ) )
            {
            // InternalLatteCSS.g:256:1: ( ( rule__PseudoClassSelector__Group__0 ) )
            // InternalLatteCSS.g:257:1: ( rule__PseudoClassSelector__Group__0 )
            {
             before(grammarAccess.getPseudoClassSelectorAccess().getGroup()); 
            // InternalLatteCSS.g:258:1: ( rule__PseudoClassSelector__Group__0 )
            // InternalLatteCSS.g:258:2: rule__PseudoClassSelector__Group__0
            {
            pushFollow(FOLLOW_2);
            rule__PseudoClassSelector__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getPseudoClassSelectorAccess().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rulePseudoClassSelector"


    // $ANTLR start "entryRuleCSSProperty"
    // InternalLatteCSS.g:270:1: entryRuleCSSProperty : ruleCSSProperty EOF ;
    public final void entryRuleCSSProperty() throws RecognitionException {
        try {
            // InternalLatteCSS.g:271:1: ( ruleCSSProperty EOF )
            // InternalLatteCSS.g:272:1: ruleCSSProperty EOF
            {
             before(grammarAccess.getCSSPropertyRule()); 
            pushFollow(FOLLOW_1);
            ruleCSSProperty();

            state._fsp--;

             after(grammarAccess.getCSSPropertyRule()); 
            match(input,EOF,FOLLOW_2); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleCSSProperty"


    // $ANTLR start "ruleCSSProperty"
    // InternalLatteCSS.g:279:1: ruleCSSProperty : ( ( rule__CSSProperty__Group__0 ) ) ;
    public final void ruleCSSProperty() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalLatteCSS.g:283:2: ( ( ( rule__CSSProperty__Group__0 ) ) )
            // InternalLatteCSS.g:284:1: ( ( rule__CSSProperty__Group__0 ) )
            {
            // InternalLatteCSS.g:284:1: ( ( rule__CSSProperty__Group__0 ) )
            // InternalLatteCSS.g:285:1: ( rule__CSSProperty__Group__0 )
            {
             before(grammarAccess.getCSSPropertyAccess().getGroup()); 
            // InternalLatteCSS.g:286:1: ( rule__CSSProperty__Group__0 )
            // InternalLatteCSS.g:286:2: rule__CSSProperty__Group__0
            {
            pushFollow(FOLLOW_2);
            rule__CSSProperty__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getCSSPropertyAccess().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleCSSProperty"


    // $ANTLR start "entryRuleFontFamilyProperty"
    // InternalLatteCSS.g:298:1: entryRuleFontFamilyProperty : ruleFontFamilyProperty EOF ;
    public final void entryRuleFontFamilyProperty() throws RecognitionException {
        try {
            // InternalLatteCSS.g:299:1: ( ruleFontFamilyProperty EOF )
            // InternalLatteCSS.g:300:1: ruleFontFamilyProperty EOF
            {
             before(grammarAccess.getFontFamilyPropertyRule()); 
            pushFollow(FOLLOW_1);
            ruleFontFamilyProperty();

            state._fsp--;

             after(grammarAccess.getFontFamilyPropertyRule()); 
            match(input,EOF,FOLLOW_2); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleFontFamilyProperty"


    // $ANTLR start "ruleFontFamilyProperty"
    // InternalLatteCSS.g:307:1: ruleFontFamilyProperty : ( ( rule__FontFamilyProperty__Group__0 ) ) ;
    public final void ruleFontFamilyProperty() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalLatteCSS.g:311:2: ( ( ( rule__FontFamilyProperty__Group__0 ) ) )
            // InternalLatteCSS.g:312:1: ( ( rule__FontFamilyProperty__Group__0 ) )
            {
            // InternalLatteCSS.g:312:1: ( ( rule__FontFamilyProperty__Group__0 ) )
            // InternalLatteCSS.g:313:1: ( rule__FontFamilyProperty__Group__0 )
            {
             before(grammarAccess.getFontFamilyPropertyAccess().getGroup()); 
            // InternalLatteCSS.g:314:1: ( rule__FontFamilyProperty__Group__0 )
            // InternalLatteCSS.g:314:2: rule__FontFamilyProperty__Group__0
            {
            pushFollow(FOLLOW_2);
            rule__FontFamilyProperty__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getFontFamilyPropertyAccess().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleFontFamilyProperty"


    // $ANTLR start "entryRuleFontStyleProperty"
    // InternalLatteCSS.g:326:1: entryRuleFontStyleProperty : ruleFontStyleProperty EOF ;
    public final void entryRuleFontStyleProperty() throws RecognitionException {
        try {
            // InternalLatteCSS.g:327:1: ( ruleFontStyleProperty EOF )
            // InternalLatteCSS.g:328:1: ruleFontStyleProperty EOF
            {
             before(grammarAccess.getFontStylePropertyRule()); 
            pushFollow(FOLLOW_1);
            ruleFontStyleProperty();

            state._fsp--;

             after(grammarAccess.getFontStylePropertyRule()); 
            match(input,EOF,FOLLOW_2); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleFontStyleProperty"


    // $ANTLR start "ruleFontStyleProperty"
    // InternalLatteCSS.g:335:1: ruleFontStyleProperty : ( ( rule__FontStyleProperty__Group__0 ) ) ;
    public final void ruleFontStyleProperty() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalLatteCSS.g:339:2: ( ( ( rule__FontStyleProperty__Group__0 ) ) )
            // InternalLatteCSS.g:340:1: ( ( rule__FontStyleProperty__Group__0 ) )
            {
            // InternalLatteCSS.g:340:1: ( ( rule__FontStyleProperty__Group__0 ) )
            // InternalLatteCSS.g:341:1: ( rule__FontStyleProperty__Group__0 )
            {
             before(grammarAccess.getFontStylePropertyAccess().getGroup()); 
            // InternalLatteCSS.g:342:1: ( rule__FontStyleProperty__Group__0 )
            // InternalLatteCSS.g:342:2: rule__FontStyleProperty__Group__0
            {
            pushFollow(FOLLOW_2);
            rule__FontStyleProperty__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getFontStylePropertyAccess().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleFontStyleProperty"


    // $ANTLR start "entryRuleViewSizeProperty"
    // InternalLatteCSS.g:354:1: entryRuleViewSizeProperty : ruleViewSizeProperty EOF ;
    public final void entryRuleViewSizeProperty() throws RecognitionException {
        try {
            // InternalLatteCSS.g:355:1: ( ruleViewSizeProperty EOF )
            // InternalLatteCSS.g:356:1: ruleViewSizeProperty EOF
            {
             before(grammarAccess.getViewSizePropertyRule()); 
            pushFollow(FOLLOW_1);
            ruleViewSizeProperty();

            state._fsp--;

             after(grammarAccess.getViewSizePropertyRule()); 
            match(input,EOF,FOLLOW_2); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleViewSizeProperty"


    // $ANTLR start "ruleViewSizeProperty"
    // InternalLatteCSS.g:363:1: ruleViewSizeProperty : ( ( rule__ViewSizeProperty__Group__0 ) ) ;
    public final void ruleViewSizeProperty() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalLatteCSS.g:367:2: ( ( ( rule__ViewSizeProperty__Group__0 ) ) )
            // InternalLatteCSS.g:368:1: ( ( rule__ViewSizeProperty__Group__0 ) )
            {
            // InternalLatteCSS.g:368:1: ( ( rule__ViewSizeProperty__Group__0 ) )
            // InternalLatteCSS.g:369:1: ( rule__ViewSizeProperty__Group__0 )
            {
             before(grammarAccess.getViewSizePropertyAccess().getGroup()); 
            // InternalLatteCSS.g:370:1: ( rule__ViewSizeProperty__Group__0 )
            // InternalLatteCSS.g:370:2: rule__ViewSizeProperty__Group__0
            {
            pushFollow(FOLLOW_2);
            rule__ViewSizeProperty__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getViewSizePropertyAccess().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleViewSizeProperty"


    // $ANTLR start "entryRuleShorthandSizeProperty"
    // InternalLatteCSS.g:382:1: entryRuleShorthandSizeProperty : ruleShorthandSizeProperty EOF ;
    public final void entryRuleShorthandSizeProperty() throws RecognitionException {
        try {
            // InternalLatteCSS.g:383:1: ( ruleShorthandSizeProperty EOF )
            // InternalLatteCSS.g:384:1: ruleShorthandSizeProperty EOF
            {
             before(grammarAccess.getShorthandSizePropertyRule()); 
            pushFollow(FOLLOW_1);
            ruleShorthandSizeProperty();

            state._fsp--;

             after(grammarAccess.getShorthandSizePropertyRule()); 
            match(input,EOF,FOLLOW_2); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleShorthandSizeProperty"


    // $ANTLR start "ruleShorthandSizeProperty"
    // InternalLatteCSS.g:391:1: ruleShorthandSizeProperty : ( ( rule__ShorthandSizeProperty__Group__0 ) ) ;
    public final void ruleShorthandSizeProperty() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalLatteCSS.g:395:2: ( ( ( rule__ShorthandSizeProperty__Group__0 ) ) )
            // InternalLatteCSS.g:396:1: ( ( rule__ShorthandSizeProperty__Group__0 ) )
            {
            // InternalLatteCSS.g:396:1: ( ( rule__ShorthandSizeProperty__Group__0 ) )
            // InternalLatteCSS.g:397:1: ( rule__ShorthandSizeProperty__Group__0 )
            {
             before(grammarAccess.getShorthandSizePropertyAccess().getGroup()); 
            // InternalLatteCSS.g:398:1: ( rule__ShorthandSizeProperty__Group__0 )
            // InternalLatteCSS.g:398:2: rule__ShorthandSizeProperty__Group__0
            {
            pushFollow(FOLLOW_2);
            rule__ShorthandSizeProperty__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getShorthandSizePropertyAccess().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleShorthandSizeProperty"


    // $ANTLR start "entryRuleBorderRadiusProperty"
    // InternalLatteCSS.g:410:1: entryRuleBorderRadiusProperty : ruleBorderRadiusProperty EOF ;
    public final void entryRuleBorderRadiusProperty() throws RecognitionException {
        try {
            // InternalLatteCSS.g:411:1: ( ruleBorderRadiusProperty EOF )
            // InternalLatteCSS.g:412:1: ruleBorderRadiusProperty EOF
            {
             before(grammarAccess.getBorderRadiusPropertyRule()); 
            pushFollow(FOLLOW_1);
            ruleBorderRadiusProperty();

            state._fsp--;

             after(grammarAccess.getBorderRadiusPropertyRule()); 
            match(input,EOF,FOLLOW_2); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleBorderRadiusProperty"


    // $ANTLR start "ruleBorderRadiusProperty"
    // InternalLatteCSS.g:419:1: ruleBorderRadiusProperty : ( ( rule__BorderRadiusProperty__Group__0 ) ) ;
    public final void ruleBorderRadiusProperty() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalLatteCSS.g:423:2: ( ( ( rule__BorderRadiusProperty__Group__0 ) ) )
            // InternalLatteCSS.g:424:1: ( ( rule__BorderRadiusProperty__Group__0 ) )
            {
            // InternalLatteCSS.g:424:1: ( ( rule__BorderRadiusProperty__Group__0 ) )
            // InternalLatteCSS.g:425:1: ( rule__BorderRadiusProperty__Group__0 )
            {
             before(grammarAccess.getBorderRadiusPropertyAccess().getGroup()); 
            // InternalLatteCSS.g:426:1: ( rule__BorderRadiusProperty__Group__0 )
            // InternalLatteCSS.g:426:2: rule__BorderRadiusProperty__Group__0
            {
            pushFollow(FOLLOW_2);
            rule__BorderRadiusProperty__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getBorderRadiusPropertyAccess().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleBorderRadiusProperty"


    // $ANTLR start "entryRuleSizeProperty"
    // InternalLatteCSS.g:438:1: entryRuleSizeProperty : ruleSizeProperty EOF ;
    public final void entryRuleSizeProperty() throws RecognitionException {
        try {
            // InternalLatteCSS.g:439:1: ( ruleSizeProperty EOF )
            // InternalLatteCSS.g:440:1: ruleSizeProperty EOF
            {
             before(grammarAccess.getSizePropertyRule()); 
            pushFollow(FOLLOW_1);
            ruleSizeProperty();

            state._fsp--;

             after(grammarAccess.getSizePropertyRule()); 
            match(input,EOF,FOLLOW_2); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleSizeProperty"


    // $ANTLR start "ruleSizeProperty"
    // InternalLatteCSS.g:447:1: ruleSizeProperty : ( ( rule__SizeProperty__Group__0 ) ) ;
    public final void ruleSizeProperty() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalLatteCSS.g:451:2: ( ( ( rule__SizeProperty__Group__0 ) ) )
            // InternalLatteCSS.g:452:1: ( ( rule__SizeProperty__Group__0 ) )
            {
            // InternalLatteCSS.g:452:1: ( ( rule__SizeProperty__Group__0 ) )
            // InternalLatteCSS.g:453:1: ( rule__SizeProperty__Group__0 )
            {
             before(grammarAccess.getSizePropertyAccess().getGroup()); 
            // InternalLatteCSS.g:454:1: ( rule__SizeProperty__Group__0 )
            // InternalLatteCSS.g:454:2: rule__SizeProperty__Group__0
            {
            pushFollow(FOLLOW_2);
            rule__SizeProperty__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getSizePropertyAccess().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleSizeProperty"


    // $ANTLR start "entryRulePaintProperty"
    // InternalLatteCSS.g:466:1: entryRulePaintProperty : rulePaintProperty EOF ;
    public final void entryRulePaintProperty() throws RecognitionException {
        try {
            // InternalLatteCSS.g:467:1: ( rulePaintProperty EOF )
            // InternalLatteCSS.g:468:1: rulePaintProperty EOF
            {
             before(grammarAccess.getPaintPropertyRule()); 
            pushFollow(FOLLOW_1);
            rulePaintProperty();

            state._fsp--;

             after(grammarAccess.getPaintPropertyRule()); 
            match(input,EOF,FOLLOW_2); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRulePaintProperty"


    // $ANTLR start "rulePaintProperty"
    // InternalLatteCSS.g:475:1: rulePaintProperty : ( ( rule__PaintProperty__Group__0 ) ) ;
    public final void rulePaintProperty() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalLatteCSS.g:479:2: ( ( ( rule__PaintProperty__Group__0 ) ) )
            // InternalLatteCSS.g:480:1: ( ( rule__PaintProperty__Group__0 ) )
            {
            // InternalLatteCSS.g:480:1: ( ( rule__PaintProperty__Group__0 ) )
            // InternalLatteCSS.g:481:1: ( rule__PaintProperty__Group__0 )
            {
             before(grammarAccess.getPaintPropertyAccess().getGroup()); 
            // InternalLatteCSS.g:482:1: ( rule__PaintProperty__Group__0 )
            // InternalLatteCSS.g:482:2: rule__PaintProperty__Group__0
            {
            pushFollow(FOLLOW_2);
            rule__PaintProperty__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getPaintPropertyAccess().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rulePaintProperty"


    // $ANTLR start "entryRuleTransitionProperty"
    // InternalLatteCSS.g:494:1: entryRuleTransitionProperty : ruleTransitionProperty EOF ;
    public final void entryRuleTransitionProperty() throws RecognitionException {
        try {
            // InternalLatteCSS.g:495:1: ( ruleTransitionProperty EOF )
            // InternalLatteCSS.g:496:1: ruleTransitionProperty EOF
            {
             before(grammarAccess.getTransitionPropertyRule()); 
            pushFollow(FOLLOW_1);
            ruleTransitionProperty();

            state._fsp--;

             after(grammarAccess.getTransitionPropertyRule()); 
            match(input,EOF,FOLLOW_2); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleTransitionProperty"


    // $ANTLR start "ruleTransitionProperty"
    // InternalLatteCSS.g:503:1: ruleTransitionProperty : ( ( rule__TransitionProperty__Group__0 ) ) ;
    public final void ruleTransitionProperty() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalLatteCSS.g:507:2: ( ( ( rule__TransitionProperty__Group__0 ) ) )
            // InternalLatteCSS.g:508:1: ( ( rule__TransitionProperty__Group__0 ) )
            {
            // InternalLatteCSS.g:508:1: ( ( rule__TransitionProperty__Group__0 ) )
            // InternalLatteCSS.g:509:1: ( rule__TransitionProperty__Group__0 )
            {
             before(grammarAccess.getTransitionPropertyAccess().getGroup()); 
            // InternalLatteCSS.g:510:1: ( rule__TransitionProperty__Group__0 )
            // InternalLatteCSS.g:510:2: rule__TransitionProperty__Group__0
            {
            pushFollow(FOLLOW_2);
            rule__TransitionProperty__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getTransitionPropertyAccess().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleTransitionProperty"


    // $ANTLR start "entryRuleTransitionValue"
    // InternalLatteCSS.g:522:1: entryRuleTransitionValue : ruleTransitionValue EOF ;
    public final void entryRuleTransitionValue() throws RecognitionException {
        try {
            // InternalLatteCSS.g:523:1: ( ruleTransitionValue EOF )
            // InternalLatteCSS.g:524:1: ruleTransitionValue EOF
            {
             before(grammarAccess.getTransitionValueRule()); 
            pushFollow(FOLLOW_1);
            ruleTransitionValue();

            state._fsp--;

             after(grammarAccess.getTransitionValueRule()); 
            match(input,EOF,FOLLOW_2); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleTransitionValue"


    // $ANTLR start "ruleTransitionValue"
    // InternalLatteCSS.g:531:1: ruleTransitionValue : ( ( rule__TransitionValue__Group__0 ) ) ;
    public final void ruleTransitionValue() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalLatteCSS.g:535:2: ( ( ( rule__TransitionValue__Group__0 ) ) )
            // InternalLatteCSS.g:536:1: ( ( rule__TransitionValue__Group__0 ) )
            {
            // InternalLatteCSS.g:536:1: ( ( rule__TransitionValue__Group__0 ) )
            // InternalLatteCSS.g:537:1: ( rule__TransitionValue__Group__0 )
            {
             before(grammarAccess.getTransitionValueAccess().getGroup()); 
            // InternalLatteCSS.g:538:1: ( rule__TransitionValue__Group__0 )
            // InternalLatteCSS.g:538:2: rule__TransitionValue__Group__0
            {
            pushFollow(FOLLOW_2);
            rule__TransitionValue__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getTransitionValueAccess().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleTransitionValue"


    // $ANTLR start "entryRuleDrawableProperty"
    // InternalLatteCSS.g:550:1: entryRuleDrawableProperty : ruleDrawableProperty EOF ;
    public final void entryRuleDrawableProperty() throws RecognitionException {
        try {
            // InternalLatteCSS.g:551:1: ( ruleDrawableProperty EOF )
            // InternalLatteCSS.g:552:1: ruleDrawableProperty EOF
            {
             before(grammarAccess.getDrawablePropertyRule()); 
            pushFollow(FOLLOW_1);
            ruleDrawableProperty();

            state._fsp--;

             after(grammarAccess.getDrawablePropertyRule()); 
            match(input,EOF,FOLLOW_2); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleDrawableProperty"


    // $ANTLR start "ruleDrawableProperty"
    // InternalLatteCSS.g:559:1: ruleDrawableProperty : ( ( rule__DrawableProperty__Group__0 ) ) ;
    public final void ruleDrawableProperty() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalLatteCSS.g:563:2: ( ( ( rule__DrawableProperty__Group__0 ) ) )
            // InternalLatteCSS.g:564:1: ( ( rule__DrawableProperty__Group__0 ) )
            {
            // InternalLatteCSS.g:564:1: ( ( rule__DrawableProperty__Group__0 ) )
            // InternalLatteCSS.g:565:1: ( rule__DrawableProperty__Group__0 )
            {
             before(grammarAccess.getDrawablePropertyAccess().getGroup()); 
            // InternalLatteCSS.g:566:1: ( rule__DrawableProperty__Group__0 )
            // InternalLatteCSS.g:566:2: rule__DrawableProperty__Group__0
            {
            pushFollow(FOLLOW_2);
            rule__DrawableProperty__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getDrawablePropertyAccess().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleDrawableProperty"


    // $ANTLR start "entryRuleBackgroundRepeatProperty"
    // InternalLatteCSS.g:578:1: entryRuleBackgroundRepeatProperty : ruleBackgroundRepeatProperty EOF ;
    public final void entryRuleBackgroundRepeatProperty() throws RecognitionException {
        try {
            // InternalLatteCSS.g:579:1: ( ruleBackgroundRepeatProperty EOF )
            // InternalLatteCSS.g:580:1: ruleBackgroundRepeatProperty EOF
            {
             before(grammarAccess.getBackgroundRepeatPropertyRule()); 
            pushFollow(FOLLOW_1);
            ruleBackgroundRepeatProperty();

            state._fsp--;

             after(grammarAccess.getBackgroundRepeatPropertyRule()); 
            match(input,EOF,FOLLOW_2); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleBackgroundRepeatProperty"


    // $ANTLR start "ruleBackgroundRepeatProperty"
    // InternalLatteCSS.g:587:1: ruleBackgroundRepeatProperty : ( ( rule__BackgroundRepeatProperty__Group__0 ) ) ;
    public final void ruleBackgroundRepeatProperty() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalLatteCSS.g:591:2: ( ( ( rule__BackgroundRepeatProperty__Group__0 ) ) )
            // InternalLatteCSS.g:592:1: ( ( rule__BackgroundRepeatProperty__Group__0 ) )
            {
            // InternalLatteCSS.g:592:1: ( ( rule__BackgroundRepeatProperty__Group__0 ) )
            // InternalLatteCSS.g:593:1: ( rule__BackgroundRepeatProperty__Group__0 )
            {
             before(grammarAccess.getBackgroundRepeatPropertyAccess().getGroup()); 
            // InternalLatteCSS.g:594:1: ( rule__BackgroundRepeatProperty__Group__0 )
            // InternalLatteCSS.g:594:2: rule__BackgroundRepeatProperty__Group__0
            {
            pushFollow(FOLLOW_2);
            rule__BackgroundRepeatProperty__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getBackgroundRepeatPropertyAccess().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleBackgroundRepeatProperty"


    // $ANTLR start "entryRuleBorderProperty"
    // InternalLatteCSS.g:606:1: entryRuleBorderProperty : ruleBorderProperty EOF ;
    public final void entryRuleBorderProperty() throws RecognitionException {
        try {
            // InternalLatteCSS.g:607:1: ( ruleBorderProperty EOF )
            // InternalLatteCSS.g:608:1: ruleBorderProperty EOF
            {
             before(grammarAccess.getBorderPropertyRule()); 
            pushFollow(FOLLOW_1);
            ruleBorderProperty();

            state._fsp--;

             after(grammarAccess.getBorderPropertyRule()); 
            match(input,EOF,FOLLOW_2); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleBorderProperty"


    // $ANTLR start "ruleBorderProperty"
    // InternalLatteCSS.g:615:1: ruleBorderProperty : ( ( rule__BorderProperty__Group__0 ) ) ;
    public final void ruleBorderProperty() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalLatteCSS.g:619:2: ( ( ( rule__BorderProperty__Group__0 ) ) )
            // InternalLatteCSS.g:620:1: ( ( rule__BorderProperty__Group__0 ) )
            {
            // InternalLatteCSS.g:620:1: ( ( rule__BorderProperty__Group__0 ) )
            // InternalLatteCSS.g:621:1: ( rule__BorderProperty__Group__0 )
            {
             before(grammarAccess.getBorderPropertyAccess().getGroup()); 
            // InternalLatteCSS.g:622:1: ( rule__BorderProperty__Group__0 )
            // InternalLatteCSS.g:622:2: rule__BorderProperty__Group__0
            {
            pushFollow(FOLLOW_2);
            rule__BorderProperty__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getBorderPropertyAccess().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleBorderProperty"


    // $ANTLR start "entryRuleBackgroundFilterProperty"
    // InternalLatteCSS.g:634:1: entryRuleBackgroundFilterProperty : ruleBackgroundFilterProperty EOF ;
    public final void entryRuleBackgroundFilterProperty() throws RecognitionException {
        try {
            // InternalLatteCSS.g:635:1: ( ruleBackgroundFilterProperty EOF )
            // InternalLatteCSS.g:636:1: ruleBackgroundFilterProperty EOF
            {
             before(grammarAccess.getBackgroundFilterPropertyRule()); 
            pushFollow(FOLLOW_1);
            ruleBackgroundFilterProperty();

            state._fsp--;

             after(grammarAccess.getBackgroundFilterPropertyRule()); 
            match(input,EOF,FOLLOW_2); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleBackgroundFilterProperty"


    // $ANTLR start "ruleBackgroundFilterProperty"
    // InternalLatteCSS.g:643:1: ruleBackgroundFilterProperty : ( ( rule__BackgroundFilterProperty__Group__0 ) ) ;
    public final void ruleBackgroundFilterProperty() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalLatteCSS.g:647:2: ( ( ( rule__BackgroundFilterProperty__Group__0 ) ) )
            // InternalLatteCSS.g:648:1: ( ( rule__BackgroundFilterProperty__Group__0 ) )
            {
            // InternalLatteCSS.g:648:1: ( ( rule__BackgroundFilterProperty__Group__0 ) )
            // InternalLatteCSS.g:649:1: ( rule__BackgroundFilterProperty__Group__0 )
            {
             before(grammarAccess.getBackgroundFilterPropertyAccess().getGroup()); 
            // InternalLatteCSS.g:650:1: ( rule__BackgroundFilterProperty__Group__0 )
            // InternalLatteCSS.g:650:2: rule__BackgroundFilterProperty__Group__0
            {
            pushFollow(FOLLOW_2);
            rule__BackgroundFilterProperty__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getBackgroundFilterPropertyAccess().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleBackgroundFilterProperty"


    // $ANTLR start "entryRuleRepeatValue"
    // InternalLatteCSS.g:662:1: entryRuleRepeatValue : ruleRepeatValue EOF ;
    public final void entryRuleRepeatValue() throws RecognitionException {
        try {
            // InternalLatteCSS.g:663:1: ( ruleRepeatValue EOF )
            // InternalLatteCSS.g:664:1: ruleRepeatValue EOF
            {
             before(grammarAccess.getRepeatValueRule()); 
            pushFollow(FOLLOW_1);
            ruleRepeatValue();

            state._fsp--;

             after(grammarAccess.getRepeatValueRule()); 
            match(input,EOF,FOLLOW_2); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleRepeatValue"


    // $ANTLR start "ruleRepeatValue"
    // InternalLatteCSS.g:671:1: ruleRepeatValue : ( ( rule__RepeatValue__Alternatives ) ) ;
    public final void ruleRepeatValue() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalLatteCSS.g:675:2: ( ( ( rule__RepeatValue__Alternatives ) ) )
            // InternalLatteCSS.g:676:1: ( ( rule__RepeatValue__Alternatives ) )
            {
            // InternalLatteCSS.g:676:1: ( ( rule__RepeatValue__Alternatives ) )
            // InternalLatteCSS.g:677:1: ( rule__RepeatValue__Alternatives )
            {
             before(grammarAccess.getRepeatValueAccess().getAlternatives()); 
            // InternalLatteCSS.g:678:1: ( rule__RepeatValue__Alternatives )
            // InternalLatteCSS.g:678:2: rule__RepeatValue__Alternatives
            {
            pushFollow(FOLLOW_2);
            rule__RepeatValue__Alternatives();

            state._fsp--;


            }

             after(grammarAccess.getRepeatValueAccess().getAlternatives()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleRepeatValue"


    // $ANTLR start "entryRuleGravityValue"
    // InternalLatteCSS.g:690:1: entryRuleGravityValue : ruleGravityValue EOF ;
    public final void entryRuleGravityValue() throws RecognitionException {
        try {
            // InternalLatteCSS.g:691:1: ( ruleGravityValue EOF )
            // InternalLatteCSS.g:692:1: ruleGravityValue EOF
            {
             before(grammarAccess.getGravityValueRule()); 
            pushFollow(FOLLOW_1);
            ruleGravityValue();

            state._fsp--;

             after(grammarAccess.getGravityValueRule()); 
            match(input,EOF,FOLLOW_2); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleGravityValue"


    // $ANTLR start "ruleGravityValue"
    // InternalLatteCSS.g:699:1: ruleGravityValue : ( ( rule__GravityValue__Alternatives ) ) ;
    public final void ruleGravityValue() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalLatteCSS.g:703:2: ( ( ( rule__GravityValue__Alternatives ) ) )
            // InternalLatteCSS.g:704:1: ( ( rule__GravityValue__Alternatives ) )
            {
            // InternalLatteCSS.g:704:1: ( ( rule__GravityValue__Alternatives ) )
            // InternalLatteCSS.g:705:1: ( rule__GravityValue__Alternatives )
            {
             before(grammarAccess.getGravityValueAccess().getAlternatives()); 
            // InternalLatteCSS.g:706:1: ( rule__GravityValue__Alternatives )
            // InternalLatteCSS.g:706:2: rule__GravityValue__Alternatives
            {
            pushFollow(FOLLOW_2);
            rule__GravityValue__Alternatives();

            state._fsp--;


            }

             after(grammarAccess.getGravityValueAccess().getAlternatives()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleGravityValue"


    // $ANTLR start "entryRuleBackgroundGravityProperty"
    // InternalLatteCSS.g:718:1: entryRuleBackgroundGravityProperty : ruleBackgroundGravityProperty EOF ;
    public final void entryRuleBackgroundGravityProperty() throws RecognitionException {
        try {
            // InternalLatteCSS.g:719:1: ( ruleBackgroundGravityProperty EOF )
            // InternalLatteCSS.g:720:1: ruleBackgroundGravityProperty EOF
            {
             before(grammarAccess.getBackgroundGravityPropertyRule()); 
            pushFollow(FOLLOW_1);
            ruleBackgroundGravityProperty();

            state._fsp--;

             after(grammarAccess.getBackgroundGravityPropertyRule()); 
            match(input,EOF,FOLLOW_2); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleBackgroundGravityProperty"


    // $ANTLR start "ruleBackgroundGravityProperty"
    // InternalLatteCSS.g:727:1: ruleBackgroundGravityProperty : ( ( rule__BackgroundGravityProperty__Group__0 ) ) ;
    public final void ruleBackgroundGravityProperty() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalLatteCSS.g:731:2: ( ( ( rule__BackgroundGravityProperty__Group__0 ) ) )
            // InternalLatteCSS.g:732:1: ( ( rule__BackgroundGravityProperty__Group__0 ) )
            {
            // InternalLatteCSS.g:732:1: ( ( rule__BackgroundGravityProperty__Group__0 ) )
            // InternalLatteCSS.g:733:1: ( rule__BackgroundGravityProperty__Group__0 )
            {
             before(grammarAccess.getBackgroundGravityPropertyAccess().getGroup()); 
            // InternalLatteCSS.g:734:1: ( rule__BackgroundGravityProperty__Group__0 )
            // InternalLatteCSS.g:734:2: rule__BackgroundGravityProperty__Group__0
            {
            pushFollow(FOLLOW_2);
            rule__BackgroundGravityProperty__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getBackgroundGravityPropertyAccess().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleBackgroundGravityProperty"


    // $ANTLR start "entryRuleFilterValue"
    // InternalLatteCSS.g:746:1: entryRuleFilterValue : ruleFilterValue EOF ;
    public final void entryRuleFilterValue() throws RecognitionException {
        try {
            // InternalLatteCSS.g:747:1: ( ruleFilterValue EOF )
            // InternalLatteCSS.g:748:1: ruleFilterValue EOF
            {
             before(grammarAccess.getFilterValueRule()); 
            pushFollow(FOLLOW_1);
            ruleFilterValue();

            state._fsp--;

             after(grammarAccess.getFilterValueRule()); 
            match(input,EOF,FOLLOW_2); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleFilterValue"


    // $ANTLR start "ruleFilterValue"
    // InternalLatteCSS.g:755:1: ruleFilterValue : ( ( rule__FilterValue__Alternatives ) ) ;
    public final void ruleFilterValue() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalLatteCSS.g:759:2: ( ( ( rule__FilterValue__Alternatives ) ) )
            // InternalLatteCSS.g:760:1: ( ( rule__FilterValue__Alternatives ) )
            {
            // InternalLatteCSS.g:760:1: ( ( rule__FilterValue__Alternatives ) )
            // InternalLatteCSS.g:761:1: ( rule__FilterValue__Alternatives )
            {
             before(grammarAccess.getFilterValueAccess().getAlternatives()); 
            // InternalLatteCSS.g:762:1: ( rule__FilterValue__Alternatives )
            // InternalLatteCSS.g:762:2: rule__FilterValue__Alternatives
            {
            pushFollow(FOLLOW_2);
            rule__FilterValue__Alternatives();

            state._fsp--;


            }

             after(grammarAccess.getFilterValueAccess().getAlternatives()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleFilterValue"


    // $ANTLR start "entryRuleBackgroundFilterTypeProperty"
    // InternalLatteCSS.g:774:1: entryRuleBackgroundFilterTypeProperty : ruleBackgroundFilterTypeProperty EOF ;
    public final void entryRuleBackgroundFilterTypeProperty() throws RecognitionException {
        try {
            // InternalLatteCSS.g:775:1: ( ruleBackgroundFilterTypeProperty EOF )
            // InternalLatteCSS.g:776:1: ruleBackgroundFilterTypeProperty EOF
            {
             before(grammarAccess.getBackgroundFilterTypePropertyRule()); 
            pushFollow(FOLLOW_1);
            ruleBackgroundFilterTypeProperty();

            state._fsp--;

             after(grammarAccess.getBackgroundFilterTypePropertyRule()); 
            match(input,EOF,FOLLOW_2); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleBackgroundFilterTypeProperty"


    // $ANTLR start "ruleBackgroundFilterTypeProperty"
    // InternalLatteCSS.g:783:1: ruleBackgroundFilterTypeProperty : ( ( rule__BackgroundFilterTypeProperty__Group__0 ) ) ;
    public final void ruleBackgroundFilterTypeProperty() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalLatteCSS.g:787:2: ( ( ( rule__BackgroundFilterTypeProperty__Group__0 ) ) )
            // InternalLatteCSS.g:788:1: ( ( rule__BackgroundFilterTypeProperty__Group__0 ) )
            {
            // InternalLatteCSS.g:788:1: ( ( rule__BackgroundFilterTypeProperty__Group__0 ) )
            // InternalLatteCSS.g:789:1: ( rule__BackgroundFilterTypeProperty__Group__0 )
            {
             before(grammarAccess.getBackgroundFilterTypePropertyAccess().getGroup()); 
            // InternalLatteCSS.g:790:1: ( rule__BackgroundFilterTypeProperty__Group__0 )
            // InternalLatteCSS.g:790:2: rule__BackgroundFilterTypeProperty__Group__0
            {
            pushFollow(FOLLOW_2);
            rule__BackgroundFilterTypeProperty__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getBackgroundFilterTypePropertyAccess().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleBackgroundFilterTypeProperty"


    // $ANTLR start "entryRuleShorthandColorProperty"
    // InternalLatteCSS.g:802:1: entryRuleShorthandColorProperty : ruleShorthandColorProperty EOF ;
    public final void entryRuleShorthandColorProperty() throws RecognitionException {
        try {
            // InternalLatteCSS.g:803:1: ( ruleShorthandColorProperty EOF )
            // InternalLatteCSS.g:804:1: ruleShorthandColorProperty EOF
            {
             before(grammarAccess.getShorthandColorPropertyRule()); 
            pushFollow(FOLLOW_1);
            ruleShorthandColorProperty();

            state._fsp--;

             after(grammarAccess.getShorthandColorPropertyRule()); 
            match(input,EOF,FOLLOW_2); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleShorthandColorProperty"


    // $ANTLR start "ruleShorthandColorProperty"
    // InternalLatteCSS.g:811:1: ruleShorthandColorProperty : ( ( rule__ShorthandColorProperty__Group__0 ) ) ;
    public final void ruleShorthandColorProperty() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalLatteCSS.g:815:2: ( ( ( rule__ShorthandColorProperty__Group__0 ) ) )
            // InternalLatteCSS.g:816:1: ( ( rule__ShorthandColorProperty__Group__0 ) )
            {
            // InternalLatteCSS.g:816:1: ( ( rule__ShorthandColorProperty__Group__0 ) )
            // InternalLatteCSS.g:817:1: ( rule__ShorthandColorProperty__Group__0 )
            {
             before(grammarAccess.getShorthandColorPropertyAccess().getGroup()); 
            // InternalLatteCSS.g:818:1: ( rule__ShorthandColorProperty__Group__0 )
            // InternalLatteCSS.g:818:2: rule__ShorthandColorProperty__Group__0
            {
            pushFollow(FOLLOW_2);
            rule__ShorthandColorProperty__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getShorthandColorPropertyAccess().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleShorthandColorProperty"


    // $ANTLR start "entryRuleColorProperty"
    // InternalLatteCSS.g:830:1: entryRuleColorProperty : ruleColorProperty EOF ;
    public final void entryRuleColorProperty() throws RecognitionException {
        try {
            // InternalLatteCSS.g:831:1: ( ruleColorProperty EOF )
            // InternalLatteCSS.g:832:1: ruleColorProperty EOF
            {
             before(grammarAccess.getColorPropertyRule()); 
            pushFollow(FOLLOW_1);
            ruleColorProperty();

            state._fsp--;

             after(grammarAccess.getColorPropertyRule()); 
            match(input,EOF,FOLLOW_2); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleColorProperty"


    // $ANTLR start "ruleColorProperty"
    // InternalLatteCSS.g:839:1: ruleColorProperty : ( ( rule__ColorProperty__Group__0 ) ) ;
    public final void ruleColorProperty() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalLatteCSS.g:843:2: ( ( ( rule__ColorProperty__Group__0 ) ) )
            // InternalLatteCSS.g:844:1: ( ( rule__ColorProperty__Group__0 ) )
            {
            // InternalLatteCSS.g:844:1: ( ( rule__ColorProperty__Group__0 ) )
            // InternalLatteCSS.g:845:1: ( rule__ColorProperty__Group__0 )
            {
             before(grammarAccess.getColorPropertyAccess().getGroup()); 
            // InternalLatteCSS.g:846:1: ( rule__ColorProperty__Group__0 )
            // InternalLatteCSS.g:846:2: rule__ColorProperty__Group__0
            {
            pushFollow(FOLLOW_2);
            rule__ColorProperty__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getColorPropertyAccess().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleColorProperty"


    // $ANTLR start "entryRuleAlignmentProperty"
    // InternalLatteCSS.g:858:1: entryRuleAlignmentProperty : ruleAlignmentProperty EOF ;
    public final void entryRuleAlignmentProperty() throws RecognitionException {
        try {
            // InternalLatteCSS.g:859:1: ( ruleAlignmentProperty EOF )
            // InternalLatteCSS.g:860:1: ruleAlignmentProperty EOF
            {
             before(grammarAccess.getAlignmentPropertyRule()); 
            pushFollow(FOLLOW_1);
            ruleAlignmentProperty();

            state._fsp--;

             after(grammarAccess.getAlignmentPropertyRule()); 
            match(input,EOF,FOLLOW_2); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleAlignmentProperty"


    // $ANTLR start "ruleAlignmentProperty"
    // InternalLatteCSS.g:867:1: ruleAlignmentProperty : ( ( rule__AlignmentProperty__Group__0 ) ) ;
    public final void ruleAlignmentProperty() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalLatteCSS.g:871:2: ( ( ( rule__AlignmentProperty__Group__0 ) ) )
            // InternalLatteCSS.g:872:1: ( ( rule__AlignmentProperty__Group__0 ) )
            {
            // InternalLatteCSS.g:872:1: ( ( rule__AlignmentProperty__Group__0 ) )
            // InternalLatteCSS.g:873:1: ( rule__AlignmentProperty__Group__0 )
            {
             before(grammarAccess.getAlignmentPropertyAccess().getGroup()); 
            // InternalLatteCSS.g:874:1: ( rule__AlignmentProperty__Group__0 )
            // InternalLatteCSS.g:874:2: rule__AlignmentProperty__Group__0
            {
            pushFollow(FOLLOW_2);
            rule__AlignmentProperty__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getAlignmentPropertyAccess().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleAlignmentProperty"


    // $ANTLR start "entryRuleTimingFunction"
    // InternalLatteCSS.g:886:1: entryRuleTimingFunction : ruleTimingFunction EOF ;
    public final void entryRuleTimingFunction() throws RecognitionException {
        try {
            // InternalLatteCSS.g:887:1: ( ruleTimingFunction EOF )
            // InternalLatteCSS.g:888:1: ruleTimingFunction EOF
            {
             before(grammarAccess.getTimingFunctionRule()); 
            pushFollow(FOLLOW_1);
            ruleTimingFunction();

            state._fsp--;

             after(grammarAccess.getTimingFunctionRule()); 
            match(input,EOF,FOLLOW_2); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleTimingFunction"


    // $ANTLR start "ruleTimingFunction"
    // InternalLatteCSS.g:895:1: ruleTimingFunction : ( ( rule__TimingFunction__Alternatives ) ) ;
    public final void ruleTimingFunction() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalLatteCSS.g:899:2: ( ( ( rule__TimingFunction__Alternatives ) ) )
            // InternalLatteCSS.g:900:1: ( ( rule__TimingFunction__Alternatives ) )
            {
            // InternalLatteCSS.g:900:1: ( ( rule__TimingFunction__Alternatives ) )
            // InternalLatteCSS.g:901:1: ( rule__TimingFunction__Alternatives )
            {
             before(grammarAccess.getTimingFunctionAccess().getAlternatives()); 
            // InternalLatteCSS.g:902:1: ( rule__TimingFunction__Alternatives )
            // InternalLatteCSS.g:902:2: rule__TimingFunction__Alternatives
            {
            pushFollow(FOLLOW_2);
            rule__TimingFunction__Alternatives();

            state._fsp--;


            }

             after(grammarAccess.getTimingFunctionAccess().getAlternatives()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleTimingFunction"


    // $ANTLR start "entryRulePropertyNameValue"
    // InternalLatteCSS.g:914:1: entryRulePropertyNameValue : rulePropertyNameValue EOF ;
    public final void entryRulePropertyNameValue() throws RecognitionException {
        try {
            // InternalLatteCSS.g:915:1: ( rulePropertyNameValue EOF )
            // InternalLatteCSS.g:916:1: rulePropertyNameValue EOF
            {
             before(grammarAccess.getPropertyNameValueRule()); 
            pushFollow(FOLLOW_1);
            rulePropertyNameValue();

            state._fsp--;

             after(grammarAccess.getPropertyNameValueRule()); 
            match(input,EOF,FOLLOW_2); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRulePropertyNameValue"


    // $ANTLR start "rulePropertyNameValue"
    // InternalLatteCSS.g:923:1: rulePropertyNameValue : ( ( rule__PropertyNameValue__Alternatives ) ) ;
    public final void rulePropertyNameValue() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalLatteCSS.g:927:2: ( ( ( rule__PropertyNameValue__Alternatives ) ) )
            // InternalLatteCSS.g:928:1: ( ( rule__PropertyNameValue__Alternatives ) )
            {
            // InternalLatteCSS.g:928:1: ( ( rule__PropertyNameValue__Alternatives ) )
            // InternalLatteCSS.g:929:1: ( rule__PropertyNameValue__Alternatives )
            {
             before(grammarAccess.getPropertyNameValueAccess().getAlternatives()); 
            // InternalLatteCSS.g:930:1: ( rule__PropertyNameValue__Alternatives )
            // InternalLatteCSS.g:930:2: rule__PropertyNameValue__Alternatives
            {
            pushFollow(FOLLOW_2);
            rule__PropertyNameValue__Alternatives();

            state._fsp--;


            }

             after(grammarAccess.getPropertyNameValueAccess().getAlternatives()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rulePropertyNameValue"


    // $ANTLR start "entryRuleNumberValue"
    // InternalLatteCSS.g:942:1: entryRuleNumberValue : ruleNumberValue EOF ;
    public final void entryRuleNumberValue() throws RecognitionException {
        try {
            // InternalLatteCSS.g:943:1: ( ruleNumberValue EOF )
            // InternalLatteCSS.g:944:1: ruleNumberValue EOF
            {
             before(grammarAccess.getNumberValueRule()); 
            pushFollow(FOLLOW_1);
            ruleNumberValue();

            state._fsp--;

             after(grammarAccess.getNumberValueRule()); 
            match(input,EOF,FOLLOW_2); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleNumberValue"


    // $ANTLR start "ruleNumberValue"
    // InternalLatteCSS.g:951:1: ruleNumberValue : ( ( rule__NumberValue__Alternatives ) ) ;
    public final void ruleNumberValue() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalLatteCSS.g:955:2: ( ( ( rule__NumberValue__Alternatives ) ) )
            // InternalLatteCSS.g:956:1: ( ( rule__NumberValue__Alternatives ) )
            {
            // InternalLatteCSS.g:956:1: ( ( rule__NumberValue__Alternatives ) )
            // InternalLatteCSS.g:957:1: ( rule__NumberValue__Alternatives )
            {
             before(grammarAccess.getNumberValueAccess().getAlternatives()); 
            // InternalLatteCSS.g:958:1: ( rule__NumberValue__Alternatives )
            // InternalLatteCSS.g:958:2: rule__NumberValue__Alternatives
            {
            pushFollow(FOLLOW_2);
            rule__NumberValue__Alternatives();

            state._fsp--;


            }

             after(grammarAccess.getNumberValueAccess().getAlternatives()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleNumberValue"


    // $ANTLR start "entryRuleIntegerValue"
    // InternalLatteCSS.g:970:1: entryRuleIntegerValue : ruleIntegerValue EOF ;
    public final void entryRuleIntegerValue() throws RecognitionException {
        try {
            // InternalLatteCSS.g:971:1: ( ruleIntegerValue EOF )
            // InternalLatteCSS.g:972:1: ruleIntegerValue EOF
            {
             before(grammarAccess.getIntegerValueRule()); 
            pushFollow(FOLLOW_1);
            ruleIntegerValue();

            state._fsp--;

             after(grammarAccess.getIntegerValueRule()); 
            match(input,EOF,FOLLOW_2); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleIntegerValue"


    // $ANTLR start "ruleIntegerValue"
    // InternalLatteCSS.g:979:1: ruleIntegerValue : ( RULE_INT ) ;
    public final void ruleIntegerValue() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalLatteCSS.g:983:2: ( ( RULE_INT ) )
            // InternalLatteCSS.g:984:1: ( RULE_INT )
            {
            // InternalLatteCSS.g:984:1: ( RULE_INT )
            // InternalLatteCSS.g:985:1: RULE_INT
            {
             before(grammarAccess.getIntegerValueAccess().getINTTerminalRuleCall()); 
            match(input,RULE_INT,FOLLOW_2); 
             after(grammarAccess.getIntegerValueAccess().getINTTerminalRuleCall()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleIntegerValue"


    // $ANTLR start "entryRuleRealValue"
    // InternalLatteCSS.g:998:1: entryRuleRealValue : ruleRealValue EOF ;
    public final void entryRuleRealValue() throws RecognitionException {
        try {
            // InternalLatteCSS.g:999:1: ( ruleRealValue EOF )
            // InternalLatteCSS.g:1000:1: ruleRealValue EOF
            {
             before(grammarAccess.getRealValueRule()); 
            pushFollow(FOLLOW_1);
            ruleRealValue();

            state._fsp--;

             after(grammarAccess.getRealValueRule()); 
            match(input,EOF,FOLLOW_2); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleRealValue"


    // $ANTLR start "ruleRealValue"
    // InternalLatteCSS.g:1007:1: ruleRealValue : ( RULE_REAL ) ;
    public final void ruleRealValue() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalLatteCSS.g:1011:2: ( ( RULE_REAL ) )
            // InternalLatteCSS.g:1012:1: ( RULE_REAL )
            {
            // InternalLatteCSS.g:1012:1: ( RULE_REAL )
            // InternalLatteCSS.g:1013:1: RULE_REAL
            {
             before(grammarAccess.getRealValueAccess().getREALTerminalRuleCall()); 
            match(input,RULE_REAL,FOLLOW_2); 
             after(grammarAccess.getRealValueAccess().getREALTerminalRuleCall()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleRealValue"


    // $ANTLR start "entryRuleTimeValue"
    // InternalLatteCSS.g:1026:1: entryRuleTimeValue : ruleTimeValue EOF ;
    public final void entryRuleTimeValue() throws RecognitionException {
        try {
            // InternalLatteCSS.g:1027:1: ( ruleTimeValue EOF )
            // InternalLatteCSS.g:1028:1: ruleTimeValue EOF
            {
             before(grammarAccess.getTimeValueRule()); 
            pushFollow(FOLLOW_1);
            ruleTimeValue();

            state._fsp--;

             after(grammarAccess.getTimeValueRule()); 
            match(input,EOF,FOLLOW_2); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleTimeValue"


    // $ANTLR start "ruleTimeValue"
    // InternalLatteCSS.g:1035:1: ruleTimeValue : ( ( rule__TimeValue__Group__0 ) ) ;
    public final void ruleTimeValue() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalLatteCSS.g:1039:2: ( ( ( rule__TimeValue__Group__0 ) ) )
            // InternalLatteCSS.g:1040:1: ( ( rule__TimeValue__Group__0 ) )
            {
            // InternalLatteCSS.g:1040:1: ( ( rule__TimeValue__Group__0 ) )
            // InternalLatteCSS.g:1041:1: ( rule__TimeValue__Group__0 )
            {
             before(grammarAccess.getTimeValueAccess().getGroup()); 
            // InternalLatteCSS.g:1042:1: ( rule__TimeValue__Group__0 )
            // InternalLatteCSS.g:1042:2: rule__TimeValue__Group__0
            {
            pushFollow(FOLLOW_2);
            rule__TimeValue__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getTimeValueAccess().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleTimeValue"


    // $ANTLR start "entryRuleViewSizeValue"
    // InternalLatteCSS.g:1054:1: entryRuleViewSizeValue : ruleViewSizeValue EOF ;
    public final void entryRuleViewSizeValue() throws RecognitionException {
        try {
            // InternalLatteCSS.g:1055:1: ( ruleViewSizeValue EOF )
            // InternalLatteCSS.g:1056:1: ruleViewSizeValue EOF
            {
             before(grammarAccess.getViewSizeValueRule()); 
            pushFollow(FOLLOW_1);
            ruleViewSizeValue();

            state._fsp--;

             after(grammarAccess.getViewSizeValueRule()); 
            match(input,EOF,FOLLOW_2); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleViewSizeValue"


    // $ANTLR start "ruleViewSizeValue"
    // InternalLatteCSS.g:1063:1: ruleViewSizeValue : ( ( rule__ViewSizeValue__Alternatives ) ) ;
    public final void ruleViewSizeValue() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalLatteCSS.g:1067:2: ( ( ( rule__ViewSizeValue__Alternatives ) ) )
            // InternalLatteCSS.g:1068:1: ( ( rule__ViewSizeValue__Alternatives ) )
            {
            // InternalLatteCSS.g:1068:1: ( ( rule__ViewSizeValue__Alternatives ) )
            // InternalLatteCSS.g:1069:1: ( rule__ViewSizeValue__Alternatives )
            {
             before(grammarAccess.getViewSizeValueAccess().getAlternatives()); 
            // InternalLatteCSS.g:1070:1: ( rule__ViewSizeValue__Alternatives )
            // InternalLatteCSS.g:1070:2: rule__ViewSizeValue__Alternatives
            {
            pushFollow(FOLLOW_2);
            rule__ViewSizeValue__Alternatives();

            state._fsp--;


            }

             after(grammarAccess.getViewSizeValueAccess().getAlternatives()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleViewSizeValue"


    // $ANTLR start "entryRuleSizeValue"
    // InternalLatteCSS.g:1082:1: entryRuleSizeValue : ruleSizeValue EOF ;
    public final void entryRuleSizeValue() throws RecognitionException {
        try {
            // InternalLatteCSS.g:1083:1: ( ruleSizeValue EOF )
            // InternalLatteCSS.g:1084:1: ruleSizeValue EOF
            {
             before(grammarAccess.getSizeValueRule()); 
            pushFollow(FOLLOW_1);
            ruleSizeValue();

            state._fsp--;

             after(grammarAccess.getSizeValueRule()); 
            match(input,EOF,FOLLOW_2); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleSizeValue"


    // $ANTLR start "ruleSizeValue"
    // InternalLatteCSS.g:1091:1: ruleSizeValue : ( ( rule__SizeValue__Group__0 ) ) ;
    public final void ruleSizeValue() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalLatteCSS.g:1095:2: ( ( ( rule__SizeValue__Group__0 ) ) )
            // InternalLatteCSS.g:1096:1: ( ( rule__SizeValue__Group__0 ) )
            {
            // InternalLatteCSS.g:1096:1: ( ( rule__SizeValue__Group__0 ) )
            // InternalLatteCSS.g:1097:1: ( rule__SizeValue__Group__0 )
            {
             before(grammarAccess.getSizeValueAccess().getGroup()); 
            // InternalLatteCSS.g:1098:1: ( rule__SizeValue__Group__0 )
            // InternalLatteCSS.g:1098:2: rule__SizeValue__Group__0
            {
            pushFollow(FOLLOW_2);
            rule__SizeValue__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getSizeValueAccess().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleSizeValue"


    // $ANTLR start "entryRulePaintValue"
    // InternalLatteCSS.g:1114:1: entryRulePaintValue : rulePaintValue EOF ;
    public final void entryRulePaintValue() throws RecognitionException {
        try {
            // InternalLatteCSS.g:1115:1: ( rulePaintValue EOF )
            // InternalLatteCSS.g:1116:1: rulePaintValue EOF
            {
             before(grammarAccess.getPaintValueRule()); 
            pushFollow(FOLLOW_1);
            rulePaintValue();

            state._fsp--;

             after(grammarAccess.getPaintValueRule()); 
            match(input,EOF,FOLLOW_2); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRulePaintValue"


    // $ANTLR start "rulePaintValue"
    // InternalLatteCSS.g:1123:1: rulePaintValue : ( ( rule__PaintValue__Alternatives ) ) ;
    public final void rulePaintValue() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalLatteCSS.g:1127:2: ( ( ( rule__PaintValue__Alternatives ) ) )
            // InternalLatteCSS.g:1128:1: ( ( rule__PaintValue__Alternatives ) )
            {
            // InternalLatteCSS.g:1128:1: ( ( rule__PaintValue__Alternatives ) )
            // InternalLatteCSS.g:1129:1: ( rule__PaintValue__Alternatives )
            {
             before(grammarAccess.getPaintValueAccess().getAlternatives()); 
            // InternalLatteCSS.g:1130:1: ( rule__PaintValue__Alternatives )
            // InternalLatteCSS.g:1130:2: rule__PaintValue__Alternatives
            {
            pushFollow(FOLLOW_2);
            rule__PaintValue__Alternatives();

            state._fsp--;


            }

             after(grammarAccess.getPaintValueAccess().getAlternatives()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rulePaintValue"


    // $ANTLR start "entryRuleLinearGradient"
    // InternalLatteCSS.g:1142:1: entryRuleLinearGradient : ruleLinearGradient EOF ;
    public final void entryRuleLinearGradient() throws RecognitionException {
        try {
            // InternalLatteCSS.g:1143:1: ( ruleLinearGradient EOF )
            // InternalLatteCSS.g:1144:1: ruleLinearGradient EOF
            {
             before(grammarAccess.getLinearGradientRule()); 
            pushFollow(FOLLOW_1);
            ruleLinearGradient();

            state._fsp--;

             after(grammarAccess.getLinearGradientRule()); 
            match(input,EOF,FOLLOW_2); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleLinearGradient"


    // $ANTLR start "ruleLinearGradient"
    // InternalLatteCSS.g:1151:1: ruleLinearGradient : ( ( rule__LinearGradient__Group__0 ) ) ;
    public final void ruleLinearGradient() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalLatteCSS.g:1155:2: ( ( ( rule__LinearGradient__Group__0 ) ) )
            // InternalLatteCSS.g:1156:1: ( ( rule__LinearGradient__Group__0 ) )
            {
            // InternalLatteCSS.g:1156:1: ( ( rule__LinearGradient__Group__0 ) )
            // InternalLatteCSS.g:1157:1: ( rule__LinearGradient__Group__0 )
            {
             before(grammarAccess.getLinearGradientAccess().getGroup()); 
            // InternalLatteCSS.g:1158:1: ( rule__LinearGradient__Group__0 )
            // InternalLatteCSS.g:1158:2: rule__LinearGradient__Group__0
            {
            pushFollow(FOLLOW_2);
            rule__LinearGradient__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getLinearGradientAccess().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleLinearGradient"


    // $ANTLR start "entryRuleRadialGradient"
    // InternalLatteCSS.g:1170:1: entryRuleRadialGradient : ruleRadialGradient EOF ;
    public final void entryRuleRadialGradient() throws RecognitionException {
        try {
            // InternalLatteCSS.g:1171:1: ( ruleRadialGradient EOF )
            // InternalLatteCSS.g:1172:1: ruleRadialGradient EOF
            {
             before(grammarAccess.getRadialGradientRule()); 
            pushFollow(FOLLOW_1);
            ruleRadialGradient();

            state._fsp--;

             after(grammarAccess.getRadialGradientRule()); 
            match(input,EOF,FOLLOW_2); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleRadialGradient"


    // $ANTLR start "ruleRadialGradient"
    // InternalLatteCSS.g:1179:1: ruleRadialGradient : ( ( rule__RadialGradient__Group__0 ) ) ;
    public final void ruleRadialGradient() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalLatteCSS.g:1183:2: ( ( ( rule__RadialGradient__Group__0 ) ) )
            // InternalLatteCSS.g:1184:1: ( ( rule__RadialGradient__Group__0 ) )
            {
            // InternalLatteCSS.g:1184:1: ( ( rule__RadialGradient__Group__0 ) )
            // InternalLatteCSS.g:1185:1: ( rule__RadialGradient__Group__0 )
            {
             before(grammarAccess.getRadialGradientAccess().getGroup()); 
            // InternalLatteCSS.g:1186:1: ( rule__RadialGradient__Group__0 )
            // InternalLatteCSS.g:1186:2: rule__RadialGradient__Group__0
            {
            pushFollow(FOLLOW_2);
            rule__RadialGradient__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getRadialGradientAccess().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleRadialGradient"


    // $ANTLR start "entryRuleStopValue"
    // InternalLatteCSS.g:1198:1: entryRuleStopValue : ruleStopValue EOF ;
    public final void entryRuleStopValue() throws RecognitionException {
        try {
            // InternalLatteCSS.g:1199:1: ( ruleStopValue EOF )
            // InternalLatteCSS.g:1200:1: ruleStopValue EOF
            {
             before(grammarAccess.getStopValueRule()); 
            pushFollow(FOLLOW_1);
            ruleStopValue();

            state._fsp--;

             after(grammarAccess.getStopValueRule()); 
            match(input,EOF,FOLLOW_2); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleStopValue"


    // $ANTLR start "ruleStopValue"
    // InternalLatteCSS.g:1207:1: ruleStopValue : ( ( rule__StopValue__Group__0 ) ) ;
    public final void ruleStopValue() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalLatteCSS.g:1211:2: ( ( ( rule__StopValue__Group__0 ) ) )
            // InternalLatteCSS.g:1212:1: ( ( rule__StopValue__Group__0 ) )
            {
            // InternalLatteCSS.g:1212:1: ( ( rule__StopValue__Group__0 ) )
            // InternalLatteCSS.g:1213:1: ( rule__StopValue__Group__0 )
            {
             before(grammarAccess.getStopValueAccess().getGroup()); 
            // InternalLatteCSS.g:1214:1: ( rule__StopValue__Group__0 )
            // InternalLatteCSS.g:1214:2: rule__StopValue__Group__0
            {
            pushFollow(FOLLOW_2);
            rule__StopValue__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getStopValueAccess().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleStopValue"


    // $ANTLR start "entryRuleColorValue"
    // InternalLatteCSS.g:1226:1: entryRuleColorValue : ruleColorValue EOF ;
    public final void entryRuleColorValue() throws RecognitionException {
        try {
            // InternalLatteCSS.g:1227:1: ( ruleColorValue EOF )
            // InternalLatteCSS.g:1228:1: ruleColorValue EOF
            {
             before(grammarAccess.getColorValueRule()); 
            pushFollow(FOLLOW_1);
            ruleColorValue();

            state._fsp--;

             after(grammarAccess.getColorValueRule()); 
            match(input,EOF,FOLLOW_2); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleColorValue"


    // $ANTLR start "ruleColorValue"
    // InternalLatteCSS.g:1235:1: ruleColorValue : ( ( rule__ColorValue__Alternatives ) ) ;
    public final void ruleColorValue() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalLatteCSS.g:1239:2: ( ( ( rule__ColorValue__Alternatives ) ) )
            // InternalLatteCSS.g:1240:1: ( ( rule__ColorValue__Alternatives ) )
            {
            // InternalLatteCSS.g:1240:1: ( ( rule__ColorValue__Alternatives ) )
            // InternalLatteCSS.g:1241:1: ( rule__ColorValue__Alternatives )
            {
             before(grammarAccess.getColorValueAccess().getAlternatives()); 
            // InternalLatteCSS.g:1242:1: ( rule__ColorValue__Alternatives )
            // InternalLatteCSS.g:1242:2: rule__ColorValue__Alternatives
            {
            pushFollow(FOLLOW_2);
            rule__ColorValue__Alternatives();

            state._fsp--;


            }

             after(grammarAccess.getColorValueAccess().getAlternatives()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleColorValue"


    // $ANTLR start "entryRuleNamedColor"
    // InternalLatteCSS.g:1254:1: entryRuleNamedColor : ruleNamedColor EOF ;
    public final void entryRuleNamedColor() throws RecognitionException {
        try {
            // InternalLatteCSS.g:1255:1: ( ruleNamedColor EOF )
            // InternalLatteCSS.g:1256:1: ruleNamedColor EOF
            {
             before(grammarAccess.getNamedColorRule()); 
            pushFollow(FOLLOW_1);
            ruleNamedColor();

            state._fsp--;

             after(grammarAccess.getNamedColorRule()); 
            match(input,EOF,FOLLOW_2); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleNamedColor"


    // $ANTLR start "ruleNamedColor"
    // InternalLatteCSS.g:1263:1: ruleNamedColor : ( ( rule__NamedColor__Alternatives ) ) ;
    public final void ruleNamedColor() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalLatteCSS.g:1267:2: ( ( ( rule__NamedColor__Alternatives ) ) )
            // InternalLatteCSS.g:1268:1: ( ( rule__NamedColor__Alternatives ) )
            {
            // InternalLatteCSS.g:1268:1: ( ( rule__NamedColor__Alternatives ) )
            // InternalLatteCSS.g:1269:1: ( rule__NamedColor__Alternatives )
            {
             before(grammarAccess.getNamedColorAccess().getAlternatives()); 
            // InternalLatteCSS.g:1270:1: ( rule__NamedColor__Alternatives )
            // InternalLatteCSS.g:1270:2: rule__NamedColor__Alternatives
            {
            pushFollow(FOLLOW_2);
            rule__NamedColor__Alternatives();

            state._fsp--;


            }

             after(grammarAccess.getNamedColorAccess().getAlternatives()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleNamedColor"


    // $ANTLR start "entryRuleRGBColor"
    // InternalLatteCSS.g:1282:1: entryRuleRGBColor : ruleRGBColor EOF ;
    public final void entryRuleRGBColor() throws RecognitionException {
        try {
            // InternalLatteCSS.g:1283:1: ( ruleRGBColor EOF )
            // InternalLatteCSS.g:1284:1: ruleRGBColor EOF
            {
             before(grammarAccess.getRGBColorRule()); 
            pushFollow(FOLLOW_1);
            ruleRGBColor();

            state._fsp--;

             after(grammarAccess.getRGBColorRule()); 
            match(input,EOF,FOLLOW_2); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleRGBColor"


    // $ANTLR start "ruleRGBColor"
    // InternalLatteCSS.g:1291:1: ruleRGBColor : ( ( rule__RGBColor__Alternatives ) ) ;
    public final void ruleRGBColor() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalLatteCSS.g:1295:2: ( ( ( rule__RGBColor__Alternatives ) ) )
            // InternalLatteCSS.g:1296:1: ( ( rule__RGBColor__Alternatives ) )
            {
            // InternalLatteCSS.g:1296:1: ( ( rule__RGBColor__Alternatives ) )
            // InternalLatteCSS.g:1297:1: ( rule__RGBColor__Alternatives )
            {
             before(grammarAccess.getRGBColorAccess().getAlternatives()); 
            // InternalLatteCSS.g:1298:1: ( rule__RGBColor__Alternatives )
            // InternalLatteCSS.g:1298:2: rule__RGBColor__Alternatives
            {
            pushFollow(FOLLOW_2);
            rule__RGBColor__Alternatives();

            state._fsp--;


            }

             after(grammarAccess.getRGBColorAccess().getAlternatives()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleRGBColor"


    // $ANTLR start "rule__SimpleSelector__Alternatives"
    // InternalLatteCSS.g:1314:1: rule__SimpleSelector__Alternatives : ( ( ( rule__SimpleSelector__ElementAssignment_0 ) ) | ( ( rule__SimpleSelector__Group_1__0 ) ) | ( ( rule__SimpleSelector__Group_2__0 ) ) );
    public final void rule__SimpleSelector__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalLatteCSS.g:1318:1: ( ( ( rule__SimpleSelector__ElementAssignment_0 ) ) | ( ( rule__SimpleSelector__Group_1__0 ) ) | ( ( rule__SimpleSelector__Group_2__0 ) ) )
            int alt3=3;
            switch ( input.LA(1) ) {
            case RULE_ID:
                {
                alt3=1;
                }
                break;
            case 277:
                {
                alt3=2;
                }
                break;
            case 278:
                {
                alt3=3;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 3, 0, input);

                throw nvae;
            }

            switch (alt3) {
                case 1 :
                    // InternalLatteCSS.g:1319:1: ( ( rule__SimpleSelector__ElementAssignment_0 ) )
                    {
                    // InternalLatteCSS.g:1319:1: ( ( rule__SimpleSelector__ElementAssignment_0 ) )
                    // InternalLatteCSS.g:1320:1: ( rule__SimpleSelector__ElementAssignment_0 )
                    {
                     before(grammarAccess.getSimpleSelectorAccess().getElementAssignment_0()); 
                    // InternalLatteCSS.g:1321:1: ( rule__SimpleSelector__ElementAssignment_0 )
                    // InternalLatteCSS.g:1321:2: rule__SimpleSelector__ElementAssignment_0
                    {
                    pushFollow(FOLLOW_2);
                    rule__SimpleSelector__ElementAssignment_0();

                    state._fsp--;


                    }

                     after(grammarAccess.getSimpleSelectorAccess().getElementAssignment_0()); 

                    }


                    }
                    break;
                case 2 :
                    // InternalLatteCSS.g:1325:6: ( ( rule__SimpleSelector__Group_1__0 ) )
                    {
                    // InternalLatteCSS.g:1325:6: ( ( rule__SimpleSelector__Group_1__0 ) )
                    // InternalLatteCSS.g:1326:1: ( rule__SimpleSelector__Group_1__0 )
                    {
                     before(grammarAccess.getSimpleSelectorAccess().getGroup_1()); 
                    // InternalLatteCSS.g:1327:1: ( rule__SimpleSelector__Group_1__0 )
                    // InternalLatteCSS.g:1327:2: rule__SimpleSelector__Group_1__0
                    {
                    pushFollow(FOLLOW_2);
                    rule__SimpleSelector__Group_1__0();

                    state._fsp--;


                    }

                     after(grammarAccess.getSimpleSelectorAccess().getGroup_1()); 

                    }


                    }
                    break;
                case 3 :
                    // InternalLatteCSS.g:1331:6: ( ( rule__SimpleSelector__Group_2__0 ) )
                    {
                    // InternalLatteCSS.g:1331:6: ( ( rule__SimpleSelector__Group_2__0 ) )
                    // InternalLatteCSS.g:1332:1: ( rule__SimpleSelector__Group_2__0 )
                    {
                     before(grammarAccess.getSimpleSelectorAccess().getGroup_2()); 
                    // InternalLatteCSS.g:1333:1: ( rule__SimpleSelector__Group_2__0 )
                    // InternalLatteCSS.g:1333:2: rule__SimpleSelector__Group_2__0
                    {
                    pushFollow(FOLLOW_2);
                    rule__SimpleSelector__Group_2__0();

                    state._fsp--;


                    }

                     after(grammarAccess.getSimpleSelectorAccess().getGroup_2()); 

                    }


                    }
                    break;

            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__SimpleSelector__Alternatives"


    // $ANTLR start "rule__CSSProperty__Alternatives_0"
    // InternalLatteCSS.g:1342:1: rule__CSSProperty__Alternatives_0 : ( ( ruleTransitionProperty ) | ( ruleFontFamilyProperty ) | ( ruleFontStyleProperty ) | ( ruleSizeProperty ) | ( ruleShorthandSizeProperty ) | ( ruleShorthandColorProperty ) | ( ruleBorderRadiusProperty ) | ( ruleViewSizeProperty ) | ( rulePaintProperty ) | ( ruleColorProperty ) | ( ruleDrawableProperty ) | ( ruleBackgroundRepeatProperty ) | ( ruleBackgroundFilterTypeProperty ) | ( ruleBackgroundGravityProperty ) | ( ruleBackgroundFilterProperty ) | ( ruleBorderProperty ) | ( ruleAlignmentProperty ) );
    public final void rule__CSSProperty__Alternatives_0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalLatteCSS.g:1346:1: ( ( ruleTransitionProperty ) | ( ruleFontFamilyProperty ) | ( ruleFontStyleProperty ) | ( ruleSizeProperty ) | ( ruleShorthandSizeProperty ) | ( ruleShorthandColorProperty ) | ( ruleBorderRadiusProperty ) | ( ruleViewSizeProperty ) | ( rulePaintProperty ) | ( ruleColorProperty ) | ( ruleDrawableProperty ) | ( ruleBackgroundRepeatProperty ) | ( ruleBackgroundFilterTypeProperty ) | ( ruleBackgroundGravityProperty ) | ( ruleBackgroundFilterProperty ) | ( ruleBorderProperty ) | ( ruleAlignmentProperty ) )
            int alt4=17;
            switch ( input.LA(1) ) {
            case 292:
                {
                alt4=1;
                }
                break;
            case 289:
                {
                alt4=2;
                }
                break;
            case 290:
                {
                alt4=3;
                }
                break;
            case 26:
            case 27:
            case 28:
            case 29:
            case 30:
            case 31:
            case 32:
            case 33:
            case 34:
            case 35:
            case 36:
            case 37:
            case 38:
            case 39:
            case 40:
            case 41:
            case 42:
            case 43:
                {
                alt4=4;
                }
                break;
            case 18:
            case 19:
            case 20:
            case 21:
                {
                alt4=5;
                }
                break;
            case 298:
                {
                alt4=6;
                }
                break;
            case 22:
            case 23:
            case 24:
            case 25:
                {
                alt4=7;
                }
                break;
            case 16:
            case 17:
                {
                alt4=8;
                }
                break;
            case 291:
                {
                alt4=9;
                }
                break;
            case 92:
            case 93:
            case 94:
            case 95:
            case 96:
            case 97:
            case 98:
            case 99:
                {
                alt4=10;
                }
                break;
            case 293:
                {
                alt4=11;
                }
                break;
            case 294:
                {
                alt4=12;
                }
                break;
            case 297:
                {
                alt4=13;
                }
                break;
            case 296:
                {
                alt4=14;
                }
                break;
            case 295:
                {
                alt4=15;
                }
                break;
            case 44:
            case 45:
            case 46:
            case 47:
            case 48:
                {
                alt4=16;
                }
                break;
            case 299:
                {
                alt4=17;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 4, 0, input);

                throw nvae;
            }

            switch (alt4) {
                case 1 :
                    // InternalLatteCSS.g:1347:1: ( ruleTransitionProperty )
                    {
                    // InternalLatteCSS.g:1347:1: ( ruleTransitionProperty )
                    // InternalLatteCSS.g:1348:1: ruleTransitionProperty
                    {
                     before(grammarAccess.getCSSPropertyAccess().getTransitionPropertyParserRuleCall_0_0()); 
                    pushFollow(FOLLOW_2);
                    ruleTransitionProperty();

                    state._fsp--;

                     after(grammarAccess.getCSSPropertyAccess().getTransitionPropertyParserRuleCall_0_0()); 

                    }


                    }
                    break;
                case 2 :
                    // InternalLatteCSS.g:1353:6: ( ruleFontFamilyProperty )
                    {
                    // InternalLatteCSS.g:1353:6: ( ruleFontFamilyProperty )
                    // InternalLatteCSS.g:1354:1: ruleFontFamilyProperty
                    {
                     before(grammarAccess.getCSSPropertyAccess().getFontFamilyPropertyParserRuleCall_0_1()); 
                    pushFollow(FOLLOW_2);
                    ruleFontFamilyProperty();

                    state._fsp--;

                     after(grammarAccess.getCSSPropertyAccess().getFontFamilyPropertyParserRuleCall_0_1()); 

                    }


                    }
                    break;
                case 3 :
                    // InternalLatteCSS.g:1359:6: ( ruleFontStyleProperty )
                    {
                    // InternalLatteCSS.g:1359:6: ( ruleFontStyleProperty )
                    // InternalLatteCSS.g:1360:1: ruleFontStyleProperty
                    {
                     before(grammarAccess.getCSSPropertyAccess().getFontStylePropertyParserRuleCall_0_2()); 
                    pushFollow(FOLLOW_2);
                    ruleFontStyleProperty();

                    state._fsp--;

                     after(grammarAccess.getCSSPropertyAccess().getFontStylePropertyParserRuleCall_0_2()); 

                    }


                    }
                    break;
                case 4 :
                    // InternalLatteCSS.g:1365:6: ( ruleSizeProperty )
                    {
                    // InternalLatteCSS.g:1365:6: ( ruleSizeProperty )
                    // InternalLatteCSS.g:1366:1: ruleSizeProperty
                    {
                     before(grammarAccess.getCSSPropertyAccess().getSizePropertyParserRuleCall_0_3()); 
                    pushFollow(FOLLOW_2);
                    ruleSizeProperty();

                    state._fsp--;

                     after(grammarAccess.getCSSPropertyAccess().getSizePropertyParserRuleCall_0_3()); 

                    }


                    }
                    break;
                case 5 :
                    // InternalLatteCSS.g:1371:6: ( ruleShorthandSizeProperty )
                    {
                    // InternalLatteCSS.g:1371:6: ( ruleShorthandSizeProperty )
                    // InternalLatteCSS.g:1372:1: ruleShorthandSizeProperty
                    {
                     before(grammarAccess.getCSSPropertyAccess().getShorthandSizePropertyParserRuleCall_0_4()); 
                    pushFollow(FOLLOW_2);
                    ruleShorthandSizeProperty();

                    state._fsp--;

                     after(grammarAccess.getCSSPropertyAccess().getShorthandSizePropertyParserRuleCall_0_4()); 

                    }


                    }
                    break;
                case 6 :
                    // InternalLatteCSS.g:1377:6: ( ruleShorthandColorProperty )
                    {
                    // InternalLatteCSS.g:1377:6: ( ruleShorthandColorProperty )
                    // InternalLatteCSS.g:1378:1: ruleShorthandColorProperty
                    {
                     before(grammarAccess.getCSSPropertyAccess().getShorthandColorPropertyParserRuleCall_0_5()); 
                    pushFollow(FOLLOW_2);
                    ruleShorthandColorProperty();

                    state._fsp--;

                     after(grammarAccess.getCSSPropertyAccess().getShorthandColorPropertyParserRuleCall_0_5()); 

                    }


                    }
                    break;
                case 7 :
                    // InternalLatteCSS.g:1383:6: ( ruleBorderRadiusProperty )
                    {
                    // InternalLatteCSS.g:1383:6: ( ruleBorderRadiusProperty )
                    // InternalLatteCSS.g:1384:1: ruleBorderRadiusProperty
                    {
                     before(grammarAccess.getCSSPropertyAccess().getBorderRadiusPropertyParserRuleCall_0_6()); 
                    pushFollow(FOLLOW_2);
                    ruleBorderRadiusProperty();

                    state._fsp--;

                     after(grammarAccess.getCSSPropertyAccess().getBorderRadiusPropertyParserRuleCall_0_6()); 

                    }


                    }
                    break;
                case 8 :
                    // InternalLatteCSS.g:1389:6: ( ruleViewSizeProperty )
                    {
                    // InternalLatteCSS.g:1389:6: ( ruleViewSizeProperty )
                    // InternalLatteCSS.g:1390:1: ruleViewSizeProperty
                    {
                     before(grammarAccess.getCSSPropertyAccess().getViewSizePropertyParserRuleCall_0_7()); 
                    pushFollow(FOLLOW_2);
                    ruleViewSizeProperty();

                    state._fsp--;

                     after(grammarAccess.getCSSPropertyAccess().getViewSizePropertyParserRuleCall_0_7()); 

                    }


                    }
                    break;
                case 9 :
                    // InternalLatteCSS.g:1395:6: ( rulePaintProperty )
                    {
                    // InternalLatteCSS.g:1395:6: ( rulePaintProperty )
                    // InternalLatteCSS.g:1396:1: rulePaintProperty
                    {
                     before(grammarAccess.getCSSPropertyAccess().getPaintPropertyParserRuleCall_0_8()); 
                    pushFollow(FOLLOW_2);
                    rulePaintProperty();

                    state._fsp--;

                     after(grammarAccess.getCSSPropertyAccess().getPaintPropertyParserRuleCall_0_8()); 

                    }


                    }
                    break;
                case 10 :
                    // InternalLatteCSS.g:1401:6: ( ruleColorProperty )
                    {
                    // InternalLatteCSS.g:1401:6: ( ruleColorProperty )
                    // InternalLatteCSS.g:1402:1: ruleColorProperty
                    {
                     before(grammarAccess.getCSSPropertyAccess().getColorPropertyParserRuleCall_0_9()); 
                    pushFollow(FOLLOW_2);
                    ruleColorProperty();

                    state._fsp--;

                     after(grammarAccess.getCSSPropertyAccess().getColorPropertyParserRuleCall_0_9()); 

                    }


                    }
                    break;
                case 11 :
                    // InternalLatteCSS.g:1407:6: ( ruleDrawableProperty )
                    {
                    // InternalLatteCSS.g:1407:6: ( ruleDrawableProperty )
                    // InternalLatteCSS.g:1408:1: ruleDrawableProperty
                    {
                     before(grammarAccess.getCSSPropertyAccess().getDrawablePropertyParserRuleCall_0_10()); 
                    pushFollow(FOLLOW_2);
                    ruleDrawableProperty();

                    state._fsp--;

                     after(grammarAccess.getCSSPropertyAccess().getDrawablePropertyParserRuleCall_0_10()); 

                    }


                    }
                    break;
                case 12 :
                    // InternalLatteCSS.g:1413:6: ( ruleBackgroundRepeatProperty )
                    {
                    // InternalLatteCSS.g:1413:6: ( ruleBackgroundRepeatProperty )
                    // InternalLatteCSS.g:1414:1: ruleBackgroundRepeatProperty
                    {
                     before(grammarAccess.getCSSPropertyAccess().getBackgroundRepeatPropertyParserRuleCall_0_11()); 
                    pushFollow(FOLLOW_2);
                    ruleBackgroundRepeatProperty();

                    state._fsp--;

                     after(grammarAccess.getCSSPropertyAccess().getBackgroundRepeatPropertyParserRuleCall_0_11()); 

                    }


                    }
                    break;
                case 13 :
                    // InternalLatteCSS.g:1419:6: ( ruleBackgroundFilterTypeProperty )
                    {
                    // InternalLatteCSS.g:1419:6: ( ruleBackgroundFilterTypeProperty )
                    // InternalLatteCSS.g:1420:1: ruleBackgroundFilterTypeProperty
                    {
                     before(grammarAccess.getCSSPropertyAccess().getBackgroundFilterTypePropertyParserRuleCall_0_12()); 
                    pushFollow(FOLLOW_2);
                    ruleBackgroundFilterTypeProperty();

                    state._fsp--;

                     after(grammarAccess.getCSSPropertyAccess().getBackgroundFilterTypePropertyParserRuleCall_0_12()); 

                    }


                    }
                    break;
                case 14 :
                    // InternalLatteCSS.g:1425:6: ( ruleBackgroundGravityProperty )
                    {
                    // InternalLatteCSS.g:1425:6: ( ruleBackgroundGravityProperty )
                    // InternalLatteCSS.g:1426:1: ruleBackgroundGravityProperty
                    {
                     before(grammarAccess.getCSSPropertyAccess().getBackgroundGravityPropertyParserRuleCall_0_13()); 
                    pushFollow(FOLLOW_2);
                    ruleBackgroundGravityProperty();

                    state._fsp--;

                     after(grammarAccess.getCSSPropertyAccess().getBackgroundGravityPropertyParserRuleCall_0_13()); 

                    }


                    }
                    break;
                case 15 :
                    // InternalLatteCSS.g:1431:6: ( ruleBackgroundFilterProperty )
                    {
                    // InternalLatteCSS.g:1431:6: ( ruleBackgroundFilterProperty )
                    // InternalLatteCSS.g:1432:1: ruleBackgroundFilterProperty
                    {
                     before(grammarAccess.getCSSPropertyAccess().getBackgroundFilterPropertyParserRuleCall_0_14()); 
                    pushFollow(FOLLOW_2);
                    ruleBackgroundFilterProperty();

                    state._fsp--;

                     after(grammarAccess.getCSSPropertyAccess().getBackgroundFilterPropertyParserRuleCall_0_14()); 

                    }


                    }
                    break;
                case 16 :
                    // InternalLatteCSS.g:1437:6: ( ruleBorderProperty )
                    {
                    // InternalLatteCSS.g:1437:6: ( ruleBorderProperty )
                    // InternalLatteCSS.g:1438:1: ruleBorderProperty
                    {
                     before(grammarAccess.getCSSPropertyAccess().getBorderPropertyParserRuleCall_0_15()); 
                    pushFollow(FOLLOW_2);
                    ruleBorderProperty();

                    state._fsp--;

                     after(grammarAccess.getCSSPropertyAccess().getBorderPropertyParserRuleCall_0_15()); 

                    }


                    }
                    break;
                case 17 :
                    // InternalLatteCSS.g:1443:6: ( ruleAlignmentProperty )
                    {
                    // InternalLatteCSS.g:1443:6: ( ruleAlignmentProperty )
                    // InternalLatteCSS.g:1444:1: ruleAlignmentProperty
                    {
                     before(grammarAccess.getCSSPropertyAccess().getAlignmentPropertyParserRuleCall_0_16()); 
                    pushFollow(FOLLOW_2);
                    ruleAlignmentProperty();

                    state._fsp--;

                     after(grammarAccess.getCSSPropertyAccess().getAlignmentPropertyParserRuleCall_0_16()); 

                    }


                    }
                    break;

            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__CSSProperty__Alternatives_0"


    // $ANTLR start "rule__FontStyleProperty__ValueAlternatives_2_0"
    // InternalLatteCSS.g:1454:1: rule__FontStyleProperty__ValueAlternatives_2_0 : ( ( 'normal' ) | ( 'bold' ) | ( 'bold-italic' ) );
    public final void rule__FontStyleProperty__ValueAlternatives_2_0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalLatteCSS.g:1458:1: ( ( 'normal' ) | ( 'bold' ) | ( 'bold-italic' ) )
            int alt5=3;
            switch ( input.LA(1) ) {
            case 13:
                {
                alt5=1;
                }
                break;
            case 14:
                {
                alt5=2;
                }
                break;
            case 15:
                {
                alt5=3;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 5, 0, input);

                throw nvae;
            }

            switch (alt5) {
                case 1 :
                    // InternalLatteCSS.g:1459:1: ( 'normal' )
                    {
                    // InternalLatteCSS.g:1459:1: ( 'normal' )
                    // InternalLatteCSS.g:1460:1: 'normal'
                    {
                     before(grammarAccess.getFontStylePropertyAccess().getValueNormalKeyword_2_0_0()); 
                    match(input,13,FOLLOW_2); 
                     after(grammarAccess.getFontStylePropertyAccess().getValueNormalKeyword_2_0_0()); 

                    }


                    }
                    break;
                case 2 :
                    // InternalLatteCSS.g:1467:6: ( 'bold' )
                    {
                    // InternalLatteCSS.g:1467:6: ( 'bold' )
                    // InternalLatteCSS.g:1468:1: 'bold'
                    {
                     before(grammarAccess.getFontStylePropertyAccess().getValueBoldKeyword_2_0_1()); 
                    match(input,14,FOLLOW_2); 
                     after(grammarAccess.getFontStylePropertyAccess().getValueBoldKeyword_2_0_1()); 

                    }


                    }
                    break;
                case 3 :
                    // InternalLatteCSS.g:1475:6: ( 'bold-italic' )
                    {
                    // InternalLatteCSS.g:1475:6: ( 'bold-italic' )
                    // InternalLatteCSS.g:1476:1: 'bold-italic'
                    {
                     before(grammarAccess.getFontStylePropertyAccess().getValueBoldItalicKeyword_2_0_2()); 
                    match(input,15,FOLLOW_2); 
                     after(grammarAccess.getFontStylePropertyAccess().getValueBoldItalicKeyword_2_0_2()); 

                    }


                    }
                    break;

            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__FontStyleProperty__ValueAlternatives_2_0"


    // $ANTLR start "rule__ViewSizeProperty__PropertyAlternatives_0_0"
    // InternalLatteCSS.g:1488:1: rule__ViewSizeProperty__PropertyAlternatives_0_0 : ( ( 'width' ) | ( 'height' ) );
    public final void rule__ViewSizeProperty__PropertyAlternatives_0_0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalLatteCSS.g:1492:1: ( ( 'width' ) | ( 'height' ) )
            int alt6=2;
            int LA6_0 = input.LA(1);

            if ( (LA6_0==16) ) {
                alt6=1;
            }
            else if ( (LA6_0==17) ) {
                alt6=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 6, 0, input);

                throw nvae;
            }
            switch (alt6) {
                case 1 :
                    // InternalLatteCSS.g:1493:1: ( 'width' )
                    {
                    // InternalLatteCSS.g:1493:1: ( 'width' )
                    // InternalLatteCSS.g:1494:1: 'width'
                    {
                     before(grammarAccess.getViewSizePropertyAccess().getPropertyWidthKeyword_0_0_0()); 
                    match(input,16,FOLLOW_2); 
                     after(grammarAccess.getViewSizePropertyAccess().getPropertyWidthKeyword_0_0_0()); 

                    }


                    }
                    break;
                case 2 :
                    // InternalLatteCSS.g:1501:6: ( 'height' )
                    {
                    // InternalLatteCSS.g:1501:6: ( 'height' )
                    // InternalLatteCSS.g:1502:1: 'height'
                    {
                     before(grammarAccess.getViewSizePropertyAccess().getPropertyHeightKeyword_0_0_1()); 
                    match(input,17,FOLLOW_2); 
                     after(grammarAccess.getViewSizePropertyAccess().getPropertyHeightKeyword_0_0_1()); 

                    }


                    }
                    break;

            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ViewSizeProperty__PropertyAlternatives_0_0"


    // $ANTLR start "rule__ShorthandSizeProperty__PropertyAlternatives_0_0"
    // InternalLatteCSS.g:1514:1: rule__ShorthandSizeProperty__PropertyAlternatives_0_0 : ( ( 'border-width' ) | ( 'border-radius' ) | ( 'margin' ) | ( 'padding' ) );
    public final void rule__ShorthandSizeProperty__PropertyAlternatives_0_0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalLatteCSS.g:1518:1: ( ( 'border-width' ) | ( 'border-radius' ) | ( 'margin' ) | ( 'padding' ) )
            int alt7=4;
            switch ( input.LA(1) ) {
            case 18:
                {
                alt7=1;
                }
                break;
            case 19:
                {
                alt7=2;
                }
                break;
            case 20:
                {
                alt7=3;
                }
                break;
            case 21:
                {
                alt7=4;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 7, 0, input);

                throw nvae;
            }

            switch (alt7) {
                case 1 :
                    // InternalLatteCSS.g:1519:1: ( 'border-width' )
                    {
                    // InternalLatteCSS.g:1519:1: ( 'border-width' )
                    // InternalLatteCSS.g:1520:1: 'border-width'
                    {
                     before(grammarAccess.getShorthandSizePropertyAccess().getPropertyBorderWidthKeyword_0_0_0()); 
                    match(input,18,FOLLOW_2); 
                     after(grammarAccess.getShorthandSizePropertyAccess().getPropertyBorderWidthKeyword_0_0_0()); 

                    }


                    }
                    break;
                case 2 :
                    // InternalLatteCSS.g:1527:6: ( 'border-radius' )
                    {
                    // InternalLatteCSS.g:1527:6: ( 'border-radius' )
                    // InternalLatteCSS.g:1528:1: 'border-radius'
                    {
                     before(grammarAccess.getShorthandSizePropertyAccess().getPropertyBorderRadiusKeyword_0_0_1()); 
                    match(input,19,FOLLOW_2); 
                     after(grammarAccess.getShorthandSizePropertyAccess().getPropertyBorderRadiusKeyword_0_0_1()); 

                    }


                    }
                    break;
                case 3 :
                    // InternalLatteCSS.g:1535:6: ( 'margin' )
                    {
                    // InternalLatteCSS.g:1535:6: ( 'margin' )
                    // InternalLatteCSS.g:1536:1: 'margin'
                    {
                     before(grammarAccess.getShorthandSizePropertyAccess().getPropertyMarginKeyword_0_0_2()); 
                    match(input,20,FOLLOW_2); 
                     after(grammarAccess.getShorthandSizePropertyAccess().getPropertyMarginKeyword_0_0_2()); 

                    }


                    }
                    break;
                case 4 :
                    // InternalLatteCSS.g:1543:6: ( 'padding' )
                    {
                    // InternalLatteCSS.g:1543:6: ( 'padding' )
                    // InternalLatteCSS.g:1544:1: 'padding'
                    {
                     before(grammarAccess.getShorthandSizePropertyAccess().getPropertyPaddingKeyword_0_0_3()); 
                    match(input,21,FOLLOW_2); 
                     after(grammarAccess.getShorthandSizePropertyAccess().getPropertyPaddingKeyword_0_0_3()); 

                    }


                    }
                    break;

            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ShorthandSizeProperty__PropertyAlternatives_0_0"


    // $ANTLR start "rule__BorderRadiusProperty__PropertyAlternatives_0_0"
    // InternalLatteCSS.g:1556:1: rule__BorderRadiusProperty__PropertyAlternatives_0_0 : ( ( 'border-top-left-radius' ) | ( 'border-top-right-radius' ) | ( 'border-bottom-left-radius' ) | ( 'border-bottom-right-radius' ) );
    public final void rule__BorderRadiusProperty__PropertyAlternatives_0_0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalLatteCSS.g:1560:1: ( ( 'border-top-left-radius' ) | ( 'border-top-right-radius' ) | ( 'border-bottom-left-radius' ) | ( 'border-bottom-right-radius' ) )
            int alt8=4;
            switch ( input.LA(1) ) {
            case 22:
                {
                alt8=1;
                }
                break;
            case 23:
                {
                alt8=2;
                }
                break;
            case 24:
                {
                alt8=3;
                }
                break;
            case 25:
                {
                alt8=4;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 8, 0, input);

                throw nvae;
            }

            switch (alt8) {
                case 1 :
                    // InternalLatteCSS.g:1561:1: ( 'border-top-left-radius' )
                    {
                    // InternalLatteCSS.g:1561:1: ( 'border-top-left-radius' )
                    // InternalLatteCSS.g:1562:1: 'border-top-left-radius'
                    {
                     before(grammarAccess.getBorderRadiusPropertyAccess().getPropertyBorderTopLeftRadiusKeyword_0_0_0()); 
                    match(input,22,FOLLOW_2); 
                     after(grammarAccess.getBorderRadiusPropertyAccess().getPropertyBorderTopLeftRadiusKeyword_0_0_0()); 

                    }


                    }
                    break;
                case 2 :
                    // InternalLatteCSS.g:1569:6: ( 'border-top-right-radius' )
                    {
                    // InternalLatteCSS.g:1569:6: ( 'border-top-right-radius' )
                    // InternalLatteCSS.g:1570:1: 'border-top-right-radius'
                    {
                     before(grammarAccess.getBorderRadiusPropertyAccess().getPropertyBorderTopRightRadiusKeyword_0_0_1()); 
                    match(input,23,FOLLOW_2); 
                     after(grammarAccess.getBorderRadiusPropertyAccess().getPropertyBorderTopRightRadiusKeyword_0_0_1()); 

                    }


                    }
                    break;
                case 3 :
                    // InternalLatteCSS.g:1577:6: ( 'border-bottom-left-radius' )
                    {
                    // InternalLatteCSS.g:1577:6: ( 'border-bottom-left-radius' )
                    // InternalLatteCSS.g:1578:1: 'border-bottom-left-radius'
                    {
                     before(grammarAccess.getBorderRadiusPropertyAccess().getPropertyBorderBottomLeftRadiusKeyword_0_0_2()); 
                    match(input,24,FOLLOW_2); 
                     after(grammarAccess.getBorderRadiusPropertyAccess().getPropertyBorderBottomLeftRadiusKeyword_0_0_2()); 

                    }


                    }
                    break;
                case 4 :
                    // InternalLatteCSS.g:1585:6: ( 'border-bottom-right-radius' )
                    {
                    // InternalLatteCSS.g:1585:6: ( 'border-bottom-right-radius' )
                    // InternalLatteCSS.g:1586:1: 'border-bottom-right-radius'
                    {
                     before(grammarAccess.getBorderRadiusPropertyAccess().getPropertyBorderBottomRightRadiusKeyword_0_0_3()); 
                    match(input,25,FOLLOW_2); 
                     after(grammarAccess.getBorderRadiusPropertyAccess().getPropertyBorderBottomRightRadiusKeyword_0_0_3()); 

                    }


                    }
                    break;

            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__BorderRadiusProperty__PropertyAlternatives_0_0"


    // $ANTLR start "rule__SizeProperty__PropertyAlternatives_0_0"
    // InternalLatteCSS.g:1598:1: rule__SizeProperty__PropertyAlternatives_0_0 : ( ( 'border-left-width' ) | ( 'border-right-width' ) | ( 'border-top-width' ) | ( 'border-bottom-width' ) | ( 'font-size' ) | ( 'translate-x' ) | ( 'translate-y' ) | ( 'margin-left' ) | ( 'margin-right' ) | ( 'margin-top' ) | ( 'margin-bottom' ) | ( 'padding-left' ) | ( 'padding-right' ) | ( 'padding-top' ) | ( 'padding-bottom' ) | ( 'x' ) | ( 'y' ) | ( 'elevation' ) );
    public final void rule__SizeProperty__PropertyAlternatives_0_0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalLatteCSS.g:1602:1: ( ( 'border-left-width' ) | ( 'border-right-width' ) | ( 'border-top-width' ) | ( 'border-bottom-width' ) | ( 'font-size' ) | ( 'translate-x' ) | ( 'translate-y' ) | ( 'margin-left' ) | ( 'margin-right' ) | ( 'margin-top' ) | ( 'margin-bottom' ) | ( 'padding-left' ) | ( 'padding-right' ) | ( 'padding-top' ) | ( 'padding-bottom' ) | ( 'x' ) | ( 'y' ) | ( 'elevation' ) )
            int alt9=18;
            switch ( input.LA(1) ) {
            case 26:
                {
                alt9=1;
                }
                break;
            case 27:
                {
                alt9=2;
                }
                break;
            case 28:
                {
                alt9=3;
                }
                break;
            case 29:
                {
                alt9=4;
                }
                break;
            case 30:
                {
                alt9=5;
                }
                break;
            case 31:
                {
                alt9=6;
                }
                break;
            case 32:
                {
                alt9=7;
                }
                break;
            case 33:
                {
                alt9=8;
                }
                break;
            case 34:
                {
                alt9=9;
                }
                break;
            case 35:
                {
                alt9=10;
                }
                break;
            case 36:
                {
                alt9=11;
                }
                break;
            case 37:
                {
                alt9=12;
                }
                break;
            case 38:
                {
                alt9=13;
                }
                break;
            case 39:
                {
                alt9=14;
                }
                break;
            case 40:
                {
                alt9=15;
                }
                break;
            case 41:
                {
                alt9=16;
                }
                break;
            case 42:
                {
                alt9=17;
                }
                break;
            case 43:
                {
                alt9=18;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 9, 0, input);

                throw nvae;
            }

            switch (alt9) {
                case 1 :
                    // InternalLatteCSS.g:1603:1: ( 'border-left-width' )
                    {
                    // InternalLatteCSS.g:1603:1: ( 'border-left-width' )
                    // InternalLatteCSS.g:1604:1: 'border-left-width'
                    {
                     before(grammarAccess.getSizePropertyAccess().getPropertyBorderLeftWidthKeyword_0_0_0()); 
                    match(input,26,FOLLOW_2); 
                     after(grammarAccess.getSizePropertyAccess().getPropertyBorderLeftWidthKeyword_0_0_0()); 

                    }


                    }
                    break;
                case 2 :
                    // InternalLatteCSS.g:1611:6: ( 'border-right-width' )
                    {
                    // InternalLatteCSS.g:1611:6: ( 'border-right-width' )
                    // InternalLatteCSS.g:1612:1: 'border-right-width'
                    {
                     before(grammarAccess.getSizePropertyAccess().getPropertyBorderRightWidthKeyword_0_0_1()); 
                    match(input,27,FOLLOW_2); 
                     after(grammarAccess.getSizePropertyAccess().getPropertyBorderRightWidthKeyword_0_0_1()); 

                    }


                    }
                    break;
                case 3 :
                    // InternalLatteCSS.g:1619:6: ( 'border-top-width' )
                    {
                    // InternalLatteCSS.g:1619:6: ( 'border-top-width' )
                    // InternalLatteCSS.g:1620:1: 'border-top-width'
                    {
                     before(grammarAccess.getSizePropertyAccess().getPropertyBorderTopWidthKeyword_0_0_2()); 
                    match(input,28,FOLLOW_2); 
                     after(grammarAccess.getSizePropertyAccess().getPropertyBorderTopWidthKeyword_0_0_2()); 

                    }


                    }
                    break;
                case 4 :
                    // InternalLatteCSS.g:1627:6: ( 'border-bottom-width' )
                    {
                    // InternalLatteCSS.g:1627:6: ( 'border-bottom-width' )
                    // InternalLatteCSS.g:1628:1: 'border-bottom-width'
                    {
                     before(grammarAccess.getSizePropertyAccess().getPropertyBorderBottomWidthKeyword_0_0_3()); 
                    match(input,29,FOLLOW_2); 
                     after(grammarAccess.getSizePropertyAccess().getPropertyBorderBottomWidthKeyword_0_0_3()); 

                    }


                    }
                    break;
                case 5 :
                    // InternalLatteCSS.g:1635:6: ( 'font-size' )
                    {
                    // InternalLatteCSS.g:1635:6: ( 'font-size' )
                    // InternalLatteCSS.g:1636:1: 'font-size'
                    {
                     before(grammarAccess.getSizePropertyAccess().getPropertyFontSizeKeyword_0_0_4()); 
                    match(input,30,FOLLOW_2); 
                     after(grammarAccess.getSizePropertyAccess().getPropertyFontSizeKeyword_0_0_4()); 

                    }


                    }
                    break;
                case 6 :
                    // InternalLatteCSS.g:1643:6: ( 'translate-x' )
                    {
                    // InternalLatteCSS.g:1643:6: ( 'translate-x' )
                    // InternalLatteCSS.g:1644:1: 'translate-x'
                    {
                     before(grammarAccess.getSizePropertyAccess().getPropertyTranslateXKeyword_0_0_5()); 
                    match(input,31,FOLLOW_2); 
                     after(grammarAccess.getSizePropertyAccess().getPropertyTranslateXKeyword_0_0_5()); 

                    }


                    }
                    break;
                case 7 :
                    // InternalLatteCSS.g:1651:6: ( 'translate-y' )
                    {
                    // InternalLatteCSS.g:1651:6: ( 'translate-y' )
                    // InternalLatteCSS.g:1652:1: 'translate-y'
                    {
                     before(grammarAccess.getSizePropertyAccess().getPropertyTranslateYKeyword_0_0_6()); 
                    match(input,32,FOLLOW_2); 
                     after(grammarAccess.getSizePropertyAccess().getPropertyTranslateYKeyword_0_0_6()); 

                    }


                    }
                    break;
                case 8 :
                    // InternalLatteCSS.g:1659:6: ( 'margin-left' )
                    {
                    // InternalLatteCSS.g:1659:6: ( 'margin-left' )
                    // InternalLatteCSS.g:1660:1: 'margin-left'
                    {
                     before(grammarAccess.getSizePropertyAccess().getPropertyMarginLeftKeyword_0_0_7()); 
                    match(input,33,FOLLOW_2); 
                     after(grammarAccess.getSizePropertyAccess().getPropertyMarginLeftKeyword_0_0_7()); 

                    }


                    }
                    break;
                case 9 :
                    // InternalLatteCSS.g:1667:6: ( 'margin-right' )
                    {
                    // InternalLatteCSS.g:1667:6: ( 'margin-right' )
                    // InternalLatteCSS.g:1668:1: 'margin-right'
                    {
                     before(grammarAccess.getSizePropertyAccess().getPropertyMarginRightKeyword_0_0_8()); 
                    match(input,34,FOLLOW_2); 
                     after(grammarAccess.getSizePropertyAccess().getPropertyMarginRightKeyword_0_0_8()); 

                    }


                    }
                    break;
                case 10 :
                    // InternalLatteCSS.g:1675:6: ( 'margin-top' )
                    {
                    // InternalLatteCSS.g:1675:6: ( 'margin-top' )
                    // InternalLatteCSS.g:1676:1: 'margin-top'
                    {
                     before(grammarAccess.getSizePropertyAccess().getPropertyMarginTopKeyword_0_0_9()); 
                    match(input,35,FOLLOW_2); 
                     after(grammarAccess.getSizePropertyAccess().getPropertyMarginTopKeyword_0_0_9()); 

                    }


                    }
                    break;
                case 11 :
                    // InternalLatteCSS.g:1683:6: ( 'margin-bottom' )
                    {
                    // InternalLatteCSS.g:1683:6: ( 'margin-bottom' )
                    // InternalLatteCSS.g:1684:1: 'margin-bottom'
                    {
                     before(grammarAccess.getSizePropertyAccess().getPropertyMarginBottomKeyword_0_0_10()); 
                    match(input,36,FOLLOW_2); 
                     after(grammarAccess.getSizePropertyAccess().getPropertyMarginBottomKeyword_0_0_10()); 

                    }


                    }
                    break;
                case 12 :
                    // InternalLatteCSS.g:1691:6: ( 'padding-left' )
                    {
                    // InternalLatteCSS.g:1691:6: ( 'padding-left' )
                    // InternalLatteCSS.g:1692:1: 'padding-left'
                    {
                     before(grammarAccess.getSizePropertyAccess().getPropertyPaddingLeftKeyword_0_0_11()); 
                    match(input,37,FOLLOW_2); 
                     after(grammarAccess.getSizePropertyAccess().getPropertyPaddingLeftKeyword_0_0_11()); 

                    }


                    }
                    break;
                case 13 :
                    // InternalLatteCSS.g:1699:6: ( 'padding-right' )
                    {
                    // InternalLatteCSS.g:1699:6: ( 'padding-right' )
                    // InternalLatteCSS.g:1700:1: 'padding-right'
                    {
                     before(grammarAccess.getSizePropertyAccess().getPropertyPaddingRightKeyword_0_0_12()); 
                    match(input,38,FOLLOW_2); 
                     after(grammarAccess.getSizePropertyAccess().getPropertyPaddingRightKeyword_0_0_12()); 

                    }


                    }
                    break;
                case 14 :
                    // InternalLatteCSS.g:1707:6: ( 'padding-top' )
                    {
                    // InternalLatteCSS.g:1707:6: ( 'padding-top' )
                    // InternalLatteCSS.g:1708:1: 'padding-top'
                    {
                     before(grammarAccess.getSizePropertyAccess().getPropertyPaddingTopKeyword_0_0_13()); 
                    match(input,39,FOLLOW_2); 
                     after(grammarAccess.getSizePropertyAccess().getPropertyPaddingTopKeyword_0_0_13()); 

                    }


                    }
                    break;
                case 15 :
                    // InternalLatteCSS.g:1715:6: ( 'padding-bottom' )
                    {
                    // InternalLatteCSS.g:1715:6: ( 'padding-bottom' )
                    // InternalLatteCSS.g:1716:1: 'padding-bottom'
                    {
                     before(grammarAccess.getSizePropertyAccess().getPropertyPaddingBottomKeyword_0_0_14()); 
                    match(input,40,FOLLOW_2); 
                     after(grammarAccess.getSizePropertyAccess().getPropertyPaddingBottomKeyword_0_0_14()); 

                    }


                    }
                    break;
                case 16 :
                    // InternalLatteCSS.g:1723:6: ( 'x' )
                    {
                    // InternalLatteCSS.g:1723:6: ( 'x' )
                    // InternalLatteCSS.g:1724:1: 'x'
                    {
                     before(grammarAccess.getSizePropertyAccess().getPropertyXKeyword_0_0_15()); 
                    match(input,41,FOLLOW_2); 
                     after(grammarAccess.getSizePropertyAccess().getPropertyXKeyword_0_0_15()); 

                    }


                    }
                    break;
                case 17 :
                    // InternalLatteCSS.g:1731:6: ( 'y' )
                    {
                    // InternalLatteCSS.g:1731:6: ( 'y' )
                    // InternalLatteCSS.g:1732:1: 'y'
                    {
                     before(grammarAccess.getSizePropertyAccess().getPropertyYKeyword_0_0_16()); 
                    match(input,42,FOLLOW_2); 
                     after(grammarAccess.getSizePropertyAccess().getPropertyYKeyword_0_0_16()); 

                    }


                    }
                    break;
                case 18 :
                    // InternalLatteCSS.g:1739:6: ( 'elevation' )
                    {
                    // InternalLatteCSS.g:1739:6: ( 'elevation' )
                    // InternalLatteCSS.g:1740:1: 'elevation'
                    {
                     before(grammarAccess.getSizePropertyAccess().getPropertyElevationKeyword_0_0_17()); 
                    match(input,43,FOLLOW_2); 
                     after(grammarAccess.getSizePropertyAccess().getPropertyElevationKeyword_0_0_17()); 

                    }


                    }
                    break;

            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__SizeProperty__PropertyAlternatives_0_0"


    // $ANTLR start "rule__BorderProperty__PropertyAlternatives_0_0"
    // InternalLatteCSS.g:1752:1: rule__BorderProperty__PropertyAlternatives_0_0 : ( ( 'border' ) | ( 'border-top' ) | ( 'border-bottom' ) | ( 'border-left' ) | ( 'border-right' ) );
    public final void rule__BorderProperty__PropertyAlternatives_0_0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalLatteCSS.g:1756:1: ( ( 'border' ) | ( 'border-top' ) | ( 'border-bottom' ) | ( 'border-left' ) | ( 'border-right' ) )
            int alt10=5;
            switch ( input.LA(1) ) {
            case 44:
                {
                alt10=1;
                }
                break;
            case 45:
                {
                alt10=2;
                }
                break;
            case 46:
                {
                alt10=3;
                }
                break;
            case 47:
                {
                alt10=4;
                }
                break;
            case 48:
                {
                alt10=5;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 10, 0, input);

                throw nvae;
            }

            switch (alt10) {
                case 1 :
                    // InternalLatteCSS.g:1757:1: ( 'border' )
                    {
                    // InternalLatteCSS.g:1757:1: ( 'border' )
                    // InternalLatteCSS.g:1758:1: 'border'
                    {
                     before(grammarAccess.getBorderPropertyAccess().getPropertyBorderKeyword_0_0_0()); 
                    match(input,44,FOLLOW_2); 
                     after(grammarAccess.getBorderPropertyAccess().getPropertyBorderKeyword_0_0_0()); 

                    }


                    }
                    break;
                case 2 :
                    // InternalLatteCSS.g:1765:6: ( 'border-top' )
                    {
                    // InternalLatteCSS.g:1765:6: ( 'border-top' )
                    // InternalLatteCSS.g:1766:1: 'border-top'
                    {
                     before(grammarAccess.getBorderPropertyAccess().getPropertyBorderTopKeyword_0_0_1()); 
                    match(input,45,FOLLOW_2); 
                     after(grammarAccess.getBorderPropertyAccess().getPropertyBorderTopKeyword_0_0_1()); 

                    }


                    }
                    break;
                case 3 :
                    // InternalLatteCSS.g:1773:6: ( 'border-bottom' )
                    {
                    // InternalLatteCSS.g:1773:6: ( 'border-bottom' )
                    // InternalLatteCSS.g:1774:1: 'border-bottom'
                    {
                     before(grammarAccess.getBorderPropertyAccess().getPropertyBorderBottomKeyword_0_0_2()); 
                    match(input,46,FOLLOW_2); 
                     after(grammarAccess.getBorderPropertyAccess().getPropertyBorderBottomKeyword_0_0_2()); 

                    }


                    }
                    break;
                case 4 :
                    // InternalLatteCSS.g:1781:6: ( 'border-left' )
                    {
                    // InternalLatteCSS.g:1781:6: ( 'border-left' )
                    // InternalLatteCSS.g:1782:1: 'border-left'
                    {
                     before(grammarAccess.getBorderPropertyAccess().getPropertyBorderLeftKeyword_0_0_3()); 
                    match(input,47,FOLLOW_2); 
                     after(grammarAccess.getBorderPropertyAccess().getPropertyBorderLeftKeyword_0_0_3()); 

                    }


                    }
                    break;
                case 5 :
                    // InternalLatteCSS.g:1789:6: ( 'border-right' )
                    {
                    // InternalLatteCSS.g:1789:6: ( 'border-right' )
                    // InternalLatteCSS.g:1790:1: 'border-right'
                    {
                     before(grammarAccess.getBorderPropertyAccess().getPropertyBorderRightKeyword_0_0_4()); 
                    match(input,48,FOLLOW_2); 
                     after(grammarAccess.getBorderPropertyAccess().getPropertyBorderRightKeyword_0_0_4()); 

                    }


                    }
                    break;

            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__BorderProperty__PropertyAlternatives_0_0"


    // $ANTLR start "rule__BorderProperty__StyleAlternatives_3_0"
    // InternalLatteCSS.g:1802:1: rule__BorderProperty__StyleAlternatives_3_0 : ( ( 'solid' ) | ( 'dashed' ) | ( 'dotted' ) );
    public final void rule__BorderProperty__StyleAlternatives_3_0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalLatteCSS.g:1806:1: ( ( 'solid' ) | ( 'dashed' ) | ( 'dotted' ) )
            int alt11=3;
            switch ( input.LA(1) ) {
            case 49:
                {
                alt11=1;
                }
                break;
            case 50:
                {
                alt11=2;
                }
                break;
            case 51:
                {
                alt11=3;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 11, 0, input);

                throw nvae;
            }

            switch (alt11) {
                case 1 :
                    // InternalLatteCSS.g:1807:1: ( 'solid' )
                    {
                    // InternalLatteCSS.g:1807:1: ( 'solid' )
                    // InternalLatteCSS.g:1808:1: 'solid'
                    {
                     before(grammarAccess.getBorderPropertyAccess().getStyleSolidKeyword_3_0_0()); 
                    match(input,49,FOLLOW_2); 
                     after(grammarAccess.getBorderPropertyAccess().getStyleSolidKeyword_3_0_0()); 

                    }


                    }
                    break;
                case 2 :
                    // InternalLatteCSS.g:1815:6: ( 'dashed' )
                    {
                    // InternalLatteCSS.g:1815:6: ( 'dashed' )
                    // InternalLatteCSS.g:1816:1: 'dashed'
                    {
                     before(grammarAccess.getBorderPropertyAccess().getStyleDashedKeyword_3_0_1()); 
                    match(input,50,FOLLOW_2); 
                     after(grammarAccess.getBorderPropertyAccess().getStyleDashedKeyword_3_0_1()); 

                    }


                    }
                    break;
                case 3 :
                    // InternalLatteCSS.g:1823:6: ( 'dotted' )
                    {
                    // InternalLatteCSS.g:1823:6: ( 'dotted' )
                    // InternalLatteCSS.g:1824:1: 'dotted'
                    {
                     before(grammarAccess.getBorderPropertyAccess().getStyleDottedKeyword_3_0_2()); 
                    match(input,51,FOLLOW_2); 
                     after(grammarAccess.getBorderPropertyAccess().getStyleDottedKeyword_3_0_2()); 

                    }


                    }
                    break;

            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__BorderProperty__StyleAlternatives_3_0"


    // $ANTLR start "rule__RepeatValue__Alternatives"
    // InternalLatteCSS.g:1836:1: rule__RepeatValue__Alternatives : ( ( 'repeat-x' ) | ( 'mirror-x' ) | ( 'clamp-x' ) | ( 'no-repeat-x' ) | ( 'repeat-y' ) | ( 'mirror-y' ) | ( 'clamp-y' ) | ( 'no-repeat-y' ) );
    public final void rule__RepeatValue__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalLatteCSS.g:1840:1: ( ( 'repeat-x' ) | ( 'mirror-x' ) | ( 'clamp-x' ) | ( 'no-repeat-x' ) | ( 'repeat-y' ) | ( 'mirror-y' ) | ( 'clamp-y' ) | ( 'no-repeat-y' ) )
            int alt12=8;
            switch ( input.LA(1) ) {
            case 52:
                {
                alt12=1;
                }
                break;
            case 53:
                {
                alt12=2;
                }
                break;
            case 54:
                {
                alt12=3;
                }
                break;
            case 55:
                {
                alt12=4;
                }
                break;
            case 56:
                {
                alt12=5;
                }
                break;
            case 57:
                {
                alt12=6;
                }
                break;
            case 58:
                {
                alt12=7;
                }
                break;
            case 59:
                {
                alt12=8;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 12, 0, input);

                throw nvae;
            }

            switch (alt12) {
                case 1 :
                    // InternalLatteCSS.g:1841:1: ( 'repeat-x' )
                    {
                    // InternalLatteCSS.g:1841:1: ( 'repeat-x' )
                    // InternalLatteCSS.g:1842:1: 'repeat-x'
                    {
                     before(grammarAccess.getRepeatValueAccess().getRepeatXKeyword_0()); 
                    match(input,52,FOLLOW_2); 
                     after(grammarAccess.getRepeatValueAccess().getRepeatXKeyword_0()); 

                    }


                    }
                    break;
                case 2 :
                    // InternalLatteCSS.g:1849:6: ( 'mirror-x' )
                    {
                    // InternalLatteCSS.g:1849:6: ( 'mirror-x' )
                    // InternalLatteCSS.g:1850:1: 'mirror-x'
                    {
                     before(grammarAccess.getRepeatValueAccess().getMirrorXKeyword_1()); 
                    match(input,53,FOLLOW_2); 
                     after(grammarAccess.getRepeatValueAccess().getMirrorXKeyword_1()); 

                    }


                    }
                    break;
                case 3 :
                    // InternalLatteCSS.g:1857:6: ( 'clamp-x' )
                    {
                    // InternalLatteCSS.g:1857:6: ( 'clamp-x' )
                    // InternalLatteCSS.g:1858:1: 'clamp-x'
                    {
                     before(grammarAccess.getRepeatValueAccess().getClampXKeyword_2()); 
                    match(input,54,FOLLOW_2); 
                     after(grammarAccess.getRepeatValueAccess().getClampXKeyword_2()); 

                    }


                    }
                    break;
                case 4 :
                    // InternalLatteCSS.g:1865:6: ( 'no-repeat-x' )
                    {
                    // InternalLatteCSS.g:1865:6: ( 'no-repeat-x' )
                    // InternalLatteCSS.g:1866:1: 'no-repeat-x'
                    {
                     before(grammarAccess.getRepeatValueAccess().getNoRepeatXKeyword_3()); 
                    match(input,55,FOLLOW_2); 
                     after(grammarAccess.getRepeatValueAccess().getNoRepeatXKeyword_3()); 

                    }


                    }
                    break;
                case 5 :
                    // InternalLatteCSS.g:1873:6: ( 'repeat-y' )
                    {
                    // InternalLatteCSS.g:1873:6: ( 'repeat-y' )
                    // InternalLatteCSS.g:1874:1: 'repeat-y'
                    {
                     before(grammarAccess.getRepeatValueAccess().getRepeatYKeyword_4()); 
                    match(input,56,FOLLOW_2); 
                     after(grammarAccess.getRepeatValueAccess().getRepeatYKeyword_4()); 

                    }


                    }
                    break;
                case 6 :
                    // InternalLatteCSS.g:1881:6: ( 'mirror-y' )
                    {
                    // InternalLatteCSS.g:1881:6: ( 'mirror-y' )
                    // InternalLatteCSS.g:1882:1: 'mirror-y'
                    {
                     before(grammarAccess.getRepeatValueAccess().getMirrorYKeyword_5()); 
                    match(input,57,FOLLOW_2); 
                     after(grammarAccess.getRepeatValueAccess().getMirrorYKeyword_5()); 

                    }


                    }
                    break;
                case 7 :
                    // InternalLatteCSS.g:1889:6: ( 'clamp-y' )
                    {
                    // InternalLatteCSS.g:1889:6: ( 'clamp-y' )
                    // InternalLatteCSS.g:1890:1: 'clamp-y'
                    {
                     before(grammarAccess.getRepeatValueAccess().getClampYKeyword_6()); 
                    match(input,58,FOLLOW_2); 
                     after(grammarAccess.getRepeatValueAccess().getClampYKeyword_6()); 

                    }


                    }
                    break;
                case 8 :
                    // InternalLatteCSS.g:1897:6: ( 'no-repeat-y' )
                    {
                    // InternalLatteCSS.g:1897:6: ( 'no-repeat-y' )
                    // InternalLatteCSS.g:1898:1: 'no-repeat-y'
                    {
                     before(grammarAccess.getRepeatValueAccess().getNoRepeatYKeyword_7()); 
                    match(input,59,FOLLOW_2); 
                     after(grammarAccess.getRepeatValueAccess().getNoRepeatYKeyword_7()); 

                    }


                    }
                    break;

            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__RepeatValue__Alternatives"


    // $ANTLR start "rule__GravityValue__Alternatives"
    // InternalLatteCSS.g:1910:1: rule__GravityValue__Alternatives : ( ( 'top' ) | ( 'bottom' ) | ( 'left' ) | ( 'right' ) | ( 'center_vertical' ) | ( 'fill_vertical' ) | ( 'center_horizontal' ) | ( 'fill_horizontal' ) | ( 'center' ) | ( 'fill' ) | ( 'clip_vertical' ) | ( 'clip_horizontal' ) | ( 'start' ) | ( 'end' ) );
    public final void rule__GravityValue__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalLatteCSS.g:1914:1: ( ( 'top' ) | ( 'bottom' ) | ( 'left' ) | ( 'right' ) | ( 'center_vertical' ) | ( 'fill_vertical' ) | ( 'center_horizontal' ) | ( 'fill_horizontal' ) | ( 'center' ) | ( 'fill' ) | ( 'clip_vertical' ) | ( 'clip_horizontal' ) | ( 'start' ) | ( 'end' ) )
            int alt13=14;
            switch ( input.LA(1) ) {
            case 60:
                {
                alt13=1;
                }
                break;
            case 61:
                {
                alt13=2;
                }
                break;
            case 62:
                {
                alt13=3;
                }
                break;
            case 63:
                {
                alt13=4;
                }
                break;
            case 64:
                {
                alt13=5;
                }
                break;
            case 65:
                {
                alt13=6;
                }
                break;
            case 66:
                {
                alt13=7;
                }
                break;
            case 67:
                {
                alt13=8;
                }
                break;
            case 68:
                {
                alt13=9;
                }
                break;
            case 69:
                {
                alt13=10;
                }
                break;
            case 70:
                {
                alt13=11;
                }
                break;
            case 71:
                {
                alt13=12;
                }
                break;
            case 72:
                {
                alt13=13;
                }
                break;
            case 73:
                {
                alt13=14;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 13, 0, input);

                throw nvae;
            }

            switch (alt13) {
                case 1 :
                    // InternalLatteCSS.g:1915:1: ( 'top' )
                    {
                    // InternalLatteCSS.g:1915:1: ( 'top' )
                    // InternalLatteCSS.g:1916:1: 'top'
                    {
                     before(grammarAccess.getGravityValueAccess().getTopKeyword_0()); 
                    match(input,60,FOLLOW_2); 
                     after(grammarAccess.getGravityValueAccess().getTopKeyword_0()); 

                    }


                    }
                    break;
                case 2 :
                    // InternalLatteCSS.g:1923:6: ( 'bottom' )
                    {
                    // InternalLatteCSS.g:1923:6: ( 'bottom' )
                    // InternalLatteCSS.g:1924:1: 'bottom'
                    {
                     before(grammarAccess.getGravityValueAccess().getBottomKeyword_1()); 
                    match(input,61,FOLLOW_2); 
                     after(grammarAccess.getGravityValueAccess().getBottomKeyword_1()); 

                    }


                    }
                    break;
                case 3 :
                    // InternalLatteCSS.g:1931:6: ( 'left' )
                    {
                    // InternalLatteCSS.g:1931:6: ( 'left' )
                    // InternalLatteCSS.g:1932:1: 'left'
                    {
                     before(grammarAccess.getGravityValueAccess().getLeftKeyword_2()); 
                    match(input,62,FOLLOW_2); 
                     after(grammarAccess.getGravityValueAccess().getLeftKeyword_2()); 

                    }


                    }
                    break;
                case 4 :
                    // InternalLatteCSS.g:1939:6: ( 'right' )
                    {
                    // InternalLatteCSS.g:1939:6: ( 'right' )
                    // InternalLatteCSS.g:1940:1: 'right'
                    {
                     before(grammarAccess.getGravityValueAccess().getRightKeyword_3()); 
                    match(input,63,FOLLOW_2); 
                     after(grammarAccess.getGravityValueAccess().getRightKeyword_3()); 

                    }


                    }
                    break;
                case 5 :
                    // InternalLatteCSS.g:1947:6: ( 'center_vertical' )
                    {
                    // InternalLatteCSS.g:1947:6: ( 'center_vertical' )
                    // InternalLatteCSS.g:1948:1: 'center_vertical'
                    {
                     before(grammarAccess.getGravityValueAccess().getCenter_verticalKeyword_4()); 
                    match(input,64,FOLLOW_2); 
                     after(grammarAccess.getGravityValueAccess().getCenter_verticalKeyword_4()); 

                    }


                    }
                    break;
                case 6 :
                    // InternalLatteCSS.g:1955:6: ( 'fill_vertical' )
                    {
                    // InternalLatteCSS.g:1955:6: ( 'fill_vertical' )
                    // InternalLatteCSS.g:1956:1: 'fill_vertical'
                    {
                     before(grammarAccess.getGravityValueAccess().getFill_verticalKeyword_5()); 
                    match(input,65,FOLLOW_2); 
                     after(grammarAccess.getGravityValueAccess().getFill_verticalKeyword_5()); 

                    }


                    }
                    break;
                case 7 :
                    // InternalLatteCSS.g:1963:6: ( 'center_horizontal' )
                    {
                    // InternalLatteCSS.g:1963:6: ( 'center_horizontal' )
                    // InternalLatteCSS.g:1964:1: 'center_horizontal'
                    {
                     before(grammarAccess.getGravityValueAccess().getCenter_horizontalKeyword_6()); 
                    match(input,66,FOLLOW_2); 
                     after(grammarAccess.getGravityValueAccess().getCenter_horizontalKeyword_6()); 

                    }


                    }
                    break;
                case 8 :
                    // InternalLatteCSS.g:1971:6: ( 'fill_horizontal' )
                    {
                    // InternalLatteCSS.g:1971:6: ( 'fill_horizontal' )
                    // InternalLatteCSS.g:1972:1: 'fill_horizontal'
                    {
                     before(grammarAccess.getGravityValueAccess().getFill_horizontalKeyword_7()); 
                    match(input,67,FOLLOW_2); 
                     after(grammarAccess.getGravityValueAccess().getFill_horizontalKeyword_7()); 

                    }


                    }
                    break;
                case 9 :
                    // InternalLatteCSS.g:1979:6: ( 'center' )
                    {
                    // InternalLatteCSS.g:1979:6: ( 'center' )
                    // InternalLatteCSS.g:1980:1: 'center'
                    {
                     before(grammarAccess.getGravityValueAccess().getCenterKeyword_8()); 
                    match(input,68,FOLLOW_2); 
                     after(grammarAccess.getGravityValueAccess().getCenterKeyword_8()); 

                    }


                    }
                    break;
                case 10 :
                    // InternalLatteCSS.g:1987:6: ( 'fill' )
                    {
                    // InternalLatteCSS.g:1987:6: ( 'fill' )
                    // InternalLatteCSS.g:1988:1: 'fill'
                    {
                     before(grammarAccess.getGravityValueAccess().getFillKeyword_9()); 
                    match(input,69,FOLLOW_2); 
                     after(grammarAccess.getGravityValueAccess().getFillKeyword_9()); 

                    }


                    }
                    break;
                case 11 :
                    // InternalLatteCSS.g:1995:6: ( 'clip_vertical' )
                    {
                    // InternalLatteCSS.g:1995:6: ( 'clip_vertical' )
                    // InternalLatteCSS.g:1996:1: 'clip_vertical'
                    {
                     before(grammarAccess.getGravityValueAccess().getClip_verticalKeyword_10()); 
                    match(input,70,FOLLOW_2); 
                     after(grammarAccess.getGravityValueAccess().getClip_verticalKeyword_10()); 

                    }


                    }
                    break;
                case 12 :
                    // InternalLatteCSS.g:2003:6: ( 'clip_horizontal' )
                    {
                    // InternalLatteCSS.g:2003:6: ( 'clip_horizontal' )
                    // InternalLatteCSS.g:2004:1: 'clip_horizontal'
                    {
                     before(grammarAccess.getGravityValueAccess().getClip_horizontalKeyword_11()); 
                    match(input,71,FOLLOW_2); 
                     after(grammarAccess.getGravityValueAccess().getClip_horizontalKeyword_11()); 

                    }


                    }
                    break;
                case 13 :
                    // InternalLatteCSS.g:2011:6: ( 'start' )
                    {
                    // InternalLatteCSS.g:2011:6: ( 'start' )
                    // InternalLatteCSS.g:2012:1: 'start'
                    {
                     before(grammarAccess.getGravityValueAccess().getStartKeyword_12()); 
                    match(input,72,FOLLOW_2); 
                     after(grammarAccess.getGravityValueAccess().getStartKeyword_12()); 

                    }


                    }
                    break;
                case 14 :
                    // InternalLatteCSS.g:2019:6: ( 'end' )
                    {
                    // InternalLatteCSS.g:2019:6: ( 'end' )
                    // InternalLatteCSS.g:2020:1: 'end'
                    {
                     before(grammarAccess.getGravityValueAccess().getEndKeyword_13()); 
                    match(input,73,FOLLOW_2); 
                     after(grammarAccess.getGravityValueAccess().getEndKeyword_13()); 

                    }


                    }
                    break;

            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__GravityValue__Alternatives"


    // $ANTLR start "rule__FilterValue__Alternatives"
    // InternalLatteCSS.g:2032:1: rule__FilterValue__Alternatives : ( ( 'add' ) | ( 'clear' ) | ( 'darken' ) | ( 'dst' ) | ( 'dst_atop' ) | ( 'dst_in' ) | ( 'dst_out' ) | ( 'dst_over' ) | ( 'lighten' ) | ( 'multiply' ) | ( 'overlay' ) | ( 'screen' ) | ( 'src' ) | ( 'src_atop' ) | ( 'src_in' ) | ( 'src_out' ) | ( 'src_over' ) | ( 'xor' ) );
    public final void rule__FilterValue__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalLatteCSS.g:2036:1: ( ( 'add' ) | ( 'clear' ) | ( 'darken' ) | ( 'dst' ) | ( 'dst_atop' ) | ( 'dst_in' ) | ( 'dst_out' ) | ( 'dst_over' ) | ( 'lighten' ) | ( 'multiply' ) | ( 'overlay' ) | ( 'screen' ) | ( 'src' ) | ( 'src_atop' ) | ( 'src_in' ) | ( 'src_out' ) | ( 'src_over' ) | ( 'xor' ) )
            int alt14=18;
            switch ( input.LA(1) ) {
            case 74:
                {
                alt14=1;
                }
                break;
            case 75:
                {
                alt14=2;
                }
                break;
            case 76:
                {
                alt14=3;
                }
                break;
            case 77:
                {
                alt14=4;
                }
                break;
            case 78:
                {
                alt14=5;
                }
                break;
            case 79:
                {
                alt14=6;
                }
                break;
            case 80:
                {
                alt14=7;
                }
                break;
            case 81:
                {
                alt14=8;
                }
                break;
            case 82:
                {
                alt14=9;
                }
                break;
            case 83:
                {
                alt14=10;
                }
                break;
            case 84:
                {
                alt14=11;
                }
                break;
            case 85:
                {
                alt14=12;
                }
                break;
            case 86:
                {
                alt14=13;
                }
                break;
            case 87:
                {
                alt14=14;
                }
                break;
            case 88:
                {
                alt14=15;
                }
                break;
            case 89:
                {
                alt14=16;
                }
                break;
            case 90:
                {
                alt14=17;
                }
                break;
            case 91:
                {
                alt14=18;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 14, 0, input);

                throw nvae;
            }

            switch (alt14) {
                case 1 :
                    // InternalLatteCSS.g:2037:1: ( 'add' )
                    {
                    // InternalLatteCSS.g:2037:1: ( 'add' )
                    // InternalLatteCSS.g:2038:1: 'add'
                    {
                     before(grammarAccess.getFilterValueAccess().getAddKeyword_0()); 
                    match(input,74,FOLLOW_2); 
                     after(grammarAccess.getFilterValueAccess().getAddKeyword_0()); 

                    }


                    }
                    break;
                case 2 :
                    // InternalLatteCSS.g:2045:6: ( 'clear' )
                    {
                    // InternalLatteCSS.g:2045:6: ( 'clear' )
                    // InternalLatteCSS.g:2046:1: 'clear'
                    {
                     before(grammarAccess.getFilterValueAccess().getClearKeyword_1()); 
                    match(input,75,FOLLOW_2); 
                     after(grammarAccess.getFilterValueAccess().getClearKeyword_1()); 

                    }


                    }
                    break;
                case 3 :
                    // InternalLatteCSS.g:2053:6: ( 'darken' )
                    {
                    // InternalLatteCSS.g:2053:6: ( 'darken' )
                    // InternalLatteCSS.g:2054:1: 'darken'
                    {
                     before(grammarAccess.getFilterValueAccess().getDarkenKeyword_2()); 
                    match(input,76,FOLLOW_2); 
                     after(grammarAccess.getFilterValueAccess().getDarkenKeyword_2()); 

                    }


                    }
                    break;
                case 4 :
                    // InternalLatteCSS.g:2061:6: ( 'dst' )
                    {
                    // InternalLatteCSS.g:2061:6: ( 'dst' )
                    // InternalLatteCSS.g:2062:1: 'dst'
                    {
                     before(grammarAccess.getFilterValueAccess().getDstKeyword_3()); 
                    match(input,77,FOLLOW_2); 
                     after(grammarAccess.getFilterValueAccess().getDstKeyword_3()); 

                    }


                    }
                    break;
                case 5 :
                    // InternalLatteCSS.g:2069:6: ( 'dst_atop' )
                    {
                    // InternalLatteCSS.g:2069:6: ( 'dst_atop' )
                    // InternalLatteCSS.g:2070:1: 'dst_atop'
                    {
                     before(grammarAccess.getFilterValueAccess().getDst_atopKeyword_4()); 
                    match(input,78,FOLLOW_2); 
                     after(grammarAccess.getFilterValueAccess().getDst_atopKeyword_4()); 

                    }


                    }
                    break;
                case 6 :
                    // InternalLatteCSS.g:2077:6: ( 'dst_in' )
                    {
                    // InternalLatteCSS.g:2077:6: ( 'dst_in' )
                    // InternalLatteCSS.g:2078:1: 'dst_in'
                    {
                     before(grammarAccess.getFilterValueAccess().getDst_inKeyword_5()); 
                    match(input,79,FOLLOW_2); 
                     after(grammarAccess.getFilterValueAccess().getDst_inKeyword_5()); 

                    }


                    }
                    break;
                case 7 :
                    // InternalLatteCSS.g:2085:6: ( 'dst_out' )
                    {
                    // InternalLatteCSS.g:2085:6: ( 'dst_out' )
                    // InternalLatteCSS.g:2086:1: 'dst_out'
                    {
                     before(grammarAccess.getFilterValueAccess().getDst_outKeyword_6()); 
                    match(input,80,FOLLOW_2); 
                     after(grammarAccess.getFilterValueAccess().getDst_outKeyword_6()); 

                    }


                    }
                    break;
                case 8 :
                    // InternalLatteCSS.g:2093:6: ( 'dst_over' )
                    {
                    // InternalLatteCSS.g:2093:6: ( 'dst_over' )
                    // InternalLatteCSS.g:2094:1: 'dst_over'
                    {
                     before(grammarAccess.getFilterValueAccess().getDst_overKeyword_7()); 
                    match(input,81,FOLLOW_2); 
                     after(grammarAccess.getFilterValueAccess().getDst_overKeyword_7()); 

                    }


                    }
                    break;
                case 9 :
                    // InternalLatteCSS.g:2101:6: ( 'lighten' )
                    {
                    // InternalLatteCSS.g:2101:6: ( 'lighten' )
                    // InternalLatteCSS.g:2102:1: 'lighten'
                    {
                     before(grammarAccess.getFilterValueAccess().getLightenKeyword_8()); 
                    match(input,82,FOLLOW_2); 
                     after(grammarAccess.getFilterValueAccess().getLightenKeyword_8()); 

                    }


                    }
                    break;
                case 10 :
                    // InternalLatteCSS.g:2109:6: ( 'multiply' )
                    {
                    // InternalLatteCSS.g:2109:6: ( 'multiply' )
                    // InternalLatteCSS.g:2110:1: 'multiply'
                    {
                     before(grammarAccess.getFilterValueAccess().getMultiplyKeyword_9()); 
                    match(input,83,FOLLOW_2); 
                     after(grammarAccess.getFilterValueAccess().getMultiplyKeyword_9()); 

                    }


                    }
                    break;
                case 11 :
                    // InternalLatteCSS.g:2117:6: ( 'overlay' )
                    {
                    // InternalLatteCSS.g:2117:6: ( 'overlay' )
                    // InternalLatteCSS.g:2118:1: 'overlay'
                    {
                     before(grammarAccess.getFilterValueAccess().getOverlayKeyword_10()); 
                    match(input,84,FOLLOW_2); 
                     after(grammarAccess.getFilterValueAccess().getOverlayKeyword_10()); 

                    }


                    }
                    break;
                case 12 :
                    // InternalLatteCSS.g:2125:6: ( 'screen' )
                    {
                    // InternalLatteCSS.g:2125:6: ( 'screen' )
                    // InternalLatteCSS.g:2126:1: 'screen'
                    {
                     before(grammarAccess.getFilterValueAccess().getScreenKeyword_11()); 
                    match(input,85,FOLLOW_2); 
                     after(grammarAccess.getFilterValueAccess().getScreenKeyword_11()); 

                    }


                    }
                    break;
                case 13 :
                    // InternalLatteCSS.g:2133:6: ( 'src' )
                    {
                    // InternalLatteCSS.g:2133:6: ( 'src' )
                    // InternalLatteCSS.g:2134:1: 'src'
                    {
                     before(grammarAccess.getFilterValueAccess().getSrcKeyword_12()); 
                    match(input,86,FOLLOW_2); 
                     after(grammarAccess.getFilterValueAccess().getSrcKeyword_12()); 

                    }


                    }
                    break;
                case 14 :
                    // InternalLatteCSS.g:2141:6: ( 'src_atop' )
                    {
                    // InternalLatteCSS.g:2141:6: ( 'src_atop' )
                    // InternalLatteCSS.g:2142:1: 'src_atop'
                    {
                     before(grammarAccess.getFilterValueAccess().getSrc_atopKeyword_13()); 
                    match(input,87,FOLLOW_2); 
                     after(grammarAccess.getFilterValueAccess().getSrc_atopKeyword_13()); 

                    }


                    }
                    break;
                case 15 :
                    // InternalLatteCSS.g:2149:6: ( 'src_in' )
                    {
                    // InternalLatteCSS.g:2149:6: ( 'src_in' )
                    // InternalLatteCSS.g:2150:1: 'src_in'
                    {
                     before(grammarAccess.getFilterValueAccess().getSrc_inKeyword_14()); 
                    match(input,88,FOLLOW_2); 
                     after(grammarAccess.getFilterValueAccess().getSrc_inKeyword_14()); 

                    }


                    }
                    break;
                case 16 :
                    // InternalLatteCSS.g:2157:6: ( 'src_out' )
                    {
                    // InternalLatteCSS.g:2157:6: ( 'src_out' )
                    // InternalLatteCSS.g:2158:1: 'src_out'
                    {
                     before(grammarAccess.getFilterValueAccess().getSrc_outKeyword_15()); 
                    match(input,89,FOLLOW_2); 
                     after(grammarAccess.getFilterValueAccess().getSrc_outKeyword_15()); 

                    }


                    }
                    break;
                case 17 :
                    // InternalLatteCSS.g:2165:6: ( 'src_over' )
                    {
                    // InternalLatteCSS.g:2165:6: ( 'src_over' )
                    // InternalLatteCSS.g:2166:1: 'src_over'
                    {
                     before(grammarAccess.getFilterValueAccess().getSrc_overKeyword_16()); 
                    match(input,90,FOLLOW_2); 
                     after(grammarAccess.getFilterValueAccess().getSrc_overKeyword_16()); 

                    }


                    }
                    break;
                case 18 :
                    // InternalLatteCSS.g:2173:6: ( 'xor' )
                    {
                    // InternalLatteCSS.g:2173:6: ( 'xor' )
                    // InternalLatteCSS.g:2174:1: 'xor'
                    {
                     before(grammarAccess.getFilterValueAccess().getXorKeyword_17()); 
                    match(input,91,FOLLOW_2); 
                     after(grammarAccess.getFilterValueAccess().getXorKeyword_17()); 

                    }


                    }
                    break;

            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__FilterValue__Alternatives"


    // $ANTLR start "rule__ColorProperty__PropertyAlternatives_0_0"
    // InternalLatteCSS.g:2186:1: rule__ColorProperty__PropertyAlternatives_0_0 : ( ( 'border-top-color' ) | ( 'border-left-color' ) | ( 'border-right-color' ) | ( 'border-bottom-color' ) | ( 'ripple-color' ) | ( 'background-color' ) | ( 'text-color' ) | ( 'background-filter-color' ) );
    public final void rule__ColorProperty__PropertyAlternatives_0_0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalLatteCSS.g:2190:1: ( ( 'border-top-color' ) | ( 'border-left-color' ) | ( 'border-right-color' ) | ( 'border-bottom-color' ) | ( 'ripple-color' ) | ( 'background-color' ) | ( 'text-color' ) | ( 'background-filter-color' ) )
            int alt15=8;
            switch ( input.LA(1) ) {
            case 92:
                {
                alt15=1;
                }
                break;
            case 93:
                {
                alt15=2;
                }
                break;
            case 94:
                {
                alt15=3;
                }
                break;
            case 95:
                {
                alt15=4;
                }
                break;
            case 96:
                {
                alt15=5;
                }
                break;
            case 97:
                {
                alt15=6;
                }
                break;
            case 98:
                {
                alt15=7;
                }
                break;
            case 99:
                {
                alt15=8;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 15, 0, input);

                throw nvae;
            }

            switch (alt15) {
                case 1 :
                    // InternalLatteCSS.g:2191:1: ( 'border-top-color' )
                    {
                    // InternalLatteCSS.g:2191:1: ( 'border-top-color' )
                    // InternalLatteCSS.g:2192:1: 'border-top-color'
                    {
                     before(grammarAccess.getColorPropertyAccess().getPropertyBorderTopColorKeyword_0_0_0()); 
                    match(input,92,FOLLOW_2); 
                     after(grammarAccess.getColorPropertyAccess().getPropertyBorderTopColorKeyword_0_0_0()); 

                    }


                    }
                    break;
                case 2 :
                    // InternalLatteCSS.g:2199:6: ( 'border-left-color' )
                    {
                    // InternalLatteCSS.g:2199:6: ( 'border-left-color' )
                    // InternalLatteCSS.g:2200:1: 'border-left-color'
                    {
                     before(grammarAccess.getColorPropertyAccess().getPropertyBorderLeftColorKeyword_0_0_1()); 
                    match(input,93,FOLLOW_2); 
                     after(grammarAccess.getColorPropertyAccess().getPropertyBorderLeftColorKeyword_0_0_1()); 

                    }


                    }
                    break;
                case 3 :
                    // InternalLatteCSS.g:2207:6: ( 'border-right-color' )
                    {
                    // InternalLatteCSS.g:2207:6: ( 'border-right-color' )
                    // InternalLatteCSS.g:2208:1: 'border-right-color'
                    {
                     before(grammarAccess.getColorPropertyAccess().getPropertyBorderRightColorKeyword_0_0_2()); 
                    match(input,94,FOLLOW_2); 
                     after(grammarAccess.getColorPropertyAccess().getPropertyBorderRightColorKeyword_0_0_2()); 

                    }


                    }
                    break;
                case 4 :
                    // InternalLatteCSS.g:2215:6: ( 'border-bottom-color' )
                    {
                    // InternalLatteCSS.g:2215:6: ( 'border-bottom-color' )
                    // InternalLatteCSS.g:2216:1: 'border-bottom-color'
                    {
                     before(grammarAccess.getColorPropertyAccess().getPropertyBorderBottomColorKeyword_0_0_3()); 
                    match(input,95,FOLLOW_2); 
                     after(grammarAccess.getColorPropertyAccess().getPropertyBorderBottomColorKeyword_0_0_3()); 

                    }


                    }
                    break;
                case 5 :
                    // InternalLatteCSS.g:2223:6: ( 'ripple-color' )
                    {
                    // InternalLatteCSS.g:2223:6: ( 'ripple-color' )
                    // InternalLatteCSS.g:2224:1: 'ripple-color'
                    {
                     before(grammarAccess.getColorPropertyAccess().getPropertyRippleColorKeyword_0_0_4()); 
                    match(input,96,FOLLOW_2); 
                     after(grammarAccess.getColorPropertyAccess().getPropertyRippleColorKeyword_0_0_4()); 

                    }


                    }
                    break;
                case 6 :
                    // InternalLatteCSS.g:2231:6: ( 'background-color' )
                    {
                    // InternalLatteCSS.g:2231:6: ( 'background-color' )
                    // InternalLatteCSS.g:2232:1: 'background-color'
                    {
                     before(grammarAccess.getColorPropertyAccess().getPropertyBackgroundColorKeyword_0_0_5()); 
                    match(input,97,FOLLOW_2); 
                     after(grammarAccess.getColorPropertyAccess().getPropertyBackgroundColorKeyword_0_0_5()); 

                    }


                    }
                    break;
                case 7 :
                    // InternalLatteCSS.g:2239:6: ( 'text-color' )
                    {
                    // InternalLatteCSS.g:2239:6: ( 'text-color' )
                    // InternalLatteCSS.g:2240:1: 'text-color'
                    {
                     before(grammarAccess.getColorPropertyAccess().getPropertyTextColorKeyword_0_0_6()); 
                    match(input,98,FOLLOW_2); 
                     after(grammarAccess.getColorPropertyAccess().getPropertyTextColorKeyword_0_0_6()); 

                    }


                    }
                    break;
                case 8 :
                    // InternalLatteCSS.g:2247:6: ( 'background-filter-color' )
                    {
                    // InternalLatteCSS.g:2247:6: ( 'background-filter-color' )
                    // InternalLatteCSS.g:2248:1: 'background-filter-color'
                    {
                     before(grammarAccess.getColorPropertyAccess().getPropertyBackgroundFilterColorKeyword_0_0_7()); 
                    match(input,99,FOLLOW_2); 
                     after(grammarAccess.getColorPropertyAccess().getPropertyBackgroundFilterColorKeyword_0_0_7()); 

                    }


                    }
                    break;

            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ColorProperty__PropertyAlternatives_0_0"


    // $ANTLR start "rule__AlignmentProperty__ValueAlternatives_2_0"
    // InternalLatteCSS.g:2260:1: rule__AlignmentProperty__ValueAlternatives_2_0 : ( ( 'left' ) | ( 'center' ) | ( 'right' ) | ( 'justify' ) );
    public final void rule__AlignmentProperty__ValueAlternatives_2_0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalLatteCSS.g:2264:1: ( ( 'left' ) | ( 'center' ) | ( 'right' ) | ( 'justify' ) )
            int alt16=4;
            switch ( input.LA(1) ) {
            case 62:
                {
                alt16=1;
                }
                break;
            case 68:
                {
                alt16=2;
                }
                break;
            case 63:
                {
                alt16=3;
                }
                break;
            case 100:
                {
                alt16=4;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 16, 0, input);

                throw nvae;
            }

            switch (alt16) {
                case 1 :
                    // InternalLatteCSS.g:2265:1: ( 'left' )
                    {
                    // InternalLatteCSS.g:2265:1: ( 'left' )
                    // InternalLatteCSS.g:2266:1: 'left'
                    {
                     before(grammarAccess.getAlignmentPropertyAccess().getValueLeftKeyword_2_0_0()); 
                    match(input,62,FOLLOW_2); 
                     after(grammarAccess.getAlignmentPropertyAccess().getValueLeftKeyword_2_0_0()); 

                    }


                    }
                    break;
                case 2 :
                    // InternalLatteCSS.g:2273:6: ( 'center' )
                    {
                    // InternalLatteCSS.g:2273:6: ( 'center' )
                    // InternalLatteCSS.g:2274:1: 'center'
                    {
                     before(grammarAccess.getAlignmentPropertyAccess().getValueCenterKeyword_2_0_1()); 
                    match(input,68,FOLLOW_2); 
                     after(grammarAccess.getAlignmentPropertyAccess().getValueCenterKeyword_2_0_1()); 

                    }


                    }
                    break;
                case 3 :
                    // InternalLatteCSS.g:2281:6: ( 'right' )
                    {
                    // InternalLatteCSS.g:2281:6: ( 'right' )
                    // InternalLatteCSS.g:2282:1: 'right'
                    {
                     before(grammarAccess.getAlignmentPropertyAccess().getValueRightKeyword_2_0_2()); 
                    match(input,63,FOLLOW_2); 
                     after(grammarAccess.getAlignmentPropertyAccess().getValueRightKeyword_2_0_2()); 

                    }


                    }
                    break;
                case 4 :
                    // InternalLatteCSS.g:2289:6: ( 'justify' )
                    {
                    // InternalLatteCSS.g:2289:6: ( 'justify' )
                    // InternalLatteCSS.g:2290:1: 'justify'
                    {
                     before(grammarAccess.getAlignmentPropertyAccess().getValueJustifyKeyword_2_0_3()); 
                    match(input,100,FOLLOW_2); 
                     after(grammarAccess.getAlignmentPropertyAccess().getValueJustifyKeyword_2_0_3()); 

                    }


                    }
                    break;

            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__AlignmentProperty__ValueAlternatives_2_0"


    // $ANTLR start "rule__TimingFunction__Alternatives"
    // InternalLatteCSS.g:2302:1: rule__TimingFunction__Alternatives : ( ( 'accelerate-decelerate' ) | ( 'accelerate' ) | ( 'anticipate' ) | ( 'anticipate-overshoot' ) | ( 'bounce' ) | ( 'cycle' ) | ( 'decelerate' ) | ( 'fast-out' ) | ( 'fast-out-slow' ) | ( 'linear' ) | ( 'linear-out' ) | ( 'overshoot' ) );
    public final void rule__TimingFunction__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalLatteCSS.g:2306:1: ( ( 'accelerate-decelerate' ) | ( 'accelerate' ) | ( 'anticipate' ) | ( 'anticipate-overshoot' ) | ( 'bounce' ) | ( 'cycle' ) | ( 'decelerate' ) | ( 'fast-out' ) | ( 'fast-out-slow' ) | ( 'linear' ) | ( 'linear-out' ) | ( 'overshoot' ) )
            int alt17=12;
            switch ( input.LA(1) ) {
            case 101:
                {
                alt17=1;
                }
                break;
            case 102:
                {
                alt17=2;
                }
                break;
            case 103:
                {
                alt17=3;
                }
                break;
            case 104:
                {
                alt17=4;
                }
                break;
            case 105:
                {
                alt17=5;
                }
                break;
            case 106:
                {
                alt17=6;
                }
                break;
            case 107:
                {
                alt17=7;
                }
                break;
            case 108:
                {
                alt17=8;
                }
                break;
            case 109:
                {
                alt17=9;
                }
                break;
            case 110:
                {
                alt17=10;
                }
                break;
            case 111:
                {
                alt17=11;
                }
                break;
            case 112:
                {
                alt17=12;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 17, 0, input);

                throw nvae;
            }

            switch (alt17) {
                case 1 :
                    // InternalLatteCSS.g:2307:1: ( 'accelerate-decelerate' )
                    {
                    // InternalLatteCSS.g:2307:1: ( 'accelerate-decelerate' )
                    // InternalLatteCSS.g:2308:1: 'accelerate-decelerate'
                    {
                     before(grammarAccess.getTimingFunctionAccess().getAccelerateDecelerateKeyword_0()); 
                    match(input,101,FOLLOW_2); 
                     after(grammarAccess.getTimingFunctionAccess().getAccelerateDecelerateKeyword_0()); 

                    }


                    }
                    break;
                case 2 :
                    // InternalLatteCSS.g:2315:6: ( 'accelerate' )
                    {
                    // InternalLatteCSS.g:2315:6: ( 'accelerate' )
                    // InternalLatteCSS.g:2316:1: 'accelerate'
                    {
                     before(grammarAccess.getTimingFunctionAccess().getAccelerateKeyword_1()); 
                    match(input,102,FOLLOW_2); 
                     after(grammarAccess.getTimingFunctionAccess().getAccelerateKeyword_1()); 

                    }


                    }
                    break;
                case 3 :
                    // InternalLatteCSS.g:2323:6: ( 'anticipate' )
                    {
                    // InternalLatteCSS.g:2323:6: ( 'anticipate' )
                    // InternalLatteCSS.g:2324:1: 'anticipate'
                    {
                     before(grammarAccess.getTimingFunctionAccess().getAnticipateKeyword_2()); 
                    match(input,103,FOLLOW_2); 
                     after(grammarAccess.getTimingFunctionAccess().getAnticipateKeyword_2()); 

                    }


                    }
                    break;
                case 4 :
                    // InternalLatteCSS.g:2331:6: ( 'anticipate-overshoot' )
                    {
                    // InternalLatteCSS.g:2331:6: ( 'anticipate-overshoot' )
                    // InternalLatteCSS.g:2332:1: 'anticipate-overshoot'
                    {
                     before(grammarAccess.getTimingFunctionAccess().getAnticipateOvershootKeyword_3()); 
                    match(input,104,FOLLOW_2); 
                     after(grammarAccess.getTimingFunctionAccess().getAnticipateOvershootKeyword_3()); 

                    }


                    }
                    break;
                case 5 :
                    // InternalLatteCSS.g:2339:6: ( 'bounce' )
                    {
                    // InternalLatteCSS.g:2339:6: ( 'bounce' )
                    // InternalLatteCSS.g:2340:1: 'bounce'
                    {
                     before(grammarAccess.getTimingFunctionAccess().getBounceKeyword_4()); 
                    match(input,105,FOLLOW_2); 
                     after(grammarAccess.getTimingFunctionAccess().getBounceKeyword_4()); 

                    }


                    }
                    break;
                case 6 :
                    // InternalLatteCSS.g:2347:6: ( 'cycle' )
                    {
                    // InternalLatteCSS.g:2347:6: ( 'cycle' )
                    // InternalLatteCSS.g:2348:1: 'cycle'
                    {
                     before(grammarAccess.getTimingFunctionAccess().getCycleKeyword_5()); 
                    match(input,106,FOLLOW_2); 
                     after(grammarAccess.getTimingFunctionAccess().getCycleKeyword_5()); 

                    }


                    }
                    break;
                case 7 :
                    // InternalLatteCSS.g:2355:6: ( 'decelerate' )
                    {
                    // InternalLatteCSS.g:2355:6: ( 'decelerate' )
                    // InternalLatteCSS.g:2356:1: 'decelerate'
                    {
                     before(grammarAccess.getTimingFunctionAccess().getDecelerateKeyword_6()); 
                    match(input,107,FOLLOW_2); 
                     after(grammarAccess.getTimingFunctionAccess().getDecelerateKeyword_6()); 

                    }


                    }
                    break;
                case 8 :
                    // InternalLatteCSS.g:2363:6: ( 'fast-out' )
                    {
                    // InternalLatteCSS.g:2363:6: ( 'fast-out' )
                    // InternalLatteCSS.g:2364:1: 'fast-out'
                    {
                     before(grammarAccess.getTimingFunctionAccess().getFastOutKeyword_7()); 
                    match(input,108,FOLLOW_2); 
                     after(grammarAccess.getTimingFunctionAccess().getFastOutKeyword_7()); 

                    }


                    }
                    break;
                case 9 :
                    // InternalLatteCSS.g:2371:6: ( 'fast-out-slow' )
                    {
                    // InternalLatteCSS.g:2371:6: ( 'fast-out-slow' )
                    // InternalLatteCSS.g:2372:1: 'fast-out-slow'
                    {
                     before(grammarAccess.getTimingFunctionAccess().getFastOutSlowKeyword_8()); 
                    match(input,109,FOLLOW_2); 
                     after(grammarAccess.getTimingFunctionAccess().getFastOutSlowKeyword_8()); 

                    }


                    }
                    break;
                case 10 :
                    // InternalLatteCSS.g:2379:6: ( 'linear' )
                    {
                    // InternalLatteCSS.g:2379:6: ( 'linear' )
                    // InternalLatteCSS.g:2380:1: 'linear'
                    {
                     before(grammarAccess.getTimingFunctionAccess().getLinearKeyword_9()); 
                    match(input,110,FOLLOW_2); 
                     after(grammarAccess.getTimingFunctionAccess().getLinearKeyword_9()); 

                    }


                    }
                    break;
                case 11 :
                    // InternalLatteCSS.g:2387:6: ( 'linear-out' )
                    {
                    // InternalLatteCSS.g:2387:6: ( 'linear-out' )
                    // InternalLatteCSS.g:2388:1: 'linear-out'
                    {
                     before(grammarAccess.getTimingFunctionAccess().getLinearOutKeyword_10()); 
                    match(input,111,FOLLOW_2); 
                     after(grammarAccess.getTimingFunctionAccess().getLinearOutKeyword_10()); 

                    }


                    }
                    break;
                case 12 :
                    // InternalLatteCSS.g:2395:6: ( 'overshoot' )
                    {
                    // InternalLatteCSS.g:2395:6: ( 'overshoot' )
                    // InternalLatteCSS.g:2396:1: 'overshoot'
                    {
                     before(grammarAccess.getTimingFunctionAccess().getOvershootKeyword_11()); 
                    match(input,112,FOLLOW_2); 
                     after(grammarAccess.getTimingFunctionAccess().getOvershootKeyword_11()); 

                    }


                    }
                    break;

            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__TimingFunction__Alternatives"


    // $ANTLR start "rule__PropertyNameValue__Alternatives"
    // InternalLatteCSS.g:2408:1: rule__PropertyNameValue__Alternatives : ( ( 'margin' ) | ( 'margin-top' ) | ( 'margin-bottom' ) | ( 'margin-left' ) | ( 'margin-right' ) | ( 'padding' ) | ( 'padding-top' ) | ( 'padding-bottom' ) | ( 'padding-left' ) | ( 'padding-right' ) | ( 'width' ) | ( 'height' ) | ( 'translateX' ) | ( 'translateY' ) | ( 'x' ) | ( 'y' ) | ( 'elevation' ) | ( 'font-size' ) | ( 'border-radius' ) | ( 'border-top-left-radius' ) | ( 'border-top-right-radius' ) | ( 'border-bottom-left-radius' ) | ( 'border-bottom-right-radius' ) | ( 'border-width' ) | ( 'border-left-width' ) | ( 'border-right-width' ) | ( 'border-top-width' ) | ( 'border-bottom-width' ) | ( 'border' ) );
    public final void rule__PropertyNameValue__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalLatteCSS.g:2412:1: ( ( 'margin' ) | ( 'margin-top' ) | ( 'margin-bottom' ) | ( 'margin-left' ) | ( 'margin-right' ) | ( 'padding' ) | ( 'padding-top' ) | ( 'padding-bottom' ) | ( 'padding-left' ) | ( 'padding-right' ) | ( 'width' ) | ( 'height' ) | ( 'translateX' ) | ( 'translateY' ) | ( 'x' ) | ( 'y' ) | ( 'elevation' ) | ( 'font-size' ) | ( 'border-radius' ) | ( 'border-top-left-radius' ) | ( 'border-top-right-radius' ) | ( 'border-bottom-left-radius' ) | ( 'border-bottom-right-radius' ) | ( 'border-width' ) | ( 'border-left-width' ) | ( 'border-right-width' ) | ( 'border-top-width' ) | ( 'border-bottom-width' ) | ( 'border' ) )
            int alt18=29;
            switch ( input.LA(1) ) {
            case 20:
                {
                alt18=1;
                }
                break;
            case 35:
                {
                alt18=2;
                }
                break;
            case 36:
                {
                alt18=3;
                }
                break;
            case 33:
                {
                alt18=4;
                }
                break;
            case 34:
                {
                alt18=5;
                }
                break;
            case 21:
                {
                alt18=6;
                }
                break;
            case 39:
                {
                alt18=7;
                }
                break;
            case 40:
                {
                alt18=8;
                }
                break;
            case 37:
                {
                alt18=9;
                }
                break;
            case 38:
                {
                alt18=10;
                }
                break;
            case 16:
                {
                alt18=11;
                }
                break;
            case 17:
                {
                alt18=12;
                }
                break;
            case 113:
                {
                alt18=13;
                }
                break;
            case 114:
                {
                alt18=14;
                }
                break;
            case 41:
                {
                alt18=15;
                }
                break;
            case 42:
                {
                alt18=16;
                }
                break;
            case 43:
                {
                alt18=17;
                }
                break;
            case 30:
                {
                alt18=18;
                }
                break;
            case 19:
                {
                alt18=19;
                }
                break;
            case 22:
                {
                alt18=20;
                }
                break;
            case 23:
                {
                alt18=21;
                }
                break;
            case 24:
                {
                alt18=22;
                }
                break;
            case 25:
                {
                alt18=23;
                }
                break;
            case 18:
                {
                alt18=24;
                }
                break;
            case 26:
                {
                alt18=25;
                }
                break;
            case 27:
                {
                alt18=26;
                }
                break;
            case 28:
                {
                alt18=27;
                }
                break;
            case 29:
                {
                alt18=28;
                }
                break;
            case 44:
                {
                alt18=29;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 18, 0, input);

                throw nvae;
            }

            switch (alt18) {
                case 1 :
                    // InternalLatteCSS.g:2413:1: ( 'margin' )
                    {
                    // InternalLatteCSS.g:2413:1: ( 'margin' )
                    // InternalLatteCSS.g:2414:1: 'margin'
                    {
                     before(grammarAccess.getPropertyNameValueAccess().getMarginKeyword_0()); 
                    match(input,20,FOLLOW_2); 
                     after(grammarAccess.getPropertyNameValueAccess().getMarginKeyword_0()); 

                    }


                    }
                    break;
                case 2 :
                    // InternalLatteCSS.g:2421:6: ( 'margin-top' )
                    {
                    // InternalLatteCSS.g:2421:6: ( 'margin-top' )
                    // InternalLatteCSS.g:2422:1: 'margin-top'
                    {
                     before(grammarAccess.getPropertyNameValueAccess().getMarginTopKeyword_1()); 
                    match(input,35,FOLLOW_2); 
                     after(grammarAccess.getPropertyNameValueAccess().getMarginTopKeyword_1()); 

                    }


                    }
                    break;
                case 3 :
                    // InternalLatteCSS.g:2429:6: ( 'margin-bottom' )
                    {
                    // InternalLatteCSS.g:2429:6: ( 'margin-bottom' )
                    // InternalLatteCSS.g:2430:1: 'margin-bottom'
                    {
                     before(grammarAccess.getPropertyNameValueAccess().getMarginBottomKeyword_2()); 
                    match(input,36,FOLLOW_2); 
                     after(grammarAccess.getPropertyNameValueAccess().getMarginBottomKeyword_2()); 

                    }


                    }
                    break;
                case 4 :
                    // InternalLatteCSS.g:2437:6: ( 'margin-left' )
                    {
                    // InternalLatteCSS.g:2437:6: ( 'margin-left' )
                    // InternalLatteCSS.g:2438:1: 'margin-left'
                    {
                     before(grammarAccess.getPropertyNameValueAccess().getMarginLeftKeyword_3()); 
                    match(input,33,FOLLOW_2); 
                     after(grammarAccess.getPropertyNameValueAccess().getMarginLeftKeyword_3()); 

                    }


                    }
                    break;
                case 5 :
                    // InternalLatteCSS.g:2445:6: ( 'margin-right' )
                    {
                    // InternalLatteCSS.g:2445:6: ( 'margin-right' )
                    // InternalLatteCSS.g:2446:1: 'margin-right'
                    {
                     before(grammarAccess.getPropertyNameValueAccess().getMarginRightKeyword_4()); 
                    match(input,34,FOLLOW_2); 
                     after(grammarAccess.getPropertyNameValueAccess().getMarginRightKeyword_4()); 

                    }


                    }
                    break;
                case 6 :
                    // InternalLatteCSS.g:2453:6: ( 'padding' )
                    {
                    // InternalLatteCSS.g:2453:6: ( 'padding' )
                    // InternalLatteCSS.g:2454:1: 'padding'
                    {
                     before(grammarAccess.getPropertyNameValueAccess().getPaddingKeyword_5()); 
                    match(input,21,FOLLOW_2); 
                     after(grammarAccess.getPropertyNameValueAccess().getPaddingKeyword_5()); 

                    }


                    }
                    break;
                case 7 :
                    // InternalLatteCSS.g:2461:6: ( 'padding-top' )
                    {
                    // InternalLatteCSS.g:2461:6: ( 'padding-top' )
                    // InternalLatteCSS.g:2462:1: 'padding-top'
                    {
                     before(grammarAccess.getPropertyNameValueAccess().getPaddingTopKeyword_6()); 
                    match(input,39,FOLLOW_2); 
                     after(grammarAccess.getPropertyNameValueAccess().getPaddingTopKeyword_6()); 

                    }


                    }
                    break;
                case 8 :
                    // InternalLatteCSS.g:2469:6: ( 'padding-bottom' )
                    {
                    // InternalLatteCSS.g:2469:6: ( 'padding-bottom' )
                    // InternalLatteCSS.g:2470:1: 'padding-bottom'
                    {
                     before(grammarAccess.getPropertyNameValueAccess().getPaddingBottomKeyword_7()); 
                    match(input,40,FOLLOW_2); 
                     after(grammarAccess.getPropertyNameValueAccess().getPaddingBottomKeyword_7()); 

                    }


                    }
                    break;
                case 9 :
                    // InternalLatteCSS.g:2477:6: ( 'padding-left' )
                    {
                    // InternalLatteCSS.g:2477:6: ( 'padding-left' )
                    // InternalLatteCSS.g:2478:1: 'padding-left'
                    {
                     before(grammarAccess.getPropertyNameValueAccess().getPaddingLeftKeyword_8()); 
                    match(input,37,FOLLOW_2); 
                     after(grammarAccess.getPropertyNameValueAccess().getPaddingLeftKeyword_8()); 

                    }


                    }
                    break;
                case 10 :
                    // InternalLatteCSS.g:2485:6: ( 'padding-right' )
                    {
                    // InternalLatteCSS.g:2485:6: ( 'padding-right' )
                    // InternalLatteCSS.g:2486:1: 'padding-right'
                    {
                     before(grammarAccess.getPropertyNameValueAccess().getPaddingRightKeyword_9()); 
                    match(input,38,FOLLOW_2); 
                     after(grammarAccess.getPropertyNameValueAccess().getPaddingRightKeyword_9()); 

                    }


                    }
                    break;
                case 11 :
                    // InternalLatteCSS.g:2493:6: ( 'width' )
                    {
                    // InternalLatteCSS.g:2493:6: ( 'width' )
                    // InternalLatteCSS.g:2494:1: 'width'
                    {
                     before(grammarAccess.getPropertyNameValueAccess().getWidthKeyword_10()); 
                    match(input,16,FOLLOW_2); 
                     after(grammarAccess.getPropertyNameValueAccess().getWidthKeyword_10()); 

                    }


                    }
                    break;
                case 12 :
                    // InternalLatteCSS.g:2501:6: ( 'height' )
                    {
                    // InternalLatteCSS.g:2501:6: ( 'height' )
                    // InternalLatteCSS.g:2502:1: 'height'
                    {
                     before(grammarAccess.getPropertyNameValueAccess().getHeightKeyword_11()); 
                    match(input,17,FOLLOW_2); 
                     after(grammarAccess.getPropertyNameValueAccess().getHeightKeyword_11()); 

                    }


                    }
                    break;
                case 13 :
                    // InternalLatteCSS.g:2509:6: ( 'translateX' )
                    {
                    // InternalLatteCSS.g:2509:6: ( 'translateX' )
                    // InternalLatteCSS.g:2510:1: 'translateX'
                    {
                     before(grammarAccess.getPropertyNameValueAccess().getTranslateXKeyword_12()); 
                    match(input,113,FOLLOW_2); 
                     after(grammarAccess.getPropertyNameValueAccess().getTranslateXKeyword_12()); 

                    }


                    }
                    break;
                case 14 :
                    // InternalLatteCSS.g:2517:6: ( 'translateY' )
                    {
                    // InternalLatteCSS.g:2517:6: ( 'translateY' )
                    // InternalLatteCSS.g:2518:1: 'translateY'
                    {
                     before(grammarAccess.getPropertyNameValueAccess().getTranslateYKeyword_13()); 
                    match(input,114,FOLLOW_2); 
                     after(grammarAccess.getPropertyNameValueAccess().getTranslateYKeyword_13()); 

                    }


                    }
                    break;
                case 15 :
                    // InternalLatteCSS.g:2525:6: ( 'x' )
                    {
                    // InternalLatteCSS.g:2525:6: ( 'x' )
                    // InternalLatteCSS.g:2526:1: 'x'
                    {
                     before(grammarAccess.getPropertyNameValueAccess().getXKeyword_14()); 
                    match(input,41,FOLLOW_2); 
                     after(grammarAccess.getPropertyNameValueAccess().getXKeyword_14()); 

                    }


                    }
                    break;
                case 16 :
                    // InternalLatteCSS.g:2533:6: ( 'y' )
                    {
                    // InternalLatteCSS.g:2533:6: ( 'y' )
                    // InternalLatteCSS.g:2534:1: 'y'
                    {
                     before(grammarAccess.getPropertyNameValueAccess().getYKeyword_15()); 
                    match(input,42,FOLLOW_2); 
                     after(grammarAccess.getPropertyNameValueAccess().getYKeyword_15()); 

                    }


                    }
                    break;
                case 17 :
                    // InternalLatteCSS.g:2541:6: ( 'elevation' )
                    {
                    // InternalLatteCSS.g:2541:6: ( 'elevation' )
                    // InternalLatteCSS.g:2542:1: 'elevation'
                    {
                     before(grammarAccess.getPropertyNameValueAccess().getElevationKeyword_16()); 
                    match(input,43,FOLLOW_2); 
                     after(grammarAccess.getPropertyNameValueAccess().getElevationKeyword_16()); 

                    }


                    }
                    break;
                case 18 :
                    // InternalLatteCSS.g:2549:6: ( 'font-size' )
                    {
                    // InternalLatteCSS.g:2549:6: ( 'font-size' )
                    // InternalLatteCSS.g:2550:1: 'font-size'
                    {
                     before(grammarAccess.getPropertyNameValueAccess().getFontSizeKeyword_17()); 
                    match(input,30,FOLLOW_2); 
                     after(grammarAccess.getPropertyNameValueAccess().getFontSizeKeyword_17()); 

                    }


                    }
                    break;
                case 19 :
                    // InternalLatteCSS.g:2557:6: ( 'border-radius' )
                    {
                    // InternalLatteCSS.g:2557:6: ( 'border-radius' )
                    // InternalLatteCSS.g:2558:1: 'border-radius'
                    {
                     before(grammarAccess.getPropertyNameValueAccess().getBorderRadiusKeyword_18()); 
                    match(input,19,FOLLOW_2); 
                     after(grammarAccess.getPropertyNameValueAccess().getBorderRadiusKeyword_18()); 

                    }


                    }
                    break;
                case 20 :
                    // InternalLatteCSS.g:2565:6: ( 'border-top-left-radius' )
                    {
                    // InternalLatteCSS.g:2565:6: ( 'border-top-left-radius' )
                    // InternalLatteCSS.g:2566:1: 'border-top-left-radius'
                    {
                     before(grammarAccess.getPropertyNameValueAccess().getBorderTopLeftRadiusKeyword_19()); 
                    match(input,22,FOLLOW_2); 
                     after(grammarAccess.getPropertyNameValueAccess().getBorderTopLeftRadiusKeyword_19()); 

                    }


                    }
                    break;
                case 21 :
                    // InternalLatteCSS.g:2573:6: ( 'border-top-right-radius' )
                    {
                    // InternalLatteCSS.g:2573:6: ( 'border-top-right-radius' )
                    // InternalLatteCSS.g:2574:1: 'border-top-right-radius'
                    {
                     before(grammarAccess.getPropertyNameValueAccess().getBorderTopRightRadiusKeyword_20()); 
                    match(input,23,FOLLOW_2); 
                     after(grammarAccess.getPropertyNameValueAccess().getBorderTopRightRadiusKeyword_20()); 

                    }


                    }
                    break;
                case 22 :
                    // InternalLatteCSS.g:2581:6: ( 'border-bottom-left-radius' )
                    {
                    // InternalLatteCSS.g:2581:6: ( 'border-bottom-left-radius' )
                    // InternalLatteCSS.g:2582:1: 'border-bottom-left-radius'
                    {
                     before(grammarAccess.getPropertyNameValueAccess().getBorderBottomLeftRadiusKeyword_21()); 
                    match(input,24,FOLLOW_2); 
                     after(grammarAccess.getPropertyNameValueAccess().getBorderBottomLeftRadiusKeyword_21()); 

                    }


                    }
                    break;
                case 23 :
                    // InternalLatteCSS.g:2589:6: ( 'border-bottom-right-radius' )
                    {
                    // InternalLatteCSS.g:2589:6: ( 'border-bottom-right-radius' )
                    // InternalLatteCSS.g:2590:1: 'border-bottom-right-radius'
                    {
                     before(grammarAccess.getPropertyNameValueAccess().getBorderBottomRightRadiusKeyword_22()); 
                    match(input,25,FOLLOW_2); 
                     after(grammarAccess.getPropertyNameValueAccess().getBorderBottomRightRadiusKeyword_22()); 

                    }


                    }
                    break;
                case 24 :
                    // InternalLatteCSS.g:2597:6: ( 'border-width' )
                    {
                    // InternalLatteCSS.g:2597:6: ( 'border-width' )
                    // InternalLatteCSS.g:2598:1: 'border-width'
                    {
                     before(grammarAccess.getPropertyNameValueAccess().getBorderWidthKeyword_23()); 
                    match(input,18,FOLLOW_2); 
                     after(grammarAccess.getPropertyNameValueAccess().getBorderWidthKeyword_23()); 

                    }


                    }
                    break;
                case 25 :
                    // InternalLatteCSS.g:2605:6: ( 'border-left-width' )
                    {
                    // InternalLatteCSS.g:2605:6: ( 'border-left-width' )
                    // InternalLatteCSS.g:2606:1: 'border-left-width'
                    {
                     before(grammarAccess.getPropertyNameValueAccess().getBorderLeftWidthKeyword_24()); 
                    match(input,26,FOLLOW_2); 
                     after(grammarAccess.getPropertyNameValueAccess().getBorderLeftWidthKeyword_24()); 

                    }


                    }
                    break;
                case 26 :
                    // InternalLatteCSS.g:2613:6: ( 'border-right-width' )
                    {
                    // InternalLatteCSS.g:2613:6: ( 'border-right-width' )
                    // InternalLatteCSS.g:2614:1: 'border-right-width'
                    {
                     before(grammarAccess.getPropertyNameValueAccess().getBorderRightWidthKeyword_25()); 
                    match(input,27,FOLLOW_2); 
                     after(grammarAccess.getPropertyNameValueAccess().getBorderRightWidthKeyword_25()); 

                    }


                    }
                    break;
                case 27 :
                    // InternalLatteCSS.g:2621:6: ( 'border-top-width' )
                    {
                    // InternalLatteCSS.g:2621:6: ( 'border-top-width' )
                    // InternalLatteCSS.g:2622:1: 'border-top-width'
                    {
                     before(grammarAccess.getPropertyNameValueAccess().getBorderTopWidthKeyword_26()); 
                    match(input,28,FOLLOW_2); 
                     after(grammarAccess.getPropertyNameValueAccess().getBorderTopWidthKeyword_26()); 

                    }


                    }
                    break;
                case 28 :
                    // InternalLatteCSS.g:2629:6: ( 'border-bottom-width' )
                    {
                    // InternalLatteCSS.g:2629:6: ( 'border-bottom-width' )
                    // InternalLatteCSS.g:2630:1: 'border-bottom-width'
                    {
                     before(grammarAccess.getPropertyNameValueAccess().getBorderBottomWidthKeyword_27()); 
                    match(input,29,FOLLOW_2); 
                     after(grammarAccess.getPropertyNameValueAccess().getBorderBottomWidthKeyword_27()); 

                    }


                    }
                    break;
                case 29 :
                    // InternalLatteCSS.g:2637:6: ( 'border' )
                    {
                    // InternalLatteCSS.g:2637:6: ( 'border' )
                    // InternalLatteCSS.g:2638:1: 'border'
                    {
                     before(grammarAccess.getPropertyNameValueAccess().getBorderKeyword_28()); 
                    match(input,44,FOLLOW_2); 
                     after(grammarAccess.getPropertyNameValueAccess().getBorderKeyword_28()); 

                    }


                    }
                    break;

            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__PropertyNameValue__Alternatives"


    // $ANTLR start "rule__NumberValue__Alternatives"
    // InternalLatteCSS.g:2650:1: rule__NumberValue__Alternatives : ( ( ruleIntegerValue ) | ( ruleRealValue ) );
    public final void rule__NumberValue__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalLatteCSS.g:2654:1: ( ( ruleIntegerValue ) | ( ruleRealValue ) )
            int alt19=2;
            int LA19_0 = input.LA(1);

            if ( (LA19_0==RULE_INT) ) {
                alt19=1;
            }
            else if ( (LA19_0==RULE_REAL) ) {
                alt19=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 19, 0, input);

                throw nvae;
            }
            switch (alt19) {
                case 1 :
                    // InternalLatteCSS.g:2655:1: ( ruleIntegerValue )
                    {
                    // InternalLatteCSS.g:2655:1: ( ruleIntegerValue )
                    // InternalLatteCSS.g:2656:1: ruleIntegerValue
                    {
                     before(grammarAccess.getNumberValueAccess().getIntegerValueParserRuleCall_0()); 
                    pushFollow(FOLLOW_2);
                    ruleIntegerValue();

                    state._fsp--;

                     after(grammarAccess.getNumberValueAccess().getIntegerValueParserRuleCall_0()); 

                    }


                    }
                    break;
                case 2 :
                    // InternalLatteCSS.g:2661:6: ( ruleRealValue )
                    {
                    // InternalLatteCSS.g:2661:6: ( ruleRealValue )
                    // InternalLatteCSS.g:2662:1: ruleRealValue
                    {
                     before(grammarAccess.getNumberValueAccess().getRealValueParserRuleCall_1()); 
                    pushFollow(FOLLOW_2);
                    ruleRealValue();

                    state._fsp--;

                     after(grammarAccess.getNumberValueAccess().getRealValueParserRuleCall_1()); 

                    }


                    }
                    break;

            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__NumberValue__Alternatives"


    // $ANTLR start "rule__TimeValue__UnitAlternatives_1_0"
    // InternalLatteCSS.g:2672:1: rule__TimeValue__UnitAlternatives_1_0 : ( ( 's' ) | ( 'ms' ) );
    public final void rule__TimeValue__UnitAlternatives_1_0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalLatteCSS.g:2676:1: ( ( 's' ) | ( 'ms' ) )
            int alt20=2;
            int LA20_0 = input.LA(1);

            if ( (LA20_0==115) ) {
                alt20=1;
            }
            else if ( (LA20_0==116) ) {
                alt20=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 20, 0, input);

                throw nvae;
            }
            switch (alt20) {
                case 1 :
                    // InternalLatteCSS.g:2677:1: ( 's' )
                    {
                    // InternalLatteCSS.g:2677:1: ( 's' )
                    // InternalLatteCSS.g:2678:1: 's'
                    {
                     before(grammarAccess.getTimeValueAccess().getUnitSKeyword_1_0_0()); 
                    match(input,115,FOLLOW_2); 
                     after(grammarAccess.getTimeValueAccess().getUnitSKeyword_1_0_0()); 

                    }


                    }
                    break;
                case 2 :
                    // InternalLatteCSS.g:2685:6: ( 'ms' )
                    {
                    // InternalLatteCSS.g:2685:6: ( 'ms' )
                    // InternalLatteCSS.g:2686:1: 'ms'
                    {
                     before(grammarAccess.getTimeValueAccess().getUnitMsKeyword_1_0_1()); 
                    match(input,116,FOLLOW_2); 
                     after(grammarAccess.getTimeValueAccess().getUnitMsKeyword_1_0_1()); 

                    }


                    }
                    break;

            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__TimeValue__UnitAlternatives_1_0"


    // $ANTLR start "rule__ViewSizeValue__Alternatives"
    // InternalLatteCSS.g:2698:1: rule__ViewSizeValue__Alternatives : ( ( ( rule__ViewSizeValue__ValueAssignment_0 ) ) | ( ( rule__ViewSizeValue__DynamicAssignment_1 ) ) );
    public final void rule__ViewSizeValue__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalLatteCSS.g:2702:1: ( ( ( rule__ViewSizeValue__ValueAssignment_0 ) ) | ( ( rule__ViewSizeValue__DynamicAssignment_1 ) ) )
            int alt21=2;
            int LA21_0 = input.LA(1);

            if ( ((LA21_0>=RULE_INT && LA21_0<=RULE_REAL)) ) {
                alt21=1;
            }
            else if ( ((LA21_0>=117 && LA21_0<=118)) ) {
                alt21=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 21, 0, input);

                throw nvae;
            }
            switch (alt21) {
                case 1 :
                    // InternalLatteCSS.g:2703:1: ( ( rule__ViewSizeValue__ValueAssignment_0 ) )
                    {
                    // InternalLatteCSS.g:2703:1: ( ( rule__ViewSizeValue__ValueAssignment_0 ) )
                    // InternalLatteCSS.g:2704:1: ( rule__ViewSizeValue__ValueAssignment_0 )
                    {
                     before(grammarAccess.getViewSizeValueAccess().getValueAssignment_0()); 
                    // InternalLatteCSS.g:2705:1: ( rule__ViewSizeValue__ValueAssignment_0 )
                    // InternalLatteCSS.g:2705:2: rule__ViewSizeValue__ValueAssignment_0
                    {
                    pushFollow(FOLLOW_2);
                    rule__ViewSizeValue__ValueAssignment_0();

                    state._fsp--;


                    }

                     after(grammarAccess.getViewSizeValueAccess().getValueAssignment_0()); 

                    }


                    }
                    break;
                case 2 :
                    // InternalLatteCSS.g:2709:6: ( ( rule__ViewSizeValue__DynamicAssignment_1 ) )
                    {
                    // InternalLatteCSS.g:2709:6: ( ( rule__ViewSizeValue__DynamicAssignment_1 ) )
                    // InternalLatteCSS.g:2710:1: ( rule__ViewSizeValue__DynamicAssignment_1 )
                    {
                     before(grammarAccess.getViewSizeValueAccess().getDynamicAssignment_1()); 
                    // InternalLatteCSS.g:2711:1: ( rule__ViewSizeValue__DynamicAssignment_1 )
                    // InternalLatteCSS.g:2711:2: rule__ViewSizeValue__DynamicAssignment_1
                    {
                    pushFollow(FOLLOW_2);
                    rule__ViewSizeValue__DynamicAssignment_1();

                    state._fsp--;


                    }

                     after(grammarAccess.getViewSizeValueAccess().getDynamicAssignment_1()); 

                    }


                    }
                    break;

            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ViewSizeValue__Alternatives"


    // $ANTLR start "rule__ViewSizeValue__DynamicAlternatives_1_0"
    // InternalLatteCSS.g:2720:1: rule__ViewSizeValue__DynamicAlternatives_1_0 : ( ( 'match_parent' ) | ( 'wrap_content' ) );
    public final void rule__ViewSizeValue__DynamicAlternatives_1_0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalLatteCSS.g:2724:1: ( ( 'match_parent' ) | ( 'wrap_content' ) )
            int alt22=2;
            int LA22_0 = input.LA(1);

            if ( (LA22_0==117) ) {
                alt22=1;
            }
            else if ( (LA22_0==118) ) {
                alt22=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 22, 0, input);

                throw nvae;
            }
            switch (alt22) {
                case 1 :
                    // InternalLatteCSS.g:2725:1: ( 'match_parent' )
                    {
                    // InternalLatteCSS.g:2725:1: ( 'match_parent' )
                    // InternalLatteCSS.g:2726:1: 'match_parent'
                    {
                     before(grammarAccess.getViewSizeValueAccess().getDynamicMatch_parentKeyword_1_0_0()); 
                    match(input,117,FOLLOW_2); 
                     after(grammarAccess.getViewSizeValueAccess().getDynamicMatch_parentKeyword_1_0_0()); 

                    }


                    }
                    break;
                case 2 :
                    // InternalLatteCSS.g:2733:6: ( 'wrap_content' )
                    {
                    // InternalLatteCSS.g:2733:6: ( 'wrap_content' )
                    // InternalLatteCSS.g:2734:1: 'wrap_content'
                    {
                     before(grammarAccess.getViewSizeValueAccess().getDynamicWrap_contentKeyword_1_0_1()); 
                    match(input,118,FOLLOW_2); 
                     after(grammarAccess.getViewSizeValueAccess().getDynamicWrap_contentKeyword_1_0_1()); 

                    }


                    }
                    break;

            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ViewSizeValue__DynamicAlternatives_1_0"


    // $ANTLR start "rule__SizeValue__DimensionAlternatives_1_0"
    // InternalLatteCSS.g:2746:1: rule__SizeValue__DimensionAlternatives_1_0 : ( ( 'dp' ) | ( 'px' ) | ( 'sp' ) | ( 'pt' ) | ( 'mm' ) );
    public final void rule__SizeValue__DimensionAlternatives_1_0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalLatteCSS.g:2750:1: ( ( 'dp' ) | ( 'px' ) | ( 'sp' ) | ( 'pt' ) | ( 'mm' ) )
            int alt23=5;
            switch ( input.LA(1) ) {
            case 119:
                {
                alt23=1;
                }
                break;
            case 120:
                {
                alt23=2;
                }
                break;
            case 121:
                {
                alt23=3;
                }
                break;
            case 122:
                {
                alt23=4;
                }
                break;
            case 123:
                {
                alt23=5;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 23, 0, input);

                throw nvae;
            }

            switch (alt23) {
                case 1 :
                    // InternalLatteCSS.g:2751:1: ( 'dp' )
                    {
                    // InternalLatteCSS.g:2751:1: ( 'dp' )
                    // InternalLatteCSS.g:2752:1: 'dp'
                    {
                     before(grammarAccess.getSizeValueAccess().getDimensionDpKeyword_1_0_0()); 
                    match(input,119,FOLLOW_2); 
                     after(grammarAccess.getSizeValueAccess().getDimensionDpKeyword_1_0_0()); 

                    }


                    }
                    break;
                case 2 :
                    // InternalLatteCSS.g:2759:6: ( 'px' )
                    {
                    // InternalLatteCSS.g:2759:6: ( 'px' )
                    // InternalLatteCSS.g:2760:1: 'px'
                    {
                     before(grammarAccess.getSizeValueAccess().getDimensionPxKeyword_1_0_1()); 
                    match(input,120,FOLLOW_2); 
                     after(grammarAccess.getSizeValueAccess().getDimensionPxKeyword_1_0_1()); 

                    }


                    }
                    break;
                case 3 :
                    // InternalLatteCSS.g:2767:6: ( 'sp' )
                    {
                    // InternalLatteCSS.g:2767:6: ( 'sp' )
                    // InternalLatteCSS.g:2768:1: 'sp'
                    {
                     before(grammarAccess.getSizeValueAccess().getDimensionSpKeyword_1_0_2()); 
                    match(input,121,FOLLOW_2); 
                     after(grammarAccess.getSizeValueAccess().getDimensionSpKeyword_1_0_2()); 

                    }


                    }
                    break;
                case 4 :
                    // InternalLatteCSS.g:2775:6: ( 'pt' )
                    {
                    // InternalLatteCSS.g:2775:6: ( 'pt' )
                    // InternalLatteCSS.g:2776:1: 'pt'
                    {
                     before(grammarAccess.getSizeValueAccess().getDimensionPtKeyword_1_0_3()); 
                    match(input,122,FOLLOW_2); 
                     after(grammarAccess.getSizeValueAccess().getDimensionPtKeyword_1_0_3()); 

                    }


                    }
                    break;
                case 5 :
                    // InternalLatteCSS.g:2783:6: ( 'mm' )
                    {
                    // InternalLatteCSS.g:2783:6: ( 'mm' )
                    // InternalLatteCSS.g:2784:1: 'mm'
                    {
                     before(grammarAccess.getSizeValueAccess().getDimensionMmKeyword_1_0_4()); 
                    match(input,123,FOLLOW_2); 
                     after(grammarAccess.getSizeValueAccess().getDimensionMmKeyword_1_0_4()); 

                    }


                    }
                    break;

            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__SizeValue__DimensionAlternatives_1_0"


    // $ANTLR start "rule__PaintValue__Alternatives"
    // InternalLatteCSS.g:2797:1: rule__PaintValue__Alternatives : ( ( ruleLinearGradient ) | ( ruleRadialGradient ) | ( ruleColorValue ) );
    public final void rule__PaintValue__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalLatteCSS.g:2801:1: ( ( ruleLinearGradient ) | ( ruleRadialGradient ) | ( ruleColorValue ) )
            int alt24=3;
            switch ( input.LA(1) ) {
            case 110:
                {
                alt24=1;
                }
                break;
            case 285:
                {
                alt24=2;
                }
                break;
            case RULE_HEX_NUMBER:
            case 126:
            case 127:
            case 128:
            case 129:
            case 130:
            case 131:
            case 132:
            case 133:
            case 134:
            case 135:
            case 136:
            case 137:
            case 138:
            case 139:
            case 140:
            case 141:
            case 142:
            case 143:
            case 144:
            case 145:
            case 146:
            case 147:
            case 148:
            case 149:
            case 150:
            case 151:
            case 152:
            case 153:
            case 154:
            case 155:
            case 156:
            case 157:
            case 158:
            case 159:
            case 160:
            case 161:
            case 162:
            case 163:
            case 164:
            case 165:
            case 166:
            case 167:
            case 168:
            case 169:
            case 170:
            case 171:
            case 172:
            case 173:
            case 174:
            case 175:
            case 176:
            case 177:
            case 178:
            case 179:
            case 180:
            case 181:
            case 182:
            case 183:
            case 184:
            case 185:
            case 186:
            case 187:
            case 188:
            case 189:
            case 190:
            case 191:
            case 192:
            case 193:
            case 194:
            case 195:
            case 196:
            case 197:
            case 198:
            case 199:
            case 200:
            case 201:
            case 202:
            case 203:
            case 204:
            case 205:
            case 206:
            case 207:
            case 208:
            case 209:
            case 210:
            case 211:
            case 212:
            case 213:
            case 214:
            case 215:
            case 216:
            case 217:
            case 218:
            case 219:
            case 220:
            case 221:
            case 222:
            case 223:
            case 224:
            case 225:
            case 226:
            case 227:
            case 228:
            case 229:
            case 230:
            case 231:
            case 232:
            case 233:
            case 234:
            case 235:
            case 236:
            case 237:
            case 238:
            case 239:
            case 240:
            case 241:
            case 242:
            case 243:
            case 244:
            case 245:
            case 246:
            case 247:
            case 248:
            case 249:
            case 250:
            case 251:
            case 252:
            case 253:
            case 254:
            case 255:
            case 256:
            case 257:
            case 258:
            case 259:
            case 260:
            case 261:
            case 262:
            case 263:
            case 264:
            case 265:
            case 266:
            case 267:
            case 268:
            case 269:
            case 270:
            case 271:
            case 272:
            case 273:
            case 287:
            case 288:
                {
                alt24=3;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 24, 0, input);

                throw nvae;
            }

            switch (alt24) {
                case 1 :
                    // InternalLatteCSS.g:2802:1: ( ruleLinearGradient )
                    {
                    // InternalLatteCSS.g:2802:1: ( ruleLinearGradient )
                    // InternalLatteCSS.g:2803:1: ruleLinearGradient
                    {
                     before(grammarAccess.getPaintValueAccess().getLinearGradientParserRuleCall_0()); 
                    pushFollow(FOLLOW_2);
                    ruleLinearGradient();

                    state._fsp--;

                     after(grammarAccess.getPaintValueAccess().getLinearGradientParserRuleCall_0()); 

                    }


                    }
                    break;
                case 2 :
                    // InternalLatteCSS.g:2808:6: ( ruleRadialGradient )
                    {
                    // InternalLatteCSS.g:2808:6: ( ruleRadialGradient )
                    // InternalLatteCSS.g:2809:1: ruleRadialGradient
                    {
                     before(grammarAccess.getPaintValueAccess().getRadialGradientParserRuleCall_1()); 
                    pushFollow(FOLLOW_2);
                    ruleRadialGradient();

                    state._fsp--;

                     after(grammarAccess.getPaintValueAccess().getRadialGradientParserRuleCall_1()); 

                    }


                    }
                    break;
                case 3 :
                    // InternalLatteCSS.g:2814:6: ( ruleColorValue )
                    {
                    // InternalLatteCSS.g:2814:6: ( ruleColorValue )
                    // InternalLatteCSS.g:2815:1: ruleColorValue
                    {
                     before(grammarAccess.getPaintValueAccess().getColorValueParserRuleCall_2()); 
                    pushFollow(FOLLOW_2);
                    ruleColorValue();

                    state._fsp--;

                     after(grammarAccess.getPaintValueAccess().getColorValueParserRuleCall_2()); 

                    }


                    }
                    break;

            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__PaintValue__Alternatives"


    // $ANTLR start "rule__LinearGradient__Alternatives_14"
    // InternalLatteCSS.g:2825:1: rule__LinearGradient__Alternatives_14 : ( ( 'repeat' ) | ( 'reflect' ) );
    public final void rule__LinearGradient__Alternatives_14() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalLatteCSS.g:2829:1: ( ( 'repeat' ) | ( 'reflect' ) )
            int alt25=2;
            int LA25_0 = input.LA(1);

            if ( (LA25_0==124) ) {
                alt25=1;
            }
            else if ( (LA25_0==125) ) {
                alt25=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 25, 0, input);

                throw nvae;
            }
            switch (alt25) {
                case 1 :
                    // InternalLatteCSS.g:2830:1: ( 'repeat' )
                    {
                    // InternalLatteCSS.g:2830:1: ( 'repeat' )
                    // InternalLatteCSS.g:2831:1: 'repeat'
                    {
                     before(grammarAccess.getLinearGradientAccess().getRepeatKeyword_14_0()); 
                    match(input,124,FOLLOW_2); 
                     after(grammarAccess.getLinearGradientAccess().getRepeatKeyword_14_0()); 

                    }


                    }
                    break;
                case 2 :
                    // InternalLatteCSS.g:2838:6: ( 'reflect' )
                    {
                    // InternalLatteCSS.g:2838:6: ( 'reflect' )
                    // InternalLatteCSS.g:2839:1: 'reflect'
                    {
                     before(grammarAccess.getLinearGradientAccess().getReflectKeyword_14_1()); 
                    match(input,125,FOLLOW_2); 
                     after(grammarAccess.getLinearGradientAccess().getReflectKeyword_14_1()); 

                    }


                    }
                    break;

            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__LinearGradient__Alternatives_14"


    // $ANTLR start "rule__RadialGradient__Alternatives_6"
    // InternalLatteCSS.g:2851:1: rule__RadialGradient__Alternatives_6 : ( ( 'repeat' ) | ( 'reflect' ) );
    public final void rule__RadialGradient__Alternatives_6() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalLatteCSS.g:2855:1: ( ( 'repeat' ) | ( 'reflect' ) )
            int alt26=2;
            int LA26_0 = input.LA(1);

            if ( (LA26_0==124) ) {
                alt26=1;
            }
            else if ( (LA26_0==125) ) {
                alt26=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 26, 0, input);

                throw nvae;
            }
            switch (alt26) {
                case 1 :
                    // InternalLatteCSS.g:2856:1: ( 'repeat' )
                    {
                    // InternalLatteCSS.g:2856:1: ( 'repeat' )
                    // InternalLatteCSS.g:2857:1: 'repeat'
                    {
                     before(grammarAccess.getRadialGradientAccess().getRepeatKeyword_6_0()); 
                    match(input,124,FOLLOW_2); 
                     after(grammarAccess.getRadialGradientAccess().getRepeatKeyword_6_0()); 

                    }


                    }
                    break;
                case 2 :
                    // InternalLatteCSS.g:2864:6: ( 'reflect' )
                    {
                    // InternalLatteCSS.g:2864:6: ( 'reflect' )
                    // InternalLatteCSS.g:2865:1: 'reflect'
                    {
                     before(grammarAccess.getRadialGradientAccess().getReflectKeyword_6_1()); 
                    match(input,125,FOLLOW_2); 
                     after(grammarAccess.getRadialGradientAccess().getReflectKeyword_6_1()); 

                    }


                    }
                    break;

            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__RadialGradient__Alternatives_6"


    // $ANTLR start "rule__ColorValue__Alternatives"
    // InternalLatteCSS.g:2877:1: rule__ColorValue__Alternatives : ( ( ( rule__ColorValue__NamedColorAssignment_0 ) ) | ( ( rule__ColorValue__RgbAssignment_1 ) ) );
    public final void rule__ColorValue__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalLatteCSS.g:2881:1: ( ( ( rule__ColorValue__NamedColorAssignment_0 ) ) | ( ( rule__ColorValue__RgbAssignment_1 ) ) )
            int alt27=2;
            int LA27_0 = input.LA(1);

            if ( ((LA27_0>=126 && LA27_0<=273)) ) {
                alt27=1;
            }
            else if ( (LA27_0==RULE_HEX_NUMBER||(LA27_0>=287 && LA27_0<=288)) ) {
                alt27=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 27, 0, input);

                throw nvae;
            }
            switch (alt27) {
                case 1 :
                    // InternalLatteCSS.g:2882:1: ( ( rule__ColorValue__NamedColorAssignment_0 ) )
                    {
                    // InternalLatteCSS.g:2882:1: ( ( rule__ColorValue__NamedColorAssignment_0 ) )
                    // InternalLatteCSS.g:2883:1: ( rule__ColorValue__NamedColorAssignment_0 )
                    {
                     before(grammarAccess.getColorValueAccess().getNamedColorAssignment_0()); 
                    // InternalLatteCSS.g:2884:1: ( rule__ColorValue__NamedColorAssignment_0 )
                    // InternalLatteCSS.g:2884:2: rule__ColorValue__NamedColorAssignment_0
                    {
                    pushFollow(FOLLOW_2);
                    rule__ColorValue__NamedColorAssignment_0();

                    state._fsp--;


                    }

                     after(grammarAccess.getColorValueAccess().getNamedColorAssignment_0()); 

                    }


                    }
                    break;
                case 2 :
                    // InternalLatteCSS.g:2888:6: ( ( rule__ColorValue__RgbAssignment_1 ) )
                    {
                    // InternalLatteCSS.g:2888:6: ( ( rule__ColorValue__RgbAssignment_1 ) )
                    // InternalLatteCSS.g:2889:1: ( rule__ColorValue__RgbAssignment_1 )
                    {
                     before(grammarAccess.getColorValueAccess().getRgbAssignment_1()); 
                    // InternalLatteCSS.g:2890:1: ( rule__ColorValue__RgbAssignment_1 )
                    // InternalLatteCSS.g:2890:2: rule__ColorValue__RgbAssignment_1
                    {
                    pushFollow(FOLLOW_2);
                    rule__ColorValue__RgbAssignment_1();

                    state._fsp--;


                    }

                     after(grammarAccess.getColorValueAccess().getRgbAssignment_1()); 

                    }


                    }
                    break;

            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ColorValue__Alternatives"


    // $ANTLR start "rule__NamedColor__Alternatives"
    // InternalLatteCSS.g:2899:1: rule__NamedColor__Alternatives : ( ( 'aliceblue' ) | ( 'antiquewhite' ) | ( 'aqua' ) | ( 'aquamarine' ) | ( 'azure' ) | ( 'beige' ) | ( 'bisque' ) | ( 'black' ) | ( 'blanchedalmond' ) | ( 'blue' ) | ( 'blueviolet' ) | ( 'brown' ) | ( 'burlywood' ) | ( 'cadetblue' ) | ( 'chartreuse' ) | ( 'chocolate' ) | ( 'coral' ) | ( 'cornflowerblue' ) | ( 'cornsilk' ) | ( 'crimson' ) | ( 'cyan' ) | ( 'darkblue' ) | ( 'darkcyan' ) | ( 'darkgoldenrod' ) | ( 'darkgray' ) | ( 'darkgreen' ) | ( 'darkgrey' ) | ( 'darkkhaki' ) | ( 'darkmagenta' ) | ( 'darkolivegreen' ) | ( 'darkorange' ) | ( 'darkorchid' ) | ( 'darkred' ) | ( 'darksalmon' ) | ( 'darkseagreen' ) | ( 'darkslateblue' ) | ( 'darkslategray' ) | ( 'darkslategrey' ) | ( 'darkturquoise' ) | ( 'darkviolet' ) | ( 'deeppink' ) | ( 'deepskyblue' ) | ( 'dimgray' ) | ( 'dimgrey' ) | ( 'dodgerblue' ) | ( 'firebrick' ) | ( 'floralwhite' ) | ( 'forestgreen' ) | ( 'fuchsia' ) | ( 'gainsboro' ) | ( 'ghostwhite' ) | ( 'gold' ) | ( 'goldenrod' ) | ( 'gray' ) | ( 'green' ) | ( 'greenyellow' ) | ( 'grey' ) | ( 'honeydew' ) | ( 'hotpink' ) | ( 'indianred' ) | ( 'indigo' ) | ( 'ivory' ) | ( 'khaki' ) | ( 'lavender' ) | ( 'lavenderblush' ) | ( 'lawngreen' ) | ( 'lemonchiffon' ) | ( 'lightblue' ) | ( 'lightcoral' ) | ( 'lightcyan' ) | ( 'lightgoldenrodyellow' ) | ( 'lightgray' ) | ( 'lightgreen' ) | ( 'lightgrey' ) | ( 'lightpink' ) | ( 'lightsalmon' ) | ( 'lightseagreen' ) | ( 'lightskyblue' ) | ( 'lightslategray' ) | ( 'lightslategrey' ) | ( 'lightsteelblue' ) | ( 'lightyellow' ) | ( 'lime' ) | ( 'limegreen' ) | ( 'linen' ) | ( 'magenta' ) | ( 'maroon' ) | ( 'mediumaquamarine' ) | ( 'mediumblue' ) | ( 'mediumorchid' ) | ( 'mediumpurple' ) | ( 'mediumseagreen' ) | ( 'mediumslateblue' ) | ( 'mediumspringgreen' ) | ( 'mediumturquoise' ) | ( 'mediumvioletred' ) | ( 'midnightblue' ) | ( 'mintcream' ) | ( 'mistyrose' ) | ( 'moccasin' ) | ( 'navajowhite' ) | ( 'navy' ) | ( 'oldlace' ) | ( 'olive' ) | ( 'olivedrab' ) | ( 'orange' ) | ( 'orangered' ) | ( 'orchid' ) | ( 'palegoldenrod' ) | ( 'palegreen' ) | ( 'paleturquoise' ) | ( 'palevioletred' ) | ( 'papayawhip' ) | ( 'peachpuff' ) | ( 'peru' ) | ( 'pink' ) | ( 'plum' ) | ( 'powderblue' ) | ( 'purple' ) | ( 'red' ) | ( 'rosybrown' ) | ( 'royalblue' ) | ( 'saddlebrown' ) | ( 'salmon' ) | ( 'sandybrown' ) | ( 'seagreen' ) | ( 'seashell' ) | ( 'sienna' ) | ( 'silver' ) | ( 'skyblue' ) | ( 'slateblue' ) | ( 'slategray' ) | ( 'slategrey' ) | ( 'snow' ) | ( 'springgreen' ) | ( 'steelblue' ) | ( 'tan' ) | ( 'teal' ) | ( 'thistle' ) | ( 'tomato' ) | ( 'turquoise' ) | ( 'violet' ) | ( 'wheat' ) | ( 'white' ) | ( 'whitesmoke' ) | ( 'yellow' ) | ( 'yellowgreen' ) | ( 'transparent' ) );
    public final void rule__NamedColor__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalLatteCSS.g:2903:1: ( ( 'aliceblue' ) | ( 'antiquewhite' ) | ( 'aqua' ) | ( 'aquamarine' ) | ( 'azure' ) | ( 'beige' ) | ( 'bisque' ) | ( 'black' ) | ( 'blanchedalmond' ) | ( 'blue' ) | ( 'blueviolet' ) | ( 'brown' ) | ( 'burlywood' ) | ( 'cadetblue' ) | ( 'chartreuse' ) | ( 'chocolate' ) | ( 'coral' ) | ( 'cornflowerblue' ) | ( 'cornsilk' ) | ( 'crimson' ) | ( 'cyan' ) | ( 'darkblue' ) | ( 'darkcyan' ) | ( 'darkgoldenrod' ) | ( 'darkgray' ) | ( 'darkgreen' ) | ( 'darkgrey' ) | ( 'darkkhaki' ) | ( 'darkmagenta' ) | ( 'darkolivegreen' ) | ( 'darkorange' ) | ( 'darkorchid' ) | ( 'darkred' ) | ( 'darksalmon' ) | ( 'darkseagreen' ) | ( 'darkslateblue' ) | ( 'darkslategray' ) | ( 'darkslategrey' ) | ( 'darkturquoise' ) | ( 'darkviolet' ) | ( 'deeppink' ) | ( 'deepskyblue' ) | ( 'dimgray' ) | ( 'dimgrey' ) | ( 'dodgerblue' ) | ( 'firebrick' ) | ( 'floralwhite' ) | ( 'forestgreen' ) | ( 'fuchsia' ) | ( 'gainsboro' ) | ( 'ghostwhite' ) | ( 'gold' ) | ( 'goldenrod' ) | ( 'gray' ) | ( 'green' ) | ( 'greenyellow' ) | ( 'grey' ) | ( 'honeydew' ) | ( 'hotpink' ) | ( 'indianred' ) | ( 'indigo' ) | ( 'ivory' ) | ( 'khaki' ) | ( 'lavender' ) | ( 'lavenderblush' ) | ( 'lawngreen' ) | ( 'lemonchiffon' ) | ( 'lightblue' ) | ( 'lightcoral' ) | ( 'lightcyan' ) | ( 'lightgoldenrodyellow' ) | ( 'lightgray' ) | ( 'lightgreen' ) | ( 'lightgrey' ) | ( 'lightpink' ) | ( 'lightsalmon' ) | ( 'lightseagreen' ) | ( 'lightskyblue' ) | ( 'lightslategray' ) | ( 'lightslategrey' ) | ( 'lightsteelblue' ) | ( 'lightyellow' ) | ( 'lime' ) | ( 'limegreen' ) | ( 'linen' ) | ( 'magenta' ) | ( 'maroon' ) | ( 'mediumaquamarine' ) | ( 'mediumblue' ) | ( 'mediumorchid' ) | ( 'mediumpurple' ) | ( 'mediumseagreen' ) | ( 'mediumslateblue' ) | ( 'mediumspringgreen' ) | ( 'mediumturquoise' ) | ( 'mediumvioletred' ) | ( 'midnightblue' ) | ( 'mintcream' ) | ( 'mistyrose' ) | ( 'moccasin' ) | ( 'navajowhite' ) | ( 'navy' ) | ( 'oldlace' ) | ( 'olive' ) | ( 'olivedrab' ) | ( 'orange' ) | ( 'orangered' ) | ( 'orchid' ) | ( 'palegoldenrod' ) | ( 'palegreen' ) | ( 'paleturquoise' ) | ( 'palevioletred' ) | ( 'papayawhip' ) | ( 'peachpuff' ) | ( 'peru' ) | ( 'pink' ) | ( 'plum' ) | ( 'powderblue' ) | ( 'purple' ) | ( 'red' ) | ( 'rosybrown' ) | ( 'royalblue' ) | ( 'saddlebrown' ) | ( 'salmon' ) | ( 'sandybrown' ) | ( 'seagreen' ) | ( 'seashell' ) | ( 'sienna' ) | ( 'silver' ) | ( 'skyblue' ) | ( 'slateblue' ) | ( 'slategray' ) | ( 'slategrey' ) | ( 'snow' ) | ( 'springgreen' ) | ( 'steelblue' ) | ( 'tan' ) | ( 'teal' ) | ( 'thistle' ) | ( 'tomato' ) | ( 'turquoise' ) | ( 'violet' ) | ( 'wheat' ) | ( 'white' ) | ( 'whitesmoke' ) | ( 'yellow' ) | ( 'yellowgreen' ) | ( 'transparent' ) )
            int alt28=148;
            switch ( input.LA(1) ) {
            case 126:
                {
                alt28=1;
                }
                break;
            case 127:
                {
                alt28=2;
                }
                break;
            case 128:
                {
                alt28=3;
                }
                break;
            case 129:
                {
                alt28=4;
                }
                break;
            case 130:
                {
                alt28=5;
                }
                break;
            case 131:
                {
                alt28=6;
                }
                break;
            case 132:
                {
                alt28=7;
                }
                break;
            case 133:
                {
                alt28=8;
                }
                break;
            case 134:
                {
                alt28=9;
                }
                break;
            case 135:
                {
                alt28=10;
                }
                break;
            case 136:
                {
                alt28=11;
                }
                break;
            case 137:
                {
                alt28=12;
                }
                break;
            case 138:
                {
                alt28=13;
                }
                break;
            case 139:
                {
                alt28=14;
                }
                break;
            case 140:
                {
                alt28=15;
                }
                break;
            case 141:
                {
                alt28=16;
                }
                break;
            case 142:
                {
                alt28=17;
                }
                break;
            case 143:
                {
                alt28=18;
                }
                break;
            case 144:
                {
                alt28=19;
                }
                break;
            case 145:
                {
                alt28=20;
                }
                break;
            case 146:
                {
                alt28=21;
                }
                break;
            case 147:
                {
                alt28=22;
                }
                break;
            case 148:
                {
                alt28=23;
                }
                break;
            case 149:
                {
                alt28=24;
                }
                break;
            case 150:
                {
                alt28=25;
                }
                break;
            case 151:
                {
                alt28=26;
                }
                break;
            case 152:
                {
                alt28=27;
                }
                break;
            case 153:
                {
                alt28=28;
                }
                break;
            case 154:
                {
                alt28=29;
                }
                break;
            case 155:
                {
                alt28=30;
                }
                break;
            case 156:
                {
                alt28=31;
                }
                break;
            case 157:
                {
                alt28=32;
                }
                break;
            case 158:
                {
                alt28=33;
                }
                break;
            case 159:
                {
                alt28=34;
                }
                break;
            case 160:
                {
                alt28=35;
                }
                break;
            case 161:
                {
                alt28=36;
                }
                break;
            case 162:
                {
                alt28=37;
                }
                break;
            case 163:
                {
                alt28=38;
                }
                break;
            case 164:
                {
                alt28=39;
                }
                break;
            case 165:
                {
                alt28=40;
                }
                break;
            case 166:
                {
                alt28=41;
                }
                break;
            case 167:
                {
                alt28=42;
                }
                break;
            case 168:
                {
                alt28=43;
                }
                break;
            case 169:
                {
                alt28=44;
                }
                break;
            case 170:
                {
                alt28=45;
                }
                break;
            case 171:
                {
                alt28=46;
                }
                break;
            case 172:
                {
                alt28=47;
                }
                break;
            case 173:
                {
                alt28=48;
                }
                break;
            case 174:
                {
                alt28=49;
                }
                break;
            case 175:
                {
                alt28=50;
                }
                break;
            case 176:
                {
                alt28=51;
                }
                break;
            case 177:
                {
                alt28=52;
                }
                break;
            case 178:
                {
                alt28=53;
                }
                break;
            case 179:
                {
                alt28=54;
                }
                break;
            case 180:
                {
                alt28=55;
                }
                break;
            case 181:
                {
                alt28=56;
                }
                break;
            case 182:
                {
                alt28=57;
                }
                break;
            case 183:
                {
                alt28=58;
                }
                break;
            case 184:
                {
                alt28=59;
                }
                break;
            case 185:
                {
                alt28=60;
                }
                break;
            case 186:
                {
                alt28=61;
                }
                break;
            case 187:
                {
                alt28=62;
                }
                break;
            case 188:
                {
                alt28=63;
                }
                break;
            case 189:
                {
                alt28=64;
                }
                break;
            case 190:
                {
                alt28=65;
                }
                break;
            case 191:
                {
                alt28=66;
                }
                break;
            case 192:
                {
                alt28=67;
                }
                break;
            case 193:
                {
                alt28=68;
                }
                break;
            case 194:
                {
                alt28=69;
                }
                break;
            case 195:
                {
                alt28=70;
                }
                break;
            case 196:
                {
                alt28=71;
                }
                break;
            case 197:
                {
                alt28=72;
                }
                break;
            case 198:
                {
                alt28=73;
                }
                break;
            case 199:
                {
                alt28=74;
                }
                break;
            case 200:
                {
                alt28=75;
                }
                break;
            case 201:
                {
                alt28=76;
                }
                break;
            case 202:
                {
                alt28=77;
                }
                break;
            case 203:
                {
                alt28=78;
                }
                break;
            case 204:
                {
                alt28=79;
                }
                break;
            case 205:
                {
                alt28=80;
                }
                break;
            case 206:
                {
                alt28=81;
                }
                break;
            case 207:
                {
                alt28=82;
                }
                break;
            case 208:
                {
                alt28=83;
                }
                break;
            case 209:
                {
                alt28=84;
                }
                break;
            case 210:
                {
                alt28=85;
                }
                break;
            case 211:
                {
                alt28=86;
                }
                break;
            case 212:
                {
                alt28=87;
                }
                break;
            case 213:
                {
                alt28=88;
                }
                break;
            case 214:
                {
                alt28=89;
                }
                break;
            case 215:
                {
                alt28=90;
                }
                break;
            case 216:
                {
                alt28=91;
                }
                break;
            case 217:
                {
                alt28=92;
                }
                break;
            case 218:
                {
                alt28=93;
                }
                break;
            case 219:
                {
                alt28=94;
                }
                break;
            case 220:
                {
                alt28=95;
                }
                break;
            case 221:
                {
                alt28=96;
                }
                break;
            case 222:
                {
                alt28=97;
                }
                break;
            case 223:
                {
                alt28=98;
                }
                break;
            case 224:
                {
                alt28=99;
                }
                break;
            case 225:
                {
                alt28=100;
                }
                break;
            case 226:
                {
                alt28=101;
                }
                break;
            case 227:
                {
                alt28=102;
                }
                break;
            case 228:
                {
                alt28=103;
                }
                break;
            case 229:
                {
                alt28=104;
                }
                break;
            case 230:
                {
                alt28=105;
                }
                break;
            case 231:
                {
                alt28=106;
                }
                break;
            case 232:
                {
                alt28=107;
                }
                break;
            case 233:
                {
                alt28=108;
                }
                break;
            case 234:
                {
                alt28=109;
                }
                break;
            case 235:
                {
                alt28=110;
                }
                break;
            case 236:
                {
                alt28=111;
                }
                break;
            case 237:
                {
                alt28=112;
                }
                break;
            case 238:
                {
                alt28=113;
                }
                break;
            case 239:
                {
                alt28=114;
                }
                break;
            case 240:
                {
                alt28=115;
                }
                break;
            case 241:
                {
                alt28=116;
                }
                break;
            case 242:
                {
                alt28=117;
                }
                break;
            case 243:
                {
                alt28=118;
                }
                break;
            case 244:
                {
                alt28=119;
                }
                break;
            case 245:
                {
                alt28=120;
                }
                break;
            case 246:
                {
                alt28=121;
                }
                break;
            case 247:
                {
                alt28=122;
                }
                break;
            case 248:
                {
                alt28=123;
                }
                break;
            case 249:
                {
                alt28=124;
                }
                break;
            case 250:
                {
                alt28=125;
                }
                break;
            case 251:
                {
                alt28=126;
                }
                break;
            case 252:
                {
                alt28=127;
                }
                break;
            case 253:
                {
                alt28=128;
                }
                break;
            case 254:
                {
                alt28=129;
                }
                break;
            case 255:
                {
                alt28=130;
                }
                break;
            case 256:
                {
                alt28=131;
                }
                break;
            case 257:
                {
                alt28=132;
                }
                break;
            case 258:
                {
                alt28=133;
                }
                break;
            case 259:
                {
                alt28=134;
                }
                break;
            case 260:
                {
                alt28=135;
                }
                break;
            case 261:
                {
                alt28=136;
                }
                break;
            case 262:
                {
                alt28=137;
                }
                break;
            case 263:
                {
                alt28=138;
                }
                break;
            case 264:
                {
                alt28=139;
                }
                break;
            case 265:
                {
                alt28=140;
                }
                break;
            case 266:
                {
                alt28=141;
                }
                break;
            case 267:
                {
                alt28=142;
                }
                break;
            case 268:
                {
                alt28=143;
                }
                break;
            case 269:
                {
                alt28=144;
                }
                break;
            case 270:
                {
                alt28=145;
                }
                break;
            case 271:
                {
                alt28=146;
                }
                break;
            case 272:
                {
                alt28=147;
                }
                break;
            case 273:
                {
                alt28=148;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 28, 0, input);

                throw nvae;
            }

            switch (alt28) {
                case 1 :
                    // InternalLatteCSS.g:2904:1: ( 'aliceblue' )
                    {
                    // InternalLatteCSS.g:2904:1: ( 'aliceblue' )
                    // InternalLatteCSS.g:2905:1: 'aliceblue'
                    {
                     before(grammarAccess.getNamedColorAccess().getAliceblueKeyword_0()); 
                    match(input,126,FOLLOW_2); 
                     after(grammarAccess.getNamedColorAccess().getAliceblueKeyword_0()); 

                    }


                    }
                    break;
                case 2 :
                    // InternalLatteCSS.g:2912:6: ( 'antiquewhite' )
                    {
                    // InternalLatteCSS.g:2912:6: ( 'antiquewhite' )
                    // InternalLatteCSS.g:2913:1: 'antiquewhite'
                    {
                     before(grammarAccess.getNamedColorAccess().getAntiquewhiteKeyword_1()); 
                    match(input,127,FOLLOW_2); 
                     after(grammarAccess.getNamedColorAccess().getAntiquewhiteKeyword_1()); 

                    }


                    }
                    break;
                case 3 :
                    // InternalLatteCSS.g:2920:6: ( 'aqua' )
                    {
                    // InternalLatteCSS.g:2920:6: ( 'aqua' )
                    // InternalLatteCSS.g:2921:1: 'aqua'
                    {
                     before(grammarAccess.getNamedColorAccess().getAquaKeyword_2()); 
                    match(input,128,FOLLOW_2); 
                     after(grammarAccess.getNamedColorAccess().getAquaKeyword_2()); 

                    }


                    }
                    break;
                case 4 :
                    // InternalLatteCSS.g:2928:6: ( 'aquamarine' )
                    {
                    // InternalLatteCSS.g:2928:6: ( 'aquamarine' )
                    // InternalLatteCSS.g:2929:1: 'aquamarine'
                    {
                     before(grammarAccess.getNamedColorAccess().getAquamarineKeyword_3()); 
                    match(input,129,FOLLOW_2); 
                     after(grammarAccess.getNamedColorAccess().getAquamarineKeyword_3()); 

                    }


                    }
                    break;
                case 5 :
                    // InternalLatteCSS.g:2936:6: ( 'azure' )
                    {
                    // InternalLatteCSS.g:2936:6: ( 'azure' )
                    // InternalLatteCSS.g:2937:1: 'azure'
                    {
                     before(grammarAccess.getNamedColorAccess().getAzureKeyword_4()); 
                    match(input,130,FOLLOW_2); 
                     after(grammarAccess.getNamedColorAccess().getAzureKeyword_4()); 

                    }


                    }
                    break;
                case 6 :
                    // InternalLatteCSS.g:2944:6: ( 'beige' )
                    {
                    // InternalLatteCSS.g:2944:6: ( 'beige' )
                    // InternalLatteCSS.g:2945:1: 'beige'
                    {
                     before(grammarAccess.getNamedColorAccess().getBeigeKeyword_5()); 
                    match(input,131,FOLLOW_2); 
                     after(grammarAccess.getNamedColorAccess().getBeigeKeyword_5()); 

                    }


                    }
                    break;
                case 7 :
                    // InternalLatteCSS.g:2952:6: ( 'bisque' )
                    {
                    // InternalLatteCSS.g:2952:6: ( 'bisque' )
                    // InternalLatteCSS.g:2953:1: 'bisque'
                    {
                     before(grammarAccess.getNamedColorAccess().getBisqueKeyword_6()); 
                    match(input,132,FOLLOW_2); 
                     after(grammarAccess.getNamedColorAccess().getBisqueKeyword_6()); 

                    }


                    }
                    break;
                case 8 :
                    // InternalLatteCSS.g:2960:6: ( 'black' )
                    {
                    // InternalLatteCSS.g:2960:6: ( 'black' )
                    // InternalLatteCSS.g:2961:1: 'black'
                    {
                     before(grammarAccess.getNamedColorAccess().getBlackKeyword_7()); 
                    match(input,133,FOLLOW_2); 
                     after(grammarAccess.getNamedColorAccess().getBlackKeyword_7()); 

                    }


                    }
                    break;
                case 9 :
                    // InternalLatteCSS.g:2968:6: ( 'blanchedalmond' )
                    {
                    // InternalLatteCSS.g:2968:6: ( 'blanchedalmond' )
                    // InternalLatteCSS.g:2969:1: 'blanchedalmond'
                    {
                     before(grammarAccess.getNamedColorAccess().getBlanchedalmondKeyword_8()); 
                    match(input,134,FOLLOW_2); 
                     after(grammarAccess.getNamedColorAccess().getBlanchedalmondKeyword_8()); 

                    }


                    }
                    break;
                case 10 :
                    // InternalLatteCSS.g:2976:6: ( 'blue' )
                    {
                    // InternalLatteCSS.g:2976:6: ( 'blue' )
                    // InternalLatteCSS.g:2977:1: 'blue'
                    {
                     before(grammarAccess.getNamedColorAccess().getBlueKeyword_9()); 
                    match(input,135,FOLLOW_2); 
                     after(grammarAccess.getNamedColorAccess().getBlueKeyword_9()); 

                    }


                    }
                    break;
                case 11 :
                    // InternalLatteCSS.g:2984:6: ( 'blueviolet' )
                    {
                    // InternalLatteCSS.g:2984:6: ( 'blueviolet' )
                    // InternalLatteCSS.g:2985:1: 'blueviolet'
                    {
                     before(grammarAccess.getNamedColorAccess().getBluevioletKeyword_10()); 
                    match(input,136,FOLLOW_2); 
                     after(grammarAccess.getNamedColorAccess().getBluevioletKeyword_10()); 

                    }


                    }
                    break;
                case 12 :
                    // InternalLatteCSS.g:2992:6: ( 'brown' )
                    {
                    // InternalLatteCSS.g:2992:6: ( 'brown' )
                    // InternalLatteCSS.g:2993:1: 'brown'
                    {
                     before(grammarAccess.getNamedColorAccess().getBrownKeyword_11()); 
                    match(input,137,FOLLOW_2); 
                     after(grammarAccess.getNamedColorAccess().getBrownKeyword_11()); 

                    }


                    }
                    break;
                case 13 :
                    // InternalLatteCSS.g:3000:6: ( 'burlywood' )
                    {
                    // InternalLatteCSS.g:3000:6: ( 'burlywood' )
                    // InternalLatteCSS.g:3001:1: 'burlywood'
                    {
                     before(grammarAccess.getNamedColorAccess().getBurlywoodKeyword_12()); 
                    match(input,138,FOLLOW_2); 
                     after(grammarAccess.getNamedColorAccess().getBurlywoodKeyword_12()); 

                    }


                    }
                    break;
                case 14 :
                    // InternalLatteCSS.g:3008:6: ( 'cadetblue' )
                    {
                    // InternalLatteCSS.g:3008:6: ( 'cadetblue' )
                    // InternalLatteCSS.g:3009:1: 'cadetblue'
                    {
                     before(grammarAccess.getNamedColorAccess().getCadetblueKeyword_13()); 
                    match(input,139,FOLLOW_2); 
                     after(grammarAccess.getNamedColorAccess().getCadetblueKeyword_13()); 

                    }


                    }
                    break;
                case 15 :
                    // InternalLatteCSS.g:3016:6: ( 'chartreuse' )
                    {
                    // InternalLatteCSS.g:3016:6: ( 'chartreuse' )
                    // InternalLatteCSS.g:3017:1: 'chartreuse'
                    {
                     before(grammarAccess.getNamedColorAccess().getChartreuseKeyword_14()); 
                    match(input,140,FOLLOW_2); 
                     after(grammarAccess.getNamedColorAccess().getChartreuseKeyword_14()); 

                    }


                    }
                    break;
                case 16 :
                    // InternalLatteCSS.g:3024:6: ( 'chocolate' )
                    {
                    // InternalLatteCSS.g:3024:6: ( 'chocolate' )
                    // InternalLatteCSS.g:3025:1: 'chocolate'
                    {
                     before(grammarAccess.getNamedColorAccess().getChocolateKeyword_15()); 
                    match(input,141,FOLLOW_2); 
                     after(grammarAccess.getNamedColorAccess().getChocolateKeyword_15()); 

                    }


                    }
                    break;
                case 17 :
                    // InternalLatteCSS.g:3032:6: ( 'coral' )
                    {
                    // InternalLatteCSS.g:3032:6: ( 'coral' )
                    // InternalLatteCSS.g:3033:1: 'coral'
                    {
                     before(grammarAccess.getNamedColorAccess().getCoralKeyword_16()); 
                    match(input,142,FOLLOW_2); 
                     after(grammarAccess.getNamedColorAccess().getCoralKeyword_16()); 

                    }


                    }
                    break;
                case 18 :
                    // InternalLatteCSS.g:3040:6: ( 'cornflowerblue' )
                    {
                    // InternalLatteCSS.g:3040:6: ( 'cornflowerblue' )
                    // InternalLatteCSS.g:3041:1: 'cornflowerblue'
                    {
                     before(grammarAccess.getNamedColorAccess().getCornflowerblueKeyword_17()); 
                    match(input,143,FOLLOW_2); 
                     after(grammarAccess.getNamedColorAccess().getCornflowerblueKeyword_17()); 

                    }


                    }
                    break;
                case 19 :
                    // InternalLatteCSS.g:3048:6: ( 'cornsilk' )
                    {
                    // InternalLatteCSS.g:3048:6: ( 'cornsilk' )
                    // InternalLatteCSS.g:3049:1: 'cornsilk'
                    {
                     before(grammarAccess.getNamedColorAccess().getCornsilkKeyword_18()); 
                    match(input,144,FOLLOW_2); 
                     after(grammarAccess.getNamedColorAccess().getCornsilkKeyword_18()); 

                    }


                    }
                    break;
                case 20 :
                    // InternalLatteCSS.g:3056:6: ( 'crimson' )
                    {
                    // InternalLatteCSS.g:3056:6: ( 'crimson' )
                    // InternalLatteCSS.g:3057:1: 'crimson'
                    {
                     before(grammarAccess.getNamedColorAccess().getCrimsonKeyword_19()); 
                    match(input,145,FOLLOW_2); 
                     after(grammarAccess.getNamedColorAccess().getCrimsonKeyword_19()); 

                    }


                    }
                    break;
                case 21 :
                    // InternalLatteCSS.g:3064:6: ( 'cyan' )
                    {
                    // InternalLatteCSS.g:3064:6: ( 'cyan' )
                    // InternalLatteCSS.g:3065:1: 'cyan'
                    {
                     before(grammarAccess.getNamedColorAccess().getCyanKeyword_20()); 
                    match(input,146,FOLLOW_2); 
                     after(grammarAccess.getNamedColorAccess().getCyanKeyword_20()); 

                    }


                    }
                    break;
                case 22 :
                    // InternalLatteCSS.g:3072:6: ( 'darkblue' )
                    {
                    // InternalLatteCSS.g:3072:6: ( 'darkblue' )
                    // InternalLatteCSS.g:3073:1: 'darkblue'
                    {
                     before(grammarAccess.getNamedColorAccess().getDarkblueKeyword_21()); 
                    match(input,147,FOLLOW_2); 
                     after(grammarAccess.getNamedColorAccess().getDarkblueKeyword_21()); 

                    }


                    }
                    break;
                case 23 :
                    // InternalLatteCSS.g:3080:6: ( 'darkcyan' )
                    {
                    // InternalLatteCSS.g:3080:6: ( 'darkcyan' )
                    // InternalLatteCSS.g:3081:1: 'darkcyan'
                    {
                     before(grammarAccess.getNamedColorAccess().getDarkcyanKeyword_22()); 
                    match(input,148,FOLLOW_2); 
                     after(grammarAccess.getNamedColorAccess().getDarkcyanKeyword_22()); 

                    }


                    }
                    break;
                case 24 :
                    // InternalLatteCSS.g:3088:6: ( 'darkgoldenrod' )
                    {
                    // InternalLatteCSS.g:3088:6: ( 'darkgoldenrod' )
                    // InternalLatteCSS.g:3089:1: 'darkgoldenrod'
                    {
                     before(grammarAccess.getNamedColorAccess().getDarkgoldenrodKeyword_23()); 
                    match(input,149,FOLLOW_2); 
                     after(grammarAccess.getNamedColorAccess().getDarkgoldenrodKeyword_23()); 

                    }


                    }
                    break;
                case 25 :
                    // InternalLatteCSS.g:3096:6: ( 'darkgray' )
                    {
                    // InternalLatteCSS.g:3096:6: ( 'darkgray' )
                    // InternalLatteCSS.g:3097:1: 'darkgray'
                    {
                     before(grammarAccess.getNamedColorAccess().getDarkgrayKeyword_24()); 
                    match(input,150,FOLLOW_2); 
                     after(grammarAccess.getNamedColorAccess().getDarkgrayKeyword_24()); 

                    }


                    }
                    break;
                case 26 :
                    // InternalLatteCSS.g:3104:6: ( 'darkgreen' )
                    {
                    // InternalLatteCSS.g:3104:6: ( 'darkgreen' )
                    // InternalLatteCSS.g:3105:1: 'darkgreen'
                    {
                     before(grammarAccess.getNamedColorAccess().getDarkgreenKeyword_25()); 
                    match(input,151,FOLLOW_2); 
                     after(grammarAccess.getNamedColorAccess().getDarkgreenKeyword_25()); 

                    }


                    }
                    break;
                case 27 :
                    // InternalLatteCSS.g:3112:6: ( 'darkgrey' )
                    {
                    // InternalLatteCSS.g:3112:6: ( 'darkgrey' )
                    // InternalLatteCSS.g:3113:1: 'darkgrey'
                    {
                     before(grammarAccess.getNamedColorAccess().getDarkgreyKeyword_26()); 
                    match(input,152,FOLLOW_2); 
                     after(grammarAccess.getNamedColorAccess().getDarkgreyKeyword_26()); 

                    }


                    }
                    break;
                case 28 :
                    // InternalLatteCSS.g:3120:6: ( 'darkkhaki' )
                    {
                    // InternalLatteCSS.g:3120:6: ( 'darkkhaki' )
                    // InternalLatteCSS.g:3121:1: 'darkkhaki'
                    {
                     before(grammarAccess.getNamedColorAccess().getDarkkhakiKeyword_27()); 
                    match(input,153,FOLLOW_2); 
                     after(grammarAccess.getNamedColorAccess().getDarkkhakiKeyword_27()); 

                    }


                    }
                    break;
                case 29 :
                    // InternalLatteCSS.g:3128:6: ( 'darkmagenta' )
                    {
                    // InternalLatteCSS.g:3128:6: ( 'darkmagenta' )
                    // InternalLatteCSS.g:3129:1: 'darkmagenta'
                    {
                     before(grammarAccess.getNamedColorAccess().getDarkmagentaKeyword_28()); 
                    match(input,154,FOLLOW_2); 
                     after(grammarAccess.getNamedColorAccess().getDarkmagentaKeyword_28()); 

                    }


                    }
                    break;
                case 30 :
                    // InternalLatteCSS.g:3136:6: ( 'darkolivegreen' )
                    {
                    // InternalLatteCSS.g:3136:6: ( 'darkolivegreen' )
                    // InternalLatteCSS.g:3137:1: 'darkolivegreen'
                    {
                     before(grammarAccess.getNamedColorAccess().getDarkolivegreenKeyword_29()); 
                    match(input,155,FOLLOW_2); 
                     after(grammarAccess.getNamedColorAccess().getDarkolivegreenKeyword_29()); 

                    }


                    }
                    break;
                case 31 :
                    // InternalLatteCSS.g:3144:6: ( 'darkorange' )
                    {
                    // InternalLatteCSS.g:3144:6: ( 'darkorange' )
                    // InternalLatteCSS.g:3145:1: 'darkorange'
                    {
                     before(grammarAccess.getNamedColorAccess().getDarkorangeKeyword_30()); 
                    match(input,156,FOLLOW_2); 
                     after(grammarAccess.getNamedColorAccess().getDarkorangeKeyword_30()); 

                    }


                    }
                    break;
                case 32 :
                    // InternalLatteCSS.g:3152:6: ( 'darkorchid' )
                    {
                    // InternalLatteCSS.g:3152:6: ( 'darkorchid' )
                    // InternalLatteCSS.g:3153:1: 'darkorchid'
                    {
                     before(grammarAccess.getNamedColorAccess().getDarkorchidKeyword_31()); 
                    match(input,157,FOLLOW_2); 
                     after(grammarAccess.getNamedColorAccess().getDarkorchidKeyword_31()); 

                    }


                    }
                    break;
                case 33 :
                    // InternalLatteCSS.g:3160:6: ( 'darkred' )
                    {
                    // InternalLatteCSS.g:3160:6: ( 'darkred' )
                    // InternalLatteCSS.g:3161:1: 'darkred'
                    {
                     before(grammarAccess.getNamedColorAccess().getDarkredKeyword_32()); 
                    match(input,158,FOLLOW_2); 
                     after(grammarAccess.getNamedColorAccess().getDarkredKeyword_32()); 

                    }


                    }
                    break;
                case 34 :
                    // InternalLatteCSS.g:3168:6: ( 'darksalmon' )
                    {
                    // InternalLatteCSS.g:3168:6: ( 'darksalmon' )
                    // InternalLatteCSS.g:3169:1: 'darksalmon'
                    {
                     before(grammarAccess.getNamedColorAccess().getDarksalmonKeyword_33()); 
                    match(input,159,FOLLOW_2); 
                     after(grammarAccess.getNamedColorAccess().getDarksalmonKeyword_33()); 

                    }


                    }
                    break;
                case 35 :
                    // InternalLatteCSS.g:3176:6: ( 'darkseagreen' )
                    {
                    // InternalLatteCSS.g:3176:6: ( 'darkseagreen' )
                    // InternalLatteCSS.g:3177:1: 'darkseagreen'
                    {
                     before(grammarAccess.getNamedColorAccess().getDarkseagreenKeyword_34()); 
                    match(input,160,FOLLOW_2); 
                     after(grammarAccess.getNamedColorAccess().getDarkseagreenKeyword_34()); 

                    }


                    }
                    break;
                case 36 :
                    // InternalLatteCSS.g:3184:6: ( 'darkslateblue' )
                    {
                    // InternalLatteCSS.g:3184:6: ( 'darkslateblue' )
                    // InternalLatteCSS.g:3185:1: 'darkslateblue'
                    {
                     before(grammarAccess.getNamedColorAccess().getDarkslateblueKeyword_35()); 
                    match(input,161,FOLLOW_2); 
                     after(grammarAccess.getNamedColorAccess().getDarkslateblueKeyword_35()); 

                    }


                    }
                    break;
                case 37 :
                    // InternalLatteCSS.g:3192:6: ( 'darkslategray' )
                    {
                    // InternalLatteCSS.g:3192:6: ( 'darkslategray' )
                    // InternalLatteCSS.g:3193:1: 'darkslategray'
                    {
                     before(grammarAccess.getNamedColorAccess().getDarkslategrayKeyword_36()); 
                    match(input,162,FOLLOW_2); 
                     after(grammarAccess.getNamedColorAccess().getDarkslategrayKeyword_36()); 

                    }


                    }
                    break;
                case 38 :
                    // InternalLatteCSS.g:3200:6: ( 'darkslategrey' )
                    {
                    // InternalLatteCSS.g:3200:6: ( 'darkslategrey' )
                    // InternalLatteCSS.g:3201:1: 'darkslategrey'
                    {
                     before(grammarAccess.getNamedColorAccess().getDarkslategreyKeyword_37()); 
                    match(input,163,FOLLOW_2); 
                     after(grammarAccess.getNamedColorAccess().getDarkslategreyKeyword_37()); 

                    }


                    }
                    break;
                case 39 :
                    // InternalLatteCSS.g:3208:6: ( 'darkturquoise' )
                    {
                    // InternalLatteCSS.g:3208:6: ( 'darkturquoise' )
                    // InternalLatteCSS.g:3209:1: 'darkturquoise'
                    {
                     before(grammarAccess.getNamedColorAccess().getDarkturquoiseKeyword_38()); 
                    match(input,164,FOLLOW_2); 
                     after(grammarAccess.getNamedColorAccess().getDarkturquoiseKeyword_38()); 

                    }


                    }
                    break;
                case 40 :
                    // InternalLatteCSS.g:3216:6: ( 'darkviolet' )
                    {
                    // InternalLatteCSS.g:3216:6: ( 'darkviolet' )
                    // InternalLatteCSS.g:3217:1: 'darkviolet'
                    {
                     before(grammarAccess.getNamedColorAccess().getDarkvioletKeyword_39()); 
                    match(input,165,FOLLOW_2); 
                     after(grammarAccess.getNamedColorAccess().getDarkvioletKeyword_39()); 

                    }


                    }
                    break;
                case 41 :
                    // InternalLatteCSS.g:3224:6: ( 'deeppink' )
                    {
                    // InternalLatteCSS.g:3224:6: ( 'deeppink' )
                    // InternalLatteCSS.g:3225:1: 'deeppink'
                    {
                     before(grammarAccess.getNamedColorAccess().getDeeppinkKeyword_40()); 
                    match(input,166,FOLLOW_2); 
                     after(grammarAccess.getNamedColorAccess().getDeeppinkKeyword_40()); 

                    }


                    }
                    break;
                case 42 :
                    // InternalLatteCSS.g:3232:6: ( 'deepskyblue' )
                    {
                    // InternalLatteCSS.g:3232:6: ( 'deepskyblue' )
                    // InternalLatteCSS.g:3233:1: 'deepskyblue'
                    {
                     before(grammarAccess.getNamedColorAccess().getDeepskyblueKeyword_41()); 
                    match(input,167,FOLLOW_2); 
                     after(grammarAccess.getNamedColorAccess().getDeepskyblueKeyword_41()); 

                    }


                    }
                    break;
                case 43 :
                    // InternalLatteCSS.g:3240:6: ( 'dimgray' )
                    {
                    // InternalLatteCSS.g:3240:6: ( 'dimgray' )
                    // InternalLatteCSS.g:3241:1: 'dimgray'
                    {
                     before(grammarAccess.getNamedColorAccess().getDimgrayKeyword_42()); 
                    match(input,168,FOLLOW_2); 
                     after(grammarAccess.getNamedColorAccess().getDimgrayKeyword_42()); 

                    }


                    }
                    break;
                case 44 :
                    // InternalLatteCSS.g:3248:6: ( 'dimgrey' )
                    {
                    // InternalLatteCSS.g:3248:6: ( 'dimgrey' )
                    // InternalLatteCSS.g:3249:1: 'dimgrey'
                    {
                     before(grammarAccess.getNamedColorAccess().getDimgreyKeyword_43()); 
                    match(input,169,FOLLOW_2); 
                     after(grammarAccess.getNamedColorAccess().getDimgreyKeyword_43()); 

                    }


                    }
                    break;
                case 45 :
                    // InternalLatteCSS.g:3256:6: ( 'dodgerblue' )
                    {
                    // InternalLatteCSS.g:3256:6: ( 'dodgerblue' )
                    // InternalLatteCSS.g:3257:1: 'dodgerblue'
                    {
                     before(grammarAccess.getNamedColorAccess().getDodgerblueKeyword_44()); 
                    match(input,170,FOLLOW_2); 
                     after(grammarAccess.getNamedColorAccess().getDodgerblueKeyword_44()); 

                    }


                    }
                    break;
                case 46 :
                    // InternalLatteCSS.g:3264:6: ( 'firebrick' )
                    {
                    // InternalLatteCSS.g:3264:6: ( 'firebrick' )
                    // InternalLatteCSS.g:3265:1: 'firebrick'
                    {
                     before(grammarAccess.getNamedColorAccess().getFirebrickKeyword_45()); 
                    match(input,171,FOLLOW_2); 
                     after(grammarAccess.getNamedColorAccess().getFirebrickKeyword_45()); 

                    }


                    }
                    break;
                case 47 :
                    // InternalLatteCSS.g:3272:6: ( 'floralwhite' )
                    {
                    // InternalLatteCSS.g:3272:6: ( 'floralwhite' )
                    // InternalLatteCSS.g:3273:1: 'floralwhite'
                    {
                     before(grammarAccess.getNamedColorAccess().getFloralwhiteKeyword_46()); 
                    match(input,172,FOLLOW_2); 
                     after(grammarAccess.getNamedColorAccess().getFloralwhiteKeyword_46()); 

                    }


                    }
                    break;
                case 48 :
                    // InternalLatteCSS.g:3280:6: ( 'forestgreen' )
                    {
                    // InternalLatteCSS.g:3280:6: ( 'forestgreen' )
                    // InternalLatteCSS.g:3281:1: 'forestgreen'
                    {
                     before(grammarAccess.getNamedColorAccess().getForestgreenKeyword_47()); 
                    match(input,173,FOLLOW_2); 
                     after(grammarAccess.getNamedColorAccess().getForestgreenKeyword_47()); 

                    }


                    }
                    break;
                case 49 :
                    // InternalLatteCSS.g:3288:6: ( 'fuchsia' )
                    {
                    // InternalLatteCSS.g:3288:6: ( 'fuchsia' )
                    // InternalLatteCSS.g:3289:1: 'fuchsia'
                    {
                     before(grammarAccess.getNamedColorAccess().getFuchsiaKeyword_48()); 
                    match(input,174,FOLLOW_2); 
                     after(grammarAccess.getNamedColorAccess().getFuchsiaKeyword_48()); 

                    }


                    }
                    break;
                case 50 :
                    // InternalLatteCSS.g:3296:6: ( 'gainsboro' )
                    {
                    // InternalLatteCSS.g:3296:6: ( 'gainsboro' )
                    // InternalLatteCSS.g:3297:1: 'gainsboro'
                    {
                     before(grammarAccess.getNamedColorAccess().getGainsboroKeyword_49()); 
                    match(input,175,FOLLOW_2); 
                     after(grammarAccess.getNamedColorAccess().getGainsboroKeyword_49()); 

                    }


                    }
                    break;
                case 51 :
                    // InternalLatteCSS.g:3304:6: ( 'ghostwhite' )
                    {
                    // InternalLatteCSS.g:3304:6: ( 'ghostwhite' )
                    // InternalLatteCSS.g:3305:1: 'ghostwhite'
                    {
                     before(grammarAccess.getNamedColorAccess().getGhostwhiteKeyword_50()); 
                    match(input,176,FOLLOW_2); 
                     after(grammarAccess.getNamedColorAccess().getGhostwhiteKeyword_50()); 

                    }


                    }
                    break;
                case 52 :
                    // InternalLatteCSS.g:3312:6: ( 'gold' )
                    {
                    // InternalLatteCSS.g:3312:6: ( 'gold' )
                    // InternalLatteCSS.g:3313:1: 'gold'
                    {
                     before(grammarAccess.getNamedColorAccess().getGoldKeyword_51()); 
                    match(input,177,FOLLOW_2); 
                     after(grammarAccess.getNamedColorAccess().getGoldKeyword_51()); 

                    }


                    }
                    break;
                case 53 :
                    // InternalLatteCSS.g:3320:6: ( 'goldenrod' )
                    {
                    // InternalLatteCSS.g:3320:6: ( 'goldenrod' )
                    // InternalLatteCSS.g:3321:1: 'goldenrod'
                    {
                     before(grammarAccess.getNamedColorAccess().getGoldenrodKeyword_52()); 
                    match(input,178,FOLLOW_2); 
                     after(grammarAccess.getNamedColorAccess().getGoldenrodKeyword_52()); 

                    }


                    }
                    break;
                case 54 :
                    // InternalLatteCSS.g:3328:6: ( 'gray' )
                    {
                    // InternalLatteCSS.g:3328:6: ( 'gray' )
                    // InternalLatteCSS.g:3329:1: 'gray'
                    {
                     before(grammarAccess.getNamedColorAccess().getGrayKeyword_53()); 
                    match(input,179,FOLLOW_2); 
                     after(grammarAccess.getNamedColorAccess().getGrayKeyword_53()); 

                    }


                    }
                    break;
                case 55 :
                    // InternalLatteCSS.g:3336:6: ( 'green' )
                    {
                    // InternalLatteCSS.g:3336:6: ( 'green' )
                    // InternalLatteCSS.g:3337:1: 'green'
                    {
                     before(grammarAccess.getNamedColorAccess().getGreenKeyword_54()); 
                    match(input,180,FOLLOW_2); 
                     after(grammarAccess.getNamedColorAccess().getGreenKeyword_54()); 

                    }


                    }
                    break;
                case 56 :
                    // InternalLatteCSS.g:3344:6: ( 'greenyellow' )
                    {
                    // InternalLatteCSS.g:3344:6: ( 'greenyellow' )
                    // InternalLatteCSS.g:3345:1: 'greenyellow'
                    {
                     before(grammarAccess.getNamedColorAccess().getGreenyellowKeyword_55()); 
                    match(input,181,FOLLOW_2); 
                     after(grammarAccess.getNamedColorAccess().getGreenyellowKeyword_55()); 

                    }


                    }
                    break;
                case 57 :
                    // InternalLatteCSS.g:3352:6: ( 'grey' )
                    {
                    // InternalLatteCSS.g:3352:6: ( 'grey' )
                    // InternalLatteCSS.g:3353:1: 'grey'
                    {
                     before(grammarAccess.getNamedColorAccess().getGreyKeyword_56()); 
                    match(input,182,FOLLOW_2); 
                     after(grammarAccess.getNamedColorAccess().getGreyKeyword_56()); 

                    }


                    }
                    break;
                case 58 :
                    // InternalLatteCSS.g:3360:6: ( 'honeydew' )
                    {
                    // InternalLatteCSS.g:3360:6: ( 'honeydew' )
                    // InternalLatteCSS.g:3361:1: 'honeydew'
                    {
                     before(grammarAccess.getNamedColorAccess().getHoneydewKeyword_57()); 
                    match(input,183,FOLLOW_2); 
                     after(grammarAccess.getNamedColorAccess().getHoneydewKeyword_57()); 

                    }


                    }
                    break;
                case 59 :
                    // InternalLatteCSS.g:3368:6: ( 'hotpink' )
                    {
                    // InternalLatteCSS.g:3368:6: ( 'hotpink' )
                    // InternalLatteCSS.g:3369:1: 'hotpink'
                    {
                     before(grammarAccess.getNamedColorAccess().getHotpinkKeyword_58()); 
                    match(input,184,FOLLOW_2); 
                     after(grammarAccess.getNamedColorAccess().getHotpinkKeyword_58()); 

                    }


                    }
                    break;
                case 60 :
                    // InternalLatteCSS.g:3376:6: ( 'indianred' )
                    {
                    // InternalLatteCSS.g:3376:6: ( 'indianred' )
                    // InternalLatteCSS.g:3377:1: 'indianred'
                    {
                     before(grammarAccess.getNamedColorAccess().getIndianredKeyword_59()); 
                    match(input,185,FOLLOW_2); 
                     after(grammarAccess.getNamedColorAccess().getIndianredKeyword_59()); 

                    }


                    }
                    break;
                case 61 :
                    // InternalLatteCSS.g:3384:6: ( 'indigo' )
                    {
                    // InternalLatteCSS.g:3384:6: ( 'indigo' )
                    // InternalLatteCSS.g:3385:1: 'indigo'
                    {
                     before(grammarAccess.getNamedColorAccess().getIndigoKeyword_60()); 
                    match(input,186,FOLLOW_2); 
                     after(grammarAccess.getNamedColorAccess().getIndigoKeyword_60()); 

                    }


                    }
                    break;
                case 62 :
                    // InternalLatteCSS.g:3392:6: ( 'ivory' )
                    {
                    // InternalLatteCSS.g:3392:6: ( 'ivory' )
                    // InternalLatteCSS.g:3393:1: 'ivory'
                    {
                     before(grammarAccess.getNamedColorAccess().getIvoryKeyword_61()); 
                    match(input,187,FOLLOW_2); 
                     after(grammarAccess.getNamedColorAccess().getIvoryKeyword_61()); 

                    }


                    }
                    break;
                case 63 :
                    // InternalLatteCSS.g:3400:6: ( 'khaki' )
                    {
                    // InternalLatteCSS.g:3400:6: ( 'khaki' )
                    // InternalLatteCSS.g:3401:1: 'khaki'
                    {
                     before(grammarAccess.getNamedColorAccess().getKhakiKeyword_62()); 
                    match(input,188,FOLLOW_2); 
                     after(grammarAccess.getNamedColorAccess().getKhakiKeyword_62()); 

                    }


                    }
                    break;
                case 64 :
                    // InternalLatteCSS.g:3408:6: ( 'lavender' )
                    {
                    // InternalLatteCSS.g:3408:6: ( 'lavender' )
                    // InternalLatteCSS.g:3409:1: 'lavender'
                    {
                     before(grammarAccess.getNamedColorAccess().getLavenderKeyword_63()); 
                    match(input,189,FOLLOW_2); 
                     after(grammarAccess.getNamedColorAccess().getLavenderKeyword_63()); 

                    }


                    }
                    break;
                case 65 :
                    // InternalLatteCSS.g:3416:6: ( 'lavenderblush' )
                    {
                    // InternalLatteCSS.g:3416:6: ( 'lavenderblush' )
                    // InternalLatteCSS.g:3417:1: 'lavenderblush'
                    {
                     before(grammarAccess.getNamedColorAccess().getLavenderblushKeyword_64()); 
                    match(input,190,FOLLOW_2); 
                     after(grammarAccess.getNamedColorAccess().getLavenderblushKeyword_64()); 

                    }


                    }
                    break;
                case 66 :
                    // InternalLatteCSS.g:3424:6: ( 'lawngreen' )
                    {
                    // InternalLatteCSS.g:3424:6: ( 'lawngreen' )
                    // InternalLatteCSS.g:3425:1: 'lawngreen'
                    {
                     before(grammarAccess.getNamedColorAccess().getLawngreenKeyword_65()); 
                    match(input,191,FOLLOW_2); 
                     after(grammarAccess.getNamedColorAccess().getLawngreenKeyword_65()); 

                    }


                    }
                    break;
                case 67 :
                    // InternalLatteCSS.g:3432:6: ( 'lemonchiffon' )
                    {
                    // InternalLatteCSS.g:3432:6: ( 'lemonchiffon' )
                    // InternalLatteCSS.g:3433:1: 'lemonchiffon'
                    {
                     before(grammarAccess.getNamedColorAccess().getLemonchiffonKeyword_66()); 
                    match(input,192,FOLLOW_2); 
                     after(grammarAccess.getNamedColorAccess().getLemonchiffonKeyword_66()); 

                    }


                    }
                    break;
                case 68 :
                    // InternalLatteCSS.g:3440:6: ( 'lightblue' )
                    {
                    // InternalLatteCSS.g:3440:6: ( 'lightblue' )
                    // InternalLatteCSS.g:3441:1: 'lightblue'
                    {
                     before(grammarAccess.getNamedColorAccess().getLightblueKeyword_67()); 
                    match(input,193,FOLLOW_2); 
                     after(grammarAccess.getNamedColorAccess().getLightblueKeyword_67()); 

                    }


                    }
                    break;
                case 69 :
                    // InternalLatteCSS.g:3448:6: ( 'lightcoral' )
                    {
                    // InternalLatteCSS.g:3448:6: ( 'lightcoral' )
                    // InternalLatteCSS.g:3449:1: 'lightcoral'
                    {
                     before(grammarAccess.getNamedColorAccess().getLightcoralKeyword_68()); 
                    match(input,194,FOLLOW_2); 
                     after(grammarAccess.getNamedColorAccess().getLightcoralKeyword_68()); 

                    }


                    }
                    break;
                case 70 :
                    // InternalLatteCSS.g:3456:6: ( 'lightcyan' )
                    {
                    // InternalLatteCSS.g:3456:6: ( 'lightcyan' )
                    // InternalLatteCSS.g:3457:1: 'lightcyan'
                    {
                     before(grammarAccess.getNamedColorAccess().getLightcyanKeyword_69()); 
                    match(input,195,FOLLOW_2); 
                     after(grammarAccess.getNamedColorAccess().getLightcyanKeyword_69()); 

                    }


                    }
                    break;
                case 71 :
                    // InternalLatteCSS.g:3464:6: ( 'lightgoldenrodyellow' )
                    {
                    // InternalLatteCSS.g:3464:6: ( 'lightgoldenrodyellow' )
                    // InternalLatteCSS.g:3465:1: 'lightgoldenrodyellow'
                    {
                     before(grammarAccess.getNamedColorAccess().getLightgoldenrodyellowKeyword_70()); 
                    match(input,196,FOLLOW_2); 
                     after(grammarAccess.getNamedColorAccess().getLightgoldenrodyellowKeyword_70()); 

                    }


                    }
                    break;
                case 72 :
                    // InternalLatteCSS.g:3472:6: ( 'lightgray' )
                    {
                    // InternalLatteCSS.g:3472:6: ( 'lightgray' )
                    // InternalLatteCSS.g:3473:1: 'lightgray'
                    {
                     before(grammarAccess.getNamedColorAccess().getLightgrayKeyword_71()); 
                    match(input,197,FOLLOW_2); 
                     after(grammarAccess.getNamedColorAccess().getLightgrayKeyword_71()); 

                    }


                    }
                    break;
                case 73 :
                    // InternalLatteCSS.g:3480:6: ( 'lightgreen' )
                    {
                    // InternalLatteCSS.g:3480:6: ( 'lightgreen' )
                    // InternalLatteCSS.g:3481:1: 'lightgreen'
                    {
                     before(grammarAccess.getNamedColorAccess().getLightgreenKeyword_72()); 
                    match(input,198,FOLLOW_2); 
                     after(grammarAccess.getNamedColorAccess().getLightgreenKeyword_72()); 

                    }


                    }
                    break;
                case 74 :
                    // InternalLatteCSS.g:3488:6: ( 'lightgrey' )
                    {
                    // InternalLatteCSS.g:3488:6: ( 'lightgrey' )
                    // InternalLatteCSS.g:3489:1: 'lightgrey'
                    {
                     before(grammarAccess.getNamedColorAccess().getLightgreyKeyword_73()); 
                    match(input,199,FOLLOW_2); 
                     after(grammarAccess.getNamedColorAccess().getLightgreyKeyword_73()); 

                    }


                    }
                    break;
                case 75 :
                    // InternalLatteCSS.g:3496:6: ( 'lightpink' )
                    {
                    // InternalLatteCSS.g:3496:6: ( 'lightpink' )
                    // InternalLatteCSS.g:3497:1: 'lightpink'
                    {
                     before(grammarAccess.getNamedColorAccess().getLightpinkKeyword_74()); 
                    match(input,200,FOLLOW_2); 
                     after(grammarAccess.getNamedColorAccess().getLightpinkKeyword_74()); 

                    }


                    }
                    break;
                case 76 :
                    // InternalLatteCSS.g:3504:6: ( 'lightsalmon' )
                    {
                    // InternalLatteCSS.g:3504:6: ( 'lightsalmon' )
                    // InternalLatteCSS.g:3505:1: 'lightsalmon'
                    {
                     before(grammarAccess.getNamedColorAccess().getLightsalmonKeyword_75()); 
                    match(input,201,FOLLOW_2); 
                     after(grammarAccess.getNamedColorAccess().getLightsalmonKeyword_75()); 

                    }


                    }
                    break;
                case 77 :
                    // InternalLatteCSS.g:3512:6: ( 'lightseagreen' )
                    {
                    // InternalLatteCSS.g:3512:6: ( 'lightseagreen' )
                    // InternalLatteCSS.g:3513:1: 'lightseagreen'
                    {
                     before(grammarAccess.getNamedColorAccess().getLightseagreenKeyword_76()); 
                    match(input,202,FOLLOW_2); 
                     after(grammarAccess.getNamedColorAccess().getLightseagreenKeyword_76()); 

                    }


                    }
                    break;
                case 78 :
                    // InternalLatteCSS.g:3520:6: ( 'lightskyblue' )
                    {
                    // InternalLatteCSS.g:3520:6: ( 'lightskyblue' )
                    // InternalLatteCSS.g:3521:1: 'lightskyblue'
                    {
                     before(grammarAccess.getNamedColorAccess().getLightskyblueKeyword_77()); 
                    match(input,203,FOLLOW_2); 
                     after(grammarAccess.getNamedColorAccess().getLightskyblueKeyword_77()); 

                    }


                    }
                    break;
                case 79 :
                    // InternalLatteCSS.g:3528:6: ( 'lightslategray' )
                    {
                    // InternalLatteCSS.g:3528:6: ( 'lightslategray' )
                    // InternalLatteCSS.g:3529:1: 'lightslategray'
                    {
                     before(grammarAccess.getNamedColorAccess().getLightslategrayKeyword_78()); 
                    match(input,204,FOLLOW_2); 
                     after(grammarAccess.getNamedColorAccess().getLightslategrayKeyword_78()); 

                    }


                    }
                    break;
                case 80 :
                    // InternalLatteCSS.g:3536:6: ( 'lightslategrey' )
                    {
                    // InternalLatteCSS.g:3536:6: ( 'lightslategrey' )
                    // InternalLatteCSS.g:3537:1: 'lightslategrey'
                    {
                     before(grammarAccess.getNamedColorAccess().getLightslategreyKeyword_79()); 
                    match(input,205,FOLLOW_2); 
                     after(grammarAccess.getNamedColorAccess().getLightslategreyKeyword_79()); 

                    }


                    }
                    break;
                case 81 :
                    // InternalLatteCSS.g:3544:6: ( 'lightsteelblue' )
                    {
                    // InternalLatteCSS.g:3544:6: ( 'lightsteelblue' )
                    // InternalLatteCSS.g:3545:1: 'lightsteelblue'
                    {
                     before(grammarAccess.getNamedColorAccess().getLightsteelblueKeyword_80()); 
                    match(input,206,FOLLOW_2); 
                     after(grammarAccess.getNamedColorAccess().getLightsteelblueKeyword_80()); 

                    }


                    }
                    break;
                case 82 :
                    // InternalLatteCSS.g:3552:6: ( 'lightyellow' )
                    {
                    // InternalLatteCSS.g:3552:6: ( 'lightyellow' )
                    // InternalLatteCSS.g:3553:1: 'lightyellow'
                    {
                     before(grammarAccess.getNamedColorAccess().getLightyellowKeyword_81()); 
                    match(input,207,FOLLOW_2); 
                     after(grammarAccess.getNamedColorAccess().getLightyellowKeyword_81()); 

                    }


                    }
                    break;
                case 83 :
                    // InternalLatteCSS.g:3560:6: ( 'lime' )
                    {
                    // InternalLatteCSS.g:3560:6: ( 'lime' )
                    // InternalLatteCSS.g:3561:1: 'lime'
                    {
                     before(grammarAccess.getNamedColorAccess().getLimeKeyword_82()); 
                    match(input,208,FOLLOW_2); 
                     after(grammarAccess.getNamedColorAccess().getLimeKeyword_82()); 

                    }


                    }
                    break;
                case 84 :
                    // InternalLatteCSS.g:3568:6: ( 'limegreen' )
                    {
                    // InternalLatteCSS.g:3568:6: ( 'limegreen' )
                    // InternalLatteCSS.g:3569:1: 'limegreen'
                    {
                     before(grammarAccess.getNamedColorAccess().getLimegreenKeyword_83()); 
                    match(input,209,FOLLOW_2); 
                     after(grammarAccess.getNamedColorAccess().getLimegreenKeyword_83()); 

                    }


                    }
                    break;
                case 85 :
                    // InternalLatteCSS.g:3576:6: ( 'linen' )
                    {
                    // InternalLatteCSS.g:3576:6: ( 'linen' )
                    // InternalLatteCSS.g:3577:1: 'linen'
                    {
                     before(grammarAccess.getNamedColorAccess().getLinenKeyword_84()); 
                    match(input,210,FOLLOW_2); 
                     after(grammarAccess.getNamedColorAccess().getLinenKeyword_84()); 

                    }


                    }
                    break;
                case 86 :
                    // InternalLatteCSS.g:3584:6: ( 'magenta' )
                    {
                    // InternalLatteCSS.g:3584:6: ( 'magenta' )
                    // InternalLatteCSS.g:3585:1: 'magenta'
                    {
                     before(grammarAccess.getNamedColorAccess().getMagentaKeyword_85()); 
                    match(input,211,FOLLOW_2); 
                     after(grammarAccess.getNamedColorAccess().getMagentaKeyword_85()); 

                    }


                    }
                    break;
                case 87 :
                    // InternalLatteCSS.g:3592:6: ( 'maroon' )
                    {
                    // InternalLatteCSS.g:3592:6: ( 'maroon' )
                    // InternalLatteCSS.g:3593:1: 'maroon'
                    {
                     before(grammarAccess.getNamedColorAccess().getMaroonKeyword_86()); 
                    match(input,212,FOLLOW_2); 
                     after(grammarAccess.getNamedColorAccess().getMaroonKeyword_86()); 

                    }


                    }
                    break;
                case 88 :
                    // InternalLatteCSS.g:3600:6: ( 'mediumaquamarine' )
                    {
                    // InternalLatteCSS.g:3600:6: ( 'mediumaquamarine' )
                    // InternalLatteCSS.g:3601:1: 'mediumaquamarine'
                    {
                     before(grammarAccess.getNamedColorAccess().getMediumaquamarineKeyword_87()); 
                    match(input,213,FOLLOW_2); 
                     after(grammarAccess.getNamedColorAccess().getMediumaquamarineKeyword_87()); 

                    }


                    }
                    break;
                case 89 :
                    // InternalLatteCSS.g:3608:6: ( 'mediumblue' )
                    {
                    // InternalLatteCSS.g:3608:6: ( 'mediumblue' )
                    // InternalLatteCSS.g:3609:1: 'mediumblue'
                    {
                     before(grammarAccess.getNamedColorAccess().getMediumblueKeyword_88()); 
                    match(input,214,FOLLOW_2); 
                     after(grammarAccess.getNamedColorAccess().getMediumblueKeyword_88()); 

                    }


                    }
                    break;
                case 90 :
                    // InternalLatteCSS.g:3616:6: ( 'mediumorchid' )
                    {
                    // InternalLatteCSS.g:3616:6: ( 'mediumorchid' )
                    // InternalLatteCSS.g:3617:1: 'mediumorchid'
                    {
                     before(grammarAccess.getNamedColorAccess().getMediumorchidKeyword_89()); 
                    match(input,215,FOLLOW_2); 
                     after(grammarAccess.getNamedColorAccess().getMediumorchidKeyword_89()); 

                    }


                    }
                    break;
                case 91 :
                    // InternalLatteCSS.g:3624:6: ( 'mediumpurple' )
                    {
                    // InternalLatteCSS.g:3624:6: ( 'mediumpurple' )
                    // InternalLatteCSS.g:3625:1: 'mediumpurple'
                    {
                     before(grammarAccess.getNamedColorAccess().getMediumpurpleKeyword_90()); 
                    match(input,216,FOLLOW_2); 
                     after(grammarAccess.getNamedColorAccess().getMediumpurpleKeyword_90()); 

                    }


                    }
                    break;
                case 92 :
                    // InternalLatteCSS.g:3632:6: ( 'mediumseagreen' )
                    {
                    // InternalLatteCSS.g:3632:6: ( 'mediumseagreen' )
                    // InternalLatteCSS.g:3633:1: 'mediumseagreen'
                    {
                     before(grammarAccess.getNamedColorAccess().getMediumseagreenKeyword_91()); 
                    match(input,217,FOLLOW_2); 
                     after(grammarAccess.getNamedColorAccess().getMediumseagreenKeyword_91()); 

                    }


                    }
                    break;
                case 93 :
                    // InternalLatteCSS.g:3640:6: ( 'mediumslateblue' )
                    {
                    // InternalLatteCSS.g:3640:6: ( 'mediumslateblue' )
                    // InternalLatteCSS.g:3641:1: 'mediumslateblue'
                    {
                     before(grammarAccess.getNamedColorAccess().getMediumslateblueKeyword_92()); 
                    match(input,218,FOLLOW_2); 
                     after(grammarAccess.getNamedColorAccess().getMediumslateblueKeyword_92()); 

                    }


                    }
                    break;
                case 94 :
                    // InternalLatteCSS.g:3648:6: ( 'mediumspringgreen' )
                    {
                    // InternalLatteCSS.g:3648:6: ( 'mediumspringgreen' )
                    // InternalLatteCSS.g:3649:1: 'mediumspringgreen'
                    {
                     before(grammarAccess.getNamedColorAccess().getMediumspringgreenKeyword_93()); 
                    match(input,219,FOLLOW_2); 
                     after(grammarAccess.getNamedColorAccess().getMediumspringgreenKeyword_93()); 

                    }


                    }
                    break;
                case 95 :
                    // InternalLatteCSS.g:3656:6: ( 'mediumturquoise' )
                    {
                    // InternalLatteCSS.g:3656:6: ( 'mediumturquoise' )
                    // InternalLatteCSS.g:3657:1: 'mediumturquoise'
                    {
                     before(grammarAccess.getNamedColorAccess().getMediumturquoiseKeyword_94()); 
                    match(input,220,FOLLOW_2); 
                     after(grammarAccess.getNamedColorAccess().getMediumturquoiseKeyword_94()); 

                    }


                    }
                    break;
                case 96 :
                    // InternalLatteCSS.g:3664:6: ( 'mediumvioletred' )
                    {
                    // InternalLatteCSS.g:3664:6: ( 'mediumvioletred' )
                    // InternalLatteCSS.g:3665:1: 'mediumvioletred'
                    {
                     before(grammarAccess.getNamedColorAccess().getMediumvioletredKeyword_95()); 
                    match(input,221,FOLLOW_2); 
                     after(grammarAccess.getNamedColorAccess().getMediumvioletredKeyword_95()); 

                    }


                    }
                    break;
                case 97 :
                    // InternalLatteCSS.g:3672:6: ( 'midnightblue' )
                    {
                    // InternalLatteCSS.g:3672:6: ( 'midnightblue' )
                    // InternalLatteCSS.g:3673:1: 'midnightblue'
                    {
                     before(grammarAccess.getNamedColorAccess().getMidnightblueKeyword_96()); 
                    match(input,222,FOLLOW_2); 
                     after(grammarAccess.getNamedColorAccess().getMidnightblueKeyword_96()); 

                    }


                    }
                    break;
                case 98 :
                    // InternalLatteCSS.g:3680:6: ( 'mintcream' )
                    {
                    // InternalLatteCSS.g:3680:6: ( 'mintcream' )
                    // InternalLatteCSS.g:3681:1: 'mintcream'
                    {
                     before(grammarAccess.getNamedColorAccess().getMintcreamKeyword_97()); 
                    match(input,223,FOLLOW_2); 
                     after(grammarAccess.getNamedColorAccess().getMintcreamKeyword_97()); 

                    }


                    }
                    break;
                case 99 :
                    // InternalLatteCSS.g:3688:6: ( 'mistyrose' )
                    {
                    // InternalLatteCSS.g:3688:6: ( 'mistyrose' )
                    // InternalLatteCSS.g:3689:1: 'mistyrose'
                    {
                     before(grammarAccess.getNamedColorAccess().getMistyroseKeyword_98()); 
                    match(input,224,FOLLOW_2); 
                     after(grammarAccess.getNamedColorAccess().getMistyroseKeyword_98()); 

                    }


                    }
                    break;
                case 100 :
                    // InternalLatteCSS.g:3696:6: ( 'moccasin' )
                    {
                    // InternalLatteCSS.g:3696:6: ( 'moccasin' )
                    // InternalLatteCSS.g:3697:1: 'moccasin'
                    {
                     before(grammarAccess.getNamedColorAccess().getMoccasinKeyword_99()); 
                    match(input,225,FOLLOW_2); 
                     after(grammarAccess.getNamedColorAccess().getMoccasinKeyword_99()); 

                    }


                    }
                    break;
                case 101 :
                    // InternalLatteCSS.g:3704:6: ( 'navajowhite' )
                    {
                    // InternalLatteCSS.g:3704:6: ( 'navajowhite' )
                    // InternalLatteCSS.g:3705:1: 'navajowhite'
                    {
                     before(grammarAccess.getNamedColorAccess().getNavajowhiteKeyword_100()); 
                    match(input,226,FOLLOW_2); 
                     after(grammarAccess.getNamedColorAccess().getNavajowhiteKeyword_100()); 

                    }


                    }
                    break;
                case 102 :
                    // InternalLatteCSS.g:3712:6: ( 'navy' )
                    {
                    // InternalLatteCSS.g:3712:6: ( 'navy' )
                    // InternalLatteCSS.g:3713:1: 'navy'
                    {
                     before(grammarAccess.getNamedColorAccess().getNavyKeyword_101()); 
                    match(input,227,FOLLOW_2); 
                     after(grammarAccess.getNamedColorAccess().getNavyKeyword_101()); 

                    }


                    }
                    break;
                case 103 :
                    // InternalLatteCSS.g:3720:6: ( 'oldlace' )
                    {
                    // InternalLatteCSS.g:3720:6: ( 'oldlace' )
                    // InternalLatteCSS.g:3721:1: 'oldlace'
                    {
                     before(grammarAccess.getNamedColorAccess().getOldlaceKeyword_102()); 
                    match(input,228,FOLLOW_2); 
                     after(grammarAccess.getNamedColorAccess().getOldlaceKeyword_102()); 

                    }


                    }
                    break;
                case 104 :
                    // InternalLatteCSS.g:3728:6: ( 'olive' )
                    {
                    // InternalLatteCSS.g:3728:6: ( 'olive' )
                    // InternalLatteCSS.g:3729:1: 'olive'
                    {
                     before(grammarAccess.getNamedColorAccess().getOliveKeyword_103()); 
                    match(input,229,FOLLOW_2); 
                     after(grammarAccess.getNamedColorAccess().getOliveKeyword_103()); 

                    }


                    }
                    break;
                case 105 :
                    // InternalLatteCSS.g:3736:6: ( 'olivedrab' )
                    {
                    // InternalLatteCSS.g:3736:6: ( 'olivedrab' )
                    // InternalLatteCSS.g:3737:1: 'olivedrab'
                    {
                     before(grammarAccess.getNamedColorAccess().getOlivedrabKeyword_104()); 
                    match(input,230,FOLLOW_2); 
                     after(grammarAccess.getNamedColorAccess().getOlivedrabKeyword_104()); 

                    }


                    }
                    break;
                case 106 :
                    // InternalLatteCSS.g:3744:6: ( 'orange' )
                    {
                    // InternalLatteCSS.g:3744:6: ( 'orange' )
                    // InternalLatteCSS.g:3745:1: 'orange'
                    {
                     before(grammarAccess.getNamedColorAccess().getOrangeKeyword_105()); 
                    match(input,231,FOLLOW_2); 
                     after(grammarAccess.getNamedColorAccess().getOrangeKeyword_105()); 

                    }


                    }
                    break;
                case 107 :
                    // InternalLatteCSS.g:3752:6: ( 'orangered' )
                    {
                    // InternalLatteCSS.g:3752:6: ( 'orangered' )
                    // InternalLatteCSS.g:3753:1: 'orangered'
                    {
                     before(grammarAccess.getNamedColorAccess().getOrangeredKeyword_106()); 
                    match(input,232,FOLLOW_2); 
                     after(grammarAccess.getNamedColorAccess().getOrangeredKeyword_106()); 

                    }


                    }
                    break;
                case 108 :
                    // InternalLatteCSS.g:3760:6: ( 'orchid' )
                    {
                    // InternalLatteCSS.g:3760:6: ( 'orchid' )
                    // InternalLatteCSS.g:3761:1: 'orchid'
                    {
                     before(grammarAccess.getNamedColorAccess().getOrchidKeyword_107()); 
                    match(input,233,FOLLOW_2); 
                     after(grammarAccess.getNamedColorAccess().getOrchidKeyword_107()); 

                    }


                    }
                    break;
                case 109 :
                    // InternalLatteCSS.g:3768:6: ( 'palegoldenrod' )
                    {
                    // InternalLatteCSS.g:3768:6: ( 'palegoldenrod' )
                    // InternalLatteCSS.g:3769:1: 'palegoldenrod'
                    {
                     before(grammarAccess.getNamedColorAccess().getPalegoldenrodKeyword_108()); 
                    match(input,234,FOLLOW_2); 
                     after(grammarAccess.getNamedColorAccess().getPalegoldenrodKeyword_108()); 

                    }


                    }
                    break;
                case 110 :
                    // InternalLatteCSS.g:3776:6: ( 'palegreen' )
                    {
                    // InternalLatteCSS.g:3776:6: ( 'palegreen' )
                    // InternalLatteCSS.g:3777:1: 'palegreen'
                    {
                     before(grammarAccess.getNamedColorAccess().getPalegreenKeyword_109()); 
                    match(input,235,FOLLOW_2); 
                     after(grammarAccess.getNamedColorAccess().getPalegreenKeyword_109()); 

                    }


                    }
                    break;
                case 111 :
                    // InternalLatteCSS.g:3784:6: ( 'paleturquoise' )
                    {
                    // InternalLatteCSS.g:3784:6: ( 'paleturquoise' )
                    // InternalLatteCSS.g:3785:1: 'paleturquoise'
                    {
                     before(grammarAccess.getNamedColorAccess().getPaleturquoiseKeyword_110()); 
                    match(input,236,FOLLOW_2); 
                     after(grammarAccess.getNamedColorAccess().getPaleturquoiseKeyword_110()); 

                    }


                    }
                    break;
                case 112 :
                    // InternalLatteCSS.g:3792:6: ( 'palevioletred' )
                    {
                    // InternalLatteCSS.g:3792:6: ( 'palevioletred' )
                    // InternalLatteCSS.g:3793:1: 'palevioletred'
                    {
                     before(grammarAccess.getNamedColorAccess().getPalevioletredKeyword_111()); 
                    match(input,237,FOLLOW_2); 
                     after(grammarAccess.getNamedColorAccess().getPalevioletredKeyword_111()); 

                    }


                    }
                    break;
                case 113 :
                    // InternalLatteCSS.g:3800:6: ( 'papayawhip' )
                    {
                    // InternalLatteCSS.g:3800:6: ( 'papayawhip' )
                    // InternalLatteCSS.g:3801:1: 'papayawhip'
                    {
                     before(grammarAccess.getNamedColorAccess().getPapayawhipKeyword_112()); 
                    match(input,238,FOLLOW_2); 
                     after(grammarAccess.getNamedColorAccess().getPapayawhipKeyword_112()); 

                    }


                    }
                    break;
                case 114 :
                    // InternalLatteCSS.g:3808:6: ( 'peachpuff' )
                    {
                    // InternalLatteCSS.g:3808:6: ( 'peachpuff' )
                    // InternalLatteCSS.g:3809:1: 'peachpuff'
                    {
                     before(grammarAccess.getNamedColorAccess().getPeachpuffKeyword_113()); 
                    match(input,239,FOLLOW_2); 
                     after(grammarAccess.getNamedColorAccess().getPeachpuffKeyword_113()); 

                    }


                    }
                    break;
                case 115 :
                    // InternalLatteCSS.g:3816:6: ( 'peru' )
                    {
                    // InternalLatteCSS.g:3816:6: ( 'peru' )
                    // InternalLatteCSS.g:3817:1: 'peru'
                    {
                     before(grammarAccess.getNamedColorAccess().getPeruKeyword_114()); 
                    match(input,240,FOLLOW_2); 
                     after(grammarAccess.getNamedColorAccess().getPeruKeyword_114()); 

                    }


                    }
                    break;
                case 116 :
                    // InternalLatteCSS.g:3824:6: ( 'pink' )
                    {
                    // InternalLatteCSS.g:3824:6: ( 'pink' )
                    // InternalLatteCSS.g:3825:1: 'pink'
                    {
                     before(grammarAccess.getNamedColorAccess().getPinkKeyword_115()); 
                    match(input,241,FOLLOW_2); 
                     after(grammarAccess.getNamedColorAccess().getPinkKeyword_115()); 

                    }


                    }
                    break;
                case 117 :
                    // InternalLatteCSS.g:3832:6: ( 'plum' )
                    {
                    // InternalLatteCSS.g:3832:6: ( 'plum' )
                    // InternalLatteCSS.g:3833:1: 'plum'
                    {
                     before(grammarAccess.getNamedColorAccess().getPlumKeyword_116()); 
                    match(input,242,FOLLOW_2); 
                     after(grammarAccess.getNamedColorAccess().getPlumKeyword_116()); 

                    }


                    }
                    break;
                case 118 :
                    // InternalLatteCSS.g:3840:6: ( 'powderblue' )
                    {
                    // InternalLatteCSS.g:3840:6: ( 'powderblue' )
                    // InternalLatteCSS.g:3841:1: 'powderblue'
                    {
                     before(grammarAccess.getNamedColorAccess().getPowderblueKeyword_117()); 
                    match(input,243,FOLLOW_2); 
                     after(grammarAccess.getNamedColorAccess().getPowderblueKeyword_117()); 

                    }


                    }
                    break;
                case 119 :
                    // InternalLatteCSS.g:3848:6: ( 'purple' )
                    {
                    // InternalLatteCSS.g:3848:6: ( 'purple' )
                    // InternalLatteCSS.g:3849:1: 'purple'
                    {
                     before(grammarAccess.getNamedColorAccess().getPurpleKeyword_118()); 
                    match(input,244,FOLLOW_2); 
                     after(grammarAccess.getNamedColorAccess().getPurpleKeyword_118()); 

                    }


                    }
                    break;
                case 120 :
                    // InternalLatteCSS.g:3856:6: ( 'red' )
                    {
                    // InternalLatteCSS.g:3856:6: ( 'red' )
                    // InternalLatteCSS.g:3857:1: 'red'
                    {
                     before(grammarAccess.getNamedColorAccess().getRedKeyword_119()); 
                    match(input,245,FOLLOW_2); 
                     after(grammarAccess.getNamedColorAccess().getRedKeyword_119()); 

                    }


                    }
                    break;
                case 121 :
                    // InternalLatteCSS.g:3864:6: ( 'rosybrown' )
                    {
                    // InternalLatteCSS.g:3864:6: ( 'rosybrown' )
                    // InternalLatteCSS.g:3865:1: 'rosybrown'
                    {
                     before(grammarAccess.getNamedColorAccess().getRosybrownKeyword_120()); 
                    match(input,246,FOLLOW_2); 
                     after(grammarAccess.getNamedColorAccess().getRosybrownKeyword_120()); 

                    }


                    }
                    break;
                case 122 :
                    // InternalLatteCSS.g:3872:6: ( 'royalblue' )
                    {
                    // InternalLatteCSS.g:3872:6: ( 'royalblue' )
                    // InternalLatteCSS.g:3873:1: 'royalblue'
                    {
                     before(grammarAccess.getNamedColorAccess().getRoyalblueKeyword_121()); 
                    match(input,247,FOLLOW_2); 
                     after(grammarAccess.getNamedColorAccess().getRoyalblueKeyword_121()); 

                    }


                    }
                    break;
                case 123 :
                    // InternalLatteCSS.g:3880:6: ( 'saddlebrown' )
                    {
                    // InternalLatteCSS.g:3880:6: ( 'saddlebrown' )
                    // InternalLatteCSS.g:3881:1: 'saddlebrown'
                    {
                     before(grammarAccess.getNamedColorAccess().getSaddlebrownKeyword_122()); 
                    match(input,248,FOLLOW_2); 
                     after(grammarAccess.getNamedColorAccess().getSaddlebrownKeyword_122()); 

                    }


                    }
                    break;
                case 124 :
                    // InternalLatteCSS.g:3888:6: ( 'salmon' )
                    {
                    // InternalLatteCSS.g:3888:6: ( 'salmon' )
                    // InternalLatteCSS.g:3889:1: 'salmon'
                    {
                     before(grammarAccess.getNamedColorAccess().getSalmonKeyword_123()); 
                    match(input,249,FOLLOW_2); 
                     after(grammarAccess.getNamedColorAccess().getSalmonKeyword_123()); 

                    }


                    }
                    break;
                case 125 :
                    // InternalLatteCSS.g:3896:6: ( 'sandybrown' )
                    {
                    // InternalLatteCSS.g:3896:6: ( 'sandybrown' )
                    // InternalLatteCSS.g:3897:1: 'sandybrown'
                    {
                     before(grammarAccess.getNamedColorAccess().getSandybrownKeyword_124()); 
                    match(input,250,FOLLOW_2); 
                     after(grammarAccess.getNamedColorAccess().getSandybrownKeyword_124()); 

                    }


                    }
                    break;
                case 126 :
                    // InternalLatteCSS.g:3904:6: ( 'seagreen' )
                    {
                    // InternalLatteCSS.g:3904:6: ( 'seagreen' )
                    // InternalLatteCSS.g:3905:1: 'seagreen'
                    {
                     before(grammarAccess.getNamedColorAccess().getSeagreenKeyword_125()); 
                    match(input,251,FOLLOW_2); 
                     after(grammarAccess.getNamedColorAccess().getSeagreenKeyword_125()); 

                    }


                    }
                    break;
                case 127 :
                    // InternalLatteCSS.g:3912:6: ( 'seashell' )
                    {
                    // InternalLatteCSS.g:3912:6: ( 'seashell' )
                    // InternalLatteCSS.g:3913:1: 'seashell'
                    {
                     before(grammarAccess.getNamedColorAccess().getSeashellKeyword_126()); 
                    match(input,252,FOLLOW_2); 
                     after(grammarAccess.getNamedColorAccess().getSeashellKeyword_126()); 

                    }


                    }
                    break;
                case 128 :
                    // InternalLatteCSS.g:3920:6: ( 'sienna' )
                    {
                    // InternalLatteCSS.g:3920:6: ( 'sienna' )
                    // InternalLatteCSS.g:3921:1: 'sienna'
                    {
                     before(grammarAccess.getNamedColorAccess().getSiennaKeyword_127()); 
                    match(input,253,FOLLOW_2); 
                     after(grammarAccess.getNamedColorAccess().getSiennaKeyword_127()); 

                    }


                    }
                    break;
                case 129 :
                    // InternalLatteCSS.g:3928:6: ( 'silver' )
                    {
                    // InternalLatteCSS.g:3928:6: ( 'silver' )
                    // InternalLatteCSS.g:3929:1: 'silver'
                    {
                     before(grammarAccess.getNamedColorAccess().getSilverKeyword_128()); 
                    match(input,254,FOLLOW_2); 
                     after(grammarAccess.getNamedColorAccess().getSilverKeyword_128()); 

                    }


                    }
                    break;
                case 130 :
                    // InternalLatteCSS.g:3936:6: ( 'skyblue' )
                    {
                    // InternalLatteCSS.g:3936:6: ( 'skyblue' )
                    // InternalLatteCSS.g:3937:1: 'skyblue'
                    {
                     before(grammarAccess.getNamedColorAccess().getSkyblueKeyword_129()); 
                    match(input,255,FOLLOW_2); 
                     after(grammarAccess.getNamedColorAccess().getSkyblueKeyword_129()); 

                    }


                    }
                    break;
                case 131 :
                    // InternalLatteCSS.g:3944:6: ( 'slateblue' )
                    {
                    // InternalLatteCSS.g:3944:6: ( 'slateblue' )
                    // InternalLatteCSS.g:3945:1: 'slateblue'
                    {
                     before(grammarAccess.getNamedColorAccess().getSlateblueKeyword_130()); 
                    match(input,256,FOLLOW_2); 
                     after(grammarAccess.getNamedColorAccess().getSlateblueKeyword_130()); 

                    }


                    }
                    break;
                case 132 :
                    // InternalLatteCSS.g:3952:6: ( 'slategray' )
                    {
                    // InternalLatteCSS.g:3952:6: ( 'slategray' )
                    // InternalLatteCSS.g:3953:1: 'slategray'
                    {
                     before(grammarAccess.getNamedColorAccess().getSlategrayKeyword_131()); 
                    match(input,257,FOLLOW_2); 
                     after(grammarAccess.getNamedColorAccess().getSlategrayKeyword_131()); 

                    }


                    }
                    break;
                case 133 :
                    // InternalLatteCSS.g:3960:6: ( 'slategrey' )
                    {
                    // InternalLatteCSS.g:3960:6: ( 'slategrey' )
                    // InternalLatteCSS.g:3961:1: 'slategrey'
                    {
                     before(grammarAccess.getNamedColorAccess().getSlategreyKeyword_132()); 
                    match(input,258,FOLLOW_2); 
                     after(grammarAccess.getNamedColorAccess().getSlategreyKeyword_132()); 

                    }


                    }
                    break;
                case 134 :
                    // InternalLatteCSS.g:3968:6: ( 'snow' )
                    {
                    // InternalLatteCSS.g:3968:6: ( 'snow' )
                    // InternalLatteCSS.g:3969:1: 'snow'
                    {
                     before(grammarAccess.getNamedColorAccess().getSnowKeyword_133()); 
                    match(input,259,FOLLOW_2); 
                     after(grammarAccess.getNamedColorAccess().getSnowKeyword_133()); 

                    }


                    }
                    break;
                case 135 :
                    // InternalLatteCSS.g:3976:6: ( 'springgreen' )
                    {
                    // InternalLatteCSS.g:3976:6: ( 'springgreen' )
                    // InternalLatteCSS.g:3977:1: 'springgreen'
                    {
                     before(grammarAccess.getNamedColorAccess().getSpringgreenKeyword_134()); 
                    match(input,260,FOLLOW_2); 
                     after(grammarAccess.getNamedColorAccess().getSpringgreenKeyword_134()); 

                    }


                    }
                    break;
                case 136 :
                    // InternalLatteCSS.g:3984:6: ( 'steelblue' )
                    {
                    // InternalLatteCSS.g:3984:6: ( 'steelblue' )
                    // InternalLatteCSS.g:3985:1: 'steelblue'
                    {
                     before(grammarAccess.getNamedColorAccess().getSteelblueKeyword_135()); 
                    match(input,261,FOLLOW_2); 
                     after(grammarAccess.getNamedColorAccess().getSteelblueKeyword_135()); 

                    }


                    }
                    break;
                case 137 :
                    // InternalLatteCSS.g:3992:6: ( 'tan' )
                    {
                    // InternalLatteCSS.g:3992:6: ( 'tan' )
                    // InternalLatteCSS.g:3993:1: 'tan'
                    {
                     before(grammarAccess.getNamedColorAccess().getTanKeyword_136()); 
                    match(input,262,FOLLOW_2); 
                     after(grammarAccess.getNamedColorAccess().getTanKeyword_136()); 

                    }


                    }
                    break;
                case 138 :
                    // InternalLatteCSS.g:4000:6: ( 'teal' )
                    {
                    // InternalLatteCSS.g:4000:6: ( 'teal' )
                    // InternalLatteCSS.g:4001:1: 'teal'
                    {
                     before(grammarAccess.getNamedColorAccess().getTealKeyword_137()); 
                    match(input,263,FOLLOW_2); 
                     after(grammarAccess.getNamedColorAccess().getTealKeyword_137()); 

                    }


                    }
                    break;
                case 139 :
                    // InternalLatteCSS.g:4008:6: ( 'thistle' )
                    {
                    // InternalLatteCSS.g:4008:6: ( 'thistle' )
                    // InternalLatteCSS.g:4009:1: 'thistle'
                    {
                     before(grammarAccess.getNamedColorAccess().getThistleKeyword_138()); 
                    match(input,264,FOLLOW_2); 
                     after(grammarAccess.getNamedColorAccess().getThistleKeyword_138()); 

                    }


                    }
                    break;
                case 140 :
                    // InternalLatteCSS.g:4016:6: ( 'tomato' )
                    {
                    // InternalLatteCSS.g:4016:6: ( 'tomato' )
                    // InternalLatteCSS.g:4017:1: 'tomato'
                    {
                     before(grammarAccess.getNamedColorAccess().getTomatoKeyword_139()); 
                    match(input,265,FOLLOW_2); 
                     after(grammarAccess.getNamedColorAccess().getTomatoKeyword_139()); 

                    }


                    }
                    break;
                case 141 :
                    // InternalLatteCSS.g:4024:6: ( 'turquoise' )
                    {
                    // InternalLatteCSS.g:4024:6: ( 'turquoise' )
                    // InternalLatteCSS.g:4025:1: 'turquoise'
                    {
                     before(grammarAccess.getNamedColorAccess().getTurquoiseKeyword_140()); 
                    match(input,266,FOLLOW_2); 
                     after(grammarAccess.getNamedColorAccess().getTurquoiseKeyword_140()); 

                    }


                    }
                    break;
                case 142 :
                    // InternalLatteCSS.g:4032:6: ( 'violet' )
                    {
                    // InternalLatteCSS.g:4032:6: ( 'violet' )
                    // InternalLatteCSS.g:4033:1: 'violet'
                    {
                     before(grammarAccess.getNamedColorAccess().getVioletKeyword_141()); 
                    match(input,267,FOLLOW_2); 
                     after(grammarAccess.getNamedColorAccess().getVioletKeyword_141()); 

                    }


                    }
                    break;
                case 143 :
                    // InternalLatteCSS.g:4040:6: ( 'wheat' )
                    {
                    // InternalLatteCSS.g:4040:6: ( 'wheat' )
                    // InternalLatteCSS.g:4041:1: 'wheat'
                    {
                     before(grammarAccess.getNamedColorAccess().getWheatKeyword_142()); 
                    match(input,268,FOLLOW_2); 
                     after(grammarAccess.getNamedColorAccess().getWheatKeyword_142()); 

                    }


                    }
                    break;
                case 144 :
                    // InternalLatteCSS.g:4048:6: ( 'white' )
                    {
                    // InternalLatteCSS.g:4048:6: ( 'white' )
                    // InternalLatteCSS.g:4049:1: 'white'
                    {
                     before(grammarAccess.getNamedColorAccess().getWhiteKeyword_143()); 
                    match(input,269,FOLLOW_2); 
                     after(grammarAccess.getNamedColorAccess().getWhiteKeyword_143()); 

                    }


                    }
                    break;
                case 145 :
                    // InternalLatteCSS.g:4056:6: ( 'whitesmoke' )
                    {
                    // InternalLatteCSS.g:4056:6: ( 'whitesmoke' )
                    // InternalLatteCSS.g:4057:1: 'whitesmoke'
                    {
                     before(grammarAccess.getNamedColorAccess().getWhitesmokeKeyword_144()); 
                    match(input,270,FOLLOW_2); 
                     after(grammarAccess.getNamedColorAccess().getWhitesmokeKeyword_144()); 

                    }


                    }
                    break;
                case 146 :
                    // InternalLatteCSS.g:4064:6: ( 'yellow' )
                    {
                    // InternalLatteCSS.g:4064:6: ( 'yellow' )
                    // InternalLatteCSS.g:4065:1: 'yellow'
                    {
                     before(grammarAccess.getNamedColorAccess().getYellowKeyword_145()); 
                    match(input,271,FOLLOW_2); 
                     after(grammarAccess.getNamedColorAccess().getYellowKeyword_145()); 

                    }


                    }
                    break;
                case 147 :
                    // InternalLatteCSS.g:4072:6: ( 'yellowgreen' )
                    {
                    // InternalLatteCSS.g:4072:6: ( 'yellowgreen' )
                    // InternalLatteCSS.g:4073:1: 'yellowgreen'
                    {
                     before(grammarAccess.getNamedColorAccess().getYellowgreenKeyword_146()); 
                    match(input,272,FOLLOW_2); 
                     after(grammarAccess.getNamedColorAccess().getYellowgreenKeyword_146()); 

                    }


                    }
                    break;
                case 148 :
                    // InternalLatteCSS.g:4080:6: ( 'transparent' )
                    {
                    // InternalLatteCSS.g:4080:6: ( 'transparent' )
                    // InternalLatteCSS.g:4081:1: 'transparent'
                    {
                     before(grammarAccess.getNamedColorAccess().getTransparentKeyword_147()); 
                    match(input,273,FOLLOW_2); 
                     after(grammarAccess.getNamedColorAccess().getTransparentKeyword_147()); 

                    }


                    }
                    break;

            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__NamedColor__Alternatives"


    // $ANTLR start "rule__RGBColor__Alternatives"
    // InternalLatteCSS.g:4093:1: rule__RGBColor__Alternatives : ( ( ( rule__RGBColor__HexAssignment_0 ) ) | ( ( rule__RGBColor__Group_1__0 ) ) | ( ( rule__RGBColor__Group_2__0 ) ) );
    public final void rule__RGBColor__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalLatteCSS.g:4097:1: ( ( ( rule__RGBColor__HexAssignment_0 ) ) | ( ( rule__RGBColor__Group_1__0 ) ) | ( ( rule__RGBColor__Group_2__0 ) ) )
            int alt29=3;
            switch ( input.LA(1) ) {
            case RULE_HEX_NUMBER:
                {
                alt29=1;
                }
                break;
            case 287:
                {
                alt29=2;
                }
                break;
            case 288:
                {
                alt29=3;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 29, 0, input);

                throw nvae;
            }

            switch (alt29) {
                case 1 :
                    // InternalLatteCSS.g:4098:1: ( ( rule__RGBColor__HexAssignment_0 ) )
                    {
                    // InternalLatteCSS.g:4098:1: ( ( rule__RGBColor__HexAssignment_0 ) )
                    // InternalLatteCSS.g:4099:1: ( rule__RGBColor__HexAssignment_0 )
                    {
                     before(grammarAccess.getRGBColorAccess().getHexAssignment_0()); 
                    // InternalLatteCSS.g:4100:1: ( rule__RGBColor__HexAssignment_0 )
                    // InternalLatteCSS.g:4100:2: rule__RGBColor__HexAssignment_0
                    {
                    pushFollow(FOLLOW_2);
                    rule__RGBColor__HexAssignment_0();

                    state._fsp--;


                    }

                     after(grammarAccess.getRGBColorAccess().getHexAssignment_0()); 

                    }


                    }
                    break;
                case 2 :
                    // InternalLatteCSS.g:4104:6: ( ( rule__RGBColor__Group_1__0 ) )
                    {
                    // InternalLatteCSS.g:4104:6: ( ( rule__RGBColor__Group_1__0 ) )
                    // InternalLatteCSS.g:4105:1: ( rule__RGBColor__Group_1__0 )
                    {
                     before(grammarAccess.getRGBColorAccess().getGroup_1()); 
                    // InternalLatteCSS.g:4106:1: ( rule__RGBColor__Group_1__0 )
                    // InternalLatteCSS.g:4106:2: rule__RGBColor__Group_1__0
                    {
                    pushFollow(FOLLOW_2);
                    rule__RGBColor__Group_1__0();

                    state._fsp--;


                    }

                     after(grammarAccess.getRGBColorAccess().getGroup_1()); 

                    }


                    }
                    break;
                case 3 :
                    // InternalLatteCSS.g:4110:6: ( ( rule__RGBColor__Group_2__0 ) )
                    {
                    // InternalLatteCSS.g:4110:6: ( ( rule__RGBColor__Group_2__0 ) )
                    // InternalLatteCSS.g:4111:1: ( rule__RGBColor__Group_2__0 )
                    {
                     before(grammarAccess.getRGBColorAccess().getGroup_2()); 
                    // InternalLatteCSS.g:4112:1: ( rule__RGBColor__Group_2__0 )
                    // InternalLatteCSS.g:4112:2: rule__RGBColor__Group_2__0
                    {
                    pushFollow(FOLLOW_2);
                    rule__RGBColor__Group_2__0();

                    state._fsp--;


                    }

                     after(grammarAccess.getRGBColorAccess().getGroup_2()); 

                    }


                    }
                    break;

            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__RGBColor__Alternatives"


    // $ANTLR start "rule__Definition__Group__0"
    // InternalLatteCSS.g:4125:1: rule__Definition__Group__0 : rule__Definition__Group__0__Impl rule__Definition__Group__1 ;
    public final void rule__Definition__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalLatteCSS.g:4129:1: ( rule__Definition__Group__0__Impl rule__Definition__Group__1 )
            // InternalLatteCSS.g:4130:2: rule__Definition__Group__0__Impl rule__Definition__Group__1
            {
            pushFollow(FOLLOW_4);
            rule__Definition__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Definition__Group__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Definition__Group__0"


    // $ANTLR start "rule__Definition__Group__0__Impl"
    // InternalLatteCSS.g:4137:1: rule__Definition__Group__0__Impl : ( ( rule__Definition__SelectorAssignment_0 ) ) ;
    public final void rule__Definition__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalLatteCSS.g:4141:1: ( ( ( rule__Definition__SelectorAssignment_0 ) ) )
            // InternalLatteCSS.g:4142:1: ( ( rule__Definition__SelectorAssignment_0 ) )
            {
            // InternalLatteCSS.g:4142:1: ( ( rule__Definition__SelectorAssignment_0 ) )
            // InternalLatteCSS.g:4143:1: ( rule__Definition__SelectorAssignment_0 )
            {
             before(grammarAccess.getDefinitionAccess().getSelectorAssignment_0()); 
            // InternalLatteCSS.g:4144:1: ( rule__Definition__SelectorAssignment_0 )
            // InternalLatteCSS.g:4144:2: rule__Definition__SelectorAssignment_0
            {
            pushFollow(FOLLOW_2);
            rule__Definition__SelectorAssignment_0();

            state._fsp--;


            }

             after(grammarAccess.getDefinitionAccess().getSelectorAssignment_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Definition__Group__0__Impl"


    // $ANTLR start "rule__Definition__Group__1"
    // InternalLatteCSS.g:4154:1: rule__Definition__Group__1 : rule__Definition__Group__1__Impl rule__Definition__Group__2 ;
    public final void rule__Definition__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalLatteCSS.g:4158:1: ( rule__Definition__Group__1__Impl rule__Definition__Group__2 )
            // InternalLatteCSS.g:4159:2: rule__Definition__Group__1__Impl rule__Definition__Group__2
            {
            pushFollow(FOLLOW_4);
            rule__Definition__Group__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Definition__Group__2();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Definition__Group__1"


    // $ANTLR start "rule__Definition__Group__1__Impl"
    // InternalLatteCSS.g:4166:1: rule__Definition__Group__1__Impl : ( ( rule__Definition__Group_1__0 )* ) ;
    public final void rule__Definition__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalLatteCSS.g:4170:1: ( ( ( rule__Definition__Group_1__0 )* ) )
            // InternalLatteCSS.g:4171:1: ( ( rule__Definition__Group_1__0 )* )
            {
            // InternalLatteCSS.g:4171:1: ( ( rule__Definition__Group_1__0 )* )
            // InternalLatteCSS.g:4172:1: ( rule__Definition__Group_1__0 )*
            {
             before(grammarAccess.getDefinitionAccess().getGroup_1()); 
            // InternalLatteCSS.g:4173:1: ( rule__Definition__Group_1__0 )*
            loop30:
            do {
                int alt30=2;
                int LA30_0 = input.LA(1);

                if ( (LA30_0==276) ) {
                    alt30=1;
                }


                switch (alt30) {
            	case 1 :
            	    // InternalLatteCSS.g:4173:2: rule__Definition__Group_1__0
            	    {
            	    pushFollow(FOLLOW_5);
            	    rule__Definition__Group_1__0();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop30;
                }
            } while (true);

             after(grammarAccess.getDefinitionAccess().getGroup_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Definition__Group__1__Impl"


    // $ANTLR start "rule__Definition__Group__2"
    // InternalLatteCSS.g:4183:1: rule__Definition__Group__2 : rule__Definition__Group__2__Impl rule__Definition__Group__3 ;
    public final void rule__Definition__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalLatteCSS.g:4187:1: ( rule__Definition__Group__2__Impl rule__Definition__Group__3 )
            // InternalLatteCSS.g:4188:2: rule__Definition__Group__2__Impl rule__Definition__Group__3
            {
            pushFollow(FOLLOW_6);
            rule__Definition__Group__2__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Definition__Group__3();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Definition__Group__2"


    // $ANTLR start "rule__Definition__Group__2__Impl"
    // InternalLatteCSS.g:4195:1: rule__Definition__Group__2__Impl : ( '{' ) ;
    public final void rule__Definition__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalLatteCSS.g:4199:1: ( ( '{' ) )
            // InternalLatteCSS.g:4200:1: ( '{' )
            {
            // InternalLatteCSS.g:4200:1: ( '{' )
            // InternalLatteCSS.g:4201:1: '{'
            {
             before(grammarAccess.getDefinitionAccess().getLeftCurlyBracketKeyword_2()); 
            match(input,274,FOLLOW_2); 
             after(grammarAccess.getDefinitionAccess().getLeftCurlyBracketKeyword_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Definition__Group__2__Impl"


    // $ANTLR start "rule__Definition__Group__3"
    // InternalLatteCSS.g:4214:1: rule__Definition__Group__3 : rule__Definition__Group__3__Impl rule__Definition__Group__4 ;
    public final void rule__Definition__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalLatteCSS.g:4218:1: ( rule__Definition__Group__3__Impl rule__Definition__Group__4 )
            // InternalLatteCSS.g:4219:2: rule__Definition__Group__3__Impl rule__Definition__Group__4
            {
            pushFollow(FOLLOW_7);
            rule__Definition__Group__3__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Definition__Group__4();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Definition__Group__3"


    // $ANTLR start "rule__Definition__Group__3__Impl"
    // InternalLatteCSS.g:4226:1: rule__Definition__Group__3__Impl : ( ( ( rule__Definition__PropertiesAssignment_3 ) ) ( ( rule__Definition__PropertiesAssignment_3 )* ) ) ;
    public final void rule__Definition__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalLatteCSS.g:4230:1: ( ( ( ( rule__Definition__PropertiesAssignment_3 ) ) ( ( rule__Definition__PropertiesAssignment_3 )* ) ) )
            // InternalLatteCSS.g:4231:1: ( ( ( rule__Definition__PropertiesAssignment_3 ) ) ( ( rule__Definition__PropertiesAssignment_3 )* ) )
            {
            // InternalLatteCSS.g:4231:1: ( ( ( rule__Definition__PropertiesAssignment_3 ) ) ( ( rule__Definition__PropertiesAssignment_3 )* ) )
            // InternalLatteCSS.g:4232:1: ( ( rule__Definition__PropertiesAssignment_3 ) ) ( ( rule__Definition__PropertiesAssignment_3 )* )
            {
            // InternalLatteCSS.g:4232:1: ( ( rule__Definition__PropertiesAssignment_3 ) )
            // InternalLatteCSS.g:4233:1: ( rule__Definition__PropertiesAssignment_3 )
            {
             before(grammarAccess.getDefinitionAccess().getPropertiesAssignment_3()); 
            // InternalLatteCSS.g:4234:1: ( rule__Definition__PropertiesAssignment_3 )
            // InternalLatteCSS.g:4234:2: rule__Definition__PropertiesAssignment_3
            {
            pushFollow(FOLLOW_8);
            rule__Definition__PropertiesAssignment_3();

            state._fsp--;


            }

             after(grammarAccess.getDefinitionAccess().getPropertiesAssignment_3()); 

            }

            // InternalLatteCSS.g:4237:1: ( ( rule__Definition__PropertiesAssignment_3 )* )
            // InternalLatteCSS.g:4238:1: ( rule__Definition__PropertiesAssignment_3 )*
            {
             before(grammarAccess.getDefinitionAccess().getPropertiesAssignment_3()); 
            // InternalLatteCSS.g:4239:1: ( rule__Definition__PropertiesAssignment_3 )*
            loop31:
            do {
                int alt31=2;
                int LA31_0 = input.LA(1);

                if ( ((LA31_0>=16 && LA31_0<=48)||(LA31_0>=92 && LA31_0<=99)||(LA31_0>=289 && LA31_0<=299)) ) {
                    alt31=1;
                }


                switch (alt31) {
            	case 1 :
            	    // InternalLatteCSS.g:4239:2: rule__Definition__PropertiesAssignment_3
            	    {
            	    pushFollow(FOLLOW_8);
            	    rule__Definition__PropertiesAssignment_3();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop31;
                }
            } while (true);

             after(grammarAccess.getDefinitionAccess().getPropertiesAssignment_3()); 

            }


            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Definition__Group__3__Impl"


    // $ANTLR start "rule__Definition__Group__4"
    // InternalLatteCSS.g:4250:1: rule__Definition__Group__4 : rule__Definition__Group__4__Impl ;
    public final void rule__Definition__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalLatteCSS.g:4254:1: ( rule__Definition__Group__4__Impl )
            // InternalLatteCSS.g:4255:2: rule__Definition__Group__4__Impl
            {
            pushFollow(FOLLOW_2);
            rule__Definition__Group__4__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Definition__Group__4"


    // $ANTLR start "rule__Definition__Group__4__Impl"
    // InternalLatteCSS.g:4261:1: rule__Definition__Group__4__Impl : ( '}' ) ;
    public final void rule__Definition__Group__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalLatteCSS.g:4265:1: ( ( '}' ) )
            // InternalLatteCSS.g:4266:1: ( '}' )
            {
            // InternalLatteCSS.g:4266:1: ( '}' )
            // InternalLatteCSS.g:4267:1: '}'
            {
             before(grammarAccess.getDefinitionAccess().getRightCurlyBracketKeyword_4()); 
            match(input,275,FOLLOW_2); 
             after(grammarAccess.getDefinitionAccess().getRightCurlyBracketKeyword_4()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Definition__Group__4__Impl"


    // $ANTLR start "rule__Definition__Group_1__0"
    // InternalLatteCSS.g:4290:1: rule__Definition__Group_1__0 : rule__Definition__Group_1__0__Impl rule__Definition__Group_1__1 ;
    public final void rule__Definition__Group_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalLatteCSS.g:4294:1: ( rule__Definition__Group_1__0__Impl rule__Definition__Group_1__1 )
            // InternalLatteCSS.g:4295:2: rule__Definition__Group_1__0__Impl rule__Definition__Group_1__1
            {
            pushFollow(FOLLOW_9);
            rule__Definition__Group_1__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Definition__Group_1__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Definition__Group_1__0"


    // $ANTLR start "rule__Definition__Group_1__0__Impl"
    // InternalLatteCSS.g:4302:1: rule__Definition__Group_1__0__Impl : ( ',' ) ;
    public final void rule__Definition__Group_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalLatteCSS.g:4306:1: ( ( ',' ) )
            // InternalLatteCSS.g:4307:1: ( ',' )
            {
            // InternalLatteCSS.g:4307:1: ( ',' )
            // InternalLatteCSS.g:4308:1: ','
            {
             before(grammarAccess.getDefinitionAccess().getCommaKeyword_1_0()); 
            match(input,276,FOLLOW_2); 
             after(grammarAccess.getDefinitionAccess().getCommaKeyword_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Definition__Group_1__0__Impl"


    // $ANTLR start "rule__Definition__Group_1__1"
    // InternalLatteCSS.g:4321:1: rule__Definition__Group_1__1 : rule__Definition__Group_1__1__Impl ;
    public final void rule__Definition__Group_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalLatteCSS.g:4325:1: ( rule__Definition__Group_1__1__Impl )
            // InternalLatteCSS.g:4326:2: rule__Definition__Group_1__1__Impl
            {
            pushFollow(FOLLOW_2);
            rule__Definition__Group_1__1__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Definition__Group_1__1"


    // $ANTLR start "rule__Definition__Group_1__1__Impl"
    // InternalLatteCSS.g:4332:1: rule__Definition__Group_1__1__Impl : ( ( rule__Definition__SelectorAssignment_1_1 ) ) ;
    public final void rule__Definition__Group_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalLatteCSS.g:4336:1: ( ( ( rule__Definition__SelectorAssignment_1_1 ) ) )
            // InternalLatteCSS.g:4337:1: ( ( rule__Definition__SelectorAssignment_1_1 ) )
            {
            // InternalLatteCSS.g:4337:1: ( ( rule__Definition__SelectorAssignment_1_1 ) )
            // InternalLatteCSS.g:4338:1: ( rule__Definition__SelectorAssignment_1_1 )
            {
             before(grammarAccess.getDefinitionAccess().getSelectorAssignment_1_1()); 
            // InternalLatteCSS.g:4339:1: ( rule__Definition__SelectorAssignment_1_1 )
            // InternalLatteCSS.g:4339:2: rule__Definition__SelectorAssignment_1_1
            {
            pushFollow(FOLLOW_2);
            rule__Definition__SelectorAssignment_1_1();

            state._fsp--;


            }

             after(grammarAccess.getDefinitionAccess().getSelectorAssignment_1_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Definition__Group_1__1__Impl"


    // $ANTLR start "rule__SimpleSelector__Group_1__0"
    // InternalLatteCSS.g:4353:1: rule__SimpleSelector__Group_1__0 : rule__SimpleSelector__Group_1__0__Impl rule__SimpleSelector__Group_1__1 ;
    public final void rule__SimpleSelector__Group_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalLatteCSS.g:4357:1: ( rule__SimpleSelector__Group_1__0__Impl rule__SimpleSelector__Group_1__1 )
            // InternalLatteCSS.g:4358:2: rule__SimpleSelector__Group_1__0__Impl rule__SimpleSelector__Group_1__1
            {
            pushFollow(FOLLOW_10);
            rule__SimpleSelector__Group_1__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__SimpleSelector__Group_1__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__SimpleSelector__Group_1__0"


    // $ANTLR start "rule__SimpleSelector__Group_1__0__Impl"
    // InternalLatteCSS.g:4365:1: rule__SimpleSelector__Group_1__0__Impl : ( ( rule__SimpleSelector__IdAssignment_1_0 ) ) ;
    public final void rule__SimpleSelector__Group_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalLatteCSS.g:4369:1: ( ( ( rule__SimpleSelector__IdAssignment_1_0 ) ) )
            // InternalLatteCSS.g:4370:1: ( ( rule__SimpleSelector__IdAssignment_1_0 ) )
            {
            // InternalLatteCSS.g:4370:1: ( ( rule__SimpleSelector__IdAssignment_1_0 ) )
            // InternalLatteCSS.g:4371:1: ( rule__SimpleSelector__IdAssignment_1_0 )
            {
             before(grammarAccess.getSimpleSelectorAccess().getIdAssignment_1_0()); 
            // InternalLatteCSS.g:4372:1: ( rule__SimpleSelector__IdAssignment_1_0 )
            // InternalLatteCSS.g:4372:2: rule__SimpleSelector__IdAssignment_1_0
            {
            pushFollow(FOLLOW_2);
            rule__SimpleSelector__IdAssignment_1_0();

            state._fsp--;


            }

             after(grammarAccess.getSimpleSelectorAccess().getIdAssignment_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__SimpleSelector__Group_1__0__Impl"


    // $ANTLR start "rule__SimpleSelector__Group_1__1"
    // InternalLatteCSS.g:4382:1: rule__SimpleSelector__Group_1__1 : rule__SimpleSelector__Group_1__1__Impl ;
    public final void rule__SimpleSelector__Group_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalLatteCSS.g:4386:1: ( rule__SimpleSelector__Group_1__1__Impl )
            // InternalLatteCSS.g:4387:2: rule__SimpleSelector__Group_1__1__Impl
            {
            pushFollow(FOLLOW_2);
            rule__SimpleSelector__Group_1__1__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__SimpleSelector__Group_1__1"


    // $ANTLR start "rule__SimpleSelector__Group_1__1__Impl"
    // InternalLatteCSS.g:4393:1: rule__SimpleSelector__Group_1__1__Impl : ( ( rule__SimpleSelector__PseudoClassAssignment_1_1 )? ) ;
    public final void rule__SimpleSelector__Group_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalLatteCSS.g:4397:1: ( ( ( rule__SimpleSelector__PseudoClassAssignment_1_1 )? ) )
            // InternalLatteCSS.g:4398:1: ( ( rule__SimpleSelector__PseudoClassAssignment_1_1 )? )
            {
            // InternalLatteCSS.g:4398:1: ( ( rule__SimpleSelector__PseudoClassAssignment_1_1 )? )
            // InternalLatteCSS.g:4399:1: ( rule__SimpleSelector__PseudoClassAssignment_1_1 )?
            {
             before(grammarAccess.getSimpleSelectorAccess().getPseudoClassAssignment_1_1()); 
            // InternalLatteCSS.g:4400:1: ( rule__SimpleSelector__PseudoClassAssignment_1_1 )?
            int alt32=2;
            int LA32_0 = input.LA(1);

            if ( (LA32_0==279) ) {
                alt32=1;
            }
            switch (alt32) {
                case 1 :
                    // InternalLatteCSS.g:4400:2: rule__SimpleSelector__PseudoClassAssignment_1_1
                    {
                    pushFollow(FOLLOW_2);
                    rule__SimpleSelector__PseudoClassAssignment_1_1();

                    state._fsp--;


                    }
                    break;

            }

             after(grammarAccess.getSimpleSelectorAccess().getPseudoClassAssignment_1_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__SimpleSelector__Group_1__1__Impl"


    // $ANTLR start "rule__SimpleSelector__Group_2__0"
    // InternalLatteCSS.g:4414:1: rule__SimpleSelector__Group_2__0 : rule__SimpleSelector__Group_2__0__Impl rule__SimpleSelector__Group_2__1 ;
    public final void rule__SimpleSelector__Group_2__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalLatteCSS.g:4418:1: ( rule__SimpleSelector__Group_2__0__Impl rule__SimpleSelector__Group_2__1 )
            // InternalLatteCSS.g:4419:2: rule__SimpleSelector__Group_2__0__Impl rule__SimpleSelector__Group_2__1
            {
            pushFollow(FOLLOW_10);
            rule__SimpleSelector__Group_2__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__SimpleSelector__Group_2__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__SimpleSelector__Group_2__0"


    // $ANTLR start "rule__SimpleSelector__Group_2__0__Impl"
    // InternalLatteCSS.g:4426:1: rule__SimpleSelector__Group_2__0__Impl : ( ( rule__SimpleSelector__ClassAssignment_2_0 ) ) ;
    public final void rule__SimpleSelector__Group_2__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalLatteCSS.g:4430:1: ( ( ( rule__SimpleSelector__ClassAssignment_2_0 ) ) )
            // InternalLatteCSS.g:4431:1: ( ( rule__SimpleSelector__ClassAssignment_2_0 ) )
            {
            // InternalLatteCSS.g:4431:1: ( ( rule__SimpleSelector__ClassAssignment_2_0 ) )
            // InternalLatteCSS.g:4432:1: ( rule__SimpleSelector__ClassAssignment_2_0 )
            {
             before(grammarAccess.getSimpleSelectorAccess().getClassAssignment_2_0()); 
            // InternalLatteCSS.g:4433:1: ( rule__SimpleSelector__ClassAssignment_2_0 )
            // InternalLatteCSS.g:4433:2: rule__SimpleSelector__ClassAssignment_2_0
            {
            pushFollow(FOLLOW_2);
            rule__SimpleSelector__ClassAssignment_2_0();

            state._fsp--;


            }

             after(grammarAccess.getSimpleSelectorAccess().getClassAssignment_2_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__SimpleSelector__Group_2__0__Impl"


    // $ANTLR start "rule__SimpleSelector__Group_2__1"
    // InternalLatteCSS.g:4443:1: rule__SimpleSelector__Group_2__1 : rule__SimpleSelector__Group_2__1__Impl ;
    public final void rule__SimpleSelector__Group_2__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalLatteCSS.g:4447:1: ( rule__SimpleSelector__Group_2__1__Impl )
            // InternalLatteCSS.g:4448:2: rule__SimpleSelector__Group_2__1__Impl
            {
            pushFollow(FOLLOW_2);
            rule__SimpleSelector__Group_2__1__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__SimpleSelector__Group_2__1"


    // $ANTLR start "rule__SimpleSelector__Group_2__1__Impl"
    // InternalLatteCSS.g:4454:1: rule__SimpleSelector__Group_2__1__Impl : ( ( rule__SimpleSelector__PseudoClassAssignment_2_1 )? ) ;
    public final void rule__SimpleSelector__Group_2__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalLatteCSS.g:4458:1: ( ( ( rule__SimpleSelector__PseudoClassAssignment_2_1 )? ) )
            // InternalLatteCSS.g:4459:1: ( ( rule__SimpleSelector__PseudoClassAssignment_2_1 )? )
            {
            // InternalLatteCSS.g:4459:1: ( ( rule__SimpleSelector__PseudoClassAssignment_2_1 )? )
            // InternalLatteCSS.g:4460:1: ( rule__SimpleSelector__PseudoClassAssignment_2_1 )?
            {
             before(grammarAccess.getSimpleSelectorAccess().getPseudoClassAssignment_2_1()); 
            // InternalLatteCSS.g:4461:1: ( rule__SimpleSelector__PseudoClassAssignment_2_1 )?
            int alt33=2;
            int LA33_0 = input.LA(1);

            if ( (LA33_0==279) ) {
                alt33=1;
            }
            switch (alt33) {
                case 1 :
                    // InternalLatteCSS.g:4461:2: rule__SimpleSelector__PseudoClassAssignment_2_1
                    {
                    pushFollow(FOLLOW_2);
                    rule__SimpleSelector__PseudoClassAssignment_2_1();

                    state._fsp--;


                    }
                    break;

            }

             after(grammarAccess.getSimpleSelectorAccess().getPseudoClassAssignment_2_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__SimpleSelector__Group_2__1__Impl"


    // $ANTLR start "rule__IdSelector__Group__0"
    // InternalLatteCSS.g:4475:1: rule__IdSelector__Group__0 : rule__IdSelector__Group__0__Impl rule__IdSelector__Group__1 ;
    public final void rule__IdSelector__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalLatteCSS.g:4479:1: ( rule__IdSelector__Group__0__Impl rule__IdSelector__Group__1 )
            // InternalLatteCSS.g:4480:2: rule__IdSelector__Group__0__Impl rule__IdSelector__Group__1
            {
            pushFollow(FOLLOW_11);
            rule__IdSelector__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__IdSelector__Group__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__IdSelector__Group__0"


    // $ANTLR start "rule__IdSelector__Group__0__Impl"
    // InternalLatteCSS.g:4487:1: rule__IdSelector__Group__0__Impl : ( '#' ) ;
    public final void rule__IdSelector__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalLatteCSS.g:4491:1: ( ( '#' ) )
            // InternalLatteCSS.g:4492:1: ( '#' )
            {
            // InternalLatteCSS.g:4492:1: ( '#' )
            // InternalLatteCSS.g:4493:1: '#'
            {
             before(grammarAccess.getIdSelectorAccess().getNumberSignKeyword_0()); 
            match(input,277,FOLLOW_2); 
             after(grammarAccess.getIdSelectorAccess().getNumberSignKeyword_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__IdSelector__Group__0__Impl"


    // $ANTLR start "rule__IdSelector__Group__1"
    // InternalLatteCSS.g:4506:1: rule__IdSelector__Group__1 : rule__IdSelector__Group__1__Impl ;
    public final void rule__IdSelector__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalLatteCSS.g:4510:1: ( rule__IdSelector__Group__1__Impl )
            // InternalLatteCSS.g:4511:2: rule__IdSelector__Group__1__Impl
            {
            pushFollow(FOLLOW_2);
            rule__IdSelector__Group__1__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__IdSelector__Group__1"


    // $ANTLR start "rule__IdSelector__Group__1__Impl"
    // InternalLatteCSS.g:4517:1: rule__IdSelector__Group__1__Impl : ( ( rule__IdSelector__IdAssignment_1 ) ) ;
    public final void rule__IdSelector__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalLatteCSS.g:4521:1: ( ( ( rule__IdSelector__IdAssignment_1 ) ) )
            // InternalLatteCSS.g:4522:1: ( ( rule__IdSelector__IdAssignment_1 ) )
            {
            // InternalLatteCSS.g:4522:1: ( ( rule__IdSelector__IdAssignment_1 ) )
            // InternalLatteCSS.g:4523:1: ( rule__IdSelector__IdAssignment_1 )
            {
             before(grammarAccess.getIdSelectorAccess().getIdAssignment_1()); 
            // InternalLatteCSS.g:4524:1: ( rule__IdSelector__IdAssignment_1 )
            // InternalLatteCSS.g:4524:2: rule__IdSelector__IdAssignment_1
            {
            pushFollow(FOLLOW_2);
            rule__IdSelector__IdAssignment_1();

            state._fsp--;


            }

             after(grammarAccess.getIdSelectorAccess().getIdAssignment_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__IdSelector__Group__1__Impl"


    // $ANTLR start "rule__ClassSelector__Group__0"
    // InternalLatteCSS.g:4538:1: rule__ClassSelector__Group__0 : rule__ClassSelector__Group__0__Impl rule__ClassSelector__Group__1 ;
    public final void rule__ClassSelector__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalLatteCSS.g:4542:1: ( rule__ClassSelector__Group__0__Impl rule__ClassSelector__Group__1 )
            // InternalLatteCSS.g:4543:2: rule__ClassSelector__Group__0__Impl rule__ClassSelector__Group__1
            {
            pushFollow(FOLLOW_11);
            rule__ClassSelector__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__ClassSelector__Group__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ClassSelector__Group__0"


    // $ANTLR start "rule__ClassSelector__Group__0__Impl"
    // InternalLatteCSS.g:4550:1: rule__ClassSelector__Group__0__Impl : ( '.' ) ;
    public final void rule__ClassSelector__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalLatteCSS.g:4554:1: ( ( '.' ) )
            // InternalLatteCSS.g:4555:1: ( '.' )
            {
            // InternalLatteCSS.g:4555:1: ( '.' )
            // InternalLatteCSS.g:4556:1: '.'
            {
             before(grammarAccess.getClassSelectorAccess().getFullStopKeyword_0()); 
            match(input,278,FOLLOW_2); 
             after(grammarAccess.getClassSelectorAccess().getFullStopKeyword_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ClassSelector__Group__0__Impl"


    // $ANTLR start "rule__ClassSelector__Group__1"
    // InternalLatteCSS.g:4569:1: rule__ClassSelector__Group__1 : rule__ClassSelector__Group__1__Impl ;
    public final void rule__ClassSelector__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalLatteCSS.g:4573:1: ( rule__ClassSelector__Group__1__Impl )
            // InternalLatteCSS.g:4574:2: rule__ClassSelector__Group__1__Impl
            {
            pushFollow(FOLLOW_2);
            rule__ClassSelector__Group__1__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ClassSelector__Group__1"


    // $ANTLR start "rule__ClassSelector__Group__1__Impl"
    // InternalLatteCSS.g:4580:1: rule__ClassSelector__Group__1__Impl : ( ( rule__ClassSelector__ClassAssignment_1 ) ) ;
    public final void rule__ClassSelector__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalLatteCSS.g:4584:1: ( ( ( rule__ClassSelector__ClassAssignment_1 ) ) )
            // InternalLatteCSS.g:4585:1: ( ( rule__ClassSelector__ClassAssignment_1 ) )
            {
            // InternalLatteCSS.g:4585:1: ( ( rule__ClassSelector__ClassAssignment_1 ) )
            // InternalLatteCSS.g:4586:1: ( rule__ClassSelector__ClassAssignment_1 )
            {
             before(grammarAccess.getClassSelectorAccess().getClassAssignment_1()); 
            // InternalLatteCSS.g:4587:1: ( rule__ClassSelector__ClassAssignment_1 )
            // InternalLatteCSS.g:4587:2: rule__ClassSelector__ClassAssignment_1
            {
            pushFollow(FOLLOW_2);
            rule__ClassSelector__ClassAssignment_1();

            state._fsp--;


            }

             after(grammarAccess.getClassSelectorAccess().getClassAssignment_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ClassSelector__Group__1__Impl"


    // $ANTLR start "rule__PseudoClassSelector__Group__0"
    // InternalLatteCSS.g:4601:1: rule__PseudoClassSelector__Group__0 : rule__PseudoClassSelector__Group__0__Impl rule__PseudoClassSelector__Group__1 ;
    public final void rule__PseudoClassSelector__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalLatteCSS.g:4605:1: ( rule__PseudoClassSelector__Group__0__Impl rule__PseudoClassSelector__Group__1 )
            // InternalLatteCSS.g:4606:2: rule__PseudoClassSelector__Group__0__Impl rule__PseudoClassSelector__Group__1
            {
            pushFollow(FOLLOW_11);
            rule__PseudoClassSelector__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__PseudoClassSelector__Group__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__PseudoClassSelector__Group__0"


    // $ANTLR start "rule__PseudoClassSelector__Group__0__Impl"
    // InternalLatteCSS.g:4613:1: rule__PseudoClassSelector__Group__0__Impl : ( ':' ) ;
    public final void rule__PseudoClassSelector__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalLatteCSS.g:4617:1: ( ( ':' ) )
            // InternalLatteCSS.g:4618:1: ( ':' )
            {
            // InternalLatteCSS.g:4618:1: ( ':' )
            // InternalLatteCSS.g:4619:1: ':'
            {
             before(grammarAccess.getPseudoClassSelectorAccess().getColonKeyword_0()); 
            match(input,279,FOLLOW_2); 
             after(grammarAccess.getPseudoClassSelectorAccess().getColonKeyword_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__PseudoClassSelector__Group__0__Impl"


    // $ANTLR start "rule__PseudoClassSelector__Group__1"
    // InternalLatteCSS.g:4632:1: rule__PseudoClassSelector__Group__1 : rule__PseudoClassSelector__Group__1__Impl ;
    public final void rule__PseudoClassSelector__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalLatteCSS.g:4636:1: ( rule__PseudoClassSelector__Group__1__Impl )
            // InternalLatteCSS.g:4637:2: rule__PseudoClassSelector__Group__1__Impl
            {
            pushFollow(FOLLOW_2);
            rule__PseudoClassSelector__Group__1__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__PseudoClassSelector__Group__1"


    // $ANTLR start "rule__PseudoClassSelector__Group__1__Impl"
    // InternalLatteCSS.g:4643:1: rule__PseudoClassSelector__Group__1__Impl : ( ( rule__PseudoClassSelector__ValueAssignment_1 ) ) ;
    public final void rule__PseudoClassSelector__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalLatteCSS.g:4647:1: ( ( ( rule__PseudoClassSelector__ValueAssignment_1 ) ) )
            // InternalLatteCSS.g:4648:1: ( ( rule__PseudoClassSelector__ValueAssignment_1 ) )
            {
            // InternalLatteCSS.g:4648:1: ( ( rule__PseudoClassSelector__ValueAssignment_1 ) )
            // InternalLatteCSS.g:4649:1: ( rule__PseudoClassSelector__ValueAssignment_1 )
            {
             before(grammarAccess.getPseudoClassSelectorAccess().getValueAssignment_1()); 
            // InternalLatteCSS.g:4650:1: ( rule__PseudoClassSelector__ValueAssignment_1 )
            // InternalLatteCSS.g:4650:2: rule__PseudoClassSelector__ValueAssignment_1
            {
            pushFollow(FOLLOW_2);
            rule__PseudoClassSelector__ValueAssignment_1();

            state._fsp--;


            }

             after(grammarAccess.getPseudoClassSelectorAccess().getValueAssignment_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__PseudoClassSelector__Group__1__Impl"


    // $ANTLR start "rule__CSSProperty__Group__0"
    // InternalLatteCSS.g:4664:1: rule__CSSProperty__Group__0 : rule__CSSProperty__Group__0__Impl rule__CSSProperty__Group__1 ;
    public final void rule__CSSProperty__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalLatteCSS.g:4668:1: ( rule__CSSProperty__Group__0__Impl rule__CSSProperty__Group__1 )
            // InternalLatteCSS.g:4669:2: rule__CSSProperty__Group__0__Impl rule__CSSProperty__Group__1
            {
            pushFollow(FOLLOW_12);
            rule__CSSProperty__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__CSSProperty__Group__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__CSSProperty__Group__0"


    // $ANTLR start "rule__CSSProperty__Group__0__Impl"
    // InternalLatteCSS.g:4676:1: rule__CSSProperty__Group__0__Impl : ( ( rule__CSSProperty__Alternatives_0 ) ) ;
    public final void rule__CSSProperty__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalLatteCSS.g:4680:1: ( ( ( rule__CSSProperty__Alternatives_0 ) ) )
            // InternalLatteCSS.g:4681:1: ( ( rule__CSSProperty__Alternatives_0 ) )
            {
            // InternalLatteCSS.g:4681:1: ( ( rule__CSSProperty__Alternatives_0 ) )
            // InternalLatteCSS.g:4682:1: ( rule__CSSProperty__Alternatives_0 )
            {
             before(grammarAccess.getCSSPropertyAccess().getAlternatives_0()); 
            // InternalLatteCSS.g:4683:1: ( rule__CSSProperty__Alternatives_0 )
            // InternalLatteCSS.g:4683:2: rule__CSSProperty__Alternatives_0
            {
            pushFollow(FOLLOW_2);
            rule__CSSProperty__Alternatives_0();

            state._fsp--;


            }

             after(grammarAccess.getCSSPropertyAccess().getAlternatives_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__CSSProperty__Group__0__Impl"


    // $ANTLR start "rule__CSSProperty__Group__1"
    // InternalLatteCSS.g:4693:1: rule__CSSProperty__Group__1 : rule__CSSProperty__Group__1__Impl ;
    public final void rule__CSSProperty__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalLatteCSS.g:4697:1: ( rule__CSSProperty__Group__1__Impl )
            // InternalLatteCSS.g:4698:2: rule__CSSProperty__Group__1__Impl
            {
            pushFollow(FOLLOW_2);
            rule__CSSProperty__Group__1__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__CSSProperty__Group__1"


    // $ANTLR start "rule__CSSProperty__Group__1__Impl"
    // InternalLatteCSS.g:4704:1: rule__CSSProperty__Group__1__Impl : ( ';' ) ;
    public final void rule__CSSProperty__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalLatteCSS.g:4708:1: ( ( ';' ) )
            // InternalLatteCSS.g:4709:1: ( ';' )
            {
            // InternalLatteCSS.g:4709:1: ( ';' )
            // InternalLatteCSS.g:4710:1: ';'
            {
             before(grammarAccess.getCSSPropertyAccess().getSemicolonKeyword_1()); 
            match(input,280,FOLLOW_2); 
             after(grammarAccess.getCSSPropertyAccess().getSemicolonKeyword_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__CSSProperty__Group__1__Impl"


    // $ANTLR start "rule__FontFamilyProperty__Group__0"
    // InternalLatteCSS.g:4727:1: rule__FontFamilyProperty__Group__0 : rule__FontFamilyProperty__Group__0__Impl rule__FontFamilyProperty__Group__1 ;
    public final void rule__FontFamilyProperty__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalLatteCSS.g:4731:1: ( rule__FontFamilyProperty__Group__0__Impl rule__FontFamilyProperty__Group__1 )
            // InternalLatteCSS.g:4732:2: rule__FontFamilyProperty__Group__0__Impl rule__FontFamilyProperty__Group__1
            {
            pushFollow(FOLLOW_10);
            rule__FontFamilyProperty__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__FontFamilyProperty__Group__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__FontFamilyProperty__Group__0"


    // $ANTLR start "rule__FontFamilyProperty__Group__0__Impl"
    // InternalLatteCSS.g:4739:1: rule__FontFamilyProperty__Group__0__Impl : ( ( rule__FontFamilyProperty__PropertyAssignment_0 ) ) ;
    public final void rule__FontFamilyProperty__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalLatteCSS.g:4743:1: ( ( ( rule__FontFamilyProperty__PropertyAssignment_0 ) ) )
            // InternalLatteCSS.g:4744:1: ( ( rule__FontFamilyProperty__PropertyAssignment_0 ) )
            {
            // InternalLatteCSS.g:4744:1: ( ( rule__FontFamilyProperty__PropertyAssignment_0 ) )
            // InternalLatteCSS.g:4745:1: ( rule__FontFamilyProperty__PropertyAssignment_0 )
            {
             before(grammarAccess.getFontFamilyPropertyAccess().getPropertyAssignment_0()); 
            // InternalLatteCSS.g:4746:1: ( rule__FontFamilyProperty__PropertyAssignment_0 )
            // InternalLatteCSS.g:4746:2: rule__FontFamilyProperty__PropertyAssignment_0
            {
            pushFollow(FOLLOW_2);
            rule__FontFamilyProperty__PropertyAssignment_0();

            state._fsp--;


            }

             after(grammarAccess.getFontFamilyPropertyAccess().getPropertyAssignment_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__FontFamilyProperty__Group__0__Impl"


    // $ANTLR start "rule__FontFamilyProperty__Group__1"
    // InternalLatteCSS.g:4756:1: rule__FontFamilyProperty__Group__1 : rule__FontFamilyProperty__Group__1__Impl rule__FontFamilyProperty__Group__2 ;
    public final void rule__FontFamilyProperty__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalLatteCSS.g:4760:1: ( rule__FontFamilyProperty__Group__1__Impl rule__FontFamilyProperty__Group__2 )
            // InternalLatteCSS.g:4761:2: rule__FontFamilyProperty__Group__1__Impl rule__FontFamilyProperty__Group__2
            {
            pushFollow(FOLLOW_13);
            rule__FontFamilyProperty__Group__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__FontFamilyProperty__Group__2();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__FontFamilyProperty__Group__1"


    // $ANTLR start "rule__FontFamilyProperty__Group__1__Impl"
    // InternalLatteCSS.g:4768:1: rule__FontFamilyProperty__Group__1__Impl : ( ':' ) ;
    public final void rule__FontFamilyProperty__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalLatteCSS.g:4772:1: ( ( ':' ) )
            // InternalLatteCSS.g:4773:1: ( ':' )
            {
            // InternalLatteCSS.g:4773:1: ( ':' )
            // InternalLatteCSS.g:4774:1: ':'
            {
             before(grammarAccess.getFontFamilyPropertyAccess().getColonKeyword_1()); 
            match(input,279,FOLLOW_2); 
             after(grammarAccess.getFontFamilyPropertyAccess().getColonKeyword_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__FontFamilyProperty__Group__1__Impl"


    // $ANTLR start "rule__FontFamilyProperty__Group__2"
    // InternalLatteCSS.g:4787:1: rule__FontFamilyProperty__Group__2 : rule__FontFamilyProperty__Group__2__Impl ;
    public final void rule__FontFamilyProperty__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalLatteCSS.g:4791:1: ( rule__FontFamilyProperty__Group__2__Impl )
            // InternalLatteCSS.g:4792:2: rule__FontFamilyProperty__Group__2__Impl
            {
            pushFollow(FOLLOW_2);
            rule__FontFamilyProperty__Group__2__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__FontFamilyProperty__Group__2"


    // $ANTLR start "rule__FontFamilyProperty__Group__2__Impl"
    // InternalLatteCSS.g:4798:1: rule__FontFamilyProperty__Group__2__Impl : ( ( rule__FontFamilyProperty__ValueAssignment_2 ) ) ;
    public final void rule__FontFamilyProperty__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalLatteCSS.g:4802:1: ( ( ( rule__FontFamilyProperty__ValueAssignment_2 ) ) )
            // InternalLatteCSS.g:4803:1: ( ( rule__FontFamilyProperty__ValueAssignment_2 ) )
            {
            // InternalLatteCSS.g:4803:1: ( ( rule__FontFamilyProperty__ValueAssignment_2 ) )
            // InternalLatteCSS.g:4804:1: ( rule__FontFamilyProperty__ValueAssignment_2 )
            {
             before(grammarAccess.getFontFamilyPropertyAccess().getValueAssignment_2()); 
            // InternalLatteCSS.g:4805:1: ( rule__FontFamilyProperty__ValueAssignment_2 )
            // InternalLatteCSS.g:4805:2: rule__FontFamilyProperty__ValueAssignment_2
            {
            pushFollow(FOLLOW_2);
            rule__FontFamilyProperty__ValueAssignment_2();

            state._fsp--;


            }

             after(grammarAccess.getFontFamilyPropertyAccess().getValueAssignment_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__FontFamilyProperty__Group__2__Impl"


    // $ANTLR start "rule__FontStyleProperty__Group__0"
    // InternalLatteCSS.g:4821:1: rule__FontStyleProperty__Group__0 : rule__FontStyleProperty__Group__0__Impl rule__FontStyleProperty__Group__1 ;
    public final void rule__FontStyleProperty__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalLatteCSS.g:4825:1: ( rule__FontStyleProperty__Group__0__Impl rule__FontStyleProperty__Group__1 )
            // InternalLatteCSS.g:4826:2: rule__FontStyleProperty__Group__0__Impl rule__FontStyleProperty__Group__1
            {
            pushFollow(FOLLOW_10);
            rule__FontStyleProperty__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__FontStyleProperty__Group__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__FontStyleProperty__Group__0"


    // $ANTLR start "rule__FontStyleProperty__Group__0__Impl"
    // InternalLatteCSS.g:4833:1: rule__FontStyleProperty__Group__0__Impl : ( ( rule__FontStyleProperty__PropertyAssignment_0 ) ) ;
    public final void rule__FontStyleProperty__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalLatteCSS.g:4837:1: ( ( ( rule__FontStyleProperty__PropertyAssignment_0 ) ) )
            // InternalLatteCSS.g:4838:1: ( ( rule__FontStyleProperty__PropertyAssignment_0 ) )
            {
            // InternalLatteCSS.g:4838:1: ( ( rule__FontStyleProperty__PropertyAssignment_0 ) )
            // InternalLatteCSS.g:4839:1: ( rule__FontStyleProperty__PropertyAssignment_0 )
            {
             before(grammarAccess.getFontStylePropertyAccess().getPropertyAssignment_0()); 
            // InternalLatteCSS.g:4840:1: ( rule__FontStyleProperty__PropertyAssignment_0 )
            // InternalLatteCSS.g:4840:2: rule__FontStyleProperty__PropertyAssignment_0
            {
            pushFollow(FOLLOW_2);
            rule__FontStyleProperty__PropertyAssignment_0();

            state._fsp--;


            }

             after(grammarAccess.getFontStylePropertyAccess().getPropertyAssignment_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__FontStyleProperty__Group__0__Impl"


    // $ANTLR start "rule__FontStyleProperty__Group__1"
    // InternalLatteCSS.g:4850:1: rule__FontStyleProperty__Group__1 : rule__FontStyleProperty__Group__1__Impl rule__FontStyleProperty__Group__2 ;
    public final void rule__FontStyleProperty__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalLatteCSS.g:4854:1: ( rule__FontStyleProperty__Group__1__Impl rule__FontStyleProperty__Group__2 )
            // InternalLatteCSS.g:4855:2: rule__FontStyleProperty__Group__1__Impl rule__FontStyleProperty__Group__2
            {
            pushFollow(FOLLOW_14);
            rule__FontStyleProperty__Group__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__FontStyleProperty__Group__2();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__FontStyleProperty__Group__1"


    // $ANTLR start "rule__FontStyleProperty__Group__1__Impl"
    // InternalLatteCSS.g:4862:1: rule__FontStyleProperty__Group__1__Impl : ( ':' ) ;
    public final void rule__FontStyleProperty__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalLatteCSS.g:4866:1: ( ( ':' ) )
            // InternalLatteCSS.g:4867:1: ( ':' )
            {
            // InternalLatteCSS.g:4867:1: ( ':' )
            // InternalLatteCSS.g:4868:1: ':'
            {
             before(grammarAccess.getFontStylePropertyAccess().getColonKeyword_1()); 
            match(input,279,FOLLOW_2); 
             after(grammarAccess.getFontStylePropertyAccess().getColonKeyword_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__FontStyleProperty__Group__1__Impl"


    // $ANTLR start "rule__FontStyleProperty__Group__2"
    // InternalLatteCSS.g:4881:1: rule__FontStyleProperty__Group__2 : rule__FontStyleProperty__Group__2__Impl ;
    public final void rule__FontStyleProperty__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalLatteCSS.g:4885:1: ( rule__FontStyleProperty__Group__2__Impl )
            // InternalLatteCSS.g:4886:2: rule__FontStyleProperty__Group__2__Impl
            {
            pushFollow(FOLLOW_2);
            rule__FontStyleProperty__Group__2__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__FontStyleProperty__Group__2"


    // $ANTLR start "rule__FontStyleProperty__Group__2__Impl"
    // InternalLatteCSS.g:4892:1: rule__FontStyleProperty__Group__2__Impl : ( ( rule__FontStyleProperty__ValueAssignment_2 ) ) ;
    public final void rule__FontStyleProperty__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalLatteCSS.g:4896:1: ( ( ( rule__FontStyleProperty__ValueAssignment_2 ) ) )
            // InternalLatteCSS.g:4897:1: ( ( rule__FontStyleProperty__ValueAssignment_2 ) )
            {
            // InternalLatteCSS.g:4897:1: ( ( rule__FontStyleProperty__ValueAssignment_2 ) )
            // InternalLatteCSS.g:4898:1: ( rule__FontStyleProperty__ValueAssignment_2 )
            {
             before(grammarAccess.getFontStylePropertyAccess().getValueAssignment_2()); 
            // InternalLatteCSS.g:4899:1: ( rule__FontStyleProperty__ValueAssignment_2 )
            // InternalLatteCSS.g:4899:2: rule__FontStyleProperty__ValueAssignment_2
            {
            pushFollow(FOLLOW_2);
            rule__FontStyleProperty__ValueAssignment_2();

            state._fsp--;


            }

             after(grammarAccess.getFontStylePropertyAccess().getValueAssignment_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__FontStyleProperty__Group__2__Impl"


    // $ANTLR start "rule__ViewSizeProperty__Group__0"
    // InternalLatteCSS.g:4915:1: rule__ViewSizeProperty__Group__0 : rule__ViewSizeProperty__Group__0__Impl rule__ViewSizeProperty__Group__1 ;
    public final void rule__ViewSizeProperty__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalLatteCSS.g:4919:1: ( rule__ViewSizeProperty__Group__0__Impl rule__ViewSizeProperty__Group__1 )
            // InternalLatteCSS.g:4920:2: rule__ViewSizeProperty__Group__0__Impl rule__ViewSizeProperty__Group__1
            {
            pushFollow(FOLLOW_10);
            rule__ViewSizeProperty__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__ViewSizeProperty__Group__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ViewSizeProperty__Group__0"


    // $ANTLR start "rule__ViewSizeProperty__Group__0__Impl"
    // InternalLatteCSS.g:4927:1: rule__ViewSizeProperty__Group__0__Impl : ( ( rule__ViewSizeProperty__PropertyAssignment_0 ) ) ;
    public final void rule__ViewSizeProperty__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalLatteCSS.g:4931:1: ( ( ( rule__ViewSizeProperty__PropertyAssignment_0 ) ) )
            // InternalLatteCSS.g:4932:1: ( ( rule__ViewSizeProperty__PropertyAssignment_0 ) )
            {
            // InternalLatteCSS.g:4932:1: ( ( rule__ViewSizeProperty__PropertyAssignment_0 ) )
            // InternalLatteCSS.g:4933:1: ( rule__ViewSizeProperty__PropertyAssignment_0 )
            {
             before(grammarAccess.getViewSizePropertyAccess().getPropertyAssignment_0()); 
            // InternalLatteCSS.g:4934:1: ( rule__ViewSizeProperty__PropertyAssignment_0 )
            // InternalLatteCSS.g:4934:2: rule__ViewSizeProperty__PropertyAssignment_0
            {
            pushFollow(FOLLOW_2);
            rule__ViewSizeProperty__PropertyAssignment_0();

            state._fsp--;


            }

             after(grammarAccess.getViewSizePropertyAccess().getPropertyAssignment_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ViewSizeProperty__Group__0__Impl"


    // $ANTLR start "rule__ViewSizeProperty__Group__1"
    // InternalLatteCSS.g:4944:1: rule__ViewSizeProperty__Group__1 : rule__ViewSizeProperty__Group__1__Impl rule__ViewSizeProperty__Group__2 ;
    public final void rule__ViewSizeProperty__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalLatteCSS.g:4948:1: ( rule__ViewSizeProperty__Group__1__Impl rule__ViewSizeProperty__Group__2 )
            // InternalLatteCSS.g:4949:2: rule__ViewSizeProperty__Group__1__Impl rule__ViewSizeProperty__Group__2
            {
            pushFollow(FOLLOW_15);
            rule__ViewSizeProperty__Group__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__ViewSizeProperty__Group__2();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ViewSizeProperty__Group__1"


    // $ANTLR start "rule__ViewSizeProperty__Group__1__Impl"
    // InternalLatteCSS.g:4956:1: rule__ViewSizeProperty__Group__1__Impl : ( ':' ) ;
    public final void rule__ViewSizeProperty__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalLatteCSS.g:4960:1: ( ( ':' ) )
            // InternalLatteCSS.g:4961:1: ( ':' )
            {
            // InternalLatteCSS.g:4961:1: ( ':' )
            // InternalLatteCSS.g:4962:1: ':'
            {
             before(grammarAccess.getViewSizePropertyAccess().getColonKeyword_1()); 
            match(input,279,FOLLOW_2); 
             after(grammarAccess.getViewSizePropertyAccess().getColonKeyword_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ViewSizeProperty__Group__1__Impl"


    // $ANTLR start "rule__ViewSizeProperty__Group__2"
    // InternalLatteCSS.g:4975:1: rule__ViewSizeProperty__Group__2 : rule__ViewSizeProperty__Group__2__Impl ;
    public final void rule__ViewSizeProperty__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalLatteCSS.g:4979:1: ( rule__ViewSizeProperty__Group__2__Impl )
            // InternalLatteCSS.g:4980:2: rule__ViewSizeProperty__Group__2__Impl
            {
            pushFollow(FOLLOW_2);
            rule__ViewSizeProperty__Group__2__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ViewSizeProperty__Group__2"


    // $ANTLR start "rule__ViewSizeProperty__Group__2__Impl"
    // InternalLatteCSS.g:4986:1: rule__ViewSizeProperty__Group__2__Impl : ( ( rule__ViewSizeProperty__ValueAssignment_2 ) ) ;
    public final void rule__ViewSizeProperty__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalLatteCSS.g:4990:1: ( ( ( rule__ViewSizeProperty__ValueAssignment_2 ) ) )
            // InternalLatteCSS.g:4991:1: ( ( rule__ViewSizeProperty__ValueAssignment_2 ) )
            {
            // InternalLatteCSS.g:4991:1: ( ( rule__ViewSizeProperty__ValueAssignment_2 ) )
            // InternalLatteCSS.g:4992:1: ( rule__ViewSizeProperty__ValueAssignment_2 )
            {
             before(grammarAccess.getViewSizePropertyAccess().getValueAssignment_2()); 
            // InternalLatteCSS.g:4993:1: ( rule__ViewSizeProperty__ValueAssignment_2 )
            // InternalLatteCSS.g:4993:2: rule__ViewSizeProperty__ValueAssignment_2
            {
            pushFollow(FOLLOW_2);
            rule__ViewSizeProperty__ValueAssignment_2();

            state._fsp--;


            }

             after(grammarAccess.getViewSizePropertyAccess().getValueAssignment_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ViewSizeProperty__Group__2__Impl"


    // $ANTLR start "rule__ShorthandSizeProperty__Group__0"
    // InternalLatteCSS.g:5009:1: rule__ShorthandSizeProperty__Group__0 : rule__ShorthandSizeProperty__Group__0__Impl rule__ShorthandSizeProperty__Group__1 ;
    public final void rule__ShorthandSizeProperty__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalLatteCSS.g:5013:1: ( rule__ShorthandSizeProperty__Group__0__Impl rule__ShorthandSizeProperty__Group__1 )
            // InternalLatteCSS.g:5014:2: rule__ShorthandSizeProperty__Group__0__Impl rule__ShorthandSizeProperty__Group__1
            {
            pushFollow(FOLLOW_10);
            rule__ShorthandSizeProperty__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__ShorthandSizeProperty__Group__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ShorthandSizeProperty__Group__0"


    // $ANTLR start "rule__ShorthandSizeProperty__Group__0__Impl"
    // InternalLatteCSS.g:5021:1: rule__ShorthandSizeProperty__Group__0__Impl : ( ( rule__ShorthandSizeProperty__PropertyAssignment_0 ) ) ;
    public final void rule__ShorthandSizeProperty__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalLatteCSS.g:5025:1: ( ( ( rule__ShorthandSizeProperty__PropertyAssignment_0 ) ) )
            // InternalLatteCSS.g:5026:1: ( ( rule__ShorthandSizeProperty__PropertyAssignment_0 ) )
            {
            // InternalLatteCSS.g:5026:1: ( ( rule__ShorthandSizeProperty__PropertyAssignment_0 ) )
            // InternalLatteCSS.g:5027:1: ( rule__ShorthandSizeProperty__PropertyAssignment_0 )
            {
             before(grammarAccess.getShorthandSizePropertyAccess().getPropertyAssignment_0()); 
            // InternalLatteCSS.g:5028:1: ( rule__ShorthandSizeProperty__PropertyAssignment_0 )
            // InternalLatteCSS.g:5028:2: rule__ShorthandSizeProperty__PropertyAssignment_0
            {
            pushFollow(FOLLOW_2);
            rule__ShorthandSizeProperty__PropertyAssignment_0();

            state._fsp--;


            }

             after(grammarAccess.getShorthandSizePropertyAccess().getPropertyAssignment_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ShorthandSizeProperty__Group__0__Impl"


    // $ANTLR start "rule__ShorthandSizeProperty__Group__1"
    // InternalLatteCSS.g:5038:1: rule__ShorthandSizeProperty__Group__1 : rule__ShorthandSizeProperty__Group__1__Impl rule__ShorthandSizeProperty__Group__2 ;
    public final void rule__ShorthandSizeProperty__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalLatteCSS.g:5042:1: ( rule__ShorthandSizeProperty__Group__1__Impl rule__ShorthandSizeProperty__Group__2 )
            // InternalLatteCSS.g:5043:2: rule__ShorthandSizeProperty__Group__1__Impl rule__ShorthandSizeProperty__Group__2
            {
            pushFollow(FOLLOW_16);
            rule__ShorthandSizeProperty__Group__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__ShorthandSizeProperty__Group__2();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ShorthandSizeProperty__Group__1"


    // $ANTLR start "rule__ShorthandSizeProperty__Group__1__Impl"
    // InternalLatteCSS.g:5050:1: rule__ShorthandSizeProperty__Group__1__Impl : ( ':' ) ;
    public final void rule__ShorthandSizeProperty__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalLatteCSS.g:5054:1: ( ( ':' ) )
            // InternalLatteCSS.g:5055:1: ( ':' )
            {
            // InternalLatteCSS.g:5055:1: ( ':' )
            // InternalLatteCSS.g:5056:1: ':'
            {
             before(grammarAccess.getShorthandSizePropertyAccess().getColonKeyword_1()); 
            match(input,279,FOLLOW_2); 
             after(grammarAccess.getShorthandSizePropertyAccess().getColonKeyword_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ShorthandSizeProperty__Group__1__Impl"


    // $ANTLR start "rule__ShorthandSizeProperty__Group__2"
    // InternalLatteCSS.g:5069:1: rule__ShorthandSizeProperty__Group__2 : rule__ShorthandSizeProperty__Group__2__Impl ;
    public final void rule__ShorthandSizeProperty__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalLatteCSS.g:5073:1: ( rule__ShorthandSizeProperty__Group__2__Impl )
            // InternalLatteCSS.g:5074:2: rule__ShorthandSizeProperty__Group__2__Impl
            {
            pushFollow(FOLLOW_2);
            rule__ShorthandSizeProperty__Group__2__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ShorthandSizeProperty__Group__2"


    // $ANTLR start "rule__ShorthandSizeProperty__Group__2__Impl"
    // InternalLatteCSS.g:5080:1: rule__ShorthandSizeProperty__Group__2__Impl : ( ( ( rule__ShorthandSizeProperty__ValuesAssignment_2 ) ) ( ( rule__ShorthandSizeProperty__ValuesAssignment_2 )* ) ) ;
    public final void rule__ShorthandSizeProperty__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalLatteCSS.g:5084:1: ( ( ( ( rule__ShorthandSizeProperty__ValuesAssignment_2 ) ) ( ( rule__ShorthandSizeProperty__ValuesAssignment_2 )* ) ) )
            // InternalLatteCSS.g:5085:1: ( ( ( rule__ShorthandSizeProperty__ValuesAssignment_2 ) ) ( ( rule__ShorthandSizeProperty__ValuesAssignment_2 )* ) )
            {
            // InternalLatteCSS.g:5085:1: ( ( ( rule__ShorthandSizeProperty__ValuesAssignment_2 ) ) ( ( rule__ShorthandSizeProperty__ValuesAssignment_2 )* ) )
            // InternalLatteCSS.g:5086:1: ( ( rule__ShorthandSizeProperty__ValuesAssignment_2 ) ) ( ( rule__ShorthandSizeProperty__ValuesAssignment_2 )* )
            {
            // InternalLatteCSS.g:5086:1: ( ( rule__ShorthandSizeProperty__ValuesAssignment_2 ) )
            // InternalLatteCSS.g:5087:1: ( rule__ShorthandSizeProperty__ValuesAssignment_2 )
            {
             before(grammarAccess.getShorthandSizePropertyAccess().getValuesAssignment_2()); 
            // InternalLatteCSS.g:5088:1: ( rule__ShorthandSizeProperty__ValuesAssignment_2 )
            // InternalLatteCSS.g:5088:2: rule__ShorthandSizeProperty__ValuesAssignment_2
            {
            pushFollow(FOLLOW_17);
            rule__ShorthandSizeProperty__ValuesAssignment_2();

            state._fsp--;


            }

             after(grammarAccess.getShorthandSizePropertyAccess().getValuesAssignment_2()); 

            }

            // InternalLatteCSS.g:5091:1: ( ( rule__ShorthandSizeProperty__ValuesAssignment_2 )* )
            // InternalLatteCSS.g:5092:1: ( rule__ShorthandSizeProperty__ValuesAssignment_2 )*
            {
             before(grammarAccess.getShorthandSizePropertyAccess().getValuesAssignment_2()); 
            // InternalLatteCSS.g:5093:1: ( rule__ShorthandSizeProperty__ValuesAssignment_2 )*
            loop34:
            do {
                int alt34=2;
                int LA34_0 = input.LA(1);

                if ( ((LA34_0>=RULE_INT && LA34_0<=RULE_REAL)) ) {
                    alt34=1;
                }


                switch (alt34) {
            	case 1 :
            	    // InternalLatteCSS.g:5093:2: rule__ShorthandSizeProperty__ValuesAssignment_2
            	    {
            	    pushFollow(FOLLOW_17);
            	    rule__ShorthandSizeProperty__ValuesAssignment_2();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop34;
                }
            } while (true);

             after(grammarAccess.getShorthandSizePropertyAccess().getValuesAssignment_2()); 

            }


            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ShorthandSizeProperty__Group__2__Impl"


    // $ANTLR start "rule__BorderRadiusProperty__Group__0"
    // InternalLatteCSS.g:5110:1: rule__BorderRadiusProperty__Group__0 : rule__BorderRadiusProperty__Group__0__Impl rule__BorderRadiusProperty__Group__1 ;
    public final void rule__BorderRadiusProperty__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalLatteCSS.g:5114:1: ( rule__BorderRadiusProperty__Group__0__Impl rule__BorderRadiusProperty__Group__1 )
            // InternalLatteCSS.g:5115:2: rule__BorderRadiusProperty__Group__0__Impl rule__BorderRadiusProperty__Group__1
            {
            pushFollow(FOLLOW_10);
            rule__BorderRadiusProperty__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__BorderRadiusProperty__Group__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__BorderRadiusProperty__Group__0"


    // $ANTLR start "rule__BorderRadiusProperty__Group__0__Impl"
    // InternalLatteCSS.g:5122:1: rule__BorderRadiusProperty__Group__0__Impl : ( ( rule__BorderRadiusProperty__PropertyAssignment_0 ) ) ;
    public final void rule__BorderRadiusProperty__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalLatteCSS.g:5126:1: ( ( ( rule__BorderRadiusProperty__PropertyAssignment_0 ) ) )
            // InternalLatteCSS.g:5127:1: ( ( rule__BorderRadiusProperty__PropertyAssignment_0 ) )
            {
            // InternalLatteCSS.g:5127:1: ( ( rule__BorderRadiusProperty__PropertyAssignment_0 ) )
            // InternalLatteCSS.g:5128:1: ( rule__BorderRadiusProperty__PropertyAssignment_0 )
            {
             before(grammarAccess.getBorderRadiusPropertyAccess().getPropertyAssignment_0()); 
            // InternalLatteCSS.g:5129:1: ( rule__BorderRadiusProperty__PropertyAssignment_0 )
            // InternalLatteCSS.g:5129:2: rule__BorderRadiusProperty__PropertyAssignment_0
            {
            pushFollow(FOLLOW_2);
            rule__BorderRadiusProperty__PropertyAssignment_0();

            state._fsp--;


            }

             after(grammarAccess.getBorderRadiusPropertyAccess().getPropertyAssignment_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__BorderRadiusProperty__Group__0__Impl"


    // $ANTLR start "rule__BorderRadiusProperty__Group__1"
    // InternalLatteCSS.g:5139:1: rule__BorderRadiusProperty__Group__1 : rule__BorderRadiusProperty__Group__1__Impl rule__BorderRadiusProperty__Group__2 ;
    public final void rule__BorderRadiusProperty__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalLatteCSS.g:5143:1: ( rule__BorderRadiusProperty__Group__1__Impl rule__BorderRadiusProperty__Group__2 )
            // InternalLatteCSS.g:5144:2: rule__BorderRadiusProperty__Group__1__Impl rule__BorderRadiusProperty__Group__2
            {
            pushFollow(FOLLOW_16);
            rule__BorderRadiusProperty__Group__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__BorderRadiusProperty__Group__2();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__BorderRadiusProperty__Group__1"


    // $ANTLR start "rule__BorderRadiusProperty__Group__1__Impl"
    // InternalLatteCSS.g:5151:1: rule__BorderRadiusProperty__Group__1__Impl : ( ':' ) ;
    public final void rule__BorderRadiusProperty__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalLatteCSS.g:5155:1: ( ( ':' ) )
            // InternalLatteCSS.g:5156:1: ( ':' )
            {
            // InternalLatteCSS.g:5156:1: ( ':' )
            // InternalLatteCSS.g:5157:1: ':'
            {
             before(grammarAccess.getBorderRadiusPropertyAccess().getColonKeyword_1()); 
            match(input,279,FOLLOW_2); 
             after(grammarAccess.getBorderRadiusPropertyAccess().getColonKeyword_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__BorderRadiusProperty__Group__1__Impl"


    // $ANTLR start "rule__BorderRadiusProperty__Group__2"
    // InternalLatteCSS.g:5170:1: rule__BorderRadiusProperty__Group__2 : rule__BorderRadiusProperty__Group__2__Impl ;
    public final void rule__BorderRadiusProperty__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalLatteCSS.g:5174:1: ( rule__BorderRadiusProperty__Group__2__Impl )
            // InternalLatteCSS.g:5175:2: rule__BorderRadiusProperty__Group__2__Impl
            {
            pushFollow(FOLLOW_2);
            rule__BorderRadiusProperty__Group__2__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__BorderRadiusProperty__Group__2"


    // $ANTLR start "rule__BorderRadiusProperty__Group__2__Impl"
    // InternalLatteCSS.g:5181:1: rule__BorderRadiusProperty__Group__2__Impl : ( ( ( rule__BorderRadiusProperty__ValuesAssignment_2 ) ) ( ( rule__BorderRadiusProperty__ValuesAssignment_2 )* ) ) ;
    public final void rule__BorderRadiusProperty__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalLatteCSS.g:5185:1: ( ( ( ( rule__BorderRadiusProperty__ValuesAssignment_2 ) ) ( ( rule__BorderRadiusProperty__ValuesAssignment_2 )* ) ) )
            // InternalLatteCSS.g:5186:1: ( ( ( rule__BorderRadiusProperty__ValuesAssignment_2 ) ) ( ( rule__BorderRadiusProperty__ValuesAssignment_2 )* ) )
            {
            // InternalLatteCSS.g:5186:1: ( ( ( rule__BorderRadiusProperty__ValuesAssignment_2 ) ) ( ( rule__BorderRadiusProperty__ValuesAssignment_2 )* ) )
            // InternalLatteCSS.g:5187:1: ( ( rule__BorderRadiusProperty__ValuesAssignment_2 ) ) ( ( rule__BorderRadiusProperty__ValuesAssignment_2 )* )
            {
            // InternalLatteCSS.g:5187:1: ( ( rule__BorderRadiusProperty__ValuesAssignment_2 ) )
            // InternalLatteCSS.g:5188:1: ( rule__BorderRadiusProperty__ValuesAssignment_2 )
            {
             before(grammarAccess.getBorderRadiusPropertyAccess().getValuesAssignment_2()); 
            // InternalLatteCSS.g:5189:1: ( rule__BorderRadiusProperty__ValuesAssignment_2 )
            // InternalLatteCSS.g:5189:2: rule__BorderRadiusProperty__ValuesAssignment_2
            {
            pushFollow(FOLLOW_17);
            rule__BorderRadiusProperty__ValuesAssignment_2();

            state._fsp--;


            }

             after(grammarAccess.getBorderRadiusPropertyAccess().getValuesAssignment_2()); 

            }

            // InternalLatteCSS.g:5192:1: ( ( rule__BorderRadiusProperty__ValuesAssignment_2 )* )
            // InternalLatteCSS.g:5193:1: ( rule__BorderRadiusProperty__ValuesAssignment_2 )*
            {
             before(grammarAccess.getBorderRadiusPropertyAccess().getValuesAssignment_2()); 
            // InternalLatteCSS.g:5194:1: ( rule__BorderRadiusProperty__ValuesAssignment_2 )*
            loop35:
            do {
                int alt35=2;
                int LA35_0 = input.LA(1);

                if ( ((LA35_0>=RULE_INT && LA35_0<=RULE_REAL)) ) {
                    alt35=1;
                }


                switch (alt35) {
            	case 1 :
            	    // InternalLatteCSS.g:5194:2: rule__BorderRadiusProperty__ValuesAssignment_2
            	    {
            	    pushFollow(FOLLOW_17);
            	    rule__BorderRadiusProperty__ValuesAssignment_2();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop35;
                }
            } while (true);

             after(grammarAccess.getBorderRadiusPropertyAccess().getValuesAssignment_2()); 

            }


            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__BorderRadiusProperty__Group__2__Impl"


    // $ANTLR start "rule__SizeProperty__Group__0"
    // InternalLatteCSS.g:5211:1: rule__SizeProperty__Group__0 : rule__SizeProperty__Group__0__Impl rule__SizeProperty__Group__1 ;
    public final void rule__SizeProperty__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalLatteCSS.g:5215:1: ( rule__SizeProperty__Group__0__Impl rule__SizeProperty__Group__1 )
            // InternalLatteCSS.g:5216:2: rule__SizeProperty__Group__0__Impl rule__SizeProperty__Group__1
            {
            pushFollow(FOLLOW_10);
            rule__SizeProperty__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__SizeProperty__Group__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__SizeProperty__Group__0"


    // $ANTLR start "rule__SizeProperty__Group__0__Impl"
    // InternalLatteCSS.g:5223:1: rule__SizeProperty__Group__0__Impl : ( ( rule__SizeProperty__PropertyAssignment_0 ) ) ;
    public final void rule__SizeProperty__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalLatteCSS.g:5227:1: ( ( ( rule__SizeProperty__PropertyAssignment_0 ) ) )
            // InternalLatteCSS.g:5228:1: ( ( rule__SizeProperty__PropertyAssignment_0 ) )
            {
            // InternalLatteCSS.g:5228:1: ( ( rule__SizeProperty__PropertyAssignment_0 ) )
            // InternalLatteCSS.g:5229:1: ( rule__SizeProperty__PropertyAssignment_0 )
            {
             before(grammarAccess.getSizePropertyAccess().getPropertyAssignment_0()); 
            // InternalLatteCSS.g:5230:1: ( rule__SizeProperty__PropertyAssignment_0 )
            // InternalLatteCSS.g:5230:2: rule__SizeProperty__PropertyAssignment_0
            {
            pushFollow(FOLLOW_2);
            rule__SizeProperty__PropertyAssignment_0();

            state._fsp--;


            }

             after(grammarAccess.getSizePropertyAccess().getPropertyAssignment_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__SizeProperty__Group__0__Impl"


    // $ANTLR start "rule__SizeProperty__Group__1"
    // InternalLatteCSS.g:5240:1: rule__SizeProperty__Group__1 : rule__SizeProperty__Group__1__Impl rule__SizeProperty__Group__2 ;
    public final void rule__SizeProperty__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalLatteCSS.g:5244:1: ( rule__SizeProperty__Group__1__Impl rule__SizeProperty__Group__2 )
            // InternalLatteCSS.g:5245:2: rule__SizeProperty__Group__1__Impl rule__SizeProperty__Group__2
            {
            pushFollow(FOLLOW_16);
            rule__SizeProperty__Group__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__SizeProperty__Group__2();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__SizeProperty__Group__1"


    // $ANTLR start "rule__SizeProperty__Group__1__Impl"
    // InternalLatteCSS.g:5252:1: rule__SizeProperty__Group__1__Impl : ( ':' ) ;
    public final void rule__SizeProperty__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalLatteCSS.g:5256:1: ( ( ':' ) )
            // InternalLatteCSS.g:5257:1: ( ':' )
            {
            // InternalLatteCSS.g:5257:1: ( ':' )
            // InternalLatteCSS.g:5258:1: ':'
            {
             before(grammarAccess.getSizePropertyAccess().getColonKeyword_1()); 
            match(input,279,FOLLOW_2); 
             after(grammarAccess.getSizePropertyAccess().getColonKeyword_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__SizeProperty__Group__1__Impl"


    // $ANTLR start "rule__SizeProperty__Group__2"
    // InternalLatteCSS.g:5271:1: rule__SizeProperty__Group__2 : rule__SizeProperty__Group__2__Impl ;
    public final void rule__SizeProperty__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalLatteCSS.g:5275:1: ( rule__SizeProperty__Group__2__Impl )
            // InternalLatteCSS.g:5276:2: rule__SizeProperty__Group__2__Impl
            {
            pushFollow(FOLLOW_2);
            rule__SizeProperty__Group__2__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__SizeProperty__Group__2"


    // $ANTLR start "rule__SizeProperty__Group__2__Impl"
    // InternalLatteCSS.g:5282:1: rule__SizeProperty__Group__2__Impl : ( ( rule__SizeProperty__ValueAssignment_2 ) ) ;
    public final void rule__SizeProperty__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalLatteCSS.g:5286:1: ( ( ( rule__SizeProperty__ValueAssignment_2 ) ) )
            // InternalLatteCSS.g:5287:1: ( ( rule__SizeProperty__ValueAssignment_2 ) )
            {
            // InternalLatteCSS.g:5287:1: ( ( rule__SizeProperty__ValueAssignment_2 ) )
            // InternalLatteCSS.g:5288:1: ( rule__SizeProperty__ValueAssignment_2 )
            {
             before(grammarAccess.getSizePropertyAccess().getValueAssignment_2()); 
            // InternalLatteCSS.g:5289:1: ( rule__SizeProperty__ValueAssignment_2 )
            // InternalLatteCSS.g:5289:2: rule__SizeProperty__ValueAssignment_2
            {
            pushFollow(FOLLOW_2);
            rule__SizeProperty__ValueAssignment_2();

            state._fsp--;


            }

             after(grammarAccess.getSizePropertyAccess().getValueAssignment_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__SizeProperty__Group__2__Impl"


    // $ANTLR start "rule__PaintProperty__Group__0"
    // InternalLatteCSS.g:5305:1: rule__PaintProperty__Group__0 : rule__PaintProperty__Group__0__Impl rule__PaintProperty__Group__1 ;
    public final void rule__PaintProperty__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalLatteCSS.g:5309:1: ( rule__PaintProperty__Group__0__Impl rule__PaintProperty__Group__1 )
            // InternalLatteCSS.g:5310:2: rule__PaintProperty__Group__0__Impl rule__PaintProperty__Group__1
            {
            pushFollow(FOLLOW_10);
            rule__PaintProperty__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__PaintProperty__Group__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__PaintProperty__Group__0"


    // $ANTLR start "rule__PaintProperty__Group__0__Impl"
    // InternalLatteCSS.g:5317:1: rule__PaintProperty__Group__0__Impl : ( ( rule__PaintProperty__PropertyAssignment_0 ) ) ;
    public final void rule__PaintProperty__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalLatteCSS.g:5321:1: ( ( ( rule__PaintProperty__PropertyAssignment_0 ) ) )
            // InternalLatteCSS.g:5322:1: ( ( rule__PaintProperty__PropertyAssignment_0 ) )
            {
            // InternalLatteCSS.g:5322:1: ( ( rule__PaintProperty__PropertyAssignment_0 ) )
            // InternalLatteCSS.g:5323:1: ( rule__PaintProperty__PropertyAssignment_0 )
            {
             before(grammarAccess.getPaintPropertyAccess().getPropertyAssignment_0()); 
            // InternalLatteCSS.g:5324:1: ( rule__PaintProperty__PropertyAssignment_0 )
            // InternalLatteCSS.g:5324:2: rule__PaintProperty__PropertyAssignment_0
            {
            pushFollow(FOLLOW_2);
            rule__PaintProperty__PropertyAssignment_0();

            state._fsp--;


            }

             after(grammarAccess.getPaintPropertyAccess().getPropertyAssignment_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__PaintProperty__Group__0__Impl"


    // $ANTLR start "rule__PaintProperty__Group__1"
    // InternalLatteCSS.g:5334:1: rule__PaintProperty__Group__1 : rule__PaintProperty__Group__1__Impl rule__PaintProperty__Group__2 ;
    public final void rule__PaintProperty__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalLatteCSS.g:5338:1: ( rule__PaintProperty__Group__1__Impl rule__PaintProperty__Group__2 )
            // InternalLatteCSS.g:5339:2: rule__PaintProperty__Group__1__Impl rule__PaintProperty__Group__2
            {
            pushFollow(FOLLOW_18);
            rule__PaintProperty__Group__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__PaintProperty__Group__2();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__PaintProperty__Group__1"


    // $ANTLR start "rule__PaintProperty__Group__1__Impl"
    // InternalLatteCSS.g:5346:1: rule__PaintProperty__Group__1__Impl : ( ':' ) ;
    public final void rule__PaintProperty__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalLatteCSS.g:5350:1: ( ( ':' ) )
            // InternalLatteCSS.g:5351:1: ( ':' )
            {
            // InternalLatteCSS.g:5351:1: ( ':' )
            // InternalLatteCSS.g:5352:1: ':'
            {
             before(grammarAccess.getPaintPropertyAccess().getColonKeyword_1()); 
            match(input,279,FOLLOW_2); 
             after(grammarAccess.getPaintPropertyAccess().getColonKeyword_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__PaintProperty__Group__1__Impl"


    // $ANTLR start "rule__PaintProperty__Group__2"
    // InternalLatteCSS.g:5365:1: rule__PaintProperty__Group__2 : rule__PaintProperty__Group__2__Impl ;
    public final void rule__PaintProperty__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalLatteCSS.g:5369:1: ( rule__PaintProperty__Group__2__Impl )
            // InternalLatteCSS.g:5370:2: rule__PaintProperty__Group__2__Impl
            {
            pushFollow(FOLLOW_2);
            rule__PaintProperty__Group__2__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__PaintProperty__Group__2"


    // $ANTLR start "rule__PaintProperty__Group__2__Impl"
    // InternalLatteCSS.g:5376:1: rule__PaintProperty__Group__2__Impl : ( ( rule__PaintProperty__ValueAssignment_2 ) ) ;
    public final void rule__PaintProperty__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalLatteCSS.g:5380:1: ( ( ( rule__PaintProperty__ValueAssignment_2 ) ) )
            // InternalLatteCSS.g:5381:1: ( ( rule__PaintProperty__ValueAssignment_2 ) )
            {
            // InternalLatteCSS.g:5381:1: ( ( rule__PaintProperty__ValueAssignment_2 ) )
            // InternalLatteCSS.g:5382:1: ( rule__PaintProperty__ValueAssignment_2 )
            {
             before(grammarAccess.getPaintPropertyAccess().getValueAssignment_2()); 
            // InternalLatteCSS.g:5383:1: ( rule__PaintProperty__ValueAssignment_2 )
            // InternalLatteCSS.g:5383:2: rule__PaintProperty__ValueAssignment_2
            {
            pushFollow(FOLLOW_2);
            rule__PaintProperty__ValueAssignment_2();

            state._fsp--;


            }

             after(grammarAccess.getPaintPropertyAccess().getValueAssignment_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__PaintProperty__Group__2__Impl"


    // $ANTLR start "rule__TransitionProperty__Group__0"
    // InternalLatteCSS.g:5399:1: rule__TransitionProperty__Group__0 : rule__TransitionProperty__Group__0__Impl rule__TransitionProperty__Group__1 ;
    public final void rule__TransitionProperty__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalLatteCSS.g:5403:1: ( rule__TransitionProperty__Group__0__Impl rule__TransitionProperty__Group__1 )
            // InternalLatteCSS.g:5404:2: rule__TransitionProperty__Group__0__Impl rule__TransitionProperty__Group__1
            {
            pushFollow(FOLLOW_10);
            rule__TransitionProperty__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__TransitionProperty__Group__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__TransitionProperty__Group__0"


    // $ANTLR start "rule__TransitionProperty__Group__0__Impl"
    // InternalLatteCSS.g:5411:1: rule__TransitionProperty__Group__0__Impl : ( ( rule__TransitionProperty__PropertyAssignment_0 ) ) ;
    public final void rule__TransitionProperty__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalLatteCSS.g:5415:1: ( ( ( rule__TransitionProperty__PropertyAssignment_0 ) ) )
            // InternalLatteCSS.g:5416:1: ( ( rule__TransitionProperty__PropertyAssignment_0 ) )
            {
            // InternalLatteCSS.g:5416:1: ( ( rule__TransitionProperty__PropertyAssignment_0 ) )
            // InternalLatteCSS.g:5417:1: ( rule__TransitionProperty__PropertyAssignment_0 )
            {
             before(grammarAccess.getTransitionPropertyAccess().getPropertyAssignment_0()); 
            // InternalLatteCSS.g:5418:1: ( rule__TransitionProperty__PropertyAssignment_0 )
            // InternalLatteCSS.g:5418:2: rule__TransitionProperty__PropertyAssignment_0
            {
            pushFollow(FOLLOW_2);
            rule__TransitionProperty__PropertyAssignment_0();

            state._fsp--;


            }

             after(grammarAccess.getTransitionPropertyAccess().getPropertyAssignment_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__TransitionProperty__Group__0__Impl"


    // $ANTLR start "rule__TransitionProperty__Group__1"
    // InternalLatteCSS.g:5428:1: rule__TransitionProperty__Group__1 : rule__TransitionProperty__Group__1__Impl rule__TransitionProperty__Group__2 ;
    public final void rule__TransitionProperty__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalLatteCSS.g:5432:1: ( rule__TransitionProperty__Group__1__Impl rule__TransitionProperty__Group__2 )
            // InternalLatteCSS.g:5433:2: rule__TransitionProperty__Group__1__Impl rule__TransitionProperty__Group__2
            {
            pushFollow(FOLLOW_19);
            rule__TransitionProperty__Group__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__TransitionProperty__Group__2();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__TransitionProperty__Group__1"


    // $ANTLR start "rule__TransitionProperty__Group__1__Impl"
    // InternalLatteCSS.g:5440:1: rule__TransitionProperty__Group__1__Impl : ( ':' ) ;
    public final void rule__TransitionProperty__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalLatteCSS.g:5444:1: ( ( ':' ) )
            // InternalLatteCSS.g:5445:1: ( ':' )
            {
            // InternalLatteCSS.g:5445:1: ( ':' )
            // InternalLatteCSS.g:5446:1: ':'
            {
             before(grammarAccess.getTransitionPropertyAccess().getColonKeyword_1()); 
            match(input,279,FOLLOW_2); 
             after(grammarAccess.getTransitionPropertyAccess().getColonKeyword_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__TransitionProperty__Group__1__Impl"


    // $ANTLR start "rule__TransitionProperty__Group__2"
    // InternalLatteCSS.g:5459:1: rule__TransitionProperty__Group__2 : rule__TransitionProperty__Group__2__Impl rule__TransitionProperty__Group__3 ;
    public final void rule__TransitionProperty__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalLatteCSS.g:5463:1: ( rule__TransitionProperty__Group__2__Impl rule__TransitionProperty__Group__3 )
            // InternalLatteCSS.g:5464:2: rule__TransitionProperty__Group__2__Impl rule__TransitionProperty__Group__3
            {
            pushFollow(FOLLOW_20);
            rule__TransitionProperty__Group__2__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__TransitionProperty__Group__3();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__TransitionProperty__Group__2"


    // $ANTLR start "rule__TransitionProperty__Group__2__Impl"
    // InternalLatteCSS.g:5471:1: rule__TransitionProperty__Group__2__Impl : ( ( rule__TransitionProperty__TransitionsAssignment_2 ) ) ;
    public final void rule__TransitionProperty__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalLatteCSS.g:5475:1: ( ( ( rule__TransitionProperty__TransitionsAssignment_2 ) ) )
            // InternalLatteCSS.g:5476:1: ( ( rule__TransitionProperty__TransitionsAssignment_2 ) )
            {
            // InternalLatteCSS.g:5476:1: ( ( rule__TransitionProperty__TransitionsAssignment_2 ) )
            // InternalLatteCSS.g:5477:1: ( rule__TransitionProperty__TransitionsAssignment_2 )
            {
             before(grammarAccess.getTransitionPropertyAccess().getTransitionsAssignment_2()); 
            // InternalLatteCSS.g:5478:1: ( rule__TransitionProperty__TransitionsAssignment_2 )
            // InternalLatteCSS.g:5478:2: rule__TransitionProperty__TransitionsAssignment_2
            {
            pushFollow(FOLLOW_2);
            rule__TransitionProperty__TransitionsAssignment_2();

            state._fsp--;


            }

             after(grammarAccess.getTransitionPropertyAccess().getTransitionsAssignment_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__TransitionProperty__Group__2__Impl"


    // $ANTLR start "rule__TransitionProperty__Group__3"
    // InternalLatteCSS.g:5488:1: rule__TransitionProperty__Group__3 : rule__TransitionProperty__Group__3__Impl ;
    public final void rule__TransitionProperty__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalLatteCSS.g:5492:1: ( rule__TransitionProperty__Group__3__Impl )
            // InternalLatteCSS.g:5493:2: rule__TransitionProperty__Group__3__Impl
            {
            pushFollow(FOLLOW_2);
            rule__TransitionProperty__Group__3__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__TransitionProperty__Group__3"


    // $ANTLR start "rule__TransitionProperty__Group__3__Impl"
    // InternalLatteCSS.g:5499:1: rule__TransitionProperty__Group__3__Impl : ( ( rule__TransitionProperty__Group_3__0 )* ) ;
    public final void rule__TransitionProperty__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalLatteCSS.g:5503:1: ( ( ( rule__TransitionProperty__Group_3__0 )* ) )
            // InternalLatteCSS.g:5504:1: ( ( rule__TransitionProperty__Group_3__0 )* )
            {
            // InternalLatteCSS.g:5504:1: ( ( rule__TransitionProperty__Group_3__0 )* )
            // InternalLatteCSS.g:5505:1: ( rule__TransitionProperty__Group_3__0 )*
            {
             before(grammarAccess.getTransitionPropertyAccess().getGroup_3()); 
            // InternalLatteCSS.g:5506:1: ( rule__TransitionProperty__Group_3__0 )*
            loop36:
            do {
                int alt36=2;
                int LA36_0 = input.LA(1);

                if ( (LA36_0==276) ) {
                    alt36=1;
                }


                switch (alt36) {
            	case 1 :
            	    // InternalLatteCSS.g:5506:2: rule__TransitionProperty__Group_3__0
            	    {
            	    pushFollow(FOLLOW_5);
            	    rule__TransitionProperty__Group_3__0();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop36;
                }
            } while (true);

             after(grammarAccess.getTransitionPropertyAccess().getGroup_3()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__TransitionProperty__Group__3__Impl"


    // $ANTLR start "rule__TransitionProperty__Group_3__0"
    // InternalLatteCSS.g:5524:1: rule__TransitionProperty__Group_3__0 : rule__TransitionProperty__Group_3__0__Impl rule__TransitionProperty__Group_3__1 ;
    public final void rule__TransitionProperty__Group_3__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalLatteCSS.g:5528:1: ( rule__TransitionProperty__Group_3__0__Impl rule__TransitionProperty__Group_3__1 )
            // InternalLatteCSS.g:5529:2: rule__TransitionProperty__Group_3__0__Impl rule__TransitionProperty__Group_3__1
            {
            pushFollow(FOLLOW_19);
            rule__TransitionProperty__Group_3__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__TransitionProperty__Group_3__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__TransitionProperty__Group_3__0"


    // $ANTLR start "rule__TransitionProperty__Group_3__0__Impl"
    // InternalLatteCSS.g:5536:1: rule__TransitionProperty__Group_3__0__Impl : ( ',' ) ;
    public final void rule__TransitionProperty__Group_3__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalLatteCSS.g:5540:1: ( ( ',' ) )
            // InternalLatteCSS.g:5541:1: ( ',' )
            {
            // InternalLatteCSS.g:5541:1: ( ',' )
            // InternalLatteCSS.g:5542:1: ','
            {
             before(grammarAccess.getTransitionPropertyAccess().getCommaKeyword_3_0()); 
            match(input,276,FOLLOW_2); 
             after(grammarAccess.getTransitionPropertyAccess().getCommaKeyword_3_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__TransitionProperty__Group_3__0__Impl"


    // $ANTLR start "rule__TransitionProperty__Group_3__1"
    // InternalLatteCSS.g:5555:1: rule__TransitionProperty__Group_3__1 : rule__TransitionProperty__Group_3__1__Impl ;
    public final void rule__TransitionProperty__Group_3__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalLatteCSS.g:5559:1: ( rule__TransitionProperty__Group_3__1__Impl )
            // InternalLatteCSS.g:5560:2: rule__TransitionProperty__Group_3__1__Impl
            {
            pushFollow(FOLLOW_2);
            rule__TransitionProperty__Group_3__1__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__TransitionProperty__Group_3__1"


    // $ANTLR start "rule__TransitionProperty__Group_3__1__Impl"
    // InternalLatteCSS.g:5566:1: rule__TransitionProperty__Group_3__1__Impl : ( ( rule__TransitionProperty__TransitionsAssignment_3_1 ) ) ;
    public final void rule__TransitionProperty__Group_3__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalLatteCSS.g:5570:1: ( ( ( rule__TransitionProperty__TransitionsAssignment_3_1 ) ) )
            // InternalLatteCSS.g:5571:1: ( ( rule__TransitionProperty__TransitionsAssignment_3_1 ) )
            {
            // InternalLatteCSS.g:5571:1: ( ( rule__TransitionProperty__TransitionsAssignment_3_1 ) )
            // InternalLatteCSS.g:5572:1: ( rule__TransitionProperty__TransitionsAssignment_3_1 )
            {
             before(grammarAccess.getTransitionPropertyAccess().getTransitionsAssignment_3_1()); 
            // InternalLatteCSS.g:5573:1: ( rule__TransitionProperty__TransitionsAssignment_3_1 )
            // InternalLatteCSS.g:5573:2: rule__TransitionProperty__TransitionsAssignment_3_1
            {
            pushFollow(FOLLOW_2);
            rule__TransitionProperty__TransitionsAssignment_3_1();

            state._fsp--;


            }

             after(grammarAccess.getTransitionPropertyAccess().getTransitionsAssignment_3_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__TransitionProperty__Group_3__1__Impl"


    // $ANTLR start "rule__TransitionValue__Group__0"
    // InternalLatteCSS.g:5587:1: rule__TransitionValue__Group__0 : rule__TransitionValue__Group__0__Impl rule__TransitionValue__Group__1 ;
    public final void rule__TransitionValue__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalLatteCSS.g:5591:1: ( rule__TransitionValue__Group__0__Impl rule__TransitionValue__Group__1 )
            // InternalLatteCSS.g:5592:2: rule__TransitionValue__Group__0__Impl rule__TransitionValue__Group__1
            {
            pushFollow(FOLLOW_16);
            rule__TransitionValue__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__TransitionValue__Group__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__TransitionValue__Group__0"


    // $ANTLR start "rule__TransitionValue__Group__0__Impl"
    // InternalLatteCSS.g:5599:1: rule__TransitionValue__Group__0__Impl : ( ( rule__TransitionValue__PropertyNameAssignment_0 ) ) ;
    public final void rule__TransitionValue__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalLatteCSS.g:5603:1: ( ( ( rule__TransitionValue__PropertyNameAssignment_0 ) ) )
            // InternalLatteCSS.g:5604:1: ( ( rule__TransitionValue__PropertyNameAssignment_0 ) )
            {
            // InternalLatteCSS.g:5604:1: ( ( rule__TransitionValue__PropertyNameAssignment_0 ) )
            // InternalLatteCSS.g:5605:1: ( rule__TransitionValue__PropertyNameAssignment_0 )
            {
             before(grammarAccess.getTransitionValueAccess().getPropertyNameAssignment_0()); 
            // InternalLatteCSS.g:5606:1: ( rule__TransitionValue__PropertyNameAssignment_0 )
            // InternalLatteCSS.g:5606:2: rule__TransitionValue__PropertyNameAssignment_0
            {
            pushFollow(FOLLOW_2);
            rule__TransitionValue__PropertyNameAssignment_0();

            state._fsp--;


            }

             after(grammarAccess.getTransitionValueAccess().getPropertyNameAssignment_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__TransitionValue__Group__0__Impl"


    // $ANTLR start "rule__TransitionValue__Group__1"
    // InternalLatteCSS.g:5616:1: rule__TransitionValue__Group__1 : rule__TransitionValue__Group__1__Impl rule__TransitionValue__Group__2 ;
    public final void rule__TransitionValue__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalLatteCSS.g:5620:1: ( rule__TransitionValue__Group__1__Impl rule__TransitionValue__Group__2 )
            // InternalLatteCSS.g:5621:2: rule__TransitionValue__Group__1__Impl rule__TransitionValue__Group__2
            {
            pushFollow(FOLLOW_21);
            rule__TransitionValue__Group__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__TransitionValue__Group__2();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__TransitionValue__Group__1"


    // $ANTLR start "rule__TransitionValue__Group__1__Impl"
    // InternalLatteCSS.g:5628:1: rule__TransitionValue__Group__1__Impl : ( ( rule__TransitionValue__DurationAssignment_1 ) ) ;
    public final void rule__TransitionValue__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalLatteCSS.g:5632:1: ( ( ( rule__TransitionValue__DurationAssignment_1 ) ) )
            // InternalLatteCSS.g:5633:1: ( ( rule__TransitionValue__DurationAssignment_1 ) )
            {
            // InternalLatteCSS.g:5633:1: ( ( rule__TransitionValue__DurationAssignment_1 ) )
            // InternalLatteCSS.g:5634:1: ( rule__TransitionValue__DurationAssignment_1 )
            {
             before(grammarAccess.getTransitionValueAccess().getDurationAssignment_1()); 
            // InternalLatteCSS.g:5635:1: ( rule__TransitionValue__DurationAssignment_1 )
            // InternalLatteCSS.g:5635:2: rule__TransitionValue__DurationAssignment_1
            {
            pushFollow(FOLLOW_2);
            rule__TransitionValue__DurationAssignment_1();

            state._fsp--;


            }

             after(grammarAccess.getTransitionValueAccess().getDurationAssignment_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__TransitionValue__Group__1__Impl"


    // $ANTLR start "rule__TransitionValue__Group__2"
    // InternalLatteCSS.g:5645:1: rule__TransitionValue__Group__2 : rule__TransitionValue__Group__2__Impl rule__TransitionValue__Group__3 ;
    public final void rule__TransitionValue__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalLatteCSS.g:5649:1: ( rule__TransitionValue__Group__2__Impl rule__TransitionValue__Group__3 )
            // InternalLatteCSS.g:5650:2: rule__TransitionValue__Group__2__Impl rule__TransitionValue__Group__3
            {
            pushFollow(FOLLOW_21);
            rule__TransitionValue__Group__2__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__TransitionValue__Group__3();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__TransitionValue__Group__2"


    // $ANTLR start "rule__TransitionValue__Group__2__Impl"
    // InternalLatteCSS.g:5657:1: rule__TransitionValue__Group__2__Impl : ( ( rule__TransitionValue__TimingFunctionAssignment_2 )? ) ;
    public final void rule__TransitionValue__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalLatteCSS.g:5661:1: ( ( ( rule__TransitionValue__TimingFunctionAssignment_2 )? ) )
            // InternalLatteCSS.g:5662:1: ( ( rule__TransitionValue__TimingFunctionAssignment_2 )? )
            {
            // InternalLatteCSS.g:5662:1: ( ( rule__TransitionValue__TimingFunctionAssignment_2 )? )
            // InternalLatteCSS.g:5663:1: ( rule__TransitionValue__TimingFunctionAssignment_2 )?
            {
             before(grammarAccess.getTransitionValueAccess().getTimingFunctionAssignment_2()); 
            // InternalLatteCSS.g:5664:1: ( rule__TransitionValue__TimingFunctionAssignment_2 )?
            int alt37=2;
            int LA37_0 = input.LA(1);

            if ( ((LA37_0>=101 && LA37_0<=112)) ) {
                alt37=1;
            }
            switch (alt37) {
                case 1 :
                    // InternalLatteCSS.g:5664:2: rule__TransitionValue__TimingFunctionAssignment_2
                    {
                    pushFollow(FOLLOW_2);
                    rule__TransitionValue__TimingFunctionAssignment_2();

                    state._fsp--;


                    }
                    break;

            }

             after(grammarAccess.getTransitionValueAccess().getTimingFunctionAssignment_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__TransitionValue__Group__2__Impl"


    // $ANTLR start "rule__TransitionValue__Group__3"
    // InternalLatteCSS.g:5674:1: rule__TransitionValue__Group__3 : rule__TransitionValue__Group__3__Impl ;
    public final void rule__TransitionValue__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalLatteCSS.g:5678:1: ( rule__TransitionValue__Group__3__Impl )
            // InternalLatteCSS.g:5679:2: rule__TransitionValue__Group__3__Impl
            {
            pushFollow(FOLLOW_2);
            rule__TransitionValue__Group__3__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__TransitionValue__Group__3"


    // $ANTLR start "rule__TransitionValue__Group__3__Impl"
    // InternalLatteCSS.g:5685:1: rule__TransitionValue__Group__3__Impl : ( ( rule__TransitionValue__DelayAssignment_3 )? ) ;
    public final void rule__TransitionValue__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalLatteCSS.g:5689:1: ( ( ( rule__TransitionValue__DelayAssignment_3 )? ) )
            // InternalLatteCSS.g:5690:1: ( ( rule__TransitionValue__DelayAssignment_3 )? )
            {
            // InternalLatteCSS.g:5690:1: ( ( rule__TransitionValue__DelayAssignment_3 )? )
            // InternalLatteCSS.g:5691:1: ( rule__TransitionValue__DelayAssignment_3 )?
            {
             before(grammarAccess.getTransitionValueAccess().getDelayAssignment_3()); 
            // InternalLatteCSS.g:5692:1: ( rule__TransitionValue__DelayAssignment_3 )?
            int alt38=2;
            int LA38_0 = input.LA(1);

            if ( ((LA38_0>=RULE_INT && LA38_0<=RULE_REAL)) ) {
                alt38=1;
            }
            switch (alt38) {
                case 1 :
                    // InternalLatteCSS.g:5692:2: rule__TransitionValue__DelayAssignment_3
                    {
                    pushFollow(FOLLOW_2);
                    rule__TransitionValue__DelayAssignment_3();

                    state._fsp--;


                    }
                    break;

            }

             after(grammarAccess.getTransitionValueAccess().getDelayAssignment_3()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__TransitionValue__Group__3__Impl"


    // $ANTLR start "rule__DrawableProperty__Group__0"
    // InternalLatteCSS.g:5710:1: rule__DrawableProperty__Group__0 : rule__DrawableProperty__Group__0__Impl rule__DrawableProperty__Group__1 ;
    public final void rule__DrawableProperty__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalLatteCSS.g:5714:1: ( rule__DrawableProperty__Group__0__Impl rule__DrawableProperty__Group__1 )
            // InternalLatteCSS.g:5715:2: rule__DrawableProperty__Group__0__Impl rule__DrawableProperty__Group__1
            {
            pushFollow(FOLLOW_10);
            rule__DrawableProperty__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__DrawableProperty__Group__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__DrawableProperty__Group__0"


    // $ANTLR start "rule__DrawableProperty__Group__0__Impl"
    // InternalLatteCSS.g:5722:1: rule__DrawableProperty__Group__0__Impl : ( ( rule__DrawableProperty__PropertyAssignment_0 ) ) ;
    public final void rule__DrawableProperty__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalLatteCSS.g:5726:1: ( ( ( rule__DrawableProperty__PropertyAssignment_0 ) ) )
            // InternalLatteCSS.g:5727:1: ( ( rule__DrawableProperty__PropertyAssignment_0 ) )
            {
            // InternalLatteCSS.g:5727:1: ( ( rule__DrawableProperty__PropertyAssignment_0 ) )
            // InternalLatteCSS.g:5728:1: ( rule__DrawableProperty__PropertyAssignment_0 )
            {
             before(grammarAccess.getDrawablePropertyAccess().getPropertyAssignment_0()); 
            // InternalLatteCSS.g:5729:1: ( rule__DrawableProperty__PropertyAssignment_0 )
            // InternalLatteCSS.g:5729:2: rule__DrawableProperty__PropertyAssignment_0
            {
            pushFollow(FOLLOW_2);
            rule__DrawableProperty__PropertyAssignment_0();

            state._fsp--;


            }

             after(grammarAccess.getDrawablePropertyAccess().getPropertyAssignment_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__DrawableProperty__Group__0__Impl"


    // $ANTLR start "rule__DrawableProperty__Group__1"
    // InternalLatteCSS.g:5739:1: rule__DrawableProperty__Group__1 : rule__DrawableProperty__Group__1__Impl rule__DrawableProperty__Group__2 ;
    public final void rule__DrawableProperty__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalLatteCSS.g:5743:1: ( rule__DrawableProperty__Group__1__Impl rule__DrawableProperty__Group__2 )
            // InternalLatteCSS.g:5744:2: rule__DrawableProperty__Group__1__Impl rule__DrawableProperty__Group__2
            {
            pushFollow(FOLLOW_13);
            rule__DrawableProperty__Group__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__DrawableProperty__Group__2();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__DrawableProperty__Group__1"


    // $ANTLR start "rule__DrawableProperty__Group__1__Impl"
    // InternalLatteCSS.g:5751:1: rule__DrawableProperty__Group__1__Impl : ( ':' ) ;
    public final void rule__DrawableProperty__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalLatteCSS.g:5755:1: ( ( ':' ) )
            // InternalLatteCSS.g:5756:1: ( ':' )
            {
            // InternalLatteCSS.g:5756:1: ( ':' )
            // InternalLatteCSS.g:5757:1: ':'
            {
             before(grammarAccess.getDrawablePropertyAccess().getColonKeyword_1()); 
            match(input,279,FOLLOW_2); 
             after(grammarAccess.getDrawablePropertyAccess().getColonKeyword_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__DrawableProperty__Group__1__Impl"


    // $ANTLR start "rule__DrawableProperty__Group__2"
    // InternalLatteCSS.g:5770:1: rule__DrawableProperty__Group__2 : rule__DrawableProperty__Group__2__Impl ;
    public final void rule__DrawableProperty__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalLatteCSS.g:5774:1: ( rule__DrawableProperty__Group__2__Impl )
            // InternalLatteCSS.g:5775:2: rule__DrawableProperty__Group__2__Impl
            {
            pushFollow(FOLLOW_2);
            rule__DrawableProperty__Group__2__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__DrawableProperty__Group__2"


    // $ANTLR start "rule__DrawableProperty__Group__2__Impl"
    // InternalLatteCSS.g:5781:1: rule__DrawableProperty__Group__2__Impl : ( ( rule__DrawableProperty__ValueAssignment_2 ) ) ;
    public final void rule__DrawableProperty__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalLatteCSS.g:5785:1: ( ( ( rule__DrawableProperty__ValueAssignment_2 ) ) )
            // InternalLatteCSS.g:5786:1: ( ( rule__DrawableProperty__ValueAssignment_2 ) )
            {
            // InternalLatteCSS.g:5786:1: ( ( rule__DrawableProperty__ValueAssignment_2 ) )
            // InternalLatteCSS.g:5787:1: ( rule__DrawableProperty__ValueAssignment_2 )
            {
             before(grammarAccess.getDrawablePropertyAccess().getValueAssignment_2()); 
            // InternalLatteCSS.g:5788:1: ( rule__DrawableProperty__ValueAssignment_2 )
            // InternalLatteCSS.g:5788:2: rule__DrawableProperty__ValueAssignment_2
            {
            pushFollow(FOLLOW_2);
            rule__DrawableProperty__ValueAssignment_2();

            state._fsp--;


            }

             after(grammarAccess.getDrawablePropertyAccess().getValueAssignment_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__DrawableProperty__Group__2__Impl"


    // $ANTLR start "rule__BackgroundRepeatProperty__Group__0"
    // InternalLatteCSS.g:5804:1: rule__BackgroundRepeatProperty__Group__0 : rule__BackgroundRepeatProperty__Group__0__Impl rule__BackgroundRepeatProperty__Group__1 ;
    public final void rule__BackgroundRepeatProperty__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalLatteCSS.g:5808:1: ( rule__BackgroundRepeatProperty__Group__0__Impl rule__BackgroundRepeatProperty__Group__1 )
            // InternalLatteCSS.g:5809:2: rule__BackgroundRepeatProperty__Group__0__Impl rule__BackgroundRepeatProperty__Group__1
            {
            pushFollow(FOLLOW_10);
            rule__BackgroundRepeatProperty__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__BackgroundRepeatProperty__Group__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__BackgroundRepeatProperty__Group__0"


    // $ANTLR start "rule__BackgroundRepeatProperty__Group__0__Impl"
    // InternalLatteCSS.g:5816:1: rule__BackgroundRepeatProperty__Group__0__Impl : ( ( rule__BackgroundRepeatProperty__PropertyAssignment_0 ) ) ;
    public final void rule__BackgroundRepeatProperty__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalLatteCSS.g:5820:1: ( ( ( rule__BackgroundRepeatProperty__PropertyAssignment_0 ) ) )
            // InternalLatteCSS.g:5821:1: ( ( rule__BackgroundRepeatProperty__PropertyAssignment_0 ) )
            {
            // InternalLatteCSS.g:5821:1: ( ( rule__BackgroundRepeatProperty__PropertyAssignment_0 ) )
            // InternalLatteCSS.g:5822:1: ( rule__BackgroundRepeatProperty__PropertyAssignment_0 )
            {
             before(grammarAccess.getBackgroundRepeatPropertyAccess().getPropertyAssignment_0()); 
            // InternalLatteCSS.g:5823:1: ( rule__BackgroundRepeatProperty__PropertyAssignment_0 )
            // InternalLatteCSS.g:5823:2: rule__BackgroundRepeatProperty__PropertyAssignment_0
            {
            pushFollow(FOLLOW_2);
            rule__BackgroundRepeatProperty__PropertyAssignment_0();

            state._fsp--;


            }

             after(grammarAccess.getBackgroundRepeatPropertyAccess().getPropertyAssignment_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__BackgroundRepeatProperty__Group__0__Impl"


    // $ANTLR start "rule__BackgroundRepeatProperty__Group__1"
    // InternalLatteCSS.g:5833:1: rule__BackgroundRepeatProperty__Group__1 : rule__BackgroundRepeatProperty__Group__1__Impl rule__BackgroundRepeatProperty__Group__2 ;
    public final void rule__BackgroundRepeatProperty__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalLatteCSS.g:5837:1: ( rule__BackgroundRepeatProperty__Group__1__Impl rule__BackgroundRepeatProperty__Group__2 )
            // InternalLatteCSS.g:5838:2: rule__BackgroundRepeatProperty__Group__1__Impl rule__BackgroundRepeatProperty__Group__2
            {
            pushFollow(FOLLOW_22);
            rule__BackgroundRepeatProperty__Group__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__BackgroundRepeatProperty__Group__2();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__BackgroundRepeatProperty__Group__1"


    // $ANTLR start "rule__BackgroundRepeatProperty__Group__1__Impl"
    // InternalLatteCSS.g:5845:1: rule__BackgroundRepeatProperty__Group__1__Impl : ( ':' ) ;
    public final void rule__BackgroundRepeatProperty__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalLatteCSS.g:5849:1: ( ( ':' ) )
            // InternalLatteCSS.g:5850:1: ( ':' )
            {
            // InternalLatteCSS.g:5850:1: ( ':' )
            // InternalLatteCSS.g:5851:1: ':'
            {
             before(grammarAccess.getBackgroundRepeatPropertyAccess().getColonKeyword_1()); 
            match(input,279,FOLLOW_2); 
             after(grammarAccess.getBackgroundRepeatPropertyAccess().getColonKeyword_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__BackgroundRepeatProperty__Group__1__Impl"


    // $ANTLR start "rule__BackgroundRepeatProperty__Group__2"
    // InternalLatteCSS.g:5864:1: rule__BackgroundRepeatProperty__Group__2 : rule__BackgroundRepeatProperty__Group__2__Impl rule__BackgroundRepeatProperty__Group__3 ;
    public final void rule__BackgroundRepeatProperty__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalLatteCSS.g:5868:1: ( rule__BackgroundRepeatProperty__Group__2__Impl rule__BackgroundRepeatProperty__Group__3 )
            // InternalLatteCSS.g:5869:2: rule__BackgroundRepeatProperty__Group__2__Impl rule__BackgroundRepeatProperty__Group__3
            {
            pushFollow(FOLLOW_22);
            rule__BackgroundRepeatProperty__Group__2__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__BackgroundRepeatProperty__Group__3();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__BackgroundRepeatProperty__Group__2"


    // $ANTLR start "rule__BackgroundRepeatProperty__Group__2__Impl"
    // InternalLatteCSS.g:5876:1: rule__BackgroundRepeatProperty__Group__2__Impl : ( ( rule__BackgroundRepeatProperty__ValuesAssignment_2 ) ) ;
    public final void rule__BackgroundRepeatProperty__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalLatteCSS.g:5880:1: ( ( ( rule__BackgroundRepeatProperty__ValuesAssignment_2 ) ) )
            // InternalLatteCSS.g:5881:1: ( ( rule__BackgroundRepeatProperty__ValuesAssignment_2 ) )
            {
            // InternalLatteCSS.g:5881:1: ( ( rule__BackgroundRepeatProperty__ValuesAssignment_2 ) )
            // InternalLatteCSS.g:5882:1: ( rule__BackgroundRepeatProperty__ValuesAssignment_2 )
            {
             before(grammarAccess.getBackgroundRepeatPropertyAccess().getValuesAssignment_2()); 
            // InternalLatteCSS.g:5883:1: ( rule__BackgroundRepeatProperty__ValuesAssignment_2 )
            // InternalLatteCSS.g:5883:2: rule__BackgroundRepeatProperty__ValuesAssignment_2
            {
            pushFollow(FOLLOW_2);
            rule__BackgroundRepeatProperty__ValuesAssignment_2();

            state._fsp--;


            }

             after(grammarAccess.getBackgroundRepeatPropertyAccess().getValuesAssignment_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__BackgroundRepeatProperty__Group__2__Impl"


    // $ANTLR start "rule__BackgroundRepeatProperty__Group__3"
    // InternalLatteCSS.g:5893:1: rule__BackgroundRepeatProperty__Group__3 : rule__BackgroundRepeatProperty__Group__3__Impl ;
    public final void rule__BackgroundRepeatProperty__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalLatteCSS.g:5897:1: ( rule__BackgroundRepeatProperty__Group__3__Impl )
            // InternalLatteCSS.g:5898:2: rule__BackgroundRepeatProperty__Group__3__Impl
            {
            pushFollow(FOLLOW_2);
            rule__BackgroundRepeatProperty__Group__3__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__BackgroundRepeatProperty__Group__3"


    // $ANTLR start "rule__BackgroundRepeatProperty__Group__3__Impl"
    // InternalLatteCSS.g:5904:1: rule__BackgroundRepeatProperty__Group__3__Impl : ( ( rule__BackgroundRepeatProperty__ValuesAssignment_3 )? ) ;
    public final void rule__BackgroundRepeatProperty__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalLatteCSS.g:5908:1: ( ( ( rule__BackgroundRepeatProperty__ValuesAssignment_3 )? ) )
            // InternalLatteCSS.g:5909:1: ( ( rule__BackgroundRepeatProperty__ValuesAssignment_3 )? )
            {
            // InternalLatteCSS.g:5909:1: ( ( rule__BackgroundRepeatProperty__ValuesAssignment_3 )? )
            // InternalLatteCSS.g:5910:1: ( rule__BackgroundRepeatProperty__ValuesAssignment_3 )?
            {
             before(grammarAccess.getBackgroundRepeatPropertyAccess().getValuesAssignment_3()); 
            // InternalLatteCSS.g:5911:1: ( rule__BackgroundRepeatProperty__ValuesAssignment_3 )?
            int alt39=2;
            int LA39_0 = input.LA(1);

            if ( ((LA39_0>=52 && LA39_0<=59)) ) {
                alt39=1;
            }
            switch (alt39) {
                case 1 :
                    // InternalLatteCSS.g:5911:2: rule__BackgroundRepeatProperty__ValuesAssignment_3
                    {
                    pushFollow(FOLLOW_2);
                    rule__BackgroundRepeatProperty__ValuesAssignment_3();

                    state._fsp--;


                    }
                    break;

            }

             after(grammarAccess.getBackgroundRepeatPropertyAccess().getValuesAssignment_3()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__BackgroundRepeatProperty__Group__3__Impl"


    // $ANTLR start "rule__BorderProperty__Group__0"
    // InternalLatteCSS.g:5929:1: rule__BorderProperty__Group__0 : rule__BorderProperty__Group__0__Impl rule__BorderProperty__Group__1 ;
    public final void rule__BorderProperty__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalLatteCSS.g:5933:1: ( rule__BorderProperty__Group__0__Impl rule__BorderProperty__Group__1 )
            // InternalLatteCSS.g:5934:2: rule__BorderProperty__Group__0__Impl rule__BorderProperty__Group__1
            {
            pushFollow(FOLLOW_10);
            rule__BorderProperty__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__BorderProperty__Group__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__BorderProperty__Group__0"


    // $ANTLR start "rule__BorderProperty__Group__0__Impl"
    // InternalLatteCSS.g:5941:1: rule__BorderProperty__Group__0__Impl : ( ( rule__BorderProperty__PropertyAssignment_0 ) ) ;
    public final void rule__BorderProperty__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalLatteCSS.g:5945:1: ( ( ( rule__BorderProperty__PropertyAssignment_0 ) ) )
            // InternalLatteCSS.g:5946:1: ( ( rule__BorderProperty__PropertyAssignment_0 ) )
            {
            // InternalLatteCSS.g:5946:1: ( ( rule__BorderProperty__PropertyAssignment_0 ) )
            // InternalLatteCSS.g:5947:1: ( rule__BorderProperty__PropertyAssignment_0 )
            {
             before(grammarAccess.getBorderPropertyAccess().getPropertyAssignment_0()); 
            // InternalLatteCSS.g:5948:1: ( rule__BorderProperty__PropertyAssignment_0 )
            // InternalLatteCSS.g:5948:2: rule__BorderProperty__PropertyAssignment_0
            {
            pushFollow(FOLLOW_2);
            rule__BorderProperty__PropertyAssignment_0();

            state._fsp--;


            }

             after(grammarAccess.getBorderPropertyAccess().getPropertyAssignment_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__BorderProperty__Group__0__Impl"


    // $ANTLR start "rule__BorderProperty__Group__1"
    // InternalLatteCSS.g:5958:1: rule__BorderProperty__Group__1 : rule__BorderProperty__Group__1__Impl rule__BorderProperty__Group__2 ;
    public final void rule__BorderProperty__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalLatteCSS.g:5962:1: ( rule__BorderProperty__Group__1__Impl rule__BorderProperty__Group__2 )
            // InternalLatteCSS.g:5963:2: rule__BorderProperty__Group__1__Impl rule__BorderProperty__Group__2
            {
            pushFollow(FOLLOW_23);
            rule__BorderProperty__Group__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__BorderProperty__Group__2();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__BorderProperty__Group__1"


    // $ANTLR start "rule__BorderProperty__Group__1__Impl"
    // InternalLatteCSS.g:5970:1: rule__BorderProperty__Group__1__Impl : ( ':' ) ;
    public final void rule__BorderProperty__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalLatteCSS.g:5974:1: ( ( ':' ) )
            // InternalLatteCSS.g:5975:1: ( ':' )
            {
            // InternalLatteCSS.g:5975:1: ( ':' )
            // InternalLatteCSS.g:5976:1: ':'
            {
             before(grammarAccess.getBorderPropertyAccess().getColonKeyword_1()); 
            match(input,279,FOLLOW_2); 
             after(grammarAccess.getBorderPropertyAccess().getColonKeyword_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__BorderProperty__Group__1__Impl"


    // $ANTLR start "rule__BorderProperty__Group__2"
    // InternalLatteCSS.g:5989:1: rule__BorderProperty__Group__2 : rule__BorderProperty__Group__2__Impl rule__BorderProperty__Group__3 ;
    public final void rule__BorderProperty__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalLatteCSS.g:5993:1: ( rule__BorderProperty__Group__2__Impl rule__BorderProperty__Group__3 )
            // InternalLatteCSS.g:5994:2: rule__BorderProperty__Group__2__Impl rule__BorderProperty__Group__3
            {
            pushFollow(FOLLOW_23);
            rule__BorderProperty__Group__2__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__BorderProperty__Group__3();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__BorderProperty__Group__2"


    // $ANTLR start "rule__BorderProperty__Group__2__Impl"
    // InternalLatteCSS.g:6001:1: rule__BorderProperty__Group__2__Impl : ( ( rule__BorderProperty__WidthAssignment_2 )? ) ;
    public final void rule__BorderProperty__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalLatteCSS.g:6005:1: ( ( ( rule__BorderProperty__WidthAssignment_2 )? ) )
            // InternalLatteCSS.g:6006:1: ( ( rule__BorderProperty__WidthAssignment_2 )? )
            {
            // InternalLatteCSS.g:6006:1: ( ( rule__BorderProperty__WidthAssignment_2 )? )
            // InternalLatteCSS.g:6007:1: ( rule__BorderProperty__WidthAssignment_2 )?
            {
             before(grammarAccess.getBorderPropertyAccess().getWidthAssignment_2()); 
            // InternalLatteCSS.g:6008:1: ( rule__BorderProperty__WidthAssignment_2 )?
            int alt40=2;
            int LA40_0 = input.LA(1);

            if ( ((LA40_0>=RULE_INT && LA40_0<=RULE_REAL)) ) {
                alt40=1;
            }
            switch (alt40) {
                case 1 :
                    // InternalLatteCSS.g:6008:2: rule__BorderProperty__WidthAssignment_2
                    {
                    pushFollow(FOLLOW_2);
                    rule__BorderProperty__WidthAssignment_2();

                    state._fsp--;


                    }
                    break;

            }

             after(grammarAccess.getBorderPropertyAccess().getWidthAssignment_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__BorderProperty__Group__2__Impl"


    // $ANTLR start "rule__BorderProperty__Group__3"
    // InternalLatteCSS.g:6018:1: rule__BorderProperty__Group__3 : rule__BorderProperty__Group__3__Impl rule__BorderProperty__Group__4 ;
    public final void rule__BorderProperty__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalLatteCSS.g:6022:1: ( rule__BorderProperty__Group__3__Impl rule__BorderProperty__Group__4 )
            // InternalLatteCSS.g:6023:2: rule__BorderProperty__Group__3__Impl rule__BorderProperty__Group__4
            {
            pushFollow(FOLLOW_18);
            rule__BorderProperty__Group__3__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__BorderProperty__Group__4();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__BorderProperty__Group__3"


    // $ANTLR start "rule__BorderProperty__Group__3__Impl"
    // InternalLatteCSS.g:6030:1: rule__BorderProperty__Group__3__Impl : ( ( rule__BorderProperty__StyleAssignment_3 ) ) ;
    public final void rule__BorderProperty__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalLatteCSS.g:6034:1: ( ( ( rule__BorderProperty__StyleAssignment_3 ) ) )
            // InternalLatteCSS.g:6035:1: ( ( rule__BorderProperty__StyleAssignment_3 ) )
            {
            // InternalLatteCSS.g:6035:1: ( ( rule__BorderProperty__StyleAssignment_3 ) )
            // InternalLatteCSS.g:6036:1: ( rule__BorderProperty__StyleAssignment_3 )
            {
             before(grammarAccess.getBorderPropertyAccess().getStyleAssignment_3()); 
            // InternalLatteCSS.g:6037:1: ( rule__BorderProperty__StyleAssignment_3 )
            // InternalLatteCSS.g:6037:2: rule__BorderProperty__StyleAssignment_3
            {
            pushFollow(FOLLOW_2);
            rule__BorderProperty__StyleAssignment_3();

            state._fsp--;


            }

             after(grammarAccess.getBorderPropertyAccess().getStyleAssignment_3()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__BorderProperty__Group__3__Impl"


    // $ANTLR start "rule__BorderProperty__Group__4"
    // InternalLatteCSS.g:6047:1: rule__BorderProperty__Group__4 : rule__BorderProperty__Group__4__Impl ;
    public final void rule__BorderProperty__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalLatteCSS.g:6051:1: ( rule__BorderProperty__Group__4__Impl )
            // InternalLatteCSS.g:6052:2: rule__BorderProperty__Group__4__Impl
            {
            pushFollow(FOLLOW_2);
            rule__BorderProperty__Group__4__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__BorderProperty__Group__4"


    // $ANTLR start "rule__BorderProperty__Group__4__Impl"
    // InternalLatteCSS.g:6058:1: rule__BorderProperty__Group__4__Impl : ( ( rule__BorderProperty__ColorAssignment_4 )? ) ;
    public final void rule__BorderProperty__Group__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalLatteCSS.g:6062:1: ( ( ( rule__BorderProperty__ColorAssignment_4 )? ) )
            // InternalLatteCSS.g:6063:1: ( ( rule__BorderProperty__ColorAssignment_4 )? )
            {
            // InternalLatteCSS.g:6063:1: ( ( rule__BorderProperty__ColorAssignment_4 )? )
            // InternalLatteCSS.g:6064:1: ( rule__BorderProperty__ColorAssignment_4 )?
            {
             before(grammarAccess.getBorderPropertyAccess().getColorAssignment_4()); 
            // InternalLatteCSS.g:6065:1: ( rule__BorderProperty__ColorAssignment_4 )?
            int alt41=2;
            int LA41_0 = input.LA(1);

            if ( (LA41_0==RULE_HEX_NUMBER||(LA41_0>=126 && LA41_0<=273)||(LA41_0>=287 && LA41_0<=288)) ) {
                alt41=1;
            }
            switch (alt41) {
                case 1 :
                    // InternalLatteCSS.g:6065:2: rule__BorderProperty__ColorAssignment_4
                    {
                    pushFollow(FOLLOW_2);
                    rule__BorderProperty__ColorAssignment_4();

                    state._fsp--;


                    }
                    break;

            }

             after(grammarAccess.getBorderPropertyAccess().getColorAssignment_4()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__BorderProperty__Group__4__Impl"


    // $ANTLR start "rule__BackgroundFilterProperty__Group__0"
    // InternalLatteCSS.g:6085:1: rule__BackgroundFilterProperty__Group__0 : rule__BackgroundFilterProperty__Group__0__Impl rule__BackgroundFilterProperty__Group__1 ;
    public final void rule__BackgroundFilterProperty__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalLatteCSS.g:6089:1: ( rule__BackgroundFilterProperty__Group__0__Impl rule__BackgroundFilterProperty__Group__1 )
            // InternalLatteCSS.g:6090:2: rule__BackgroundFilterProperty__Group__0__Impl rule__BackgroundFilterProperty__Group__1
            {
            pushFollow(FOLLOW_10);
            rule__BackgroundFilterProperty__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__BackgroundFilterProperty__Group__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__BackgroundFilterProperty__Group__0"


    // $ANTLR start "rule__BackgroundFilterProperty__Group__0__Impl"
    // InternalLatteCSS.g:6097:1: rule__BackgroundFilterProperty__Group__0__Impl : ( ( rule__BackgroundFilterProperty__PropertyAssignment_0 ) ) ;
    public final void rule__BackgroundFilterProperty__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalLatteCSS.g:6101:1: ( ( ( rule__BackgroundFilterProperty__PropertyAssignment_0 ) ) )
            // InternalLatteCSS.g:6102:1: ( ( rule__BackgroundFilterProperty__PropertyAssignment_0 ) )
            {
            // InternalLatteCSS.g:6102:1: ( ( rule__BackgroundFilterProperty__PropertyAssignment_0 ) )
            // InternalLatteCSS.g:6103:1: ( rule__BackgroundFilterProperty__PropertyAssignment_0 )
            {
             before(grammarAccess.getBackgroundFilterPropertyAccess().getPropertyAssignment_0()); 
            // InternalLatteCSS.g:6104:1: ( rule__BackgroundFilterProperty__PropertyAssignment_0 )
            // InternalLatteCSS.g:6104:2: rule__BackgroundFilterProperty__PropertyAssignment_0
            {
            pushFollow(FOLLOW_2);
            rule__BackgroundFilterProperty__PropertyAssignment_0();

            state._fsp--;


            }

             after(grammarAccess.getBackgroundFilterPropertyAccess().getPropertyAssignment_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__BackgroundFilterProperty__Group__0__Impl"


    // $ANTLR start "rule__BackgroundFilterProperty__Group__1"
    // InternalLatteCSS.g:6114:1: rule__BackgroundFilterProperty__Group__1 : rule__BackgroundFilterProperty__Group__1__Impl rule__BackgroundFilterProperty__Group__2 ;
    public final void rule__BackgroundFilterProperty__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalLatteCSS.g:6118:1: ( rule__BackgroundFilterProperty__Group__1__Impl rule__BackgroundFilterProperty__Group__2 )
            // InternalLatteCSS.g:6119:2: rule__BackgroundFilterProperty__Group__1__Impl rule__BackgroundFilterProperty__Group__2
            {
            pushFollow(FOLLOW_18);
            rule__BackgroundFilterProperty__Group__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__BackgroundFilterProperty__Group__2();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__BackgroundFilterProperty__Group__1"


    // $ANTLR start "rule__BackgroundFilterProperty__Group__1__Impl"
    // InternalLatteCSS.g:6126:1: rule__BackgroundFilterProperty__Group__1__Impl : ( ':' ) ;
    public final void rule__BackgroundFilterProperty__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalLatteCSS.g:6130:1: ( ( ':' ) )
            // InternalLatteCSS.g:6131:1: ( ':' )
            {
            // InternalLatteCSS.g:6131:1: ( ':' )
            // InternalLatteCSS.g:6132:1: ':'
            {
             before(grammarAccess.getBackgroundFilterPropertyAccess().getColonKeyword_1()); 
            match(input,279,FOLLOW_2); 
             after(grammarAccess.getBackgroundFilterPropertyAccess().getColonKeyword_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__BackgroundFilterProperty__Group__1__Impl"


    // $ANTLR start "rule__BackgroundFilterProperty__Group__2"
    // InternalLatteCSS.g:6145:1: rule__BackgroundFilterProperty__Group__2 : rule__BackgroundFilterProperty__Group__2__Impl rule__BackgroundFilterProperty__Group__3 ;
    public final void rule__BackgroundFilterProperty__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalLatteCSS.g:6149:1: ( rule__BackgroundFilterProperty__Group__2__Impl rule__BackgroundFilterProperty__Group__3 )
            // InternalLatteCSS.g:6150:2: rule__BackgroundFilterProperty__Group__2__Impl rule__BackgroundFilterProperty__Group__3
            {
            pushFollow(FOLLOW_24);
            rule__BackgroundFilterProperty__Group__2__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__BackgroundFilterProperty__Group__3();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__BackgroundFilterProperty__Group__2"


    // $ANTLR start "rule__BackgroundFilterProperty__Group__2__Impl"
    // InternalLatteCSS.g:6157:1: rule__BackgroundFilterProperty__Group__2__Impl : ( ( rule__BackgroundFilterProperty__ColorAssignment_2 ) ) ;
    public final void rule__BackgroundFilterProperty__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalLatteCSS.g:6161:1: ( ( ( rule__BackgroundFilterProperty__ColorAssignment_2 ) ) )
            // InternalLatteCSS.g:6162:1: ( ( rule__BackgroundFilterProperty__ColorAssignment_2 ) )
            {
            // InternalLatteCSS.g:6162:1: ( ( rule__BackgroundFilterProperty__ColorAssignment_2 ) )
            // InternalLatteCSS.g:6163:1: ( rule__BackgroundFilterProperty__ColorAssignment_2 )
            {
             before(grammarAccess.getBackgroundFilterPropertyAccess().getColorAssignment_2()); 
            // InternalLatteCSS.g:6164:1: ( rule__BackgroundFilterProperty__ColorAssignment_2 )
            // InternalLatteCSS.g:6164:2: rule__BackgroundFilterProperty__ColorAssignment_2
            {
            pushFollow(FOLLOW_2);
            rule__BackgroundFilterProperty__ColorAssignment_2();

            state._fsp--;


            }

             after(grammarAccess.getBackgroundFilterPropertyAccess().getColorAssignment_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__BackgroundFilterProperty__Group__2__Impl"


    // $ANTLR start "rule__BackgroundFilterProperty__Group__3"
    // InternalLatteCSS.g:6174:1: rule__BackgroundFilterProperty__Group__3 : rule__BackgroundFilterProperty__Group__3__Impl ;
    public final void rule__BackgroundFilterProperty__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalLatteCSS.g:6178:1: ( rule__BackgroundFilterProperty__Group__3__Impl )
            // InternalLatteCSS.g:6179:2: rule__BackgroundFilterProperty__Group__3__Impl
            {
            pushFollow(FOLLOW_2);
            rule__BackgroundFilterProperty__Group__3__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__BackgroundFilterProperty__Group__3"


    // $ANTLR start "rule__BackgroundFilterProperty__Group__3__Impl"
    // InternalLatteCSS.g:6185:1: rule__BackgroundFilterProperty__Group__3__Impl : ( ( rule__BackgroundFilterProperty__FilterAssignment_3 )? ) ;
    public final void rule__BackgroundFilterProperty__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalLatteCSS.g:6189:1: ( ( ( rule__BackgroundFilterProperty__FilterAssignment_3 )? ) )
            // InternalLatteCSS.g:6190:1: ( ( rule__BackgroundFilterProperty__FilterAssignment_3 )? )
            {
            // InternalLatteCSS.g:6190:1: ( ( rule__BackgroundFilterProperty__FilterAssignment_3 )? )
            // InternalLatteCSS.g:6191:1: ( rule__BackgroundFilterProperty__FilterAssignment_3 )?
            {
             before(grammarAccess.getBackgroundFilterPropertyAccess().getFilterAssignment_3()); 
            // InternalLatteCSS.g:6192:1: ( rule__BackgroundFilterProperty__FilterAssignment_3 )?
            int alt42=2;
            int LA42_0 = input.LA(1);

            if ( ((LA42_0>=74 && LA42_0<=91)) ) {
                alt42=1;
            }
            switch (alt42) {
                case 1 :
                    // InternalLatteCSS.g:6192:2: rule__BackgroundFilterProperty__FilterAssignment_3
                    {
                    pushFollow(FOLLOW_2);
                    rule__BackgroundFilterProperty__FilterAssignment_3();

                    state._fsp--;


                    }
                    break;

            }

             after(grammarAccess.getBackgroundFilterPropertyAccess().getFilterAssignment_3()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__BackgroundFilterProperty__Group__3__Impl"


    // $ANTLR start "rule__BackgroundGravityProperty__Group__0"
    // InternalLatteCSS.g:6210:1: rule__BackgroundGravityProperty__Group__0 : rule__BackgroundGravityProperty__Group__0__Impl rule__BackgroundGravityProperty__Group__1 ;
    public final void rule__BackgroundGravityProperty__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalLatteCSS.g:6214:1: ( rule__BackgroundGravityProperty__Group__0__Impl rule__BackgroundGravityProperty__Group__1 )
            // InternalLatteCSS.g:6215:2: rule__BackgroundGravityProperty__Group__0__Impl rule__BackgroundGravityProperty__Group__1
            {
            pushFollow(FOLLOW_10);
            rule__BackgroundGravityProperty__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__BackgroundGravityProperty__Group__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__BackgroundGravityProperty__Group__0"


    // $ANTLR start "rule__BackgroundGravityProperty__Group__0__Impl"
    // InternalLatteCSS.g:6222:1: rule__BackgroundGravityProperty__Group__0__Impl : ( ( rule__BackgroundGravityProperty__PropertyAssignment_0 ) ) ;
    public final void rule__BackgroundGravityProperty__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalLatteCSS.g:6226:1: ( ( ( rule__BackgroundGravityProperty__PropertyAssignment_0 ) ) )
            // InternalLatteCSS.g:6227:1: ( ( rule__BackgroundGravityProperty__PropertyAssignment_0 ) )
            {
            // InternalLatteCSS.g:6227:1: ( ( rule__BackgroundGravityProperty__PropertyAssignment_0 ) )
            // InternalLatteCSS.g:6228:1: ( rule__BackgroundGravityProperty__PropertyAssignment_0 )
            {
             before(grammarAccess.getBackgroundGravityPropertyAccess().getPropertyAssignment_0()); 
            // InternalLatteCSS.g:6229:1: ( rule__BackgroundGravityProperty__PropertyAssignment_0 )
            // InternalLatteCSS.g:6229:2: rule__BackgroundGravityProperty__PropertyAssignment_0
            {
            pushFollow(FOLLOW_2);
            rule__BackgroundGravityProperty__PropertyAssignment_0();

            state._fsp--;


            }

             after(grammarAccess.getBackgroundGravityPropertyAccess().getPropertyAssignment_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__BackgroundGravityProperty__Group__0__Impl"


    // $ANTLR start "rule__BackgroundGravityProperty__Group__1"
    // InternalLatteCSS.g:6239:1: rule__BackgroundGravityProperty__Group__1 : rule__BackgroundGravityProperty__Group__1__Impl rule__BackgroundGravityProperty__Group__2 ;
    public final void rule__BackgroundGravityProperty__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalLatteCSS.g:6243:1: ( rule__BackgroundGravityProperty__Group__1__Impl rule__BackgroundGravityProperty__Group__2 )
            // InternalLatteCSS.g:6244:2: rule__BackgroundGravityProperty__Group__1__Impl rule__BackgroundGravityProperty__Group__2
            {
            pushFollow(FOLLOW_25);
            rule__BackgroundGravityProperty__Group__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__BackgroundGravityProperty__Group__2();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__BackgroundGravityProperty__Group__1"


    // $ANTLR start "rule__BackgroundGravityProperty__Group__1__Impl"
    // InternalLatteCSS.g:6251:1: rule__BackgroundGravityProperty__Group__1__Impl : ( ':' ) ;
    public final void rule__BackgroundGravityProperty__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalLatteCSS.g:6255:1: ( ( ':' ) )
            // InternalLatteCSS.g:6256:1: ( ':' )
            {
            // InternalLatteCSS.g:6256:1: ( ':' )
            // InternalLatteCSS.g:6257:1: ':'
            {
             before(grammarAccess.getBackgroundGravityPropertyAccess().getColonKeyword_1()); 
            match(input,279,FOLLOW_2); 
             after(grammarAccess.getBackgroundGravityPropertyAccess().getColonKeyword_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__BackgroundGravityProperty__Group__1__Impl"


    // $ANTLR start "rule__BackgroundGravityProperty__Group__2"
    // InternalLatteCSS.g:6270:1: rule__BackgroundGravityProperty__Group__2 : rule__BackgroundGravityProperty__Group__2__Impl rule__BackgroundGravityProperty__Group__3 ;
    public final void rule__BackgroundGravityProperty__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalLatteCSS.g:6274:1: ( rule__BackgroundGravityProperty__Group__2__Impl rule__BackgroundGravityProperty__Group__3 )
            // InternalLatteCSS.g:6275:2: rule__BackgroundGravityProperty__Group__2__Impl rule__BackgroundGravityProperty__Group__3
            {
            pushFollow(FOLLOW_20);
            rule__BackgroundGravityProperty__Group__2__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__BackgroundGravityProperty__Group__3();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__BackgroundGravityProperty__Group__2"


    // $ANTLR start "rule__BackgroundGravityProperty__Group__2__Impl"
    // InternalLatteCSS.g:6282:1: rule__BackgroundGravityProperty__Group__2__Impl : ( ( rule__BackgroundGravityProperty__ValuesAssignment_2 ) ) ;
    public final void rule__BackgroundGravityProperty__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalLatteCSS.g:6286:1: ( ( ( rule__BackgroundGravityProperty__ValuesAssignment_2 ) ) )
            // InternalLatteCSS.g:6287:1: ( ( rule__BackgroundGravityProperty__ValuesAssignment_2 ) )
            {
            // InternalLatteCSS.g:6287:1: ( ( rule__BackgroundGravityProperty__ValuesAssignment_2 ) )
            // InternalLatteCSS.g:6288:1: ( rule__BackgroundGravityProperty__ValuesAssignment_2 )
            {
             before(grammarAccess.getBackgroundGravityPropertyAccess().getValuesAssignment_2()); 
            // InternalLatteCSS.g:6289:1: ( rule__BackgroundGravityProperty__ValuesAssignment_2 )
            // InternalLatteCSS.g:6289:2: rule__BackgroundGravityProperty__ValuesAssignment_2
            {
            pushFollow(FOLLOW_2);
            rule__BackgroundGravityProperty__ValuesAssignment_2();

            state._fsp--;


            }

             after(grammarAccess.getBackgroundGravityPropertyAccess().getValuesAssignment_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__BackgroundGravityProperty__Group__2__Impl"


    // $ANTLR start "rule__BackgroundGravityProperty__Group__3"
    // InternalLatteCSS.g:6299:1: rule__BackgroundGravityProperty__Group__3 : rule__BackgroundGravityProperty__Group__3__Impl ;
    public final void rule__BackgroundGravityProperty__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalLatteCSS.g:6303:1: ( rule__BackgroundGravityProperty__Group__3__Impl )
            // InternalLatteCSS.g:6304:2: rule__BackgroundGravityProperty__Group__3__Impl
            {
            pushFollow(FOLLOW_2);
            rule__BackgroundGravityProperty__Group__3__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__BackgroundGravityProperty__Group__3"


    // $ANTLR start "rule__BackgroundGravityProperty__Group__3__Impl"
    // InternalLatteCSS.g:6310:1: rule__BackgroundGravityProperty__Group__3__Impl : ( ( rule__BackgroundGravityProperty__Group_3__0 )* ) ;
    public final void rule__BackgroundGravityProperty__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalLatteCSS.g:6314:1: ( ( ( rule__BackgroundGravityProperty__Group_3__0 )* ) )
            // InternalLatteCSS.g:6315:1: ( ( rule__BackgroundGravityProperty__Group_3__0 )* )
            {
            // InternalLatteCSS.g:6315:1: ( ( rule__BackgroundGravityProperty__Group_3__0 )* )
            // InternalLatteCSS.g:6316:1: ( rule__BackgroundGravityProperty__Group_3__0 )*
            {
             before(grammarAccess.getBackgroundGravityPropertyAccess().getGroup_3()); 
            // InternalLatteCSS.g:6317:1: ( rule__BackgroundGravityProperty__Group_3__0 )*
            loop43:
            do {
                int alt43=2;
                int LA43_0 = input.LA(1);

                if ( (LA43_0==276) ) {
                    alt43=1;
                }


                switch (alt43) {
            	case 1 :
            	    // InternalLatteCSS.g:6317:2: rule__BackgroundGravityProperty__Group_3__0
            	    {
            	    pushFollow(FOLLOW_5);
            	    rule__BackgroundGravityProperty__Group_3__0();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop43;
                }
            } while (true);

             after(grammarAccess.getBackgroundGravityPropertyAccess().getGroup_3()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__BackgroundGravityProperty__Group__3__Impl"


    // $ANTLR start "rule__BackgroundGravityProperty__Group_3__0"
    // InternalLatteCSS.g:6335:1: rule__BackgroundGravityProperty__Group_3__0 : rule__BackgroundGravityProperty__Group_3__0__Impl rule__BackgroundGravityProperty__Group_3__1 ;
    public final void rule__BackgroundGravityProperty__Group_3__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalLatteCSS.g:6339:1: ( rule__BackgroundGravityProperty__Group_3__0__Impl rule__BackgroundGravityProperty__Group_3__1 )
            // InternalLatteCSS.g:6340:2: rule__BackgroundGravityProperty__Group_3__0__Impl rule__BackgroundGravityProperty__Group_3__1
            {
            pushFollow(FOLLOW_25);
            rule__BackgroundGravityProperty__Group_3__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__BackgroundGravityProperty__Group_3__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__BackgroundGravityProperty__Group_3__0"


    // $ANTLR start "rule__BackgroundGravityProperty__Group_3__0__Impl"
    // InternalLatteCSS.g:6347:1: rule__BackgroundGravityProperty__Group_3__0__Impl : ( ',' ) ;
    public final void rule__BackgroundGravityProperty__Group_3__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalLatteCSS.g:6351:1: ( ( ',' ) )
            // InternalLatteCSS.g:6352:1: ( ',' )
            {
            // InternalLatteCSS.g:6352:1: ( ',' )
            // InternalLatteCSS.g:6353:1: ','
            {
             before(grammarAccess.getBackgroundGravityPropertyAccess().getCommaKeyword_3_0()); 
            match(input,276,FOLLOW_2); 
             after(grammarAccess.getBackgroundGravityPropertyAccess().getCommaKeyword_3_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__BackgroundGravityProperty__Group_3__0__Impl"


    // $ANTLR start "rule__BackgroundGravityProperty__Group_3__1"
    // InternalLatteCSS.g:6366:1: rule__BackgroundGravityProperty__Group_3__1 : rule__BackgroundGravityProperty__Group_3__1__Impl ;
    public final void rule__BackgroundGravityProperty__Group_3__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalLatteCSS.g:6370:1: ( rule__BackgroundGravityProperty__Group_3__1__Impl )
            // InternalLatteCSS.g:6371:2: rule__BackgroundGravityProperty__Group_3__1__Impl
            {
            pushFollow(FOLLOW_2);
            rule__BackgroundGravityProperty__Group_3__1__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__BackgroundGravityProperty__Group_3__1"


    // $ANTLR start "rule__BackgroundGravityProperty__Group_3__1__Impl"
    // InternalLatteCSS.g:6377:1: rule__BackgroundGravityProperty__Group_3__1__Impl : ( ( rule__BackgroundGravityProperty__ValuesAssignment_3_1 ) ) ;
    public final void rule__BackgroundGravityProperty__Group_3__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalLatteCSS.g:6381:1: ( ( ( rule__BackgroundGravityProperty__ValuesAssignment_3_1 ) ) )
            // InternalLatteCSS.g:6382:1: ( ( rule__BackgroundGravityProperty__ValuesAssignment_3_1 ) )
            {
            // InternalLatteCSS.g:6382:1: ( ( rule__BackgroundGravityProperty__ValuesAssignment_3_1 ) )
            // InternalLatteCSS.g:6383:1: ( rule__BackgroundGravityProperty__ValuesAssignment_3_1 )
            {
             before(grammarAccess.getBackgroundGravityPropertyAccess().getValuesAssignment_3_1()); 
            // InternalLatteCSS.g:6384:1: ( rule__BackgroundGravityProperty__ValuesAssignment_3_1 )
            // InternalLatteCSS.g:6384:2: rule__BackgroundGravityProperty__ValuesAssignment_3_1
            {
            pushFollow(FOLLOW_2);
            rule__BackgroundGravityProperty__ValuesAssignment_3_1();

            state._fsp--;


            }

             after(grammarAccess.getBackgroundGravityPropertyAccess().getValuesAssignment_3_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__BackgroundGravityProperty__Group_3__1__Impl"


    // $ANTLR start "rule__BackgroundFilterTypeProperty__Group__0"
    // InternalLatteCSS.g:6398:1: rule__BackgroundFilterTypeProperty__Group__0 : rule__BackgroundFilterTypeProperty__Group__0__Impl rule__BackgroundFilterTypeProperty__Group__1 ;
    public final void rule__BackgroundFilterTypeProperty__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalLatteCSS.g:6402:1: ( rule__BackgroundFilterTypeProperty__Group__0__Impl rule__BackgroundFilterTypeProperty__Group__1 )
            // InternalLatteCSS.g:6403:2: rule__BackgroundFilterTypeProperty__Group__0__Impl rule__BackgroundFilterTypeProperty__Group__1
            {
            pushFollow(FOLLOW_10);
            rule__BackgroundFilterTypeProperty__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__BackgroundFilterTypeProperty__Group__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__BackgroundFilterTypeProperty__Group__0"


    // $ANTLR start "rule__BackgroundFilterTypeProperty__Group__0__Impl"
    // InternalLatteCSS.g:6410:1: rule__BackgroundFilterTypeProperty__Group__0__Impl : ( ( rule__BackgroundFilterTypeProperty__PropertyAssignment_0 ) ) ;
    public final void rule__BackgroundFilterTypeProperty__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalLatteCSS.g:6414:1: ( ( ( rule__BackgroundFilterTypeProperty__PropertyAssignment_0 ) ) )
            // InternalLatteCSS.g:6415:1: ( ( rule__BackgroundFilterTypeProperty__PropertyAssignment_0 ) )
            {
            // InternalLatteCSS.g:6415:1: ( ( rule__BackgroundFilterTypeProperty__PropertyAssignment_0 ) )
            // InternalLatteCSS.g:6416:1: ( rule__BackgroundFilterTypeProperty__PropertyAssignment_0 )
            {
             before(grammarAccess.getBackgroundFilterTypePropertyAccess().getPropertyAssignment_0()); 
            // InternalLatteCSS.g:6417:1: ( rule__BackgroundFilterTypeProperty__PropertyAssignment_0 )
            // InternalLatteCSS.g:6417:2: rule__BackgroundFilterTypeProperty__PropertyAssignment_0
            {
            pushFollow(FOLLOW_2);
            rule__BackgroundFilterTypeProperty__PropertyAssignment_0();

            state._fsp--;


            }

             after(grammarAccess.getBackgroundFilterTypePropertyAccess().getPropertyAssignment_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__BackgroundFilterTypeProperty__Group__0__Impl"


    // $ANTLR start "rule__BackgroundFilterTypeProperty__Group__1"
    // InternalLatteCSS.g:6427:1: rule__BackgroundFilterTypeProperty__Group__1 : rule__BackgroundFilterTypeProperty__Group__1__Impl rule__BackgroundFilterTypeProperty__Group__2 ;
    public final void rule__BackgroundFilterTypeProperty__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalLatteCSS.g:6431:1: ( rule__BackgroundFilterTypeProperty__Group__1__Impl rule__BackgroundFilterTypeProperty__Group__2 )
            // InternalLatteCSS.g:6432:2: rule__BackgroundFilterTypeProperty__Group__1__Impl rule__BackgroundFilterTypeProperty__Group__2
            {
            pushFollow(FOLLOW_24);
            rule__BackgroundFilterTypeProperty__Group__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__BackgroundFilterTypeProperty__Group__2();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__BackgroundFilterTypeProperty__Group__1"


    // $ANTLR start "rule__BackgroundFilterTypeProperty__Group__1__Impl"
    // InternalLatteCSS.g:6439:1: rule__BackgroundFilterTypeProperty__Group__1__Impl : ( ':' ) ;
    public final void rule__BackgroundFilterTypeProperty__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalLatteCSS.g:6443:1: ( ( ':' ) )
            // InternalLatteCSS.g:6444:1: ( ':' )
            {
            // InternalLatteCSS.g:6444:1: ( ':' )
            // InternalLatteCSS.g:6445:1: ':'
            {
             before(grammarAccess.getBackgroundFilterTypePropertyAccess().getColonKeyword_1()); 
            match(input,279,FOLLOW_2); 
             after(grammarAccess.getBackgroundFilterTypePropertyAccess().getColonKeyword_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__BackgroundFilterTypeProperty__Group__1__Impl"


    // $ANTLR start "rule__BackgroundFilterTypeProperty__Group__2"
    // InternalLatteCSS.g:6458:1: rule__BackgroundFilterTypeProperty__Group__2 : rule__BackgroundFilterTypeProperty__Group__2__Impl ;
    public final void rule__BackgroundFilterTypeProperty__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalLatteCSS.g:6462:1: ( rule__BackgroundFilterTypeProperty__Group__2__Impl )
            // InternalLatteCSS.g:6463:2: rule__BackgroundFilterTypeProperty__Group__2__Impl
            {
            pushFollow(FOLLOW_2);
            rule__BackgroundFilterTypeProperty__Group__2__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__BackgroundFilterTypeProperty__Group__2"


    // $ANTLR start "rule__BackgroundFilterTypeProperty__Group__2__Impl"
    // InternalLatteCSS.g:6469:1: rule__BackgroundFilterTypeProperty__Group__2__Impl : ( ( rule__BackgroundFilterTypeProperty__ValueAssignment_2 ) ) ;
    public final void rule__BackgroundFilterTypeProperty__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalLatteCSS.g:6473:1: ( ( ( rule__BackgroundFilterTypeProperty__ValueAssignment_2 ) ) )
            // InternalLatteCSS.g:6474:1: ( ( rule__BackgroundFilterTypeProperty__ValueAssignment_2 ) )
            {
            // InternalLatteCSS.g:6474:1: ( ( rule__BackgroundFilterTypeProperty__ValueAssignment_2 ) )
            // InternalLatteCSS.g:6475:1: ( rule__BackgroundFilterTypeProperty__ValueAssignment_2 )
            {
             before(grammarAccess.getBackgroundFilterTypePropertyAccess().getValueAssignment_2()); 
            // InternalLatteCSS.g:6476:1: ( rule__BackgroundFilterTypeProperty__ValueAssignment_2 )
            // InternalLatteCSS.g:6476:2: rule__BackgroundFilterTypeProperty__ValueAssignment_2
            {
            pushFollow(FOLLOW_2);
            rule__BackgroundFilterTypeProperty__ValueAssignment_2();

            state._fsp--;


            }

             after(grammarAccess.getBackgroundFilterTypePropertyAccess().getValueAssignment_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__BackgroundFilterTypeProperty__Group__2__Impl"


    // $ANTLR start "rule__ShorthandColorProperty__Group__0"
    // InternalLatteCSS.g:6492:1: rule__ShorthandColorProperty__Group__0 : rule__ShorthandColorProperty__Group__0__Impl rule__ShorthandColorProperty__Group__1 ;
    public final void rule__ShorthandColorProperty__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalLatteCSS.g:6496:1: ( rule__ShorthandColorProperty__Group__0__Impl rule__ShorthandColorProperty__Group__1 )
            // InternalLatteCSS.g:6497:2: rule__ShorthandColorProperty__Group__0__Impl rule__ShorthandColorProperty__Group__1
            {
            pushFollow(FOLLOW_10);
            rule__ShorthandColorProperty__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__ShorthandColorProperty__Group__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ShorthandColorProperty__Group__0"


    // $ANTLR start "rule__ShorthandColorProperty__Group__0__Impl"
    // InternalLatteCSS.g:6504:1: rule__ShorthandColorProperty__Group__0__Impl : ( ( rule__ShorthandColorProperty__PropertyAssignment_0 ) ) ;
    public final void rule__ShorthandColorProperty__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalLatteCSS.g:6508:1: ( ( ( rule__ShorthandColorProperty__PropertyAssignment_0 ) ) )
            // InternalLatteCSS.g:6509:1: ( ( rule__ShorthandColorProperty__PropertyAssignment_0 ) )
            {
            // InternalLatteCSS.g:6509:1: ( ( rule__ShorthandColorProperty__PropertyAssignment_0 ) )
            // InternalLatteCSS.g:6510:1: ( rule__ShorthandColorProperty__PropertyAssignment_0 )
            {
             before(grammarAccess.getShorthandColorPropertyAccess().getPropertyAssignment_0()); 
            // InternalLatteCSS.g:6511:1: ( rule__ShorthandColorProperty__PropertyAssignment_0 )
            // InternalLatteCSS.g:6511:2: rule__ShorthandColorProperty__PropertyAssignment_0
            {
            pushFollow(FOLLOW_2);
            rule__ShorthandColorProperty__PropertyAssignment_0();

            state._fsp--;


            }

             after(grammarAccess.getShorthandColorPropertyAccess().getPropertyAssignment_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ShorthandColorProperty__Group__0__Impl"


    // $ANTLR start "rule__ShorthandColorProperty__Group__1"
    // InternalLatteCSS.g:6521:1: rule__ShorthandColorProperty__Group__1 : rule__ShorthandColorProperty__Group__1__Impl rule__ShorthandColorProperty__Group__2 ;
    public final void rule__ShorthandColorProperty__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalLatteCSS.g:6525:1: ( rule__ShorthandColorProperty__Group__1__Impl rule__ShorthandColorProperty__Group__2 )
            // InternalLatteCSS.g:6526:2: rule__ShorthandColorProperty__Group__1__Impl rule__ShorthandColorProperty__Group__2
            {
            pushFollow(FOLLOW_18);
            rule__ShorthandColorProperty__Group__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__ShorthandColorProperty__Group__2();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ShorthandColorProperty__Group__1"


    // $ANTLR start "rule__ShorthandColorProperty__Group__1__Impl"
    // InternalLatteCSS.g:6533:1: rule__ShorthandColorProperty__Group__1__Impl : ( ':' ) ;
    public final void rule__ShorthandColorProperty__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalLatteCSS.g:6537:1: ( ( ':' ) )
            // InternalLatteCSS.g:6538:1: ( ':' )
            {
            // InternalLatteCSS.g:6538:1: ( ':' )
            // InternalLatteCSS.g:6539:1: ':'
            {
             before(grammarAccess.getShorthandColorPropertyAccess().getColonKeyword_1()); 
            match(input,279,FOLLOW_2); 
             after(grammarAccess.getShorthandColorPropertyAccess().getColonKeyword_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ShorthandColorProperty__Group__1__Impl"


    // $ANTLR start "rule__ShorthandColorProperty__Group__2"
    // InternalLatteCSS.g:6552:1: rule__ShorthandColorProperty__Group__2 : rule__ShorthandColorProperty__Group__2__Impl ;
    public final void rule__ShorthandColorProperty__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalLatteCSS.g:6556:1: ( rule__ShorthandColorProperty__Group__2__Impl )
            // InternalLatteCSS.g:6557:2: rule__ShorthandColorProperty__Group__2__Impl
            {
            pushFollow(FOLLOW_2);
            rule__ShorthandColorProperty__Group__2__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ShorthandColorProperty__Group__2"


    // $ANTLR start "rule__ShorthandColorProperty__Group__2__Impl"
    // InternalLatteCSS.g:6563:1: rule__ShorthandColorProperty__Group__2__Impl : ( ( ( rule__ShorthandColorProperty__ValuesAssignment_2 ) ) ( ( rule__ShorthandColorProperty__ValuesAssignment_2 )* ) ) ;
    public final void rule__ShorthandColorProperty__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalLatteCSS.g:6567:1: ( ( ( ( rule__ShorthandColorProperty__ValuesAssignment_2 ) ) ( ( rule__ShorthandColorProperty__ValuesAssignment_2 )* ) ) )
            // InternalLatteCSS.g:6568:1: ( ( ( rule__ShorthandColorProperty__ValuesAssignment_2 ) ) ( ( rule__ShorthandColorProperty__ValuesAssignment_2 )* ) )
            {
            // InternalLatteCSS.g:6568:1: ( ( ( rule__ShorthandColorProperty__ValuesAssignment_2 ) ) ( ( rule__ShorthandColorProperty__ValuesAssignment_2 )* ) )
            // InternalLatteCSS.g:6569:1: ( ( rule__ShorthandColorProperty__ValuesAssignment_2 ) ) ( ( rule__ShorthandColorProperty__ValuesAssignment_2 )* )
            {
            // InternalLatteCSS.g:6569:1: ( ( rule__ShorthandColorProperty__ValuesAssignment_2 ) )
            // InternalLatteCSS.g:6570:1: ( rule__ShorthandColorProperty__ValuesAssignment_2 )
            {
             before(grammarAccess.getShorthandColorPropertyAccess().getValuesAssignment_2()); 
            // InternalLatteCSS.g:6571:1: ( rule__ShorthandColorProperty__ValuesAssignment_2 )
            // InternalLatteCSS.g:6571:2: rule__ShorthandColorProperty__ValuesAssignment_2
            {
            pushFollow(FOLLOW_26);
            rule__ShorthandColorProperty__ValuesAssignment_2();

            state._fsp--;


            }

             after(grammarAccess.getShorthandColorPropertyAccess().getValuesAssignment_2()); 

            }

            // InternalLatteCSS.g:6574:1: ( ( rule__ShorthandColorProperty__ValuesAssignment_2 )* )
            // InternalLatteCSS.g:6575:1: ( rule__ShorthandColorProperty__ValuesAssignment_2 )*
            {
             before(grammarAccess.getShorthandColorPropertyAccess().getValuesAssignment_2()); 
            // InternalLatteCSS.g:6576:1: ( rule__ShorthandColorProperty__ValuesAssignment_2 )*
            loop44:
            do {
                int alt44=2;
                int LA44_0 = input.LA(1);

                if ( (LA44_0==RULE_HEX_NUMBER||(LA44_0>=126 && LA44_0<=273)||(LA44_0>=287 && LA44_0<=288)) ) {
                    alt44=1;
                }


                switch (alt44) {
            	case 1 :
            	    // InternalLatteCSS.g:6576:2: rule__ShorthandColorProperty__ValuesAssignment_2
            	    {
            	    pushFollow(FOLLOW_26);
            	    rule__ShorthandColorProperty__ValuesAssignment_2();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop44;
                }
            } while (true);

             after(grammarAccess.getShorthandColorPropertyAccess().getValuesAssignment_2()); 

            }


            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ShorthandColorProperty__Group__2__Impl"


    // $ANTLR start "rule__ColorProperty__Group__0"
    // InternalLatteCSS.g:6593:1: rule__ColorProperty__Group__0 : rule__ColorProperty__Group__0__Impl rule__ColorProperty__Group__1 ;
    public final void rule__ColorProperty__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalLatteCSS.g:6597:1: ( rule__ColorProperty__Group__0__Impl rule__ColorProperty__Group__1 )
            // InternalLatteCSS.g:6598:2: rule__ColorProperty__Group__0__Impl rule__ColorProperty__Group__1
            {
            pushFollow(FOLLOW_10);
            rule__ColorProperty__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__ColorProperty__Group__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ColorProperty__Group__0"


    // $ANTLR start "rule__ColorProperty__Group__0__Impl"
    // InternalLatteCSS.g:6605:1: rule__ColorProperty__Group__0__Impl : ( ( rule__ColorProperty__PropertyAssignment_0 ) ) ;
    public final void rule__ColorProperty__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalLatteCSS.g:6609:1: ( ( ( rule__ColorProperty__PropertyAssignment_0 ) ) )
            // InternalLatteCSS.g:6610:1: ( ( rule__ColorProperty__PropertyAssignment_0 ) )
            {
            // InternalLatteCSS.g:6610:1: ( ( rule__ColorProperty__PropertyAssignment_0 ) )
            // InternalLatteCSS.g:6611:1: ( rule__ColorProperty__PropertyAssignment_0 )
            {
             before(grammarAccess.getColorPropertyAccess().getPropertyAssignment_0()); 
            // InternalLatteCSS.g:6612:1: ( rule__ColorProperty__PropertyAssignment_0 )
            // InternalLatteCSS.g:6612:2: rule__ColorProperty__PropertyAssignment_0
            {
            pushFollow(FOLLOW_2);
            rule__ColorProperty__PropertyAssignment_0();

            state._fsp--;


            }

             after(grammarAccess.getColorPropertyAccess().getPropertyAssignment_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ColorProperty__Group__0__Impl"


    // $ANTLR start "rule__ColorProperty__Group__1"
    // InternalLatteCSS.g:6622:1: rule__ColorProperty__Group__1 : rule__ColorProperty__Group__1__Impl rule__ColorProperty__Group__2 ;
    public final void rule__ColorProperty__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalLatteCSS.g:6626:1: ( rule__ColorProperty__Group__1__Impl rule__ColorProperty__Group__2 )
            // InternalLatteCSS.g:6627:2: rule__ColorProperty__Group__1__Impl rule__ColorProperty__Group__2
            {
            pushFollow(FOLLOW_18);
            rule__ColorProperty__Group__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__ColorProperty__Group__2();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ColorProperty__Group__1"


    // $ANTLR start "rule__ColorProperty__Group__1__Impl"
    // InternalLatteCSS.g:6634:1: rule__ColorProperty__Group__1__Impl : ( ':' ) ;
    public final void rule__ColorProperty__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalLatteCSS.g:6638:1: ( ( ':' ) )
            // InternalLatteCSS.g:6639:1: ( ':' )
            {
            // InternalLatteCSS.g:6639:1: ( ':' )
            // InternalLatteCSS.g:6640:1: ':'
            {
             before(grammarAccess.getColorPropertyAccess().getColonKeyword_1()); 
            match(input,279,FOLLOW_2); 
             after(grammarAccess.getColorPropertyAccess().getColonKeyword_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ColorProperty__Group__1__Impl"


    // $ANTLR start "rule__ColorProperty__Group__2"
    // InternalLatteCSS.g:6653:1: rule__ColorProperty__Group__2 : rule__ColorProperty__Group__2__Impl ;
    public final void rule__ColorProperty__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalLatteCSS.g:6657:1: ( rule__ColorProperty__Group__2__Impl )
            // InternalLatteCSS.g:6658:2: rule__ColorProperty__Group__2__Impl
            {
            pushFollow(FOLLOW_2);
            rule__ColorProperty__Group__2__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ColorProperty__Group__2"


    // $ANTLR start "rule__ColorProperty__Group__2__Impl"
    // InternalLatteCSS.g:6664:1: rule__ColorProperty__Group__2__Impl : ( ( rule__ColorProperty__ValueAssignment_2 ) ) ;
    public final void rule__ColorProperty__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalLatteCSS.g:6668:1: ( ( ( rule__ColorProperty__ValueAssignment_2 ) ) )
            // InternalLatteCSS.g:6669:1: ( ( rule__ColorProperty__ValueAssignment_2 ) )
            {
            // InternalLatteCSS.g:6669:1: ( ( rule__ColorProperty__ValueAssignment_2 ) )
            // InternalLatteCSS.g:6670:1: ( rule__ColorProperty__ValueAssignment_2 )
            {
             before(grammarAccess.getColorPropertyAccess().getValueAssignment_2()); 
            // InternalLatteCSS.g:6671:1: ( rule__ColorProperty__ValueAssignment_2 )
            // InternalLatteCSS.g:6671:2: rule__ColorProperty__ValueAssignment_2
            {
            pushFollow(FOLLOW_2);
            rule__ColorProperty__ValueAssignment_2();

            state._fsp--;


            }

             after(grammarAccess.getColorPropertyAccess().getValueAssignment_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ColorProperty__Group__2__Impl"


    // $ANTLR start "rule__AlignmentProperty__Group__0"
    // InternalLatteCSS.g:6687:1: rule__AlignmentProperty__Group__0 : rule__AlignmentProperty__Group__0__Impl rule__AlignmentProperty__Group__1 ;
    public final void rule__AlignmentProperty__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalLatteCSS.g:6691:1: ( rule__AlignmentProperty__Group__0__Impl rule__AlignmentProperty__Group__1 )
            // InternalLatteCSS.g:6692:2: rule__AlignmentProperty__Group__0__Impl rule__AlignmentProperty__Group__1
            {
            pushFollow(FOLLOW_10);
            rule__AlignmentProperty__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__AlignmentProperty__Group__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__AlignmentProperty__Group__0"


    // $ANTLR start "rule__AlignmentProperty__Group__0__Impl"
    // InternalLatteCSS.g:6699:1: rule__AlignmentProperty__Group__0__Impl : ( ( rule__AlignmentProperty__PropertyAssignment_0 ) ) ;
    public final void rule__AlignmentProperty__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalLatteCSS.g:6703:1: ( ( ( rule__AlignmentProperty__PropertyAssignment_0 ) ) )
            // InternalLatteCSS.g:6704:1: ( ( rule__AlignmentProperty__PropertyAssignment_0 ) )
            {
            // InternalLatteCSS.g:6704:1: ( ( rule__AlignmentProperty__PropertyAssignment_0 ) )
            // InternalLatteCSS.g:6705:1: ( rule__AlignmentProperty__PropertyAssignment_0 )
            {
             before(grammarAccess.getAlignmentPropertyAccess().getPropertyAssignment_0()); 
            // InternalLatteCSS.g:6706:1: ( rule__AlignmentProperty__PropertyAssignment_0 )
            // InternalLatteCSS.g:6706:2: rule__AlignmentProperty__PropertyAssignment_0
            {
            pushFollow(FOLLOW_2);
            rule__AlignmentProperty__PropertyAssignment_0();

            state._fsp--;


            }

             after(grammarAccess.getAlignmentPropertyAccess().getPropertyAssignment_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__AlignmentProperty__Group__0__Impl"


    // $ANTLR start "rule__AlignmentProperty__Group__1"
    // InternalLatteCSS.g:6716:1: rule__AlignmentProperty__Group__1 : rule__AlignmentProperty__Group__1__Impl rule__AlignmentProperty__Group__2 ;
    public final void rule__AlignmentProperty__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalLatteCSS.g:6720:1: ( rule__AlignmentProperty__Group__1__Impl rule__AlignmentProperty__Group__2 )
            // InternalLatteCSS.g:6721:2: rule__AlignmentProperty__Group__1__Impl rule__AlignmentProperty__Group__2
            {
            pushFollow(FOLLOW_27);
            rule__AlignmentProperty__Group__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__AlignmentProperty__Group__2();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__AlignmentProperty__Group__1"


    // $ANTLR start "rule__AlignmentProperty__Group__1__Impl"
    // InternalLatteCSS.g:6728:1: rule__AlignmentProperty__Group__1__Impl : ( ':' ) ;
    public final void rule__AlignmentProperty__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalLatteCSS.g:6732:1: ( ( ':' ) )
            // InternalLatteCSS.g:6733:1: ( ':' )
            {
            // InternalLatteCSS.g:6733:1: ( ':' )
            // InternalLatteCSS.g:6734:1: ':'
            {
             before(grammarAccess.getAlignmentPropertyAccess().getColonKeyword_1()); 
            match(input,279,FOLLOW_2); 
             after(grammarAccess.getAlignmentPropertyAccess().getColonKeyword_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__AlignmentProperty__Group__1__Impl"


    // $ANTLR start "rule__AlignmentProperty__Group__2"
    // InternalLatteCSS.g:6747:1: rule__AlignmentProperty__Group__2 : rule__AlignmentProperty__Group__2__Impl ;
    public final void rule__AlignmentProperty__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalLatteCSS.g:6751:1: ( rule__AlignmentProperty__Group__2__Impl )
            // InternalLatteCSS.g:6752:2: rule__AlignmentProperty__Group__2__Impl
            {
            pushFollow(FOLLOW_2);
            rule__AlignmentProperty__Group__2__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__AlignmentProperty__Group__2"


    // $ANTLR start "rule__AlignmentProperty__Group__2__Impl"
    // InternalLatteCSS.g:6758:1: rule__AlignmentProperty__Group__2__Impl : ( ( rule__AlignmentProperty__ValueAssignment_2 ) ) ;
    public final void rule__AlignmentProperty__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalLatteCSS.g:6762:1: ( ( ( rule__AlignmentProperty__ValueAssignment_2 ) ) )
            // InternalLatteCSS.g:6763:1: ( ( rule__AlignmentProperty__ValueAssignment_2 ) )
            {
            // InternalLatteCSS.g:6763:1: ( ( rule__AlignmentProperty__ValueAssignment_2 ) )
            // InternalLatteCSS.g:6764:1: ( rule__AlignmentProperty__ValueAssignment_2 )
            {
             before(grammarAccess.getAlignmentPropertyAccess().getValueAssignment_2()); 
            // InternalLatteCSS.g:6765:1: ( rule__AlignmentProperty__ValueAssignment_2 )
            // InternalLatteCSS.g:6765:2: rule__AlignmentProperty__ValueAssignment_2
            {
            pushFollow(FOLLOW_2);
            rule__AlignmentProperty__ValueAssignment_2();

            state._fsp--;


            }

             after(grammarAccess.getAlignmentPropertyAccess().getValueAssignment_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__AlignmentProperty__Group__2__Impl"


    // $ANTLR start "rule__TimeValue__Group__0"
    // InternalLatteCSS.g:6781:1: rule__TimeValue__Group__0 : rule__TimeValue__Group__0__Impl rule__TimeValue__Group__1 ;
    public final void rule__TimeValue__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalLatteCSS.g:6785:1: ( rule__TimeValue__Group__0__Impl rule__TimeValue__Group__1 )
            // InternalLatteCSS.g:6786:2: rule__TimeValue__Group__0__Impl rule__TimeValue__Group__1
            {
            pushFollow(FOLLOW_28);
            rule__TimeValue__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__TimeValue__Group__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__TimeValue__Group__0"


    // $ANTLR start "rule__TimeValue__Group__0__Impl"
    // InternalLatteCSS.g:6793:1: rule__TimeValue__Group__0__Impl : ( ( rule__TimeValue__TimeAssignment_0 ) ) ;
    public final void rule__TimeValue__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalLatteCSS.g:6797:1: ( ( ( rule__TimeValue__TimeAssignment_0 ) ) )
            // InternalLatteCSS.g:6798:1: ( ( rule__TimeValue__TimeAssignment_0 ) )
            {
            // InternalLatteCSS.g:6798:1: ( ( rule__TimeValue__TimeAssignment_0 ) )
            // InternalLatteCSS.g:6799:1: ( rule__TimeValue__TimeAssignment_0 )
            {
             before(grammarAccess.getTimeValueAccess().getTimeAssignment_0()); 
            // InternalLatteCSS.g:6800:1: ( rule__TimeValue__TimeAssignment_0 )
            // InternalLatteCSS.g:6800:2: rule__TimeValue__TimeAssignment_0
            {
            pushFollow(FOLLOW_2);
            rule__TimeValue__TimeAssignment_0();

            state._fsp--;


            }

             after(grammarAccess.getTimeValueAccess().getTimeAssignment_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__TimeValue__Group__0__Impl"


    // $ANTLR start "rule__TimeValue__Group__1"
    // InternalLatteCSS.g:6810:1: rule__TimeValue__Group__1 : rule__TimeValue__Group__1__Impl ;
    public final void rule__TimeValue__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalLatteCSS.g:6814:1: ( rule__TimeValue__Group__1__Impl )
            // InternalLatteCSS.g:6815:2: rule__TimeValue__Group__1__Impl
            {
            pushFollow(FOLLOW_2);
            rule__TimeValue__Group__1__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__TimeValue__Group__1"


    // $ANTLR start "rule__TimeValue__Group__1__Impl"
    // InternalLatteCSS.g:6821:1: rule__TimeValue__Group__1__Impl : ( ( rule__TimeValue__UnitAssignment_1 ) ) ;
    public final void rule__TimeValue__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalLatteCSS.g:6825:1: ( ( ( rule__TimeValue__UnitAssignment_1 ) ) )
            // InternalLatteCSS.g:6826:1: ( ( rule__TimeValue__UnitAssignment_1 ) )
            {
            // InternalLatteCSS.g:6826:1: ( ( rule__TimeValue__UnitAssignment_1 ) )
            // InternalLatteCSS.g:6827:1: ( rule__TimeValue__UnitAssignment_1 )
            {
             before(grammarAccess.getTimeValueAccess().getUnitAssignment_1()); 
            // InternalLatteCSS.g:6828:1: ( rule__TimeValue__UnitAssignment_1 )
            // InternalLatteCSS.g:6828:2: rule__TimeValue__UnitAssignment_1
            {
            pushFollow(FOLLOW_2);
            rule__TimeValue__UnitAssignment_1();

            state._fsp--;


            }

             after(grammarAccess.getTimeValueAccess().getUnitAssignment_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__TimeValue__Group__1__Impl"


    // $ANTLR start "rule__SizeValue__Group__0"
    // InternalLatteCSS.g:6842:1: rule__SizeValue__Group__0 : rule__SizeValue__Group__0__Impl rule__SizeValue__Group__1 ;
    public final void rule__SizeValue__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalLatteCSS.g:6846:1: ( rule__SizeValue__Group__0__Impl rule__SizeValue__Group__1 )
            // InternalLatteCSS.g:6847:2: rule__SizeValue__Group__0__Impl rule__SizeValue__Group__1
            {
            pushFollow(FOLLOW_29);
            rule__SizeValue__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__SizeValue__Group__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__SizeValue__Group__0"


    // $ANTLR start "rule__SizeValue__Group__0__Impl"
    // InternalLatteCSS.g:6854:1: rule__SizeValue__Group__0__Impl : ( ( rule__SizeValue__ValueAssignment_0 ) ) ;
    public final void rule__SizeValue__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalLatteCSS.g:6858:1: ( ( ( rule__SizeValue__ValueAssignment_0 ) ) )
            // InternalLatteCSS.g:6859:1: ( ( rule__SizeValue__ValueAssignment_0 ) )
            {
            // InternalLatteCSS.g:6859:1: ( ( rule__SizeValue__ValueAssignment_0 ) )
            // InternalLatteCSS.g:6860:1: ( rule__SizeValue__ValueAssignment_0 )
            {
             before(grammarAccess.getSizeValueAccess().getValueAssignment_0()); 
            // InternalLatteCSS.g:6861:1: ( rule__SizeValue__ValueAssignment_0 )
            // InternalLatteCSS.g:6861:2: rule__SizeValue__ValueAssignment_0
            {
            pushFollow(FOLLOW_2);
            rule__SizeValue__ValueAssignment_0();

            state._fsp--;


            }

             after(grammarAccess.getSizeValueAccess().getValueAssignment_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__SizeValue__Group__0__Impl"


    // $ANTLR start "rule__SizeValue__Group__1"
    // InternalLatteCSS.g:6871:1: rule__SizeValue__Group__1 : rule__SizeValue__Group__1__Impl ;
    public final void rule__SizeValue__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalLatteCSS.g:6875:1: ( rule__SizeValue__Group__1__Impl )
            // InternalLatteCSS.g:6876:2: rule__SizeValue__Group__1__Impl
            {
            pushFollow(FOLLOW_2);
            rule__SizeValue__Group__1__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__SizeValue__Group__1"


    // $ANTLR start "rule__SizeValue__Group__1__Impl"
    // InternalLatteCSS.g:6882:1: rule__SizeValue__Group__1__Impl : ( ( rule__SizeValue__DimensionAssignment_1 )? ) ;
    public final void rule__SizeValue__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalLatteCSS.g:6886:1: ( ( ( rule__SizeValue__DimensionAssignment_1 )? ) )
            // InternalLatteCSS.g:6887:1: ( ( rule__SizeValue__DimensionAssignment_1 )? )
            {
            // InternalLatteCSS.g:6887:1: ( ( rule__SizeValue__DimensionAssignment_1 )? )
            // InternalLatteCSS.g:6888:1: ( rule__SizeValue__DimensionAssignment_1 )?
            {
             before(grammarAccess.getSizeValueAccess().getDimensionAssignment_1()); 
            // InternalLatteCSS.g:6889:1: ( rule__SizeValue__DimensionAssignment_1 )?
            int alt45=2;
            int LA45_0 = input.LA(1);

            if ( ((LA45_0>=119 && LA45_0<=123)) ) {
                alt45=1;
            }
            switch (alt45) {
                case 1 :
                    // InternalLatteCSS.g:6889:2: rule__SizeValue__DimensionAssignment_1
                    {
                    pushFollow(FOLLOW_2);
                    rule__SizeValue__DimensionAssignment_1();

                    state._fsp--;


                    }
                    break;

            }

             after(grammarAccess.getSizeValueAccess().getDimensionAssignment_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__SizeValue__Group__1__Impl"


    // $ANTLR start "rule__LinearGradient__Group__0"
    // InternalLatteCSS.g:6903:1: rule__LinearGradient__Group__0 : rule__LinearGradient__Group__0__Impl rule__LinearGradient__Group__1 ;
    public final void rule__LinearGradient__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalLatteCSS.g:6907:1: ( rule__LinearGradient__Group__0__Impl rule__LinearGradient__Group__1 )
            // InternalLatteCSS.g:6908:2: rule__LinearGradient__Group__0__Impl rule__LinearGradient__Group__1
            {
            pushFollow(FOLLOW_30);
            rule__LinearGradient__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__LinearGradient__Group__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__LinearGradient__Group__0"


    // $ANTLR start "rule__LinearGradient__Group__0__Impl"
    // InternalLatteCSS.g:6915:1: rule__LinearGradient__Group__0__Impl : ( 'linear' ) ;
    public final void rule__LinearGradient__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalLatteCSS.g:6919:1: ( ( 'linear' ) )
            // InternalLatteCSS.g:6920:1: ( 'linear' )
            {
            // InternalLatteCSS.g:6920:1: ( 'linear' )
            // InternalLatteCSS.g:6921:1: 'linear'
            {
             before(grammarAccess.getLinearGradientAccess().getLinearKeyword_0()); 
            match(input,110,FOLLOW_2); 
             after(grammarAccess.getLinearGradientAccess().getLinearKeyword_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__LinearGradient__Group__0__Impl"


    // $ANTLR start "rule__LinearGradient__Group__1"
    // InternalLatteCSS.g:6934:1: rule__LinearGradient__Group__1 : rule__LinearGradient__Group__1__Impl rule__LinearGradient__Group__2 ;
    public final void rule__LinearGradient__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalLatteCSS.g:6938:1: ( rule__LinearGradient__Group__1__Impl rule__LinearGradient__Group__2 )
            // InternalLatteCSS.g:6939:2: rule__LinearGradient__Group__1__Impl rule__LinearGradient__Group__2
            {
            pushFollow(FOLLOW_16);
            rule__LinearGradient__Group__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__LinearGradient__Group__2();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__LinearGradient__Group__1"


    // $ANTLR start "rule__LinearGradient__Group__1__Impl"
    // InternalLatteCSS.g:6946:1: rule__LinearGradient__Group__1__Impl : ( '(' ) ;
    public final void rule__LinearGradient__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalLatteCSS.g:6950:1: ( ( '(' ) )
            // InternalLatteCSS.g:6951:1: ( '(' )
            {
            // InternalLatteCSS.g:6951:1: ( '(' )
            // InternalLatteCSS.g:6952:1: '('
            {
             before(grammarAccess.getLinearGradientAccess().getLeftParenthesisKeyword_1()); 
            match(input,281,FOLLOW_2); 
             after(grammarAccess.getLinearGradientAccess().getLeftParenthesisKeyword_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__LinearGradient__Group__1__Impl"


    // $ANTLR start "rule__LinearGradient__Group__2"
    // InternalLatteCSS.g:6965:1: rule__LinearGradient__Group__2 : rule__LinearGradient__Group__2__Impl rule__LinearGradient__Group__3 ;
    public final void rule__LinearGradient__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalLatteCSS.g:6969:1: ( rule__LinearGradient__Group__2__Impl rule__LinearGradient__Group__3 )
            // InternalLatteCSS.g:6970:2: rule__LinearGradient__Group__2__Impl rule__LinearGradient__Group__3
            {
            pushFollow(FOLLOW_20);
            rule__LinearGradient__Group__2__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__LinearGradient__Group__3();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__LinearGradient__Group__2"


    // $ANTLR start "rule__LinearGradient__Group__2__Impl"
    // InternalLatteCSS.g:6977:1: rule__LinearGradient__Group__2__Impl : ( ( rule__LinearGradient__X1Assignment_2 ) ) ;
    public final void rule__LinearGradient__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalLatteCSS.g:6981:1: ( ( ( rule__LinearGradient__X1Assignment_2 ) ) )
            // InternalLatteCSS.g:6982:1: ( ( rule__LinearGradient__X1Assignment_2 ) )
            {
            // InternalLatteCSS.g:6982:1: ( ( rule__LinearGradient__X1Assignment_2 ) )
            // InternalLatteCSS.g:6983:1: ( rule__LinearGradient__X1Assignment_2 )
            {
             before(grammarAccess.getLinearGradientAccess().getX1Assignment_2()); 
            // InternalLatteCSS.g:6984:1: ( rule__LinearGradient__X1Assignment_2 )
            // InternalLatteCSS.g:6984:2: rule__LinearGradient__X1Assignment_2
            {
            pushFollow(FOLLOW_2);
            rule__LinearGradient__X1Assignment_2();

            state._fsp--;


            }

             after(grammarAccess.getLinearGradientAccess().getX1Assignment_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__LinearGradient__Group__2__Impl"


    // $ANTLR start "rule__LinearGradient__Group__3"
    // InternalLatteCSS.g:6994:1: rule__LinearGradient__Group__3 : rule__LinearGradient__Group__3__Impl rule__LinearGradient__Group__4 ;
    public final void rule__LinearGradient__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalLatteCSS.g:6998:1: ( rule__LinearGradient__Group__3__Impl rule__LinearGradient__Group__4 )
            // InternalLatteCSS.g:6999:2: rule__LinearGradient__Group__3__Impl rule__LinearGradient__Group__4
            {
            pushFollow(FOLLOW_16);
            rule__LinearGradient__Group__3__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__LinearGradient__Group__4();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__LinearGradient__Group__3"


    // $ANTLR start "rule__LinearGradient__Group__3__Impl"
    // InternalLatteCSS.g:7006:1: rule__LinearGradient__Group__3__Impl : ( ',' ) ;
    public final void rule__LinearGradient__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalLatteCSS.g:7010:1: ( ( ',' ) )
            // InternalLatteCSS.g:7011:1: ( ',' )
            {
            // InternalLatteCSS.g:7011:1: ( ',' )
            // InternalLatteCSS.g:7012:1: ','
            {
             before(grammarAccess.getLinearGradientAccess().getCommaKeyword_3()); 
            match(input,276,FOLLOW_2); 
             after(grammarAccess.getLinearGradientAccess().getCommaKeyword_3()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__LinearGradient__Group__3__Impl"


    // $ANTLR start "rule__LinearGradient__Group__4"
    // InternalLatteCSS.g:7025:1: rule__LinearGradient__Group__4 : rule__LinearGradient__Group__4__Impl rule__LinearGradient__Group__5 ;
    public final void rule__LinearGradient__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalLatteCSS.g:7029:1: ( rule__LinearGradient__Group__4__Impl rule__LinearGradient__Group__5 )
            // InternalLatteCSS.g:7030:2: rule__LinearGradient__Group__4__Impl rule__LinearGradient__Group__5
            {
            pushFollow(FOLLOW_31);
            rule__LinearGradient__Group__4__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__LinearGradient__Group__5();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__LinearGradient__Group__4"


    // $ANTLR start "rule__LinearGradient__Group__4__Impl"
    // InternalLatteCSS.g:7037:1: rule__LinearGradient__Group__4__Impl : ( ( rule__LinearGradient__Y1Assignment_4 ) ) ;
    public final void rule__LinearGradient__Group__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalLatteCSS.g:7041:1: ( ( ( rule__LinearGradient__Y1Assignment_4 ) ) )
            // InternalLatteCSS.g:7042:1: ( ( rule__LinearGradient__Y1Assignment_4 ) )
            {
            // InternalLatteCSS.g:7042:1: ( ( rule__LinearGradient__Y1Assignment_4 ) )
            // InternalLatteCSS.g:7043:1: ( rule__LinearGradient__Y1Assignment_4 )
            {
             before(grammarAccess.getLinearGradientAccess().getY1Assignment_4()); 
            // InternalLatteCSS.g:7044:1: ( rule__LinearGradient__Y1Assignment_4 )
            // InternalLatteCSS.g:7044:2: rule__LinearGradient__Y1Assignment_4
            {
            pushFollow(FOLLOW_2);
            rule__LinearGradient__Y1Assignment_4();

            state._fsp--;


            }

             after(grammarAccess.getLinearGradientAccess().getY1Assignment_4()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__LinearGradient__Group__4__Impl"


    // $ANTLR start "rule__LinearGradient__Group__5"
    // InternalLatteCSS.g:7054:1: rule__LinearGradient__Group__5 : rule__LinearGradient__Group__5__Impl rule__LinearGradient__Group__6 ;
    public final void rule__LinearGradient__Group__5() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalLatteCSS.g:7058:1: ( rule__LinearGradient__Group__5__Impl rule__LinearGradient__Group__6 )
            // InternalLatteCSS.g:7059:2: rule__LinearGradient__Group__5__Impl rule__LinearGradient__Group__6
            {
            pushFollow(FOLLOW_32);
            rule__LinearGradient__Group__5__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__LinearGradient__Group__6();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__LinearGradient__Group__5"


    // $ANTLR start "rule__LinearGradient__Group__5__Impl"
    // InternalLatteCSS.g:7066:1: rule__LinearGradient__Group__5__Impl : ( ')' ) ;
    public final void rule__LinearGradient__Group__5__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalLatteCSS.g:7070:1: ( ( ')' ) )
            // InternalLatteCSS.g:7071:1: ( ')' )
            {
            // InternalLatteCSS.g:7071:1: ( ')' )
            // InternalLatteCSS.g:7072:1: ')'
            {
             before(grammarAccess.getLinearGradientAccess().getRightParenthesisKeyword_5()); 
            match(input,282,FOLLOW_2); 
             after(grammarAccess.getLinearGradientAccess().getRightParenthesisKeyword_5()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__LinearGradient__Group__5__Impl"


    // $ANTLR start "rule__LinearGradient__Group__6"
    // InternalLatteCSS.g:7085:1: rule__LinearGradient__Group__6 : rule__LinearGradient__Group__6__Impl rule__LinearGradient__Group__7 ;
    public final void rule__LinearGradient__Group__6() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalLatteCSS.g:7089:1: ( rule__LinearGradient__Group__6__Impl rule__LinearGradient__Group__7 )
            // InternalLatteCSS.g:7090:2: rule__LinearGradient__Group__6__Impl rule__LinearGradient__Group__7
            {
            pushFollow(FOLLOW_30);
            rule__LinearGradient__Group__6__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__LinearGradient__Group__7();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__LinearGradient__Group__6"


    // $ANTLR start "rule__LinearGradient__Group__6__Impl"
    // InternalLatteCSS.g:7097:1: rule__LinearGradient__Group__6__Impl : ( 'to' ) ;
    public final void rule__LinearGradient__Group__6__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalLatteCSS.g:7101:1: ( ( 'to' ) )
            // InternalLatteCSS.g:7102:1: ( 'to' )
            {
            // InternalLatteCSS.g:7102:1: ( 'to' )
            // InternalLatteCSS.g:7103:1: 'to'
            {
             before(grammarAccess.getLinearGradientAccess().getToKeyword_6()); 
            match(input,283,FOLLOW_2); 
             after(grammarAccess.getLinearGradientAccess().getToKeyword_6()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__LinearGradient__Group__6__Impl"


    // $ANTLR start "rule__LinearGradient__Group__7"
    // InternalLatteCSS.g:7116:1: rule__LinearGradient__Group__7 : rule__LinearGradient__Group__7__Impl rule__LinearGradient__Group__8 ;
    public final void rule__LinearGradient__Group__7() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalLatteCSS.g:7120:1: ( rule__LinearGradient__Group__7__Impl rule__LinearGradient__Group__8 )
            // InternalLatteCSS.g:7121:2: rule__LinearGradient__Group__7__Impl rule__LinearGradient__Group__8
            {
            pushFollow(FOLLOW_16);
            rule__LinearGradient__Group__7__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__LinearGradient__Group__8();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__LinearGradient__Group__7"


    // $ANTLR start "rule__LinearGradient__Group__7__Impl"
    // InternalLatteCSS.g:7128:1: rule__LinearGradient__Group__7__Impl : ( '(' ) ;
    public final void rule__LinearGradient__Group__7__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalLatteCSS.g:7132:1: ( ( '(' ) )
            // InternalLatteCSS.g:7133:1: ( '(' )
            {
            // InternalLatteCSS.g:7133:1: ( '(' )
            // InternalLatteCSS.g:7134:1: '('
            {
             before(grammarAccess.getLinearGradientAccess().getLeftParenthesisKeyword_7()); 
            match(input,281,FOLLOW_2); 
             after(grammarAccess.getLinearGradientAccess().getLeftParenthesisKeyword_7()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__LinearGradient__Group__7__Impl"


    // $ANTLR start "rule__LinearGradient__Group__8"
    // InternalLatteCSS.g:7147:1: rule__LinearGradient__Group__8 : rule__LinearGradient__Group__8__Impl rule__LinearGradient__Group__9 ;
    public final void rule__LinearGradient__Group__8() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalLatteCSS.g:7151:1: ( rule__LinearGradient__Group__8__Impl rule__LinearGradient__Group__9 )
            // InternalLatteCSS.g:7152:2: rule__LinearGradient__Group__8__Impl rule__LinearGradient__Group__9
            {
            pushFollow(FOLLOW_20);
            rule__LinearGradient__Group__8__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__LinearGradient__Group__9();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__LinearGradient__Group__8"


    // $ANTLR start "rule__LinearGradient__Group__8__Impl"
    // InternalLatteCSS.g:7159:1: rule__LinearGradient__Group__8__Impl : ( ( rule__LinearGradient__X2Assignment_8 ) ) ;
    public final void rule__LinearGradient__Group__8__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalLatteCSS.g:7163:1: ( ( ( rule__LinearGradient__X2Assignment_8 ) ) )
            // InternalLatteCSS.g:7164:1: ( ( rule__LinearGradient__X2Assignment_8 ) )
            {
            // InternalLatteCSS.g:7164:1: ( ( rule__LinearGradient__X2Assignment_8 ) )
            // InternalLatteCSS.g:7165:1: ( rule__LinearGradient__X2Assignment_8 )
            {
             before(grammarAccess.getLinearGradientAccess().getX2Assignment_8()); 
            // InternalLatteCSS.g:7166:1: ( rule__LinearGradient__X2Assignment_8 )
            // InternalLatteCSS.g:7166:2: rule__LinearGradient__X2Assignment_8
            {
            pushFollow(FOLLOW_2);
            rule__LinearGradient__X2Assignment_8();

            state._fsp--;


            }

             after(grammarAccess.getLinearGradientAccess().getX2Assignment_8()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__LinearGradient__Group__8__Impl"


    // $ANTLR start "rule__LinearGradient__Group__9"
    // InternalLatteCSS.g:7176:1: rule__LinearGradient__Group__9 : rule__LinearGradient__Group__9__Impl rule__LinearGradient__Group__10 ;
    public final void rule__LinearGradient__Group__9() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalLatteCSS.g:7180:1: ( rule__LinearGradient__Group__9__Impl rule__LinearGradient__Group__10 )
            // InternalLatteCSS.g:7181:2: rule__LinearGradient__Group__9__Impl rule__LinearGradient__Group__10
            {
            pushFollow(FOLLOW_16);
            rule__LinearGradient__Group__9__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__LinearGradient__Group__10();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__LinearGradient__Group__9"


    // $ANTLR start "rule__LinearGradient__Group__9__Impl"
    // InternalLatteCSS.g:7188:1: rule__LinearGradient__Group__9__Impl : ( ',' ) ;
    public final void rule__LinearGradient__Group__9__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalLatteCSS.g:7192:1: ( ( ',' ) )
            // InternalLatteCSS.g:7193:1: ( ',' )
            {
            // InternalLatteCSS.g:7193:1: ( ',' )
            // InternalLatteCSS.g:7194:1: ','
            {
             before(grammarAccess.getLinearGradientAccess().getCommaKeyword_9()); 
            match(input,276,FOLLOW_2); 
             after(grammarAccess.getLinearGradientAccess().getCommaKeyword_9()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__LinearGradient__Group__9__Impl"


    // $ANTLR start "rule__LinearGradient__Group__10"
    // InternalLatteCSS.g:7207:1: rule__LinearGradient__Group__10 : rule__LinearGradient__Group__10__Impl rule__LinearGradient__Group__11 ;
    public final void rule__LinearGradient__Group__10() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalLatteCSS.g:7211:1: ( rule__LinearGradient__Group__10__Impl rule__LinearGradient__Group__11 )
            // InternalLatteCSS.g:7212:2: rule__LinearGradient__Group__10__Impl rule__LinearGradient__Group__11
            {
            pushFollow(FOLLOW_31);
            rule__LinearGradient__Group__10__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__LinearGradient__Group__11();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__LinearGradient__Group__10"


    // $ANTLR start "rule__LinearGradient__Group__10__Impl"
    // InternalLatteCSS.g:7219:1: rule__LinearGradient__Group__10__Impl : ( ( rule__LinearGradient__Y2Assignment_10 ) ) ;
    public final void rule__LinearGradient__Group__10__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalLatteCSS.g:7223:1: ( ( ( rule__LinearGradient__Y2Assignment_10 ) ) )
            // InternalLatteCSS.g:7224:1: ( ( rule__LinearGradient__Y2Assignment_10 ) )
            {
            // InternalLatteCSS.g:7224:1: ( ( rule__LinearGradient__Y2Assignment_10 ) )
            // InternalLatteCSS.g:7225:1: ( rule__LinearGradient__Y2Assignment_10 )
            {
             before(grammarAccess.getLinearGradientAccess().getY2Assignment_10()); 
            // InternalLatteCSS.g:7226:1: ( rule__LinearGradient__Y2Assignment_10 )
            // InternalLatteCSS.g:7226:2: rule__LinearGradient__Y2Assignment_10
            {
            pushFollow(FOLLOW_2);
            rule__LinearGradient__Y2Assignment_10();

            state._fsp--;


            }

             after(grammarAccess.getLinearGradientAccess().getY2Assignment_10()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__LinearGradient__Group__10__Impl"


    // $ANTLR start "rule__LinearGradient__Group__11"
    // InternalLatteCSS.g:7236:1: rule__LinearGradient__Group__11 : rule__LinearGradient__Group__11__Impl rule__LinearGradient__Group__12 ;
    public final void rule__LinearGradient__Group__11() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalLatteCSS.g:7240:1: ( rule__LinearGradient__Group__11__Impl rule__LinearGradient__Group__12 )
            // InternalLatteCSS.g:7241:2: rule__LinearGradient__Group__11__Impl rule__LinearGradient__Group__12
            {
            pushFollow(FOLLOW_33);
            rule__LinearGradient__Group__11__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__LinearGradient__Group__12();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__LinearGradient__Group__11"


    // $ANTLR start "rule__LinearGradient__Group__11__Impl"
    // InternalLatteCSS.g:7248:1: rule__LinearGradient__Group__11__Impl : ( ')' ) ;
    public final void rule__LinearGradient__Group__11__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalLatteCSS.g:7252:1: ( ( ')' ) )
            // InternalLatteCSS.g:7253:1: ( ')' )
            {
            // InternalLatteCSS.g:7253:1: ( ')' )
            // InternalLatteCSS.g:7254:1: ')'
            {
             before(grammarAccess.getLinearGradientAccess().getRightParenthesisKeyword_11()); 
            match(input,282,FOLLOW_2); 
             after(grammarAccess.getLinearGradientAccess().getRightParenthesisKeyword_11()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__LinearGradient__Group__11__Impl"


    // $ANTLR start "rule__LinearGradient__Group__12"
    // InternalLatteCSS.g:7267:1: rule__LinearGradient__Group__12 : rule__LinearGradient__Group__12__Impl rule__LinearGradient__Group__13 ;
    public final void rule__LinearGradient__Group__12() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalLatteCSS.g:7271:1: ( rule__LinearGradient__Group__12__Impl rule__LinearGradient__Group__13 )
            // InternalLatteCSS.g:7272:2: rule__LinearGradient__Group__12__Impl rule__LinearGradient__Group__13
            {
            pushFollow(FOLLOW_30);
            rule__LinearGradient__Group__12__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__LinearGradient__Group__13();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__LinearGradient__Group__12"


    // $ANTLR start "rule__LinearGradient__Group__12__Impl"
    // InternalLatteCSS.g:7279:1: rule__LinearGradient__Group__12__Impl : ( 'stops' ) ;
    public final void rule__LinearGradient__Group__12__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalLatteCSS.g:7283:1: ( ( 'stops' ) )
            // InternalLatteCSS.g:7284:1: ( 'stops' )
            {
            // InternalLatteCSS.g:7284:1: ( 'stops' )
            // InternalLatteCSS.g:7285:1: 'stops'
            {
             before(grammarAccess.getLinearGradientAccess().getStopsKeyword_12()); 
            match(input,284,FOLLOW_2); 
             after(grammarAccess.getLinearGradientAccess().getStopsKeyword_12()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__LinearGradient__Group__12__Impl"


    // $ANTLR start "rule__LinearGradient__Group__13"
    // InternalLatteCSS.g:7298:1: rule__LinearGradient__Group__13 : rule__LinearGradient__Group__13__Impl rule__LinearGradient__Group__14 ;
    public final void rule__LinearGradient__Group__13() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalLatteCSS.g:7302:1: ( rule__LinearGradient__Group__13__Impl rule__LinearGradient__Group__14 )
            // InternalLatteCSS.g:7303:2: rule__LinearGradient__Group__13__Impl rule__LinearGradient__Group__14
            {
            pushFollow(FOLLOW_34);
            rule__LinearGradient__Group__13__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__LinearGradient__Group__14();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__LinearGradient__Group__13"


    // $ANTLR start "rule__LinearGradient__Group__13__Impl"
    // InternalLatteCSS.g:7310:1: rule__LinearGradient__Group__13__Impl : ( ( ( rule__LinearGradient__Group_13__0 ) ) ( ( rule__LinearGradient__Group_13__0 )* ) ) ;
    public final void rule__LinearGradient__Group__13__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalLatteCSS.g:7314:1: ( ( ( ( rule__LinearGradient__Group_13__0 ) ) ( ( rule__LinearGradient__Group_13__0 )* ) ) )
            // InternalLatteCSS.g:7315:1: ( ( ( rule__LinearGradient__Group_13__0 ) ) ( ( rule__LinearGradient__Group_13__0 )* ) )
            {
            // InternalLatteCSS.g:7315:1: ( ( ( rule__LinearGradient__Group_13__0 ) ) ( ( rule__LinearGradient__Group_13__0 )* ) )
            // InternalLatteCSS.g:7316:1: ( ( rule__LinearGradient__Group_13__0 ) ) ( ( rule__LinearGradient__Group_13__0 )* )
            {
            // InternalLatteCSS.g:7316:1: ( ( rule__LinearGradient__Group_13__0 ) )
            // InternalLatteCSS.g:7317:1: ( rule__LinearGradient__Group_13__0 )
            {
             before(grammarAccess.getLinearGradientAccess().getGroup_13()); 
            // InternalLatteCSS.g:7318:1: ( rule__LinearGradient__Group_13__0 )
            // InternalLatteCSS.g:7318:2: rule__LinearGradient__Group_13__0
            {
            pushFollow(FOLLOW_35);
            rule__LinearGradient__Group_13__0();

            state._fsp--;


            }

             after(grammarAccess.getLinearGradientAccess().getGroup_13()); 

            }

            // InternalLatteCSS.g:7321:1: ( ( rule__LinearGradient__Group_13__0 )* )
            // InternalLatteCSS.g:7322:1: ( rule__LinearGradient__Group_13__0 )*
            {
             before(grammarAccess.getLinearGradientAccess().getGroup_13()); 
            // InternalLatteCSS.g:7323:1: ( rule__LinearGradient__Group_13__0 )*
            loop46:
            do {
                int alt46=2;
                int LA46_0 = input.LA(1);

                if ( (LA46_0==281) ) {
                    alt46=1;
                }


                switch (alt46) {
            	case 1 :
            	    // InternalLatteCSS.g:7323:2: rule__LinearGradient__Group_13__0
            	    {
            	    pushFollow(FOLLOW_35);
            	    rule__LinearGradient__Group_13__0();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop46;
                }
            } while (true);

             after(grammarAccess.getLinearGradientAccess().getGroup_13()); 

            }


            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__LinearGradient__Group__13__Impl"


    // $ANTLR start "rule__LinearGradient__Group__14"
    // InternalLatteCSS.g:7334:1: rule__LinearGradient__Group__14 : rule__LinearGradient__Group__14__Impl ;
    public final void rule__LinearGradient__Group__14() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalLatteCSS.g:7338:1: ( rule__LinearGradient__Group__14__Impl )
            // InternalLatteCSS.g:7339:2: rule__LinearGradient__Group__14__Impl
            {
            pushFollow(FOLLOW_2);
            rule__LinearGradient__Group__14__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__LinearGradient__Group__14"


    // $ANTLR start "rule__LinearGradient__Group__14__Impl"
    // InternalLatteCSS.g:7345:1: rule__LinearGradient__Group__14__Impl : ( ( rule__LinearGradient__Alternatives_14 )? ) ;
    public final void rule__LinearGradient__Group__14__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalLatteCSS.g:7349:1: ( ( ( rule__LinearGradient__Alternatives_14 )? ) )
            // InternalLatteCSS.g:7350:1: ( ( rule__LinearGradient__Alternatives_14 )? )
            {
            // InternalLatteCSS.g:7350:1: ( ( rule__LinearGradient__Alternatives_14 )? )
            // InternalLatteCSS.g:7351:1: ( rule__LinearGradient__Alternatives_14 )?
            {
             before(grammarAccess.getLinearGradientAccess().getAlternatives_14()); 
            // InternalLatteCSS.g:7352:1: ( rule__LinearGradient__Alternatives_14 )?
            int alt47=2;
            int LA47_0 = input.LA(1);

            if ( ((LA47_0>=124 && LA47_0<=125)) ) {
                alt47=1;
            }
            switch (alt47) {
                case 1 :
                    // InternalLatteCSS.g:7352:2: rule__LinearGradient__Alternatives_14
                    {
                    pushFollow(FOLLOW_2);
                    rule__LinearGradient__Alternatives_14();

                    state._fsp--;


                    }
                    break;

            }

             after(grammarAccess.getLinearGradientAccess().getAlternatives_14()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__LinearGradient__Group__14__Impl"


    // $ANTLR start "rule__LinearGradient__Group_13__0"
    // InternalLatteCSS.g:7392:1: rule__LinearGradient__Group_13__0 : rule__LinearGradient__Group_13__0__Impl rule__LinearGradient__Group_13__1 ;
    public final void rule__LinearGradient__Group_13__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalLatteCSS.g:7396:1: ( rule__LinearGradient__Group_13__0__Impl rule__LinearGradient__Group_13__1 )
            // InternalLatteCSS.g:7397:2: rule__LinearGradient__Group_13__0__Impl rule__LinearGradient__Group_13__1
            {
            pushFollow(FOLLOW_16);
            rule__LinearGradient__Group_13__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__LinearGradient__Group_13__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__LinearGradient__Group_13__0"


    // $ANTLR start "rule__LinearGradient__Group_13__0__Impl"
    // InternalLatteCSS.g:7404:1: rule__LinearGradient__Group_13__0__Impl : ( '(' ) ;
    public final void rule__LinearGradient__Group_13__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalLatteCSS.g:7408:1: ( ( '(' ) )
            // InternalLatteCSS.g:7409:1: ( '(' )
            {
            // InternalLatteCSS.g:7409:1: ( '(' )
            // InternalLatteCSS.g:7410:1: '('
            {
             before(grammarAccess.getLinearGradientAccess().getLeftParenthesisKeyword_13_0()); 
            match(input,281,FOLLOW_2); 
             after(grammarAccess.getLinearGradientAccess().getLeftParenthesisKeyword_13_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__LinearGradient__Group_13__0__Impl"


    // $ANTLR start "rule__LinearGradient__Group_13__1"
    // InternalLatteCSS.g:7423:1: rule__LinearGradient__Group_13__1 : rule__LinearGradient__Group_13__1__Impl rule__LinearGradient__Group_13__2 ;
    public final void rule__LinearGradient__Group_13__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalLatteCSS.g:7427:1: ( rule__LinearGradient__Group_13__1__Impl rule__LinearGradient__Group_13__2 )
            // InternalLatteCSS.g:7428:2: rule__LinearGradient__Group_13__1__Impl rule__LinearGradient__Group_13__2
            {
            pushFollow(FOLLOW_31);
            rule__LinearGradient__Group_13__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__LinearGradient__Group_13__2();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__LinearGradient__Group_13__1"


    // $ANTLR start "rule__LinearGradient__Group_13__1__Impl"
    // InternalLatteCSS.g:7435:1: rule__LinearGradient__Group_13__1__Impl : ( ( rule__LinearGradient__StopsAssignment_13_1 ) ) ;
    public final void rule__LinearGradient__Group_13__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalLatteCSS.g:7439:1: ( ( ( rule__LinearGradient__StopsAssignment_13_1 ) ) )
            // InternalLatteCSS.g:7440:1: ( ( rule__LinearGradient__StopsAssignment_13_1 ) )
            {
            // InternalLatteCSS.g:7440:1: ( ( rule__LinearGradient__StopsAssignment_13_1 ) )
            // InternalLatteCSS.g:7441:1: ( rule__LinearGradient__StopsAssignment_13_1 )
            {
             before(grammarAccess.getLinearGradientAccess().getStopsAssignment_13_1()); 
            // InternalLatteCSS.g:7442:1: ( rule__LinearGradient__StopsAssignment_13_1 )
            // InternalLatteCSS.g:7442:2: rule__LinearGradient__StopsAssignment_13_1
            {
            pushFollow(FOLLOW_2);
            rule__LinearGradient__StopsAssignment_13_1();

            state._fsp--;


            }

             after(grammarAccess.getLinearGradientAccess().getStopsAssignment_13_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__LinearGradient__Group_13__1__Impl"


    // $ANTLR start "rule__LinearGradient__Group_13__2"
    // InternalLatteCSS.g:7452:1: rule__LinearGradient__Group_13__2 : rule__LinearGradient__Group_13__2__Impl ;
    public final void rule__LinearGradient__Group_13__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalLatteCSS.g:7456:1: ( rule__LinearGradient__Group_13__2__Impl )
            // InternalLatteCSS.g:7457:2: rule__LinearGradient__Group_13__2__Impl
            {
            pushFollow(FOLLOW_2);
            rule__LinearGradient__Group_13__2__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__LinearGradient__Group_13__2"


    // $ANTLR start "rule__LinearGradient__Group_13__2__Impl"
    // InternalLatteCSS.g:7463:1: rule__LinearGradient__Group_13__2__Impl : ( ')' ) ;
    public final void rule__LinearGradient__Group_13__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalLatteCSS.g:7467:1: ( ( ')' ) )
            // InternalLatteCSS.g:7468:1: ( ')' )
            {
            // InternalLatteCSS.g:7468:1: ( ')' )
            // InternalLatteCSS.g:7469:1: ')'
            {
             before(grammarAccess.getLinearGradientAccess().getRightParenthesisKeyword_13_2()); 
            match(input,282,FOLLOW_2); 
             after(grammarAccess.getLinearGradientAccess().getRightParenthesisKeyword_13_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__LinearGradient__Group_13__2__Impl"


    // $ANTLR start "rule__RadialGradient__Group__0"
    // InternalLatteCSS.g:7488:1: rule__RadialGradient__Group__0 : rule__RadialGradient__Group__0__Impl rule__RadialGradient__Group__1 ;
    public final void rule__RadialGradient__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalLatteCSS.g:7492:1: ( rule__RadialGradient__Group__0__Impl rule__RadialGradient__Group__1 )
            // InternalLatteCSS.g:7493:2: rule__RadialGradient__Group__0__Impl rule__RadialGradient__Group__1
            {
            pushFollow(FOLLOW_36);
            rule__RadialGradient__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__RadialGradient__Group__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__RadialGradient__Group__0"


    // $ANTLR start "rule__RadialGradient__Group__0__Impl"
    // InternalLatteCSS.g:7500:1: rule__RadialGradient__Group__0__Impl : ( 'radial' ) ;
    public final void rule__RadialGradient__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalLatteCSS.g:7504:1: ( ( 'radial' ) )
            // InternalLatteCSS.g:7505:1: ( 'radial' )
            {
            // InternalLatteCSS.g:7505:1: ( 'radial' )
            // InternalLatteCSS.g:7506:1: 'radial'
            {
             before(grammarAccess.getRadialGradientAccess().getRadialKeyword_0()); 
            match(input,285,FOLLOW_2); 
             after(grammarAccess.getRadialGradientAccess().getRadialKeyword_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__RadialGradient__Group__0__Impl"


    // $ANTLR start "rule__RadialGradient__Group__1"
    // InternalLatteCSS.g:7519:1: rule__RadialGradient__Group__1 : rule__RadialGradient__Group__1__Impl rule__RadialGradient__Group__2 ;
    public final void rule__RadialGradient__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalLatteCSS.g:7523:1: ( rule__RadialGradient__Group__1__Impl rule__RadialGradient__Group__2 )
            // InternalLatteCSS.g:7524:2: rule__RadialGradient__Group__1__Impl rule__RadialGradient__Group__2
            {
            pushFollow(FOLLOW_36);
            rule__RadialGradient__Group__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__RadialGradient__Group__2();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__RadialGradient__Group__1"


    // $ANTLR start "rule__RadialGradient__Group__1__Impl"
    // InternalLatteCSS.g:7531:1: rule__RadialGradient__Group__1__Impl : ( ( rule__RadialGradient__Group_1__0 )? ) ;
    public final void rule__RadialGradient__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalLatteCSS.g:7535:1: ( ( ( rule__RadialGradient__Group_1__0 )? ) )
            // InternalLatteCSS.g:7536:1: ( ( rule__RadialGradient__Group_1__0 )? )
            {
            // InternalLatteCSS.g:7536:1: ( ( rule__RadialGradient__Group_1__0 )? )
            // InternalLatteCSS.g:7537:1: ( rule__RadialGradient__Group_1__0 )?
            {
             before(grammarAccess.getRadialGradientAccess().getGroup_1()); 
            // InternalLatteCSS.g:7538:1: ( rule__RadialGradient__Group_1__0 )?
            int alt48=2;
            int LA48_0 = input.LA(1);

            if ( (LA48_0==281) ) {
                alt48=1;
            }
            switch (alt48) {
                case 1 :
                    // InternalLatteCSS.g:7538:2: rule__RadialGradient__Group_1__0
                    {
                    pushFollow(FOLLOW_2);
                    rule__RadialGradient__Group_1__0();

                    state._fsp--;


                    }
                    break;

            }

             after(grammarAccess.getRadialGradientAccess().getGroup_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__RadialGradient__Group__1__Impl"


    // $ANTLR start "rule__RadialGradient__Group__2"
    // InternalLatteCSS.g:7548:1: rule__RadialGradient__Group__2 : rule__RadialGradient__Group__2__Impl rule__RadialGradient__Group__3 ;
    public final void rule__RadialGradient__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalLatteCSS.g:7552:1: ( rule__RadialGradient__Group__2__Impl rule__RadialGradient__Group__3 )
            // InternalLatteCSS.g:7553:2: rule__RadialGradient__Group__2__Impl rule__RadialGradient__Group__3
            {
            pushFollow(FOLLOW_37);
            rule__RadialGradient__Group__2__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__RadialGradient__Group__3();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__RadialGradient__Group__2"


    // $ANTLR start "rule__RadialGradient__Group__2__Impl"
    // InternalLatteCSS.g:7560:1: rule__RadialGradient__Group__2__Impl : ( ( rule__RadialGradient__RadiusAssignment_2 ) ) ;
    public final void rule__RadialGradient__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalLatteCSS.g:7564:1: ( ( ( rule__RadialGradient__RadiusAssignment_2 ) ) )
            // InternalLatteCSS.g:7565:1: ( ( rule__RadialGradient__RadiusAssignment_2 ) )
            {
            // InternalLatteCSS.g:7565:1: ( ( rule__RadialGradient__RadiusAssignment_2 ) )
            // InternalLatteCSS.g:7566:1: ( rule__RadialGradient__RadiusAssignment_2 )
            {
             before(grammarAccess.getRadialGradientAccess().getRadiusAssignment_2()); 
            // InternalLatteCSS.g:7567:1: ( rule__RadialGradient__RadiusAssignment_2 )
            // InternalLatteCSS.g:7567:2: rule__RadialGradient__RadiusAssignment_2
            {
            pushFollow(FOLLOW_2);
            rule__RadialGradient__RadiusAssignment_2();

            state._fsp--;


            }

             after(grammarAccess.getRadialGradientAccess().getRadiusAssignment_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__RadialGradient__Group__2__Impl"


    // $ANTLR start "rule__RadialGradient__Group__3"
    // InternalLatteCSS.g:7577:1: rule__RadialGradient__Group__3 : rule__RadialGradient__Group__3__Impl rule__RadialGradient__Group__4 ;
    public final void rule__RadialGradient__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalLatteCSS.g:7581:1: ( rule__RadialGradient__Group__3__Impl rule__RadialGradient__Group__4 )
            // InternalLatteCSS.g:7582:2: rule__RadialGradient__Group__3__Impl rule__RadialGradient__Group__4
            {
            pushFollow(FOLLOW_33);
            rule__RadialGradient__Group__3__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__RadialGradient__Group__4();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__RadialGradient__Group__3"


    // $ANTLR start "rule__RadialGradient__Group__3__Impl"
    // InternalLatteCSS.g:7589:1: rule__RadialGradient__Group__3__Impl : ( ( rule__RadialGradient__Group_3__0 ) ) ;
    public final void rule__RadialGradient__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalLatteCSS.g:7593:1: ( ( ( rule__RadialGradient__Group_3__0 ) ) )
            // InternalLatteCSS.g:7594:1: ( ( rule__RadialGradient__Group_3__0 ) )
            {
            // InternalLatteCSS.g:7594:1: ( ( rule__RadialGradient__Group_3__0 ) )
            // InternalLatteCSS.g:7595:1: ( rule__RadialGradient__Group_3__0 )
            {
             before(grammarAccess.getRadialGradientAccess().getGroup_3()); 
            // InternalLatteCSS.g:7596:1: ( rule__RadialGradient__Group_3__0 )
            // InternalLatteCSS.g:7596:2: rule__RadialGradient__Group_3__0
            {
            pushFollow(FOLLOW_2);
            rule__RadialGradient__Group_3__0();

            state._fsp--;


            }

             after(grammarAccess.getRadialGradientAccess().getGroup_3()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__RadialGradient__Group__3__Impl"


    // $ANTLR start "rule__RadialGradient__Group__4"
    // InternalLatteCSS.g:7606:1: rule__RadialGradient__Group__4 : rule__RadialGradient__Group__4__Impl rule__RadialGradient__Group__5 ;
    public final void rule__RadialGradient__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalLatteCSS.g:7610:1: ( rule__RadialGradient__Group__4__Impl rule__RadialGradient__Group__5 )
            // InternalLatteCSS.g:7611:2: rule__RadialGradient__Group__4__Impl rule__RadialGradient__Group__5
            {
            pushFollow(FOLLOW_30);
            rule__RadialGradient__Group__4__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__RadialGradient__Group__5();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__RadialGradient__Group__4"


    // $ANTLR start "rule__RadialGradient__Group__4__Impl"
    // InternalLatteCSS.g:7618:1: rule__RadialGradient__Group__4__Impl : ( 'stops' ) ;
    public final void rule__RadialGradient__Group__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalLatteCSS.g:7622:1: ( ( 'stops' ) )
            // InternalLatteCSS.g:7623:1: ( 'stops' )
            {
            // InternalLatteCSS.g:7623:1: ( 'stops' )
            // InternalLatteCSS.g:7624:1: 'stops'
            {
             before(grammarAccess.getRadialGradientAccess().getStopsKeyword_4()); 
            match(input,284,FOLLOW_2); 
             after(grammarAccess.getRadialGradientAccess().getStopsKeyword_4()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__RadialGradient__Group__4__Impl"


    // $ANTLR start "rule__RadialGradient__Group__5"
    // InternalLatteCSS.g:7637:1: rule__RadialGradient__Group__5 : rule__RadialGradient__Group__5__Impl rule__RadialGradient__Group__6 ;
    public final void rule__RadialGradient__Group__5() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalLatteCSS.g:7641:1: ( rule__RadialGradient__Group__5__Impl rule__RadialGradient__Group__6 )
            // InternalLatteCSS.g:7642:2: rule__RadialGradient__Group__5__Impl rule__RadialGradient__Group__6
            {
            pushFollow(FOLLOW_34);
            rule__RadialGradient__Group__5__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__RadialGradient__Group__6();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__RadialGradient__Group__5"


    // $ANTLR start "rule__RadialGradient__Group__5__Impl"
    // InternalLatteCSS.g:7649:1: rule__RadialGradient__Group__5__Impl : ( ( ( rule__RadialGradient__Group_5__0 ) ) ( ( rule__RadialGradient__Group_5__0 )* ) ) ;
    public final void rule__RadialGradient__Group__5__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalLatteCSS.g:7653:1: ( ( ( ( rule__RadialGradient__Group_5__0 ) ) ( ( rule__RadialGradient__Group_5__0 )* ) ) )
            // InternalLatteCSS.g:7654:1: ( ( ( rule__RadialGradient__Group_5__0 ) ) ( ( rule__RadialGradient__Group_5__0 )* ) )
            {
            // InternalLatteCSS.g:7654:1: ( ( ( rule__RadialGradient__Group_5__0 ) ) ( ( rule__RadialGradient__Group_5__0 )* ) )
            // InternalLatteCSS.g:7655:1: ( ( rule__RadialGradient__Group_5__0 ) ) ( ( rule__RadialGradient__Group_5__0 )* )
            {
            // InternalLatteCSS.g:7655:1: ( ( rule__RadialGradient__Group_5__0 ) )
            // InternalLatteCSS.g:7656:1: ( rule__RadialGradient__Group_5__0 )
            {
             before(grammarAccess.getRadialGradientAccess().getGroup_5()); 
            // InternalLatteCSS.g:7657:1: ( rule__RadialGradient__Group_5__0 )
            // InternalLatteCSS.g:7657:2: rule__RadialGradient__Group_5__0
            {
            pushFollow(FOLLOW_35);
            rule__RadialGradient__Group_5__0();

            state._fsp--;


            }

             after(grammarAccess.getRadialGradientAccess().getGroup_5()); 

            }

            // InternalLatteCSS.g:7660:1: ( ( rule__RadialGradient__Group_5__0 )* )
            // InternalLatteCSS.g:7661:1: ( rule__RadialGradient__Group_5__0 )*
            {
             before(grammarAccess.getRadialGradientAccess().getGroup_5()); 
            // InternalLatteCSS.g:7662:1: ( rule__RadialGradient__Group_5__0 )*
            loop49:
            do {
                int alt49=2;
                int LA49_0 = input.LA(1);

                if ( (LA49_0==281) ) {
                    alt49=1;
                }


                switch (alt49) {
            	case 1 :
            	    // InternalLatteCSS.g:7662:2: rule__RadialGradient__Group_5__0
            	    {
            	    pushFollow(FOLLOW_35);
            	    rule__RadialGradient__Group_5__0();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop49;
                }
            } while (true);

             after(grammarAccess.getRadialGradientAccess().getGroup_5()); 

            }


            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__RadialGradient__Group__5__Impl"


    // $ANTLR start "rule__RadialGradient__Group__6"
    // InternalLatteCSS.g:7673:1: rule__RadialGradient__Group__6 : rule__RadialGradient__Group__6__Impl ;
    public final void rule__RadialGradient__Group__6() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalLatteCSS.g:7677:1: ( rule__RadialGradient__Group__6__Impl )
            // InternalLatteCSS.g:7678:2: rule__RadialGradient__Group__6__Impl
            {
            pushFollow(FOLLOW_2);
            rule__RadialGradient__Group__6__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__RadialGradient__Group__6"


    // $ANTLR start "rule__RadialGradient__Group__6__Impl"
    // InternalLatteCSS.g:7684:1: rule__RadialGradient__Group__6__Impl : ( ( rule__RadialGradient__Alternatives_6 )? ) ;
    public final void rule__RadialGradient__Group__6__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalLatteCSS.g:7688:1: ( ( ( rule__RadialGradient__Alternatives_6 )? ) )
            // InternalLatteCSS.g:7689:1: ( ( rule__RadialGradient__Alternatives_6 )? )
            {
            // InternalLatteCSS.g:7689:1: ( ( rule__RadialGradient__Alternatives_6 )? )
            // InternalLatteCSS.g:7690:1: ( rule__RadialGradient__Alternatives_6 )?
            {
             before(grammarAccess.getRadialGradientAccess().getAlternatives_6()); 
            // InternalLatteCSS.g:7691:1: ( rule__RadialGradient__Alternatives_6 )?
            int alt50=2;
            int LA50_0 = input.LA(1);

            if ( ((LA50_0>=124 && LA50_0<=125)) ) {
                alt50=1;
            }
            switch (alt50) {
                case 1 :
                    // InternalLatteCSS.g:7691:2: rule__RadialGradient__Alternatives_6
                    {
                    pushFollow(FOLLOW_2);
                    rule__RadialGradient__Alternatives_6();

                    state._fsp--;


                    }
                    break;

            }

             after(grammarAccess.getRadialGradientAccess().getAlternatives_6()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__RadialGradient__Group__6__Impl"


    // $ANTLR start "rule__RadialGradient__Group_1__0"
    // InternalLatteCSS.g:7715:1: rule__RadialGradient__Group_1__0 : rule__RadialGradient__Group_1__0__Impl rule__RadialGradient__Group_1__1 ;
    public final void rule__RadialGradient__Group_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalLatteCSS.g:7719:1: ( rule__RadialGradient__Group_1__0__Impl rule__RadialGradient__Group_1__1 )
            // InternalLatteCSS.g:7720:2: rule__RadialGradient__Group_1__0__Impl rule__RadialGradient__Group_1__1
            {
            pushFollow(FOLLOW_16);
            rule__RadialGradient__Group_1__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__RadialGradient__Group_1__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__RadialGradient__Group_1__0"


    // $ANTLR start "rule__RadialGradient__Group_1__0__Impl"
    // InternalLatteCSS.g:7727:1: rule__RadialGradient__Group_1__0__Impl : ( '(' ) ;
    public final void rule__RadialGradient__Group_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalLatteCSS.g:7731:1: ( ( '(' ) )
            // InternalLatteCSS.g:7732:1: ( '(' )
            {
            // InternalLatteCSS.g:7732:1: ( '(' )
            // InternalLatteCSS.g:7733:1: '('
            {
             before(grammarAccess.getRadialGradientAccess().getLeftParenthesisKeyword_1_0()); 
            match(input,281,FOLLOW_2); 
             after(grammarAccess.getRadialGradientAccess().getLeftParenthesisKeyword_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__RadialGradient__Group_1__0__Impl"


    // $ANTLR start "rule__RadialGradient__Group_1__1"
    // InternalLatteCSS.g:7746:1: rule__RadialGradient__Group_1__1 : rule__RadialGradient__Group_1__1__Impl rule__RadialGradient__Group_1__2 ;
    public final void rule__RadialGradient__Group_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalLatteCSS.g:7750:1: ( rule__RadialGradient__Group_1__1__Impl rule__RadialGradient__Group_1__2 )
            // InternalLatteCSS.g:7751:2: rule__RadialGradient__Group_1__1__Impl rule__RadialGradient__Group_1__2
            {
            pushFollow(FOLLOW_20);
            rule__RadialGradient__Group_1__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__RadialGradient__Group_1__2();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__RadialGradient__Group_1__1"


    // $ANTLR start "rule__RadialGradient__Group_1__1__Impl"
    // InternalLatteCSS.g:7758:1: rule__RadialGradient__Group_1__1__Impl : ( ( rule__RadialGradient__CxAssignment_1_1 ) ) ;
    public final void rule__RadialGradient__Group_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalLatteCSS.g:7762:1: ( ( ( rule__RadialGradient__CxAssignment_1_1 ) ) )
            // InternalLatteCSS.g:7763:1: ( ( rule__RadialGradient__CxAssignment_1_1 ) )
            {
            // InternalLatteCSS.g:7763:1: ( ( rule__RadialGradient__CxAssignment_1_1 ) )
            // InternalLatteCSS.g:7764:1: ( rule__RadialGradient__CxAssignment_1_1 )
            {
             before(grammarAccess.getRadialGradientAccess().getCxAssignment_1_1()); 
            // InternalLatteCSS.g:7765:1: ( rule__RadialGradient__CxAssignment_1_1 )
            // InternalLatteCSS.g:7765:2: rule__RadialGradient__CxAssignment_1_1
            {
            pushFollow(FOLLOW_2);
            rule__RadialGradient__CxAssignment_1_1();

            state._fsp--;


            }

             after(grammarAccess.getRadialGradientAccess().getCxAssignment_1_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__RadialGradient__Group_1__1__Impl"


    // $ANTLR start "rule__RadialGradient__Group_1__2"
    // InternalLatteCSS.g:7775:1: rule__RadialGradient__Group_1__2 : rule__RadialGradient__Group_1__2__Impl rule__RadialGradient__Group_1__3 ;
    public final void rule__RadialGradient__Group_1__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalLatteCSS.g:7779:1: ( rule__RadialGradient__Group_1__2__Impl rule__RadialGradient__Group_1__3 )
            // InternalLatteCSS.g:7780:2: rule__RadialGradient__Group_1__2__Impl rule__RadialGradient__Group_1__3
            {
            pushFollow(FOLLOW_16);
            rule__RadialGradient__Group_1__2__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__RadialGradient__Group_1__3();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__RadialGradient__Group_1__2"


    // $ANTLR start "rule__RadialGradient__Group_1__2__Impl"
    // InternalLatteCSS.g:7787:1: rule__RadialGradient__Group_1__2__Impl : ( ',' ) ;
    public final void rule__RadialGradient__Group_1__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalLatteCSS.g:7791:1: ( ( ',' ) )
            // InternalLatteCSS.g:7792:1: ( ',' )
            {
            // InternalLatteCSS.g:7792:1: ( ',' )
            // InternalLatteCSS.g:7793:1: ','
            {
             before(grammarAccess.getRadialGradientAccess().getCommaKeyword_1_2()); 
            match(input,276,FOLLOW_2); 
             after(grammarAccess.getRadialGradientAccess().getCommaKeyword_1_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__RadialGradient__Group_1__2__Impl"


    // $ANTLR start "rule__RadialGradient__Group_1__3"
    // InternalLatteCSS.g:7806:1: rule__RadialGradient__Group_1__3 : rule__RadialGradient__Group_1__3__Impl rule__RadialGradient__Group_1__4 ;
    public final void rule__RadialGradient__Group_1__3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalLatteCSS.g:7810:1: ( rule__RadialGradient__Group_1__3__Impl rule__RadialGradient__Group_1__4 )
            // InternalLatteCSS.g:7811:2: rule__RadialGradient__Group_1__3__Impl rule__RadialGradient__Group_1__4
            {
            pushFollow(FOLLOW_31);
            rule__RadialGradient__Group_1__3__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__RadialGradient__Group_1__4();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__RadialGradient__Group_1__3"


    // $ANTLR start "rule__RadialGradient__Group_1__3__Impl"
    // InternalLatteCSS.g:7818:1: rule__RadialGradient__Group_1__3__Impl : ( ( rule__RadialGradient__CyAssignment_1_3 ) ) ;
    public final void rule__RadialGradient__Group_1__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalLatteCSS.g:7822:1: ( ( ( rule__RadialGradient__CyAssignment_1_3 ) ) )
            // InternalLatteCSS.g:7823:1: ( ( rule__RadialGradient__CyAssignment_1_3 ) )
            {
            // InternalLatteCSS.g:7823:1: ( ( rule__RadialGradient__CyAssignment_1_3 ) )
            // InternalLatteCSS.g:7824:1: ( rule__RadialGradient__CyAssignment_1_3 )
            {
             before(grammarAccess.getRadialGradientAccess().getCyAssignment_1_3()); 
            // InternalLatteCSS.g:7825:1: ( rule__RadialGradient__CyAssignment_1_3 )
            // InternalLatteCSS.g:7825:2: rule__RadialGradient__CyAssignment_1_3
            {
            pushFollow(FOLLOW_2);
            rule__RadialGradient__CyAssignment_1_3();

            state._fsp--;


            }

             after(grammarAccess.getRadialGradientAccess().getCyAssignment_1_3()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__RadialGradient__Group_1__3__Impl"


    // $ANTLR start "rule__RadialGradient__Group_1__4"
    // InternalLatteCSS.g:7835:1: rule__RadialGradient__Group_1__4 : rule__RadialGradient__Group_1__4__Impl rule__RadialGradient__Group_1__5 ;
    public final void rule__RadialGradient__Group_1__4() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalLatteCSS.g:7839:1: ( rule__RadialGradient__Group_1__4__Impl rule__RadialGradient__Group_1__5 )
            // InternalLatteCSS.g:7840:2: rule__RadialGradient__Group_1__4__Impl rule__RadialGradient__Group_1__5
            {
            pushFollow(FOLLOW_20);
            rule__RadialGradient__Group_1__4__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__RadialGradient__Group_1__5();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__RadialGradient__Group_1__4"


    // $ANTLR start "rule__RadialGradient__Group_1__4__Impl"
    // InternalLatteCSS.g:7847:1: rule__RadialGradient__Group_1__4__Impl : ( ')' ) ;
    public final void rule__RadialGradient__Group_1__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalLatteCSS.g:7851:1: ( ( ')' ) )
            // InternalLatteCSS.g:7852:1: ( ')' )
            {
            // InternalLatteCSS.g:7852:1: ( ')' )
            // InternalLatteCSS.g:7853:1: ')'
            {
             before(grammarAccess.getRadialGradientAccess().getRightParenthesisKeyword_1_4()); 
            match(input,282,FOLLOW_2); 
             after(grammarAccess.getRadialGradientAccess().getRightParenthesisKeyword_1_4()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__RadialGradient__Group_1__4__Impl"


    // $ANTLR start "rule__RadialGradient__Group_1__5"
    // InternalLatteCSS.g:7866:1: rule__RadialGradient__Group_1__5 : rule__RadialGradient__Group_1__5__Impl ;
    public final void rule__RadialGradient__Group_1__5() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalLatteCSS.g:7870:1: ( rule__RadialGradient__Group_1__5__Impl )
            // InternalLatteCSS.g:7871:2: rule__RadialGradient__Group_1__5__Impl
            {
            pushFollow(FOLLOW_2);
            rule__RadialGradient__Group_1__5__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__RadialGradient__Group_1__5"


    // $ANTLR start "rule__RadialGradient__Group_1__5__Impl"
    // InternalLatteCSS.g:7877:1: rule__RadialGradient__Group_1__5__Impl : ( ',' ) ;
    public final void rule__RadialGradient__Group_1__5__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalLatteCSS.g:7881:1: ( ( ',' ) )
            // InternalLatteCSS.g:7882:1: ( ',' )
            {
            // InternalLatteCSS.g:7882:1: ( ',' )
            // InternalLatteCSS.g:7883:1: ','
            {
             before(grammarAccess.getRadialGradientAccess().getCommaKeyword_1_5()); 
            match(input,276,FOLLOW_2); 
             after(grammarAccess.getRadialGradientAccess().getCommaKeyword_1_5()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__RadialGradient__Group_1__5__Impl"


    // $ANTLR start "rule__RadialGradient__Group_3__0"
    // InternalLatteCSS.g:7908:1: rule__RadialGradient__Group_3__0 : rule__RadialGradient__Group_3__0__Impl rule__RadialGradient__Group_3__1 ;
    public final void rule__RadialGradient__Group_3__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalLatteCSS.g:7912:1: ( rule__RadialGradient__Group_3__0__Impl rule__RadialGradient__Group_3__1 )
            // InternalLatteCSS.g:7913:2: rule__RadialGradient__Group_3__0__Impl rule__RadialGradient__Group_3__1
            {
            pushFollow(FOLLOW_30);
            rule__RadialGradient__Group_3__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__RadialGradient__Group_3__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__RadialGradient__Group_3__0"


    // $ANTLR start "rule__RadialGradient__Group_3__0__Impl"
    // InternalLatteCSS.g:7920:1: rule__RadialGradient__Group_3__0__Impl : ( 'focus' ) ;
    public final void rule__RadialGradient__Group_3__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalLatteCSS.g:7924:1: ( ( 'focus' ) )
            // InternalLatteCSS.g:7925:1: ( 'focus' )
            {
            // InternalLatteCSS.g:7925:1: ( 'focus' )
            // InternalLatteCSS.g:7926:1: 'focus'
            {
             before(grammarAccess.getRadialGradientAccess().getFocusKeyword_3_0()); 
            match(input,286,FOLLOW_2); 
             after(grammarAccess.getRadialGradientAccess().getFocusKeyword_3_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__RadialGradient__Group_3__0__Impl"


    // $ANTLR start "rule__RadialGradient__Group_3__1"
    // InternalLatteCSS.g:7939:1: rule__RadialGradient__Group_3__1 : rule__RadialGradient__Group_3__1__Impl rule__RadialGradient__Group_3__2 ;
    public final void rule__RadialGradient__Group_3__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalLatteCSS.g:7943:1: ( rule__RadialGradient__Group_3__1__Impl rule__RadialGradient__Group_3__2 )
            // InternalLatteCSS.g:7944:2: rule__RadialGradient__Group_3__1__Impl rule__RadialGradient__Group_3__2
            {
            pushFollow(FOLLOW_16);
            rule__RadialGradient__Group_3__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__RadialGradient__Group_3__2();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__RadialGradient__Group_3__1"


    // $ANTLR start "rule__RadialGradient__Group_3__1__Impl"
    // InternalLatteCSS.g:7951:1: rule__RadialGradient__Group_3__1__Impl : ( '(' ) ;
    public final void rule__RadialGradient__Group_3__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalLatteCSS.g:7955:1: ( ( '(' ) )
            // InternalLatteCSS.g:7956:1: ( '(' )
            {
            // InternalLatteCSS.g:7956:1: ( '(' )
            // InternalLatteCSS.g:7957:1: '('
            {
             before(grammarAccess.getRadialGradientAccess().getLeftParenthesisKeyword_3_1()); 
            match(input,281,FOLLOW_2); 
             after(grammarAccess.getRadialGradientAccess().getLeftParenthesisKeyword_3_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__RadialGradient__Group_3__1__Impl"


    // $ANTLR start "rule__RadialGradient__Group_3__2"
    // InternalLatteCSS.g:7970:1: rule__RadialGradient__Group_3__2 : rule__RadialGradient__Group_3__2__Impl rule__RadialGradient__Group_3__3 ;
    public final void rule__RadialGradient__Group_3__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalLatteCSS.g:7974:1: ( rule__RadialGradient__Group_3__2__Impl rule__RadialGradient__Group_3__3 )
            // InternalLatteCSS.g:7975:2: rule__RadialGradient__Group_3__2__Impl rule__RadialGradient__Group_3__3
            {
            pushFollow(FOLLOW_20);
            rule__RadialGradient__Group_3__2__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__RadialGradient__Group_3__3();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__RadialGradient__Group_3__2"


    // $ANTLR start "rule__RadialGradient__Group_3__2__Impl"
    // InternalLatteCSS.g:7982:1: rule__RadialGradient__Group_3__2__Impl : ( ( rule__RadialGradient__FxAssignment_3_2 ) ) ;
    public final void rule__RadialGradient__Group_3__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalLatteCSS.g:7986:1: ( ( ( rule__RadialGradient__FxAssignment_3_2 ) ) )
            // InternalLatteCSS.g:7987:1: ( ( rule__RadialGradient__FxAssignment_3_2 ) )
            {
            // InternalLatteCSS.g:7987:1: ( ( rule__RadialGradient__FxAssignment_3_2 ) )
            // InternalLatteCSS.g:7988:1: ( rule__RadialGradient__FxAssignment_3_2 )
            {
             before(grammarAccess.getRadialGradientAccess().getFxAssignment_3_2()); 
            // InternalLatteCSS.g:7989:1: ( rule__RadialGradient__FxAssignment_3_2 )
            // InternalLatteCSS.g:7989:2: rule__RadialGradient__FxAssignment_3_2
            {
            pushFollow(FOLLOW_2);
            rule__RadialGradient__FxAssignment_3_2();

            state._fsp--;


            }

             after(grammarAccess.getRadialGradientAccess().getFxAssignment_3_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__RadialGradient__Group_3__2__Impl"


    // $ANTLR start "rule__RadialGradient__Group_3__3"
    // InternalLatteCSS.g:7999:1: rule__RadialGradient__Group_3__3 : rule__RadialGradient__Group_3__3__Impl rule__RadialGradient__Group_3__4 ;
    public final void rule__RadialGradient__Group_3__3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalLatteCSS.g:8003:1: ( rule__RadialGradient__Group_3__3__Impl rule__RadialGradient__Group_3__4 )
            // InternalLatteCSS.g:8004:2: rule__RadialGradient__Group_3__3__Impl rule__RadialGradient__Group_3__4
            {
            pushFollow(FOLLOW_16);
            rule__RadialGradient__Group_3__3__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__RadialGradient__Group_3__4();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__RadialGradient__Group_3__3"


    // $ANTLR start "rule__RadialGradient__Group_3__3__Impl"
    // InternalLatteCSS.g:8011:1: rule__RadialGradient__Group_3__3__Impl : ( ',' ) ;
    public final void rule__RadialGradient__Group_3__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalLatteCSS.g:8015:1: ( ( ',' ) )
            // InternalLatteCSS.g:8016:1: ( ',' )
            {
            // InternalLatteCSS.g:8016:1: ( ',' )
            // InternalLatteCSS.g:8017:1: ','
            {
             before(grammarAccess.getRadialGradientAccess().getCommaKeyword_3_3()); 
            match(input,276,FOLLOW_2); 
             after(grammarAccess.getRadialGradientAccess().getCommaKeyword_3_3()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__RadialGradient__Group_3__3__Impl"


    // $ANTLR start "rule__RadialGradient__Group_3__4"
    // InternalLatteCSS.g:8030:1: rule__RadialGradient__Group_3__4 : rule__RadialGradient__Group_3__4__Impl rule__RadialGradient__Group_3__5 ;
    public final void rule__RadialGradient__Group_3__4() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalLatteCSS.g:8034:1: ( rule__RadialGradient__Group_3__4__Impl rule__RadialGradient__Group_3__5 )
            // InternalLatteCSS.g:8035:2: rule__RadialGradient__Group_3__4__Impl rule__RadialGradient__Group_3__5
            {
            pushFollow(FOLLOW_31);
            rule__RadialGradient__Group_3__4__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__RadialGradient__Group_3__5();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__RadialGradient__Group_3__4"


    // $ANTLR start "rule__RadialGradient__Group_3__4__Impl"
    // InternalLatteCSS.g:8042:1: rule__RadialGradient__Group_3__4__Impl : ( ( rule__RadialGradient__FyAssignment_3_4 ) ) ;
    public final void rule__RadialGradient__Group_3__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalLatteCSS.g:8046:1: ( ( ( rule__RadialGradient__FyAssignment_3_4 ) ) )
            // InternalLatteCSS.g:8047:1: ( ( rule__RadialGradient__FyAssignment_3_4 ) )
            {
            // InternalLatteCSS.g:8047:1: ( ( rule__RadialGradient__FyAssignment_3_4 ) )
            // InternalLatteCSS.g:8048:1: ( rule__RadialGradient__FyAssignment_3_4 )
            {
             before(grammarAccess.getRadialGradientAccess().getFyAssignment_3_4()); 
            // InternalLatteCSS.g:8049:1: ( rule__RadialGradient__FyAssignment_3_4 )
            // InternalLatteCSS.g:8049:2: rule__RadialGradient__FyAssignment_3_4
            {
            pushFollow(FOLLOW_2);
            rule__RadialGradient__FyAssignment_3_4();

            state._fsp--;


            }

             after(grammarAccess.getRadialGradientAccess().getFyAssignment_3_4()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__RadialGradient__Group_3__4__Impl"


    // $ANTLR start "rule__RadialGradient__Group_3__5"
    // InternalLatteCSS.g:8059:1: rule__RadialGradient__Group_3__5 : rule__RadialGradient__Group_3__5__Impl ;
    public final void rule__RadialGradient__Group_3__5() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalLatteCSS.g:8063:1: ( rule__RadialGradient__Group_3__5__Impl )
            // InternalLatteCSS.g:8064:2: rule__RadialGradient__Group_3__5__Impl
            {
            pushFollow(FOLLOW_2);
            rule__RadialGradient__Group_3__5__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__RadialGradient__Group_3__5"


    // $ANTLR start "rule__RadialGradient__Group_3__5__Impl"
    // InternalLatteCSS.g:8070:1: rule__RadialGradient__Group_3__5__Impl : ( ')' ) ;
    public final void rule__RadialGradient__Group_3__5__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalLatteCSS.g:8074:1: ( ( ')' ) )
            // InternalLatteCSS.g:8075:1: ( ')' )
            {
            // InternalLatteCSS.g:8075:1: ( ')' )
            // InternalLatteCSS.g:8076:1: ')'
            {
             before(grammarAccess.getRadialGradientAccess().getRightParenthesisKeyword_3_5()); 
            match(input,282,FOLLOW_2); 
             after(grammarAccess.getRadialGradientAccess().getRightParenthesisKeyword_3_5()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__RadialGradient__Group_3__5__Impl"


    // $ANTLR start "rule__RadialGradient__Group_5__0"
    // InternalLatteCSS.g:8101:1: rule__RadialGradient__Group_5__0 : rule__RadialGradient__Group_5__0__Impl rule__RadialGradient__Group_5__1 ;
    public final void rule__RadialGradient__Group_5__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalLatteCSS.g:8105:1: ( rule__RadialGradient__Group_5__0__Impl rule__RadialGradient__Group_5__1 )
            // InternalLatteCSS.g:8106:2: rule__RadialGradient__Group_5__0__Impl rule__RadialGradient__Group_5__1
            {
            pushFollow(FOLLOW_16);
            rule__RadialGradient__Group_5__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__RadialGradient__Group_5__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__RadialGradient__Group_5__0"


    // $ANTLR start "rule__RadialGradient__Group_5__0__Impl"
    // InternalLatteCSS.g:8113:1: rule__RadialGradient__Group_5__0__Impl : ( '(' ) ;
    public final void rule__RadialGradient__Group_5__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalLatteCSS.g:8117:1: ( ( '(' ) )
            // InternalLatteCSS.g:8118:1: ( '(' )
            {
            // InternalLatteCSS.g:8118:1: ( '(' )
            // InternalLatteCSS.g:8119:1: '('
            {
             before(grammarAccess.getRadialGradientAccess().getLeftParenthesisKeyword_5_0()); 
            match(input,281,FOLLOW_2); 
             after(grammarAccess.getRadialGradientAccess().getLeftParenthesisKeyword_5_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__RadialGradient__Group_5__0__Impl"


    // $ANTLR start "rule__RadialGradient__Group_5__1"
    // InternalLatteCSS.g:8132:1: rule__RadialGradient__Group_5__1 : rule__RadialGradient__Group_5__1__Impl rule__RadialGradient__Group_5__2 ;
    public final void rule__RadialGradient__Group_5__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalLatteCSS.g:8136:1: ( rule__RadialGradient__Group_5__1__Impl rule__RadialGradient__Group_5__2 )
            // InternalLatteCSS.g:8137:2: rule__RadialGradient__Group_5__1__Impl rule__RadialGradient__Group_5__2
            {
            pushFollow(FOLLOW_31);
            rule__RadialGradient__Group_5__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__RadialGradient__Group_5__2();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__RadialGradient__Group_5__1"


    // $ANTLR start "rule__RadialGradient__Group_5__1__Impl"
    // InternalLatteCSS.g:8144:1: rule__RadialGradient__Group_5__1__Impl : ( ( rule__RadialGradient__StopsAssignment_5_1 ) ) ;
    public final void rule__RadialGradient__Group_5__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalLatteCSS.g:8148:1: ( ( ( rule__RadialGradient__StopsAssignment_5_1 ) ) )
            // InternalLatteCSS.g:8149:1: ( ( rule__RadialGradient__StopsAssignment_5_1 ) )
            {
            // InternalLatteCSS.g:8149:1: ( ( rule__RadialGradient__StopsAssignment_5_1 ) )
            // InternalLatteCSS.g:8150:1: ( rule__RadialGradient__StopsAssignment_5_1 )
            {
             before(grammarAccess.getRadialGradientAccess().getStopsAssignment_5_1()); 
            // InternalLatteCSS.g:8151:1: ( rule__RadialGradient__StopsAssignment_5_1 )
            // InternalLatteCSS.g:8151:2: rule__RadialGradient__StopsAssignment_5_1
            {
            pushFollow(FOLLOW_2);
            rule__RadialGradient__StopsAssignment_5_1();

            state._fsp--;


            }

             after(grammarAccess.getRadialGradientAccess().getStopsAssignment_5_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__RadialGradient__Group_5__1__Impl"


    // $ANTLR start "rule__RadialGradient__Group_5__2"
    // InternalLatteCSS.g:8161:1: rule__RadialGradient__Group_5__2 : rule__RadialGradient__Group_5__2__Impl ;
    public final void rule__RadialGradient__Group_5__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalLatteCSS.g:8165:1: ( rule__RadialGradient__Group_5__2__Impl )
            // InternalLatteCSS.g:8166:2: rule__RadialGradient__Group_5__2__Impl
            {
            pushFollow(FOLLOW_2);
            rule__RadialGradient__Group_5__2__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__RadialGradient__Group_5__2"


    // $ANTLR start "rule__RadialGradient__Group_5__2__Impl"
    // InternalLatteCSS.g:8172:1: rule__RadialGradient__Group_5__2__Impl : ( ')' ) ;
    public final void rule__RadialGradient__Group_5__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalLatteCSS.g:8176:1: ( ( ')' ) )
            // InternalLatteCSS.g:8177:1: ( ')' )
            {
            // InternalLatteCSS.g:8177:1: ( ')' )
            // InternalLatteCSS.g:8178:1: ')'
            {
             before(grammarAccess.getRadialGradientAccess().getRightParenthesisKeyword_5_2()); 
            match(input,282,FOLLOW_2); 
             after(grammarAccess.getRadialGradientAccess().getRightParenthesisKeyword_5_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__RadialGradient__Group_5__2__Impl"


    // $ANTLR start "rule__StopValue__Group__0"
    // InternalLatteCSS.g:8197:1: rule__StopValue__Group__0 : rule__StopValue__Group__0__Impl rule__StopValue__Group__1 ;
    public final void rule__StopValue__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalLatteCSS.g:8201:1: ( rule__StopValue__Group__0__Impl rule__StopValue__Group__1 )
            // InternalLatteCSS.g:8202:2: rule__StopValue__Group__0__Impl rule__StopValue__Group__1
            {
            pushFollow(FOLLOW_20);
            rule__StopValue__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__StopValue__Group__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__StopValue__Group__0"


    // $ANTLR start "rule__StopValue__Group__0__Impl"
    // InternalLatteCSS.g:8209:1: rule__StopValue__Group__0__Impl : ( ( rule__StopValue__PosAssignment_0 ) ) ;
    public final void rule__StopValue__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalLatteCSS.g:8213:1: ( ( ( rule__StopValue__PosAssignment_0 ) ) )
            // InternalLatteCSS.g:8214:1: ( ( rule__StopValue__PosAssignment_0 ) )
            {
            // InternalLatteCSS.g:8214:1: ( ( rule__StopValue__PosAssignment_0 ) )
            // InternalLatteCSS.g:8215:1: ( rule__StopValue__PosAssignment_0 )
            {
             before(grammarAccess.getStopValueAccess().getPosAssignment_0()); 
            // InternalLatteCSS.g:8216:1: ( rule__StopValue__PosAssignment_0 )
            // InternalLatteCSS.g:8216:2: rule__StopValue__PosAssignment_0
            {
            pushFollow(FOLLOW_2);
            rule__StopValue__PosAssignment_0();

            state._fsp--;


            }

             after(grammarAccess.getStopValueAccess().getPosAssignment_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__StopValue__Group__0__Impl"


    // $ANTLR start "rule__StopValue__Group__1"
    // InternalLatteCSS.g:8226:1: rule__StopValue__Group__1 : rule__StopValue__Group__1__Impl rule__StopValue__Group__2 ;
    public final void rule__StopValue__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalLatteCSS.g:8230:1: ( rule__StopValue__Group__1__Impl rule__StopValue__Group__2 )
            // InternalLatteCSS.g:8231:2: rule__StopValue__Group__1__Impl rule__StopValue__Group__2
            {
            pushFollow(FOLLOW_18);
            rule__StopValue__Group__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__StopValue__Group__2();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__StopValue__Group__1"


    // $ANTLR start "rule__StopValue__Group__1__Impl"
    // InternalLatteCSS.g:8238:1: rule__StopValue__Group__1__Impl : ( ',' ) ;
    public final void rule__StopValue__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalLatteCSS.g:8242:1: ( ( ',' ) )
            // InternalLatteCSS.g:8243:1: ( ',' )
            {
            // InternalLatteCSS.g:8243:1: ( ',' )
            // InternalLatteCSS.g:8244:1: ','
            {
             before(grammarAccess.getStopValueAccess().getCommaKeyword_1()); 
            match(input,276,FOLLOW_2); 
             after(grammarAccess.getStopValueAccess().getCommaKeyword_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__StopValue__Group__1__Impl"


    // $ANTLR start "rule__StopValue__Group__2"
    // InternalLatteCSS.g:8257:1: rule__StopValue__Group__2 : rule__StopValue__Group__2__Impl ;
    public final void rule__StopValue__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalLatteCSS.g:8261:1: ( rule__StopValue__Group__2__Impl )
            // InternalLatteCSS.g:8262:2: rule__StopValue__Group__2__Impl
            {
            pushFollow(FOLLOW_2);
            rule__StopValue__Group__2__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__StopValue__Group__2"


    // $ANTLR start "rule__StopValue__Group__2__Impl"
    // InternalLatteCSS.g:8268:1: rule__StopValue__Group__2__Impl : ( ( rule__StopValue__ColorAssignment_2 ) ) ;
    public final void rule__StopValue__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalLatteCSS.g:8272:1: ( ( ( rule__StopValue__ColorAssignment_2 ) ) )
            // InternalLatteCSS.g:8273:1: ( ( rule__StopValue__ColorAssignment_2 ) )
            {
            // InternalLatteCSS.g:8273:1: ( ( rule__StopValue__ColorAssignment_2 ) )
            // InternalLatteCSS.g:8274:1: ( rule__StopValue__ColorAssignment_2 )
            {
             before(grammarAccess.getStopValueAccess().getColorAssignment_2()); 
            // InternalLatteCSS.g:8275:1: ( rule__StopValue__ColorAssignment_2 )
            // InternalLatteCSS.g:8275:2: rule__StopValue__ColorAssignment_2
            {
            pushFollow(FOLLOW_2);
            rule__StopValue__ColorAssignment_2();

            state._fsp--;


            }

             after(grammarAccess.getStopValueAccess().getColorAssignment_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__StopValue__Group__2__Impl"


    // $ANTLR start "rule__RGBColor__Group_1__0"
    // InternalLatteCSS.g:8291:1: rule__RGBColor__Group_1__0 : rule__RGBColor__Group_1__0__Impl rule__RGBColor__Group_1__1 ;
    public final void rule__RGBColor__Group_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalLatteCSS.g:8295:1: ( rule__RGBColor__Group_1__0__Impl rule__RGBColor__Group_1__1 )
            // InternalLatteCSS.g:8296:2: rule__RGBColor__Group_1__0__Impl rule__RGBColor__Group_1__1
            {
            pushFollow(FOLLOW_30);
            rule__RGBColor__Group_1__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__RGBColor__Group_1__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__RGBColor__Group_1__0"


    // $ANTLR start "rule__RGBColor__Group_1__0__Impl"
    // InternalLatteCSS.g:8303:1: rule__RGBColor__Group_1__0__Impl : ( 'rgb' ) ;
    public final void rule__RGBColor__Group_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalLatteCSS.g:8307:1: ( ( 'rgb' ) )
            // InternalLatteCSS.g:8308:1: ( 'rgb' )
            {
            // InternalLatteCSS.g:8308:1: ( 'rgb' )
            // InternalLatteCSS.g:8309:1: 'rgb'
            {
             before(grammarAccess.getRGBColorAccess().getRgbKeyword_1_0()); 
            match(input,287,FOLLOW_2); 
             after(grammarAccess.getRGBColorAccess().getRgbKeyword_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__RGBColor__Group_1__0__Impl"


    // $ANTLR start "rule__RGBColor__Group_1__1"
    // InternalLatteCSS.g:8322:1: rule__RGBColor__Group_1__1 : rule__RGBColor__Group_1__1__Impl rule__RGBColor__Group_1__2 ;
    public final void rule__RGBColor__Group_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalLatteCSS.g:8326:1: ( rule__RGBColor__Group_1__1__Impl rule__RGBColor__Group_1__2 )
            // InternalLatteCSS.g:8327:2: rule__RGBColor__Group_1__1__Impl rule__RGBColor__Group_1__2
            {
            pushFollow(FOLLOW_38);
            rule__RGBColor__Group_1__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__RGBColor__Group_1__2();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__RGBColor__Group_1__1"


    // $ANTLR start "rule__RGBColor__Group_1__1__Impl"
    // InternalLatteCSS.g:8334:1: rule__RGBColor__Group_1__1__Impl : ( '(' ) ;
    public final void rule__RGBColor__Group_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalLatteCSS.g:8338:1: ( ( '(' ) )
            // InternalLatteCSS.g:8339:1: ( '(' )
            {
            // InternalLatteCSS.g:8339:1: ( '(' )
            // InternalLatteCSS.g:8340:1: '('
            {
             before(grammarAccess.getRGBColorAccess().getLeftParenthesisKeyword_1_1()); 
            match(input,281,FOLLOW_2); 
             after(grammarAccess.getRGBColorAccess().getLeftParenthesisKeyword_1_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__RGBColor__Group_1__1__Impl"


    // $ANTLR start "rule__RGBColor__Group_1__2"
    // InternalLatteCSS.g:8353:1: rule__RGBColor__Group_1__2 : rule__RGBColor__Group_1__2__Impl rule__RGBColor__Group_1__3 ;
    public final void rule__RGBColor__Group_1__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalLatteCSS.g:8357:1: ( rule__RGBColor__Group_1__2__Impl rule__RGBColor__Group_1__3 )
            // InternalLatteCSS.g:8358:2: rule__RGBColor__Group_1__2__Impl rule__RGBColor__Group_1__3
            {
            pushFollow(FOLLOW_20);
            rule__RGBColor__Group_1__2__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__RGBColor__Group_1__3();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__RGBColor__Group_1__2"


    // $ANTLR start "rule__RGBColor__Group_1__2__Impl"
    // InternalLatteCSS.g:8365:1: rule__RGBColor__Group_1__2__Impl : ( ( rule__RGBColor__RAssignment_1_2 ) ) ;
    public final void rule__RGBColor__Group_1__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalLatteCSS.g:8369:1: ( ( ( rule__RGBColor__RAssignment_1_2 ) ) )
            // InternalLatteCSS.g:8370:1: ( ( rule__RGBColor__RAssignment_1_2 ) )
            {
            // InternalLatteCSS.g:8370:1: ( ( rule__RGBColor__RAssignment_1_2 ) )
            // InternalLatteCSS.g:8371:1: ( rule__RGBColor__RAssignment_1_2 )
            {
             before(grammarAccess.getRGBColorAccess().getRAssignment_1_2()); 
            // InternalLatteCSS.g:8372:1: ( rule__RGBColor__RAssignment_1_2 )
            // InternalLatteCSS.g:8372:2: rule__RGBColor__RAssignment_1_2
            {
            pushFollow(FOLLOW_2);
            rule__RGBColor__RAssignment_1_2();

            state._fsp--;


            }

             after(grammarAccess.getRGBColorAccess().getRAssignment_1_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__RGBColor__Group_1__2__Impl"


    // $ANTLR start "rule__RGBColor__Group_1__3"
    // InternalLatteCSS.g:8382:1: rule__RGBColor__Group_1__3 : rule__RGBColor__Group_1__3__Impl rule__RGBColor__Group_1__4 ;
    public final void rule__RGBColor__Group_1__3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalLatteCSS.g:8386:1: ( rule__RGBColor__Group_1__3__Impl rule__RGBColor__Group_1__4 )
            // InternalLatteCSS.g:8387:2: rule__RGBColor__Group_1__3__Impl rule__RGBColor__Group_1__4
            {
            pushFollow(FOLLOW_38);
            rule__RGBColor__Group_1__3__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__RGBColor__Group_1__4();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__RGBColor__Group_1__3"


    // $ANTLR start "rule__RGBColor__Group_1__3__Impl"
    // InternalLatteCSS.g:8394:1: rule__RGBColor__Group_1__3__Impl : ( ',' ) ;
    public final void rule__RGBColor__Group_1__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalLatteCSS.g:8398:1: ( ( ',' ) )
            // InternalLatteCSS.g:8399:1: ( ',' )
            {
            // InternalLatteCSS.g:8399:1: ( ',' )
            // InternalLatteCSS.g:8400:1: ','
            {
             before(grammarAccess.getRGBColorAccess().getCommaKeyword_1_3()); 
            match(input,276,FOLLOW_2); 
             after(grammarAccess.getRGBColorAccess().getCommaKeyword_1_3()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__RGBColor__Group_1__3__Impl"


    // $ANTLR start "rule__RGBColor__Group_1__4"
    // InternalLatteCSS.g:8413:1: rule__RGBColor__Group_1__4 : rule__RGBColor__Group_1__4__Impl rule__RGBColor__Group_1__5 ;
    public final void rule__RGBColor__Group_1__4() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalLatteCSS.g:8417:1: ( rule__RGBColor__Group_1__4__Impl rule__RGBColor__Group_1__5 )
            // InternalLatteCSS.g:8418:2: rule__RGBColor__Group_1__4__Impl rule__RGBColor__Group_1__5
            {
            pushFollow(FOLLOW_20);
            rule__RGBColor__Group_1__4__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__RGBColor__Group_1__5();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__RGBColor__Group_1__4"


    // $ANTLR start "rule__RGBColor__Group_1__4__Impl"
    // InternalLatteCSS.g:8425:1: rule__RGBColor__Group_1__4__Impl : ( ( rule__RGBColor__GAssignment_1_4 ) ) ;
    public final void rule__RGBColor__Group_1__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalLatteCSS.g:8429:1: ( ( ( rule__RGBColor__GAssignment_1_4 ) ) )
            // InternalLatteCSS.g:8430:1: ( ( rule__RGBColor__GAssignment_1_4 ) )
            {
            // InternalLatteCSS.g:8430:1: ( ( rule__RGBColor__GAssignment_1_4 ) )
            // InternalLatteCSS.g:8431:1: ( rule__RGBColor__GAssignment_1_4 )
            {
             before(grammarAccess.getRGBColorAccess().getGAssignment_1_4()); 
            // InternalLatteCSS.g:8432:1: ( rule__RGBColor__GAssignment_1_4 )
            // InternalLatteCSS.g:8432:2: rule__RGBColor__GAssignment_1_4
            {
            pushFollow(FOLLOW_2);
            rule__RGBColor__GAssignment_1_4();

            state._fsp--;


            }

             after(grammarAccess.getRGBColorAccess().getGAssignment_1_4()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__RGBColor__Group_1__4__Impl"


    // $ANTLR start "rule__RGBColor__Group_1__5"
    // InternalLatteCSS.g:8442:1: rule__RGBColor__Group_1__5 : rule__RGBColor__Group_1__5__Impl rule__RGBColor__Group_1__6 ;
    public final void rule__RGBColor__Group_1__5() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalLatteCSS.g:8446:1: ( rule__RGBColor__Group_1__5__Impl rule__RGBColor__Group_1__6 )
            // InternalLatteCSS.g:8447:2: rule__RGBColor__Group_1__5__Impl rule__RGBColor__Group_1__6
            {
            pushFollow(FOLLOW_38);
            rule__RGBColor__Group_1__5__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__RGBColor__Group_1__6();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__RGBColor__Group_1__5"


    // $ANTLR start "rule__RGBColor__Group_1__5__Impl"
    // InternalLatteCSS.g:8454:1: rule__RGBColor__Group_1__5__Impl : ( ',' ) ;
    public final void rule__RGBColor__Group_1__5__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalLatteCSS.g:8458:1: ( ( ',' ) )
            // InternalLatteCSS.g:8459:1: ( ',' )
            {
            // InternalLatteCSS.g:8459:1: ( ',' )
            // InternalLatteCSS.g:8460:1: ','
            {
             before(grammarAccess.getRGBColorAccess().getCommaKeyword_1_5()); 
            match(input,276,FOLLOW_2); 
             after(grammarAccess.getRGBColorAccess().getCommaKeyword_1_5()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__RGBColor__Group_1__5__Impl"


    // $ANTLR start "rule__RGBColor__Group_1__6"
    // InternalLatteCSS.g:8473:1: rule__RGBColor__Group_1__6 : rule__RGBColor__Group_1__6__Impl rule__RGBColor__Group_1__7 ;
    public final void rule__RGBColor__Group_1__6() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalLatteCSS.g:8477:1: ( rule__RGBColor__Group_1__6__Impl rule__RGBColor__Group_1__7 )
            // InternalLatteCSS.g:8478:2: rule__RGBColor__Group_1__6__Impl rule__RGBColor__Group_1__7
            {
            pushFollow(FOLLOW_31);
            rule__RGBColor__Group_1__6__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__RGBColor__Group_1__7();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__RGBColor__Group_1__6"


    // $ANTLR start "rule__RGBColor__Group_1__6__Impl"
    // InternalLatteCSS.g:8485:1: rule__RGBColor__Group_1__6__Impl : ( ( rule__RGBColor__BAssignment_1_6 ) ) ;
    public final void rule__RGBColor__Group_1__6__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalLatteCSS.g:8489:1: ( ( ( rule__RGBColor__BAssignment_1_6 ) ) )
            // InternalLatteCSS.g:8490:1: ( ( rule__RGBColor__BAssignment_1_6 ) )
            {
            // InternalLatteCSS.g:8490:1: ( ( rule__RGBColor__BAssignment_1_6 ) )
            // InternalLatteCSS.g:8491:1: ( rule__RGBColor__BAssignment_1_6 )
            {
             before(grammarAccess.getRGBColorAccess().getBAssignment_1_6()); 
            // InternalLatteCSS.g:8492:1: ( rule__RGBColor__BAssignment_1_6 )
            // InternalLatteCSS.g:8492:2: rule__RGBColor__BAssignment_1_6
            {
            pushFollow(FOLLOW_2);
            rule__RGBColor__BAssignment_1_6();

            state._fsp--;


            }

             after(grammarAccess.getRGBColorAccess().getBAssignment_1_6()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__RGBColor__Group_1__6__Impl"


    // $ANTLR start "rule__RGBColor__Group_1__7"
    // InternalLatteCSS.g:8502:1: rule__RGBColor__Group_1__7 : rule__RGBColor__Group_1__7__Impl ;
    public final void rule__RGBColor__Group_1__7() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalLatteCSS.g:8506:1: ( rule__RGBColor__Group_1__7__Impl )
            // InternalLatteCSS.g:8507:2: rule__RGBColor__Group_1__7__Impl
            {
            pushFollow(FOLLOW_2);
            rule__RGBColor__Group_1__7__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__RGBColor__Group_1__7"


    // $ANTLR start "rule__RGBColor__Group_1__7__Impl"
    // InternalLatteCSS.g:8513:1: rule__RGBColor__Group_1__7__Impl : ( ')' ) ;
    public final void rule__RGBColor__Group_1__7__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalLatteCSS.g:8517:1: ( ( ')' ) )
            // InternalLatteCSS.g:8518:1: ( ')' )
            {
            // InternalLatteCSS.g:8518:1: ( ')' )
            // InternalLatteCSS.g:8519:1: ')'
            {
             before(grammarAccess.getRGBColorAccess().getRightParenthesisKeyword_1_7()); 
            match(input,282,FOLLOW_2); 
             after(grammarAccess.getRGBColorAccess().getRightParenthesisKeyword_1_7()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__RGBColor__Group_1__7__Impl"


    // $ANTLR start "rule__RGBColor__Group_2__0"
    // InternalLatteCSS.g:8548:1: rule__RGBColor__Group_2__0 : rule__RGBColor__Group_2__0__Impl rule__RGBColor__Group_2__1 ;
    public final void rule__RGBColor__Group_2__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalLatteCSS.g:8552:1: ( rule__RGBColor__Group_2__0__Impl rule__RGBColor__Group_2__1 )
            // InternalLatteCSS.g:8553:2: rule__RGBColor__Group_2__0__Impl rule__RGBColor__Group_2__1
            {
            pushFollow(FOLLOW_30);
            rule__RGBColor__Group_2__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__RGBColor__Group_2__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__RGBColor__Group_2__0"


    // $ANTLR start "rule__RGBColor__Group_2__0__Impl"
    // InternalLatteCSS.g:8560:1: rule__RGBColor__Group_2__0__Impl : ( 'rgba' ) ;
    public final void rule__RGBColor__Group_2__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalLatteCSS.g:8564:1: ( ( 'rgba' ) )
            // InternalLatteCSS.g:8565:1: ( 'rgba' )
            {
            // InternalLatteCSS.g:8565:1: ( 'rgba' )
            // InternalLatteCSS.g:8566:1: 'rgba'
            {
             before(grammarAccess.getRGBColorAccess().getRgbaKeyword_2_0()); 
            match(input,288,FOLLOW_2); 
             after(grammarAccess.getRGBColorAccess().getRgbaKeyword_2_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__RGBColor__Group_2__0__Impl"


    // $ANTLR start "rule__RGBColor__Group_2__1"
    // InternalLatteCSS.g:8579:1: rule__RGBColor__Group_2__1 : rule__RGBColor__Group_2__1__Impl rule__RGBColor__Group_2__2 ;
    public final void rule__RGBColor__Group_2__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalLatteCSS.g:8583:1: ( rule__RGBColor__Group_2__1__Impl rule__RGBColor__Group_2__2 )
            // InternalLatteCSS.g:8584:2: rule__RGBColor__Group_2__1__Impl rule__RGBColor__Group_2__2
            {
            pushFollow(FOLLOW_38);
            rule__RGBColor__Group_2__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__RGBColor__Group_2__2();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__RGBColor__Group_2__1"


    // $ANTLR start "rule__RGBColor__Group_2__1__Impl"
    // InternalLatteCSS.g:8591:1: rule__RGBColor__Group_2__1__Impl : ( '(' ) ;
    public final void rule__RGBColor__Group_2__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalLatteCSS.g:8595:1: ( ( '(' ) )
            // InternalLatteCSS.g:8596:1: ( '(' )
            {
            // InternalLatteCSS.g:8596:1: ( '(' )
            // InternalLatteCSS.g:8597:1: '('
            {
             before(grammarAccess.getRGBColorAccess().getLeftParenthesisKeyword_2_1()); 
            match(input,281,FOLLOW_2); 
             after(grammarAccess.getRGBColorAccess().getLeftParenthesisKeyword_2_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__RGBColor__Group_2__1__Impl"


    // $ANTLR start "rule__RGBColor__Group_2__2"
    // InternalLatteCSS.g:8610:1: rule__RGBColor__Group_2__2 : rule__RGBColor__Group_2__2__Impl rule__RGBColor__Group_2__3 ;
    public final void rule__RGBColor__Group_2__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalLatteCSS.g:8614:1: ( rule__RGBColor__Group_2__2__Impl rule__RGBColor__Group_2__3 )
            // InternalLatteCSS.g:8615:2: rule__RGBColor__Group_2__2__Impl rule__RGBColor__Group_2__3
            {
            pushFollow(FOLLOW_20);
            rule__RGBColor__Group_2__2__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__RGBColor__Group_2__3();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__RGBColor__Group_2__2"


    // $ANTLR start "rule__RGBColor__Group_2__2__Impl"
    // InternalLatteCSS.g:8622:1: rule__RGBColor__Group_2__2__Impl : ( ( rule__RGBColor__RAssignment_2_2 ) ) ;
    public final void rule__RGBColor__Group_2__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalLatteCSS.g:8626:1: ( ( ( rule__RGBColor__RAssignment_2_2 ) ) )
            // InternalLatteCSS.g:8627:1: ( ( rule__RGBColor__RAssignment_2_2 ) )
            {
            // InternalLatteCSS.g:8627:1: ( ( rule__RGBColor__RAssignment_2_2 ) )
            // InternalLatteCSS.g:8628:1: ( rule__RGBColor__RAssignment_2_2 )
            {
             before(grammarAccess.getRGBColorAccess().getRAssignment_2_2()); 
            // InternalLatteCSS.g:8629:1: ( rule__RGBColor__RAssignment_2_2 )
            // InternalLatteCSS.g:8629:2: rule__RGBColor__RAssignment_2_2
            {
            pushFollow(FOLLOW_2);
            rule__RGBColor__RAssignment_2_2();

            state._fsp--;


            }

             after(grammarAccess.getRGBColorAccess().getRAssignment_2_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__RGBColor__Group_2__2__Impl"


    // $ANTLR start "rule__RGBColor__Group_2__3"
    // InternalLatteCSS.g:8639:1: rule__RGBColor__Group_2__3 : rule__RGBColor__Group_2__3__Impl rule__RGBColor__Group_2__4 ;
    public final void rule__RGBColor__Group_2__3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalLatteCSS.g:8643:1: ( rule__RGBColor__Group_2__3__Impl rule__RGBColor__Group_2__4 )
            // InternalLatteCSS.g:8644:2: rule__RGBColor__Group_2__3__Impl rule__RGBColor__Group_2__4
            {
            pushFollow(FOLLOW_38);
            rule__RGBColor__Group_2__3__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__RGBColor__Group_2__4();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__RGBColor__Group_2__3"


    // $ANTLR start "rule__RGBColor__Group_2__3__Impl"
    // InternalLatteCSS.g:8651:1: rule__RGBColor__Group_2__3__Impl : ( ',' ) ;
    public final void rule__RGBColor__Group_2__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalLatteCSS.g:8655:1: ( ( ',' ) )
            // InternalLatteCSS.g:8656:1: ( ',' )
            {
            // InternalLatteCSS.g:8656:1: ( ',' )
            // InternalLatteCSS.g:8657:1: ','
            {
             before(grammarAccess.getRGBColorAccess().getCommaKeyword_2_3()); 
            match(input,276,FOLLOW_2); 
             after(grammarAccess.getRGBColorAccess().getCommaKeyword_2_3()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__RGBColor__Group_2__3__Impl"


    // $ANTLR start "rule__RGBColor__Group_2__4"
    // InternalLatteCSS.g:8670:1: rule__RGBColor__Group_2__4 : rule__RGBColor__Group_2__4__Impl rule__RGBColor__Group_2__5 ;
    public final void rule__RGBColor__Group_2__4() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalLatteCSS.g:8674:1: ( rule__RGBColor__Group_2__4__Impl rule__RGBColor__Group_2__5 )
            // InternalLatteCSS.g:8675:2: rule__RGBColor__Group_2__4__Impl rule__RGBColor__Group_2__5
            {
            pushFollow(FOLLOW_20);
            rule__RGBColor__Group_2__4__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__RGBColor__Group_2__5();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__RGBColor__Group_2__4"


    // $ANTLR start "rule__RGBColor__Group_2__4__Impl"
    // InternalLatteCSS.g:8682:1: rule__RGBColor__Group_2__4__Impl : ( ( rule__RGBColor__GAssignment_2_4 ) ) ;
    public final void rule__RGBColor__Group_2__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalLatteCSS.g:8686:1: ( ( ( rule__RGBColor__GAssignment_2_4 ) ) )
            // InternalLatteCSS.g:8687:1: ( ( rule__RGBColor__GAssignment_2_4 ) )
            {
            // InternalLatteCSS.g:8687:1: ( ( rule__RGBColor__GAssignment_2_4 ) )
            // InternalLatteCSS.g:8688:1: ( rule__RGBColor__GAssignment_2_4 )
            {
             before(grammarAccess.getRGBColorAccess().getGAssignment_2_4()); 
            // InternalLatteCSS.g:8689:1: ( rule__RGBColor__GAssignment_2_4 )
            // InternalLatteCSS.g:8689:2: rule__RGBColor__GAssignment_2_4
            {
            pushFollow(FOLLOW_2);
            rule__RGBColor__GAssignment_2_4();

            state._fsp--;


            }

             after(grammarAccess.getRGBColorAccess().getGAssignment_2_4()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__RGBColor__Group_2__4__Impl"


    // $ANTLR start "rule__RGBColor__Group_2__5"
    // InternalLatteCSS.g:8699:1: rule__RGBColor__Group_2__5 : rule__RGBColor__Group_2__5__Impl rule__RGBColor__Group_2__6 ;
    public final void rule__RGBColor__Group_2__5() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalLatteCSS.g:8703:1: ( rule__RGBColor__Group_2__5__Impl rule__RGBColor__Group_2__6 )
            // InternalLatteCSS.g:8704:2: rule__RGBColor__Group_2__5__Impl rule__RGBColor__Group_2__6
            {
            pushFollow(FOLLOW_38);
            rule__RGBColor__Group_2__5__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__RGBColor__Group_2__6();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__RGBColor__Group_2__5"


    // $ANTLR start "rule__RGBColor__Group_2__5__Impl"
    // InternalLatteCSS.g:8711:1: rule__RGBColor__Group_2__5__Impl : ( ',' ) ;
    public final void rule__RGBColor__Group_2__5__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalLatteCSS.g:8715:1: ( ( ',' ) )
            // InternalLatteCSS.g:8716:1: ( ',' )
            {
            // InternalLatteCSS.g:8716:1: ( ',' )
            // InternalLatteCSS.g:8717:1: ','
            {
             before(grammarAccess.getRGBColorAccess().getCommaKeyword_2_5()); 
            match(input,276,FOLLOW_2); 
             after(grammarAccess.getRGBColorAccess().getCommaKeyword_2_5()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__RGBColor__Group_2__5__Impl"


    // $ANTLR start "rule__RGBColor__Group_2__6"
    // InternalLatteCSS.g:8730:1: rule__RGBColor__Group_2__6 : rule__RGBColor__Group_2__6__Impl rule__RGBColor__Group_2__7 ;
    public final void rule__RGBColor__Group_2__6() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalLatteCSS.g:8734:1: ( rule__RGBColor__Group_2__6__Impl rule__RGBColor__Group_2__7 )
            // InternalLatteCSS.g:8735:2: rule__RGBColor__Group_2__6__Impl rule__RGBColor__Group_2__7
            {
            pushFollow(FOLLOW_20);
            rule__RGBColor__Group_2__6__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__RGBColor__Group_2__7();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__RGBColor__Group_2__6"


    // $ANTLR start "rule__RGBColor__Group_2__6__Impl"
    // InternalLatteCSS.g:8742:1: rule__RGBColor__Group_2__6__Impl : ( ( rule__RGBColor__BAssignment_2_6 ) ) ;
    public final void rule__RGBColor__Group_2__6__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalLatteCSS.g:8746:1: ( ( ( rule__RGBColor__BAssignment_2_6 ) ) )
            // InternalLatteCSS.g:8747:1: ( ( rule__RGBColor__BAssignment_2_6 ) )
            {
            // InternalLatteCSS.g:8747:1: ( ( rule__RGBColor__BAssignment_2_6 ) )
            // InternalLatteCSS.g:8748:1: ( rule__RGBColor__BAssignment_2_6 )
            {
             before(grammarAccess.getRGBColorAccess().getBAssignment_2_6()); 
            // InternalLatteCSS.g:8749:1: ( rule__RGBColor__BAssignment_2_6 )
            // InternalLatteCSS.g:8749:2: rule__RGBColor__BAssignment_2_6
            {
            pushFollow(FOLLOW_2);
            rule__RGBColor__BAssignment_2_6();

            state._fsp--;


            }

             after(grammarAccess.getRGBColorAccess().getBAssignment_2_6()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__RGBColor__Group_2__6__Impl"


    // $ANTLR start "rule__RGBColor__Group_2__7"
    // InternalLatteCSS.g:8759:1: rule__RGBColor__Group_2__7 : rule__RGBColor__Group_2__7__Impl rule__RGBColor__Group_2__8 ;
    public final void rule__RGBColor__Group_2__7() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalLatteCSS.g:8763:1: ( rule__RGBColor__Group_2__7__Impl rule__RGBColor__Group_2__8 )
            // InternalLatteCSS.g:8764:2: rule__RGBColor__Group_2__7__Impl rule__RGBColor__Group_2__8
            {
            pushFollow(FOLLOW_16);
            rule__RGBColor__Group_2__7__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__RGBColor__Group_2__8();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__RGBColor__Group_2__7"


    // $ANTLR start "rule__RGBColor__Group_2__7__Impl"
    // InternalLatteCSS.g:8771:1: rule__RGBColor__Group_2__7__Impl : ( ',' ) ;
    public final void rule__RGBColor__Group_2__7__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalLatteCSS.g:8775:1: ( ( ',' ) )
            // InternalLatteCSS.g:8776:1: ( ',' )
            {
            // InternalLatteCSS.g:8776:1: ( ',' )
            // InternalLatteCSS.g:8777:1: ','
            {
             before(grammarAccess.getRGBColorAccess().getCommaKeyword_2_7()); 
            match(input,276,FOLLOW_2); 
             after(grammarAccess.getRGBColorAccess().getCommaKeyword_2_7()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__RGBColor__Group_2__7__Impl"


    // $ANTLR start "rule__RGBColor__Group_2__8"
    // InternalLatteCSS.g:8790:1: rule__RGBColor__Group_2__8 : rule__RGBColor__Group_2__8__Impl rule__RGBColor__Group_2__9 ;
    public final void rule__RGBColor__Group_2__8() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalLatteCSS.g:8794:1: ( rule__RGBColor__Group_2__8__Impl rule__RGBColor__Group_2__9 )
            // InternalLatteCSS.g:8795:2: rule__RGBColor__Group_2__8__Impl rule__RGBColor__Group_2__9
            {
            pushFollow(FOLLOW_31);
            rule__RGBColor__Group_2__8__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__RGBColor__Group_2__9();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__RGBColor__Group_2__8"


    // $ANTLR start "rule__RGBColor__Group_2__8__Impl"
    // InternalLatteCSS.g:8802:1: rule__RGBColor__Group_2__8__Impl : ( ( rule__RGBColor__AlphaAssignment_2_8 ) ) ;
    public final void rule__RGBColor__Group_2__8__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalLatteCSS.g:8806:1: ( ( ( rule__RGBColor__AlphaAssignment_2_8 ) ) )
            // InternalLatteCSS.g:8807:1: ( ( rule__RGBColor__AlphaAssignment_2_8 ) )
            {
            // InternalLatteCSS.g:8807:1: ( ( rule__RGBColor__AlphaAssignment_2_8 ) )
            // InternalLatteCSS.g:8808:1: ( rule__RGBColor__AlphaAssignment_2_8 )
            {
             before(grammarAccess.getRGBColorAccess().getAlphaAssignment_2_8()); 
            // InternalLatteCSS.g:8809:1: ( rule__RGBColor__AlphaAssignment_2_8 )
            // InternalLatteCSS.g:8809:2: rule__RGBColor__AlphaAssignment_2_8
            {
            pushFollow(FOLLOW_2);
            rule__RGBColor__AlphaAssignment_2_8();

            state._fsp--;


            }

             after(grammarAccess.getRGBColorAccess().getAlphaAssignment_2_8()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__RGBColor__Group_2__8__Impl"


    // $ANTLR start "rule__RGBColor__Group_2__9"
    // InternalLatteCSS.g:8819:1: rule__RGBColor__Group_2__9 : rule__RGBColor__Group_2__9__Impl ;
    public final void rule__RGBColor__Group_2__9() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalLatteCSS.g:8823:1: ( rule__RGBColor__Group_2__9__Impl )
            // InternalLatteCSS.g:8824:2: rule__RGBColor__Group_2__9__Impl
            {
            pushFollow(FOLLOW_2);
            rule__RGBColor__Group_2__9__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__RGBColor__Group_2__9"


    // $ANTLR start "rule__RGBColor__Group_2__9__Impl"
    // InternalLatteCSS.g:8830:1: rule__RGBColor__Group_2__9__Impl : ( ')' ) ;
    public final void rule__RGBColor__Group_2__9__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalLatteCSS.g:8834:1: ( ( ')' ) )
            // InternalLatteCSS.g:8835:1: ( ')' )
            {
            // InternalLatteCSS.g:8835:1: ( ')' )
            // InternalLatteCSS.g:8836:1: ')'
            {
             before(grammarAccess.getRGBColorAccess().getRightParenthesisKeyword_2_9()); 
            match(input,282,FOLLOW_2); 
             after(grammarAccess.getRGBColorAccess().getRightParenthesisKeyword_2_9()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__RGBColor__Group_2__9__Impl"


    // $ANTLR start "rule__CSS__DefinitionsAssignment"
    // InternalLatteCSS.g:8875:1: rule__CSS__DefinitionsAssignment : ( ruleDefinition ) ;
    public final void rule__CSS__DefinitionsAssignment() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalLatteCSS.g:8879:1: ( ( ruleDefinition ) )
            // InternalLatteCSS.g:8880:1: ( ruleDefinition )
            {
            // InternalLatteCSS.g:8880:1: ( ruleDefinition )
            // InternalLatteCSS.g:8881:1: ruleDefinition
            {
             before(grammarAccess.getCSSAccess().getDefinitionsDefinitionParserRuleCall_0()); 
            pushFollow(FOLLOW_2);
            ruleDefinition();

            state._fsp--;

             after(grammarAccess.getCSSAccess().getDefinitionsDefinitionParserRuleCall_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__CSS__DefinitionsAssignment"


    // $ANTLR start "rule__Definition__SelectorAssignment_0"
    // InternalLatteCSS.g:8890:1: rule__Definition__SelectorAssignment_0 : ( ruleSelector ) ;
    public final void rule__Definition__SelectorAssignment_0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalLatteCSS.g:8894:1: ( ( ruleSelector ) )
            // InternalLatteCSS.g:8895:1: ( ruleSelector )
            {
            // InternalLatteCSS.g:8895:1: ( ruleSelector )
            // InternalLatteCSS.g:8896:1: ruleSelector
            {
             before(grammarAccess.getDefinitionAccess().getSelectorSelectorParserRuleCall_0_0()); 
            pushFollow(FOLLOW_2);
            ruleSelector();

            state._fsp--;

             after(grammarAccess.getDefinitionAccess().getSelectorSelectorParserRuleCall_0_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Definition__SelectorAssignment_0"


    // $ANTLR start "rule__Definition__SelectorAssignment_1_1"
    // InternalLatteCSS.g:8905:1: rule__Definition__SelectorAssignment_1_1 : ( ruleSelector ) ;
    public final void rule__Definition__SelectorAssignment_1_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalLatteCSS.g:8909:1: ( ( ruleSelector ) )
            // InternalLatteCSS.g:8910:1: ( ruleSelector )
            {
            // InternalLatteCSS.g:8910:1: ( ruleSelector )
            // InternalLatteCSS.g:8911:1: ruleSelector
            {
             before(grammarAccess.getDefinitionAccess().getSelectorSelectorParserRuleCall_1_1_0()); 
            pushFollow(FOLLOW_2);
            ruleSelector();

            state._fsp--;

             after(grammarAccess.getDefinitionAccess().getSelectorSelectorParserRuleCall_1_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Definition__SelectorAssignment_1_1"


    // $ANTLR start "rule__Definition__PropertiesAssignment_3"
    // InternalLatteCSS.g:8920:1: rule__Definition__PropertiesAssignment_3 : ( ruleCSSProperty ) ;
    public final void rule__Definition__PropertiesAssignment_3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalLatteCSS.g:8924:1: ( ( ruleCSSProperty ) )
            // InternalLatteCSS.g:8925:1: ( ruleCSSProperty )
            {
            // InternalLatteCSS.g:8925:1: ( ruleCSSProperty )
            // InternalLatteCSS.g:8926:1: ruleCSSProperty
            {
             before(grammarAccess.getDefinitionAccess().getPropertiesCSSPropertyParserRuleCall_3_0()); 
            pushFollow(FOLLOW_2);
            ruleCSSProperty();

            state._fsp--;

             after(grammarAccess.getDefinitionAccess().getPropertiesCSSPropertyParserRuleCall_3_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Definition__PropertiesAssignment_3"


    // $ANTLR start "rule__Selector__SimpleSelectorAssignment"
    // InternalLatteCSS.g:8935:1: rule__Selector__SimpleSelectorAssignment : ( ruleSimpleSelector ) ;
    public final void rule__Selector__SimpleSelectorAssignment() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalLatteCSS.g:8939:1: ( ( ruleSimpleSelector ) )
            // InternalLatteCSS.g:8940:1: ( ruleSimpleSelector )
            {
            // InternalLatteCSS.g:8940:1: ( ruleSimpleSelector )
            // InternalLatteCSS.g:8941:1: ruleSimpleSelector
            {
             before(grammarAccess.getSelectorAccess().getSimpleSelectorSimpleSelectorParserRuleCall_0()); 
            pushFollow(FOLLOW_2);
            ruleSimpleSelector();

            state._fsp--;

             after(grammarAccess.getSelectorAccess().getSimpleSelectorSimpleSelectorParserRuleCall_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Selector__SimpleSelectorAssignment"


    // $ANTLR start "rule__SimpleSelector__ElementAssignment_0"
    // InternalLatteCSS.g:8950:1: rule__SimpleSelector__ElementAssignment_0 : ( RULE_ID ) ;
    public final void rule__SimpleSelector__ElementAssignment_0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalLatteCSS.g:8954:1: ( ( RULE_ID ) )
            // InternalLatteCSS.g:8955:1: ( RULE_ID )
            {
            // InternalLatteCSS.g:8955:1: ( RULE_ID )
            // InternalLatteCSS.g:8956:1: RULE_ID
            {
             before(grammarAccess.getSimpleSelectorAccess().getElementIDTerminalRuleCall_0_0()); 
            match(input,RULE_ID,FOLLOW_2); 
             after(grammarAccess.getSimpleSelectorAccess().getElementIDTerminalRuleCall_0_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__SimpleSelector__ElementAssignment_0"


    // $ANTLR start "rule__SimpleSelector__IdAssignment_1_0"
    // InternalLatteCSS.g:8965:1: rule__SimpleSelector__IdAssignment_1_0 : ( ruleIdSelector ) ;
    public final void rule__SimpleSelector__IdAssignment_1_0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalLatteCSS.g:8969:1: ( ( ruleIdSelector ) )
            // InternalLatteCSS.g:8970:1: ( ruleIdSelector )
            {
            // InternalLatteCSS.g:8970:1: ( ruleIdSelector )
            // InternalLatteCSS.g:8971:1: ruleIdSelector
            {
             before(grammarAccess.getSimpleSelectorAccess().getIdIdSelectorParserRuleCall_1_0_0()); 
            pushFollow(FOLLOW_2);
            ruleIdSelector();

            state._fsp--;

             after(grammarAccess.getSimpleSelectorAccess().getIdIdSelectorParserRuleCall_1_0_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__SimpleSelector__IdAssignment_1_0"


    // $ANTLR start "rule__SimpleSelector__PseudoClassAssignment_1_1"
    // InternalLatteCSS.g:8980:1: rule__SimpleSelector__PseudoClassAssignment_1_1 : ( rulePseudoClassSelector ) ;
    public final void rule__SimpleSelector__PseudoClassAssignment_1_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalLatteCSS.g:8984:1: ( ( rulePseudoClassSelector ) )
            // InternalLatteCSS.g:8985:1: ( rulePseudoClassSelector )
            {
            // InternalLatteCSS.g:8985:1: ( rulePseudoClassSelector )
            // InternalLatteCSS.g:8986:1: rulePseudoClassSelector
            {
             before(grammarAccess.getSimpleSelectorAccess().getPseudoClassPseudoClassSelectorParserRuleCall_1_1_0()); 
            pushFollow(FOLLOW_2);
            rulePseudoClassSelector();

            state._fsp--;

             after(grammarAccess.getSimpleSelectorAccess().getPseudoClassPseudoClassSelectorParserRuleCall_1_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__SimpleSelector__PseudoClassAssignment_1_1"


    // $ANTLR start "rule__SimpleSelector__ClassAssignment_2_0"
    // InternalLatteCSS.g:8995:1: rule__SimpleSelector__ClassAssignment_2_0 : ( ruleClassSelector ) ;
    public final void rule__SimpleSelector__ClassAssignment_2_0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalLatteCSS.g:8999:1: ( ( ruleClassSelector ) )
            // InternalLatteCSS.g:9000:1: ( ruleClassSelector )
            {
            // InternalLatteCSS.g:9000:1: ( ruleClassSelector )
            // InternalLatteCSS.g:9001:1: ruleClassSelector
            {
             before(grammarAccess.getSimpleSelectorAccess().getClassClassSelectorParserRuleCall_2_0_0()); 
            pushFollow(FOLLOW_2);
            ruleClassSelector();

            state._fsp--;

             after(grammarAccess.getSimpleSelectorAccess().getClassClassSelectorParserRuleCall_2_0_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__SimpleSelector__ClassAssignment_2_0"


    // $ANTLR start "rule__SimpleSelector__PseudoClassAssignment_2_1"
    // InternalLatteCSS.g:9010:1: rule__SimpleSelector__PseudoClassAssignment_2_1 : ( rulePseudoClassSelector ) ;
    public final void rule__SimpleSelector__PseudoClassAssignment_2_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalLatteCSS.g:9014:1: ( ( rulePseudoClassSelector ) )
            // InternalLatteCSS.g:9015:1: ( rulePseudoClassSelector )
            {
            // InternalLatteCSS.g:9015:1: ( rulePseudoClassSelector )
            // InternalLatteCSS.g:9016:1: rulePseudoClassSelector
            {
             before(grammarAccess.getSimpleSelectorAccess().getPseudoClassPseudoClassSelectorParserRuleCall_2_1_0()); 
            pushFollow(FOLLOW_2);
            rulePseudoClassSelector();

            state._fsp--;

             after(grammarAccess.getSimpleSelectorAccess().getPseudoClassPseudoClassSelectorParserRuleCall_2_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__SimpleSelector__PseudoClassAssignment_2_1"


    // $ANTLR start "rule__IdSelector__IdAssignment_1"
    // InternalLatteCSS.g:9025:1: rule__IdSelector__IdAssignment_1 : ( RULE_ID ) ;
    public final void rule__IdSelector__IdAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalLatteCSS.g:9029:1: ( ( RULE_ID ) )
            // InternalLatteCSS.g:9030:1: ( RULE_ID )
            {
            // InternalLatteCSS.g:9030:1: ( RULE_ID )
            // InternalLatteCSS.g:9031:1: RULE_ID
            {
             before(grammarAccess.getIdSelectorAccess().getIdIDTerminalRuleCall_1_0()); 
            match(input,RULE_ID,FOLLOW_2); 
             after(grammarAccess.getIdSelectorAccess().getIdIDTerminalRuleCall_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__IdSelector__IdAssignment_1"


    // $ANTLR start "rule__ClassSelector__ClassAssignment_1"
    // InternalLatteCSS.g:9040:1: rule__ClassSelector__ClassAssignment_1 : ( RULE_ID ) ;
    public final void rule__ClassSelector__ClassAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalLatteCSS.g:9044:1: ( ( RULE_ID ) )
            // InternalLatteCSS.g:9045:1: ( RULE_ID )
            {
            // InternalLatteCSS.g:9045:1: ( RULE_ID )
            // InternalLatteCSS.g:9046:1: RULE_ID
            {
             before(grammarAccess.getClassSelectorAccess().getClassIDTerminalRuleCall_1_0()); 
            match(input,RULE_ID,FOLLOW_2); 
             after(grammarAccess.getClassSelectorAccess().getClassIDTerminalRuleCall_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ClassSelector__ClassAssignment_1"


    // $ANTLR start "rule__PseudoClassSelector__ValueAssignment_1"
    // InternalLatteCSS.g:9055:1: rule__PseudoClassSelector__ValueAssignment_1 : ( RULE_ID ) ;
    public final void rule__PseudoClassSelector__ValueAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalLatteCSS.g:9059:1: ( ( RULE_ID ) )
            // InternalLatteCSS.g:9060:1: ( RULE_ID )
            {
            // InternalLatteCSS.g:9060:1: ( RULE_ID )
            // InternalLatteCSS.g:9061:1: RULE_ID
            {
             before(grammarAccess.getPseudoClassSelectorAccess().getValueIDTerminalRuleCall_1_0()); 
            match(input,RULE_ID,FOLLOW_2); 
             after(grammarAccess.getPseudoClassSelectorAccess().getValueIDTerminalRuleCall_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__PseudoClassSelector__ValueAssignment_1"


    // $ANTLR start "rule__FontFamilyProperty__PropertyAssignment_0"
    // InternalLatteCSS.g:9070:1: rule__FontFamilyProperty__PropertyAssignment_0 : ( ( 'font-family' ) ) ;
    public final void rule__FontFamilyProperty__PropertyAssignment_0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalLatteCSS.g:9074:1: ( ( ( 'font-family' ) ) )
            // InternalLatteCSS.g:9075:1: ( ( 'font-family' ) )
            {
            // InternalLatteCSS.g:9075:1: ( ( 'font-family' ) )
            // InternalLatteCSS.g:9076:1: ( 'font-family' )
            {
             before(grammarAccess.getFontFamilyPropertyAccess().getPropertyFontFamilyKeyword_0_0()); 
            // InternalLatteCSS.g:9077:1: ( 'font-family' )
            // InternalLatteCSS.g:9078:1: 'font-family'
            {
             before(grammarAccess.getFontFamilyPropertyAccess().getPropertyFontFamilyKeyword_0_0()); 
            match(input,289,FOLLOW_2); 
             after(grammarAccess.getFontFamilyPropertyAccess().getPropertyFontFamilyKeyword_0_0()); 

            }

             after(grammarAccess.getFontFamilyPropertyAccess().getPropertyFontFamilyKeyword_0_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__FontFamilyProperty__PropertyAssignment_0"


    // $ANTLR start "rule__FontFamilyProperty__ValueAssignment_2"
    // InternalLatteCSS.g:9093:1: rule__FontFamilyProperty__ValueAssignment_2 : ( RULE_STRING ) ;
    public final void rule__FontFamilyProperty__ValueAssignment_2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalLatteCSS.g:9097:1: ( ( RULE_STRING ) )
            // InternalLatteCSS.g:9098:1: ( RULE_STRING )
            {
            // InternalLatteCSS.g:9098:1: ( RULE_STRING )
            // InternalLatteCSS.g:9099:1: RULE_STRING
            {
             before(grammarAccess.getFontFamilyPropertyAccess().getValueSTRINGTerminalRuleCall_2_0()); 
            match(input,RULE_STRING,FOLLOW_2); 
             after(grammarAccess.getFontFamilyPropertyAccess().getValueSTRINGTerminalRuleCall_2_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__FontFamilyProperty__ValueAssignment_2"


    // $ANTLR start "rule__FontStyleProperty__PropertyAssignment_0"
    // InternalLatteCSS.g:9108:1: rule__FontStyleProperty__PropertyAssignment_0 : ( ( 'font-style' ) ) ;
    public final void rule__FontStyleProperty__PropertyAssignment_0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalLatteCSS.g:9112:1: ( ( ( 'font-style' ) ) )
            // InternalLatteCSS.g:9113:1: ( ( 'font-style' ) )
            {
            // InternalLatteCSS.g:9113:1: ( ( 'font-style' ) )
            // InternalLatteCSS.g:9114:1: ( 'font-style' )
            {
             before(grammarAccess.getFontStylePropertyAccess().getPropertyFontStyleKeyword_0_0()); 
            // InternalLatteCSS.g:9115:1: ( 'font-style' )
            // InternalLatteCSS.g:9116:1: 'font-style'
            {
             before(grammarAccess.getFontStylePropertyAccess().getPropertyFontStyleKeyword_0_0()); 
            match(input,290,FOLLOW_2); 
             after(grammarAccess.getFontStylePropertyAccess().getPropertyFontStyleKeyword_0_0()); 

            }

             after(grammarAccess.getFontStylePropertyAccess().getPropertyFontStyleKeyword_0_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__FontStyleProperty__PropertyAssignment_0"


    // $ANTLR start "rule__FontStyleProperty__ValueAssignment_2"
    // InternalLatteCSS.g:9131:1: rule__FontStyleProperty__ValueAssignment_2 : ( ( rule__FontStyleProperty__ValueAlternatives_2_0 ) ) ;
    public final void rule__FontStyleProperty__ValueAssignment_2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalLatteCSS.g:9135:1: ( ( ( rule__FontStyleProperty__ValueAlternatives_2_0 ) ) )
            // InternalLatteCSS.g:9136:1: ( ( rule__FontStyleProperty__ValueAlternatives_2_0 ) )
            {
            // InternalLatteCSS.g:9136:1: ( ( rule__FontStyleProperty__ValueAlternatives_2_0 ) )
            // InternalLatteCSS.g:9137:1: ( rule__FontStyleProperty__ValueAlternatives_2_0 )
            {
             before(grammarAccess.getFontStylePropertyAccess().getValueAlternatives_2_0()); 
            // InternalLatteCSS.g:9138:1: ( rule__FontStyleProperty__ValueAlternatives_2_0 )
            // InternalLatteCSS.g:9138:2: rule__FontStyleProperty__ValueAlternatives_2_0
            {
            pushFollow(FOLLOW_2);
            rule__FontStyleProperty__ValueAlternatives_2_0();

            state._fsp--;


            }

             after(grammarAccess.getFontStylePropertyAccess().getValueAlternatives_2_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__FontStyleProperty__ValueAssignment_2"


    // $ANTLR start "rule__ViewSizeProperty__PropertyAssignment_0"
    // InternalLatteCSS.g:9147:1: rule__ViewSizeProperty__PropertyAssignment_0 : ( ( rule__ViewSizeProperty__PropertyAlternatives_0_0 ) ) ;
    public final void rule__ViewSizeProperty__PropertyAssignment_0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalLatteCSS.g:9151:1: ( ( ( rule__ViewSizeProperty__PropertyAlternatives_0_0 ) ) )
            // InternalLatteCSS.g:9152:1: ( ( rule__ViewSizeProperty__PropertyAlternatives_0_0 ) )
            {
            // InternalLatteCSS.g:9152:1: ( ( rule__ViewSizeProperty__PropertyAlternatives_0_0 ) )
            // InternalLatteCSS.g:9153:1: ( rule__ViewSizeProperty__PropertyAlternatives_0_0 )
            {
             before(grammarAccess.getViewSizePropertyAccess().getPropertyAlternatives_0_0()); 
            // InternalLatteCSS.g:9154:1: ( rule__ViewSizeProperty__PropertyAlternatives_0_0 )
            // InternalLatteCSS.g:9154:2: rule__ViewSizeProperty__PropertyAlternatives_0_0
            {
            pushFollow(FOLLOW_2);
            rule__ViewSizeProperty__PropertyAlternatives_0_0();

            state._fsp--;


            }

             after(grammarAccess.getViewSizePropertyAccess().getPropertyAlternatives_0_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ViewSizeProperty__PropertyAssignment_0"


    // $ANTLR start "rule__ViewSizeProperty__ValueAssignment_2"
    // InternalLatteCSS.g:9163:1: rule__ViewSizeProperty__ValueAssignment_2 : ( ruleViewSizeValue ) ;
    public final void rule__ViewSizeProperty__ValueAssignment_2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalLatteCSS.g:9167:1: ( ( ruleViewSizeValue ) )
            // InternalLatteCSS.g:9168:1: ( ruleViewSizeValue )
            {
            // InternalLatteCSS.g:9168:1: ( ruleViewSizeValue )
            // InternalLatteCSS.g:9169:1: ruleViewSizeValue
            {
             before(grammarAccess.getViewSizePropertyAccess().getValueViewSizeValueParserRuleCall_2_0()); 
            pushFollow(FOLLOW_2);
            ruleViewSizeValue();

            state._fsp--;

             after(grammarAccess.getViewSizePropertyAccess().getValueViewSizeValueParserRuleCall_2_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ViewSizeProperty__ValueAssignment_2"


    // $ANTLR start "rule__ShorthandSizeProperty__PropertyAssignment_0"
    // InternalLatteCSS.g:9178:1: rule__ShorthandSizeProperty__PropertyAssignment_0 : ( ( rule__ShorthandSizeProperty__PropertyAlternatives_0_0 ) ) ;
    public final void rule__ShorthandSizeProperty__PropertyAssignment_0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalLatteCSS.g:9182:1: ( ( ( rule__ShorthandSizeProperty__PropertyAlternatives_0_0 ) ) )
            // InternalLatteCSS.g:9183:1: ( ( rule__ShorthandSizeProperty__PropertyAlternatives_0_0 ) )
            {
            // InternalLatteCSS.g:9183:1: ( ( rule__ShorthandSizeProperty__PropertyAlternatives_0_0 ) )
            // InternalLatteCSS.g:9184:1: ( rule__ShorthandSizeProperty__PropertyAlternatives_0_0 )
            {
             before(grammarAccess.getShorthandSizePropertyAccess().getPropertyAlternatives_0_0()); 
            // InternalLatteCSS.g:9185:1: ( rule__ShorthandSizeProperty__PropertyAlternatives_0_0 )
            // InternalLatteCSS.g:9185:2: rule__ShorthandSizeProperty__PropertyAlternatives_0_0
            {
            pushFollow(FOLLOW_2);
            rule__ShorthandSizeProperty__PropertyAlternatives_0_0();

            state._fsp--;


            }

             after(grammarAccess.getShorthandSizePropertyAccess().getPropertyAlternatives_0_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ShorthandSizeProperty__PropertyAssignment_0"


    // $ANTLR start "rule__ShorthandSizeProperty__ValuesAssignment_2"
    // InternalLatteCSS.g:9194:1: rule__ShorthandSizeProperty__ValuesAssignment_2 : ( ruleSizeValue ) ;
    public final void rule__ShorthandSizeProperty__ValuesAssignment_2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalLatteCSS.g:9198:1: ( ( ruleSizeValue ) )
            // InternalLatteCSS.g:9199:1: ( ruleSizeValue )
            {
            // InternalLatteCSS.g:9199:1: ( ruleSizeValue )
            // InternalLatteCSS.g:9200:1: ruleSizeValue
            {
             before(grammarAccess.getShorthandSizePropertyAccess().getValuesSizeValueParserRuleCall_2_0()); 
            pushFollow(FOLLOW_2);
            ruleSizeValue();

            state._fsp--;

             after(grammarAccess.getShorthandSizePropertyAccess().getValuesSizeValueParserRuleCall_2_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ShorthandSizeProperty__ValuesAssignment_2"


    // $ANTLR start "rule__BorderRadiusProperty__PropertyAssignment_0"
    // InternalLatteCSS.g:9209:1: rule__BorderRadiusProperty__PropertyAssignment_0 : ( ( rule__BorderRadiusProperty__PropertyAlternatives_0_0 ) ) ;
    public final void rule__BorderRadiusProperty__PropertyAssignment_0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalLatteCSS.g:9213:1: ( ( ( rule__BorderRadiusProperty__PropertyAlternatives_0_0 ) ) )
            // InternalLatteCSS.g:9214:1: ( ( rule__BorderRadiusProperty__PropertyAlternatives_0_0 ) )
            {
            // InternalLatteCSS.g:9214:1: ( ( rule__BorderRadiusProperty__PropertyAlternatives_0_0 ) )
            // InternalLatteCSS.g:9215:1: ( rule__BorderRadiusProperty__PropertyAlternatives_0_0 )
            {
             before(grammarAccess.getBorderRadiusPropertyAccess().getPropertyAlternatives_0_0()); 
            // InternalLatteCSS.g:9216:1: ( rule__BorderRadiusProperty__PropertyAlternatives_0_0 )
            // InternalLatteCSS.g:9216:2: rule__BorderRadiusProperty__PropertyAlternatives_0_0
            {
            pushFollow(FOLLOW_2);
            rule__BorderRadiusProperty__PropertyAlternatives_0_0();

            state._fsp--;


            }

             after(grammarAccess.getBorderRadiusPropertyAccess().getPropertyAlternatives_0_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__BorderRadiusProperty__PropertyAssignment_0"


    // $ANTLR start "rule__BorderRadiusProperty__ValuesAssignment_2"
    // InternalLatteCSS.g:9225:1: rule__BorderRadiusProperty__ValuesAssignment_2 : ( ruleSizeValue ) ;
    public final void rule__BorderRadiusProperty__ValuesAssignment_2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalLatteCSS.g:9229:1: ( ( ruleSizeValue ) )
            // InternalLatteCSS.g:9230:1: ( ruleSizeValue )
            {
            // InternalLatteCSS.g:9230:1: ( ruleSizeValue )
            // InternalLatteCSS.g:9231:1: ruleSizeValue
            {
             before(grammarAccess.getBorderRadiusPropertyAccess().getValuesSizeValueParserRuleCall_2_0()); 
            pushFollow(FOLLOW_2);
            ruleSizeValue();

            state._fsp--;

             after(grammarAccess.getBorderRadiusPropertyAccess().getValuesSizeValueParserRuleCall_2_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__BorderRadiusProperty__ValuesAssignment_2"


    // $ANTLR start "rule__SizeProperty__PropertyAssignment_0"
    // InternalLatteCSS.g:9240:1: rule__SizeProperty__PropertyAssignment_0 : ( ( rule__SizeProperty__PropertyAlternatives_0_0 ) ) ;
    public final void rule__SizeProperty__PropertyAssignment_0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalLatteCSS.g:9244:1: ( ( ( rule__SizeProperty__PropertyAlternatives_0_0 ) ) )
            // InternalLatteCSS.g:9245:1: ( ( rule__SizeProperty__PropertyAlternatives_0_0 ) )
            {
            // InternalLatteCSS.g:9245:1: ( ( rule__SizeProperty__PropertyAlternatives_0_0 ) )
            // InternalLatteCSS.g:9246:1: ( rule__SizeProperty__PropertyAlternatives_0_0 )
            {
             before(grammarAccess.getSizePropertyAccess().getPropertyAlternatives_0_0()); 
            // InternalLatteCSS.g:9247:1: ( rule__SizeProperty__PropertyAlternatives_0_0 )
            // InternalLatteCSS.g:9247:2: rule__SizeProperty__PropertyAlternatives_0_0
            {
            pushFollow(FOLLOW_2);
            rule__SizeProperty__PropertyAlternatives_0_0();

            state._fsp--;


            }

             after(grammarAccess.getSizePropertyAccess().getPropertyAlternatives_0_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__SizeProperty__PropertyAssignment_0"


    // $ANTLR start "rule__SizeProperty__ValueAssignment_2"
    // InternalLatteCSS.g:9256:1: rule__SizeProperty__ValueAssignment_2 : ( ruleSizeValue ) ;
    public final void rule__SizeProperty__ValueAssignment_2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalLatteCSS.g:9260:1: ( ( ruleSizeValue ) )
            // InternalLatteCSS.g:9261:1: ( ruleSizeValue )
            {
            // InternalLatteCSS.g:9261:1: ( ruleSizeValue )
            // InternalLatteCSS.g:9262:1: ruleSizeValue
            {
             before(grammarAccess.getSizePropertyAccess().getValueSizeValueParserRuleCall_2_0()); 
            pushFollow(FOLLOW_2);
            ruleSizeValue();

            state._fsp--;

             after(grammarAccess.getSizePropertyAccess().getValueSizeValueParserRuleCall_2_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__SizeProperty__ValueAssignment_2"


    // $ANTLR start "rule__PaintProperty__PropertyAssignment_0"
    // InternalLatteCSS.g:9271:1: rule__PaintProperty__PropertyAssignment_0 : ( ( 'background' ) ) ;
    public final void rule__PaintProperty__PropertyAssignment_0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalLatteCSS.g:9275:1: ( ( ( 'background' ) ) )
            // InternalLatteCSS.g:9276:1: ( ( 'background' ) )
            {
            // InternalLatteCSS.g:9276:1: ( ( 'background' ) )
            // InternalLatteCSS.g:9277:1: ( 'background' )
            {
             before(grammarAccess.getPaintPropertyAccess().getPropertyBackgroundKeyword_0_0()); 
            // InternalLatteCSS.g:9278:1: ( 'background' )
            // InternalLatteCSS.g:9279:1: 'background'
            {
             before(grammarAccess.getPaintPropertyAccess().getPropertyBackgroundKeyword_0_0()); 
            match(input,291,FOLLOW_2); 
             after(grammarAccess.getPaintPropertyAccess().getPropertyBackgroundKeyword_0_0()); 

            }

             after(grammarAccess.getPaintPropertyAccess().getPropertyBackgroundKeyword_0_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__PaintProperty__PropertyAssignment_0"


    // $ANTLR start "rule__PaintProperty__ValueAssignment_2"
    // InternalLatteCSS.g:9294:1: rule__PaintProperty__ValueAssignment_2 : ( rulePaintValue ) ;
    public final void rule__PaintProperty__ValueAssignment_2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalLatteCSS.g:9298:1: ( ( rulePaintValue ) )
            // InternalLatteCSS.g:9299:1: ( rulePaintValue )
            {
            // InternalLatteCSS.g:9299:1: ( rulePaintValue )
            // InternalLatteCSS.g:9300:1: rulePaintValue
            {
             before(grammarAccess.getPaintPropertyAccess().getValuePaintValueParserRuleCall_2_0()); 
            pushFollow(FOLLOW_2);
            rulePaintValue();

            state._fsp--;

             after(grammarAccess.getPaintPropertyAccess().getValuePaintValueParserRuleCall_2_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__PaintProperty__ValueAssignment_2"


    // $ANTLR start "rule__TransitionProperty__PropertyAssignment_0"
    // InternalLatteCSS.g:9309:1: rule__TransitionProperty__PropertyAssignment_0 : ( ( 'transition' ) ) ;
    public final void rule__TransitionProperty__PropertyAssignment_0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalLatteCSS.g:9313:1: ( ( ( 'transition' ) ) )
            // InternalLatteCSS.g:9314:1: ( ( 'transition' ) )
            {
            // InternalLatteCSS.g:9314:1: ( ( 'transition' ) )
            // InternalLatteCSS.g:9315:1: ( 'transition' )
            {
             before(grammarAccess.getTransitionPropertyAccess().getPropertyTransitionKeyword_0_0()); 
            // InternalLatteCSS.g:9316:1: ( 'transition' )
            // InternalLatteCSS.g:9317:1: 'transition'
            {
             before(grammarAccess.getTransitionPropertyAccess().getPropertyTransitionKeyword_0_0()); 
            match(input,292,FOLLOW_2); 
             after(grammarAccess.getTransitionPropertyAccess().getPropertyTransitionKeyword_0_0()); 

            }

             after(grammarAccess.getTransitionPropertyAccess().getPropertyTransitionKeyword_0_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__TransitionProperty__PropertyAssignment_0"


    // $ANTLR start "rule__TransitionProperty__TransitionsAssignment_2"
    // InternalLatteCSS.g:9332:1: rule__TransitionProperty__TransitionsAssignment_2 : ( ruleTransitionValue ) ;
    public final void rule__TransitionProperty__TransitionsAssignment_2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalLatteCSS.g:9336:1: ( ( ruleTransitionValue ) )
            // InternalLatteCSS.g:9337:1: ( ruleTransitionValue )
            {
            // InternalLatteCSS.g:9337:1: ( ruleTransitionValue )
            // InternalLatteCSS.g:9338:1: ruleTransitionValue
            {
             before(grammarAccess.getTransitionPropertyAccess().getTransitionsTransitionValueParserRuleCall_2_0()); 
            pushFollow(FOLLOW_2);
            ruleTransitionValue();

            state._fsp--;

             after(grammarAccess.getTransitionPropertyAccess().getTransitionsTransitionValueParserRuleCall_2_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__TransitionProperty__TransitionsAssignment_2"


    // $ANTLR start "rule__TransitionProperty__TransitionsAssignment_3_1"
    // InternalLatteCSS.g:9347:1: rule__TransitionProperty__TransitionsAssignment_3_1 : ( ruleTransitionValue ) ;
    public final void rule__TransitionProperty__TransitionsAssignment_3_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalLatteCSS.g:9351:1: ( ( ruleTransitionValue ) )
            // InternalLatteCSS.g:9352:1: ( ruleTransitionValue )
            {
            // InternalLatteCSS.g:9352:1: ( ruleTransitionValue )
            // InternalLatteCSS.g:9353:1: ruleTransitionValue
            {
             before(grammarAccess.getTransitionPropertyAccess().getTransitionsTransitionValueParserRuleCall_3_1_0()); 
            pushFollow(FOLLOW_2);
            ruleTransitionValue();

            state._fsp--;

             after(grammarAccess.getTransitionPropertyAccess().getTransitionsTransitionValueParserRuleCall_3_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__TransitionProperty__TransitionsAssignment_3_1"


    // $ANTLR start "rule__TransitionValue__PropertyNameAssignment_0"
    // InternalLatteCSS.g:9362:1: rule__TransitionValue__PropertyNameAssignment_0 : ( rulePropertyNameValue ) ;
    public final void rule__TransitionValue__PropertyNameAssignment_0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalLatteCSS.g:9366:1: ( ( rulePropertyNameValue ) )
            // InternalLatteCSS.g:9367:1: ( rulePropertyNameValue )
            {
            // InternalLatteCSS.g:9367:1: ( rulePropertyNameValue )
            // InternalLatteCSS.g:9368:1: rulePropertyNameValue
            {
             before(grammarAccess.getTransitionValueAccess().getPropertyNamePropertyNameValueParserRuleCall_0_0()); 
            pushFollow(FOLLOW_2);
            rulePropertyNameValue();

            state._fsp--;

             after(grammarAccess.getTransitionValueAccess().getPropertyNamePropertyNameValueParserRuleCall_0_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__TransitionValue__PropertyNameAssignment_0"


    // $ANTLR start "rule__TransitionValue__DurationAssignment_1"
    // InternalLatteCSS.g:9377:1: rule__TransitionValue__DurationAssignment_1 : ( ruleTimeValue ) ;
    public final void rule__TransitionValue__DurationAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalLatteCSS.g:9381:1: ( ( ruleTimeValue ) )
            // InternalLatteCSS.g:9382:1: ( ruleTimeValue )
            {
            // InternalLatteCSS.g:9382:1: ( ruleTimeValue )
            // InternalLatteCSS.g:9383:1: ruleTimeValue
            {
             before(grammarAccess.getTransitionValueAccess().getDurationTimeValueParserRuleCall_1_0()); 
            pushFollow(FOLLOW_2);
            ruleTimeValue();

            state._fsp--;

             after(grammarAccess.getTransitionValueAccess().getDurationTimeValueParserRuleCall_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__TransitionValue__DurationAssignment_1"


    // $ANTLR start "rule__TransitionValue__TimingFunctionAssignment_2"
    // InternalLatteCSS.g:9392:1: rule__TransitionValue__TimingFunctionAssignment_2 : ( ruleTimingFunction ) ;
    public final void rule__TransitionValue__TimingFunctionAssignment_2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalLatteCSS.g:9396:1: ( ( ruleTimingFunction ) )
            // InternalLatteCSS.g:9397:1: ( ruleTimingFunction )
            {
            // InternalLatteCSS.g:9397:1: ( ruleTimingFunction )
            // InternalLatteCSS.g:9398:1: ruleTimingFunction
            {
             before(grammarAccess.getTransitionValueAccess().getTimingFunctionTimingFunctionParserRuleCall_2_0()); 
            pushFollow(FOLLOW_2);
            ruleTimingFunction();

            state._fsp--;

             after(grammarAccess.getTransitionValueAccess().getTimingFunctionTimingFunctionParserRuleCall_2_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__TransitionValue__TimingFunctionAssignment_2"


    // $ANTLR start "rule__TransitionValue__DelayAssignment_3"
    // InternalLatteCSS.g:9407:1: rule__TransitionValue__DelayAssignment_3 : ( ruleTimeValue ) ;
    public final void rule__TransitionValue__DelayAssignment_3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalLatteCSS.g:9411:1: ( ( ruleTimeValue ) )
            // InternalLatteCSS.g:9412:1: ( ruleTimeValue )
            {
            // InternalLatteCSS.g:9412:1: ( ruleTimeValue )
            // InternalLatteCSS.g:9413:1: ruleTimeValue
            {
             before(grammarAccess.getTransitionValueAccess().getDelayTimeValueParserRuleCall_3_0()); 
            pushFollow(FOLLOW_2);
            ruleTimeValue();

            state._fsp--;

             after(grammarAccess.getTransitionValueAccess().getDelayTimeValueParserRuleCall_3_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__TransitionValue__DelayAssignment_3"


    // $ANTLR start "rule__DrawableProperty__PropertyAssignment_0"
    // InternalLatteCSS.g:9422:1: rule__DrawableProperty__PropertyAssignment_0 : ( ( 'background-drawable' ) ) ;
    public final void rule__DrawableProperty__PropertyAssignment_0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalLatteCSS.g:9426:1: ( ( ( 'background-drawable' ) ) )
            // InternalLatteCSS.g:9427:1: ( ( 'background-drawable' ) )
            {
            // InternalLatteCSS.g:9427:1: ( ( 'background-drawable' ) )
            // InternalLatteCSS.g:9428:1: ( 'background-drawable' )
            {
             before(grammarAccess.getDrawablePropertyAccess().getPropertyBackgroundDrawableKeyword_0_0()); 
            // InternalLatteCSS.g:9429:1: ( 'background-drawable' )
            // InternalLatteCSS.g:9430:1: 'background-drawable'
            {
             before(grammarAccess.getDrawablePropertyAccess().getPropertyBackgroundDrawableKeyword_0_0()); 
            match(input,293,FOLLOW_2); 
             after(grammarAccess.getDrawablePropertyAccess().getPropertyBackgroundDrawableKeyword_0_0()); 

            }

             after(grammarAccess.getDrawablePropertyAccess().getPropertyBackgroundDrawableKeyword_0_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__DrawableProperty__PropertyAssignment_0"


    // $ANTLR start "rule__DrawableProperty__ValueAssignment_2"
    // InternalLatteCSS.g:9445:1: rule__DrawableProperty__ValueAssignment_2 : ( RULE_STRING ) ;
    public final void rule__DrawableProperty__ValueAssignment_2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalLatteCSS.g:9449:1: ( ( RULE_STRING ) )
            // InternalLatteCSS.g:9450:1: ( RULE_STRING )
            {
            // InternalLatteCSS.g:9450:1: ( RULE_STRING )
            // InternalLatteCSS.g:9451:1: RULE_STRING
            {
             before(grammarAccess.getDrawablePropertyAccess().getValueSTRINGTerminalRuleCall_2_0()); 
            match(input,RULE_STRING,FOLLOW_2); 
             after(grammarAccess.getDrawablePropertyAccess().getValueSTRINGTerminalRuleCall_2_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__DrawableProperty__ValueAssignment_2"


    // $ANTLR start "rule__BackgroundRepeatProperty__PropertyAssignment_0"
    // InternalLatteCSS.g:9460:1: rule__BackgroundRepeatProperty__PropertyAssignment_0 : ( ( 'background-repeat' ) ) ;
    public final void rule__BackgroundRepeatProperty__PropertyAssignment_0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalLatteCSS.g:9464:1: ( ( ( 'background-repeat' ) ) )
            // InternalLatteCSS.g:9465:1: ( ( 'background-repeat' ) )
            {
            // InternalLatteCSS.g:9465:1: ( ( 'background-repeat' ) )
            // InternalLatteCSS.g:9466:1: ( 'background-repeat' )
            {
             before(grammarAccess.getBackgroundRepeatPropertyAccess().getPropertyBackgroundRepeatKeyword_0_0()); 
            // InternalLatteCSS.g:9467:1: ( 'background-repeat' )
            // InternalLatteCSS.g:9468:1: 'background-repeat'
            {
             before(grammarAccess.getBackgroundRepeatPropertyAccess().getPropertyBackgroundRepeatKeyword_0_0()); 
            match(input,294,FOLLOW_2); 
             after(grammarAccess.getBackgroundRepeatPropertyAccess().getPropertyBackgroundRepeatKeyword_0_0()); 

            }

             after(grammarAccess.getBackgroundRepeatPropertyAccess().getPropertyBackgroundRepeatKeyword_0_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__BackgroundRepeatProperty__PropertyAssignment_0"


    // $ANTLR start "rule__BackgroundRepeatProperty__ValuesAssignment_2"
    // InternalLatteCSS.g:9483:1: rule__BackgroundRepeatProperty__ValuesAssignment_2 : ( ruleRepeatValue ) ;
    public final void rule__BackgroundRepeatProperty__ValuesAssignment_2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalLatteCSS.g:9487:1: ( ( ruleRepeatValue ) )
            // InternalLatteCSS.g:9488:1: ( ruleRepeatValue )
            {
            // InternalLatteCSS.g:9488:1: ( ruleRepeatValue )
            // InternalLatteCSS.g:9489:1: ruleRepeatValue
            {
             before(grammarAccess.getBackgroundRepeatPropertyAccess().getValuesRepeatValueParserRuleCall_2_0()); 
            pushFollow(FOLLOW_2);
            ruleRepeatValue();

            state._fsp--;

             after(grammarAccess.getBackgroundRepeatPropertyAccess().getValuesRepeatValueParserRuleCall_2_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__BackgroundRepeatProperty__ValuesAssignment_2"


    // $ANTLR start "rule__BackgroundRepeatProperty__ValuesAssignment_3"
    // InternalLatteCSS.g:9498:1: rule__BackgroundRepeatProperty__ValuesAssignment_3 : ( ruleRepeatValue ) ;
    public final void rule__BackgroundRepeatProperty__ValuesAssignment_3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalLatteCSS.g:9502:1: ( ( ruleRepeatValue ) )
            // InternalLatteCSS.g:9503:1: ( ruleRepeatValue )
            {
            // InternalLatteCSS.g:9503:1: ( ruleRepeatValue )
            // InternalLatteCSS.g:9504:1: ruleRepeatValue
            {
             before(grammarAccess.getBackgroundRepeatPropertyAccess().getValuesRepeatValueParserRuleCall_3_0()); 
            pushFollow(FOLLOW_2);
            ruleRepeatValue();

            state._fsp--;

             after(grammarAccess.getBackgroundRepeatPropertyAccess().getValuesRepeatValueParserRuleCall_3_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__BackgroundRepeatProperty__ValuesAssignment_3"


    // $ANTLR start "rule__BorderProperty__PropertyAssignment_0"
    // InternalLatteCSS.g:9513:1: rule__BorderProperty__PropertyAssignment_0 : ( ( rule__BorderProperty__PropertyAlternatives_0_0 ) ) ;
    public final void rule__BorderProperty__PropertyAssignment_0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalLatteCSS.g:9517:1: ( ( ( rule__BorderProperty__PropertyAlternatives_0_0 ) ) )
            // InternalLatteCSS.g:9518:1: ( ( rule__BorderProperty__PropertyAlternatives_0_0 ) )
            {
            // InternalLatteCSS.g:9518:1: ( ( rule__BorderProperty__PropertyAlternatives_0_0 ) )
            // InternalLatteCSS.g:9519:1: ( rule__BorderProperty__PropertyAlternatives_0_0 )
            {
             before(grammarAccess.getBorderPropertyAccess().getPropertyAlternatives_0_0()); 
            // InternalLatteCSS.g:9520:1: ( rule__BorderProperty__PropertyAlternatives_0_0 )
            // InternalLatteCSS.g:9520:2: rule__BorderProperty__PropertyAlternatives_0_0
            {
            pushFollow(FOLLOW_2);
            rule__BorderProperty__PropertyAlternatives_0_0();

            state._fsp--;


            }

             after(grammarAccess.getBorderPropertyAccess().getPropertyAlternatives_0_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__BorderProperty__PropertyAssignment_0"


    // $ANTLR start "rule__BorderProperty__WidthAssignment_2"
    // InternalLatteCSS.g:9529:1: rule__BorderProperty__WidthAssignment_2 : ( ruleSizeValue ) ;
    public final void rule__BorderProperty__WidthAssignment_2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalLatteCSS.g:9533:1: ( ( ruleSizeValue ) )
            // InternalLatteCSS.g:9534:1: ( ruleSizeValue )
            {
            // InternalLatteCSS.g:9534:1: ( ruleSizeValue )
            // InternalLatteCSS.g:9535:1: ruleSizeValue
            {
             before(grammarAccess.getBorderPropertyAccess().getWidthSizeValueParserRuleCall_2_0()); 
            pushFollow(FOLLOW_2);
            ruleSizeValue();

            state._fsp--;

             after(grammarAccess.getBorderPropertyAccess().getWidthSizeValueParserRuleCall_2_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__BorderProperty__WidthAssignment_2"


    // $ANTLR start "rule__BorderProperty__StyleAssignment_3"
    // InternalLatteCSS.g:9544:1: rule__BorderProperty__StyleAssignment_3 : ( ( rule__BorderProperty__StyleAlternatives_3_0 ) ) ;
    public final void rule__BorderProperty__StyleAssignment_3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalLatteCSS.g:9548:1: ( ( ( rule__BorderProperty__StyleAlternatives_3_0 ) ) )
            // InternalLatteCSS.g:9549:1: ( ( rule__BorderProperty__StyleAlternatives_3_0 ) )
            {
            // InternalLatteCSS.g:9549:1: ( ( rule__BorderProperty__StyleAlternatives_3_0 ) )
            // InternalLatteCSS.g:9550:1: ( rule__BorderProperty__StyleAlternatives_3_0 )
            {
             before(grammarAccess.getBorderPropertyAccess().getStyleAlternatives_3_0()); 
            // InternalLatteCSS.g:9551:1: ( rule__BorderProperty__StyleAlternatives_3_0 )
            // InternalLatteCSS.g:9551:2: rule__BorderProperty__StyleAlternatives_3_0
            {
            pushFollow(FOLLOW_2);
            rule__BorderProperty__StyleAlternatives_3_0();

            state._fsp--;


            }

             after(grammarAccess.getBorderPropertyAccess().getStyleAlternatives_3_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__BorderProperty__StyleAssignment_3"


    // $ANTLR start "rule__BorderProperty__ColorAssignment_4"
    // InternalLatteCSS.g:9560:1: rule__BorderProperty__ColorAssignment_4 : ( ruleColorValue ) ;
    public final void rule__BorderProperty__ColorAssignment_4() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalLatteCSS.g:9564:1: ( ( ruleColorValue ) )
            // InternalLatteCSS.g:9565:1: ( ruleColorValue )
            {
            // InternalLatteCSS.g:9565:1: ( ruleColorValue )
            // InternalLatteCSS.g:9566:1: ruleColorValue
            {
             before(grammarAccess.getBorderPropertyAccess().getColorColorValueParserRuleCall_4_0()); 
            pushFollow(FOLLOW_2);
            ruleColorValue();

            state._fsp--;

             after(grammarAccess.getBorderPropertyAccess().getColorColorValueParserRuleCall_4_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__BorderProperty__ColorAssignment_4"


    // $ANTLR start "rule__BackgroundFilterProperty__PropertyAssignment_0"
    // InternalLatteCSS.g:9575:1: rule__BackgroundFilterProperty__PropertyAssignment_0 : ( ( 'background-filter' ) ) ;
    public final void rule__BackgroundFilterProperty__PropertyAssignment_0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalLatteCSS.g:9579:1: ( ( ( 'background-filter' ) ) )
            // InternalLatteCSS.g:9580:1: ( ( 'background-filter' ) )
            {
            // InternalLatteCSS.g:9580:1: ( ( 'background-filter' ) )
            // InternalLatteCSS.g:9581:1: ( 'background-filter' )
            {
             before(grammarAccess.getBackgroundFilterPropertyAccess().getPropertyBackgroundFilterKeyword_0_0()); 
            // InternalLatteCSS.g:9582:1: ( 'background-filter' )
            // InternalLatteCSS.g:9583:1: 'background-filter'
            {
             before(grammarAccess.getBackgroundFilterPropertyAccess().getPropertyBackgroundFilterKeyword_0_0()); 
            match(input,295,FOLLOW_2); 
             after(grammarAccess.getBackgroundFilterPropertyAccess().getPropertyBackgroundFilterKeyword_0_0()); 

            }

             after(grammarAccess.getBackgroundFilterPropertyAccess().getPropertyBackgroundFilterKeyword_0_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__BackgroundFilterProperty__PropertyAssignment_0"


    // $ANTLR start "rule__BackgroundFilterProperty__ColorAssignment_2"
    // InternalLatteCSS.g:9598:1: rule__BackgroundFilterProperty__ColorAssignment_2 : ( ruleColorValue ) ;
    public final void rule__BackgroundFilterProperty__ColorAssignment_2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalLatteCSS.g:9602:1: ( ( ruleColorValue ) )
            // InternalLatteCSS.g:9603:1: ( ruleColorValue )
            {
            // InternalLatteCSS.g:9603:1: ( ruleColorValue )
            // InternalLatteCSS.g:9604:1: ruleColorValue
            {
             before(grammarAccess.getBackgroundFilterPropertyAccess().getColorColorValueParserRuleCall_2_0()); 
            pushFollow(FOLLOW_2);
            ruleColorValue();

            state._fsp--;

             after(grammarAccess.getBackgroundFilterPropertyAccess().getColorColorValueParserRuleCall_2_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__BackgroundFilterProperty__ColorAssignment_2"


    // $ANTLR start "rule__BackgroundFilterProperty__FilterAssignment_3"
    // InternalLatteCSS.g:9613:1: rule__BackgroundFilterProperty__FilterAssignment_3 : ( ruleFilterValue ) ;
    public final void rule__BackgroundFilterProperty__FilterAssignment_3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalLatteCSS.g:9617:1: ( ( ruleFilterValue ) )
            // InternalLatteCSS.g:9618:1: ( ruleFilterValue )
            {
            // InternalLatteCSS.g:9618:1: ( ruleFilterValue )
            // InternalLatteCSS.g:9619:1: ruleFilterValue
            {
             before(grammarAccess.getBackgroundFilterPropertyAccess().getFilterFilterValueParserRuleCall_3_0()); 
            pushFollow(FOLLOW_2);
            ruleFilterValue();

            state._fsp--;

             after(grammarAccess.getBackgroundFilterPropertyAccess().getFilterFilterValueParserRuleCall_3_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__BackgroundFilterProperty__FilterAssignment_3"


    // $ANTLR start "rule__BackgroundGravityProperty__PropertyAssignment_0"
    // InternalLatteCSS.g:9628:1: rule__BackgroundGravityProperty__PropertyAssignment_0 : ( ( 'background-gravity' ) ) ;
    public final void rule__BackgroundGravityProperty__PropertyAssignment_0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalLatteCSS.g:9632:1: ( ( ( 'background-gravity' ) ) )
            // InternalLatteCSS.g:9633:1: ( ( 'background-gravity' ) )
            {
            // InternalLatteCSS.g:9633:1: ( ( 'background-gravity' ) )
            // InternalLatteCSS.g:9634:1: ( 'background-gravity' )
            {
             before(grammarAccess.getBackgroundGravityPropertyAccess().getPropertyBackgroundGravityKeyword_0_0()); 
            // InternalLatteCSS.g:9635:1: ( 'background-gravity' )
            // InternalLatteCSS.g:9636:1: 'background-gravity'
            {
             before(grammarAccess.getBackgroundGravityPropertyAccess().getPropertyBackgroundGravityKeyword_0_0()); 
            match(input,296,FOLLOW_2); 
             after(grammarAccess.getBackgroundGravityPropertyAccess().getPropertyBackgroundGravityKeyword_0_0()); 

            }

             after(grammarAccess.getBackgroundGravityPropertyAccess().getPropertyBackgroundGravityKeyword_0_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__BackgroundGravityProperty__PropertyAssignment_0"


    // $ANTLR start "rule__BackgroundGravityProperty__ValuesAssignment_2"
    // InternalLatteCSS.g:9651:1: rule__BackgroundGravityProperty__ValuesAssignment_2 : ( ruleGravityValue ) ;
    public final void rule__BackgroundGravityProperty__ValuesAssignment_2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalLatteCSS.g:9655:1: ( ( ruleGravityValue ) )
            // InternalLatteCSS.g:9656:1: ( ruleGravityValue )
            {
            // InternalLatteCSS.g:9656:1: ( ruleGravityValue )
            // InternalLatteCSS.g:9657:1: ruleGravityValue
            {
             before(grammarAccess.getBackgroundGravityPropertyAccess().getValuesGravityValueParserRuleCall_2_0()); 
            pushFollow(FOLLOW_2);
            ruleGravityValue();

            state._fsp--;

             after(grammarAccess.getBackgroundGravityPropertyAccess().getValuesGravityValueParserRuleCall_2_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__BackgroundGravityProperty__ValuesAssignment_2"


    // $ANTLR start "rule__BackgroundGravityProperty__ValuesAssignment_3_1"
    // InternalLatteCSS.g:9666:1: rule__BackgroundGravityProperty__ValuesAssignment_3_1 : ( ruleGravityValue ) ;
    public final void rule__BackgroundGravityProperty__ValuesAssignment_3_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalLatteCSS.g:9670:1: ( ( ruleGravityValue ) )
            // InternalLatteCSS.g:9671:1: ( ruleGravityValue )
            {
            // InternalLatteCSS.g:9671:1: ( ruleGravityValue )
            // InternalLatteCSS.g:9672:1: ruleGravityValue
            {
             before(grammarAccess.getBackgroundGravityPropertyAccess().getValuesGravityValueParserRuleCall_3_1_0()); 
            pushFollow(FOLLOW_2);
            ruleGravityValue();

            state._fsp--;

             after(grammarAccess.getBackgroundGravityPropertyAccess().getValuesGravityValueParserRuleCall_3_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__BackgroundGravityProperty__ValuesAssignment_3_1"


    // $ANTLR start "rule__BackgroundFilterTypeProperty__PropertyAssignment_0"
    // InternalLatteCSS.g:9681:1: rule__BackgroundFilterTypeProperty__PropertyAssignment_0 : ( ( 'background-filter-type' ) ) ;
    public final void rule__BackgroundFilterTypeProperty__PropertyAssignment_0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalLatteCSS.g:9685:1: ( ( ( 'background-filter-type' ) ) )
            // InternalLatteCSS.g:9686:1: ( ( 'background-filter-type' ) )
            {
            // InternalLatteCSS.g:9686:1: ( ( 'background-filter-type' ) )
            // InternalLatteCSS.g:9687:1: ( 'background-filter-type' )
            {
             before(grammarAccess.getBackgroundFilterTypePropertyAccess().getPropertyBackgroundFilterTypeKeyword_0_0()); 
            // InternalLatteCSS.g:9688:1: ( 'background-filter-type' )
            // InternalLatteCSS.g:9689:1: 'background-filter-type'
            {
             before(grammarAccess.getBackgroundFilterTypePropertyAccess().getPropertyBackgroundFilterTypeKeyword_0_0()); 
            match(input,297,FOLLOW_2); 
             after(grammarAccess.getBackgroundFilterTypePropertyAccess().getPropertyBackgroundFilterTypeKeyword_0_0()); 

            }

             after(grammarAccess.getBackgroundFilterTypePropertyAccess().getPropertyBackgroundFilterTypeKeyword_0_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__BackgroundFilterTypeProperty__PropertyAssignment_0"


    // $ANTLR start "rule__BackgroundFilterTypeProperty__ValueAssignment_2"
    // InternalLatteCSS.g:9704:1: rule__BackgroundFilterTypeProperty__ValueAssignment_2 : ( ruleFilterValue ) ;
    public final void rule__BackgroundFilterTypeProperty__ValueAssignment_2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalLatteCSS.g:9708:1: ( ( ruleFilterValue ) )
            // InternalLatteCSS.g:9709:1: ( ruleFilterValue )
            {
            // InternalLatteCSS.g:9709:1: ( ruleFilterValue )
            // InternalLatteCSS.g:9710:1: ruleFilterValue
            {
             before(grammarAccess.getBackgroundFilterTypePropertyAccess().getValueFilterValueParserRuleCall_2_0()); 
            pushFollow(FOLLOW_2);
            ruleFilterValue();

            state._fsp--;

             after(grammarAccess.getBackgroundFilterTypePropertyAccess().getValueFilterValueParserRuleCall_2_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__BackgroundFilterTypeProperty__ValueAssignment_2"


    // $ANTLR start "rule__ShorthandColorProperty__PropertyAssignment_0"
    // InternalLatteCSS.g:9719:1: rule__ShorthandColorProperty__PropertyAssignment_0 : ( ( 'border-color' ) ) ;
    public final void rule__ShorthandColorProperty__PropertyAssignment_0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalLatteCSS.g:9723:1: ( ( ( 'border-color' ) ) )
            // InternalLatteCSS.g:9724:1: ( ( 'border-color' ) )
            {
            // InternalLatteCSS.g:9724:1: ( ( 'border-color' ) )
            // InternalLatteCSS.g:9725:1: ( 'border-color' )
            {
             before(grammarAccess.getShorthandColorPropertyAccess().getPropertyBorderColorKeyword_0_0()); 
            // InternalLatteCSS.g:9726:1: ( 'border-color' )
            // InternalLatteCSS.g:9727:1: 'border-color'
            {
             before(grammarAccess.getShorthandColorPropertyAccess().getPropertyBorderColorKeyword_0_0()); 
            match(input,298,FOLLOW_2); 
             after(grammarAccess.getShorthandColorPropertyAccess().getPropertyBorderColorKeyword_0_0()); 

            }

             after(grammarAccess.getShorthandColorPropertyAccess().getPropertyBorderColorKeyword_0_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ShorthandColorProperty__PropertyAssignment_0"


    // $ANTLR start "rule__ShorthandColorProperty__ValuesAssignment_2"
    // InternalLatteCSS.g:9742:1: rule__ShorthandColorProperty__ValuesAssignment_2 : ( ruleColorValue ) ;
    public final void rule__ShorthandColorProperty__ValuesAssignment_2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalLatteCSS.g:9746:1: ( ( ruleColorValue ) )
            // InternalLatteCSS.g:9747:1: ( ruleColorValue )
            {
            // InternalLatteCSS.g:9747:1: ( ruleColorValue )
            // InternalLatteCSS.g:9748:1: ruleColorValue
            {
             before(grammarAccess.getShorthandColorPropertyAccess().getValuesColorValueParserRuleCall_2_0()); 
            pushFollow(FOLLOW_2);
            ruleColorValue();

            state._fsp--;

             after(grammarAccess.getShorthandColorPropertyAccess().getValuesColorValueParserRuleCall_2_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ShorthandColorProperty__ValuesAssignment_2"


    // $ANTLR start "rule__ColorProperty__PropertyAssignment_0"
    // InternalLatteCSS.g:9757:1: rule__ColorProperty__PropertyAssignment_0 : ( ( rule__ColorProperty__PropertyAlternatives_0_0 ) ) ;
    public final void rule__ColorProperty__PropertyAssignment_0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalLatteCSS.g:9761:1: ( ( ( rule__ColorProperty__PropertyAlternatives_0_0 ) ) )
            // InternalLatteCSS.g:9762:1: ( ( rule__ColorProperty__PropertyAlternatives_0_0 ) )
            {
            // InternalLatteCSS.g:9762:1: ( ( rule__ColorProperty__PropertyAlternatives_0_0 ) )
            // InternalLatteCSS.g:9763:1: ( rule__ColorProperty__PropertyAlternatives_0_0 )
            {
             before(grammarAccess.getColorPropertyAccess().getPropertyAlternatives_0_0()); 
            // InternalLatteCSS.g:9764:1: ( rule__ColorProperty__PropertyAlternatives_0_0 )
            // InternalLatteCSS.g:9764:2: rule__ColorProperty__PropertyAlternatives_0_0
            {
            pushFollow(FOLLOW_2);
            rule__ColorProperty__PropertyAlternatives_0_0();

            state._fsp--;


            }

             after(grammarAccess.getColorPropertyAccess().getPropertyAlternatives_0_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ColorProperty__PropertyAssignment_0"


    // $ANTLR start "rule__ColorProperty__ValueAssignment_2"
    // InternalLatteCSS.g:9773:1: rule__ColorProperty__ValueAssignment_2 : ( ruleColorValue ) ;
    public final void rule__ColorProperty__ValueAssignment_2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalLatteCSS.g:9777:1: ( ( ruleColorValue ) )
            // InternalLatteCSS.g:9778:1: ( ruleColorValue )
            {
            // InternalLatteCSS.g:9778:1: ( ruleColorValue )
            // InternalLatteCSS.g:9779:1: ruleColorValue
            {
             before(grammarAccess.getColorPropertyAccess().getValueColorValueParserRuleCall_2_0()); 
            pushFollow(FOLLOW_2);
            ruleColorValue();

            state._fsp--;

             after(grammarAccess.getColorPropertyAccess().getValueColorValueParserRuleCall_2_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ColorProperty__ValueAssignment_2"


    // $ANTLR start "rule__AlignmentProperty__PropertyAssignment_0"
    // InternalLatteCSS.g:9788:1: rule__AlignmentProperty__PropertyAssignment_0 : ( ( 'text-align' ) ) ;
    public final void rule__AlignmentProperty__PropertyAssignment_0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalLatteCSS.g:9792:1: ( ( ( 'text-align' ) ) )
            // InternalLatteCSS.g:9793:1: ( ( 'text-align' ) )
            {
            // InternalLatteCSS.g:9793:1: ( ( 'text-align' ) )
            // InternalLatteCSS.g:9794:1: ( 'text-align' )
            {
             before(grammarAccess.getAlignmentPropertyAccess().getPropertyTextAlignKeyword_0_0()); 
            // InternalLatteCSS.g:9795:1: ( 'text-align' )
            // InternalLatteCSS.g:9796:1: 'text-align'
            {
             before(grammarAccess.getAlignmentPropertyAccess().getPropertyTextAlignKeyword_0_0()); 
            match(input,299,FOLLOW_2); 
             after(grammarAccess.getAlignmentPropertyAccess().getPropertyTextAlignKeyword_0_0()); 

            }

             after(grammarAccess.getAlignmentPropertyAccess().getPropertyTextAlignKeyword_0_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__AlignmentProperty__PropertyAssignment_0"


    // $ANTLR start "rule__AlignmentProperty__ValueAssignment_2"
    // InternalLatteCSS.g:9811:1: rule__AlignmentProperty__ValueAssignment_2 : ( ( rule__AlignmentProperty__ValueAlternatives_2_0 ) ) ;
    public final void rule__AlignmentProperty__ValueAssignment_2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalLatteCSS.g:9815:1: ( ( ( rule__AlignmentProperty__ValueAlternatives_2_0 ) ) )
            // InternalLatteCSS.g:9816:1: ( ( rule__AlignmentProperty__ValueAlternatives_2_0 ) )
            {
            // InternalLatteCSS.g:9816:1: ( ( rule__AlignmentProperty__ValueAlternatives_2_0 ) )
            // InternalLatteCSS.g:9817:1: ( rule__AlignmentProperty__ValueAlternatives_2_0 )
            {
             before(grammarAccess.getAlignmentPropertyAccess().getValueAlternatives_2_0()); 
            // InternalLatteCSS.g:9818:1: ( rule__AlignmentProperty__ValueAlternatives_2_0 )
            // InternalLatteCSS.g:9818:2: rule__AlignmentProperty__ValueAlternatives_2_0
            {
            pushFollow(FOLLOW_2);
            rule__AlignmentProperty__ValueAlternatives_2_0();

            state._fsp--;


            }

             after(grammarAccess.getAlignmentPropertyAccess().getValueAlternatives_2_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__AlignmentProperty__ValueAssignment_2"


    // $ANTLR start "rule__TimeValue__TimeAssignment_0"
    // InternalLatteCSS.g:9827:1: rule__TimeValue__TimeAssignment_0 : ( ruleNumberValue ) ;
    public final void rule__TimeValue__TimeAssignment_0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalLatteCSS.g:9831:1: ( ( ruleNumberValue ) )
            // InternalLatteCSS.g:9832:1: ( ruleNumberValue )
            {
            // InternalLatteCSS.g:9832:1: ( ruleNumberValue )
            // InternalLatteCSS.g:9833:1: ruleNumberValue
            {
             before(grammarAccess.getTimeValueAccess().getTimeNumberValueParserRuleCall_0_0()); 
            pushFollow(FOLLOW_2);
            ruleNumberValue();

            state._fsp--;

             after(grammarAccess.getTimeValueAccess().getTimeNumberValueParserRuleCall_0_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__TimeValue__TimeAssignment_0"


    // $ANTLR start "rule__TimeValue__UnitAssignment_1"
    // InternalLatteCSS.g:9842:1: rule__TimeValue__UnitAssignment_1 : ( ( rule__TimeValue__UnitAlternatives_1_0 ) ) ;
    public final void rule__TimeValue__UnitAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalLatteCSS.g:9846:1: ( ( ( rule__TimeValue__UnitAlternatives_1_0 ) ) )
            // InternalLatteCSS.g:9847:1: ( ( rule__TimeValue__UnitAlternatives_1_0 ) )
            {
            // InternalLatteCSS.g:9847:1: ( ( rule__TimeValue__UnitAlternatives_1_0 ) )
            // InternalLatteCSS.g:9848:1: ( rule__TimeValue__UnitAlternatives_1_0 )
            {
             before(grammarAccess.getTimeValueAccess().getUnitAlternatives_1_0()); 
            // InternalLatteCSS.g:9849:1: ( rule__TimeValue__UnitAlternatives_1_0 )
            // InternalLatteCSS.g:9849:2: rule__TimeValue__UnitAlternatives_1_0
            {
            pushFollow(FOLLOW_2);
            rule__TimeValue__UnitAlternatives_1_0();

            state._fsp--;


            }

             after(grammarAccess.getTimeValueAccess().getUnitAlternatives_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__TimeValue__UnitAssignment_1"


    // $ANTLR start "rule__ViewSizeValue__ValueAssignment_0"
    // InternalLatteCSS.g:9858:1: rule__ViewSizeValue__ValueAssignment_0 : ( ruleSizeValue ) ;
    public final void rule__ViewSizeValue__ValueAssignment_0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalLatteCSS.g:9862:1: ( ( ruleSizeValue ) )
            // InternalLatteCSS.g:9863:1: ( ruleSizeValue )
            {
            // InternalLatteCSS.g:9863:1: ( ruleSizeValue )
            // InternalLatteCSS.g:9864:1: ruleSizeValue
            {
             before(grammarAccess.getViewSizeValueAccess().getValueSizeValueParserRuleCall_0_0()); 
            pushFollow(FOLLOW_2);
            ruleSizeValue();

            state._fsp--;

             after(grammarAccess.getViewSizeValueAccess().getValueSizeValueParserRuleCall_0_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ViewSizeValue__ValueAssignment_0"


    // $ANTLR start "rule__ViewSizeValue__DynamicAssignment_1"
    // InternalLatteCSS.g:9873:1: rule__ViewSizeValue__DynamicAssignment_1 : ( ( rule__ViewSizeValue__DynamicAlternatives_1_0 ) ) ;
    public final void rule__ViewSizeValue__DynamicAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalLatteCSS.g:9877:1: ( ( ( rule__ViewSizeValue__DynamicAlternatives_1_0 ) ) )
            // InternalLatteCSS.g:9878:1: ( ( rule__ViewSizeValue__DynamicAlternatives_1_0 ) )
            {
            // InternalLatteCSS.g:9878:1: ( ( rule__ViewSizeValue__DynamicAlternatives_1_0 ) )
            // InternalLatteCSS.g:9879:1: ( rule__ViewSizeValue__DynamicAlternatives_1_0 )
            {
             before(grammarAccess.getViewSizeValueAccess().getDynamicAlternatives_1_0()); 
            // InternalLatteCSS.g:9880:1: ( rule__ViewSizeValue__DynamicAlternatives_1_0 )
            // InternalLatteCSS.g:9880:2: rule__ViewSizeValue__DynamicAlternatives_1_0
            {
            pushFollow(FOLLOW_2);
            rule__ViewSizeValue__DynamicAlternatives_1_0();

            state._fsp--;


            }

             after(grammarAccess.getViewSizeValueAccess().getDynamicAlternatives_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ViewSizeValue__DynamicAssignment_1"


    // $ANTLR start "rule__SizeValue__ValueAssignment_0"
    // InternalLatteCSS.g:9889:1: rule__SizeValue__ValueAssignment_0 : ( ruleNumberValue ) ;
    public final void rule__SizeValue__ValueAssignment_0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalLatteCSS.g:9893:1: ( ( ruleNumberValue ) )
            // InternalLatteCSS.g:9894:1: ( ruleNumberValue )
            {
            // InternalLatteCSS.g:9894:1: ( ruleNumberValue )
            // InternalLatteCSS.g:9895:1: ruleNumberValue
            {
             before(grammarAccess.getSizeValueAccess().getValueNumberValueParserRuleCall_0_0()); 
            pushFollow(FOLLOW_2);
            ruleNumberValue();

            state._fsp--;

             after(grammarAccess.getSizeValueAccess().getValueNumberValueParserRuleCall_0_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__SizeValue__ValueAssignment_0"


    // $ANTLR start "rule__SizeValue__DimensionAssignment_1"
    // InternalLatteCSS.g:9904:1: rule__SizeValue__DimensionAssignment_1 : ( ( rule__SizeValue__DimensionAlternatives_1_0 ) ) ;
    public final void rule__SizeValue__DimensionAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalLatteCSS.g:9908:1: ( ( ( rule__SizeValue__DimensionAlternatives_1_0 ) ) )
            // InternalLatteCSS.g:9909:1: ( ( rule__SizeValue__DimensionAlternatives_1_0 ) )
            {
            // InternalLatteCSS.g:9909:1: ( ( rule__SizeValue__DimensionAlternatives_1_0 ) )
            // InternalLatteCSS.g:9910:1: ( rule__SizeValue__DimensionAlternatives_1_0 )
            {
             before(grammarAccess.getSizeValueAccess().getDimensionAlternatives_1_0()); 
            // InternalLatteCSS.g:9911:1: ( rule__SizeValue__DimensionAlternatives_1_0 )
            // InternalLatteCSS.g:9911:2: rule__SizeValue__DimensionAlternatives_1_0
            {
            pushFollow(FOLLOW_2);
            rule__SizeValue__DimensionAlternatives_1_0();

            state._fsp--;


            }

             after(grammarAccess.getSizeValueAccess().getDimensionAlternatives_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__SizeValue__DimensionAssignment_1"


    // $ANTLR start "rule__LinearGradient__X1Assignment_2"
    // InternalLatteCSS.g:9920:1: rule__LinearGradient__X1Assignment_2 : ( ruleSizeValue ) ;
    public final void rule__LinearGradient__X1Assignment_2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalLatteCSS.g:9924:1: ( ( ruleSizeValue ) )
            // InternalLatteCSS.g:9925:1: ( ruleSizeValue )
            {
            // InternalLatteCSS.g:9925:1: ( ruleSizeValue )
            // InternalLatteCSS.g:9926:1: ruleSizeValue
            {
             before(grammarAccess.getLinearGradientAccess().getX1SizeValueParserRuleCall_2_0()); 
            pushFollow(FOLLOW_2);
            ruleSizeValue();

            state._fsp--;

             after(grammarAccess.getLinearGradientAccess().getX1SizeValueParserRuleCall_2_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__LinearGradient__X1Assignment_2"


    // $ANTLR start "rule__LinearGradient__Y1Assignment_4"
    // InternalLatteCSS.g:9935:1: rule__LinearGradient__Y1Assignment_4 : ( ruleSizeValue ) ;
    public final void rule__LinearGradient__Y1Assignment_4() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalLatteCSS.g:9939:1: ( ( ruleSizeValue ) )
            // InternalLatteCSS.g:9940:1: ( ruleSizeValue )
            {
            // InternalLatteCSS.g:9940:1: ( ruleSizeValue )
            // InternalLatteCSS.g:9941:1: ruleSizeValue
            {
             before(grammarAccess.getLinearGradientAccess().getY1SizeValueParserRuleCall_4_0()); 
            pushFollow(FOLLOW_2);
            ruleSizeValue();

            state._fsp--;

             after(grammarAccess.getLinearGradientAccess().getY1SizeValueParserRuleCall_4_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__LinearGradient__Y1Assignment_4"


    // $ANTLR start "rule__LinearGradient__X2Assignment_8"
    // InternalLatteCSS.g:9950:1: rule__LinearGradient__X2Assignment_8 : ( ruleSizeValue ) ;
    public final void rule__LinearGradient__X2Assignment_8() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalLatteCSS.g:9954:1: ( ( ruleSizeValue ) )
            // InternalLatteCSS.g:9955:1: ( ruleSizeValue )
            {
            // InternalLatteCSS.g:9955:1: ( ruleSizeValue )
            // InternalLatteCSS.g:9956:1: ruleSizeValue
            {
             before(grammarAccess.getLinearGradientAccess().getX2SizeValueParserRuleCall_8_0()); 
            pushFollow(FOLLOW_2);
            ruleSizeValue();

            state._fsp--;

             after(grammarAccess.getLinearGradientAccess().getX2SizeValueParserRuleCall_8_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__LinearGradient__X2Assignment_8"


    // $ANTLR start "rule__LinearGradient__Y2Assignment_10"
    // InternalLatteCSS.g:9965:1: rule__LinearGradient__Y2Assignment_10 : ( ruleSizeValue ) ;
    public final void rule__LinearGradient__Y2Assignment_10() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalLatteCSS.g:9969:1: ( ( ruleSizeValue ) )
            // InternalLatteCSS.g:9970:1: ( ruleSizeValue )
            {
            // InternalLatteCSS.g:9970:1: ( ruleSizeValue )
            // InternalLatteCSS.g:9971:1: ruleSizeValue
            {
             before(grammarAccess.getLinearGradientAccess().getY2SizeValueParserRuleCall_10_0()); 
            pushFollow(FOLLOW_2);
            ruleSizeValue();

            state._fsp--;

             after(grammarAccess.getLinearGradientAccess().getY2SizeValueParserRuleCall_10_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__LinearGradient__Y2Assignment_10"


    // $ANTLR start "rule__LinearGradient__StopsAssignment_13_1"
    // InternalLatteCSS.g:9980:1: rule__LinearGradient__StopsAssignment_13_1 : ( ruleStopValue ) ;
    public final void rule__LinearGradient__StopsAssignment_13_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalLatteCSS.g:9984:1: ( ( ruleStopValue ) )
            // InternalLatteCSS.g:9985:1: ( ruleStopValue )
            {
            // InternalLatteCSS.g:9985:1: ( ruleStopValue )
            // InternalLatteCSS.g:9986:1: ruleStopValue
            {
             before(grammarAccess.getLinearGradientAccess().getStopsStopValueParserRuleCall_13_1_0()); 
            pushFollow(FOLLOW_2);
            ruleStopValue();

            state._fsp--;

             after(grammarAccess.getLinearGradientAccess().getStopsStopValueParserRuleCall_13_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__LinearGradient__StopsAssignment_13_1"


    // $ANTLR start "rule__RadialGradient__CxAssignment_1_1"
    // InternalLatteCSS.g:9995:1: rule__RadialGradient__CxAssignment_1_1 : ( ruleSizeValue ) ;
    public final void rule__RadialGradient__CxAssignment_1_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalLatteCSS.g:9999:1: ( ( ruleSizeValue ) )
            // InternalLatteCSS.g:10000:1: ( ruleSizeValue )
            {
            // InternalLatteCSS.g:10000:1: ( ruleSizeValue )
            // InternalLatteCSS.g:10001:1: ruleSizeValue
            {
             before(grammarAccess.getRadialGradientAccess().getCxSizeValueParserRuleCall_1_1_0()); 
            pushFollow(FOLLOW_2);
            ruleSizeValue();

            state._fsp--;

             after(grammarAccess.getRadialGradientAccess().getCxSizeValueParserRuleCall_1_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__RadialGradient__CxAssignment_1_1"


    // $ANTLR start "rule__RadialGradient__CyAssignment_1_3"
    // InternalLatteCSS.g:10010:1: rule__RadialGradient__CyAssignment_1_3 : ( ruleSizeValue ) ;
    public final void rule__RadialGradient__CyAssignment_1_3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalLatteCSS.g:10014:1: ( ( ruleSizeValue ) )
            // InternalLatteCSS.g:10015:1: ( ruleSizeValue )
            {
            // InternalLatteCSS.g:10015:1: ( ruleSizeValue )
            // InternalLatteCSS.g:10016:1: ruleSizeValue
            {
             before(grammarAccess.getRadialGradientAccess().getCySizeValueParserRuleCall_1_3_0()); 
            pushFollow(FOLLOW_2);
            ruleSizeValue();

            state._fsp--;

             after(grammarAccess.getRadialGradientAccess().getCySizeValueParserRuleCall_1_3_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__RadialGradient__CyAssignment_1_3"


    // $ANTLR start "rule__RadialGradient__RadiusAssignment_2"
    // InternalLatteCSS.g:10025:1: rule__RadialGradient__RadiusAssignment_2 : ( ruleSizeValue ) ;
    public final void rule__RadialGradient__RadiusAssignment_2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalLatteCSS.g:10029:1: ( ( ruleSizeValue ) )
            // InternalLatteCSS.g:10030:1: ( ruleSizeValue )
            {
            // InternalLatteCSS.g:10030:1: ( ruleSizeValue )
            // InternalLatteCSS.g:10031:1: ruleSizeValue
            {
             before(grammarAccess.getRadialGradientAccess().getRadiusSizeValueParserRuleCall_2_0()); 
            pushFollow(FOLLOW_2);
            ruleSizeValue();

            state._fsp--;

             after(grammarAccess.getRadialGradientAccess().getRadiusSizeValueParserRuleCall_2_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__RadialGradient__RadiusAssignment_2"


    // $ANTLR start "rule__RadialGradient__FxAssignment_3_2"
    // InternalLatteCSS.g:10040:1: rule__RadialGradient__FxAssignment_3_2 : ( ruleSizeValue ) ;
    public final void rule__RadialGradient__FxAssignment_3_2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalLatteCSS.g:10044:1: ( ( ruleSizeValue ) )
            // InternalLatteCSS.g:10045:1: ( ruleSizeValue )
            {
            // InternalLatteCSS.g:10045:1: ( ruleSizeValue )
            // InternalLatteCSS.g:10046:1: ruleSizeValue
            {
             before(grammarAccess.getRadialGradientAccess().getFxSizeValueParserRuleCall_3_2_0()); 
            pushFollow(FOLLOW_2);
            ruleSizeValue();

            state._fsp--;

             after(grammarAccess.getRadialGradientAccess().getFxSizeValueParserRuleCall_3_2_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__RadialGradient__FxAssignment_3_2"


    // $ANTLR start "rule__RadialGradient__FyAssignment_3_4"
    // InternalLatteCSS.g:10055:1: rule__RadialGradient__FyAssignment_3_4 : ( ruleSizeValue ) ;
    public final void rule__RadialGradient__FyAssignment_3_4() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalLatteCSS.g:10059:1: ( ( ruleSizeValue ) )
            // InternalLatteCSS.g:10060:1: ( ruleSizeValue )
            {
            // InternalLatteCSS.g:10060:1: ( ruleSizeValue )
            // InternalLatteCSS.g:10061:1: ruleSizeValue
            {
             before(grammarAccess.getRadialGradientAccess().getFySizeValueParserRuleCall_3_4_0()); 
            pushFollow(FOLLOW_2);
            ruleSizeValue();

            state._fsp--;

             after(grammarAccess.getRadialGradientAccess().getFySizeValueParserRuleCall_3_4_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__RadialGradient__FyAssignment_3_4"


    // $ANTLR start "rule__RadialGradient__StopsAssignment_5_1"
    // InternalLatteCSS.g:10070:1: rule__RadialGradient__StopsAssignment_5_1 : ( ruleStopValue ) ;
    public final void rule__RadialGradient__StopsAssignment_5_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalLatteCSS.g:10074:1: ( ( ruleStopValue ) )
            // InternalLatteCSS.g:10075:1: ( ruleStopValue )
            {
            // InternalLatteCSS.g:10075:1: ( ruleStopValue )
            // InternalLatteCSS.g:10076:1: ruleStopValue
            {
             before(grammarAccess.getRadialGradientAccess().getStopsStopValueParserRuleCall_5_1_0()); 
            pushFollow(FOLLOW_2);
            ruleStopValue();

            state._fsp--;

             after(grammarAccess.getRadialGradientAccess().getStopsStopValueParserRuleCall_5_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__RadialGradient__StopsAssignment_5_1"


    // $ANTLR start "rule__StopValue__PosAssignment_0"
    // InternalLatteCSS.g:10085:1: rule__StopValue__PosAssignment_0 : ( ruleSizeValue ) ;
    public final void rule__StopValue__PosAssignment_0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalLatteCSS.g:10089:1: ( ( ruleSizeValue ) )
            // InternalLatteCSS.g:10090:1: ( ruleSizeValue )
            {
            // InternalLatteCSS.g:10090:1: ( ruleSizeValue )
            // InternalLatteCSS.g:10091:1: ruleSizeValue
            {
             before(grammarAccess.getStopValueAccess().getPosSizeValueParserRuleCall_0_0()); 
            pushFollow(FOLLOW_2);
            ruleSizeValue();

            state._fsp--;

             after(grammarAccess.getStopValueAccess().getPosSizeValueParserRuleCall_0_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__StopValue__PosAssignment_0"


    // $ANTLR start "rule__StopValue__ColorAssignment_2"
    // InternalLatteCSS.g:10100:1: rule__StopValue__ColorAssignment_2 : ( ruleColorValue ) ;
    public final void rule__StopValue__ColorAssignment_2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalLatteCSS.g:10104:1: ( ( ruleColorValue ) )
            // InternalLatteCSS.g:10105:1: ( ruleColorValue )
            {
            // InternalLatteCSS.g:10105:1: ( ruleColorValue )
            // InternalLatteCSS.g:10106:1: ruleColorValue
            {
             before(grammarAccess.getStopValueAccess().getColorColorValueParserRuleCall_2_0()); 
            pushFollow(FOLLOW_2);
            ruleColorValue();

            state._fsp--;

             after(grammarAccess.getStopValueAccess().getColorColorValueParserRuleCall_2_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__StopValue__ColorAssignment_2"


    // $ANTLR start "rule__ColorValue__NamedColorAssignment_0"
    // InternalLatteCSS.g:10115:1: rule__ColorValue__NamedColorAssignment_0 : ( ruleNamedColor ) ;
    public final void rule__ColorValue__NamedColorAssignment_0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalLatteCSS.g:10119:1: ( ( ruleNamedColor ) )
            // InternalLatteCSS.g:10120:1: ( ruleNamedColor )
            {
            // InternalLatteCSS.g:10120:1: ( ruleNamedColor )
            // InternalLatteCSS.g:10121:1: ruleNamedColor
            {
             before(grammarAccess.getColorValueAccess().getNamedColorNamedColorParserRuleCall_0_0()); 
            pushFollow(FOLLOW_2);
            ruleNamedColor();

            state._fsp--;

             after(grammarAccess.getColorValueAccess().getNamedColorNamedColorParserRuleCall_0_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ColorValue__NamedColorAssignment_0"


    // $ANTLR start "rule__ColorValue__RgbAssignment_1"
    // InternalLatteCSS.g:10130:1: rule__ColorValue__RgbAssignment_1 : ( ruleRGBColor ) ;
    public final void rule__ColorValue__RgbAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalLatteCSS.g:10134:1: ( ( ruleRGBColor ) )
            // InternalLatteCSS.g:10135:1: ( ruleRGBColor )
            {
            // InternalLatteCSS.g:10135:1: ( ruleRGBColor )
            // InternalLatteCSS.g:10136:1: ruleRGBColor
            {
             before(grammarAccess.getColorValueAccess().getRgbRGBColorParserRuleCall_1_0()); 
            pushFollow(FOLLOW_2);
            ruleRGBColor();

            state._fsp--;

             after(grammarAccess.getColorValueAccess().getRgbRGBColorParserRuleCall_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ColorValue__RgbAssignment_1"


    // $ANTLR start "rule__RGBColor__HexAssignment_0"
    // InternalLatteCSS.g:10145:1: rule__RGBColor__HexAssignment_0 : ( RULE_HEX_NUMBER ) ;
    public final void rule__RGBColor__HexAssignment_0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalLatteCSS.g:10149:1: ( ( RULE_HEX_NUMBER ) )
            // InternalLatteCSS.g:10150:1: ( RULE_HEX_NUMBER )
            {
            // InternalLatteCSS.g:10150:1: ( RULE_HEX_NUMBER )
            // InternalLatteCSS.g:10151:1: RULE_HEX_NUMBER
            {
             before(grammarAccess.getRGBColorAccess().getHexHEX_NUMBERTerminalRuleCall_0_0()); 
            match(input,RULE_HEX_NUMBER,FOLLOW_2); 
             after(grammarAccess.getRGBColorAccess().getHexHEX_NUMBERTerminalRuleCall_0_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__RGBColor__HexAssignment_0"


    // $ANTLR start "rule__RGBColor__RAssignment_1_2"
    // InternalLatteCSS.g:10160:1: rule__RGBColor__RAssignment_1_2 : ( ruleIntegerValue ) ;
    public final void rule__RGBColor__RAssignment_1_2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalLatteCSS.g:10164:1: ( ( ruleIntegerValue ) )
            // InternalLatteCSS.g:10165:1: ( ruleIntegerValue )
            {
            // InternalLatteCSS.g:10165:1: ( ruleIntegerValue )
            // InternalLatteCSS.g:10166:1: ruleIntegerValue
            {
             before(grammarAccess.getRGBColorAccess().getRIntegerValueParserRuleCall_1_2_0()); 
            pushFollow(FOLLOW_2);
            ruleIntegerValue();

            state._fsp--;

             after(grammarAccess.getRGBColorAccess().getRIntegerValueParserRuleCall_1_2_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__RGBColor__RAssignment_1_2"


    // $ANTLR start "rule__RGBColor__GAssignment_1_4"
    // InternalLatteCSS.g:10175:1: rule__RGBColor__GAssignment_1_4 : ( ruleIntegerValue ) ;
    public final void rule__RGBColor__GAssignment_1_4() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalLatteCSS.g:10179:1: ( ( ruleIntegerValue ) )
            // InternalLatteCSS.g:10180:1: ( ruleIntegerValue )
            {
            // InternalLatteCSS.g:10180:1: ( ruleIntegerValue )
            // InternalLatteCSS.g:10181:1: ruleIntegerValue
            {
             before(grammarAccess.getRGBColorAccess().getGIntegerValueParserRuleCall_1_4_0()); 
            pushFollow(FOLLOW_2);
            ruleIntegerValue();

            state._fsp--;

             after(grammarAccess.getRGBColorAccess().getGIntegerValueParserRuleCall_1_4_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__RGBColor__GAssignment_1_4"


    // $ANTLR start "rule__RGBColor__BAssignment_1_6"
    // InternalLatteCSS.g:10190:1: rule__RGBColor__BAssignment_1_6 : ( ruleIntegerValue ) ;
    public final void rule__RGBColor__BAssignment_1_6() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalLatteCSS.g:10194:1: ( ( ruleIntegerValue ) )
            // InternalLatteCSS.g:10195:1: ( ruleIntegerValue )
            {
            // InternalLatteCSS.g:10195:1: ( ruleIntegerValue )
            // InternalLatteCSS.g:10196:1: ruleIntegerValue
            {
             before(grammarAccess.getRGBColorAccess().getBIntegerValueParserRuleCall_1_6_0()); 
            pushFollow(FOLLOW_2);
            ruleIntegerValue();

            state._fsp--;

             after(grammarAccess.getRGBColorAccess().getBIntegerValueParserRuleCall_1_6_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__RGBColor__BAssignment_1_6"


    // $ANTLR start "rule__RGBColor__RAssignment_2_2"
    // InternalLatteCSS.g:10205:1: rule__RGBColor__RAssignment_2_2 : ( ruleIntegerValue ) ;
    public final void rule__RGBColor__RAssignment_2_2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalLatteCSS.g:10209:1: ( ( ruleIntegerValue ) )
            // InternalLatteCSS.g:10210:1: ( ruleIntegerValue )
            {
            // InternalLatteCSS.g:10210:1: ( ruleIntegerValue )
            // InternalLatteCSS.g:10211:1: ruleIntegerValue
            {
             before(grammarAccess.getRGBColorAccess().getRIntegerValueParserRuleCall_2_2_0()); 
            pushFollow(FOLLOW_2);
            ruleIntegerValue();

            state._fsp--;

             after(grammarAccess.getRGBColorAccess().getRIntegerValueParserRuleCall_2_2_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__RGBColor__RAssignment_2_2"


    // $ANTLR start "rule__RGBColor__GAssignment_2_4"
    // InternalLatteCSS.g:10220:1: rule__RGBColor__GAssignment_2_4 : ( ruleIntegerValue ) ;
    public final void rule__RGBColor__GAssignment_2_4() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalLatteCSS.g:10224:1: ( ( ruleIntegerValue ) )
            // InternalLatteCSS.g:10225:1: ( ruleIntegerValue )
            {
            // InternalLatteCSS.g:10225:1: ( ruleIntegerValue )
            // InternalLatteCSS.g:10226:1: ruleIntegerValue
            {
             before(grammarAccess.getRGBColorAccess().getGIntegerValueParserRuleCall_2_4_0()); 
            pushFollow(FOLLOW_2);
            ruleIntegerValue();

            state._fsp--;

             after(grammarAccess.getRGBColorAccess().getGIntegerValueParserRuleCall_2_4_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__RGBColor__GAssignment_2_4"


    // $ANTLR start "rule__RGBColor__BAssignment_2_6"
    // InternalLatteCSS.g:10235:1: rule__RGBColor__BAssignment_2_6 : ( ruleIntegerValue ) ;
    public final void rule__RGBColor__BAssignment_2_6() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalLatteCSS.g:10239:1: ( ( ruleIntegerValue ) )
            // InternalLatteCSS.g:10240:1: ( ruleIntegerValue )
            {
            // InternalLatteCSS.g:10240:1: ( ruleIntegerValue )
            // InternalLatteCSS.g:10241:1: ruleIntegerValue
            {
             before(grammarAccess.getRGBColorAccess().getBIntegerValueParserRuleCall_2_6_0()); 
            pushFollow(FOLLOW_2);
            ruleIntegerValue();

            state._fsp--;

             after(grammarAccess.getRGBColorAccess().getBIntegerValueParserRuleCall_2_6_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__RGBColor__BAssignment_2_6"


    // $ANTLR start "rule__RGBColor__AlphaAssignment_2_8"
    // InternalLatteCSS.g:10250:1: rule__RGBColor__AlphaAssignment_2_8 : ( ruleNumberValue ) ;
    public final void rule__RGBColor__AlphaAssignment_2_8() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalLatteCSS.g:10254:1: ( ( ruleNumberValue ) )
            // InternalLatteCSS.g:10255:1: ( ruleNumberValue )
            {
            // InternalLatteCSS.g:10255:1: ( ruleNumberValue )
            // InternalLatteCSS.g:10256:1: ruleNumberValue
            {
             before(grammarAccess.getRGBColorAccess().getAlphaNumberValueParserRuleCall_2_8_0()); 
            pushFollow(FOLLOW_2);
            ruleNumberValue();

            state._fsp--;

             after(grammarAccess.getRGBColorAccess().getAlphaNumberValueParserRuleCall_2_8_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__RGBColor__AlphaAssignment_2_8"

    // Delegated rules


 

    public static final BitSet FOLLOW_1 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_2 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_3 = new BitSet(new long[]{0x0000000000000042L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000600000L});
    public static final BitSet FOLLOW_4 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000140000L});
    public static final BitSet FOLLOW_5 = new BitSet(new long[]{0x0000000000000002L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000100000L});
    public static final BitSet FOLLOW_6 = new BitSet(new long[]{0x0001FFFFFFFF0000L,0x0000000FF0000000L,0x0000000000000000L,0x0000000000000000L,0x00000FFE00000000L});
    public static final BitSet FOLLOW_7 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000080000L});
    public static final BitSet FOLLOW_8 = new BitSet(new long[]{0x0001FFFFFFFF0002L,0x0000000FF0000000L,0x0000000000000000L,0x0000000000000000L,0x00000FFE00000000L});
    public static final BitSet FOLLOW_9 = new BitSet(new long[]{0x0000000000000040L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000600000L});
    public static final BitSet FOLLOW_10 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000800000L});
    public static final BitSet FOLLOW_11 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_12 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000001000000L});
    public static final BitSet FOLLOW_13 = new BitSet(new long[]{0x0000000000000080L});
    public static final BitSet FOLLOW_14 = new BitSet(new long[]{0x000000000000E000L});
    public static final BitSet FOLLOW_15 = new BitSet(new long[]{0x0000000000000030L,0x0060000000000000L});
    public static final BitSet FOLLOW_16 = new BitSet(new long[]{0x0000000000000030L});
    public static final BitSet FOLLOW_17 = new BitSet(new long[]{0x0000000000000032L});
    public static final BitSet FOLLOW_18 = new BitSet(new long[]{0x0000000000000100L,0xC000400000000000L,0xFFFFFFFFFFFFFFFFL,0xFFFFFFFFFFFFFFFFL,0x00000001A003FFFFL});
    public static final BitSet FOLLOW_19 = new BitSet(new long[]{0x00001FFE7FFF0000L,0x0006000000000000L});
    public static final BitSet FOLLOW_20 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000100000L});
    public static final BitSet FOLLOW_21 = new BitSet(new long[]{0x0000000000000030L,0x0001FFE000000000L});
    public static final BitSet FOLLOW_22 = new BitSet(new long[]{0x0FF0000000000000L});
    public static final BitSet FOLLOW_23 = new BitSet(new long[]{0x000E000000000030L});
    public static final BitSet FOLLOW_24 = new BitSet(new long[]{0x0000000000000000L,0x000000000FFFFC00L});
    public static final BitSet FOLLOW_25 = new BitSet(new long[]{0xF000000000000000L,0x00000000000003FFL});
    public static final BitSet FOLLOW_26 = new BitSet(new long[]{0x0000000000000102L,0xC000400000000000L,0xFFFFFFFFFFFFFFFFL,0xFFFFFFFFFFFFFFFFL,0x00000001A003FFFFL});
    public static final BitSet FOLLOW_27 = new BitSet(new long[]{0xC000000000000000L,0x0000001000000010L});
    public static final BitSet FOLLOW_28 = new BitSet(new long[]{0x0000000000000000L,0x0018000000000000L});
    public static final BitSet FOLLOW_29 = new BitSet(new long[]{0x0000000000000000L,0x0F80000000000000L});
    public static final BitSet FOLLOW_30 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000002000000L});
    public static final BitSet FOLLOW_31 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000004000000L});
    public static final BitSet FOLLOW_32 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000008000000L});
    public static final BitSet FOLLOW_33 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000010000000L});
    public static final BitSet FOLLOW_34 = new BitSet(new long[]{0x0000000000000000L,0x3000000000000000L});
    public static final BitSet FOLLOW_35 = new BitSet(new long[]{0x0000000000000002L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000002000000L});
    public static final BitSet FOLLOW_36 = new BitSet(new long[]{0x0000000000000030L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000002000000L});
    public static final BitSet FOLLOW_37 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000040000000L});
    public static final BitSet FOLLOW_38 = new BitSet(new long[]{0x0000000000000010L});

}