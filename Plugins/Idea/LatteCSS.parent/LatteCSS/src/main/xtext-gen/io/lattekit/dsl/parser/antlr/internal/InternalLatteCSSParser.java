package io.lattekit.dsl.parser.antlr.internal; 

import org.eclipse.xtext.*;
import org.eclipse.xtext.parser.*;
import org.eclipse.xtext.parser.impl.*;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.parser.antlr.AbstractInternalAntlrParser;
import org.eclipse.xtext.parser.antlr.XtextTokenStream;
import org.eclipse.xtext.parser.antlr.XtextTokenStream.HiddenTokens;
import org.eclipse.xtext.parser.antlr.AntlrDatatypeRuleToken;
import io.lattekit.dsl.services.LatteCSSGrammarAccess;



import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

@SuppressWarnings("all")
public class InternalLatteCSSParser extends AbstractInternalAntlrParser {
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


        public InternalLatteCSSParser(TokenStream input) {
            this(input, new RecognizerSharedState());
        }
        public InternalLatteCSSParser(TokenStream input, RecognizerSharedState state) {
            super(input, state);
             
        }
        

    public String[] getTokenNames() { return InternalLatteCSSParser.tokenNames; }
    public String getGrammarFileName() { return "InternalLatteCSS.g"; }



     	private LatteCSSGrammarAccess grammarAccess;
     	
        public InternalLatteCSSParser(TokenStream input, LatteCSSGrammarAccess grammarAccess) {
            this(input);
            this.grammarAccess = grammarAccess;
            registerRules(grammarAccess.getGrammar());
        }
        
        @Override
        protected String getFirstRuleName() {
        	return "CSS";	
       	}
       	
       	@Override
       	protected LatteCSSGrammarAccess getGrammarAccess() {
       		return grammarAccess;
       	}



    // $ANTLR start "entryRuleCSS"
    // InternalLatteCSS.g:67:1: entryRuleCSS returns [EObject current=null] : iv_ruleCSS= ruleCSS EOF ;
    public final EObject entryRuleCSS() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleCSS = null;


        try {
            // InternalLatteCSS.g:68:2: (iv_ruleCSS= ruleCSS EOF )
            // InternalLatteCSS.g:69:2: iv_ruleCSS= ruleCSS EOF
            {
             newCompositeNode(grammarAccess.getCSSRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleCSS=ruleCSS();

            state._fsp--;

             current =iv_ruleCSS; 
            match(input,EOF,FOLLOW_2); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleCSS"


    // $ANTLR start "ruleCSS"
    // InternalLatteCSS.g:76:1: ruleCSS returns [EObject current=null] : ( (lv_definitions_0_0= ruleDefinition ) )+ ;
    public final EObject ruleCSS() throws RecognitionException {
        EObject current = null;

        EObject lv_definitions_0_0 = null;


         enterRule(); 
            
        try {
            // InternalLatteCSS.g:79:28: ( ( (lv_definitions_0_0= ruleDefinition ) )+ )
            // InternalLatteCSS.g:80:1: ( (lv_definitions_0_0= ruleDefinition ) )+
            {
            // InternalLatteCSS.g:80:1: ( (lv_definitions_0_0= ruleDefinition ) )+
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
            	    // InternalLatteCSS.g:81:1: (lv_definitions_0_0= ruleDefinition )
            	    {
            	    // InternalLatteCSS.g:81:1: (lv_definitions_0_0= ruleDefinition )
            	    // InternalLatteCSS.g:82:3: lv_definitions_0_0= ruleDefinition
            	    {
            	     
            	    	        newCompositeNode(grammarAccess.getCSSAccess().getDefinitionsDefinitionParserRuleCall_0()); 
            	    	    
            	    pushFollow(FOLLOW_3);
            	    lv_definitions_0_0=ruleDefinition();

            	    state._fsp--;


            	    	        if (current==null) {
            	    	            current = createModelElementForParent(grammarAccess.getCSSRule());
            	    	        }
            	           		add(
            	           			current, 
            	           			"definitions",
            	            		lv_definitions_0_0, 
            	            		"io.lattekit.dsl.LatteCSS.Definition");
            	    	        afterParserOrEnumRuleCall();
            	    	    

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

             leaveRule(); 
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleCSS"


    // $ANTLR start "entryRuleDefinition"
    // InternalLatteCSS.g:106:1: entryRuleDefinition returns [EObject current=null] : iv_ruleDefinition= ruleDefinition EOF ;
    public final EObject entryRuleDefinition() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleDefinition = null;


        try {
            // InternalLatteCSS.g:107:2: (iv_ruleDefinition= ruleDefinition EOF )
            // InternalLatteCSS.g:108:2: iv_ruleDefinition= ruleDefinition EOF
            {
             newCompositeNode(grammarAccess.getDefinitionRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleDefinition=ruleDefinition();

            state._fsp--;

             current =iv_ruleDefinition; 
            match(input,EOF,FOLLOW_2); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleDefinition"


    // $ANTLR start "ruleDefinition"
    // InternalLatteCSS.g:115:1: ruleDefinition returns [EObject current=null] : ( ( (lv_selector_0_0= ruleSelector ) ) (otherlv_1= ',' ( (lv_selector_2_0= ruleSelector ) ) )* otherlv_3= '{' ( (lv_properties_4_0= ruleCSSProperty ) )+ otherlv_5= '}' ) ;
    public final EObject ruleDefinition() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_3=null;
        Token otherlv_5=null;
        EObject lv_selector_0_0 = null;

        EObject lv_selector_2_0 = null;

        EObject lv_properties_4_0 = null;


         enterRule(); 
            
        try {
            // InternalLatteCSS.g:118:28: ( ( ( (lv_selector_0_0= ruleSelector ) ) (otherlv_1= ',' ( (lv_selector_2_0= ruleSelector ) ) )* otherlv_3= '{' ( (lv_properties_4_0= ruleCSSProperty ) )+ otherlv_5= '}' ) )
            // InternalLatteCSS.g:119:1: ( ( (lv_selector_0_0= ruleSelector ) ) (otherlv_1= ',' ( (lv_selector_2_0= ruleSelector ) ) )* otherlv_3= '{' ( (lv_properties_4_0= ruleCSSProperty ) )+ otherlv_5= '}' )
            {
            // InternalLatteCSS.g:119:1: ( ( (lv_selector_0_0= ruleSelector ) ) (otherlv_1= ',' ( (lv_selector_2_0= ruleSelector ) ) )* otherlv_3= '{' ( (lv_properties_4_0= ruleCSSProperty ) )+ otherlv_5= '}' )
            // InternalLatteCSS.g:119:2: ( (lv_selector_0_0= ruleSelector ) ) (otherlv_1= ',' ( (lv_selector_2_0= ruleSelector ) ) )* otherlv_3= '{' ( (lv_properties_4_0= ruleCSSProperty ) )+ otherlv_5= '}'
            {
            // InternalLatteCSS.g:119:2: ( (lv_selector_0_0= ruleSelector ) )
            // InternalLatteCSS.g:120:1: (lv_selector_0_0= ruleSelector )
            {
            // InternalLatteCSS.g:120:1: (lv_selector_0_0= ruleSelector )
            // InternalLatteCSS.g:121:3: lv_selector_0_0= ruleSelector
            {
             
            	        newCompositeNode(grammarAccess.getDefinitionAccess().getSelectorSelectorParserRuleCall_0_0()); 
            	    
            pushFollow(FOLLOW_4);
            lv_selector_0_0=ruleSelector();

            state._fsp--;


            	        if (current==null) {
            	            current = createModelElementForParent(grammarAccess.getDefinitionRule());
            	        }
                   		add(
                   			current, 
                   			"selector",
                    		lv_selector_0_0, 
                    		"io.lattekit.dsl.LatteCSS.Selector");
            	        afterParserOrEnumRuleCall();
            	    

            }


            }

            // InternalLatteCSS.g:137:2: (otherlv_1= ',' ( (lv_selector_2_0= ruleSelector ) ) )*
            loop2:
            do {
                int alt2=2;
                int LA2_0 = input.LA(1);

                if ( (LA2_0==13) ) {
                    alt2=1;
                }


                switch (alt2) {
            	case 1 :
            	    // InternalLatteCSS.g:137:4: otherlv_1= ',' ( (lv_selector_2_0= ruleSelector ) )
            	    {
            	    otherlv_1=(Token)match(input,13,FOLLOW_5); 

            	        	newLeafNode(otherlv_1, grammarAccess.getDefinitionAccess().getCommaKeyword_1_0());
            	        
            	    // InternalLatteCSS.g:141:1: ( (lv_selector_2_0= ruleSelector ) )
            	    // InternalLatteCSS.g:142:1: (lv_selector_2_0= ruleSelector )
            	    {
            	    // InternalLatteCSS.g:142:1: (lv_selector_2_0= ruleSelector )
            	    // InternalLatteCSS.g:143:3: lv_selector_2_0= ruleSelector
            	    {
            	     
            	    	        newCompositeNode(grammarAccess.getDefinitionAccess().getSelectorSelectorParserRuleCall_1_1_0()); 
            	    	    
            	    pushFollow(FOLLOW_4);
            	    lv_selector_2_0=ruleSelector();

            	    state._fsp--;


            	    	        if (current==null) {
            	    	            current = createModelElementForParent(grammarAccess.getDefinitionRule());
            	    	        }
            	           		add(
            	           			current, 
            	           			"selector",
            	            		lv_selector_2_0, 
            	            		"io.lattekit.dsl.LatteCSS.Selector");
            	    	        afterParserOrEnumRuleCall();
            	    	    

            	    }


            	    }


            	    }
            	    break;

            	default :
            	    break loop2;
                }
            } while (true);

            otherlv_3=(Token)match(input,14,FOLLOW_6); 

                	newLeafNode(otherlv_3, grammarAccess.getDefinitionAccess().getLeftCurlyBracketKeyword_2());
                
            // InternalLatteCSS.g:163:1: ( (lv_properties_4_0= ruleCSSProperty ) )+
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
            	    // InternalLatteCSS.g:164:1: (lv_properties_4_0= ruleCSSProperty )
            	    {
            	    // InternalLatteCSS.g:164:1: (lv_properties_4_0= ruleCSSProperty )
            	    // InternalLatteCSS.g:165:3: lv_properties_4_0= ruleCSSProperty
            	    {
            	     
            	    	        newCompositeNode(grammarAccess.getDefinitionAccess().getPropertiesCSSPropertyParserRuleCall_3_0()); 
            	    	    
            	    pushFollow(FOLLOW_7);
            	    lv_properties_4_0=ruleCSSProperty();

            	    state._fsp--;


            	    	        if (current==null) {
            	    	            current = createModelElementForParent(grammarAccess.getDefinitionRule());
            	    	        }
            	           		add(
            	           			current, 
            	           			"properties",
            	            		lv_properties_4_0, 
            	            		"io.lattekit.dsl.LatteCSS.CSSProperty");
            	    	        afterParserOrEnumRuleCall();
            	    	    

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

            otherlv_5=(Token)match(input,15,FOLLOW_2); 

                	newLeafNode(otherlv_5, grammarAccess.getDefinitionAccess().getRightCurlyBracketKeyword_4());
                

            }


            }

             leaveRule(); 
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleDefinition"


    // $ANTLR start "entryRuleSelector"
    // InternalLatteCSS.g:193:1: entryRuleSelector returns [EObject current=null] : iv_ruleSelector= ruleSelector EOF ;
    public final EObject entryRuleSelector() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleSelector = null;


        try {
            // InternalLatteCSS.g:194:2: (iv_ruleSelector= ruleSelector EOF )
            // InternalLatteCSS.g:195:2: iv_ruleSelector= ruleSelector EOF
            {
             newCompositeNode(grammarAccess.getSelectorRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleSelector=ruleSelector();

            state._fsp--;

             current =iv_ruleSelector; 
            match(input,EOF,FOLLOW_2); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleSelector"


    // $ANTLR start "ruleSelector"
    // InternalLatteCSS.g:202:1: ruleSelector returns [EObject current=null] : ( (lv_simpleSelector_0_0= ruleSimpleSelector ) )+ ;
    public final EObject ruleSelector() throws RecognitionException {
        EObject current = null;

        EObject lv_simpleSelector_0_0 = null;


         enterRule(); 
            
        try {
            // InternalLatteCSS.g:205:28: ( ( (lv_simpleSelector_0_0= ruleSimpleSelector ) )+ )
            // InternalLatteCSS.g:206:1: ( (lv_simpleSelector_0_0= ruleSimpleSelector ) )+
            {
            // InternalLatteCSS.g:206:1: ( (lv_simpleSelector_0_0= ruleSimpleSelector ) )+
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
            	    // InternalLatteCSS.g:207:1: (lv_simpleSelector_0_0= ruleSimpleSelector )
            	    {
            	    // InternalLatteCSS.g:207:1: (lv_simpleSelector_0_0= ruleSimpleSelector )
            	    // InternalLatteCSS.g:208:3: lv_simpleSelector_0_0= ruleSimpleSelector
            	    {
            	     
            	    	        newCompositeNode(grammarAccess.getSelectorAccess().getSimpleSelectorSimpleSelectorParserRuleCall_0()); 
            	    	    
            	    pushFollow(FOLLOW_3);
            	    lv_simpleSelector_0_0=ruleSimpleSelector();

            	    state._fsp--;


            	    	        if (current==null) {
            	    	            current = createModelElementForParent(grammarAccess.getSelectorRule());
            	    	        }
            	           		add(
            	           			current, 
            	           			"simpleSelector",
            	            		lv_simpleSelector_0_0, 
            	            		"io.lattekit.dsl.LatteCSS.SimpleSelector");
            	    	        afterParserOrEnumRuleCall();
            	    	    

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

             leaveRule(); 
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleSelector"


    // $ANTLR start "entryRuleSimpleSelector"
    // InternalLatteCSS.g:232:1: entryRuleSimpleSelector returns [EObject current=null] : iv_ruleSimpleSelector= ruleSimpleSelector EOF ;
    public final EObject entryRuleSimpleSelector() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleSimpleSelector = null;


        try {
            // InternalLatteCSS.g:233:2: (iv_ruleSimpleSelector= ruleSimpleSelector EOF )
            // InternalLatteCSS.g:234:2: iv_ruleSimpleSelector= ruleSimpleSelector EOF
            {
             newCompositeNode(grammarAccess.getSimpleSelectorRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleSimpleSelector=ruleSimpleSelector();

            state._fsp--;

             current =iv_ruleSimpleSelector; 
            match(input,EOF,FOLLOW_2); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleSimpleSelector"


    // $ANTLR start "ruleSimpleSelector"
    // InternalLatteCSS.g:241:1: ruleSimpleSelector returns [EObject current=null] : ( ( (lv_element_0_0= RULE_ID ) ) | ( ( (lv_id_1_0= ruleIdSelector ) ) ( (lv_pseudoClass_2_0= rulePseudoClassSelector ) )? ) | ( ( (lv_class_3_0= ruleClassSelector ) ) ( (lv_pseudoClass_4_0= rulePseudoClassSelector ) )? ) ) ;
    public final EObject ruleSimpleSelector() throws RecognitionException {
        EObject current = null;

        Token lv_element_0_0=null;
        EObject lv_id_1_0 = null;

        EObject lv_pseudoClass_2_0 = null;

        EObject lv_class_3_0 = null;

        EObject lv_pseudoClass_4_0 = null;


         enterRule(); 
            
        try {
            // InternalLatteCSS.g:244:28: ( ( ( (lv_element_0_0= RULE_ID ) ) | ( ( (lv_id_1_0= ruleIdSelector ) ) ( (lv_pseudoClass_2_0= rulePseudoClassSelector ) )? ) | ( ( (lv_class_3_0= ruleClassSelector ) ) ( (lv_pseudoClass_4_0= rulePseudoClassSelector ) )? ) ) )
            // InternalLatteCSS.g:245:1: ( ( (lv_element_0_0= RULE_ID ) ) | ( ( (lv_id_1_0= ruleIdSelector ) ) ( (lv_pseudoClass_2_0= rulePseudoClassSelector ) )? ) | ( ( (lv_class_3_0= ruleClassSelector ) ) ( (lv_pseudoClass_4_0= rulePseudoClassSelector ) )? ) )
            {
            // InternalLatteCSS.g:245:1: ( ( (lv_element_0_0= RULE_ID ) ) | ( ( (lv_id_1_0= ruleIdSelector ) ) ( (lv_pseudoClass_2_0= rulePseudoClassSelector ) )? ) | ( ( (lv_class_3_0= ruleClassSelector ) ) ( (lv_pseudoClass_4_0= rulePseudoClassSelector ) )? ) )
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
                    // InternalLatteCSS.g:245:2: ( (lv_element_0_0= RULE_ID ) )
                    {
                    // InternalLatteCSS.g:245:2: ( (lv_element_0_0= RULE_ID ) )
                    // InternalLatteCSS.g:246:1: (lv_element_0_0= RULE_ID )
                    {
                    // InternalLatteCSS.g:246:1: (lv_element_0_0= RULE_ID )
                    // InternalLatteCSS.g:247:3: lv_element_0_0= RULE_ID
                    {
                    lv_element_0_0=(Token)match(input,RULE_ID,FOLLOW_2); 

                    			newLeafNode(lv_element_0_0, grammarAccess.getSimpleSelectorAccess().getElementIDTerminalRuleCall_0_0()); 
                    		

                    	        if (current==null) {
                    	            current = createModelElement(grammarAccess.getSimpleSelectorRule());
                    	        }
                           		setWithLastConsumed(
                           			current, 
                           			"element",
                            		lv_element_0_0, 
                            		"org.eclipse.xtext.common.Terminals.ID");
                    	    

                    }


                    }


                    }
                    break;
                case 2 :
                    // InternalLatteCSS.g:264:6: ( ( (lv_id_1_0= ruleIdSelector ) ) ( (lv_pseudoClass_2_0= rulePseudoClassSelector ) )? )
                    {
                    // InternalLatteCSS.g:264:6: ( ( (lv_id_1_0= ruleIdSelector ) ) ( (lv_pseudoClass_2_0= rulePseudoClassSelector ) )? )
                    // InternalLatteCSS.g:264:7: ( (lv_id_1_0= ruleIdSelector ) ) ( (lv_pseudoClass_2_0= rulePseudoClassSelector ) )?
                    {
                    // InternalLatteCSS.g:264:7: ( (lv_id_1_0= ruleIdSelector ) )
                    // InternalLatteCSS.g:265:1: (lv_id_1_0= ruleIdSelector )
                    {
                    // InternalLatteCSS.g:265:1: (lv_id_1_0= ruleIdSelector )
                    // InternalLatteCSS.g:266:3: lv_id_1_0= ruleIdSelector
                    {
                     
                    	        newCompositeNode(grammarAccess.getSimpleSelectorAccess().getIdIdSelectorParserRuleCall_1_0_0()); 
                    	    
                    pushFollow(FOLLOW_8);
                    lv_id_1_0=ruleIdSelector();

                    state._fsp--;


                    	        if (current==null) {
                    	            current = createModelElementForParent(grammarAccess.getSimpleSelectorRule());
                    	        }
                           		set(
                           			current, 
                           			"id",
                            		lv_id_1_0, 
                            		"io.lattekit.dsl.LatteCSS.IdSelector");
                    	        afterParserOrEnumRuleCall();
                    	    

                    }


                    }

                    // InternalLatteCSS.g:282:2: ( (lv_pseudoClass_2_0= rulePseudoClassSelector ) )?
                    int alt5=2;
                    int LA5_0 = input.LA(1);

                    if ( (LA5_0==18) ) {
                        alt5=1;
                    }
                    switch (alt5) {
                        case 1 :
                            // InternalLatteCSS.g:283:1: (lv_pseudoClass_2_0= rulePseudoClassSelector )
                            {
                            // InternalLatteCSS.g:283:1: (lv_pseudoClass_2_0= rulePseudoClassSelector )
                            // InternalLatteCSS.g:284:3: lv_pseudoClass_2_0= rulePseudoClassSelector
                            {
                             
                            	        newCompositeNode(grammarAccess.getSimpleSelectorAccess().getPseudoClassPseudoClassSelectorParserRuleCall_1_1_0()); 
                            	    
                            pushFollow(FOLLOW_2);
                            lv_pseudoClass_2_0=rulePseudoClassSelector();

                            state._fsp--;


                            	        if (current==null) {
                            	            current = createModelElementForParent(grammarAccess.getSimpleSelectorRule());
                            	        }
                                   		set(
                                   			current, 
                                   			"pseudoClass",
                                    		lv_pseudoClass_2_0, 
                                    		"io.lattekit.dsl.LatteCSS.PseudoClassSelector");
                            	        afterParserOrEnumRuleCall();
                            	    

                            }


                            }
                            break;

                    }


                    }


                    }
                    break;
                case 3 :
                    // InternalLatteCSS.g:301:6: ( ( (lv_class_3_0= ruleClassSelector ) ) ( (lv_pseudoClass_4_0= rulePseudoClassSelector ) )? )
                    {
                    // InternalLatteCSS.g:301:6: ( ( (lv_class_3_0= ruleClassSelector ) ) ( (lv_pseudoClass_4_0= rulePseudoClassSelector ) )? )
                    // InternalLatteCSS.g:301:7: ( (lv_class_3_0= ruleClassSelector ) ) ( (lv_pseudoClass_4_0= rulePseudoClassSelector ) )?
                    {
                    // InternalLatteCSS.g:301:7: ( (lv_class_3_0= ruleClassSelector ) )
                    // InternalLatteCSS.g:302:1: (lv_class_3_0= ruleClassSelector )
                    {
                    // InternalLatteCSS.g:302:1: (lv_class_3_0= ruleClassSelector )
                    // InternalLatteCSS.g:303:3: lv_class_3_0= ruleClassSelector
                    {
                     
                    	        newCompositeNode(grammarAccess.getSimpleSelectorAccess().getClassClassSelectorParserRuleCall_2_0_0()); 
                    	    
                    pushFollow(FOLLOW_8);
                    lv_class_3_0=ruleClassSelector();

                    state._fsp--;


                    	        if (current==null) {
                    	            current = createModelElementForParent(grammarAccess.getSimpleSelectorRule());
                    	        }
                           		set(
                           			current, 
                           			"class",
                            		lv_class_3_0, 
                            		"io.lattekit.dsl.LatteCSS.ClassSelector");
                    	        afterParserOrEnumRuleCall();
                    	    

                    }


                    }

                    // InternalLatteCSS.g:319:2: ( (lv_pseudoClass_4_0= rulePseudoClassSelector ) )?
                    int alt6=2;
                    int LA6_0 = input.LA(1);

                    if ( (LA6_0==18) ) {
                        alt6=1;
                    }
                    switch (alt6) {
                        case 1 :
                            // InternalLatteCSS.g:320:1: (lv_pseudoClass_4_0= rulePseudoClassSelector )
                            {
                            // InternalLatteCSS.g:320:1: (lv_pseudoClass_4_0= rulePseudoClassSelector )
                            // InternalLatteCSS.g:321:3: lv_pseudoClass_4_0= rulePseudoClassSelector
                            {
                             
                            	        newCompositeNode(grammarAccess.getSimpleSelectorAccess().getPseudoClassPseudoClassSelectorParserRuleCall_2_1_0()); 
                            	    
                            pushFollow(FOLLOW_2);
                            lv_pseudoClass_4_0=rulePseudoClassSelector();

                            state._fsp--;


                            	        if (current==null) {
                            	            current = createModelElementForParent(grammarAccess.getSimpleSelectorRule());
                            	        }
                                   		set(
                                   			current, 
                                   			"pseudoClass",
                                    		lv_pseudoClass_4_0, 
                                    		"io.lattekit.dsl.LatteCSS.PseudoClassSelector");
                            	        afterParserOrEnumRuleCall();
                            	    

                            }


                            }
                            break;

                    }


                    }


                    }
                    break;

            }


            }

             leaveRule(); 
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleSimpleSelector"


    // $ANTLR start "entryRuleIdSelector"
    // InternalLatteCSS.g:345:1: entryRuleIdSelector returns [EObject current=null] : iv_ruleIdSelector= ruleIdSelector EOF ;
    public final EObject entryRuleIdSelector() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleIdSelector = null;


        try {
            // InternalLatteCSS.g:346:2: (iv_ruleIdSelector= ruleIdSelector EOF )
            // InternalLatteCSS.g:347:2: iv_ruleIdSelector= ruleIdSelector EOF
            {
             newCompositeNode(grammarAccess.getIdSelectorRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleIdSelector=ruleIdSelector();

            state._fsp--;

             current =iv_ruleIdSelector; 
            match(input,EOF,FOLLOW_2); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleIdSelector"


    // $ANTLR start "ruleIdSelector"
    // InternalLatteCSS.g:354:1: ruleIdSelector returns [EObject current=null] : (otherlv_0= '#' ( (lv_id_1_0= RULE_ID ) ) ) ;
    public final EObject ruleIdSelector() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token lv_id_1_0=null;

         enterRule(); 
            
        try {
            // InternalLatteCSS.g:357:28: ( (otherlv_0= '#' ( (lv_id_1_0= RULE_ID ) ) ) )
            // InternalLatteCSS.g:358:1: (otherlv_0= '#' ( (lv_id_1_0= RULE_ID ) ) )
            {
            // InternalLatteCSS.g:358:1: (otherlv_0= '#' ( (lv_id_1_0= RULE_ID ) ) )
            // InternalLatteCSS.g:358:3: otherlv_0= '#' ( (lv_id_1_0= RULE_ID ) )
            {
            otherlv_0=(Token)match(input,16,FOLLOW_9); 

                	newLeafNode(otherlv_0, grammarAccess.getIdSelectorAccess().getNumberSignKeyword_0());
                
            // InternalLatteCSS.g:362:1: ( (lv_id_1_0= RULE_ID ) )
            // InternalLatteCSS.g:363:1: (lv_id_1_0= RULE_ID )
            {
            // InternalLatteCSS.g:363:1: (lv_id_1_0= RULE_ID )
            // InternalLatteCSS.g:364:3: lv_id_1_0= RULE_ID
            {
            lv_id_1_0=(Token)match(input,RULE_ID,FOLLOW_2); 

            			newLeafNode(lv_id_1_0, grammarAccess.getIdSelectorAccess().getIdIDTerminalRuleCall_1_0()); 
            		

            	        if (current==null) {
            	            current = createModelElement(grammarAccess.getIdSelectorRule());
            	        }
                   		setWithLastConsumed(
                   			current, 
                   			"id",
                    		lv_id_1_0, 
                    		"org.eclipse.xtext.common.Terminals.ID");
            	    

            }


            }


            }


            }

             leaveRule(); 
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleIdSelector"


    // $ANTLR start "entryRuleClassSelector"
    // InternalLatteCSS.g:388:1: entryRuleClassSelector returns [EObject current=null] : iv_ruleClassSelector= ruleClassSelector EOF ;
    public final EObject entryRuleClassSelector() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleClassSelector = null;


        try {
            // InternalLatteCSS.g:389:2: (iv_ruleClassSelector= ruleClassSelector EOF )
            // InternalLatteCSS.g:390:2: iv_ruleClassSelector= ruleClassSelector EOF
            {
             newCompositeNode(grammarAccess.getClassSelectorRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleClassSelector=ruleClassSelector();

            state._fsp--;

             current =iv_ruleClassSelector; 
            match(input,EOF,FOLLOW_2); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleClassSelector"


    // $ANTLR start "ruleClassSelector"
    // InternalLatteCSS.g:397:1: ruleClassSelector returns [EObject current=null] : (otherlv_0= '.' ( (lv_class_1_0= RULE_ID ) ) ) ;
    public final EObject ruleClassSelector() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token lv_class_1_0=null;

         enterRule(); 
            
        try {
            // InternalLatteCSS.g:400:28: ( (otherlv_0= '.' ( (lv_class_1_0= RULE_ID ) ) ) )
            // InternalLatteCSS.g:401:1: (otherlv_0= '.' ( (lv_class_1_0= RULE_ID ) ) )
            {
            // InternalLatteCSS.g:401:1: (otherlv_0= '.' ( (lv_class_1_0= RULE_ID ) ) )
            // InternalLatteCSS.g:401:3: otherlv_0= '.' ( (lv_class_1_0= RULE_ID ) )
            {
            otherlv_0=(Token)match(input,17,FOLLOW_9); 

                	newLeafNode(otherlv_0, grammarAccess.getClassSelectorAccess().getFullStopKeyword_0());
                
            // InternalLatteCSS.g:405:1: ( (lv_class_1_0= RULE_ID ) )
            // InternalLatteCSS.g:406:1: (lv_class_1_0= RULE_ID )
            {
            // InternalLatteCSS.g:406:1: (lv_class_1_0= RULE_ID )
            // InternalLatteCSS.g:407:3: lv_class_1_0= RULE_ID
            {
            lv_class_1_0=(Token)match(input,RULE_ID,FOLLOW_2); 

            			newLeafNode(lv_class_1_0, grammarAccess.getClassSelectorAccess().getClassIDTerminalRuleCall_1_0()); 
            		

            	        if (current==null) {
            	            current = createModelElement(grammarAccess.getClassSelectorRule());
            	        }
                   		setWithLastConsumed(
                   			current, 
                   			"class",
                    		lv_class_1_0, 
                    		"org.eclipse.xtext.common.Terminals.ID");
            	    

            }


            }


            }


            }

             leaveRule(); 
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleClassSelector"


    // $ANTLR start "entryRulePseudoClassSelector"
    // InternalLatteCSS.g:431:1: entryRulePseudoClassSelector returns [EObject current=null] : iv_rulePseudoClassSelector= rulePseudoClassSelector EOF ;
    public final EObject entryRulePseudoClassSelector() throws RecognitionException {
        EObject current = null;

        EObject iv_rulePseudoClassSelector = null;


        try {
            // InternalLatteCSS.g:432:2: (iv_rulePseudoClassSelector= rulePseudoClassSelector EOF )
            // InternalLatteCSS.g:433:2: iv_rulePseudoClassSelector= rulePseudoClassSelector EOF
            {
             newCompositeNode(grammarAccess.getPseudoClassSelectorRule()); 
            pushFollow(FOLLOW_1);
            iv_rulePseudoClassSelector=rulePseudoClassSelector();

            state._fsp--;

             current =iv_rulePseudoClassSelector; 
            match(input,EOF,FOLLOW_2); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRulePseudoClassSelector"


    // $ANTLR start "rulePseudoClassSelector"
    // InternalLatteCSS.g:440:1: rulePseudoClassSelector returns [EObject current=null] : (otherlv_0= ':' ( (lv_value_1_0= RULE_ID ) ) ) ;
    public final EObject rulePseudoClassSelector() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token lv_value_1_0=null;

         enterRule(); 
            
        try {
            // InternalLatteCSS.g:443:28: ( (otherlv_0= ':' ( (lv_value_1_0= RULE_ID ) ) ) )
            // InternalLatteCSS.g:444:1: (otherlv_0= ':' ( (lv_value_1_0= RULE_ID ) ) )
            {
            // InternalLatteCSS.g:444:1: (otherlv_0= ':' ( (lv_value_1_0= RULE_ID ) ) )
            // InternalLatteCSS.g:444:3: otherlv_0= ':' ( (lv_value_1_0= RULE_ID ) )
            {
            otherlv_0=(Token)match(input,18,FOLLOW_9); 

                	newLeafNode(otherlv_0, grammarAccess.getPseudoClassSelectorAccess().getColonKeyword_0());
                
            // InternalLatteCSS.g:448:1: ( (lv_value_1_0= RULE_ID ) )
            // InternalLatteCSS.g:449:1: (lv_value_1_0= RULE_ID )
            {
            // InternalLatteCSS.g:449:1: (lv_value_1_0= RULE_ID )
            // InternalLatteCSS.g:450:3: lv_value_1_0= RULE_ID
            {
            lv_value_1_0=(Token)match(input,RULE_ID,FOLLOW_2); 

            			newLeafNode(lv_value_1_0, grammarAccess.getPseudoClassSelectorAccess().getValueIDTerminalRuleCall_1_0()); 
            		

            	        if (current==null) {
            	            current = createModelElement(grammarAccess.getPseudoClassSelectorRule());
            	        }
                   		setWithLastConsumed(
                   			current, 
                   			"value",
                    		lv_value_1_0, 
                    		"org.eclipse.xtext.common.Terminals.ID");
            	    

            }


            }


            }


            }

             leaveRule(); 
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "rulePseudoClassSelector"


    // $ANTLR start "entryRuleCSSProperty"
    // InternalLatteCSS.g:474:1: entryRuleCSSProperty returns [EObject current=null] : iv_ruleCSSProperty= ruleCSSProperty EOF ;
    public final EObject entryRuleCSSProperty() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleCSSProperty = null;


        try {
            // InternalLatteCSS.g:475:2: (iv_ruleCSSProperty= ruleCSSProperty EOF )
            // InternalLatteCSS.g:476:2: iv_ruleCSSProperty= ruleCSSProperty EOF
            {
             newCompositeNode(grammarAccess.getCSSPropertyRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleCSSProperty=ruleCSSProperty();

            state._fsp--;

             current =iv_ruleCSSProperty; 
            match(input,EOF,FOLLOW_2); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleCSSProperty"


    // $ANTLR start "ruleCSSProperty"
    // InternalLatteCSS.g:483:1: ruleCSSProperty returns [EObject current=null] : ( (this_TransitionProperty_0= ruleTransitionProperty | this_FontFamilyProperty_1= ruleFontFamilyProperty | this_FontStyleProperty_2= ruleFontStyleProperty | this_SizeProperty_3= ruleSizeProperty | this_ShorthandSizeProperty_4= ruleShorthandSizeProperty | this_ShorthandColorProperty_5= ruleShorthandColorProperty | this_BorderRadiusProperty_6= ruleBorderRadiusProperty | this_ViewSizeProperty_7= ruleViewSizeProperty | this_PaintProperty_8= rulePaintProperty | this_ColorProperty_9= ruleColorProperty | this_DrawableProperty_10= ruleDrawableProperty | this_BackgroundRepeatProperty_11= ruleBackgroundRepeatProperty | this_BackgroundFilterTypeProperty_12= ruleBackgroundFilterTypeProperty | this_BackgroundGravityProperty_13= ruleBackgroundGravityProperty | this_BackgroundFilterProperty_14= ruleBackgroundFilterProperty | this_BorderProperty_15= ruleBorderProperty | this_AlignmentProperty_16= ruleAlignmentProperty ) otherlv_17= ';' ) ;
    public final EObject ruleCSSProperty() throws RecognitionException {
        EObject current = null;

        Token otherlv_17=null;
        EObject this_TransitionProperty_0 = null;

        EObject this_FontFamilyProperty_1 = null;

        EObject this_FontStyleProperty_2 = null;

        EObject this_SizeProperty_3 = null;

        EObject this_ShorthandSizeProperty_4 = null;

        EObject this_ShorthandColorProperty_5 = null;

        EObject this_BorderRadiusProperty_6 = null;

        EObject this_ViewSizeProperty_7 = null;

        EObject this_PaintProperty_8 = null;

        EObject this_ColorProperty_9 = null;

        EObject this_DrawableProperty_10 = null;

        EObject this_BackgroundRepeatProperty_11 = null;

        EObject this_BackgroundFilterTypeProperty_12 = null;

        EObject this_BackgroundGravityProperty_13 = null;

        EObject this_BackgroundFilterProperty_14 = null;

        EObject this_BorderProperty_15 = null;

        EObject this_AlignmentProperty_16 = null;


         enterRule(); 
            
        try {
            // InternalLatteCSS.g:486:28: ( ( (this_TransitionProperty_0= ruleTransitionProperty | this_FontFamilyProperty_1= ruleFontFamilyProperty | this_FontStyleProperty_2= ruleFontStyleProperty | this_SizeProperty_3= ruleSizeProperty | this_ShorthandSizeProperty_4= ruleShorthandSizeProperty | this_ShorthandColorProperty_5= ruleShorthandColorProperty | this_BorderRadiusProperty_6= ruleBorderRadiusProperty | this_ViewSizeProperty_7= ruleViewSizeProperty | this_PaintProperty_8= rulePaintProperty | this_ColorProperty_9= ruleColorProperty | this_DrawableProperty_10= ruleDrawableProperty | this_BackgroundRepeatProperty_11= ruleBackgroundRepeatProperty | this_BackgroundFilterTypeProperty_12= ruleBackgroundFilterTypeProperty | this_BackgroundGravityProperty_13= ruleBackgroundGravityProperty | this_BackgroundFilterProperty_14= ruleBackgroundFilterProperty | this_BorderProperty_15= ruleBorderProperty | this_AlignmentProperty_16= ruleAlignmentProperty ) otherlv_17= ';' ) )
            // InternalLatteCSS.g:487:1: ( (this_TransitionProperty_0= ruleTransitionProperty | this_FontFamilyProperty_1= ruleFontFamilyProperty | this_FontStyleProperty_2= ruleFontStyleProperty | this_SizeProperty_3= ruleSizeProperty | this_ShorthandSizeProperty_4= ruleShorthandSizeProperty | this_ShorthandColorProperty_5= ruleShorthandColorProperty | this_BorderRadiusProperty_6= ruleBorderRadiusProperty | this_ViewSizeProperty_7= ruleViewSizeProperty | this_PaintProperty_8= rulePaintProperty | this_ColorProperty_9= ruleColorProperty | this_DrawableProperty_10= ruleDrawableProperty | this_BackgroundRepeatProperty_11= ruleBackgroundRepeatProperty | this_BackgroundFilterTypeProperty_12= ruleBackgroundFilterTypeProperty | this_BackgroundGravityProperty_13= ruleBackgroundGravityProperty | this_BackgroundFilterProperty_14= ruleBackgroundFilterProperty | this_BorderProperty_15= ruleBorderProperty | this_AlignmentProperty_16= ruleAlignmentProperty ) otherlv_17= ';' )
            {
            // InternalLatteCSS.g:487:1: ( (this_TransitionProperty_0= ruleTransitionProperty | this_FontFamilyProperty_1= ruleFontFamilyProperty | this_FontStyleProperty_2= ruleFontStyleProperty | this_SizeProperty_3= ruleSizeProperty | this_ShorthandSizeProperty_4= ruleShorthandSizeProperty | this_ShorthandColorProperty_5= ruleShorthandColorProperty | this_BorderRadiusProperty_6= ruleBorderRadiusProperty | this_ViewSizeProperty_7= ruleViewSizeProperty | this_PaintProperty_8= rulePaintProperty | this_ColorProperty_9= ruleColorProperty | this_DrawableProperty_10= ruleDrawableProperty | this_BackgroundRepeatProperty_11= ruleBackgroundRepeatProperty | this_BackgroundFilterTypeProperty_12= ruleBackgroundFilterTypeProperty | this_BackgroundGravityProperty_13= ruleBackgroundGravityProperty | this_BackgroundFilterProperty_14= ruleBackgroundFilterProperty | this_BorderProperty_15= ruleBorderProperty | this_AlignmentProperty_16= ruleAlignmentProperty ) otherlv_17= ';' )
            // InternalLatteCSS.g:487:2: (this_TransitionProperty_0= ruleTransitionProperty | this_FontFamilyProperty_1= ruleFontFamilyProperty | this_FontStyleProperty_2= ruleFontStyleProperty | this_SizeProperty_3= ruleSizeProperty | this_ShorthandSizeProperty_4= ruleShorthandSizeProperty | this_ShorthandColorProperty_5= ruleShorthandColorProperty | this_BorderRadiusProperty_6= ruleBorderRadiusProperty | this_ViewSizeProperty_7= ruleViewSizeProperty | this_PaintProperty_8= rulePaintProperty | this_ColorProperty_9= ruleColorProperty | this_DrawableProperty_10= ruleDrawableProperty | this_BackgroundRepeatProperty_11= ruleBackgroundRepeatProperty | this_BackgroundFilterTypeProperty_12= ruleBackgroundFilterTypeProperty | this_BackgroundGravityProperty_13= ruleBackgroundGravityProperty | this_BackgroundFilterProperty_14= ruleBackgroundFilterProperty | this_BorderProperty_15= ruleBorderProperty | this_AlignmentProperty_16= ruleAlignmentProperty ) otherlv_17= ';'
            {
            // InternalLatteCSS.g:487:2: (this_TransitionProperty_0= ruleTransitionProperty | this_FontFamilyProperty_1= ruleFontFamilyProperty | this_FontStyleProperty_2= ruleFontStyleProperty | this_SizeProperty_3= ruleSizeProperty | this_ShorthandSizeProperty_4= ruleShorthandSizeProperty | this_ShorthandColorProperty_5= ruleShorthandColorProperty | this_BorderRadiusProperty_6= ruleBorderRadiusProperty | this_ViewSizeProperty_7= ruleViewSizeProperty | this_PaintProperty_8= rulePaintProperty | this_ColorProperty_9= ruleColorProperty | this_DrawableProperty_10= ruleDrawableProperty | this_BackgroundRepeatProperty_11= ruleBackgroundRepeatProperty | this_BackgroundFilterTypeProperty_12= ruleBackgroundFilterTypeProperty | this_BackgroundGravityProperty_13= ruleBackgroundGravityProperty | this_BackgroundFilterProperty_14= ruleBackgroundFilterProperty | this_BorderProperty_15= ruleBorderProperty | this_AlignmentProperty_16= ruleAlignmentProperty )
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
                    // InternalLatteCSS.g:488:5: this_TransitionProperty_0= ruleTransitionProperty
                    {
                     
                            newCompositeNode(grammarAccess.getCSSPropertyAccess().getTransitionPropertyParserRuleCall_0_0()); 
                        
                    pushFollow(FOLLOW_10);
                    this_TransitionProperty_0=ruleTransitionProperty();

                    state._fsp--;

                     
                            current = this_TransitionProperty_0; 
                            afterParserOrEnumRuleCall();
                        

                    }
                    break;
                case 2 :
                    // InternalLatteCSS.g:498:5: this_FontFamilyProperty_1= ruleFontFamilyProperty
                    {
                     
                            newCompositeNode(grammarAccess.getCSSPropertyAccess().getFontFamilyPropertyParserRuleCall_0_1()); 
                        
                    pushFollow(FOLLOW_10);
                    this_FontFamilyProperty_1=ruleFontFamilyProperty();

                    state._fsp--;

                     
                            current = this_FontFamilyProperty_1; 
                            afterParserOrEnumRuleCall();
                        

                    }
                    break;
                case 3 :
                    // InternalLatteCSS.g:508:5: this_FontStyleProperty_2= ruleFontStyleProperty
                    {
                     
                            newCompositeNode(grammarAccess.getCSSPropertyAccess().getFontStylePropertyParserRuleCall_0_2()); 
                        
                    pushFollow(FOLLOW_10);
                    this_FontStyleProperty_2=ruleFontStyleProperty();

                    state._fsp--;

                     
                            current = this_FontStyleProperty_2; 
                            afterParserOrEnumRuleCall();
                        

                    }
                    break;
                case 4 :
                    // InternalLatteCSS.g:518:5: this_SizeProperty_3= ruleSizeProperty
                    {
                     
                            newCompositeNode(grammarAccess.getCSSPropertyAccess().getSizePropertyParserRuleCall_0_3()); 
                        
                    pushFollow(FOLLOW_10);
                    this_SizeProperty_3=ruleSizeProperty();

                    state._fsp--;

                     
                            current = this_SizeProperty_3; 
                            afterParserOrEnumRuleCall();
                        

                    }
                    break;
                case 5 :
                    // InternalLatteCSS.g:528:5: this_ShorthandSizeProperty_4= ruleShorthandSizeProperty
                    {
                     
                            newCompositeNode(grammarAccess.getCSSPropertyAccess().getShorthandSizePropertyParserRuleCall_0_4()); 
                        
                    pushFollow(FOLLOW_10);
                    this_ShorthandSizeProperty_4=ruleShorthandSizeProperty();

                    state._fsp--;

                     
                            current = this_ShorthandSizeProperty_4; 
                            afterParserOrEnumRuleCall();
                        

                    }
                    break;
                case 6 :
                    // InternalLatteCSS.g:538:5: this_ShorthandColorProperty_5= ruleShorthandColorProperty
                    {
                     
                            newCompositeNode(grammarAccess.getCSSPropertyAccess().getShorthandColorPropertyParserRuleCall_0_5()); 
                        
                    pushFollow(FOLLOW_10);
                    this_ShorthandColorProperty_5=ruleShorthandColorProperty();

                    state._fsp--;

                     
                            current = this_ShorthandColorProperty_5; 
                            afterParserOrEnumRuleCall();
                        

                    }
                    break;
                case 7 :
                    // InternalLatteCSS.g:548:5: this_BorderRadiusProperty_6= ruleBorderRadiusProperty
                    {
                     
                            newCompositeNode(grammarAccess.getCSSPropertyAccess().getBorderRadiusPropertyParserRuleCall_0_6()); 
                        
                    pushFollow(FOLLOW_10);
                    this_BorderRadiusProperty_6=ruleBorderRadiusProperty();

                    state._fsp--;

                     
                            current = this_BorderRadiusProperty_6; 
                            afterParserOrEnumRuleCall();
                        

                    }
                    break;
                case 8 :
                    // InternalLatteCSS.g:558:5: this_ViewSizeProperty_7= ruleViewSizeProperty
                    {
                     
                            newCompositeNode(grammarAccess.getCSSPropertyAccess().getViewSizePropertyParserRuleCall_0_7()); 
                        
                    pushFollow(FOLLOW_10);
                    this_ViewSizeProperty_7=ruleViewSizeProperty();

                    state._fsp--;

                     
                            current = this_ViewSizeProperty_7; 
                            afterParserOrEnumRuleCall();
                        

                    }
                    break;
                case 9 :
                    // InternalLatteCSS.g:568:5: this_PaintProperty_8= rulePaintProperty
                    {
                     
                            newCompositeNode(grammarAccess.getCSSPropertyAccess().getPaintPropertyParserRuleCall_0_8()); 
                        
                    pushFollow(FOLLOW_10);
                    this_PaintProperty_8=rulePaintProperty();

                    state._fsp--;

                     
                            current = this_PaintProperty_8; 
                            afterParserOrEnumRuleCall();
                        

                    }
                    break;
                case 10 :
                    // InternalLatteCSS.g:578:5: this_ColorProperty_9= ruleColorProperty
                    {
                     
                            newCompositeNode(grammarAccess.getCSSPropertyAccess().getColorPropertyParserRuleCall_0_9()); 
                        
                    pushFollow(FOLLOW_10);
                    this_ColorProperty_9=ruleColorProperty();

                    state._fsp--;

                     
                            current = this_ColorProperty_9; 
                            afterParserOrEnumRuleCall();
                        

                    }
                    break;
                case 11 :
                    // InternalLatteCSS.g:588:5: this_DrawableProperty_10= ruleDrawableProperty
                    {
                     
                            newCompositeNode(grammarAccess.getCSSPropertyAccess().getDrawablePropertyParserRuleCall_0_10()); 
                        
                    pushFollow(FOLLOW_10);
                    this_DrawableProperty_10=ruleDrawableProperty();

                    state._fsp--;

                     
                            current = this_DrawableProperty_10; 
                            afterParserOrEnumRuleCall();
                        

                    }
                    break;
                case 12 :
                    // InternalLatteCSS.g:598:5: this_BackgroundRepeatProperty_11= ruleBackgroundRepeatProperty
                    {
                     
                            newCompositeNode(grammarAccess.getCSSPropertyAccess().getBackgroundRepeatPropertyParserRuleCall_0_11()); 
                        
                    pushFollow(FOLLOW_10);
                    this_BackgroundRepeatProperty_11=ruleBackgroundRepeatProperty();

                    state._fsp--;

                     
                            current = this_BackgroundRepeatProperty_11; 
                            afterParserOrEnumRuleCall();
                        

                    }
                    break;
                case 13 :
                    // InternalLatteCSS.g:608:5: this_BackgroundFilterTypeProperty_12= ruleBackgroundFilterTypeProperty
                    {
                     
                            newCompositeNode(grammarAccess.getCSSPropertyAccess().getBackgroundFilterTypePropertyParserRuleCall_0_12()); 
                        
                    pushFollow(FOLLOW_10);
                    this_BackgroundFilterTypeProperty_12=ruleBackgroundFilterTypeProperty();

                    state._fsp--;

                     
                            current = this_BackgroundFilterTypeProperty_12; 
                            afterParserOrEnumRuleCall();
                        

                    }
                    break;
                case 14 :
                    // InternalLatteCSS.g:618:5: this_BackgroundGravityProperty_13= ruleBackgroundGravityProperty
                    {
                     
                            newCompositeNode(grammarAccess.getCSSPropertyAccess().getBackgroundGravityPropertyParserRuleCall_0_13()); 
                        
                    pushFollow(FOLLOW_10);
                    this_BackgroundGravityProperty_13=ruleBackgroundGravityProperty();

                    state._fsp--;

                     
                            current = this_BackgroundGravityProperty_13; 
                            afterParserOrEnumRuleCall();
                        

                    }
                    break;
                case 15 :
                    // InternalLatteCSS.g:628:5: this_BackgroundFilterProperty_14= ruleBackgroundFilterProperty
                    {
                     
                            newCompositeNode(grammarAccess.getCSSPropertyAccess().getBackgroundFilterPropertyParserRuleCall_0_14()); 
                        
                    pushFollow(FOLLOW_10);
                    this_BackgroundFilterProperty_14=ruleBackgroundFilterProperty();

                    state._fsp--;

                     
                            current = this_BackgroundFilterProperty_14; 
                            afterParserOrEnumRuleCall();
                        

                    }
                    break;
                case 16 :
                    // InternalLatteCSS.g:638:5: this_BorderProperty_15= ruleBorderProperty
                    {
                     
                            newCompositeNode(grammarAccess.getCSSPropertyAccess().getBorderPropertyParserRuleCall_0_15()); 
                        
                    pushFollow(FOLLOW_10);
                    this_BorderProperty_15=ruleBorderProperty();

                    state._fsp--;

                     
                            current = this_BorderProperty_15; 
                            afterParserOrEnumRuleCall();
                        

                    }
                    break;
                case 17 :
                    // InternalLatteCSS.g:648:5: this_AlignmentProperty_16= ruleAlignmentProperty
                    {
                     
                            newCompositeNode(grammarAccess.getCSSPropertyAccess().getAlignmentPropertyParserRuleCall_0_16()); 
                        
                    pushFollow(FOLLOW_10);
                    this_AlignmentProperty_16=ruleAlignmentProperty();

                    state._fsp--;

                     
                            current = this_AlignmentProperty_16; 
                            afterParserOrEnumRuleCall();
                        

                    }
                    break;

            }

            otherlv_17=(Token)match(input,19,FOLLOW_2); 

                	newLeafNode(otherlv_17, grammarAccess.getCSSPropertyAccess().getSemicolonKeyword_1());
                

            }


            }

             leaveRule(); 
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleCSSProperty"


    // $ANTLR start "entryRuleFontFamilyProperty"
    // InternalLatteCSS.g:668:1: entryRuleFontFamilyProperty returns [EObject current=null] : iv_ruleFontFamilyProperty= ruleFontFamilyProperty EOF ;
    public final EObject entryRuleFontFamilyProperty() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleFontFamilyProperty = null;


        try {
            // InternalLatteCSS.g:669:2: (iv_ruleFontFamilyProperty= ruleFontFamilyProperty EOF )
            // InternalLatteCSS.g:670:2: iv_ruleFontFamilyProperty= ruleFontFamilyProperty EOF
            {
             newCompositeNode(grammarAccess.getFontFamilyPropertyRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleFontFamilyProperty=ruleFontFamilyProperty();

            state._fsp--;

             current =iv_ruleFontFamilyProperty; 
            match(input,EOF,FOLLOW_2); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleFontFamilyProperty"


    // $ANTLR start "ruleFontFamilyProperty"
    // InternalLatteCSS.g:677:1: ruleFontFamilyProperty returns [EObject current=null] : ( ( (lv_property_0_0= 'font-family' ) ) otherlv_1= ':' ( (lv_value_2_0= RULE_STRING ) ) ) ;
    public final EObject ruleFontFamilyProperty() throws RecognitionException {
        EObject current = null;

        Token lv_property_0_0=null;
        Token otherlv_1=null;
        Token lv_value_2_0=null;

         enterRule(); 
            
        try {
            // InternalLatteCSS.g:680:28: ( ( ( (lv_property_0_0= 'font-family' ) ) otherlv_1= ':' ( (lv_value_2_0= RULE_STRING ) ) ) )
            // InternalLatteCSS.g:681:1: ( ( (lv_property_0_0= 'font-family' ) ) otherlv_1= ':' ( (lv_value_2_0= RULE_STRING ) ) )
            {
            // InternalLatteCSS.g:681:1: ( ( (lv_property_0_0= 'font-family' ) ) otherlv_1= ':' ( (lv_value_2_0= RULE_STRING ) ) )
            // InternalLatteCSS.g:681:2: ( (lv_property_0_0= 'font-family' ) ) otherlv_1= ':' ( (lv_value_2_0= RULE_STRING ) )
            {
            // InternalLatteCSS.g:681:2: ( (lv_property_0_0= 'font-family' ) )
            // InternalLatteCSS.g:682:1: (lv_property_0_0= 'font-family' )
            {
            // InternalLatteCSS.g:682:1: (lv_property_0_0= 'font-family' )
            // InternalLatteCSS.g:683:3: lv_property_0_0= 'font-family'
            {
            lv_property_0_0=(Token)match(input,20,FOLLOW_11); 

                    newLeafNode(lv_property_0_0, grammarAccess.getFontFamilyPropertyAccess().getPropertyFontFamilyKeyword_0_0());
                

            	        if (current==null) {
            	            current = createModelElement(grammarAccess.getFontFamilyPropertyRule());
            	        }
                   		setWithLastConsumed(current, "property", lv_property_0_0, "font-family");
            	    

            }


            }

            otherlv_1=(Token)match(input,18,FOLLOW_12); 

                	newLeafNode(otherlv_1, grammarAccess.getFontFamilyPropertyAccess().getColonKeyword_1());
                
            // InternalLatteCSS.g:700:1: ( (lv_value_2_0= RULE_STRING ) )
            // InternalLatteCSS.g:701:1: (lv_value_2_0= RULE_STRING )
            {
            // InternalLatteCSS.g:701:1: (lv_value_2_0= RULE_STRING )
            // InternalLatteCSS.g:702:3: lv_value_2_0= RULE_STRING
            {
            lv_value_2_0=(Token)match(input,RULE_STRING,FOLLOW_2); 

            			newLeafNode(lv_value_2_0, grammarAccess.getFontFamilyPropertyAccess().getValueSTRINGTerminalRuleCall_2_0()); 
            		

            	        if (current==null) {
            	            current = createModelElement(grammarAccess.getFontFamilyPropertyRule());
            	        }
                   		setWithLastConsumed(
                   			current, 
                   			"value",
                    		lv_value_2_0, 
                    		"org.eclipse.xtext.common.Terminals.STRING");
            	    

            }


            }


            }


            }

             leaveRule(); 
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleFontFamilyProperty"


    // $ANTLR start "entryRuleFontStyleProperty"
    // InternalLatteCSS.g:726:1: entryRuleFontStyleProperty returns [EObject current=null] : iv_ruleFontStyleProperty= ruleFontStyleProperty EOF ;
    public final EObject entryRuleFontStyleProperty() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleFontStyleProperty = null;


        try {
            // InternalLatteCSS.g:727:2: (iv_ruleFontStyleProperty= ruleFontStyleProperty EOF )
            // InternalLatteCSS.g:728:2: iv_ruleFontStyleProperty= ruleFontStyleProperty EOF
            {
             newCompositeNode(grammarAccess.getFontStylePropertyRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleFontStyleProperty=ruleFontStyleProperty();

            state._fsp--;

             current =iv_ruleFontStyleProperty; 
            match(input,EOF,FOLLOW_2); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleFontStyleProperty"


    // $ANTLR start "ruleFontStyleProperty"
    // InternalLatteCSS.g:735:1: ruleFontStyleProperty returns [EObject current=null] : ( ( (lv_property_0_0= 'font-style' ) ) otherlv_1= ':' ( ( (lv_value_2_1= 'normal' | lv_value_2_2= 'bold' | lv_value_2_3= 'bold-italic' ) ) ) ) ;
    public final EObject ruleFontStyleProperty() throws RecognitionException {
        EObject current = null;

        Token lv_property_0_0=null;
        Token otherlv_1=null;
        Token lv_value_2_1=null;
        Token lv_value_2_2=null;
        Token lv_value_2_3=null;

         enterRule(); 
            
        try {
            // InternalLatteCSS.g:738:28: ( ( ( (lv_property_0_0= 'font-style' ) ) otherlv_1= ':' ( ( (lv_value_2_1= 'normal' | lv_value_2_2= 'bold' | lv_value_2_3= 'bold-italic' ) ) ) ) )
            // InternalLatteCSS.g:739:1: ( ( (lv_property_0_0= 'font-style' ) ) otherlv_1= ':' ( ( (lv_value_2_1= 'normal' | lv_value_2_2= 'bold' | lv_value_2_3= 'bold-italic' ) ) ) )
            {
            // InternalLatteCSS.g:739:1: ( ( (lv_property_0_0= 'font-style' ) ) otherlv_1= ':' ( ( (lv_value_2_1= 'normal' | lv_value_2_2= 'bold' | lv_value_2_3= 'bold-italic' ) ) ) )
            // InternalLatteCSS.g:739:2: ( (lv_property_0_0= 'font-style' ) ) otherlv_1= ':' ( ( (lv_value_2_1= 'normal' | lv_value_2_2= 'bold' | lv_value_2_3= 'bold-italic' ) ) )
            {
            // InternalLatteCSS.g:739:2: ( (lv_property_0_0= 'font-style' ) )
            // InternalLatteCSS.g:740:1: (lv_property_0_0= 'font-style' )
            {
            // InternalLatteCSS.g:740:1: (lv_property_0_0= 'font-style' )
            // InternalLatteCSS.g:741:3: lv_property_0_0= 'font-style'
            {
            lv_property_0_0=(Token)match(input,21,FOLLOW_11); 

                    newLeafNode(lv_property_0_0, grammarAccess.getFontStylePropertyAccess().getPropertyFontStyleKeyword_0_0());
                

            	        if (current==null) {
            	            current = createModelElement(grammarAccess.getFontStylePropertyRule());
            	        }
                   		setWithLastConsumed(current, "property", lv_property_0_0, "font-style");
            	    

            }


            }

            otherlv_1=(Token)match(input,18,FOLLOW_13); 

                	newLeafNode(otherlv_1, grammarAccess.getFontStylePropertyAccess().getColonKeyword_1());
                
            // InternalLatteCSS.g:758:1: ( ( (lv_value_2_1= 'normal' | lv_value_2_2= 'bold' | lv_value_2_3= 'bold-italic' ) ) )
            // InternalLatteCSS.g:759:1: ( (lv_value_2_1= 'normal' | lv_value_2_2= 'bold' | lv_value_2_3= 'bold-italic' ) )
            {
            // InternalLatteCSS.g:759:1: ( (lv_value_2_1= 'normal' | lv_value_2_2= 'bold' | lv_value_2_3= 'bold-italic' ) )
            // InternalLatteCSS.g:760:1: (lv_value_2_1= 'normal' | lv_value_2_2= 'bold' | lv_value_2_3= 'bold-italic' )
            {
            // InternalLatteCSS.g:760:1: (lv_value_2_1= 'normal' | lv_value_2_2= 'bold' | lv_value_2_3= 'bold-italic' )
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
                    // InternalLatteCSS.g:761:3: lv_value_2_1= 'normal'
                    {
                    lv_value_2_1=(Token)match(input,22,FOLLOW_2); 

                            newLeafNode(lv_value_2_1, grammarAccess.getFontStylePropertyAccess().getValueNormalKeyword_2_0_0());
                        

                    	        if (current==null) {
                    	            current = createModelElement(grammarAccess.getFontStylePropertyRule());
                    	        }
                           		setWithLastConsumed(current, "value", lv_value_2_1, null);
                    	    

                    }
                    break;
                case 2 :
                    // InternalLatteCSS.g:773:8: lv_value_2_2= 'bold'
                    {
                    lv_value_2_2=(Token)match(input,23,FOLLOW_2); 

                            newLeafNode(lv_value_2_2, grammarAccess.getFontStylePropertyAccess().getValueBoldKeyword_2_0_1());
                        

                    	        if (current==null) {
                    	            current = createModelElement(grammarAccess.getFontStylePropertyRule());
                    	        }
                           		setWithLastConsumed(current, "value", lv_value_2_2, null);
                    	    

                    }
                    break;
                case 3 :
                    // InternalLatteCSS.g:785:8: lv_value_2_3= 'bold-italic'
                    {
                    lv_value_2_3=(Token)match(input,24,FOLLOW_2); 

                            newLeafNode(lv_value_2_3, grammarAccess.getFontStylePropertyAccess().getValueBoldItalicKeyword_2_0_2());
                        

                    	        if (current==null) {
                    	            current = createModelElement(grammarAccess.getFontStylePropertyRule());
                    	        }
                           		setWithLastConsumed(current, "value", lv_value_2_3, null);
                    	    

                    }
                    break;

            }


            }


            }


            }


            }

             leaveRule(); 
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleFontStyleProperty"


    // $ANTLR start "entryRuleViewSizeProperty"
    // InternalLatteCSS.g:808:1: entryRuleViewSizeProperty returns [EObject current=null] : iv_ruleViewSizeProperty= ruleViewSizeProperty EOF ;
    public final EObject entryRuleViewSizeProperty() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleViewSizeProperty = null;


        try {
            // InternalLatteCSS.g:809:2: (iv_ruleViewSizeProperty= ruleViewSizeProperty EOF )
            // InternalLatteCSS.g:810:2: iv_ruleViewSizeProperty= ruleViewSizeProperty EOF
            {
             newCompositeNode(grammarAccess.getViewSizePropertyRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleViewSizeProperty=ruleViewSizeProperty();

            state._fsp--;

             current =iv_ruleViewSizeProperty; 
            match(input,EOF,FOLLOW_2); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleViewSizeProperty"


    // $ANTLR start "ruleViewSizeProperty"
    // InternalLatteCSS.g:817:1: ruleViewSizeProperty returns [EObject current=null] : ( ( ( (lv_property_0_1= 'width' | lv_property_0_2= 'height' ) ) ) otherlv_1= ':' ( (lv_value_2_0= ruleViewSizeValue ) ) ) ;
    public final EObject ruleViewSizeProperty() throws RecognitionException {
        EObject current = null;

        Token lv_property_0_1=null;
        Token lv_property_0_2=null;
        Token otherlv_1=null;
        EObject lv_value_2_0 = null;


         enterRule(); 
            
        try {
            // InternalLatteCSS.g:820:28: ( ( ( ( (lv_property_0_1= 'width' | lv_property_0_2= 'height' ) ) ) otherlv_1= ':' ( (lv_value_2_0= ruleViewSizeValue ) ) ) )
            // InternalLatteCSS.g:821:1: ( ( ( (lv_property_0_1= 'width' | lv_property_0_2= 'height' ) ) ) otherlv_1= ':' ( (lv_value_2_0= ruleViewSizeValue ) ) )
            {
            // InternalLatteCSS.g:821:1: ( ( ( (lv_property_0_1= 'width' | lv_property_0_2= 'height' ) ) ) otherlv_1= ':' ( (lv_value_2_0= ruleViewSizeValue ) ) )
            // InternalLatteCSS.g:821:2: ( ( (lv_property_0_1= 'width' | lv_property_0_2= 'height' ) ) ) otherlv_1= ':' ( (lv_value_2_0= ruleViewSizeValue ) )
            {
            // InternalLatteCSS.g:821:2: ( ( (lv_property_0_1= 'width' | lv_property_0_2= 'height' ) ) )
            // InternalLatteCSS.g:822:1: ( (lv_property_0_1= 'width' | lv_property_0_2= 'height' ) )
            {
            // InternalLatteCSS.g:822:1: ( (lv_property_0_1= 'width' | lv_property_0_2= 'height' ) )
            // InternalLatteCSS.g:823:1: (lv_property_0_1= 'width' | lv_property_0_2= 'height' )
            {
            // InternalLatteCSS.g:823:1: (lv_property_0_1= 'width' | lv_property_0_2= 'height' )
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
                    // InternalLatteCSS.g:824:3: lv_property_0_1= 'width'
                    {
                    lv_property_0_1=(Token)match(input,25,FOLLOW_11); 

                            newLeafNode(lv_property_0_1, grammarAccess.getViewSizePropertyAccess().getPropertyWidthKeyword_0_0_0());
                        

                    	        if (current==null) {
                    	            current = createModelElement(grammarAccess.getViewSizePropertyRule());
                    	        }
                           		setWithLastConsumed(current, "property", lv_property_0_1, null);
                    	    

                    }
                    break;
                case 2 :
                    // InternalLatteCSS.g:836:8: lv_property_0_2= 'height'
                    {
                    lv_property_0_2=(Token)match(input,26,FOLLOW_11); 

                            newLeafNode(lv_property_0_2, grammarAccess.getViewSizePropertyAccess().getPropertyHeightKeyword_0_0_1());
                        

                    	        if (current==null) {
                    	            current = createModelElement(grammarAccess.getViewSizePropertyRule());
                    	        }
                           		setWithLastConsumed(current, "property", lv_property_0_2, null);
                    	    

                    }
                    break;

            }


            }


            }

            otherlv_1=(Token)match(input,18,FOLLOW_14); 

                	newLeafNode(otherlv_1, grammarAccess.getViewSizePropertyAccess().getColonKeyword_1());
                
            // InternalLatteCSS.g:855:1: ( (lv_value_2_0= ruleViewSizeValue ) )
            // InternalLatteCSS.g:856:1: (lv_value_2_0= ruleViewSizeValue )
            {
            // InternalLatteCSS.g:856:1: (lv_value_2_0= ruleViewSizeValue )
            // InternalLatteCSS.g:857:3: lv_value_2_0= ruleViewSizeValue
            {
             
            	        newCompositeNode(grammarAccess.getViewSizePropertyAccess().getValueViewSizeValueParserRuleCall_2_0()); 
            	    
            pushFollow(FOLLOW_2);
            lv_value_2_0=ruleViewSizeValue();

            state._fsp--;


            	        if (current==null) {
            	            current = createModelElementForParent(grammarAccess.getViewSizePropertyRule());
            	        }
                   		set(
                   			current, 
                   			"value",
                    		lv_value_2_0, 
                    		"io.lattekit.dsl.LatteCSS.ViewSizeValue");
            	        afterParserOrEnumRuleCall();
            	    

            }


            }


            }


            }

             leaveRule(); 
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleViewSizeProperty"


    // $ANTLR start "entryRuleShorthandSizeProperty"
    // InternalLatteCSS.g:881:1: entryRuleShorthandSizeProperty returns [EObject current=null] : iv_ruleShorthandSizeProperty= ruleShorthandSizeProperty EOF ;
    public final EObject entryRuleShorthandSizeProperty() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleShorthandSizeProperty = null;


        try {
            // InternalLatteCSS.g:882:2: (iv_ruleShorthandSizeProperty= ruleShorthandSizeProperty EOF )
            // InternalLatteCSS.g:883:2: iv_ruleShorthandSizeProperty= ruleShorthandSizeProperty EOF
            {
             newCompositeNode(grammarAccess.getShorthandSizePropertyRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleShorthandSizeProperty=ruleShorthandSizeProperty();

            state._fsp--;

             current =iv_ruleShorthandSizeProperty; 
            match(input,EOF,FOLLOW_2); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleShorthandSizeProperty"


    // $ANTLR start "ruleShorthandSizeProperty"
    // InternalLatteCSS.g:890:1: ruleShorthandSizeProperty returns [EObject current=null] : ( ( ( (lv_property_0_1= 'border-width' | lv_property_0_2= 'border-radius' | lv_property_0_3= 'margin' | lv_property_0_4= 'padding' ) ) ) otherlv_1= ':' ( (lv_values_2_0= ruleSizeValue ) )+ ) ;
    public final EObject ruleShorthandSizeProperty() throws RecognitionException {
        EObject current = null;

        Token lv_property_0_1=null;
        Token lv_property_0_2=null;
        Token lv_property_0_3=null;
        Token lv_property_0_4=null;
        Token otherlv_1=null;
        EObject lv_values_2_0 = null;


         enterRule(); 
            
        try {
            // InternalLatteCSS.g:893:28: ( ( ( ( (lv_property_0_1= 'border-width' | lv_property_0_2= 'border-radius' | lv_property_0_3= 'margin' | lv_property_0_4= 'padding' ) ) ) otherlv_1= ':' ( (lv_values_2_0= ruleSizeValue ) )+ ) )
            // InternalLatteCSS.g:894:1: ( ( ( (lv_property_0_1= 'border-width' | lv_property_0_2= 'border-radius' | lv_property_0_3= 'margin' | lv_property_0_4= 'padding' ) ) ) otherlv_1= ':' ( (lv_values_2_0= ruleSizeValue ) )+ )
            {
            // InternalLatteCSS.g:894:1: ( ( ( (lv_property_0_1= 'border-width' | lv_property_0_2= 'border-radius' | lv_property_0_3= 'margin' | lv_property_0_4= 'padding' ) ) ) otherlv_1= ':' ( (lv_values_2_0= ruleSizeValue ) )+ )
            // InternalLatteCSS.g:894:2: ( ( (lv_property_0_1= 'border-width' | lv_property_0_2= 'border-radius' | lv_property_0_3= 'margin' | lv_property_0_4= 'padding' ) ) ) otherlv_1= ':' ( (lv_values_2_0= ruleSizeValue ) )+
            {
            // InternalLatteCSS.g:894:2: ( ( (lv_property_0_1= 'border-width' | lv_property_0_2= 'border-radius' | lv_property_0_3= 'margin' | lv_property_0_4= 'padding' ) ) )
            // InternalLatteCSS.g:895:1: ( (lv_property_0_1= 'border-width' | lv_property_0_2= 'border-radius' | lv_property_0_3= 'margin' | lv_property_0_4= 'padding' ) )
            {
            // InternalLatteCSS.g:895:1: ( (lv_property_0_1= 'border-width' | lv_property_0_2= 'border-radius' | lv_property_0_3= 'margin' | lv_property_0_4= 'padding' ) )
            // InternalLatteCSS.g:896:1: (lv_property_0_1= 'border-width' | lv_property_0_2= 'border-radius' | lv_property_0_3= 'margin' | lv_property_0_4= 'padding' )
            {
            // InternalLatteCSS.g:896:1: (lv_property_0_1= 'border-width' | lv_property_0_2= 'border-radius' | lv_property_0_3= 'margin' | lv_property_0_4= 'padding' )
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
                    // InternalLatteCSS.g:897:3: lv_property_0_1= 'border-width'
                    {
                    lv_property_0_1=(Token)match(input,27,FOLLOW_11); 

                            newLeafNode(lv_property_0_1, grammarAccess.getShorthandSizePropertyAccess().getPropertyBorderWidthKeyword_0_0_0());
                        

                    	        if (current==null) {
                    	            current = createModelElement(grammarAccess.getShorthandSizePropertyRule());
                    	        }
                           		setWithLastConsumed(current, "property", lv_property_0_1, null);
                    	    

                    }
                    break;
                case 2 :
                    // InternalLatteCSS.g:909:8: lv_property_0_2= 'border-radius'
                    {
                    lv_property_0_2=(Token)match(input,28,FOLLOW_11); 

                            newLeafNode(lv_property_0_2, grammarAccess.getShorthandSizePropertyAccess().getPropertyBorderRadiusKeyword_0_0_1());
                        

                    	        if (current==null) {
                    	            current = createModelElement(grammarAccess.getShorthandSizePropertyRule());
                    	        }
                           		setWithLastConsumed(current, "property", lv_property_0_2, null);
                    	    

                    }
                    break;
                case 3 :
                    // InternalLatteCSS.g:921:8: lv_property_0_3= 'margin'
                    {
                    lv_property_0_3=(Token)match(input,29,FOLLOW_11); 

                            newLeafNode(lv_property_0_3, grammarAccess.getShorthandSizePropertyAccess().getPropertyMarginKeyword_0_0_2());
                        

                    	        if (current==null) {
                    	            current = createModelElement(grammarAccess.getShorthandSizePropertyRule());
                    	        }
                           		setWithLastConsumed(current, "property", lv_property_0_3, null);
                    	    

                    }
                    break;
                case 4 :
                    // InternalLatteCSS.g:933:8: lv_property_0_4= 'padding'
                    {
                    lv_property_0_4=(Token)match(input,30,FOLLOW_11); 

                            newLeafNode(lv_property_0_4, grammarAccess.getShorthandSizePropertyAccess().getPropertyPaddingKeyword_0_0_3());
                        

                    	        if (current==null) {
                    	            current = createModelElement(grammarAccess.getShorthandSizePropertyRule());
                    	        }
                           		setWithLastConsumed(current, "property", lv_property_0_4, null);
                    	    

                    }
                    break;

            }


            }


            }

            otherlv_1=(Token)match(input,18,FOLLOW_15); 

                	newLeafNode(otherlv_1, grammarAccess.getShorthandSizePropertyAccess().getColonKeyword_1());
                
            // InternalLatteCSS.g:952:1: ( (lv_values_2_0= ruleSizeValue ) )+
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
            	    // InternalLatteCSS.g:953:1: (lv_values_2_0= ruleSizeValue )
            	    {
            	    // InternalLatteCSS.g:953:1: (lv_values_2_0= ruleSizeValue )
            	    // InternalLatteCSS.g:954:3: lv_values_2_0= ruleSizeValue
            	    {
            	     
            	    	        newCompositeNode(grammarAccess.getShorthandSizePropertyAccess().getValuesSizeValueParserRuleCall_2_0()); 
            	    	    
            	    pushFollow(FOLLOW_16);
            	    lv_values_2_0=ruleSizeValue();

            	    state._fsp--;


            	    	        if (current==null) {
            	    	            current = createModelElementForParent(grammarAccess.getShorthandSizePropertyRule());
            	    	        }
            	           		add(
            	           			current, 
            	           			"values",
            	            		lv_values_2_0, 
            	            		"io.lattekit.dsl.LatteCSS.SizeValue");
            	    	        afterParserOrEnumRuleCall();
            	    	    

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

             leaveRule(); 
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleShorthandSizeProperty"


    // $ANTLR start "entryRuleBorderRadiusProperty"
    // InternalLatteCSS.g:978:1: entryRuleBorderRadiusProperty returns [EObject current=null] : iv_ruleBorderRadiusProperty= ruleBorderRadiusProperty EOF ;
    public final EObject entryRuleBorderRadiusProperty() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleBorderRadiusProperty = null;


        try {
            // InternalLatteCSS.g:979:2: (iv_ruleBorderRadiusProperty= ruleBorderRadiusProperty EOF )
            // InternalLatteCSS.g:980:2: iv_ruleBorderRadiusProperty= ruleBorderRadiusProperty EOF
            {
             newCompositeNode(grammarAccess.getBorderRadiusPropertyRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleBorderRadiusProperty=ruleBorderRadiusProperty();

            state._fsp--;

             current =iv_ruleBorderRadiusProperty; 
            match(input,EOF,FOLLOW_2); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleBorderRadiusProperty"


    // $ANTLR start "ruleBorderRadiusProperty"
    // InternalLatteCSS.g:987:1: ruleBorderRadiusProperty returns [EObject current=null] : ( ( ( (lv_property_0_1= 'border-top-left-radius' | lv_property_0_2= 'border-top-right-radius' | lv_property_0_3= 'border-bottom-left-radius' | lv_property_0_4= 'border-bottom-right-radius' ) ) ) otherlv_1= ':' ( (lv_values_2_0= ruleSizeValue ) )+ ) ;
    public final EObject ruleBorderRadiusProperty() throws RecognitionException {
        EObject current = null;

        Token lv_property_0_1=null;
        Token lv_property_0_2=null;
        Token lv_property_0_3=null;
        Token lv_property_0_4=null;
        Token otherlv_1=null;
        EObject lv_values_2_0 = null;


         enterRule(); 
            
        try {
            // InternalLatteCSS.g:990:28: ( ( ( ( (lv_property_0_1= 'border-top-left-radius' | lv_property_0_2= 'border-top-right-radius' | lv_property_0_3= 'border-bottom-left-radius' | lv_property_0_4= 'border-bottom-right-radius' ) ) ) otherlv_1= ':' ( (lv_values_2_0= ruleSizeValue ) )+ ) )
            // InternalLatteCSS.g:991:1: ( ( ( (lv_property_0_1= 'border-top-left-radius' | lv_property_0_2= 'border-top-right-radius' | lv_property_0_3= 'border-bottom-left-radius' | lv_property_0_4= 'border-bottom-right-radius' ) ) ) otherlv_1= ':' ( (lv_values_2_0= ruleSizeValue ) )+ )
            {
            // InternalLatteCSS.g:991:1: ( ( ( (lv_property_0_1= 'border-top-left-radius' | lv_property_0_2= 'border-top-right-radius' | lv_property_0_3= 'border-bottom-left-radius' | lv_property_0_4= 'border-bottom-right-radius' ) ) ) otherlv_1= ':' ( (lv_values_2_0= ruleSizeValue ) )+ )
            // InternalLatteCSS.g:991:2: ( ( (lv_property_0_1= 'border-top-left-radius' | lv_property_0_2= 'border-top-right-radius' | lv_property_0_3= 'border-bottom-left-radius' | lv_property_0_4= 'border-bottom-right-radius' ) ) ) otherlv_1= ':' ( (lv_values_2_0= ruleSizeValue ) )+
            {
            // InternalLatteCSS.g:991:2: ( ( (lv_property_0_1= 'border-top-left-radius' | lv_property_0_2= 'border-top-right-radius' | lv_property_0_3= 'border-bottom-left-radius' | lv_property_0_4= 'border-bottom-right-radius' ) ) )
            // InternalLatteCSS.g:992:1: ( (lv_property_0_1= 'border-top-left-radius' | lv_property_0_2= 'border-top-right-radius' | lv_property_0_3= 'border-bottom-left-radius' | lv_property_0_4= 'border-bottom-right-radius' ) )
            {
            // InternalLatteCSS.g:992:1: ( (lv_property_0_1= 'border-top-left-radius' | lv_property_0_2= 'border-top-right-radius' | lv_property_0_3= 'border-bottom-left-radius' | lv_property_0_4= 'border-bottom-right-radius' ) )
            // InternalLatteCSS.g:993:1: (lv_property_0_1= 'border-top-left-radius' | lv_property_0_2= 'border-top-right-radius' | lv_property_0_3= 'border-bottom-left-radius' | lv_property_0_4= 'border-bottom-right-radius' )
            {
            // InternalLatteCSS.g:993:1: (lv_property_0_1= 'border-top-left-radius' | lv_property_0_2= 'border-top-right-radius' | lv_property_0_3= 'border-bottom-left-radius' | lv_property_0_4= 'border-bottom-right-radius' )
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
                    // InternalLatteCSS.g:994:3: lv_property_0_1= 'border-top-left-radius'
                    {
                    lv_property_0_1=(Token)match(input,31,FOLLOW_11); 

                            newLeafNode(lv_property_0_1, grammarAccess.getBorderRadiusPropertyAccess().getPropertyBorderTopLeftRadiusKeyword_0_0_0());
                        

                    	        if (current==null) {
                    	            current = createModelElement(grammarAccess.getBorderRadiusPropertyRule());
                    	        }
                           		setWithLastConsumed(current, "property", lv_property_0_1, null);
                    	    

                    }
                    break;
                case 2 :
                    // InternalLatteCSS.g:1006:8: lv_property_0_2= 'border-top-right-radius'
                    {
                    lv_property_0_2=(Token)match(input,32,FOLLOW_11); 

                            newLeafNode(lv_property_0_2, grammarAccess.getBorderRadiusPropertyAccess().getPropertyBorderTopRightRadiusKeyword_0_0_1());
                        

                    	        if (current==null) {
                    	            current = createModelElement(grammarAccess.getBorderRadiusPropertyRule());
                    	        }
                           		setWithLastConsumed(current, "property", lv_property_0_2, null);
                    	    

                    }
                    break;
                case 3 :
                    // InternalLatteCSS.g:1018:8: lv_property_0_3= 'border-bottom-left-radius'
                    {
                    lv_property_0_3=(Token)match(input,33,FOLLOW_11); 

                            newLeafNode(lv_property_0_3, grammarAccess.getBorderRadiusPropertyAccess().getPropertyBorderBottomLeftRadiusKeyword_0_0_2());
                        

                    	        if (current==null) {
                    	            current = createModelElement(grammarAccess.getBorderRadiusPropertyRule());
                    	        }
                           		setWithLastConsumed(current, "property", lv_property_0_3, null);
                    	    

                    }
                    break;
                case 4 :
                    // InternalLatteCSS.g:1030:8: lv_property_0_4= 'border-bottom-right-radius'
                    {
                    lv_property_0_4=(Token)match(input,34,FOLLOW_11); 

                            newLeafNode(lv_property_0_4, grammarAccess.getBorderRadiusPropertyAccess().getPropertyBorderBottomRightRadiusKeyword_0_0_3());
                        

                    	        if (current==null) {
                    	            current = createModelElement(grammarAccess.getBorderRadiusPropertyRule());
                    	        }
                           		setWithLastConsumed(current, "property", lv_property_0_4, null);
                    	    

                    }
                    break;

            }


            }


            }

            otherlv_1=(Token)match(input,18,FOLLOW_15); 

                	newLeafNode(otherlv_1, grammarAccess.getBorderRadiusPropertyAccess().getColonKeyword_1());
                
            // InternalLatteCSS.g:1049:1: ( (lv_values_2_0= ruleSizeValue ) )+
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
            	    // InternalLatteCSS.g:1050:1: (lv_values_2_0= ruleSizeValue )
            	    {
            	    // InternalLatteCSS.g:1050:1: (lv_values_2_0= ruleSizeValue )
            	    // InternalLatteCSS.g:1051:3: lv_values_2_0= ruleSizeValue
            	    {
            	     
            	    	        newCompositeNode(grammarAccess.getBorderRadiusPropertyAccess().getValuesSizeValueParserRuleCall_2_0()); 
            	    	    
            	    pushFollow(FOLLOW_16);
            	    lv_values_2_0=ruleSizeValue();

            	    state._fsp--;


            	    	        if (current==null) {
            	    	            current = createModelElementForParent(grammarAccess.getBorderRadiusPropertyRule());
            	    	        }
            	           		add(
            	           			current, 
            	           			"values",
            	            		lv_values_2_0, 
            	            		"io.lattekit.dsl.LatteCSS.SizeValue");
            	    	        afterParserOrEnumRuleCall();
            	    	    

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

             leaveRule(); 
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleBorderRadiusProperty"


    // $ANTLR start "entryRuleSizeProperty"
    // InternalLatteCSS.g:1075:1: entryRuleSizeProperty returns [EObject current=null] : iv_ruleSizeProperty= ruleSizeProperty EOF ;
    public final EObject entryRuleSizeProperty() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleSizeProperty = null;


        try {
            // InternalLatteCSS.g:1076:2: (iv_ruleSizeProperty= ruleSizeProperty EOF )
            // InternalLatteCSS.g:1077:2: iv_ruleSizeProperty= ruleSizeProperty EOF
            {
             newCompositeNode(grammarAccess.getSizePropertyRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleSizeProperty=ruleSizeProperty();

            state._fsp--;

             current =iv_ruleSizeProperty; 
            match(input,EOF,FOLLOW_2); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleSizeProperty"


    // $ANTLR start "ruleSizeProperty"
    // InternalLatteCSS.g:1084:1: ruleSizeProperty returns [EObject current=null] : ( ( ( (lv_property_0_1= 'border-left-width' | lv_property_0_2= 'border-right-width' | lv_property_0_3= 'border-top-width' | lv_property_0_4= 'border-bottom-width' | lv_property_0_5= 'font-size' | lv_property_0_6= 'translate-x' | lv_property_0_7= 'translate-y' | lv_property_0_8= 'margin-left' | lv_property_0_9= 'margin-right' | lv_property_0_10= 'margin-top' | lv_property_0_11= 'margin-bottom' | lv_property_0_12= 'padding-left' | lv_property_0_13= 'padding-right' | lv_property_0_14= 'padding-top' | lv_property_0_15= 'padding-bottom' | lv_property_0_16= 'x' | lv_property_0_17= 'y' | lv_property_0_18= 'elevation' ) ) ) otherlv_1= ':' ( (lv_value_2_0= ruleSizeValue ) ) ) ;
    public final EObject ruleSizeProperty() throws RecognitionException {
        EObject current = null;

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
        EObject lv_value_2_0 = null;


         enterRule(); 
            
        try {
            // InternalLatteCSS.g:1087:28: ( ( ( ( (lv_property_0_1= 'border-left-width' | lv_property_0_2= 'border-right-width' | lv_property_0_3= 'border-top-width' | lv_property_0_4= 'border-bottom-width' | lv_property_0_5= 'font-size' | lv_property_0_6= 'translate-x' | lv_property_0_7= 'translate-y' | lv_property_0_8= 'margin-left' | lv_property_0_9= 'margin-right' | lv_property_0_10= 'margin-top' | lv_property_0_11= 'margin-bottom' | lv_property_0_12= 'padding-left' | lv_property_0_13= 'padding-right' | lv_property_0_14= 'padding-top' | lv_property_0_15= 'padding-bottom' | lv_property_0_16= 'x' | lv_property_0_17= 'y' | lv_property_0_18= 'elevation' ) ) ) otherlv_1= ':' ( (lv_value_2_0= ruleSizeValue ) ) ) )
            // InternalLatteCSS.g:1088:1: ( ( ( (lv_property_0_1= 'border-left-width' | lv_property_0_2= 'border-right-width' | lv_property_0_3= 'border-top-width' | lv_property_0_4= 'border-bottom-width' | lv_property_0_5= 'font-size' | lv_property_0_6= 'translate-x' | lv_property_0_7= 'translate-y' | lv_property_0_8= 'margin-left' | lv_property_0_9= 'margin-right' | lv_property_0_10= 'margin-top' | lv_property_0_11= 'margin-bottom' | lv_property_0_12= 'padding-left' | lv_property_0_13= 'padding-right' | lv_property_0_14= 'padding-top' | lv_property_0_15= 'padding-bottom' | lv_property_0_16= 'x' | lv_property_0_17= 'y' | lv_property_0_18= 'elevation' ) ) ) otherlv_1= ':' ( (lv_value_2_0= ruleSizeValue ) ) )
            {
            // InternalLatteCSS.g:1088:1: ( ( ( (lv_property_0_1= 'border-left-width' | lv_property_0_2= 'border-right-width' | lv_property_0_3= 'border-top-width' | lv_property_0_4= 'border-bottom-width' | lv_property_0_5= 'font-size' | lv_property_0_6= 'translate-x' | lv_property_0_7= 'translate-y' | lv_property_0_8= 'margin-left' | lv_property_0_9= 'margin-right' | lv_property_0_10= 'margin-top' | lv_property_0_11= 'margin-bottom' | lv_property_0_12= 'padding-left' | lv_property_0_13= 'padding-right' | lv_property_0_14= 'padding-top' | lv_property_0_15= 'padding-bottom' | lv_property_0_16= 'x' | lv_property_0_17= 'y' | lv_property_0_18= 'elevation' ) ) ) otherlv_1= ':' ( (lv_value_2_0= ruleSizeValue ) ) )
            // InternalLatteCSS.g:1088:2: ( ( (lv_property_0_1= 'border-left-width' | lv_property_0_2= 'border-right-width' | lv_property_0_3= 'border-top-width' | lv_property_0_4= 'border-bottom-width' | lv_property_0_5= 'font-size' | lv_property_0_6= 'translate-x' | lv_property_0_7= 'translate-y' | lv_property_0_8= 'margin-left' | lv_property_0_9= 'margin-right' | lv_property_0_10= 'margin-top' | lv_property_0_11= 'margin-bottom' | lv_property_0_12= 'padding-left' | lv_property_0_13= 'padding-right' | lv_property_0_14= 'padding-top' | lv_property_0_15= 'padding-bottom' | lv_property_0_16= 'x' | lv_property_0_17= 'y' | lv_property_0_18= 'elevation' ) ) ) otherlv_1= ':' ( (lv_value_2_0= ruleSizeValue ) )
            {
            // InternalLatteCSS.g:1088:2: ( ( (lv_property_0_1= 'border-left-width' | lv_property_0_2= 'border-right-width' | lv_property_0_3= 'border-top-width' | lv_property_0_4= 'border-bottom-width' | lv_property_0_5= 'font-size' | lv_property_0_6= 'translate-x' | lv_property_0_7= 'translate-y' | lv_property_0_8= 'margin-left' | lv_property_0_9= 'margin-right' | lv_property_0_10= 'margin-top' | lv_property_0_11= 'margin-bottom' | lv_property_0_12= 'padding-left' | lv_property_0_13= 'padding-right' | lv_property_0_14= 'padding-top' | lv_property_0_15= 'padding-bottom' | lv_property_0_16= 'x' | lv_property_0_17= 'y' | lv_property_0_18= 'elevation' ) ) )
            // InternalLatteCSS.g:1089:1: ( (lv_property_0_1= 'border-left-width' | lv_property_0_2= 'border-right-width' | lv_property_0_3= 'border-top-width' | lv_property_0_4= 'border-bottom-width' | lv_property_0_5= 'font-size' | lv_property_0_6= 'translate-x' | lv_property_0_7= 'translate-y' | lv_property_0_8= 'margin-left' | lv_property_0_9= 'margin-right' | lv_property_0_10= 'margin-top' | lv_property_0_11= 'margin-bottom' | lv_property_0_12= 'padding-left' | lv_property_0_13= 'padding-right' | lv_property_0_14= 'padding-top' | lv_property_0_15= 'padding-bottom' | lv_property_0_16= 'x' | lv_property_0_17= 'y' | lv_property_0_18= 'elevation' ) )
            {
            // InternalLatteCSS.g:1089:1: ( (lv_property_0_1= 'border-left-width' | lv_property_0_2= 'border-right-width' | lv_property_0_3= 'border-top-width' | lv_property_0_4= 'border-bottom-width' | lv_property_0_5= 'font-size' | lv_property_0_6= 'translate-x' | lv_property_0_7= 'translate-y' | lv_property_0_8= 'margin-left' | lv_property_0_9= 'margin-right' | lv_property_0_10= 'margin-top' | lv_property_0_11= 'margin-bottom' | lv_property_0_12= 'padding-left' | lv_property_0_13= 'padding-right' | lv_property_0_14= 'padding-top' | lv_property_0_15= 'padding-bottom' | lv_property_0_16= 'x' | lv_property_0_17= 'y' | lv_property_0_18= 'elevation' ) )
            // InternalLatteCSS.g:1090:1: (lv_property_0_1= 'border-left-width' | lv_property_0_2= 'border-right-width' | lv_property_0_3= 'border-top-width' | lv_property_0_4= 'border-bottom-width' | lv_property_0_5= 'font-size' | lv_property_0_6= 'translate-x' | lv_property_0_7= 'translate-y' | lv_property_0_8= 'margin-left' | lv_property_0_9= 'margin-right' | lv_property_0_10= 'margin-top' | lv_property_0_11= 'margin-bottom' | lv_property_0_12= 'padding-left' | lv_property_0_13= 'padding-right' | lv_property_0_14= 'padding-top' | lv_property_0_15= 'padding-bottom' | lv_property_0_16= 'x' | lv_property_0_17= 'y' | lv_property_0_18= 'elevation' )
            {
            // InternalLatteCSS.g:1090:1: (lv_property_0_1= 'border-left-width' | lv_property_0_2= 'border-right-width' | lv_property_0_3= 'border-top-width' | lv_property_0_4= 'border-bottom-width' | lv_property_0_5= 'font-size' | lv_property_0_6= 'translate-x' | lv_property_0_7= 'translate-y' | lv_property_0_8= 'margin-left' | lv_property_0_9= 'margin-right' | lv_property_0_10= 'margin-top' | lv_property_0_11= 'margin-bottom' | lv_property_0_12= 'padding-left' | lv_property_0_13= 'padding-right' | lv_property_0_14= 'padding-top' | lv_property_0_15= 'padding-bottom' | lv_property_0_16= 'x' | lv_property_0_17= 'y' | lv_property_0_18= 'elevation' )
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
                    // InternalLatteCSS.g:1091:3: lv_property_0_1= 'border-left-width'
                    {
                    lv_property_0_1=(Token)match(input,35,FOLLOW_11); 

                            newLeafNode(lv_property_0_1, grammarAccess.getSizePropertyAccess().getPropertyBorderLeftWidthKeyword_0_0_0());
                        

                    	        if (current==null) {
                    	            current = createModelElement(grammarAccess.getSizePropertyRule());
                    	        }
                           		setWithLastConsumed(current, "property", lv_property_0_1, null);
                    	    

                    }
                    break;
                case 2 :
                    // InternalLatteCSS.g:1103:8: lv_property_0_2= 'border-right-width'
                    {
                    lv_property_0_2=(Token)match(input,36,FOLLOW_11); 

                            newLeafNode(lv_property_0_2, grammarAccess.getSizePropertyAccess().getPropertyBorderRightWidthKeyword_0_0_1());
                        

                    	        if (current==null) {
                    	            current = createModelElement(grammarAccess.getSizePropertyRule());
                    	        }
                           		setWithLastConsumed(current, "property", lv_property_0_2, null);
                    	    

                    }
                    break;
                case 3 :
                    // InternalLatteCSS.g:1115:8: lv_property_0_3= 'border-top-width'
                    {
                    lv_property_0_3=(Token)match(input,37,FOLLOW_11); 

                            newLeafNode(lv_property_0_3, grammarAccess.getSizePropertyAccess().getPropertyBorderTopWidthKeyword_0_0_2());
                        

                    	        if (current==null) {
                    	            current = createModelElement(grammarAccess.getSizePropertyRule());
                    	        }
                           		setWithLastConsumed(current, "property", lv_property_0_3, null);
                    	    

                    }
                    break;
                case 4 :
                    // InternalLatteCSS.g:1127:8: lv_property_0_4= 'border-bottom-width'
                    {
                    lv_property_0_4=(Token)match(input,38,FOLLOW_11); 

                            newLeafNode(lv_property_0_4, grammarAccess.getSizePropertyAccess().getPropertyBorderBottomWidthKeyword_0_0_3());
                        

                    	        if (current==null) {
                    	            current = createModelElement(grammarAccess.getSizePropertyRule());
                    	        }
                           		setWithLastConsumed(current, "property", lv_property_0_4, null);
                    	    

                    }
                    break;
                case 5 :
                    // InternalLatteCSS.g:1139:8: lv_property_0_5= 'font-size'
                    {
                    lv_property_0_5=(Token)match(input,39,FOLLOW_11); 

                            newLeafNode(lv_property_0_5, grammarAccess.getSizePropertyAccess().getPropertyFontSizeKeyword_0_0_4());
                        

                    	        if (current==null) {
                    	            current = createModelElement(grammarAccess.getSizePropertyRule());
                    	        }
                           		setWithLastConsumed(current, "property", lv_property_0_5, null);
                    	    

                    }
                    break;
                case 6 :
                    // InternalLatteCSS.g:1151:8: lv_property_0_6= 'translate-x'
                    {
                    lv_property_0_6=(Token)match(input,40,FOLLOW_11); 

                            newLeafNode(lv_property_0_6, grammarAccess.getSizePropertyAccess().getPropertyTranslateXKeyword_0_0_5());
                        

                    	        if (current==null) {
                    	            current = createModelElement(grammarAccess.getSizePropertyRule());
                    	        }
                           		setWithLastConsumed(current, "property", lv_property_0_6, null);
                    	    

                    }
                    break;
                case 7 :
                    // InternalLatteCSS.g:1163:8: lv_property_0_7= 'translate-y'
                    {
                    lv_property_0_7=(Token)match(input,41,FOLLOW_11); 

                            newLeafNode(lv_property_0_7, grammarAccess.getSizePropertyAccess().getPropertyTranslateYKeyword_0_0_6());
                        

                    	        if (current==null) {
                    	            current = createModelElement(grammarAccess.getSizePropertyRule());
                    	        }
                           		setWithLastConsumed(current, "property", lv_property_0_7, null);
                    	    

                    }
                    break;
                case 8 :
                    // InternalLatteCSS.g:1175:8: lv_property_0_8= 'margin-left'
                    {
                    lv_property_0_8=(Token)match(input,42,FOLLOW_11); 

                            newLeafNode(lv_property_0_8, grammarAccess.getSizePropertyAccess().getPropertyMarginLeftKeyword_0_0_7());
                        

                    	        if (current==null) {
                    	            current = createModelElement(grammarAccess.getSizePropertyRule());
                    	        }
                           		setWithLastConsumed(current, "property", lv_property_0_8, null);
                    	    

                    }
                    break;
                case 9 :
                    // InternalLatteCSS.g:1187:8: lv_property_0_9= 'margin-right'
                    {
                    lv_property_0_9=(Token)match(input,43,FOLLOW_11); 

                            newLeafNode(lv_property_0_9, grammarAccess.getSizePropertyAccess().getPropertyMarginRightKeyword_0_0_8());
                        

                    	        if (current==null) {
                    	            current = createModelElement(grammarAccess.getSizePropertyRule());
                    	        }
                           		setWithLastConsumed(current, "property", lv_property_0_9, null);
                    	    

                    }
                    break;
                case 10 :
                    // InternalLatteCSS.g:1199:8: lv_property_0_10= 'margin-top'
                    {
                    lv_property_0_10=(Token)match(input,44,FOLLOW_11); 

                            newLeafNode(lv_property_0_10, grammarAccess.getSizePropertyAccess().getPropertyMarginTopKeyword_0_0_9());
                        

                    	        if (current==null) {
                    	            current = createModelElement(grammarAccess.getSizePropertyRule());
                    	        }
                           		setWithLastConsumed(current, "property", lv_property_0_10, null);
                    	    

                    }
                    break;
                case 11 :
                    // InternalLatteCSS.g:1211:8: lv_property_0_11= 'margin-bottom'
                    {
                    lv_property_0_11=(Token)match(input,45,FOLLOW_11); 

                            newLeafNode(lv_property_0_11, grammarAccess.getSizePropertyAccess().getPropertyMarginBottomKeyword_0_0_10());
                        

                    	        if (current==null) {
                    	            current = createModelElement(grammarAccess.getSizePropertyRule());
                    	        }
                           		setWithLastConsumed(current, "property", lv_property_0_11, null);
                    	    

                    }
                    break;
                case 12 :
                    // InternalLatteCSS.g:1223:8: lv_property_0_12= 'padding-left'
                    {
                    lv_property_0_12=(Token)match(input,46,FOLLOW_11); 

                            newLeafNode(lv_property_0_12, grammarAccess.getSizePropertyAccess().getPropertyPaddingLeftKeyword_0_0_11());
                        

                    	        if (current==null) {
                    	            current = createModelElement(grammarAccess.getSizePropertyRule());
                    	        }
                           		setWithLastConsumed(current, "property", lv_property_0_12, null);
                    	    

                    }
                    break;
                case 13 :
                    // InternalLatteCSS.g:1235:8: lv_property_0_13= 'padding-right'
                    {
                    lv_property_0_13=(Token)match(input,47,FOLLOW_11); 

                            newLeafNode(lv_property_0_13, grammarAccess.getSizePropertyAccess().getPropertyPaddingRightKeyword_0_0_12());
                        

                    	        if (current==null) {
                    	            current = createModelElement(grammarAccess.getSizePropertyRule());
                    	        }
                           		setWithLastConsumed(current, "property", lv_property_0_13, null);
                    	    

                    }
                    break;
                case 14 :
                    // InternalLatteCSS.g:1247:8: lv_property_0_14= 'padding-top'
                    {
                    lv_property_0_14=(Token)match(input,48,FOLLOW_11); 

                            newLeafNode(lv_property_0_14, grammarAccess.getSizePropertyAccess().getPropertyPaddingTopKeyword_0_0_13());
                        

                    	        if (current==null) {
                    	            current = createModelElement(grammarAccess.getSizePropertyRule());
                    	        }
                           		setWithLastConsumed(current, "property", lv_property_0_14, null);
                    	    

                    }
                    break;
                case 15 :
                    // InternalLatteCSS.g:1259:8: lv_property_0_15= 'padding-bottom'
                    {
                    lv_property_0_15=(Token)match(input,49,FOLLOW_11); 

                            newLeafNode(lv_property_0_15, grammarAccess.getSizePropertyAccess().getPropertyPaddingBottomKeyword_0_0_14());
                        

                    	        if (current==null) {
                    	            current = createModelElement(grammarAccess.getSizePropertyRule());
                    	        }
                           		setWithLastConsumed(current, "property", lv_property_0_15, null);
                    	    

                    }
                    break;
                case 16 :
                    // InternalLatteCSS.g:1271:8: lv_property_0_16= 'x'
                    {
                    lv_property_0_16=(Token)match(input,50,FOLLOW_11); 

                            newLeafNode(lv_property_0_16, grammarAccess.getSizePropertyAccess().getPropertyXKeyword_0_0_15());
                        

                    	        if (current==null) {
                    	            current = createModelElement(grammarAccess.getSizePropertyRule());
                    	        }
                           		setWithLastConsumed(current, "property", lv_property_0_16, null);
                    	    

                    }
                    break;
                case 17 :
                    // InternalLatteCSS.g:1283:8: lv_property_0_17= 'y'
                    {
                    lv_property_0_17=(Token)match(input,51,FOLLOW_11); 

                            newLeafNode(lv_property_0_17, grammarAccess.getSizePropertyAccess().getPropertyYKeyword_0_0_16());
                        

                    	        if (current==null) {
                    	            current = createModelElement(grammarAccess.getSizePropertyRule());
                    	        }
                           		setWithLastConsumed(current, "property", lv_property_0_17, null);
                    	    

                    }
                    break;
                case 18 :
                    // InternalLatteCSS.g:1295:8: lv_property_0_18= 'elevation'
                    {
                    lv_property_0_18=(Token)match(input,52,FOLLOW_11); 

                            newLeafNode(lv_property_0_18, grammarAccess.getSizePropertyAccess().getPropertyElevationKeyword_0_0_17());
                        

                    	        if (current==null) {
                    	            current = createModelElement(grammarAccess.getSizePropertyRule());
                    	        }
                           		setWithLastConsumed(current, "property", lv_property_0_18, null);
                    	    

                    }
                    break;

            }


            }


            }

            otherlv_1=(Token)match(input,18,FOLLOW_15); 

                	newLeafNode(otherlv_1, grammarAccess.getSizePropertyAccess().getColonKeyword_1());
                
            // InternalLatteCSS.g:1314:1: ( (lv_value_2_0= ruleSizeValue ) )
            // InternalLatteCSS.g:1315:1: (lv_value_2_0= ruleSizeValue )
            {
            // InternalLatteCSS.g:1315:1: (lv_value_2_0= ruleSizeValue )
            // InternalLatteCSS.g:1316:3: lv_value_2_0= ruleSizeValue
            {
             
            	        newCompositeNode(grammarAccess.getSizePropertyAccess().getValueSizeValueParserRuleCall_2_0()); 
            	    
            pushFollow(FOLLOW_2);
            lv_value_2_0=ruleSizeValue();

            state._fsp--;


            	        if (current==null) {
            	            current = createModelElementForParent(grammarAccess.getSizePropertyRule());
            	        }
                   		set(
                   			current, 
                   			"value",
                    		lv_value_2_0, 
                    		"io.lattekit.dsl.LatteCSS.SizeValue");
            	        afterParserOrEnumRuleCall();
            	    

            }


            }


            }


            }

             leaveRule(); 
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleSizeProperty"


    // $ANTLR start "entryRulePaintProperty"
    // InternalLatteCSS.g:1340:1: entryRulePaintProperty returns [EObject current=null] : iv_rulePaintProperty= rulePaintProperty EOF ;
    public final EObject entryRulePaintProperty() throws RecognitionException {
        EObject current = null;

        EObject iv_rulePaintProperty = null;


        try {
            // InternalLatteCSS.g:1341:2: (iv_rulePaintProperty= rulePaintProperty EOF )
            // InternalLatteCSS.g:1342:2: iv_rulePaintProperty= rulePaintProperty EOF
            {
             newCompositeNode(grammarAccess.getPaintPropertyRule()); 
            pushFollow(FOLLOW_1);
            iv_rulePaintProperty=rulePaintProperty();

            state._fsp--;

             current =iv_rulePaintProperty; 
            match(input,EOF,FOLLOW_2); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRulePaintProperty"


    // $ANTLR start "rulePaintProperty"
    // InternalLatteCSS.g:1349:1: rulePaintProperty returns [EObject current=null] : ( ( (lv_property_0_0= 'background' ) ) otherlv_1= ':' ( (lv_value_2_0= rulePaintValue ) ) ) ;
    public final EObject rulePaintProperty() throws RecognitionException {
        EObject current = null;

        Token lv_property_0_0=null;
        Token otherlv_1=null;
        EObject lv_value_2_0 = null;


         enterRule(); 
            
        try {
            // InternalLatteCSS.g:1352:28: ( ( ( (lv_property_0_0= 'background' ) ) otherlv_1= ':' ( (lv_value_2_0= rulePaintValue ) ) ) )
            // InternalLatteCSS.g:1353:1: ( ( (lv_property_0_0= 'background' ) ) otherlv_1= ':' ( (lv_value_2_0= rulePaintValue ) ) )
            {
            // InternalLatteCSS.g:1353:1: ( ( (lv_property_0_0= 'background' ) ) otherlv_1= ':' ( (lv_value_2_0= rulePaintValue ) ) )
            // InternalLatteCSS.g:1353:2: ( (lv_property_0_0= 'background' ) ) otherlv_1= ':' ( (lv_value_2_0= rulePaintValue ) )
            {
            // InternalLatteCSS.g:1353:2: ( (lv_property_0_0= 'background' ) )
            // InternalLatteCSS.g:1354:1: (lv_property_0_0= 'background' )
            {
            // InternalLatteCSS.g:1354:1: (lv_property_0_0= 'background' )
            // InternalLatteCSS.g:1355:3: lv_property_0_0= 'background'
            {
            lv_property_0_0=(Token)match(input,53,FOLLOW_11); 

                    newLeafNode(lv_property_0_0, grammarAccess.getPaintPropertyAccess().getPropertyBackgroundKeyword_0_0());
                

            	        if (current==null) {
            	            current = createModelElement(grammarAccess.getPaintPropertyRule());
            	        }
                   		setWithLastConsumed(current, "property", lv_property_0_0, "background");
            	    

            }


            }

            otherlv_1=(Token)match(input,18,FOLLOW_17); 

                	newLeafNode(otherlv_1, grammarAccess.getPaintPropertyAccess().getColonKeyword_1());
                
            // InternalLatteCSS.g:1372:1: ( (lv_value_2_0= rulePaintValue ) )
            // InternalLatteCSS.g:1373:1: (lv_value_2_0= rulePaintValue )
            {
            // InternalLatteCSS.g:1373:1: (lv_value_2_0= rulePaintValue )
            // InternalLatteCSS.g:1374:3: lv_value_2_0= rulePaintValue
            {
             
            	        newCompositeNode(grammarAccess.getPaintPropertyAccess().getValuePaintValueParserRuleCall_2_0()); 
            	    
            pushFollow(FOLLOW_2);
            lv_value_2_0=rulePaintValue();

            state._fsp--;


            	        if (current==null) {
            	            current = createModelElementForParent(grammarAccess.getPaintPropertyRule());
            	        }
                   		set(
                   			current, 
                   			"value",
                    		lv_value_2_0, 
                    		"io.lattekit.dsl.LatteCSS.PaintValue");
            	        afterParserOrEnumRuleCall();
            	    

            }


            }


            }


            }

             leaveRule(); 
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "rulePaintProperty"


    // $ANTLR start "entryRuleTransitionProperty"
    // InternalLatteCSS.g:1398:1: entryRuleTransitionProperty returns [EObject current=null] : iv_ruleTransitionProperty= ruleTransitionProperty EOF ;
    public final EObject entryRuleTransitionProperty() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleTransitionProperty = null;


        try {
            // InternalLatteCSS.g:1399:2: (iv_ruleTransitionProperty= ruleTransitionProperty EOF )
            // InternalLatteCSS.g:1400:2: iv_ruleTransitionProperty= ruleTransitionProperty EOF
            {
             newCompositeNode(grammarAccess.getTransitionPropertyRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleTransitionProperty=ruleTransitionProperty();

            state._fsp--;

             current =iv_ruleTransitionProperty; 
            match(input,EOF,FOLLOW_2); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleTransitionProperty"


    // $ANTLR start "ruleTransitionProperty"
    // InternalLatteCSS.g:1407:1: ruleTransitionProperty returns [EObject current=null] : ( ( (lv_property_0_0= 'transition' ) ) otherlv_1= ':' ( (lv_transitions_2_0= ruleTransitionValue ) ) (otherlv_3= ',' ( (lv_transitions_4_0= ruleTransitionValue ) ) )* ) ;
    public final EObject ruleTransitionProperty() throws RecognitionException {
        EObject current = null;

        Token lv_property_0_0=null;
        Token otherlv_1=null;
        Token otherlv_3=null;
        EObject lv_transitions_2_0 = null;

        EObject lv_transitions_4_0 = null;


         enterRule(); 
            
        try {
            // InternalLatteCSS.g:1410:28: ( ( ( (lv_property_0_0= 'transition' ) ) otherlv_1= ':' ( (lv_transitions_2_0= ruleTransitionValue ) ) (otherlv_3= ',' ( (lv_transitions_4_0= ruleTransitionValue ) ) )* ) )
            // InternalLatteCSS.g:1411:1: ( ( (lv_property_0_0= 'transition' ) ) otherlv_1= ':' ( (lv_transitions_2_0= ruleTransitionValue ) ) (otherlv_3= ',' ( (lv_transitions_4_0= ruleTransitionValue ) ) )* )
            {
            // InternalLatteCSS.g:1411:1: ( ( (lv_property_0_0= 'transition' ) ) otherlv_1= ':' ( (lv_transitions_2_0= ruleTransitionValue ) ) (otherlv_3= ',' ( (lv_transitions_4_0= ruleTransitionValue ) ) )* )
            // InternalLatteCSS.g:1411:2: ( (lv_property_0_0= 'transition' ) ) otherlv_1= ':' ( (lv_transitions_2_0= ruleTransitionValue ) ) (otherlv_3= ',' ( (lv_transitions_4_0= ruleTransitionValue ) ) )*
            {
            // InternalLatteCSS.g:1411:2: ( (lv_property_0_0= 'transition' ) )
            // InternalLatteCSS.g:1412:1: (lv_property_0_0= 'transition' )
            {
            // InternalLatteCSS.g:1412:1: (lv_property_0_0= 'transition' )
            // InternalLatteCSS.g:1413:3: lv_property_0_0= 'transition'
            {
            lv_property_0_0=(Token)match(input,54,FOLLOW_11); 

                    newLeafNode(lv_property_0_0, grammarAccess.getTransitionPropertyAccess().getPropertyTransitionKeyword_0_0());
                

            	        if (current==null) {
            	            current = createModelElement(grammarAccess.getTransitionPropertyRule());
            	        }
                   		setWithLastConsumed(current, "property", lv_property_0_0, "transition");
            	    

            }


            }

            otherlv_1=(Token)match(input,18,FOLLOW_18); 

                	newLeafNode(otherlv_1, grammarAccess.getTransitionPropertyAccess().getColonKeyword_1());
                
            // InternalLatteCSS.g:1430:1: ( (lv_transitions_2_0= ruleTransitionValue ) )
            // InternalLatteCSS.g:1431:1: (lv_transitions_2_0= ruleTransitionValue )
            {
            // InternalLatteCSS.g:1431:1: (lv_transitions_2_0= ruleTransitionValue )
            // InternalLatteCSS.g:1432:3: lv_transitions_2_0= ruleTransitionValue
            {
             
            	        newCompositeNode(grammarAccess.getTransitionPropertyAccess().getTransitionsTransitionValueParserRuleCall_2_0()); 
            	    
            pushFollow(FOLLOW_19);
            lv_transitions_2_0=ruleTransitionValue();

            state._fsp--;


            	        if (current==null) {
            	            current = createModelElementForParent(grammarAccess.getTransitionPropertyRule());
            	        }
                   		add(
                   			current, 
                   			"transitions",
                    		lv_transitions_2_0, 
                    		"io.lattekit.dsl.LatteCSS.TransitionValue");
            	        afterParserOrEnumRuleCall();
            	    

            }


            }

            // InternalLatteCSS.g:1448:2: (otherlv_3= ',' ( (lv_transitions_4_0= ruleTransitionValue ) ) )*
            loop16:
            do {
                int alt16=2;
                int LA16_0 = input.LA(1);

                if ( (LA16_0==13) ) {
                    alt16=1;
                }


                switch (alt16) {
            	case 1 :
            	    // InternalLatteCSS.g:1448:4: otherlv_3= ',' ( (lv_transitions_4_0= ruleTransitionValue ) )
            	    {
            	    otherlv_3=(Token)match(input,13,FOLLOW_18); 

            	        	newLeafNode(otherlv_3, grammarAccess.getTransitionPropertyAccess().getCommaKeyword_3_0());
            	        
            	    // InternalLatteCSS.g:1452:1: ( (lv_transitions_4_0= ruleTransitionValue ) )
            	    // InternalLatteCSS.g:1453:1: (lv_transitions_4_0= ruleTransitionValue )
            	    {
            	    // InternalLatteCSS.g:1453:1: (lv_transitions_4_0= ruleTransitionValue )
            	    // InternalLatteCSS.g:1454:3: lv_transitions_4_0= ruleTransitionValue
            	    {
            	     
            	    	        newCompositeNode(grammarAccess.getTransitionPropertyAccess().getTransitionsTransitionValueParserRuleCall_3_1_0()); 
            	    	    
            	    pushFollow(FOLLOW_19);
            	    lv_transitions_4_0=ruleTransitionValue();

            	    state._fsp--;


            	    	        if (current==null) {
            	    	            current = createModelElementForParent(grammarAccess.getTransitionPropertyRule());
            	    	        }
            	           		add(
            	           			current, 
            	           			"transitions",
            	            		lv_transitions_4_0, 
            	            		"io.lattekit.dsl.LatteCSS.TransitionValue");
            	    	        afterParserOrEnumRuleCall();
            	    	    

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

             leaveRule(); 
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleTransitionProperty"


    // $ANTLR start "entryRuleTransitionValue"
    // InternalLatteCSS.g:1478:1: entryRuleTransitionValue returns [EObject current=null] : iv_ruleTransitionValue= ruleTransitionValue EOF ;
    public final EObject entryRuleTransitionValue() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleTransitionValue = null;


        try {
            // InternalLatteCSS.g:1479:2: (iv_ruleTransitionValue= ruleTransitionValue EOF )
            // InternalLatteCSS.g:1480:2: iv_ruleTransitionValue= ruleTransitionValue EOF
            {
             newCompositeNode(grammarAccess.getTransitionValueRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleTransitionValue=ruleTransitionValue();

            state._fsp--;

             current =iv_ruleTransitionValue; 
            match(input,EOF,FOLLOW_2); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleTransitionValue"


    // $ANTLR start "ruleTransitionValue"
    // InternalLatteCSS.g:1487:1: ruleTransitionValue returns [EObject current=null] : ( ( (lv_propertyName_0_0= rulePropertyNameValue ) ) ( (lv_duration_1_0= ruleTimeValue ) ) ( (lv_timingFunction_2_0= ruleTimingFunction ) )? ( (lv_delay_3_0= ruleTimeValue ) )? ) ;
    public final EObject ruleTransitionValue() throws RecognitionException {
        EObject current = null;

        AntlrDatatypeRuleToken lv_propertyName_0_0 = null;

        EObject lv_duration_1_0 = null;

        AntlrDatatypeRuleToken lv_timingFunction_2_0 = null;

        EObject lv_delay_3_0 = null;


         enterRule(); 
            
        try {
            // InternalLatteCSS.g:1490:28: ( ( ( (lv_propertyName_0_0= rulePropertyNameValue ) ) ( (lv_duration_1_0= ruleTimeValue ) ) ( (lv_timingFunction_2_0= ruleTimingFunction ) )? ( (lv_delay_3_0= ruleTimeValue ) )? ) )
            // InternalLatteCSS.g:1491:1: ( ( (lv_propertyName_0_0= rulePropertyNameValue ) ) ( (lv_duration_1_0= ruleTimeValue ) ) ( (lv_timingFunction_2_0= ruleTimingFunction ) )? ( (lv_delay_3_0= ruleTimeValue ) )? )
            {
            // InternalLatteCSS.g:1491:1: ( ( (lv_propertyName_0_0= rulePropertyNameValue ) ) ( (lv_duration_1_0= ruleTimeValue ) ) ( (lv_timingFunction_2_0= ruleTimingFunction ) )? ( (lv_delay_3_0= ruleTimeValue ) )? )
            // InternalLatteCSS.g:1491:2: ( (lv_propertyName_0_0= rulePropertyNameValue ) ) ( (lv_duration_1_0= ruleTimeValue ) ) ( (lv_timingFunction_2_0= ruleTimingFunction ) )? ( (lv_delay_3_0= ruleTimeValue ) )?
            {
            // InternalLatteCSS.g:1491:2: ( (lv_propertyName_0_0= rulePropertyNameValue ) )
            // InternalLatteCSS.g:1492:1: (lv_propertyName_0_0= rulePropertyNameValue )
            {
            // InternalLatteCSS.g:1492:1: (lv_propertyName_0_0= rulePropertyNameValue )
            // InternalLatteCSS.g:1493:3: lv_propertyName_0_0= rulePropertyNameValue
            {
             
            	        newCompositeNode(grammarAccess.getTransitionValueAccess().getPropertyNamePropertyNameValueParserRuleCall_0_0()); 
            	    
            pushFollow(FOLLOW_15);
            lv_propertyName_0_0=rulePropertyNameValue();

            state._fsp--;


            	        if (current==null) {
            	            current = createModelElementForParent(grammarAccess.getTransitionValueRule());
            	        }
                   		set(
                   			current, 
                   			"propertyName",
                    		lv_propertyName_0_0, 
                    		"io.lattekit.dsl.LatteCSS.PropertyNameValue");
            	        afterParserOrEnumRuleCall();
            	    

            }


            }

            // InternalLatteCSS.g:1509:2: ( (lv_duration_1_0= ruleTimeValue ) )
            // InternalLatteCSS.g:1510:1: (lv_duration_1_0= ruleTimeValue )
            {
            // InternalLatteCSS.g:1510:1: (lv_duration_1_0= ruleTimeValue )
            // InternalLatteCSS.g:1511:3: lv_duration_1_0= ruleTimeValue
            {
             
            	        newCompositeNode(grammarAccess.getTransitionValueAccess().getDurationTimeValueParserRuleCall_1_0()); 
            	    
            pushFollow(FOLLOW_20);
            lv_duration_1_0=ruleTimeValue();

            state._fsp--;


            	        if (current==null) {
            	            current = createModelElementForParent(grammarAccess.getTransitionValueRule());
            	        }
                   		set(
                   			current, 
                   			"duration",
                    		lv_duration_1_0, 
                    		"io.lattekit.dsl.LatteCSS.TimeValue");
            	        afterParserOrEnumRuleCall();
            	    

            }


            }

            // InternalLatteCSS.g:1527:2: ( (lv_timingFunction_2_0= ruleTimingFunction ) )?
            int alt17=2;
            int LA17_0 = input.LA(1);

            if ( ((LA17_0>=119 && LA17_0<=130)) ) {
                alt17=1;
            }
            switch (alt17) {
                case 1 :
                    // InternalLatteCSS.g:1528:1: (lv_timingFunction_2_0= ruleTimingFunction )
                    {
                    // InternalLatteCSS.g:1528:1: (lv_timingFunction_2_0= ruleTimingFunction )
                    // InternalLatteCSS.g:1529:3: lv_timingFunction_2_0= ruleTimingFunction
                    {
                     
                    	        newCompositeNode(grammarAccess.getTransitionValueAccess().getTimingFunctionTimingFunctionParserRuleCall_2_0()); 
                    	    
                    pushFollow(FOLLOW_16);
                    lv_timingFunction_2_0=ruleTimingFunction();

                    state._fsp--;


                    	        if (current==null) {
                    	            current = createModelElementForParent(grammarAccess.getTransitionValueRule());
                    	        }
                           		set(
                           			current, 
                           			"timingFunction",
                            		lv_timingFunction_2_0, 
                            		"io.lattekit.dsl.LatteCSS.TimingFunction");
                    	        afterParserOrEnumRuleCall();
                    	    

                    }


                    }
                    break;

            }

            // InternalLatteCSS.g:1545:3: ( (lv_delay_3_0= ruleTimeValue ) )?
            int alt18=2;
            int LA18_0 = input.LA(1);

            if ( ((LA18_0>=RULE_INT && LA18_0<=RULE_REAL)) ) {
                alt18=1;
            }
            switch (alt18) {
                case 1 :
                    // InternalLatteCSS.g:1546:1: (lv_delay_3_0= ruleTimeValue )
                    {
                    // InternalLatteCSS.g:1546:1: (lv_delay_3_0= ruleTimeValue )
                    // InternalLatteCSS.g:1547:3: lv_delay_3_0= ruleTimeValue
                    {
                     
                    	        newCompositeNode(grammarAccess.getTransitionValueAccess().getDelayTimeValueParserRuleCall_3_0()); 
                    	    
                    pushFollow(FOLLOW_2);
                    lv_delay_3_0=ruleTimeValue();

                    state._fsp--;


                    	        if (current==null) {
                    	            current = createModelElementForParent(grammarAccess.getTransitionValueRule());
                    	        }
                           		set(
                           			current, 
                           			"delay",
                            		lv_delay_3_0, 
                            		"io.lattekit.dsl.LatteCSS.TimeValue");
                    	        afterParserOrEnumRuleCall();
                    	    

                    }


                    }
                    break;

            }


            }


            }

             leaveRule(); 
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleTransitionValue"


    // $ANTLR start "entryRuleDrawableProperty"
    // InternalLatteCSS.g:1571:1: entryRuleDrawableProperty returns [EObject current=null] : iv_ruleDrawableProperty= ruleDrawableProperty EOF ;
    public final EObject entryRuleDrawableProperty() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleDrawableProperty = null;


        try {
            // InternalLatteCSS.g:1572:2: (iv_ruleDrawableProperty= ruleDrawableProperty EOF )
            // InternalLatteCSS.g:1573:2: iv_ruleDrawableProperty= ruleDrawableProperty EOF
            {
             newCompositeNode(grammarAccess.getDrawablePropertyRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleDrawableProperty=ruleDrawableProperty();

            state._fsp--;

             current =iv_ruleDrawableProperty; 
            match(input,EOF,FOLLOW_2); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleDrawableProperty"


    // $ANTLR start "ruleDrawableProperty"
    // InternalLatteCSS.g:1580:1: ruleDrawableProperty returns [EObject current=null] : ( ( (lv_property_0_0= 'background-drawable' ) ) otherlv_1= ':' ( (lv_value_2_0= RULE_STRING ) ) ) ;
    public final EObject ruleDrawableProperty() throws RecognitionException {
        EObject current = null;

        Token lv_property_0_0=null;
        Token otherlv_1=null;
        Token lv_value_2_0=null;

         enterRule(); 
            
        try {
            // InternalLatteCSS.g:1583:28: ( ( ( (lv_property_0_0= 'background-drawable' ) ) otherlv_1= ':' ( (lv_value_2_0= RULE_STRING ) ) ) )
            // InternalLatteCSS.g:1584:1: ( ( (lv_property_0_0= 'background-drawable' ) ) otherlv_1= ':' ( (lv_value_2_0= RULE_STRING ) ) )
            {
            // InternalLatteCSS.g:1584:1: ( ( (lv_property_0_0= 'background-drawable' ) ) otherlv_1= ':' ( (lv_value_2_0= RULE_STRING ) ) )
            // InternalLatteCSS.g:1584:2: ( (lv_property_0_0= 'background-drawable' ) ) otherlv_1= ':' ( (lv_value_2_0= RULE_STRING ) )
            {
            // InternalLatteCSS.g:1584:2: ( (lv_property_0_0= 'background-drawable' ) )
            // InternalLatteCSS.g:1585:1: (lv_property_0_0= 'background-drawable' )
            {
            // InternalLatteCSS.g:1585:1: (lv_property_0_0= 'background-drawable' )
            // InternalLatteCSS.g:1586:3: lv_property_0_0= 'background-drawable'
            {
            lv_property_0_0=(Token)match(input,55,FOLLOW_11); 

                    newLeafNode(lv_property_0_0, grammarAccess.getDrawablePropertyAccess().getPropertyBackgroundDrawableKeyword_0_0());
                

            	        if (current==null) {
            	            current = createModelElement(grammarAccess.getDrawablePropertyRule());
            	        }
                   		setWithLastConsumed(current, "property", lv_property_0_0, "background-drawable");
            	    

            }


            }

            otherlv_1=(Token)match(input,18,FOLLOW_12); 

                	newLeafNode(otherlv_1, grammarAccess.getDrawablePropertyAccess().getColonKeyword_1());
                
            // InternalLatteCSS.g:1603:1: ( (lv_value_2_0= RULE_STRING ) )
            // InternalLatteCSS.g:1604:1: (lv_value_2_0= RULE_STRING )
            {
            // InternalLatteCSS.g:1604:1: (lv_value_2_0= RULE_STRING )
            // InternalLatteCSS.g:1605:3: lv_value_2_0= RULE_STRING
            {
            lv_value_2_0=(Token)match(input,RULE_STRING,FOLLOW_2); 

            			newLeafNode(lv_value_2_0, grammarAccess.getDrawablePropertyAccess().getValueSTRINGTerminalRuleCall_2_0()); 
            		

            	        if (current==null) {
            	            current = createModelElement(grammarAccess.getDrawablePropertyRule());
            	        }
                   		setWithLastConsumed(
                   			current, 
                   			"value",
                    		lv_value_2_0, 
                    		"org.eclipse.xtext.common.Terminals.STRING");
            	    

            }


            }


            }


            }

             leaveRule(); 
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleDrawableProperty"


    // $ANTLR start "entryRuleBackgroundRepeatProperty"
    // InternalLatteCSS.g:1629:1: entryRuleBackgroundRepeatProperty returns [EObject current=null] : iv_ruleBackgroundRepeatProperty= ruleBackgroundRepeatProperty EOF ;
    public final EObject entryRuleBackgroundRepeatProperty() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleBackgroundRepeatProperty = null;


        try {
            // InternalLatteCSS.g:1630:2: (iv_ruleBackgroundRepeatProperty= ruleBackgroundRepeatProperty EOF )
            // InternalLatteCSS.g:1631:2: iv_ruleBackgroundRepeatProperty= ruleBackgroundRepeatProperty EOF
            {
             newCompositeNode(grammarAccess.getBackgroundRepeatPropertyRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleBackgroundRepeatProperty=ruleBackgroundRepeatProperty();

            state._fsp--;

             current =iv_ruleBackgroundRepeatProperty; 
            match(input,EOF,FOLLOW_2); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleBackgroundRepeatProperty"


    // $ANTLR start "ruleBackgroundRepeatProperty"
    // InternalLatteCSS.g:1638:1: ruleBackgroundRepeatProperty returns [EObject current=null] : ( ( (lv_property_0_0= 'background-repeat' ) ) otherlv_1= ':' ( (lv_values_2_0= ruleRepeatValue ) ) ( (lv_values_3_0= ruleRepeatValue ) )? ) ;
    public final EObject ruleBackgroundRepeatProperty() throws RecognitionException {
        EObject current = null;

        Token lv_property_0_0=null;
        Token otherlv_1=null;
        AntlrDatatypeRuleToken lv_values_2_0 = null;

        AntlrDatatypeRuleToken lv_values_3_0 = null;


         enterRule(); 
            
        try {
            // InternalLatteCSS.g:1641:28: ( ( ( (lv_property_0_0= 'background-repeat' ) ) otherlv_1= ':' ( (lv_values_2_0= ruleRepeatValue ) ) ( (lv_values_3_0= ruleRepeatValue ) )? ) )
            // InternalLatteCSS.g:1642:1: ( ( (lv_property_0_0= 'background-repeat' ) ) otherlv_1= ':' ( (lv_values_2_0= ruleRepeatValue ) ) ( (lv_values_3_0= ruleRepeatValue ) )? )
            {
            // InternalLatteCSS.g:1642:1: ( ( (lv_property_0_0= 'background-repeat' ) ) otherlv_1= ':' ( (lv_values_2_0= ruleRepeatValue ) ) ( (lv_values_3_0= ruleRepeatValue ) )? )
            // InternalLatteCSS.g:1642:2: ( (lv_property_0_0= 'background-repeat' ) ) otherlv_1= ':' ( (lv_values_2_0= ruleRepeatValue ) ) ( (lv_values_3_0= ruleRepeatValue ) )?
            {
            // InternalLatteCSS.g:1642:2: ( (lv_property_0_0= 'background-repeat' ) )
            // InternalLatteCSS.g:1643:1: (lv_property_0_0= 'background-repeat' )
            {
            // InternalLatteCSS.g:1643:1: (lv_property_0_0= 'background-repeat' )
            // InternalLatteCSS.g:1644:3: lv_property_0_0= 'background-repeat'
            {
            lv_property_0_0=(Token)match(input,56,FOLLOW_11); 

                    newLeafNode(lv_property_0_0, grammarAccess.getBackgroundRepeatPropertyAccess().getPropertyBackgroundRepeatKeyword_0_0());
                

            	        if (current==null) {
            	            current = createModelElement(grammarAccess.getBackgroundRepeatPropertyRule());
            	        }
                   		setWithLastConsumed(current, "property", lv_property_0_0, "background-repeat");
            	    

            }


            }

            otherlv_1=(Token)match(input,18,FOLLOW_21); 

                	newLeafNode(otherlv_1, grammarAccess.getBackgroundRepeatPropertyAccess().getColonKeyword_1());
                
            // InternalLatteCSS.g:1661:1: ( (lv_values_2_0= ruleRepeatValue ) )
            // InternalLatteCSS.g:1662:1: (lv_values_2_0= ruleRepeatValue )
            {
            // InternalLatteCSS.g:1662:1: (lv_values_2_0= ruleRepeatValue )
            // InternalLatteCSS.g:1663:3: lv_values_2_0= ruleRepeatValue
            {
             
            	        newCompositeNode(grammarAccess.getBackgroundRepeatPropertyAccess().getValuesRepeatValueParserRuleCall_2_0()); 
            	    
            pushFollow(FOLLOW_22);
            lv_values_2_0=ruleRepeatValue();

            state._fsp--;


            	        if (current==null) {
            	            current = createModelElementForParent(grammarAccess.getBackgroundRepeatPropertyRule());
            	        }
                   		add(
                   			current, 
                   			"values",
                    		lv_values_2_0, 
                    		"io.lattekit.dsl.LatteCSS.RepeatValue");
            	        afterParserOrEnumRuleCall();
            	    

            }


            }

            // InternalLatteCSS.g:1679:2: ( (lv_values_3_0= ruleRepeatValue ) )?
            int alt19=2;
            int LA19_0 = input.LA(1);

            if ( ((LA19_0>=66 && LA19_0<=73)) ) {
                alt19=1;
            }
            switch (alt19) {
                case 1 :
                    // InternalLatteCSS.g:1680:1: (lv_values_3_0= ruleRepeatValue )
                    {
                    // InternalLatteCSS.g:1680:1: (lv_values_3_0= ruleRepeatValue )
                    // InternalLatteCSS.g:1681:3: lv_values_3_0= ruleRepeatValue
                    {
                     
                    	        newCompositeNode(grammarAccess.getBackgroundRepeatPropertyAccess().getValuesRepeatValueParserRuleCall_3_0()); 
                    	    
                    pushFollow(FOLLOW_2);
                    lv_values_3_0=ruleRepeatValue();

                    state._fsp--;


                    	        if (current==null) {
                    	            current = createModelElementForParent(grammarAccess.getBackgroundRepeatPropertyRule());
                    	        }
                           		add(
                           			current, 
                           			"values",
                            		lv_values_3_0, 
                            		"io.lattekit.dsl.LatteCSS.RepeatValue");
                    	        afterParserOrEnumRuleCall();
                    	    

                    }


                    }
                    break;

            }


            }


            }

             leaveRule(); 
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleBackgroundRepeatProperty"


    // $ANTLR start "entryRuleBorderProperty"
    // InternalLatteCSS.g:1705:1: entryRuleBorderProperty returns [EObject current=null] : iv_ruleBorderProperty= ruleBorderProperty EOF ;
    public final EObject entryRuleBorderProperty() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleBorderProperty = null;


        try {
            // InternalLatteCSS.g:1706:2: (iv_ruleBorderProperty= ruleBorderProperty EOF )
            // InternalLatteCSS.g:1707:2: iv_ruleBorderProperty= ruleBorderProperty EOF
            {
             newCompositeNode(grammarAccess.getBorderPropertyRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleBorderProperty=ruleBorderProperty();

            state._fsp--;

             current =iv_ruleBorderProperty; 
            match(input,EOF,FOLLOW_2); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleBorderProperty"


    // $ANTLR start "ruleBorderProperty"
    // InternalLatteCSS.g:1714:1: ruleBorderProperty returns [EObject current=null] : ( ( ( (lv_property_0_1= 'border' | lv_property_0_2= 'border-top' | lv_property_0_3= 'border-bottom' | lv_property_0_4= 'border-left' | lv_property_0_5= 'border-right' ) ) ) otherlv_1= ':' ( (lv_width_2_0= ruleSizeValue ) )? ( ( (lv_style_3_1= 'solid' | lv_style_3_2= 'dashed' | lv_style_3_3= 'dotted' ) ) ) ( (lv_color_4_0= ruleColorValue ) )? ) ;
    public final EObject ruleBorderProperty() throws RecognitionException {
        EObject current = null;

        Token lv_property_0_1=null;
        Token lv_property_0_2=null;
        Token lv_property_0_3=null;
        Token lv_property_0_4=null;
        Token lv_property_0_5=null;
        Token otherlv_1=null;
        Token lv_style_3_1=null;
        Token lv_style_3_2=null;
        Token lv_style_3_3=null;
        EObject lv_width_2_0 = null;

        EObject lv_color_4_0 = null;


         enterRule(); 
            
        try {
            // InternalLatteCSS.g:1717:28: ( ( ( ( (lv_property_0_1= 'border' | lv_property_0_2= 'border-top' | lv_property_0_3= 'border-bottom' | lv_property_0_4= 'border-left' | lv_property_0_5= 'border-right' ) ) ) otherlv_1= ':' ( (lv_width_2_0= ruleSizeValue ) )? ( ( (lv_style_3_1= 'solid' | lv_style_3_2= 'dashed' | lv_style_3_3= 'dotted' ) ) ) ( (lv_color_4_0= ruleColorValue ) )? ) )
            // InternalLatteCSS.g:1718:1: ( ( ( (lv_property_0_1= 'border' | lv_property_0_2= 'border-top' | lv_property_0_3= 'border-bottom' | lv_property_0_4= 'border-left' | lv_property_0_5= 'border-right' ) ) ) otherlv_1= ':' ( (lv_width_2_0= ruleSizeValue ) )? ( ( (lv_style_3_1= 'solid' | lv_style_3_2= 'dashed' | lv_style_3_3= 'dotted' ) ) ) ( (lv_color_4_0= ruleColorValue ) )? )
            {
            // InternalLatteCSS.g:1718:1: ( ( ( (lv_property_0_1= 'border' | lv_property_0_2= 'border-top' | lv_property_0_3= 'border-bottom' | lv_property_0_4= 'border-left' | lv_property_0_5= 'border-right' ) ) ) otherlv_1= ':' ( (lv_width_2_0= ruleSizeValue ) )? ( ( (lv_style_3_1= 'solid' | lv_style_3_2= 'dashed' | lv_style_3_3= 'dotted' ) ) ) ( (lv_color_4_0= ruleColorValue ) )? )
            // InternalLatteCSS.g:1718:2: ( ( (lv_property_0_1= 'border' | lv_property_0_2= 'border-top' | lv_property_0_3= 'border-bottom' | lv_property_0_4= 'border-left' | lv_property_0_5= 'border-right' ) ) ) otherlv_1= ':' ( (lv_width_2_0= ruleSizeValue ) )? ( ( (lv_style_3_1= 'solid' | lv_style_3_2= 'dashed' | lv_style_3_3= 'dotted' ) ) ) ( (lv_color_4_0= ruleColorValue ) )?
            {
            // InternalLatteCSS.g:1718:2: ( ( (lv_property_0_1= 'border' | lv_property_0_2= 'border-top' | lv_property_0_3= 'border-bottom' | lv_property_0_4= 'border-left' | lv_property_0_5= 'border-right' ) ) )
            // InternalLatteCSS.g:1719:1: ( (lv_property_0_1= 'border' | lv_property_0_2= 'border-top' | lv_property_0_3= 'border-bottom' | lv_property_0_4= 'border-left' | lv_property_0_5= 'border-right' ) )
            {
            // InternalLatteCSS.g:1719:1: ( (lv_property_0_1= 'border' | lv_property_0_2= 'border-top' | lv_property_0_3= 'border-bottom' | lv_property_0_4= 'border-left' | lv_property_0_5= 'border-right' ) )
            // InternalLatteCSS.g:1720:1: (lv_property_0_1= 'border' | lv_property_0_2= 'border-top' | lv_property_0_3= 'border-bottom' | lv_property_0_4= 'border-left' | lv_property_0_5= 'border-right' )
            {
            // InternalLatteCSS.g:1720:1: (lv_property_0_1= 'border' | lv_property_0_2= 'border-top' | lv_property_0_3= 'border-bottom' | lv_property_0_4= 'border-left' | lv_property_0_5= 'border-right' )
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
                    // InternalLatteCSS.g:1721:3: lv_property_0_1= 'border'
                    {
                    lv_property_0_1=(Token)match(input,57,FOLLOW_11); 

                            newLeafNode(lv_property_0_1, grammarAccess.getBorderPropertyAccess().getPropertyBorderKeyword_0_0_0());
                        

                    	        if (current==null) {
                    	            current = createModelElement(grammarAccess.getBorderPropertyRule());
                    	        }
                           		setWithLastConsumed(current, "property", lv_property_0_1, null);
                    	    

                    }
                    break;
                case 2 :
                    // InternalLatteCSS.g:1733:8: lv_property_0_2= 'border-top'
                    {
                    lv_property_0_2=(Token)match(input,58,FOLLOW_11); 

                            newLeafNode(lv_property_0_2, grammarAccess.getBorderPropertyAccess().getPropertyBorderTopKeyword_0_0_1());
                        

                    	        if (current==null) {
                    	            current = createModelElement(grammarAccess.getBorderPropertyRule());
                    	        }
                           		setWithLastConsumed(current, "property", lv_property_0_2, null);
                    	    

                    }
                    break;
                case 3 :
                    // InternalLatteCSS.g:1745:8: lv_property_0_3= 'border-bottom'
                    {
                    lv_property_0_3=(Token)match(input,59,FOLLOW_11); 

                            newLeafNode(lv_property_0_3, grammarAccess.getBorderPropertyAccess().getPropertyBorderBottomKeyword_0_0_2());
                        

                    	        if (current==null) {
                    	            current = createModelElement(grammarAccess.getBorderPropertyRule());
                    	        }
                           		setWithLastConsumed(current, "property", lv_property_0_3, null);
                    	    

                    }
                    break;
                case 4 :
                    // InternalLatteCSS.g:1757:8: lv_property_0_4= 'border-left'
                    {
                    lv_property_0_4=(Token)match(input,60,FOLLOW_11); 

                            newLeafNode(lv_property_0_4, grammarAccess.getBorderPropertyAccess().getPropertyBorderLeftKeyword_0_0_3());
                        

                    	        if (current==null) {
                    	            current = createModelElement(grammarAccess.getBorderPropertyRule());
                    	        }
                           		setWithLastConsumed(current, "property", lv_property_0_4, null);
                    	    

                    }
                    break;
                case 5 :
                    // InternalLatteCSS.g:1769:8: lv_property_0_5= 'border-right'
                    {
                    lv_property_0_5=(Token)match(input,61,FOLLOW_11); 

                            newLeafNode(lv_property_0_5, grammarAccess.getBorderPropertyAccess().getPropertyBorderRightKeyword_0_0_4());
                        

                    	        if (current==null) {
                    	            current = createModelElement(grammarAccess.getBorderPropertyRule());
                    	        }
                           		setWithLastConsumed(current, "property", lv_property_0_5, null);
                    	    

                    }
                    break;

            }


            }


            }

            otherlv_1=(Token)match(input,18,FOLLOW_23); 

                	newLeafNode(otherlv_1, grammarAccess.getBorderPropertyAccess().getColonKeyword_1());
                
            // InternalLatteCSS.g:1788:1: ( (lv_width_2_0= ruleSizeValue ) )?
            int alt21=2;
            int LA21_0 = input.LA(1);

            if ( ((LA21_0>=RULE_INT && LA21_0<=RULE_REAL)) ) {
                alt21=1;
            }
            switch (alt21) {
                case 1 :
                    // InternalLatteCSS.g:1789:1: (lv_width_2_0= ruleSizeValue )
                    {
                    // InternalLatteCSS.g:1789:1: (lv_width_2_0= ruleSizeValue )
                    // InternalLatteCSS.g:1790:3: lv_width_2_0= ruleSizeValue
                    {
                     
                    	        newCompositeNode(grammarAccess.getBorderPropertyAccess().getWidthSizeValueParserRuleCall_2_0()); 
                    	    
                    pushFollow(FOLLOW_24);
                    lv_width_2_0=ruleSizeValue();

                    state._fsp--;


                    	        if (current==null) {
                    	            current = createModelElementForParent(grammarAccess.getBorderPropertyRule());
                    	        }
                           		set(
                           			current, 
                           			"width",
                            		lv_width_2_0, 
                            		"io.lattekit.dsl.LatteCSS.SizeValue");
                    	        afterParserOrEnumRuleCall();
                    	    

                    }


                    }
                    break;

            }

            // InternalLatteCSS.g:1806:3: ( ( (lv_style_3_1= 'solid' | lv_style_3_2= 'dashed' | lv_style_3_3= 'dotted' ) ) )
            // InternalLatteCSS.g:1807:1: ( (lv_style_3_1= 'solid' | lv_style_3_2= 'dashed' | lv_style_3_3= 'dotted' ) )
            {
            // InternalLatteCSS.g:1807:1: ( (lv_style_3_1= 'solid' | lv_style_3_2= 'dashed' | lv_style_3_3= 'dotted' ) )
            // InternalLatteCSS.g:1808:1: (lv_style_3_1= 'solid' | lv_style_3_2= 'dashed' | lv_style_3_3= 'dotted' )
            {
            // InternalLatteCSS.g:1808:1: (lv_style_3_1= 'solid' | lv_style_3_2= 'dashed' | lv_style_3_3= 'dotted' )
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
                    // InternalLatteCSS.g:1809:3: lv_style_3_1= 'solid'
                    {
                    lv_style_3_1=(Token)match(input,62,FOLLOW_25); 

                            newLeafNode(lv_style_3_1, grammarAccess.getBorderPropertyAccess().getStyleSolidKeyword_3_0_0());
                        

                    	        if (current==null) {
                    	            current = createModelElement(grammarAccess.getBorderPropertyRule());
                    	        }
                           		setWithLastConsumed(current, "style", lv_style_3_1, null);
                    	    

                    }
                    break;
                case 2 :
                    // InternalLatteCSS.g:1821:8: lv_style_3_2= 'dashed'
                    {
                    lv_style_3_2=(Token)match(input,63,FOLLOW_25); 

                            newLeafNode(lv_style_3_2, grammarAccess.getBorderPropertyAccess().getStyleDashedKeyword_3_0_1());
                        

                    	        if (current==null) {
                    	            current = createModelElement(grammarAccess.getBorderPropertyRule());
                    	        }
                           		setWithLastConsumed(current, "style", lv_style_3_2, null);
                    	    

                    }
                    break;
                case 3 :
                    // InternalLatteCSS.g:1833:8: lv_style_3_3= 'dotted'
                    {
                    lv_style_3_3=(Token)match(input,64,FOLLOW_25); 

                            newLeafNode(lv_style_3_3, grammarAccess.getBorderPropertyAccess().getStyleDottedKeyword_3_0_2());
                        

                    	        if (current==null) {
                    	            current = createModelElement(grammarAccess.getBorderPropertyRule());
                    	        }
                           		setWithLastConsumed(current, "style", lv_style_3_3, null);
                    	    

                    }
                    break;

            }


            }


            }

            // InternalLatteCSS.g:1848:2: ( (lv_color_4_0= ruleColorValue ) )?
            int alt23=2;
            int LA23_0 = input.LA(1);

            if ( (LA23_0==RULE_HEX_NUMBER||(LA23_0>=150 && LA23_0<=299)) ) {
                alt23=1;
            }
            switch (alt23) {
                case 1 :
                    // InternalLatteCSS.g:1849:1: (lv_color_4_0= ruleColorValue )
                    {
                    // InternalLatteCSS.g:1849:1: (lv_color_4_0= ruleColorValue )
                    // InternalLatteCSS.g:1850:3: lv_color_4_0= ruleColorValue
                    {
                     
                    	        newCompositeNode(grammarAccess.getBorderPropertyAccess().getColorColorValueParserRuleCall_4_0()); 
                    	    
                    pushFollow(FOLLOW_2);
                    lv_color_4_0=ruleColorValue();

                    state._fsp--;


                    	        if (current==null) {
                    	            current = createModelElementForParent(grammarAccess.getBorderPropertyRule());
                    	        }
                           		set(
                           			current, 
                           			"color",
                            		lv_color_4_0, 
                            		"io.lattekit.dsl.LatteCSS.ColorValue");
                    	        afterParserOrEnumRuleCall();
                    	    

                    }


                    }
                    break;

            }


            }


            }

             leaveRule(); 
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleBorderProperty"


    // $ANTLR start "entryRuleBackgroundFilterProperty"
    // InternalLatteCSS.g:1874:1: entryRuleBackgroundFilterProperty returns [EObject current=null] : iv_ruleBackgroundFilterProperty= ruleBackgroundFilterProperty EOF ;
    public final EObject entryRuleBackgroundFilterProperty() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleBackgroundFilterProperty = null;


        try {
            // InternalLatteCSS.g:1875:2: (iv_ruleBackgroundFilterProperty= ruleBackgroundFilterProperty EOF )
            // InternalLatteCSS.g:1876:2: iv_ruleBackgroundFilterProperty= ruleBackgroundFilterProperty EOF
            {
             newCompositeNode(grammarAccess.getBackgroundFilterPropertyRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleBackgroundFilterProperty=ruleBackgroundFilterProperty();

            state._fsp--;

             current =iv_ruleBackgroundFilterProperty; 
            match(input,EOF,FOLLOW_2); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleBackgroundFilterProperty"


    // $ANTLR start "ruleBackgroundFilterProperty"
    // InternalLatteCSS.g:1883:1: ruleBackgroundFilterProperty returns [EObject current=null] : ( ( (lv_property_0_0= 'background-filter' ) ) otherlv_1= ':' ( (lv_color_2_0= ruleColorValue ) ) ( (lv_filter_3_0= ruleFilterValue ) )? ) ;
    public final EObject ruleBackgroundFilterProperty() throws RecognitionException {
        EObject current = null;

        Token lv_property_0_0=null;
        Token otherlv_1=null;
        EObject lv_color_2_0 = null;

        AntlrDatatypeRuleToken lv_filter_3_0 = null;


         enterRule(); 
            
        try {
            // InternalLatteCSS.g:1886:28: ( ( ( (lv_property_0_0= 'background-filter' ) ) otherlv_1= ':' ( (lv_color_2_0= ruleColorValue ) ) ( (lv_filter_3_0= ruleFilterValue ) )? ) )
            // InternalLatteCSS.g:1887:1: ( ( (lv_property_0_0= 'background-filter' ) ) otherlv_1= ':' ( (lv_color_2_0= ruleColorValue ) ) ( (lv_filter_3_0= ruleFilterValue ) )? )
            {
            // InternalLatteCSS.g:1887:1: ( ( (lv_property_0_0= 'background-filter' ) ) otherlv_1= ':' ( (lv_color_2_0= ruleColorValue ) ) ( (lv_filter_3_0= ruleFilterValue ) )? )
            // InternalLatteCSS.g:1887:2: ( (lv_property_0_0= 'background-filter' ) ) otherlv_1= ':' ( (lv_color_2_0= ruleColorValue ) ) ( (lv_filter_3_0= ruleFilterValue ) )?
            {
            // InternalLatteCSS.g:1887:2: ( (lv_property_0_0= 'background-filter' ) )
            // InternalLatteCSS.g:1888:1: (lv_property_0_0= 'background-filter' )
            {
            // InternalLatteCSS.g:1888:1: (lv_property_0_0= 'background-filter' )
            // InternalLatteCSS.g:1889:3: lv_property_0_0= 'background-filter'
            {
            lv_property_0_0=(Token)match(input,65,FOLLOW_11); 

                    newLeafNode(lv_property_0_0, grammarAccess.getBackgroundFilterPropertyAccess().getPropertyBackgroundFilterKeyword_0_0());
                

            	        if (current==null) {
            	            current = createModelElement(grammarAccess.getBackgroundFilterPropertyRule());
            	        }
                   		setWithLastConsumed(current, "property", lv_property_0_0, "background-filter");
            	    

            }


            }

            otherlv_1=(Token)match(input,18,FOLLOW_17); 

                	newLeafNode(otherlv_1, grammarAccess.getBackgroundFilterPropertyAccess().getColonKeyword_1());
                
            // InternalLatteCSS.g:1906:1: ( (lv_color_2_0= ruleColorValue ) )
            // InternalLatteCSS.g:1907:1: (lv_color_2_0= ruleColorValue )
            {
            // InternalLatteCSS.g:1907:1: (lv_color_2_0= ruleColorValue )
            // InternalLatteCSS.g:1908:3: lv_color_2_0= ruleColorValue
            {
             
            	        newCompositeNode(grammarAccess.getBackgroundFilterPropertyAccess().getColorColorValueParserRuleCall_2_0()); 
            	    
            pushFollow(FOLLOW_26);
            lv_color_2_0=ruleColorValue();

            state._fsp--;


            	        if (current==null) {
            	            current = createModelElementForParent(grammarAccess.getBackgroundFilterPropertyRule());
            	        }
                   		set(
                   			current, 
                   			"color",
                    		lv_color_2_0, 
                    		"io.lattekit.dsl.LatteCSS.ColorValue");
            	        afterParserOrEnumRuleCall();
            	    

            }


            }

            // InternalLatteCSS.g:1924:2: ( (lv_filter_3_0= ruleFilterValue ) )?
            int alt24=2;
            int LA24_0 = input.LA(1);

            if ( ((LA24_0>=89 && LA24_0<=106)) ) {
                alt24=1;
            }
            switch (alt24) {
                case 1 :
                    // InternalLatteCSS.g:1925:1: (lv_filter_3_0= ruleFilterValue )
                    {
                    // InternalLatteCSS.g:1925:1: (lv_filter_3_0= ruleFilterValue )
                    // InternalLatteCSS.g:1926:3: lv_filter_3_0= ruleFilterValue
                    {
                     
                    	        newCompositeNode(grammarAccess.getBackgroundFilterPropertyAccess().getFilterFilterValueParserRuleCall_3_0()); 
                    	    
                    pushFollow(FOLLOW_2);
                    lv_filter_3_0=ruleFilterValue();

                    state._fsp--;


                    	        if (current==null) {
                    	            current = createModelElementForParent(grammarAccess.getBackgroundFilterPropertyRule());
                    	        }
                           		set(
                           			current, 
                           			"filter",
                            		lv_filter_3_0, 
                            		"io.lattekit.dsl.LatteCSS.FilterValue");
                    	        afterParserOrEnumRuleCall();
                    	    

                    }


                    }
                    break;

            }


            }


            }

             leaveRule(); 
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleBackgroundFilterProperty"


    // $ANTLR start "entryRuleRepeatValue"
    // InternalLatteCSS.g:1950:1: entryRuleRepeatValue returns [String current=null] : iv_ruleRepeatValue= ruleRepeatValue EOF ;
    public final String entryRuleRepeatValue() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleRepeatValue = null;


        try {
            // InternalLatteCSS.g:1951:2: (iv_ruleRepeatValue= ruleRepeatValue EOF )
            // InternalLatteCSS.g:1952:2: iv_ruleRepeatValue= ruleRepeatValue EOF
            {
             newCompositeNode(grammarAccess.getRepeatValueRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleRepeatValue=ruleRepeatValue();

            state._fsp--;

             current =iv_ruleRepeatValue.getText(); 
            match(input,EOF,FOLLOW_2); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleRepeatValue"


    // $ANTLR start "ruleRepeatValue"
    // InternalLatteCSS.g:1959:1: ruleRepeatValue returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (kw= 'repeat-x' | kw= 'mirror-x' | kw= 'clamp-x' | kw= 'no-repeat-x' | kw= 'repeat-y' | kw= 'mirror-y' | kw= 'clamp-y' | kw= 'no-repeat-y' ) ;
    public final AntlrDatatypeRuleToken ruleRepeatValue() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token kw=null;

         enterRule(); 
            
        try {
            // InternalLatteCSS.g:1962:28: ( (kw= 'repeat-x' | kw= 'mirror-x' | kw= 'clamp-x' | kw= 'no-repeat-x' | kw= 'repeat-y' | kw= 'mirror-y' | kw= 'clamp-y' | kw= 'no-repeat-y' ) )
            // InternalLatteCSS.g:1963:1: (kw= 'repeat-x' | kw= 'mirror-x' | kw= 'clamp-x' | kw= 'no-repeat-x' | kw= 'repeat-y' | kw= 'mirror-y' | kw= 'clamp-y' | kw= 'no-repeat-y' )
            {
            // InternalLatteCSS.g:1963:1: (kw= 'repeat-x' | kw= 'mirror-x' | kw= 'clamp-x' | kw= 'no-repeat-x' | kw= 'repeat-y' | kw= 'mirror-y' | kw= 'clamp-y' | kw= 'no-repeat-y' )
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
                    // InternalLatteCSS.g:1964:2: kw= 'repeat-x'
                    {
                    kw=(Token)match(input,66,FOLLOW_2); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getRepeatValueAccess().getRepeatXKeyword_0()); 
                        

                    }
                    break;
                case 2 :
                    // InternalLatteCSS.g:1971:2: kw= 'mirror-x'
                    {
                    kw=(Token)match(input,67,FOLLOW_2); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getRepeatValueAccess().getMirrorXKeyword_1()); 
                        

                    }
                    break;
                case 3 :
                    // InternalLatteCSS.g:1978:2: kw= 'clamp-x'
                    {
                    kw=(Token)match(input,68,FOLLOW_2); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getRepeatValueAccess().getClampXKeyword_2()); 
                        

                    }
                    break;
                case 4 :
                    // InternalLatteCSS.g:1985:2: kw= 'no-repeat-x'
                    {
                    kw=(Token)match(input,69,FOLLOW_2); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getRepeatValueAccess().getNoRepeatXKeyword_3()); 
                        

                    }
                    break;
                case 5 :
                    // InternalLatteCSS.g:1992:2: kw= 'repeat-y'
                    {
                    kw=(Token)match(input,70,FOLLOW_2); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getRepeatValueAccess().getRepeatYKeyword_4()); 
                        

                    }
                    break;
                case 6 :
                    // InternalLatteCSS.g:1999:2: kw= 'mirror-y'
                    {
                    kw=(Token)match(input,71,FOLLOW_2); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getRepeatValueAccess().getMirrorYKeyword_5()); 
                        

                    }
                    break;
                case 7 :
                    // InternalLatteCSS.g:2006:2: kw= 'clamp-y'
                    {
                    kw=(Token)match(input,72,FOLLOW_2); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getRepeatValueAccess().getClampYKeyword_6()); 
                        

                    }
                    break;
                case 8 :
                    // InternalLatteCSS.g:2013:2: kw= 'no-repeat-y'
                    {
                    kw=(Token)match(input,73,FOLLOW_2); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getRepeatValueAccess().getNoRepeatYKeyword_7()); 
                        

                    }
                    break;

            }


            }

             leaveRule(); 
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleRepeatValue"


    // $ANTLR start "entryRuleGravityValue"
    // InternalLatteCSS.g:2026:1: entryRuleGravityValue returns [String current=null] : iv_ruleGravityValue= ruleGravityValue EOF ;
    public final String entryRuleGravityValue() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleGravityValue = null;


        try {
            // InternalLatteCSS.g:2027:2: (iv_ruleGravityValue= ruleGravityValue EOF )
            // InternalLatteCSS.g:2028:2: iv_ruleGravityValue= ruleGravityValue EOF
            {
             newCompositeNode(grammarAccess.getGravityValueRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleGravityValue=ruleGravityValue();

            state._fsp--;

             current =iv_ruleGravityValue.getText(); 
            match(input,EOF,FOLLOW_2); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleGravityValue"


    // $ANTLR start "ruleGravityValue"
    // InternalLatteCSS.g:2035:1: ruleGravityValue returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (kw= 'top' | kw= 'bottom' | kw= 'left' | kw= 'right' | kw= 'center_vertical' | kw= 'fill_vertical' | kw= 'center_horizontal' | kw= 'fill_horizontal' | kw= 'center' | kw= 'fill' | kw= 'clip_vertical' | kw= 'clip_horizontal' | kw= 'start' | kw= 'end' ) ;
    public final AntlrDatatypeRuleToken ruleGravityValue() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token kw=null;

         enterRule(); 
            
        try {
            // InternalLatteCSS.g:2038:28: ( (kw= 'top' | kw= 'bottom' | kw= 'left' | kw= 'right' | kw= 'center_vertical' | kw= 'fill_vertical' | kw= 'center_horizontal' | kw= 'fill_horizontal' | kw= 'center' | kw= 'fill' | kw= 'clip_vertical' | kw= 'clip_horizontal' | kw= 'start' | kw= 'end' ) )
            // InternalLatteCSS.g:2039:1: (kw= 'top' | kw= 'bottom' | kw= 'left' | kw= 'right' | kw= 'center_vertical' | kw= 'fill_vertical' | kw= 'center_horizontal' | kw= 'fill_horizontal' | kw= 'center' | kw= 'fill' | kw= 'clip_vertical' | kw= 'clip_horizontal' | kw= 'start' | kw= 'end' )
            {
            // InternalLatteCSS.g:2039:1: (kw= 'top' | kw= 'bottom' | kw= 'left' | kw= 'right' | kw= 'center_vertical' | kw= 'fill_vertical' | kw= 'center_horizontal' | kw= 'fill_horizontal' | kw= 'center' | kw= 'fill' | kw= 'clip_vertical' | kw= 'clip_horizontal' | kw= 'start' | kw= 'end' )
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
                    // InternalLatteCSS.g:2040:2: kw= 'top'
                    {
                    kw=(Token)match(input,74,FOLLOW_2); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getGravityValueAccess().getTopKeyword_0()); 
                        

                    }
                    break;
                case 2 :
                    // InternalLatteCSS.g:2047:2: kw= 'bottom'
                    {
                    kw=(Token)match(input,75,FOLLOW_2); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getGravityValueAccess().getBottomKeyword_1()); 
                        

                    }
                    break;
                case 3 :
                    // InternalLatteCSS.g:2054:2: kw= 'left'
                    {
                    kw=(Token)match(input,76,FOLLOW_2); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getGravityValueAccess().getLeftKeyword_2()); 
                        

                    }
                    break;
                case 4 :
                    // InternalLatteCSS.g:2061:2: kw= 'right'
                    {
                    kw=(Token)match(input,77,FOLLOW_2); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getGravityValueAccess().getRightKeyword_3()); 
                        

                    }
                    break;
                case 5 :
                    // InternalLatteCSS.g:2068:2: kw= 'center_vertical'
                    {
                    kw=(Token)match(input,78,FOLLOW_2); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getGravityValueAccess().getCenter_verticalKeyword_4()); 
                        

                    }
                    break;
                case 6 :
                    // InternalLatteCSS.g:2075:2: kw= 'fill_vertical'
                    {
                    kw=(Token)match(input,79,FOLLOW_2); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getGravityValueAccess().getFill_verticalKeyword_5()); 
                        

                    }
                    break;
                case 7 :
                    // InternalLatteCSS.g:2082:2: kw= 'center_horizontal'
                    {
                    kw=(Token)match(input,80,FOLLOW_2); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getGravityValueAccess().getCenter_horizontalKeyword_6()); 
                        

                    }
                    break;
                case 8 :
                    // InternalLatteCSS.g:2089:2: kw= 'fill_horizontal'
                    {
                    kw=(Token)match(input,81,FOLLOW_2); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getGravityValueAccess().getFill_horizontalKeyword_7()); 
                        

                    }
                    break;
                case 9 :
                    // InternalLatteCSS.g:2096:2: kw= 'center'
                    {
                    kw=(Token)match(input,82,FOLLOW_2); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getGravityValueAccess().getCenterKeyword_8()); 
                        

                    }
                    break;
                case 10 :
                    // InternalLatteCSS.g:2103:2: kw= 'fill'
                    {
                    kw=(Token)match(input,83,FOLLOW_2); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getGravityValueAccess().getFillKeyword_9()); 
                        

                    }
                    break;
                case 11 :
                    // InternalLatteCSS.g:2110:2: kw= 'clip_vertical'
                    {
                    kw=(Token)match(input,84,FOLLOW_2); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getGravityValueAccess().getClip_verticalKeyword_10()); 
                        

                    }
                    break;
                case 12 :
                    // InternalLatteCSS.g:2117:2: kw= 'clip_horizontal'
                    {
                    kw=(Token)match(input,85,FOLLOW_2); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getGravityValueAccess().getClip_horizontalKeyword_11()); 
                        

                    }
                    break;
                case 13 :
                    // InternalLatteCSS.g:2124:2: kw= 'start'
                    {
                    kw=(Token)match(input,86,FOLLOW_2); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getGravityValueAccess().getStartKeyword_12()); 
                        

                    }
                    break;
                case 14 :
                    // InternalLatteCSS.g:2131:2: kw= 'end'
                    {
                    kw=(Token)match(input,87,FOLLOW_2); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getGravityValueAccess().getEndKeyword_13()); 
                        

                    }
                    break;

            }


            }

             leaveRule(); 
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleGravityValue"


    // $ANTLR start "entryRuleBackgroundGravityProperty"
    // InternalLatteCSS.g:2144:1: entryRuleBackgroundGravityProperty returns [EObject current=null] : iv_ruleBackgroundGravityProperty= ruleBackgroundGravityProperty EOF ;
    public final EObject entryRuleBackgroundGravityProperty() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleBackgroundGravityProperty = null;


        try {
            // InternalLatteCSS.g:2145:2: (iv_ruleBackgroundGravityProperty= ruleBackgroundGravityProperty EOF )
            // InternalLatteCSS.g:2146:2: iv_ruleBackgroundGravityProperty= ruleBackgroundGravityProperty EOF
            {
             newCompositeNode(grammarAccess.getBackgroundGravityPropertyRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleBackgroundGravityProperty=ruleBackgroundGravityProperty();

            state._fsp--;

             current =iv_ruleBackgroundGravityProperty; 
            match(input,EOF,FOLLOW_2); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleBackgroundGravityProperty"


    // $ANTLR start "ruleBackgroundGravityProperty"
    // InternalLatteCSS.g:2153:1: ruleBackgroundGravityProperty returns [EObject current=null] : ( ( (lv_property_0_0= 'background-gravity' ) ) otherlv_1= ':' ( (lv_values_2_0= ruleGravityValue ) ) (otherlv_3= ',' ( (lv_values_4_0= ruleGravityValue ) ) )* ) ;
    public final EObject ruleBackgroundGravityProperty() throws RecognitionException {
        EObject current = null;

        Token lv_property_0_0=null;
        Token otherlv_1=null;
        Token otherlv_3=null;
        AntlrDatatypeRuleToken lv_values_2_0 = null;

        AntlrDatatypeRuleToken lv_values_4_0 = null;


         enterRule(); 
            
        try {
            // InternalLatteCSS.g:2156:28: ( ( ( (lv_property_0_0= 'background-gravity' ) ) otherlv_1= ':' ( (lv_values_2_0= ruleGravityValue ) ) (otherlv_3= ',' ( (lv_values_4_0= ruleGravityValue ) ) )* ) )
            // InternalLatteCSS.g:2157:1: ( ( (lv_property_0_0= 'background-gravity' ) ) otherlv_1= ':' ( (lv_values_2_0= ruleGravityValue ) ) (otherlv_3= ',' ( (lv_values_4_0= ruleGravityValue ) ) )* )
            {
            // InternalLatteCSS.g:2157:1: ( ( (lv_property_0_0= 'background-gravity' ) ) otherlv_1= ':' ( (lv_values_2_0= ruleGravityValue ) ) (otherlv_3= ',' ( (lv_values_4_0= ruleGravityValue ) ) )* )
            // InternalLatteCSS.g:2157:2: ( (lv_property_0_0= 'background-gravity' ) ) otherlv_1= ':' ( (lv_values_2_0= ruleGravityValue ) ) (otherlv_3= ',' ( (lv_values_4_0= ruleGravityValue ) ) )*
            {
            // InternalLatteCSS.g:2157:2: ( (lv_property_0_0= 'background-gravity' ) )
            // InternalLatteCSS.g:2158:1: (lv_property_0_0= 'background-gravity' )
            {
            // InternalLatteCSS.g:2158:1: (lv_property_0_0= 'background-gravity' )
            // InternalLatteCSS.g:2159:3: lv_property_0_0= 'background-gravity'
            {
            lv_property_0_0=(Token)match(input,88,FOLLOW_11); 

                    newLeafNode(lv_property_0_0, grammarAccess.getBackgroundGravityPropertyAccess().getPropertyBackgroundGravityKeyword_0_0());
                

            	        if (current==null) {
            	            current = createModelElement(grammarAccess.getBackgroundGravityPropertyRule());
            	        }
                   		setWithLastConsumed(current, "property", lv_property_0_0, "background-gravity");
            	    

            }


            }

            otherlv_1=(Token)match(input,18,FOLLOW_27); 

                	newLeafNode(otherlv_1, grammarAccess.getBackgroundGravityPropertyAccess().getColonKeyword_1());
                
            // InternalLatteCSS.g:2176:1: ( (lv_values_2_0= ruleGravityValue ) )
            // InternalLatteCSS.g:2177:1: (lv_values_2_0= ruleGravityValue )
            {
            // InternalLatteCSS.g:2177:1: (lv_values_2_0= ruleGravityValue )
            // InternalLatteCSS.g:2178:3: lv_values_2_0= ruleGravityValue
            {
             
            	        newCompositeNode(grammarAccess.getBackgroundGravityPropertyAccess().getValuesGravityValueParserRuleCall_2_0()); 
            	    
            pushFollow(FOLLOW_19);
            lv_values_2_0=ruleGravityValue();

            state._fsp--;


            	        if (current==null) {
            	            current = createModelElementForParent(grammarAccess.getBackgroundGravityPropertyRule());
            	        }
                   		add(
                   			current, 
                   			"values",
                    		lv_values_2_0, 
                    		"io.lattekit.dsl.LatteCSS.GravityValue");
            	        afterParserOrEnumRuleCall();
            	    

            }


            }

            // InternalLatteCSS.g:2194:2: (otherlv_3= ',' ( (lv_values_4_0= ruleGravityValue ) ) )*
            loop27:
            do {
                int alt27=2;
                int LA27_0 = input.LA(1);

                if ( (LA27_0==13) ) {
                    alt27=1;
                }


                switch (alt27) {
            	case 1 :
            	    // InternalLatteCSS.g:2194:4: otherlv_3= ',' ( (lv_values_4_0= ruleGravityValue ) )
            	    {
            	    otherlv_3=(Token)match(input,13,FOLLOW_27); 

            	        	newLeafNode(otherlv_3, grammarAccess.getBackgroundGravityPropertyAccess().getCommaKeyword_3_0());
            	        
            	    // InternalLatteCSS.g:2198:1: ( (lv_values_4_0= ruleGravityValue ) )
            	    // InternalLatteCSS.g:2199:1: (lv_values_4_0= ruleGravityValue )
            	    {
            	    // InternalLatteCSS.g:2199:1: (lv_values_4_0= ruleGravityValue )
            	    // InternalLatteCSS.g:2200:3: lv_values_4_0= ruleGravityValue
            	    {
            	     
            	    	        newCompositeNode(grammarAccess.getBackgroundGravityPropertyAccess().getValuesGravityValueParserRuleCall_3_1_0()); 
            	    	    
            	    pushFollow(FOLLOW_19);
            	    lv_values_4_0=ruleGravityValue();

            	    state._fsp--;


            	    	        if (current==null) {
            	    	            current = createModelElementForParent(grammarAccess.getBackgroundGravityPropertyRule());
            	    	        }
            	           		add(
            	           			current, 
            	           			"values",
            	            		lv_values_4_0, 
            	            		"io.lattekit.dsl.LatteCSS.GravityValue");
            	    	        afterParserOrEnumRuleCall();
            	    	    

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

             leaveRule(); 
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleBackgroundGravityProperty"


    // $ANTLR start "entryRuleFilterValue"
    // InternalLatteCSS.g:2224:1: entryRuleFilterValue returns [String current=null] : iv_ruleFilterValue= ruleFilterValue EOF ;
    public final String entryRuleFilterValue() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleFilterValue = null;


        try {
            // InternalLatteCSS.g:2225:2: (iv_ruleFilterValue= ruleFilterValue EOF )
            // InternalLatteCSS.g:2226:2: iv_ruleFilterValue= ruleFilterValue EOF
            {
             newCompositeNode(grammarAccess.getFilterValueRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleFilterValue=ruleFilterValue();

            state._fsp--;

             current =iv_ruleFilterValue.getText(); 
            match(input,EOF,FOLLOW_2); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleFilterValue"


    // $ANTLR start "ruleFilterValue"
    // InternalLatteCSS.g:2233:1: ruleFilterValue returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (kw= 'add' | kw= 'clear' | kw= 'darken' | kw= 'dst' | kw= 'dst_atop' | kw= 'dst_in' | kw= 'dst_out' | kw= 'dst_over' | kw= 'lighten' | kw= 'multiply' | kw= 'overlay' | kw= 'screen' | kw= 'src' | kw= 'src_atop' | kw= 'src_in' | kw= 'src_out' | kw= 'src_over' | kw= 'xor' ) ;
    public final AntlrDatatypeRuleToken ruleFilterValue() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token kw=null;

         enterRule(); 
            
        try {
            // InternalLatteCSS.g:2236:28: ( (kw= 'add' | kw= 'clear' | kw= 'darken' | kw= 'dst' | kw= 'dst_atop' | kw= 'dst_in' | kw= 'dst_out' | kw= 'dst_over' | kw= 'lighten' | kw= 'multiply' | kw= 'overlay' | kw= 'screen' | kw= 'src' | kw= 'src_atop' | kw= 'src_in' | kw= 'src_out' | kw= 'src_over' | kw= 'xor' ) )
            // InternalLatteCSS.g:2237:1: (kw= 'add' | kw= 'clear' | kw= 'darken' | kw= 'dst' | kw= 'dst_atop' | kw= 'dst_in' | kw= 'dst_out' | kw= 'dst_over' | kw= 'lighten' | kw= 'multiply' | kw= 'overlay' | kw= 'screen' | kw= 'src' | kw= 'src_atop' | kw= 'src_in' | kw= 'src_out' | kw= 'src_over' | kw= 'xor' )
            {
            // InternalLatteCSS.g:2237:1: (kw= 'add' | kw= 'clear' | kw= 'darken' | kw= 'dst' | kw= 'dst_atop' | kw= 'dst_in' | kw= 'dst_out' | kw= 'dst_over' | kw= 'lighten' | kw= 'multiply' | kw= 'overlay' | kw= 'screen' | kw= 'src' | kw= 'src_atop' | kw= 'src_in' | kw= 'src_out' | kw= 'src_over' | kw= 'xor' )
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
                    // InternalLatteCSS.g:2238:2: kw= 'add'
                    {
                    kw=(Token)match(input,89,FOLLOW_2); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getFilterValueAccess().getAddKeyword_0()); 
                        

                    }
                    break;
                case 2 :
                    // InternalLatteCSS.g:2245:2: kw= 'clear'
                    {
                    kw=(Token)match(input,90,FOLLOW_2); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getFilterValueAccess().getClearKeyword_1()); 
                        

                    }
                    break;
                case 3 :
                    // InternalLatteCSS.g:2252:2: kw= 'darken'
                    {
                    kw=(Token)match(input,91,FOLLOW_2); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getFilterValueAccess().getDarkenKeyword_2()); 
                        

                    }
                    break;
                case 4 :
                    // InternalLatteCSS.g:2259:2: kw= 'dst'
                    {
                    kw=(Token)match(input,92,FOLLOW_2); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getFilterValueAccess().getDstKeyword_3()); 
                        

                    }
                    break;
                case 5 :
                    // InternalLatteCSS.g:2266:2: kw= 'dst_atop'
                    {
                    kw=(Token)match(input,93,FOLLOW_2); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getFilterValueAccess().getDst_atopKeyword_4()); 
                        

                    }
                    break;
                case 6 :
                    // InternalLatteCSS.g:2273:2: kw= 'dst_in'
                    {
                    kw=(Token)match(input,94,FOLLOW_2); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getFilterValueAccess().getDst_inKeyword_5()); 
                        

                    }
                    break;
                case 7 :
                    // InternalLatteCSS.g:2280:2: kw= 'dst_out'
                    {
                    kw=(Token)match(input,95,FOLLOW_2); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getFilterValueAccess().getDst_outKeyword_6()); 
                        

                    }
                    break;
                case 8 :
                    // InternalLatteCSS.g:2287:2: kw= 'dst_over'
                    {
                    kw=(Token)match(input,96,FOLLOW_2); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getFilterValueAccess().getDst_overKeyword_7()); 
                        

                    }
                    break;
                case 9 :
                    // InternalLatteCSS.g:2294:2: kw= 'lighten'
                    {
                    kw=(Token)match(input,97,FOLLOW_2); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getFilterValueAccess().getLightenKeyword_8()); 
                        

                    }
                    break;
                case 10 :
                    // InternalLatteCSS.g:2301:2: kw= 'multiply'
                    {
                    kw=(Token)match(input,98,FOLLOW_2); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getFilterValueAccess().getMultiplyKeyword_9()); 
                        

                    }
                    break;
                case 11 :
                    // InternalLatteCSS.g:2308:2: kw= 'overlay'
                    {
                    kw=(Token)match(input,99,FOLLOW_2); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getFilterValueAccess().getOverlayKeyword_10()); 
                        

                    }
                    break;
                case 12 :
                    // InternalLatteCSS.g:2315:2: kw= 'screen'
                    {
                    kw=(Token)match(input,100,FOLLOW_2); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getFilterValueAccess().getScreenKeyword_11()); 
                        

                    }
                    break;
                case 13 :
                    // InternalLatteCSS.g:2322:2: kw= 'src'
                    {
                    kw=(Token)match(input,101,FOLLOW_2); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getFilterValueAccess().getSrcKeyword_12()); 
                        

                    }
                    break;
                case 14 :
                    // InternalLatteCSS.g:2329:2: kw= 'src_atop'
                    {
                    kw=(Token)match(input,102,FOLLOW_2); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getFilterValueAccess().getSrc_atopKeyword_13()); 
                        

                    }
                    break;
                case 15 :
                    // InternalLatteCSS.g:2336:2: kw= 'src_in'
                    {
                    kw=(Token)match(input,103,FOLLOW_2); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getFilterValueAccess().getSrc_inKeyword_14()); 
                        

                    }
                    break;
                case 16 :
                    // InternalLatteCSS.g:2343:2: kw= 'src_out'
                    {
                    kw=(Token)match(input,104,FOLLOW_2); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getFilterValueAccess().getSrc_outKeyword_15()); 
                        

                    }
                    break;
                case 17 :
                    // InternalLatteCSS.g:2350:2: kw= 'src_over'
                    {
                    kw=(Token)match(input,105,FOLLOW_2); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getFilterValueAccess().getSrc_overKeyword_16()); 
                        

                    }
                    break;
                case 18 :
                    // InternalLatteCSS.g:2357:2: kw= 'xor'
                    {
                    kw=(Token)match(input,106,FOLLOW_2); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getFilterValueAccess().getXorKeyword_17()); 
                        

                    }
                    break;

            }


            }

             leaveRule(); 
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleFilterValue"


    // $ANTLR start "entryRuleBackgroundFilterTypeProperty"
    // InternalLatteCSS.g:2370:1: entryRuleBackgroundFilterTypeProperty returns [EObject current=null] : iv_ruleBackgroundFilterTypeProperty= ruleBackgroundFilterTypeProperty EOF ;
    public final EObject entryRuleBackgroundFilterTypeProperty() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleBackgroundFilterTypeProperty = null;


        try {
            // InternalLatteCSS.g:2371:2: (iv_ruleBackgroundFilterTypeProperty= ruleBackgroundFilterTypeProperty EOF )
            // InternalLatteCSS.g:2372:2: iv_ruleBackgroundFilterTypeProperty= ruleBackgroundFilterTypeProperty EOF
            {
             newCompositeNode(grammarAccess.getBackgroundFilterTypePropertyRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleBackgroundFilterTypeProperty=ruleBackgroundFilterTypeProperty();

            state._fsp--;

             current =iv_ruleBackgroundFilterTypeProperty; 
            match(input,EOF,FOLLOW_2); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleBackgroundFilterTypeProperty"


    // $ANTLR start "ruleBackgroundFilterTypeProperty"
    // InternalLatteCSS.g:2379:1: ruleBackgroundFilterTypeProperty returns [EObject current=null] : ( ( (lv_property_0_0= 'background-filter-type' ) ) otherlv_1= ':' ( (lv_value_2_0= ruleFilterValue ) ) ) ;
    public final EObject ruleBackgroundFilterTypeProperty() throws RecognitionException {
        EObject current = null;

        Token lv_property_0_0=null;
        Token otherlv_1=null;
        AntlrDatatypeRuleToken lv_value_2_0 = null;


         enterRule(); 
            
        try {
            // InternalLatteCSS.g:2382:28: ( ( ( (lv_property_0_0= 'background-filter-type' ) ) otherlv_1= ':' ( (lv_value_2_0= ruleFilterValue ) ) ) )
            // InternalLatteCSS.g:2383:1: ( ( (lv_property_0_0= 'background-filter-type' ) ) otherlv_1= ':' ( (lv_value_2_0= ruleFilterValue ) ) )
            {
            // InternalLatteCSS.g:2383:1: ( ( (lv_property_0_0= 'background-filter-type' ) ) otherlv_1= ':' ( (lv_value_2_0= ruleFilterValue ) ) )
            // InternalLatteCSS.g:2383:2: ( (lv_property_0_0= 'background-filter-type' ) ) otherlv_1= ':' ( (lv_value_2_0= ruleFilterValue ) )
            {
            // InternalLatteCSS.g:2383:2: ( (lv_property_0_0= 'background-filter-type' ) )
            // InternalLatteCSS.g:2384:1: (lv_property_0_0= 'background-filter-type' )
            {
            // InternalLatteCSS.g:2384:1: (lv_property_0_0= 'background-filter-type' )
            // InternalLatteCSS.g:2385:3: lv_property_0_0= 'background-filter-type'
            {
            lv_property_0_0=(Token)match(input,107,FOLLOW_11); 

                    newLeafNode(lv_property_0_0, grammarAccess.getBackgroundFilterTypePropertyAccess().getPropertyBackgroundFilterTypeKeyword_0_0());
                

            	        if (current==null) {
            	            current = createModelElement(grammarAccess.getBackgroundFilterTypePropertyRule());
            	        }
                   		setWithLastConsumed(current, "property", lv_property_0_0, "background-filter-type");
            	    

            }


            }

            otherlv_1=(Token)match(input,18,FOLLOW_28); 

                	newLeafNode(otherlv_1, grammarAccess.getBackgroundFilterTypePropertyAccess().getColonKeyword_1());
                
            // InternalLatteCSS.g:2402:1: ( (lv_value_2_0= ruleFilterValue ) )
            // InternalLatteCSS.g:2403:1: (lv_value_2_0= ruleFilterValue )
            {
            // InternalLatteCSS.g:2403:1: (lv_value_2_0= ruleFilterValue )
            // InternalLatteCSS.g:2404:3: lv_value_2_0= ruleFilterValue
            {
             
            	        newCompositeNode(grammarAccess.getBackgroundFilterTypePropertyAccess().getValueFilterValueParserRuleCall_2_0()); 
            	    
            pushFollow(FOLLOW_2);
            lv_value_2_0=ruleFilterValue();

            state._fsp--;


            	        if (current==null) {
            	            current = createModelElementForParent(grammarAccess.getBackgroundFilterTypePropertyRule());
            	        }
                   		set(
                   			current, 
                   			"value",
                    		lv_value_2_0, 
                    		"io.lattekit.dsl.LatteCSS.FilterValue");
            	        afterParserOrEnumRuleCall();
            	    

            }


            }


            }


            }

             leaveRule(); 
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleBackgroundFilterTypeProperty"


    // $ANTLR start "entryRuleShorthandColorProperty"
    // InternalLatteCSS.g:2428:1: entryRuleShorthandColorProperty returns [EObject current=null] : iv_ruleShorthandColorProperty= ruleShorthandColorProperty EOF ;
    public final EObject entryRuleShorthandColorProperty() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleShorthandColorProperty = null;


        try {
            // InternalLatteCSS.g:2429:2: (iv_ruleShorthandColorProperty= ruleShorthandColorProperty EOF )
            // InternalLatteCSS.g:2430:2: iv_ruleShorthandColorProperty= ruleShorthandColorProperty EOF
            {
             newCompositeNode(grammarAccess.getShorthandColorPropertyRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleShorthandColorProperty=ruleShorthandColorProperty();

            state._fsp--;

             current =iv_ruleShorthandColorProperty; 
            match(input,EOF,FOLLOW_2); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleShorthandColorProperty"


    // $ANTLR start "ruleShorthandColorProperty"
    // InternalLatteCSS.g:2437:1: ruleShorthandColorProperty returns [EObject current=null] : ( ( (lv_property_0_0= 'border-color' ) ) otherlv_1= ':' ( (lv_values_2_0= ruleColorValue ) )+ ) ;
    public final EObject ruleShorthandColorProperty() throws RecognitionException {
        EObject current = null;

        Token lv_property_0_0=null;
        Token otherlv_1=null;
        EObject lv_values_2_0 = null;


         enterRule(); 
            
        try {
            // InternalLatteCSS.g:2440:28: ( ( ( (lv_property_0_0= 'border-color' ) ) otherlv_1= ':' ( (lv_values_2_0= ruleColorValue ) )+ ) )
            // InternalLatteCSS.g:2441:1: ( ( (lv_property_0_0= 'border-color' ) ) otherlv_1= ':' ( (lv_values_2_0= ruleColorValue ) )+ )
            {
            // InternalLatteCSS.g:2441:1: ( ( (lv_property_0_0= 'border-color' ) ) otherlv_1= ':' ( (lv_values_2_0= ruleColorValue ) )+ )
            // InternalLatteCSS.g:2441:2: ( (lv_property_0_0= 'border-color' ) ) otherlv_1= ':' ( (lv_values_2_0= ruleColorValue ) )+
            {
            // InternalLatteCSS.g:2441:2: ( (lv_property_0_0= 'border-color' ) )
            // InternalLatteCSS.g:2442:1: (lv_property_0_0= 'border-color' )
            {
            // InternalLatteCSS.g:2442:1: (lv_property_0_0= 'border-color' )
            // InternalLatteCSS.g:2443:3: lv_property_0_0= 'border-color'
            {
            lv_property_0_0=(Token)match(input,108,FOLLOW_11); 

                    newLeafNode(lv_property_0_0, grammarAccess.getShorthandColorPropertyAccess().getPropertyBorderColorKeyword_0_0());
                

            	        if (current==null) {
            	            current = createModelElement(grammarAccess.getShorthandColorPropertyRule());
            	        }
                   		setWithLastConsumed(current, "property", lv_property_0_0, "border-color");
            	    

            }


            }

            otherlv_1=(Token)match(input,18,FOLLOW_17); 

                	newLeafNode(otherlv_1, grammarAccess.getShorthandColorPropertyAccess().getColonKeyword_1());
                
            // InternalLatteCSS.g:2460:1: ( (lv_values_2_0= ruleColorValue ) )+
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
            	    // InternalLatteCSS.g:2461:1: (lv_values_2_0= ruleColorValue )
            	    {
            	    // InternalLatteCSS.g:2461:1: (lv_values_2_0= ruleColorValue )
            	    // InternalLatteCSS.g:2462:3: lv_values_2_0= ruleColorValue
            	    {
            	     
            	    	        newCompositeNode(grammarAccess.getShorthandColorPropertyAccess().getValuesColorValueParserRuleCall_2_0()); 
            	    	    
            	    pushFollow(FOLLOW_25);
            	    lv_values_2_0=ruleColorValue();

            	    state._fsp--;


            	    	        if (current==null) {
            	    	            current = createModelElementForParent(grammarAccess.getShorthandColorPropertyRule());
            	    	        }
            	           		add(
            	           			current, 
            	           			"values",
            	            		lv_values_2_0, 
            	            		"io.lattekit.dsl.LatteCSS.ColorValue");
            	    	        afterParserOrEnumRuleCall();
            	    	    

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

             leaveRule(); 
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleShorthandColorProperty"


    // $ANTLR start "entryRuleColorProperty"
    // InternalLatteCSS.g:2486:1: entryRuleColorProperty returns [EObject current=null] : iv_ruleColorProperty= ruleColorProperty EOF ;
    public final EObject entryRuleColorProperty() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleColorProperty = null;


        try {
            // InternalLatteCSS.g:2487:2: (iv_ruleColorProperty= ruleColorProperty EOF )
            // InternalLatteCSS.g:2488:2: iv_ruleColorProperty= ruleColorProperty EOF
            {
             newCompositeNode(grammarAccess.getColorPropertyRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleColorProperty=ruleColorProperty();

            state._fsp--;

             current =iv_ruleColorProperty; 
            match(input,EOF,FOLLOW_2); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleColorProperty"


    // $ANTLR start "ruleColorProperty"
    // InternalLatteCSS.g:2495:1: ruleColorProperty returns [EObject current=null] : ( ( ( (lv_property_0_1= 'border-top-color' | lv_property_0_2= 'border-left-color' | lv_property_0_3= 'border-right-color' | lv_property_0_4= 'border-bottom-color' | lv_property_0_5= 'ripple-color' | lv_property_0_6= 'background-color' | lv_property_0_7= 'text-color' | lv_property_0_8= 'background-filter-color' ) ) ) otherlv_1= ':' ( (lv_value_2_0= ruleColorValue ) ) ) ;
    public final EObject ruleColorProperty() throws RecognitionException {
        EObject current = null;

        Token lv_property_0_1=null;
        Token lv_property_0_2=null;
        Token lv_property_0_3=null;
        Token lv_property_0_4=null;
        Token lv_property_0_5=null;
        Token lv_property_0_6=null;
        Token lv_property_0_7=null;
        Token lv_property_0_8=null;
        Token otherlv_1=null;
        EObject lv_value_2_0 = null;


         enterRule(); 
            
        try {
            // InternalLatteCSS.g:2498:28: ( ( ( ( (lv_property_0_1= 'border-top-color' | lv_property_0_2= 'border-left-color' | lv_property_0_3= 'border-right-color' | lv_property_0_4= 'border-bottom-color' | lv_property_0_5= 'ripple-color' | lv_property_0_6= 'background-color' | lv_property_0_7= 'text-color' | lv_property_0_8= 'background-filter-color' ) ) ) otherlv_1= ':' ( (lv_value_2_0= ruleColorValue ) ) ) )
            // InternalLatteCSS.g:2499:1: ( ( ( (lv_property_0_1= 'border-top-color' | lv_property_0_2= 'border-left-color' | lv_property_0_3= 'border-right-color' | lv_property_0_4= 'border-bottom-color' | lv_property_0_5= 'ripple-color' | lv_property_0_6= 'background-color' | lv_property_0_7= 'text-color' | lv_property_0_8= 'background-filter-color' ) ) ) otherlv_1= ':' ( (lv_value_2_0= ruleColorValue ) ) )
            {
            // InternalLatteCSS.g:2499:1: ( ( ( (lv_property_0_1= 'border-top-color' | lv_property_0_2= 'border-left-color' | lv_property_0_3= 'border-right-color' | lv_property_0_4= 'border-bottom-color' | lv_property_0_5= 'ripple-color' | lv_property_0_6= 'background-color' | lv_property_0_7= 'text-color' | lv_property_0_8= 'background-filter-color' ) ) ) otherlv_1= ':' ( (lv_value_2_0= ruleColorValue ) ) )
            // InternalLatteCSS.g:2499:2: ( ( (lv_property_0_1= 'border-top-color' | lv_property_0_2= 'border-left-color' | lv_property_0_3= 'border-right-color' | lv_property_0_4= 'border-bottom-color' | lv_property_0_5= 'ripple-color' | lv_property_0_6= 'background-color' | lv_property_0_7= 'text-color' | lv_property_0_8= 'background-filter-color' ) ) ) otherlv_1= ':' ( (lv_value_2_0= ruleColorValue ) )
            {
            // InternalLatteCSS.g:2499:2: ( ( (lv_property_0_1= 'border-top-color' | lv_property_0_2= 'border-left-color' | lv_property_0_3= 'border-right-color' | lv_property_0_4= 'border-bottom-color' | lv_property_0_5= 'ripple-color' | lv_property_0_6= 'background-color' | lv_property_0_7= 'text-color' | lv_property_0_8= 'background-filter-color' ) ) )
            // InternalLatteCSS.g:2500:1: ( (lv_property_0_1= 'border-top-color' | lv_property_0_2= 'border-left-color' | lv_property_0_3= 'border-right-color' | lv_property_0_4= 'border-bottom-color' | lv_property_0_5= 'ripple-color' | lv_property_0_6= 'background-color' | lv_property_0_7= 'text-color' | lv_property_0_8= 'background-filter-color' ) )
            {
            // InternalLatteCSS.g:2500:1: ( (lv_property_0_1= 'border-top-color' | lv_property_0_2= 'border-left-color' | lv_property_0_3= 'border-right-color' | lv_property_0_4= 'border-bottom-color' | lv_property_0_5= 'ripple-color' | lv_property_0_6= 'background-color' | lv_property_0_7= 'text-color' | lv_property_0_8= 'background-filter-color' ) )
            // InternalLatteCSS.g:2501:1: (lv_property_0_1= 'border-top-color' | lv_property_0_2= 'border-left-color' | lv_property_0_3= 'border-right-color' | lv_property_0_4= 'border-bottom-color' | lv_property_0_5= 'ripple-color' | lv_property_0_6= 'background-color' | lv_property_0_7= 'text-color' | lv_property_0_8= 'background-filter-color' )
            {
            // InternalLatteCSS.g:2501:1: (lv_property_0_1= 'border-top-color' | lv_property_0_2= 'border-left-color' | lv_property_0_3= 'border-right-color' | lv_property_0_4= 'border-bottom-color' | lv_property_0_5= 'ripple-color' | lv_property_0_6= 'background-color' | lv_property_0_7= 'text-color' | lv_property_0_8= 'background-filter-color' )
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
                    // InternalLatteCSS.g:2502:3: lv_property_0_1= 'border-top-color'
                    {
                    lv_property_0_1=(Token)match(input,109,FOLLOW_11); 

                            newLeafNode(lv_property_0_1, grammarAccess.getColorPropertyAccess().getPropertyBorderTopColorKeyword_0_0_0());
                        

                    	        if (current==null) {
                    	            current = createModelElement(grammarAccess.getColorPropertyRule());
                    	        }
                           		setWithLastConsumed(current, "property", lv_property_0_1, null);
                    	    

                    }
                    break;
                case 2 :
                    // InternalLatteCSS.g:2514:8: lv_property_0_2= 'border-left-color'
                    {
                    lv_property_0_2=(Token)match(input,110,FOLLOW_11); 

                            newLeafNode(lv_property_0_2, grammarAccess.getColorPropertyAccess().getPropertyBorderLeftColorKeyword_0_0_1());
                        

                    	        if (current==null) {
                    	            current = createModelElement(grammarAccess.getColorPropertyRule());
                    	        }
                           		setWithLastConsumed(current, "property", lv_property_0_2, null);
                    	    

                    }
                    break;
                case 3 :
                    // InternalLatteCSS.g:2526:8: lv_property_0_3= 'border-right-color'
                    {
                    lv_property_0_3=(Token)match(input,111,FOLLOW_11); 

                            newLeafNode(lv_property_0_3, grammarAccess.getColorPropertyAccess().getPropertyBorderRightColorKeyword_0_0_2());
                        

                    	        if (current==null) {
                    	            current = createModelElement(grammarAccess.getColorPropertyRule());
                    	        }
                           		setWithLastConsumed(current, "property", lv_property_0_3, null);
                    	    

                    }
                    break;
                case 4 :
                    // InternalLatteCSS.g:2538:8: lv_property_0_4= 'border-bottom-color'
                    {
                    lv_property_0_4=(Token)match(input,112,FOLLOW_11); 

                            newLeafNode(lv_property_0_4, grammarAccess.getColorPropertyAccess().getPropertyBorderBottomColorKeyword_0_0_3());
                        

                    	        if (current==null) {
                    	            current = createModelElement(grammarAccess.getColorPropertyRule());
                    	        }
                           		setWithLastConsumed(current, "property", lv_property_0_4, null);
                    	    

                    }
                    break;
                case 5 :
                    // InternalLatteCSS.g:2550:8: lv_property_0_5= 'ripple-color'
                    {
                    lv_property_0_5=(Token)match(input,113,FOLLOW_11); 

                            newLeafNode(lv_property_0_5, grammarAccess.getColorPropertyAccess().getPropertyRippleColorKeyword_0_0_4());
                        

                    	        if (current==null) {
                    	            current = createModelElement(grammarAccess.getColorPropertyRule());
                    	        }
                           		setWithLastConsumed(current, "property", lv_property_0_5, null);
                    	    

                    }
                    break;
                case 6 :
                    // InternalLatteCSS.g:2562:8: lv_property_0_6= 'background-color'
                    {
                    lv_property_0_6=(Token)match(input,114,FOLLOW_11); 

                            newLeafNode(lv_property_0_6, grammarAccess.getColorPropertyAccess().getPropertyBackgroundColorKeyword_0_0_5());
                        

                    	        if (current==null) {
                    	            current = createModelElement(grammarAccess.getColorPropertyRule());
                    	        }
                           		setWithLastConsumed(current, "property", lv_property_0_6, null);
                    	    

                    }
                    break;
                case 7 :
                    // InternalLatteCSS.g:2574:8: lv_property_0_7= 'text-color'
                    {
                    lv_property_0_7=(Token)match(input,115,FOLLOW_11); 

                            newLeafNode(lv_property_0_7, grammarAccess.getColorPropertyAccess().getPropertyTextColorKeyword_0_0_6());
                        

                    	        if (current==null) {
                    	            current = createModelElement(grammarAccess.getColorPropertyRule());
                    	        }
                           		setWithLastConsumed(current, "property", lv_property_0_7, null);
                    	    

                    }
                    break;
                case 8 :
                    // InternalLatteCSS.g:2586:8: lv_property_0_8= 'background-filter-color'
                    {
                    lv_property_0_8=(Token)match(input,116,FOLLOW_11); 

                            newLeafNode(lv_property_0_8, grammarAccess.getColorPropertyAccess().getPropertyBackgroundFilterColorKeyword_0_0_7());
                        

                    	        if (current==null) {
                    	            current = createModelElement(grammarAccess.getColorPropertyRule());
                    	        }
                           		setWithLastConsumed(current, "property", lv_property_0_8, null);
                    	    

                    }
                    break;

            }


            }


            }

            otherlv_1=(Token)match(input,18,FOLLOW_17); 

                	newLeafNode(otherlv_1, grammarAccess.getColorPropertyAccess().getColonKeyword_1());
                
            // InternalLatteCSS.g:2605:1: ( (lv_value_2_0= ruleColorValue ) )
            // InternalLatteCSS.g:2606:1: (lv_value_2_0= ruleColorValue )
            {
            // InternalLatteCSS.g:2606:1: (lv_value_2_0= ruleColorValue )
            // InternalLatteCSS.g:2607:3: lv_value_2_0= ruleColorValue
            {
             
            	        newCompositeNode(grammarAccess.getColorPropertyAccess().getValueColorValueParserRuleCall_2_0()); 
            	    
            pushFollow(FOLLOW_2);
            lv_value_2_0=ruleColorValue();

            state._fsp--;


            	        if (current==null) {
            	            current = createModelElementForParent(grammarAccess.getColorPropertyRule());
            	        }
                   		set(
                   			current, 
                   			"value",
                    		lv_value_2_0, 
                    		"io.lattekit.dsl.LatteCSS.ColorValue");
            	        afterParserOrEnumRuleCall();
            	    

            }


            }


            }


            }

             leaveRule(); 
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleColorProperty"


    // $ANTLR start "entryRuleAlignmentProperty"
    // InternalLatteCSS.g:2631:1: entryRuleAlignmentProperty returns [EObject current=null] : iv_ruleAlignmentProperty= ruleAlignmentProperty EOF ;
    public final EObject entryRuleAlignmentProperty() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleAlignmentProperty = null;


        try {
            // InternalLatteCSS.g:2632:2: (iv_ruleAlignmentProperty= ruleAlignmentProperty EOF )
            // InternalLatteCSS.g:2633:2: iv_ruleAlignmentProperty= ruleAlignmentProperty EOF
            {
             newCompositeNode(grammarAccess.getAlignmentPropertyRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleAlignmentProperty=ruleAlignmentProperty();

            state._fsp--;

             current =iv_ruleAlignmentProperty; 
            match(input,EOF,FOLLOW_2); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleAlignmentProperty"


    // $ANTLR start "ruleAlignmentProperty"
    // InternalLatteCSS.g:2640:1: ruleAlignmentProperty returns [EObject current=null] : ( ( (lv_property_0_0= 'text-align' ) ) otherlv_1= ':' ( ( (lv_value_2_1= 'left' | lv_value_2_2= 'center' | lv_value_2_3= 'right' | lv_value_2_4= 'justify' ) ) ) ) ;
    public final EObject ruleAlignmentProperty() throws RecognitionException {
        EObject current = null;

        Token lv_property_0_0=null;
        Token otherlv_1=null;
        Token lv_value_2_1=null;
        Token lv_value_2_2=null;
        Token lv_value_2_3=null;
        Token lv_value_2_4=null;

         enterRule(); 
            
        try {
            // InternalLatteCSS.g:2643:28: ( ( ( (lv_property_0_0= 'text-align' ) ) otherlv_1= ':' ( ( (lv_value_2_1= 'left' | lv_value_2_2= 'center' | lv_value_2_3= 'right' | lv_value_2_4= 'justify' ) ) ) ) )
            // InternalLatteCSS.g:2644:1: ( ( (lv_property_0_0= 'text-align' ) ) otherlv_1= ':' ( ( (lv_value_2_1= 'left' | lv_value_2_2= 'center' | lv_value_2_3= 'right' | lv_value_2_4= 'justify' ) ) ) )
            {
            // InternalLatteCSS.g:2644:1: ( ( (lv_property_0_0= 'text-align' ) ) otherlv_1= ':' ( ( (lv_value_2_1= 'left' | lv_value_2_2= 'center' | lv_value_2_3= 'right' | lv_value_2_4= 'justify' ) ) ) )
            // InternalLatteCSS.g:2644:2: ( (lv_property_0_0= 'text-align' ) ) otherlv_1= ':' ( ( (lv_value_2_1= 'left' | lv_value_2_2= 'center' | lv_value_2_3= 'right' | lv_value_2_4= 'justify' ) ) )
            {
            // InternalLatteCSS.g:2644:2: ( (lv_property_0_0= 'text-align' ) )
            // InternalLatteCSS.g:2645:1: (lv_property_0_0= 'text-align' )
            {
            // InternalLatteCSS.g:2645:1: (lv_property_0_0= 'text-align' )
            // InternalLatteCSS.g:2646:3: lv_property_0_0= 'text-align'
            {
            lv_property_0_0=(Token)match(input,117,FOLLOW_11); 

                    newLeafNode(lv_property_0_0, grammarAccess.getAlignmentPropertyAccess().getPropertyTextAlignKeyword_0_0());
                

            	        if (current==null) {
            	            current = createModelElement(grammarAccess.getAlignmentPropertyRule());
            	        }
                   		setWithLastConsumed(current, "property", lv_property_0_0, "text-align");
            	    

            }


            }

            otherlv_1=(Token)match(input,18,FOLLOW_29); 

                	newLeafNode(otherlv_1, grammarAccess.getAlignmentPropertyAccess().getColonKeyword_1());
                
            // InternalLatteCSS.g:2663:1: ( ( (lv_value_2_1= 'left' | lv_value_2_2= 'center' | lv_value_2_3= 'right' | lv_value_2_4= 'justify' ) ) )
            // InternalLatteCSS.g:2664:1: ( (lv_value_2_1= 'left' | lv_value_2_2= 'center' | lv_value_2_3= 'right' | lv_value_2_4= 'justify' ) )
            {
            // InternalLatteCSS.g:2664:1: ( (lv_value_2_1= 'left' | lv_value_2_2= 'center' | lv_value_2_3= 'right' | lv_value_2_4= 'justify' ) )
            // InternalLatteCSS.g:2665:1: (lv_value_2_1= 'left' | lv_value_2_2= 'center' | lv_value_2_3= 'right' | lv_value_2_4= 'justify' )
            {
            // InternalLatteCSS.g:2665:1: (lv_value_2_1= 'left' | lv_value_2_2= 'center' | lv_value_2_3= 'right' | lv_value_2_4= 'justify' )
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
                    // InternalLatteCSS.g:2666:3: lv_value_2_1= 'left'
                    {
                    lv_value_2_1=(Token)match(input,76,FOLLOW_2); 

                            newLeafNode(lv_value_2_1, grammarAccess.getAlignmentPropertyAccess().getValueLeftKeyword_2_0_0());
                        

                    	        if (current==null) {
                    	            current = createModelElement(grammarAccess.getAlignmentPropertyRule());
                    	        }
                           		setWithLastConsumed(current, "value", lv_value_2_1, null);
                    	    

                    }
                    break;
                case 2 :
                    // InternalLatteCSS.g:2678:8: lv_value_2_2= 'center'
                    {
                    lv_value_2_2=(Token)match(input,82,FOLLOW_2); 

                            newLeafNode(lv_value_2_2, grammarAccess.getAlignmentPropertyAccess().getValueCenterKeyword_2_0_1());
                        

                    	        if (current==null) {
                    	            current = createModelElement(grammarAccess.getAlignmentPropertyRule());
                    	        }
                           		setWithLastConsumed(current, "value", lv_value_2_2, null);
                    	    

                    }
                    break;
                case 3 :
                    // InternalLatteCSS.g:2690:8: lv_value_2_3= 'right'
                    {
                    lv_value_2_3=(Token)match(input,77,FOLLOW_2); 

                            newLeafNode(lv_value_2_3, grammarAccess.getAlignmentPropertyAccess().getValueRightKeyword_2_0_2());
                        

                    	        if (current==null) {
                    	            current = createModelElement(grammarAccess.getAlignmentPropertyRule());
                    	        }
                           		setWithLastConsumed(current, "value", lv_value_2_3, null);
                    	    

                    }
                    break;
                case 4 :
                    // InternalLatteCSS.g:2702:8: lv_value_2_4= 'justify'
                    {
                    lv_value_2_4=(Token)match(input,118,FOLLOW_2); 

                            newLeafNode(lv_value_2_4, grammarAccess.getAlignmentPropertyAccess().getValueJustifyKeyword_2_0_3());
                        

                    	        if (current==null) {
                    	            current = createModelElement(grammarAccess.getAlignmentPropertyRule());
                    	        }
                           		setWithLastConsumed(current, "value", lv_value_2_4, null);
                    	    

                    }
                    break;

            }


            }


            }


            }


            }

             leaveRule(); 
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleAlignmentProperty"


    // $ANTLR start "entryRuleTimingFunction"
    // InternalLatteCSS.g:2725:1: entryRuleTimingFunction returns [String current=null] : iv_ruleTimingFunction= ruleTimingFunction EOF ;
    public final String entryRuleTimingFunction() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleTimingFunction = null;


        try {
            // InternalLatteCSS.g:2726:2: (iv_ruleTimingFunction= ruleTimingFunction EOF )
            // InternalLatteCSS.g:2727:2: iv_ruleTimingFunction= ruleTimingFunction EOF
            {
             newCompositeNode(grammarAccess.getTimingFunctionRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleTimingFunction=ruleTimingFunction();

            state._fsp--;

             current =iv_ruleTimingFunction.getText(); 
            match(input,EOF,FOLLOW_2); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleTimingFunction"


    // $ANTLR start "ruleTimingFunction"
    // InternalLatteCSS.g:2734:1: ruleTimingFunction returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (kw= 'accelerate-decelerate' | kw= 'accelerate' | kw= 'anticipate' | kw= 'anticipate-overshoot' | kw= 'bounce' | kw= 'cycle' | kw= 'decelerate' | kw= 'fast-out' | kw= 'fast-out-slow' | kw= 'linear' | kw= 'linear-out' | kw= 'overshoot' ) ;
    public final AntlrDatatypeRuleToken ruleTimingFunction() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token kw=null;

         enterRule(); 
            
        try {
            // InternalLatteCSS.g:2737:28: ( (kw= 'accelerate-decelerate' | kw= 'accelerate' | kw= 'anticipate' | kw= 'anticipate-overshoot' | kw= 'bounce' | kw= 'cycle' | kw= 'decelerate' | kw= 'fast-out' | kw= 'fast-out-slow' | kw= 'linear' | kw= 'linear-out' | kw= 'overshoot' ) )
            // InternalLatteCSS.g:2738:1: (kw= 'accelerate-decelerate' | kw= 'accelerate' | kw= 'anticipate' | kw= 'anticipate-overshoot' | kw= 'bounce' | kw= 'cycle' | kw= 'decelerate' | kw= 'fast-out' | kw= 'fast-out-slow' | kw= 'linear' | kw= 'linear-out' | kw= 'overshoot' )
            {
            // InternalLatteCSS.g:2738:1: (kw= 'accelerate-decelerate' | kw= 'accelerate' | kw= 'anticipate' | kw= 'anticipate-overshoot' | kw= 'bounce' | kw= 'cycle' | kw= 'decelerate' | kw= 'fast-out' | kw= 'fast-out-slow' | kw= 'linear' | kw= 'linear-out' | kw= 'overshoot' )
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
                    // InternalLatteCSS.g:2739:2: kw= 'accelerate-decelerate'
                    {
                    kw=(Token)match(input,119,FOLLOW_2); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getTimingFunctionAccess().getAccelerateDecelerateKeyword_0()); 
                        

                    }
                    break;
                case 2 :
                    // InternalLatteCSS.g:2746:2: kw= 'accelerate'
                    {
                    kw=(Token)match(input,120,FOLLOW_2); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getTimingFunctionAccess().getAccelerateKeyword_1()); 
                        

                    }
                    break;
                case 3 :
                    // InternalLatteCSS.g:2753:2: kw= 'anticipate'
                    {
                    kw=(Token)match(input,121,FOLLOW_2); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getTimingFunctionAccess().getAnticipateKeyword_2()); 
                        

                    }
                    break;
                case 4 :
                    // InternalLatteCSS.g:2760:2: kw= 'anticipate-overshoot'
                    {
                    kw=(Token)match(input,122,FOLLOW_2); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getTimingFunctionAccess().getAnticipateOvershootKeyword_3()); 
                        

                    }
                    break;
                case 5 :
                    // InternalLatteCSS.g:2767:2: kw= 'bounce'
                    {
                    kw=(Token)match(input,123,FOLLOW_2); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getTimingFunctionAccess().getBounceKeyword_4()); 
                        

                    }
                    break;
                case 6 :
                    // InternalLatteCSS.g:2774:2: kw= 'cycle'
                    {
                    kw=(Token)match(input,124,FOLLOW_2); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getTimingFunctionAccess().getCycleKeyword_5()); 
                        

                    }
                    break;
                case 7 :
                    // InternalLatteCSS.g:2781:2: kw= 'decelerate'
                    {
                    kw=(Token)match(input,125,FOLLOW_2); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getTimingFunctionAccess().getDecelerateKeyword_6()); 
                        

                    }
                    break;
                case 8 :
                    // InternalLatteCSS.g:2788:2: kw= 'fast-out'
                    {
                    kw=(Token)match(input,126,FOLLOW_2); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getTimingFunctionAccess().getFastOutKeyword_7()); 
                        

                    }
                    break;
                case 9 :
                    // InternalLatteCSS.g:2795:2: kw= 'fast-out-slow'
                    {
                    kw=(Token)match(input,127,FOLLOW_2); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getTimingFunctionAccess().getFastOutSlowKeyword_8()); 
                        

                    }
                    break;
                case 10 :
                    // InternalLatteCSS.g:2802:2: kw= 'linear'
                    {
                    kw=(Token)match(input,128,FOLLOW_2); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getTimingFunctionAccess().getLinearKeyword_9()); 
                        

                    }
                    break;
                case 11 :
                    // InternalLatteCSS.g:2809:2: kw= 'linear-out'
                    {
                    kw=(Token)match(input,129,FOLLOW_2); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getTimingFunctionAccess().getLinearOutKeyword_10()); 
                        

                    }
                    break;
                case 12 :
                    // InternalLatteCSS.g:2816:2: kw= 'overshoot'
                    {
                    kw=(Token)match(input,130,FOLLOW_2); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getTimingFunctionAccess().getOvershootKeyword_11()); 
                        

                    }
                    break;

            }


            }

             leaveRule(); 
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleTimingFunction"


    // $ANTLR start "entryRulePropertyNameValue"
    // InternalLatteCSS.g:2829:1: entryRulePropertyNameValue returns [String current=null] : iv_rulePropertyNameValue= rulePropertyNameValue EOF ;
    public final String entryRulePropertyNameValue() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_rulePropertyNameValue = null;


        try {
            // InternalLatteCSS.g:2830:2: (iv_rulePropertyNameValue= rulePropertyNameValue EOF )
            // InternalLatteCSS.g:2831:2: iv_rulePropertyNameValue= rulePropertyNameValue EOF
            {
             newCompositeNode(grammarAccess.getPropertyNameValueRule()); 
            pushFollow(FOLLOW_1);
            iv_rulePropertyNameValue=rulePropertyNameValue();

            state._fsp--;

             current =iv_rulePropertyNameValue.getText(); 
            match(input,EOF,FOLLOW_2); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRulePropertyNameValue"


    // $ANTLR start "rulePropertyNameValue"
    // InternalLatteCSS.g:2838:1: rulePropertyNameValue returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (kw= 'margin' | kw= 'margin-top' | kw= 'margin-bottom' | kw= 'margin-left' | kw= 'margin-right' | kw= 'padding' | kw= 'padding-top' | kw= 'padding-bottom' | kw= 'padding-left' | kw= 'padding-right' | kw= 'width' | kw= 'height' | kw= 'translateX' | kw= 'translateY' | kw= 'x' | kw= 'y' | kw= 'elevation' | kw= 'font-size' | kw= 'border-radius' | kw= 'border-top-left-radius' | kw= 'border-top-right-radius' | kw= 'border-bottom-left-radius' | kw= 'border-bottom-right-radius' | kw= 'border-width' | kw= 'border-left-width' | kw= 'border-right-width' | kw= 'border-top-width' | kw= 'border-bottom-width' | kw= 'border' ) ;
    public final AntlrDatatypeRuleToken rulePropertyNameValue() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token kw=null;

         enterRule(); 
            
        try {
            // InternalLatteCSS.g:2841:28: ( (kw= 'margin' | kw= 'margin-top' | kw= 'margin-bottom' | kw= 'margin-left' | kw= 'margin-right' | kw= 'padding' | kw= 'padding-top' | kw= 'padding-bottom' | kw= 'padding-left' | kw= 'padding-right' | kw= 'width' | kw= 'height' | kw= 'translateX' | kw= 'translateY' | kw= 'x' | kw= 'y' | kw= 'elevation' | kw= 'font-size' | kw= 'border-radius' | kw= 'border-top-left-radius' | kw= 'border-top-right-radius' | kw= 'border-bottom-left-radius' | kw= 'border-bottom-right-radius' | kw= 'border-width' | kw= 'border-left-width' | kw= 'border-right-width' | kw= 'border-top-width' | kw= 'border-bottom-width' | kw= 'border' ) )
            // InternalLatteCSS.g:2842:1: (kw= 'margin' | kw= 'margin-top' | kw= 'margin-bottom' | kw= 'margin-left' | kw= 'margin-right' | kw= 'padding' | kw= 'padding-top' | kw= 'padding-bottom' | kw= 'padding-left' | kw= 'padding-right' | kw= 'width' | kw= 'height' | kw= 'translateX' | kw= 'translateY' | kw= 'x' | kw= 'y' | kw= 'elevation' | kw= 'font-size' | kw= 'border-radius' | kw= 'border-top-left-radius' | kw= 'border-top-right-radius' | kw= 'border-bottom-left-radius' | kw= 'border-bottom-right-radius' | kw= 'border-width' | kw= 'border-left-width' | kw= 'border-right-width' | kw= 'border-top-width' | kw= 'border-bottom-width' | kw= 'border' )
            {
            // InternalLatteCSS.g:2842:1: (kw= 'margin' | kw= 'margin-top' | kw= 'margin-bottom' | kw= 'margin-left' | kw= 'margin-right' | kw= 'padding' | kw= 'padding-top' | kw= 'padding-bottom' | kw= 'padding-left' | kw= 'padding-right' | kw= 'width' | kw= 'height' | kw= 'translateX' | kw= 'translateY' | kw= 'x' | kw= 'y' | kw= 'elevation' | kw= 'font-size' | kw= 'border-radius' | kw= 'border-top-left-radius' | kw= 'border-top-right-radius' | kw= 'border-bottom-left-radius' | kw= 'border-bottom-right-radius' | kw= 'border-width' | kw= 'border-left-width' | kw= 'border-right-width' | kw= 'border-top-width' | kw= 'border-bottom-width' | kw= 'border' )
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
                    // InternalLatteCSS.g:2843:2: kw= 'margin'
                    {
                    kw=(Token)match(input,29,FOLLOW_2); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getPropertyNameValueAccess().getMarginKeyword_0()); 
                        

                    }
                    break;
                case 2 :
                    // InternalLatteCSS.g:2850:2: kw= 'margin-top'
                    {
                    kw=(Token)match(input,44,FOLLOW_2); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getPropertyNameValueAccess().getMarginTopKeyword_1()); 
                        

                    }
                    break;
                case 3 :
                    // InternalLatteCSS.g:2857:2: kw= 'margin-bottom'
                    {
                    kw=(Token)match(input,45,FOLLOW_2); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getPropertyNameValueAccess().getMarginBottomKeyword_2()); 
                        

                    }
                    break;
                case 4 :
                    // InternalLatteCSS.g:2864:2: kw= 'margin-left'
                    {
                    kw=(Token)match(input,42,FOLLOW_2); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getPropertyNameValueAccess().getMarginLeftKeyword_3()); 
                        

                    }
                    break;
                case 5 :
                    // InternalLatteCSS.g:2871:2: kw= 'margin-right'
                    {
                    kw=(Token)match(input,43,FOLLOW_2); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getPropertyNameValueAccess().getMarginRightKeyword_4()); 
                        

                    }
                    break;
                case 6 :
                    // InternalLatteCSS.g:2878:2: kw= 'padding'
                    {
                    kw=(Token)match(input,30,FOLLOW_2); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getPropertyNameValueAccess().getPaddingKeyword_5()); 
                        

                    }
                    break;
                case 7 :
                    // InternalLatteCSS.g:2885:2: kw= 'padding-top'
                    {
                    kw=(Token)match(input,48,FOLLOW_2); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getPropertyNameValueAccess().getPaddingTopKeyword_6()); 
                        

                    }
                    break;
                case 8 :
                    // InternalLatteCSS.g:2892:2: kw= 'padding-bottom'
                    {
                    kw=(Token)match(input,49,FOLLOW_2); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getPropertyNameValueAccess().getPaddingBottomKeyword_7()); 
                        

                    }
                    break;
                case 9 :
                    // InternalLatteCSS.g:2899:2: kw= 'padding-left'
                    {
                    kw=(Token)match(input,46,FOLLOW_2); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getPropertyNameValueAccess().getPaddingLeftKeyword_8()); 
                        

                    }
                    break;
                case 10 :
                    // InternalLatteCSS.g:2906:2: kw= 'padding-right'
                    {
                    kw=(Token)match(input,47,FOLLOW_2); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getPropertyNameValueAccess().getPaddingRightKeyword_9()); 
                        

                    }
                    break;
                case 11 :
                    // InternalLatteCSS.g:2913:2: kw= 'width'
                    {
                    kw=(Token)match(input,25,FOLLOW_2); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getPropertyNameValueAccess().getWidthKeyword_10()); 
                        

                    }
                    break;
                case 12 :
                    // InternalLatteCSS.g:2920:2: kw= 'height'
                    {
                    kw=(Token)match(input,26,FOLLOW_2); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getPropertyNameValueAccess().getHeightKeyword_11()); 
                        

                    }
                    break;
                case 13 :
                    // InternalLatteCSS.g:2927:2: kw= 'translateX'
                    {
                    kw=(Token)match(input,131,FOLLOW_2); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getPropertyNameValueAccess().getTranslateXKeyword_12()); 
                        

                    }
                    break;
                case 14 :
                    // InternalLatteCSS.g:2934:2: kw= 'translateY'
                    {
                    kw=(Token)match(input,132,FOLLOW_2); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getPropertyNameValueAccess().getTranslateYKeyword_13()); 
                        

                    }
                    break;
                case 15 :
                    // InternalLatteCSS.g:2941:2: kw= 'x'
                    {
                    kw=(Token)match(input,50,FOLLOW_2); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getPropertyNameValueAccess().getXKeyword_14()); 
                        

                    }
                    break;
                case 16 :
                    // InternalLatteCSS.g:2948:2: kw= 'y'
                    {
                    kw=(Token)match(input,51,FOLLOW_2); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getPropertyNameValueAccess().getYKeyword_15()); 
                        

                    }
                    break;
                case 17 :
                    // InternalLatteCSS.g:2955:2: kw= 'elevation'
                    {
                    kw=(Token)match(input,52,FOLLOW_2); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getPropertyNameValueAccess().getElevationKeyword_16()); 
                        

                    }
                    break;
                case 18 :
                    // InternalLatteCSS.g:2962:2: kw= 'font-size'
                    {
                    kw=(Token)match(input,39,FOLLOW_2); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getPropertyNameValueAccess().getFontSizeKeyword_17()); 
                        

                    }
                    break;
                case 19 :
                    // InternalLatteCSS.g:2969:2: kw= 'border-radius'
                    {
                    kw=(Token)match(input,28,FOLLOW_2); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getPropertyNameValueAccess().getBorderRadiusKeyword_18()); 
                        

                    }
                    break;
                case 20 :
                    // InternalLatteCSS.g:2976:2: kw= 'border-top-left-radius'
                    {
                    kw=(Token)match(input,31,FOLLOW_2); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getPropertyNameValueAccess().getBorderTopLeftRadiusKeyword_19()); 
                        

                    }
                    break;
                case 21 :
                    // InternalLatteCSS.g:2983:2: kw= 'border-top-right-radius'
                    {
                    kw=(Token)match(input,32,FOLLOW_2); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getPropertyNameValueAccess().getBorderTopRightRadiusKeyword_20()); 
                        

                    }
                    break;
                case 22 :
                    // InternalLatteCSS.g:2990:2: kw= 'border-bottom-left-radius'
                    {
                    kw=(Token)match(input,33,FOLLOW_2); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getPropertyNameValueAccess().getBorderBottomLeftRadiusKeyword_21()); 
                        

                    }
                    break;
                case 23 :
                    // InternalLatteCSS.g:2997:2: kw= 'border-bottom-right-radius'
                    {
                    kw=(Token)match(input,34,FOLLOW_2); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getPropertyNameValueAccess().getBorderBottomRightRadiusKeyword_22()); 
                        

                    }
                    break;
                case 24 :
                    // InternalLatteCSS.g:3004:2: kw= 'border-width'
                    {
                    kw=(Token)match(input,27,FOLLOW_2); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getPropertyNameValueAccess().getBorderWidthKeyword_23()); 
                        

                    }
                    break;
                case 25 :
                    // InternalLatteCSS.g:3011:2: kw= 'border-left-width'
                    {
                    kw=(Token)match(input,35,FOLLOW_2); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getPropertyNameValueAccess().getBorderLeftWidthKeyword_24()); 
                        

                    }
                    break;
                case 26 :
                    // InternalLatteCSS.g:3018:2: kw= 'border-right-width'
                    {
                    kw=(Token)match(input,36,FOLLOW_2); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getPropertyNameValueAccess().getBorderRightWidthKeyword_25()); 
                        

                    }
                    break;
                case 27 :
                    // InternalLatteCSS.g:3025:2: kw= 'border-top-width'
                    {
                    kw=(Token)match(input,37,FOLLOW_2); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getPropertyNameValueAccess().getBorderTopWidthKeyword_26()); 
                        

                    }
                    break;
                case 28 :
                    // InternalLatteCSS.g:3032:2: kw= 'border-bottom-width'
                    {
                    kw=(Token)match(input,38,FOLLOW_2); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getPropertyNameValueAccess().getBorderBottomWidthKeyword_27()); 
                        

                    }
                    break;
                case 29 :
                    // InternalLatteCSS.g:3039:2: kw= 'border'
                    {
                    kw=(Token)match(input,57,FOLLOW_2); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getPropertyNameValueAccess().getBorderKeyword_28()); 
                        

                    }
                    break;

            }


            }

             leaveRule(); 
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "rulePropertyNameValue"


    // $ANTLR start "entryRuleNumberValue"
    // InternalLatteCSS.g:3052:1: entryRuleNumberValue returns [String current=null] : iv_ruleNumberValue= ruleNumberValue EOF ;
    public final String entryRuleNumberValue() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleNumberValue = null;


        try {
            // InternalLatteCSS.g:3053:2: (iv_ruleNumberValue= ruleNumberValue EOF )
            // InternalLatteCSS.g:3054:2: iv_ruleNumberValue= ruleNumberValue EOF
            {
             newCompositeNode(grammarAccess.getNumberValueRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleNumberValue=ruleNumberValue();

            state._fsp--;

             current =iv_ruleNumberValue.getText(); 
            match(input,EOF,FOLLOW_2); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleNumberValue"


    // $ANTLR start "ruleNumberValue"
    // InternalLatteCSS.g:3061:1: ruleNumberValue returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (this_IntegerValue_0= ruleIntegerValue | this_RealValue_1= ruleRealValue ) ;
    public final AntlrDatatypeRuleToken ruleNumberValue() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        AntlrDatatypeRuleToken this_IntegerValue_0 = null;

        AntlrDatatypeRuleToken this_RealValue_1 = null;


         enterRule(); 
            
        try {
            // InternalLatteCSS.g:3064:28: ( (this_IntegerValue_0= ruleIntegerValue | this_RealValue_1= ruleRealValue ) )
            // InternalLatteCSS.g:3065:1: (this_IntegerValue_0= ruleIntegerValue | this_RealValue_1= ruleRealValue )
            {
            // InternalLatteCSS.g:3065:1: (this_IntegerValue_0= ruleIntegerValue | this_RealValue_1= ruleRealValue )
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
                    // InternalLatteCSS.g:3066:5: this_IntegerValue_0= ruleIntegerValue
                    {
                     
                            newCompositeNode(grammarAccess.getNumberValueAccess().getIntegerValueParserRuleCall_0()); 
                        
                    pushFollow(FOLLOW_2);
                    this_IntegerValue_0=ruleIntegerValue();

                    state._fsp--;


                    		current.merge(this_IntegerValue_0);
                        
                     
                            afterParserOrEnumRuleCall();
                        

                    }
                    break;
                case 2 :
                    // InternalLatteCSS.g:3078:5: this_RealValue_1= ruleRealValue
                    {
                     
                            newCompositeNode(grammarAccess.getNumberValueAccess().getRealValueParserRuleCall_1()); 
                        
                    pushFollow(FOLLOW_2);
                    this_RealValue_1=ruleRealValue();

                    state._fsp--;


                    		current.merge(this_RealValue_1);
                        
                     
                            afterParserOrEnumRuleCall();
                        

                    }
                    break;

            }


            }

             leaveRule(); 
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleNumberValue"


    // $ANTLR start "entryRuleIntegerValue"
    // InternalLatteCSS.g:3096:1: entryRuleIntegerValue returns [String current=null] : iv_ruleIntegerValue= ruleIntegerValue EOF ;
    public final String entryRuleIntegerValue() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleIntegerValue = null;


        try {
            // InternalLatteCSS.g:3097:2: (iv_ruleIntegerValue= ruleIntegerValue EOF )
            // InternalLatteCSS.g:3098:2: iv_ruleIntegerValue= ruleIntegerValue EOF
            {
             newCompositeNode(grammarAccess.getIntegerValueRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleIntegerValue=ruleIntegerValue();

            state._fsp--;

             current =iv_ruleIntegerValue.getText(); 
            match(input,EOF,FOLLOW_2); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleIntegerValue"


    // $ANTLR start "ruleIntegerValue"
    // InternalLatteCSS.g:3105:1: ruleIntegerValue returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : this_INT_0= RULE_INT ;
    public final AntlrDatatypeRuleToken ruleIntegerValue() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token this_INT_0=null;

         enterRule(); 
            
        try {
            // InternalLatteCSS.g:3108:28: (this_INT_0= RULE_INT )
            // InternalLatteCSS.g:3109:5: this_INT_0= RULE_INT
            {
            this_INT_0=(Token)match(input,RULE_INT,FOLLOW_2); 

            		current.merge(this_INT_0);
                
             
                newLeafNode(this_INT_0, grammarAccess.getIntegerValueAccess().getINTTerminalRuleCall()); 
                

            }

             leaveRule(); 
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleIntegerValue"


    // $ANTLR start "entryRuleRealValue"
    // InternalLatteCSS.g:3124:1: entryRuleRealValue returns [String current=null] : iv_ruleRealValue= ruleRealValue EOF ;
    public final String entryRuleRealValue() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleRealValue = null;


        try {
            // InternalLatteCSS.g:3125:2: (iv_ruleRealValue= ruleRealValue EOF )
            // InternalLatteCSS.g:3126:2: iv_ruleRealValue= ruleRealValue EOF
            {
             newCompositeNode(grammarAccess.getRealValueRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleRealValue=ruleRealValue();

            state._fsp--;

             current =iv_ruleRealValue.getText(); 
            match(input,EOF,FOLLOW_2); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleRealValue"


    // $ANTLR start "ruleRealValue"
    // InternalLatteCSS.g:3133:1: ruleRealValue returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : this_REAL_0= RULE_REAL ;
    public final AntlrDatatypeRuleToken ruleRealValue() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token this_REAL_0=null;

         enterRule(); 
            
        try {
            // InternalLatteCSS.g:3136:28: (this_REAL_0= RULE_REAL )
            // InternalLatteCSS.g:3137:5: this_REAL_0= RULE_REAL
            {
            this_REAL_0=(Token)match(input,RULE_REAL,FOLLOW_2); 

            		current.merge(this_REAL_0);
                
             
                newLeafNode(this_REAL_0, grammarAccess.getRealValueAccess().getREALTerminalRuleCall()); 
                

            }

             leaveRule(); 
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleRealValue"


    // $ANTLR start "entryRuleTimeValue"
    // InternalLatteCSS.g:3152:1: entryRuleTimeValue returns [EObject current=null] : iv_ruleTimeValue= ruleTimeValue EOF ;
    public final EObject entryRuleTimeValue() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleTimeValue = null;


        try {
            // InternalLatteCSS.g:3153:2: (iv_ruleTimeValue= ruleTimeValue EOF )
            // InternalLatteCSS.g:3154:2: iv_ruleTimeValue= ruleTimeValue EOF
            {
             newCompositeNode(grammarAccess.getTimeValueRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleTimeValue=ruleTimeValue();

            state._fsp--;

             current =iv_ruleTimeValue; 
            match(input,EOF,FOLLOW_2); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleTimeValue"


    // $ANTLR start "ruleTimeValue"
    // InternalLatteCSS.g:3161:1: ruleTimeValue returns [EObject current=null] : ( ( (lv_time_0_0= ruleNumberValue ) ) ( ( (lv_unit_1_1= 's' | lv_unit_1_2= 'ms' ) ) ) ) ;
    public final EObject ruleTimeValue() throws RecognitionException {
        EObject current = null;

        Token lv_unit_1_1=null;
        Token lv_unit_1_2=null;
        AntlrDatatypeRuleToken lv_time_0_0 = null;


         enterRule(); 
            
        try {
            // InternalLatteCSS.g:3164:28: ( ( ( (lv_time_0_0= ruleNumberValue ) ) ( ( (lv_unit_1_1= 's' | lv_unit_1_2= 'ms' ) ) ) ) )
            // InternalLatteCSS.g:3165:1: ( ( (lv_time_0_0= ruleNumberValue ) ) ( ( (lv_unit_1_1= 's' | lv_unit_1_2= 'ms' ) ) ) )
            {
            // InternalLatteCSS.g:3165:1: ( ( (lv_time_0_0= ruleNumberValue ) ) ( ( (lv_unit_1_1= 's' | lv_unit_1_2= 'ms' ) ) ) )
            // InternalLatteCSS.g:3165:2: ( (lv_time_0_0= ruleNumberValue ) ) ( ( (lv_unit_1_1= 's' | lv_unit_1_2= 'ms' ) ) )
            {
            // InternalLatteCSS.g:3165:2: ( (lv_time_0_0= ruleNumberValue ) )
            // InternalLatteCSS.g:3166:1: (lv_time_0_0= ruleNumberValue )
            {
            // InternalLatteCSS.g:3166:1: (lv_time_0_0= ruleNumberValue )
            // InternalLatteCSS.g:3167:3: lv_time_0_0= ruleNumberValue
            {
             
            	        newCompositeNode(grammarAccess.getTimeValueAccess().getTimeNumberValueParserRuleCall_0_0()); 
            	    
            pushFollow(FOLLOW_30);
            lv_time_0_0=ruleNumberValue();

            state._fsp--;


            	        if (current==null) {
            	            current = createModelElementForParent(grammarAccess.getTimeValueRule());
            	        }
                   		set(
                   			current, 
                   			"time",
                    		lv_time_0_0, 
                    		"io.lattekit.dsl.LatteCSS.NumberValue");
            	        afterParserOrEnumRuleCall();
            	    

            }


            }

            // InternalLatteCSS.g:3183:2: ( ( (lv_unit_1_1= 's' | lv_unit_1_2= 'ms' ) ) )
            // InternalLatteCSS.g:3184:1: ( (lv_unit_1_1= 's' | lv_unit_1_2= 'ms' ) )
            {
            // InternalLatteCSS.g:3184:1: ( (lv_unit_1_1= 's' | lv_unit_1_2= 'ms' ) )
            // InternalLatteCSS.g:3185:1: (lv_unit_1_1= 's' | lv_unit_1_2= 'ms' )
            {
            // InternalLatteCSS.g:3185:1: (lv_unit_1_1= 's' | lv_unit_1_2= 'ms' )
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
                    // InternalLatteCSS.g:3186:3: lv_unit_1_1= 's'
                    {
                    lv_unit_1_1=(Token)match(input,133,FOLLOW_2); 

                            newLeafNode(lv_unit_1_1, grammarAccess.getTimeValueAccess().getUnitSKeyword_1_0_0());
                        

                    	        if (current==null) {
                    	            current = createModelElement(grammarAccess.getTimeValueRule());
                    	        }
                           		setWithLastConsumed(current, "unit", lv_unit_1_1, null);
                    	    

                    }
                    break;
                case 2 :
                    // InternalLatteCSS.g:3198:8: lv_unit_1_2= 'ms'
                    {
                    lv_unit_1_2=(Token)match(input,134,FOLLOW_2); 

                            newLeafNode(lv_unit_1_2, grammarAccess.getTimeValueAccess().getUnitMsKeyword_1_0_1());
                        

                    	        if (current==null) {
                    	            current = createModelElement(grammarAccess.getTimeValueRule());
                    	        }
                           		setWithLastConsumed(current, "unit", lv_unit_1_2, null);
                    	    

                    }
                    break;

            }


            }


            }


            }


            }

             leaveRule(); 
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleTimeValue"


    // $ANTLR start "entryRuleViewSizeValue"
    // InternalLatteCSS.g:3221:1: entryRuleViewSizeValue returns [EObject current=null] : iv_ruleViewSizeValue= ruleViewSizeValue EOF ;
    public final EObject entryRuleViewSizeValue() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleViewSizeValue = null;


        try {
            // InternalLatteCSS.g:3222:2: (iv_ruleViewSizeValue= ruleViewSizeValue EOF )
            // InternalLatteCSS.g:3223:2: iv_ruleViewSizeValue= ruleViewSizeValue EOF
            {
             newCompositeNode(grammarAccess.getViewSizeValueRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleViewSizeValue=ruleViewSizeValue();

            state._fsp--;

             current =iv_ruleViewSizeValue; 
            match(input,EOF,FOLLOW_2); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleViewSizeValue"


    // $ANTLR start "ruleViewSizeValue"
    // InternalLatteCSS.g:3230:1: ruleViewSizeValue returns [EObject current=null] : ( ( (lv_value_0_0= ruleSizeValue ) ) | ( ( (lv_dynamic_1_1= 'match_parent' | lv_dynamic_1_2= 'wrap_content' ) ) ) ) ;
    public final EObject ruleViewSizeValue() throws RecognitionException {
        EObject current = null;

        Token lv_dynamic_1_1=null;
        Token lv_dynamic_1_2=null;
        EObject lv_value_0_0 = null;


         enterRule(); 
            
        try {
            // InternalLatteCSS.g:3233:28: ( ( ( (lv_value_0_0= ruleSizeValue ) ) | ( ( (lv_dynamic_1_1= 'match_parent' | lv_dynamic_1_2= 'wrap_content' ) ) ) ) )
            // InternalLatteCSS.g:3234:1: ( ( (lv_value_0_0= ruleSizeValue ) ) | ( ( (lv_dynamic_1_1= 'match_parent' | lv_dynamic_1_2= 'wrap_content' ) ) ) )
            {
            // InternalLatteCSS.g:3234:1: ( ( (lv_value_0_0= ruleSizeValue ) ) | ( ( (lv_dynamic_1_1= 'match_parent' | lv_dynamic_1_2= 'wrap_content' ) ) ) )
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
                    // InternalLatteCSS.g:3234:2: ( (lv_value_0_0= ruleSizeValue ) )
                    {
                    // InternalLatteCSS.g:3234:2: ( (lv_value_0_0= ruleSizeValue ) )
                    // InternalLatteCSS.g:3235:1: (lv_value_0_0= ruleSizeValue )
                    {
                    // InternalLatteCSS.g:3235:1: (lv_value_0_0= ruleSizeValue )
                    // InternalLatteCSS.g:3236:3: lv_value_0_0= ruleSizeValue
                    {
                     
                    	        newCompositeNode(grammarAccess.getViewSizeValueAccess().getValueSizeValueParserRuleCall_0_0()); 
                    	    
                    pushFollow(FOLLOW_2);
                    lv_value_0_0=ruleSizeValue();

                    state._fsp--;


                    	        if (current==null) {
                    	            current = createModelElementForParent(grammarAccess.getViewSizeValueRule());
                    	        }
                           		set(
                           			current, 
                           			"value",
                            		lv_value_0_0, 
                            		"io.lattekit.dsl.LatteCSS.SizeValue");
                    	        afterParserOrEnumRuleCall();
                    	    

                    }


                    }


                    }
                    break;
                case 2 :
                    // InternalLatteCSS.g:3253:6: ( ( (lv_dynamic_1_1= 'match_parent' | lv_dynamic_1_2= 'wrap_content' ) ) )
                    {
                    // InternalLatteCSS.g:3253:6: ( ( (lv_dynamic_1_1= 'match_parent' | lv_dynamic_1_2= 'wrap_content' ) ) )
                    // InternalLatteCSS.g:3254:1: ( (lv_dynamic_1_1= 'match_parent' | lv_dynamic_1_2= 'wrap_content' ) )
                    {
                    // InternalLatteCSS.g:3254:1: ( (lv_dynamic_1_1= 'match_parent' | lv_dynamic_1_2= 'wrap_content' ) )
                    // InternalLatteCSS.g:3255:1: (lv_dynamic_1_1= 'match_parent' | lv_dynamic_1_2= 'wrap_content' )
                    {
                    // InternalLatteCSS.g:3255:1: (lv_dynamic_1_1= 'match_parent' | lv_dynamic_1_2= 'wrap_content' )
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
                            // InternalLatteCSS.g:3256:3: lv_dynamic_1_1= 'match_parent'
                            {
                            lv_dynamic_1_1=(Token)match(input,135,FOLLOW_2); 

                                    newLeafNode(lv_dynamic_1_1, grammarAccess.getViewSizeValueAccess().getDynamicMatch_parentKeyword_1_0_0());
                                

                            	        if (current==null) {
                            	            current = createModelElement(grammarAccess.getViewSizeValueRule());
                            	        }
                                   		setWithLastConsumed(current, "dynamic", lv_dynamic_1_1, null);
                            	    

                            }
                            break;
                        case 2 :
                            // InternalLatteCSS.g:3268:8: lv_dynamic_1_2= 'wrap_content'
                            {
                            lv_dynamic_1_2=(Token)match(input,136,FOLLOW_2); 

                                    newLeafNode(lv_dynamic_1_2, grammarAccess.getViewSizeValueAccess().getDynamicWrap_contentKeyword_1_0_1());
                                

                            	        if (current==null) {
                            	            current = createModelElement(grammarAccess.getViewSizeValueRule());
                            	        }
                                   		setWithLastConsumed(current, "dynamic", lv_dynamic_1_2, null);
                            	    

                            }
                            break;

                    }


                    }


                    }


                    }
                    break;

            }


            }

             leaveRule(); 
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleViewSizeValue"


    // $ANTLR start "entryRuleSizeValue"
    // InternalLatteCSS.g:3291:1: entryRuleSizeValue returns [EObject current=null] : iv_ruleSizeValue= ruleSizeValue EOF ;
    public final EObject entryRuleSizeValue() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleSizeValue = null;


        try {
            // InternalLatteCSS.g:3292:2: (iv_ruleSizeValue= ruleSizeValue EOF )
            // InternalLatteCSS.g:3293:2: iv_ruleSizeValue= ruleSizeValue EOF
            {
             newCompositeNode(grammarAccess.getSizeValueRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleSizeValue=ruleSizeValue();

            state._fsp--;

             current =iv_ruleSizeValue; 
            match(input,EOF,FOLLOW_2); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleSizeValue"


    // $ANTLR start "ruleSizeValue"
    // InternalLatteCSS.g:3300:1: ruleSizeValue returns [EObject current=null] : ( ( (lv_value_0_0= ruleNumberValue ) ) ( ( (lv_dimension_1_1= 'dp' | lv_dimension_1_2= 'px' | lv_dimension_1_3= 'sp' | lv_dimension_1_4= 'pt' | lv_dimension_1_5= 'mm' ) ) )? ) ;
    public final EObject ruleSizeValue() throws RecognitionException {
        EObject current = null;

        Token lv_dimension_1_1=null;
        Token lv_dimension_1_2=null;
        Token lv_dimension_1_3=null;
        Token lv_dimension_1_4=null;
        Token lv_dimension_1_5=null;
        AntlrDatatypeRuleToken lv_value_0_0 = null;


         enterRule(); 
            
        try {
            // InternalLatteCSS.g:3303:28: ( ( ( (lv_value_0_0= ruleNumberValue ) ) ( ( (lv_dimension_1_1= 'dp' | lv_dimension_1_2= 'px' | lv_dimension_1_3= 'sp' | lv_dimension_1_4= 'pt' | lv_dimension_1_5= 'mm' ) ) )? ) )
            // InternalLatteCSS.g:3304:1: ( ( (lv_value_0_0= ruleNumberValue ) ) ( ( (lv_dimension_1_1= 'dp' | lv_dimension_1_2= 'px' | lv_dimension_1_3= 'sp' | lv_dimension_1_4= 'pt' | lv_dimension_1_5= 'mm' ) ) )? )
            {
            // InternalLatteCSS.g:3304:1: ( ( (lv_value_0_0= ruleNumberValue ) ) ( ( (lv_dimension_1_1= 'dp' | lv_dimension_1_2= 'px' | lv_dimension_1_3= 'sp' | lv_dimension_1_4= 'pt' | lv_dimension_1_5= 'mm' ) ) )? )
            // InternalLatteCSS.g:3304:2: ( (lv_value_0_0= ruleNumberValue ) ) ( ( (lv_dimension_1_1= 'dp' | lv_dimension_1_2= 'px' | lv_dimension_1_3= 'sp' | lv_dimension_1_4= 'pt' | lv_dimension_1_5= 'mm' ) ) )?
            {
            // InternalLatteCSS.g:3304:2: ( (lv_value_0_0= ruleNumberValue ) )
            // InternalLatteCSS.g:3305:1: (lv_value_0_0= ruleNumberValue )
            {
            // InternalLatteCSS.g:3305:1: (lv_value_0_0= ruleNumberValue )
            // InternalLatteCSS.g:3306:3: lv_value_0_0= ruleNumberValue
            {
             
            	        newCompositeNode(grammarAccess.getSizeValueAccess().getValueNumberValueParserRuleCall_0_0()); 
            	    
            pushFollow(FOLLOW_31);
            lv_value_0_0=ruleNumberValue();

            state._fsp--;


            	        if (current==null) {
            	            current = createModelElementForParent(grammarAccess.getSizeValueRule());
            	        }
                   		set(
                   			current, 
                   			"value",
                    		lv_value_0_0, 
                    		"io.lattekit.dsl.LatteCSS.NumberValue");
            	        afterParserOrEnumRuleCall();
            	    

            }


            }

            // InternalLatteCSS.g:3322:2: ( ( (lv_dimension_1_1= 'dp' | lv_dimension_1_2= 'px' | lv_dimension_1_3= 'sp' | lv_dimension_1_4= 'pt' | lv_dimension_1_5= 'mm' ) ) )?
            int alt39=2;
            int LA39_0 = input.LA(1);

            if ( ((LA39_0>=137 && LA39_0<=141)) ) {
                alt39=1;
            }
            switch (alt39) {
                case 1 :
                    // InternalLatteCSS.g:3323:1: ( (lv_dimension_1_1= 'dp' | lv_dimension_1_2= 'px' | lv_dimension_1_3= 'sp' | lv_dimension_1_4= 'pt' | lv_dimension_1_5= 'mm' ) )
                    {
                    // InternalLatteCSS.g:3323:1: ( (lv_dimension_1_1= 'dp' | lv_dimension_1_2= 'px' | lv_dimension_1_3= 'sp' | lv_dimension_1_4= 'pt' | lv_dimension_1_5= 'mm' ) )
                    // InternalLatteCSS.g:3324:1: (lv_dimension_1_1= 'dp' | lv_dimension_1_2= 'px' | lv_dimension_1_3= 'sp' | lv_dimension_1_4= 'pt' | lv_dimension_1_5= 'mm' )
                    {
                    // InternalLatteCSS.g:3324:1: (lv_dimension_1_1= 'dp' | lv_dimension_1_2= 'px' | lv_dimension_1_3= 'sp' | lv_dimension_1_4= 'pt' | lv_dimension_1_5= 'mm' )
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
                            // InternalLatteCSS.g:3325:3: lv_dimension_1_1= 'dp'
                            {
                            lv_dimension_1_1=(Token)match(input,137,FOLLOW_2); 

                                    newLeafNode(lv_dimension_1_1, grammarAccess.getSizeValueAccess().getDimensionDpKeyword_1_0_0());
                                

                            	        if (current==null) {
                            	            current = createModelElement(grammarAccess.getSizeValueRule());
                            	        }
                                   		setWithLastConsumed(current, "dimension", lv_dimension_1_1, null);
                            	    

                            }
                            break;
                        case 2 :
                            // InternalLatteCSS.g:3337:8: lv_dimension_1_2= 'px'
                            {
                            lv_dimension_1_2=(Token)match(input,138,FOLLOW_2); 

                                    newLeafNode(lv_dimension_1_2, grammarAccess.getSizeValueAccess().getDimensionPxKeyword_1_0_1());
                                

                            	        if (current==null) {
                            	            current = createModelElement(grammarAccess.getSizeValueRule());
                            	        }
                                   		setWithLastConsumed(current, "dimension", lv_dimension_1_2, null);
                            	    

                            }
                            break;
                        case 3 :
                            // InternalLatteCSS.g:3349:8: lv_dimension_1_3= 'sp'
                            {
                            lv_dimension_1_3=(Token)match(input,139,FOLLOW_2); 

                                    newLeafNode(lv_dimension_1_3, grammarAccess.getSizeValueAccess().getDimensionSpKeyword_1_0_2());
                                

                            	        if (current==null) {
                            	            current = createModelElement(grammarAccess.getSizeValueRule());
                            	        }
                                   		setWithLastConsumed(current, "dimension", lv_dimension_1_3, null);
                            	    

                            }
                            break;
                        case 4 :
                            // InternalLatteCSS.g:3361:8: lv_dimension_1_4= 'pt'
                            {
                            lv_dimension_1_4=(Token)match(input,140,FOLLOW_2); 

                                    newLeafNode(lv_dimension_1_4, grammarAccess.getSizeValueAccess().getDimensionPtKeyword_1_0_3());
                                

                            	        if (current==null) {
                            	            current = createModelElement(grammarAccess.getSizeValueRule());
                            	        }
                                   		setWithLastConsumed(current, "dimension", lv_dimension_1_4, null);
                            	    

                            }
                            break;
                        case 5 :
                            // InternalLatteCSS.g:3373:8: lv_dimension_1_5= 'mm'
                            {
                            lv_dimension_1_5=(Token)match(input,141,FOLLOW_2); 

                                    newLeafNode(lv_dimension_1_5, grammarAccess.getSizeValueAccess().getDimensionMmKeyword_1_0_4());
                                

                            	        if (current==null) {
                            	            current = createModelElement(grammarAccess.getSizeValueRule());
                            	        }
                                   		setWithLastConsumed(current, "dimension", lv_dimension_1_5, null);
                            	    

                            }
                            break;

                    }


                    }


                    }
                    break;

            }


            }


            }

             leaveRule(); 
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleSizeValue"


    // $ANTLR start "entryRulePaintValue"
    // InternalLatteCSS.g:3400:1: entryRulePaintValue returns [EObject current=null] : iv_rulePaintValue= rulePaintValue EOF ;
    public final EObject entryRulePaintValue() throws RecognitionException {
        EObject current = null;

        EObject iv_rulePaintValue = null;


        try {
            // InternalLatteCSS.g:3401:2: (iv_rulePaintValue= rulePaintValue EOF )
            // InternalLatteCSS.g:3402:2: iv_rulePaintValue= rulePaintValue EOF
            {
             newCompositeNode(grammarAccess.getPaintValueRule()); 
            pushFollow(FOLLOW_1);
            iv_rulePaintValue=rulePaintValue();

            state._fsp--;

             current =iv_rulePaintValue; 
            match(input,EOF,FOLLOW_2); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRulePaintValue"


    // $ANTLR start "rulePaintValue"
    // InternalLatteCSS.g:3409:1: rulePaintValue returns [EObject current=null] : (this_LinearGradient_0= ruleLinearGradient | this_RadialGradient_1= ruleRadialGradient | this_ColorValue_2= ruleColorValue ) ;
    public final EObject rulePaintValue() throws RecognitionException {
        EObject current = null;

        EObject this_LinearGradient_0 = null;

        EObject this_RadialGradient_1 = null;

        EObject this_ColorValue_2 = null;


         enterRule(); 
            
        try {
            // InternalLatteCSS.g:3412:28: ( (this_LinearGradient_0= ruleLinearGradient | this_RadialGradient_1= ruleRadialGradient | this_ColorValue_2= ruleColorValue ) )
            // InternalLatteCSS.g:3413:1: (this_LinearGradient_0= ruleLinearGradient | this_RadialGradient_1= ruleRadialGradient | this_ColorValue_2= ruleColorValue )
            {
            // InternalLatteCSS.g:3413:1: (this_LinearGradient_0= ruleLinearGradient | this_RadialGradient_1= ruleRadialGradient | this_ColorValue_2= ruleColorValue )
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
                    // InternalLatteCSS.g:3414:5: this_LinearGradient_0= ruleLinearGradient
                    {
                     
                            newCompositeNode(grammarAccess.getPaintValueAccess().getLinearGradientParserRuleCall_0()); 
                        
                    pushFollow(FOLLOW_2);
                    this_LinearGradient_0=ruleLinearGradient();

                    state._fsp--;

                     
                            current = this_LinearGradient_0; 
                            afterParserOrEnumRuleCall();
                        

                    }
                    break;
                case 2 :
                    // InternalLatteCSS.g:3424:5: this_RadialGradient_1= ruleRadialGradient
                    {
                     
                            newCompositeNode(grammarAccess.getPaintValueAccess().getRadialGradientParserRuleCall_1()); 
                        
                    pushFollow(FOLLOW_2);
                    this_RadialGradient_1=ruleRadialGradient();

                    state._fsp--;

                     
                            current = this_RadialGradient_1; 
                            afterParserOrEnumRuleCall();
                        

                    }
                    break;
                case 3 :
                    // InternalLatteCSS.g:3434:5: this_ColorValue_2= ruleColorValue
                    {
                     
                            newCompositeNode(grammarAccess.getPaintValueAccess().getColorValueParserRuleCall_2()); 
                        
                    pushFollow(FOLLOW_2);
                    this_ColorValue_2=ruleColorValue();

                    state._fsp--;

                     
                            current = this_ColorValue_2; 
                            afterParserOrEnumRuleCall();
                        

                    }
                    break;

            }


            }

             leaveRule(); 
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "rulePaintValue"


    // $ANTLR start "entryRuleLinearGradient"
    // InternalLatteCSS.g:3450:1: entryRuleLinearGradient returns [EObject current=null] : iv_ruleLinearGradient= ruleLinearGradient EOF ;
    public final EObject entryRuleLinearGradient() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleLinearGradient = null;


        try {
            // InternalLatteCSS.g:3451:2: (iv_ruleLinearGradient= ruleLinearGradient EOF )
            // InternalLatteCSS.g:3452:2: iv_ruleLinearGradient= ruleLinearGradient EOF
            {
             newCompositeNode(grammarAccess.getLinearGradientRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleLinearGradient=ruleLinearGradient();

            state._fsp--;

             current =iv_ruleLinearGradient; 
            match(input,EOF,FOLLOW_2); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleLinearGradient"


    // $ANTLR start "ruleLinearGradient"
    // InternalLatteCSS.g:3459:1: ruleLinearGradient returns [EObject current=null] : (otherlv_0= 'linear' otherlv_1= '(' ( (lv_x1_2_0= ruleSizeValue ) ) otherlv_3= ',' ( (lv_y1_4_0= ruleSizeValue ) ) otherlv_5= ')' otherlv_6= 'to' otherlv_7= '(' ( (lv_x2_8_0= ruleSizeValue ) ) otherlv_9= ',' ( (lv_y2_10_0= ruleSizeValue ) ) otherlv_11= ')' otherlv_12= 'stops' (otherlv_13= '(' ( (lv_stops_14_0= ruleStopValue ) ) otherlv_15= ')' )+ (otherlv_16= 'repeat' | otherlv_17= 'reflect' )? ) ;
    public final EObject ruleLinearGradient() throws RecognitionException {
        EObject current = null;

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
        EObject lv_x1_2_0 = null;

        EObject lv_y1_4_0 = null;

        EObject lv_x2_8_0 = null;

        EObject lv_y2_10_0 = null;

        EObject lv_stops_14_0 = null;


         enterRule(); 
            
        try {
            // InternalLatteCSS.g:3462:28: ( (otherlv_0= 'linear' otherlv_1= '(' ( (lv_x1_2_0= ruleSizeValue ) ) otherlv_3= ',' ( (lv_y1_4_0= ruleSizeValue ) ) otherlv_5= ')' otherlv_6= 'to' otherlv_7= '(' ( (lv_x2_8_0= ruleSizeValue ) ) otherlv_9= ',' ( (lv_y2_10_0= ruleSizeValue ) ) otherlv_11= ')' otherlv_12= 'stops' (otherlv_13= '(' ( (lv_stops_14_0= ruleStopValue ) ) otherlv_15= ')' )+ (otherlv_16= 'repeat' | otherlv_17= 'reflect' )? ) )
            // InternalLatteCSS.g:3463:1: (otherlv_0= 'linear' otherlv_1= '(' ( (lv_x1_2_0= ruleSizeValue ) ) otherlv_3= ',' ( (lv_y1_4_0= ruleSizeValue ) ) otherlv_5= ')' otherlv_6= 'to' otherlv_7= '(' ( (lv_x2_8_0= ruleSizeValue ) ) otherlv_9= ',' ( (lv_y2_10_0= ruleSizeValue ) ) otherlv_11= ')' otherlv_12= 'stops' (otherlv_13= '(' ( (lv_stops_14_0= ruleStopValue ) ) otherlv_15= ')' )+ (otherlv_16= 'repeat' | otherlv_17= 'reflect' )? )
            {
            // InternalLatteCSS.g:3463:1: (otherlv_0= 'linear' otherlv_1= '(' ( (lv_x1_2_0= ruleSizeValue ) ) otherlv_3= ',' ( (lv_y1_4_0= ruleSizeValue ) ) otherlv_5= ')' otherlv_6= 'to' otherlv_7= '(' ( (lv_x2_8_0= ruleSizeValue ) ) otherlv_9= ',' ( (lv_y2_10_0= ruleSizeValue ) ) otherlv_11= ')' otherlv_12= 'stops' (otherlv_13= '(' ( (lv_stops_14_0= ruleStopValue ) ) otherlv_15= ')' )+ (otherlv_16= 'repeat' | otherlv_17= 'reflect' )? )
            // InternalLatteCSS.g:3463:3: otherlv_0= 'linear' otherlv_1= '(' ( (lv_x1_2_0= ruleSizeValue ) ) otherlv_3= ',' ( (lv_y1_4_0= ruleSizeValue ) ) otherlv_5= ')' otherlv_6= 'to' otherlv_7= '(' ( (lv_x2_8_0= ruleSizeValue ) ) otherlv_9= ',' ( (lv_y2_10_0= ruleSizeValue ) ) otherlv_11= ')' otherlv_12= 'stops' (otherlv_13= '(' ( (lv_stops_14_0= ruleStopValue ) ) otherlv_15= ')' )+ (otherlv_16= 'repeat' | otherlv_17= 'reflect' )?
            {
            otherlv_0=(Token)match(input,128,FOLLOW_32); 

                	newLeafNode(otherlv_0, grammarAccess.getLinearGradientAccess().getLinearKeyword_0());
                
            otherlv_1=(Token)match(input,142,FOLLOW_15); 

                	newLeafNode(otherlv_1, grammarAccess.getLinearGradientAccess().getLeftParenthesisKeyword_1());
                
            // InternalLatteCSS.g:3471:1: ( (lv_x1_2_0= ruleSizeValue ) )
            // InternalLatteCSS.g:3472:1: (lv_x1_2_0= ruleSizeValue )
            {
            // InternalLatteCSS.g:3472:1: (lv_x1_2_0= ruleSizeValue )
            // InternalLatteCSS.g:3473:3: lv_x1_2_0= ruleSizeValue
            {
             
            	        newCompositeNode(grammarAccess.getLinearGradientAccess().getX1SizeValueParserRuleCall_2_0()); 
            	    
            pushFollow(FOLLOW_33);
            lv_x1_2_0=ruleSizeValue();

            state._fsp--;


            	        if (current==null) {
            	            current = createModelElementForParent(grammarAccess.getLinearGradientRule());
            	        }
                   		set(
                   			current, 
                   			"x1",
                    		lv_x1_2_0, 
                    		"io.lattekit.dsl.LatteCSS.SizeValue");
            	        afterParserOrEnumRuleCall();
            	    

            }


            }

            otherlv_3=(Token)match(input,13,FOLLOW_15); 

                	newLeafNode(otherlv_3, grammarAccess.getLinearGradientAccess().getCommaKeyword_3());
                
            // InternalLatteCSS.g:3493:1: ( (lv_y1_4_0= ruleSizeValue ) )
            // InternalLatteCSS.g:3494:1: (lv_y1_4_0= ruleSizeValue )
            {
            // InternalLatteCSS.g:3494:1: (lv_y1_4_0= ruleSizeValue )
            // InternalLatteCSS.g:3495:3: lv_y1_4_0= ruleSizeValue
            {
             
            	        newCompositeNode(grammarAccess.getLinearGradientAccess().getY1SizeValueParserRuleCall_4_0()); 
            	    
            pushFollow(FOLLOW_34);
            lv_y1_4_0=ruleSizeValue();

            state._fsp--;


            	        if (current==null) {
            	            current = createModelElementForParent(grammarAccess.getLinearGradientRule());
            	        }
                   		set(
                   			current, 
                   			"y1",
                    		lv_y1_4_0, 
                    		"io.lattekit.dsl.LatteCSS.SizeValue");
            	        afterParserOrEnumRuleCall();
            	    

            }


            }

            otherlv_5=(Token)match(input,143,FOLLOW_35); 

                	newLeafNode(otherlv_5, grammarAccess.getLinearGradientAccess().getRightParenthesisKeyword_5());
                
            otherlv_6=(Token)match(input,144,FOLLOW_32); 

                	newLeafNode(otherlv_6, grammarAccess.getLinearGradientAccess().getToKeyword_6());
                
            otherlv_7=(Token)match(input,142,FOLLOW_15); 

                	newLeafNode(otherlv_7, grammarAccess.getLinearGradientAccess().getLeftParenthesisKeyword_7());
                
            // InternalLatteCSS.g:3523:1: ( (lv_x2_8_0= ruleSizeValue ) )
            // InternalLatteCSS.g:3524:1: (lv_x2_8_0= ruleSizeValue )
            {
            // InternalLatteCSS.g:3524:1: (lv_x2_8_0= ruleSizeValue )
            // InternalLatteCSS.g:3525:3: lv_x2_8_0= ruleSizeValue
            {
             
            	        newCompositeNode(grammarAccess.getLinearGradientAccess().getX2SizeValueParserRuleCall_8_0()); 
            	    
            pushFollow(FOLLOW_33);
            lv_x2_8_0=ruleSizeValue();

            state._fsp--;


            	        if (current==null) {
            	            current = createModelElementForParent(grammarAccess.getLinearGradientRule());
            	        }
                   		set(
                   			current, 
                   			"x2",
                    		lv_x2_8_0, 
                    		"io.lattekit.dsl.LatteCSS.SizeValue");
            	        afterParserOrEnumRuleCall();
            	    

            }


            }

            otherlv_9=(Token)match(input,13,FOLLOW_15); 

                	newLeafNode(otherlv_9, grammarAccess.getLinearGradientAccess().getCommaKeyword_9());
                
            // InternalLatteCSS.g:3545:1: ( (lv_y2_10_0= ruleSizeValue ) )
            // InternalLatteCSS.g:3546:1: (lv_y2_10_0= ruleSizeValue )
            {
            // InternalLatteCSS.g:3546:1: (lv_y2_10_0= ruleSizeValue )
            // InternalLatteCSS.g:3547:3: lv_y2_10_0= ruleSizeValue
            {
             
            	        newCompositeNode(grammarAccess.getLinearGradientAccess().getY2SizeValueParserRuleCall_10_0()); 
            	    
            pushFollow(FOLLOW_34);
            lv_y2_10_0=ruleSizeValue();

            state._fsp--;


            	        if (current==null) {
            	            current = createModelElementForParent(grammarAccess.getLinearGradientRule());
            	        }
                   		set(
                   			current, 
                   			"y2",
                    		lv_y2_10_0, 
                    		"io.lattekit.dsl.LatteCSS.SizeValue");
            	        afterParserOrEnumRuleCall();
            	    

            }


            }

            otherlv_11=(Token)match(input,143,FOLLOW_36); 

                	newLeafNode(otherlv_11, grammarAccess.getLinearGradientAccess().getRightParenthesisKeyword_11());
                
            otherlv_12=(Token)match(input,145,FOLLOW_32); 

                	newLeafNode(otherlv_12, grammarAccess.getLinearGradientAccess().getStopsKeyword_12());
                
            // InternalLatteCSS.g:3571:1: (otherlv_13= '(' ( (lv_stops_14_0= ruleStopValue ) ) otherlv_15= ')' )+
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
            	    // InternalLatteCSS.g:3571:3: otherlv_13= '(' ( (lv_stops_14_0= ruleStopValue ) ) otherlv_15= ')'
            	    {
            	    otherlv_13=(Token)match(input,142,FOLLOW_15); 

            	        	newLeafNode(otherlv_13, grammarAccess.getLinearGradientAccess().getLeftParenthesisKeyword_13_0());
            	        
            	    // InternalLatteCSS.g:3575:1: ( (lv_stops_14_0= ruleStopValue ) )
            	    // InternalLatteCSS.g:3576:1: (lv_stops_14_0= ruleStopValue )
            	    {
            	    // InternalLatteCSS.g:3576:1: (lv_stops_14_0= ruleStopValue )
            	    // InternalLatteCSS.g:3577:3: lv_stops_14_0= ruleStopValue
            	    {
            	     
            	    	        newCompositeNode(grammarAccess.getLinearGradientAccess().getStopsStopValueParserRuleCall_13_1_0()); 
            	    	    
            	    pushFollow(FOLLOW_34);
            	    lv_stops_14_0=ruleStopValue();

            	    state._fsp--;


            	    	        if (current==null) {
            	    	            current = createModelElementForParent(grammarAccess.getLinearGradientRule());
            	    	        }
            	           		add(
            	           			current, 
            	           			"stops",
            	            		lv_stops_14_0, 
            	            		"io.lattekit.dsl.LatteCSS.StopValue");
            	    	        afterParserOrEnumRuleCall();
            	    	    

            	    }


            	    }

            	    otherlv_15=(Token)match(input,143,FOLLOW_37); 

            	        	newLeafNode(otherlv_15, grammarAccess.getLinearGradientAccess().getRightParenthesisKeyword_13_2());
            	        

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

            // InternalLatteCSS.g:3597:3: (otherlv_16= 'repeat' | otherlv_17= 'reflect' )?
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
                    // InternalLatteCSS.g:3597:5: otherlv_16= 'repeat'
                    {
                    otherlv_16=(Token)match(input,146,FOLLOW_2); 

                        	newLeafNode(otherlv_16, grammarAccess.getLinearGradientAccess().getRepeatKeyword_14_0());
                        

                    }
                    break;
                case 2 :
                    // InternalLatteCSS.g:3602:7: otherlv_17= 'reflect'
                    {
                    otherlv_17=(Token)match(input,147,FOLLOW_2); 

                        	newLeafNode(otherlv_17, grammarAccess.getLinearGradientAccess().getReflectKeyword_14_1());
                        

                    }
                    break;

            }


            }


            }

             leaveRule(); 
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleLinearGradient"


    // $ANTLR start "entryRuleRadialGradient"
    // InternalLatteCSS.g:3614:1: entryRuleRadialGradient returns [EObject current=null] : iv_ruleRadialGradient= ruleRadialGradient EOF ;
    public final EObject entryRuleRadialGradient() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleRadialGradient = null;


        try {
            // InternalLatteCSS.g:3615:2: (iv_ruleRadialGradient= ruleRadialGradient EOF )
            // InternalLatteCSS.g:3616:2: iv_ruleRadialGradient= ruleRadialGradient EOF
            {
             newCompositeNode(grammarAccess.getRadialGradientRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleRadialGradient=ruleRadialGradient();

            state._fsp--;

             current =iv_ruleRadialGradient; 
            match(input,EOF,FOLLOW_2); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleRadialGradient"


    // $ANTLR start "ruleRadialGradient"
    // InternalLatteCSS.g:3623:1: ruleRadialGradient returns [EObject current=null] : (otherlv_0= 'radial' (otherlv_1= '(' ( (lv_cx_2_0= ruleSizeValue ) ) otherlv_3= ',' ( (lv_cy_4_0= ruleSizeValue ) ) otherlv_5= ')' otherlv_6= ',' )? ( (lv_radius_7_0= ruleSizeValue ) ) (otherlv_8= 'focus' otherlv_9= '(' ( (lv_fx_10_0= ruleSizeValue ) ) otherlv_11= ',' ( (lv_fy_12_0= ruleSizeValue ) ) otherlv_13= ')' ) otherlv_14= 'stops' (otherlv_15= '(' ( (lv_stops_16_0= ruleStopValue ) ) otherlv_17= ')' )+ (otherlv_18= 'repeat' | otherlv_19= 'reflect' )? ) ;
    public final EObject ruleRadialGradient() throws RecognitionException {
        EObject current = null;

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
        EObject lv_cx_2_0 = null;

        EObject lv_cy_4_0 = null;

        EObject lv_radius_7_0 = null;

        EObject lv_fx_10_0 = null;

        EObject lv_fy_12_0 = null;

        EObject lv_stops_16_0 = null;


         enterRule(); 
            
        try {
            // InternalLatteCSS.g:3626:28: ( (otherlv_0= 'radial' (otherlv_1= '(' ( (lv_cx_2_0= ruleSizeValue ) ) otherlv_3= ',' ( (lv_cy_4_0= ruleSizeValue ) ) otherlv_5= ')' otherlv_6= ',' )? ( (lv_radius_7_0= ruleSizeValue ) ) (otherlv_8= 'focus' otherlv_9= '(' ( (lv_fx_10_0= ruleSizeValue ) ) otherlv_11= ',' ( (lv_fy_12_0= ruleSizeValue ) ) otherlv_13= ')' ) otherlv_14= 'stops' (otherlv_15= '(' ( (lv_stops_16_0= ruleStopValue ) ) otherlv_17= ')' )+ (otherlv_18= 'repeat' | otherlv_19= 'reflect' )? ) )
            // InternalLatteCSS.g:3627:1: (otherlv_0= 'radial' (otherlv_1= '(' ( (lv_cx_2_0= ruleSizeValue ) ) otherlv_3= ',' ( (lv_cy_4_0= ruleSizeValue ) ) otherlv_5= ')' otherlv_6= ',' )? ( (lv_radius_7_0= ruleSizeValue ) ) (otherlv_8= 'focus' otherlv_9= '(' ( (lv_fx_10_0= ruleSizeValue ) ) otherlv_11= ',' ( (lv_fy_12_0= ruleSizeValue ) ) otherlv_13= ')' ) otherlv_14= 'stops' (otherlv_15= '(' ( (lv_stops_16_0= ruleStopValue ) ) otherlv_17= ')' )+ (otherlv_18= 'repeat' | otherlv_19= 'reflect' )? )
            {
            // InternalLatteCSS.g:3627:1: (otherlv_0= 'radial' (otherlv_1= '(' ( (lv_cx_2_0= ruleSizeValue ) ) otherlv_3= ',' ( (lv_cy_4_0= ruleSizeValue ) ) otherlv_5= ')' otherlv_6= ',' )? ( (lv_radius_7_0= ruleSizeValue ) ) (otherlv_8= 'focus' otherlv_9= '(' ( (lv_fx_10_0= ruleSizeValue ) ) otherlv_11= ',' ( (lv_fy_12_0= ruleSizeValue ) ) otherlv_13= ')' ) otherlv_14= 'stops' (otherlv_15= '(' ( (lv_stops_16_0= ruleStopValue ) ) otherlv_17= ')' )+ (otherlv_18= 'repeat' | otherlv_19= 'reflect' )? )
            // InternalLatteCSS.g:3627:3: otherlv_0= 'radial' (otherlv_1= '(' ( (lv_cx_2_0= ruleSizeValue ) ) otherlv_3= ',' ( (lv_cy_4_0= ruleSizeValue ) ) otherlv_5= ')' otherlv_6= ',' )? ( (lv_radius_7_0= ruleSizeValue ) ) (otherlv_8= 'focus' otherlv_9= '(' ( (lv_fx_10_0= ruleSizeValue ) ) otherlv_11= ',' ( (lv_fy_12_0= ruleSizeValue ) ) otherlv_13= ')' ) otherlv_14= 'stops' (otherlv_15= '(' ( (lv_stops_16_0= ruleStopValue ) ) otherlv_17= ')' )+ (otherlv_18= 'repeat' | otherlv_19= 'reflect' )?
            {
            otherlv_0=(Token)match(input,148,FOLLOW_38); 

                	newLeafNode(otherlv_0, grammarAccess.getRadialGradientAccess().getRadialKeyword_0());
                
            // InternalLatteCSS.g:3631:1: (otherlv_1= '(' ( (lv_cx_2_0= ruleSizeValue ) ) otherlv_3= ',' ( (lv_cy_4_0= ruleSizeValue ) ) otherlv_5= ')' otherlv_6= ',' )?
            int alt43=2;
            int LA43_0 = input.LA(1);

            if ( (LA43_0==142) ) {
                alt43=1;
            }
            switch (alt43) {
                case 1 :
                    // InternalLatteCSS.g:3631:3: otherlv_1= '(' ( (lv_cx_2_0= ruleSizeValue ) ) otherlv_3= ',' ( (lv_cy_4_0= ruleSizeValue ) ) otherlv_5= ')' otherlv_6= ','
                    {
                    otherlv_1=(Token)match(input,142,FOLLOW_15); 

                        	newLeafNode(otherlv_1, grammarAccess.getRadialGradientAccess().getLeftParenthesisKeyword_1_0());
                        
                    // InternalLatteCSS.g:3635:1: ( (lv_cx_2_0= ruleSizeValue ) )
                    // InternalLatteCSS.g:3636:1: (lv_cx_2_0= ruleSizeValue )
                    {
                    // InternalLatteCSS.g:3636:1: (lv_cx_2_0= ruleSizeValue )
                    // InternalLatteCSS.g:3637:3: lv_cx_2_0= ruleSizeValue
                    {
                     
                    	        newCompositeNode(grammarAccess.getRadialGradientAccess().getCxSizeValueParserRuleCall_1_1_0()); 
                    	    
                    pushFollow(FOLLOW_33);
                    lv_cx_2_0=ruleSizeValue();

                    state._fsp--;


                    	        if (current==null) {
                    	            current = createModelElementForParent(grammarAccess.getRadialGradientRule());
                    	        }
                           		set(
                           			current, 
                           			"cx",
                            		lv_cx_2_0, 
                            		"io.lattekit.dsl.LatteCSS.SizeValue");
                    	        afterParserOrEnumRuleCall();
                    	    

                    }


                    }

                    otherlv_3=(Token)match(input,13,FOLLOW_15); 

                        	newLeafNode(otherlv_3, grammarAccess.getRadialGradientAccess().getCommaKeyword_1_2());
                        
                    // InternalLatteCSS.g:3657:1: ( (lv_cy_4_0= ruleSizeValue ) )
                    // InternalLatteCSS.g:3658:1: (lv_cy_4_0= ruleSizeValue )
                    {
                    // InternalLatteCSS.g:3658:1: (lv_cy_4_0= ruleSizeValue )
                    // InternalLatteCSS.g:3659:3: lv_cy_4_0= ruleSizeValue
                    {
                     
                    	        newCompositeNode(grammarAccess.getRadialGradientAccess().getCySizeValueParserRuleCall_1_3_0()); 
                    	    
                    pushFollow(FOLLOW_34);
                    lv_cy_4_0=ruleSizeValue();

                    state._fsp--;


                    	        if (current==null) {
                    	            current = createModelElementForParent(grammarAccess.getRadialGradientRule());
                    	        }
                           		set(
                           			current, 
                           			"cy",
                            		lv_cy_4_0, 
                            		"io.lattekit.dsl.LatteCSS.SizeValue");
                    	        afterParserOrEnumRuleCall();
                    	    

                    }


                    }

                    otherlv_5=(Token)match(input,143,FOLLOW_33); 

                        	newLeafNode(otherlv_5, grammarAccess.getRadialGradientAccess().getRightParenthesisKeyword_1_4());
                        
                    otherlv_6=(Token)match(input,13,FOLLOW_15); 

                        	newLeafNode(otherlv_6, grammarAccess.getRadialGradientAccess().getCommaKeyword_1_5());
                        

                    }
                    break;

            }

            // InternalLatteCSS.g:3683:3: ( (lv_radius_7_0= ruleSizeValue ) )
            // InternalLatteCSS.g:3684:1: (lv_radius_7_0= ruleSizeValue )
            {
            // InternalLatteCSS.g:3684:1: (lv_radius_7_0= ruleSizeValue )
            // InternalLatteCSS.g:3685:3: lv_radius_7_0= ruleSizeValue
            {
             
            	        newCompositeNode(grammarAccess.getRadialGradientAccess().getRadiusSizeValueParserRuleCall_2_0()); 
            	    
            pushFollow(FOLLOW_39);
            lv_radius_7_0=ruleSizeValue();

            state._fsp--;


            	        if (current==null) {
            	            current = createModelElementForParent(grammarAccess.getRadialGradientRule());
            	        }
                   		set(
                   			current, 
                   			"radius",
                    		lv_radius_7_0, 
                    		"io.lattekit.dsl.LatteCSS.SizeValue");
            	        afterParserOrEnumRuleCall();
            	    

            }


            }

            // InternalLatteCSS.g:3701:2: (otherlv_8= 'focus' otherlv_9= '(' ( (lv_fx_10_0= ruleSizeValue ) ) otherlv_11= ',' ( (lv_fy_12_0= ruleSizeValue ) ) otherlv_13= ')' )
            // InternalLatteCSS.g:3701:4: otherlv_8= 'focus' otherlv_9= '(' ( (lv_fx_10_0= ruleSizeValue ) ) otherlv_11= ',' ( (lv_fy_12_0= ruleSizeValue ) ) otherlv_13= ')'
            {
            otherlv_8=(Token)match(input,149,FOLLOW_32); 

                	newLeafNode(otherlv_8, grammarAccess.getRadialGradientAccess().getFocusKeyword_3_0());
                
            otherlv_9=(Token)match(input,142,FOLLOW_15); 

                	newLeafNode(otherlv_9, grammarAccess.getRadialGradientAccess().getLeftParenthesisKeyword_3_1());
                
            // InternalLatteCSS.g:3709:1: ( (lv_fx_10_0= ruleSizeValue ) )
            // InternalLatteCSS.g:3710:1: (lv_fx_10_0= ruleSizeValue )
            {
            // InternalLatteCSS.g:3710:1: (lv_fx_10_0= ruleSizeValue )
            // InternalLatteCSS.g:3711:3: lv_fx_10_0= ruleSizeValue
            {
             
            	        newCompositeNode(grammarAccess.getRadialGradientAccess().getFxSizeValueParserRuleCall_3_2_0()); 
            	    
            pushFollow(FOLLOW_33);
            lv_fx_10_0=ruleSizeValue();

            state._fsp--;


            	        if (current==null) {
            	            current = createModelElementForParent(grammarAccess.getRadialGradientRule());
            	        }
                   		set(
                   			current, 
                   			"fx",
                    		lv_fx_10_0, 
                    		"io.lattekit.dsl.LatteCSS.SizeValue");
            	        afterParserOrEnumRuleCall();
            	    

            }


            }

            otherlv_11=(Token)match(input,13,FOLLOW_15); 

                	newLeafNode(otherlv_11, grammarAccess.getRadialGradientAccess().getCommaKeyword_3_3());
                
            // InternalLatteCSS.g:3731:1: ( (lv_fy_12_0= ruleSizeValue ) )
            // InternalLatteCSS.g:3732:1: (lv_fy_12_0= ruleSizeValue )
            {
            // InternalLatteCSS.g:3732:1: (lv_fy_12_0= ruleSizeValue )
            // InternalLatteCSS.g:3733:3: lv_fy_12_0= ruleSizeValue
            {
             
            	        newCompositeNode(grammarAccess.getRadialGradientAccess().getFySizeValueParserRuleCall_3_4_0()); 
            	    
            pushFollow(FOLLOW_34);
            lv_fy_12_0=ruleSizeValue();

            state._fsp--;


            	        if (current==null) {
            	            current = createModelElementForParent(grammarAccess.getRadialGradientRule());
            	        }
                   		set(
                   			current, 
                   			"fy",
                    		lv_fy_12_0, 
                    		"io.lattekit.dsl.LatteCSS.SizeValue");
            	        afterParserOrEnumRuleCall();
            	    

            }


            }

            otherlv_13=(Token)match(input,143,FOLLOW_36); 

                	newLeafNode(otherlv_13, grammarAccess.getRadialGradientAccess().getRightParenthesisKeyword_3_5());
                

            }

            otherlv_14=(Token)match(input,145,FOLLOW_32); 

                	newLeafNode(otherlv_14, grammarAccess.getRadialGradientAccess().getStopsKeyword_4());
                
            // InternalLatteCSS.g:3757:1: (otherlv_15= '(' ( (lv_stops_16_0= ruleStopValue ) ) otherlv_17= ')' )+
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
            	    // InternalLatteCSS.g:3757:3: otherlv_15= '(' ( (lv_stops_16_0= ruleStopValue ) ) otherlv_17= ')'
            	    {
            	    otherlv_15=(Token)match(input,142,FOLLOW_15); 

            	        	newLeafNode(otherlv_15, grammarAccess.getRadialGradientAccess().getLeftParenthesisKeyword_5_0());
            	        
            	    // InternalLatteCSS.g:3761:1: ( (lv_stops_16_0= ruleStopValue ) )
            	    // InternalLatteCSS.g:3762:1: (lv_stops_16_0= ruleStopValue )
            	    {
            	    // InternalLatteCSS.g:3762:1: (lv_stops_16_0= ruleStopValue )
            	    // InternalLatteCSS.g:3763:3: lv_stops_16_0= ruleStopValue
            	    {
            	     
            	    	        newCompositeNode(grammarAccess.getRadialGradientAccess().getStopsStopValueParserRuleCall_5_1_0()); 
            	    	    
            	    pushFollow(FOLLOW_34);
            	    lv_stops_16_0=ruleStopValue();

            	    state._fsp--;


            	    	        if (current==null) {
            	    	            current = createModelElementForParent(grammarAccess.getRadialGradientRule());
            	    	        }
            	           		add(
            	           			current, 
            	           			"stops",
            	            		lv_stops_16_0, 
            	            		"io.lattekit.dsl.LatteCSS.StopValue");
            	    	        afterParserOrEnumRuleCall();
            	    	    

            	    }


            	    }

            	    otherlv_17=(Token)match(input,143,FOLLOW_37); 

            	        	newLeafNode(otherlv_17, grammarAccess.getRadialGradientAccess().getRightParenthesisKeyword_5_2());
            	        

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

            // InternalLatteCSS.g:3783:3: (otherlv_18= 'repeat' | otherlv_19= 'reflect' )?
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
                    // InternalLatteCSS.g:3783:5: otherlv_18= 'repeat'
                    {
                    otherlv_18=(Token)match(input,146,FOLLOW_2); 

                        	newLeafNode(otherlv_18, grammarAccess.getRadialGradientAccess().getRepeatKeyword_6_0());
                        

                    }
                    break;
                case 2 :
                    // InternalLatteCSS.g:3788:7: otherlv_19= 'reflect'
                    {
                    otherlv_19=(Token)match(input,147,FOLLOW_2); 

                        	newLeafNode(otherlv_19, grammarAccess.getRadialGradientAccess().getReflectKeyword_6_1());
                        

                    }
                    break;

            }


            }


            }

             leaveRule(); 
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleRadialGradient"


    // $ANTLR start "entryRuleStopValue"
    // InternalLatteCSS.g:3800:1: entryRuleStopValue returns [EObject current=null] : iv_ruleStopValue= ruleStopValue EOF ;
    public final EObject entryRuleStopValue() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleStopValue = null;


        try {
            // InternalLatteCSS.g:3801:2: (iv_ruleStopValue= ruleStopValue EOF )
            // InternalLatteCSS.g:3802:2: iv_ruleStopValue= ruleStopValue EOF
            {
             newCompositeNode(grammarAccess.getStopValueRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleStopValue=ruleStopValue();

            state._fsp--;

             current =iv_ruleStopValue; 
            match(input,EOF,FOLLOW_2); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleStopValue"


    // $ANTLR start "ruleStopValue"
    // InternalLatteCSS.g:3809:1: ruleStopValue returns [EObject current=null] : ( ( (lv_pos_0_0= ruleSizeValue ) ) otherlv_1= ',' ( (lv_color_2_0= ruleColorValue ) ) ) ;
    public final EObject ruleStopValue() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        EObject lv_pos_0_0 = null;

        EObject lv_color_2_0 = null;


         enterRule(); 
            
        try {
            // InternalLatteCSS.g:3812:28: ( ( ( (lv_pos_0_0= ruleSizeValue ) ) otherlv_1= ',' ( (lv_color_2_0= ruleColorValue ) ) ) )
            // InternalLatteCSS.g:3813:1: ( ( (lv_pos_0_0= ruleSizeValue ) ) otherlv_1= ',' ( (lv_color_2_0= ruleColorValue ) ) )
            {
            // InternalLatteCSS.g:3813:1: ( ( (lv_pos_0_0= ruleSizeValue ) ) otherlv_1= ',' ( (lv_color_2_0= ruleColorValue ) ) )
            // InternalLatteCSS.g:3813:2: ( (lv_pos_0_0= ruleSizeValue ) ) otherlv_1= ',' ( (lv_color_2_0= ruleColorValue ) )
            {
            // InternalLatteCSS.g:3813:2: ( (lv_pos_0_0= ruleSizeValue ) )
            // InternalLatteCSS.g:3814:1: (lv_pos_0_0= ruleSizeValue )
            {
            // InternalLatteCSS.g:3814:1: (lv_pos_0_0= ruleSizeValue )
            // InternalLatteCSS.g:3815:3: lv_pos_0_0= ruleSizeValue
            {
             
            	        newCompositeNode(grammarAccess.getStopValueAccess().getPosSizeValueParserRuleCall_0_0()); 
            	    
            pushFollow(FOLLOW_33);
            lv_pos_0_0=ruleSizeValue();

            state._fsp--;


            	        if (current==null) {
            	            current = createModelElementForParent(grammarAccess.getStopValueRule());
            	        }
                   		set(
                   			current, 
                   			"pos",
                    		lv_pos_0_0, 
                    		"io.lattekit.dsl.LatteCSS.SizeValue");
            	        afterParserOrEnumRuleCall();
            	    

            }


            }

            otherlv_1=(Token)match(input,13,FOLLOW_17); 

                	newLeafNode(otherlv_1, grammarAccess.getStopValueAccess().getCommaKeyword_1());
                
            // InternalLatteCSS.g:3835:1: ( (lv_color_2_0= ruleColorValue ) )
            // InternalLatteCSS.g:3836:1: (lv_color_2_0= ruleColorValue )
            {
            // InternalLatteCSS.g:3836:1: (lv_color_2_0= ruleColorValue )
            // InternalLatteCSS.g:3837:3: lv_color_2_0= ruleColorValue
            {
             
            	        newCompositeNode(grammarAccess.getStopValueAccess().getColorColorValueParserRuleCall_2_0()); 
            	    
            pushFollow(FOLLOW_2);
            lv_color_2_0=ruleColorValue();

            state._fsp--;


            	        if (current==null) {
            	            current = createModelElementForParent(grammarAccess.getStopValueRule());
            	        }
                   		set(
                   			current, 
                   			"color",
                    		lv_color_2_0, 
                    		"io.lattekit.dsl.LatteCSS.ColorValue");
            	        afterParserOrEnumRuleCall();
            	    

            }


            }


            }


            }

             leaveRule(); 
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleStopValue"


    // $ANTLR start "entryRuleColorValue"
    // InternalLatteCSS.g:3861:1: entryRuleColorValue returns [EObject current=null] : iv_ruleColorValue= ruleColorValue EOF ;
    public final EObject entryRuleColorValue() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleColorValue = null;


        try {
            // InternalLatteCSS.g:3862:2: (iv_ruleColorValue= ruleColorValue EOF )
            // InternalLatteCSS.g:3863:2: iv_ruleColorValue= ruleColorValue EOF
            {
             newCompositeNode(grammarAccess.getColorValueRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleColorValue=ruleColorValue();

            state._fsp--;

             current =iv_ruleColorValue; 
            match(input,EOF,FOLLOW_2); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleColorValue"


    // $ANTLR start "ruleColorValue"
    // InternalLatteCSS.g:3870:1: ruleColorValue returns [EObject current=null] : ( ( (lv_namedColor_0_0= ruleNamedColor ) ) | ( (lv_rgb_1_0= ruleRGBColor ) ) ) ;
    public final EObject ruleColorValue() throws RecognitionException {
        EObject current = null;

        AntlrDatatypeRuleToken lv_namedColor_0_0 = null;

        EObject lv_rgb_1_0 = null;


         enterRule(); 
            
        try {
            // InternalLatteCSS.g:3873:28: ( ( ( (lv_namedColor_0_0= ruleNamedColor ) ) | ( (lv_rgb_1_0= ruleRGBColor ) ) ) )
            // InternalLatteCSS.g:3874:1: ( ( (lv_namedColor_0_0= ruleNamedColor ) ) | ( (lv_rgb_1_0= ruleRGBColor ) ) )
            {
            // InternalLatteCSS.g:3874:1: ( ( (lv_namedColor_0_0= ruleNamedColor ) ) | ( (lv_rgb_1_0= ruleRGBColor ) ) )
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
                    // InternalLatteCSS.g:3874:2: ( (lv_namedColor_0_0= ruleNamedColor ) )
                    {
                    // InternalLatteCSS.g:3874:2: ( (lv_namedColor_0_0= ruleNamedColor ) )
                    // InternalLatteCSS.g:3875:1: (lv_namedColor_0_0= ruleNamedColor )
                    {
                    // InternalLatteCSS.g:3875:1: (lv_namedColor_0_0= ruleNamedColor )
                    // InternalLatteCSS.g:3876:3: lv_namedColor_0_0= ruleNamedColor
                    {
                     
                    	        newCompositeNode(grammarAccess.getColorValueAccess().getNamedColorNamedColorParserRuleCall_0_0()); 
                    	    
                    pushFollow(FOLLOW_2);
                    lv_namedColor_0_0=ruleNamedColor();

                    state._fsp--;


                    	        if (current==null) {
                    	            current = createModelElementForParent(grammarAccess.getColorValueRule());
                    	        }
                           		set(
                           			current, 
                           			"namedColor",
                            		lv_namedColor_0_0, 
                            		"io.lattekit.dsl.LatteCSS.NamedColor");
                    	        afterParserOrEnumRuleCall();
                    	    

                    }


                    }


                    }
                    break;
                case 2 :
                    // InternalLatteCSS.g:3893:6: ( (lv_rgb_1_0= ruleRGBColor ) )
                    {
                    // InternalLatteCSS.g:3893:6: ( (lv_rgb_1_0= ruleRGBColor ) )
                    // InternalLatteCSS.g:3894:1: (lv_rgb_1_0= ruleRGBColor )
                    {
                    // InternalLatteCSS.g:3894:1: (lv_rgb_1_0= ruleRGBColor )
                    // InternalLatteCSS.g:3895:3: lv_rgb_1_0= ruleRGBColor
                    {
                     
                    	        newCompositeNode(grammarAccess.getColorValueAccess().getRgbRGBColorParserRuleCall_1_0()); 
                    	    
                    pushFollow(FOLLOW_2);
                    lv_rgb_1_0=ruleRGBColor();

                    state._fsp--;


                    	        if (current==null) {
                    	            current = createModelElementForParent(grammarAccess.getColorValueRule());
                    	        }
                           		set(
                           			current, 
                           			"rgb",
                            		lv_rgb_1_0, 
                            		"io.lattekit.dsl.LatteCSS.RGBColor");
                    	        afterParserOrEnumRuleCall();
                    	    

                    }


                    }


                    }
                    break;

            }


            }

             leaveRule(); 
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleColorValue"


    // $ANTLR start "entryRuleNamedColor"
    // InternalLatteCSS.g:3919:1: entryRuleNamedColor returns [String current=null] : iv_ruleNamedColor= ruleNamedColor EOF ;
    public final String entryRuleNamedColor() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleNamedColor = null;


        try {
            // InternalLatteCSS.g:3920:2: (iv_ruleNamedColor= ruleNamedColor EOF )
            // InternalLatteCSS.g:3921:2: iv_ruleNamedColor= ruleNamedColor EOF
            {
             newCompositeNode(grammarAccess.getNamedColorRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleNamedColor=ruleNamedColor();

            state._fsp--;

             current =iv_ruleNamedColor.getText(); 
            match(input,EOF,FOLLOW_2); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleNamedColor"


    // $ANTLR start "ruleNamedColor"
    // InternalLatteCSS.g:3928:1: ruleNamedColor returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (kw= 'aliceblue' | kw= 'antiquewhite' | kw= 'aqua' | kw= 'aquamarine' | kw= 'azure' | kw= 'beige' | kw= 'bisque' | kw= 'black' | kw= 'blanchedalmond' | kw= 'blue' | kw= 'blueviolet' | kw= 'brown' | kw= 'burlywood' | kw= 'cadetblue' | kw= 'chartreuse' | kw= 'chocolate' | kw= 'coral' | kw= 'cornflowerblue' | kw= 'cornsilk' | kw= 'crimson' | kw= 'cyan' | kw= 'darkblue' | kw= 'darkcyan' | kw= 'darkgoldenrod' | kw= 'darkgray' | kw= 'darkgreen' | kw= 'darkgrey' | kw= 'darkkhaki' | kw= 'darkmagenta' | kw= 'darkolivegreen' | kw= 'darkorange' | kw= 'darkorchid' | kw= 'darkred' | kw= 'darksalmon' | kw= 'darkseagreen' | kw= 'darkslateblue' | kw= 'darkslategray' | kw= 'darkslategrey' | kw= 'darkturquoise' | kw= 'darkviolet' | kw= 'deeppink' | kw= 'deepskyblue' | kw= 'dimgray' | kw= 'dimgrey' | kw= 'dodgerblue' | kw= 'firebrick' | kw= 'floralwhite' | kw= 'forestgreen' | kw= 'fuchsia' | kw= 'gainsboro' | kw= 'ghostwhite' | kw= 'gold' | kw= 'goldenrod' | kw= 'gray' | kw= 'green' | kw= 'greenyellow' | kw= 'grey' | kw= 'honeydew' | kw= 'hotpink' | kw= 'indianred' | kw= 'indigo' | kw= 'ivory' | kw= 'khaki' | kw= 'lavender' | kw= 'lavenderblush' | kw= 'lawngreen' | kw= 'lemonchiffon' | kw= 'lightblue' | kw= 'lightcoral' | kw= 'lightcyan' | kw= 'lightgoldenrodyellow' | kw= 'lightgray' | kw= 'lightgreen' | kw= 'lightgrey' | kw= 'lightpink' | kw= 'lightsalmon' | kw= 'lightseagreen' | kw= 'lightskyblue' | kw= 'lightslategray' | kw= 'lightslategrey' | kw= 'lightsteelblue' | kw= 'lightyellow' | kw= 'lime' | kw= 'limegreen' | kw= 'linen' | kw= 'magenta' | kw= 'maroon' | kw= 'mediumaquamarine' | kw= 'mediumblue' | kw= 'mediumorchid' | kw= 'mediumpurple' | kw= 'mediumseagreen' | kw= 'mediumslateblue' | kw= 'mediumspringgreen' | kw= 'mediumturquoise' | kw= 'mediumvioletred' | kw= 'midnightblue' | kw= 'mintcream' | kw= 'mistyrose' | kw= 'moccasin' | kw= 'navajowhite' | kw= 'navy' | kw= 'oldlace' | kw= 'olive' | kw= 'olivedrab' | kw= 'orange' | kw= 'orangered' | kw= 'orchid' | kw= 'palegoldenrod' | kw= 'palegreen' | kw= 'paleturquoise' | kw= 'palevioletred' | kw= 'papayawhip' | kw= 'peachpuff' | kw= 'peru' | kw= 'pink' | kw= 'plum' | kw= 'powderblue' | kw= 'purple' | kw= 'red' | kw= 'rosybrown' | kw= 'royalblue' | kw= 'saddlebrown' | kw= 'salmon' | kw= 'sandybrown' | kw= 'seagreen' | kw= 'seashell' | kw= 'sienna' | kw= 'silver' | kw= 'skyblue' | kw= 'slateblue' | kw= 'slategray' | kw= 'slategrey' | kw= 'snow' | kw= 'springgreen' | kw= 'steelblue' | kw= 'tan' | kw= 'teal' | kw= 'thistle' | kw= 'tomato' | kw= 'turquoise' | kw= 'violet' | kw= 'wheat' | kw= 'white' | kw= 'whitesmoke' | kw= 'yellow' | kw= 'yellowgreen' | kw= 'transparent' ) ;
    public final AntlrDatatypeRuleToken ruleNamedColor() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token kw=null;

         enterRule(); 
            
        try {
            // InternalLatteCSS.g:3931:28: ( (kw= 'aliceblue' | kw= 'antiquewhite' | kw= 'aqua' | kw= 'aquamarine' | kw= 'azure' | kw= 'beige' | kw= 'bisque' | kw= 'black' | kw= 'blanchedalmond' | kw= 'blue' | kw= 'blueviolet' | kw= 'brown' | kw= 'burlywood' | kw= 'cadetblue' | kw= 'chartreuse' | kw= 'chocolate' | kw= 'coral' | kw= 'cornflowerblue' | kw= 'cornsilk' | kw= 'crimson' | kw= 'cyan' | kw= 'darkblue' | kw= 'darkcyan' | kw= 'darkgoldenrod' | kw= 'darkgray' | kw= 'darkgreen' | kw= 'darkgrey' | kw= 'darkkhaki' | kw= 'darkmagenta' | kw= 'darkolivegreen' | kw= 'darkorange' | kw= 'darkorchid' | kw= 'darkred' | kw= 'darksalmon' | kw= 'darkseagreen' | kw= 'darkslateblue' | kw= 'darkslategray' | kw= 'darkslategrey' | kw= 'darkturquoise' | kw= 'darkviolet' | kw= 'deeppink' | kw= 'deepskyblue' | kw= 'dimgray' | kw= 'dimgrey' | kw= 'dodgerblue' | kw= 'firebrick' | kw= 'floralwhite' | kw= 'forestgreen' | kw= 'fuchsia' | kw= 'gainsboro' | kw= 'ghostwhite' | kw= 'gold' | kw= 'goldenrod' | kw= 'gray' | kw= 'green' | kw= 'greenyellow' | kw= 'grey' | kw= 'honeydew' | kw= 'hotpink' | kw= 'indianred' | kw= 'indigo' | kw= 'ivory' | kw= 'khaki' | kw= 'lavender' | kw= 'lavenderblush' | kw= 'lawngreen' | kw= 'lemonchiffon' | kw= 'lightblue' | kw= 'lightcoral' | kw= 'lightcyan' | kw= 'lightgoldenrodyellow' | kw= 'lightgray' | kw= 'lightgreen' | kw= 'lightgrey' | kw= 'lightpink' | kw= 'lightsalmon' | kw= 'lightseagreen' | kw= 'lightskyblue' | kw= 'lightslategray' | kw= 'lightslategrey' | kw= 'lightsteelblue' | kw= 'lightyellow' | kw= 'lime' | kw= 'limegreen' | kw= 'linen' | kw= 'magenta' | kw= 'maroon' | kw= 'mediumaquamarine' | kw= 'mediumblue' | kw= 'mediumorchid' | kw= 'mediumpurple' | kw= 'mediumseagreen' | kw= 'mediumslateblue' | kw= 'mediumspringgreen' | kw= 'mediumturquoise' | kw= 'mediumvioletred' | kw= 'midnightblue' | kw= 'mintcream' | kw= 'mistyrose' | kw= 'moccasin' | kw= 'navajowhite' | kw= 'navy' | kw= 'oldlace' | kw= 'olive' | kw= 'olivedrab' | kw= 'orange' | kw= 'orangered' | kw= 'orchid' | kw= 'palegoldenrod' | kw= 'palegreen' | kw= 'paleturquoise' | kw= 'palevioletred' | kw= 'papayawhip' | kw= 'peachpuff' | kw= 'peru' | kw= 'pink' | kw= 'plum' | kw= 'powderblue' | kw= 'purple' | kw= 'red' | kw= 'rosybrown' | kw= 'royalblue' | kw= 'saddlebrown' | kw= 'salmon' | kw= 'sandybrown' | kw= 'seagreen' | kw= 'seashell' | kw= 'sienna' | kw= 'silver' | kw= 'skyblue' | kw= 'slateblue' | kw= 'slategray' | kw= 'slategrey' | kw= 'snow' | kw= 'springgreen' | kw= 'steelblue' | kw= 'tan' | kw= 'teal' | kw= 'thistle' | kw= 'tomato' | kw= 'turquoise' | kw= 'violet' | kw= 'wheat' | kw= 'white' | kw= 'whitesmoke' | kw= 'yellow' | kw= 'yellowgreen' | kw= 'transparent' ) )
            // InternalLatteCSS.g:3932:1: (kw= 'aliceblue' | kw= 'antiquewhite' | kw= 'aqua' | kw= 'aquamarine' | kw= 'azure' | kw= 'beige' | kw= 'bisque' | kw= 'black' | kw= 'blanchedalmond' | kw= 'blue' | kw= 'blueviolet' | kw= 'brown' | kw= 'burlywood' | kw= 'cadetblue' | kw= 'chartreuse' | kw= 'chocolate' | kw= 'coral' | kw= 'cornflowerblue' | kw= 'cornsilk' | kw= 'crimson' | kw= 'cyan' | kw= 'darkblue' | kw= 'darkcyan' | kw= 'darkgoldenrod' | kw= 'darkgray' | kw= 'darkgreen' | kw= 'darkgrey' | kw= 'darkkhaki' | kw= 'darkmagenta' | kw= 'darkolivegreen' | kw= 'darkorange' | kw= 'darkorchid' | kw= 'darkred' | kw= 'darksalmon' | kw= 'darkseagreen' | kw= 'darkslateblue' | kw= 'darkslategray' | kw= 'darkslategrey' | kw= 'darkturquoise' | kw= 'darkviolet' | kw= 'deeppink' | kw= 'deepskyblue' | kw= 'dimgray' | kw= 'dimgrey' | kw= 'dodgerblue' | kw= 'firebrick' | kw= 'floralwhite' | kw= 'forestgreen' | kw= 'fuchsia' | kw= 'gainsboro' | kw= 'ghostwhite' | kw= 'gold' | kw= 'goldenrod' | kw= 'gray' | kw= 'green' | kw= 'greenyellow' | kw= 'grey' | kw= 'honeydew' | kw= 'hotpink' | kw= 'indianred' | kw= 'indigo' | kw= 'ivory' | kw= 'khaki' | kw= 'lavender' | kw= 'lavenderblush' | kw= 'lawngreen' | kw= 'lemonchiffon' | kw= 'lightblue' | kw= 'lightcoral' | kw= 'lightcyan' | kw= 'lightgoldenrodyellow' | kw= 'lightgray' | kw= 'lightgreen' | kw= 'lightgrey' | kw= 'lightpink' | kw= 'lightsalmon' | kw= 'lightseagreen' | kw= 'lightskyblue' | kw= 'lightslategray' | kw= 'lightslategrey' | kw= 'lightsteelblue' | kw= 'lightyellow' | kw= 'lime' | kw= 'limegreen' | kw= 'linen' | kw= 'magenta' | kw= 'maroon' | kw= 'mediumaquamarine' | kw= 'mediumblue' | kw= 'mediumorchid' | kw= 'mediumpurple' | kw= 'mediumseagreen' | kw= 'mediumslateblue' | kw= 'mediumspringgreen' | kw= 'mediumturquoise' | kw= 'mediumvioletred' | kw= 'midnightblue' | kw= 'mintcream' | kw= 'mistyrose' | kw= 'moccasin' | kw= 'navajowhite' | kw= 'navy' | kw= 'oldlace' | kw= 'olive' | kw= 'olivedrab' | kw= 'orange' | kw= 'orangered' | kw= 'orchid' | kw= 'palegoldenrod' | kw= 'palegreen' | kw= 'paleturquoise' | kw= 'palevioletred' | kw= 'papayawhip' | kw= 'peachpuff' | kw= 'peru' | kw= 'pink' | kw= 'plum' | kw= 'powderblue' | kw= 'purple' | kw= 'red' | kw= 'rosybrown' | kw= 'royalblue' | kw= 'saddlebrown' | kw= 'salmon' | kw= 'sandybrown' | kw= 'seagreen' | kw= 'seashell' | kw= 'sienna' | kw= 'silver' | kw= 'skyblue' | kw= 'slateblue' | kw= 'slategray' | kw= 'slategrey' | kw= 'snow' | kw= 'springgreen' | kw= 'steelblue' | kw= 'tan' | kw= 'teal' | kw= 'thistle' | kw= 'tomato' | kw= 'turquoise' | kw= 'violet' | kw= 'wheat' | kw= 'white' | kw= 'whitesmoke' | kw= 'yellow' | kw= 'yellowgreen' | kw= 'transparent' )
            {
            // InternalLatteCSS.g:3932:1: (kw= 'aliceblue' | kw= 'antiquewhite' | kw= 'aqua' | kw= 'aquamarine' | kw= 'azure' | kw= 'beige' | kw= 'bisque' | kw= 'black' | kw= 'blanchedalmond' | kw= 'blue' | kw= 'blueviolet' | kw= 'brown' | kw= 'burlywood' | kw= 'cadetblue' | kw= 'chartreuse' | kw= 'chocolate' | kw= 'coral' | kw= 'cornflowerblue' | kw= 'cornsilk' | kw= 'crimson' | kw= 'cyan' | kw= 'darkblue' | kw= 'darkcyan' | kw= 'darkgoldenrod' | kw= 'darkgray' | kw= 'darkgreen' | kw= 'darkgrey' | kw= 'darkkhaki' | kw= 'darkmagenta' | kw= 'darkolivegreen' | kw= 'darkorange' | kw= 'darkorchid' | kw= 'darkred' | kw= 'darksalmon' | kw= 'darkseagreen' | kw= 'darkslateblue' | kw= 'darkslategray' | kw= 'darkslategrey' | kw= 'darkturquoise' | kw= 'darkviolet' | kw= 'deeppink' | kw= 'deepskyblue' | kw= 'dimgray' | kw= 'dimgrey' | kw= 'dodgerblue' | kw= 'firebrick' | kw= 'floralwhite' | kw= 'forestgreen' | kw= 'fuchsia' | kw= 'gainsboro' | kw= 'ghostwhite' | kw= 'gold' | kw= 'goldenrod' | kw= 'gray' | kw= 'green' | kw= 'greenyellow' | kw= 'grey' | kw= 'honeydew' | kw= 'hotpink' | kw= 'indianred' | kw= 'indigo' | kw= 'ivory' | kw= 'khaki' | kw= 'lavender' | kw= 'lavenderblush' | kw= 'lawngreen' | kw= 'lemonchiffon' | kw= 'lightblue' | kw= 'lightcoral' | kw= 'lightcyan' | kw= 'lightgoldenrodyellow' | kw= 'lightgray' | kw= 'lightgreen' | kw= 'lightgrey' | kw= 'lightpink' | kw= 'lightsalmon' | kw= 'lightseagreen' | kw= 'lightskyblue' | kw= 'lightslategray' | kw= 'lightslategrey' | kw= 'lightsteelblue' | kw= 'lightyellow' | kw= 'lime' | kw= 'limegreen' | kw= 'linen' | kw= 'magenta' | kw= 'maroon' | kw= 'mediumaquamarine' | kw= 'mediumblue' | kw= 'mediumorchid' | kw= 'mediumpurple' | kw= 'mediumseagreen' | kw= 'mediumslateblue' | kw= 'mediumspringgreen' | kw= 'mediumturquoise' | kw= 'mediumvioletred' | kw= 'midnightblue' | kw= 'mintcream' | kw= 'mistyrose' | kw= 'moccasin' | kw= 'navajowhite' | kw= 'navy' | kw= 'oldlace' | kw= 'olive' | kw= 'olivedrab' | kw= 'orange' | kw= 'orangered' | kw= 'orchid' | kw= 'palegoldenrod' | kw= 'palegreen' | kw= 'paleturquoise' | kw= 'palevioletred' | kw= 'papayawhip' | kw= 'peachpuff' | kw= 'peru' | kw= 'pink' | kw= 'plum' | kw= 'powderblue' | kw= 'purple' | kw= 'red' | kw= 'rosybrown' | kw= 'royalblue' | kw= 'saddlebrown' | kw= 'salmon' | kw= 'sandybrown' | kw= 'seagreen' | kw= 'seashell' | kw= 'sienna' | kw= 'silver' | kw= 'skyblue' | kw= 'slateblue' | kw= 'slategray' | kw= 'slategrey' | kw= 'snow' | kw= 'springgreen' | kw= 'steelblue' | kw= 'tan' | kw= 'teal' | kw= 'thistle' | kw= 'tomato' | kw= 'turquoise' | kw= 'violet' | kw= 'wheat' | kw= 'white' | kw= 'whitesmoke' | kw= 'yellow' | kw= 'yellowgreen' | kw= 'transparent' )
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
                    // InternalLatteCSS.g:3933:2: kw= 'aliceblue'
                    {
                    kw=(Token)match(input,150,FOLLOW_2); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getNamedColorAccess().getAliceblueKeyword_0()); 
                        

                    }
                    break;
                case 2 :
                    // InternalLatteCSS.g:3940:2: kw= 'antiquewhite'
                    {
                    kw=(Token)match(input,151,FOLLOW_2); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getNamedColorAccess().getAntiquewhiteKeyword_1()); 
                        

                    }
                    break;
                case 3 :
                    // InternalLatteCSS.g:3947:2: kw= 'aqua'
                    {
                    kw=(Token)match(input,152,FOLLOW_2); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getNamedColorAccess().getAquaKeyword_2()); 
                        

                    }
                    break;
                case 4 :
                    // InternalLatteCSS.g:3954:2: kw= 'aquamarine'
                    {
                    kw=(Token)match(input,153,FOLLOW_2); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getNamedColorAccess().getAquamarineKeyword_3()); 
                        

                    }
                    break;
                case 5 :
                    // InternalLatteCSS.g:3961:2: kw= 'azure'
                    {
                    kw=(Token)match(input,154,FOLLOW_2); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getNamedColorAccess().getAzureKeyword_4()); 
                        

                    }
                    break;
                case 6 :
                    // InternalLatteCSS.g:3968:2: kw= 'beige'
                    {
                    kw=(Token)match(input,155,FOLLOW_2); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getNamedColorAccess().getBeigeKeyword_5()); 
                        

                    }
                    break;
                case 7 :
                    // InternalLatteCSS.g:3975:2: kw= 'bisque'
                    {
                    kw=(Token)match(input,156,FOLLOW_2); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getNamedColorAccess().getBisqueKeyword_6()); 
                        

                    }
                    break;
                case 8 :
                    // InternalLatteCSS.g:3982:2: kw= 'black'
                    {
                    kw=(Token)match(input,157,FOLLOW_2); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getNamedColorAccess().getBlackKeyword_7()); 
                        

                    }
                    break;
                case 9 :
                    // InternalLatteCSS.g:3989:2: kw= 'blanchedalmond'
                    {
                    kw=(Token)match(input,158,FOLLOW_2); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getNamedColorAccess().getBlanchedalmondKeyword_8()); 
                        

                    }
                    break;
                case 10 :
                    // InternalLatteCSS.g:3996:2: kw= 'blue'
                    {
                    kw=(Token)match(input,159,FOLLOW_2); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getNamedColorAccess().getBlueKeyword_9()); 
                        

                    }
                    break;
                case 11 :
                    // InternalLatteCSS.g:4003:2: kw= 'blueviolet'
                    {
                    kw=(Token)match(input,160,FOLLOW_2); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getNamedColorAccess().getBluevioletKeyword_10()); 
                        

                    }
                    break;
                case 12 :
                    // InternalLatteCSS.g:4010:2: kw= 'brown'
                    {
                    kw=(Token)match(input,161,FOLLOW_2); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getNamedColorAccess().getBrownKeyword_11()); 
                        

                    }
                    break;
                case 13 :
                    // InternalLatteCSS.g:4017:2: kw= 'burlywood'
                    {
                    kw=(Token)match(input,162,FOLLOW_2); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getNamedColorAccess().getBurlywoodKeyword_12()); 
                        

                    }
                    break;
                case 14 :
                    // InternalLatteCSS.g:4024:2: kw= 'cadetblue'
                    {
                    kw=(Token)match(input,163,FOLLOW_2); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getNamedColorAccess().getCadetblueKeyword_13()); 
                        

                    }
                    break;
                case 15 :
                    // InternalLatteCSS.g:4031:2: kw= 'chartreuse'
                    {
                    kw=(Token)match(input,164,FOLLOW_2); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getNamedColorAccess().getChartreuseKeyword_14()); 
                        

                    }
                    break;
                case 16 :
                    // InternalLatteCSS.g:4038:2: kw= 'chocolate'
                    {
                    kw=(Token)match(input,165,FOLLOW_2); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getNamedColorAccess().getChocolateKeyword_15()); 
                        

                    }
                    break;
                case 17 :
                    // InternalLatteCSS.g:4045:2: kw= 'coral'
                    {
                    kw=(Token)match(input,166,FOLLOW_2); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getNamedColorAccess().getCoralKeyword_16()); 
                        

                    }
                    break;
                case 18 :
                    // InternalLatteCSS.g:4052:2: kw= 'cornflowerblue'
                    {
                    kw=(Token)match(input,167,FOLLOW_2); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getNamedColorAccess().getCornflowerblueKeyword_17()); 
                        

                    }
                    break;
                case 19 :
                    // InternalLatteCSS.g:4059:2: kw= 'cornsilk'
                    {
                    kw=(Token)match(input,168,FOLLOW_2); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getNamedColorAccess().getCornsilkKeyword_18()); 
                        

                    }
                    break;
                case 20 :
                    // InternalLatteCSS.g:4066:2: kw= 'crimson'
                    {
                    kw=(Token)match(input,169,FOLLOW_2); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getNamedColorAccess().getCrimsonKeyword_19()); 
                        

                    }
                    break;
                case 21 :
                    // InternalLatteCSS.g:4073:2: kw= 'cyan'
                    {
                    kw=(Token)match(input,170,FOLLOW_2); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getNamedColorAccess().getCyanKeyword_20()); 
                        

                    }
                    break;
                case 22 :
                    // InternalLatteCSS.g:4080:2: kw= 'darkblue'
                    {
                    kw=(Token)match(input,171,FOLLOW_2); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getNamedColorAccess().getDarkblueKeyword_21()); 
                        

                    }
                    break;
                case 23 :
                    // InternalLatteCSS.g:4087:2: kw= 'darkcyan'
                    {
                    kw=(Token)match(input,172,FOLLOW_2); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getNamedColorAccess().getDarkcyanKeyword_22()); 
                        

                    }
                    break;
                case 24 :
                    // InternalLatteCSS.g:4094:2: kw= 'darkgoldenrod'
                    {
                    kw=(Token)match(input,173,FOLLOW_2); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getNamedColorAccess().getDarkgoldenrodKeyword_23()); 
                        

                    }
                    break;
                case 25 :
                    // InternalLatteCSS.g:4101:2: kw= 'darkgray'
                    {
                    kw=(Token)match(input,174,FOLLOW_2); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getNamedColorAccess().getDarkgrayKeyword_24()); 
                        

                    }
                    break;
                case 26 :
                    // InternalLatteCSS.g:4108:2: kw= 'darkgreen'
                    {
                    kw=(Token)match(input,175,FOLLOW_2); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getNamedColorAccess().getDarkgreenKeyword_25()); 
                        

                    }
                    break;
                case 27 :
                    // InternalLatteCSS.g:4115:2: kw= 'darkgrey'
                    {
                    kw=(Token)match(input,176,FOLLOW_2); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getNamedColorAccess().getDarkgreyKeyword_26()); 
                        

                    }
                    break;
                case 28 :
                    // InternalLatteCSS.g:4122:2: kw= 'darkkhaki'
                    {
                    kw=(Token)match(input,177,FOLLOW_2); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getNamedColorAccess().getDarkkhakiKeyword_27()); 
                        

                    }
                    break;
                case 29 :
                    // InternalLatteCSS.g:4129:2: kw= 'darkmagenta'
                    {
                    kw=(Token)match(input,178,FOLLOW_2); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getNamedColorAccess().getDarkmagentaKeyword_28()); 
                        

                    }
                    break;
                case 30 :
                    // InternalLatteCSS.g:4136:2: kw= 'darkolivegreen'
                    {
                    kw=(Token)match(input,179,FOLLOW_2); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getNamedColorAccess().getDarkolivegreenKeyword_29()); 
                        

                    }
                    break;
                case 31 :
                    // InternalLatteCSS.g:4143:2: kw= 'darkorange'
                    {
                    kw=(Token)match(input,180,FOLLOW_2); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getNamedColorAccess().getDarkorangeKeyword_30()); 
                        

                    }
                    break;
                case 32 :
                    // InternalLatteCSS.g:4150:2: kw= 'darkorchid'
                    {
                    kw=(Token)match(input,181,FOLLOW_2); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getNamedColorAccess().getDarkorchidKeyword_31()); 
                        

                    }
                    break;
                case 33 :
                    // InternalLatteCSS.g:4157:2: kw= 'darkred'
                    {
                    kw=(Token)match(input,182,FOLLOW_2); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getNamedColorAccess().getDarkredKeyword_32()); 
                        

                    }
                    break;
                case 34 :
                    // InternalLatteCSS.g:4164:2: kw= 'darksalmon'
                    {
                    kw=(Token)match(input,183,FOLLOW_2); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getNamedColorAccess().getDarksalmonKeyword_33()); 
                        

                    }
                    break;
                case 35 :
                    // InternalLatteCSS.g:4171:2: kw= 'darkseagreen'
                    {
                    kw=(Token)match(input,184,FOLLOW_2); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getNamedColorAccess().getDarkseagreenKeyword_34()); 
                        

                    }
                    break;
                case 36 :
                    // InternalLatteCSS.g:4178:2: kw= 'darkslateblue'
                    {
                    kw=(Token)match(input,185,FOLLOW_2); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getNamedColorAccess().getDarkslateblueKeyword_35()); 
                        

                    }
                    break;
                case 37 :
                    // InternalLatteCSS.g:4185:2: kw= 'darkslategray'
                    {
                    kw=(Token)match(input,186,FOLLOW_2); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getNamedColorAccess().getDarkslategrayKeyword_36()); 
                        

                    }
                    break;
                case 38 :
                    // InternalLatteCSS.g:4192:2: kw= 'darkslategrey'
                    {
                    kw=(Token)match(input,187,FOLLOW_2); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getNamedColorAccess().getDarkslategreyKeyword_37()); 
                        

                    }
                    break;
                case 39 :
                    // InternalLatteCSS.g:4199:2: kw= 'darkturquoise'
                    {
                    kw=(Token)match(input,188,FOLLOW_2); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getNamedColorAccess().getDarkturquoiseKeyword_38()); 
                        

                    }
                    break;
                case 40 :
                    // InternalLatteCSS.g:4206:2: kw= 'darkviolet'
                    {
                    kw=(Token)match(input,189,FOLLOW_2); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getNamedColorAccess().getDarkvioletKeyword_39()); 
                        

                    }
                    break;
                case 41 :
                    // InternalLatteCSS.g:4213:2: kw= 'deeppink'
                    {
                    kw=(Token)match(input,190,FOLLOW_2); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getNamedColorAccess().getDeeppinkKeyword_40()); 
                        

                    }
                    break;
                case 42 :
                    // InternalLatteCSS.g:4220:2: kw= 'deepskyblue'
                    {
                    kw=(Token)match(input,191,FOLLOW_2); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getNamedColorAccess().getDeepskyblueKeyword_41()); 
                        

                    }
                    break;
                case 43 :
                    // InternalLatteCSS.g:4227:2: kw= 'dimgray'
                    {
                    kw=(Token)match(input,192,FOLLOW_2); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getNamedColorAccess().getDimgrayKeyword_42()); 
                        

                    }
                    break;
                case 44 :
                    // InternalLatteCSS.g:4234:2: kw= 'dimgrey'
                    {
                    kw=(Token)match(input,193,FOLLOW_2); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getNamedColorAccess().getDimgreyKeyword_43()); 
                        

                    }
                    break;
                case 45 :
                    // InternalLatteCSS.g:4241:2: kw= 'dodgerblue'
                    {
                    kw=(Token)match(input,194,FOLLOW_2); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getNamedColorAccess().getDodgerblueKeyword_44()); 
                        

                    }
                    break;
                case 46 :
                    // InternalLatteCSS.g:4248:2: kw= 'firebrick'
                    {
                    kw=(Token)match(input,195,FOLLOW_2); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getNamedColorAccess().getFirebrickKeyword_45()); 
                        

                    }
                    break;
                case 47 :
                    // InternalLatteCSS.g:4255:2: kw= 'floralwhite'
                    {
                    kw=(Token)match(input,196,FOLLOW_2); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getNamedColorAccess().getFloralwhiteKeyword_46()); 
                        

                    }
                    break;
                case 48 :
                    // InternalLatteCSS.g:4262:2: kw= 'forestgreen'
                    {
                    kw=(Token)match(input,197,FOLLOW_2); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getNamedColorAccess().getForestgreenKeyword_47()); 
                        

                    }
                    break;
                case 49 :
                    // InternalLatteCSS.g:4269:2: kw= 'fuchsia'
                    {
                    kw=(Token)match(input,198,FOLLOW_2); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getNamedColorAccess().getFuchsiaKeyword_48()); 
                        

                    }
                    break;
                case 50 :
                    // InternalLatteCSS.g:4276:2: kw= 'gainsboro'
                    {
                    kw=(Token)match(input,199,FOLLOW_2); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getNamedColorAccess().getGainsboroKeyword_49()); 
                        

                    }
                    break;
                case 51 :
                    // InternalLatteCSS.g:4283:2: kw= 'ghostwhite'
                    {
                    kw=(Token)match(input,200,FOLLOW_2); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getNamedColorAccess().getGhostwhiteKeyword_50()); 
                        

                    }
                    break;
                case 52 :
                    // InternalLatteCSS.g:4290:2: kw= 'gold'
                    {
                    kw=(Token)match(input,201,FOLLOW_2); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getNamedColorAccess().getGoldKeyword_51()); 
                        

                    }
                    break;
                case 53 :
                    // InternalLatteCSS.g:4297:2: kw= 'goldenrod'
                    {
                    kw=(Token)match(input,202,FOLLOW_2); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getNamedColorAccess().getGoldenrodKeyword_52()); 
                        

                    }
                    break;
                case 54 :
                    // InternalLatteCSS.g:4304:2: kw= 'gray'
                    {
                    kw=(Token)match(input,203,FOLLOW_2); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getNamedColorAccess().getGrayKeyword_53()); 
                        

                    }
                    break;
                case 55 :
                    // InternalLatteCSS.g:4311:2: kw= 'green'
                    {
                    kw=(Token)match(input,204,FOLLOW_2); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getNamedColorAccess().getGreenKeyword_54()); 
                        

                    }
                    break;
                case 56 :
                    // InternalLatteCSS.g:4318:2: kw= 'greenyellow'
                    {
                    kw=(Token)match(input,205,FOLLOW_2); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getNamedColorAccess().getGreenyellowKeyword_55()); 
                        

                    }
                    break;
                case 57 :
                    // InternalLatteCSS.g:4325:2: kw= 'grey'
                    {
                    kw=(Token)match(input,206,FOLLOW_2); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getNamedColorAccess().getGreyKeyword_56()); 
                        

                    }
                    break;
                case 58 :
                    // InternalLatteCSS.g:4332:2: kw= 'honeydew'
                    {
                    kw=(Token)match(input,207,FOLLOW_2); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getNamedColorAccess().getHoneydewKeyword_57()); 
                        

                    }
                    break;
                case 59 :
                    // InternalLatteCSS.g:4339:2: kw= 'hotpink'
                    {
                    kw=(Token)match(input,208,FOLLOW_2); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getNamedColorAccess().getHotpinkKeyword_58()); 
                        

                    }
                    break;
                case 60 :
                    // InternalLatteCSS.g:4346:2: kw= 'indianred'
                    {
                    kw=(Token)match(input,209,FOLLOW_2); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getNamedColorAccess().getIndianredKeyword_59()); 
                        

                    }
                    break;
                case 61 :
                    // InternalLatteCSS.g:4353:2: kw= 'indigo'
                    {
                    kw=(Token)match(input,210,FOLLOW_2); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getNamedColorAccess().getIndigoKeyword_60()); 
                        

                    }
                    break;
                case 62 :
                    // InternalLatteCSS.g:4360:2: kw= 'ivory'
                    {
                    kw=(Token)match(input,211,FOLLOW_2); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getNamedColorAccess().getIvoryKeyword_61()); 
                        

                    }
                    break;
                case 63 :
                    // InternalLatteCSS.g:4367:2: kw= 'khaki'
                    {
                    kw=(Token)match(input,212,FOLLOW_2); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getNamedColorAccess().getKhakiKeyword_62()); 
                        

                    }
                    break;
                case 64 :
                    // InternalLatteCSS.g:4374:2: kw= 'lavender'
                    {
                    kw=(Token)match(input,213,FOLLOW_2); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getNamedColorAccess().getLavenderKeyword_63()); 
                        

                    }
                    break;
                case 65 :
                    // InternalLatteCSS.g:4381:2: kw= 'lavenderblush'
                    {
                    kw=(Token)match(input,214,FOLLOW_2); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getNamedColorAccess().getLavenderblushKeyword_64()); 
                        

                    }
                    break;
                case 66 :
                    // InternalLatteCSS.g:4388:2: kw= 'lawngreen'
                    {
                    kw=(Token)match(input,215,FOLLOW_2); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getNamedColorAccess().getLawngreenKeyword_65()); 
                        

                    }
                    break;
                case 67 :
                    // InternalLatteCSS.g:4395:2: kw= 'lemonchiffon'
                    {
                    kw=(Token)match(input,216,FOLLOW_2); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getNamedColorAccess().getLemonchiffonKeyword_66()); 
                        

                    }
                    break;
                case 68 :
                    // InternalLatteCSS.g:4402:2: kw= 'lightblue'
                    {
                    kw=(Token)match(input,217,FOLLOW_2); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getNamedColorAccess().getLightblueKeyword_67()); 
                        

                    }
                    break;
                case 69 :
                    // InternalLatteCSS.g:4409:2: kw= 'lightcoral'
                    {
                    kw=(Token)match(input,218,FOLLOW_2); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getNamedColorAccess().getLightcoralKeyword_68()); 
                        

                    }
                    break;
                case 70 :
                    // InternalLatteCSS.g:4416:2: kw= 'lightcyan'
                    {
                    kw=(Token)match(input,219,FOLLOW_2); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getNamedColorAccess().getLightcyanKeyword_69()); 
                        

                    }
                    break;
                case 71 :
                    // InternalLatteCSS.g:4423:2: kw= 'lightgoldenrodyellow'
                    {
                    kw=(Token)match(input,220,FOLLOW_2); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getNamedColorAccess().getLightgoldenrodyellowKeyword_70()); 
                        

                    }
                    break;
                case 72 :
                    // InternalLatteCSS.g:4430:2: kw= 'lightgray'
                    {
                    kw=(Token)match(input,221,FOLLOW_2); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getNamedColorAccess().getLightgrayKeyword_71()); 
                        

                    }
                    break;
                case 73 :
                    // InternalLatteCSS.g:4437:2: kw= 'lightgreen'
                    {
                    kw=(Token)match(input,222,FOLLOW_2); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getNamedColorAccess().getLightgreenKeyword_72()); 
                        

                    }
                    break;
                case 74 :
                    // InternalLatteCSS.g:4444:2: kw= 'lightgrey'
                    {
                    kw=(Token)match(input,223,FOLLOW_2); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getNamedColorAccess().getLightgreyKeyword_73()); 
                        

                    }
                    break;
                case 75 :
                    // InternalLatteCSS.g:4451:2: kw= 'lightpink'
                    {
                    kw=(Token)match(input,224,FOLLOW_2); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getNamedColorAccess().getLightpinkKeyword_74()); 
                        

                    }
                    break;
                case 76 :
                    // InternalLatteCSS.g:4458:2: kw= 'lightsalmon'
                    {
                    kw=(Token)match(input,225,FOLLOW_2); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getNamedColorAccess().getLightsalmonKeyword_75()); 
                        

                    }
                    break;
                case 77 :
                    // InternalLatteCSS.g:4465:2: kw= 'lightseagreen'
                    {
                    kw=(Token)match(input,226,FOLLOW_2); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getNamedColorAccess().getLightseagreenKeyword_76()); 
                        

                    }
                    break;
                case 78 :
                    // InternalLatteCSS.g:4472:2: kw= 'lightskyblue'
                    {
                    kw=(Token)match(input,227,FOLLOW_2); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getNamedColorAccess().getLightskyblueKeyword_77()); 
                        

                    }
                    break;
                case 79 :
                    // InternalLatteCSS.g:4479:2: kw= 'lightslategray'
                    {
                    kw=(Token)match(input,228,FOLLOW_2); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getNamedColorAccess().getLightslategrayKeyword_78()); 
                        

                    }
                    break;
                case 80 :
                    // InternalLatteCSS.g:4486:2: kw= 'lightslategrey'
                    {
                    kw=(Token)match(input,229,FOLLOW_2); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getNamedColorAccess().getLightslategreyKeyword_79()); 
                        

                    }
                    break;
                case 81 :
                    // InternalLatteCSS.g:4493:2: kw= 'lightsteelblue'
                    {
                    kw=(Token)match(input,230,FOLLOW_2); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getNamedColorAccess().getLightsteelblueKeyword_80()); 
                        

                    }
                    break;
                case 82 :
                    // InternalLatteCSS.g:4500:2: kw= 'lightyellow'
                    {
                    kw=(Token)match(input,231,FOLLOW_2); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getNamedColorAccess().getLightyellowKeyword_81()); 
                        

                    }
                    break;
                case 83 :
                    // InternalLatteCSS.g:4507:2: kw= 'lime'
                    {
                    kw=(Token)match(input,232,FOLLOW_2); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getNamedColorAccess().getLimeKeyword_82()); 
                        

                    }
                    break;
                case 84 :
                    // InternalLatteCSS.g:4514:2: kw= 'limegreen'
                    {
                    kw=(Token)match(input,233,FOLLOW_2); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getNamedColorAccess().getLimegreenKeyword_83()); 
                        

                    }
                    break;
                case 85 :
                    // InternalLatteCSS.g:4521:2: kw= 'linen'
                    {
                    kw=(Token)match(input,234,FOLLOW_2); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getNamedColorAccess().getLinenKeyword_84()); 
                        

                    }
                    break;
                case 86 :
                    // InternalLatteCSS.g:4528:2: kw= 'magenta'
                    {
                    kw=(Token)match(input,235,FOLLOW_2); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getNamedColorAccess().getMagentaKeyword_85()); 
                        

                    }
                    break;
                case 87 :
                    // InternalLatteCSS.g:4535:2: kw= 'maroon'
                    {
                    kw=(Token)match(input,236,FOLLOW_2); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getNamedColorAccess().getMaroonKeyword_86()); 
                        

                    }
                    break;
                case 88 :
                    // InternalLatteCSS.g:4542:2: kw= 'mediumaquamarine'
                    {
                    kw=(Token)match(input,237,FOLLOW_2); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getNamedColorAccess().getMediumaquamarineKeyword_87()); 
                        

                    }
                    break;
                case 89 :
                    // InternalLatteCSS.g:4549:2: kw= 'mediumblue'
                    {
                    kw=(Token)match(input,238,FOLLOW_2); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getNamedColorAccess().getMediumblueKeyword_88()); 
                        

                    }
                    break;
                case 90 :
                    // InternalLatteCSS.g:4556:2: kw= 'mediumorchid'
                    {
                    kw=(Token)match(input,239,FOLLOW_2); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getNamedColorAccess().getMediumorchidKeyword_89()); 
                        

                    }
                    break;
                case 91 :
                    // InternalLatteCSS.g:4563:2: kw= 'mediumpurple'
                    {
                    kw=(Token)match(input,240,FOLLOW_2); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getNamedColorAccess().getMediumpurpleKeyword_90()); 
                        

                    }
                    break;
                case 92 :
                    // InternalLatteCSS.g:4570:2: kw= 'mediumseagreen'
                    {
                    kw=(Token)match(input,241,FOLLOW_2); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getNamedColorAccess().getMediumseagreenKeyword_91()); 
                        

                    }
                    break;
                case 93 :
                    // InternalLatteCSS.g:4577:2: kw= 'mediumslateblue'
                    {
                    kw=(Token)match(input,242,FOLLOW_2); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getNamedColorAccess().getMediumslateblueKeyword_92()); 
                        

                    }
                    break;
                case 94 :
                    // InternalLatteCSS.g:4584:2: kw= 'mediumspringgreen'
                    {
                    kw=(Token)match(input,243,FOLLOW_2); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getNamedColorAccess().getMediumspringgreenKeyword_93()); 
                        

                    }
                    break;
                case 95 :
                    // InternalLatteCSS.g:4591:2: kw= 'mediumturquoise'
                    {
                    kw=(Token)match(input,244,FOLLOW_2); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getNamedColorAccess().getMediumturquoiseKeyword_94()); 
                        

                    }
                    break;
                case 96 :
                    // InternalLatteCSS.g:4598:2: kw= 'mediumvioletred'
                    {
                    kw=(Token)match(input,245,FOLLOW_2); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getNamedColorAccess().getMediumvioletredKeyword_95()); 
                        

                    }
                    break;
                case 97 :
                    // InternalLatteCSS.g:4605:2: kw= 'midnightblue'
                    {
                    kw=(Token)match(input,246,FOLLOW_2); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getNamedColorAccess().getMidnightblueKeyword_96()); 
                        

                    }
                    break;
                case 98 :
                    // InternalLatteCSS.g:4612:2: kw= 'mintcream'
                    {
                    kw=(Token)match(input,247,FOLLOW_2); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getNamedColorAccess().getMintcreamKeyword_97()); 
                        

                    }
                    break;
                case 99 :
                    // InternalLatteCSS.g:4619:2: kw= 'mistyrose'
                    {
                    kw=(Token)match(input,248,FOLLOW_2); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getNamedColorAccess().getMistyroseKeyword_98()); 
                        

                    }
                    break;
                case 100 :
                    // InternalLatteCSS.g:4626:2: kw= 'moccasin'
                    {
                    kw=(Token)match(input,249,FOLLOW_2); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getNamedColorAccess().getMoccasinKeyword_99()); 
                        

                    }
                    break;
                case 101 :
                    // InternalLatteCSS.g:4633:2: kw= 'navajowhite'
                    {
                    kw=(Token)match(input,250,FOLLOW_2); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getNamedColorAccess().getNavajowhiteKeyword_100()); 
                        

                    }
                    break;
                case 102 :
                    // InternalLatteCSS.g:4640:2: kw= 'navy'
                    {
                    kw=(Token)match(input,251,FOLLOW_2); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getNamedColorAccess().getNavyKeyword_101()); 
                        

                    }
                    break;
                case 103 :
                    // InternalLatteCSS.g:4647:2: kw= 'oldlace'
                    {
                    kw=(Token)match(input,252,FOLLOW_2); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getNamedColorAccess().getOldlaceKeyword_102()); 
                        

                    }
                    break;
                case 104 :
                    // InternalLatteCSS.g:4654:2: kw= 'olive'
                    {
                    kw=(Token)match(input,253,FOLLOW_2); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getNamedColorAccess().getOliveKeyword_103()); 
                        

                    }
                    break;
                case 105 :
                    // InternalLatteCSS.g:4661:2: kw= 'olivedrab'
                    {
                    kw=(Token)match(input,254,FOLLOW_2); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getNamedColorAccess().getOlivedrabKeyword_104()); 
                        

                    }
                    break;
                case 106 :
                    // InternalLatteCSS.g:4668:2: kw= 'orange'
                    {
                    kw=(Token)match(input,255,FOLLOW_2); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getNamedColorAccess().getOrangeKeyword_105()); 
                        

                    }
                    break;
                case 107 :
                    // InternalLatteCSS.g:4675:2: kw= 'orangered'
                    {
                    kw=(Token)match(input,256,FOLLOW_2); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getNamedColorAccess().getOrangeredKeyword_106()); 
                        

                    }
                    break;
                case 108 :
                    // InternalLatteCSS.g:4682:2: kw= 'orchid'
                    {
                    kw=(Token)match(input,257,FOLLOW_2); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getNamedColorAccess().getOrchidKeyword_107()); 
                        

                    }
                    break;
                case 109 :
                    // InternalLatteCSS.g:4689:2: kw= 'palegoldenrod'
                    {
                    kw=(Token)match(input,258,FOLLOW_2); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getNamedColorAccess().getPalegoldenrodKeyword_108()); 
                        

                    }
                    break;
                case 110 :
                    // InternalLatteCSS.g:4696:2: kw= 'palegreen'
                    {
                    kw=(Token)match(input,259,FOLLOW_2); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getNamedColorAccess().getPalegreenKeyword_109()); 
                        

                    }
                    break;
                case 111 :
                    // InternalLatteCSS.g:4703:2: kw= 'paleturquoise'
                    {
                    kw=(Token)match(input,260,FOLLOW_2); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getNamedColorAccess().getPaleturquoiseKeyword_110()); 
                        

                    }
                    break;
                case 112 :
                    // InternalLatteCSS.g:4710:2: kw= 'palevioletred'
                    {
                    kw=(Token)match(input,261,FOLLOW_2); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getNamedColorAccess().getPalevioletredKeyword_111()); 
                        

                    }
                    break;
                case 113 :
                    // InternalLatteCSS.g:4717:2: kw= 'papayawhip'
                    {
                    kw=(Token)match(input,262,FOLLOW_2); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getNamedColorAccess().getPapayawhipKeyword_112()); 
                        

                    }
                    break;
                case 114 :
                    // InternalLatteCSS.g:4724:2: kw= 'peachpuff'
                    {
                    kw=(Token)match(input,263,FOLLOW_2); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getNamedColorAccess().getPeachpuffKeyword_113()); 
                        

                    }
                    break;
                case 115 :
                    // InternalLatteCSS.g:4731:2: kw= 'peru'
                    {
                    kw=(Token)match(input,264,FOLLOW_2); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getNamedColorAccess().getPeruKeyword_114()); 
                        

                    }
                    break;
                case 116 :
                    // InternalLatteCSS.g:4738:2: kw= 'pink'
                    {
                    kw=(Token)match(input,265,FOLLOW_2); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getNamedColorAccess().getPinkKeyword_115()); 
                        

                    }
                    break;
                case 117 :
                    // InternalLatteCSS.g:4745:2: kw= 'plum'
                    {
                    kw=(Token)match(input,266,FOLLOW_2); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getNamedColorAccess().getPlumKeyword_116()); 
                        

                    }
                    break;
                case 118 :
                    // InternalLatteCSS.g:4752:2: kw= 'powderblue'
                    {
                    kw=(Token)match(input,267,FOLLOW_2); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getNamedColorAccess().getPowderblueKeyword_117()); 
                        

                    }
                    break;
                case 119 :
                    // InternalLatteCSS.g:4759:2: kw= 'purple'
                    {
                    kw=(Token)match(input,268,FOLLOW_2); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getNamedColorAccess().getPurpleKeyword_118()); 
                        

                    }
                    break;
                case 120 :
                    // InternalLatteCSS.g:4766:2: kw= 'red'
                    {
                    kw=(Token)match(input,269,FOLLOW_2); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getNamedColorAccess().getRedKeyword_119()); 
                        

                    }
                    break;
                case 121 :
                    // InternalLatteCSS.g:4773:2: kw= 'rosybrown'
                    {
                    kw=(Token)match(input,270,FOLLOW_2); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getNamedColorAccess().getRosybrownKeyword_120()); 
                        

                    }
                    break;
                case 122 :
                    // InternalLatteCSS.g:4780:2: kw= 'royalblue'
                    {
                    kw=(Token)match(input,271,FOLLOW_2); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getNamedColorAccess().getRoyalblueKeyword_121()); 
                        

                    }
                    break;
                case 123 :
                    // InternalLatteCSS.g:4787:2: kw= 'saddlebrown'
                    {
                    kw=(Token)match(input,272,FOLLOW_2); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getNamedColorAccess().getSaddlebrownKeyword_122()); 
                        

                    }
                    break;
                case 124 :
                    // InternalLatteCSS.g:4794:2: kw= 'salmon'
                    {
                    kw=(Token)match(input,273,FOLLOW_2); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getNamedColorAccess().getSalmonKeyword_123()); 
                        

                    }
                    break;
                case 125 :
                    // InternalLatteCSS.g:4801:2: kw= 'sandybrown'
                    {
                    kw=(Token)match(input,274,FOLLOW_2); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getNamedColorAccess().getSandybrownKeyword_124()); 
                        

                    }
                    break;
                case 126 :
                    // InternalLatteCSS.g:4808:2: kw= 'seagreen'
                    {
                    kw=(Token)match(input,275,FOLLOW_2); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getNamedColorAccess().getSeagreenKeyword_125()); 
                        

                    }
                    break;
                case 127 :
                    // InternalLatteCSS.g:4815:2: kw= 'seashell'
                    {
                    kw=(Token)match(input,276,FOLLOW_2); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getNamedColorAccess().getSeashellKeyword_126()); 
                        

                    }
                    break;
                case 128 :
                    // InternalLatteCSS.g:4822:2: kw= 'sienna'
                    {
                    kw=(Token)match(input,277,FOLLOW_2); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getNamedColorAccess().getSiennaKeyword_127()); 
                        

                    }
                    break;
                case 129 :
                    // InternalLatteCSS.g:4829:2: kw= 'silver'
                    {
                    kw=(Token)match(input,278,FOLLOW_2); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getNamedColorAccess().getSilverKeyword_128()); 
                        

                    }
                    break;
                case 130 :
                    // InternalLatteCSS.g:4836:2: kw= 'skyblue'
                    {
                    kw=(Token)match(input,279,FOLLOW_2); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getNamedColorAccess().getSkyblueKeyword_129()); 
                        

                    }
                    break;
                case 131 :
                    // InternalLatteCSS.g:4843:2: kw= 'slateblue'
                    {
                    kw=(Token)match(input,280,FOLLOW_2); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getNamedColorAccess().getSlateblueKeyword_130()); 
                        

                    }
                    break;
                case 132 :
                    // InternalLatteCSS.g:4850:2: kw= 'slategray'
                    {
                    kw=(Token)match(input,281,FOLLOW_2); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getNamedColorAccess().getSlategrayKeyword_131()); 
                        

                    }
                    break;
                case 133 :
                    // InternalLatteCSS.g:4857:2: kw= 'slategrey'
                    {
                    kw=(Token)match(input,282,FOLLOW_2); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getNamedColorAccess().getSlategreyKeyword_132()); 
                        

                    }
                    break;
                case 134 :
                    // InternalLatteCSS.g:4864:2: kw= 'snow'
                    {
                    kw=(Token)match(input,283,FOLLOW_2); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getNamedColorAccess().getSnowKeyword_133()); 
                        

                    }
                    break;
                case 135 :
                    // InternalLatteCSS.g:4871:2: kw= 'springgreen'
                    {
                    kw=(Token)match(input,284,FOLLOW_2); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getNamedColorAccess().getSpringgreenKeyword_134()); 
                        

                    }
                    break;
                case 136 :
                    // InternalLatteCSS.g:4878:2: kw= 'steelblue'
                    {
                    kw=(Token)match(input,285,FOLLOW_2); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getNamedColorAccess().getSteelblueKeyword_135()); 
                        

                    }
                    break;
                case 137 :
                    // InternalLatteCSS.g:4885:2: kw= 'tan'
                    {
                    kw=(Token)match(input,286,FOLLOW_2); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getNamedColorAccess().getTanKeyword_136()); 
                        

                    }
                    break;
                case 138 :
                    // InternalLatteCSS.g:4892:2: kw= 'teal'
                    {
                    kw=(Token)match(input,287,FOLLOW_2); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getNamedColorAccess().getTealKeyword_137()); 
                        

                    }
                    break;
                case 139 :
                    // InternalLatteCSS.g:4899:2: kw= 'thistle'
                    {
                    kw=(Token)match(input,288,FOLLOW_2); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getNamedColorAccess().getThistleKeyword_138()); 
                        

                    }
                    break;
                case 140 :
                    // InternalLatteCSS.g:4906:2: kw= 'tomato'
                    {
                    kw=(Token)match(input,289,FOLLOW_2); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getNamedColorAccess().getTomatoKeyword_139()); 
                        

                    }
                    break;
                case 141 :
                    // InternalLatteCSS.g:4913:2: kw= 'turquoise'
                    {
                    kw=(Token)match(input,290,FOLLOW_2); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getNamedColorAccess().getTurquoiseKeyword_140()); 
                        

                    }
                    break;
                case 142 :
                    // InternalLatteCSS.g:4920:2: kw= 'violet'
                    {
                    kw=(Token)match(input,291,FOLLOW_2); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getNamedColorAccess().getVioletKeyword_141()); 
                        

                    }
                    break;
                case 143 :
                    // InternalLatteCSS.g:4927:2: kw= 'wheat'
                    {
                    kw=(Token)match(input,292,FOLLOW_2); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getNamedColorAccess().getWheatKeyword_142()); 
                        

                    }
                    break;
                case 144 :
                    // InternalLatteCSS.g:4934:2: kw= 'white'
                    {
                    kw=(Token)match(input,293,FOLLOW_2); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getNamedColorAccess().getWhiteKeyword_143()); 
                        

                    }
                    break;
                case 145 :
                    // InternalLatteCSS.g:4941:2: kw= 'whitesmoke'
                    {
                    kw=(Token)match(input,294,FOLLOW_2); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getNamedColorAccess().getWhitesmokeKeyword_144()); 
                        

                    }
                    break;
                case 146 :
                    // InternalLatteCSS.g:4948:2: kw= 'yellow'
                    {
                    kw=(Token)match(input,295,FOLLOW_2); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getNamedColorAccess().getYellowKeyword_145()); 
                        

                    }
                    break;
                case 147 :
                    // InternalLatteCSS.g:4955:2: kw= 'yellowgreen'
                    {
                    kw=(Token)match(input,296,FOLLOW_2); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getNamedColorAccess().getYellowgreenKeyword_146()); 
                        

                    }
                    break;
                case 148 :
                    // InternalLatteCSS.g:4962:2: kw= 'transparent'
                    {
                    kw=(Token)match(input,297,FOLLOW_2); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getNamedColorAccess().getTransparentKeyword_147()); 
                        

                    }
                    break;

            }


            }

             leaveRule(); 
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleNamedColor"


    // $ANTLR start "entryRuleRGBColor"
    // InternalLatteCSS.g:4975:1: entryRuleRGBColor returns [EObject current=null] : iv_ruleRGBColor= ruleRGBColor EOF ;
    public final EObject entryRuleRGBColor() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleRGBColor = null;


        try {
            // InternalLatteCSS.g:4976:2: (iv_ruleRGBColor= ruleRGBColor EOF )
            // InternalLatteCSS.g:4977:2: iv_ruleRGBColor= ruleRGBColor EOF
            {
             newCompositeNode(grammarAccess.getRGBColorRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleRGBColor=ruleRGBColor();

            state._fsp--;

             current =iv_ruleRGBColor; 
            match(input,EOF,FOLLOW_2); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleRGBColor"


    // $ANTLR start "ruleRGBColor"
    // InternalLatteCSS.g:4984:1: ruleRGBColor returns [EObject current=null] : ( ( (lv_hex_0_0= RULE_HEX_NUMBER ) ) | (otherlv_1= 'rgb' otherlv_2= '(' ( (lv_r_3_0= ruleIntegerValue ) ) otherlv_4= ',' ( (lv_g_5_0= ruleIntegerValue ) ) otherlv_6= ',' ( (lv_b_7_0= ruleIntegerValue ) ) otherlv_8= ')' ) | (otherlv_9= 'rgba' otherlv_10= '(' ( (lv_r_11_0= ruleIntegerValue ) ) otherlv_12= ',' ( (lv_g_13_0= ruleIntegerValue ) ) otherlv_14= ',' ( (lv_b_15_0= ruleIntegerValue ) ) otherlv_16= ',' ( (lv_alpha_17_0= ruleNumberValue ) ) otherlv_18= ')' ) ) ;
    public final EObject ruleRGBColor() throws RecognitionException {
        EObject current = null;

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
        AntlrDatatypeRuleToken lv_r_3_0 = null;

        AntlrDatatypeRuleToken lv_g_5_0 = null;

        AntlrDatatypeRuleToken lv_b_7_0 = null;

        AntlrDatatypeRuleToken lv_r_11_0 = null;

        AntlrDatatypeRuleToken lv_g_13_0 = null;

        AntlrDatatypeRuleToken lv_b_15_0 = null;

        AntlrDatatypeRuleToken lv_alpha_17_0 = null;


         enterRule(); 
            
        try {
            // InternalLatteCSS.g:4987:28: ( ( ( (lv_hex_0_0= RULE_HEX_NUMBER ) ) | (otherlv_1= 'rgb' otherlv_2= '(' ( (lv_r_3_0= ruleIntegerValue ) ) otherlv_4= ',' ( (lv_g_5_0= ruleIntegerValue ) ) otherlv_6= ',' ( (lv_b_7_0= ruleIntegerValue ) ) otherlv_8= ')' ) | (otherlv_9= 'rgba' otherlv_10= '(' ( (lv_r_11_0= ruleIntegerValue ) ) otherlv_12= ',' ( (lv_g_13_0= ruleIntegerValue ) ) otherlv_14= ',' ( (lv_b_15_0= ruleIntegerValue ) ) otherlv_16= ',' ( (lv_alpha_17_0= ruleNumberValue ) ) otherlv_18= ')' ) ) )
            // InternalLatteCSS.g:4988:1: ( ( (lv_hex_0_0= RULE_HEX_NUMBER ) ) | (otherlv_1= 'rgb' otherlv_2= '(' ( (lv_r_3_0= ruleIntegerValue ) ) otherlv_4= ',' ( (lv_g_5_0= ruleIntegerValue ) ) otherlv_6= ',' ( (lv_b_7_0= ruleIntegerValue ) ) otherlv_8= ')' ) | (otherlv_9= 'rgba' otherlv_10= '(' ( (lv_r_11_0= ruleIntegerValue ) ) otherlv_12= ',' ( (lv_g_13_0= ruleIntegerValue ) ) otherlv_14= ',' ( (lv_b_15_0= ruleIntegerValue ) ) otherlv_16= ',' ( (lv_alpha_17_0= ruleNumberValue ) ) otherlv_18= ')' ) )
            {
            // InternalLatteCSS.g:4988:1: ( ( (lv_hex_0_0= RULE_HEX_NUMBER ) ) | (otherlv_1= 'rgb' otherlv_2= '(' ( (lv_r_3_0= ruleIntegerValue ) ) otherlv_4= ',' ( (lv_g_5_0= ruleIntegerValue ) ) otherlv_6= ',' ( (lv_b_7_0= ruleIntegerValue ) ) otherlv_8= ')' ) | (otherlv_9= 'rgba' otherlv_10= '(' ( (lv_r_11_0= ruleIntegerValue ) ) otherlv_12= ',' ( (lv_g_13_0= ruleIntegerValue ) ) otherlv_14= ',' ( (lv_b_15_0= ruleIntegerValue ) ) otherlv_16= ',' ( (lv_alpha_17_0= ruleNumberValue ) ) otherlv_18= ')' ) )
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
                    // InternalLatteCSS.g:4988:2: ( (lv_hex_0_0= RULE_HEX_NUMBER ) )
                    {
                    // InternalLatteCSS.g:4988:2: ( (lv_hex_0_0= RULE_HEX_NUMBER ) )
                    // InternalLatteCSS.g:4989:1: (lv_hex_0_0= RULE_HEX_NUMBER )
                    {
                    // InternalLatteCSS.g:4989:1: (lv_hex_0_0= RULE_HEX_NUMBER )
                    // InternalLatteCSS.g:4990:3: lv_hex_0_0= RULE_HEX_NUMBER
                    {
                    lv_hex_0_0=(Token)match(input,RULE_HEX_NUMBER,FOLLOW_2); 

                    			newLeafNode(lv_hex_0_0, grammarAccess.getRGBColorAccess().getHexHEX_NUMBERTerminalRuleCall_0_0()); 
                    		

                    	        if (current==null) {
                    	            current = createModelElement(grammarAccess.getRGBColorRule());
                    	        }
                           		setWithLastConsumed(
                           			current, 
                           			"hex",
                            		lv_hex_0_0, 
                            		"io.lattekit.dsl.LatteCSS.HEX_NUMBER");
                    	    

                    }


                    }


                    }
                    break;
                case 2 :
                    // InternalLatteCSS.g:5007:6: (otherlv_1= 'rgb' otherlv_2= '(' ( (lv_r_3_0= ruleIntegerValue ) ) otherlv_4= ',' ( (lv_g_5_0= ruleIntegerValue ) ) otherlv_6= ',' ( (lv_b_7_0= ruleIntegerValue ) ) otherlv_8= ')' )
                    {
                    // InternalLatteCSS.g:5007:6: (otherlv_1= 'rgb' otherlv_2= '(' ( (lv_r_3_0= ruleIntegerValue ) ) otherlv_4= ',' ( (lv_g_5_0= ruleIntegerValue ) ) otherlv_6= ',' ( (lv_b_7_0= ruleIntegerValue ) ) otherlv_8= ')' )
                    // InternalLatteCSS.g:5007:8: otherlv_1= 'rgb' otherlv_2= '(' ( (lv_r_3_0= ruleIntegerValue ) ) otherlv_4= ',' ( (lv_g_5_0= ruleIntegerValue ) ) otherlv_6= ',' ( (lv_b_7_0= ruleIntegerValue ) ) otherlv_8= ')'
                    {
                    otherlv_1=(Token)match(input,298,FOLLOW_32); 

                        	newLeafNode(otherlv_1, grammarAccess.getRGBColorAccess().getRgbKeyword_1_0());
                        
                    otherlv_2=(Token)match(input,142,FOLLOW_40); 

                        	newLeafNode(otherlv_2, grammarAccess.getRGBColorAccess().getLeftParenthesisKeyword_1_1());
                        
                    // InternalLatteCSS.g:5015:1: ( (lv_r_3_0= ruleIntegerValue ) )
                    // InternalLatteCSS.g:5016:1: (lv_r_3_0= ruleIntegerValue )
                    {
                    // InternalLatteCSS.g:5016:1: (lv_r_3_0= ruleIntegerValue )
                    // InternalLatteCSS.g:5017:3: lv_r_3_0= ruleIntegerValue
                    {
                     
                    	        newCompositeNode(grammarAccess.getRGBColorAccess().getRIntegerValueParserRuleCall_1_2_0()); 
                    	    
                    pushFollow(FOLLOW_33);
                    lv_r_3_0=ruleIntegerValue();

                    state._fsp--;


                    	        if (current==null) {
                    	            current = createModelElementForParent(grammarAccess.getRGBColorRule());
                    	        }
                           		set(
                           			current, 
                           			"r",
                            		lv_r_3_0, 
                            		"io.lattekit.dsl.LatteCSS.IntegerValue");
                    	        afterParserOrEnumRuleCall();
                    	    

                    }


                    }

                    otherlv_4=(Token)match(input,13,FOLLOW_40); 

                        	newLeafNode(otherlv_4, grammarAccess.getRGBColorAccess().getCommaKeyword_1_3());
                        
                    // InternalLatteCSS.g:5037:1: ( (lv_g_5_0= ruleIntegerValue ) )
                    // InternalLatteCSS.g:5038:1: (lv_g_5_0= ruleIntegerValue )
                    {
                    // InternalLatteCSS.g:5038:1: (lv_g_5_0= ruleIntegerValue )
                    // InternalLatteCSS.g:5039:3: lv_g_5_0= ruleIntegerValue
                    {
                     
                    	        newCompositeNode(grammarAccess.getRGBColorAccess().getGIntegerValueParserRuleCall_1_4_0()); 
                    	    
                    pushFollow(FOLLOW_33);
                    lv_g_5_0=ruleIntegerValue();

                    state._fsp--;


                    	        if (current==null) {
                    	            current = createModelElementForParent(grammarAccess.getRGBColorRule());
                    	        }
                           		set(
                           			current, 
                           			"g",
                            		lv_g_5_0, 
                            		"io.lattekit.dsl.LatteCSS.IntegerValue");
                    	        afterParserOrEnumRuleCall();
                    	    

                    }


                    }

                    otherlv_6=(Token)match(input,13,FOLLOW_40); 

                        	newLeafNode(otherlv_6, grammarAccess.getRGBColorAccess().getCommaKeyword_1_5());
                        
                    // InternalLatteCSS.g:5059:1: ( (lv_b_7_0= ruleIntegerValue ) )
                    // InternalLatteCSS.g:5060:1: (lv_b_7_0= ruleIntegerValue )
                    {
                    // InternalLatteCSS.g:5060:1: (lv_b_7_0= ruleIntegerValue )
                    // InternalLatteCSS.g:5061:3: lv_b_7_0= ruleIntegerValue
                    {
                     
                    	        newCompositeNode(grammarAccess.getRGBColorAccess().getBIntegerValueParserRuleCall_1_6_0()); 
                    	    
                    pushFollow(FOLLOW_34);
                    lv_b_7_0=ruleIntegerValue();

                    state._fsp--;


                    	        if (current==null) {
                    	            current = createModelElementForParent(grammarAccess.getRGBColorRule());
                    	        }
                           		set(
                           			current, 
                           			"b",
                            		lv_b_7_0, 
                            		"io.lattekit.dsl.LatteCSS.IntegerValue");
                    	        afterParserOrEnumRuleCall();
                    	    

                    }


                    }

                    otherlv_8=(Token)match(input,143,FOLLOW_2); 

                        	newLeafNode(otherlv_8, grammarAccess.getRGBColorAccess().getRightParenthesisKeyword_1_7());
                        

                    }


                    }
                    break;
                case 3 :
                    // InternalLatteCSS.g:5082:6: (otherlv_9= 'rgba' otherlv_10= '(' ( (lv_r_11_0= ruleIntegerValue ) ) otherlv_12= ',' ( (lv_g_13_0= ruleIntegerValue ) ) otherlv_14= ',' ( (lv_b_15_0= ruleIntegerValue ) ) otherlv_16= ',' ( (lv_alpha_17_0= ruleNumberValue ) ) otherlv_18= ')' )
                    {
                    // InternalLatteCSS.g:5082:6: (otherlv_9= 'rgba' otherlv_10= '(' ( (lv_r_11_0= ruleIntegerValue ) ) otherlv_12= ',' ( (lv_g_13_0= ruleIntegerValue ) ) otherlv_14= ',' ( (lv_b_15_0= ruleIntegerValue ) ) otherlv_16= ',' ( (lv_alpha_17_0= ruleNumberValue ) ) otherlv_18= ')' )
                    // InternalLatteCSS.g:5082:8: otherlv_9= 'rgba' otherlv_10= '(' ( (lv_r_11_0= ruleIntegerValue ) ) otherlv_12= ',' ( (lv_g_13_0= ruleIntegerValue ) ) otherlv_14= ',' ( (lv_b_15_0= ruleIntegerValue ) ) otherlv_16= ',' ( (lv_alpha_17_0= ruleNumberValue ) ) otherlv_18= ')'
                    {
                    otherlv_9=(Token)match(input,299,FOLLOW_32); 

                        	newLeafNode(otherlv_9, grammarAccess.getRGBColorAccess().getRgbaKeyword_2_0());
                        
                    otherlv_10=(Token)match(input,142,FOLLOW_40); 

                        	newLeafNode(otherlv_10, grammarAccess.getRGBColorAccess().getLeftParenthesisKeyword_2_1());
                        
                    // InternalLatteCSS.g:5090:1: ( (lv_r_11_0= ruleIntegerValue ) )
                    // InternalLatteCSS.g:5091:1: (lv_r_11_0= ruleIntegerValue )
                    {
                    // InternalLatteCSS.g:5091:1: (lv_r_11_0= ruleIntegerValue )
                    // InternalLatteCSS.g:5092:3: lv_r_11_0= ruleIntegerValue
                    {
                     
                    	        newCompositeNode(grammarAccess.getRGBColorAccess().getRIntegerValueParserRuleCall_2_2_0()); 
                    	    
                    pushFollow(FOLLOW_33);
                    lv_r_11_0=ruleIntegerValue();

                    state._fsp--;


                    	        if (current==null) {
                    	            current = createModelElementForParent(grammarAccess.getRGBColorRule());
                    	        }
                           		set(
                           			current, 
                           			"r",
                            		lv_r_11_0, 
                            		"io.lattekit.dsl.LatteCSS.IntegerValue");
                    	        afterParserOrEnumRuleCall();
                    	    

                    }


                    }

                    otherlv_12=(Token)match(input,13,FOLLOW_40); 

                        	newLeafNode(otherlv_12, grammarAccess.getRGBColorAccess().getCommaKeyword_2_3());
                        
                    // InternalLatteCSS.g:5112:1: ( (lv_g_13_0= ruleIntegerValue ) )
                    // InternalLatteCSS.g:5113:1: (lv_g_13_0= ruleIntegerValue )
                    {
                    // InternalLatteCSS.g:5113:1: (lv_g_13_0= ruleIntegerValue )
                    // InternalLatteCSS.g:5114:3: lv_g_13_0= ruleIntegerValue
                    {
                     
                    	        newCompositeNode(grammarAccess.getRGBColorAccess().getGIntegerValueParserRuleCall_2_4_0()); 
                    	    
                    pushFollow(FOLLOW_33);
                    lv_g_13_0=ruleIntegerValue();

                    state._fsp--;


                    	        if (current==null) {
                    	            current = createModelElementForParent(grammarAccess.getRGBColorRule());
                    	        }
                           		set(
                           			current, 
                           			"g",
                            		lv_g_13_0, 
                            		"io.lattekit.dsl.LatteCSS.IntegerValue");
                    	        afterParserOrEnumRuleCall();
                    	    

                    }


                    }

                    otherlv_14=(Token)match(input,13,FOLLOW_40); 

                        	newLeafNode(otherlv_14, grammarAccess.getRGBColorAccess().getCommaKeyword_2_5());
                        
                    // InternalLatteCSS.g:5134:1: ( (lv_b_15_0= ruleIntegerValue ) )
                    // InternalLatteCSS.g:5135:1: (lv_b_15_0= ruleIntegerValue )
                    {
                    // InternalLatteCSS.g:5135:1: (lv_b_15_0= ruleIntegerValue )
                    // InternalLatteCSS.g:5136:3: lv_b_15_0= ruleIntegerValue
                    {
                     
                    	        newCompositeNode(grammarAccess.getRGBColorAccess().getBIntegerValueParserRuleCall_2_6_0()); 
                    	    
                    pushFollow(FOLLOW_33);
                    lv_b_15_0=ruleIntegerValue();

                    state._fsp--;


                    	        if (current==null) {
                    	            current = createModelElementForParent(grammarAccess.getRGBColorRule());
                    	        }
                           		set(
                           			current, 
                           			"b",
                            		lv_b_15_0, 
                            		"io.lattekit.dsl.LatteCSS.IntegerValue");
                    	        afterParserOrEnumRuleCall();
                    	    

                    }


                    }

                    otherlv_16=(Token)match(input,13,FOLLOW_15); 

                        	newLeafNode(otherlv_16, grammarAccess.getRGBColorAccess().getCommaKeyword_2_7());
                        
                    // InternalLatteCSS.g:5156:1: ( (lv_alpha_17_0= ruleNumberValue ) )
                    // InternalLatteCSS.g:5157:1: (lv_alpha_17_0= ruleNumberValue )
                    {
                    // InternalLatteCSS.g:5157:1: (lv_alpha_17_0= ruleNumberValue )
                    // InternalLatteCSS.g:5158:3: lv_alpha_17_0= ruleNumberValue
                    {
                     
                    	        newCompositeNode(grammarAccess.getRGBColorAccess().getAlphaNumberValueParserRuleCall_2_8_0()); 
                    	    
                    pushFollow(FOLLOW_34);
                    lv_alpha_17_0=ruleNumberValue();

                    state._fsp--;


                    	        if (current==null) {
                    	            current = createModelElementForParent(grammarAccess.getRGBColorRule());
                    	        }
                           		set(
                           			current, 
                           			"alpha",
                            		lv_alpha_17_0, 
                            		"io.lattekit.dsl.LatteCSS.NumberValue");
                    	        afterParserOrEnumRuleCall();
                    	    

                    }


                    }

                    otherlv_18=(Token)match(input,143,FOLLOW_2); 

                        	newLeafNode(otherlv_18, grammarAccess.getRGBColorAccess().getRightParenthesisKeyword_2_9());
                        

                    }


                    }
                    break;

            }


            }

             leaveRule(); 
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
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