package io.lattekit.dsl.idea.parser.antlr.internal;

import org.eclipse.xtext.idea.parser.AbstractPsiAntlrParser;
import io.lattekit.dsl.idea.lang.LatteCSSElementTypeProvider;
import org.eclipse.xtext.idea.parser.TokenTypeProvider;
import org.eclipse.xtext.parser.antlr.XtextTokenStream;
import org.eclipse.xtext.parser.antlr.XtextTokenStream.HiddenTokens;
import io.lattekit.dsl.services.LatteCSSGrammarAccess;

import com.intellij.lang.PsiBuilder;


import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

@SuppressWarnings("all")
public class PsiInternalLatteCSSParser extends AbstractPsiAntlrParser {
    public static final String[] tokenNames = new String[] {
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "RULE_ID", "RULE_STRING", "RULE_INT", "RULE_REAL", "RULE_HEX_NUMBER", "RULE_ML_COMMENT", "RULE_SL_COMMENT", "RULE_WS", "RULE_ANY_OTHER", "','", "'{'", "'}'", "'#'", "'.'", "':'", "';'", "'font-family'", "'font-style'", "'normal'", "'bold'", "'bold-italic'", "'width'", "'height'", "'border-width'", "'border-radius'", "'margin'", "'padding'", "'border-top-left-radius'", "'border-top-right-radius'", "'border-bottom-left-radius'", "'border-bottom-right-radius'", "'border-left-width'", "'border-right-width'", "'border-top-width'", "'border-bottom-width'", "'font-size'", "'translate-x'", "'translate-y'", "'margin-left'", "'margin-right'", "'margin-top'", "'margin-bottom'", "'padding-left'", "'padding-right'", "'padding-top'", "'padding-bottom'", "'x'", "'y'", "'elevation'", "'background'", "'transition'", "'background-drawable'", "'background-repeat'", "'border'", "'border-top'", "'border-bottom'", "'border-left'", "'border-right'", "'solid'", "'dashed'", "'dotted'", "'background-filter'", "'repeat-x'", "'mirror-x'", "'clamp-x'", "'no-repeat-x'", "'repeat-y'", "'mirror-y'", "'clamp-y'", "'no-repeat-y'", "'top'", "'bottom'", "'left'", "'right'", "'center_vertical'", "'fill_vertical'", "'center_horizontal'", "'fill_horizontal'", "'center'", "'fill'", "'clip_vertical'", "'clip_horizontal'", "'start'", "'end'", "'background-gravity'", "'add'", "'clear'", "'darken'", "'dst'", "'dst_atop'", "'dst_in'", "'dst_out'", "'dst_over'", "'lighten'", "'multiply'", "'overlay'", "'screen'", "'src'", "'src_atop'", "'src_in'", "'src_out'", "'src_over'", "'xor'", "'background-filter-type'", "'border-color'", "'border-top-color'", "'border-left-color'", "'border-right-color'", "'border-bottom-color'", "'ripple-color'", "'background-color'", "'text-color'", "'background-filter-color'", "'text-align'", "'justify'", "'accelerate-decelerate'", "'accelerate'", "'anticipate'", "'anticipate-overshoot'", "'bounce'", "'cycle'", "'decelerate'", "'fast-out'", "'fast-out-slow'", "'linear'", "'linear-out'", "'overshoot'", "'translateX'", "'translateY'", "'s'", "'ms'", "'match_parent'", "'wrap_content'", "'dp'", "'px'", "'sp'", "'pt'", "'mm'", "'('", "')'", "'to'", "'stops'", "'repeat'", "'reflect'", "'radial'", "'focus'", "'aliceblue'", "'antiquewhite'", "'aqua'", "'aquamarine'", "'azure'", "'beige'", "'bisque'", "'black'", "'blanchedalmond'", "'blue'", "'blueviolet'", "'brown'", "'burlywood'", "'cadetblue'", "'chartreuse'", "'chocolate'", "'coral'", "'cornflowerblue'", "'cornsilk'", "'crimson'", "'cyan'", "'darkblue'", "'darkcyan'", "'darkgoldenrod'", "'darkgray'", "'darkgreen'", "'darkgrey'", "'darkkhaki'", "'darkmagenta'", "'darkolivegreen'", "'darkorange'", "'darkorchid'", "'darkred'", "'darksalmon'", "'darkseagreen'", "'darkslateblue'", "'darkslategray'", "'darkslategrey'", "'darkturquoise'", "'darkviolet'", "'deeppink'", "'deepskyblue'", "'dimgray'", "'dimgrey'", "'dodgerblue'", "'firebrick'", "'floralwhite'", "'forestgreen'", "'fuchsia'", "'gainsboro'", "'ghostwhite'", "'gold'", "'goldenrod'", "'gray'", "'green'", "'greenyellow'", "'grey'", "'honeydew'", "'hotpink'", "'indianred'", "'indigo'", "'ivory'", "'khaki'", "'lavender'", "'lavenderblush'", "'lawngreen'", "'lemonchiffon'", "'lightblue'", "'lightcoral'", "'lightcyan'", "'lightgoldenrodyellow'", "'lightgray'", "'lightgreen'", "'lightgrey'", "'lightpink'", "'lightsalmon'", "'lightseagreen'", "'lightskyblue'", "'lightslategray'", "'lightslategrey'", "'lightsteelblue'", "'lightyellow'", "'lime'", "'limegreen'", "'linen'", "'magenta'", "'maroon'", "'mediumaquamarine'", "'mediumblue'", "'mediumorchid'", "'mediumpurple'", "'mediumseagreen'", "'mediumslateblue'", "'mediumspringgreen'", "'mediumturquoise'", "'mediumvioletred'", "'midnightblue'", "'mintcream'", "'mistyrose'", "'moccasin'", "'navajowhite'", "'navy'", "'oldlace'", "'olive'", "'olivedrab'", "'orange'", "'orangered'", "'orchid'", "'palegoldenrod'", "'palegreen'", "'paleturquoise'", "'palevioletred'", "'papayawhip'", "'peachpuff'", "'peru'", "'pink'", "'plum'", "'powderblue'", "'purple'", "'red'", "'rosybrown'", "'royalblue'", "'saddlebrown'", "'salmon'", "'sandybrown'", "'seagreen'", "'seashell'", "'sienna'", "'silver'", "'skyblue'", "'slateblue'", "'slategray'", "'slategrey'", "'snow'", "'springgreen'", "'steelblue'", "'tan'", "'teal'", "'thistle'", "'tomato'", "'turquoise'", "'violet'", "'wheat'", "'white'", "'whitesmoke'", "'yellow'", "'yellowgreen'", "'transparent'", "'rgb'", "'rgba'"
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
    public static final int RULE_ID=4;
    public static final int T__131=131;
    public static final int T__252=252;
    public static final int T__130=130;
    public static final int T__251=251;
    public static final int RULE_REAL=7;
    public static final int RULE_INT=6;
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
    public static final int RULE_STRING=5;
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


        public PsiInternalLatteCSSParser(TokenStream input) {
            this(input, new RecognizerSharedState());
        }
        public PsiInternalLatteCSSParser(TokenStream input, RecognizerSharedState state) {
            super(input, state);
             
        }
        

    public String[] getTokenNames() { return PsiInternalLatteCSSParser.tokenNames; }
    public String getGrammarFileName() { return "PsiInternalLatteCSS.g"; }



    	protected LatteCSSGrammarAccess grammarAccess;

    	protected LatteCSSElementTypeProvider elementTypeProvider;

    	public PsiInternalLatteCSSParser(PsiBuilder builder, TokenStream input, LatteCSSElementTypeProvider elementTypeProvider, LatteCSSGrammarAccess grammarAccess) {
    		this(input);
    		setPsiBuilder(builder);
        	this.grammarAccess = grammarAccess;
    		this.elementTypeProvider = elementTypeProvider;
    	}

    	@Override
    	protected String getFirstRuleName() {
    		return "CSS";
    	}




    // $ANTLR start "entryRuleCSS"
    // PsiInternalLatteCSS.g:52:1: entryRuleCSS : ruleCSS EOF ;
    public final void entryRuleCSS() throws RecognitionException {
        try {
            // PsiInternalLatteCSS.g:52:13: ( ruleCSS EOF )
            // PsiInternalLatteCSS.g:53:2: ruleCSS EOF
            {
             markComposite(elementTypeProvider.getCSSElementType()); 
            pushFollow(FOLLOW_1);
            ruleCSS();

            state._fsp--;

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
    // PsiInternalLatteCSS.g:58:1: ruleCSS : ( (lv_definitions_0_0= ruleDefinition ) )+ ;
    public final void ruleCSS() throws RecognitionException {
        try {
            // PsiInternalLatteCSS.g:58:8: ( ( (lv_definitions_0_0= ruleDefinition ) )+ )
            // PsiInternalLatteCSS.g:59:2: ( (lv_definitions_0_0= ruleDefinition ) )+
            {
            // PsiInternalLatteCSS.g:59:2: ( (lv_definitions_0_0= ruleDefinition ) )+
            int cnt1=0;
            loop1:
            do {
                int alt1=2;
                int LA1_0 = input.LA(1);

                if ( (LA1_0==RULE_ID||(LA1_0>=16 && LA1_0<=17)) ) {
                    alt1=1;
                }


                switch (alt1) {
            	case 1 :
            	    // PsiInternalLatteCSS.g:60:3: (lv_definitions_0_0= ruleDefinition )
            	    {
            	    // PsiInternalLatteCSS.g:60:3: (lv_definitions_0_0= ruleDefinition )
            	    // PsiInternalLatteCSS.g:61:4: lv_definitions_0_0= ruleDefinition
            	    {

            	    				markComposite(elementTypeProvider.getCSS_DefinitionsDefinitionParserRuleCall_0ElementType());
            	    			
            	    pushFollow(FOLLOW_3);
            	    ruleDefinition();

            	    state._fsp--;


            	    				doneComposite();
            	    			

            	    }


            	    }
            	    break;

            	default :
            	    if ( cnt1 >= 1 ) break loop1;
                        EarlyExitException eee =
                            new EarlyExitException(1, input);
                        throw eee;
                }
                cnt1++;
            } while (true);


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
    // $ANTLR end "ruleCSS"


    // $ANTLR start "entryRuleDefinition"
    // PsiInternalLatteCSS.g:73:1: entryRuleDefinition : ruleDefinition EOF ;
    public final void entryRuleDefinition() throws RecognitionException {
        try {
            // PsiInternalLatteCSS.g:73:20: ( ruleDefinition EOF )
            // PsiInternalLatteCSS.g:74:2: ruleDefinition EOF
            {
             markComposite(elementTypeProvider.getDefinitionElementType()); 
            pushFollow(FOLLOW_1);
            ruleDefinition();

            state._fsp--;

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
    // PsiInternalLatteCSS.g:79:1: ruleDefinition : ( ( (lv_selector_0_0= ruleSelector ) ) (otherlv_1= ',' ( (lv_selector_2_0= ruleSelector ) ) )* otherlv_3= '{' ( (lv_properties_4_0= ruleCSSProperty ) )+ otherlv_5= '}' ) ;
    public final void ruleDefinition() throws RecognitionException {
        Token otherlv_1=null;
        Token otherlv_3=null;
        Token otherlv_5=null;

        try {
            // PsiInternalLatteCSS.g:79:15: ( ( ( (lv_selector_0_0= ruleSelector ) ) (otherlv_1= ',' ( (lv_selector_2_0= ruleSelector ) ) )* otherlv_3= '{' ( (lv_properties_4_0= ruleCSSProperty ) )+ otherlv_5= '}' ) )
            // PsiInternalLatteCSS.g:80:2: ( ( (lv_selector_0_0= ruleSelector ) ) (otherlv_1= ',' ( (lv_selector_2_0= ruleSelector ) ) )* otherlv_3= '{' ( (lv_properties_4_0= ruleCSSProperty ) )+ otherlv_5= '}' )
            {
            // PsiInternalLatteCSS.g:80:2: ( ( (lv_selector_0_0= ruleSelector ) ) (otherlv_1= ',' ( (lv_selector_2_0= ruleSelector ) ) )* otherlv_3= '{' ( (lv_properties_4_0= ruleCSSProperty ) )+ otherlv_5= '}' )
            // PsiInternalLatteCSS.g:81:3: ( (lv_selector_0_0= ruleSelector ) ) (otherlv_1= ',' ( (lv_selector_2_0= ruleSelector ) ) )* otherlv_3= '{' ( (lv_properties_4_0= ruleCSSProperty ) )+ otherlv_5= '}'
            {
            // PsiInternalLatteCSS.g:81:3: ( (lv_selector_0_0= ruleSelector ) )
            // PsiInternalLatteCSS.g:82:4: (lv_selector_0_0= ruleSelector )
            {
            // PsiInternalLatteCSS.g:82:4: (lv_selector_0_0= ruleSelector )
            // PsiInternalLatteCSS.g:83:5: lv_selector_0_0= ruleSelector
            {

            					markComposite(elementTypeProvider.getDefinition_SelectorSelectorParserRuleCall_0_0ElementType());
            				
            pushFollow(FOLLOW_4);
            ruleSelector();

            state._fsp--;


            					doneComposite();
            				

            }


            }

            // PsiInternalLatteCSS.g:92:3: (otherlv_1= ',' ( (lv_selector_2_0= ruleSelector ) ) )*
            loop2:
            do {
                int alt2=2;
                int LA2_0 = input.LA(1);

                if ( (LA2_0==13) ) {
                    alt2=1;
                }


                switch (alt2) {
            	case 1 :
            	    // PsiInternalLatteCSS.g:93:4: otherlv_1= ',' ( (lv_selector_2_0= ruleSelector ) )
            	    {

            	    				markLeaf(elementTypeProvider.getDefinition_CommaKeyword_1_0ElementType());
            	    			
            	    otherlv_1=(Token)match(input,13,FOLLOW_5); 

            	    				doneLeaf(otherlv_1);
            	    			
            	    // PsiInternalLatteCSS.g:100:4: ( (lv_selector_2_0= ruleSelector ) )
            	    // PsiInternalLatteCSS.g:101:5: (lv_selector_2_0= ruleSelector )
            	    {
            	    // PsiInternalLatteCSS.g:101:5: (lv_selector_2_0= ruleSelector )
            	    // PsiInternalLatteCSS.g:102:6: lv_selector_2_0= ruleSelector
            	    {

            	    						markComposite(elementTypeProvider.getDefinition_SelectorSelectorParserRuleCall_1_1_0ElementType());
            	    					
            	    pushFollow(FOLLOW_4);
            	    ruleSelector();

            	    state._fsp--;


            	    						doneComposite();
            	    					

            	    }


            	    }


            	    }
            	    break;

            	default :
            	    break loop2;
                }
            } while (true);


            			markLeaf(elementTypeProvider.getDefinition_LeftCurlyBracketKeyword_2ElementType());
            		
            otherlv_3=(Token)match(input,14,FOLLOW_6); 

            			doneLeaf(otherlv_3);
            		
            // PsiInternalLatteCSS.g:119:3: ( (lv_properties_4_0= ruleCSSProperty ) )+
            int cnt3=0;
            loop3:
            do {
                int alt3=2;
                int LA3_0 = input.LA(1);

                if ( ((LA3_0>=20 && LA3_0<=21)||(LA3_0>=25 && LA3_0<=61)||LA3_0==65||LA3_0==88||(LA3_0>=107 && LA3_0<=117)) ) {
                    alt3=1;
                }


                switch (alt3) {
            	case 1 :
            	    // PsiInternalLatteCSS.g:120:4: (lv_properties_4_0= ruleCSSProperty )
            	    {
            	    // PsiInternalLatteCSS.g:120:4: (lv_properties_4_0= ruleCSSProperty )
            	    // PsiInternalLatteCSS.g:121:5: lv_properties_4_0= ruleCSSProperty
            	    {

            	    					markComposite(elementTypeProvider.getDefinition_PropertiesCSSPropertyParserRuleCall_3_0ElementType());
            	    				
            	    pushFollow(FOLLOW_7);
            	    ruleCSSProperty();

            	    state._fsp--;


            	    					doneComposite();
            	    				

            	    }


            	    }
            	    break;

            	default :
            	    if ( cnt3 >= 1 ) break loop3;
                        EarlyExitException eee =
                            new EarlyExitException(3, input);
                        throw eee;
                }
                cnt3++;
            } while (true);


            			markLeaf(elementTypeProvider.getDefinition_RightCurlyBracketKeyword_4ElementType());
            		
            otherlv_5=(Token)match(input,15,FOLLOW_2); 

            			doneLeaf(otherlv_5);
            		

            }


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
    // $ANTLR end "ruleDefinition"


    // $ANTLR start "entryRuleSelector"
    // PsiInternalLatteCSS.g:141:1: entryRuleSelector : ruleSelector EOF ;
    public final void entryRuleSelector() throws RecognitionException {
        try {
            // PsiInternalLatteCSS.g:141:18: ( ruleSelector EOF )
            // PsiInternalLatteCSS.g:142:2: ruleSelector EOF
            {
             markComposite(elementTypeProvider.getSelectorElementType()); 
            pushFollow(FOLLOW_1);
            ruleSelector();

            state._fsp--;

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
    // PsiInternalLatteCSS.g:147:1: ruleSelector : ( (lv_simpleSelector_0_0= ruleSimpleSelector ) )+ ;
    public final void ruleSelector() throws RecognitionException {
        try {
            // PsiInternalLatteCSS.g:147:13: ( ( (lv_simpleSelector_0_0= ruleSimpleSelector ) )+ )
            // PsiInternalLatteCSS.g:148:2: ( (lv_simpleSelector_0_0= ruleSimpleSelector ) )+
            {
            // PsiInternalLatteCSS.g:148:2: ( (lv_simpleSelector_0_0= ruleSimpleSelector ) )+
            int cnt4=0;
            loop4:
            do {
                int alt4=2;
                int LA4_0 = input.LA(1);

                if ( (LA4_0==RULE_ID||(LA4_0>=16 && LA4_0<=17)) ) {
                    alt4=1;
                }


                switch (alt4) {
            	case 1 :
            	    // PsiInternalLatteCSS.g:149:3: (lv_simpleSelector_0_0= ruleSimpleSelector )
            	    {
            	    // PsiInternalLatteCSS.g:149:3: (lv_simpleSelector_0_0= ruleSimpleSelector )
            	    // PsiInternalLatteCSS.g:150:4: lv_simpleSelector_0_0= ruleSimpleSelector
            	    {

            	    				markComposite(elementTypeProvider.getSelector_SimpleSelectorSimpleSelectorParserRuleCall_0ElementType());
            	    			
            	    pushFollow(FOLLOW_3);
            	    ruleSimpleSelector();

            	    state._fsp--;


            	    				doneComposite();
            	    			

            	    }


            	    }
            	    break;

            	default :
            	    if ( cnt4 >= 1 ) break loop4;
                        EarlyExitException eee =
                            new EarlyExitException(4, input);
                        throw eee;
                }
                cnt4++;
            } while (true);


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
    // $ANTLR end "ruleSelector"


    // $ANTLR start "entryRuleSimpleSelector"
    // PsiInternalLatteCSS.g:162:1: entryRuleSimpleSelector : ruleSimpleSelector EOF ;
    public final void entryRuleSimpleSelector() throws RecognitionException {
        try {
            // PsiInternalLatteCSS.g:162:24: ( ruleSimpleSelector EOF )
            // PsiInternalLatteCSS.g:163:2: ruleSimpleSelector EOF
            {
             markComposite(elementTypeProvider.getSimpleSelectorElementType()); 
            pushFollow(FOLLOW_1);
            ruleSimpleSelector();

            state._fsp--;

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
    // PsiInternalLatteCSS.g:168:1: ruleSimpleSelector : ( ( (lv_element_0_0= RULE_ID ) ) | ( ( (lv_id_1_0= ruleIdSelector ) ) ( (lv_pseudoClass_2_0= rulePseudoClassSelector ) )? ) | ( ( (lv_class_3_0= ruleClassSelector ) ) ( (lv_pseudoClass_4_0= rulePseudoClassSelector ) )? ) ) ;
    public final void ruleSimpleSelector() throws RecognitionException {
        Token lv_element_0_0=null;

        try {
            // PsiInternalLatteCSS.g:168:19: ( ( ( (lv_element_0_0= RULE_ID ) ) | ( ( (lv_id_1_0= ruleIdSelector ) ) ( (lv_pseudoClass_2_0= rulePseudoClassSelector ) )? ) | ( ( (lv_class_3_0= ruleClassSelector ) ) ( (lv_pseudoClass_4_0= rulePseudoClassSelector ) )? ) ) )
            // PsiInternalLatteCSS.g:169:2: ( ( (lv_element_0_0= RULE_ID ) ) | ( ( (lv_id_1_0= ruleIdSelector ) ) ( (lv_pseudoClass_2_0= rulePseudoClassSelector ) )? ) | ( ( (lv_class_3_0= ruleClassSelector ) ) ( (lv_pseudoClass_4_0= rulePseudoClassSelector ) )? ) )
            {
            // PsiInternalLatteCSS.g:169:2: ( ( (lv_element_0_0= RULE_ID ) ) | ( ( (lv_id_1_0= ruleIdSelector ) ) ( (lv_pseudoClass_2_0= rulePseudoClassSelector ) )? ) | ( ( (lv_class_3_0= ruleClassSelector ) ) ( (lv_pseudoClass_4_0= rulePseudoClassSelector ) )? ) )
            int alt7=3;
            switch ( input.LA(1) ) {
            case RULE_ID:
                {
                alt7=1;
                }
                break;
            case 16:
                {
                alt7=2;
                }
                break;
            case 17:
                {
                alt7=3;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 7, 0, input);

                throw nvae;
            }

            switch (alt7) {
                case 1 :
                    // PsiInternalLatteCSS.g:170:3: ( (lv_element_0_0= RULE_ID ) )
                    {
                    // PsiInternalLatteCSS.g:170:3: ( (lv_element_0_0= RULE_ID ) )
                    // PsiInternalLatteCSS.g:171:4: (lv_element_0_0= RULE_ID )
                    {
                    // PsiInternalLatteCSS.g:171:4: (lv_element_0_0= RULE_ID )
                    // PsiInternalLatteCSS.g:172:5: lv_element_0_0= RULE_ID
                    {

                    					markLeaf(elementTypeProvider.getSimpleSelector_ElementIDTerminalRuleCall_0_0ElementType());
                    				
                    lv_element_0_0=(Token)match(input,RULE_ID,FOLLOW_2); 

                    					doneLeaf(lv_element_0_0);
                    				

                    }


                    }


                    }
                    break;
                case 2 :
                    // PsiInternalLatteCSS.g:182:3: ( ( (lv_id_1_0= ruleIdSelector ) ) ( (lv_pseudoClass_2_0= rulePseudoClassSelector ) )? )
                    {
                    // PsiInternalLatteCSS.g:182:3: ( ( (lv_id_1_0= ruleIdSelector ) ) ( (lv_pseudoClass_2_0= rulePseudoClassSelector ) )? )
                    // PsiInternalLatteCSS.g:183:4: ( (lv_id_1_0= ruleIdSelector ) ) ( (lv_pseudoClass_2_0= rulePseudoClassSelector ) )?
                    {
                    // PsiInternalLatteCSS.g:183:4: ( (lv_id_1_0= ruleIdSelector ) )
                    // PsiInternalLatteCSS.g:184:5: (lv_id_1_0= ruleIdSelector )
                    {
                    // PsiInternalLatteCSS.g:184:5: (lv_id_1_0= ruleIdSelector )
                    // PsiInternalLatteCSS.g:185:6: lv_id_1_0= ruleIdSelector
                    {

                    						markComposite(elementTypeProvider.getSimpleSelector_IdIdSelectorParserRuleCall_1_0_0ElementType());
                    					
                    pushFollow(FOLLOW_8);
                    ruleIdSelector();

                    state._fsp--;


                    						doneComposite();
                    					

                    }


                    }

                    // PsiInternalLatteCSS.g:194:4: ( (lv_pseudoClass_2_0= rulePseudoClassSelector ) )?
                    int alt5=2;
                    int LA5_0 = input.LA(1);

                    if ( (LA5_0==18) ) {
                        alt5=1;
                    }
                    switch (alt5) {
                        case 1 :
                            // PsiInternalLatteCSS.g:195:5: (lv_pseudoClass_2_0= rulePseudoClassSelector )
                            {
                            // PsiInternalLatteCSS.g:195:5: (lv_pseudoClass_2_0= rulePseudoClassSelector )
                            // PsiInternalLatteCSS.g:196:6: lv_pseudoClass_2_0= rulePseudoClassSelector
                            {

                            						markComposite(elementTypeProvider.getSimpleSelector_PseudoClassPseudoClassSelectorParserRuleCall_1_1_0ElementType());
                            					
                            pushFollow(FOLLOW_2);
                            rulePseudoClassSelector();

                            state._fsp--;


                            						doneComposite();
                            					

                            }


                            }
                            break;

                    }


                    }


                    }
                    break;
                case 3 :
                    // PsiInternalLatteCSS.g:207:3: ( ( (lv_class_3_0= ruleClassSelector ) ) ( (lv_pseudoClass_4_0= rulePseudoClassSelector ) )? )
                    {
                    // PsiInternalLatteCSS.g:207:3: ( ( (lv_class_3_0= ruleClassSelector ) ) ( (lv_pseudoClass_4_0= rulePseudoClassSelector ) )? )
                    // PsiInternalLatteCSS.g:208:4: ( (lv_class_3_0= ruleClassSelector ) ) ( (lv_pseudoClass_4_0= rulePseudoClassSelector ) )?
                    {
                    // PsiInternalLatteCSS.g:208:4: ( (lv_class_3_0= ruleClassSelector ) )
                    // PsiInternalLatteCSS.g:209:5: (lv_class_3_0= ruleClassSelector )
                    {
                    // PsiInternalLatteCSS.g:209:5: (lv_class_3_0= ruleClassSelector )
                    // PsiInternalLatteCSS.g:210:6: lv_class_3_0= ruleClassSelector
                    {

                    						markComposite(elementTypeProvider.getSimpleSelector_ClassClassSelectorParserRuleCall_2_0_0ElementType());
                    					
                    pushFollow(FOLLOW_8);
                    ruleClassSelector();

                    state._fsp--;


                    						doneComposite();
                    					

                    }


                    }

                    // PsiInternalLatteCSS.g:219:4: ( (lv_pseudoClass_4_0= rulePseudoClassSelector ) )?
                    int alt6=2;
                    int LA6_0 = input.LA(1);

                    if ( (LA6_0==18) ) {
                        alt6=1;
                    }
                    switch (alt6) {
                        case 1 :
                            // PsiInternalLatteCSS.g:220:5: (lv_pseudoClass_4_0= rulePseudoClassSelector )
                            {
                            // PsiInternalLatteCSS.g:220:5: (lv_pseudoClass_4_0= rulePseudoClassSelector )
                            // PsiInternalLatteCSS.g:221:6: lv_pseudoClass_4_0= rulePseudoClassSelector
                            {

                            						markComposite(elementTypeProvider.getSimpleSelector_PseudoClassPseudoClassSelectorParserRuleCall_2_1_0ElementType());
                            					
                            pushFollow(FOLLOW_2);
                            rulePseudoClassSelector();

                            state._fsp--;


                            						doneComposite();
                            					

                            }


                            }
                            break;

                    }


                    }


                    }
                    break;

            }


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
    // $ANTLR end "ruleSimpleSelector"


    // $ANTLR start "entryRuleIdSelector"
    // PsiInternalLatteCSS.g:235:1: entryRuleIdSelector : ruleIdSelector EOF ;
    public final void entryRuleIdSelector() throws RecognitionException {
        try {
            // PsiInternalLatteCSS.g:235:20: ( ruleIdSelector EOF )
            // PsiInternalLatteCSS.g:236:2: ruleIdSelector EOF
            {
             markComposite(elementTypeProvider.getIdSelectorElementType()); 
            pushFollow(FOLLOW_1);
            ruleIdSelector();

            state._fsp--;

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
    // PsiInternalLatteCSS.g:241:1: ruleIdSelector : (otherlv_0= '#' ( (lv_id_1_0= RULE_ID ) ) ) ;
    public final void ruleIdSelector() throws RecognitionException {
        Token otherlv_0=null;
        Token lv_id_1_0=null;

        try {
            // PsiInternalLatteCSS.g:241:15: ( (otherlv_0= '#' ( (lv_id_1_0= RULE_ID ) ) ) )
            // PsiInternalLatteCSS.g:242:2: (otherlv_0= '#' ( (lv_id_1_0= RULE_ID ) ) )
            {
            // PsiInternalLatteCSS.g:242:2: (otherlv_0= '#' ( (lv_id_1_0= RULE_ID ) ) )
            // PsiInternalLatteCSS.g:243:3: otherlv_0= '#' ( (lv_id_1_0= RULE_ID ) )
            {

            			markLeaf(elementTypeProvider.getIdSelector_NumberSignKeyword_0ElementType());
            		
            otherlv_0=(Token)match(input,16,FOLLOW_9); 

            			doneLeaf(otherlv_0);
            		
            // PsiInternalLatteCSS.g:250:3: ( (lv_id_1_0= RULE_ID ) )
            // PsiInternalLatteCSS.g:251:4: (lv_id_1_0= RULE_ID )
            {
            // PsiInternalLatteCSS.g:251:4: (lv_id_1_0= RULE_ID )
            // PsiInternalLatteCSS.g:252:5: lv_id_1_0= RULE_ID
            {

            					markLeaf(elementTypeProvider.getIdSelector_IdIDTerminalRuleCall_1_0ElementType());
            				
            lv_id_1_0=(Token)match(input,RULE_ID,FOLLOW_2); 

            					doneLeaf(lv_id_1_0);
            				

            }


            }


            }


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
    // $ANTLR end "ruleIdSelector"


    // $ANTLR start "entryRuleClassSelector"
    // PsiInternalLatteCSS.g:265:1: entryRuleClassSelector : ruleClassSelector EOF ;
    public final void entryRuleClassSelector() throws RecognitionException {
        try {
            // PsiInternalLatteCSS.g:265:23: ( ruleClassSelector EOF )
            // PsiInternalLatteCSS.g:266:2: ruleClassSelector EOF
            {
             markComposite(elementTypeProvider.getClassSelectorElementType()); 
            pushFollow(FOLLOW_1);
            ruleClassSelector();

            state._fsp--;

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
    // PsiInternalLatteCSS.g:271:1: ruleClassSelector : (otherlv_0= '.' ( (lv_class_1_0= RULE_ID ) ) ) ;
    public final void ruleClassSelector() throws RecognitionException {
        Token otherlv_0=null;
        Token lv_class_1_0=null;

        try {
            // PsiInternalLatteCSS.g:271:18: ( (otherlv_0= '.' ( (lv_class_1_0= RULE_ID ) ) ) )
            // PsiInternalLatteCSS.g:272:2: (otherlv_0= '.' ( (lv_class_1_0= RULE_ID ) ) )
            {
            // PsiInternalLatteCSS.g:272:2: (otherlv_0= '.' ( (lv_class_1_0= RULE_ID ) ) )
            // PsiInternalLatteCSS.g:273:3: otherlv_0= '.' ( (lv_class_1_0= RULE_ID ) )
            {

            			markLeaf(elementTypeProvider.getClassSelector_FullStopKeyword_0ElementType());
            		
            otherlv_0=(Token)match(input,17,FOLLOW_9); 

            			doneLeaf(otherlv_0);
            		
            // PsiInternalLatteCSS.g:280:3: ( (lv_class_1_0= RULE_ID ) )
            // PsiInternalLatteCSS.g:281:4: (lv_class_1_0= RULE_ID )
            {
            // PsiInternalLatteCSS.g:281:4: (lv_class_1_0= RULE_ID )
            // PsiInternalLatteCSS.g:282:5: lv_class_1_0= RULE_ID
            {

            					markLeaf(elementTypeProvider.getClassSelector_ClassIDTerminalRuleCall_1_0ElementType());
            				
            lv_class_1_0=(Token)match(input,RULE_ID,FOLLOW_2); 

            					doneLeaf(lv_class_1_0);
            				

            }


            }


            }


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
    // $ANTLR end "ruleClassSelector"


    // $ANTLR start "entryRulePseudoClassSelector"
    // PsiInternalLatteCSS.g:295:1: entryRulePseudoClassSelector : rulePseudoClassSelector EOF ;
    public final void entryRulePseudoClassSelector() throws RecognitionException {
        try {
            // PsiInternalLatteCSS.g:295:29: ( rulePseudoClassSelector EOF )
            // PsiInternalLatteCSS.g:296:2: rulePseudoClassSelector EOF
            {
             markComposite(elementTypeProvider.getPseudoClassSelectorElementType()); 
            pushFollow(FOLLOW_1);
            rulePseudoClassSelector();

            state._fsp--;

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
    // PsiInternalLatteCSS.g:301:1: rulePseudoClassSelector : (otherlv_0= ':' ( (lv_value_1_0= RULE_ID ) ) ) ;
    public final void rulePseudoClassSelector() throws RecognitionException {
        Token otherlv_0=null;
        Token lv_value_1_0=null;

        try {
            // PsiInternalLatteCSS.g:301:24: ( (otherlv_0= ':' ( (lv_value_1_0= RULE_ID ) ) ) )
            // PsiInternalLatteCSS.g:302:2: (otherlv_0= ':' ( (lv_value_1_0= RULE_ID ) ) )
            {
            // PsiInternalLatteCSS.g:302:2: (otherlv_0= ':' ( (lv_value_1_0= RULE_ID ) ) )
            // PsiInternalLatteCSS.g:303:3: otherlv_0= ':' ( (lv_value_1_0= RULE_ID ) )
            {

            			markLeaf(elementTypeProvider.getPseudoClassSelector_ColonKeyword_0ElementType());
            		
            otherlv_0=(Token)match(input,18,FOLLOW_9); 

            			doneLeaf(otherlv_0);
            		
            // PsiInternalLatteCSS.g:310:3: ( (lv_value_1_0= RULE_ID ) )
            // PsiInternalLatteCSS.g:311:4: (lv_value_1_0= RULE_ID )
            {
            // PsiInternalLatteCSS.g:311:4: (lv_value_1_0= RULE_ID )
            // PsiInternalLatteCSS.g:312:5: lv_value_1_0= RULE_ID
            {

            					markLeaf(elementTypeProvider.getPseudoClassSelector_ValueIDTerminalRuleCall_1_0ElementType());
            				
            lv_value_1_0=(Token)match(input,RULE_ID,FOLLOW_2); 

            					doneLeaf(lv_value_1_0);
            				

            }


            }


            }


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
    // $ANTLR end "rulePseudoClassSelector"


    // $ANTLR start "entryRuleCSSProperty"
    // PsiInternalLatteCSS.g:325:1: entryRuleCSSProperty : ruleCSSProperty EOF ;
    public final void entryRuleCSSProperty() throws RecognitionException {
        try {
            // PsiInternalLatteCSS.g:325:21: ( ruleCSSProperty EOF )
            // PsiInternalLatteCSS.g:326:2: ruleCSSProperty EOF
            {
             markComposite(elementTypeProvider.getCSSPropertyElementType()); 
            pushFollow(FOLLOW_1);
            ruleCSSProperty();

            state._fsp--;

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
    // PsiInternalLatteCSS.g:331:1: ruleCSSProperty : ( ( ruleTransitionProperty | ruleFontFamilyProperty | ruleFontStyleProperty | ruleSizeProperty | ruleShorthandSizeProperty | ruleShorthandColorProperty | ruleBorderRadiusProperty | ruleViewSizeProperty | rulePaintProperty | ruleColorProperty | ruleDrawableProperty | ruleBackgroundRepeatProperty | ruleBackgroundFilterTypeProperty | ruleBackgroundGravityProperty | ruleBackgroundFilterProperty | ruleBorderProperty | ruleAlignmentProperty ) otherlv_17= ';' ) ;
    public final void ruleCSSProperty() throws RecognitionException {
        Token otherlv_17=null;

        try {
            // PsiInternalLatteCSS.g:331:16: ( ( ( ruleTransitionProperty | ruleFontFamilyProperty | ruleFontStyleProperty | ruleSizeProperty | ruleShorthandSizeProperty | ruleShorthandColorProperty | ruleBorderRadiusProperty | ruleViewSizeProperty | rulePaintProperty | ruleColorProperty | ruleDrawableProperty | ruleBackgroundRepeatProperty | ruleBackgroundFilterTypeProperty | ruleBackgroundGravityProperty | ruleBackgroundFilterProperty | ruleBorderProperty | ruleAlignmentProperty ) otherlv_17= ';' ) )
            // PsiInternalLatteCSS.g:332:2: ( ( ruleTransitionProperty | ruleFontFamilyProperty | ruleFontStyleProperty | ruleSizeProperty | ruleShorthandSizeProperty | ruleShorthandColorProperty | ruleBorderRadiusProperty | ruleViewSizeProperty | rulePaintProperty | ruleColorProperty | ruleDrawableProperty | ruleBackgroundRepeatProperty | ruleBackgroundFilterTypeProperty | ruleBackgroundGravityProperty | ruleBackgroundFilterProperty | ruleBorderProperty | ruleAlignmentProperty ) otherlv_17= ';' )
            {
            // PsiInternalLatteCSS.g:332:2: ( ( ruleTransitionProperty | ruleFontFamilyProperty | ruleFontStyleProperty | ruleSizeProperty | ruleShorthandSizeProperty | ruleShorthandColorProperty | ruleBorderRadiusProperty | ruleViewSizeProperty | rulePaintProperty | ruleColorProperty | ruleDrawableProperty | ruleBackgroundRepeatProperty | ruleBackgroundFilterTypeProperty | ruleBackgroundGravityProperty | ruleBackgroundFilterProperty | ruleBorderProperty | ruleAlignmentProperty ) otherlv_17= ';' )
            // PsiInternalLatteCSS.g:333:3: ( ruleTransitionProperty | ruleFontFamilyProperty | ruleFontStyleProperty | ruleSizeProperty | ruleShorthandSizeProperty | ruleShorthandColorProperty | ruleBorderRadiusProperty | ruleViewSizeProperty | rulePaintProperty | ruleColorProperty | ruleDrawableProperty | ruleBackgroundRepeatProperty | ruleBackgroundFilterTypeProperty | ruleBackgroundGravityProperty | ruleBackgroundFilterProperty | ruleBorderProperty | ruleAlignmentProperty ) otherlv_17= ';'
            {
            // PsiInternalLatteCSS.g:333:3: ( ruleTransitionProperty | ruleFontFamilyProperty | ruleFontStyleProperty | ruleSizeProperty | ruleShorthandSizeProperty | ruleShorthandColorProperty | ruleBorderRadiusProperty | ruleViewSizeProperty | rulePaintProperty | ruleColorProperty | ruleDrawableProperty | ruleBackgroundRepeatProperty | ruleBackgroundFilterTypeProperty | ruleBackgroundGravityProperty | ruleBackgroundFilterProperty | ruleBorderProperty | ruleAlignmentProperty )
            int alt8=17;
            switch ( input.LA(1) ) {
            case 54:
                {
                alt8=1;
                }
                break;
            case 20:
                {
                alt8=2;
                }
                break;
            case 21:
                {
                alt8=3;
                }
                break;
            case 35:
            case 36:
            case 37:
            case 38:
            case 39:
            case 40:
            case 41:
            case 42:
            case 43:
            case 44:
            case 45:
            case 46:
            case 47:
            case 48:
            case 49:
            case 50:
            case 51:
            case 52:
                {
                alt8=4;
                }
                break;
            case 27:
            case 28:
            case 29:
            case 30:
                {
                alt8=5;
                }
                break;
            case 108:
                {
                alt8=6;
                }
                break;
            case 31:
            case 32:
            case 33:
            case 34:
                {
                alt8=7;
                }
                break;
            case 25:
            case 26:
                {
                alt8=8;
                }
                break;
            case 53:
                {
                alt8=9;
                }
                break;
            case 109:
            case 110:
            case 111:
            case 112:
            case 113:
            case 114:
            case 115:
            case 116:
                {
                alt8=10;
                }
                break;
            case 55:
                {
                alt8=11;
                }
                break;
            case 56:
                {
                alt8=12;
                }
                break;
            case 107:
                {
                alt8=13;
                }
                break;
            case 88:
                {
                alt8=14;
                }
                break;
            case 65:
                {
                alt8=15;
                }
                break;
            case 57:
            case 58:
            case 59:
            case 60:
            case 61:
                {
                alt8=16;
                }
                break;
            case 117:
                {
                alt8=17;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 8, 0, input);

                throw nvae;
            }

            switch (alt8) {
                case 1 :
                    // PsiInternalLatteCSS.g:334:4: ruleTransitionProperty
                    {

                    				markComposite(elementTypeProvider.getCSSProperty_TransitionPropertyParserRuleCall_0_0ElementType());
                    			
                    pushFollow(FOLLOW_10);
                    ruleTransitionProperty();

                    state._fsp--;


                    				doneComposite();
                    			

                    }
                    break;
                case 2 :
                    // PsiInternalLatteCSS.g:342:4: ruleFontFamilyProperty
                    {

                    				markComposite(elementTypeProvider.getCSSProperty_FontFamilyPropertyParserRuleCall_0_1ElementType());
                    			
                    pushFollow(FOLLOW_10);
                    ruleFontFamilyProperty();

                    state._fsp--;


                    				doneComposite();
                    			

                    }
                    break;
                case 3 :
                    // PsiInternalLatteCSS.g:350:4: ruleFontStyleProperty
                    {

                    				markComposite(elementTypeProvider.getCSSProperty_FontStylePropertyParserRuleCall_0_2ElementType());
                    			
                    pushFollow(FOLLOW_10);
                    ruleFontStyleProperty();

                    state._fsp--;


                    				doneComposite();
                    			

                    }
                    break;
                case 4 :
                    // PsiInternalLatteCSS.g:358:4: ruleSizeProperty
                    {

                    				markComposite(elementTypeProvider.getCSSProperty_SizePropertyParserRuleCall_0_3ElementType());
                    			
                    pushFollow(FOLLOW_10);
                    ruleSizeProperty();

                    state._fsp--;


                    				doneComposite();
                    			

                    }
                    break;
                case 5 :
                    // PsiInternalLatteCSS.g:366:4: ruleShorthandSizeProperty
                    {

                    				markComposite(elementTypeProvider.getCSSProperty_ShorthandSizePropertyParserRuleCall_0_4ElementType());
                    			
                    pushFollow(FOLLOW_10);
                    ruleShorthandSizeProperty();

                    state._fsp--;


                    				doneComposite();
                    			

                    }
                    break;
                case 6 :
                    // PsiInternalLatteCSS.g:374:4: ruleShorthandColorProperty
                    {

                    				markComposite(elementTypeProvider.getCSSProperty_ShorthandColorPropertyParserRuleCall_0_5ElementType());
                    			
                    pushFollow(FOLLOW_10);
                    ruleShorthandColorProperty();

                    state._fsp--;


                    				doneComposite();
                    			

                    }
                    break;
                case 7 :
                    // PsiInternalLatteCSS.g:382:4: ruleBorderRadiusProperty
                    {

                    				markComposite(elementTypeProvider.getCSSProperty_BorderRadiusPropertyParserRuleCall_0_6ElementType());
                    			
                    pushFollow(FOLLOW_10);
                    ruleBorderRadiusProperty();

                    state._fsp--;


                    				doneComposite();
                    			

                    }
                    break;
                case 8 :
                    // PsiInternalLatteCSS.g:390:4: ruleViewSizeProperty
                    {

                    				markComposite(elementTypeProvider.getCSSProperty_ViewSizePropertyParserRuleCall_0_7ElementType());
                    			
                    pushFollow(FOLLOW_10);
                    ruleViewSizeProperty();

                    state._fsp--;


                    				doneComposite();
                    			

                    }
                    break;
                case 9 :
                    // PsiInternalLatteCSS.g:398:4: rulePaintProperty
                    {

                    				markComposite(elementTypeProvider.getCSSProperty_PaintPropertyParserRuleCall_0_8ElementType());
                    			
                    pushFollow(FOLLOW_10);
                    rulePaintProperty();

                    state._fsp--;


                    				doneComposite();
                    			

                    }
                    break;
                case 10 :
                    // PsiInternalLatteCSS.g:406:4: ruleColorProperty
                    {

                    				markComposite(elementTypeProvider.getCSSProperty_ColorPropertyParserRuleCall_0_9ElementType());
                    			
                    pushFollow(FOLLOW_10);
                    ruleColorProperty();

                    state._fsp--;


                    				doneComposite();
                    			

                    }
                    break;
                case 11 :
                    // PsiInternalLatteCSS.g:414:4: ruleDrawableProperty
                    {

                    				markComposite(elementTypeProvider.getCSSProperty_DrawablePropertyParserRuleCall_0_10ElementType());
                    			
                    pushFollow(FOLLOW_10);
                    ruleDrawableProperty();

                    state._fsp--;


                    				doneComposite();
                    			

                    }
                    break;
                case 12 :
                    // PsiInternalLatteCSS.g:422:4: ruleBackgroundRepeatProperty
                    {

                    				markComposite(elementTypeProvider.getCSSProperty_BackgroundRepeatPropertyParserRuleCall_0_11ElementType());
                    			
                    pushFollow(FOLLOW_10);
                    ruleBackgroundRepeatProperty();

                    state._fsp--;


                    				doneComposite();
                    			

                    }
                    break;
                case 13 :
                    // PsiInternalLatteCSS.g:430:4: ruleBackgroundFilterTypeProperty
                    {

                    				markComposite(elementTypeProvider.getCSSProperty_BackgroundFilterTypePropertyParserRuleCall_0_12ElementType());
                    			
                    pushFollow(FOLLOW_10);
                    ruleBackgroundFilterTypeProperty();

                    state._fsp--;


                    				doneComposite();
                    			

                    }
                    break;
                case 14 :
                    // PsiInternalLatteCSS.g:438:4: ruleBackgroundGravityProperty
                    {

                    				markComposite(elementTypeProvider.getCSSProperty_BackgroundGravityPropertyParserRuleCall_0_13ElementType());
                    			
                    pushFollow(FOLLOW_10);
                    ruleBackgroundGravityProperty();

                    state._fsp--;


                    				doneComposite();
                    			

                    }
                    break;
                case 15 :
                    // PsiInternalLatteCSS.g:446:4: ruleBackgroundFilterProperty
                    {

                    				markComposite(elementTypeProvider.getCSSProperty_BackgroundFilterPropertyParserRuleCall_0_14ElementType());
                    			
                    pushFollow(FOLLOW_10);
                    ruleBackgroundFilterProperty();

                    state._fsp--;


                    				doneComposite();
                    			

                    }
                    break;
                case 16 :
                    // PsiInternalLatteCSS.g:454:4: ruleBorderProperty
                    {

                    				markComposite(elementTypeProvider.getCSSProperty_BorderPropertyParserRuleCall_0_15ElementType());
                    			
                    pushFollow(FOLLOW_10);
                    ruleBorderProperty();

                    state._fsp--;


                    				doneComposite();
                    			

                    }
                    break;
                case 17 :
                    // PsiInternalLatteCSS.g:462:4: ruleAlignmentProperty
                    {

                    				markComposite(elementTypeProvider.getCSSProperty_AlignmentPropertyParserRuleCall_0_16ElementType());
                    			
                    pushFollow(FOLLOW_10);
                    ruleAlignmentProperty();

                    state._fsp--;


                    				doneComposite();
                    			

                    }
                    break;

            }


            			markLeaf(elementTypeProvider.getCSSProperty_SemicolonKeyword_1ElementType());
            		
            otherlv_17=(Token)match(input,19,FOLLOW_2); 

            			doneLeaf(otherlv_17);
            		

            }


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
    // $ANTLR end "ruleCSSProperty"


    // $ANTLR start "entryRuleFontFamilyProperty"
    // PsiInternalLatteCSS.g:481:1: entryRuleFontFamilyProperty : ruleFontFamilyProperty EOF ;
    public final void entryRuleFontFamilyProperty() throws RecognitionException {
        try {
            // PsiInternalLatteCSS.g:481:28: ( ruleFontFamilyProperty EOF )
            // PsiInternalLatteCSS.g:482:2: ruleFontFamilyProperty EOF
            {
             markComposite(elementTypeProvider.getFontFamilyPropertyElementType()); 
            pushFollow(FOLLOW_1);
            ruleFontFamilyProperty();

            state._fsp--;

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
    // PsiInternalLatteCSS.g:487:1: ruleFontFamilyProperty : ( ( (lv_property_0_0= 'font-family' ) ) otherlv_1= ':' ( (lv_value_2_0= RULE_STRING ) ) ) ;
    public final void ruleFontFamilyProperty() throws RecognitionException {
        Token lv_property_0_0=null;
        Token otherlv_1=null;
        Token lv_value_2_0=null;

        try {
            // PsiInternalLatteCSS.g:487:23: ( ( ( (lv_property_0_0= 'font-family' ) ) otherlv_1= ':' ( (lv_value_2_0= RULE_STRING ) ) ) )
            // PsiInternalLatteCSS.g:488:2: ( ( (lv_property_0_0= 'font-family' ) ) otherlv_1= ':' ( (lv_value_2_0= RULE_STRING ) ) )
            {
            // PsiInternalLatteCSS.g:488:2: ( ( (lv_property_0_0= 'font-family' ) ) otherlv_1= ':' ( (lv_value_2_0= RULE_STRING ) ) )
            // PsiInternalLatteCSS.g:489:3: ( (lv_property_0_0= 'font-family' ) ) otherlv_1= ':' ( (lv_value_2_0= RULE_STRING ) )
            {
            // PsiInternalLatteCSS.g:489:3: ( (lv_property_0_0= 'font-family' ) )
            // PsiInternalLatteCSS.g:490:4: (lv_property_0_0= 'font-family' )
            {
            // PsiInternalLatteCSS.g:490:4: (lv_property_0_0= 'font-family' )
            // PsiInternalLatteCSS.g:491:5: lv_property_0_0= 'font-family'
            {

            					markLeaf(elementTypeProvider.getFontFamilyProperty_PropertyFontFamilyKeyword_0_0ElementType());
            				
            lv_property_0_0=(Token)match(input,20,FOLLOW_11); 

            					doneLeaf(lv_property_0_0);
            				

            }


            }


            			markLeaf(elementTypeProvider.getFontFamilyProperty_ColonKeyword_1ElementType());
            		
            otherlv_1=(Token)match(input,18,FOLLOW_12); 

            			doneLeaf(otherlv_1);
            		
            // PsiInternalLatteCSS.g:507:3: ( (lv_value_2_0= RULE_STRING ) )
            // PsiInternalLatteCSS.g:508:4: (lv_value_2_0= RULE_STRING )
            {
            // PsiInternalLatteCSS.g:508:4: (lv_value_2_0= RULE_STRING )
            // PsiInternalLatteCSS.g:509:5: lv_value_2_0= RULE_STRING
            {

            					markLeaf(elementTypeProvider.getFontFamilyProperty_ValueSTRINGTerminalRuleCall_2_0ElementType());
            				
            lv_value_2_0=(Token)match(input,RULE_STRING,FOLLOW_2); 

            					doneLeaf(lv_value_2_0);
            				

            }


            }


            }


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
    // $ANTLR end "ruleFontFamilyProperty"


    // $ANTLR start "entryRuleFontStyleProperty"
    // PsiInternalLatteCSS.g:522:1: entryRuleFontStyleProperty : ruleFontStyleProperty EOF ;
    public final void entryRuleFontStyleProperty() throws RecognitionException {
        try {
            // PsiInternalLatteCSS.g:522:27: ( ruleFontStyleProperty EOF )
            // PsiInternalLatteCSS.g:523:2: ruleFontStyleProperty EOF
            {
             markComposite(elementTypeProvider.getFontStylePropertyElementType()); 
            pushFollow(FOLLOW_1);
            ruleFontStyleProperty();

            state._fsp--;

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
    // PsiInternalLatteCSS.g:528:1: ruleFontStyleProperty : ( ( (lv_property_0_0= 'font-style' ) ) otherlv_1= ':' ( ( (lv_value_2_1= 'normal' | lv_value_2_2= 'bold' | lv_value_2_3= 'bold-italic' ) ) ) ) ;
    public final void ruleFontStyleProperty() throws RecognitionException {
        Token lv_property_0_0=null;
        Token otherlv_1=null;
        Token lv_value_2_1=null;
        Token lv_value_2_2=null;
        Token lv_value_2_3=null;

        try {
            // PsiInternalLatteCSS.g:528:22: ( ( ( (lv_property_0_0= 'font-style' ) ) otherlv_1= ':' ( ( (lv_value_2_1= 'normal' | lv_value_2_2= 'bold' | lv_value_2_3= 'bold-italic' ) ) ) ) )
            // PsiInternalLatteCSS.g:529:2: ( ( (lv_property_0_0= 'font-style' ) ) otherlv_1= ':' ( ( (lv_value_2_1= 'normal' | lv_value_2_2= 'bold' | lv_value_2_3= 'bold-italic' ) ) ) )
            {
            // PsiInternalLatteCSS.g:529:2: ( ( (lv_property_0_0= 'font-style' ) ) otherlv_1= ':' ( ( (lv_value_2_1= 'normal' | lv_value_2_2= 'bold' | lv_value_2_3= 'bold-italic' ) ) ) )
            // PsiInternalLatteCSS.g:530:3: ( (lv_property_0_0= 'font-style' ) ) otherlv_1= ':' ( ( (lv_value_2_1= 'normal' | lv_value_2_2= 'bold' | lv_value_2_3= 'bold-italic' ) ) )
            {
            // PsiInternalLatteCSS.g:530:3: ( (lv_property_0_0= 'font-style' ) )
            // PsiInternalLatteCSS.g:531:4: (lv_property_0_0= 'font-style' )
            {
            // PsiInternalLatteCSS.g:531:4: (lv_property_0_0= 'font-style' )
            // PsiInternalLatteCSS.g:532:5: lv_property_0_0= 'font-style'
            {

            					markLeaf(elementTypeProvider.getFontStyleProperty_PropertyFontStyleKeyword_0_0ElementType());
            				
            lv_property_0_0=(Token)match(input,21,FOLLOW_11); 

            					doneLeaf(lv_property_0_0);
            				

            }


            }


            			markLeaf(elementTypeProvider.getFontStyleProperty_ColonKeyword_1ElementType());
            		
            otherlv_1=(Token)match(input,18,FOLLOW_13); 

            			doneLeaf(otherlv_1);
            		
            // PsiInternalLatteCSS.g:548:3: ( ( (lv_value_2_1= 'normal' | lv_value_2_2= 'bold' | lv_value_2_3= 'bold-italic' ) ) )
            // PsiInternalLatteCSS.g:549:4: ( (lv_value_2_1= 'normal' | lv_value_2_2= 'bold' | lv_value_2_3= 'bold-italic' ) )
            {
            // PsiInternalLatteCSS.g:549:4: ( (lv_value_2_1= 'normal' | lv_value_2_2= 'bold' | lv_value_2_3= 'bold-italic' ) )
            // PsiInternalLatteCSS.g:550:5: (lv_value_2_1= 'normal' | lv_value_2_2= 'bold' | lv_value_2_3= 'bold-italic' )
            {
            // PsiInternalLatteCSS.g:550:5: (lv_value_2_1= 'normal' | lv_value_2_2= 'bold' | lv_value_2_3= 'bold-italic' )
            int alt9=3;
            switch ( input.LA(1) ) {
            case 22:
                {
                alt9=1;
                }
                break;
            case 23:
                {
                alt9=2;
                }
                break;
            case 24:
                {
                alt9=3;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 9, 0, input);

                throw nvae;
            }

            switch (alt9) {
                case 1 :
                    // PsiInternalLatteCSS.g:551:6: lv_value_2_1= 'normal'
                    {

                    						markLeaf(elementTypeProvider.getFontStyleProperty_ValueNormalKeyword_2_0_0ElementType());
                    					
                    lv_value_2_1=(Token)match(input,22,FOLLOW_2); 

                    						doneLeaf(lv_value_2_1);
                    					

                    }
                    break;
                case 2 :
                    // PsiInternalLatteCSS.g:559:6: lv_value_2_2= 'bold'
                    {

                    						markLeaf(elementTypeProvider.getFontStyleProperty_ValueBoldKeyword_2_0_1ElementType());
                    					
                    lv_value_2_2=(Token)match(input,23,FOLLOW_2); 

                    						doneLeaf(lv_value_2_2);
                    					

                    }
                    break;
                case 3 :
                    // PsiInternalLatteCSS.g:567:6: lv_value_2_3= 'bold-italic'
                    {

                    						markLeaf(elementTypeProvider.getFontStyleProperty_ValueBoldItalicKeyword_2_0_2ElementType());
                    					
                    lv_value_2_3=(Token)match(input,24,FOLLOW_2); 

                    						doneLeaf(lv_value_2_3);
                    					

                    }
                    break;

            }


            }


            }


            }


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
    // $ANTLR end "ruleFontStyleProperty"


    // $ANTLR start "entryRuleViewSizeProperty"
    // PsiInternalLatteCSS.g:581:1: entryRuleViewSizeProperty : ruleViewSizeProperty EOF ;
    public final void entryRuleViewSizeProperty() throws RecognitionException {
        try {
            // PsiInternalLatteCSS.g:581:26: ( ruleViewSizeProperty EOF )
            // PsiInternalLatteCSS.g:582:2: ruleViewSizeProperty EOF
            {
             markComposite(elementTypeProvider.getViewSizePropertyElementType()); 
            pushFollow(FOLLOW_1);
            ruleViewSizeProperty();

            state._fsp--;

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
    // PsiInternalLatteCSS.g:587:1: ruleViewSizeProperty : ( ( ( (lv_property_0_1= 'width' | lv_property_0_2= 'height' ) ) ) otherlv_1= ':' ( (lv_value_2_0= ruleViewSizeValue ) ) ) ;
    public final void ruleViewSizeProperty() throws RecognitionException {
        Token lv_property_0_1=null;
        Token lv_property_0_2=null;
        Token otherlv_1=null;

        try {
            // PsiInternalLatteCSS.g:587:21: ( ( ( ( (lv_property_0_1= 'width' | lv_property_0_2= 'height' ) ) ) otherlv_1= ':' ( (lv_value_2_0= ruleViewSizeValue ) ) ) )
            // PsiInternalLatteCSS.g:588:2: ( ( ( (lv_property_0_1= 'width' | lv_property_0_2= 'height' ) ) ) otherlv_1= ':' ( (lv_value_2_0= ruleViewSizeValue ) ) )
            {
            // PsiInternalLatteCSS.g:588:2: ( ( ( (lv_property_0_1= 'width' | lv_property_0_2= 'height' ) ) ) otherlv_1= ':' ( (lv_value_2_0= ruleViewSizeValue ) ) )
            // PsiInternalLatteCSS.g:589:3: ( ( (lv_property_0_1= 'width' | lv_property_0_2= 'height' ) ) ) otherlv_1= ':' ( (lv_value_2_0= ruleViewSizeValue ) )
            {
            // PsiInternalLatteCSS.g:589:3: ( ( (lv_property_0_1= 'width' | lv_property_0_2= 'height' ) ) )
            // PsiInternalLatteCSS.g:590:4: ( (lv_property_0_1= 'width' | lv_property_0_2= 'height' ) )
            {
            // PsiInternalLatteCSS.g:590:4: ( (lv_property_0_1= 'width' | lv_property_0_2= 'height' ) )
            // PsiInternalLatteCSS.g:591:5: (lv_property_0_1= 'width' | lv_property_0_2= 'height' )
            {
            // PsiInternalLatteCSS.g:591:5: (lv_property_0_1= 'width' | lv_property_0_2= 'height' )
            int alt10=2;
            int LA10_0 = input.LA(1);

            if ( (LA10_0==25) ) {
                alt10=1;
            }
            else if ( (LA10_0==26) ) {
                alt10=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 10, 0, input);

                throw nvae;
            }
            switch (alt10) {
                case 1 :
                    // PsiInternalLatteCSS.g:592:6: lv_property_0_1= 'width'
                    {

                    						markLeaf(elementTypeProvider.getViewSizeProperty_PropertyWidthKeyword_0_0_0ElementType());
                    					
                    lv_property_0_1=(Token)match(input,25,FOLLOW_11); 

                    						doneLeaf(lv_property_0_1);
                    					

                    }
                    break;
                case 2 :
                    // PsiInternalLatteCSS.g:600:6: lv_property_0_2= 'height'
                    {

                    						markLeaf(elementTypeProvider.getViewSizeProperty_PropertyHeightKeyword_0_0_1ElementType());
                    					
                    lv_property_0_2=(Token)match(input,26,FOLLOW_11); 

                    						doneLeaf(lv_property_0_2);
                    					

                    }
                    break;

            }


            }


            }


            			markLeaf(elementTypeProvider.getViewSizeProperty_ColonKeyword_1ElementType());
            		
            otherlv_1=(Token)match(input,18,FOLLOW_14); 

            			doneLeaf(otherlv_1);
            		
            // PsiInternalLatteCSS.g:617:3: ( (lv_value_2_0= ruleViewSizeValue ) )
            // PsiInternalLatteCSS.g:618:4: (lv_value_2_0= ruleViewSizeValue )
            {
            // PsiInternalLatteCSS.g:618:4: (lv_value_2_0= ruleViewSizeValue )
            // PsiInternalLatteCSS.g:619:5: lv_value_2_0= ruleViewSizeValue
            {

            					markComposite(elementTypeProvider.getViewSizeProperty_ValueViewSizeValueParserRuleCall_2_0ElementType());
            				
            pushFollow(FOLLOW_2);
            ruleViewSizeValue();

            state._fsp--;


            					doneComposite();
            				

            }


            }


            }


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
    // $ANTLR end "ruleViewSizeProperty"


    // $ANTLR start "entryRuleShorthandSizeProperty"
    // PsiInternalLatteCSS.g:632:1: entryRuleShorthandSizeProperty : ruleShorthandSizeProperty EOF ;
    public final void entryRuleShorthandSizeProperty() throws RecognitionException {
        try {
            // PsiInternalLatteCSS.g:632:31: ( ruleShorthandSizeProperty EOF )
            // PsiInternalLatteCSS.g:633:2: ruleShorthandSizeProperty EOF
            {
             markComposite(elementTypeProvider.getShorthandSizePropertyElementType()); 
            pushFollow(FOLLOW_1);
            ruleShorthandSizeProperty();

            state._fsp--;

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
    // PsiInternalLatteCSS.g:638:1: ruleShorthandSizeProperty : ( ( ( (lv_property_0_1= 'border-width' | lv_property_0_2= 'border-radius' | lv_property_0_3= 'margin' | lv_property_0_4= 'padding' ) ) ) otherlv_1= ':' ( (lv_values_2_0= ruleSizeValue ) )+ ) ;
    public final void ruleShorthandSizeProperty() throws RecognitionException {
        Token lv_property_0_1=null;
        Token lv_property_0_2=null;
        Token lv_property_0_3=null;
        Token lv_property_0_4=null;
        Token otherlv_1=null;

        try {
            // PsiInternalLatteCSS.g:638:26: ( ( ( ( (lv_property_0_1= 'border-width' | lv_property_0_2= 'border-radius' | lv_property_0_3= 'margin' | lv_property_0_4= 'padding' ) ) ) otherlv_1= ':' ( (lv_values_2_0= ruleSizeValue ) )+ ) )
            // PsiInternalLatteCSS.g:639:2: ( ( ( (lv_property_0_1= 'border-width' | lv_property_0_2= 'border-radius' | lv_property_0_3= 'margin' | lv_property_0_4= 'padding' ) ) ) otherlv_1= ':' ( (lv_values_2_0= ruleSizeValue ) )+ )
            {
            // PsiInternalLatteCSS.g:639:2: ( ( ( (lv_property_0_1= 'border-width' | lv_property_0_2= 'border-radius' | lv_property_0_3= 'margin' | lv_property_0_4= 'padding' ) ) ) otherlv_1= ':' ( (lv_values_2_0= ruleSizeValue ) )+ )
            // PsiInternalLatteCSS.g:640:3: ( ( (lv_property_0_1= 'border-width' | lv_property_0_2= 'border-radius' | lv_property_0_3= 'margin' | lv_property_0_4= 'padding' ) ) ) otherlv_1= ':' ( (lv_values_2_0= ruleSizeValue ) )+
            {
            // PsiInternalLatteCSS.g:640:3: ( ( (lv_property_0_1= 'border-width' | lv_property_0_2= 'border-radius' | lv_property_0_3= 'margin' | lv_property_0_4= 'padding' ) ) )
            // PsiInternalLatteCSS.g:641:4: ( (lv_property_0_1= 'border-width' | lv_property_0_2= 'border-radius' | lv_property_0_3= 'margin' | lv_property_0_4= 'padding' ) )
            {
            // PsiInternalLatteCSS.g:641:4: ( (lv_property_0_1= 'border-width' | lv_property_0_2= 'border-radius' | lv_property_0_3= 'margin' | lv_property_0_4= 'padding' ) )
            // PsiInternalLatteCSS.g:642:5: (lv_property_0_1= 'border-width' | lv_property_0_2= 'border-radius' | lv_property_0_3= 'margin' | lv_property_0_4= 'padding' )
            {
            // PsiInternalLatteCSS.g:642:5: (lv_property_0_1= 'border-width' | lv_property_0_2= 'border-radius' | lv_property_0_3= 'margin' | lv_property_0_4= 'padding' )
            int alt11=4;
            switch ( input.LA(1) ) {
            case 27:
                {
                alt11=1;
                }
                break;
            case 28:
                {
                alt11=2;
                }
                break;
            case 29:
                {
                alt11=3;
                }
                break;
            case 30:
                {
                alt11=4;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 11, 0, input);

                throw nvae;
            }

            switch (alt11) {
                case 1 :
                    // PsiInternalLatteCSS.g:643:6: lv_property_0_1= 'border-width'
                    {

                    						markLeaf(elementTypeProvider.getShorthandSizeProperty_PropertyBorderWidthKeyword_0_0_0ElementType());
                    					
                    lv_property_0_1=(Token)match(input,27,FOLLOW_11); 

                    						doneLeaf(lv_property_0_1);
                    					

                    }
                    break;
                case 2 :
                    // PsiInternalLatteCSS.g:651:6: lv_property_0_2= 'border-radius'
                    {

                    						markLeaf(elementTypeProvider.getShorthandSizeProperty_PropertyBorderRadiusKeyword_0_0_1ElementType());
                    					
                    lv_property_0_2=(Token)match(input,28,FOLLOW_11); 

                    						doneLeaf(lv_property_0_2);
                    					

                    }
                    break;
                case 3 :
                    // PsiInternalLatteCSS.g:659:6: lv_property_0_3= 'margin'
                    {

                    						markLeaf(elementTypeProvider.getShorthandSizeProperty_PropertyMarginKeyword_0_0_2ElementType());
                    					
                    lv_property_0_3=(Token)match(input,29,FOLLOW_11); 

                    						doneLeaf(lv_property_0_3);
                    					

                    }
                    break;
                case 4 :
                    // PsiInternalLatteCSS.g:667:6: lv_property_0_4= 'padding'
                    {

                    						markLeaf(elementTypeProvider.getShorthandSizeProperty_PropertyPaddingKeyword_0_0_3ElementType());
                    					
                    lv_property_0_4=(Token)match(input,30,FOLLOW_11); 

                    						doneLeaf(lv_property_0_4);
                    					

                    }
                    break;

            }


            }


            }


            			markLeaf(elementTypeProvider.getShorthandSizeProperty_ColonKeyword_1ElementType());
            		
            otherlv_1=(Token)match(input,18,FOLLOW_15); 

            			doneLeaf(otherlv_1);
            		
            // PsiInternalLatteCSS.g:684:3: ( (lv_values_2_0= ruleSizeValue ) )+
            int cnt12=0;
            loop12:
            do {
                int alt12=2;
                int LA12_0 = input.LA(1);

                if ( ((LA12_0>=RULE_INT && LA12_0<=RULE_REAL)) ) {
                    alt12=1;
                }


                switch (alt12) {
            	case 1 :
            	    // PsiInternalLatteCSS.g:685:4: (lv_values_2_0= ruleSizeValue )
            	    {
            	    // PsiInternalLatteCSS.g:685:4: (lv_values_2_0= ruleSizeValue )
            	    // PsiInternalLatteCSS.g:686:5: lv_values_2_0= ruleSizeValue
            	    {

            	    					markComposite(elementTypeProvider.getShorthandSizeProperty_ValuesSizeValueParserRuleCall_2_0ElementType());
            	    				
            	    pushFollow(FOLLOW_16);
            	    ruleSizeValue();

            	    state._fsp--;


            	    					doneComposite();
            	    				

            	    }


            	    }
            	    break;

            	default :
            	    if ( cnt12 >= 1 ) break loop12;
                        EarlyExitException eee =
                            new EarlyExitException(12, input);
                        throw eee;
                }
                cnt12++;
            } while (true);


            }


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
    // $ANTLR end "ruleShorthandSizeProperty"


    // $ANTLR start "entryRuleBorderRadiusProperty"
    // PsiInternalLatteCSS.g:699:1: entryRuleBorderRadiusProperty : ruleBorderRadiusProperty EOF ;
    public final void entryRuleBorderRadiusProperty() throws RecognitionException {
        try {
            // PsiInternalLatteCSS.g:699:30: ( ruleBorderRadiusProperty EOF )
            // PsiInternalLatteCSS.g:700:2: ruleBorderRadiusProperty EOF
            {
             markComposite(elementTypeProvider.getBorderRadiusPropertyElementType()); 
            pushFollow(FOLLOW_1);
            ruleBorderRadiusProperty();

            state._fsp--;

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
    // PsiInternalLatteCSS.g:705:1: ruleBorderRadiusProperty : ( ( ( (lv_property_0_1= 'border-top-left-radius' | lv_property_0_2= 'border-top-right-radius' | lv_property_0_3= 'border-bottom-left-radius' | lv_property_0_4= 'border-bottom-right-radius' ) ) ) otherlv_1= ':' ( (lv_values_2_0= ruleSizeValue ) )+ ) ;
    public final void ruleBorderRadiusProperty() throws RecognitionException {
        Token lv_property_0_1=null;
        Token lv_property_0_2=null;
        Token lv_property_0_3=null;
        Token lv_property_0_4=null;
        Token otherlv_1=null;

        try {
            // PsiInternalLatteCSS.g:705:25: ( ( ( ( (lv_property_0_1= 'border-top-left-radius' | lv_property_0_2= 'border-top-right-radius' | lv_property_0_3= 'border-bottom-left-radius' | lv_property_0_4= 'border-bottom-right-radius' ) ) ) otherlv_1= ':' ( (lv_values_2_0= ruleSizeValue ) )+ ) )
            // PsiInternalLatteCSS.g:706:2: ( ( ( (lv_property_0_1= 'border-top-left-radius' | lv_property_0_2= 'border-top-right-radius' | lv_property_0_3= 'border-bottom-left-radius' | lv_property_0_4= 'border-bottom-right-radius' ) ) ) otherlv_1= ':' ( (lv_values_2_0= ruleSizeValue ) )+ )
            {
            // PsiInternalLatteCSS.g:706:2: ( ( ( (lv_property_0_1= 'border-top-left-radius' | lv_property_0_2= 'border-top-right-radius' | lv_property_0_3= 'border-bottom-left-radius' | lv_property_0_4= 'border-bottom-right-radius' ) ) ) otherlv_1= ':' ( (lv_values_2_0= ruleSizeValue ) )+ )
            // PsiInternalLatteCSS.g:707:3: ( ( (lv_property_0_1= 'border-top-left-radius' | lv_property_0_2= 'border-top-right-radius' | lv_property_0_3= 'border-bottom-left-radius' | lv_property_0_4= 'border-bottom-right-radius' ) ) ) otherlv_1= ':' ( (lv_values_2_0= ruleSizeValue ) )+
            {
            // PsiInternalLatteCSS.g:707:3: ( ( (lv_property_0_1= 'border-top-left-radius' | lv_property_0_2= 'border-top-right-radius' | lv_property_0_3= 'border-bottom-left-radius' | lv_property_0_4= 'border-bottom-right-radius' ) ) )
            // PsiInternalLatteCSS.g:708:4: ( (lv_property_0_1= 'border-top-left-radius' | lv_property_0_2= 'border-top-right-radius' | lv_property_0_3= 'border-bottom-left-radius' | lv_property_0_4= 'border-bottom-right-radius' ) )
            {
            // PsiInternalLatteCSS.g:708:4: ( (lv_property_0_1= 'border-top-left-radius' | lv_property_0_2= 'border-top-right-radius' | lv_property_0_3= 'border-bottom-left-radius' | lv_property_0_4= 'border-bottom-right-radius' ) )
            // PsiInternalLatteCSS.g:709:5: (lv_property_0_1= 'border-top-left-radius' | lv_property_0_2= 'border-top-right-radius' | lv_property_0_3= 'border-bottom-left-radius' | lv_property_0_4= 'border-bottom-right-radius' )
            {
            // PsiInternalLatteCSS.g:709:5: (lv_property_0_1= 'border-top-left-radius' | lv_property_0_2= 'border-top-right-radius' | lv_property_0_3= 'border-bottom-left-radius' | lv_property_0_4= 'border-bottom-right-radius' )
            int alt13=4;
            switch ( input.LA(1) ) {
            case 31:
                {
                alt13=1;
                }
                break;
            case 32:
                {
                alt13=2;
                }
                break;
            case 33:
                {
                alt13=3;
                }
                break;
            case 34:
                {
                alt13=4;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 13, 0, input);

                throw nvae;
            }

            switch (alt13) {
                case 1 :
                    // PsiInternalLatteCSS.g:710:6: lv_property_0_1= 'border-top-left-radius'
                    {

                    						markLeaf(elementTypeProvider.getBorderRadiusProperty_PropertyBorderTopLeftRadiusKeyword_0_0_0ElementType());
                    					
                    lv_property_0_1=(Token)match(input,31,FOLLOW_11); 

                    						doneLeaf(lv_property_0_1);
                    					

                    }
                    break;
                case 2 :
                    // PsiInternalLatteCSS.g:718:6: lv_property_0_2= 'border-top-right-radius'
                    {

                    						markLeaf(elementTypeProvider.getBorderRadiusProperty_PropertyBorderTopRightRadiusKeyword_0_0_1ElementType());
                    					
                    lv_property_0_2=(Token)match(input,32,FOLLOW_11); 

                    						doneLeaf(lv_property_0_2);
                    					

                    }
                    break;
                case 3 :
                    // PsiInternalLatteCSS.g:726:6: lv_property_0_3= 'border-bottom-left-radius'
                    {

                    						markLeaf(elementTypeProvider.getBorderRadiusProperty_PropertyBorderBottomLeftRadiusKeyword_0_0_2ElementType());
                    					
                    lv_property_0_3=(Token)match(input,33,FOLLOW_11); 

                    						doneLeaf(lv_property_0_3);
                    					

                    }
                    break;
                case 4 :
                    // PsiInternalLatteCSS.g:734:6: lv_property_0_4= 'border-bottom-right-radius'
                    {

                    						markLeaf(elementTypeProvider.getBorderRadiusProperty_PropertyBorderBottomRightRadiusKeyword_0_0_3ElementType());
                    					
                    lv_property_0_4=(Token)match(input,34,FOLLOW_11); 

                    						doneLeaf(lv_property_0_4);
                    					

                    }
                    break;

            }


            }


            }


            			markLeaf(elementTypeProvider.getBorderRadiusProperty_ColonKeyword_1ElementType());
            		
            otherlv_1=(Token)match(input,18,FOLLOW_15); 

            			doneLeaf(otherlv_1);
            		
            // PsiInternalLatteCSS.g:751:3: ( (lv_values_2_0= ruleSizeValue ) )+
            int cnt14=0;
            loop14:
            do {
                int alt14=2;
                int LA14_0 = input.LA(1);

                if ( ((LA14_0>=RULE_INT && LA14_0<=RULE_REAL)) ) {
                    alt14=1;
                }


                switch (alt14) {
            	case 1 :
            	    // PsiInternalLatteCSS.g:752:4: (lv_values_2_0= ruleSizeValue )
            	    {
            	    // PsiInternalLatteCSS.g:752:4: (lv_values_2_0= ruleSizeValue )
            	    // PsiInternalLatteCSS.g:753:5: lv_values_2_0= ruleSizeValue
            	    {

            	    					markComposite(elementTypeProvider.getBorderRadiusProperty_ValuesSizeValueParserRuleCall_2_0ElementType());
            	    				
            	    pushFollow(FOLLOW_16);
            	    ruleSizeValue();

            	    state._fsp--;


            	    					doneComposite();
            	    				

            	    }


            	    }
            	    break;

            	default :
            	    if ( cnt14 >= 1 ) break loop14;
                        EarlyExitException eee =
                            new EarlyExitException(14, input);
                        throw eee;
                }
                cnt14++;
            } while (true);


            }


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
    // $ANTLR end "ruleBorderRadiusProperty"


    // $ANTLR start "entryRuleSizeProperty"
    // PsiInternalLatteCSS.g:766:1: entryRuleSizeProperty : ruleSizeProperty EOF ;
    public final void entryRuleSizeProperty() throws RecognitionException {
        try {
            // PsiInternalLatteCSS.g:766:22: ( ruleSizeProperty EOF )
            // PsiInternalLatteCSS.g:767:2: ruleSizeProperty EOF
            {
             markComposite(elementTypeProvider.getSizePropertyElementType()); 
            pushFollow(FOLLOW_1);
            ruleSizeProperty();

            state._fsp--;

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
    // PsiInternalLatteCSS.g:772:1: ruleSizeProperty : ( ( ( (lv_property_0_1= 'border-left-width' | lv_property_0_2= 'border-right-width' | lv_property_0_3= 'border-top-width' | lv_property_0_4= 'border-bottom-width' | lv_property_0_5= 'font-size' | lv_property_0_6= 'translate-x' | lv_property_0_7= 'translate-y' | lv_property_0_8= 'margin-left' | lv_property_0_9= 'margin-right' | lv_property_0_10= 'margin-top' | lv_property_0_11= 'margin-bottom' | lv_property_0_12= 'padding-left' | lv_property_0_13= 'padding-right' | lv_property_0_14= 'padding-top' | lv_property_0_15= 'padding-bottom' | lv_property_0_16= 'x' | lv_property_0_17= 'y' | lv_property_0_18= 'elevation' ) ) ) otherlv_1= ':' ( (lv_value_2_0= ruleSizeValue ) ) ) ;
    public final void ruleSizeProperty() throws RecognitionException {
        Token lv_property_0_1=null;
        Token lv_property_0_2=null;
        Token lv_property_0_3=null;
        Token lv_property_0_4=null;
        Token lv_property_0_5=null;
        Token lv_property_0_6=null;
        Token lv_property_0_7=null;
        Token lv_property_0_8=null;
        Token lv_property_0_9=null;
        Token lv_property_0_10=null;
        Token lv_property_0_11=null;
        Token lv_property_0_12=null;
        Token lv_property_0_13=null;
        Token lv_property_0_14=null;
        Token lv_property_0_15=null;
        Token lv_property_0_16=null;
        Token lv_property_0_17=null;
        Token lv_property_0_18=null;
        Token otherlv_1=null;

        try {
            // PsiInternalLatteCSS.g:772:17: ( ( ( ( (lv_property_0_1= 'border-left-width' | lv_property_0_2= 'border-right-width' | lv_property_0_3= 'border-top-width' | lv_property_0_4= 'border-bottom-width' | lv_property_0_5= 'font-size' | lv_property_0_6= 'translate-x' | lv_property_0_7= 'translate-y' | lv_property_0_8= 'margin-left' | lv_property_0_9= 'margin-right' | lv_property_0_10= 'margin-top' | lv_property_0_11= 'margin-bottom' | lv_property_0_12= 'padding-left' | lv_property_0_13= 'padding-right' | lv_property_0_14= 'padding-top' | lv_property_0_15= 'padding-bottom' | lv_property_0_16= 'x' | lv_property_0_17= 'y' | lv_property_0_18= 'elevation' ) ) ) otherlv_1= ':' ( (lv_value_2_0= ruleSizeValue ) ) ) )
            // PsiInternalLatteCSS.g:773:2: ( ( ( (lv_property_0_1= 'border-left-width' | lv_property_0_2= 'border-right-width' | lv_property_0_3= 'border-top-width' | lv_property_0_4= 'border-bottom-width' | lv_property_0_5= 'font-size' | lv_property_0_6= 'translate-x' | lv_property_0_7= 'translate-y' | lv_property_0_8= 'margin-left' | lv_property_0_9= 'margin-right' | lv_property_0_10= 'margin-top' | lv_property_0_11= 'margin-bottom' | lv_property_0_12= 'padding-left' | lv_property_0_13= 'padding-right' | lv_property_0_14= 'padding-top' | lv_property_0_15= 'padding-bottom' | lv_property_0_16= 'x' | lv_property_0_17= 'y' | lv_property_0_18= 'elevation' ) ) ) otherlv_1= ':' ( (lv_value_2_0= ruleSizeValue ) ) )
            {
            // PsiInternalLatteCSS.g:773:2: ( ( ( (lv_property_0_1= 'border-left-width' | lv_property_0_2= 'border-right-width' | lv_property_0_3= 'border-top-width' | lv_property_0_4= 'border-bottom-width' | lv_property_0_5= 'font-size' | lv_property_0_6= 'translate-x' | lv_property_0_7= 'translate-y' | lv_property_0_8= 'margin-left' | lv_property_0_9= 'margin-right' | lv_property_0_10= 'margin-top' | lv_property_0_11= 'margin-bottom' | lv_property_0_12= 'padding-left' | lv_property_0_13= 'padding-right' | lv_property_0_14= 'padding-top' | lv_property_0_15= 'padding-bottom' | lv_property_0_16= 'x' | lv_property_0_17= 'y' | lv_property_0_18= 'elevation' ) ) ) otherlv_1= ':' ( (lv_value_2_0= ruleSizeValue ) ) )
            // PsiInternalLatteCSS.g:774:3: ( ( (lv_property_0_1= 'border-left-width' | lv_property_0_2= 'border-right-width' | lv_property_0_3= 'border-top-width' | lv_property_0_4= 'border-bottom-width' | lv_property_0_5= 'font-size' | lv_property_0_6= 'translate-x' | lv_property_0_7= 'translate-y' | lv_property_0_8= 'margin-left' | lv_property_0_9= 'margin-right' | lv_property_0_10= 'margin-top' | lv_property_0_11= 'margin-bottom' | lv_property_0_12= 'padding-left' | lv_property_0_13= 'padding-right' | lv_property_0_14= 'padding-top' | lv_property_0_15= 'padding-bottom' | lv_property_0_16= 'x' | lv_property_0_17= 'y' | lv_property_0_18= 'elevation' ) ) ) otherlv_1= ':' ( (lv_value_2_0= ruleSizeValue ) )
            {
            // PsiInternalLatteCSS.g:774:3: ( ( (lv_property_0_1= 'border-left-width' | lv_property_0_2= 'border-right-width' | lv_property_0_3= 'border-top-width' | lv_property_0_4= 'border-bottom-width' | lv_property_0_5= 'font-size' | lv_property_0_6= 'translate-x' | lv_property_0_7= 'translate-y' | lv_property_0_8= 'margin-left' | lv_property_0_9= 'margin-right' | lv_property_0_10= 'margin-top' | lv_property_0_11= 'margin-bottom' | lv_property_0_12= 'padding-left' | lv_property_0_13= 'padding-right' | lv_property_0_14= 'padding-top' | lv_property_0_15= 'padding-bottom' | lv_property_0_16= 'x' | lv_property_0_17= 'y' | lv_property_0_18= 'elevation' ) ) )
            // PsiInternalLatteCSS.g:775:4: ( (lv_property_0_1= 'border-left-width' | lv_property_0_2= 'border-right-width' | lv_property_0_3= 'border-top-width' | lv_property_0_4= 'border-bottom-width' | lv_property_0_5= 'font-size' | lv_property_0_6= 'translate-x' | lv_property_0_7= 'translate-y' | lv_property_0_8= 'margin-left' | lv_property_0_9= 'margin-right' | lv_property_0_10= 'margin-top' | lv_property_0_11= 'margin-bottom' | lv_property_0_12= 'padding-left' | lv_property_0_13= 'padding-right' | lv_property_0_14= 'padding-top' | lv_property_0_15= 'padding-bottom' | lv_property_0_16= 'x' | lv_property_0_17= 'y' | lv_property_0_18= 'elevation' ) )
            {
            // PsiInternalLatteCSS.g:775:4: ( (lv_property_0_1= 'border-left-width' | lv_property_0_2= 'border-right-width' | lv_property_0_3= 'border-top-width' | lv_property_0_4= 'border-bottom-width' | lv_property_0_5= 'font-size' | lv_property_0_6= 'translate-x' | lv_property_0_7= 'translate-y' | lv_property_0_8= 'margin-left' | lv_property_0_9= 'margin-right' | lv_property_0_10= 'margin-top' | lv_property_0_11= 'margin-bottom' | lv_property_0_12= 'padding-left' | lv_property_0_13= 'padding-right' | lv_property_0_14= 'padding-top' | lv_property_0_15= 'padding-bottom' | lv_property_0_16= 'x' | lv_property_0_17= 'y' | lv_property_0_18= 'elevation' ) )
            // PsiInternalLatteCSS.g:776:5: (lv_property_0_1= 'border-left-width' | lv_property_0_2= 'border-right-width' | lv_property_0_3= 'border-top-width' | lv_property_0_4= 'border-bottom-width' | lv_property_0_5= 'font-size' | lv_property_0_6= 'translate-x' | lv_property_0_7= 'translate-y' | lv_property_0_8= 'margin-left' | lv_property_0_9= 'margin-right' | lv_property_0_10= 'margin-top' | lv_property_0_11= 'margin-bottom' | lv_property_0_12= 'padding-left' | lv_property_0_13= 'padding-right' | lv_property_0_14= 'padding-top' | lv_property_0_15= 'padding-bottom' | lv_property_0_16= 'x' | lv_property_0_17= 'y' | lv_property_0_18= 'elevation' )
            {
            // PsiInternalLatteCSS.g:776:5: (lv_property_0_1= 'border-left-width' | lv_property_0_2= 'border-right-width' | lv_property_0_3= 'border-top-width' | lv_property_0_4= 'border-bottom-width' | lv_property_0_5= 'font-size' | lv_property_0_6= 'translate-x' | lv_property_0_7= 'translate-y' | lv_property_0_8= 'margin-left' | lv_property_0_9= 'margin-right' | lv_property_0_10= 'margin-top' | lv_property_0_11= 'margin-bottom' | lv_property_0_12= 'padding-left' | lv_property_0_13= 'padding-right' | lv_property_0_14= 'padding-top' | lv_property_0_15= 'padding-bottom' | lv_property_0_16= 'x' | lv_property_0_17= 'y' | lv_property_0_18= 'elevation' )
            int alt15=18;
            switch ( input.LA(1) ) {
            case 35:
                {
                alt15=1;
                }
                break;
            case 36:
                {
                alt15=2;
                }
                break;
            case 37:
                {
                alt15=3;
                }
                break;
            case 38:
                {
                alt15=4;
                }
                break;
            case 39:
                {
                alt15=5;
                }
                break;
            case 40:
                {
                alt15=6;
                }
                break;
            case 41:
                {
                alt15=7;
                }
                break;
            case 42:
                {
                alt15=8;
                }
                break;
            case 43:
                {
                alt15=9;
                }
                break;
            case 44:
                {
                alt15=10;
                }
                break;
            case 45:
                {
                alt15=11;
                }
                break;
            case 46:
                {
                alt15=12;
                }
                break;
            case 47:
                {
                alt15=13;
                }
                break;
            case 48:
                {
                alt15=14;
                }
                break;
            case 49:
                {
                alt15=15;
                }
                break;
            case 50:
                {
                alt15=16;
                }
                break;
            case 51:
                {
                alt15=17;
                }
                break;
            case 52:
                {
                alt15=18;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 15, 0, input);

                throw nvae;
            }

            switch (alt15) {
                case 1 :
                    // PsiInternalLatteCSS.g:777:6: lv_property_0_1= 'border-left-width'
                    {

                    						markLeaf(elementTypeProvider.getSizeProperty_PropertyBorderLeftWidthKeyword_0_0_0ElementType());
                    					
                    lv_property_0_1=(Token)match(input,35,FOLLOW_11); 

                    						doneLeaf(lv_property_0_1);
                    					

                    }
                    break;
                case 2 :
                    // PsiInternalLatteCSS.g:785:6: lv_property_0_2= 'border-right-width'
                    {

                    						markLeaf(elementTypeProvider.getSizeProperty_PropertyBorderRightWidthKeyword_0_0_1ElementType());
                    					
                    lv_property_0_2=(Token)match(input,36,FOLLOW_11); 

                    						doneLeaf(lv_property_0_2);
                    					

                    }
                    break;
                case 3 :
                    // PsiInternalLatteCSS.g:793:6: lv_property_0_3= 'border-top-width'
                    {

                    						markLeaf(elementTypeProvider.getSizeProperty_PropertyBorderTopWidthKeyword_0_0_2ElementType());
                    					
                    lv_property_0_3=(Token)match(input,37,FOLLOW_11); 

                    						doneLeaf(lv_property_0_3);
                    					

                    }
                    break;
                case 4 :
                    // PsiInternalLatteCSS.g:801:6: lv_property_0_4= 'border-bottom-width'
                    {

                    						markLeaf(elementTypeProvider.getSizeProperty_PropertyBorderBottomWidthKeyword_0_0_3ElementType());
                    					
                    lv_property_0_4=(Token)match(input,38,FOLLOW_11); 

                    						doneLeaf(lv_property_0_4);
                    					

                    }
                    break;
                case 5 :
                    // PsiInternalLatteCSS.g:809:6: lv_property_0_5= 'font-size'
                    {

                    						markLeaf(elementTypeProvider.getSizeProperty_PropertyFontSizeKeyword_0_0_4ElementType());
                    					
                    lv_property_0_5=(Token)match(input,39,FOLLOW_11); 

                    						doneLeaf(lv_property_0_5);
                    					

                    }
                    break;
                case 6 :
                    // PsiInternalLatteCSS.g:817:6: lv_property_0_6= 'translate-x'
                    {

                    						markLeaf(elementTypeProvider.getSizeProperty_PropertyTranslateXKeyword_0_0_5ElementType());
                    					
                    lv_property_0_6=(Token)match(input,40,FOLLOW_11); 

                    						doneLeaf(lv_property_0_6);
                    					

                    }
                    break;
                case 7 :
                    // PsiInternalLatteCSS.g:825:6: lv_property_0_7= 'translate-y'
                    {

                    						markLeaf(elementTypeProvider.getSizeProperty_PropertyTranslateYKeyword_0_0_6ElementType());
                    					
                    lv_property_0_7=(Token)match(input,41,FOLLOW_11); 

                    						doneLeaf(lv_property_0_7);
                    					

                    }
                    break;
                case 8 :
                    // PsiInternalLatteCSS.g:833:6: lv_property_0_8= 'margin-left'
                    {

                    						markLeaf(elementTypeProvider.getSizeProperty_PropertyMarginLeftKeyword_0_0_7ElementType());
                    					
                    lv_property_0_8=(Token)match(input,42,FOLLOW_11); 

                    						doneLeaf(lv_property_0_8);
                    					

                    }
                    break;
                case 9 :
                    // PsiInternalLatteCSS.g:841:6: lv_property_0_9= 'margin-right'
                    {

                    						markLeaf(elementTypeProvider.getSizeProperty_PropertyMarginRightKeyword_0_0_8ElementType());
                    					
                    lv_property_0_9=(Token)match(input,43,FOLLOW_11); 

                    						doneLeaf(lv_property_0_9);
                    					

                    }
                    break;
                case 10 :
                    // PsiInternalLatteCSS.g:849:6: lv_property_0_10= 'margin-top'
                    {

                    						markLeaf(elementTypeProvider.getSizeProperty_PropertyMarginTopKeyword_0_0_9ElementType());
                    					
                    lv_property_0_10=(Token)match(input,44,FOLLOW_11); 

                    						doneLeaf(lv_property_0_10);
                    					

                    }
                    break;
                case 11 :
                    // PsiInternalLatteCSS.g:857:6: lv_property_0_11= 'margin-bottom'
                    {

                    						markLeaf(elementTypeProvider.getSizeProperty_PropertyMarginBottomKeyword_0_0_10ElementType());
                    					
                    lv_property_0_11=(Token)match(input,45,FOLLOW_11); 

                    						doneLeaf(lv_property_0_11);
                    					

                    }
                    break;
                case 12 :
                    // PsiInternalLatteCSS.g:865:6: lv_property_0_12= 'padding-left'
                    {

                    						markLeaf(elementTypeProvider.getSizeProperty_PropertyPaddingLeftKeyword_0_0_11ElementType());
                    					
                    lv_property_0_12=(Token)match(input,46,FOLLOW_11); 

                    						doneLeaf(lv_property_0_12);
                    					

                    }
                    break;
                case 13 :
                    // PsiInternalLatteCSS.g:873:6: lv_property_0_13= 'padding-right'
                    {

                    						markLeaf(elementTypeProvider.getSizeProperty_PropertyPaddingRightKeyword_0_0_12ElementType());
                    					
                    lv_property_0_13=(Token)match(input,47,FOLLOW_11); 

                    						doneLeaf(lv_property_0_13);
                    					

                    }
                    break;
                case 14 :
                    // PsiInternalLatteCSS.g:881:6: lv_property_0_14= 'padding-top'
                    {

                    						markLeaf(elementTypeProvider.getSizeProperty_PropertyPaddingTopKeyword_0_0_13ElementType());
                    					
                    lv_property_0_14=(Token)match(input,48,FOLLOW_11); 

                    						doneLeaf(lv_property_0_14);
                    					

                    }
                    break;
                case 15 :
                    // PsiInternalLatteCSS.g:889:6: lv_property_0_15= 'padding-bottom'
                    {

                    						markLeaf(elementTypeProvider.getSizeProperty_PropertyPaddingBottomKeyword_0_0_14ElementType());
                    					
                    lv_property_0_15=(Token)match(input,49,FOLLOW_11); 

                    						doneLeaf(lv_property_0_15);
                    					

                    }
                    break;
                case 16 :
                    // PsiInternalLatteCSS.g:897:6: lv_property_0_16= 'x'
                    {

                    						markLeaf(elementTypeProvider.getSizeProperty_PropertyXKeyword_0_0_15ElementType());
                    					
                    lv_property_0_16=(Token)match(input,50,FOLLOW_11); 

                    						doneLeaf(lv_property_0_16);
                    					

                    }
                    break;
                case 17 :
                    // PsiInternalLatteCSS.g:905:6: lv_property_0_17= 'y'
                    {

                    						markLeaf(elementTypeProvider.getSizeProperty_PropertyYKeyword_0_0_16ElementType());
                    					
                    lv_property_0_17=(Token)match(input,51,FOLLOW_11); 

                    						doneLeaf(lv_property_0_17);
                    					

                    }
                    break;
                case 18 :
                    // PsiInternalLatteCSS.g:913:6: lv_property_0_18= 'elevation'
                    {

                    						markLeaf(elementTypeProvider.getSizeProperty_PropertyElevationKeyword_0_0_17ElementType());
                    					
                    lv_property_0_18=(Token)match(input,52,FOLLOW_11); 

                    						doneLeaf(lv_property_0_18);
                    					

                    }
                    break;

            }


            }


            }


            			markLeaf(elementTypeProvider.getSizeProperty_ColonKeyword_1ElementType());
            		
            otherlv_1=(Token)match(input,18,FOLLOW_15); 

            			doneLeaf(otherlv_1);
            		
            // PsiInternalLatteCSS.g:930:3: ( (lv_value_2_0= ruleSizeValue ) )
            // PsiInternalLatteCSS.g:931:4: (lv_value_2_0= ruleSizeValue )
            {
            // PsiInternalLatteCSS.g:931:4: (lv_value_2_0= ruleSizeValue )
            // PsiInternalLatteCSS.g:932:5: lv_value_2_0= ruleSizeValue
            {

            					markComposite(elementTypeProvider.getSizeProperty_ValueSizeValueParserRuleCall_2_0ElementType());
            				
            pushFollow(FOLLOW_2);
            ruleSizeValue();

            state._fsp--;


            					doneComposite();
            				

            }


            }


            }


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
    // $ANTLR end "ruleSizeProperty"


    // $ANTLR start "entryRulePaintProperty"
    // PsiInternalLatteCSS.g:945:1: entryRulePaintProperty : rulePaintProperty EOF ;
    public final void entryRulePaintProperty() throws RecognitionException {
        try {
            // PsiInternalLatteCSS.g:945:23: ( rulePaintProperty EOF )
            // PsiInternalLatteCSS.g:946:2: rulePaintProperty EOF
            {
             markComposite(elementTypeProvider.getPaintPropertyElementType()); 
            pushFollow(FOLLOW_1);
            rulePaintProperty();

            state._fsp--;

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
    // PsiInternalLatteCSS.g:951:1: rulePaintProperty : ( ( (lv_property_0_0= 'background' ) ) otherlv_1= ':' ( (lv_value_2_0= rulePaintValue ) ) ) ;
    public final void rulePaintProperty() throws RecognitionException {
        Token lv_property_0_0=null;
        Token otherlv_1=null;

        try {
            // PsiInternalLatteCSS.g:951:18: ( ( ( (lv_property_0_0= 'background' ) ) otherlv_1= ':' ( (lv_value_2_0= rulePaintValue ) ) ) )
            // PsiInternalLatteCSS.g:952:2: ( ( (lv_property_0_0= 'background' ) ) otherlv_1= ':' ( (lv_value_2_0= rulePaintValue ) ) )
            {
            // PsiInternalLatteCSS.g:952:2: ( ( (lv_property_0_0= 'background' ) ) otherlv_1= ':' ( (lv_value_2_0= rulePaintValue ) ) )
            // PsiInternalLatteCSS.g:953:3: ( (lv_property_0_0= 'background' ) ) otherlv_1= ':' ( (lv_value_2_0= rulePaintValue ) )
            {
            // PsiInternalLatteCSS.g:953:3: ( (lv_property_0_0= 'background' ) )
            // PsiInternalLatteCSS.g:954:4: (lv_property_0_0= 'background' )
            {
            // PsiInternalLatteCSS.g:954:4: (lv_property_0_0= 'background' )
            // PsiInternalLatteCSS.g:955:5: lv_property_0_0= 'background'
            {

            					markLeaf(elementTypeProvider.getPaintProperty_PropertyBackgroundKeyword_0_0ElementType());
            				
            lv_property_0_0=(Token)match(input,53,FOLLOW_11); 

            					doneLeaf(lv_property_0_0);
            				

            }


            }


            			markLeaf(elementTypeProvider.getPaintProperty_ColonKeyword_1ElementType());
            		
            otherlv_1=(Token)match(input,18,FOLLOW_17); 

            			doneLeaf(otherlv_1);
            		
            // PsiInternalLatteCSS.g:971:3: ( (lv_value_2_0= rulePaintValue ) )
            // PsiInternalLatteCSS.g:972:4: (lv_value_2_0= rulePaintValue )
            {
            // PsiInternalLatteCSS.g:972:4: (lv_value_2_0= rulePaintValue )
            // PsiInternalLatteCSS.g:973:5: lv_value_2_0= rulePaintValue
            {

            					markComposite(elementTypeProvider.getPaintProperty_ValuePaintValueParserRuleCall_2_0ElementType());
            				
            pushFollow(FOLLOW_2);
            rulePaintValue();

            state._fsp--;


            					doneComposite();
            				

            }


            }


            }


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
    // $ANTLR end "rulePaintProperty"


    // $ANTLR start "entryRuleTransitionProperty"
    // PsiInternalLatteCSS.g:986:1: entryRuleTransitionProperty : ruleTransitionProperty EOF ;
    public final void entryRuleTransitionProperty() throws RecognitionException {
        try {
            // PsiInternalLatteCSS.g:986:28: ( ruleTransitionProperty EOF )
            // PsiInternalLatteCSS.g:987:2: ruleTransitionProperty EOF
            {
             markComposite(elementTypeProvider.getTransitionPropertyElementType()); 
            pushFollow(FOLLOW_1);
            ruleTransitionProperty();

            state._fsp--;

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
    // PsiInternalLatteCSS.g:992:1: ruleTransitionProperty : ( ( (lv_property_0_0= 'transition' ) ) otherlv_1= ':' ( (lv_transitions_2_0= ruleTransitionValue ) ) (otherlv_3= ',' ( (lv_transitions_4_0= ruleTransitionValue ) ) )* ) ;
    public final void ruleTransitionProperty() throws RecognitionException {
        Token lv_property_0_0=null;
        Token otherlv_1=null;
        Token otherlv_3=null;

        try {
            // PsiInternalLatteCSS.g:992:23: ( ( ( (lv_property_0_0= 'transition' ) ) otherlv_1= ':' ( (lv_transitions_2_0= ruleTransitionValue ) ) (otherlv_3= ',' ( (lv_transitions_4_0= ruleTransitionValue ) ) )* ) )
            // PsiInternalLatteCSS.g:993:2: ( ( (lv_property_0_0= 'transition' ) ) otherlv_1= ':' ( (lv_transitions_2_0= ruleTransitionValue ) ) (otherlv_3= ',' ( (lv_transitions_4_0= ruleTransitionValue ) ) )* )
            {
            // PsiInternalLatteCSS.g:993:2: ( ( (lv_property_0_0= 'transition' ) ) otherlv_1= ':' ( (lv_transitions_2_0= ruleTransitionValue ) ) (otherlv_3= ',' ( (lv_transitions_4_0= ruleTransitionValue ) ) )* )
            // PsiInternalLatteCSS.g:994:3: ( (lv_property_0_0= 'transition' ) ) otherlv_1= ':' ( (lv_transitions_2_0= ruleTransitionValue ) ) (otherlv_3= ',' ( (lv_transitions_4_0= ruleTransitionValue ) ) )*
            {
            // PsiInternalLatteCSS.g:994:3: ( (lv_property_0_0= 'transition' ) )
            // PsiInternalLatteCSS.g:995:4: (lv_property_0_0= 'transition' )
            {
            // PsiInternalLatteCSS.g:995:4: (lv_property_0_0= 'transition' )
            // PsiInternalLatteCSS.g:996:5: lv_property_0_0= 'transition'
            {

            					markLeaf(elementTypeProvider.getTransitionProperty_PropertyTransitionKeyword_0_0ElementType());
            				
            lv_property_0_0=(Token)match(input,54,FOLLOW_11); 

            					doneLeaf(lv_property_0_0);
            				

            }


            }


            			markLeaf(elementTypeProvider.getTransitionProperty_ColonKeyword_1ElementType());
            		
            otherlv_1=(Token)match(input,18,FOLLOW_18); 

            			doneLeaf(otherlv_1);
            		
            // PsiInternalLatteCSS.g:1012:3: ( (lv_transitions_2_0= ruleTransitionValue ) )
            // PsiInternalLatteCSS.g:1013:4: (lv_transitions_2_0= ruleTransitionValue )
            {
            // PsiInternalLatteCSS.g:1013:4: (lv_transitions_2_0= ruleTransitionValue )
            // PsiInternalLatteCSS.g:1014:5: lv_transitions_2_0= ruleTransitionValue
            {

            					markComposite(elementTypeProvider.getTransitionProperty_TransitionsTransitionValueParserRuleCall_2_0ElementType());
            				
            pushFollow(FOLLOW_19);
            ruleTransitionValue();

            state._fsp--;


            					doneComposite();
            				

            }


            }

            // PsiInternalLatteCSS.g:1023:3: (otherlv_3= ',' ( (lv_transitions_4_0= ruleTransitionValue ) ) )*
            loop16:
            do {
                int alt16=2;
                int LA16_0 = input.LA(1);

                if ( (LA16_0==13) ) {
                    alt16=1;
                }


                switch (alt16) {
            	case 1 :
            	    // PsiInternalLatteCSS.g:1024:4: otherlv_3= ',' ( (lv_transitions_4_0= ruleTransitionValue ) )
            	    {

            	    				markLeaf(elementTypeProvider.getTransitionProperty_CommaKeyword_3_0ElementType());
            	    			
            	    otherlv_3=(Token)match(input,13,FOLLOW_18); 

            	    				doneLeaf(otherlv_3);
            	    			
            	    // PsiInternalLatteCSS.g:1031:4: ( (lv_transitions_4_0= ruleTransitionValue ) )
            	    // PsiInternalLatteCSS.g:1032:5: (lv_transitions_4_0= ruleTransitionValue )
            	    {
            	    // PsiInternalLatteCSS.g:1032:5: (lv_transitions_4_0= ruleTransitionValue )
            	    // PsiInternalLatteCSS.g:1033:6: lv_transitions_4_0= ruleTransitionValue
            	    {

            	    						markComposite(elementTypeProvider.getTransitionProperty_TransitionsTransitionValueParserRuleCall_3_1_0ElementType());
            	    					
            	    pushFollow(FOLLOW_19);
            	    ruleTransitionValue();

            	    state._fsp--;


            	    						doneComposite();
            	    					

            	    }


            	    }


            	    }
            	    break;

            	default :
            	    break loop16;
                }
            } while (true);


            }


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
    // $ANTLR end "ruleTransitionProperty"


    // $ANTLR start "entryRuleTransitionValue"
    // PsiInternalLatteCSS.g:1047:1: entryRuleTransitionValue : ruleTransitionValue EOF ;
    public final void entryRuleTransitionValue() throws RecognitionException {
        try {
            // PsiInternalLatteCSS.g:1047:25: ( ruleTransitionValue EOF )
            // PsiInternalLatteCSS.g:1048:2: ruleTransitionValue EOF
            {
             markComposite(elementTypeProvider.getTransitionValueElementType()); 
            pushFollow(FOLLOW_1);
            ruleTransitionValue();

            state._fsp--;

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
    // PsiInternalLatteCSS.g:1053:1: ruleTransitionValue : ( ( (lv_propertyName_0_0= rulePropertyNameValue ) ) ( (lv_duration_1_0= ruleTimeValue ) ) ( (lv_timingFunction_2_0= ruleTimingFunction ) )? ( (lv_delay_3_0= ruleTimeValue ) )? ) ;
    public final void ruleTransitionValue() throws RecognitionException {
        try {
            // PsiInternalLatteCSS.g:1053:20: ( ( ( (lv_propertyName_0_0= rulePropertyNameValue ) ) ( (lv_duration_1_0= ruleTimeValue ) ) ( (lv_timingFunction_2_0= ruleTimingFunction ) )? ( (lv_delay_3_0= ruleTimeValue ) )? ) )
            // PsiInternalLatteCSS.g:1054:2: ( ( (lv_propertyName_0_0= rulePropertyNameValue ) ) ( (lv_duration_1_0= ruleTimeValue ) ) ( (lv_timingFunction_2_0= ruleTimingFunction ) )? ( (lv_delay_3_0= ruleTimeValue ) )? )
            {
            // PsiInternalLatteCSS.g:1054:2: ( ( (lv_propertyName_0_0= rulePropertyNameValue ) ) ( (lv_duration_1_0= ruleTimeValue ) ) ( (lv_timingFunction_2_0= ruleTimingFunction ) )? ( (lv_delay_3_0= ruleTimeValue ) )? )
            // PsiInternalLatteCSS.g:1055:3: ( (lv_propertyName_0_0= rulePropertyNameValue ) ) ( (lv_duration_1_0= ruleTimeValue ) ) ( (lv_timingFunction_2_0= ruleTimingFunction ) )? ( (lv_delay_3_0= ruleTimeValue ) )?
            {
            // PsiInternalLatteCSS.g:1055:3: ( (lv_propertyName_0_0= rulePropertyNameValue ) )
            // PsiInternalLatteCSS.g:1056:4: (lv_propertyName_0_0= rulePropertyNameValue )
            {
            // PsiInternalLatteCSS.g:1056:4: (lv_propertyName_0_0= rulePropertyNameValue )
            // PsiInternalLatteCSS.g:1057:5: lv_propertyName_0_0= rulePropertyNameValue
            {

            					markComposite(elementTypeProvider.getTransitionValue_PropertyNamePropertyNameValueParserRuleCall_0_0ElementType());
            				
            pushFollow(FOLLOW_15);
            rulePropertyNameValue();

            state._fsp--;


            					doneComposite();
            				

            }


            }

            // PsiInternalLatteCSS.g:1066:3: ( (lv_duration_1_0= ruleTimeValue ) )
            // PsiInternalLatteCSS.g:1067:4: (lv_duration_1_0= ruleTimeValue )
            {
            // PsiInternalLatteCSS.g:1067:4: (lv_duration_1_0= ruleTimeValue )
            // PsiInternalLatteCSS.g:1068:5: lv_duration_1_0= ruleTimeValue
            {

            					markComposite(elementTypeProvider.getTransitionValue_DurationTimeValueParserRuleCall_1_0ElementType());
            				
            pushFollow(FOLLOW_20);
            ruleTimeValue();

            state._fsp--;


            					doneComposite();
            				

            }


            }

            // PsiInternalLatteCSS.g:1077:3: ( (lv_timingFunction_2_0= ruleTimingFunction ) )?
            int alt17=2;
            int LA17_0 = input.LA(1);

            if ( ((LA17_0>=119 && LA17_0<=130)) ) {
                alt17=1;
            }
            switch (alt17) {
                case 1 :
                    // PsiInternalLatteCSS.g:1078:4: (lv_timingFunction_2_0= ruleTimingFunction )
                    {
                    // PsiInternalLatteCSS.g:1078:4: (lv_timingFunction_2_0= ruleTimingFunction )
                    // PsiInternalLatteCSS.g:1079:5: lv_timingFunction_2_0= ruleTimingFunction
                    {

                    					markComposite(elementTypeProvider.getTransitionValue_TimingFunctionTimingFunctionParserRuleCall_2_0ElementType());
                    				
                    pushFollow(FOLLOW_16);
                    ruleTimingFunction();

                    state._fsp--;


                    					doneComposite();
                    				

                    }


                    }
                    break;

            }

            // PsiInternalLatteCSS.g:1088:3: ( (lv_delay_3_0= ruleTimeValue ) )?
            int alt18=2;
            int LA18_0 = input.LA(1);

            if ( ((LA18_0>=RULE_INT && LA18_0<=RULE_REAL)) ) {
                alt18=1;
            }
            switch (alt18) {
                case 1 :
                    // PsiInternalLatteCSS.g:1089:4: (lv_delay_3_0= ruleTimeValue )
                    {
                    // PsiInternalLatteCSS.g:1089:4: (lv_delay_3_0= ruleTimeValue )
                    // PsiInternalLatteCSS.g:1090:5: lv_delay_3_0= ruleTimeValue
                    {

                    					markComposite(elementTypeProvider.getTransitionValue_DelayTimeValueParserRuleCall_3_0ElementType());
                    				
                    pushFollow(FOLLOW_2);
                    ruleTimeValue();

                    state._fsp--;


                    					doneComposite();
                    				

                    }


                    }
                    break;

            }


            }


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
    // $ANTLR end "ruleTransitionValue"


    // $ANTLR start "entryRuleDrawableProperty"
    // PsiInternalLatteCSS.g:1103:1: entryRuleDrawableProperty : ruleDrawableProperty EOF ;
    public final void entryRuleDrawableProperty() throws RecognitionException {
        try {
            // PsiInternalLatteCSS.g:1103:26: ( ruleDrawableProperty EOF )
            // PsiInternalLatteCSS.g:1104:2: ruleDrawableProperty EOF
            {
             markComposite(elementTypeProvider.getDrawablePropertyElementType()); 
            pushFollow(FOLLOW_1);
            ruleDrawableProperty();

            state._fsp--;

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
    // PsiInternalLatteCSS.g:1109:1: ruleDrawableProperty : ( ( (lv_property_0_0= 'background-drawable' ) ) otherlv_1= ':' ( (lv_value_2_0= RULE_STRING ) ) ) ;
    public final void ruleDrawableProperty() throws RecognitionException {
        Token lv_property_0_0=null;
        Token otherlv_1=null;
        Token lv_value_2_0=null;

        try {
            // PsiInternalLatteCSS.g:1109:21: ( ( ( (lv_property_0_0= 'background-drawable' ) ) otherlv_1= ':' ( (lv_value_2_0= RULE_STRING ) ) ) )
            // PsiInternalLatteCSS.g:1110:2: ( ( (lv_property_0_0= 'background-drawable' ) ) otherlv_1= ':' ( (lv_value_2_0= RULE_STRING ) ) )
            {
            // PsiInternalLatteCSS.g:1110:2: ( ( (lv_property_0_0= 'background-drawable' ) ) otherlv_1= ':' ( (lv_value_2_0= RULE_STRING ) ) )
            // PsiInternalLatteCSS.g:1111:3: ( (lv_property_0_0= 'background-drawable' ) ) otherlv_1= ':' ( (lv_value_2_0= RULE_STRING ) )
            {
            // PsiInternalLatteCSS.g:1111:3: ( (lv_property_0_0= 'background-drawable' ) )
            // PsiInternalLatteCSS.g:1112:4: (lv_property_0_0= 'background-drawable' )
            {
            // PsiInternalLatteCSS.g:1112:4: (lv_property_0_0= 'background-drawable' )
            // PsiInternalLatteCSS.g:1113:5: lv_property_0_0= 'background-drawable'
            {

            					markLeaf(elementTypeProvider.getDrawableProperty_PropertyBackgroundDrawableKeyword_0_0ElementType());
            				
            lv_property_0_0=(Token)match(input,55,FOLLOW_11); 

            					doneLeaf(lv_property_0_0);
            				

            }


            }


            			markLeaf(elementTypeProvider.getDrawableProperty_ColonKeyword_1ElementType());
            		
            otherlv_1=(Token)match(input,18,FOLLOW_12); 

            			doneLeaf(otherlv_1);
            		
            // PsiInternalLatteCSS.g:1129:3: ( (lv_value_2_0= RULE_STRING ) )
            // PsiInternalLatteCSS.g:1130:4: (lv_value_2_0= RULE_STRING )
            {
            // PsiInternalLatteCSS.g:1130:4: (lv_value_2_0= RULE_STRING )
            // PsiInternalLatteCSS.g:1131:5: lv_value_2_0= RULE_STRING
            {

            					markLeaf(elementTypeProvider.getDrawableProperty_ValueSTRINGTerminalRuleCall_2_0ElementType());
            				
            lv_value_2_0=(Token)match(input,RULE_STRING,FOLLOW_2); 

            					doneLeaf(lv_value_2_0);
            				

            }


            }


            }


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
    // $ANTLR end "ruleDrawableProperty"


    // $ANTLR start "entryRuleBackgroundRepeatProperty"
    // PsiInternalLatteCSS.g:1144:1: entryRuleBackgroundRepeatProperty : ruleBackgroundRepeatProperty EOF ;
    public final void entryRuleBackgroundRepeatProperty() throws RecognitionException {
        try {
            // PsiInternalLatteCSS.g:1144:34: ( ruleBackgroundRepeatProperty EOF )
            // PsiInternalLatteCSS.g:1145:2: ruleBackgroundRepeatProperty EOF
            {
             markComposite(elementTypeProvider.getBackgroundRepeatPropertyElementType()); 
            pushFollow(FOLLOW_1);
            ruleBackgroundRepeatProperty();

            state._fsp--;

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
    // PsiInternalLatteCSS.g:1150:1: ruleBackgroundRepeatProperty : ( ( (lv_property_0_0= 'background-repeat' ) ) otherlv_1= ':' ( (lv_values_2_0= ruleRepeatValue ) ) ( (lv_values_3_0= ruleRepeatValue ) )? ) ;
    public final void ruleBackgroundRepeatProperty() throws RecognitionException {
        Token lv_property_0_0=null;
        Token otherlv_1=null;

        try {
            // PsiInternalLatteCSS.g:1150:29: ( ( ( (lv_property_0_0= 'background-repeat' ) ) otherlv_1= ':' ( (lv_values_2_0= ruleRepeatValue ) ) ( (lv_values_3_0= ruleRepeatValue ) )? ) )
            // PsiInternalLatteCSS.g:1151:2: ( ( (lv_property_0_0= 'background-repeat' ) ) otherlv_1= ':' ( (lv_values_2_0= ruleRepeatValue ) ) ( (lv_values_3_0= ruleRepeatValue ) )? )
            {
            // PsiInternalLatteCSS.g:1151:2: ( ( (lv_property_0_0= 'background-repeat' ) ) otherlv_1= ':' ( (lv_values_2_0= ruleRepeatValue ) ) ( (lv_values_3_0= ruleRepeatValue ) )? )
            // PsiInternalLatteCSS.g:1152:3: ( (lv_property_0_0= 'background-repeat' ) ) otherlv_1= ':' ( (lv_values_2_0= ruleRepeatValue ) ) ( (lv_values_3_0= ruleRepeatValue ) )?
            {
            // PsiInternalLatteCSS.g:1152:3: ( (lv_property_0_0= 'background-repeat' ) )
            // PsiInternalLatteCSS.g:1153:4: (lv_property_0_0= 'background-repeat' )
            {
            // PsiInternalLatteCSS.g:1153:4: (lv_property_0_0= 'background-repeat' )
            // PsiInternalLatteCSS.g:1154:5: lv_property_0_0= 'background-repeat'
            {

            					markLeaf(elementTypeProvider.getBackgroundRepeatProperty_PropertyBackgroundRepeatKeyword_0_0ElementType());
            				
            lv_property_0_0=(Token)match(input,56,FOLLOW_11); 

            					doneLeaf(lv_property_0_0);
            				

            }


            }


            			markLeaf(elementTypeProvider.getBackgroundRepeatProperty_ColonKeyword_1ElementType());
            		
            otherlv_1=(Token)match(input,18,FOLLOW_21); 

            			doneLeaf(otherlv_1);
            		
            // PsiInternalLatteCSS.g:1170:3: ( (lv_values_2_0= ruleRepeatValue ) )
            // PsiInternalLatteCSS.g:1171:4: (lv_values_2_0= ruleRepeatValue )
            {
            // PsiInternalLatteCSS.g:1171:4: (lv_values_2_0= ruleRepeatValue )
            // PsiInternalLatteCSS.g:1172:5: lv_values_2_0= ruleRepeatValue
            {

            					markComposite(elementTypeProvider.getBackgroundRepeatProperty_ValuesRepeatValueParserRuleCall_2_0ElementType());
            				
            pushFollow(FOLLOW_22);
            ruleRepeatValue();

            state._fsp--;


            					doneComposite();
            				

            }


            }

            // PsiInternalLatteCSS.g:1181:3: ( (lv_values_3_0= ruleRepeatValue ) )?
            int alt19=2;
            int LA19_0 = input.LA(1);

            if ( ((LA19_0>=66 && LA19_0<=73)) ) {
                alt19=1;
            }
            switch (alt19) {
                case 1 :
                    // PsiInternalLatteCSS.g:1182:4: (lv_values_3_0= ruleRepeatValue )
                    {
                    // PsiInternalLatteCSS.g:1182:4: (lv_values_3_0= ruleRepeatValue )
                    // PsiInternalLatteCSS.g:1183:5: lv_values_3_0= ruleRepeatValue
                    {

                    					markComposite(elementTypeProvider.getBackgroundRepeatProperty_ValuesRepeatValueParserRuleCall_3_0ElementType());
                    				
                    pushFollow(FOLLOW_2);
                    ruleRepeatValue();

                    state._fsp--;


                    					doneComposite();
                    				

                    }


                    }
                    break;

            }


            }


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
    // $ANTLR end "ruleBackgroundRepeatProperty"


    // $ANTLR start "entryRuleBorderProperty"
    // PsiInternalLatteCSS.g:1196:1: entryRuleBorderProperty : ruleBorderProperty EOF ;
    public final void entryRuleBorderProperty() throws RecognitionException {
        try {
            // PsiInternalLatteCSS.g:1196:24: ( ruleBorderProperty EOF )
            // PsiInternalLatteCSS.g:1197:2: ruleBorderProperty EOF
            {
             markComposite(elementTypeProvider.getBorderPropertyElementType()); 
            pushFollow(FOLLOW_1);
            ruleBorderProperty();

            state._fsp--;

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
    // PsiInternalLatteCSS.g:1202:1: ruleBorderProperty : ( ( ( (lv_property_0_1= 'border' | lv_property_0_2= 'border-top' | lv_property_0_3= 'border-bottom' | lv_property_0_4= 'border-left' | lv_property_0_5= 'border-right' ) ) ) otherlv_1= ':' ( (lv_width_2_0= ruleSizeValue ) )? ( ( (lv_style_3_1= 'solid' | lv_style_3_2= 'dashed' | lv_style_3_3= 'dotted' ) ) ) ( (lv_color_4_0= ruleColorValue ) )? ) ;
    public final void ruleBorderProperty() throws RecognitionException {
        Token lv_property_0_1=null;
        Token lv_property_0_2=null;
        Token lv_property_0_3=null;
        Token lv_property_0_4=null;
        Token lv_property_0_5=null;
        Token otherlv_1=null;
        Token lv_style_3_1=null;
        Token lv_style_3_2=null;
        Token lv_style_3_3=null;

        try {
            // PsiInternalLatteCSS.g:1202:19: ( ( ( ( (lv_property_0_1= 'border' | lv_property_0_2= 'border-top' | lv_property_0_3= 'border-bottom' | lv_property_0_4= 'border-left' | lv_property_0_5= 'border-right' ) ) ) otherlv_1= ':' ( (lv_width_2_0= ruleSizeValue ) )? ( ( (lv_style_3_1= 'solid' | lv_style_3_2= 'dashed' | lv_style_3_3= 'dotted' ) ) ) ( (lv_color_4_0= ruleColorValue ) )? ) )
            // PsiInternalLatteCSS.g:1203:2: ( ( ( (lv_property_0_1= 'border' | lv_property_0_2= 'border-top' | lv_property_0_3= 'border-bottom' | lv_property_0_4= 'border-left' | lv_property_0_5= 'border-right' ) ) ) otherlv_1= ':' ( (lv_width_2_0= ruleSizeValue ) )? ( ( (lv_style_3_1= 'solid' | lv_style_3_2= 'dashed' | lv_style_3_3= 'dotted' ) ) ) ( (lv_color_4_0= ruleColorValue ) )? )
            {
            // PsiInternalLatteCSS.g:1203:2: ( ( ( (lv_property_0_1= 'border' | lv_property_0_2= 'border-top' | lv_property_0_3= 'border-bottom' | lv_property_0_4= 'border-left' | lv_property_0_5= 'border-right' ) ) ) otherlv_1= ':' ( (lv_width_2_0= ruleSizeValue ) )? ( ( (lv_style_3_1= 'solid' | lv_style_3_2= 'dashed' | lv_style_3_3= 'dotted' ) ) ) ( (lv_color_4_0= ruleColorValue ) )? )
            // PsiInternalLatteCSS.g:1204:3: ( ( (lv_property_0_1= 'border' | lv_property_0_2= 'border-top' | lv_property_0_3= 'border-bottom' | lv_property_0_4= 'border-left' | lv_property_0_5= 'border-right' ) ) ) otherlv_1= ':' ( (lv_width_2_0= ruleSizeValue ) )? ( ( (lv_style_3_1= 'solid' | lv_style_3_2= 'dashed' | lv_style_3_3= 'dotted' ) ) ) ( (lv_color_4_0= ruleColorValue ) )?
            {
            // PsiInternalLatteCSS.g:1204:3: ( ( (lv_property_0_1= 'border' | lv_property_0_2= 'border-top' | lv_property_0_3= 'border-bottom' | lv_property_0_4= 'border-left' | lv_property_0_5= 'border-right' ) ) )
            // PsiInternalLatteCSS.g:1205:4: ( (lv_property_0_1= 'border' | lv_property_0_2= 'border-top' | lv_property_0_3= 'border-bottom' | lv_property_0_4= 'border-left' | lv_property_0_5= 'border-right' ) )
            {
            // PsiInternalLatteCSS.g:1205:4: ( (lv_property_0_1= 'border' | lv_property_0_2= 'border-top' | lv_property_0_3= 'border-bottom' | lv_property_0_4= 'border-left' | lv_property_0_5= 'border-right' ) )
            // PsiInternalLatteCSS.g:1206:5: (lv_property_0_1= 'border' | lv_property_0_2= 'border-top' | lv_property_0_3= 'border-bottom' | lv_property_0_4= 'border-left' | lv_property_0_5= 'border-right' )
            {
            // PsiInternalLatteCSS.g:1206:5: (lv_property_0_1= 'border' | lv_property_0_2= 'border-top' | lv_property_0_3= 'border-bottom' | lv_property_0_4= 'border-left' | lv_property_0_5= 'border-right' )
            int alt20=5;
            switch ( input.LA(1) ) {
            case 57:
                {
                alt20=1;
                }
                break;
            case 58:
                {
                alt20=2;
                }
                break;
            case 59:
                {
                alt20=3;
                }
                break;
            case 60:
                {
                alt20=4;
                }
                break;
            case 61:
                {
                alt20=5;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 20, 0, input);

                throw nvae;
            }

            switch (alt20) {
                case 1 :
                    // PsiInternalLatteCSS.g:1207:6: lv_property_0_1= 'border'
                    {

                    						markLeaf(elementTypeProvider.getBorderProperty_PropertyBorderKeyword_0_0_0ElementType());
                    					
                    lv_property_0_1=(Token)match(input,57,FOLLOW_11); 

                    						doneLeaf(lv_property_0_1);
                    					

                    }
                    break;
                case 2 :
                    // PsiInternalLatteCSS.g:1215:6: lv_property_0_2= 'border-top'
                    {

                    						markLeaf(elementTypeProvider.getBorderProperty_PropertyBorderTopKeyword_0_0_1ElementType());
                    					
                    lv_property_0_2=(Token)match(input,58,FOLLOW_11); 

                    						doneLeaf(lv_property_0_2);
                    					

                    }
                    break;
                case 3 :
                    // PsiInternalLatteCSS.g:1223:6: lv_property_0_3= 'border-bottom'
                    {

                    						markLeaf(elementTypeProvider.getBorderProperty_PropertyBorderBottomKeyword_0_0_2ElementType());
                    					
                    lv_property_0_3=(Token)match(input,59,FOLLOW_11); 

                    						doneLeaf(lv_property_0_3);
                    					

                    }
                    break;
                case 4 :
                    // PsiInternalLatteCSS.g:1231:6: lv_property_0_4= 'border-left'
                    {

                    						markLeaf(elementTypeProvider.getBorderProperty_PropertyBorderLeftKeyword_0_0_3ElementType());
                    					
                    lv_property_0_4=(Token)match(input,60,FOLLOW_11); 

                    						doneLeaf(lv_property_0_4);
                    					

                    }
                    break;
                case 5 :
                    // PsiInternalLatteCSS.g:1239:6: lv_property_0_5= 'border-right'
                    {

                    						markLeaf(elementTypeProvider.getBorderProperty_PropertyBorderRightKeyword_0_0_4ElementType());
                    					
                    lv_property_0_5=(Token)match(input,61,FOLLOW_11); 

                    						doneLeaf(lv_property_0_5);
                    					

                    }
                    break;

            }


            }


            }


            			markLeaf(elementTypeProvider.getBorderProperty_ColonKeyword_1ElementType());
            		
            otherlv_1=(Token)match(input,18,FOLLOW_23); 

            			doneLeaf(otherlv_1);
            		
            // PsiInternalLatteCSS.g:1256:3: ( (lv_width_2_0= ruleSizeValue ) )?
            int alt21=2;
            int LA21_0 = input.LA(1);

            if ( ((LA21_0>=RULE_INT && LA21_0<=RULE_REAL)) ) {
                alt21=1;
            }
            switch (alt21) {
                case 1 :
                    // PsiInternalLatteCSS.g:1257:4: (lv_width_2_0= ruleSizeValue )
                    {
                    // PsiInternalLatteCSS.g:1257:4: (lv_width_2_0= ruleSizeValue )
                    // PsiInternalLatteCSS.g:1258:5: lv_width_2_0= ruleSizeValue
                    {

                    					markComposite(elementTypeProvider.getBorderProperty_WidthSizeValueParserRuleCall_2_0ElementType());
                    				
                    pushFollow(FOLLOW_24);
                    ruleSizeValue();

                    state._fsp--;


                    					doneComposite();
                    				

                    }


                    }
                    break;

            }

            // PsiInternalLatteCSS.g:1267:3: ( ( (lv_style_3_1= 'solid' | lv_style_3_2= 'dashed' | lv_style_3_3= 'dotted' ) ) )
            // PsiInternalLatteCSS.g:1268:4: ( (lv_style_3_1= 'solid' | lv_style_3_2= 'dashed' | lv_style_3_3= 'dotted' ) )
            {
            // PsiInternalLatteCSS.g:1268:4: ( (lv_style_3_1= 'solid' | lv_style_3_2= 'dashed' | lv_style_3_3= 'dotted' ) )
            // PsiInternalLatteCSS.g:1269:5: (lv_style_3_1= 'solid' | lv_style_3_2= 'dashed' | lv_style_3_3= 'dotted' )
            {
            // PsiInternalLatteCSS.g:1269:5: (lv_style_3_1= 'solid' | lv_style_3_2= 'dashed' | lv_style_3_3= 'dotted' )
            int alt22=3;
            switch ( input.LA(1) ) {
            case 62:
                {
                alt22=1;
                }
                break;
            case 63:
                {
                alt22=2;
                }
                break;
            case 64:
                {
                alt22=3;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 22, 0, input);

                throw nvae;
            }

            switch (alt22) {
                case 1 :
                    // PsiInternalLatteCSS.g:1270:6: lv_style_3_1= 'solid'
                    {

                    						markLeaf(elementTypeProvider.getBorderProperty_StyleSolidKeyword_3_0_0ElementType());
                    					
                    lv_style_3_1=(Token)match(input,62,FOLLOW_25); 

                    						doneLeaf(lv_style_3_1);
                    					

                    }
                    break;
                case 2 :
                    // PsiInternalLatteCSS.g:1278:6: lv_style_3_2= 'dashed'
                    {

                    						markLeaf(elementTypeProvider.getBorderProperty_StyleDashedKeyword_3_0_1ElementType());
                    					
                    lv_style_3_2=(Token)match(input,63,FOLLOW_25); 

                    						doneLeaf(lv_style_3_2);
                    					

                    }
                    break;
                case 3 :
                    // PsiInternalLatteCSS.g:1286:6: lv_style_3_3= 'dotted'
                    {

                    						markLeaf(elementTypeProvider.getBorderProperty_StyleDottedKeyword_3_0_2ElementType());
                    					
                    lv_style_3_3=(Token)match(input,64,FOLLOW_25); 

                    						doneLeaf(lv_style_3_3);
                    					

                    }
                    break;

            }


            }


            }

            // PsiInternalLatteCSS.g:1296:3: ( (lv_color_4_0= ruleColorValue ) )?
            int alt23=2;
            int LA23_0 = input.LA(1);

            if ( (LA23_0==RULE_HEX_NUMBER||(LA23_0>=150 && LA23_0<=299)) ) {
                alt23=1;
            }
            switch (alt23) {
                case 1 :
                    // PsiInternalLatteCSS.g:1297:4: (lv_color_4_0= ruleColorValue )
                    {
                    // PsiInternalLatteCSS.g:1297:4: (lv_color_4_0= ruleColorValue )
                    // PsiInternalLatteCSS.g:1298:5: lv_color_4_0= ruleColorValue
                    {

                    					markComposite(elementTypeProvider.getBorderProperty_ColorColorValueParserRuleCall_4_0ElementType());
                    				
                    pushFollow(FOLLOW_2);
                    ruleColorValue();

                    state._fsp--;


                    					doneComposite();
                    				

                    }


                    }
                    break;

            }


            }


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
    // $ANTLR end "ruleBorderProperty"


    // $ANTLR start "entryRuleBackgroundFilterProperty"
    // PsiInternalLatteCSS.g:1311:1: entryRuleBackgroundFilterProperty : ruleBackgroundFilterProperty EOF ;
    public final void entryRuleBackgroundFilterProperty() throws RecognitionException {
        try {
            // PsiInternalLatteCSS.g:1311:34: ( ruleBackgroundFilterProperty EOF )
            // PsiInternalLatteCSS.g:1312:2: ruleBackgroundFilterProperty EOF
            {
             markComposite(elementTypeProvider.getBackgroundFilterPropertyElementType()); 
            pushFollow(FOLLOW_1);
            ruleBackgroundFilterProperty();

            state._fsp--;

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
    // PsiInternalLatteCSS.g:1317:1: ruleBackgroundFilterProperty : ( ( (lv_property_0_0= 'background-filter' ) ) otherlv_1= ':' ( (lv_color_2_0= ruleColorValue ) ) ( (lv_filter_3_0= ruleFilterValue ) )? ) ;
    public final void ruleBackgroundFilterProperty() throws RecognitionException {
        Token lv_property_0_0=null;
        Token otherlv_1=null;

        try {
            // PsiInternalLatteCSS.g:1317:29: ( ( ( (lv_property_0_0= 'background-filter' ) ) otherlv_1= ':' ( (lv_color_2_0= ruleColorValue ) ) ( (lv_filter_3_0= ruleFilterValue ) )? ) )
            // PsiInternalLatteCSS.g:1318:2: ( ( (lv_property_0_0= 'background-filter' ) ) otherlv_1= ':' ( (lv_color_2_0= ruleColorValue ) ) ( (lv_filter_3_0= ruleFilterValue ) )? )
            {
            // PsiInternalLatteCSS.g:1318:2: ( ( (lv_property_0_0= 'background-filter' ) ) otherlv_1= ':' ( (lv_color_2_0= ruleColorValue ) ) ( (lv_filter_3_0= ruleFilterValue ) )? )
            // PsiInternalLatteCSS.g:1319:3: ( (lv_property_0_0= 'background-filter' ) ) otherlv_1= ':' ( (lv_color_2_0= ruleColorValue ) ) ( (lv_filter_3_0= ruleFilterValue ) )?
            {
            // PsiInternalLatteCSS.g:1319:3: ( (lv_property_0_0= 'background-filter' ) )
            // PsiInternalLatteCSS.g:1320:4: (lv_property_0_0= 'background-filter' )
            {
            // PsiInternalLatteCSS.g:1320:4: (lv_property_0_0= 'background-filter' )
            // PsiInternalLatteCSS.g:1321:5: lv_property_0_0= 'background-filter'
            {

            					markLeaf(elementTypeProvider.getBackgroundFilterProperty_PropertyBackgroundFilterKeyword_0_0ElementType());
            				
            lv_property_0_0=(Token)match(input,65,FOLLOW_11); 

            					doneLeaf(lv_property_0_0);
            				

            }


            }


            			markLeaf(elementTypeProvider.getBackgroundFilterProperty_ColonKeyword_1ElementType());
            		
            otherlv_1=(Token)match(input,18,FOLLOW_17); 

            			doneLeaf(otherlv_1);
            		
            // PsiInternalLatteCSS.g:1337:3: ( (lv_color_2_0= ruleColorValue ) )
            // PsiInternalLatteCSS.g:1338:4: (lv_color_2_0= ruleColorValue )
            {
            // PsiInternalLatteCSS.g:1338:4: (lv_color_2_0= ruleColorValue )
            // PsiInternalLatteCSS.g:1339:5: lv_color_2_0= ruleColorValue
            {

            					markComposite(elementTypeProvider.getBackgroundFilterProperty_ColorColorValueParserRuleCall_2_0ElementType());
            				
            pushFollow(FOLLOW_26);
            ruleColorValue();

            state._fsp--;


            					doneComposite();
            				

            }


            }

            // PsiInternalLatteCSS.g:1348:3: ( (lv_filter_3_0= ruleFilterValue ) )?
            int alt24=2;
            int LA24_0 = input.LA(1);

            if ( ((LA24_0>=89 && LA24_0<=106)) ) {
                alt24=1;
            }
            switch (alt24) {
                case 1 :
                    // PsiInternalLatteCSS.g:1349:4: (lv_filter_3_0= ruleFilterValue )
                    {
                    // PsiInternalLatteCSS.g:1349:4: (lv_filter_3_0= ruleFilterValue )
                    // PsiInternalLatteCSS.g:1350:5: lv_filter_3_0= ruleFilterValue
                    {

                    					markComposite(elementTypeProvider.getBackgroundFilterProperty_FilterFilterValueParserRuleCall_3_0ElementType());
                    				
                    pushFollow(FOLLOW_2);
                    ruleFilterValue();

                    state._fsp--;


                    					doneComposite();
                    				

                    }


                    }
                    break;

            }


            }


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
    // $ANTLR end "ruleBackgroundFilterProperty"


    // $ANTLR start "entryRuleRepeatValue"
    // PsiInternalLatteCSS.g:1363:1: entryRuleRepeatValue : ruleRepeatValue EOF ;
    public final void entryRuleRepeatValue() throws RecognitionException {
        try {
            // PsiInternalLatteCSS.g:1363:21: ( ruleRepeatValue EOF )
            // PsiInternalLatteCSS.g:1364:2: ruleRepeatValue EOF
            {
             markComposite(elementTypeProvider.getRepeatValueElementType()); 
            pushFollow(FOLLOW_1);
            ruleRepeatValue();

            state._fsp--;

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
    // PsiInternalLatteCSS.g:1369:1: ruleRepeatValue : (kw= 'repeat-x' | kw= 'mirror-x' | kw= 'clamp-x' | kw= 'no-repeat-x' | kw= 'repeat-y' | kw= 'mirror-y' | kw= 'clamp-y' | kw= 'no-repeat-y' ) ;
    public final void ruleRepeatValue() throws RecognitionException {
        Token kw=null;

        try {
            // PsiInternalLatteCSS.g:1369:16: ( (kw= 'repeat-x' | kw= 'mirror-x' | kw= 'clamp-x' | kw= 'no-repeat-x' | kw= 'repeat-y' | kw= 'mirror-y' | kw= 'clamp-y' | kw= 'no-repeat-y' ) )
            // PsiInternalLatteCSS.g:1370:2: (kw= 'repeat-x' | kw= 'mirror-x' | kw= 'clamp-x' | kw= 'no-repeat-x' | kw= 'repeat-y' | kw= 'mirror-y' | kw= 'clamp-y' | kw= 'no-repeat-y' )
            {
            // PsiInternalLatteCSS.g:1370:2: (kw= 'repeat-x' | kw= 'mirror-x' | kw= 'clamp-x' | kw= 'no-repeat-x' | kw= 'repeat-y' | kw= 'mirror-y' | kw= 'clamp-y' | kw= 'no-repeat-y' )
            int alt25=8;
            switch ( input.LA(1) ) {
            case 66:
                {
                alt25=1;
                }
                break;
            case 67:
                {
                alt25=2;
                }
                break;
            case 68:
                {
                alt25=3;
                }
                break;
            case 69:
                {
                alt25=4;
                }
                break;
            case 70:
                {
                alt25=5;
                }
                break;
            case 71:
                {
                alt25=6;
                }
                break;
            case 72:
                {
                alt25=7;
                }
                break;
            case 73:
                {
                alt25=8;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 25, 0, input);

                throw nvae;
            }

            switch (alt25) {
                case 1 :
                    // PsiInternalLatteCSS.g:1371:3: kw= 'repeat-x'
                    {

                    			markLeaf(elementTypeProvider.getRepeatValue_RepeatXKeyword_0ElementType());
                    		
                    kw=(Token)match(input,66,FOLLOW_2); 

                    			doneLeaf(kw);
                    		

                    }
                    break;
                case 2 :
                    // PsiInternalLatteCSS.g:1379:3: kw= 'mirror-x'
                    {

                    			markLeaf(elementTypeProvider.getRepeatValue_MirrorXKeyword_1ElementType());
                    		
                    kw=(Token)match(input,67,FOLLOW_2); 

                    			doneLeaf(kw);
                    		

                    }
                    break;
                case 3 :
                    // PsiInternalLatteCSS.g:1387:3: kw= 'clamp-x'
                    {

                    			markLeaf(elementTypeProvider.getRepeatValue_ClampXKeyword_2ElementType());
                    		
                    kw=(Token)match(input,68,FOLLOW_2); 

                    			doneLeaf(kw);
                    		

                    }
                    break;
                case 4 :
                    // PsiInternalLatteCSS.g:1395:3: kw= 'no-repeat-x'
                    {

                    			markLeaf(elementTypeProvider.getRepeatValue_NoRepeatXKeyword_3ElementType());
                    		
                    kw=(Token)match(input,69,FOLLOW_2); 

                    			doneLeaf(kw);
                    		

                    }
                    break;
                case 5 :
                    // PsiInternalLatteCSS.g:1403:3: kw= 'repeat-y'
                    {

                    			markLeaf(elementTypeProvider.getRepeatValue_RepeatYKeyword_4ElementType());
                    		
                    kw=(Token)match(input,70,FOLLOW_2); 

                    			doneLeaf(kw);
                    		

                    }
                    break;
                case 6 :
                    // PsiInternalLatteCSS.g:1411:3: kw= 'mirror-y'
                    {

                    			markLeaf(elementTypeProvider.getRepeatValue_MirrorYKeyword_5ElementType());
                    		
                    kw=(Token)match(input,71,FOLLOW_2); 

                    			doneLeaf(kw);
                    		

                    }
                    break;
                case 7 :
                    // PsiInternalLatteCSS.g:1419:3: kw= 'clamp-y'
                    {

                    			markLeaf(elementTypeProvider.getRepeatValue_ClampYKeyword_6ElementType());
                    		
                    kw=(Token)match(input,72,FOLLOW_2); 

                    			doneLeaf(kw);
                    		

                    }
                    break;
                case 8 :
                    // PsiInternalLatteCSS.g:1427:3: kw= 'no-repeat-y'
                    {

                    			markLeaf(elementTypeProvider.getRepeatValue_NoRepeatYKeyword_7ElementType());
                    		
                    kw=(Token)match(input,73,FOLLOW_2); 

                    			doneLeaf(kw);
                    		

                    }
                    break;

            }


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
    // $ANTLR end "ruleRepeatValue"


    // $ANTLR start "entryRuleGravityValue"
    // PsiInternalLatteCSS.g:1438:1: entryRuleGravityValue : ruleGravityValue EOF ;
    public final void entryRuleGravityValue() throws RecognitionException {
        try {
            // PsiInternalLatteCSS.g:1438:22: ( ruleGravityValue EOF )
            // PsiInternalLatteCSS.g:1439:2: ruleGravityValue EOF
            {
             markComposite(elementTypeProvider.getGravityValueElementType()); 
            pushFollow(FOLLOW_1);
            ruleGravityValue();

            state._fsp--;

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
    // PsiInternalLatteCSS.g:1444:1: ruleGravityValue : (kw= 'top' | kw= 'bottom' | kw= 'left' | kw= 'right' | kw= 'center_vertical' | kw= 'fill_vertical' | kw= 'center_horizontal' | kw= 'fill_horizontal' | kw= 'center' | kw= 'fill' | kw= 'clip_vertical' | kw= 'clip_horizontal' | kw= 'start' | kw= 'end' ) ;
    public final void ruleGravityValue() throws RecognitionException {
        Token kw=null;

        try {
            // PsiInternalLatteCSS.g:1444:17: ( (kw= 'top' | kw= 'bottom' | kw= 'left' | kw= 'right' | kw= 'center_vertical' | kw= 'fill_vertical' | kw= 'center_horizontal' | kw= 'fill_horizontal' | kw= 'center' | kw= 'fill' | kw= 'clip_vertical' | kw= 'clip_horizontal' | kw= 'start' | kw= 'end' ) )
            // PsiInternalLatteCSS.g:1445:2: (kw= 'top' | kw= 'bottom' | kw= 'left' | kw= 'right' | kw= 'center_vertical' | kw= 'fill_vertical' | kw= 'center_horizontal' | kw= 'fill_horizontal' | kw= 'center' | kw= 'fill' | kw= 'clip_vertical' | kw= 'clip_horizontal' | kw= 'start' | kw= 'end' )
            {
            // PsiInternalLatteCSS.g:1445:2: (kw= 'top' | kw= 'bottom' | kw= 'left' | kw= 'right' | kw= 'center_vertical' | kw= 'fill_vertical' | kw= 'center_horizontal' | kw= 'fill_horizontal' | kw= 'center' | kw= 'fill' | kw= 'clip_vertical' | kw= 'clip_horizontal' | kw= 'start' | kw= 'end' )
            int alt26=14;
            switch ( input.LA(1) ) {
            case 74:
                {
                alt26=1;
                }
                break;
            case 75:
                {
                alt26=2;
                }
                break;
            case 76:
                {
                alt26=3;
                }
                break;
            case 77:
                {
                alt26=4;
                }
                break;
            case 78:
                {
                alt26=5;
                }
                break;
            case 79:
                {
                alt26=6;
                }
                break;
            case 80:
                {
                alt26=7;
                }
                break;
            case 81:
                {
                alt26=8;
                }
                break;
            case 82:
                {
                alt26=9;
                }
                break;
            case 83:
                {
                alt26=10;
                }
                break;
            case 84:
                {
                alt26=11;
                }
                break;
            case 85:
                {
                alt26=12;
                }
                break;
            case 86:
                {
                alt26=13;
                }
                break;
            case 87:
                {
                alt26=14;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 26, 0, input);

                throw nvae;
            }

            switch (alt26) {
                case 1 :
                    // PsiInternalLatteCSS.g:1446:3: kw= 'top'
                    {

                    			markLeaf(elementTypeProvider.getGravityValue_TopKeyword_0ElementType());
                    		
                    kw=(Token)match(input,74,FOLLOW_2); 

                    			doneLeaf(kw);
                    		

                    }
                    break;
                case 2 :
                    // PsiInternalLatteCSS.g:1454:3: kw= 'bottom'
                    {

                    			markLeaf(elementTypeProvider.getGravityValue_BottomKeyword_1ElementType());
                    		
                    kw=(Token)match(input,75,FOLLOW_2); 

                    			doneLeaf(kw);
                    		

                    }
                    break;
                case 3 :
                    // PsiInternalLatteCSS.g:1462:3: kw= 'left'
                    {

                    			markLeaf(elementTypeProvider.getGravityValue_LeftKeyword_2ElementType());
                    		
                    kw=(Token)match(input,76,FOLLOW_2); 

                    			doneLeaf(kw);
                    		

                    }
                    break;
                case 4 :
                    // PsiInternalLatteCSS.g:1470:3: kw= 'right'
                    {

                    			markLeaf(elementTypeProvider.getGravityValue_RightKeyword_3ElementType());
                    		
                    kw=(Token)match(input,77,FOLLOW_2); 

                    			doneLeaf(kw);
                    		

                    }
                    break;
                case 5 :
                    // PsiInternalLatteCSS.g:1478:3: kw= 'center_vertical'
                    {

                    			markLeaf(elementTypeProvider.getGravityValue_Center_verticalKeyword_4ElementType());
                    		
                    kw=(Token)match(input,78,FOLLOW_2); 

                    			doneLeaf(kw);
                    		

                    }
                    break;
                case 6 :
                    // PsiInternalLatteCSS.g:1486:3: kw= 'fill_vertical'
                    {

                    			markLeaf(elementTypeProvider.getGravityValue_Fill_verticalKeyword_5ElementType());
                    		
                    kw=(Token)match(input,79,FOLLOW_2); 

                    			doneLeaf(kw);
                    		

                    }
                    break;
                case 7 :
                    // PsiInternalLatteCSS.g:1494:3: kw= 'center_horizontal'
                    {

                    			markLeaf(elementTypeProvider.getGravityValue_Center_horizontalKeyword_6ElementType());
                    		
                    kw=(Token)match(input,80,FOLLOW_2); 

                    			doneLeaf(kw);
                    		

                    }
                    break;
                case 8 :
                    // PsiInternalLatteCSS.g:1502:3: kw= 'fill_horizontal'
                    {

                    			markLeaf(elementTypeProvider.getGravityValue_Fill_horizontalKeyword_7ElementType());
                    		
                    kw=(Token)match(input,81,FOLLOW_2); 

                    			doneLeaf(kw);
                    		

                    }
                    break;
                case 9 :
                    // PsiInternalLatteCSS.g:1510:3: kw= 'center'
                    {

                    			markLeaf(elementTypeProvider.getGravityValue_CenterKeyword_8ElementType());
                    		
                    kw=(Token)match(input,82,FOLLOW_2); 

                    			doneLeaf(kw);
                    		

                    }
                    break;
                case 10 :
                    // PsiInternalLatteCSS.g:1518:3: kw= 'fill'
                    {

                    			markLeaf(elementTypeProvider.getGravityValue_FillKeyword_9ElementType());
                    		
                    kw=(Token)match(input,83,FOLLOW_2); 

                    			doneLeaf(kw);
                    		

                    }
                    break;
                case 11 :
                    // PsiInternalLatteCSS.g:1526:3: kw= 'clip_vertical'
                    {

                    			markLeaf(elementTypeProvider.getGravityValue_Clip_verticalKeyword_10ElementType());
                    		
                    kw=(Token)match(input,84,FOLLOW_2); 

                    			doneLeaf(kw);
                    		

                    }
                    break;
                case 12 :
                    // PsiInternalLatteCSS.g:1534:3: kw= 'clip_horizontal'
                    {

                    			markLeaf(elementTypeProvider.getGravityValue_Clip_horizontalKeyword_11ElementType());
                    		
                    kw=(Token)match(input,85,FOLLOW_2); 

                    			doneLeaf(kw);
                    		

                    }
                    break;
                case 13 :
                    // PsiInternalLatteCSS.g:1542:3: kw= 'start'
                    {

                    			markLeaf(elementTypeProvider.getGravityValue_StartKeyword_12ElementType());
                    		
                    kw=(Token)match(input,86,FOLLOW_2); 

                    			doneLeaf(kw);
                    		

                    }
                    break;
                case 14 :
                    // PsiInternalLatteCSS.g:1550:3: kw= 'end'
                    {

                    			markLeaf(elementTypeProvider.getGravityValue_EndKeyword_13ElementType());
                    		
                    kw=(Token)match(input,87,FOLLOW_2); 

                    			doneLeaf(kw);
                    		

                    }
                    break;

            }


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
    // $ANTLR end "ruleGravityValue"


    // $ANTLR start "entryRuleBackgroundGravityProperty"
    // PsiInternalLatteCSS.g:1561:1: entryRuleBackgroundGravityProperty : ruleBackgroundGravityProperty EOF ;
    public final void entryRuleBackgroundGravityProperty() throws RecognitionException {
        try {
            // PsiInternalLatteCSS.g:1561:35: ( ruleBackgroundGravityProperty EOF )
            // PsiInternalLatteCSS.g:1562:2: ruleBackgroundGravityProperty EOF
            {
             markComposite(elementTypeProvider.getBackgroundGravityPropertyElementType()); 
            pushFollow(FOLLOW_1);
            ruleBackgroundGravityProperty();

            state._fsp--;

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
    // PsiInternalLatteCSS.g:1567:1: ruleBackgroundGravityProperty : ( ( (lv_property_0_0= 'background-gravity' ) ) otherlv_1= ':' ( (lv_values_2_0= ruleGravityValue ) ) (otherlv_3= ',' ( (lv_values_4_0= ruleGravityValue ) ) )* ) ;
    public final void ruleBackgroundGravityProperty() throws RecognitionException {
        Token lv_property_0_0=null;
        Token otherlv_1=null;
        Token otherlv_3=null;

        try {
            // PsiInternalLatteCSS.g:1567:30: ( ( ( (lv_property_0_0= 'background-gravity' ) ) otherlv_1= ':' ( (lv_values_2_0= ruleGravityValue ) ) (otherlv_3= ',' ( (lv_values_4_0= ruleGravityValue ) ) )* ) )
            // PsiInternalLatteCSS.g:1568:2: ( ( (lv_property_0_0= 'background-gravity' ) ) otherlv_1= ':' ( (lv_values_2_0= ruleGravityValue ) ) (otherlv_3= ',' ( (lv_values_4_0= ruleGravityValue ) ) )* )
            {
            // PsiInternalLatteCSS.g:1568:2: ( ( (lv_property_0_0= 'background-gravity' ) ) otherlv_1= ':' ( (lv_values_2_0= ruleGravityValue ) ) (otherlv_3= ',' ( (lv_values_4_0= ruleGravityValue ) ) )* )
            // PsiInternalLatteCSS.g:1569:3: ( (lv_property_0_0= 'background-gravity' ) ) otherlv_1= ':' ( (lv_values_2_0= ruleGravityValue ) ) (otherlv_3= ',' ( (lv_values_4_0= ruleGravityValue ) ) )*
            {
            // PsiInternalLatteCSS.g:1569:3: ( (lv_property_0_0= 'background-gravity' ) )
            // PsiInternalLatteCSS.g:1570:4: (lv_property_0_0= 'background-gravity' )
            {
            // PsiInternalLatteCSS.g:1570:4: (lv_property_0_0= 'background-gravity' )
            // PsiInternalLatteCSS.g:1571:5: lv_property_0_0= 'background-gravity'
            {

            					markLeaf(elementTypeProvider.getBackgroundGravityProperty_PropertyBackgroundGravityKeyword_0_0ElementType());
            				
            lv_property_0_0=(Token)match(input,88,FOLLOW_11); 

            					doneLeaf(lv_property_0_0);
            				

            }


            }


            			markLeaf(elementTypeProvider.getBackgroundGravityProperty_ColonKeyword_1ElementType());
            		
            otherlv_1=(Token)match(input,18,FOLLOW_27); 

            			doneLeaf(otherlv_1);
            		
            // PsiInternalLatteCSS.g:1587:3: ( (lv_values_2_0= ruleGravityValue ) )
            // PsiInternalLatteCSS.g:1588:4: (lv_values_2_0= ruleGravityValue )
            {
            // PsiInternalLatteCSS.g:1588:4: (lv_values_2_0= ruleGravityValue )
            // PsiInternalLatteCSS.g:1589:5: lv_values_2_0= ruleGravityValue
            {

            					markComposite(elementTypeProvider.getBackgroundGravityProperty_ValuesGravityValueParserRuleCall_2_0ElementType());
            				
            pushFollow(FOLLOW_19);
            ruleGravityValue();

            state._fsp--;


            					doneComposite();
            				

            }


            }

            // PsiInternalLatteCSS.g:1598:3: (otherlv_3= ',' ( (lv_values_4_0= ruleGravityValue ) ) )*
            loop27:
            do {
                int alt27=2;
                int LA27_0 = input.LA(1);

                if ( (LA27_0==13) ) {
                    alt27=1;
                }


                switch (alt27) {
            	case 1 :
            	    // PsiInternalLatteCSS.g:1599:4: otherlv_3= ',' ( (lv_values_4_0= ruleGravityValue ) )
            	    {

            	    				markLeaf(elementTypeProvider.getBackgroundGravityProperty_CommaKeyword_3_0ElementType());
            	    			
            	    otherlv_3=(Token)match(input,13,FOLLOW_27); 

            	    				doneLeaf(otherlv_3);
            	    			
            	    // PsiInternalLatteCSS.g:1606:4: ( (lv_values_4_0= ruleGravityValue ) )
            	    // PsiInternalLatteCSS.g:1607:5: (lv_values_4_0= ruleGravityValue )
            	    {
            	    // PsiInternalLatteCSS.g:1607:5: (lv_values_4_0= ruleGravityValue )
            	    // PsiInternalLatteCSS.g:1608:6: lv_values_4_0= ruleGravityValue
            	    {

            	    						markComposite(elementTypeProvider.getBackgroundGravityProperty_ValuesGravityValueParserRuleCall_3_1_0ElementType());
            	    					
            	    pushFollow(FOLLOW_19);
            	    ruleGravityValue();

            	    state._fsp--;


            	    						doneComposite();
            	    					

            	    }


            	    }


            	    }
            	    break;

            	default :
            	    break loop27;
                }
            } while (true);


            }


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
    // $ANTLR end "ruleBackgroundGravityProperty"


    // $ANTLR start "entryRuleFilterValue"
    // PsiInternalLatteCSS.g:1622:1: entryRuleFilterValue : ruleFilterValue EOF ;
    public final void entryRuleFilterValue() throws RecognitionException {
        try {
            // PsiInternalLatteCSS.g:1622:21: ( ruleFilterValue EOF )
            // PsiInternalLatteCSS.g:1623:2: ruleFilterValue EOF
            {
             markComposite(elementTypeProvider.getFilterValueElementType()); 
            pushFollow(FOLLOW_1);
            ruleFilterValue();

            state._fsp--;

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
    // PsiInternalLatteCSS.g:1628:1: ruleFilterValue : (kw= 'add' | kw= 'clear' | kw= 'darken' | kw= 'dst' | kw= 'dst_atop' | kw= 'dst_in' | kw= 'dst_out' | kw= 'dst_over' | kw= 'lighten' | kw= 'multiply' | kw= 'overlay' | kw= 'screen' | kw= 'src' | kw= 'src_atop' | kw= 'src_in' | kw= 'src_out' | kw= 'src_over' | kw= 'xor' ) ;
    public final void ruleFilterValue() throws RecognitionException {
        Token kw=null;

        try {
            // PsiInternalLatteCSS.g:1628:16: ( (kw= 'add' | kw= 'clear' | kw= 'darken' | kw= 'dst' | kw= 'dst_atop' | kw= 'dst_in' | kw= 'dst_out' | kw= 'dst_over' | kw= 'lighten' | kw= 'multiply' | kw= 'overlay' | kw= 'screen' | kw= 'src' | kw= 'src_atop' | kw= 'src_in' | kw= 'src_out' | kw= 'src_over' | kw= 'xor' ) )
            // PsiInternalLatteCSS.g:1629:2: (kw= 'add' | kw= 'clear' | kw= 'darken' | kw= 'dst' | kw= 'dst_atop' | kw= 'dst_in' | kw= 'dst_out' | kw= 'dst_over' | kw= 'lighten' | kw= 'multiply' | kw= 'overlay' | kw= 'screen' | kw= 'src' | kw= 'src_atop' | kw= 'src_in' | kw= 'src_out' | kw= 'src_over' | kw= 'xor' )
            {
            // PsiInternalLatteCSS.g:1629:2: (kw= 'add' | kw= 'clear' | kw= 'darken' | kw= 'dst' | kw= 'dst_atop' | kw= 'dst_in' | kw= 'dst_out' | kw= 'dst_over' | kw= 'lighten' | kw= 'multiply' | kw= 'overlay' | kw= 'screen' | kw= 'src' | kw= 'src_atop' | kw= 'src_in' | kw= 'src_out' | kw= 'src_over' | kw= 'xor' )
            int alt28=18;
            switch ( input.LA(1) ) {
            case 89:
                {
                alt28=1;
                }
                break;
            case 90:
                {
                alt28=2;
                }
                break;
            case 91:
                {
                alt28=3;
                }
                break;
            case 92:
                {
                alt28=4;
                }
                break;
            case 93:
                {
                alt28=5;
                }
                break;
            case 94:
                {
                alt28=6;
                }
                break;
            case 95:
                {
                alt28=7;
                }
                break;
            case 96:
                {
                alt28=8;
                }
                break;
            case 97:
                {
                alt28=9;
                }
                break;
            case 98:
                {
                alt28=10;
                }
                break;
            case 99:
                {
                alt28=11;
                }
                break;
            case 100:
                {
                alt28=12;
                }
                break;
            case 101:
                {
                alt28=13;
                }
                break;
            case 102:
                {
                alt28=14;
                }
                break;
            case 103:
                {
                alt28=15;
                }
                break;
            case 104:
                {
                alt28=16;
                }
                break;
            case 105:
                {
                alt28=17;
                }
                break;
            case 106:
                {
                alt28=18;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 28, 0, input);

                throw nvae;
            }

            switch (alt28) {
                case 1 :
                    // PsiInternalLatteCSS.g:1630:3: kw= 'add'
                    {

                    			markLeaf(elementTypeProvider.getFilterValue_AddKeyword_0ElementType());
                    		
                    kw=(Token)match(input,89,FOLLOW_2); 

                    			doneLeaf(kw);
                    		

                    }
                    break;
                case 2 :
                    // PsiInternalLatteCSS.g:1638:3: kw= 'clear'
                    {

                    			markLeaf(elementTypeProvider.getFilterValue_ClearKeyword_1ElementType());
                    		
                    kw=(Token)match(input,90,FOLLOW_2); 

                    			doneLeaf(kw);
                    		

                    }
                    break;
                case 3 :
                    // PsiInternalLatteCSS.g:1646:3: kw= 'darken'
                    {

                    			markLeaf(elementTypeProvider.getFilterValue_DarkenKeyword_2ElementType());
                    		
                    kw=(Token)match(input,91,FOLLOW_2); 

                    			doneLeaf(kw);
                    		

                    }
                    break;
                case 4 :
                    // PsiInternalLatteCSS.g:1654:3: kw= 'dst'
                    {

                    			markLeaf(elementTypeProvider.getFilterValue_DstKeyword_3ElementType());
                    		
                    kw=(Token)match(input,92,FOLLOW_2); 

                    			doneLeaf(kw);
                    		

                    }
                    break;
                case 5 :
                    // PsiInternalLatteCSS.g:1662:3: kw= 'dst_atop'
                    {

                    			markLeaf(elementTypeProvider.getFilterValue_Dst_atopKeyword_4ElementType());
                    		
                    kw=(Token)match(input,93,FOLLOW_2); 

                    			doneLeaf(kw);
                    		

                    }
                    break;
                case 6 :
                    // PsiInternalLatteCSS.g:1670:3: kw= 'dst_in'
                    {

                    			markLeaf(elementTypeProvider.getFilterValue_Dst_inKeyword_5ElementType());
                    		
                    kw=(Token)match(input,94,FOLLOW_2); 

                    			doneLeaf(kw);
                    		

                    }
                    break;
                case 7 :
                    // PsiInternalLatteCSS.g:1678:3: kw= 'dst_out'
                    {

                    			markLeaf(elementTypeProvider.getFilterValue_Dst_outKeyword_6ElementType());
                    		
                    kw=(Token)match(input,95,FOLLOW_2); 

                    			doneLeaf(kw);
                    		

                    }
                    break;
                case 8 :
                    // PsiInternalLatteCSS.g:1686:3: kw= 'dst_over'
                    {

                    			markLeaf(elementTypeProvider.getFilterValue_Dst_overKeyword_7ElementType());
                    		
                    kw=(Token)match(input,96,FOLLOW_2); 

                    			doneLeaf(kw);
                    		

                    }
                    break;
                case 9 :
                    // PsiInternalLatteCSS.g:1694:3: kw= 'lighten'
                    {

                    			markLeaf(elementTypeProvider.getFilterValue_LightenKeyword_8ElementType());
                    		
                    kw=(Token)match(input,97,FOLLOW_2); 

                    			doneLeaf(kw);
                    		

                    }
                    break;
                case 10 :
                    // PsiInternalLatteCSS.g:1702:3: kw= 'multiply'
                    {

                    			markLeaf(elementTypeProvider.getFilterValue_MultiplyKeyword_9ElementType());
                    		
                    kw=(Token)match(input,98,FOLLOW_2); 

                    			doneLeaf(kw);
                    		

                    }
                    break;
                case 11 :
                    // PsiInternalLatteCSS.g:1710:3: kw= 'overlay'
                    {

                    			markLeaf(elementTypeProvider.getFilterValue_OverlayKeyword_10ElementType());
                    		
                    kw=(Token)match(input,99,FOLLOW_2); 

                    			doneLeaf(kw);
                    		

                    }
                    break;
                case 12 :
                    // PsiInternalLatteCSS.g:1718:3: kw= 'screen'
                    {

                    			markLeaf(elementTypeProvider.getFilterValue_ScreenKeyword_11ElementType());
                    		
                    kw=(Token)match(input,100,FOLLOW_2); 

                    			doneLeaf(kw);
                    		

                    }
                    break;
                case 13 :
                    // PsiInternalLatteCSS.g:1726:3: kw= 'src'
                    {

                    			markLeaf(elementTypeProvider.getFilterValue_SrcKeyword_12ElementType());
                    		
                    kw=(Token)match(input,101,FOLLOW_2); 

                    			doneLeaf(kw);
                    		

                    }
                    break;
                case 14 :
                    // PsiInternalLatteCSS.g:1734:3: kw= 'src_atop'
                    {

                    			markLeaf(elementTypeProvider.getFilterValue_Src_atopKeyword_13ElementType());
                    		
                    kw=(Token)match(input,102,FOLLOW_2); 

                    			doneLeaf(kw);
                    		

                    }
                    break;
                case 15 :
                    // PsiInternalLatteCSS.g:1742:3: kw= 'src_in'
                    {

                    			markLeaf(elementTypeProvider.getFilterValue_Src_inKeyword_14ElementType());
                    		
                    kw=(Token)match(input,103,FOLLOW_2); 

                    			doneLeaf(kw);
                    		

                    }
                    break;
                case 16 :
                    // PsiInternalLatteCSS.g:1750:3: kw= 'src_out'
                    {

                    			markLeaf(elementTypeProvider.getFilterValue_Src_outKeyword_15ElementType());
                    		
                    kw=(Token)match(input,104,FOLLOW_2); 

                    			doneLeaf(kw);
                    		

                    }
                    break;
                case 17 :
                    // PsiInternalLatteCSS.g:1758:3: kw= 'src_over'
                    {

                    			markLeaf(elementTypeProvider.getFilterValue_Src_overKeyword_16ElementType());
                    		
                    kw=(Token)match(input,105,FOLLOW_2); 

                    			doneLeaf(kw);
                    		

                    }
                    break;
                case 18 :
                    // PsiInternalLatteCSS.g:1766:3: kw= 'xor'
                    {

                    			markLeaf(elementTypeProvider.getFilterValue_XorKeyword_17ElementType());
                    		
                    kw=(Token)match(input,106,FOLLOW_2); 

                    			doneLeaf(kw);
                    		

                    }
                    break;

            }


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
    // $ANTLR end "ruleFilterValue"


    // $ANTLR start "entryRuleBackgroundFilterTypeProperty"
    // PsiInternalLatteCSS.g:1777:1: entryRuleBackgroundFilterTypeProperty : ruleBackgroundFilterTypeProperty EOF ;
    public final void entryRuleBackgroundFilterTypeProperty() throws RecognitionException {
        try {
            // PsiInternalLatteCSS.g:1777:38: ( ruleBackgroundFilterTypeProperty EOF )
            // PsiInternalLatteCSS.g:1778:2: ruleBackgroundFilterTypeProperty EOF
            {
             markComposite(elementTypeProvider.getBackgroundFilterTypePropertyElementType()); 
            pushFollow(FOLLOW_1);
            ruleBackgroundFilterTypeProperty();

            state._fsp--;

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
    // PsiInternalLatteCSS.g:1783:1: ruleBackgroundFilterTypeProperty : ( ( (lv_property_0_0= 'background-filter-type' ) ) otherlv_1= ':' ( (lv_value_2_0= ruleFilterValue ) ) ) ;
    public final void ruleBackgroundFilterTypeProperty() throws RecognitionException {
        Token lv_property_0_0=null;
        Token otherlv_1=null;

        try {
            // PsiInternalLatteCSS.g:1783:33: ( ( ( (lv_property_0_0= 'background-filter-type' ) ) otherlv_1= ':' ( (lv_value_2_0= ruleFilterValue ) ) ) )
            // PsiInternalLatteCSS.g:1784:2: ( ( (lv_property_0_0= 'background-filter-type' ) ) otherlv_1= ':' ( (lv_value_2_0= ruleFilterValue ) ) )
            {
            // PsiInternalLatteCSS.g:1784:2: ( ( (lv_property_0_0= 'background-filter-type' ) ) otherlv_1= ':' ( (lv_value_2_0= ruleFilterValue ) ) )
            // PsiInternalLatteCSS.g:1785:3: ( (lv_property_0_0= 'background-filter-type' ) ) otherlv_1= ':' ( (lv_value_2_0= ruleFilterValue ) )
            {
            // PsiInternalLatteCSS.g:1785:3: ( (lv_property_0_0= 'background-filter-type' ) )
            // PsiInternalLatteCSS.g:1786:4: (lv_property_0_0= 'background-filter-type' )
            {
            // PsiInternalLatteCSS.g:1786:4: (lv_property_0_0= 'background-filter-type' )
            // PsiInternalLatteCSS.g:1787:5: lv_property_0_0= 'background-filter-type'
            {

            					markLeaf(elementTypeProvider.getBackgroundFilterTypeProperty_PropertyBackgroundFilterTypeKeyword_0_0ElementType());
            				
            lv_property_0_0=(Token)match(input,107,FOLLOW_11); 

            					doneLeaf(lv_property_0_0);
            				

            }


            }


            			markLeaf(elementTypeProvider.getBackgroundFilterTypeProperty_ColonKeyword_1ElementType());
            		
            otherlv_1=(Token)match(input,18,FOLLOW_28); 

            			doneLeaf(otherlv_1);
            		
            // PsiInternalLatteCSS.g:1803:3: ( (lv_value_2_0= ruleFilterValue ) )
            // PsiInternalLatteCSS.g:1804:4: (lv_value_2_0= ruleFilterValue )
            {
            // PsiInternalLatteCSS.g:1804:4: (lv_value_2_0= ruleFilterValue )
            // PsiInternalLatteCSS.g:1805:5: lv_value_2_0= ruleFilterValue
            {

            					markComposite(elementTypeProvider.getBackgroundFilterTypeProperty_ValueFilterValueParserRuleCall_2_0ElementType());
            				
            pushFollow(FOLLOW_2);
            ruleFilterValue();

            state._fsp--;


            					doneComposite();
            				

            }


            }


            }


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
    // $ANTLR end "ruleBackgroundFilterTypeProperty"


    // $ANTLR start "entryRuleShorthandColorProperty"
    // PsiInternalLatteCSS.g:1818:1: entryRuleShorthandColorProperty : ruleShorthandColorProperty EOF ;
    public final void entryRuleShorthandColorProperty() throws RecognitionException {
        try {
            // PsiInternalLatteCSS.g:1818:32: ( ruleShorthandColorProperty EOF )
            // PsiInternalLatteCSS.g:1819:2: ruleShorthandColorProperty EOF
            {
             markComposite(elementTypeProvider.getShorthandColorPropertyElementType()); 
            pushFollow(FOLLOW_1);
            ruleShorthandColorProperty();

            state._fsp--;

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
    // PsiInternalLatteCSS.g:1824:1: ruleShorthandColorProperty : ( ( (lv_property_0_0= 'border-color' ) ) otherlv_1= ':' ( (lv_values_2_0= ruleColorValue ) )+ ) ;
    public final void ruleShorthandColorProperty() throws RecognitionException {
        Token lv_property_0_0=null;
        Token otherlv_1=null;

        try {
            // PsiInternalLatteCSS.g:1824:27: ( ( ( (lv_property_0_0= 'border-color' ) ) otherlv_1= ':' ( (lv_values_2_0= ruleColorValue ) )+ ) )
            // PsiInternalLatteCSS.g:1825:2: ( ( (lv_property_0_0= 'border-color' ) ) otherlv_1= ':' ( (lv_values_2_0= ruleColorValue ) )+ )
            {
            // PsiInternalLatteCSS.g:1825:2: ( ( (lv_property_0_0= 'border-color' ) ) otherlv_1= ':' ( (lv_values_2_0= ruleColorValue ) )+ )
            // PsiInternalLatteCSS.g:1826:3: ( (lv_property_0_0= 'border-color' ) ) otherlv_1= ':' ( (lv_values_2_0= ruleColorValue ) )+
            {
            // PsiInternalLatteCSS.g:1826:3: ( (lv_property_0_0= 'border-color' ) )
            // PsiInternalLatteCSS.g:1827:4: (lv_property_0_0= 'border-color' )
            {
            // PsiInternalLatteCSS.g:1827:4: (lv_property_0_0= 'border-color' )
            // PsiInternalLatteCSS.g:1828:5: lv_property_0_0= 'border-color'
            {

            					markLeaf(elementTypeProvider.getShorthandColorProperty_PropertyBorderColorKeyword_0_0ElementType());
            				
            lv_property_0_0=(Token)match(input,108,FOLLOW_11); 

            					doneLeaf(lv_property_0_0);
            				

            }


            }


            			markLeaf(elementTypeProvider.getShorthandColorProperty_ColonKeyword_1ElementType());
            		
            otherlv_1=(Token)match(input,18,FOLLOW_17); 

            			doneLeaf(otherlv_1);
            		
            // PsiInternalLatteCSS.g:1844:3: ( (lv_values_2_0= ruleColorValue ) )+
            int cnt29=0;
            loop29:
            do {
                int alt29=2;
                int LA29_0 = input.LA(1);

                if ( (LA29_0==RULE_HEX_NUMBER||(LA29_0>=150 && LA29_0<=299)) ) {
                    alt29=1;
                }


                switch (alt29) {
            	case 1 :
            	    // PsiInternalLatteCSS.g:1845:4: (lv_values_2_0= ruleColorValue )
            	    {
            	    // PsiInternalLatteCSS.g:1845:4: (lv_values_2_0= ruleColorValue )
            	    // PsiInternalLatteCSS.g:1846:5: lv_values_2_0= ruleColorValue
            	    {

            	    					markComposite(elementTypeProvider.getShorthandColorProperty_ValuesColorValueParserRuleCall_2_0ElementType());
            	    				
            	    pushFollow(FOLLOW_25);
            	    ruleColorValue();

            	    state._fsp--;


            	    					doneComposite();
            	    				

            	    }


            	    }
            	    break;

            	default :
            	    if ( cnt29 >= 1 ) break loop29;
                        EarlyExitException eee =
                            new EarlyExitException(29, input);
                        throw eee;
                }
                cnt29++;
            } while (true);


            }


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
    // $ANTLR end "ruleShorthandColorProperty"


    // $ANTLR start "entryRuleColorProperty"
    // PsiInternalLatteCSS.g:1859:1: entryRuleColorProperty : ruleColorProperty EOF ;
    public final void entryRuleColorProperty() throws RecognitionException {
        try {
            // PsiInternalLatteCSS.g:1859:23: ( ruleColorProperty EOF )
            // PsiInternalLatteCSS.g:1860:2: ruleColorProperty EOF
            {
             markComposite(elementTypeProvider.getColorPropertyElementType()); 
            pushFollow(FOLLOW_1);
            ruleColorProperty();

            state._fsp--;

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
    // PsiInternalLatteCSS.g:1865:1: ruleColorProperty : ( ( ( (lv_property_0_1= 'border-top-color' | lv_property_0_2= 'border-left-color' | lv_property_0_3= 'border-right-color' | lv_property_0_4= 'border-bottom-color' | lv_property_0_5= 'ripple-color' | lv_property_0_6= 'background-color' | lv_property_0_7= 'text-color' | lv_property_0_8= 'background-filter-color' ) ) ) otherlv_1= ':' ( (lv_value_2_0= ruleColorValue ) ) ) ;
    public final void ruleColorProperty() throws RecognitionException {
        Token lv_property_0_1=null;
        Token lv_property_0_2=null;
        Token lv_property_0_3=null;
        Token lv_property_0_4=null;
        Token lv_property_0_5=null;
        Token lv_property_0_6=null;
        Token lv_property_0_7=null;
        Token lv_property_0_8=null;
        Token otherlv_1=null;

        try {
            // PsiInternalLatteCSS.g:1865:18: ( ( ( ( (lv_property_0_1= 'border-top-color' | lv_property_0_2= 'border-left-color' | lv_property_0_3= 'border-right-color' | lv_property_0_4= 'border-bottom-color' | lv_property_0_5= 'ripple-color' | lv_property_0_6= 'background-color' | lv_property_0_7= 'text-color' | lv_property_0_8= 'background-filter-color' ) ) ) otherlv_1= ':' ( (lv_value_2_0= ruleColorValue ) ) ) )
            // PsiInternalLatteCSS.g:1866:2: ( ( ( (lv_property_0_1= 'border-top-color' | lv_property_0_2= 'border-left-color' | lv_property_0_3= 'border-right-color' | lv_property_0_4= 'border-bottom-color' | lv_property_0_5= 'ripple-color' | lv_property_0_6= 'background-color' | lv_property_0_7= 'text-color' | lv_property_0_8= 'background-filter-color' ) ) ) otherlv_1= ':' ( (lv_value_2_0= ruleColorValue ) ) )
            {
            // PsiInternalLatteCSS.g:1866:2: ( ( ( (lv_property_0_1= 'border-top-color' | lv_property_0_2= 'border-left-color' | lv_property_0_3= 'border-right-color' | lv_property_0_4= 'border-bottom-color' | lv_property_0_5= 'ripple-color' | lv_property_0_6= 'background-color' | lv_property_0_7= 'text-color' | lv_property_0_8= 'background-filter-color' ) ) ) otherlv_1= ':' ( (lv_value_2_0= ruleColorValue ) ) )
            // PsiInternalLatteCSS.g:1867:3: ( ( (lv_property_0_1= 'border-top-color' | lv_property_0_2= 'border-left-color' | lv_property_0_3= 'border-right-color' | lv_property_0_4= 'border-bottom-color' | lv_property_0_5= 'ripple-color' | lv_property_0_6= 'background-color' | lv_property_0_7= 'text-color' | lv_property_0_8= 'background-filter-color' ) ) ) otherlv_1= ':' ( (lv_value_2_0= ruleColorValue ) )
            {
            // PsiInternalLatteCSS.g:1867:3: ( ( (lv_property_0_1= 'border-top-color' | lv_property_0_2= 'border-left-color' | lv_property_0_3= 'border-right-color' | lv_property_0_4= 'border-bottom-color' | lv_property_0_5= 'ripple-color' | lv_property_0_6= 'background-color' | lv_property_0_7= 'text-color' | lv_property_0_8= 'background-filter-color' ) ) )
            // PsiInternalLatteCSS.g:1868:4: ( (lv_property_0_1= 'border-top-color' | lv_property_0_2= 'border-left-color' | lv_property_0_3= 'border-right-color' | lv_property_0_4= 'border-bottom-color' | lv_property_0_5= 'ripple-color' | lv_property_0_6= 'background-color' | lv_property_0_7= 'text-color' | lv_property_0_8= 'background-filter-color' ) )
            {
            // PsiInternalLatteCSS.g:1868:4: ( (lv_property_0_1= 'border-top-color' | lv_property_0_2= 'border-left-color' | lv_property_0_3= 'border-right-color' | lv_property_0_4= 'border-bottom-color' | lv_property_0_5= 'ripple-color' | lv_property_0_6= 'background-color' | lv_property_0_7= 'text-color' | lv_property_0_8= 'background-filter-color' ) )
            // PsiInternalLatteCSS.g:1869:5: (lv_property_0_1= 'border-top-color' | lv_property_0_2= 'border-left-color' | lv_property_0_3= 'border-right-color' | lv_property_0_4= 'border-bottom-color' | lv_property_0_5= 'ripple-color' | lv_property_0_6= 'background-color' | lv_property_0_7= 'text-color' | lv_property_0_8= 'background-filter-color' )
            {
            // PsiInternalLatteCSS.g:1869:5: (lv_property_0_1= 'border-top-color' | lv_property_0_2= 'border-left-color' | lv_property_0_3= 'border-right-color' | lv_property_0_4= 'border-bottom-color' | lv_property_0_5= 'ripple-color' | lv_property_0_6= 'background-color' | lv_property_0_7= 'text-color' | lv_property_0_8= 'background-filter-color' )
            int alt30=8;
            switch ( input.LA(1) ) {
            case 109:
                {
                alt30=1;
                }
                break;
            case 110:
                {
                alt30=2;
                }
                break;
            case 111:
                {
                alt30=3;
                }
                break;
            case 112:
                {
                alt30=4;
                }
                break;
            case 113:
                {
                alt30=5;
                }
                break;
            case 114:
                {
                alt30=6;
                }
                break;
            case 115:
                {
                alt30=7;
                }
                break;
            case 116:
                {
                alt30=8;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 30, 0, input);

                throw nvae;
            }

            switch (alt30) {
                case 1 :
                    // PsiInternalLatteCSS.g:1870:6: lv_property_0_1= 'border-top-color'
                    {

                    						markLeaf(elementTypeProvider.getColorProperty_PropertyBorderTopColorKeyword_0_0_0ElementType());
                    					
                    lv_property_0_1=(Token)match(input,109,FOLLOW_11); 

                    						doneLeaf(lv_property_0_1);
                    					

                    }
                    break;
                case 2 :
                    // PsiInternalLatteCSS.g:1878:6: lv_property_0_2= 'border-left-color'
                    {

                    						markLeaf(elementTypeProvider.getColorProperty_PropertyBorderLeftColorKeyword_0_0_1ElementType());
                    					
                    lv_property_0_2=(Token)match(input,110,FOLLOW_11); 

                    						doneLeaf(lv_property_0_2);
                    					

                    }
                    break;
                case 3 :
                    // PsiInternalLatteCSS.g:1886:6: lv_property_0_3= 'border-right-color'
                    {

                    						markLeaf(elementTypeProvider.getColorProperty_PropertyBorderRightColorKeyword_0_0_2ElementType());
                    					
                    lv_property_0_3=(Token)match(input,111,FOLLOW_11); 

                    						doneLeaf(lv_property_0_3);
                    					

                    }
                    break;
                case 4 :
                    // PsiInternalLatteCSS.g:1894:6: lv_property_0_4= 'border-bottom-color'
                    {

                    						markLeaf(elementTypeProvider.getColorProperty_PropertyBorderBottomColorKeyword_0_0_3ElementType());
                    					
                    lv_property_0_4=(Token)match(input,112,FOLLOW_11); 

                    						doneLeaf(lv_property_0_4);
                    					

                    }
                    break;
                case 5 :
                    // PsiInternalLatteCSS.g:1902:6: lv_property_0_5= 'ripple-color'
                    {

                    						markLeaf(elementTypeProvider.getColorProperty_PropertyRippleColorKeyword_0_0_4ElementType());
                    					
                    lv_property_0_5=(Token)match(input,113,FOLLOW_11); 

                    						doneLeaf(lv_property_0_5);
                    					

                    }
                    break;
                case 6 :
                    // PsiInternalLatteCSS.g:1910:6: lv_property_0_6= 'background-color'
                    {

                    						markLeaf(elementTypeProvider.getColorProperty_PropertyBackgroundColorKeyword_0_0_5ElementType());
                    					
                    lv_property_0_6=(Token)match(input,114,FOLLOW_11); 

                    						doneLeaf(lv_property_0_6);
                    					

                    }
                    break;
                case 7 :
                    // PsiInternalLatteCSS.g:1918:6: lv_property_0_7= 'text-color'
                    {

                    						markLeaf(elementTypeProvider.getColorProperty_PropertyTextColorKeyword_0_0_6ElementType());
                    					
                    lv_property_0_7=(Token)match(input,115,FOLLOW_11); 

                    						doneLeaf(lv_property_0_7);
                    					

                    }
                    break;
                case 8 :
                    // PsiInternalLatteCSS.g:1926:6: lv_property_0_8= 'background-filter-color'
                    {

                    						markLeaf(elementTypeProvider.getColorProperty_PropertyBackgroundFilterColorKeyword_0_0_7ElementType());
                    					
                    lv_property_0_8=(Token)match(input,116,FOLLOW_11); 

                    						doneLeaf(lv_property_0_8);
                    					

                    }
                    break;

            }


            }


            }


            			markLeaf(elementTypeProvider.getColorProperty_ColonKeyword_1ElementType());
            		
            otherlv_1=(Token)match(input,18,FOLLOW_17); 

            			doneLeaf(otherlv_1);
            		
            // PsiInternalLatteCSS.g:1943:3: ( (lv_value_2_0= ruleColorValue ) )
            // PsiInternalLatteCSS.g:1944:4: (lv_value_2_0= ruleColorValue )
            {
            // PsiInternalLatteCSS.g:1944:4: (lv_value_2_0= ruleColorValue )
            // PsiInternalLatteCSS.g:1945:5: lv_value_2_0= ruleColorValue
            {

            					markComposite(elementTypeProvider.getColorProperty_ValueColorValueParserRuleCall_2_0ElementType());
            				
            pushFollow(FOLLOW_2);
            ruleColorValue();

            state._fsp--;


            					doneComposite();
            				

            }


            }


            }


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
    // $ANTLR end "ruleColorProperty"


    // $ANTLR start "entryRuleAlignmentProperty"
    // PsiInternalLatteCSS.g:1958:1: entryRuleAlignmentProperty : ruleAlignmentProperty EOF ;
    public final void entryRuleAlignmentProperty() throws RecognitionException {
        try {
            // PsiInternalLatteCSS.g:1958:27: ( ruleAlignmentProperty EOF )
            // PsiInternalLatteCSS.g:1959:2: ruleAlignmentProperty EOF
            {
             markComposite(elementTypeProvider.getAlignmentPropertyElementType()); 
            pushFollow(FOLLOW_1);
            ruleAlignmentProperty();

            state._fsp--;

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
    // PsiInternalLatteCSS.g:1964:1: ruleAlignmentProperty : ( ( (lv_property_0_0= 'text-align' ) ) otherlv_1= ':' ( ( (lv_value_2_1= 'left' | lv_value_2_2= 'center' | lv_value_2_3= 'right' | lv_value_2_4= 'justify' ) ) ) ) ;
    public final void ruleAlignmentProperty() throws RecognitionException {
        Token lv_property_0_0=null;
        Token otherlv_1=null;
        Token lv_value_2_1=null;
        Token lv_value_2_2=null;
        Token lv_value_2_3=null;
        Token lv_value_2_4=null;

        try {
            // PsiInternalLatteCSS.g:1964:22: ( ( ( (lv_property_0_0= 'text-align' ) ) otherlv_1= ':' ( ( (lv_value_2_1= 'left' | lv_value_2_2= 'center' | lv_value_2_3= 'right' | lv_value_2_4= 'justify' ) ) ) ) )
            // PsiInternalLatteCSS.g:1965:2: ( ( (lv_property_0_0= 'text-align' ) ) otherlv_1= ':' ( ( (lv_value_2_1= 'left' | lv_value_2_2= 'center' | lv_value_2_3= 'right' | lv_value_2_4= 'justify' ) ) ) )
            {
            // PsiInternalLatteCSS.g:1965:2: ( ( (lv_property_0_0= 'text-align' ) ) otherlv_1= ':' ( ( (lv_value_2_1= 'left' | lv_value_2_2= 'center' | lv_value_2_3= 'right' | lv_value_2_4= 'justify' ) ) ) )
            // PsiInternalLatteCSS.g:1966:3: ( (lv_property_0_0= 'text-align' ) ) otherlv_1= ':' ( ( (lv_value_2_1= 'left' | lv_value_2_2= 'center' | lv_value_2_3= 'right' | lv_value_2_4= 'justify' ) ) )
            {
            // PsiInternalLatteCSS.g:1966:3: ( (lv_property_0_0= 'text-align' ) )
            // PsiInternalLatteCSS.g:1967:4: (lv_property_0_0= 'text-align' )
            {
            // PsiInternalLatteCSS.g:1967:4: (lv_property_0_0= 'text-align' )
            // PsiInternalLatteCSS.g:1968:5: lv_property_0_0= 'text-align'
            {

            					markLeaf(elementTypeProvider.getAlignmentProperty_PropertyTextAlignKeyword_0_0ElementType());
            				
            lv_property_0_0=(Token)match(input,117,FOLLOW_11); 

            					doneLeaf(lv_property_0_0);
            				

            }


            }


            			markLeaf(elementTypeProvider.getAlignmentProperty_ColonKeyword_1ElementType());
            		
            otherlv_1=(Token)match(input,18,FOLLOW_29); 

            			doneLeaf(otherlv_1);
            		
            // PsiInternalLatteCSS.g:1984:3: ( ( (lv_value_2_1= 'left' | lv_value_2_2= 'center' | lv_value_2_3= 'right' | lv_value_2_4= 'justify' ) ) )
            // PsiInternalLatteCSS.g:1985:4: ( (lv_value_2_1= 'left' | lv_value_2_2= 'center' | lv_value_2_3= 'right' | lv_value_2_4= 'justify' ) )
            {
            // PsiInternalLatteCSS.g:1985:4: ( (lv_value_2_1= 'left' | lv_value_2_2= 'center' | lv_value_2_3= 'right' | lv_value_2_4= 'justify' ) )
            // PsiInternalLatteCSS.g:1986:5: (lv_value_2_1= 'left' | lv_value_2_2= 'center' | lv_value_2_3= 'right' | lv_value_2_4= 'justify' )
            {
            // PsiInternalLatteCSS.g:1986:5: (lv_value_2_1= 'left' | lv_value_2_2= 'center' | lv_value_2_3= 'right' | lv_value_2_4= 'justify' )
            int alt31=4;
            switch ( input.LA(1) ) {
            case 76:
                {
                alt31=1;
                }
                break;
            case 82:
                {
                alt31=2;
                }
                break;
            case 77:
                {
                alt31=3;
                }
                break;
            case 118:
                {
                alt31=4;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 31, 0, input);

                throw nvae;
            }

            switch (alt31) {
                case 1 :
                    // PsiInternalLatteCSS.g:1987:6: lv_value_2_1= 'left'
                    {

                    						markLeaf(elementTypeProvider.getAlignmentProperty_ValueLeftKeyword_2_0_0ElementType());
                    					
                    lv_value_2_1=(Token)match(input,76,FOLLOW_2); 

                    						doneLeaf(lv_value_2_1);
                    					

                    }
                    break;
                case 2 :
                    // PsiInternalLatteCSS.g:1995:6: lv_value_2_2= 'center'
                    {

                    						markLeaf(elementTypeProvider.getAlignmentProperty_ValueCenterKeyword_2_0_1ElementType());
                    					
                    lv_value_2_2=(Token)match(input,82,FOLLOW_2); 

                    						doneLeaf(lv_value_2_2);
                    					

                    }
                    break;
                case 3 :
                    // PsiInternalLatteCSS.g:2003:6: lv_value_2_3= 'right'
                    {

                    						markLeaf(elementTypeProvider.getAlignmentProperty_ValueRightKeyword_2_0_2ElementType());
                    					
                    lv_value_2_3=(Token)match(input,77,FOLLOW_2); 

                    						doneLeaf(lv_value_2_3);
                    					

                    }
                    break;
                case 4 :
                    // PsiInternalLatteCSS.g:2011:6: lv_value_2_4= 'justify'
                    {

                    						markLeaf(elementTypeProvider.getAlignmentProperty_ValueJustifyKeyword_2_0_3ElementType());
                    					
                    lv_value_2_4=(Token)match(input,118,FOLLOW_2); 

                    						doneLeaf(lv_value_2_4);
                    					

                    }
                    break;

            }


            }


            }


            }


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
    // $ANTLR end "ruleAlignmentProperty"


    // $ANTLR start "entryRuleTimingFunction"
    // PsiInternalLatteCSS.g:2025:1: entryRuleTimingFunction : ruleTimingFunction EOF ;
    public final void entryRuleTimingFunction() throws RecognitionException {
        try {
            // PsiInternalLatteCSS.g:2025:24: ( ruleTimingFunction EOF )
            // PsiInternalLatteCSS.g:2026:2: ruleTimingFunction EOF
            {
             markComposite(elementTypeProvider.getTimingFunctionElementType()); 
            pushFollow(FOLLOW_1);
            ruleTimingFunction();

            state._fsp--;

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
    // PsiInternalLatteCSS.g:2031:1: ruleTimingFunction : (kw= 'accelerate-decelerate' | kw= 'accelerate' | kw= 'anticipate' | kw= 'anticipate-overshoot' | kw= 'bounce' | kw= 'cycle' | kw= 'decelerate' | kw= 'fast-out' | kw= 'fast-out-slow' | kw= 'linear' | kw= 'linear-out' | kw= 'overshoot' ) ;
    public final void ruleTimingFunction() throws RecognitionException {
        Token kw=null;

        try {
            // PsiInternalLatteCSS.g:2031:19: ( (kw= 'accelerate-decelerate' | kw= 'accelerate' | kw= 'anticipate' | kw= 'anticipate-overshoot' | kw= 'bounce' | kw= 'cycle' | kw= 'decelerate' | kw= 'fast-out' | kw= 'fast-out-slow' | kw= 'linear' | kw= 'linear-out' | kw= 'overshoot' ) )
            // PsiInternalLatteCSS.g:2032:2: (kw= 'accelerate-decelerate' | kw= 'accelerate' | kw= 'anticipate' | kw= 'anticipate-overshoot' | kw= 'bounce' | kw= 'cycle' | kw= 'decelerate' | kw= 'fast-out' | kw= 'fast-out-slow' | kw= 'linear' | kw= 'linear-out' | kw= 'overshoot' )
            {
            // PsiInternalLatteCSS.g:2032:2: (kw= 'accelerate-decelerate' | kw= 'accelerate' | kw= 'anticipate' | kw= 'anticipate-overshoot' | kw= 'bounce' | kw= 'cycle' | kw= 'decelerate' | kw= 'fast-out' | kw= 'fast-out-slow' | kw= 'linear' | kw= 'linear-out' | kw= 'overshoot' )
            int alt32=12;
            switch ( input.LA(1) ) {
            case 119:
                {
                alt32=1;
                }
                break;
            case 120:
                {
                alt32=2;
                }
                break;
            case 121:
                {
                alt32=3;
                }
                break;
            case 122:
                {
                alt32=4;
                }
                break;
            case 123:
                {
                alt32=5;
                }
                break;
            case 124:
                {
                alt32=6;
                }
                break;
            case 125:
                {
                alt32=7;
                }
                break;
            case 126:
                {
                alt32=8;
                }
                break;
            case 127:
                {
                alt32=9;
                }
                break;
            case 128:
                {
                alt32=10;
                }
                break;
            case 129:
                {
                alt32=11;
                }
                break;
            case 130:
                {
                alt32=12;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 32, 0, input);

                throw nvae;
            }

            switch (alt32) {
                case 1 :
                    // PsiInternalLatteCSS.g:2033:3: kw= 'accelerate-decelerate'
                    {

                    			markLeaf(elementTypeProvider.getTimingFunction_AccelerateDecelerateKeyword_0ElementType());
                    		
                    kw=(Token)match(input,119,FOLLOW_2); 

                    			doneLeaf(kw);
                    		

                    }
                    break;
                case 2 :
                    // PsiInternalLatteCSS.g:2041:3: kw= 'accelerate'
                    {

                    			markLeaf(elementTypeProvider.getTimingFunction_AccelerateKeyword_1ElementType());
                    		
                    kw=(Token)match(input,120,FOLLOW_2); 

                    			doneLeaf(kw);
                    		

                    }
                    break;
                case 3 :
                    // PsiInternalLatteCSS.g:2049:3: kw= 'anticipate'
                    {

                    			markLeaf(elementTypeProvider.getTimingFunction_AnticipateKeyword_2ElementType());
                    		
                    kw=(Token)match(input,121,FOLLOW_2); 

                    			doneLeaf(kw);
                    		

                    }
                    break;
                case 4 :
                    // PsiInternalLatteCSS.g:2057:3: kw= 'anticipate-overshoot'
                    {

                    			markLeaf(elementTypeProvider.getTimingFunction_AnticipateOvershootKeyword_3ElementType());
                    		
                    kw=(Token)match(input,122,FOLLOW_2); 

                    			doneLeaf(kw);
                    		

                    }
                    break;
                case 5 :
                    // PsiInternalLatteCSS.g:2065:3: kw= 'bounce'
                    {

                    			markLeaf(elementTypeProvider.getTimingFunction_BounceKeyword_4ElementType());
                    		
                    kw=(Token)match(input,123,FOLLOW_2); 

                    			doneLeaf(kw);
                    		

                    }
                    break;
                case 6 :
                    // PsiInternalLatteCSS.g:2073:3: kw= 'cycle'
                    {

                    			markLeaf(elementTypeProvider.getTimingFunction_CycleKeyword_5ElementType());
                    		
                    kw=(Token)match(input,124,FOLLOW_2); 

                    			doneLeaf(kw);
                    		

                    }
                    break;
                case 7 :
                    // PsiInternalLatteCSS.g:2081:3: kw= 'decelerate'
                    {

                    			markLeaf(elementTypeProvider.getTimingFunction_DecelerateKeyword_6ElementType());
                    		
                    kw=(Token)match(input,125,FOLLOW_2); 

                    			doneLeaf(kw);
                    		

                    }
                    break;
                case 8 :
                    // PsiInternalLatteCSS.g:2089:3: kw= 'fast-out'
                    {

                    			markLeaf(elementTypeProvider.getTimingFunction_FastOutKeyword_7ElementType());
                    		
                    kw=(Token)match(input,126,FOLLOW_2); 

                    			doneLeaf(kw);
                    		

                    }
                    break;
                case 9 :
                    // PsiInternalLatteCSS.g:2097:3: kw= 'fast-out-slow'
                    {

                    			markLeaf(elementTypeProvider.getTimingFunction_FastOutSlowKeyword_8ElementType());
                    		
                    kw=(Token)match(input,127,FOLLOW_2); 

                    			doneLeaf(kw);
                    		

                    }
                    break;
                case 10 :
                    // PsiInternalLatteCSS.g:2105:3: kw= 'linear'
                    {

                    			markLeaf(elementTypeProvider.getTimingFunction_LinearKeyword_9ElementType());
                    		
                    kw=(Token)match(input,128,FOLLOW_2); 

                    			doneLeaf(kw);
                    		

                    }
                    break;
                case 11 :
                    // PsiInternalLatteCSS.g:2113:3: kw= 'linear-out'
                    {

                    			markLeaf(elementTypeProvider.getTimingFunction_LinearOutKeyword_10ElementType());
                    		
                    kw=(Token)match(input,129,FOLLOW_2); 

                    			doneLeaf(kw);
                    		

                    }
                    break;
                case 12 :
                    // PsiInternalLatteCSS.g:2121:3: kw= 'overshoot'
                    {

                    			markLeaf(elementTypeProvider.getTimingFunction_OvershootKeyword_11ElementType());
                    		
                    kw=(Token)match(input,130,FOLLOW_2); 

                    			doneLeaf(kw);
                    		

                    }
                    break;

            }


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
    // $ANTLR end "ruleTimingFunction"


    // $ANTLR start "entryRulePropertyNameValue"
    // PsiInternalLatteCSS.g:2132:1: entryRulePropertyNameValue : rulePropertyNameValue EOF ;
    public final void entryRulePropertyNameValue() throws RecognitionException {
        try {
            // PsiInternalLatteCSS.g:2132:27: ( rulePropertyNameValue EOF )
            // PsiInternalLatteCSS.g:2133:2: rulePropertyNameValue EOF
            {
             markComposite(elementTypeProvider.getPropertyNameValueElementType()); 
            pushFollow(FOLLOW_1);
            rulePropertyNameValue();

            state._fsp--;

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
    // PsiInternalLatteCSS.g:2138:1: rulePropertyNameValue : (kw= 'margin' | kw= 'margin-top' | kw= 'margin-bottom' | kw= 'margin-left' | kw= 'margin-right' | kw= 'padding' | kw= 'padding-top' | kw= 'padding-bottom' | kw= 'padding-left' | kw= 'padding-right' | kw= 'width' | kw= 'height' | kw= 'translateX' | kw= 'translateY' | kw= 'x' | kw= 'y' | kw= 'elevation' | kw= 'font-size' | kw= 'border-radius' | kw= 'border-top-left-radius' | kw= 'border-top-right-radius' | kw= 'border-bottom-left-radius' | kw= 'border-bottom-right-radius' | kw= 'border-width' | kw= 'border-left-width' | kw= 'border-right-width' | kw= 'border-top-width' | kw= 'border-bottom-width' | kw= 'border' ) ;
    public final void rulePropertyNameValue() throws RecognitionException {
        Token kw=null;

        try {
            // PsiInternalLatteCSS.g:2138:22: ( (kw= 'margin' | kw= 'margin-top' | kw= 'margin-bottom' | kw= 'margin-left' | kw= 'margin-right' | kw= 'padding' | kw= 'padding-top' | kw= 'padding-bottom' | kw= 'padding-left' | kw= 'padding-right' | kw= 'width' | kw= 'height' | kw= 'translateX' | kw= 'translateY' | kw= 'x' | kw= 'y' | kw= 'elevation' | kw= 'font-size' | kw= 'border-radius' | kw= 'border-top-left-radius' | kw= 'border-top-right-radius' | kw= 'border-bottom-left-radius' | kw= 'border-bottom-right-radius' | kw= 'border-width' | kw= 'border-left-width' | kw= 'border-right-width' | kw= 'border-top-width' | kw= 'border-bottom-width' | kw= 'border' ) )
            // PsiInternalLatteCSS.g:2139:2: (kw= 'margin' | kw= 'margin-top' | kw= 'margin-bottom' | kw= 'margin-left' | kw= 'margin-right' | kw= 'padding' | kw= 'padding-top' | kw= 'padding-bottom' | kw= 'padding-left' | kw= 'padding-right' | kw= 'width' | kw= 'height' | kw= 'translateX' | kw= 'translateY' | kw= 'x' | kw= 'y' | kw= 'elevation' | kw= 'font-size' | kw= 'border-radius' | kw= 'border-top-left-radius' | kw= 'border-top-right-radius' | kw= 'border-bottom-left-radius' | kw= 'border-bottom-right-radius' | kw= 'border-width' | kw= 'border-left-width' | kw= 'border-right-width' | kw= 'border-top-width' | kw= 'border-bottom-width' | kw= 'border' )
            {
            // PsiInternalLatteCSS.g:2139:2: (kw= 'margin' | kw= 'margin-top' | kw= 'margin-bottom' | kw= 'margin-left' | kw= 'margin-right' | kw= 'padding' | kw= 'padding-top' | kw= 'padding-bottom' | kw= 'padding-left' | kw= 'padding-right' | kw= 'width' | kw= 'height' | kw= 'translateX' | kw= 'translateY' | kw= 'x' | kw= 'y' | kw= 'elevation' | kw= 'font-size' | kw= 'border-radius' | kw= 'border-top-left-radius' | kw= 'border-top-right-radius' | kw= 'border-bottom-left-radius' | kw= 'border-bottom-right-radius' | kw= 'border-width' | kw= 'border-left-width' | kw= 'border-right-width' | kw= 'border-top-width' | kw= 'border-bottom-width' | kw= 'border' )
            int alt33=29;
            switch ( input.LA(1) ) {
            case 29:
                {
                alt33=1;
                }
                break;
            case 44:
                {
                alt33=2;
                }
                break;
            case 45:
                {
                alt33=3;
                }
                break;
            case 42:
                {
                alt33=4;
                }
                break;
            case 43:
                {
                alt33=5;
                }
                break;
            case 30:
                {
                alt33=6;
                }
                break;
            case 48:
                {
                alt33=7;
                }
                break;
            case 49:
                {
                alt33=8;
                }
                break;
            case 46:
                {
                alt33=9;
                }
                break;
            case 47:
                {
                alt33=10;
                }
                break;
            case 25:
                {
                alt33=11;
                }
                break;
            case 26:
                {
                alt33=12;
                }
                break;
            case 131:
                {
                alt33=13;
                }
                break;
            case 132:
                {
                alt33=14;
                }
                break;
            case 50:
                {
                alt33=15;
                }
                break;
            case 51:
                {
                alt33=16;
                }
                break;
            case 52:
                {
                alt33=17;
                }
                break;
            case 39:
                {
                alt33=18;
                }
                break;
            case 28:
                {
                alt33=19;
                }
                break;
            case 31:
                {
                alt33=20;
                }
                break;
            case 32:
                {
                alt33=21;
                }
                break;
            case 33:
                {
                alt33=22;
                }
                break;
            case 34:
                {
                alt33=23;
                }
                break;
            case 27:
                {
                alt33=24;
                }
                break;
            case 35:
                {
                alt33=25;
                }
                break;
            case 36:
                {
                alt33=26;
                }
                break;
            case 37:
                {
                alt33=27;
                }
                break;
            case 38:
                {
                alt33=28;
                }
                break;
            case 57:
                {
                alt33=29;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 33, 0, input);

                throw nvae;
            }

            switch (alt33) {
                case 1 :
                    // PsiInternalLatteCSS.g:2140:3: kw= 'margin'
                    {

                    			markLeaf(elementTypeProvider.getPropertyNameValue_MarginKeyword_0ElementType());
                    		
                    kw=(Token)match(input,29,FOLLOW_2); 

                    			doneLeaf(kw);
                    		

                    }
                    break;
                case 2 :
                    // PsiInternalLatteCSS.g:2148:3: kw= 'margin-top'
                    {

                    			markLeaf(elementTypeProvider.getPropertyNameValue_MarginTopKeyword_1ElementType());
                    		
                    kw=(Token)match(input,44,FOLLOW_2); 

                    			doneLeaf(kw);
                    		

                    }
                    break;
                case 3 :
                    // PsiInternalLatteCSS.g:2156:3: kw= 'margin-bottom'
                    {

                    			markLeaf(elementTypeProvider.getPropertyNameValue_MarginBottomKeyword_2ElementType());
                    		
                    kw=(Token)match(input,45,FOLLOW_2); 

                    			doneLeaf(kw);
                    		

                    }
                    break;
                case 4 :
                    // PsiInternalLatteCSS.g:2164:3: kw= 'margin-left'
                    {

                    			markLeaf(elementTypeProvider.getPropertyNameValue_MarginLeftKeyword_3ElementType());
                    		
                    kw=(Token)match(input,42,FOLLOW_2); 

                    			doneLeaf(kw);
                    		

                    }
                    break;
                case 5 :
                    // PsiInternalLatteCSS.g:2172:3: kw= 'margin-right'
                    {

                    			markLeaf(elementTypeProvider.getPropertyNameValue_MarginRightKeyword_4ElementType());
                    		
                    kw=(Token)match(input,43,FOLLOW_2); 

                    			doneLeaf(kw);
                    		

                    }
                    break;
                case 6 :
                    // PsiInternalLatteCSS.g:2180:3: kw= 'padding'
                    {

                    			markLeaf(elementTypeProvider.getPropertyNameValue_PaddingKeyword_5ElementType());
                    		
                    kw=(Token)match(input,30,FOLLOW_2); 

                    			doneLeaf(kw);
                    		

                    }
                    break;
                case 7 :
                    // PsiInternalLatteCSS.g:2188:3: kw= 'padding-top'
                    {

                    			markLeaf(elementTypeProvider.getPropertyNameValue_PaddingTopKeyword_6ElementType());
                    		
                    kw=(Token)match(input,48,FOLLOW_2); 

                    			doneLeaf(kw);
                    		

                    }
                    break;
                case 8 :
                    // PsiInternalLatteCSS.g:2196:3: kw= 'padding-bottom'
                    {

                    			markLeaf(elementTypeProvider.getPropertyNameValue_PaddingBottomKeyword_7ElementType());
                    		
                    kw=(Token)match(input,49,FOLLOW_2); 

                    			doneLeaf(kw);
                    		

                    }
                    break;
                case 9 :
                    // PsiInternalLatteCSS.g:2204:3: kw= 'padding-left'
                    {

                    			markLeaf(elementTypeProvider.getPropertyNameValue_PaddingLeftKeyword_8ElementType());
                    		
                    kw=(Token)match(input,46,FOLLOW_2); 

                    			doneLeaf(kw);
                    		

                    }
                    break;
                case 10 :
                    // PsiInternalLatteCSS.g:2212:3: kw= 'padding-right'
                    {

                    			markLeaf(elementTypeProvider.getPropertyNameValue_PaddingRightKeyword_9ElementType());
                    		
                    kw=(Token)match(input,47,FOLLOW_2); 

                    			doneLeaf(kw);
                    		

                    }
                    break;
                case 11 :
                    // PsiInternalLatteCSS.g:2220:3: kw= 'width'
                    {

                    			markLeaf(elementTypeProvider.getPropertyNameValue_WidthKeyword_10ElementType());
                    		
                    kw=(Token)match(input,25,FOLLOW_2); 

                    			doneLeaf(kw);
                    		

                    }
                    break;
                case 12 :
                    // PsiInternalLatteCSS.g:2228:3: kw= 'height'
                    {

                    			markLeaf(elementTypeProvider.getPropertyNameValue_HeightKeyword_11ElementType());
                    		
                    kw=(Token)match(input,26,FOLLOW_2); 

                    			doneLeaf(kw);
                    		

                    }
                    break;
                case 13 :
                    // PsiInternalLatteCSS.g:2236:3: kw= 'translateX'
                    {

                    			markLeaf(elementTypeProvider.getPropertyNameValue_TranslateXKeyword_12ElementType());
                    		
                    kw=(Token)match(input,131,FOLLOW_2); 

                    			doneLeaf(kw);
                    		

                    }
                    break;
                case 14 :
                    // PsiInternalLatteCSS.g:2244:3: kw= 'translateY'
                    {

                    			markLeaf(elementTypeProvider.getPropertyNameValue_TranslateYKeyword_13ElementType());
                    		
                    kw=(Token)match(input,132,FOLLOW_2); 

                    			doneLeaf(kw);
                    		

                    }
                    break;
                case 15 :
                    // PsiInternalLatteCSS.g:2252:3: kw= 'x'
                    {

                    			markLeaf(elementTypeProvider.getPropertyNameValue_XKeyword_14ElementType());
                    		
                    kw=(Token)match(input,50,FOLLOW_2); 

                    			doneLeaf(kw);
                    		

                    }
                    break;
                case 16 :
                    // PsiInternalLatteCSS.g:2260:3: kw= 'y'
                    {

                    			markLeaf(elementTypeProvider.getPropertyNameValue_YKeyword_15ElementType());
                    		
                    kw=(Token)match(input,51,FOLLOW_2); 

                    			doneLeaf(kw);
                    		

                    }
                    break;
                case 17 :
                    // PsiInternalLatteCSS.g:2268:3: kw= 'elevation'
                    {

                    			markLeaf(elementTypeProvider.getPropertyNameValue_ElevationKeyword_16ElementType());
                    		
                    kw=(Token)match(input,52,FOLLOW_2); 

                    			doneLeaf(kw);
                    		

                    }
                    break;
                case 18 :
                    // PsiInternalLatteCSS.g:2276:3: kw= 'font-size'
                    {

                    			markLeaf(elementTypeProvider.getPropertyNameValue_FontSizeKeyword_17ElementType());
                    		
                    kw=(Token)match(input,39,FOLLOW_2); 

                    			doneLeaf(kw);
                    		

                    }
                    break;
                case 19 :
                    // PsiInternalLatteCSS.g:2284:3: kw= 'border-radius'
                    {

                    			markLeaf(elementTypeProvider.getPropertyNameValue_BorderRadiusKeyword_18ElementType());
                    		
                    kw=(Token)match(input,28,FOLLOW_2); 

                    			doneLeaf(kw);
                    		

                    }
                    break;
                case 20 :
                    // PsiInternalLatteCSS.g:2292:3: kw= 'border-top-left-radius'
                    {

                    			markLeaf(elementTypeProvider.getPropertyNameValue_BorderTopLeftRadiusKeyword_19ElementType());
                    		
                    kw=(Token)match(input,31,FOLLOW_2); 

                    			doneLeaf(kw);
                    		

                    }
                    break;
                case 21 :
                    // PsiInternalLatteCSS.g:2300:3: kw= 'border-top-right-radius'
                    {

                    			markLeaf(elementTypeProvider.getPropertyNameValue_BorderTopRightRadiusKeyword_20ElementType());
                    		
                    kw=(Token)match(input,32,FOLLOW_2); 

                    			doneLeaf(kw);
                    		

                    }
                    break;
                case 22 :
                    // PsiInternalLatteCSS.g:2308:3: kw= 'border-bottom-left-radius'
                    {

                    			markLeaf(elementTypeProvider.getPropertyNameValue_BorderBottomLeftRadiusKeyword_21ElementType());
                    		
                    kw=(Token)match(input,33,FOLLOW_2); 

                    			doneLeaf(kw);
                    		

                    }
                    break;
                case 23 :
                    // PsiInternalLatteCSS.g:2316:3: kw= 'border-bottom-right-radius'
                    {

                    			markLeaf(elementTypeProvider.getPropertyNameValue_BorderBottomRightRadiusKeyword_22ElementType());
                    		
                    kw=(Token)match(input,34,FOLLOW_2); 

                    			doneLeaf(kw);
                    		

                    }
                    break;
                case 24 :
                    // PsiInternalLatteCSS.g:2324:3: kw= 'border-width'
                    {

                    			markLeaf(elementTypeProvider.getPropertyNameValue_BorderWidthKeyword_23ElementType());
                    		
                    kw=(Token)match(input,27,FOLLOW_2); 

                    			doneLeaf(kw);
                    		

                    }
                    break;
                case 25 :
                    // PsiInternalLatteCSS.g:2332:3: kw= 'border-left-width'
                    {

                    			markLeaf(elementTypeProvider.getPropertyNameValue_BorderLeftWidthKeyword_24ElementType());
                    		
                    kw=(Token)match(input,35,FOLLOW_2); 

                    			doneLeaf(kw);
                    		

                    }
                    break;
                case 26 :
                    // PsiInternalLatteCSS.g:2340:3: kw= 'border-right-width'
                    {

                    			markLeaf(elementTypeProvider.getPropertyNameValue_BorderRightWidthKeyword_25ElementType());
                    		
                    kw=(Token)match(input,36,FOLLOW_2); 

                    			doneLeaf(kw);
                    		

                    }
                    break;
                case 27 :
                    // PsiInternalLatteCSS.g:2348:3: kw= 'border-top-width'
                    {

                    			markLeaf(elementTypeProvider.getPropertyNameValue_BorderTopWidthKeyword_26ElementType());
                    		
                    kw=(Token)match(input,37,FOLLOW_2); 

                    			doneLeaf(kw);
                    		

                    }
                    break;
                case 28 :
                    // PsiInternalLatteCSS.g:2356:3: kw= 'border-bottom-width'
                    {

                    			markLeaf(elementTypeProvider.getPropertyNameValue_BorderBottomWidthKeyword_27ElementType());
                    		
                    kw=(Token)match(input,38,FOLLOW_2); 

                    			doneLeaf(kw);
                    		

                    }
                    break;
                case 29 :
                    // PsiInternalLatteCSS.g:2364:3: kw= 'border'
                    {

                    			markLeaf(elementTypeProvider.getPropertyNameValue_BorderKeyword_28ElementType());
                    		
                    kw=(Token)match(input,57,FOLLOW_2); 

                    			doneLeaf(kw);
                    		

                    }
                    break;

            }


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
    // $ANTLR end "rulePropertyNameValue"


    // $ANTLR start "entryRuleNumberValue"
    // PsiInternalLatteCSS.g:2375:1: entryRuleNumberValue : ruleNumberValue EOF ;
    public final void entryRuleNumberValue() throws RecognitionException {
        try {
            // PsiInternalLatteCSS.g:2375:21: ( ruleNumberValue EOF )
            // PsiInternalLatteCSS.g:2376:2: ruleNumberValue EOF
            {
             markComposite(elementTypeProvider.getNumberValueElementType()); 
            pushFollow(FOLLOW_1);
            ruleNumberValue();

            state._fsp--;

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
    // PsiInternalLatteCSS.g:2381:1: ruleNumberValue : ( ruleIntegerValue | ruleRealValue ) ;
    public final void ruleNumberValue() throws RecognitionException {
        try {
            // PsiInternalLatteCSS.g:2381:16: ( ( ruleIntegerValue | ruleRealValue ) )
            // PsiInternalLatteCSS.g:2382:2: ( ruleIntegerValue | ruleRealValue )
            {
            // PsiInternalLatteCSS.g:2382:2: ( ruleIntegerValue | ruleRealValue )
            int alt34=2;
            int LA34_0 = input.LA(1);

            if ( (LA34_0==RULE_INT) ) {
                alt34=1;
            }
            else if ( (LA34_0==RULE_REAL) ) {
                alt34=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 34, 0, input);

                throw nvae;
            }
            switch (alt34) {
                case 1 :
                    // PsiInternalLatteCSS.g:2383:3: ruleIntegerValue
                    {

                    			markComposite(elementTypeProvider.getNumberValue_IntegerValueParserRuleCall_0ElementType());
                    		
                    pushFollow(FOLLOW_2);
                    ruleIntegerValue();

                    state._fsp--;


                    			doneComposite();
                    		

                    }
                    break;
                case 2 :
                    // PsiInternalLatteCSS.g:2391:3: ruleRealValue
                    {

                    			markComposite(elementTypeProvider.getNumberValue_RealValueParserRuleCall_1ElementType());
                    		
                    pushFollow(FOLLOW_2);
                    ruleRealValue();

                    state._fsp--;


                    			doneComposite();
                    		

                    }
                    break;

            }


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
    // $ANTLR end "ruleNumberValue"


    // $ANTLR start "entryRuleIntegerValue"
    // PsiInternalLatteCSS.g:2402:1: entryRuleIntegerValue : ruleIntegerValue EOF ;
    public final void entryRuleIntegerValue() throws RecognitionException {
        try {
            // PsiInternalLatteCSS.g:2402:22: ( ruleIntegerValue EOF )
            // PsiInternalLatteCSS.g:2403:2: ruleIntegerValue EOF
            {
             markComposite(elementTypeProvider.getIntegerValueElementType()); 
            pushFollow(FOLLOW_1);
            ruleIntegerValue();

            state._fsp--;

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
    // PsiInternalLatteCSS.g:2408:1: ruleIntegerValue : this_INT_0= RULE_INT ;
    public final void ruleIntegerValue() throws RecognitionException {
        Token this_INT_0=null;

        try {
            // PsiInternalLatteCSS.g:2408:17: (this_INT_0= RULE_INT )
            // PsiInternalLatteCSS.g:2409:2: this_INT_0= RULE_INT
            {

            		markLeaf(elementTypeProvider.getIntegerValue_INTTerminalRuleCallElementType());
            	
            this_INT_0=(Token)match(input,RULE_INT,FOLLOW_2); 

            		doneLeaf(this_INT_0);
            	

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
    // $ANTLR end "ruleIntegerValue"


    // $ANTLR start "entryRuleRealValue"
    // PsiInternalLatteCSS.g:2419:1: entryRuleRealValue : ruleRealValue EOF ;
    public final void entryRuleRealValue() throws RecognitionException {
        try {
            // PsiInternalLatteCSS.g:2419:19: ( ruleRealValue EOF )
            // PsiInternalLatteCSS.g:2420:2: ruleRealValue EOF
            {
             markComposite(elementTypeProvider.getRealValueElementType()); 
            pushFollow(FOLLOW_1);
            ruleRealValue();

            state._fsp--;

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
    // PsiInternalLatteCSS.g:2425:1: ruleRealValue : this_REAL_0= RULE_REAL ;
    public final void ruleRealValue() throws RecognitionException {
        Token this_REAL_0=null;

        try {
            // PsiInternalLatteCSS.g:2425:14: (this_REAL_0= RULE_REAL )
            // PsiInternalLatteCSS.g:2426:2: this_REAL_0= RULE_REAL
            {

            		markLeaf(elementTypeProvider.getRealValue_REALTerminalRuleCallElementType());
            	
            this_REAL_0=(Token)match(input,RULE_REAL,FOLLOW_2); 

            		doneLeaf(this_REAL_0);
            	

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
    // $ANTLR end "ruleRealValue"


    // $ANTLR start "entryRuleTimeValue"
    // PsiInternalLatteCSS.g:2436:1: entryRuleTimeValue : ruleTimeValue EOF ;
    public final void entryRuleTimeValue() throws RecognitionException {
        try {
            // PsiInternalLatteCSS.g:2436:19: ( ruleTimeValue EOF )
            // PsiInternalLatteCSS.g:2437:2: ruleTimeValue EOF
            {
             markComposite(elementTypeProvider.getTimeValueElementType()); 
            pushFollow(FOLLOW_1);
            ruleTimeValue();

            state._fsp--;

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
    // PsiInternalLatteCSS.g:2442:1: ruleTimeValue : ( ( (lv_time_0_0= ruleNumberValue ) ) ( ( (lv_unit_1_1= 's' | lv_unit_1_2= 'ms' ) ) ) ) ;
    public final void ruleTimeValue() throws RecognitionException {
        Token lv_unit_1_1=null;
        Token lv_unit_1_2=null;

        try {
            // PsiInternalLatteCSS.g:2442:14: ( ( ( (lv_time_0_0= ruleNumberValue ) ) ( ( (lv_unit_1_1= 's' | lv_unit_1_2= 'ms' ) ) ) ) )
            // PsiInternalLatteCSS.g:2443:2: ( ( (lv_time_0_0= ruleNumberValue ) ) ( ( (lv_unit_1_1= 's' | lv_unit_1_2= 'ms' ) ) ) )
            {
            // PsiInternalLatteCSS.g:2443:2: ( ( (lv_time_0_0= ruleNumberValue ) ) ( ( (lv_unit_1_1= 's' | lv_unit_1_2= 'ms' ) ) ) )
            // PsiInternalLatteCSS.g:2444:3: ( (lv_time_0_0= ruleNumberValue ) ) ( ( (lv_unit_1_1= 's' | lv_unit_1_2= 'ms' ) ) )
            {
            // PsiInternalLatteCSS.g:2444:3: ( (lv_time_0_0= ruleNumberValue ) )
            // PsiInternalLatteCSS.g:2445:4: (lv_time_0_0= ruleNumberValue )
            {
            // PsiInternalLatteCSS.g:2445:4: (lv_time_0_0= ruleNumberValue )
            // PsiInternalLatteCSS.g:2446:5: lv_time_0_0= ruleNumberValue
            {

            					markComposite(elementTypeProvider.getTimeValue_TimeNumberValueParserRuleCall_0_0ElementType());
            				
            pushFollow(FOLLOW_30);
            ruleNumberValue();

            state._fsp--;


            					doneComposite();
            				

            }


            }

            // PsiInternalLatteCSS.g:2455:3: ( ( (lv_unit_1_1= 's' | lv_unit_1_2= 'ms' ) ) )
            // PsiInternalLatteCSS.g:2456:4: ( (lv_unit_1_1= 's' | lv_unit_1_2= 'ms' ) )
            {
            // PsiInternalLatteCSS.g:2456:4: ( (lv_unit_1_1= 's' | lv_unit_1_2= 'ms' ) )
            // PsiInternalLatteCSS.g:2457:5: (lv_unit_1_1= 's' | lv_unit_1_2= 'ms' )
            {
            // PsiInternalLatteCSS.g:2457:5: (lv_unit_1_1= 's' | lv_unit_1_2= 'ms' )
            int alt35=2;
            int LA35_0 = input.LA(1);

            if ( (LA35_0==133) ) {
                alt35=1;
            }
            else if ( (LA35_0==134) ) {
                alt35=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 35, 0, input);

                throw nvae;
            }
            switch (alt35) {
                case 1 :
                    // PsiInternalLatteCSS.g:2458:6: lv_unit_1_1= 's'
                    {

                    						markLeaf(elementTypeProvider.getTimeValue_UnitSKeyword_1_0_0ElementType());
                    					
                    lv_unit_1_1=(Token)match(input,133,FOLLOW_2); 

                    						doneLeaf(lv_unit_1_1);
                    					

                    }
                    break;
                case 2 :
                    // PsiInternalLatteCSS.g:2466:6: lv_unit_1_2= 'ms'
                    {

                    						markLeaf(elementTypeProvider.getTimeValue_UnitMsKeyword_1_0_1ElementType());
                    					
                    lv_unit_1_2=(Token)match(input,134,FOLLOW_2); 

                    						doneLeaf(lv_unit_1_2);
                    					

                    }
                    break;

            }


            }


            }


            }


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
    // $ANTLR end "ruleTimeValue"


    // $ANTLR start "entryRuleViewSizeValue"
    // PsiInternalLatteCSS.g:2480:1: entryRuleViewSizeValue : ruleViewSizeValue EOF ;
    public final void entryRuleViewSizeValue() throws RecognitionException {
        try {
            // PsiInternalLatteCSS.g:2480:23: ( ruleViewSizeValue EOF )
            // PsiInternalLatteCSS.g:2481:2: ruleViewSizeValue EOF
            {
             markComposite(elementTypeProvider.getViewSizeValueElementType()); 
            pushFollow(FOLLOW_1);
            ruleViewSizeValue();

            state._fsp--;

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
    // PsiInternalLatteCSS.g:2486:1: ruleViewSizeValue : ( ( (lv_value_0_0= ruleSizeValue ) ) | ( ( (lv_dynamic_1_1= 'match_parent' | lv_dynamic_1_2= 'wrap_content' ) ) ) ) ;
    public final void ruleViewSizeValue() throws RecognitionException {
        Token lv_dynamic_1_1=null;
        Token lv_dynamic_1_2=null;

        try {
            // PsiInternalLatteCSS.g:2486:18: ( ( ( (lv_value_0_0= ruleSizeValue ) ) | ( ( (lv_dynamic_1_1= 'match_parent' | lv_dynamic_1_2= 'wrap_content' ) ) ) ) )
            // PsiInternalLatteCSS.g:2487:2: ( ( (lv_value_0_0= ruleSizeValue ) ) | ( ( (lv_dynamic_1_1= 'match_parent' | lv_dynamic_1_2= 'wrap_content' ) ) ) )
            {
            // PsiInternalLatteCSS.g:2487:2: ( ( (lv_value_0_0= ruleSizeValue ) ) | ( ( (lv_dynamic_1_1= 'match_parent' | lv_dynamic_1_2= 'wrap_content' ) ) ) )
            int alt37=2;
            int LA37_0 = input.LA(1);

            if ( ((LA37_0>=RULE_INT && LA37_0<=RULE_REAL)) ) {
                alt37=1;
            }
            else if ( ((LA37_0>=135 && LA37_0<=136)) ) {
                alt37=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 37, 0, input);

                throw nvae;
            }
            switch (alt37) {
                case 1 :
                    // PsiInternalLatteCSS.g:2488:3: ( (lv_value_0_0= ruleSizeValue ) )
                    {
                    // PsiInternalLatteCSS.g:2488:3: ( (lv_value_0_0= ruleSizeValue ) )
                    // PsiInternalLatteCSS.g:2489:4: (lv_value_0_0= ruleSizeValue )
                    {
                    // PsiInternalLatteCSS.g:2489:4: (lv_value_0_0= ruleSizeValue )
                    // PsiInternalLatteCSS.g:2490:5: lv_value_0_0= ruleSizeValue
                    {

                    					markComposite(elementTypeProvider.getViewSizeValue_ValueSizeValueParserRuleCall_0_0ElementType());
                    				
                    pushFollow(FOLLOW_2);
                    ruleSizeValue();

                    state._fsp--;


                    					doneComposite();
                    				

                    }


                    }


                    }
                    break;
                case 2 :
                    // PsiInternalLatteCSS.g:2500:3: ( ( (lv_dynamic_1_1= 'match_parent' | lv_dynamic_1_2= 'wrap_content' ) ) )
                    {
                    // PsiInternalLatteCSS.g:2500:3: ( ( (lv_dynamic_1_1= 'match_parent' | lv_dynamic_1_2= 'wrap_content' ) ) )
                    // PsiInternalLatteCSS.g:2501:4: ( (lv_dynamic_1_1= 'match_parent' | lv_dynamic_1_2= 'wrap_content' ) )
                    {
                    // PsiInternalLatteCSS.g:2501:4: ( (lv_dynamic_1_1= 'match_parent' | lv_dynamic_1_2= 'wrap_content' ) )
                    // PsiInternalLatteCSS.g:2502:5: (lv_dynamic_1_1= 'match_parent' | lv_dynamic_1_2= 'wrap_content' )
                    {
                    // PsiInternalLatteCSS.g:2502:5: (lv_dynamic_1_1= 'match_parent' | lv_dynamic_1_2= 'wrap_content' )
                    int alt36=2;
                    int LA36_0 = input.LA(1);

                    if ( (LA36_0==135) ) {
                        alt36=1;
                    }
                    else if ( (LA36_0==136) ) {
                        alt36=2;
                    }
                    else {
                        NoViableAltException nvae =
                            new NoViableAltException("", 36, 0, input);

                        throw nvae;
                    }
                    switch (alt36) {
                        case 1 :
                            // PsiInternalLatteCSS.g:2503:6: lv_dynamic_1_1= 'match_parent'
                            {

                            						markLeaf(elementTypeProvider.getViewSizeValue_DynamicMatch_parentKeyword_1_0_0ElementType());
                            					
                            lv_dynamic_1_1=(Token)match(input,135,FOLLOW_2); 

                            						doneLeaf(lv_dynamic_1_1);
                            					

                            }
                            break;
                        case 2 :
                            // PsiInternalLatteCSS.g:2511:6: lv_dynamic_1_2= 'wrap_content'
                            {

                            						markLeaf(elementTypeProvider.getViewSizeValue_DynamicWrap_contentKeyword_1_0_1ElementType());
                            					
                            lv_dynamic_1_2=(Token)match(input,136,FOLLOW_2); 

                            						doneLeaf(lv_dynamic_1_2);
                            					

                            }
                            break;

                    }


                    }


                    }


                    }
                    break;

            }


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
    // $ANTLR end "ruleViewSizeValue"


    // $ANTLR start "entryRuleSizeValue"
    // PsiInternalLatteCSS.g:2525:1: entryRuleSizeValue : ruleSizeValue EOF ;
    public final void entryRuleSizeValue() throws RecognitionException {
        try {
            // PsiInternalLatteCSS.g:2525:19: ( ruleSizeValue EOF )
            // PsiInternalLatteCSS.g:2526:2: ruleSizeValue EOF
            {
             markComposite(elementTypeProvider.getSizeValueElementType()); 
            pushFollow(FOLLOW_1);
            ruleSizeValue();

            state._fsp--;

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
    // PsiInternalLatteCSS.g:2531:1: ruleSizeValue : ( ( (lv_value_0_0= ruleNumberValue ) ) ( ( (lv_dimension_1_1= 'dp' | lv_dimension_1_2= 'px' | lv_dimension_1_3= 'sp' | lv_dimension_1_4= 'pt' | lv_dimension_1_5= 'mm' ) ) )? ) ;
    public final void ruleSizeValue() throws RecognitionException {
        Token lv_dimension_1_1=null;
        Token lv_dimension_1_2=null;
        Token lv_dimension_1_3=null;
        Token lv_dimension_1_4=null;
        Token lv_dimension_1_5=null;

        try {
            // PsiInternalLatteCSS.g:2531:14: ( ( ( (lv_value_0_0= ruleNumberValue ) ) ( ( (lv_dimension_1_1= 'dp' | lv_dimension_1_2= 'px' | lv_dimension_1_3= 'sp' | lv_dimension_1_4= 'pt' | lv_dimension_1_5= 'mm' ) ) )? ) )
            // PsiInternalLatteCSS.g:2532:2: ( ( (lv_value_0_0= ruleNumberValue ) ) ( ( (lv_dimension_1_1= 'dp' | lv_dimension_1_2= 'px' | lv_dimension_1_3= 'sp' | lv_dimension_1_4= 'pt' | lv_dimension_1_5= 'mm' ) ) )? )
            {
            // PsiInternalLatteCSS.g:2532:2: ( ( (lv_value_0_0= ruleNumberValue ) ) ( ( (lv_dimension_1_1= 'dp' | lv_dimension_1_2= 'px' | lv_dimension_1_3= 'sp' | lv_dimension_1_4= 'pt' | lv_dimension_1_5= 'mm' ) ) )? )
            // PsiInternalLatteCSS.g:2533:3: ( (lv_value_0_0= ruleNumberValue ) ) ( ( (lv_dimension_1_1= 'dp' | lv_dimension_1_2= 'px' | lv_dimension_1_3= 'sp' | lv_dimension_1_4= 'pt' | lv_dimension_1_5= 'mm' ) ) )?
            {
            // PsiInternalLatteCSS.g:2533:3: ( (lv_value_0_0= ruleNumberValue ) )
            // PsiInternalLatteCSS.g:2534:4: (lv_value_0_0= ruleNumberValue )
            {
            // PsiInternalLatteCSS.g:2534:4: (lv_value_0_0= ruleNumberValue )
            // PsiInternalLatteCSS.g:2535:5: lv_value_0_0= ruleNumberValue
            {

            					markComposite(elementTypeProvider.getSizeValue_ValueNumberValueParserRuleCall_0_0ElementType());
            				
            pushFollow(FOLLOW_31);
            ruleNumberValue();

            state._fsp--;


            					doneComposite();
            				

            }


            }

            // PsiInternalLatteCSS.g:2544:3: ( ( (lv_dimension_1_1= 'dp' | lv_dimension_1_2= 'px' | lv_dimension_1_3= 'sp' | lv_dimension_1_4= 'pt' | lv_dimension_1_5= 'mm' ) ) )?
            int alt39=2;
            int LA39_0 = input.LA(1);

            if ( ((LA39_0>=137 && LA39_0<=141)) ) {
                alt39=1;
            }
            switch (alt39) {
                case 1 :
                    // PsiInternalLatteCSS.g:2545:4: ( (lv_dimension_1_1= 'dp' | lv_dimension_1_2= 'px' | lv_dimension_1_3= 'sp' | lv_dimension_1_4= 'pt' | lv_dimension_1_5= 'mm' ) )
                    {
                    // PsiInternalLatteCSS.g:2545:4: ( (lv_dimension_1_1= 'dp' | lv_dimension_1_2= 'px' | lv_dimension_1_3= 'sp' | lv_dimension_1_4= 'pt' | lv_dimension_1_5= 'mm' ) )
                    // PsiInternalLatteCSS.g:2546:5: (lv_dimension_1_1= 'dp' | lv_dimension_1_2= 'px' | lv_dimension_1_3= 'sp' | lv_dimension_1_4= 'pt' | lv_dimension_1_5= 'mm' )
                    {
                    // PsiInternalLatteCSS.g:2546:5: (lv_dimension_1_1= 'dp' | lv_dimension_1_2= 'px' | lv_dimension_1_3= 'sp' | lv_dimension_1_4= 'pt' | lv_dimension_1_5= 'mm' )
                    int alt38=5;
                    switch ( input.LA(1) ) {
                    case 137:
                        {
                        alt38=1;
                        }
                        break;
                    case 138:
                        {
                        alt38=2;
                        }
                        break;
                    case 139:
                        {
                        alt38=3;
                        }
                        break;
                    case 140:
                        {
                        alt38=4;
                        }
                        break;
                    case 141:
                        {
                        alt38=5;
                        }
                        break;
                    default:
                        NoViableAltException nvae =
                            new NoViableAltException("", 38, 0, input);

                        throw nvae;
                    }

                    switch (alt38) {
                        case 1 :
                            // PsiInternalLatteCSS.g:2547:6: lv_dimension_1_1= 'dp'
                            {

                            						markLeaf(elementTypeProvider.getSizeValue_DimensionDpKeyword_1_0_0ElementType());
                            					
                            lv_dimension_1_1=(Token)match(input,137,FOLLOW_2); 

                            						doneLeaf(lv_dimension_1_1);
                            					

                            }
                            break;
                        case 2 :
                            // PsiInternalLatteCSS.g:2555:6: lv_dimension_1_2= 'px'
                            {

                            						markLeaf(elementTypeProvider.getSizeValue_DimensionPxKeyword_1_0_1ElementType());
                            					
                            lv_dimension_1_2=(Token)match(input,138,FOLLOW_2); 

                            						doneLeaf(lv_dimension_1_2);
                            					

                            }
                            break;
                        case 3 :
                            // PsiInternalLatteCSS.g:2563:6: lv_dimension_1_3= 'sp'
                            {

                            						markLeaf(elementTypeProvider.getSizeValue_DimensionSpKeyword_1_0_2ElementType());
                            					
                            lv_dimension_1_3=(Token)match(input,139,FOLLOW_2); 

                            						doneLeaf(lv_dimension_1_3);
                            					

                            }
                            break;
                        case 4 :
                            // PsiInternalLatteCSS.g:2571:6: lv_dimension_1_4= 'pt'
                            {

                            						markLeaf(elementTypeProvider.getSizeValue_DimensionPtKeyword_1_0_3ElementType());
                            					
                            lv_dimension_1_4=(Token)match(input,140,FOLLOW_2); 

                            						doneLeaf(lv_dimension_1_4);
                            					

                            }
                            break;
                        case 5 :
                            // PsiInternalLatteCSS.g:2579:6: lv_dimension_1_5= 'mm'
                            {

                            						markLeaf(elementTypeProvider.getSizeValue_DimensionMmKeyword_1_0_4ElementType());
                            					
                            lv_dimension_1_5=(Token)match(input,141,FOLLOW_2); 

                            						doneLeaf(lv_dimension_1_5);
                            					

                            }
                            break;

                    }


                    }


                    }
                    break;

            }


            }


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
    // $ANTLR end "ruleSizeValue"


    // $ANTLR start "entryRulePaintValue"
    // PsiInternalLatteCSS.g:2593:1: entryRulePaintValue : rulePaintValue EOF ;
    public final void entryRulePaintValue() throws RecognitionException {
        try {
            // PsiInternalLatteCSS.g:2593:20: ( rulePaintValue EOF )
            // PsiInternalLatteCSS.g:2594:2: rulePaintValue EOF
            {
             markComposite(elementTypeProvider.getPaintValueElementType()); 
            pushFollow(FOLLOW_1);
            rulePaintValue();

            state._fsp--;

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
    // PsiInternalLatteCSS.g:2599:1: rulePaintValue : ( ruleLinearGradient | ruleRadialGradient | ruleColorValue ) ;
    public final void rulePaintValue() throws RecognitionException {
        try {
            // PsiInternalLatteCSS.g:2599:15: ( ( ruleLinearGradient | ruleRadialGradient | ruleColorValue ) )
            // PsiInternalLatteCSS.g:2600:2: ( ruleLinearGradient | ruleRadialGradient | ruleColorValue )
            {
            // PsiInternalLatteCSS.g:2600:2: ( ruleLinearGradient | ruleRadialGradient | ruleColorValue )
            int alt40=3;
            switch ( input.LA(1) ) {
            case 128:
                {
                alt40=1;
                }
                break;
            case 148:
                {
                alt40=2;
                }
                break;
            case RULE_HEX_NUMBER:
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
            case 274:
            case 275:
            case 276:
            case 277:
            case 278:
            case 279:
            case 280:
            case 281:
            case 282:
            case 283:
            case 284:
            case 285:
            case 286:
            case 287:
            case 288:
            case 289:
            case 290:
            case 291:
            case 292:
            case 293:
            case 294:
            case 295:
            case 296:
            case 297:
            case 298:
            case 299:
                {
                alt40=3;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 40, 0, input);

                throw nvae;
            }

            switch (alt40) {
                case 1 :
                    // PsiInternalLatteCSS.g:2601:3: ruleLinearGradient
                    {

                    			markComposite(elementTypeProvider.getPaintValue_LinearGradientParserRuleCall_0ElementType());
                    		
                    pushFollow(FOLLOW_2);
                    ruleLinearGradient();

                    state._fsp--;


                    			doneComposite();
                    		

                    }
                    break;
                case 2 :
                    // PsiInternalLatteCSS.g:2609:3: ruleRadialGradient
                    {

                    			markComposite(elementTypeProvider.getPaintValue_RadialGradientParserRuleCall_1ElementType());
                    		
                    pushFollow(FOLLOW_2);
                    ruleRadialGradient();

                    state._fsp--;


                    			doneComposite();
                    		

                    }
                    break;
                case 3 :
                    // PsiInternalLatteCSS.g:2617:3: ruleColorValue
                    {

                    			markComposite(elementTypeProvider.getPaintValue_ColorValueParserRuleCall_2ElementType());
                    		
                    pushFollow(FOLLOW_2);
                    ruleColorValue();

                    state._fsp--;


                    			doneComposite();
                    		

                    }
                    break;

            }


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
    // $ANTLR end "rulePaintValue"


    // $ANTLR start "entryRuleLinearGradient"
    // PsiInternalLatteCSS.g:2628:1: entryRuleLinearGradient : ruleLinearGradient EOF ;
    public final void entryRuleLinearGradient() throws RecognitionException {
        try {
            // PsiInternalLatteCSS.g:2628:24: ( ruleLinearGradient EOF )
            // PsiInternalLatteCSS.g:2629:2: ruleLinearGradient EOF
            {
             markComposite(elementTypeProvider.getLinearGradientElementType()); 
            pushFollow(FOLLOW_1);
            ruleLinearGradient();

            state._fsp--;

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
    // PsiInternalLatteCSS.g:2634:1: ruleLinearGradient : (otherlv_0= 'linear' otherlv_1= '(' ( (lv_x1_2_0= ruleSizeValue ) ) otherlv_3= ',' ( (lv_y1_4_0= ruleSizeValue ) ) otherlv_5= ')' otherlv_6= 'to' otherlv_7= '(' ( (lv_x2_8_0= ruleSizeValue ) ) otherlv_9= ',' ( (lv_y2_10_0= ruleSizeValue ) ) otherlv_11= ')' otherlv_12= 'stops' (otherlv_13= '(' ( (lv_stops_14_0= ruleStopValue ) ) otherlv_15= ')' )+ (otherlv_16= 'repeat' | otherlv_17= 'reflect' )? ) ;
    public final void ruleLinearGradient() throws RecognitionException {
        Token otherlv_0=null;
        Token otherlv_1=null;
        Token otherlv_3=null;
        Token otherlv_5=null;
        Token otherlv_6=null;
        Token otherlv_7=null;
        Token otherlv_9=null;
        Token otherlv_11=null;
        Token otherlv_12=null;
        Token otherlv_13=null;
        Token otherlv_15=null;
        Token otherlv_16=null;
        Token otherlv_17=null;

        try {
            // PsiInternalLatteCSS.g:2634:19: ( (otherlv_0= 'linear' otherlv_1= '(' ( (lv_x1_2_0= ruleSizeValue ) ) otherlv_3= ',' ( (lv_y1_4_0= ruleSizeValue ) ) otherlv_5= ')' otherlv_6= 'to' otherlv_7= '(' ( (lv_x2_8_0= ruleSizeValue ) ) otherlv_9= ',' ( (lv_y2_10_0= ruleSizeValue ) ) otherlv_11= ')' otherlv_12= 'stops' (otherlv_13= '(' ( (lv_stops_14_0= ruleStopValue ) ) otherlv_15= ')' )+ (otherlv_16= 'repeat' | otherlv_17= 'reflect' )? ) )
            // PsiInternalLatteCSS.g:2635:2: (otherlv_0= 'linear' otherlv_1= '(' ( (lv_x1_2_0= ruleSizeValue ) ) otherlv_3= ',' ( (lv_y1_4_0= ruleSizeValue ) ) otherlv_5= ')' otherlv_6= 'to' otherlv_7= '(' ( (lv_x2_8_0= ruleSizeValue ) ) otherlv_9= ',' ( (lv_y2_10_0= ruleSizeValue ) ) otherlv_11= ')' otherlv_12= 'stops' (otherlv_13= '(' ( (lv_stops_14_0= ruleStopValue ) ) otherlv_15= ')' )+ (otherlv_16= 'repeat' | otherlv_17= 'reflect' )? )
            {
            // PsiInternalLatteCSS.g:2635:2: (otherlv_0= 'linear' otherlv_1= '(' ( (lv_x1_2_0= ruleSizeValue ) ) otherlv_3= ',' ( (lv_y1_4_0= ruleSizeValue ) ) otherlv_5= ')' otherlv_6= 'to' otherlv_7= '(' ( (lv_x2_8_0= ruleSizeValue ) ) otherlv_9= ',' ( (lv_y2_10_0= ruleSizeValue ) ) otherlv_11= ')' otherlv_12= 'stops' (otherlv_13= '(' ( (lv_stops_14_0= ruleStopValue ) ) otherlv_15= ')' )+ (otherlv_16= 'repeat' | otherlv_17= 'reflect' )? )
            // PsiInternalLatteCSS.g:2636:3: otherlv_0= 'linear' otherlv_1= '(' ( (lv_x1_2_0= ruleSizeValue ) ) otherlv_3= ',' ( (lv_y1_4_0= ruleSizeValue ) ) otherlv_5= ')' otherlv_6= 'to' otherlv_7= '(' ( (lv_x2_8_0= ruleSizeValue ) ) otherlv_9= ',' ( (lv_y2_10_0= ruleSizeValue ) ) otherlv_11= ')' otherlv_12= 'stops' (otherlv_13= '(' ( (lv_stops_14_0= ruleStopValue ) ) otherlv_15= ')' )+ (otherlv_16= 'repeat' | otherlv_17= 'reflect' )?
            {

            			markLeaf(elementTypeProvider.getLinearGradient_LinearKeyword_0ElementType());
            		
            otherlv_0=(Token)match(input,128,FOLLOW_32); 

            			doneLeaf(otherlv_0);
            		

            			markLeaf(elementTypeProvider.getLinearGradient_LeftParenthesisKeyword_1ElementType());
            		
            otherlv_1=(Token)match(input,142,FOLLOW_15); 

            			doneLeaf(otherlv_1);
            		
            // PsiInternalLatteCSS.g:2650:3: ( (lv_x1_2_0= ruleSizeValue ) )
            // PsiInternalLatteCSS.g:2651:4: (lv_x1_2_0= ruleSizeValue )
            {
            // PsiInternalLatteCSS.g:2651:4: (lv_x1_2_0= ruleSizeValue )
            // PsiInternalLatteCSS.g:2652:5: lv_x1_2_0= ruleSizeValue
            {

            					markComposite(elementTypeProvider.getLinearGradient_X1SizeValueParserRuleCall_2_0ElementType());
            				
            pushFollow(FOLLOW_33);
            ruleSizeValue();

            state._fsp--;


            					doneComposite();
            				

            }


            }


            			markLeaf(elementTypeProvider.getLinearGradient_CommaKeyword_3ElementType());
            		
            otherlv_3=(Token)match(input,13,FOLLOW_15); 

            			doneLeaf(otherlv_3);
            		
            // PsiInternalLatteCSS.g:2668:3: ( (lv_y1_4_0= ruleSizeValue ) )
            // PsiInternalLatteCSS.g:2669:4: (lv_y1_4_0= ruleSizeValue )
            {
            // PsiInternalLatteCSS.g:2669:4: (lv_y1_4_0= ruleSizeValue )
            // PsiInternalLatteCSS.g:2670:5: lv_y1_4_0= ruleSizeValue
            {

            					markComposite(elementTypeProvider.getLinearGradient_Y1SizeValueParserRuleCall_4_0ElementType());
            				
            pushFollow(FOLLOW_34);
            ruleSizeValue();

            state._fsp--;


            					doneComposite();
            				

            }


            }


            			markLeaf(elementTypeProvider.getLinearGradient_RightParenthesisKeyword_5ElementType());
            		
            otherlv_5=(Token)match(input,143,FOLLOW_35); 

            			doneLeaf(otherlv_5);
            		

            			markLeaf(elementTypeProvider.getLinearGradient_ToKeyword_6ElementType());
            		
            otherlv_6=(Token)match(input,144,FOLLOW_32); 

            			doneLeaf(otherlv_6);
            		

            			markLeaf(elementTypeProvider.getLinearGradient_LeftParenthesisKeyword_7ElementType());
            		
            otherlv_7=(Token)match(input,142,FOLLOW_15); 

            			doneLeaf(otherlv_7);
            		
            // PsiInternalLatteCSS.g:2700:3: ( (lv_x2_8_0= ruleSizeValue ) )
            // PsiInternalLatteCSS.g:2701:4: (lv_x2_8_0= ruleSizeValue )
            {
            // PsiInternalLatteCSS.g:2701:4: (lv_x2_8_0= ruleSizeValue )
            // PsiInternalLatteCSS.g:2702:5: lv_x2_8_0= ruleSizeValue
            {

            					markComposite(elementTypeProvider.getLinearGradient_X2SizeValueParserRuleCall_8_0ElementType());
            				
            pushFollow(FOLLOW_33);
            ruleSizeValue();

            state._fsp--;


            					doneComposite();
            				

            }


            }


            			markLeaf(elementTypeProvider.getLinearGradient_CommaKeyword_9ElementType());
            		
            otherlv_9=(Token)match(input,13,FOLLOW_15); 

            			doneLeaf(otherlv_9);
            		
            // PsiInternalLatteCSS.g:2718:3: ( (lv_y2_10_0= ruleSizeValue ) )
            // PsiInternalLatteCSS.g:2719:4: (lv_y2_10_0= ruleSizeValue )
            {
            // PsiInternalLatteCSS.g:2719:4: (lv_y2_10_0= ruleSizeValue )
            // PsiInternalLatteCSS.g:2720:5: lv_y2_10_0= ruleSizeValue
            {

            					markComposite(elementTypeProvider.getLinearGradient_Y2SizeValueParserRuleCall_10_0ElementType());
            				
            pushFollow(FOLLOW_34);
            ruleSizeValue();

            state._fsp--;


            					doneComposite();
            				

            }


            }


            			markLeaf(elementTypeProvider.getLinearGradient_RightParenthesisKeyword_11ElementType());
            		
            otherlv_11=(Token)match(input,143,FOLLOW_36); 

            			doneLeaf(otherlv_11);
            		

            			markLeaf(elementTypeProvider.getLinearGradient_StopsKeyword_12ElementType());
            		
            otherlv_12=(Token)match(input,145,FOLLOW_32); 

            			doneLeaf(otherlv_12);
            		
            // PsiInternalLatteCSS.g:2743:3: (otherlv_13= '(' ( (lv_stops_14_0= ruleStopValue ) ) otherlv_15= ')' )+
            int cnt41=0;
            loop41:
            do {
                int alt41=2;
                int LA41_0 = input.LA(1);

                if ( (LA41_0==142) ) {
                    alt41=1;
                }


                switch (alt41) {
            	case 1 :
            	    // PsiInternalLatteCSS.g:2744:4: otherlv_13= '(' ( (lv_stops_14_0= ruleStopValue ) ) otherlv_15= ')'
            	    {

            	    				markLeaf(elementTypeProvider.getLinearGradient_LeftParenthesisKeyword_13_0ElementType());
            	    			
            	    otherlv_13=(Token)match(input,142,FOLLOW_15); 

            	    				doneLeaf(otherlv_13);
            	    			
            	    // PsiInternalLatteCSS.g:2751:4: ( (lv_stops_14_0= ruleStopValue ) )
            	    // PsiInternalLatteCSS.g:2752:5: (lv_stops_14_0= ruleStopValue )
            	    {
            	    // PsiInternalLatteCSS.g:2752:5: (lv_stops_14_0= ruleStopValue )
            	    // PsiInternalLatteCSS.g:2753:6: lv_stops_14_0= ruleStopValue
            	    {

            	    						markComposite(elementTypeProvider.getLinearGradient_StopsStopValueParserRuleCall_13_1_0ElementType());
            	    					
            	    pushFollow(FOLLOW_34);
            	    ruleStopValue();

            	    state._fsp--;


            	    						doneComposite();
            	    					

            	    }


            	    }


            	    				markLeaf(elementTypeProvider.getLinearGradient_RightParenthesisKeyword_13_2ElementType());
            	    			
            	    otherlv_15=(Token)match(input,143,FOLLOW_37); 

            	    				doneLeaf(otherlv_15);
            	    			

            	    }
            	    break;

            	default :
            	    if ( cnt41 >= 1 ) break loop41;
                        EarlyExitException eee =
                            new EarlyExitException(41, input);
                        throw eee;
                }
                cnt41++;
            } while (true);

            // PsiInternalLatteCSS.g:2770:3: (otherlv_16= 'repeat' | otherlv_17= 'reflect' )?
            int alt42=3;
            int LA42_0 = input.LA(1);

            if ( (LA42_0==146) ) {
                alt42=1;
            }
            else if ( (LA42_0==147) ) {
                alt42=2;
            }
            switch (alt42) {
                case 1 :
                    // PsiInternalLatteCSS.g:2771:4: otherlv_16= 'repeat'
                    {

                    				markLeaf(elementTypeProvider.getLinearGradient_RepeatKeyword_14_0ElementType());
                    			
                    otherlv_16=(Token)match(input,146,FOLLOW_2); 

                    				doneLeaf(otherlv_16);
                    			

                    }
                    break;
                case 2 :
                    // PsiInternalLatteCSS.g:2779:4: otherlv_17= 'reflect'
                    {

                    				markLeaf(elementTypeProvider.getLinearGradient_ReflectKeyword_14_1ElementType());
                    			
                    otherlv_17=(Token)match(input,147,FOLLOW_2); 

                    				doneLeaf(otherlv_17);
                    			

                    }
                    break;

            }


            }


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
    // $ANTLR end "ruleLinearGradient"


    // $ANTLR start "entryRuleRadialGradient"
    // PsiInternalLatteCSS.g:2791:1: entryRuleRadialGradient : ruleRadialGradient EOF ;
    public final void entryRuleRadialGradient() throws RecognitionException {
        try {
            // PsiInternalLatteCSS.g:2791:24: ( ruleRadialGradient EOF )
            // PsiInternalLatteCSS.g:2792:2: ruleRadialGradient EOF
            {
             markComposite(elementTypeProvider.getRadialGradientElementType()); 
            pushFollow(FOLLOW_1);
            ruleRadialGradient();

            state._fsp--;

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
    // PsiInternalLatteCSS.g:2797:1: ruleRadialGradient : (otherlv_0= 'radial' (otherlv_1= '(' ( (lv_cx_2_0= ruleSizeValue ) ) otherlv_3= ',' ( (lv_cy_4_0= ruleSizeValue ) ) otherlv_5= ')' otherlv_6= ',' )? ( (lv_radius_7_0= ruleSizeValue ) ) (otherlv_8= 'focus' otherlv_9= '(' ( (lv_fx_10_0= ruleSizeValue ) ) otherlv_11= ',' ( (lv_fy_12_0= ruleSizeValue ) ) otherlv_13= ')' ) otherlv_14= 'stops' (otherlv_15= '(' ( (lv_stops_16_0= ruleStopValue ) ) otherlv_17= ')' )+ (otherlv_18= 'repeat' | otherlv_19= 'reflect' )? ) ;
    public final void ruleRadialGradient() throws RecognitionException {
        Token otherlv_0=null;
        Token otherlv_1=null;
        Token otherlv_3=null;
        Token otherlv_5=null;
        Token otherlv_6=null;
        Token otherlv_8=null;
        Token otherlv_9=null;
        Token otherlv_11=null;
        Token otherlv_13=null;
        Token otherlv_14=null;
        Token otherlv_15=null;
        Token otherlv_17=null;
        Token otherlv_18=null;
        Token otherlv_19=null;

        try {
            // PsiInternalLatteCSS.g:2797:19: ( (otherlv_0= 'radial' (otherlv_1= '(' ( (lv_cx_2_0= ruleSizeValue ) ) otherlv_3= ',' ( (lv_cy_4_0= ruleSizeValue ) ) otherlv_5= ')' otherlv_6= ',' )? ( (lv_radius_7_0= ruleSizeValue ) ) (otherlv_8= 'focus' otherlv_9= '(' ( (lv_fx_10_0= ruleSizeValue ) ) otherlv_11= ',' ( (lv_fy_12_0= ruleSizeValue ) ) otherlv_13= ')' ) otherlv_14= 'stops' (otherlv_15= '(' ( (lv_stops_16_0= ruleStopValue ) ) otherlv_17= ')' )+ (otherlv_18= 'repeat' | otherlv_19= 'reflect' )? ) )
            // PsiInternalLatteCSS.g:2798:2: (otherlv_0= 'radial' (otherlv_1= '(' ( (lv_cx_2_0= ruleSizeValue ) ) otherlv_3= ',' ( (lv_cy_4_0= ruleSizeValue ) ) otherlv_5= ')' otherlv_6= ',' )? ( (lv_radius_7_0= ruleSizeValue ) ) (otherlv_8= 'focus' otherlv_9= '(' ( (lv_fx_10_0= ruleSizeValue ) ) otherlv_11= ',' ( (lv_fy_12_0= ruleSizeValue ) ) otherlv_13= ')' ) otherlv_14= 'stops' (otherlv_15= '(' ( (lv_stops_16_0= ruleStopValue ) ) otherlv_17= ')' )+ (otherlv_18= 'repeat' | otherlv_19= 'reflect' )? )
            {
            // PsiInternalLatteCSS.g:2798:2: (otherlv_0= 'radial' (otherlv_1= '(' ( (lv_cx_2_0= ruleSizeValue ) ) otherlv_3= ',' ( (lv_cy_4_0= ruleSizeValue ) ) otherlv_5= ')' otherlv_6= ',' )? ( (lv_radius_7_0= ruleSizeValue ) ) (otherlv_8= 'focus' otherlv_9= '(' ( (lv_fx_10_0= ruleSizeValue ) ) otherlv_11= ',' ( (lv_fy_12_0= ruleSizeValue ) ) otherlv_13= ')' ) otherlv_14= 'stops' (otherlv_15= '(' ( (lv_stops_16_0= ruleStopValue ) ) otherlv_17= ')' )+ (otherlv_18= 'repeat' | otherlv_19= 'reflect' )? )
            // PsiInternalLatteCSS.g:2799:3: otherlv_0= 'radial' (otherlv_1= '(' ( (lv_cx_2_0= ruleSizeValue ) ) otherlv_3= ',' ( (lv_cy_4_0= ruleSizeValue ) ) otherlv_5= ')' otherlv_6= ',' )? ( (lv_radius_7_0= ruleSizeValue ) ) (otherlv_8= 'focus' otherlv_9= '(' ( (lv_fx_10_0= ruleSizeValue ) ) otherlv_11= ',' ( (lv_fy_12_0= ruleSizeValue ) ) otherlv_13= ')' ) otherlv_14= 'stops' (otherlv_15= '(' ( (lv_stops_16_0= ruleStopValue ) ) otherlv_17= ')' )+ (otherlv_18= 'repeat' | otherlv_19= 'reflect' )?
            {

            			markLeaf(elementTypeProvider.getRadialGradient_RadialKeyword_0ElementType());
            		
            otherlv_0=(Token)match(input,148,FOLLOW_38); 

            			doneLeaf(otherlv_0);
            		
            // PsiInternalLatteCSS.g:2806:3: (otherlv_1= '(' ( (lv_cx_2_0= ruleSizeValue ) ) otherlv_3= ',' ( (lv_cy_4_0= ruleSizeValue ) ) otherlv_5= ')' otherlv_6= ',' )?
            int alt43=2;
            int LA43_0 = input.LA(1);

            if ( (LA43_0==142) ) {
                alt43=1;
            }
            switch (alt43) {
                case 1 :
                    // PsiInternalLatteCSS.g:2807:4: otherlv_1= '(' ( (lv_cx_2_0= ruleSizeValue ) ) otherlv_3= ',' ( (lv_cy_4_0= ruleSizeValue ) ) otherlv_5= ')' otherlv_6= ','
                    {

                    				markLeaf(elementTypeProvider.getRadialGradient_LeftParenthesisKeyword_1_0ElementType());
                    			
                    otherlv_1=(Token)match(input,142,FOLLOW_15); 

                    				doneLeaf(otherlv_1);
                    			
                    // PsiInternalLatteCSS.g:2814:4: ( (lv_cx_2_0= ruleSizeValue ) )
                    // PsiInternalLatteCSS.g:2815:5: (lv_cx_2_0= ruleSizeValue )
                    {
                    // PsiInternalLatteCSS.g:2815:5: (lv_cx_2_0= ruleSizeValue )
                    // PsiInternalLatteCSS.g:2816:6: lv_cx_2_0= ruleSizeValue
                    {

                    						markComposite(elementTypeProvider.getRadialGradient_CxSizeValueParserRuleCall_1_1_0ElementType());
                    					
                    pushFollow(FOLLOW_33);
                    ruleSizeValue();

                    state._fsp--;


                    						doneComposite();
                    					

                    }


                    }


                    				markLeaf(elementTypeProvider.getRadialGradient_CommaKeyword_1_2ElementType());
                    			
                    otherlv_3=(Token)match(input,13,FOLLOW_15); 

                    				doneLeaf(otherlv_3);
                    			
                    // PsiInternalLatteCSS.g:2832:4: ( (lv_cy_4_0= ruleSizeValue ) )
                    // PsiInternalLatteCSS.g:2833:5: (lv_cy_4_0= ruleSizeValue )
                    {
                    // PsiInternalLatteCSS.g:2833:5: (lv_cy_4_0= ruleSizeValue )
                    // PsiInternalLatteCSS.g:2834:6: lv_cy_4_0= ruleSizeValue
                    {

                    						markComposite(elementTypeProvider.getRadialGradient_CySizeValueParserRuleCall_1_3_0ElementType());
                    					
                    pushFollow(FOLLOW_34);
                    ruleSizeValue();

                    state._fsp--;


                    						doneComposite();
                    					

                    }


                    }


                    				markLeaf(elementTypeProvider.getRadialGradient_RightParenthesisKeyword_1_4ElementType());
                    			
                    otherlv_5=(Token)match(input,143,FOLLOW_33); 

                    				doneLeaf(otherlv_5);
                    			

                    				markLeaf(elementTypeProvider.getRadialGradient_CommaKeyword_1_5ElementType());
                    			
                    otherlv_6=(Token)match(input,13,FOLLOW_15); 

                    				doneLeaf(otherlv_6);
                    			

                    }
                    break;

            }

            // PsiInternalLatteCSS.g:2858:3: ( (lv_radius_7_0= ruleSizeValue ) )
            // PsiInternalLatteCSS.g:2859:4: (lv_radius_7_0= ruleSizeValue )
            {
            // PsiInternalLatteCSS.g:2859:4: (lv_radius_7_0= ruleSizeValue )
            // PsiInternalLatteCSS.g:2860:5: lv_radius_7_0= ruleSizeValue
            {

            					markComposite(elementTypeProvider.getRadialGradient_RadiusSizeValueParserRuleCall_2_0ElementType());
            				
            pushFollow(FOLLOW_39);
            ruleSizeValue();

            state._fsp--;


            					doneComposite();
            				

            }


            }

            // PsiInternalLatteCSS.g:2869:3: (otherlv_8= 'focus' otherlv_9= '(' ( (lv_fx_10_0= ruleSizeValue ) ) otherlv_11= ',' ( (lv_fy_12_0= ruleSizeValue ) ) otherlv_13= ')' )
            // PsiInternalLatteCSS.g:2870:4: otherlv_8= 'focus' otherlv_9= '(' ( (lv_fx_10_0= ruleSizeValue ) ) otherlv_11= ',' ( (lv_fy_12_0= ruleSizeValue ) ) otherlv_13= ')'
            {

            				markLeaf(elementTypeProvider.getRadialGradient_FocusKeyword_3_0ElementType());
            			
            otherlv_8=(Token)match(input,149,FOLLOW_32); 

            				doneLeaf(otherlv_8);
            			

            				markLeaf(elementTypeProvider.getRadialGradient_LeftParenthesisKeyword_3_1ElementType());
            			
            otherlv_9=(Token)match(input,142,FOLLOW_15); 

            				doneLeaf(otherlv_9);
            			
            // PsiInternalLatteCSS.g:2884:4: ( (lv_fx_10_0= ruleSizeValue ) )
            // PsiInternalLatteCSS.g:2885:5: (lv_fx_10_0= ruleSizeValue )
            {
            // PsiInternalLatteCSS.g:2885:5: (lv_fx_10_0= ruleSizeValue )
            // PsiInternalLatteCSS.g:2886:6: lv_fx_10_0= ruleSizeValue
            {

            						markComposite(elementTypeProvider.getRadialGradient_FxSizeValueParserRuleCall_3_2_0ElementType());
            					
            pushFollow(FOLLOW_33);
            ruleSizeValue();

            state._fsp--;


            						doneComposite();
            					

            }


            }


            				markLeaf(elementTypeProvider.getRadialGradient_CommaKeyword_3_3ElementType());
            			
            otherlv_11=(Token)match(input,13,FOLLOW_15); 

            				doneLeaf(otherlv_11);
            			
            // PsiInternalLatteCSS.g:2902:4: ( (lv_fy_12_0= ruleSizeValue ) )
            // PsiInternalLatteCSS.g:2903:5: (lv_fy_12_0= ruleSizeValue )
            {
            // PsiInternalLatteCSS.g:2903:5: (lv_fy_12_0= ruleSizeValue )
            // PsiInternalLatteCSS.g:2904:6: lv_fy_12_0= ruleSizeValue
            {

            						markComposite(elementTypeProvider.getRadialGradient_FySizeValueParserRuleCall_3_4_0ElementType());
            					
            pushFollow(FOLLOW_34);
            ruleSizeValue();

            state._fsp--;


            						doneComposite();
            					

            }


            }


            				markLeaf(elementTypeProvider.getRadialGradient_RightParenthesisKeyword_3_5ElementType());
            			
            otherlv_13=(Token)match(input,143,FOLLOW_36); 

            				doneLeaf(otherlv_13);
            			

            }


            			markLeaf(elementTypeProvider.getRadialGradient_StopsKeyword_4ElementType());
            		
            otherlv_14=(Token)match(input,145,FOLLOW_32); 

            			doneLeaf(otherlv_14);
            		
            // PsiInternalLatteCSS.g:2928:3: (otherlv_15= '(' ( (lv_stops_16_0= ruleStopValue ) ) otherlv_17= ')' )+
            int cnt44=0;
            loop44:
            do {
                int alt44=2;
                int LA44_0 = input.LA(1);

                if ( (LA44_0==142) ) {
                    alt44=1;
                }


                switch (alt44) {
            	case 1 :
            	    // PsiInternalLatteCSS.g:2929:4: otherlv_15= '(' ( (lv_stops_16_0= ruleStopValue ) ) otherlv_17= ')'
            	    {

            	    				markLeaf(elementTypeProvider.getRadialGradient_LeftParenthesisKeyword_5_0ElementType());
            	    			
            	    otherlv_15=(Token)match(input,142,FOLLOW_15); 

            	    				doneLeaf(otherlv_15);
            	    			
            	    // PsiInternalLatteCSS.g:2936:4: ( (lv_stops_16_0= ruleStopValue ) )
            	    // PsiInternalLatteCSS.g:2937:5: (lv_stops_16_0= ruleStopValue )
            	    {
            	    // PsiInternalLatteCSS.g:2937:5: (lv_stops_16_0= ruleStopValue )
            	    // PsiInternalLatteCSS.g:2938:6: lv_stops_16_0= ruleStopValue
            	    {

            	    						markComposite(elementTypeProvider.getRadialGradient_StopsStopValueParserRuleCall_5_1_0ElementType());
            	    					
            	    pushFollow(FOLLOW_34);
            	    ruleStopValue();

            	    state._fsp--;


            	    						doneComposite();
            	    					

            	    }


            	    }


            	    				markLeaf(elementTypeProvider.getRadialGradient_RightParenthesisKeyword_5_2ElementType());
            	    			
            	    otherlv_17=(Token)match(input,143,FOLLOW_37); 

            	    				doneLeaf(otherlv_17);
            	    			

            	    }
            	    break;

            	default :
            	    if ( cnt44 >= 1 ) break loop44;
                        EarlyExitException eee =
                            new EarlyExitException(44, input);
                        throw eee;
                }
                cnt44++;
            } while (true);

            // PsiInternalLatteCSS.g:2955:3: (otherlv_18= 'repeat' | otherlv_19= 'reflect' )?
            int alt45=3;
            int LA45_0 = input.LA(1);

            if ( (LA45_0==146) ) {
                alt45=1;
            }
            else if ( (LA45_0==147) ) {
                alt45=2;
            }
            switch (alt45) {
                case 1 :
                    // PsiInternalLatteCSS.g:2956:4: otherlv_18= 'repeat'
                    {

                    				markLeaf(elementTypeProvider.getRadialGradient_RepeatKeyword_6_0ElementType());
                    			
                    otherlv_18=(Token)match(input,146,FOLLOW_2); 

                    				doneLeaf(otherlv_18);
                    			

                    }
                    break;
                case 2 :
                    // PsiInternalLatteCSS.g:2964:4: otherlv_19= 'reflect'
                    {

                    				markLeaf(elementTypeProvider.getRadialGradient_ReflectKeyword_6_1ElementType());
                    			
                    otherlv_19=(Token)match(input,147,FOLLOW_2); 

                    				doneLeaf(otherlv_19);
                    			

                    }
                    break;

            }


            }


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
    // $ANTLR end "ruleRadialGradient"


    // $ANTLR start "entryRuleStopValue"
    // PsiInternalLatteCSS.g:2976:1: entryRuleStopValue : ruleStopValue EOF ;
    public final void entryRuleStopValue() throws RecognitionException {
        try {
            // PsiInternalLatteCSS.g:2976:19: ( ruleStopValue EOF )
            // PsiInternalLatteCSS.g:2977:2: ruleStopValue EOF
            {
             markComposite(elementTypeProvider.getStopValueElementType()); 
            pushFollow(FOLLOW_1);
            ruleStopValue();

            state._fsp--;

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
    // PsiInternalLatteCSS.g:2982:1: ruleStopValue : ( ( (lv_pos_0_0= ruleSizeValue ) ) otherlv_1= ',' ( (lv_color_2_0= ruleColorValue ) ) ) ;
    public final void ruleStopValue() throws RecognitionException {
        Token otherlv_1=null;

        try {
            // PsiInternalLatteCSS.g:2982:14: ( ( ( (lv_pos_0_0= ruleSizeValue ) ) otherlv_1= ',' ( (lv_color_2_0= ruleColorValue ) ) ) )
            // PsiInternalLatteCSS.g:2983:2: ( ( (lv_pos_0_0= ruleSizeValue ) ) otherlv_1= ',' ( (lv_color_2_0= ruleColorValue ) ) )
            {
            // PsiInternalLatteCSS.g:2983:2: ( ( (lv_pos_0_0= ruleSizeValue ) ) otherlv_1= ',' ( (lv_color_2_0= ruleColorValue ) ) )
            // PsiInternalLatteCSS.g:2984:3: ( (lv_pos_0_0= ruleSizeValue ) ) otherlv_1= ',' ( (lv_color_2_0= ruleColorValue ) )
            {
            // PsiInternalLatteCSS.g:2984:3: ( (lv_pos_0_0= ruleSizeValue ) )
            // PsiInternalLatteCSS.g:2985:4: (lv_pos_0_0= ruleSizeValue )
            {
            // PsiInternalLatteCSS.g:2985:4: (lv_pos_0_0= ruleSizeValue )
            // PsiInternalLatteCSS.g:2986:5: lv_pos_0_0= ruleSizeValue
            {

            					markComposite(elementTypeProvider.getStopValue_PosSizeValueParserRuleCall_0_0ElementType());
            				
            pushFollow(FOLLOW_33);
            ruleSizeValue();

            state._fsp--;


            					doneComposite();
            				

            }


            }


            			markLeaf(elementTypeProvider.getStopValue_CommaKeyword_1ElementType());
            		
            otherlv_1=(Token)match(input,13,FOLLOW_17); 

            			doneLeaf(otherlv_1);
            		
            // PsiInternalLatteCSS.g:3002:3: ( (lv_color_2_0= ruleColorValue ) )
            // PsiInternalLatteCSS.g:3003:4: (lv_color_2_0= ruleColorValue )
            {
            // PsiInternalLatteCSS.g:3003:4: (lv_color_2_0= ruleColorValue )
            // PsiInternalLatteCSS.g:3004:5: lv_color_2_0= ruleColorValue
            {

            					markComposite(elementTypeProvider.getStopValue_ColorColorValueParserRuleCall_2_0ElementType());
            				
            pushFollow(FOLLOW_2);
            ruleColorValue();

            state._fsp--;


            					doneComposite();
            				

            }


            }


            }


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
    // $ANTLR end "ruleStopValue"


    // $ANTLR start "entryRuleColorValue"
    // PsiInternalLatteCSS.g:3017:1: entryRuleColorValue : ruleColorValue EOF ;
    public final void entryRuleColorValue() throws RecognitionException {
        try {
            // PsiInternalLatteCSS.g:3017:20: ( ruleColorValue EOF )
            // PsiInternalLatteCSS.g:3018:2: ruleColorValue EOF
            {
             markComposite(elementTypeProvider.getColorValueElementType()); 
            pushFollow(FOLLOW_1);
            ruleColorValue();

            state._fsp--;

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
    // PsiInternalLatteCSS.g:3023:1: ruleColorValue : ( ( (lv_namedColor_0_0= ruleNamedColor ) ) | ( (lv_rgb_1_0= ruleRGBColor ) ) ) ;
    public final void ruleColorValue() throws RecognitionException {
        try {
            // PsiInternalLatteCSS.g:3023:15: ( ( ( (lv_namedColor_0_0= ruleNamedColor ) ) | ( (lv_rgb_1_0= ruleRGBColor ) ) ) )
            // PsiInternalLatteCSS.g:3024:2: ( ( (lv_namedColor_0_0= ruleNamedColor ) ) | ( (lv_rgb_1_0= ruleRGBColor ) ) )
            {
            // PsiInternalLatteCSS.g:3024:2: ( ( (lv_namedColor_0_0= ruleNamedColor ) ) | ( (lv_rgb_1_0= ruleRGBColor ) ) )
            int alt46=2;
            int LA46_0 = input.LA(1);

            if ( ((LA46_0>=150 && LA46_0<=297)) ) {
                alt46=1;
            }
            else if ( (LA46_0==RULE_HEX_NUMBER||(LA46_0>=298 && LA46_0<=299)) ) {
                alt46=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 46, 0, input);

                throw nvae;
            }
            switch (alt46) {
                case 1 :
                    // PsiInternalLatteCSS.g:3025:3: ( (lv_namedColor_0_0= ruleNamedColor ) )
                    {
                    // PsiInternalLatteCSS.g:3025:3: ( (lv_namedColor_0_0= ruleNamedColor ) )
                    // PsiInternalLatteCSS.g:3026:4: (lv_namedColor_0_0= ruleNamedColor )
                    {
                    // PsiInternalLatteCSS.g:3026:4: (lv_namedColor_0_0= ruleNamedColor )
                    // PsiInternalLatteCSS.g:3027:5: lv_namedColor_0_0= ruleNamedColor
                    {

                    					markComposite(elementTypeProvider.getColorValue_NamedColorNamedColorParserRuleCall_0_0ElementType());
                    				
                    pushFollow(FOLLOW_2);
                    ruleNamedColor();

                    state._fsp--;


                    					doneComposite();
                    				

                    }


                    }


                    }
                    break;
                case 2 :
                    // PsiInternalLatteCSS.g:3037:3: ( (lv_rgb_1_0= ruleRGBColor ) )
                    {
                    // PsiInternalLatteCSS.g:3037:3: ( (lv_rgb_1_0= ruleRGBColor ) )
                    // PsiInternalLatteCSS.g:3038:4: (lv_rgb_1_0= ruleRGBColor )
                    {
                    // PsiInternalLatteCSS.g:3038:4: (lv_rgb_1_0= ruleRGBColor )
                    // PsiInternalLatteCSS.g:3039:5: lv_rgb_1_0= ruleRGBColor
                    {

                    					markComposite(elementTypeProvider.getColorValue_RgbRGBColorParserRuleCall_1_0ElementType());
                    				
                    pushFollow(FOLLOW_2);
                    ruleRGBColor();

                    state._fsp--;


                    					doneComposite();
                    				

                    }


                    }


                    }
                    break;

            }


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
    // $ANTLR end "ruleColorValue"


    // $ANTLR start "entryRuleNamedColor"
    // PsiInternalLatteCSS.g:3052:1: entryRuleNamedColor : ruleNamedColor EOF ;
    public final void entryRuleNamedColor() throws RecognitionException {
        try {
            // PsiInternalLatteCSS.g:3052:20: ( ruleNamedColor EOF )
            // PsiInternalLatteCSS.g:3053:2: ruleNamedColor EOF
            {
             markComposite(elementTypeProvider.getNamedColorElementType()); 
            pushFollow(FOLLOW_1);
            ruleNamedColor();

            state._fsp--;

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
    // PsiInternalLatteCSS.g:3058:1: ruleNamedColor : (kw= 'aliceblue' | kw= 'antiquewhite' | kw= 'aqua' | kw= 'aquamarine' | kw= 'azure' | kw= 'beige' | kw= 'bisque' | kw= 'black' | kw= 'blanchedalmond' | kw= 'blue' | kw= 'blueviolet' | kw= 'brown' | kw= 'burlywood' | kw= 'cadetblue' | kw= 'chartreuse' | kw= 'chocolate' | kw= 'coral' | kw= 'cornflowerblue' | kw= 'cornsilk' | kw= 'crimson' | kw= 'cyan' | kw= 'darkblue' | kw= 'darkcyan' | kw= 'darkgoldenrod' | kw= 'darkgray' | kw= 'darkgreen' | kw= 'darkgrey' | kw= 'darkkhaki' | kw= 'darkmagenta' | kw= 'darkolivegreen' | kw= 'darkorange' | kw= 'darkorchid' | kw= 'darkred' | kw= 'darksalmon' | kw= 'darkseagreen' | kw= 'darkslateblue' | kw= 'darkslategray' | kw= 'darkslategrey' | kw= 'darkturquoise' | kw= 'darkviolet' | kw= 'deeppink' | kw= 'deepskyblue' | kw= 'dimgray' | kw= 'dimgrey' | kw= 'dodgerblue' | kw= 'firebrick' | kw= 'floralwhite' | kw= 'forestgreen' | kw= 'fuchsia' | kw= 'gainsboro' | kw= 'ghostwhite' | kw= 'gold' | kw= 'goldenrod' | kw= 'gray' | kw= 'green' | kw= 'greenyellow' | kw= 'grey' | kw= 'honeydew' | kw= 'hotpink' | kw= 'indianred' | kw= 'indigo' | kw= 'ivory' | kw= 'khaki' | kw= 'lavender' | kw= 'lavenderblush' | kw= 'lawngreen' | kw= 'lemonchiffon' | kw= 'lightblue' | kw= 'lightcoral' | kw= 'lightcyan' | kw= 'lightgoldenrodyellow' | kw= 'lightgray' | kw= 'lightgreen' | kw= 'lightgrey' | kw= 'lightpink' | kw= 'lightsalmon' | kw= 'lightseagreen' | kw= 'lightskyblue' | kw= 'lightslategray' | kw= 'lightslategrey' | kw= 'lightsteelblue' | kw= 'lightyellow' | kw= 'lime' | kw= 'limegreen' | kw= 'linen' | kw= 'magenta' | kw= 'maroon' | kw= 'mediumaquamarine' | kw= 'mediumblue' | kw= 'mediumorchid' | kw= 'mediumpurple' | kw= 'mediumseagreen' | kw= 'mediumslateblue' | kw= 'mediumspringgreen' | kw= 'mediumturquoise' | kw= 'mediumvioletred' | kw= 'midnightblue' | kw= 'mintcream' | kw= 'mistyrose' | kw= 'moccasin' | kw= 'navajowhite' | kw= 'navy' | kw= 'oldlace' | kw= 'olive' | kw= 'olivedrab' | kw= 'orange' | kw= 'orangered' | kw= 'orchid' | kw= 'palegoldenrod' | kw= 'palegreen' | kw= 'paleturquoise' | kw= 'palevioletred' | kw= 'papayawhip' | kw= 'peachpuff' | kw= 'peru' | kw= 'pink' | kw= 'plum' | kw= 'powderblue' | kw= 'purple' | kw= 'red' | kw= 'rosybrown' | kw= 'royalblue' | kw= 'saddlebrown' | kw= 'salmon' | kw= 'sandybrown' | kw= 'seagreen' | kw= 'seashell' | kw= 'sienna' | kw= 'silver' | kw= 'skyblue' | kw= 'slateblue' | kw= 'slategray' | kw= 'slategrey' | kw= 'snow' | kw= 'springgreen' | kw= 'steelblue' | kw= 'tan' | kw= 'teal' | kw= 'thistle' | kw= 'tomato' | kw= 'turquoise' | kw= 'violet' | kw= 'wheat' | kw= 'white' | kw= 'whitesmoke' | kw= 'yellow' | kw= 'yellowgreen' | kw= 'transparent' ) ;
    public final void ruleNamedColor() throws RecognitionException {
        Token kw=null;

        try {
            // PsiInternalLatteCSS.g:3058:15: ( (kw= 'aliceblue' | kw= 'antiquewhite' | kw= 'aqua' | kw= 'aquamarine' | kw= 'azure' | kw= 'beige' | kw= 'bisque' | kw= 'black' | kw= 'blanchedalmond' | kw= 'blue' | kw= 'blueviolet' | kw= 'brown' | kw= 'burlywood' | kw= 'cadetblue' | kw= 'chartreuse' | kw= 'chocolate' | kw= 'coral' | kw= 'cornflowerblue' | kw= 'cornsilk' | kw= 'crimson' | kw= 'cyan' | kw= 'darkblue' | kw= 'darkcyan' | kw= 'darkgoldenrod' | kw= 'darkgray' | kw= 'darkgreen' | kw= 'darkgrey' | kw= 'darkkhaki' | kw= 'darkmagenta' | kw= 'darkolivegreen' | kw= 'darkorange' | kw= 'darkorchid' | kw= 'darkred' | kw= 'darksalmon' | kw= 'darkseagreen' | kw= 'darkslateblue' | kw= 'darkslategray' | kw= 'darkslategrey' | kw= 'darkturquoise' | kw= 'darkviolet' | kw= 'deeppink' | kw= 'deepskyblue' | kw= 'dimgray' | kw= 'dimgrey' | kw= 'dodgerblue' | kw= 'firebrick' | kw= 'floralwhite' | kw= 'forestgreen' | kw= 'fuchsia' | kw= 'gainsboro' | kw= 'ghostwhite' | kw= 'gold' | kw= 'goldenrod' | kw= 'gray' | kw= 'green' | kw= 'greenyellow' | kw= 'grey' | kw= 'honeydew' | kw= 'hotpink' | kw= 'indianred' | kw= 'indigo' | kw= 'ivory' | kw= 'khaki' | kw= 'lavender' | kw= 'lavenderblush' | kw= 'lawngreen' | kw= 'lemonchiffon' | kw= 'lightblue' | kw= 'lightcoral' | kw= 'lightcyan' | kw= 'lightgoldenrodyellow' | kw= 'lightgray' | kw= 'lightgreen' | kw= 'lightgrey' | kw= 'lightpink' | kw= 'lightsalmon' | kw= 'lightseagreen' | kw= 'lightskyblue' | kw= 'lightslategray' | kw= 'lightslategrey' | kw= 'lightsteelblue' | kw= 'lightyellow' | kw= 'lime' | kw= 'limegreen' | kw= 'linen' | kw= 'magenta' | kw= 'maroon' | kw= 'mediumaquamarine' | kw= 'mediumblue' | kw= 'mediumorchid' | kw= 'mediumpurple' | kw= 'mediumseagreen' | kw= 'mediumslateblue' | kw= 'mediumspringgreen' | kw= 'mediumturquoise' | kw= 'mediumvioletred' | kw= 'midnightblue' | kw= 'mintcream' | kw= 'mistyrose' | kw= 'moccasin' | kw= 'navajowhite' | kw= 'navy' | kw= 'oldlace' | kw= 'olive' | kw= 'olivedrab' | kw= 'orange' | kw= 'orangered' | kw= 'orchid' | kw= 'palegoldenrod' | kw= 'palegreen' | kw= 'paleturquoise' | kw= 'palevioletred' | kw= 'papayawhip' | kw= 'peachpuff' | kw= 'peru' | kw= 'pink' | kw= 'plum' | kw= 'powderblue' | kw= 'purple' | kw= 'red' | kw= 'rosybrown' | kw= 'royalblue' | kw= 'saddlebrown' | kw= 'salmon' | kw= 'sandybrown' | kw= 'seagreen' | kw= 'seashell' | kw= 'sienna' | kw= 'silver' | kw= 'skyblue' | kw= 'slateblue' | kw= 'slategray' | kw= 'slategrey' | kw= 'snow' | kw= 'springgreen' | kw= 'steelblue' | kw= 'tan' | kw= 'teal' | kw= 'thistle' | kw= 'tomato' | kw= 'turquoise' | kw= 'violet' | kw= 'wheat' | kw= 'white' | kw= 'whitesmoke' | kw= 'yellow' | kw= 'yellowgreen' | kw= 'transparent' ) )
            // PsiInternalLatteCSS.g:3059:2: (kw= 'aliceblue' | kw= 'antiquewhite' | kw= 'aqua' | kw= 'aquamarine' | kw= 'azure' | kw= 'beige' | kw= 'bisque' | kw= 'black' | kw= 'blanchedalmond' | kw= 'blue' | kw= 'blueviolet' | kw= 'brown' | kw= 'burlywood' | kw= 'cadetblue' | kw= 'chartreuse' | kw= 'chocolate' | kw= 'coral' | kw= 'cornflowerblue' | kw= 'cornsilk' | kw= 'crimson' | kw= 'cyan' | kw= 'darkblue' | kw= 'darkcyan' | kw= 'darkgoldenrod' | kw= 'darkgray' | kw= 'darkgreen' | kw= 'darkgrey' | kw= 'darkkhaki' | kw= 'darkmagenta' | kw= 'darkolivegreen' | kw= 'darkorange' | kw= 'darkorchid' | kw= 'darkred' | kw= 'darksalmon' | kw= 'darkseagreen' | kw= 'darkslateblue' | kw= 'darkslategray' | kw= 'darkslategrey' | kw= 'darkturquoise' | kw= 'darkviolet' | kw= 'deeppink' | kw= 'deepskyblue' | kw= 'dimgray' | kw= 'dimgrey' | kw= 'dodgerblue' | kw= 'firebrick' | kw= 'floralwhite' | kw= 'forestgreen' | kw= 'fuchsia' | kw= 'gainsboro' | kw= 'ghostwhite' | kw= 'gold' | kw= 'goldenrod' | kw= 'gray' | kw= 'green' | kw= 'greenyellow' | kw= 'grey' | kw= 'honeydew' | kw= 'hotpink' | kw= 'indianred' | kw= 'indigo' | kw= 'ivory' | kw= 'khaki' | kw= 'lavender' | kw= 'lavenderblush' | kw= 'lawngreen' | kw= 'lemonchiffon' | kw= 'lightblue' | kw= 'lightcoral' | kw= 'lightcyan' | kw= 'lightgoldenrodyellow' | kw= 'lightgray' | kw= 'lightgreen' | kw= 'lightgrey' | kw= 'lightpink' | kw= 'lightsalmon' | kw= 'lightseagreen' | kw= 'lightskyblue' | kw= 'lightslategray' | kw= 'lightslategrey' | kw= 'lightsteelblue' | kw= 'lightyellow' | kw= 'lime' | kw= 'limegreen' | kw= 'linen' | kw= 'magenta' | kw= 'maroon' | kw= 'mediumaquamarine' | kw= 'mediumblue' | kw= 'mediumorchid' | kw= 'mediumpurple' | kw= 'mediumseagreen' | kw= 'mediumslateblue' | kw= 'mediumspringgreen' | kw= 'mediumturquoise' | kw= 'mediumvioletred' | kw= 'midnightblue' | kw= 'mintcream' | kw= 'mistyrose' | kw= 'moccasin' | kw= 'navajowhite' | kw= 'navy' | kw= 'oldlace' | kw= 'olive' | kw= 'olivedrab' | kw= 'orange' | kw= 'orangered' | kw= 'orchid' | kw= 'palegoldenrod' | kw= 'palegreen' | kw= 'paleturquoise' | kw= 'palevioletred' | kw= 'papayawhip' | kw= 'peachpuff' | kw= 'peru' | kw= 'pink' | kw= 'plum' | kw= 'powderblue' | kw= 'purple' | kw= 'red' | kw= 'rosybrown' | kw= 'royalblue' | kw= 'saddlebrown' | kw= 'salmon' | kw= 'sandybrown' | kw= 'seagreen' | kw= 'seashell' | kw= 'sienna' | kw= 'silver' | kw= 'skyblue' | kw= 'slateblue' | kw= 'slategray' | kw= 'slategrey' | kw= 'snow' | kw= 'springgreen' | kw= 'steelblue' | kw= 'tan' | kw= 'teal' | kw= 'thistle' | kw= 'tomato' | kw= 'turquoise' | kw= 'violet' | kw= 'wheat' | kw= 'white' | kw= 'whitesmoke' | kw= 'yellow' | kw= 'yellowgreen' | kw= 'transparent' )
            {
            // PsiInternalLatteCSS.g:3059:2: (kw= 'aliceblue' | kw= 'antiquewhite' | kw= 'aqua' | kw= 'aquamarine' | kw= 'azure' | kw= 'beige' | kw= 'bisque' | kw= 'black' | kw= 'blanchedalmond' | kw= 'blue' | kw= 'blueviolet' | kw= 'brown' | kw= 'burlywood' | kw= 'cadetblue' | kw= 'chartreuse' | kw= 'chocolate' | kw= 'coral' | kw= 'cornflowerblue' | kw= 'cornsilk' | kw= 'crimson' | kw= 'cyan' | kw= 'darkblue' | kw= 'darkcyan' | kw= 'darkgoldenrod' | kw= 'darkgray' | kw= 'darkgreen' | kw= 'darkgrey' | kw= 'darkkhaki' | kw= 'darkmagenta' | kw= 'darkolivegreen' | kw= 'darkorange' | kw= 'darkorchid' | kw= 'darkred' | kw= 'darksalmon' | kw= 'darkseagreen' | kw= 'darkslateblue' | kw= 'darkslategray' | kw= 'darkslategrey' | kw= 'darkturquoise' | kw= 'darkviolet' | kw= 'deeppink' | kw= 'deepskyblue' | kw= 'dimgray' | kw= 'dimgrey' | kw= 'dodgerblue' | kw= 'firebrick' | kw= 'floralwhite' | kw= 'forestgreen' | kw= 'fuchsia' | kw= 'gainsboro' | kw= 'ghostwhite' | kw= 'gold' | kw= 'goldenrod' | kw= 'gray' | kw= 'green' | kw= 'greenyellow' | kw= 'grey' | kw= 'honeydew' | kw= 'hotpink' | kw= 'indianred' | kw= 'indigo' | kw= 'ivory' | kw= 'khaki' | kw= 'lavender' | kw= 'lavenderblush' | kw= 'lawngreen' | kw= 'lemonchiffon' | kw= 'lightblue' | kw= 'lightcoral' | kw= 'lightcyan' | kw= 'lightgoldenrodyellow' | kw= 'lightgray' | kw= 'lightgreen' | kw= 'lightgrey' | kw= 'lightpink' | kw= 'lightsalmon' | kw= 'lightseagreen' | kw= 'lightskyblue' | kw= 'lightslategray' | kw= 'lightslategrey' | kw= 'lightsteelblue' | kw= 'lightyellow' | kw= 'lime' | kw= 'limegreen' | kw= 'linen' | kw= 'magenta' | kw= 'maroon' | kw= 'mediumaquamarine' | kw= 'mediumblue' | kw= 'mediumorchid' | kw= 'mediumpurple' | kw= 'mediumseagreen' | kw= 'mediumslateblue' | kw= 'mediumspringgreen' | kw= 'mediumturquoise' | kw= 'mediumvioletred' | kw= 'midnightblue' | kw= 'mintcream' | kw= 'mistyrose' | kw= 'moccasin' | kw= 'navajowhite' | kw= 'navy' | kw= 'oldlace' | kw= 'olive' | kw= 'olivedrab' | kw= 'orange' | kw= 'orangered' | kw= 'orchid' | kw= 'palegoldenrod' | kw= 'palegreen' | kw= 'paleturquoise' | kw= 'palevioletred' | kw= 'papayawhip' | kw= 'peachpuff' | kw= 'peru' | kw= 'pink' | kw= 'plum' | kw= 'powderblue' | kw= 'purple' | kw= 'red' | kw= 'rosybrown' | kw= 'royalblue' | kw= 'saddlebrown' | kw= 'salmon' | kw= 'sandybrown' | kw= 'seagreen' | kw= 'seashell' | kw= 'sienna' | kw= 'silver' | kw= 'skyblue' | kw= 'slateblue' | kw= 'slategray' | kw= 'slategrey' | kw= 'snow' | kw= 'springgreen' | kw= 'steelblue' | kw= 'tan' | kw= 'teal' | kw= 'thistle' | kw= 'tomato' | kw= 'turquoise' | kw= 'violet' | kw= 'wheat' | kw= 'white' | kw= 'whitesmoke' | kw= 'yellow' | kw= 'yellowgreen' | kw= 'transparent' )
            int alt47=148;
            switch ( input.LA(1) ) {
            case 150:
                {
                alt47=1;
                }
                break;
            case 151:
                {
                alt47=2;
                }
                break;
            case 152:
                {
                alt47=3;
                }
                break;
            case 153:
                {
                alt47=4;
                }
                break;
            case 154:
                {
                alt47=5;
                }
                break;
            case 155:
                {
                alt47=6;
                }
                break;
            case 156:
                {
                alt47=7;
                }
                break;
            case 157:
                {
                alt47=8;
                }
                break;
            case 158:
                {
                alt47=9;
                }
                break;
            case 159:
                {
                alt47=10;
                }
                break;
            case 160:
                {
                alt47=11;
                }
                break;
            case 161:
                {
                alt47=12;
                }
                break;
            case 162:
                {
                alt47=13;
                }
                break;
            case 163:
                {
                alt47=14;
                }
                break;
            case 164:
                {
                alt47=15;
                }
                break;
            case 165:
                {
                alt47=16;
                }
                break;
            case 166:
                {
                alt47=17;
                }
                break;
            case 167:
                {
                alt47=18;
                }
                break;
            case 168:
                {
                alt47=19;
                }
                break;
            case 169:
                {
                alt47=20;
                }
                break;
            case 170:
                {
                alt47=21;
                }
                break;
            case 171:
                {
                alt47=22;
                }
                break;
            case 172:
                {
                alt47=23;
                }
                break;
            case 173:
                {
                alt47=24;
                }
                break;
            case 174:
                {
                alt47=25;
                }
                break;
            case 175:
                {
                alt47=26;
                }
                break;
            case 176:
                {
                alt47=27;
                }
                break;
            case 177:
                {
                alt47=28;
                }
                break;
            case 178:
                {
                alt47=29;
                }
                break;
            case 179:
                {
                alt47=30;
                }
                break;
            case 180:
                {
                alt47=31;
                }
                break;
            case 181:
                {
                alt47=32;
                }
                break;
            case 182:
                {
                alt47=33;
                }
                break;
            case 183:
                {
                alt47=34;
                }
                break;
            case 184:
                {
                alt47=35;
                }
                break;
            case 185:
                {
                alt47=36;
                }
                break;
            case 186:
                {
                alt47=37;
                }
                break;
            case 187:
                {
                alt47=38;
                }
                break;
            case 188:
                {
                alt47=39;
                }
                break;
            case 189:
                {
                alt47=40;
                }
                break;
            case 190:
                {
                alt47=41;
                }
                break;
            case 191:
                {
                alt47=42;
                }
                break;
            case 192:
                {
                alt47=43;
                }
                break;
            case 193:
                {
                alt47=44;
                }
                break;
            case 194:
                {
                alt47=45;
                }
                break;
            case 195:
                {
                alt47=46;
                }
                break;
            case 196:
                {
                alt47=47;
                }
                break;
            case 197:
                {
                alt47=48;
                }
                break;
            case 198:
                {
                alt47=49;
                }
                break;
            case 199:
                {
                alt47=50;
                }
                break;
            case 200:
                {
                alt47=51;
                }
                break;
            case 201:
                {
                alt47=52;
                }
                break;
            case 202:
                {
                alt47=53;
                }
                break;
            case 203:
                {
                alt47=54;
                }
                break;
            case 204:
                {
                alt47=55;
                }
                break;
            case 205:
                {
                alt47=56;
                }
                break;
            case 206:
                {
                alt47=57;
                }
                break;
            case 207:
                {
                alt47=58;
                }
                break;
            case 208:
                {
                alt47=59;
                }
                break;
            case 209:
                {
                alt47=60;
                }
                break;
            case 210:
                {
                alt47=61;
                }
                break;
            case 211:
                {
                alt47=62;
                }
                break;
            case 212:
                {
                alt47=63;
                }
                break;
            case 213:
                {
                alt47=64;
                }
                break;
            case 214:
                {
                alt47=65;
                }
                break;
            case 215:
                {
                alt47=66;
                }
                break;
            case 216:
                {
                alt47=67;
                }
                break;
            case 217:
                {
                alt47=68;
                }
                break;
            case 218:
                {
                alt47=69;
                }
                break;
            case 219:
                {
                alt47=70;
                }
                break;
            case 220:
                {
                alt47=71;
                }
                break;
            case 221:
                {
                alt47=72;
                }
                break;
            case 222:
                {
                alt47=73;
                }
                break;
            case 223:
                {
                alt47=74;
                }
                break;
            case 224:
                {
                alt47=75;
                }
                break;
            case 225:
                {
                alt47=76;
                }
                break;
            case 226:
                {
                alt47=77;
                }
                break;
            case 227:
                {
                alt47=78;
                }
                break;
            case 228:
                {
                alt47=79;
                }
                break;
            case 229:
                {
                alt47=80;
                }
                break;
            case 230:
                {
                alt47=81;
                }
                break;
            case 231:
                {
                alt47=82;
                }
                break;
            case 232:
                {
                alt47=83;
                }
                break;
            case 233:
                {
                alt47=84;
                }
                break;
            case 234:
                {
                alt47=85;
                }
                break;
            case 235:
                {
                alt47=86;
                }
                break;
            case 236:
                {
                alt47=87;
                }
                break;
            case 237:
                {
                alt47=88;
                }
                break;
            case 238:
                {
                alt47=89;
                }
                break;
            case 239:
                {
                alt47=90;
                }
                break;
            case 240:
                {
                alt47=91;
                }
                break;
            case 241:
                {
                alt47=92;
                }
                break;
            case 242:
                {
                alt47=93;
                }
                break;
            case 243:
                {
                alt47=94;
                }
                break;
            case 244:
                {
                alt47=95;
                }
                break;
            case 245:
                {
                alt47=96;
                }
                break;
            case 246:
                {
                alt47=97;
                }
                break;
            case 247:
                {
                alt47=98;
                }
                break;
            case 248:
                {
                alt47=99;
                }
                break;
            case 249:
                {
                alt47=100;
                }
                break;
            case 250:
                {
                alt47=101;
                }
                break;
            case 251:
                {
                alt47=102;
                }
                break;
            case 252:
                {
                alt47=103;
                }
                break;
            case 253:
                {
                alt47=104;
                }
                break;
            case 254:
                {
                alt47=105;
                }
                break;
            case 255:
                {
                alt47=106;
                }
                break;
            case 256:
                {
                alt47=107;
                }
                break;
            case 257:
                {
                alt47=108;
                }
                break;
            case 258:
                {
                alt47=109;
                }
                break;
            case 259:
                {
                alt47=110;
                }
                break;
            case 260:
                {
                alt47=111;
                }
                break;
            case 261:
                {
                alt47=112;
                }
                break;
            case 262:
                {
                alt47=113;
                }
                break;
            case 263:
                {
                alt47=114;
                }
                break;
            case 264:
                {
                alt47=115;
                }
                break;
            case 265:
                {
                alt47=116;
                }
                break;
            case 266:
                {
                alt47=117;
                }
                break;
            case 267:
                {
                alt47=118;
                }
                break;
            case 268:
                {
                alt47=119;
                }
                break;
            case 269:
                {
                alt47=120;
                }
                break;
            case 270:
                {
                alt47=121;
                }
                break;
            case 271:
                {
                alt47=122;
                }
                break;
            case 272:
                {
                alt47=123;
                }
                break;
            case 273:
                {
                alt47=124;
                }
                break;
            case 274:
                {
                alt47=125;
                }
                break;
            case 275:
                {
                alt47=126;
                }
                break;
            case 276:
                {
                alt47=127;
                }
                break;
            case 277:
                {
                alt47=128;
                }
                break;
            case 278:
                {
                alt47=129;
                }
                break;
            case 279:
                {
                alt47=130;
                }
                break;
            case 280:
                {
                alt47=131;
                }
                break;
            case 281:
                {
                alt47=132;
                }
                break;
            case 282:
                {
                alt47=133;
                }
                break;
            case 283:
                {
                alt47=134;
                }
                break;
            case 284:
                {
                alt47=135;
                }
                break;
            case 285:
                {
                alt47=136;
                }
                break;
            case 286:
                {
                alt47=137;
                }
                break;
            case 287:
                {
                alt47=138;
                }
                break;
            case 288:
                {
                alt47=139;
                }
                break;
            case 289:
                {
                alt47=140;
                }
                break;
            case 290:
                {
                alt47=141;
                }
                break;
            case 291:
                {
                alt47=142;
                }
                break;
            case 292:
                {
                alt47=143;
                }
                break;
            case 293:
                {
                alt47=144;
                }
                break;
            case 294:
                {
                alt47=145;
                }
                break;
            case 295:
                {
                alt47=146;
                }
                break;
            case 296:
                {
                alt47=147;
                }
                break;
            case 297:
                {
                alt47=148;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 47, 0, input);

                throw nvae;
            }

            switch (alt47) {
                case 1 :
                    // PsiInternalLatteCSS.g:3060:3: kw= 'aliceblue'
                    {

                    			markLeaf(elementTypeProvider.getNamedColor_AliceblueKeyword_0ElementType());
                    		
                    kw=(Token)match(input,150,FOLLOW_2); 

                    			doneLeaf(kw);
                    		

                    }
                    break;
                case 2 :
                    // PsiInternalLatteCSS.g:3068:3: kw= 'antiquewhite'
                    {

                    			markLeaf(elementTypeProvider.getNamedColor_AntiquewhiteKeyword_1ElementType());
                    		
                    kw=(Token)match(input,151,FOLLOW_2); 

                    			doneLeaf(kw);
                    		

                    }
                    break;
                case 3 :
                    // PsiInternalLatteCSS.g:3076:3: kw= 'aqua'
                    {

                    			markLeaf(elementTypeProvider.getNamedColor_AquaKeyword_2ElementType());
                    		
                    kw=(Token)match(input,152,FOLLOW_2); 

                    			doneLeaf(kw);
                    		

                    }
                    break;
                case 4 :
                    // PsiInternalLatteCSS.g:3084:3: kw= 'aquamarine'
                    {

                    			markLeaf(elementTypeProvider.getNamedColor_AquamarineKeyword_3ElementType());
                    		
                    kw=(Token)match(input,153,FOLLOW_2); 

                    			doneLeaf(kw);
                    		

                    }
                    break;
                case 5 :
                    // PsiInternalLatteCSS.g:3092:3: kw= 'azure'
                    {

                    			markLeaf(elementTypeProvider.getNamedColor_AzureKeyword_4ElementType());
                    		
                    kw=(Token)match(input,154,FOLLOW_2); 

                    			doneLeaf(kw);
                    		

                    }
                    break;
                case 6 :
                    // PsiInternalLatteCSS.g:3100:3: kw= 'beige'
                    {

                    			markLeaf(elementTypeProvider.getNamedColor_BeigeKeyword_5ElementType());
                    		
                    kw=(Token)match(input,155,FOLLOW_2); 

                    			doneLeaf(kw);
                    		

                    }
                    break;
                case 7 :
                    // PsiInternalLatteCSS.g:3108:3: kw= 'bisque'
                    {

                    			markLeaf(elementTypeProvider.getNamedColor_BisqueKeyword_6ElementType());
                    		
                    kw=(Token)match(input,156,FOLLOW_2); 

                    			doneLeaf(kw);
                    		

                    }
                    break;
                case 8 :
                    // PsiInternalLatteCSS.g:3116:3: kw= 'black'
                    {

                    			markLeaf(elementTypeProvider.getNamedColor_BlackKeyword_7ElementType());
                    		
                    kw=(Token)match(input,157,FOLLOW_2); 

                    			doneLeaf(kw);
                    		

                    }
                    break;
                case 9 :
                    // PsiInternalLatteCSS.g:3124:3: kw= 'blanchedalmond'
                    {

                    			markLeaf(elementTypeProvider.getNamedColor_BlanchedalmondKeyword_8ElementType());
                    		
                    kw=(Token)match(input,158,FOLLOW_2); 

                    			doneLeaf(kw);
                    		

                    }
                    break;
                case 10 :
                    // PsiInternalLatteCSS.g:3132:3: kw= 'blue'
                    {

                    			markLeaf(elementTypeProvider.getNamedColor_BlueKeyword_9ElementType());
                    		
                    kw=(Token)match(input,159,FOLLOW_2); 

                    			doneLeaf(kw);
                    		

                    }
                    break;
                case 11 :
                    // PsiInternalLatteCSS.g:3140:3: kw= 'blueviolet'
                    {

                    			markLeaf(elementTypeProvider.getNamedColor_BluevioletKeyword_10ElementType());
                    		
                    kw=(Token)match(input,160,FOLLOW_2); 

                    			doneLeaf(kw);
                    		

                    }
                    break;
                case 12 :
                    // PsiInternalLatteCSS.g:3148:3: kw= 'brown'
                    {

                    			markLeaf(elementTypeProvider.getNamedColor_BrownKeyword_11ElementType());
                    		
                    kw=(Token)match(input,161,FOLLOW_2); 

                    			doneLeaf(kw);
                    		

                    }
                    break;
                case 13 :
                    // PsiInternalLatteCSS.g:3156:3: kw= 'burlywood'
                    {

                    			markLeaf(elementTypeProvider.getNamedColor_BurlywoodKeyword_12ElementType());
                    		
                    kw=(Token)match(input,162,FOLLOW_2); 

                    			doneLeaf(kw);
                    		

                    }
                    break;
                case 14 :
                    // PsiInternalLatteCSS.g:3164:3: kw= 'cadetblue'
                    {

                    			markLeaf(elementTypeProvider.getNamedColor_CadetblueKeyword_13ElementType());
                    		
                    kw=(Token)match(input,163,FOLLOW_2); 

                    			doneLeaf(kw);
                    		

                    }
                    break;
                case 15 :
                    // PsiInternalLatteCSS.g:3172:3: kw= 'chartreuse'
                    {

                    			markLeaf(elementTypeProvider.getNamedColor_ChartreuseKeyword_14ElementType());
                    		
                    kw=(Token)match(input,164,FOLLOW_2); 

                    			doneLeaf(kw);
                    		

                    }
                    break;
                case 16 :
                    // PsiInternalLatteCSS.g:3180:3: kw= 'chocolate'
                    {

                    			markLeaf(elementTypeProvider.getNamedColor_ChocolateKeyword_15ElementType());
                    		
                    kw=(Token)match(input,165,FOLLOW_2); 

                    			doneLeaf(kw);
                    		

                    }
                    break;
                case 17 :
                    // PsiInternalLatteCSS.g:3188:3: kw= 'coral'
                    {

                    			markLeaf(elementTypeProvider.getNamedColor_CoralKeyword_16ElementType());
                    		
                    kw=(Token)match(input,166,FOLLOW_2); 

                    			doneLeaf(kw);
                    		

                    }
                    break;
                case 18 :
                    // PsiInternalLatteCSS.g:3196:3: kw= 'cornflowerblue'
                    {

                    			markLeaf(elementTypeProvider.getNamedColor_CornflowerblueKeyword_17ElementType());
                    		
                    kw=(Token)match(input,167,FOLLOW_2); 

                    			doneLeaf(kw);
                    		

                    }
                    break;
                case 19 :
                    // PsiInternalLatteCSS.g:3204:3: kw= 'cornsilk'
                    {

                    			markLeaf(elementTypeProvider.getNamedColor_CornsilkKeyword_18ElementType());
                    		
                    kw=(Token)match(input,168,FOLLOW_2); 

                    			doneLeaf(kw);
                    		

                    }
                    break;
                case 20 :
                    // PsiInternalLatteCSS.g:3212:3: kw= 'crimson'
                    {

                    			markLeaf(elementTypeProvider.getNamedColor_CrimsonKeyword_19ElementType());
                    		
                    kw=(Token)match(input,169,FOLLOW_2); 

                    			doneLeaf(kw);
                    		

                    }
                    break;
                case 21 :
                    // PsiInternalLatteCSS.g:3220:3: kw= 'cyan'
                    {

                    			markLeaf(elementTypeProvider.getNamedColor_CyanKeyword_20ElementType());
                    		
                    kw=(Token)match(input,170,FOLLOW_2); 

                    			doneLeaf(kw);
                    		

                    }
                    break;
                case 22 :
                    // PsiInternalLatteCSS.g:3228:3: kw= 'darkblue'
                    {

                    			markLeaf(elementTypeProvider.getNamedColor_DarkblueKeyword_21ElementType());
                    		
                    kw=(Token)match(input,171,FOLLOW_2); 

                    			doneLeaf(kw);
                    		

                    }
                    break;
                case 23 :
                    // PsiInternalLatteCSS.g:3236:3: kw= 'darkcyan'
                    {

                    			markLeaf(elementTypeProvider.getNamedColor_DarkcyanKeyword_22ElementType());
                    		
                    kw=(Token)match(input,172,FOLLOW_2); 

                    			doneLeaf(kw);
                    		

                    }
                    break;
                case 24 :
                    // PsiInternalLatteCSS.g:3244:3: kw= 'darkgoldenrod'
                    {

                    			markLeaf(elementTypeProvider.getNamedColor_DarkgoldenrodKeyword_23ElementType());
                    		
                    kw=(Token)match(input,173,FOLLOW_2); 

                    			doneLeaf(kw);
                    		

                    }
                    break;
                case 25 :
                    // PsiInternalLatteCSS.g:3252:3: kw= 'darkgray'
                    {

                    			markLeaf(elementTypeProvider.getNamedColor_DarkgrayKeyword_24ElementType());
                    		
                    kw=(Token)match(input,174,FOLLOW_2); 

                    			doneLeaf(kw);
                    		

                    }
                    break;
                case 26 :
                    // PsiInternalLatteCSS.g:3260:3: kw= 'darkgreen'
                    {

                    			markLeaf(elementTypeProvider.getNamedColor_DarkgreenKeyword_25ElementType());
                    		
                    kw=(Token)match(input,175,FOLLOW_2); 

                    			doneLeaf(kw);
                    		

                    }
                    break;
                case 27 :
                    // PsiInternalLatteCSS.g:3268:3: kw= 'darkgrey'
                    {

                    			markLeaf(elementTypeProvider.getNamedColor_DarkgreyKeyword_26ElementType());
                    		
                    kw=(Token)match(input,176,FOLLOW_2); 

                    			doneLeaf(kw);
                    		

                    }
                    break;
                case 28 :
                    // PsiInternalLatteCSS.g:3276:3: kw= 'darkkhaki'
                    {

                    			markLeaf(elementTypeProvider.getNamedColor_DarkkhakiKeyword_27ElementType());
                    		
                    kw=(Token)match(input,177,FOLLOW_2); 

                    			doneLeaf(kw);
                    		

                    }
                    break;
                case 29 :
                    // PsiInternalLatteCSS.g:3284:3: kw= 'darkmagenta'
                    {

                    			markLeaf(elementTypeProvider.getNamedColor_DarkmagentaKeyword_28ElementType());
                    		
                    kw=(Token)match(input,178,FOLLOW_2); 

                    			doneLeaf(kw);
                    		

                    }
                    break;
                case 30 :
                    // PsiInternalLatteCSS.g:3292:3: kw= 'darkolivegreen'
                    {

                    			markLeaf(elementTypeProvider.getNamedColor_DarkolivegreenKeyword_29ElementType());
                    		
                    kw=(Token)match(input,179,FOLLOW_2); 

                    			doneLeaf(kw);
                    		

                    }
                    break;
                case 31 :
                    // PsiInternalLatteCSS.g:3300:3: kw= 'darkorange'
                    {

                    			markLeaf(elementTypeProvider.getNamedColor_DarkorangeKeyword_30ElementType());
                    		
                    kw=(Token)match(input,180,FOLLOW_2); 

                    			doneLeaf(kw);
                    		

                    }
                    break;
                case 32 :
                    // PsiInternalLatteCSS.g:3308:3: kw= 'darkorchid'
                    {

                    			markLeaf(elementTypeProvider.getNamedColor_DarkorchidKeyword_31ElementType());
                    		
                    kw=(Token)match(input,181,FOLLOW_2); 

                    			doneLeaf(kw);
                    		

                    }
                    break;
                case 33 :
                    // PsiInternalLatteCSS.g:3316:3: kw= 'darkred'
                    {

                    			markLeaf(elementTypeProvider.getNamedColor_DarkredKeyword_32ElementType());
                    		
                    kw=(Token)match(input,182,FOLLOW_2); 

                    			doneLeaf(kw);
                    		

                    }
                    break;
                case 34 :
                    // PsiInternalLatteCSS.g:3324:3: kw= 'darksalmon'
                    {

                    			markLeaf(elementTypeProvider.getNamedColor_DarksalmonKeyword_33ElementType());
                    		
                    kw=(Token)match(input,183,FOLLOW_2); 

                    			doneLeaf(kw);
                    		

                    }
                    break;
                case 35 :
                    // PsiInternalLatteCSS.g:3332:3: kw= 'darkseagreen'
                    {

                    			markLeaf(elementTypeProvider.getNamedColor_DarkseagreenKeyword_34ElementType());
                    		
                    kw=(Token)match(input,184,FOLLOW_2); 

                    			doneLeaf(kw);
                    		

                    }
                    break;
                case 36 :
                    // PsiInternalLatteCSS.g:3340:3: kw= 'darkslateblue'
                    {

                    			markLeaf(elementTypeProvider.getNamedColor_DarkslateblueKeyword_35ElementType());
                    		
                    kw=(Token)match(input,185,FOLLOW_2); 

                    			doneLeaf(kw);
                    		

                    }
                    break;
                case 37 :
                    // PsiInternalLatteCSS.g:3348:3: kw= 'darkslategray'
                    {

                    			markLeaf(elementTypeProvider.getNamedColor_DarkslategrayKeyword_36ElementType());
                    		
                    kw=(Token)match(input,186,FOLLOW_2); 

                    			doneLeaf(kw);
                    		

                    }
                    break;
                case 38 :
                    // PsiInternalLatteCSS.g:3356:3: kw= 'darkslategrey'
                    {

                    			markLeaf(elementTypeProvider.getNamedColor_DarkslategreyKeyword_37ElementType());
                    		
                    kw=(Token)match(input,187,FOLLOW_2); 

                    			doneLeaf(kw);
                    		

                    }
                    break;
                case 39 :
                    // PsiInternalLatteCSS.g:3364:3: kw= 'darkturquoise'
                    {

                    			markLeaf(elementTypeProvider.getNamedColor_DarkturquoiseKeyword_38ElementType());
                    		
                    kw=(Token)match(input,188,FOLLOW_2); 

                    			doneLeaf(kw);
                    		

                    }
                    break;
                case 40 :
                    // PsiInternalLatteCSS.g:3372:3: kw= 'darkviolet'
                    {

                    			markLeaf(elementTypeProvider.getNamedColor_DarkvioletKeyword_39ElementType());
                    		
                    kw=(Token)match(input,189,FOLLOW_2); 

                    			doneLeaf(kw);
                    		

                    }
                    break;
                case 41 :
                    // PsiInternalLatteCSS.g:3380:3: kw= 'deeppink'
                    {

                    			markLeaf(elementTypeProvider.getNamedColor_DeeppinkKeyword_40ElementType());
                    		
                    kw=(Token)match(input,190,FOLLOW_2); 

                    			doneLeaf(kw);
                    		

                    }
                    break;
                case 42 :
                    // PsiInternalLatteCSS.g:3388:3: kw= 'deepskyblue'
                    {

                    			markLeaf(elementTypeProvider.getNamedColor_DeepskyblueKeyword_41ElementType());
                    		
                    kw=(Token)match(input,191,FOLLOW_2); 

                    			doneLeaf(kw);
                    		

                    }
                    break;
                case 43 :
                    // PsiInternalLatteCSS.g:3396:3: kw= 'dimgray'
                    {

                    			markLeaf(elementTypeProvider.getNamedColor_DimgrayKeyword_42ElementType());
                    		
                    kw=(Token)match(input,192,FOLLOW_2); 

                    			doneLeaf(kw);
                    		

                    }
                    break;
                case 44 :
                    // PsiInternalLatteCSS.g:3404:3: kw= 'dimgrey'
                    {

                    			markLeaf(elementTypeProvider.getNamedColor_DimgreyKeyword_43ElementType());
                    		
                    kw=(Token)match(input,193,FOLLOW_2); 

                    			doneLeaf(kw);
                    		

                    }
                    break;
                case 45 :
                    // PsiInternalLatteCSS.g:3412:3: kw= 'dodgerblue'
                    {

                    			markLeaf(elementTypeProvider.getNamedColor_DodgerblueKeyword_44ElementType());
                    		
                    kw=(Token)match(input,194,FOLLOW_2); 

                    			doneLeaf(kw);
                    		

                    }
                    break;
                case 46 :
                    // PsiInternalLatteCSS.g:3420:3: kw= 'firebrick'
                    {

                    			markLeaf(elementTypeProvider.getNamedColor_FirebrickKeyword_45ElementType());
                    		
                    kw=(Token)match(input,195,FOLLOW_2); 

                    			doneLeaf(kw);
                    		

                    }
                    break;
                case 47 :
                    // PsiInternalLatteCSS.g:3428:3: kw= 'floralwhite'
                    {

                    			markLeaf(elementTypeProvider.getNamedColor_FloralwhiteKeyword_46ElementType());
                    		
                    kw=(Token)match(input,196,FOLLOW_2); 

                    			doneLeaf(kw);
                    		

                    }
                    break;
                case 48 :
                    // PsiInternalLatteCSS.g:3436:3: kw= 'forestgreen'
                    {

                    			markLeaf(elementTypeProvider.getNamedColor_ForestgreenKeyword_47ElementType());
                    		
                    kw=(Token)match(input,197,FOLLOW_2); 

                    			doneLeaf(kw);
                    		

                    }
                    break;
                case 49 :
                    // PsiInternalLatteCSS.g:3444:3: kw= 'fuchsia'
                    {

                    			markLeaf(elementTypeProvider.getNamedColor_FuchsiaKeyword_48ElementType());
                    		
                    kw=(Token)match(input,198,FOLLOW_2); 

                    			doneLeaf(kw);
                    		

                    }
                    break;
                case 50 :
                    // PsiInternalLatteCSS.g:3452:3: kw= 'gainsboro'
                    {

                    			markLeaf(elementTypeProvider.getNamedColor_GainsboroKeyword_49ElementType());
                    		
                    kw=(Token)match(input,199,FOLLOW_2); 

                    			doneLeaf(kw);
                    		

                    }
                    break;
                case 51 :
                    // PsiInternalLatteCSS.g:3460:3: kw= 'ghostwhite'
                    {

                    			markLeaf(elementTypeProvider.getNamedColor_GhostwhiteKeyword_50ElementType());
                    		
                    kw=(Token)match(input,200,FOLLOW_2); 

                    			doneLeaf(kw);
                    		

                    }
                    break;
                case 52 :
                    // PsiInternalLatteCSS.g:3468:3: kw= 'gold'
                    {

                    			markLeaf(elementTypeProvider.getNamedColor_GoldKeyword_51ElementType());
                    		
                    kw=(Token)match(input,201,FOLLOW_2); 

                    			doneLeaf(kw);
                    		

                    }
                    break;
                case 53 :
                    // PsiInternalLatteCSS.g:3476:3: kw= 'goldenrod'
                    {

                    			markLeaf(elementTypeProvider.getNamedColor_GoldenrodKeyword_52ElementType());
                    		
                    kw=(Token)match(input,202,FOLLOW_2); 

                    			doneLeaf(kw);
                    		

                    }
                    break;
                case 54 :
                    // PsiInternalLatteCSS.g:3484:3: kw= 'gray'
                    {

                    			markLeaf(elementTypeProvider.getNamedColor_GrayKeyword_53ElementType());
                    		
                    kw=(Token)match(input,203,FOLLOW_2); 

                    			doneLeaf(kw);
                    		

                    }
                    break;
                case 55 :
                    // PsiInternalLatteCSS.g:3492:3: kw= 'green'
                    {

                    			markLeaf(elementTypeProvider.getNamedColor_GreenKeyword_54ElementType());
                    		
                    kw=(Token)match(input,204,FOLLOW_2); 

                    			doneLeaf(kw);
                    		

                    }
                    break;
                case 56 :
                    // PsiInternalLatteCSS.g:3500:3: kw= 'greenyellow'
                    {

                    			markLeaf(elementTypeProvider.getNamedColor_GreenyellowKeyword_55ElementType());
                    		
                    kw=(Token)match(input,205,FOLLOW_2); 

                    			doneLeaf(kw);
                    		

                    }
                    break;
                case 57 :
                    // PsiInternalLatteCSS.g:3508:3: kw= 'grey'
                    {

                    			markLeaf(elementTypeProvider.getNamedColor_GreyKeyword_56ElementType());
                    		
                    kw=(Token)match(input,206,FOLLOW_2); 

                    			doneLeaf(kw);
                    		

                    }
                    break;
                case 58 :
                    // PsiInternalLatteCSS.g:3516:3: kw= 'honeydew'
                    {

                    			markLeaf(elementTypeProvider.getNamedColor_HoneydewKeyword_57ElementType());
                    		
                    kw=(Token)match(input,207,FOLLOW_2); 

                    			doneLeaf(kw);
                    		

                    }
                    break;
                case 59 :
                    // PsiInternalLatteCSS.g:3524:3: kw= 'hotpink'
                    {

                    			markLeaf(elementTypeProvider.getNamedColor_HotpinkKeyword_58ElementType());
                    		
                    kw=(Token)match(input,208,FOLLOW_2); 

                    			doneLeaf(kw);
                    		

                    }
                    break;
                case 60 :
                    // PsiInternalLatteCSS.g:3532:3: kw= 'indianred'
                    {

                    			markLeaf(elementTypeProvider.getNamedColor_IndianredKeyword_59ElementType());
                    		
                    kw=(Token)match(input,209,FOLLOW_2); 

                    			doneLeaf(kw);
                    		

                    }
                    break;
                case 61 :
                    // PsiInternalLatteCSS.g:3540:3: kw= 'indigo'
                    {

                    			markLeaf(elementTypeProvider.getNamedColor_IndigoKeyword_60ElementType());
                    		
                    kw=(Token)match(input,210,FOLLOW_2); 

                    			doneLeaf(kw);
                    		

                    }
                    break;
                case 62 :
                    // PsiInternalLatteCSS.g:3548:3: kw= 'ivory'
                    {

                    			markLeaf(elementTypeProvider.getNamedColor_IvoryKeyword_61ElementType());
                    		
                    kw=(Token)match(input,211,FOLLOW_2); 

                    			doneLeaf(kw);
                    		

                    }
                    break;
                case 63 :
                    // PsiInternalLatteCSS.g:3556:3: kw= 'khaki'
                    {

                    			markLeaf(elementTypeProvider.getNamedColor_KhakiKeyword_62ElementType());
                    		
                    kw=(Token)match(input,212,FOLLOW_2); 

                    			doneLeaf(kw);
                    		

                    }
                    break;
                case 64 :
                    // PsiInternalLatteCSS.g:3564:3: kw= 'lavender'
                    {

                    			markLeaf(elementTypeProvider.getNamedColor_LavenderKeyword_63ElementType());
                    		
                    kw=(Token)match(input,213,FOLLOW_2); 

                    			doneLeaf(kw);
                    		

                    }
                    break;
                case 65 :
                    // PsiInternalLatteCSS.g:3572:3: kw= 'lavenderblush'
                    {

                    			markLeaf(elementTypeProvider.getNamedColor_LavenderblushKeyword_64ElementType());
                    		
                    kw=(Token)match(input,214,FOLLOW_2); 

                    			doneLeaf(kw);
                    		

                    }
                    break;
                case 66 :
                    // PsiInternalLatteCSS.g:3580:3: kw= 'lawngreen'
                    {

                    			markLeaf(elementTypeProvider.getNamedColor_LawngreenKeyword_65ElementType());
                    		
                    kw=(Token)match(input,215,FOLLOW_2); 

                    			doneLeaf(kw);
                    		

                    }
                    break;
                case 67 :
                    // PsiInternalLatteCSS.g:3588:3: kw= 'lemonchiffon'
                    {

                    			markLeaf(elementTypeProvider.getNamedColor_LemonchiffonKeyword_66ElementType());
                    		
                    kw=(Token)match(input,216,FOLLOW_2); 

                    			doneLeaf(kw);
                    		

                    }
                    break;
                case 68 :
                    // PsiInternalLatteCSS.g:3596:3: kw= 'lightblue'
                    {

                    			markLeaf(elementTypeProvider.getNamedColor_LightblueKeyword_67ElementType());
                    		
                    kw=(Token)match(input,217,FOLLOW_2); 

                    			doneLeaf(kw);
                    		

                    }
                    break;
                case 69 :
                    // PsiInternalLatteCSS.g:3604:3: kw= 'lightcoral'
                    {

                    			markLeaf(elementTypeProvider.getNamedColor_LightcoralKeyword_68ElementType());
                    		
                    kw=(Token)match(input,218,FOLLOW_2); 

                    			doneLeaf(kw);
                    		

                    }
                    break;
                case 70 :
                    // PsiInternalLatteCSS.g:3612:3: kw= 'lightcyan'
                    {

                    			markLeaf(elementTypeProvider.getNamedColor_LightcyanKeyword_69ElementType());
                    		
                    kw=(Token)match(input,219,FOLLOW_2); 

                    			doneLeaf(kw);
                    		

                    }
                    break;
                case 71 :
                    // PsiInternalLatteCSS.g:3620:3: kw= 'lightgoldenrodyellow'
                    {

                    			markLeaf(elementTypeProvider.getNamedColor_LightgoldenrodyellowKeyword_70ElementType());
                    		
                    kw=(Token)match(input,220,FOLLOW_2); 

                    			doneLeaf(kw);
                    		

                    }
                    break;
                case 72 :
                    // PsiInternalLatteCSS.g:3628:3: kw= 'lightgray'
                    {

                    			markLeaf(elementTypeProvider.getNamedColor_LightgrayKeyword_71ElementType());
                    		
                    kw=(Token)match(input,221,FOLLOW_2); 

                    			doneLeaf(kw);
                    		

                    }
                    break;
                case 73 :
                    // PsiInternalLatteCSS.g:3636:3: kw= 'lightgreen'
                    {

                    			markLeaf(elementTypeProvider.getNamedColor_LightgreenKeyword_72ElementType());
                    		
                    kw=(Token)match(input,222,FOLLOW_2); 

                    			doneLeaf(kw);
                    		

                    }
                    break;
                case 74 :
                    // PsiInternalLatteCSS.g:3644:3: kw= 'lightgrey'
                    {

                    			markLeaf(elementTypeProvider.getNamedColor_LightgreyKeyword_73ElementType());
                    		
                    kw=(Token)match(input,223,FOLLOW_2); 

                    			doneLeaf(kw);
                    		

                    }
                    break;
                case 75 :
                    // PsiInternalLatteCSS.g:3652:3: kw= 'lightpink'
                    {

                    			markLeaf(elementTypeProvider.getNamedColor_LightpinkKeyword_74ElementType());
                    		
                    kw=(Token)match(input,224,FOLLOW_2); 

                    			doneLeaf(kw);
                    		

                    }
                    break;
                case 76 :
                    // PsiInternalLatteCSS.g:3660:3: kw= 'lightsalmon'
                    {

                    			markLeaf(elementTypeProvider.getNamedColor_LightsalmonKeyword_75ElementType());
                    		
                    kw=(Token)match(input,225,FOLLOW_2); 

                    			doneLeaf(kw);
                    		

                    }
                    break;
                case 77 :
                    // PsiInternalLatteCSS.g:3668:3: kw= 'lightseagreen'
                    {

                    			markLeaf(elementTypeProvider.getNamedColor_LightseagreenKeyword_76ElementType());
                    		
                    kw=(Token)match(input,226,FOLLOW_2); 

                    			doneLeaf(kw);
                    		

                    }
                    break;
                case 78 :
                    // PsiInternalLatteCSS.g:3676:3: kw= 'lightskyblue'
                    {

                    			markLeaf(elementTypeProvider.getNamedColor_LightskyblueKeyword_77ElementType());
                    		
                    kw=(Token)match(input,227,FOLLOW_2); 

                    			doneLeaf(kw);
                    		

                    }
                    break;
                case 79 :
                    // PsiInternalLatteCSS.g:3684:3: kw= 'lightslategray'
                    {

                    			markLeaf(elementTypeProvider.getNamedColor_LightslategrayKeyword_78ElementType());
                    		
                    kw=(Token)match(input,228,FOLLOW_2); 

                    			doneLeaf(kw);
                    		

                    }
                    break;
                case 80 :
                    // PsiInternalLatteCSS.g:3692:3: kw= 'lightslategrey'
                    {

                    			markLeaf(elementTypeProvider.getNamedColor_LightslategreyKeyword_79ElementType());
                    		
                    kw=(Token)match(input,229,FOLLOW_2); 

                    			doneLeaf(kw);
                    		

                    }
                    break;
                case 81 :
                    // PsiInternalLatteCSS.g:3700:3: kw= 'lightsteelblue'
                    {

                    			markLeaf(elementTypeProvider.getNamedColor_LightsteelblueKeyword_80ElementType());
                    		
                    kw=(Token)match(input,230,FOLLOW_2); 

                    			doneLeaf(kw);
                    		

                    }
                    break;
                case 82 :
                    // PsiInternalLatteCSS.g:3708:3: kw= 'lightyellow'
                    {

                    			markLeaf(elementTypeProvider.getNamedColor_LightyellowKeyword_81ElementType());
                    		
                    kw=(Token)match(input,231,FOLLOW_2); 

                    			doneLeaf(kw);
                    		

                    }
                    break;
                case 83 :
                    // PsiInternalLatteCSS.g:3716:3: kw= 'lime'
                    {

                    			markLeaf(elementTypeProvider.getNamedColor_LimeKeyword_82ElementType());
                    		
                    kw=(Token)match(input,232,FOLLOW_2); 

                    			doneLeaf(kw);
                    		

                    }
                    break;
                case 84 :
                    // PsiInternalLatteCSS.g:3724:3: kw= 'limegreen'
                    {

                    			markLeaf(elementTypeProvider.getNamedColor_LimegreenKeyword_83ElementType());
                    		
                    kw=(Token)match(input,233,FOLLOW_2); 

                    			doneLeaf(kw);
                    		

                    }
                    break;
                case 85 :
                    // PsiInternalLatteCSS.g:3732:3: kw= 'linen'
                    {

                    			markLeaf(elementTypeProvider.getNamedColor_LinenKeyword_84ElementType());
                    		
                    kw=(Token)match(input,234,FOLLOW_2); 

                    			doneLeaf(kw);
                    		

                    }
                    break;
                case 86 :
                    // PsiInternalLatteCSS.g:3740:3: kw= 'magenta'
                    {

                    			markLeaf(elementTypeProvider.getNamedColor_MagentaKeyword_85ElementType());
                    		
                    kw=(Token)match(input,235,FOLLOW_2); 

                    			doneLeaf(kw);
                    		

                    }
                    break;
                case 87 :
                    // PsiInternalLatteCSS.g:3748:3: kw= 'maroon'
                    {

                    			markLeaf(elementTypeProvider.getNamedColor_MaroonKeyword_86ElementType());
                    		
                    kw=(Token)match(input,236,FOLLOW_2); 

                    			doneLeaf(kw);
                    		

                    }
                    break;
                case 88 :
                    // PsiInternalLatteCSS.g:3756:3: kw= 'mediumaquamarine'
                    {

                    			markLeaf(elementTypeProvider.getNamedColor_MediumaquamarineKeyword_87ElementType());
                    		
                    kw=(Token)match(input,237,FOLLOW_2); 

                    			doneLeaf(kw);
                    		

                    }
                    break;
                case 89 :
                    // PsiInternalLatteCSS.g:3764:3: kw= 'mediumblue'
                    {

                    			markLeaf(elementTypeProvider.getNamedColor_MediumblueKeyword_88ElementType());
                    		
                    kw=(Token)match(input,238,FOLLOW_2); 

                    			doneLeaf(kw);
                    		

                    }
                    break;
                case 90 :
                    // PsiInternalLatteCSS.g:3772:3: kw= 'mediumorchid'
                    {

                    			markLeaf(elementTypeProvider.getNamedColor_MediumorchidKeyword_89ElementType());
                    		
                    kw=(Token)match(input,239,FOLLOW_2); 

                    			doneLeaf(kw);
                    		

                    }
                    break;
                case 91 :
                    // PsiInternalLatteCSS.g:3780:3: kw= 'mediumpurple'
                    {

                    			markLeaf(elementTypeProvider.getNamedColor_MediumpurpleKeyword_90ElementType());
                    		
                    kw=(Token)match(input,240,FOLLOW_2); 

                    			doneLeaf(kw);
                    		

                    }
                    break;
                case 92 :
                    // PsiInternalLatteCSS.g:3788:3: kw= 'mediumseagreen'
                    {

                    			markLeaf(elementTypeProvider.getNamedColor_MediumseagreenKeyword_91ElementType());
                    		
                    kw=(Token)match(input,241,FOLLOW_2); 

                    			doneLeaf(kw);
                    		

                    }
                    break;
                case 93 :
                    // PsiInternalLatteCSS.g:3796:3: kw= 'mediumslateblue'
                    {

                    			markLeaf(elementTypeProvider.getNamedColor_MediumslateblueKeyword_92ElementType());
                    		
                    kw=(Token)match(input,242,FOLLOW_2); 

                    			doneLeaf(kw);
                    		

                    }
                    break;
                case 94 :
                    // PsiInternalLatteCSS.g:3804:3: kw= 'mediumspringgreen'
                    {

                    			markLeaf(elementTypeProvider.getNamedColor_MediumspringgreenKeyword_93ElementType());
                    		
                    kw=(Token)match(input,243,FOLLOW_2); 

                    			doneLeaf(kw);
                    		

                    }
                    break;
                case 95 :
                    // PsiInternalLatteCSS.g:3812:3: kw= 'mediumturquoise'
                    {

                    			markLeaf(elementTypeProvider.getNamedColor_MediumturquoiseKeyword_94ElementType());
                    		
                    kw=(Token)match(input,244,FOLLOW_2); 

                    			doneLeaf(kw);
                    		

                    }
                    break;
                case 96 :
                    // PsiInternalLatteCSS.g:3820:3: kw= 'mediumvioletred'
                    {

                    			markLeaf(elementTypeProvider.getNamedColor_MediumvioletredKeyword_95ElementType());
                    		
                    kw=(Token)match(input,245,FOLLOW_2); 

                    			doneLeaf(kw);
                    		

                    }
                    break;
                case 97 :
                    // PsiInternalLatteCSS.g:3828:3: kw= 'midnightblue'
                    {

                    			markLeaf(elementTypeProvider.getNamedColor_MidnightblueKeyword_96ElementType());
                    		
                    kw=(Token)match(input,246,FOLLOW_2); 

                    			doneLeaf(kw);
                    		

                    }
                    break;
                case 98 :
                    // PsiInternalLatteCSS.g:3836:3: kw= 'mintcream'
                    {

                    			markLeaf(elementTypeProvider.getNamedColor_MintcreamKeyword_97ElementType());
                    		
                    kw=(Token)match(input,247,FOLLOW_2); 

                    			doneLeaf(kw);
                    		

                    }
                    break;
                case 99 :
                    // PsiInternalLatteCSS.g:3844:3: kw= 'mistyrose'
                    {

                    			markLeaf(elementTypeProvider.getNamedColor_MistyroseKeyword_98ElementType());
                    		
                    kw=(Token)match(input,248,FOLLOW_2); 

                    			doneLeaf(kw);
                    		

                    }
                    break;
                case 100 :
                    // PsiInternalLatteCSS.g:3852:3: kw= 'moccasin'
                    {

                    			markLeaf(elementTypeProvider.getNamedColor_MoccasinKeyword_99ElementType());
                    		
                    kw=(Token)match(input,249,FOLLOW_2); 

                    			doneLeaf(kw);
                    		

                    }
                    break;
                case 101 :
                    // PsiInternalLatteCSS.g:3860:3: kw= 'navajowhite'
                    {

                    			markLeaf(elementTypeProvider.getNamedColor_NavajowhiteKeyword_100ElementType());
                    		
                    kw=(Token)match(input,250,FOLLOW_2); 

                    			doneLeaf(kw);
                    		

                    }
                    break;
                case 102 :
                    // PsiInternalLatteCSS.g:3868:3: kw= 'navy'
                    {

                    			markLeaf(elementTypeProvider.getNamedColor_NavyKeyword_101ElementType());
                    		
                    kw=(Token)match(input,251,FOLLOW_2); 

                    			doneLeaf(kw);
                    		

                    }
                    break;
                case 103 :
                    // PsiInternalLatteCSS.g:3876:3: kw= 'oldlace'
                    {

                    			markLeaf(elementTypeProvider.getNamedColor_OldlaceKeyword_102ElementType());
                    		
                    kw=(Token)match(input,252,FOLLOW_2); 

                    			doneLeaf(kw);
                    		

                    }
                    break;
                case 104 :
                    // PsiInternalLatteCSS.g:3884:3: kw= 'olive'
                    {

                    			markLeaf(elementTypeProvider.getNamedColor_OliveKeyword_103ElementType());
                    		
                    kw=(Token)match(input,253,FOLLOW_2); 

                    			doneLeaf(kw);
                    		

                    }
                    break;
                case 105 :
                    // PsiInternalLatteCSS.g:3892:3: kw= 'olivedrab'
                    {

                    			markLeaf(elementTypeProvider.getNamedColor_OlivedrabKeyword_104ElementType());
                    		
                    kw=(Token)match(input,254,FOLLOW_2); 

                    			doneLeaf(kw);
                    		

                    }
                    break;
                case 106 :
                    // PsiInternalLatteCSS.g:3900:3: kw= 'orange'
                    {

                    			markLeaf(elementTypeProvider.getNamedColor_OrangeKeyword_105ElementType());
                    		
                    kw=(Token)match(input,255,FOLLOW_2); 

                    			doneLeaf(kw);
                    		

                    }
                    break;
                case 107 :
                    // PsiInternalLatteCSS.g:3908:3: kw= 'orangered'
                    {

                    			markLeaf(elementTypeProvider.getNamedColor_OrangeredKeyword_106ElementType());
                    		
                    kw=(Token)match(input,256,FOLLOW_2); 

                    			doneLeaf(kw);
                    		

                    }
                    break;
                case 108 :
                    // PsiInternalLatteCSS.g:3916:3: kw= 'orchid'
                    {

                    			markLeaf(elementTypeProvider.getNamedColor_OrchidKeyword_107ElementType());
                    		
                    kw=(Token)match(input,257,FOLLOW_2); 

                    			doneLeaf(kw);
                    		

                    }
                    break;
                case 109 :
                    // PsiInternalLatteCSS.g:3924:3: kw= 'palegoldenrod'
                    {

                    			markLeaf(elementTypeProvider.getNamedColor_PalegoldenrodKeyword_108ElementType());
                    		
                    kw=(Token)match(input,258,FOLLOW_2); 

                    			doneLeaf(kw);
                    		

                    }
                    break;
                case 110 :
                    // PsiInternalLatteCSS.g:3932:3: kw= 'palegreen'
                    {

                    			markLeaf(elementTypeProvider.getNamedColor_PalegreenKeyword_109ElementType());
                    		
                    kw=(Token)match(input,259,FOLLOW_2); 

                    			doneLeaf(kw);
                    		

                    }
                    break;
                case 111 :
                    // PsiInternalLatteCSS.g:3940:3: kw= 'paleturquoise'
                    {

                    			markLeaf(elementTypeProvider.getNamedColor_PaleturquoiseKeyword_110ElementType());
                    		
                    kw=(Token)match(input,260,FOLLOW_2); 

                    			doneLeaf(kw);
                    		

                    }
                    break;
                case 112 :
                    // PsiInternalLatteCSS.g:3948:3: kw= 'palevioletred'
                    {

                    			markLeaf(elementTypeProvider.getNamedColor_PalevioletredKeyword_111ElementType());
                    		
                    kw=(Token)match(input,261,FOLLOW_2); 

                    			doneLeaf(kw);
                    		

                    }
                    break;
                case 113 :
                    // PsiInternalLatteCSS.g:3956:3: kw= 'papayawhip'
                    {

                    			markLeaf(elementTypeProvider.getNamedColor_PapayawhipKeyword_112ElementType());
                    		
                    kw=(Token)match(input,262,FOLLOW_2); 

                    			doneLeaf(kw);
                    		

                    }
                    break;
                case 114 :
                    // PsiInternalLatteCSS.g:3964:3: kw= 'peachpuff'
                    {

                    			markLeaf(elementTypeProvider.getNamedColor_PeachpuffKeyword_113ElementType());
                    		
                    kw=(Token)match(input,263,FOLLOW_2); 

                    			doneLeaf(kw);
                    		

                    }
                    break;
                case 115 :
                    // PsiInternalLatteCSS.g:3972:3: kw= 'peru'
                    {

                    			markLeaf(elementTypeProvider.getNamedColor_PeruKeyword_114ElementType());
                    		
                    kw=(Token)match(input,264,FOLLOW_2); 

                    			doneLeaf(kw);
                    		

                    }
                    break;
                case 116 :
                    // PsiInternalLatteCSS.g:3980:3: kw= 'pink'
                    {

                    			markLeaf(elementTypeProvider.getNamedColor_PinkKeyword_115ElementType());
                    		
                    kw=(Token)match(input,265,FOLLOW_2); 

                    			doneLeaf(kw);
                    		

                    }
                    break;
                case 117 :
                    // PsiInternalLatteCSS.g:3988:3: kw= 'plum'
                    {

                    			markLeaf(elementTypeProvider.getNamedColor_PlumKeyword_116ElementType());
                    		
                    kw=(Token)match(input,266,FOLLOW_2); 

                    			doneLeaf(kw);
                    		

                    }
                    break;
                case 118 :
                    // PsiInternalLatteCSS.g:3996:3: kw= 'powderblue'
                    {

                    			markLeaf(elementTypeProvider.getNamedColor_PowderblueKeyword_117ElementType());
                    		
                    kw=(Token)match(input,267,FOLLOW_2); 

                    			doneLeaf(kw);
                    		

                    }
                    break;
                case 119 :
                    // PsiInternalLatteCSS.g:4004:3: kw= 'purple'
                    {

                    			markLeaf(elementTypeProvider.getNamedColor_PurpleKeyword_118ElementType());
                    		
                    kw=(Token)match(input,268,FOLLOW_2); 

                    			doneLeaf(kw);
                    		

                    }
                    break;
                case 120 :
                    // PsiInternalLatteCSS.g:4012:3: kw= 'red'
                    {

                    			markLeaf(elementTypeProvider.getNamedColor_RedKeyword_119ElementType());
                    		
                    kw=(Token)match(input,269,FOLLOW_2); 

                    			doneLeaf(kw);
                    		

                    }
                    break;
                case 121 :
                    // PsiInternalLatteCSS.g:4020:3: kw= 'rosybrown'
                    {

                    			markLeaf(elementTypeProvider.getNamedColor_RosybrownKeyword_120ElementType());
                    		
                    kw=(Token)match(input,270,FOLLOW_2); 

                    			doneLeaf(kw);
                    		

                    }
                    break;
                case 122 :
                    // PsiInternalLatteCSS.g:4028:3: kw= 'royalblue'
                    {

                    			markLeaf(elementTypeProvider.getNamedColor_RoyalblueKeyword_121ElementType());
                    		
                    kw=(Token)match(input,271,FOLLOW_2); 

                    			doneLeaf(kw);
                    		

                    }
                    break;
                case 123 :
                    // PsiInternalLatteCSS.g:4036:3: kw= 'saddlebrown'
                    {

                    			markLeaf(elementTypeProvider.getNamedColor_SaddlebrownKeyword_122ElementType());
                    		
                    kw=(Token)match(input,272,FOLLOW_2); 

                    			doneLeaf(kw);
                    		

                    }
                    break;
                case 124 :
                    // PsiInternalLatteCSS.g:4044:3: kw= 'salmon'
                    {

                    			markLeaf(elementTypeProvider.getNamedColor_SalmonKeyword_123ElementType());
                    		
                    kw=(Token)match(input,273,FOLLOW_2); 

                    			doneLeaf(kw);
                    		

                    }
                    break;
                case 125 :
                    // PsiInternalLatteCSS.g:4052:3: kw= 'sandybrown'
                    {

                    			markLeaf(elementTypeProvider.getNamedColor_SandybrownKeyword_124ElementType());
                    		
                    kw=(Token)match(input,274,FOLLOW_2); 

                    			doneLeaf(kw);
                    		

                    }
                    break;
                case 126 :
                    // PsiInternalLatteCSS.g:4060:3: kw= 'seagreen'
                    {

                    			markLeaf(elementTypeProvider.getNamedColor_SeagreenKeyword_125ElementType());
                    		
                    kw=(Token)match(input,275,FOLLOW_2); 

                    			doneLeaf(kw);
                    		

                    }
                    break;
                case 127 :
                    // PsiInternalLatteCSS.g:4068:3: kw= 'seashell'
                    {

                    			markLeaf(elementTypeProvider.getNamedColor_SeashellKeyword_126ElementType());
                    		
                    kw=(Token)match(input,276,FOLLOW_2); 

                    			doneLeaf(kw);
                    		

                    }
                    break;
                case 128 :
                    // PsiInternalLatteCSS.g:4076:3: kw= 'sienna'
                    {

                    			markLeaf(elementTypeProvider.getNamedColor_SiennaKeyword_127ElementType());
                    		
                    kw=(Token)match(input,277,FOLLOW_2); 

                    			doneLeaf(kw);
                    		

                    }
                    break;
                case 129 :
                    // PsiInternalLatteCSS.g:4084:3: kw= 'silver'
                    {

                    			markLeaf(elementTypeProvider.getNamedColor_SilverKeyword_128ElementType());
                    		
                    kw=(Token)match(input,278,FOLLOW_2); 

                    			doneLeaf(kw);
                    		

                    }
                    break;
                case 130 :
                    // PsiInternalLatteCSS.g:4092:3: kw= 'skyblue'
                    {

                    			markLeaf(elementTypeProvider.getNamedColor_SkyblueKeyword_129ElementType());
                    		
                    kw=(Token)match(input,279,FOLLOW_2); 

                    			doneLeaf(kw);
                    		

                    }
                    break;
                case 131 :
                    // PsiInternalLatteCSS.g:4100:3: kw= 'slateblue'
                    {

                    			markLeaf(elementTypeProvider.getNamedColor_SlateblueKeyword_130ElementType());
                    		
                    kw=(Token)match(input,280,FOLLOW_2); 

                    			doneLeaf(kw);
                    		

                    }
                    break;
                case 132 :
                    // PsiInternalLatteCSS.g:4108:3: kw= 'slategray'
                    {

                    			markLeaf(elementTypeProvider.getNamedColor_SlategrayKeyword_131ElementType());
                    		
                    kw=(Token)match(input,281,FOLLOW_2); 

                    			doneLeaf(kw);
                    		

                    }
                    break;
                case 133 :
                    // PsiInternalLatteCSS.g:4116:3: kw= 'slategrey'
                    {

                    			markLeaf(elementTypeProvider.getNamedColor_SlategreyKeyword_132ElementType());
                    		
                    kw=(Token)match(input,282,FOLLOW_2); 

                    			doneLeaf(kw);
                    		

                    }
                    break;
                case 134 :
                    // PsiInternalLatteCSS.g:4124:3: kw= 'snow'
                    {

                    			markLeaf(elementTypeProvider.getNamedColor_SnowKeyword_133ElementType());
                    		
                    kw=(Token)match(input,283,FOLLOW_2); 

                    			doneLeaf(kw);
                    		

                    }
                    break;
                case 135 :
                    // PsiInternalLatteCSS.g:4132:3: kw= 'springgreen'
                    {

                    			markLeaf(elementTypeProvider.getNamedColor_SpringgreenKeyword_134ElementType());
                    		
                    kw=(Token)match(input,284,FOLLOW_2); 

                    			doneLeaf(kw);
                    		

                    }
                    break;
                case 136 :
                    // PsiInternalLatteCSS.g:4140:3: kw= 'steelblue'
                    {

                    			markLeaf(elementTypeProvider.getNamedColor_SteelblueKeyword_135ElementType());
                    		
                    kw=(Token)match(input,285,FOLLOW_2); 

                    			doneLeaf(kw);
                    		

                    }
                    break;
                case 137 :
                    // PsiInternalLatteCSS.g:4148:3: kw= 'tan'
                    {

                    			markLeaf(elementTypeProvider.getNamedColor_TanKeyword_136ElementType());
                    		
                    kw=(Token)match(input,286,FOLLOW_2); 

                    			doneLeaf(kw);
                    		

                    }
                    break;
                case 138 :
                    // PsiInternalLatteCSS.g:4156:3: kw= 'teal'
                    {

                    			markLeaf(elementTypeProvider.getNamedColor_TealKeyword_137ElementType());
                    		
                    kw=(Token)match(input,287,FOLLOW_2); 

                    			doneLeaf(kw);
                    		

                    }
                    break;
                case 139 :
                    // PsiInternalLatteCSS.g:4164:3: kw= 'thistle'
                    {

                    			markLeaf(elementTypeProvider.getNamedColor_ThistleKeyword_138ElementType());
                    		
                    kw=(Token)match(input,288,FOLLOW_2); 

                    			doneLeaf(kw);
                    		

                    }
                    break;
                case 140 :
                    // PsiInternalLatteCSS.g:4172:3: kw= 'tomato'
                    {

                    			markLeaf(elementTypeProvider.getNamedColor_TomatoKeyword_139ElementType());
                    		
                    kw=(Token)match(input,289,FOLLOW_2); 

                    			doneLeaf(kw);
                    		

                    }
                    break;
                case 141 :
                    // PsiInternalLatteCSS.g:4180:3: kw= 'turquoise'
                    {

                    			markLeaf(elementTypeProvider.getNamedColor_TurquoiseKeyword_140ElementType());
                    		
                    kw=(Token)match(input,290,FOLLOW_2); 

                    			doneLeaf(kw);
                    		

                    }
                    break;
                case 142 :
                    // PsiInternalLatteCSS.g:4188:3: kw= 'violet'
                    {

                    			markLeaf(elementTypeProvider.getNamedColor_VioletKeyword_141ElementType());
                    		
                    kw=(Token)match(input,291,FOLLOW_2); 

                    			doneLeaf(kw);
                    		

                    }
                    break;
                case 143 :
                    // PsiInternalLatteCSS.g:4196:3: kw= 'wheat'
                    {

                    			markLeaf(elementTypeProvider.getNamedColor_WheatKeyword_142ElementType());
                    		
                    kw=(Token)match(input,292,FOLLOW_2); 

                    			doneLeaf(kw);
                    		

                    }
                    break;
                case 144 :
                    // PsiInternalLatteCSS.g:4204:3: kw= 'white'
                    {

                    			markLeaf(elementTypeProvider.getNamedColor_WhiteKeyword_143ElementType());
                    		
                    kw=(Token)match(input,293,FOLLOW_2); 

                    			doneLeaf(kw);
                    		

                    }
                    break;
                case 145 :
                    // PsiInternalLatteCSS.g:4212:3: kw= 'whitesmoke'
                    {

                    			markLeaf(elementTypeProvider.getNamedColor_WhitesmokeKeyword_144ElementType());
                    		
                    kw=(Token)match(input,294,FOLLOW_2); 

                    			doneLeaf(kw);
                    		

                    }
                    break;
                case 146 :
                    // PsiInternalLatteCSS.g:4220:3: kw= 'yellow'
                    {

                    			markLeaf(elementTypeProvider.getNamedColor_YellowKeyword_145ElementType());
                    		
                    kw=(Token)match(input,295,FOLLOW_2); 

                    			doneLeaf(kw);
                    		

                    }
                    break;
                case 147 :
                    // PsiInternalLatteCSS.g:4228:3: kw= 'yellowgreen'
                    {

                    			markLeaf(elementTypeProvider.getNamedColor_YellowgreenKeyword_146ElementType());
                    		
                    kw=(Token)match(input,296,FOLLOW_2); 

                    			doneLeaf(kw);
                    		

                    }
                    break;
                case 148 :
                    // PsiInternalLatteCSS.g:4236:3: kw= 'transparent'
                    {

                    			markLeaf(elementTypeProvider.getNamedColor_TransparentKeyword_147ElementType());
                    		
                    kw=(Token)match(input,297,FOLLOW_2); 

                    			doneLeaf(kw);
                    		

                    }
                    break;

            }


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
    // $ANTLR end "ruleNamedColor"


    // $ANTLR start "entryRuleRGBColor"
    // PsiInternalLatteCSS.g:4247:1: entryRuleRGBColor : ruleRGBColor EOF ;
    public final void entryRuleRGBColor() throws RecognitionException {
        try {
            // PsiInternalLatteCSS.g:4247:18: ( ruleRGBColor EOF )
            // PsiInternalLatteCSS.g:4248:2: ruleRGBColor EOF
            {
             markComposite(elementTypeProvider.getRGBColorElementType()); 
            pushFollow(FOLLOW_1);
            ruleRGBColor();

            state._fsp--;

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
    // PsiInternalLatteCSS.g:4253:1: ruleRGBColor : ( ( (lv_hex_0_0= RULE_HEX_NUMBER ) ) | (otherlv_1= 'rgb' otherlv_2= '(' ( (lv_r_3_0= ruleIntegerValue ) ) otherlv_4= ',' ( (lv_g_5_0= ruleIntegerValue ) ) otherlv_6= ',' ( (lv_b_7_0= ruleIntegerValue ) ) otherlv_8= ')' ) | (otherlv_9= 'rgba' otherlv_10= '(' ( (lv_r_11_0= ruleIntegerValue ) ) otherlv_12= ',' ( (lv_g_13_0= ruleIntegerValue ) ) otherlv_14= ',' ( (lv_b_15_0= ruleIntegerValue ) ) otherlv_16= ',' ( (lv_alpha_17_0= ruleNumberValue ) ) otherlv_18= ')' ) ) ;
    public final void ruleRGBColor() throws RecognitionException {
        Token lv_hex_0_0=null;
        Token otherlv_1=null;
        Token otherlv_2=null;
        Token otherlv_4=null;
        Token otherlv_6=null;
        Token otherlv_8=null;
        Token otherlv_9=null;
        Token otherlv_10=null;
        Token otherlv_12=null;
        Token otherlv_14=null;
        Token otherlv_16=null;
        Token otherlv_18=null;

        try {
            // PsiInternalLatteCSS.g:4253:13: ( ( ( (lv_hex_0_0= RULE_HEX_NUMBER ) ) | (otherlv_1= 'rgb' otherlv_2= '(' ( (lv_r_3_0= ruleIntegerValue ) ) otherlv_4= ',' ( (lv_g_5_0= ruleIntegerValue ) ) otherlv_6= ',' ( (lv_b_7_0= ruleIntegerValue ) ) otherlv_8= ')' ) | (otherlv_9= 'rgba' otherlv_10= '(' ( (lv_r_11_0= ruleIntegerValue ) ) otherlv_12= ',' ( (lv_g_13_0= ruleIntegerValue ) ) otherlv_14= ',' ( (lv_b_15_0= ruleIntegerValue ) ) otherlv_16= ',' ( (lv_alpha_17_0= ruleNumberValue ) ) otherlv_18= ')' ) ) )
            // PsiInternalLatteCSS.g:4254:2: ( ( (lv_hex_0_0= RULE_HEX_NUMBER ) ) | (otherlv_1= 'rgb' otherlv_2= '(' ( (lv_r_3_0= ruleIntegerValue ) ) otherlv_4= ',' ( (lv_g_5_0= ruleIntegerValue ) ) otherlv_6= ',' ( (lv_b_7_0= ruleIntegerValue ) ) otherlv_8= ')' ) | (otherlv_9= 'rgba' otherlv_10= '(' ( (lv_r_11_0= ruleIntegerValue ) ) otherlv_12= ',' ( (lv_g_13_0= ruleIntegerValue ) ) otherlv_14= ',' ( (lv_b_15_0= ruleIntegerValue ) ) otherlv_16= ',' ( (lv_alpha_17_0= ruleNumberValue ) ) otherlv_18= ')' ) )
            {
            // PsiInternalLatteCSS.g:4254:2: ( ( (lv_hex_0_0= RULE_HEX_NUMBER ) ) | (otherlv_1= 'rgb' otherlv_2= '(' ( (lv_r_3_0= ruleIntegerValue ) ) otherlv_4= ',' ( (lv_g_5_0= ruleIntegerValue ) ) otherlv_6= ',' ( (lv_b_7_0= ruleIntegerValue ) ) otherlv_8= ')' ) | (otherlv_9= 'rgba' otherlv_10= '(' ( (lv_r_11_0= ruleIntegerValue ) ) otherlv_12= ',' ( (lv_g_13_0= ruleIntegerValue ) ) otherlv_14= ',' ( (lv_b_15_0= ruleIntegerValue ) ) otherlv_16= ',' ( (lv_alpha_17_0= ruleNumberValue ) ) otherlv_18= ')' ) )
            int alt48=3;
            switch ( input.LA(1) ) {
            case RULE_HEX_NUMBER:
                {
                alt48=1;
                }
                break;
            case 298:
                {
                alt48=2;
                }
                break;
            case 299:
                {
                alt48=3;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 48, 0, input);

                throw nvae;
            }

            switch (alt48) {
                case 1 :
                    // PsiInternalLatteCSS.g:4255:3: ( (lv_hex_0_0= RULE_HEX_NUMBER ) )
                    {
                    // PsiInternalLatteCSS.g:4255:3: ( (lv_hex_0_0= RULE_HEX_NUMBER ) )
                    // PsiInternalLatteCSS.g:4256:4: (lv_hex_0_0= RULE_HEX_NUMBER )
                    {
                    // PsiInternalLatteCSS.g:4256:4: (lv_hex_0_0= RULE_HEX_NUMBER )
                    // PsiInternalLatteCSS.g:4257:5: lv_hex_0_0= RULE_HEX_NUMBER
                    {

                    					markLeaf(elementTypeProvider.getRGBColor_HexHEX_NUMBERTerminalRuleCall_0_0ElementType());
                    				
                    lv_hex_0_0=(Token)match(input,RULE_HEX_NUMBER,FOLLOW_2); 

                    					doneLeaf(lv_hex_0_0);
                    				

                    }


                    }


                    }
                    break;
                case 2 :
                    // PsiInternalLatteCSS.g:4267:3: (otherlv_1= 'rgb' otherlv_2= '(' ( (lv_r_3_0= ruleIntegerValue ) ) otherlv_4= ',' ( (lv_g_5_0= ruleIntegerValue ) ) otherlv_6= ',' ( (lv_b_7_0= ruleIntegerValue ) ) otherlv_8= ')' )
                    {
                    // PsiInternalLatteCSS.g:4267:3: (otherlv_1= 'rgb' otherlv_2= '(' ( (lv_r_3_0= ruleIntegerValue ) ) otherlv_4= ',' ( (lv_g_5_0= ruleIntegerValue ) ) otherlv_6= ',' ( (lv_b_7_0= ruleIntegerValue ) ) otherlv_8= ')' )
                    // PsiInternalLatteCSS.g:4268:4: otherlv_1= 'rgb' otherlv_2= '(' ( (lv_r_3_0= ruleIntegerValue ) ) otherlv_4= ',' ( (lv_g_5_0= ruleIntegerValue ) ) otherlv_6= ',' ( (lv_b_7_0= ruleIntegerValue ) ) otherlv_8= ')'
                    {

                    				markLeaf(elementTypeProvider.getRGBColor_RgbKeyword_1_0ElementType());
                    			
                    otherlv_1=(Token)match(input,298,FOLLOW_32); 

                    				doneLeaf(otherlv_1);
                    			

                    				markLeaf(elementTypeProvider.getRGBColor_LeftParenthesisKeyword_1_1ElementType());
                    			
                    otherlv_2=(Token)match(input,142,FOLLOW_40); 

                    				doneLeaf(otherlv_2);
                    			
                    // PsiInternalLatteCSS.g:4282:4: ( (lv_r_3_0= ruleIntegerValue ) )
                    // PsiInternalLatteCSS.g:4283:5: (lv_r_3_0= ruleIntegerValue )
                    {
                    // PsiInternalLatteCSS.g:4283:5: (lv_r_3_0= ruleIntegerValue )
                    // PsiInternalLatteCSS.g:4284:6: lv_r_3_0= ruleIntegerValue
                    {

                    						markComposite(elementTypeProvider.getRGBColor_RIntegerValueParserRuleCall_1_2_0ElementType());
                    					
                    pushFollow(FOLLOW_33);
                    ruleIntegerValue();

                    state._fsp--;


                    						doneComposite();
                    					

                    }


                    }


                    				markLeaf(elementTypeProvider.getRGBColor_CommaKeyword_1_3ElementType());
                    			
                    otherlv_4=(Token)match(input,13,FOLLOW_40); 

                    				doneLeaf(otherlv_4);
                    			
                    // PsiInternalLatteCSS.g:4300:4: ( (lv_g_5_0= ruleIntegerValue ) )
                    // PsiInternalLatteCSS.g:4301:5: (lv_g_5_0= ruleIntegerValue )
                    {
                    // PsiInternalLatteCSS.g:4301:5: (lv_g_5_0= ruleIntegerValue )
                    // PsiInternalLatteCSS.g:4302:6: lv_g_5_0= ruleIntegerValue
                    {

                    						markComposite(elementTypeProvider.getRGBColor_GIntegerValueParserRuleCall_1_4_0ElementType());
                    					
                    pushFollow(FOLLOW_33);
                    ruleIntegerValue();

                    state._fsp--;


                    						doneComposite();
                    					

                    }


                    }


                    				markLeaf(elementTypeProvider.getRGBColor_CommaKeyword_1_5ElementType());
                    			
                    otherlv_6=(Token)match(input,13,FOLLOW_40); 

                    				doneLeaf(otherlv_6);
                    			
                    // PsiInternalLatteCSS.g:4318:4: ( (lv_b_7_0= ruleIntegerValue ) )
                    // PsiInternalLatteCSS.g:4319:5: (lv_b_7_0= ruleIntegerValue )
                    {
                    // PsiInternalLatteCSS.g:4319:5: (lv_b_7_0= ruleIntegerValue )
                    // PsiInternalLatteCSS.g:4320:6: lv_b_7_0= ruleIntegerValue
                    {

                    						markComposite(elementTypeProvider.getRGBColor_BIntegerValueParserRuleCall_1_6_0ElementType());
                    					
                    pushFollow(FOLLOW_34);
                    ruleIntegerValue();

                    state._fsp--;


                    						doneComposite();
                    					

                    }


                    }


                    				markLeaf(elementTypeProvider.getRGBColor_RightParenthesisKeyword_1_7ElementType());
                    			
                    otherlv_8=(Token)match(input,143,FOLLOW_2); 

                    				doneLeaf(otherlv_8);
                    			

                    }


                    }
                    break;
                case 3 :
                    // PsiInternalLatteCSS.g:4338:3: (otherlv_9= 'rgba' otherlv_10= '(' ( (lv_r_11_0= ruleIntegerValue ) ) otherlv_12= ',' ( (lv_g_13_0= ruleIntegerValue ) ) otherlv_14= ',' ( (lv_b_15_0= ruleIntegerValue ) ) otherlv_16= ',' ( (lv_alpha_17_0= ruleNumberValue ) ) otherlv_18= ')' )
                    {
                    // PsiInternalLatteCSS.g:4338:3: (otherlv_9= 'rgba' otherlv_10= '(' ( (lv_r_11_0= ruleIntegerValue ) ) otherlv_12= ',' ( (lv_g_13_0= ruleIntegerValue ) ) otherlv_14= ',' ( (lv_b_15_0= ruleIntegerValue ) ) otherlv_16= ',' ( (lv_alpha_17_0= ruleNumberValue ) ) otherlv_18= ')' )
                    // PsiInternalLatteCSS.g:4339:4: otherlv_9= 'rgba' otherlv_10= '(' ( (lv_r_11_0= ruleIntegerValue ) ) otherlv_12= ',' ( (lv_g_13_0= ruleIntegerValue ) ) otherlv_14= ',' ( (lv_b_15_0= ruleIntegerValue ) ) otherlv_16= ',' ( (lv_alpha_17_0= ruleNumberValue ) ) otherlv_18= ')'
                    {

                    				markLeaf(elementTypeProvider.getRGBColor_RgbaKeyword_2_0ElementType());
                    			
                    otherlv_9=(Token)match(input,299,FOLLOW_32); 

                    				doneLeaf(otherlv_9);
                    			

                    				markLeaf(elementTypeProvider.getRGBColor_LeftParenthesisKeyword_2_1ElementType());
                    			
                    otherlv_10=(Token)match(input,142,FOLLOW_40); 

                    				doneLeaf(otherlv_10);
                    			
                    // PsiInternalLatteCSS.g:4353:4: ( (lv_r_11_0= ruleIntegerValue ) )
                    // PsiInternalLatteCSS.g:4354:5: (lv_r_11_0= ruleIntegerValue )
                    {
                    // PsiInternalLatteCSS.g:4354:5: (lv_r_11_0= ruleIntegerValue )
                    // PsiInternalLatteCSS.g:4355:6: lv_r_11_0= ruleIntegerValue
                    {

                    						markComposite(elementTypeProvider.getRGBColor_RIntegerValueParserRuleCall_2_2_0ElementType());
                    					
                    pushFollow(FOLLOW_33);
                    ruleIntegerValue();

                    state._fsp--;


                    						doneComposite();
                    					

                    }


                    }


                    				markLeaf(elementTypeProvider.getRGBColor_CommaKeyword_2_3ElementType());
                    			
                    otherlv_12=(Token)match(input,13,FOLLOW_40); 

                    				doneLeaf(otherlv_12);
                    			
                    // PsiInternalLatteCSS.g:4371:4: ( (lv_g_13_0= ruleIntegerValue ) )
                    // PsiInternalLatteCSS.g:4372:5: (lv_g_13_0= ruleIntegerValue )
                    {
                    // PsiInternalLatteCSS.g:4372:5: (lv_g_13_0= ruleIntegerValue )
                    // PsiInternalLatteCSS.g:4373:6: lv_g_13_0= ruleIntegerValue
                    {

                    						markComposite(elementTypeProvider.getRGBColor_GIntegerValueParserRuleCall_2_4_0ElementType());
                    					
                    pushFollow(FOLLOW_33);
                    ruleIntegerValue();

                    state._fsp--;


                    						doneComposite();
                    					

                    }


                    }


                    				markLeaf(elementTypeProvider.getRGBColor_CommaKeyword_2_5ElementType());
                    			
                    otherlv_14=(Token)match(input,13,FOLLOW_40); 

                    				doneLeaf(otherlv_14);
                    			
                    // PsiInternalLatteCSS.g:4389:4: ( (lv_b_15_0= ruleIntegerValue ) )
                    // PsiInternalLatteCSS.g:4390:5: (lv_b_15_0= ruleIntegerValue )
                    {
                    // PsiInternalLatteCSS.g:4390:5: (lv_b_15_0= ruleIntegerValue )
                    // PsiInternalLatteCSS.g:4391:6: lv_b_15_0= ruleIntegerValue
                    {

                    						markComposite(elementTypeProvider.getRGBColor_BIntegerValueParserRuleCall_2_6_0ElementType());
                    					
                    pushFollow(FOLLOW_33);
                    ruleIntegerValue();

                    state._fsp--;


                    						doneComposite();
                    					

                    }


                    }


                    				markLeaf(elementTypeProvider.getRGBColor_CommaKeyword_2_7ElementType());
                    			
                    otherlv_16=(Token)match(input,13,FOLLOW_15); 

                    				doneLeaf(otherlv_16);
                    			
                    // PsiInternalLatteCSS.g:4407:4: ( (lv_alpha_17_0= ruleNumberValue ) )
                    // PsiInternalLatteCSS.g:4408:5: (lv_alpha_17_0= ruleNumberValue )
                    {
                    // PsiInternalLatteCSS.g:4408:5: (lv_alpha_17_0= ruleNumberValue )
                    // PsiInternalLatteCSS.g:4409:6: lv_alpha_17_0= ruleNumberValue
                    {

                    						markComposite(elementTypeProvider.getRGBColor_AlphaNumberValueParserRuleCall_2_8_0ElementType());
                    					
                    pushFollow(FOLLOW_34);
                    ruleNumberValue();

                    state._fsp--;


                    						doneComposite();
                    					

                    }


                    }


                    				markLeaf(elementTypeProvider.getRGBColor_RightParenthesisKeyword_2_9ElementType());
                    			
                    otherlv_18=(Token)match(input,143,FOLLOW_2); 

                    				doneLeaf(otherlv_18);
                    			

                    }


                    }
                    break;

            }


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
    // $ANTLR end "ruleRGBColor"

    // Delegated rules


 

    public static final BitSet FOLLOW_1 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_2 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_3 = new BitSet(new long[]{0x0000000000030012L});
    public static final BitSet FOLLOW_4 = new BitSet(new long[]{0x0000000000006000L});
    public static final BitSet FOLLOW_5 = new BitSet(new long[]{0x0000000000036010L});
    public static final BitSet FOLLOW_6 = new BitSet(new long[]{0x3FFFFFFFFE300000L,0x003FF80001000002L});
    public static final BitSet FOLLOW_7 = new BitSet(new long[]{0x3FFFFFFFFE308000L,0x003FF80001000002L});
    public static final BitSet FOLLOW_8 = new BitSet(new long[]{0x0000000000040002L});
    public static final BitSet FOLLOW_9 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_10 = new BitSet(new long[]{0x0000000000080000L});
    public static final BitSet FOLLOW_11 = new BitSet(new long[]{0x0000000000040000L});
    public static final BitSet FOLLOW_12 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_13 = new BitSet(new long[]{0x0000000001C00000L});
    public static final BitSet FOLLOW_14 = new BitSet(new long[]{0x00000000000000C0L,0x0000000000000000L,0x0000000000000180L});
    public static final BitSet FOLLOW_15 = new BitSet(new long[]{0x00000000000000C0L});
    public static final BitSet FOLLOW_16 = new BitSet(new long[]{0x00000000000000C2L});
    public static final BitSet FOLLOW_17 = new BitSet(new long[]{0x0000000000000100L,0x0000000000000000L,0xFFFFFFFFFFD00001L,0xFFFFFFFFFFFFFFFFL,0x00000FFFFFFFFFFFL});
    public static final BitSet FOLLOW_18 = new BitSet(new long[]{0x021FFCFFFE000000L,0x0000000000000000L,0x0000000000000018L});
    public static final BitSet FOLLOW_19 = new BitSet(new long[]{0x0000000000002002L});
    public static final BitSet FOLLOW_20 = new BitSet(new long[]{0x00000000000000C2L,0xFF80000000000000L,0x0000000000000007L});
    public static final BitSet FOLLOW_21 = new BitSet(new long[]{0x0000000000000000L,0x00000000000003FCL});
    public static final BitSet FOLLOW_22 = new BitSet(new long[]{0x0000000000000002L,0x00000000000003FCL});
    public static final BitSet FOLLOW_23 = new BitSet(new long[]{0xC0000000000000C0L,0x0000000000000001L});
    public static final BitSet FOLLOW_24 = new BitSet(new long[]{0xC000000000000000L,0x0000000000000001L});
    public static final BitSet FOLLOW_25 = new BitSet(new long[]{0x0000000000000102L,0x0000000000000000L,0xFFFFFFFFFFD00001L,0xFFFFFFFFFFFFFFFFL,0x00000FFFFFFFFFFFL});
    public static final BitSet FOLLOW_26 = new BitSet(new long[]{0x0000000000000002L,0x000007FFFE000000L});
    public static final BitSet FOLLOW_27 = new BitSet(new long[]{0x0000000000000000L,0x0000000000FFFC00L});
    public static final BitSet FOLLOW_28 = new BitSet(new long[]{0x0000000000000000L,0x000007FFFE000000L});
    public static final BitSet FOLLOW_29 = new BitSet(new long[]{0x0000000000000000L,0x0040000000043000L});
    public static final BitSet FOLLOW_30 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000000000000060L});
    public static final BitSet FOLLOW_31 = new BitSet(new long[]{0x0000000000000002L,0x0000000000000000L,0x0000000000003E00L});
    public static final BitSet FOLLOW_32 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000000000004000L});
    public static final BitSet FOLLOW_33 = new BitSet(new long[]{0x0000000000002000L});
    public static final BitSet FOLLOW_34 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000000000008000L});
    public static final BitSet FOLLOW_35 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000000000010000L});
    public static final BitSet FOLLOW_36 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000000000020000L});
    public static final BitSet FOLLOW_37 = new BitSet(new long[]{0x0000000000000002L,0x0000000000000000L,0x00000000000C4000L});
    public static final BitSet FOLLOW_38 = new BitSet(new long[]{0x00000000000000C0L,0x0000000000000000L,0x0000000000004000L});
    public static final BitSet FOLLOW_39 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000000000200000L});
    public static final BitSet FOLLOW_40 = new BitSet(new long[]{0x0000000000000040L});

}