/* Generated By:JavaCC: Do not edit this line. comp.java */
package Comp;
import java.io.*;
class comp implements compConstants {
        static String nombre;
        static String tipo;
        static String atributo;
        static String valor;
        static String posicion;
        static Simbolo s = new Simbolo();
        public static void main( String[] args )throws ParseException, Exception
        {
                try{
                        Ventana ven = new Ventana("Compilador");
                }catch(Exception e){
                        Ventana.t2.setText(e.getMessage());
                }


        }

  static final public void Programa() throws ParseException {
    modifi();
    jj_consume_token(clase);
    jj_consume_token(IDENTIFIER);
    jj_consume_token(Izq);
    label_1:
    while (true) {
      switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
      case PUBLIC:
      case PRIVATE:
        ;
        break;
      default:
        jj_la1[0] = jj_gen;
        break label_1;
      }
      field_declaration();
    }
    label_2:
    while (true) {
      switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
      case If:
        ;
        break;
      default:
        jj_la1[1] = jj_gen;
        break label_2;
      }
      if_statement();
    }
    jj_consume_token(Der);
  }

  static final public void modifi() throws ParseException {
    switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
    case PUBLIC:
      jj_consume_token(PUBLIC);
      break;
    case PRIVATE:
      jj_consume_token(PRIVATE);
      break;
    default:
      jj_la1[2] = jj_gen;
      jj_consume_token(-1);
      throw new ParseException();
    }
  }

  static final public void field_declaration() throws ParseException {
    variable_declaration();
  }

  static final public void variable_declaration() throws ParseException {
    modifi();
          atributo=token.image;
    type();
          tipo=token.image;
    variable_declarator();
        String g=s.getPosicion();
        Simbolo n  = new Simbolo(nombre,tipo,atributo,valor,g);
          Ventana.tabla.put(nombre,n);
  }

  static final public void type() throws ParseException {
    type_specifier();
  }

  static final public void variable_declarator() throws ParseException {
    identi();
          nombre=token.image;
        s=Ventana.buscar(nombre);
        System.out.println(s.getNombre());
    switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
    case SEMICOLON:
      jj_consume_token(SEMICOLON);
      break;
    case Asignacion:
      jj_consume_token(Asignacion);
      switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
      case Int:
        jj_consume_token(Int);
        break;
      case True:
        jj_consume_token(True);
        break;
      case False:
        jj_consume_token(False);
        break;
      default:
        jj_la1[3] = jj_gen;
        jj_consume_token(-1);
        throw new ParseException();
      }
          valor=token.image;
      jj_consume_token(SEMICOLON);
      break;
    default:
      jj_la1[4] = jj_gen;
      jj_consume_token(-1);
      throw new ParseException();
    }
  }

  static final public void expression() throws ParseException {
    testing_expression();
  }

  static final public void testing_expression() throws ParseException {
    or();
    switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
    case Mayor:
      jj_consume_token(Mayor);
      break;
    case Menor:
      jj_consume_token(Menor);
      break;
    case MenorIgual:
      jj_consume_token(MenorIgual);
      break;
    case MayorIgual:
      jj_consume_token(MayorIgual);
      break;
    case Comparacion:
      jj_consume_token(Comparacion);
      break;
    case Diferente:
      jj_consume_token(Diferente);
      break;
    default:
      jj_la1[5] = jj_gen;
      jj_consume_token(-1);
      throw new ParseException();
    }
    or();
  }

  static final public void or() throws ParseException {
    switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
    case Int:
      jj_consume_token(Int);
      break;
    case IDENTIFIER:
      identi();
      break;
    default:
      jj_la1[6] = jj_gen;
      jj_consume_token(-1);
      throw new ParseException();
    }
  }

  static final public void type_specifier() throws ParseException {
    switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
    case Boolean:
      jj_consume_token(Boolean);
      break;
    case integer:
      jj_consume_token(integer);
      break;
    default:
      jj_la1[7] = jj_gen;
      jj_consume_token(-1);
      throw new ParseException();
    }
  }

  static final public void if_statement() throws ParseException {
    jj_consume_token(If);
    jj_consume_token(ParAP);
    expression();
    jj_consume_token(ParCi);
    statement();
  }

  static final public void statement() throws ParseException {
    statement_block();
  }

  static final public void statement_block() throws ParseException {
    jj_consume_token(Izq);
    label_3:
    while (true) {
      switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
      case IDENTIFIER:
        ;
        break;
      default:
        jj_la1[8] = jj_gen;
        break label_3;
      }
      aritmetica_expression();
    }
    jj_consume_token(Der);
  }

  static final public void aritmetica_expression() throws ParseException {
    identi();
    jj_consume_token(Asignacion);
    opint();
    jj_consume_token(SEMICOLON);
  }

  static final public void identi() throws ParseException {
    jj_consume_token(IDENTIFIER);
  }

  static final public void opint() throws ParseException {
    switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
    case Int:
      jj_consume_token(Int);
      break;
    case IDENTIFIER:
      identi();
      break;
    default:
      jj_la1[9] = jj_gen;
      jj_consume_token(-1);
      throw new ParseException();
    }
    switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
    case Mas:
      jj_consume_token(Mas);
      break;
    case Menos:
      jj_consume_token(Menos);
      break;
    default:
      jj_la1[10] = jj_gen;
      jj_consume_token(-1);
      throw new ParseException();
    }
    switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
    case Int:
      jj_consume_token(Int);
      break;
    case IDENTIFIER:
      identi();
      break;
    default:
      jj_la1[11] = jj_gen;
      jj_consume_token(-1);
      throw new ParseException();
    }
  }

  static final public void asignation() throws ParseException {
    identi();
    jj_consume_token(Asignacion);
    switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
    case Int:
      jj_consume_token(Int);
      break;
    case True:
      jj_consume_token(True);
      break;
    case False:
      jj_consume_token(False);
      break;
    default:
      jj_la1[12] = jj_gen;
      jj_consume_token(-1);
      throw new ParseException();
    }
    jj_consume_token(SEMICOLON);
  }

  static private boolean jj_initialized_once = false;
  /** Generated Token Manager. */
  static public compTokenManager token_source;
  static SimpleCharStream jj_input_stream;
  /** Current token. */
  static public Token token;
  /** Next token. */
  static public Token jj_nt;
  static private int jj_ntk;
  static private int jj_gen;
  static final private int[] jj_la1 = new int[13];
  static private int[] jj_la1_0;
  static {
      jj_la1_init_0();
   }
   private static void jj_la1_init_0() {
      jj_la1_0 = new int[] {0x28000,0x200000,0x28000,0x8c0000,0x4080,0x7e,0x1800000,0x500000,0x1000000,0x1800000,0x300,0x1800000,0x8c0000,};
   }

  /** Constructor with InputStream. */
  public comp(java.io.InputStream stream) {
     this(stream, null);
  }
  /** Constructor with InputStream and supplied encoding */
  public comp(java.io.InputStream stream, String encoding) {
    if (jj_initialized_once) {
      System.out.println("ERROR: Second call to constructor of static parser.  ");
      System.out.println("       You must either use ReInit() or set the JavaCC option STATIC to false");
      System.out.println("       during parser generation.");
      throw new Error();
    }
    jj_initialized_once = true;
    try { jj_input_stream = new SimpleCharStream(stream, encoding, 1, 1); } catch(java.io.UnsupportedEncodingException e) { throw new RuntimeException(e); }
    token_source = new compTokenManager(jj_input_stream);
    token = new Token();
    jj_ntk = -1;
    jj_gen = 0;
    for (int i = 0; i < 13; i++) jj_la1[i] = -1;
  }

  /** Reinitialise. */
  static public void ReInit(java.io.InputStream stream) {
     ReInit(stream, null);
  }
  /** Reinitialise. */
  static public void ReInit(java.io.InputStream stream, String encoding) {
    try { jj_input_stream.ReInit(stream, encoding, 1, 1); } catch(java.io.UnsupportedEncodingException e) { throw new RuntimeException(e); }
    token_source.ReInit(jj_input_stream);
    token = new Token();
    jj_ntk = -1;
    jj_gen = 0;
    for (int i = 0; i < 13; i++) jj_la1[i] = -1;
  }

  /** Constructor. */
  public comp(java.io.Reader stream) {
    if (jj_initialized_once) {
      System.out.println("ERROR: Second call to constructor of static parser. ");
      System.out.println("       You must either use ReInit() or set the JavaCC option STATIC to false");
      System.out.println("       during parser generation.");
      throw new Error();
    }
    jj_initialized_once = true;
    jj_input_stream = new SimpleCharStream(stream, 1, 1);
    token_source = new compTokenManager(jj_input_stream);
    token = new Token();
    jj_ntk = -1;
    jj_gen = 0;
    for (int i = 0; i < 13; i++) jj_la1[i] = -1;
  }

  /** Reinitialise. */
  static public void ReInit(java.io.Reader stream) {
    jj_input_stream.ReInit(stream, 1, 1);
    token_source.ReInit(jj_input_stream);
    token = new Token();
    jj_ntk = -1;
    jj_gen = 0;
    for (int i = 0; i < 13; i++) jj_la1[i] = -1;
  }

  /** Constructor with generated Token Manager. */
  public comp(compTokenManager tm) {
    if (jj_initialized_once) {
      System.out.println("ERROR: Second call to constructor of static parser. ");
      System.out.println("       You must either use ReInit() or set the JavaCC option STATIC to false");
      System.out.println("       during parser generation.");
      throw new Error();
    }
    jj_initialized_once = true;
    token_source = tm;
    token = new Token();
    jj_ntk = -1;
    jj_gen = 0;
    for (int i = 0; i < 13; i++) jj_la1[i] = -1;
  }

  /** Reinitialise. */
  public void ReInit(compTokenManager tm) {
    token_source = tm;
    token = new Token();
    jj_ntk = -1;
    jj_gen = 0;
    for (int i = 0; i < 13; i++) jj_la1[i] = -1;
  }

  static private Token jj_consume_token(int kind) throws ParseException {
    Token oldToken;
    if ((oldToken = token).next != null) token = token.next;
    else token = token.next = token_source.getNextToken();
    jj_ntk = -1;
    if (token.kind == kind) {
      jj_gen++;
      return token;
    }
    token = oldToken;
    jj_kind = kind;
    throw generateParseException();
  }


/** Get the next Token. */
  static final public Token getNextToken() {
    if (token.next != null) token = token.next;
    else token = token.next = token_source.getNextToken();
    jj_ntk = -1;
    jj_gen++;
    return token;
  }

/** Get the specific Token. */
  static final public Token getToken(int index) {
    Token t = token;
    for (int i = 0; i < index; i++) {
      if (t.next != null) t = t.next;
      else t = t.next = token_source.getNextToken();
    }
    return t;
  }

  static private int jj_ntk() {
    if ((jj_nt=token.next) == null)
      return (jj_ntk = (token.next=token_source.getNextToken()).kind);
    else
      return (jj_ntk = jj_nt.kind);
  }

  static private java.util.List<int[]> jj_expentries = new java.util.ArrayList<int[]>();
  static private int[] jj_expentry;
  static private int jj_kind = -1;

  /** Generate ParseException. */
  static public ParseException generateParseException() {
    jj_expentries.clear();
    boolean[] la1tokens = new boolean[30];
    if (jj_kind >= 0) {
      la1tokens[jj_kind] = true;
      jj_kind = -1;
    }
    for (int i = 0; i < 13; i++) {
      if (jj_la1[i] == jj_gen) {
        for (int j = 0; j < 32; j++) {
          if ((jj_la1_0[i] & (1<<j)) != 0) {
            la1tokens[j] = true;
          }
        }
      }
    }
    for (int i = 0; i < 30; i++) {
      if (la1tokens[i]) {
        jj_expentry = new int[1];
        jj_expentry[0] = i;
        jj_expentries.add(jj_expentry);
      }
    }
    int[][] exptokseq = new int[jj_expentries.size()][];
    for (int i = 0; i < jj_expentries.size(); i++) {
      exptokseq[i] = jj_expentries.get(i);
    }
    return new ParseException(token, exptokseq, tokenImage);
  }

  /** Enable tracing. */
  static final public void enable_tracing() {
  }

  /** Disable tracing. */
  static final public void disable_tracing() {
  }

}
